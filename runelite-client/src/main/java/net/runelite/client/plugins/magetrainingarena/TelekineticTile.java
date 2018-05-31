/*
 * Copyright (c) 2018, Toocanzs <https://github.com/Toocanzs>
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
package net.runelite.client.plugins.magetrainingarena;

import lombok.Getter;
import net.runelite.api.Tile;
import java.util.ArrayList;
import java.util.List;

public class TelekineticTile
{
	@Getter
	private boolean northWall;
	@Getter
	private boolean eastWall;
	@Getter
	private boolean westWall;
	@Getter
	private boolean southWall;
	@Getter
	private int x;
	@Getter
	private int y;

	@Getter
	private Tile tile;

	public TelekineticTile(int orientationA, int orinetationB, int x, int y, Tile tile)
	{
		northWall = orientationA == 2 || orinetationB == 2;
		eastWall = orientationA == 4 || orinetationB == 4;
		southWall = orientationA == 8 || orinetationB == 8;
		westWall = orientationA == 1 || orinetationB == 1;
		this.x = x;
		this.y = y;
		this.tile = tile;
	}

	private TelekineticTile findNorthNeighbor(TelekineticTile[] tiles)
	{
		int currentY = y;
		//Continue up as long as the above tile doesn't have a south wall
		while (currentY < tiles.length - 1)
		{
			TelekineticTile currentTile = tiles[currentY];
			TelekineticTile aboveTile = tiles[currentY + 1];
			if (aboveTile.southWall || currentTile.northWall)
			{
				break;
			}
			currentY++;
		}

		if (currentY != y)
		{
			return tiles[currentY];
		}

		return null;
	}

	private TelekineticTile findSouthNeighbor(TelekineticTile[] tiles)
	{
		int currentY = y;
		while (currentY > 0)
		{
			TelekineticTile currentTile = tiles[currentY];
			TelekineticTile belowTile = tiles[currentY - 1];
			if (belowTile.northWall || currentTile.southWall)
			{
				break;
			}
			currentY--;
		}

		if (currentY != y)
		{
			return tiles[currentY];
		}

		return null;
	}

	private TelekineticTile findEastNeighbor(TelekineticTile[][] tiles)
	{
		int currentX = x;
		while (currentX < tiles.length - 1)
		{
			TelekineticTile currentTile = tiles[currentX][y];
			TelekineticTile rightTile = tiles[currentX + 1][y];
			if (rightTile.westWall || currentTile.eastWall)
			{
				break;
			}
			currentX++;
		}

		if (currentX != x)
		{
			return tiles[currentX][y];
		}

		return null;
	}

	private TelekineticTile findWestNeighbor(TelekineticTile[][] tiles)
	{
		int currentX = x;
		while (currentX > 0)
		{
			TelekineticTile currentTile = tiles[currentX][y];
			TelekineticTile leftTile = tiles[currentX - 1][y];
			if (leftTile.eastWall || currentTile.westWall)
			{
				break;
			}
			currentX--;
		}

		if (currentX != x)
		{
			return tiles[currentX][y];
		}

		return null;
	}

	//These "neighbors" are not the actual next tile over. A "neighbor" is the tile which the guardian would end up if he traveled in that direction
	public List<TelekineticTile> getNeighbors(TelekineticTile[][] tiles)
	{
		List<TelekineticTile> neighbors = new ArrayList<TelekineticTile>();
		TelekineticTile northNeighbor = findNorthNeighbor(tiles[x]);
		TelekineticTile southNeighbor = findSouthNeighbor(tiles[x]);
		TelekineticTile eastNeighbor = findEastNeighbor(tiles);
		TelekineticTile westNeighbor = findWestNeighbor(tiles);

		if (northNeighbor != null)
		{
			neighbors.add(northNeighbor);
		}

		if (southNeighbor != null)
		{
			neighbors.add(southNeighbor);
		}

		if (eastNeighbor != null)
		{
			neighbors.add(eastNeighbor);
		}

		if (westNeighbor != null)
		{
			neighbors.add(westNeighbor);
		}

		return neighbors;
	}
}
