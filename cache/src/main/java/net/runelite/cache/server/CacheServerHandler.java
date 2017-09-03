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
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.io.IOException;
import java.util.Arrays;
import net.runelite.cache.client.requests.ConnectionInfo;
import net.runelite.cache.client.requests.HelloHandshake;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.CompressionType;
import net.runelite.cache.fs.DataFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheServerHandler extends SimpleChannelInboundHandler<ByteBuf>
{
	private static final Logger logger = LoggerFactory.getLogger(CacheServerHandler.class);

	private final CacheServer server;
	private final Store store;

	private ClientState state = ClientState.HANDSHAKING;
	private final ByteBuf buffer = Unpooled.buffer();

	public CacheServerHandler(CacheServer server)
	{
		this.server = server;
		this.store = server.getStore();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) throws Exception
	{
		System.out.println(ByteBufUtil.prettyHexDump(buf));

		buffer.writeBytes(buf);

		int last = -1;
		while (buffer.readableBytes() != last)
		{
			last = buffer.readableBytes();

			switch (state)
			{
				case HANDSHAKING:
					handshake(ctx, buffer);
					break;
				case CONNECTING:
					connecting(ctx, buffer);
					break;
				case CONNECTED:
					connected(ctx, buffer);
					break;
			}
		}

		buffer.discardReadBytes();
	}

	private void handshake(ChannelHandlerContext ctx, ByteBuf buf)
	{
		if (buf.readableBytes() < 5)
		{
			return;
		}

		byte type = buf.readByte();
		if (type != 15)
		{
			logger.warn("Expected handshake type 15, got {}", type);
			ctx.close();
			return;
		}

		int revision = buf.readInt();
		if (revision != server.getRevision())
		{
			logger.warn("Incorrect version for client {}, expected {}", revision, server.getRevision());
			ctx.close();
			return;
		}

		logger.info("Handshake complete from client {}, type {}, revision {}", ctx.channel().remoteAddress(), type, revision);

		// Write response
		ByteBuf buffer = Unpooled.buffer(1);
		buffer.writeByte(HelloHandshake.RESPONSE_OK);
		ctx.writeAndFlush(buffer);

		state = ClientState.CONNECTING;
	}

	private void connecting(ChannelHandlerContext ctx, ByteBuf buf)
	{
		if (buf.readableBytes() < 4)
		{
			return;
		}

		ConnectionInfo cinfo = new ConnectionInfo();
		cinfo.setType(buf.readByte());
		cinfo.setPadding(buf.readMedium());

		logger.info("Connect info from client {} - type {}", ctx.channel().remoteAddress(), cinfo.getType());

		state = ClientState.CONNECTED;
	}

	private void connected(ChannelHandlerContext ctx, ByteBuf buf)
	{
		// a request for an archive
		// byte[0] = 1 if requesting index 255, else 0
		// byte[1] = index
		// byte[2-3] = archive id

		if (buf.readableBytes() < 4)
		{
			return;
		}

		byte requesting255 = buf.readByte();
		int index = buf.readByte() & 0xFF;
		int archiveId = buf.readShort() & 0xFFFF;

		if (index == 255)
		{
			handle255(ctx, requesting255, index, archiveId);
		}
		else
		{
			handleRequest(ctx, index, archiveId);
		}
	}

	private void handle255(ChannelHandlerContext ctx, byte requesting255, int index, int archiveId)
	{
		logger.info("Client {} requests 255 {}, index {}, archive {}", ctx.channel().remoteAddress(), requesting255, index, archiveId);

		if (archiveId == 255)
		{
			// index 255 data, for each index:
			// 4 byte crc
			// 4 byte revision
			ByteBuf buffer = Unpooled.buffer();
			for (Index i : store.getIndexes())
			{
				buffer.writeInt(i.getCrc());
				buffer.writeInt(i.getRevision());
			}

			byte[] compressed = compress(CompressionType.NONE, Arrays.copyOf(buffer.array(), buffer.readableBytes()));
			byte[] packed = addHeader(index, archiveId, compressed);
			byte[] chunked = chunk(packed);

			ctx.writeAndFlush(Unpooled.wrappedBuffer(chunked));
		}
		else
		{
			Index i = store.findIndex(archiveId);
			assert i != null;

			byte[] indexData = i.writeIndexData();

			byte[] compressed = compress(CompressionType.NONE, indexData);
			byte[] packed = addHeader(255, archiveId, compressed);
			byte[] chunked = chunk(packed);

			ctx.writeAndFlush(Unpooled.wrappedBuffer(chunked));
		}
	}

	private void handleRequest(ChannelHandlerContext ctx, int index, int archiveId)
	{
		logger.info("Client {} requests index {} archive {}", ctx.channel().remoteAddress(), index, archiveId);

		Index i = store.findIndex(index);
		assert i != null;

		Archive archive = i.getArchive(archiveId);
		assert archive != null;

		byte[] packed;
		if (archive.getData() != null)
		{
			byte[] data = archive.getData(); // is compressed, includes length and type
			packed = addHeader(index, archiveId, Arrays.copyOf(data, data.length - 2)); // compressed size includes revision..
		}
		else
		{
			byte[] data = archive.saveContents();
			data = compress(archive.getCompression(), data);

			packed = addHeader(index, archiveId, data);
		}

		byte[] chunked = chunk(packed);

		ctx.writeAndFlush(Unpooled.wrappedBuffer(chunked));
	}

	private byte[] compress(int compression, byte[] data)
	{
		try
		{
			return DataFile.compress(data, compression, -1, null);
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	/**
	 * add header to archive
	 *
	 * @param index
	 * @param archive
	 * @param file compressed archive
	 * @return
	 */
	private byte[] addHeader(int index, int archive, byte[] file)
	{
		// archive file header
		// 1 byte index
		// 2 byte archive

		ByteBuf buf = Unpooled.buffer();
		buf.writeByte((byte) index);
		buf.writeShort((short) archive);
		buf.writeBytes(file);

		return Arrays.copyOf(buf.array(), buf.readableBytes());
	}

	/**
	 * Insert in chunk markers to data
	 *
	 * @param in
	 * @return
	 */
	private byte[] chunk(byte[] in)
	{
		Chunker chunker = new Chunker(in);
		return chunker.chunkData();
	}

}
