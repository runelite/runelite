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
	private static BigInteger exponent = new BigInteger("db7adc8af6f44b1359c5d1701d6bddc3eb47ce3ff2c690521ec8a9ea27525bf69263cea25648540cb572db8c703eeab85e740d1b44342555ab5733e9884f979fb42929d0a21b79d4a180fe83e48e1abaf08ec41e9dc2c0d8b087dc1a9637df68a64b82dddfdfbc6ae31a3c077434c892c7e8425a0184eed3971fa77b0ec895399d7b683042ee981990d9dd2ce3c436be9b2ec93587fb25d1f17cbb771e0f0bf88b27c47af0fd5417f4d1977e3f5483f787a71f59820d1b29a9af9460c6ad8a713ee2a1bf4021e51ce9776aa4eddae3616a808174493b572218c957c15b06df5aef889dbfd5de3a1326ea2d47dbf68b5bd06201b36d6ca5dedb69a8be84c254bb", 16);

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
