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

package net.runelite.deob.util;

public class PrimitiveUtils
{
	public static Class<?> unbox(Class<?> c)
	{
		if (c == int.class)
			return Integer.class;
		else if (c == long.class)
			return Long.class;
		else if (c == byte.class)
			return Byte.class;
		else if (c == char.class)
			return Character.class;
		else if (c == short.class)
			return Short.class;
		else if (c == boolean.class)
			return Boolean.class;
		else if (c == float.class)
			return Float.class;
		else if (c == double.class)
			return Double.class;
		else if (c == void.class)
			return Void.class;
		else
			return c;
	}
	
	public static Object convert(Number n, Class<?> c)
	{
		c = unbox(c);
		
		if (c == Integer.class)
			return n.intValue();
		else if (c == Long.class)
			return n.longValue();
		else if (c == Byte.class)
			return n.byteValue();
		else if (c == Short.class)
			return n.shortValue();
		else if (c == Float.class)
			return n.floatValue();
		else if (c == Double.class)
			return n.doubleValue();
		
		throw new IllegalArgumentException();
	}
}
