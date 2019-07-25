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
package net.runelite.cache.definitions.loaders;

import java.util.LinkedList;
import net.runelite.cache.definitions.WorldMapDefinition;
import net.runelite.cache.definitions.WorldMapType0;
import net.runelite.cache.definitions.WorldMapType1;
import net.runelite.cache.definitions.WorldMapType2;
import net.runelite.cache.definitions.WorldMapType3;
import net.runelite.cache.definitions.WorldMapTypeBase;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.region.Position;

public class WorldMapLoader
{
	@SuppressWarnings("unchecked")
	public WorldMapDefinition load(byte[] b, int fileId)
	{
		WorldMapDefinition def = new WorldMapDefinition();
		InputStream in = new InputStream(b);

		def.fileId = fileId;
		def.safeName = in.readString();
		def.name = in.readString();

		int packedPos = in.readInt();
		if (packedPos == -1)
		{
			def.position = new Position(-1, -1, -1);
		}
		else
		{
			int y = packedPos >> 28 & 3;
			int x = packedPos >> 14 & 16383;
			int z = packedPos & 16383;
			def.position = new Position(x, y, z);
		}

		def.field450 = in.readInt();
		in.readUnsignedByte();
		def.field457 = in.readUnsignedByte() == 1;
		def.field451 = in.readUnsignedByte();
		int var3 = in.readUnsignedByte();
		def.field458 = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4)
		{
			def.field458.add(this.loadType(in));
		}

		return def;
	}

	private WorldMapTypeBase loadType(InputStream var1)
	{
		int var2 = var1.readUnsignedByte();
		//      field397 = new class27(1, (byte)0);
		//      field390 = new class27(2, (byte)1);
		//      field399 = new class27(3, (byte)2);
		//      field393 = new class27(0, (byte)3);
		WorldMapTypeBase base;
		switch (var2)
		{
			case 0:
				// type 1
				base = load1(var1);
				break;
			case 1:
				// type 2
				base = load2(var1);
				break;
			case 2:
				// type 3
				base = load3(var1);
				break;
			case 3:
				// type 0
				base = load0(var1);
				break;
			default:
				throw new IllegalStateException();
		}
		return base;
	}

	private WorldMapTypeBase load0(InputStream in)
	{
		WorldMapType0 wm = new WorldMapType0();

		wm.field606 = in.readUnsignedByte();
		wm.field605 = in.readUnsignedByte();
		wm.field601 = in.readUnsignedShort();
		wm.field602 = in.readUnsignedByte();
		wm.field603 = in.readUnsignedShort();
		wm.field607 = in.readUnsignedByte();
		wm.field604 = in.readUnsignedShort();
		wm.field600 = in.readUnsignedByte();
		wm.field608 = in.readUnsignedShort();
		wm.field609 = in.readUnsignedByte();

		return wm;
	}

	private WorldMapTypeBase load1(InputStream in)
	{
		WorldMapType1 wm = new WorldMapType1();

		wm.field434 = in.readUnsignedByte();
		wm.field424 = in.readUnsignedByte();
		wm.field425 = in.readUnsignedShort();
		wm.field426 = in.readUnsignedShort();
		wm.field427 = in.readUnsignedShort();
		wm.field431 = in.readUnsignedShort();
		wm.field429 = in.readUnsignedShort();
		wm.field428 = in.readUnsignedShort();
		wm.field433 = in.readUnsignedShort();
		wm.field435 = in.readUnsignedShort();

		return wm;
	}

	private WorldMapTypeBase load2(InputStream in)
	{
		WorldMapType2 wm = new WorldMapType2();

		wm.field519 = in.readUnsignedByte();
		wm.field511 = in.readUnsignedByte();
		wm.field510 = in.readUnsignedShort();
		wm.field512 = in.readUnsignedShort();
		wm.field514 = in.readUnsignedShort();
		wm.field515 = in.readUnsignedShort();

		return wm;
	}

	private WorldMapTypeBase load3(InputStream in)
	{
		WorldMapType3 wm = new WorldMapType3();

		wm.field387 = in.readUnsignedByte();
		wm.field377 = in.readUnsignedByte();
		wm.field378 = in.readUnsignedShort();
		wm.field382 = in.readUnsignedByte();
		wm.field376 = in.readUnsignedByte();
		wm.field383 = in.readUnsignedShort();
		wm.field385 = in.readUnsignedByte();
		wm.field379 = in.readUnsignedByte();
		wm.field380 = in.readUnsignedShort();
		wm.field386 = in.readUnsignedByte();
		wm.field388 = in.readUnsignedByte();
		wm.field381 = in.readUnsignedShort();
		wm.field384 = in.readUnsignedByte();
		wm.field389 = in.readUnsignedByte();

		return wm;
	}
}
