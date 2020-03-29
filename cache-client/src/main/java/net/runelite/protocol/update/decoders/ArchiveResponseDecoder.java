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
package net.runelite.protocol.update.decoders;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import net.runelite.cache.fs.jagex.CompressionType;
import net.runelite.protocol.api.update.ArchiveResponsePacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchiveResponseDecoder extends ByteToMessageDecoder
{
	private static final Logger logger = LoggerFactory.getLogger(ArchiveResponseDecoder.class);

	private static final int CHUNK_SIZE = 512;

	@Override
	public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		if (in.readableBytes() < 8)
		{
			return;
		}

		ByteBuf copy = in.slice();

		int index = copy.readUnsignedByte();
		int file = copy.readUnsignedShort();
		// decompress() starts reading here
		int compression = copy.readUnsignedByte();
		int compressedFileSize = copy.readInt();

		assert compression == CompressionType.NONE ||
			compression == CompressionType.BZ2 ||
			compression == CompressionType.GZ;

		int size = compressedFileSize
			+ 5 // 1 byte compresion type, 4 byte compressed size
			+ (compression != CompressionType.NONE ? 4 : 0); // compression has leading 4 byte decompressed length

		assert size > 0;

		int breaks = calculateBreaks(size);

		// 3 for index/file
		if (size + 3 + breaks > in.readableBytes())
		{
			logger.trace("Index {} archive {}: Not enough data yet {} > {}", index, file, size + 3 + breaks, in.readableBytes());
			return;
		}

		ByteBuf compressedData = Unpooled.buffer(size);

		int totalRead = 3;
		in.skipBytes(3); // skip index/file

		for (int i = 0; i < breaks + 1; ++i)
		{
			int bytesInBlock = CHUNK_SIZE - (totalRead % CHUNK_SIZE);
			int bytesToRead = Math.min(bytesInBlock, size - compressedData.writerIndex());

			logger.trace("{}/{}: reading block {}/{}, read so far this block: {}, file status: {}/{}",
				index, file,
				(totalRead % CHUNK_SIZE), CHUNK_SIZE,
				bytesInBlock,
				compressedData.writerIndex(), size);

			ByteBuf chunk = in.readBytes(bytesToRead);
			compressedData.writeBytes(chunk);
			chunk.release();

			totalRead += bytesToRead;

			if (i < breaks)
			{
				assert compressedData.writerIndex() < size;
				int b = in.readUnsignedByte();
				++totalRead;
				assert b == 0xff;
			}
		}

		assert compressedData.writerIndex() == size;

		logger.trace("{}/{}: done downloading file, remaining buffer {}",
			index, file,
			in.readableBytes());

		ArchiveResponsePacket archiveResponse = new ArchiveResponsePacket();
		archiveResponse.setIndex(index);
		archiveResponse.setArchive(file);
		archiveResponse.setData(compressedData.array());
		out.add(archiveResponse);

		compressedData.release();
	}

	/**
	 * Calculate how many breaks there are in the file stream. There are
	 * calculateBreaks()+1 total chunks in the file stream
	 *
	 * File contents are sent in 512 byte chunks, with the first byte of
	 * each chunk except for the first one being 0xff.
	 *
	 * The first chunk has an 8 byte header (index, file, compression,
	 * compressed size). So, the first chunk can contain 512 - 8 bytes of
	 * the file, and each chunk after 511 bytes.
	 *
	 * The 'size' parameter has the compression type and size included in
	 * it, since they haven't been read yet by the buffer stream, as
	 * decompress() reads it, so we use 512 - 3 (because 8-5) = 3
	 */
	private static int calculateBreaks(int size)
	{
		int initialSize = CHUNK_SIZE - 3;
		if (size <= initialSize)
		{
			return 0; // First in the initial chunk, no breaks
		}
		int left = size - initialSize;

		if (left % (CHUNK_SIZE - 1) == 0)
		{
			return (left / (CHUNK_SIZE - 1));
		}
		else
		{
			// / 511 because 511 bytes of the file per chunk.
			// + 1 if there is some left over, it still needs its
			// own chunk
			return (left / (CHUNK_SIZE - 1)) + 1;
		}
	}

}
