/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.asm.signature;

import net.runelite.asm.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signature
{
	private static Pattern paramRetPattern = Pattern.compile("\\((.*)\\)(.*)"),
		paramsPattern = Pattern.compile("(\\[*(?:B|C|Z|S|I|J|F|D|(?:L[^;]*;)))");

	private final List<Type> arguments;
	private final Type rv;

	private Signature(List<Type> arguments, Type rv)
	{
		this.arguments = new ArrayList<>(arguments);
		this.rv = rv;
	}

	public Signature(String str)
	{
		Matcher m = paramRetPattern.matcher(str);
		if (!m.find())
		{
			throw new IllegalArgumentException("Signature has no arguments");
		}

		String args = m.group(1), ret = m.group(2);

		m = paramsPattern.matcher(args);
		arguments = new ArrayList<>();
		while (m.find())
		{
			String arg = m.group(1);
			arguments.add(new Type(arg));
		}

		rv = new Type(ret);
	}

	public Signature(Signature other)
	{
		arguments = new ArrayList<>(other.arguments);
		rv = other.rv;
	}

	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Signature))
		{
			return false;
		}

		Signature a = (Signature) other;
		return arguments.equals(a.arguments) && rv.equals(a.rv);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 97 * hash + Objects.hashCode(this.arguments);
		hash = 97 * hash + Objects.hashCode(this.rv);
		return hash;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		for (Type a : arguments)
		{
			sb.append(a);
		}
		sb.append(')');
		sb.append(rv);
		return sb.toString();
	}

	public int size()
	{
		return arguments.size();
	}

	public void remove(int i)
	{
		arguments.remove(i);
	}

	public Type getTypeOfArg(int i)
	{
		return arguments.get(i);
	}

	public Type getReturnValue()
	{
		return rv;
	}

	public List<Type> getArguments()
	{
		return Collections.unmodifiableList(arguments);
	}

	public boolean isVoid()
	{
		return rv.equals(Type.VOID);
	}

	public static class Builder
	{
		private final List<Type> arguments = new ArrayList<>();
		private Type rv;

		public Builder setReturnType(Type type)
		{
			rv = type;
			return this;
		}

		public Builder addArgument(Type type)
		{
			arguments.add(type);
			return this;
		}

		public Builder addArgument(int idx, Type type)
		{
			arguments.add(idx, type);
			return this;
		}

		public Builder addArguments(Collection<Type> types)
		{
			arguments.addAll(types);
			return this;
		}

		public Signature build()
		{
			return new Signature(arguments, rv);
		}
	}
}
