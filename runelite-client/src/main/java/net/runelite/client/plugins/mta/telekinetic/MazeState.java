/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
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
package net.runelite.client.plugins.mta.telekinetic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

public class MazeState
{
	private final Maze maze;
	@Getter
	private final WorldPoint current;
	@Getter
	private final List<WorldPoint> solution;

	public MazeState(Maze maze, WorldPoint current)
	{
		this.maze = maze;
		this.current = current;
		this.solution = solve();
	}

	private MazeState(Maze maze, WorldPoint current, List<WorldPoint> solution)
	{
		this.maze = maze;
		this.current = current;
		this.solution = solution;
	}

	public MazeState next()
	{
		List<WorldPoint> nextSolution = new ArrayList<>(solution);
		WorldPoint next = getMove(0);
		nextSolution.remove(next);
		return new MazeState(maze, next, nextSolution);
	}

	public WorldPoint getMove(int move)
	{
		return solution.get(solution.size() - (1 + move));
	}

	public int moves()
	{
		return solution.size();
	}

	private List<WorldPoint> solve()
	{
		WorldPoint finish = maze.getFinish();

		Queue<WorldPoint> visit = new LinkedList<>();
		Set<WorldPoint> closed = new HashSet<>();
		HashMap<WorldPoint, Integer> scores = new HashMap<>();
		HashMap<WorldPoint, WorldPoint> edges = new HashMap<>();
		scores.put(current, 0);
		visit.add(current);

		while (!visit.isEmpty())
		{
			WorldPoint next = visit.poll();
			closed.add(next);

			WorldPoint[] neighbours = neighbours(next);

			for (WorldPoint neighbour : neighbours)
			{
				if (neighbour == null)
				{
					continue;
				}

				if (!neighbour.equals(next)
					&& !closed.contains(neighbour))
				{
					int score = scores.get(next) + 1;

					if (!scores.containsKey(neighbour) || scores.get(neighbour) > score)
					{
						scores.put(neighbour, score);
						edges.put(neighbour, next);
						visit.add(neighbour);
					}
				}
			}
		}

		ArrayList<WorldPoint> result = new ArrayList<>();
		WorldPoint current = finish;
		while (edges.containsKey(current))
		{
			result.add(current);
			current = edges.get(current);
		}

		return result;
	}

	private WorldArea getIndicatorLine(Direction direction)
	{
		Rectangle bounds = maze.getBounds();
		switch (direction)
		{
			case NORTH:
				return new WorldArea(bounds.x + 1, (int) bounds.getMaxY(), bounds.width - 1, 1, 0);
			case SOUTH:
				return new WorldArea(bounds.x + 1, bounds.y, bounds.width - 1, 1, 0);
			case WEST:
				return new WorldArea(bounds.x, bounds.y + 1, 1, bounds.height - 1, 0);
			case EAST:
				return new WorldArea((int) bounds.getMaxX(), bounds.y + 1, 1, bounds.height - 1, 0);
		}

		return null;
	}

	public boolean validate()
	{
		return between(getCurrent(), getMove(0)) == maze.getMyDirection();
	}

	public WorldPoint optimal(WorldPoint current)
	{
		WorldPoint nextPoint = getMove(0);
		Direction next = between(getCurrent(), nextPoint);
		WorldArea areaNext = getIndicatorLine(next);
		WorldPoint nearestNext = nearest(areaNext, current);

		if (moves() == 1)
		{
			return nearestNext;
		}

		Direction after = between(nextPoint, getMove(1));
		WorldArea areaAfter = getIndicatorLine(after);
		WorldPoint nearestAfter = nearest(areaAfter, nearestNext);

		return nearest(areaNext, nearestAfter);
	}

	private Direction between(WorldPoint from, WorldPoint to)
	{
		if (to.getX() > from.getX())
		{
			return Direction.EAST;
		}
		else if (to.getY() > from.getY())
		{
			return Direction.NORTH;
		}
		else if (to.getY() < from.getY())
		{
			return Direction.SOUTH;
		}

		return Direction.WEST;

	}

	private int manhattan(WorldPoint point1, WorldPoint point2)
	{
		return Math.abs(point1.getX() - point2.getX()) + Math.abs(point2.getY() - point1.getY());
	}

	private WorldPoint nearest(WorldArea area, WorldPoint worldPoint)
	{
		int dist = Integer.MAX_VALUE;
		WorldPoint nearest = null;

		for (WorldPoint areaPoint : area.toWorldPointList())
		{
			int currDist = manhattan(areaPoint, worldPoint);
			if (nearest == null || dist > currDist)
			{
				nearest = areaPoint;
				dist = currDist;
			}
		}

		return nearest;
	}

	private WorldPoint[] neighbours(WorldPoint point)
	{
		return new WorldPoint[]
			{
				maze.neighbour(point, Direction.NORTH), maze.neighbour(point, Direction.SOUTH),
				maze.neighbour(point, Direction.EAST), maze.neighbour(point, Direction.WEST)
			};
	}

}
