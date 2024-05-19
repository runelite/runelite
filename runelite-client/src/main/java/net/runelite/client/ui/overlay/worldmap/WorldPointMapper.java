/*
 * Copyright (c) 2024, Zoinkwiz <https://github.com/Zoinkwiz>
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
package net.runelite.client.ui.overlay.worldmap;

import java.util.Arrays;
import net.runelite.api.coords.WorldPoint;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorldPointMapper
{
	private static final Map<Integer, List<WorldMapPointMapping>> PROCESSED_MAPPINGS = new HashMap<>();

	static
	{
		for (WorldMapPointMapping mapping : WorldMapPointMapping.values())
		{
			if (mapping.isMirror())
			{
				continue;
			}
			for (int x = mapping.getMinRegionXMap(); x <= mapping.getMaxRegionXMap(); x++)
			{
				for (int y = mapping.getMinRegionYMap(); y <= mapping.getMaxRegionYMap(); y++)
				{
					int mapRegionID = (x << 8) | y;
					PROCESSED_MAPPINGS.computeIfAbsent(mapRegionID, k -> new ArrayList<>()).add(mapping);
				}
			}
		}
	}

	/**
	 * Get all of the {@link WorldMapPointMapping}s for a certain region ID.
	 *
	 * @param regionId The region ID to get all associated mappings for.
	 * @return The list of WorldMapPointMappings for the region.
	 */
	public static List<WorldMapPointMapping> getMappingsInRegion(int regionId)
	{
		return PROCESSED_MAPPINGS.get(regionId);
	}

	public static int getWorldRegionIDFromMapRegionID(int worldRegionID, WorldMapPointMapping mapping)
	{
		if (!mapping.mapContainsRegion(worldRegionID)) return worldRegionID;
		// Work out relative shift of X and Y based on shift
		int x = worldRegionID >> 8;
		int y = worldRegionID & 0xFF;

		int xShift = x - mapping.getMinRegionXMap();
		int yShift = y - mapping.getMinRegionYMap();

		return (mapping.getMinRegionXWorld() + xShift) << 8 | (mapping.getMinRegionYWorld() + yShift);
	}

	/**
	 * Converts a real {@link WorldPoint} to its corresponding world map WorldPoint.
	 *
	 * @param realWorldPoint The real WorldPoint to be converted.
	 * @return The corresponding WorldPoint on the map and the Map Area it should appear in.
	 */
	public static WorldPointWithWorldMapArea getMapWorldPointFromRealWorldPoint(WorldPoint realWorldPoint)
	{
		return Arrays.stream(WorldMapPointMapping.values())
			.filter(mapping -> mapping.worldContainsWorldPoint(realWorldPoint))
			.findFirst()
			.map(mapping -> convertToMapWorldPointWithWorldMapArea(mapping, realWorldPoint))
			.orElse(new WorldPointWithWorldMapArea(realWorldPoint, WorldMapArea.ANY));
	}

	/**
	 * Converts a world map WorldPoint back to its corresponding real WorldPoint.
	 *
	 * @param mapWorldPoint The map WorldPoint to be converted.
	 * @param worldMapArea  The map area of the point.
	 * @return The corresponding real WorldPoint and its map area.
	 */
	public static WorldPointWithWorldMapArea getRealWorldPointFromMapPoint(WorldPoint mapWorldPoint, WorldMapArea worldMapArea)
	{
		return Arrays.stream(WorldMapPointMapping.values())
			.filter(mapping -> mapping.getArea() == worldMapArea || worldMapArea == WorldMapArea.ANY)
			.filter(mapping -> !mapping.isMirror())
			.filter(mapping -> mapping.mapContainsWorldPoint(mapWorldPoint))
			.findFirst()
			.map(mapping -> convertToRealWorldPointWithWorldMapArea(mapping, mapWorldPoint))
			.orElse(new WorldPointWithWorldMapArea(mapWorldPoint, WorldMapArea.ANY));
	}

	/**
	 * Converts the given mapping and real WorldPoint to a {@link WorldPointWithWorldMapArea}.
	 *
	 * @param mapping        The mapping to use for conversion.
	 * @param realWorldPoint The real WorldPoint to convert.
	 * @return A new {@link WorldPointWithWorldMapArea} object representing world map WorldPoint and WorldMapArea.
	 */
	private static WorldPointWithWorldMapArea convertToMapWorldPointWithWorldMapArea(WorldMapPointMapping mapping, WorldPoint realWorldPoint)
	{
		int shiftedX = realWorldPoint.getRegionX() + (mapping.getMinChunkXMap() - mapping.getMinChunkXWorld());
		int shiftedY = realWorldPoint.getRegionY() + (mapping.getMinChunkYMap() - mapping.getMinChunkYWorld());
		int x = realWorldPoint.getRegionID() >> 8;
		int y = realWorldPoint.getRegionID() & 0xFF;
		int shiftedRegionX = mapping.getMinRegionXMap() + (x - mapping.getMinRegionXWorld());
		int shiftedRegionY = mapping.getMinRegionYMap() + (y - mapping.getMinRegionYWorld());
		int shiftedRegionId = (shiftedRegionX << 8) | shiftedRegionY;
		WorldPoint mappedPoint = WorldPoint.fromRegion(shiftedRegionId,
			shiftedX,
			shiftedY,
			realWorldPoint.getPlane());
		return new WorldPointWithWorldMapArea(mappedPoint, mapping.getArea());
	}

	/**
	 * Converts the given mapping and world map point to a {@link WorldPointWithWorldMapArea} representing the real WorldPoint.
	 *
	 * @param mapping       The mapping to use for conversion.
	 * @param mapWorldPoint The map point to convert back to a real WorldPoint.
	 * @return A new {@link WorldPointWithWorldMapArea} object representing the real WorldPoint.
	 */
	private static WorldPointWithWorldMapArea convertToRealWorldPointWithWorldMapArea(WorldMapPointMapping mapping, WorldPoint mapWorldPoint)
	{
		int shiftedX = mapWorldPoint.getRegionX() + (mapping.getMinChunkXWorld() - mapping.getMinChunkXMap());
		int shiftedY = mapWorldPoint.getRegionY() + (mapping.getMinChunkYWorld() - mapping.getMinChunkYMap());
		int x = mapWorldPoint.getRegionID() >> 8;
		int y = mapWorldPoint.getRegionID() & 0xFF;
		int shiftedRegionX = mapping.getMinRegionXWorld() + (x - mapping.getMinRegionXMap());
		int shiftedRegionY = mapping.getMinRegionYWorld() + (y - mapping.getMinRegionYMap());
		int shiftedRegionId = (shiftedRegionX << 8) | shiftedRegionY;
		WorldPoint mappedPoint = WorldPoint.fromRegion(shiftedRegionId,
			shiftedX,
			shiftedY,
			mapping.getPlane());
		return new WorldPointWithWorldMapArea(mappedPoint, mapping.getArea());
	}
}
