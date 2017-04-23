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
package net.runelite.proxy;

import java.math.BigInteger;
import java.util.Random;

public class RSA
{
	private final BigInteger e = Proxy.SERVER_RSA_KEY_EXPONENT; // Use same exponent as server
	private final BigInteger n;
	private final BigInteger d;

	public RSA()
	{
		// This taken from http://stackoverflow.com/a/24547249
		int keySize = Proxy.SERVER_RSA_KEY_MODULUS.bitLength(); // pick same key size as server

		//SecureRandom random = new SecureRandom();
		Random random = new Random(42); // Hack to make the modulus always the same

		// Choose two distinct prime numbers p and q.
		BigInteger p = BigInteger.probablePrime(keySize / 2, random);
		BigInteger q = BigInteger.probablePrime(keySize / 2, random);
		// Compute n = pq (modulus)
		n = p.multiply(q);
		// Compute φ(n) = φ(p)φ(q) = (p − 1)(q − 1) = n - (p + q -1), where φ is Euler's totient function.
		// and choose an integer e such that 1 < e < φ(n) and gcd(e, φ(n)) = 1; i.e., e and φ(n) are coprime.
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		assert m.gcd(e).equals(BigInteger.ONE); // We always pick SERVER_RSA_KEY_EXPONENT instead
		// Determine d as d ≡ e−1 (mod φ(n)); i.e., d is the multiplicative inverse of e (modulo φ(n)).
		d = e.modInverse(m);
	}

	public RSA(BigInteger n, BigInteger d)
	{
		this.n = n;
		this.d = d;
	}

	public BigInteger encrypt(BigInteger value)
	{
		// C = P**e % n
		return value.modPow(e, n);
	}

	public BigInteger decrypt(BigInteger value)
	{
		// P = C**d % n
		return value.modPow(d, n);
	}

	public byte[] encrypt(byte[] value)
	{
		return encrypt(new BigInteger(value)).toByteArray();
	}

	public byte[] decrypt(byte[] value)
	{
		return decrypt(new BigInteger(value)).toByteArray();
	}

	public BigInteger getE()
	{
		return e;
	}

	public BigInteger getN()
	{
		return n;
	}

	public BigInteger getD()
	{
		return d;
	}
}
