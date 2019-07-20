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
	private static BigInteger exponent = new BigInteger("10001", 16);

	@Inject
	private static BigInteger modulus = new BigInteger("83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db", 16);

	@Copy("encryptRsa")
	public void rs$encryptRsa(BigInteger var1, BigInteger var2)
	{
	}

	@Replace("encryptRsa")
	public void rl$encryptRsa(BigInteger var1, BigInteger var2)
	{
		rs$encryptRsa(exponent, modulus);
	}
}