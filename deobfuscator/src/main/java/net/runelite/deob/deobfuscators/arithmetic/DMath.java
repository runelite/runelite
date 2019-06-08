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
package net.runelite.deob.deobfuscators.arithmetic;

import java.math.BigInteger;

public class DMath
{
	public static BigInteger modInverse(BigInteger val, int bits)
	{
		try
		{
			BigInteger shift = BigInteger.ONE.shiftLeft(bits);
			return val.modInverse(shift);
		}
		catch (ArithmeticException e)
		{
			return val;
		}
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
		{
			return modInverse((int) value);
		}
		else if (value instanceof Long)
		{
			return modInverse((long) value);
		}
		else
		{
			throw new IllegalArgumentException();
		}
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
		{
			return isInversable((int) value);
		}
		else if (value instanceof Long)
		{
			return isInversable((long) value);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	public static Number multiply(Number one, Number two)
	{
		assert one.getClass() == two.getClass();

		if (one instanceof Integer)
		{
			return (int) one * (int) two;
		}
		else if (one instanceof Long)
		{
			return (long) one * (long) two;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	public static boolean equals(Number one, int two)
	{
		if (one instanceof Long)
		{
			return equals(one, ((long) two) & 0xffffffff);
		}
		return one.intValue() == two;
	}

	public static boolean equals(Number one, long two)
	{
		if (one instanceof Integer)
		{
			return equals(one, (int) two);
		}
		return one.longValue() == two;
	}
}
