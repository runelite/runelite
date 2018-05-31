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
import net.runelite.api.ObjectID;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.WorldPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TelekineticPuzzle
{
	private TelekineticTile[][] telekineticTiles;
	@Getter
	private List<TelekineticTile> playerPredictedTiles;
	@Getter
	private List<TelekineticTile> puzzleShortestPath;

	public static TelekineticPuzzle findTelekineticPuzzle(WorldPoint startPoint, WorldPoint endPoint, Tile[][] tiles)
	{
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		//Find south western most corner of walls to be the origin of the puzzle array
		for (Tile[] row : tiles)
		{
			for (Tile tile : row)
			{
				if (tile != null && tile.getWallObject() != null)
				{
					WallObject wallObject = tile.getWallObject();
					if (wallObject.getId() == ObjectID.TELEKINETIC_ROOM_WALL)
					{
						Point regionPoint = tile.getRegionLocation();
						if (regionPoint.getX() < minX && regionPoint.getX() < minY)
						{
							minX = regionPoint.getX();
							minY = regionPoint.getY();
						}
					}
				}
			}
		}

		TelekineticTile[][] telekineticTiles = new TelekineticTile[12][12];

		TelekineticTile startTile = null;
		TelekineticTile endTile = null;

		for (int x = 0; x < 12; x++)
		{
			for (int y = 0; y < 12; y++)
			{
				Tile tile = tiles[minX + x][minY + y];
				WallObject wallObject = tile.getWallObject();

				TelekineticTile telekineticTile;

				if (wallObject != null)
				{
					telekineticTile = new TelekineticTile(wallObject.getOrientationA(), wallObject.getOrientationB(), x, y, tile);

				}

				else
				{
					telekineticTile = new TelekineticTile(-1, -1, x, y, tile);
				}

				if (telekineticTile.getTile().getWorldLocation().equals(startPoint))
				{
					startTile = telekineticTile;
				}

				if (telekineticTile.getTile().getWorldLocation().equals(endPoint))
				{
					endTile = telekineticTile;
				}

				telekineticTiles[x][y] = telekineticTile;
			}
		}
		if (endTile == null || startTile == null)
		{
			return null;
		}

		return new TelekineticPuzzle(startTile, endTile, telekineticTiles);
	}

	public TelekineticPuzzle(TelekineticTile startTile, TelekineticTile endTile, TelekineticTile[][] tiles)
	{
		this.telekineticTiles = tiles;
		this.puzzleShortestPath = solve(startTile, endTile, telekineticTiles);
		this.playerPredictedTiles = findPlayerPredictedTiles(puzzleShortestPath, telekineticTiles);
	}

	private List<TelekineticTile> solve(TelekineticTile startTile, TelekineticTile endTile, TelekineticTile[][] tiles)
	{
		Set<TelekineticTile> visited = new HashSet<TelekineticTile>();
		Queue<TelekineticTile> queue = new LinkedList<TelekineticTile>();
		Map<TelekineticTile, TelekineticTile> parentNodes = new HashMap<TelekineticTile, TelekineticTile>();
		queue.add(startTile);
		visited.add(startTile);

		while (queue.size() > 0)
		{
			TelekineticTile current = queue.remove();
			List<TelekineticTile> neighbors = current.getNeighbors(tiles);
			for (TelekineticTile neighbor : neighbors)
			{
				if (!visited.contains(neighbor))
				{
					queue.add(neighbor);
					visited.add(neighbor);
					parentNodes.put(neighbor, current);
				}
			}
		}

		List<TelekineticTile> shortestPath = new ArrayList<TelekineticTile>();
		TelekineticTile current = endTile;
		while (current != null)
		{
			shortestPath.add(current);
			current = parentNodes.get(current);
		}

		Collections.reverse(shortestPath);
		return shortestPath;

	}

	//Project a point onto the edge needed to pull the guardian in the direction (guardianNext-guardianStart)
	private TelekineticTile getNearestEdge(TelekineticTile guardianStart, TelekineticTile guardianNext, TelekineticTile playerStartTile)
	{
		int dx = guardianNext.getX() - guardianStart.getX();
		int dy = guardianNext.getY() - guardianStart.getY();

		//Make sure that the player never ends up on a corner by subtracting/adding to avoid corners
		int finalY = playerStartTile.getY();
		int finalX = playerStartTile.getX();
		if (finalX == 0)
		{
			finalX++;
		}

		else if (finalX == 11)
		{
			finalX--;
		}

		if (finalY == 0)
		{
			finalY++;
		}

		else if (finalY == 11)
		{
			finalY--;
		}

		if (dx > 0)
		{
			return telekineticTiles[11][finalY];
		}

		else if (dx < 0)
		{
			return telekineticTiles[0][finalY];
		}

		else if (dy > 0)
		{
			return telekineticTiles[finalX][11];
		}

		else if (dy < 0)
		{
			return telekineticTiles[finalX][0];
		}

		else
		{
			return telekineticTiles[finalX][finalY];
		}
	}

	private int tileDistanceToNext(TelekineticTile playerStartTile, TelekineticTile playerEndTile)
	{
		int distance = 0;
		int x = playerStartTile.getX();
		int y = playerStartTile.getY();

		//Travel along only 1 axis at a time to get to the goal
		//adding distance along the way. Doesn't matter if the path would actually go through the puzzle as the distance will be the same
		//whether the path is actually along the edge of the puzzle or not
		int differenceX = playerEndTile.getX() - x;
		distance += Math.abs(differenceX);

		int differenceY = playerEndTile.getY() - y;
		distance += Math.abs(differenceY);
		return distance;
	}

	private List<TelekineticTile> findPlayerPredictedTiles(List<TelekineticTile> puzzleShortestPath, TelekineticTile[][] telekineticTiles)
	{
		List<TelekineticTile> predictedTiles = new ArrayList<TelekineticTile>();

		predictedTiles.add(getNearestEdge(puzzleShortestPath.get(0), puzzleShortestPath.get(1), puzzleShortestPath.get(0)));

		for (int i = 1; i < puzzleShortestPath.size() - 1; i++)
		{
			TelekineticTile previous = predictedTiles.get(i - 1);
			//The closest tile we need to stand on to be on the correct edge. This would work fine as a target point, but sometimes you end up waiting there for the guardian to stop moving
			//So we can do better by moving projected towards the next position
			TelekineticTile projected = getNearestEdge(puzzleShortestPath.get(i), puzzleShortestPath.get(i + 1), previous);

			TelekineticTile predictedTile = projected;

			if (i < puzzleShortestPath.size() - 2)
			{
				int distancePlayer = tileDistanceToNext(previous, projected);

				int guardianDx = puzzleShortestPath.get(i).getX() - puzzleShortestPath.get(i - 1).getX();
				int guardianDy = puzzleShortestPath.get(i).getY() - puzzleShortestPath.get(i - 1).getY();
				int ticksToTravelGuardian = Math.max(Math.abs(guardianDx), Math.abs(guardianDy));//Only moves at 1 tile per tick
				int ticksToTravelPlayer = (int) Math.ceil(distancePlayer / 2.0);//Assuming running

				//How much time we have left to keep running towards our next tile while waiting for the guardian to stop moving
				int ticksLeft = Math.max((ticksToTravelGuardian - ticksToTravelPlayer) - 1, 0);//subtract 1 because the guardian moves 1 tick before you are able to

				if (ticksLeft > 0)
				{
					TelekineticTile projectedFuture = getNearestEdge(puzzleShortestPath.get(i + 1), puzzleShortestPath.get(i + 2), previous);
					TelekineticTile closestAlongEdge = getNearestEdge(puzzleShortestPath.get(i), puzzleShortestPath.get(i + 1), projectedFuture);

					int dx = closestAlongEdge.getX() - projected.getX();
					int dy = closestAlongEdge.getY() - projected.getY();


					int movementLengthX = ticksLeft * 2;
					int movementLengthY = ticksLeft * 2;

					//Don't travel past closestAlongEdge
					if (Math.abs(movementLengthX) > Math.abs(dx))
					{
						movementLengthX = Math.abs(dx);
					}

					if (Math.abs(movementLengthY) > Math.abs(dy))
					{
						movementLengthY = Math.abs(dy);
					}

					//Move as far as we can while waiting for the guardian to stop moving
					int movementX = (int) Math.signum(dx) * movementLengthX;
					int movementY = (int) Math.signum(dy) * movementLengthY;

					int finalPredictedX = projected.getX() + movementX;
					int finalPredictedY = projected.getY() + movementY;

					predictedTile = telekineticTiles[finalPredictedX][finalPredictedY];
				}
			}

			predictedTiles.add(predictedTile);
		}
		return predictedTiles;
	}
}
