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

package net.runelite.asm.execution;

import java.lang.reflect.Array;
import java.util.Arrays;
import net.runelite.deob.util.PrimitiveUtils;

public class Value
{
	public static final Value NULL = new Value(null);
	public static final Value UNKNOWN = new Value(null);
	
	private Object value;

	public Value(Object value)
	{
		assert !(value instanceof Value);
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "Value{" + "value=" + value + '}';
	}
	
	public boolean isUnknownOrNull()
	{
		return this == UNKNOWN || this == NULL;
	}

	public Object getValue()
	{
		return value;
	}
	
	private boolean isArray()
	{
		return !isUnknownOrNull() && value.getClass().isArray();
	}
	
	public Value arrayLength()
	{
		return isArray() ? new Value(Array.getLength(value)) : UNKNOWN;
	}
	
	public Value arrayGet(Value index)
	{
		if (isUnknownOrNull() || index.isUnknownOrNull())
			return UNKNOWN;
		
		int i = (int) index.value;
		
		if (i < 0)
			return UNKNOWN;
		
		assert isArray();
		
		int len = Array.getLength(value);
		if (len <= i)
			return UNKNOWN;
		
		Value o = (Value) Array.get(value, i);
		if (o.isUnknownOrNull())
			return UNKNOWN;
		
		return o;
	}
	
	public void arraySet(Value index, Value object)
	{
		if (isUnknownOrNull() || index.isUnknownOrNull())
			return;
		
		int i = (int) index.value;
		
		if (i < 0)
			return;

		assert isArray();
		
		int len = Array.getLength(value);
		if (len <= i)
		{
			value = Arrays.copyOf((Value[]) value, i + 1, Value[].class);
			Arrays.fill((Value[]) value, len, i, UNKNOWN);
		}
		
		Array.set(value, i, object);
	}
	
	public Value cast(Class<?> c)
	{
		if (isUnknownOrNull())
			return UNKNOWN;
		
		Object v = value;
		
		if (value instanceof Number && Number.class.isAssignableFrom(PrimitiveUtils.unbox(c)))
			v = PrimitiveUtils.convert((Number) value, c);
		
		return new Value(PrimitiveUtils.unbox(c).cast(v));
	}
	
	public Object as(Class<?> c)
	{
		return PrimitiveUtils.convert((Number) value, c);
	}
	
	public static Value newArray(Value length)
	{
		if (length.isUnknownOrNull())
		{
			return new Value(new Value[0]);
		}
		else
		{
			int len = (int) length.getValue();

			// the generated garbage code can create negative sized arrays
			if (len < 0 || len > 0xFFFF)
				len = 0;

			Value[] array = new Value[len];
			Arrays.fill(array, UNKNOWN);
			return new Value(array);
		}
	}
	
	public static Value newArray(Value[] lenghts)
	{
		Value mainArray = new Value(new Value[lenghts.length]);
		
		int i = 0;
		for (Value l : lenghts)
			mainArray.arraySet(new Value(i++), newArray(l));
		
		return mainArray;
	}
}
