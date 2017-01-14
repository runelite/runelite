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

package net.runelite.cache.util;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

public class Xtea
{
	static
	{
		Security.addProvider(new BouncyCastleProvider());
	}
	
	private final Cipher cipher;
	private final int[] keys;

	public Xtea(int[] keys) throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		this.cipher = Cipher.getInstance("XTEA/ECB/NoPadding");
		this.keys = keys;
	}

	private static byte[] packKey(int[] key)
	{
		ByteBuffer buffer = ByteBuffer.allocate(4 * key.length);
		for (int i : key)
			buffer.putInt(i);
		return buffer.array();
	}

	public byte[] encrypt(byte[] data, int len) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(packKey(keys), cipher.getAlgorithm()));
		byte[] out = cipher.update(data, 0, len - (len % cipher.getBlockSize()));
		cipher.doFinal();

		// add remaining data, which is not encrypted
		if (out.length != len)
		{
			assert len > out.length;
			
			byte[] padded = Arrays.copyOf(out, len);
			System.arraycopy(data, out.length, padded, out.length, len - out.length);

			out = padded;
		}

		return out;
	}

	public byte[] decrypt(byte[] data, int len) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(packKey(keys), cipher.getAlgorithm()));
		byte[] out = cipher.update(data, 0, len - (len % cipher.getBlockSize()));
		cipher.doFinal();

		if (out.length != len)
		{
			assert len > out.length;

			byte[] padded = Arrays.copyOf(out, len);
			System.arraycopy(data, out.length, padded, out.length, len - out.length);

			out = padded;
		}

		return out;
	}
}
