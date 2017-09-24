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

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import net.runelite.cache.protocol.packets.EncryptionPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheFrameDecoder extends ByteToMessageDecoder
{
	private static final Logger logger = LoggerFactory.getLogger(CacheFrameDecoder.class);

	public static final int ARCHIVE_REQUEST_LOW = 0;
	public static final int ARCHIVE_REQUEST_HIGH = 1;
	public static final int ENCRYPTION = EncryptionPacket.OPCODE;
	public static final int HANDSHAKE_ON_DEMAND = 15;

	private ClientState state = ClientState.HANDSHAKING;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		in.markReaderIndex();
		byte opcode = in.readByte();
		in.resetReaderIndex();

		int length;

		switch (opcode)
		{
			case HANDSHAKE_ON_DEMAND:
				length = 5;

				if (state != ClientState.HANDSHAKING)
				{
					ctx.close();
					return;
				}
				state = ClientState.CONNECTED;
				break;
			case ARCHIVE_REQUEST_LOW:
			case ARCHIVE_REQUEST_HIGH:
			case ENCRYPTION:
				length = 4;

				if (state != ClientState.CONNECTED)
				{
					ctx.close();
					return;
				}
				break;
			default:
				logger.debug("Unknown packet opcode from {}: {}",
					ctx.channel().remoteAddress(), opcode);
				ctx.close();
				return;
		}

		if (in.readableBytes() < length)
		{
			return;
		}

		ByteBuf packet = in.readRetainedSlice(length);
		out.add(packet);
	}
}
