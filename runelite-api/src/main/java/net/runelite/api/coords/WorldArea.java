/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.api.coords;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.CollisionData;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.Constants;
import net.runelite.api.Point;
import net.runelite.api.Tile;

/**
 * Represents an area on the world.
 */
public class WorldArea
{
	/**
	 * The western most point of the area.
	 */
	@Getter
	private int x;

	/**
	 * The southern most point of the area.
	 */
	@Getter
	private int y;

	/**
	 * The width of the area.
	 */
	@Getter
	private int width;

	/**
	 * The height of the area.
	 */
	@Getter
	private int height;

	/**
	 * The plane the area is on.
	 */
	@Getter
	private int plane;

	public WorldArea(int x, int y, int width, int height, int plane)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.plane = plane;
	}

	public WorldArea(WorldPoint location, int width, int height)
	{
		this.x = location.getX();
		this.y = location.getY();
		this.plane = location.getPlane();
		this.width = width;
		this.height = height;
	}

	/**
	 * Computes the shortest distance to another area.
	 *
	 * @param other the passed area
	 * @return the distance along both x and y axis
	 */
	private Point getAxisDistances(WorldArea other)
	{
		Point p1 = this.getComparisonPoint(other);
		Point p2 = other.getComparisonPoint(this);
		return new Point(Math.abs(p1.getX() - p2.getX()), Math.abs(p1.getY() - p2.getY()));
	}

	/**
	 * Computes the shortest distance to another area.
	 *
	 * @param other the passed area
	 * @return the distance, or {@link Integer#MAX_VALUE} if the planes differ
	 */
	public int distanceTo(WorldArea other)
	{
		if (this.getPlane() != other.getPlane())
		{
			return Integer.MAX_VALUE;
		}

		Point distances = getAxisDistances(other);
		return Math.max(distances.getX(), distances.getY());
	}

	/**
	 * Computes the shortest distance to a world coordinate.
	 *
	 * @param other the passed coordinate
	 * @return the distance, or {@link Integer#MAX_VALUE} if the planes differ
	 */
	public int distanceTo(WorldPoint other)
	{
		return distanceTo(new WorldArea(other, 1, 1));
	}

	/**
	 * Checks whether this area is within melee distance of another.
	 * <p>
	 * Melee distance is exactly 1 tile, so this method computes and returns
	 * whether the shortest distance to the passed area is directly
	 * on the outside of this areas edge.
	 *
	 * @param other the other area
	 * @return true if in melee distance, false otherwise
	 */
	public boolean isInMeleeDistance(WorldArea other)
	{
		if (other == null || this.getPlane() != other.getPlane())
		{
			return false;
		}

		Point distances = getAxisDistances(other);
		return distances.getX() + distances.getY() == 1;
	}

	/**
	 * Checks whether a coordinate is within melee distance of this area.
	 *
	 * @param other the coordinate
	 * @return true if in melee distance, false otherwise
	 * @see #isInMeleeDistance(WorldArea)
	 */
	public boolean isInMeleeDistance(WorldPoint other)
	{
		return isInMeleeDistance(new WorldArea(other, 1, 1));
	}

	/**
	 * Checks whether this area intersects with another.
	 *
	 * @param other the other area
	 * @return true if the areas intersect, false otherwise
	 */
	public boolean intersectsWith(WorldArea other)
	{
		if (this.getPlane() != other.getPlane())
		{
			return false;
		}

		Point distances = getAxisDistances(other);
		return distances.getX() + distances.getY() == 0;
	}

	/**
	 * Determines if the area can travel in one of the 9 directions
	 * by using the standard collision detection algorithm.
	 * <p>
	 * Note that this method does not consider other actors as
	 * a collision, but most non-boss NPCs do check for collision
	 * with some actors. For actor collision checking, use the
	 * {@link #canTravelInDirection(Client, int, int, Predicate)} method.
	 *
	 * @param client the client to test in
	 * @param dx the x-axis direction to travel (-1, 0, or 1)
	 * @param dy the y-axis direction to travel (-1, 0, or 1)
	 * @return true if the area can travel in the specified direction
	 */
	public boolean canTravelInDirection(Client client, int dx, int dy)
	{
		return canTravelInDirection(client, dx, dy, x -> true);
	}

	/**
	 * Determines if the area can travel in one of the 9 directions
	 * by using the standard collision detection algorithm.
	 * <p>
	 * The passed x and y axis directions indicate the direction to
	 * travel in.
	 * <p>
	 * Note that this method does not normally consider other actors
	 * as a collision, but most non-boss NPCs do check for collision
	 * with some actors. However, using the {@code extraCondition} param
	 * it is possible to implement this check manually.
	 *
	 * @param client the client to test in
	 * @param dx the x-axis direction to travel (-1, 0, or 1)
	 * @param dy the y-axis direction to travel (-1, 0, or 1)
	 * @param extraCondition an additional condition to perform when checking valid tiles,
	 *                       such as performing a check for un-passable actors
	 * @return true if the area can travel in the specified direction
	 */
	public boolean canTravelInDirection(Client client, int dx, int dy,
										Predicate<? super WorldPoint> extraCondition)
	{
		dx = Integer.signum(dx);
		dy = Integer.signum(dy);

		if (dx == 0 && dy == 0)
		{
			return true;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, x, y);

		int startX = lp.getSceneX() + dx;
		int startY = lp.getSceneY() + dy;
		int checkX = startX + (dx > 0 ? width - 1 : 0);
		int checkY = startY + (dy > 0 ? height - 1 : 0);
		int endX = startX + width - 1;
		int endY = startY + height - 1;

		int xFlags = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int yFlags = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int xyFlags = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int xWallFlagsSouth = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int xWallFlagsNorth = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int yWallFlagsWest = CollisionDataFlag.BLOCK_MOVEMENT_FULL;
		int yWallFlagsEast = CollisionDataFlag.BLOCK_MOVEMENT_FULL;

		if (dx < 0)
		{
			xFlags |= CollisionDataFlag.BLOCK_MOVEMENT_EAST;
			xWallFlagsSouth |= CollisionDataFlag.BLOCK_MOVEMENT_SOUTH |
				CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST;
			xWallFlagsNorth |= CollisionDataFlag.BLOCK_MOVEMENT_NORTH |
				CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST;
		}
		if (dx > 0)
		{
			xFlags |= CollisionDataFlag.BLOCK_MOVEMENT_WEST;
			xWallFlagsSouth |= CollisionDataFlag.BLOCK_MOVEMENT_SOUTH |
				CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST;
			xWallFlagsNorth |= CollisionDataFlag.BLOCK_MOVEMENT_NORTH |
				CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST;
		}
		if (dy < 0)
		{
			yFlags |= CollisionDataFlag.BLOCK_MOVEMENT_NORTH;
			yWallFlagsWest |= CollisionDataFlag.BLOCK_MOVEMENT_WEST |
				CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST;
			yWallFlagsEast |= CollisionDataFlag.BLOCK_MOVEMENT_EAST |
				CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST;
		}
		if (dy > 0)
		{
			yFlags |= CollisionDataFlag.BLOCK_MOVEMENT_SOUTH;
			yWallFlagsWest |= CollisionDataFlag.BLOCK_MOVEMENT_WEST |
				CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST;
			yWallFlagsEast |= CollisionDataFlag.BLOCK_MOVEMENT_EAST |
				CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST;
		}
		if (dx < 0 && dy < 0)
		{
			xyFlags |= CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST;
		}
		if (dx < 0 && dy > 0)
		{
			xyFlags |= CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST;
		}
		if (dx > 0 && dy < 0)
		{
			xyFlags |= CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST;
		}
		if (dx > 0 && dy > 0)
		{
			xyFlags |= CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST;
		}

		CollisionData[] collisionData = client.getCollisionMaps();
		if (collisionData == null)
		{
			return false;
		}

		int[][] collisionDataFlags = collisionData[plane].getFlags();

		if (dx != 0)
		{
			// Check that the area doesn't bypass a wall
			for (int y = startY; y <= endY; y++)
			{
				if ((collisionDataFlags[checkX][y] & xFlags) != 0 ||
					!extraCondition.test(WorldPoint.fromScene(client, checkX, y, plane)))
				{
					// Collision while attempting to travel along the x axis
					return false;
				}
			}

			// Check that the new area tiles don't contain a wall
			for (int y = startY + 1; y <= endY; y++)
			{
				if ((collisionDataFlags[checkX][y] & xWallFlagsSouth) != 0)
				{
					// The new area tiles contains a wall
					return false;
				}
			}
			for (int y = endY - 1; y >= startY; y--)
			{
				if ((collisionDataFlags[checkX][y] & xWallFlagsNorth) != 0)
				{
					// The new area tiles contains a wall
					return false;
				}
			}
		}
		if (dy != 0)
		{
			// Check that the area tiles don't bypass a wall
			for (int x = startX; x <= endX; x++)
			{
				if ((collisionDataFlags[x][checkY] & yFlags) != 0 ||
					!extraCondition.test(WorldPoint.fromScene(client, x, checkY, client.getPlane())))
				{
					// Collision while attempting to travel along the y axis
					return false;
				}
			}

			// Check that the new area tiles don't contain a wall
			for (int x = startX + 1; x <= endX; x++)
			{
				if ((collisionDataFlags[x][checkY] & yWallFlagsWest) != 0)
				{
					// The new area tiles contains a wall
					return false;
				}
			}
			for (int x = endX - 1; x >= startX; x--)
			{
				if ((collisionDataFlags[x][checkY] & yWallFlagsEast) != 0)
				{
					// The new area tiles contains a wall
					return false;
				}
			}
		}
		if (dx != 0 && dy != 0)
		{
			if ((collisionDataFlags[checkX][checkY] & xyFlags) != 0 ||
				!extraCondition.test(WorldPoint.fromScene(client, checkX, checkY, client.getPlane())))
			{
				// Collision while attempting to travel diagonally
				return false;
			}

			// When the areas edge size is 1 and it attempts to travel
			// diagonally, a collision check is done for respective
			// x and y axis as well.
			if (width == 1)
			{
				if ((collisionDataFlags[checkX][checkY - dy] & xFlags) != 0 &&
					extraCondition.test(WorldPoint.fromScene(client, checkX, startY, client.getPlane())))
				{
					return false;
				}
			}
			if (height == 1)
			{
				if ((collisionDataFlags[checkX - dx][checkY] & yFlags) != 0 &&
					extraCondition.test(WorldPoint.fromScene(client, startX, checkY, client.getPlane())))
				{
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Gets the point within this area that is closest to another.
	 *
	 * @param other the other area
	 * @return the closest point to the passed area
	 */
	private Point getComparisonPoint(WorldArea other)
	{
		int x, y;
		if (other.x <= this.x)
		{
			x = this.x;
		}
		else if (other.x >= this.x + this.width - 1)
		{
			x = this.x + this.width - 1;
		}
		else
		{
			x = other.x;
		}
		if (other.y <= this.y)
		{
			y = this.y;
		}
		else if (other.y >= this.y + this.height - 1)
		{
			y = this.y + this.height - 1;
		}
		else
		{
			y = other.y;
		}
		return new Point(x, y);
	}

	/**
	 * Calculates the next area that will be occupied if this area attempts
	 * to move toward it by using the normal NPC travelling pattern.
	 *
	 * @param client the client to calculate with
	 * @param target the target area
	 * @param stopAtMeleeDistance whether to stop at melee distance to the target
	 * @return the next occupied area
	 */
	public WorldArea calculateNextTravellingPoint(Client client, WorldArea target,
		boolean stopAtMeleeDistance)
	{
		return calculateNextTravellingPoint(client, target, stopAtMeleeDistance, x -> true);
	}

	/**
	 * Calculates the next area that will be occupied if this area attempts
	 * to move toward it by using the normal NPC travelling pattern.
	 *
	 * @param client the client to calculate with
	 * @param target the target area
	 * @param stopAtMeleeDistance whether to stop at melee distance to the target
	 * @param extraCondition an additional condition to perform when checking valid tiles,
	 * 	                     such as performing a check for un-passable actors
	 * @return the next occupied area
	 */
	public WorldArea calculateNextTravellingPoint(Client client, WorldArea target,
		boolean stopAtMeleeDistance, Predicate<? super WorldPoint> extraCondition)
	{
		if (plane != target.getPlane())
		{
			return null;
		}

		if (this.intersectsWith(target))
		{
			if (stopAtMeleeDistance)
			{
				// Movement is unpredictable when the NPC and actor stand on top of each other
				return null;
			}
			else
			{
				return this;
			}
		}

		int dx = target.x - this.x;
		int dy = target.y - this.y;
		Point axisDistances = getAxisDistances(target);
		if (stopAtMeleeDistance && axisDistances.getX() + axisDistances.getY() == 1)
		{
			// NPC is in melee distance of target, so no movement is done
			return this;
		}

		LocalPoint lp = LocalPoint.fromWorld(client, x, y);
		if (lp == null ||
			lp.getSceneX() + dx < 0 || lp.getSceneX() + dy >= Constants.SCENE_SIZE ||
			lp.getSceneY() + dx < 0 || lp.getSceneY() + dy >= Constants.SCENE_SIZE)
		{
			// NPC is travelling out of the scene, so collision data isn't available
			return null;
		}

		int dxSig = Integer.signum(dx);
		int dySig = Integer.signum(dy);
		if (stopAtMeleeDistance && axisDistances.getX() == 1 && axisDistances.getY() == 1)
		{
			// When it needs to stop at melee distance, it will only attempt
			// to travel along the x axis when it is standing diagonally
			// from the target
			if (this.canTravelInDirection(client, dxSig, 0, extraCondition))
			{
				return new WorldArea(x + dxSig, y, width, height, plane);
			}
		}
		else
		{
			if (this.canTravelInDirection(client, dxSig, dySig, extraCondition))
			{
				return new WorldArea(x + dxSig, y + dySig, width, height, plane);
			}
			else if (dx != 0 && this.canTravelInDirection(client, dxSig, 0, extraCondition))
			{
				return new WorldArea(x + dxSig, y, width, height, plane);
			}
			else if (dy != 0 && Math.max(Math.abs(dx), Math.abs(dy)) > 1 &&
				this.canTravelInDirection(client, 0, dy, extraCondition))
			{
				// Note that NPCs don't attempts to travel along the y-axis
				// if the target is <= 1 tile distance away
				return new WorldArea(x, y + dySig, width, height, plane);
			}
		}

		// The NPC is stuck
		return this;
	}

	/**
	 * Determine if this WorldArea has line of sight to another WorldArea.
	 * <p>
	 * Note that the reverse isn't necessarily true, meaning this can return true
	 * while the other WorldArea does not have line of sight to this WorldArea.
	 *
	 * @param client The client to compare in
	 * @param other The other WorldArea to compare with
	 * @return Returns true if this WorldArea has line of sight to the other
	 */
	public boolean hasLineOfSightTo(Client client, WorldArea other)
	{
		if (plane != other.getPlane())
		{
			return false;
		}

		LocalPoint sourceLp = LocalPoint.fromWorld(client, x, y);
		LocalPoint targetLp = LocalPoint.fromWorld(client, other.getX(), other.getY());
		if (sourceLp == null || targetLp == null)
		{
			return false;
		}

		int thisX = sourceLp.getSceneX();
		int thisY = sourceLp.getSceneY();
		int otherX = targetLp.getSceneX();
		int otherY = targetLp.getSceneY();

		int cmpThisX, cmpThisY, cmpOtherX, cmpOtherY;

		// Determine which position to compare with for this NPC
		if (otherX <= thisX)
		{
			cmpThisX = thisX;
		}
		else if (otherX >= thisX + width - 1)
		{
			cmpThisX = thisX + width - 1;
		}
		else
		{
			cmpThisX = otherX;
		}
		if (otherY <= thisY)
		{
			cmpThisY = thisY;
		}
		else if (otherY >= thisY + height - 1)
		{
			cmpThisY = thisY + height - 1;
		}
		else
		{
			cmpThisY = otherY;
		}

		// Determine which position to compare for the other actor
		if (thisX <= otherX)
		{
			cmpOtherX = otherX;
		}
		else if (thisX >= otherX + other.getWidth() - 1)
		{
			cmpOtherX = otherX + other.getWidth() - 1;
		}
		else
		{
			cmpOtherX = thisX;
		}
		if (thisY <= otherY)
		{
			cmpOtherY = otherY;
		}
		else if (thisY >= otherY + other.getHeight() - 1)
		{
			cmpOtherY = otherY + other.getHeight() - 1;
		}
		else
		{
			cmpOtherY = thisY;
		}

		Tile[][][] tiles = client.getScene().getTiles();
		Tile sourceTile = tiles[plane][cmpThisX][cmpThisY];
		Tile targetTile = tiles[other.getPlane()][cmpOtherX][cmpOtherY];
		if (sourceTile == null || targetTile == null)
		{
			return false;
		}
		return sourceTile.hasLineOfSightTo(targetTile);
	}

	/**
	 * Determine if this WorldArea has line of sight to another WorldArea.
	 * <p>
	 * Note that the reverse isn't necessarily true, meaning this can return true
	 * while the other WorldArea does not have line of sight to this WorldArea.
	 *
	 * @param client The client to compare in
	 * @param other The other WorldPoint to compare with
	 * @return Returns true if this WorldPoint has line of sight to the WorldPoint
	 */
	public boolean hasLineOfSightTo(Client client, WorldPoint other)
	{
		return hasLineOfSightTo(client, new WorldArea(other, 1, 1));
	}

	/**
	 * Retrieves the southwestern most point of this WorldArea.
	 *
	 * @return Returns the southwestern most WorldPoint in the area
	 */
	public WorldPoint toWorldPoint()
	{
		return new WorldPoint(x, y, plane);
	}

	/**
	 * Accumulates all the WorldPoints that this WorldArea contains and returns them as a list
	 *
	 * @return Returns the WorldPoints in this WorldArea
	 */
	public List<WorldPoint> toWorldPointList()
	{
		List<WorldPoint> list = new ArrayList<>(width * height);
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				list.add(new WorldPoint(getX() + x, getY() + y, getPlane()));
			}
		}

		return list;
	}
}