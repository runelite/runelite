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

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.concurrent.CompletableFuture;
import net.runelite.protocol.update.decoders.ArchiveResponseDecoder;
import net.runelite.protocol.api.update.EncryptionPacket;
import net.runelite.protocol.api.handshake.HandshakeResponsePacket;
import net.runelite.protocol.api.login.HandshakeResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandshakeResponseHandler extends SimpleChannelInboundHandler<HandshakeResponsePacket>
{
	private static final Logger logger = LoggerFactory.getLogger(HandshakeResponseHandler.class);

	private final CacheClient client;

	public HandshakeResponseHandler(CacheClient client)
	{
		this.client = client;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HandshakeResponsePacket handshakeResponse) throws Exception
	{
		Channel channel = ctx.channel();
		ChannelPipeline p = ctx.pipeline();
		CompletableFuture<HandshakeResponseType> handshakeFuture = client.getHandshakeFuture();

		assert handshakeFuture != null;

		if (handshakeResponse.getResponse() != HandshakeResponseType.RESPONSE_OK)
		{
			logger.warn("Non-ok response from server {}", handshakeResponse.getResponse());
			handshakeFuture.complete(handshakeResponse.getResponse());
			ctx.close();
			return;
		}

		// Send encryption packet
		EncryptionPacket encryptionPacket = new EncryptionPacket();
		encryptionPacket.setKey((byte) 0);
		channel.writeAndFlush(encryptionPacket);

		client.setState(ClientState.CONNECTED);

		logger.info("Client is now connected!");

		p.replace("decoder", "decoder", new ArchiveResponseDecoder());

		handshakeFuture.complete(handshakeResponse.getResponse());
	}

}
