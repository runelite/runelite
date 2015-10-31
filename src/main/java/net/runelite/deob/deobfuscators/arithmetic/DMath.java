package net.runelite.deob.deobfuscators.arithmetic;

import java.math.BigInteger;

public class DMath
{
	public static BigInteger modInverse(BigInteger val, int bits)
	{
		BigInteger shift = BigInteger.ONE.shiftLeft(bits);
		return val.modInverse(shift);
	}
	
	public static int modInverse(int val)
	{
		return modInverse(BigInteger.valueOf(val), 32).intValue();
	}
	
	public static long modInverse(long val)
	{
		return modInverse(BigInteger.valueOf(val), 64).longValue();
	}
	
	public static Number modInverse(Number value)
	{
		if (value instanceof Integer)
			return modInverse((int) value);
		else if (value instanceof Long)
			return modInverse((long) value);
		else
			throw new IllegalArgumentException();	
	}
	
	public static boolean isInversable(int val)
	{
		try
		{
			modInverse(val);
			return true;
		}
		catch (ArithmeticException ex)
		{
			return false;
		}
	}
	
	private static boolean isInversable(long val)
	{
		try
		{
			modInverse(val);
			return true;
		}
		catch (ArithmeticException ex)
		{
			return false;
		}
	}
	
	public static boolean isInversable(Number value)
	{
		if (value instanceof Integer)
			return isInversable((int) value);
		else if (value instanceof Long)
			return isInversable((long) value);
		else
			throw new IllegalArgumentException();	
	}
	
	public static boolean isBig(int val)
	{
		if ((val & 0x80000000) != 0)
			val = ~val + 1;
		
		return (val & 0x7FF00000) != 0;
	}
	
	private static boolean isBig(long val)
	{
		if ((val & 0x8000000000000000L) != 0L)
			val = ~val + 1L;
		
		return (val & 0x7FF0000000000000L) != 0L;
	}
	
	public static boolean isBig(Number value)
	{
		if (value instanceof Integer)
			return isBig((int) value);
		else if (value instanceof Long)
			return isBig((long) value);
		else
			throw new IllegalArgumentException();
	}
	
	public static Number multiply(Number one, Number two)
	{
		assert one.getClass() == two.getClass();
		
		if (one instanceof Integer)
			return (int) one * (int) two;
		else if (one instanceof Long)
			return (long) one * (long) two;
		else
			throw new IllegalArgumentException();	
	}
	
	public static boolean equals(Number one, int two)
	{
		if (one instanceof Long)
			return equals(one, ((long) two) & 0xffffffff);
		return one.intValue() == two;
	}
	
	public static boolean equals(Number one, long two)
	{
		if (one instanceof Integer)
			return equals(one, (int) one);
		return one.longValue() == two;
	}
}
