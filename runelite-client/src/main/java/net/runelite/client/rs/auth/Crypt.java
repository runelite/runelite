/*
 * Copyright (c) 2021 Abex
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
package net.runelite.client.rs.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Crypt
{
	private static final String CIPHER_TRANSFORM = "AES/GCM/NoPadding";
	private static final int NONCE_LENGTH = 12;
	private static final int TAG_LENGTH_BITS = 128;
	private static final int TAG_LENGTH_BYTES = TAG_LENGTH_BITS / 8;
	private static final int DATA_VERSION = 1;
	private static final int HEADER_LENGTH = 2 + NONCE_LENGTH;

	private Crypt()
	{
	}

	static byte[] encryptData(byte[] plaintext, byte[] key) throws IOException
	{
		try
		{
			byte[] nonce = new byte[NONCE_LENGTH];
			new SecureRandom().nextBytes(nonce);
			Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORM);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(TAG_LENGTH_BITS, nonce));
			byte[] header = createHeader(nonce);
			cipher.updateAAD(header);
			byte[] ciphertext = cipher.doFinal(plaintext);
			byte[] output = Arrays.copyOf(header, header.length + ciphertext.length);
			System.arraycopy(ciphertext, 0, output, header.length, ciphertext.length);
			return output;
		}
		catch (GeneralSecurityException e)
		{
			throw new IOException("unable to encrypt data", e);
		}
	}

	static byte[] decryptData(byte[] cryptData, byte[] key) throws IOException
	{
		if (cryptData.length < HEADER_LENGTH + TAG_LENGTH_BYTES || getU16(cryptData, 0) != DATA_VERSION)
		{
			throw new IOException("invalid encrypted data");
		}

		try
		{
			byte[] nonce = Arrays.copyOfRange(cryptData, 2, HEADER_LENGTH);
			Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORM);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(TAG_LENGTH_BITS, nonce));
			cipher.updateAAD(cryptData, 0, HEADER_LENGTH);
			return cipher.doFinal(cryptData, HEADER_LENGTH, cryptData.length - HEADER_LENGTH);
		}
		catch (AEADBadTagException e)
		{
			throw new IOException("incorrect key or corrupt encrypted data", e);
		}
		catch (GeneralSecurityException e)
		{
			throw new IOException("unable to decrypt data", e);
		}
	}

	private static byte[] createHeader(byte[] nonce)
	{
		byte[] header = new byte[HEADER_LENGTH];
		putU16(header, 0, DATA_VERSION);
		System.arraycopy(nonce, 0, header, 2, nonce.length);
		return header;
	}

	private static void putU16(byte[] data, int offset, int value)
	{
		data[offset] = (byte) (value >> 8);
		data[offset + 1] = (byte) value;
	}

	private static int getU16(byte[] data, int offset)
	{
		return ((data[offset] & 0xFF) << 8) | (data[offset + 1] & 0xFF);
	}
}
