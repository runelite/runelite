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
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.rs.auth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class CryptTest
{
	@Test
	public void testDataRoundtrip() throws IOException
	{
		byte[] plaintext = "session store payload".getBytes(StandardCharsets.UTF_8);
		byte[] key = new byte[32];
		Arrays.fill(key, (byte) 7);

		byte[] encryptedA = Crypt.encryptData(plaintext, key);
		byte[] encryptedB = Crypt.encryptData(plaintext, key);

		Assert.assertFalse(Arrays.equals(encryptedA, encryptedB));
		Assert.assertArrayEquals(plaintext, Crypt.decryptData(encryptedA, key));
		Assert.assertArrayEquals(plaintext, Crypt.decryptData(encryptedB, key));

		encryptedA[encryptedA.length - 1] ^= 1;
		try
		{
			Crypt.decryptData(encryptedA, key);
			Assert.fail("Tampered ciphertext must not decrypt");
		}
		catch (IOException expected)
		{
		}
	}
}
