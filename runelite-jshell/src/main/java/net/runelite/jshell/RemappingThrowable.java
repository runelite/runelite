/*
 * Copyright (c) 2021 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.jshell;

import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import jdk.jshell.EvalException;

class RemappingThrowable extends Throwable
{
	private final String source;
	private final Map<String, Integer> offsets;
	private final Throwable wrapped;
	private final Map<Throwable, Throwable> dejaVu;

	public RemappingThrowable(String source, Map<String, Integer> offsets, Throwable other)
	{
		this(source, offsets, other, new HashMap<>());
	}

	private RemappingThrowable(String source, Map<String, Integer> offsets, Throwable other, Map<Throwable, Throwable> dejaVu)
	{
		super();

		this.source = source;
		this.offsets = offsets;
		this.wrapped = other;
		this.dejaVu = dejaVu;

		dejaVu.put(wrapped, this);

		setStackTrace(Stream.of(wrapped.getStackTrace())
			.map(e ->
			{
				Integer boxOffset = offsets.get(e.getFileName());
				if (boxOffset == null)
				{
					return e;
				}

				int offset = boxOffset;
				int line = e.getLineNumber();
				for (int i = 0; i <= offset && i < source.length(); i++)
				{
					if (source.charAt(i) == '\n')
					{
						line++;
					}
				}
				return new StackTraceElement(
					Strings.isNullOrEmpty(e.getClassName()) ? "Shell" : e.getClassName(),
					Strings.isNullOrEmpty(e.getMethodName()) ? "global" : e.getMethodName(),
					"",
					line);
			})
			.toArray(StackTraceElement[]::new));

		if (wrapped.getCause() != null)
		{
			initCause(remap(wrapped.getCause()));
		}

		for (Throwable suppressed : wrapped.getSuppressed())
		{
			addSuppressed(remap(suppressed));
		}
	}

	private Throwable remap(Throwable other)
	{
		Throwable remap = dejaVu.get(other);
		if (remap == null)
		{
			remap = new RemappingThrowable(source, offsets, other, dejaVu);
			// ctor inserts into the map
		}
		return remap;
	}

	@Override
	public String getMessage()
	{
		return wrapped.getMessage();
	}

	@Override
	public String getLocalizedMessage()
	{
		return wrapped.getLocalizedMessage();
	}

	@Override
	public synchronized Throwable fillInStackTrace()
	{
		return this;
	}

	@Override
	public String toString()
	{
		String className;
		if (wrapped instanceof EvalException)
		{
			className = ((EvalException) wrapped).getExceptionClassName();
		}
		else
		{
			className = wrapped.getClass().getName();
		}

		String message = wrapped.getLocalizedMessage();
		if (message == null)
		{
			return className;
		}
		return className + ": " + message;
	}
}
