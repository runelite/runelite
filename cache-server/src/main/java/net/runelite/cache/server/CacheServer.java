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

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.runelite.cache.fs.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheServer implements AutoCloseable
{
	private static final Logger logger = LoggerFactory.getLogger(CacheServer.class);

	private static final int PORT = 43594;

	private final EventLoopGroup group = new NioEventLoopGroup(1);

	private Channel channel;

	private final Store store;
	private final int revision;

	public CacheServer(Store store, int revision)
	{
		this.store = store;
		this.revision = revision;
	}

	public void start()
	{
		ServerBootstrap b = new ServerBootstrap();
		b.group(group)
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.TCP_NODELAY, true)
			.childHandler(new CacheServerInitializer(this));

		ChannelFuture f = b.bind(PORT).syncUninterruptibly();
		channel = f.channel();

		logger.info("Server is now listening on {}", PORT);
	}

	public void waitForClose()
	{
		channel.closeFuture().awaitUninterruptibly();
	}

	@Override
	public void close()
	{
		channel.close().syncUninterruptibly();
		group.shutdownGracefully();
	}

	public int getRevision()
	{
		return revision;
	}

	public Store getStore()
	{
		return store;
	}
}
