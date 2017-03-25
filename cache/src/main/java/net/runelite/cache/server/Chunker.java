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
package net.runelite.cache.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chunker
{
	private static final Logger logger = LoggerFactory.getLogger(Chunker.class);

	private static final int CHUNK_SIZE = 512;

	private final byte[] data;

	public Chunker(byte[] data)
	{
		this.data = data;
	}

	/**
	 * Split data into 512 byte chunks, with the first byte of each chunk
	 * being 0xff, except for the first chunk.
	 *
	 * @return
	 */
	public byte[] chunkData()
	{
		ByteBuf buf = Unpooled.buffer();

		int pos = 0;
		int remaining = data.length;

		int put = Math.min(CHUNK_SIZE, remaining);
		buf.writeBytes(data, pos, put);

		pos += put;
		remaining -= put;

		while (remaining > 0)
		{
			buf.writeByte((byte) 0xff);

			put = Math.min(CHUNK_SIZE - 1, remaining);
			buf.writeBytes(data, pos, put);

			pos += put;
			remaining -= put;
		}

		return Arrays.copyOf(buf.array(), buf.readableBytes());
	}
}
