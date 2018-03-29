/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.util;

import com.google.inject.Inject;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.DeobfuscatedName;
import net.runelite.api.ExceptionWithScriptStack;
import net.runelite.api.Script;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptStackFrame;
import net.runelite.client.RuneLite;
import net.runelite.client.util.throwable.EnhancedStackTraceElement;
import net.runelite.client.util.throwable.JVMUnsupportedException;
import net.runelite.client.util.throwable.ThrowableUtil;

@Singleton
@Slf4j
public class TraceFormatter
{
	private final Client client;

	private final ThrowableUtil throwableUtil;

	@Inject
	TraceFormatter(Client client)
	{
		this.client = client;

		ThrowableUtil tu = null;
		if (RuneLite.getOptions().has("developer-mode"))
		{
			try
			{
				tu = ThrowableUtil.getInstance();
				client.setScriptEventTracingEnabled(true);
			}
			catch (JVMUnsupportedException e)
			{
				log.info("Failed to get ThrowableUtil", e);
			}
		}
		this.throwableUtil = tu;
	}

	public String formatStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		printStackTrace(t, pw);
		return sw.toString().trim();
	}

	public void printStackTrace(Throwable t, PrintWriter w)
	{
		boolean fallback = throwableUtil == null;

		ExceptionWithScriptStack scriptException = null;
		if (t instanceof ExceptionWithScriptStack)
		{
			scriptException = (ExceptionWithScriptStack) t;
			if (scriptException.getScriptStack() == null)
			{
				scriptException = null;
			}
		}
		//XXX should probably remove common frames

		if (!fallback)
		{
			try
			{
				EnhancedStackTraceElement[] trace = throwableUtil.getEnhancedStackTrace(t);
				w.println(t);
				for (EnhancedStackTraceElement e : trace)
				{
					Method m = e.getMethod();
					DeobfuscatedName deobName = null;
					if (m != null)
					{
						deobName = m.getAnnotation(DeobfuscatedName.class);
					}

					String className = deobName == null ? e.getDeclaringClass().getName() : deobName.className();
					String methodName = deobName == null ? e.getMethodName() : deobName.methodName();

					w.print("\tat ");

					w.print(className);
					w.print(".");
					w.print(methodName);

					String fileName = e.getFileName();
					int lineNo = e.getLineNumber();
					if (deobName != null)
					{
						fileName = deobName.fileName();
						if (lineNo < 0)
						{
							lineNo = deobName.lineNo();
						}
					}
					if (fileName != null)
					{
						w.print("(");
						w.print(fileName);
						if (lineNo > 0)
						{
							w.print(":");
							w.print(lineNo);
						}
						w.print(")");
					}
					w.format("@%X\n", e.getBytecodeIndex());

					if (scriptException != null && "copy$runScript".equals(methodName) && "client".equals(className))
					{
						ScriptStackFrame[] scriptTrace = scriptException.getScriptStack();
						for (ScriptStackFrame f : scriptTrace)
						{
							Script script = f.getScript();
							int pc = f.getPc();

							w.print("\tat script ");
							w.print(script.getHash());
							w.print("+");
							w.print(pc);

							int[] instrs = script.getInstructions();
							if (instrs.length > pc)
							{
								w.print("(");
								w.print(instrs[pc]);
								w.print(")");
							}

							w.println();
						}

						ScriptEvent event = scriptException.getSourceEvent();

						w.print("from event with arguments: ");
						w.println(Arrays.toString(event.getArguments()));

						if (event.getWidget() != null)
						{
							w.print("from widget: ");
							w.println(event.getWidget());
						}

						Throwable eventTrace = event.getTrace();
						if (eventTrace != null)
						{
							w.print("created at: ");
							printStackTrace(eventTrace, w);
						}
						break;
					}
				}
				if (t.getCause() != null)
				{
					w.print("caused by: ");
					printStackTrace(t.getCause(), w);
				}
			}
			catch (JVMUnsupportedException e)
			{
				fallback = true;
				log.info("Unable to get enhanced trace", e);
			}
		}
		if (fallback)
		{
			t.printStackTrace(w);
		}
	}

	public void printStackTrace(Throwable t)
	{
		if (t instanceof OutOfMemoryError)
		{
			t.printStackTrace();
			return;
		}
		log.warn("{}", formatStackTrace(t));
	}

	public void printStackTrace()
	{
		printStackTrace(new ExceptionWithScriptStack(client));
	}
}
