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
package net.runelite.cache.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.runelite.cache.protocol.packets.HandshakePacket;
import net.runelite.cache.protocol.packets.HandshakeResponsePacket;
import net.runelite.cache.protocol.packets.HandshakeResponseType;
import net.runelite.cache.protocol.packets.HandshakeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandshakeHandler extends SimpleChannelInboundHandler<HandshakePacket>
{
	private static final Logger logger = LoggerFactory.getLogger(HandshakeHandler.class);

	private final CacheServer server;

	public HandshakeHandler(CacheServer server)
	{
		this.server = server;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HandshakePacket handshakePacket) throws Exception
	{
		if (handshakePacket.getType() != HandshakeType.ON_DEMAND)
		{
			logger.warn("Expected handshake type ON_DEMAND");
			ctx.close();
			return;
		}

		if (handshakePacket.getRevision() != server.getRevision())
		{
			logger.warn("Incorrect version for client {}, expected {}",
				handshakePacket.getRevision(), server.getRevision());
			ctx.close();
			return;
		}

		logger.info("Handshake complete from client {}, type {}, revision {}",
			ctx.channel().remoteAddress(), handshakePacket.getType(),
			handshakePacket.getRevision());

		HandshakeResponsePacket handshakeResponse = new HandshakeResponsePacket();
		handshakeResponse.setResponse(HandshakeResponseType.RESPONSE_OK);
		ctx.channel().writeAndFlush(handshakeResponse);
	}

}
