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
package net.runelite.cache.definitions;

import lombok.Data;
import net.runelite.cache.region.Position;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class WorldMapCompositeDefinition
{
	public final Set<MapSquareDefinition> mapSquareDefinitions = new HashSet<>();
	public final Set<ZoneDefinition> zoneDefinitions = new HashSet<>();
	public final List<WorldMapElementDefinition> worldMapElementDefinitions = new ArrayList<>();

	public Position calculateWorldOffset(Position position)
	{
		int squareX = position.getX() / 64;
		int squareZ = position.getY() / 64;
		int zoneX = (position.getX() & 63) / 8;
		int zoneZ = (position.getY() & 63) / 8;
		Position offset = null;

		for (MapSquareDefinition mapSquare : mapSquareDefinitions)
		{
			if (squareX == mapSquare.displaySquareX && squareZ == mapSquare.displaySquareZ)
			{
				int shiftX = ((mapSquare.sourceSquareX - mapSquare.displaySquareX) * 64);
				int shiftZ = ((mapSquare.sourceSquareZ - mapSquare.displaySquareZ) * 64);
				offset = new Position(shiftX, shiftZ, mapSquare.getMinLevel());
			}
		}

		for (ZoneDefinition zone : zoneDefinitions)
		{
			if (squareX == zone.displaySquareX && squareZ == zone.displaySquareZ && zoneX == zone.displayZoneX && zoneZ == zone.displayZoneZ)
			{
				int shiftX = ((zone.sourceSquareX - zone.displaySquareX) * 64) + ((zone.sourceZoneX - zone.displayZoneX) * 8);
				int shiftZ = ((zone.sourceSquareZ - zone.displaySquareZ) * 64) + ((zone.sourceZoneZ - zone.displayZoneZ) * 8);
				offset = new Position(shiftX, shiftZ, zone.getMinLevel());
			}
		}

		return offset;
	}
}
