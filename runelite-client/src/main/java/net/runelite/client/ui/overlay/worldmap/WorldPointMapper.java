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

public class WorldPointMapper
{
	/**
	 * Converts a real {@link WorldPoint} to its corresponding world map WorldPoint.
	 *
	 * @param realWorldPoint The real WorldPoint to be converted.
	 * @return The corresponding WorldPoint on the map and the Map Area it should appear in.
	 */
	public static WorldPointWithWorldMapArea getMapWorldPointFromRealWorldPoint(WorldPoint realWorldPoint)
	{
		return Arrays.stream(WorldMapPointMapping.values())
			.filter(mapping -> mapping.getWorldChunkID() == realWorldPoint.getRegionID())
			.filter(mapping -> isRealWorldPointInMappingArea(mapping, realWorldPoint))
			.findFirst()
			.map(mapping -> convertToMapWorldPointWithWorldMapArea(mapping, realWorldPoint))
			.orElse(new WorldPointWithWorldMapArea(realWorldPoint, WorldMapArea.ANY));
	}

	/**
	 * Converts a world map WorldPoint back to its corresponding real WorldPoint.
	 *
	 * @param mapWorldPoint The map WorldPoint to be converted.
	 * @param worldMapArea The map area of the point.
	 * @return The corresponding real WorldPoint and its map area.
	 */
	public static WorldPointWithWorldMapArea getRealWorldPointFromMapPoint(WorldPoint mapWorldPoint, WorldMapArea worldMapArea)
	{
		return Arrays.stream(WorldMapPointMapping.values())
			.filter(mapping -> mapping.getArea() == worldMapArea || worldMapArea == WorldMapArea.ANY)
			.filter(mapping -> !mapping.isMirror())
			.filter(mapping -> isWorldMapPointInMappingArea(mapping, mapWorldPoint))
			.findFirst()
			.map(mapping -> convertToRealWorldPointWithWorldMapArea(mapping, mapWorldPoint))
			.orElse(new WorldPointWithWorldMapArea(mapWorldPoint, WorldMapArea.ANY));
	}

	/**
	 * Checks if a given mapping applies to the specified real {@link WorldPoint}.
	 *
	 * @param mapping        The world map mapping to check.
	 * @param realWorldPoint The real WorldPoint to be checked against the mapping.
	 * @return {@code true} if the mapping applies to the real WorldPoint; {@code false} otherwise.
	 */
	private static boolean isRealWorldPointInMappingArea(WorldMapPointMapping mapping, WorldPoint realWorldPoint)
	{
		if (mapping.getPlane() != -1 && mapping.getPlane() != realWorldPoint.getPlane())
		{
			return false;
		}

		return isInMappingArea(mapping, realWorldPoint);
	}

	/**
	 * Checks if a given mapping applies to the specified world map {@link WorldPoint}.
	 *
	 * @param mapping      The mapping to check.
	 * @param mapWorldPoint The map point to be checked against the mapping.
	 * @return {@code true} if the mapping matches the map point; {@code false} otherwise.
	 */
	private static boolean isWorldMapPointInMappingArea(WorldMapPointMapping mapping, WorldPoint mapWorldPoint)
	{
		int shiftedWorldX = mapWorldPoint.getX() - mapping.getShiftX();
		int shiftedWorldY = mapWorldPoint.getY() - mapping.getShiftY();
		WorldPoint shiftedWorldPoint = new WorldPoint(shiftedWorldX, shiftedWorldY, mapWorldPoint.getPlane());

		if (shiftedWorldPoint.getRegionID() != mapping.getMapChunkID())
		{
			return false;
		}

		return isInMappingArea(mapping, shiftedWorldPoint);
	}

	private static boolean isInMappingArea(WorldMapPointMapping mapping, WorldPoint worldPoint)
	{
		return worldPoint.getRegionX() >= mapping.getMinX() && worldPoint.getRegionX() < mapping.getMaxX() &&
			worldPoint.getRegionY() >= mapping.getMinY() && worldPoint.getRegionY() < mapping.getMaxY();
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
		WorldPoint mappedPoint = WorldPoint.fromRegion(mapping.getMapChunkID(),
			realWorldPoint.getRegionX() + mapping.getShiftX(),
			realWorldPoint.getRegionY() + mapping.getShiftY(),
			realWorldPoint.getPlane());
		return new WorldPointWithWorldMapArea(mappedPoint, mapping.getArea());
	}

	/**
	 * Converts the given mapping and world map point to a {@link WorldPointWithWorldMapArea} representing the real WorldPoint.
	 *
	 * @param mapping      The mapping to use for conversion.
	 * @param mapWorldPoint The map point to convert back to a real WorldPoint.
	 * @return A new {@link WorldPointWithWorldMapArea} object representing the real WorldPoint.
	 */
	private static WorldPointWithWorldMapArea convertToRealWorldPointWithWorldMapArea(WorldMapPointMapping mapping, WorldPoint mapWorldPoint)
	{
		int shiftedWorldX = mapWorldPoint.getX() - mapping.getShiftX();
		int shiftedWorldY = mapWorldPoint.getY() - mapping.getShiftY();
		WorldPoint shiftedWorldPoint = new WorldPoint(shiftedWorldX, shiftedWorldY, mapWorldPoint.getPlane());
		WorldPoint realWorldPoint = WorldPoint.fromRegion(mapping.getWorldChunkID(), shiftedWorldPoint.getRegionX(), shiftedWorldPoint.getRegionY(), mapping.getPlane());

		return new WorldPointWithWorldMapArea(realWorldPoint, mapping.getArea());
	}
}
