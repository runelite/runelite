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

import net.runelite.cache.definitions.WorldMapCompositeDefinition;
import net.runelite.cache.definitions.WorldMapElementDefinition;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.region.Position;

public class WorldMapCompositeLoader
{
	public WorldMapCompositeDefinition load(byte[] buffer)
	{
		WorldMapDataLoader worldMapDataLoader = new WorldMapDataLoader();
		WorldMapElementLoader worldMapElementLoader = new WorldMapElementLoader();

		WorldMapCompositeDefinition worldMapCompositeDefinition = new WorldMapCompositeDefinition();
		InputStream in = new InputStream(buffer);

		int worldData0Count = in.readUnsignedShort();
		for (int i = 0; i < worldData0Count; ++i)
		{
			worldMapCompositeDefinition.mapSquareDefinitions.add(worldMapDataLoader.loadMapSquare(in));
		}

		int worldData1Amount = in.readUnsignedShort();
		for (int i = 0; i < worldData1Amount; ++i)
		{
			worldMapCompositeDefinition.zoneDefinitions.add(worldMapDataLoader.loadZone(in));
		}

		int iconAmount = in.readUnsignedShort();
		for (int i = 0; i < iconAmount; ++i)
		{
			worldMapCompositeDefinition.worldMapElementDefinitions.add(worldMapElementLoader.load(in));
		}

		// The graphics in the world map are patched together from parts of the map and the position of
		// the map elements are based on the result of that. This calculates the offset needed to place the element back
		// into world coordinates.
		for (WorldMapElementDefinition element : worldMapCompositeDefinition.worldMapElementDefinitions)
		{
			Position position = element.getPosition();
			element.setOffset(worldMapCompositeDefinition.calculateWorldOffset(position));
		}

		return worldMapCompositeDefinition;
	}
}
