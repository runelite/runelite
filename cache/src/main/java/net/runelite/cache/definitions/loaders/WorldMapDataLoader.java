/*
 * Copyright (c) 2024, Christopher Brown <christoabrown@gmail.com>
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

import net.runelite.cache.definitions.MapSquareDefinition;
import net.runelite.cache.definitions.ZoneDefinition;
import net.runelite.cache.io.InputStream;

public class WorldMapDataLoader
{
	public MapSquareDefinition loadMapSquare(InputStream in)
	{
		int worldMapDataType = in.readUnsignedByte();

		if (worldMapDataType != 0)
		{
			throw new RuntimeException("Expected worldMapDataType 0 got " + worldMapDataType);
		}

		MapSquareDefinition mapSquareDefinition = new MapSquareDefinition();
		mapSquareDefinition.minLevel = in.readUnsignedByte();
		mapSquareDefinition.levels = in.readUnsignedByte();
		mapSquareDefinition.displaySquareX = in.readUnsignedShort();
		mapSquareDefinition.displaySquareZ = in.readUnsignedShort();
		mapSquareDefinition.sourceSquareX = in.readUnsignedShort();
		mapSquareDefinition.sourceSquareZ = in.readUnsignedShort();
		mapSquareDefinition.groupId = in.readBigSmart2();
		mapSquareDefinition.fileId = in.readBigSmart2();

		return mapSquareDefinition;
	}

	public ZoneDefinition loadZone(InputStream in)
	{
		int worldMapDataType = in.readUnsignedByte();

		if (worldMapDataType != 1)
		{
			throw new RuntimeException("Expected worldMapDataType 1 got " + worldMapDataType);
		}

		ZoneDefinition zoneDefinition = new ZoneDefinition();
		zoneDefinition.minLevel = in.readUnsignedByte();
		zoneDefinition.levels = in.readUnsignedByte();
		zoneDefinition.displaySquareX = in.readUnsignedShort();
		zoneDefinition.displaySquareZ = in.readUnsignedShort();
		zoneDefinition.displayZoneX = in.readUnsignedByte();
		zoneDefinition.displayZoneY = in.readUnsignedByte();
		zoneDefinition.sourceSquareX = in.readUnsignedShort();
		zoneDefinition.sourceSquareZ = in.readUnsignedShort();
		zoneDefinition.sourceZoneX = in.readUnsignedByte();
		zoneDefinition.sourceZoneZ = in.readUnsignedByte();
		zoneDefinition.groupId = in.readBigSmart2();
		zoneDefinition.fileId = in.readBigSmart2();

		return zoneDefinition;
	}
}
