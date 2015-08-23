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
}
