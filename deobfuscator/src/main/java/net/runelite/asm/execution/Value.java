package net.runelite.asm.execution;

import java.lang.reflect.Array;
import java.util.Arrays;
import net.runelite.deob.util.PrimitiveUtils;

public class Value
{
	public static final Value NULL = new Value(null);
	
	private Object value;

	public Value(Object value)
	{
		assert !(value instanceof Value);
		this.value = value;
	}
	
	public boolean isNull()
	{
		assert (value == null) == (this == NULL);
		return this == NULL;
	}

	public Object getValue()
	{
		return value;
	}
	
	private boolean isArray()
	{
		return !isNull() && value.getClass().isArray();
	}
	
	public Value arrayLength()
	{
		return isArray() ? new Value(Array.getLength(value)) : NULL;
	}
	
	public Value arrayGet(Value index)
	{
		if (isNull() || index.isNull())
			return NULL;
		
		int i = (int) index.value;
		
		if (i < 0)
			return NULL;
		
		assert isArray();
		
		int len = Array.getLength(value);
		if (len <= i)
			return NULL;
		
		Value o = (Value) Array.get(value, i);
		if (o.isNull())
			return NULL;
		
		return o;
	}
	
	public void arraySet(Value index, Value object)
	{
		if (isNull() || index.isNull())
			return;
		
		int i = (int) index.value;
		
		if (i < 0)
			return;

		assert isArray();
		
		int len = Array.getLength(value);
		if (len <= i)
		{
			value = Arrays.copyOf((Value[]) value, i + 1, Value[].class);
			Arrays.fill((Value[]) value, len, i, NULL);
		}
		
		Array.set(value, i, object);
	}
	
	public Value cast(Class<?> c)
	{
		if (isNull())
			return NULL;
		
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
		if (length.isNull())
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
			Arrays.fill(array, NULL);
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
