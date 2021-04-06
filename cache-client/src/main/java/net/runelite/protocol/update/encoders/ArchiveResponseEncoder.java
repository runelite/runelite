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
package net.runelite.protocol.update.encoders;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.runelite.protocol.api.update.ArchiveResponsePacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchiveResponseEncoder extends MessageToByteEncoder<ArchiveResponsePacket>
{
	private static final Logger logger = LoggerFactory.getLogger(ArchiveResponseEncoder.class);

	private static final int CHUNK_SIZE = 512;

	@Override
	protected void encode(ChannelHandlerContext ctx, ArchiveResponsePacket archiveResponse, ByteBuf out) throws Exception
	{
		// archive file header
		// 1 byte index
		// 2 byte archive
		out.writeByte(archiveResponse.getIndex());
		out.writeShort(archiveResponse.getArchive());

		int pos = out.readableBytes();

		// next is the compressed data which starts with compression
		// type and length
		ByteBuf file = Unpooled.wrappedBuffer(archiveResponse.getData());
		// - 3 for the header
		int chunkSize = Math.min(file.readableBytes(), CHUNK_SIZE - 3);

		writeChunk(file.readBytes(chunkSize), out);

		while (file.isReadable())
		{
			out.writeByte(0xff);

			chunkSize = Math.min(file.readableBytes(), CHUNK_SIZE - 1);
			writeChunk(file.readBytes(chunkSize), out);
		}

		int size = out.readableBytes() - pos;
		logger.debug("Wrote index {} archive {} (size {}) in {} bytes",
			archiveResponse.getIndex(), archiveResponse.getArchive(),
			archiveResponse.getData().length, size);
	}

	private void writeChunk(ByteBuf chunk, ByteBuf out)
	{
		try
		{
			out.writeBytes(chunk);
		}
		finally
		{
			chunk.release();
		}
	}

}
