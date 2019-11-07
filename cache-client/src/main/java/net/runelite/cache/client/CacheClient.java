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
package net.runelite.cache.client;

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
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.ArchiveData;
import net.runelite.cache.index.IndexData;
import net.runelite.protocol.update.decoders.HandshakeResponseDecoder;
import net.runelite.protocol.update.encoders.ArchiveRequestEncoder;
import net.runelite.protocol.update.encoders.EncryptionEncoder;
import net.runelite.protocol.api.update.ArchiveRequestPacket;
import net.runelite.protocol.api.login.HandshakeResponseType;
import net.runelite.cache.util.Crc32;
import net.runelite.protocol.api.handshake.UpdateHandshakePacket;
import net.runelite.protocol.handshake.UpdateHandshakeEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheClient implements AutoCloseable
{
	private static final Logger logger = LoggerFactory.getLogger(CacheClient.class);

	private static final String HOST = "oldschool1.runescape.com";
	private static final int PORT = 43594;

	private static final int MAX_REQUESTS = 19; // too many and the server closes the conncetion

	private final Store store; // store cache will be written to
	private final String host;
	private final int clientRevision;
	private DownloadWatcher watcher;

	private ClientState state;

	private final EventLoopGroup group = new NioEventLoopGroup(1);
	private Channel channel;

	private CompletableFuture<HandshakeResponseType> handshakeFuture;
	private final Queue<PendingFileRequest> requests = new ArrayDeque<>();

	public static void main(String[] args)
	{
		Path path = Paths.get(System.getProperty("user.home"), "jagexcache" + File.separator + "oldschool" + File.separator + "LIVE");
		final File jagexcache = new File(String.valueOf(path));

		jagexcache.mkdirs();

		try (Store store = new Store(jagexcache))
		{
			store.load();
			CacheClient c = new CacheClient(store, Integer.parseInt(args[0]));
			c.connect();
			CompletableFuture<HandshakeResponseType> handshake = c.handshake();
			handshake.get();
			c.download();
			c.close();
			store.save();
		}
		catch (Exception ex)
		{
			logger.error(ex.getMessage());
		}
	}

	public CacheClient(Store store, int clientRevision)
	{
		this(store, HOST, clientRevision);
	}

	public CacheClient(Store store, String host, int clientRevision)
	{
		this.store = store;
		this.host = host;
		this.clientRevision = clientRevision;
	}

	public CacheClient(Store store, int clientRevision, DownloadWatcher watcher)
	{
		this(store, clientRevision);
		this.watcher = watcher;
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
					p.addLast("decoder", new HandshakeResponseDecoder());

					p.addLast(
						new CacheClientHandler(),
						new HandshakeResponseHandler(CacheClient.this),
						new ArchiveResponseHandler(CacheClient.this)
					);

					p.addLast(
						new UpdateHandshakeEncoder(),
						new EncryptionEncoder(),
						new ArchiveRequestEncoder()
					);
				}
			});

		// Start the client.
		ChannelFuture f = b.connect(host, PORT).syncUninterruptibly();
		channel = f.channel();
	}

	public CompletableFuture<HandshakeResponseType> handshake()
	{
		UpdateHandshakePacket handshakePacket = new UpdateHandshakePacket();
		handshakePacket.setRevision(getClientRevision());

		state = ClientState.HANDSHAKING;

		assert handshakeFuture == null;
		handshakeFuture = new CompletableFuture<>();

		channel.writeAndFlush(handshakePacket);

		logger.info("Sent handshake with revision {}", handshakePacket.getRevision());

		return handshakeFuture;
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

	void setState(ClientState state)
	{
		this.state = state;
	}

	CompletableFuture<HandshakeResponseType> getHandshakeFuture()
	{
		return handshakeFuture;
	}

	public List<IndexInfo> requestIndexes() throws IOException
	{
		logger.info("Requesting indexes");

		FileResult result = requestFile(255, 255, true).join();
		result.decompress(null);

		ByteBuf buffer = Unpooled.wrappedBuffer(result.getContents());
		int indexCount = result.getContents().length / 8;
		List<IndexInfo> indexInfo = new ArrayList<>();

		for (int i = 0; i < indexCount; ++i)
		{
			int crc = buffer.readInt();
			int revision = buffer.readInt();
			indexInfo.add(new IndexInfo(i, crc, revision));
		}

		return indexInfo;
	}

	public void download() throws IOException
	{
		Stopwatch stopwatch = Stopwatch.createStarted();

		List<IndexInfo> indexes = requestIndexes();
		for (IndexInfo indexInfo : indexes)
		{
			int i = indexInfo.getId();
			int crc = indexInfo.getCrc();
			int revision = indexInfo.getRevision();

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
			else if (index.getCrc() != crc)
			{
				logger.warn("Index {} CRC has changed! (our crc {}, their crc {})",
					index.getCrc(), index.getCrc(), crc);
			}
			else
			{
				// despite the index being up to date, not everything
				// can be downloaded, eg. for tracks.
				logger.info("Index {} is up to date", index.getId());
			}

			logger.info("Downloading index {}", i);

			FileResult indexFileResult = requestFile(255, i, true).join();
			indexFileResult.decompress(null);

			logger.info("Downloaded index {}", i);

			if (indexFileResult.getCrc() != crc)
			{
				logger.warn("Corrupted download for index {}", i);
				continue;
			}

			IndexData indexData = new IndexData();
			indexData.load(indexFileResult.getContents());

			if (index == null)
			{
				index = store.addIndex(i);
			}

			// update index settings
			index.setProtocol(indexData.getProtocol());
			index.setNamed(indexData.isNamed());
			index.setCrc(crc);
			index.setRevision(revision);

			logger.info("Index {} has {} archives", i, indexData.getArchives().length);

			for (ArchiveData ad : indexData.getArchives())
			{
				Archive existing = index.getArchive(ad.getId());

				if (existing != null && existing.getRevision() == ad.getRevision()
					&& existing.getCrc() == ad.getCrc()
					&& existing.getNameHash() == ad.getNameHash())
				{
					logger.debug("Archive {}/{} in index {} is up to date",
						ad.getId(), indexData.getArchives().length, index.getId());
					continue;
				}

				if (existing == null)
				{
					logger.info("Archive {}/{} in index {} is out of date, downloading",
						ad.getId(), indexData.getArchives().length, index.getId());
				}
				else if (ad.getRevision() < existing.getRevision())
				{
					logger.warn("Archive {}/{} in index {} revision is going BACKWARDS! (our revision {}, their revision {})",
						ad.getId(), indexData.getArchives().length, index.getId(),
						existing.getRevision(), ad.getRevision());
				}
				else
				{
					logger.info("Archive {}/{} in index {} is out of date, downloading. " +
						"revision: ours: {} theirs: {}, crc: ours: {} theirs {}, name: ours {} theirs {}",
						ad.getId(), indexData.getArchives().length, index.getId(),
						existing.getRevision(), ad.getRevision(),
						existing.getCrc(), ad.getCrc(),
						existing.getNameHash(), ad.getNameHash());
				}

				final Archive archive = existing == null
					? index.addArchive(ad.getId())
					: existing;

				archive.setRevision(ad.getRevision());
				archive.setCrc(ad.getCrc());
				archive.setNameHash(ad.getNameHash());

				// Add files
				archive.setFileData(ad.getFiles());

				CompletableFuture<FileResult> future = requestFile(index.getId(), ad.getId(), false);
				future.handle((fr, ex) ->
				{
					byte[] data = fr.getCompressedData();

					Crc32 crc32 = new Crc32();
					crc32.update(data, 0, data.length);
					int hash = crc32.getHash();

					if (hash != archive.getCrc())
					{
						logger.warn("crc mismatch on downloaded archive {}/{}: {} != {}",
							archive.getIndex().getId(), archive.getArchiveId(),
							hash, archive.getCrc());
						throw new RuntimeException("crc mismatch");
					}

					if (watcher != null)
					{
						watcher.downloadComplete(archive, data);
					}
					else
					{
						try
						{
							Storage storage = store.getStorage();
							storage.saveArchive(archive, data);
						}
						catch (IOException ex1)
						{
							logger.warn("unable to save archive data", ex1);
						}
					}
					return null;
				});
			}
		}

		// flush any pending requests
		channel.flush();

		while (!requests.isEmpty())
		{
			// wait for pending requests
			synchronized (this)
			{
				try
				{
					wait();
				}
				catch (InterruptedException ex)
				{
					logger.warn(null, ex);
				}
			}
		}

		stopwatch.stop();
		logger.info("Download completed in {}", stopwatch);
	}

	private synchronized CompletableFuture<FileResult> requestFile(int index, int fileId, boolean flush)
	{
		if (state != ClientState.CONNECTED)
		{
			throw new IllegalStateException("Can't request files until connected!");
		}

		if (!flush)
		{
			while (requests.size() >= MAX_REQUESTS)
			{
				channel.flush();

				try
				{
					wait();
				}
				catch (InterruptedException ex)
				{
					logger.warn("interrupted while waiting for requests", ex);
				}
			}
		}

		ArchiveRequestPacket archiveRequest = new ArchiveRequestPacket();
		archiveRequest.setPriority(false);
		archiveRequest.setIndex(index);
		archiveRequest.setArchive(fileId);

		CompletableFuture<FileResult> future = new CompletableFuture<>();
		PendingFileRequest pf = new PendingFileRequest(index,
			fileId, future);

		logger.trace("Sending request for {}/{}", index, fileId);

		requests.add(pf);

		if (!flush)
		{
			channel.write(archiveRequest);
		}
		else
		{
			channel.writeAndFlush(archiveRequest);
		}

		return future;
	}

	private PendingFileRequest findRequest(int index, int file)
	{
		for (PendingFileRequest pr : requests)
		{
			if (pr.getIndex() == index && pr.getArchive() == file)
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

		notify();

		FileResult result = new FileResult(index, file, compressedData);

		logger.debug("File download finished for index {} file {}, length {}", index, file, compressedData.length);

		pr.getFuture().complete(result);
	}
}
