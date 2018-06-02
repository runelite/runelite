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

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Xtea
{
	private static final int GOLDEN_RATIO = 0x9E3779B9;

	private static final int ROUNDS = 32;

	private final int[] key;

	public Xtea(int[] key)
	{
		this.key = key;
	}

	public byte[] encrypt(byte[] data, int len)
	{
		ByteBuf buf = Unpooled.wrappedBuffer(data, 0, len);
		ByteBuf out = Unpooled.buffer(len);
		int numBlocks = len / 8;
		for (int block = 0; block < numBlocks; ++block)
		{
			int v0 = buf.readInt();
			int v1 = buf.readInt();
			int sum = 0;
			for (int i = 0; i < ROUNDS; ++i)
			{
				v0 += (((v1 << 4) ^ (v1 >>> 5)) + v1) ^ (sum + key[sum & 3]);
				sum += GOLDEN_RATIO;
				v1 += (((v0 << 4) ^ (v0 >>> 5)) + v0) ^ (sum + key[(sum >>> 11) & 3]);
			}
			out.writeInt(v0);
			out.writeInt(v1);
		}
		out.writeBytes(buf);
		return out.array();
	}

	public byte[] decrypt(byte[] data, int len)
	{
		ByteBuf buf = Unpooled.wrappedBuffer(data, 0, len);
		ByteBuf out = Unpooled.buffer(len);
		int numBlocks = len / 8;
		for (int block = 0; block < numBlocks; ++block)
		{
			int v0 = buf.readInt();
			int v1 = buf.readInt();
			int sum = GOLDEN_RATIO * ROUNDS;
			for (int i = 0; i < ROUNDS; ++i)
			{
				v1 -= (((v0 << 4) ^ (v0 >>> 5)) + v0) ^ (sum + key[(sum >>> 11) & 3]);
				sum -= GOLDEN_RATIO;
				v0 -= (((v1 << 4) ^ (v1 >>> 5)) + v1) ^ (sum + key[sum & 3]);
			}
			out.writeInt(v0);
			out.writeInt(v1);
		}
		out.writeBytes(buf);
		return out.array();
	}
}
