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
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.GroundObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.WallObject;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.queries.GroundObjectQuery;

public class Maze
{
	private static final int TELEKINETIC_FINISH = NullObjectID.NULL_23672;

	private final Client client;
	@Getter
	private final int[][] flags;
	@Getter
	private final WorldPoint finish;
	@Getter
	private final int walls;
	@Getter
	private Rectangle bounds;

	private Maze(Client client, int[][] flags, int walls, WorldPoint finish, Rectangle bounds)
	{
		this.flags = flags;
		this.client = client;
		this.walls = walls;
		this.finish = finish;
		this.bounds = bounds;
	}

	public static Maze build(Client client, WallObject[] walls)
	{
		int[][] flags = client.getCollisionMaps()[client.getPlane()].getFlags();

		GroundObjectQuery gqry = new GroundObjectQuery()
			.idEquals(TELEKINETIC_FINISH);
		GroundObject[] groundObjects = gqry.result(client);
		if (groundObjects.length == 0)
		{
			return null;
		}

		WorldPoint finish = groundObjects[0].getWorldLocation();

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (WallObject wall : walls)
		{
			WorldPoint point = wall.getWorldLocation();
			minX = Math.min(minX, point.getX());
			minY = Math.min(minY, point.getY());

			maxX = Math.max(maxX, point.getX());
			maxY = Math.max(maxY, point.getY());
		}

		Rectangle bounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);

		return new Maze(client, flags, walls.length, finish, bounds);
	}

	public int getFlag(int worldX, int worldY)
	{
		return this.flags[worldX - client.getBaseX()][worldY - client.getBaseY()];
	}

	public MazeState getState(MazeState current, NPC guardian)
	{
		if (current == null)
		{
			return new MazeState(this, guardian.getWorldLocation());
		}

		if (guardian.getId() == NpcID.MAZE_GUARDIAN_MOVING && !getDestination(guardian).equals(current.getCurrent()))
		{
			return new MazeState(this, getDestination(guardian));
		}

		if (guardian.getId() == NpcID.MAZE_GUARDIAN && !guardian.getWorldLocation().equals(current.getCurrent()))
		{
			return new MazeState(this, guardian.getWorldLocation());
		}

		return current;
	}


	public Direction getMyDirection()
	{
		WorldPoint mine = client.getLocalPlayer().getWorldLocation();

		if (mine.getY() >= bounds.getMaxY() && mine.getX() < bounds.getMaxX() && mine.getX() > bounds.getX())
		{
			return Direction.NORTH;
		}
		else if (mine.getY() <= bounds.getY() && mine.getX() < bounds.getMaxX() && mine.getX() > bounds.getX())
		{
			return Direction.SOUTH;
		}
		else if (mine.getX() >= bounds.getMaxX() && mine.getY() < bounds.getMaxY() && mine.getY() > bounds.getY())
		{
			return Direction.EAST;
		}
		else if (mine.getX() <= bounds.getX() && mine.getY() < bounds.getMaxY() && mine.getY() > bounds.getY())
		{
			return Direction.WEST;
		}

		return null;
	}

	private WorldPoint getDestination(NPC guardian)
	{
		Angle angle = new Angle(guardian.getOrientation());
		Direction facing = angle.getNearestDirection();
		return neighbour(guardian.getWorldLocation(), facing);
	}

	protected WorldPoint neighbour(WorldPoint point, Direction direction)
	{
		if (point == null)
		{
			return null;
		}

		int dx = 0, dy = 0;

		switch (direction)
		{
			case NORTH:
				dx = 0;
				dy = 1;
				break;
			case SOUTH:
				dx = 0;
				dy = -1;
				break;
			case EAST:
				dx = 1;
				dy = 0;
				break;
			case WEST:
				dx = -1;
				dy = 0;
				break;
		}

		int x = point.getX();
		int y = point.getY();
		int current = getFlag(x, y);
		int next = getFlag(x + dx, y + dy);

		while (!isBlocked(current, next, direction))
		{
			x += dx;
			y += dy;
			current = next;
			next = getFlag(x + dx, y + dy);
		}

		return new WorldPoint(x, y, 0);
	}

	private boolean isBlocked(int from, int to, Direction direction)
	{
		boolean blocked = checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_FLOOR)
			|| checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_OBJECT);

		if (blocked)
		{
			return true;
		}
		switch (direction)
		{
			case NORTH:
				return checkFlag(from, CollisionDataFlag.BLOCK_MOVEMENT_NORTH)
					|| checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH);
			case SOUTH:
				return checkFlag(from, CollisionDataFlag.BLOCK_MOVEMENT_SOUTH)
					|| checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_NORTH);
			case EAST:
				return checkFlag(from, CollisionDataFlag.BLOCK_MOVEMENT_EAST)
					|| checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_WEST);
			case WEST:
				return checkFlag(from, CollisionDataFlag.BLOCK_MOVEMENT_WEST)
					|| checkFlag(to, CollisionDataFlag.BLOCK_MOVEMENT_EAST);
		}

		return false;
	}

	private boolean checkFlag(int flag, int mask)
	{
		return (flag & mask) == mask;
	}
}
