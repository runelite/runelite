/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.execution;

public class Type
{
	public String type;
	
	public Type(String type)
	{
		if (type.startsWith("["))
			throw new IllegalStateException();
		this.type = type;
	}
	
	public Type(net.runelite.asm.signature.Type t)
	{
		type = asmTypeToClass(t.getType());
		for (int i = 0; i < t.getArrayDims(); ++i)
			type = type + "[]";
	}

	private Type toStackType()
	{
		if (type.equals(byte.class.getCanonicalName()) || type.equals(char.class.getCanonicalName()) || type.equals(short.class.getCanonicalName())
				|| type.equals(boolean.class.getCanonicalName()))
			return new Type(int.class.getCanonicalName());
		return this;
	}
	
	public boolean isInt()
	{
		return toStackType().equals(new Type(int.class.getName()));
	}
	
	public boolean isBoolean()
	{
		return type.equals("boolean");
	}
	
	private static String asmTypeToClass(String type)
	{
		switch (type)
		{
			case "B":
				return byte.class.getCanonicalName();
			case "C":
				return char.class.getCanonicalName();
			case "I":
				return int.class.getCanonicalName();
			case "S":
				return short.class.getCanonicalName();
			case "Z":
				return boolean.class.getCanonicalName();
			case "D":
				return double.class.getCanonicalName();
			case "F":
				return float.class.getCanonicalName();
			case "J":
				return long.class.getCanonicalName();
			default:
				return type.replace("/", ".");
		}
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Type))
			return false;
		
		Type t = (Type) other;
		return type.equals(t.type);
	}
	
	public Type getSubtype()
	{
		if (!type.endsWith("[]"))
			throw new IllegalStateException(type + " is not an array type");
		
		return new Type(type.substring(0, type.length() - 2));
	}
}
