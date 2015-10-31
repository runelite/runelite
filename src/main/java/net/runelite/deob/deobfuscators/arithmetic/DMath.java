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
}
