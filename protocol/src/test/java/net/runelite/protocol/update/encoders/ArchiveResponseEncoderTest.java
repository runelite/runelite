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
package net.runelite.protocol.update.encoders;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.runelite.cache.fs.Container;
import net.runelite.cache.fs.jagex.CompressionType;
import net.runelite.protocol.update.decoders.ArchiveResponseDecoder;
import net.runelite.protocol.api.update.ArchiveResponsePacket;
import org.junit.Assert;
import org.junit.Test;

public class ArchiveResponseEncoderTest
{
	@Test
	public void testEncode() throws Exception
	{
		byte[] data = new byte[1000];
		Random random = new Random(42L);
		random.nextBytes(data);

		Container container = new Container(CompressionType.NONE, -1);
		container.compress(data, null);
		byte[] compressedData = container.data;

		ArchiveResponsePacket archiveResponse = new ArchiveResponsePacket();
		archiveResponse.setIndex(0);
		archiveResponse.setArchive(1);
		archiveResponse.setData(compressedData);

		ByteBuf buf = Unpooled.buffer(1024);
		ArchiveResponseEncoder encoder = new ArchiveResponseEncoder();
		encoder.encode(null, archiveResponse, buf);

		ArchiveResponseDecoder decoder = new ArchiveResponseDecoder();
		List<Object> out = new ArrayList<>();
		decoder.decode(null, buf, out);

		Assert.assertEquals(1, out.size());
		ArchiveResponsePacket response = (ArchiveResponsePacket) out.get(0);

		Assert.assertEquals(archiveResponse.getIndex(), response.getIndex());
		Assert.assertEquals(archiveResponse.getArchive(), response.getArchive());
		Assert.assertArrayEquals(archiveResponse.getData(), response.getData());

		byte[] decompressedData = Container.decompress(response.getData(), null).data;
		Assert.assertArrayEquals(data, decompressedData);
	}

}
