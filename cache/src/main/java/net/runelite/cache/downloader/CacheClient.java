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

import com.google.common.base.Stopwatch;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import net.runelite.cache.IndexType;
import net.runelite.cache.downloader.requests.ConnectionInfo;
import net.runelite.cache.downloader.requests.FileRequest;
import net.runelite.cache.downloader.requests.HelloHandshake;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheClient implements AutoCloseable
{
	private static final Logger logger = LoggerFactory.getLogger(CacheClient.class);

	private static final String HOST = "oldschool1.runescape.com";
	private static final int PORT = 43594;

	private static final int CLIENT_REVISION = 139;

	private final Store store; // store cache will be written to
	private final String host;
	private final int clientRevision;

	private ClientState state;

	private final EventLoopGroup group = new NioEventLoopGroup(1);
	private Channel channel;

	private CompletableFuture<Integer> handshakeFuture;
	private final Queue<PendingFileRequest> requests = new ArrayDeque<>();

	public CacheClient(Store store)
	{
		this(store, HOST, CLIENT_REVISION);
	}

	public CacheClient(Store store, String host, int clientRevision)
	{
		this.store = store;
		this.host = host;
		this.clientRevision = clientRevision;
	}

	public void connect()
	{
		Bootstrap b = new Bootstrap();
		b.group(group)
			.channel(NioSocketChannel.class)
			.option(ChannelOption.TCP_NODELAY, true)
			.handler(new ChannelInitializer<SocketChannel>()
			{
				@Override
				public void initChannel(SocketChannel ch) throws Exception
				{
					ChannelPipeline p = ch.pipeline();
					//p.addFirst(new HttpProxyHandler(new InetSocketAddress("runelite.net", 3128)));
					p.addLast(new CacheClientHandler(CacheClient.this));
				}
			});

		// Start the client.
		ChannelFuture f = b.connect(host, PORT).syncUninterruptibly();
		channel = f.channel();
	}

	public CompletableFuture<Integer> handshake()
	{
		HelloHandshake msg = new HelloHandshake();
		msg.setRevision(getClientRevision());

		ByteBuf message = Unpooled.buffer(5);
		message.writeByte(msg.getType()); // handshake type
		message.writeInt(msg.getRevision()); // client revision

		state = ClientState.HANDSHAKING;
		channel.writeAndFlush(message);

		logger.info("Sent handshake with revision {}", msg.getRevision());

		assert handshakeFuture == null;
		handshakeFuture = new CompletableFuture<>();

		return handshakeFuture;
	}

	public void onHandshake(int response)
	{
		assert handshakeFuture != null;

		handshakeFuture.complete(response);

		if (response != HelloHandshake.RESPONSE_OK)
		{
			close();
			return;
		}

		// Send connection info
		ConnectionInfo cinfo = new ConnectionInfo();
		ByteBuf outbuf = Unpooled.buffer(4);
		outbuf.writeByte(cinfo.getType());
		outbuf.writeMedium(cinfo.getPadding());

		channel.writeAndFlush(outbuf);

		state = ClientState.CONNECTED;

		logger.info("Client is now connected!");
	}

	@Override
	public void close()
	{
		channel.close().syncUninterruptibly();
		group.shutdownGracefully();
	}

	public int getClientRevision()
	{
		return clientRevision;
	}

	public ClientState getState()
	{
		return state;
	}

	public void download() throws InterruptedException, ExecutionException, FileNotFoundException, IOException
	{
		Stopwatch stopwatch = Stopwatch.createStarted();

		FileResult result = requestFile(255, 255).get();
		result.decompress(null);

		ByteBuf buffer = Unpooled.wrappedBuffer(result.getContents());

		int indexCount = result.getContents().length / 8;

		for (int i = 0; i < indexCount; ++i)
		{
			int crc = buffer.readInt();
			int revision = buffer.readInt();

			Index index = store.findIndex(i);

			if (index == null)
			{
				logger.info("Index {} does not exist, creating", i);
			}
			else if (index.getRevision() != revision)
			{
				if (revision < index.getRevision())
				{
					logger.warn("Index {} revision is going BACKWARDS! (our revision {}, their revision {})", index.getId(), index.getRevision(), revision);
				}
				else
				{
					logger.info("Index {} has the wrong revision (our revision {}, their revision {})", index.getId(), index.getRevision(), revision);
				}
			}
			else
			{
				logger.info("Index {} is up to date", index.getId());
				continue;
			}

			logger.info("Downloading index {}", i);

			FileResult indexFileResult = requestFile(255, i).get();
			indexFileResult.decompress(null);

			logger.info("Downloaded index {}", i);

			if (indexFileResult.getCrc() != crc)
			{
				logger.warn("Corrupted download for index {}", i);
				continue;
			}

			Index oldIndex = null;
			if (index != null)
			{
				store.removeIndex(index);

				oldIndex = index;
			}

			index = store.addIndex(i);

			index.readIndexData(indexFileResult.getContents());
			index.setCrc(crc);

			logger.info("Index {} has {} archives", i, index.getArchives().size());

			for (Archive archive : index.getArchives())
			{
				Archive oldArchive = oldIndex != null ? oldIndex.getArchive(archive.getArchiveId()) : null;

				if (oldArchive == null || oldArchive.getRevision() != archive.getRevision())
				{
					if (oldArchive == null)
					{
						logger.info("Archive {}/{} in index {} is out of date, downloading", archive.getArchiveId(), index.getArchives().size(), index.getId());
					}
					else if (archive.getRevision() < oldArchive.getRevision())
					{
						logger.warn("Archive {}/{} in index {} revision is going BACKWARDS! (our revision {}, their revision {})",
							archive.getArchiveId(), index.getArchives().size(), index.getId(),
							oldArchive.getRevision(), archive.getRevision());
					}
					else
					{
						logger.info("Archive {}/{} in index {} is out of date ({} != {}), downloading",
							archive.getArchiveId(), index.getArchives().size(), index.getId(),
							oldArchive.getRevision(), archive.getRevision());
					}

					FileResult archiveFileResult = requestFile(index.getId(), archive.getArchiveId()).get();
					byte[] compressedContents = archiveFileResult.getCompressedData();

					archive.setData(compressedContents);
					if (index.getId() != IndexType.MAPS.getNumber())
					{
						archive.decompressAndLoad(null);
					}
				}
				else
				{
					logger.info("Active {}/{} in index {} is up to date", archive.getArchiveId(), index.getArchives().size(), index.getId());

					// copy existing contents, this is sort of hackish.
					byte[] contents = oldArchive.getData();
					if (contents != null)
					{
						archive.setData(contents);
					}
					else
					{
						contents = oldArchive.saveContents();
						archive.loadContents(contents);
						archive.setCompression(oldArchive.getCompression());
					}
				}
			}
		}

		stopwatch.stop();
		logger.info("Download completed in {}", stopwatch);
	}

	public synchronized CompletableFuture<FileResult> requestFile(int index, int fileId)
	{
		if (state != ClientState.CONNECTED)
		{
			throw new IllegalStateException("Can't request files until connected!");
		}

		ByteBuf buf = Unpooled.buffer(4);
		FileRequest request = new FileRequest(index, fileId);
		CompletableFuture<FileResult> future = new CompletableFuture<>();
		PendingFileRequest pf = new PendingFileRequest(request, future);

		buf.writeByte(request.getIndex() == 255 ? 1 : 0);
		int hash = pf.computeHash();
		buf.writeMedium(hash);

		logger.trace("Sending request for {}/{}", index, fileId);

		channel.writeAndFlush(buf);

		requests.add(pf);

		return future;
	}

	private PendingFileRequest findRequest(int index, int file)
	{
		for (PendingFileRequest pr : requests)
		{
			if (pr.getRequest().getIndex() == index && pr.getRequest().getFile() == file)
			{
				return pr;
			}
		}
		return null;
	}

	protected synchronized void onFileFinish(int index, int file, byte[] compressedData)
	{
		PendingFileRequest pr = findRequest(index, file);

		if (pr == null)
		{
			logger.warn("File download {}/{} with no pending request", index, file);
			return;
		}

		requests.remove(pr);

		FileResult result = new FileResult(index, file, compressedData);

		logger.debug("File download finished for index {} file {}, length {}", index, file, compressedData.length);

		pr.getFuture().complete(result);
	}
}
