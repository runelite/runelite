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
package net.runelite.asm;

import net.runelite.asm.pool.Class;

/**
 * Created by Kyle Fricilone on 8/20/2017
 */
public class Type
{

	public static final Type VOID = new Type("V");
	public static final Type BOOLEAN = new Type("Z");
	public static final Type CHAR = new Type("C");
	public static final Type BYTE = new Type("B");
	public static final Type SHORT = new Type("S");
	public static final Type INT = new Type("I");
	public static final Type FLOAT = new Type("F");
	public static final Type LONG = new Type("J");
	public static final Type DOUBLE = new Type("D");
	public static final Type OBJECT = new Type("Ljava/lang/Object;");
	public static final Type STRING = new Type("Ljava/lang/String;");
	public static final Type THROWABLE = new Type("Ljava/lang/Throwable;");
	public static final Type EXCEPTION = new Type("Ljava/lang/Exception;");

	private final String type;

	public Type(String type)
	{
		this.type = type;
	}

	public boolean isPrimitive()
	{
		return this.equals(BOOLEAN) || this.equals(BYTE) || this.equals(SHORT) || this.equals(CHAR) || this.equals(INT)
			|| this.equals(VOID) || this.equals(LONG) || this.equals(FLOAT) || this.equals(DOUBLE);
	}

	public boolean isObject()
	{
		return this.equals(OBJECT);
	}

	public boolean isArray()
	{
		return getDimensions() > 0;
	}

	public boolean isStackInt()
	{
		return this.equals(BOOLEAN) || this.equals(BYTE) || this.equals(SHORT) || this.equals(CHAR) || this.equals(INT);
	}

	public int getSize()
	{
		if (this.equals(LONG) || this.equals(DOUBLE))
		{
			return 2;
		}

		if (this.equals(VOID))
		{
			return 0;
		}

		return 1;
	}

	public int getDimensions()
	{
		return getDimensions(type);
	}

	public Type getSubtype()
	{
		if (!type.startsWith("["))
		{
			throw new IllegalStateException(type + " is not an array");
		}
		return new Type(type.substring(1));
	}

	public String getInternalName()
	{
		String s = type;
		while (s.startsWith("["))
		{
			s = s.substring(1);
		}
		if (s.startsWith("L"))
		{
			return s.substring(1, s.length() - 1);
		}
		else
		{
			return s;
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Type))
		{
			return false;
		}

		Type other = (Type) o;
		return type.equals(other.type);
	}

	@Override
	public int hashCode()
	{
		return type.hashCode();
	}

	@Override
	public String toString()
	{
		return type;
	}

	public String toAsmString()
	{
		if (type.startsWith("L") && type.endsWith(";"))
		{
			return type.substring(1, type.length() - 1);
		}
		else
		{
			return type;
		}
	}

	public static Type fromAsmString(String str)
	{
		if (str.startsWith("["))
		{
			// array type
			return new Type(str);
		}
		else
		{
			// object type
			return new Type("L" + str + ";");
		}
	}

	private static int getDimensions(String type)
	{
		if (!type.startsWith("["))
		{
			return 0;
		}

		return (int) type.chars().filter(i -> i == '[').count();
	}

	public static Type getType(String type, int dims)
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < dims; i++)
		{
			builder.append('[');
		}
		return new Type(builder.append(type).toString());
	}

	public static Type getType(Object object)
	{
		Type type;

		if (object instanceof Double)
		{
			type = DOUBLE;
		}
		else if (object instanceof Float)
		{
			type = FLOAT;
		}
		else if (object instanceof Integer)
		{
			type = INT;
		}
		else if (object instanceof Long)
		{
			type = LONG;
		}
		else if (object instanceof String)
		{
			type = STRING;
		}
		else if (object instanceof Class)
		{
			type = new Type("L" + ((Class) object).getName() + ";");
		}
		else
		{
			throw new IllegalArgumentException("Unexpected object type: " + object.getClass());
		}

		return type;
	}
}
