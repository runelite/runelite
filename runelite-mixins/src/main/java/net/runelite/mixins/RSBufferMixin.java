/*
 * Copyright (c) 2019, Null (zeruth)
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
package net.runelite.mixins;

import java.math.BigInteger;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.rs.api.RSBuffer;

@Mixin(RSBuffer.class)
public abstract class RSBufferMixin implements RSBuffer
{
	@Inject
	private static BigInteger modulus = new BigInteger("10001", 16);

	@Inject
	private static BigInteger exponent = new BigInteger("bb5d826b249905895f4e463422dd339f8375ed5b212ac8890a97e4ab7dba0c5fe8188f44c00f8106e5721f615a8bcee2da7316ff1572cad5fbfd33f30985f0ae855cfd498483ecc0c3a01c8630f90cff1f54e75a44d58482c371e203e6eb7ba879fd65949aeef827a5e550429bd857d712f64351bc1162e1615ca6622a3bc9b8e31a96000fb0a01a12a51ca3e89918c06759d1db65c33dc6a074abec02f94466886d1a52e7d084aa88338aab1f25d58f9e03ed0a308c6c4eed139c1c1c818cd2370d8cd28ec34bce18360d1756e202eb733f998200242d71ce19548f23b03c1eac4d6e9892616ade1c66d2ce3ab69744e27d7099f3574bcd3d3e95e7a52180d9", 16);

	@Copy("encryptRsa")
	public void rs$encryptRsa(BigInteger var1, BigInteger var2)
	{
	}

	@Replace("encryptRsa")
	public void rl$encryptRsa(BigInteger var1, BigInteger var2)
	{
		rs$encryptRsa(modulus, exponent);
	}
}
