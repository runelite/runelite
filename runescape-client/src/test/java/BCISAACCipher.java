/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bouncycastle.crypto.engines.ISAACEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.Pack;

public class BCISAACCipher
{
	private final ISAACEngine cipher = new ISAACEngine();
	private final int[] results;
	private int index = 255; // RS ISAACCipher returns the last int first

	private Method isaac;

	public BCISAACCipher(int[] keys)
	{
		// Convert keys to a little endian byte array
		byte[] bkeys = Pack.intToLittleEndian(keys);
		cipher.init(true, new KeyParameter(bkeys));

		try
		{
			Field resultsField = cipher.getClass().getDeclaredField("results");
			resultsField.setAccessible(true);

			isaac = cipher.getClass().getDeclaredMethod("isaac");

			results = (int[]) resultsField.get(cipher);
		}
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public int nextInt()
	{
		/*
		 * bouncycastle calls isaac() initially twice, once in setKey,
		 * and then again in returnByte because index == 0. So, we can't
		 * use returnByte
		 */
		if (index == -1)
		{
			try
			{
				isaac.invoke(cipher);
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
			{
				throw new RuntimeException(ex);
			}

			index = 255;
		}

		return results[index--];
	}
}
