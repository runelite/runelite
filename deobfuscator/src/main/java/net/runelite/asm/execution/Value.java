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
