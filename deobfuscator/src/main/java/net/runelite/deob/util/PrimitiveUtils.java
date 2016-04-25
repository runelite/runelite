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
