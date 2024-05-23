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
	public WorldMapDefinition load(byte[] b, int fileId)
	{
		WorldMapDefinition def = new WorldMapDefinition();
		InputStream in = new InputStream(b);

		def.fileId = fileId;
		def.safeName = in.readString();
		def.name = in.readString();

		int packedPos = in.readInt();
		def.position = Position.fromPacked(packedPos);

		def.emptyTileColor = in.readInt();
		def.backgroundColor = in.readInt();
		in.readUnsignedByte();
		def.isSurface = in.readUnsignedByte() == 1;
		def.defaultZoom = in.readUnsignedByte();
		int var3 = in.readUnsignedByte();
		def.regionList = new LinkedList<>();

		for (int var4 = 0; var4 < var3; ++var4)
		{
			def.regionList.add(this.loadType(in));
		}

		return def;
	}

	private WorldMapTypeBase loadType(InputStream var1)
	{
		int var2 = var1.readUnsignedByte();
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

		wm.plane = in.readUnsignedByte();
		wm.numberOfPlanes = in.readUnsignedByte();
		wm.xLow = in.readUnsignedShort();
		wm.chunk_xLow = in.readUnsignedByte();
		wm.yLow = in.readUnsignedShort();
		wm.chunk_yLow = in.readUnsignedByte();
		wm.xHigh = in.readUnsignedShort();
		wm.chunk_xHigh = in.readUnsignedByte();
		wm.yHigh = in.readUnsignedShort();
		wm.chunk_yHigh = in.readUnsignedByte();

		return wm;
	}

	private WorldMapTypeBase load1(InputStream in)
	{
		WorldMapType1 wm = new WorldMapType1();

		wm.plane = in.readUnsignedByte();
		wm.numberOfPlanes = in.readUnsignedByte();
		wm.xLowerLeft = in.readUnsignedShort();
		wm.yLowerLeft = in.readUnsignedShort();
		wm.xLowerRight = in.readUnsignedShort();
		wm.yUpperLeft = in.readUnsignedShort();
		wm.xUpperLeft = in.readUnsignedShort();
		wm.yLowerRight = in.readUnsignedShort();
		wm.xUpperRight = in.readUnsignedShort();
		wm.yUpperRight = in.readUnsignedShort();

		return wm;
	}

	private WorldMapTypeBase load2(InputStream in)
	{
		WorldMapType2 wm = new WorldMapType2();

		wm.plane = in.readUnsignedByte();
		wm.numberOfPlanes = in.readUnsignedByte();
		wm.xLow = in.readUnsignedShort();
		wm.yLow = in.readUnsignedShort();
		wm.xHigh = in.readUnsignedShort();
		wm.yHigh = in.readUnsignedShort();

		return wm;
	}

	private WorldMapTypeBase load3(InputStream in)
	{
		WorldMapType3 wm = new WorldMapType3();

		wm.oldPlane = in.readUnsignedByte();
		wm.numberOfPlanes = in.readUnsignedByte();
		wm.oldX = in.readUnsignedShort();
		wm.chunk_oldXLow = in.readUnsignedByte();
		wm.chunk_oldXHigh = in.readUnsignedByte();
		wm.oldY = in.readUnsignedShort();
		wm.chunk_oldYLow = in.readUnsignedByte();
		wm.chunk_oldYHigh = in.readUnsignedByte();
		wm.newX = in.readUnsignedShort();
		wm.chunk_newXLow = in.readUnsignedByte();
		wm.chunk_newXHigh = in.readUnsignedByte();
		wm.newY = in.readUnsignedShort();
		wm.chunk_newYLow = in.readUnsignedByte();
		wm.chunk_newYHigh = in.readUnsignedByte();

		return wm;
	}
}
