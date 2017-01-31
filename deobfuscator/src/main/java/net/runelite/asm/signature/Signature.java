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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signature
{
	private static Pattern paramRetPattern = Pattern.compile("\\((.*)\\)(.*)"),
			paramsPattern = Pattern.compile("(\\[*(?:B|C|Z|S|I|J|F|D|(?:L[^;]*;)))");
	
	private List<Type> arguments = new ArrayList<>();
	private Type rv;
	
	public Signature()
	{
	}
	
	public Signature(String str)
	{
		Matcher m = paramRetPattern.matcher(str);
		if (!m.find())
			throw new IllegalArgumentException("Signature has no arguments");
		
		String args = m.group(1), ret = m.group(2);
		
		m = paramsPattern.matcher(args);
		while (m.find())
		{
			String arg = m.group(1);
			arguments.add(new Type(arg));
		}
		
		rv = new Type(ret);
	}
	
	public Signature(Signature other)
	{
		rv = new Type(other.rv);
		for (Type t : other.arguments)
			arguments.add(new Type(t));
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Signature))
			return false;
		
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
			sb.append(a.getFullType());
		sb.append(')');
		sb.append(rv.getFullType());
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
	
	public void setTypeOfArg(int i, Type type)
	{
		arguments.set(i, type);
	}
	
	public void addArg(Type type)
	{
		arguments.add(type);
	}
	
	public void insertArg(int idx, Type type)
	{
		arguments.add(idx, type);
	}
	
	public Type getReturnValue()
	{
		return rv;
	}
	
	public void setTypeOfReturnValue(Type type)
	{
		rv = type;
	}
	
	public List<Type> getArguments()
	{
		return arguments;
	}


	public boolean isVoid()
	{
		return rv.getFullType().equals("V");
	}
}
