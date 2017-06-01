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
package net.runelite.cache.downloader;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import net.runelite.cache.downloader.requests.HelloHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheClientHandler extends ChannelInboundHandlerAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(CacheClientHandler.class);

	private final CacheClient client;
	private final ByteBuf buffer = Unpooled.buffer(512);

	public CacheClientHandler(CacheClient client)
	{
		this.client = client;
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		logger.warn("Channel has gone inactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
	{
		ByteBuf inbuf = (ByteBuf) msg;
		buffer.writeBytes(inbuf);

		ClientState state = client.getState();

		if (state == ClientState.HANDSHAKING)
		{
			int response = buffer.readByte();

			logger.info("Handshake response {}", response);

			if (response != HelloHandshake.RESPONSE_OK)
			{
				if (response == HelloHandshake.RESPONSE_OUTDATED)
				{
					logger.warn("Client version is outdated");
				}
				else
				{
					logger.warn("Handshake response error {}", response);
				}
			}

			client.onHandshake(response);
		}
		else if (state == ClientState.CONNECTED)
		{
			while (readFile());
		}

		buffer.discardReadBytes();
		ReferenceCountUtil.release(msg);
	}

	private boolean readFile()
	{
		if (buffer.readableBytes() < 8)
		{
			logger.trace("Connected, but not enough data yet to read header");
			return false;
		}

		ByteBuf copy = buffer.slice();

		int index = copy.readUnsignedByte();
		int file = copy.readUnsignedShort();
		// decompress() starts reading here
		int compression = copy.readUnsignedByte();
		int compressedFileSize = copy.readInt();

		int size = compressedFileSize
			+ 5 // 1 byte compresion type, 4 byte compressed size
			+ (compression != 0 ? 4 : 0); // compression has leading 4 byte decompressed length

		assert size > 0;

		int breaks = calculateBreaks(size);

		// 3 for index/file
		if (size + 3 + breaks > buffer.readableBytes())
		{
			logger.trace("Index {} archive {}: Not enough data yet {} > {}", index, file, size + 3 + breaks, buffer.readableBytes());
			return false;
		}

		byte[] compressedData = new byte[size];
		int compressedDataOffset = 0;

		int totalRead = 3;
		buffer.skipBytes(3); // skip index/file

		for (int i = 0; i < breaks + 1; ++i)
		{
			int bytesInBlock = 512 - (totalRead % 512);
			int bytesToRead = Math.min(bytesInBlock, size - compressedDataOffset);

			logger.trace("{}/{}: reading block {}/{}, read so far this block: {}, file status: {}/{}",
				index, file,
				(totalRead % 512), 512,
				bytesInBlock,
				compressedDataOffset, size);

			buffer.getBytes(buffer.readerIndex(), compressedData, compressedDataOffset, bytesToRead);
			buffer.skipBytes(bytesToRead);

			compressedDataOffset += bytesToRead;
			totalRead += bytesToRead;

			if (i < breaks)
			{
				assert compressedDataOffset < size;
				int b = buffer.readUnsignedByte();
				++totalRead;
				assert b == 0xff;
			}
		}

		assert compressedDataOffset == size;

		logger.trace("{}/{}: done downloading file, remaining buffer {}",
			index, file,
			buffer.readableBytes());

		client.onFileFinish(index, file, compressedData);
		return true;
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
	private int calculateBreaks(int size)
	{
		int initialSize = 512 - 3;
		if (size <= initialSize)
		{
			return 0; // First in the initial chunk, no breaks
		}
		int left = size - initialSize;

		if (left % 511 == 0)
		{
			return (left / 511);
		}
		else
		{
			// / 511 because 511 bytes of the file per chunk.
			// + 1 if there is some left over, it still needs its
			// own chunk
			return (left / 511) + 1;
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		// Close the connection when an exception is raised.
		logger.warn(null, cause);
		ctx.close();
	}
}
