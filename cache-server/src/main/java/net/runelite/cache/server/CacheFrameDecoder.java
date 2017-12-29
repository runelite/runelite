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
import static net.runelite.protocol.update.decoders.UpdateOpcodes.ARCHIVE_REQUEST_HIGH;
import static net.runelite.protocol.update.decoders.UpdateOpcodes.ARCHIVE_REQUEST_LOW;
import static net.runelite.protocol.update.decoders.UpdateOpcodes.CLIENT_LOGGED_IN;
import static net.runelite.protocol.update.decoders.UpdateOpcodes.CLIENT_LOGGED_OUT;
import static net.runelite.protocol.update.decoders.UpdateOpcodes.ENCRYPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheFrameDecoder extends ByteToMessageDecoder
{
	private static final Logger logger = LoggerFactory.getLogger(CacheFrameDecoder.class);

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		in.markReaderIndex();
		byte opcode = in.readByte();
		in.resetReaderIndex();

		int length;

		switch (opcode)
		{
			case ARCHIVE_REQUEST_LOW:
			case ARCHIVE_REQUEST_HIGH:
			case CLIENT_LOGGED_IN:
			case CLIENT_LOGGED_OUT:
			case ENCRYPTION:
				length = 4;
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
