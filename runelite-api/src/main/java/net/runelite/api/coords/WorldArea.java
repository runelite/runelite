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
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Getter;
import net.runelite.api.CollisionData;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WorldView;

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

		return distanceTo2D(other);
	}

	/**
	 * Computes the shortest distance to a world coordinate.
	 *
	 * @param other the passed coordinate
	 * @return the distance, or {@link Integer#MAX_VALUE} if the planes differ
	 */
	public int distanceTo(WorldPoint other)
	{
		return distanceTo(other.toWorldArea());
	}

	/**
	 * Computes the shortest distance to another area while ignoring the plane.
	 *
	 * @param other the passed area
	 * @return the distance
	 */
	public int distanceTo2D(WorldArea other)
	{
		Point distances = getAxisDistances(other);
		return Math.max(distances.getX(), distances.getY());
	}

	/**
	 * Computes the shortest distance to a world coordinate.
	 *
	 * @param other the passed coordinate
	 * @return the distance
	 */
	public int distanceTo2D(WorldPoint other)
	{
		return distanceTo2D(other.toWorldArea());
	}

	/**
	 * Checks whether a tile is contained within the area and in the same plane.
	 *
	 * @return {@code true} if the tile is contained within the bounds of this area, {@code false} otherwise.
	 */
	public boolean contains(WorldPoint worldPoint)
	{
		return distanceTo(worldPoint) == 0;
	}

	/**
	 * Checks whether a tile is contained within the area while ignoring the plane.
	 *
	 * @return {@code true} if the tile is contained within the bounds of this area regardless of plane, {@code false} otherwise.
	 */
	public boolean contains2D(WorldPoint worldPoint)
	{
		return distanceTo2D(worldPoint) == 0;
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
		return isInMeleeDistance(other.toWorldArea());
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
	 * {@link #canTravelInDirection(WorldView, int, int, Predicate)} method.
	 *
	 * @param dx the x-axis direction to travel (-1, 0, or 1)
	 * @param dy the y-axis direction to travel (-1, 0, or 1)
	 * @return true if the area can travel in the specified direction
	 */
	public boolean canTravelInDirection(WorldView wv, int dx, int dy)
	{
		return canTravelInDirection(wv, dx, dy, x -> true);
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
	 * @param dx             the x-axis direction to travel (-1, 0, or 1)
	 * @param dy             the y-axis direction to travel (-1, 0, or 1)
	 * @param extraCondition an additional condition to perform when checking valid tiles,
	 *                       such as performing a check for un-passable actors
	 * @return true if the area can travel in the specified direction
	 */
	public boolean canTravelInDirection(WorldView wv, int dx, int dy,
										Predicate<? super WorldPoint> extraCondition)
	{
		dx = Integer.signum(dx);
		dy = Integer.signum(dy);

		if (dx == 0 && dy == 0)
		{
			return true;
		}

		LocalPoint lp = LocalPoint.fromWorld(wv, x, y);

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

		CollisionData[] collisionData = wv.getCollisionMaps();
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
					!extraCondition.test(WorldPoint.fromScene(wv, checkX, y, plane)))
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
					!extraCondition.test(WorldPoint.fromScene(wv, x, checkY, plane)))
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
				!extraCondition.test(WorldPoint.fromScene(wv, checkX, checkY, plane)))
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
					extraCondition.test(WorldPoint.fromScene(wv, checkX, startY, plane)))
				{
					return false;
				}
			}
			if (height == 1)
			{
				if ((collisionDataFlags[checkX - dx][checkY] & yFlags) != 0 &&
					extraCondition.test(WorldPoint.fromScene(wv, startX, checkY, plane)))
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
	 * Determine if this WorldArea has line of sight to another WorldArea.
	 * <p>
	 * Note that the reverse isn't necessarily true, meaning this can return true
	 * while the other WorldArea does not have line of sight to this WorldArea.
	 *
	 * @param other The other WorldArea to compare with
	 * @return Returns true if this WorldArea has line of sight to the other
	 */
	public boolean hasLineOfSightTo(WorldView wv, WorldArea other)
	{
		if (plane != other.getPlane())
		{
			return false;
		}

		List<WorldPoint> fromEdges = other.getVisibleCandidates(this);
		List<WorldPoint> toEdges = this.getVisibleCandidates(other);
		Tile[][][] tiles = wv.getScene().getTiles();
		for (WorldPoint fromPoint : fromEdges)
		{
			for (WorldPoint toPoint : toEdges)
			{
				LocalPoint fromLp = LocalPoint.fromWorld(wv, fromPoint);
				LocalPoint toLp = LocalPoint.fromWorld(wv, toPoint);

				if (fromLp == null || toLp == null)
				{
					continue;
				}

				Tile sourceTile = tiles[plane][fromLp.getSceneX()][fromLp.getSceneY()];
				Tile targetTile = tiles[other.getPlane()][toLp.getSceneX()][toLp.getSceneY()];
				if (sourceTile == null || targetTile == null)
				{
					continue;
				}
				if (hasLineOfSightTo(wv, sourceTile, targetTile))
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasLineOfSightTo(WorldView wv, Tile from, Tile to)
	{
		// Thanks to Henke for this method :)

		if (from.getPlane() != to.getPlane())
		{
			return false;
		}

		CollisionData[] collisionData = wv.getCollisionMaps();
		if (collisionData == null)
		{
			return false;
		}

		int z = from.getPlane();
		int[][] collisionDataFlags = collisionData[z].getFlags();

		Point p1 = from.getSceneLocation();
		Point p2 = to.getSceneLocation();
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
		{
			return true;
		}

		int dx = p2.getX() - p1.getX();
		int dy = p2.getY() - p1.getY();
		int dxAbs = Math.abs(dx);
		int dyAbs = Math.abs(dy);

		int xFlags = CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
		int yFlags = CollisionDataFlag.BLOCK_LINE_OF_SIGHT_FULL;
		if (dx < 0)
		{
			xFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_EAST;
		}
		else
		{
			xFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_WEST;
		}
		if (dy < 0)
		{
			yFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_NORTH;
		}
		else
		{
			yFlags |= CollisionDataFlag.BLOCK_LINE_OF_SIGHT_SOUTH;
		}

		if (dxAbs > dyAbs)
		{
			int x = p1.getX();
			int yBig = p1.getY() << 16; // The y position is represented as a bigger number to handle rounding
			int slope = (dy << 16) / dxAbs;
			yBig += 0x8000; // Add half of a tile
			if (dy < 0)
			{
				yBig--; // For correct rounding
			}
			int direction = dx < 0 ? -1 : 1;

			while (x != p2.getX())
			{
				x += direction;
				int y = yBig >>> 16;
				if ((collisionDataFlags[x][y] & xFlags) != 0)
				{
					// Collision while traveling on the x axis
					return false;
				}
				yBig += slope;
				int nextY = yBig >>> 16;
				if (nextY != y && (collisionDataFlags[x][nextY] & yFlags) != 0)
				{
					// Collision while traveling on the y axis
					return false;
				}
			}
		}
		else
		{
			int y = p1.getY();
			int xBig = p1.getX() << 16; // The x position is represented as a bigger number to handle rounding
			int slope = (dx << 16) / dyAbs;
			xBig += 0x8000; // Add half of a tile
			if (dx < 0)
			{
				xBig--; // For correct rounding
			}
			int direction = dy < 0 ? -1 : 1;

			while (y != p2.getY())
			{
				y += direction;
				int x = xBig >>> 16;
				if ((collisionDataFlags[x][y] & yFlags) != 0)
				{
					// Collision while traveling on the y axis
					return false;
				}
				xBig += slope;
				int nextX = xBig >>> 16;
				if (nextX != x && (collisionDataFlags[nextX][y] & xFlags) != 0)
				{
					// Collision while traveling on the x axis
					return false;
				}
			}
		}

		// No collision
		return true;
	}

	/**
	 * Determine if this WorldArea has line of sight to another WorldArea.
	 * <p>
	 * Note that the reverse isn't necessarily true, meaning this can return true
	 * while the other WorldArea does not have line of sight to this WorldArea.
	 *
	 * @param other The other WorldPoint to compare with
	 * @return Returns true if this WorldPoint has line of sight to the WorldPoint
	 */
	public boolean hasLineOfSightTo(WorldView wv, WorldPoint other)
	{
		return hasLineOfSightTo(wv, other.toWorldArea());
	}

	/**
	 * Gets the points of another worldArea that may be viewable by this WorldArea
	 * The points are sorted by their distance to the closest point in this WorldArea
	 *
	 * @param other the other WorldArea
	 * @return the list of potentially visible points
	 */
	private List<WorldPoint> getVisibleCandidates(WorldArea other)
	{
		Point compPoint = this.getComparisonPoint(other);
		Comparator<WorldPoint> byDistance = Comparator.comparingInt((p) -> p.distanceTo(
			new WorldPoint(compPoint.getX(), compPoint.getY(), this.getPlane())));

		return other.toWorldPointList()
			.stream()
			.filter(p -> isEdgePoint(other, p))
			.filter(p -> isVisibleCandidate(other, p))
			.sorted(byDistance)
			.collect(Collectors.toList());
	}

	/**
	 * Checks if the given point is on the edge of the provided WorldArea
	 *
	 * @param p Point to test
	 * @return true if on the edge, false otherwise
	 */
	private static boolean isEdgePoint(WorldArea wa, WorldPoint p)
	{
		return p.getX() == wa.getX()
			|| p.getX() == wa.getX() + wa.getWidth() - 1
			|| p.getY() == wa.getY()
			|| p.getY() == wa.getY() + wa.getHeight() - 1;
	}

	/**
	 * Prunes potentially visible WorldArea points in the other WorldArea by checking
	 * if the given point is on a visible edge.
	 *
	 * @param other The other WorldArea
	 * @param p     Test point in other WorldArea
	 * @return true if the point is on a potentially visible edge, false otherwise
	 */
	private boolean isVisibleCandidate(WorldArea other, WorldPoint p)
	{
		if (this.intersectsWith(other))
		{
			return false;
		}
		// This WorldArea is east of other
		if (this.getX() + this.getWidth() - 1 > other.getX() + other.getWidth() - 1)
		{
			// Southeast
			if (this.getY() < other.getY())
			{
				return p.getX() == other.getX() + other.getWidth() - 1 || p.getY() == other.getY();
			}
			// Northeast
			if (this.getY() + this.getHeight() - 1 > other.getY() + other.getHeight() - 1)
			{
				return p.getX() == other.getX() + other.getWidth() - 1 || p.getY() == other.getY() + other.getHeight() - 1;
			}
			return p.getX() == other.getX() + other.getWidth() - 1;
		}
		// This WorldArea is west of other
		else if (this.getX() < other.getX())
		{
			// Southwest
			if (this.getY() < other.getY())
			{
				return p.getX() == other.getX() || p.getY() == other.getY();
			}
			// Northwest
			if (this.getY() + this.getHeight() - 1 > other.getY() + other.getHeight() - 1)
			{
				return p.getX() == other.getX() || p.getY() == other.getY() + other.getHeight() - 1;
			}
			// Straight west
			return p.getX() == other.getX();
		}
		// This WorldArea is north
		else if (this.getY() > other.getY() + other.getHeight() - 1)
		{
			return p.getY() == other.getY() + other.getHeight() - 1;
		}
		// This WorldArea is south
		else if (this.getY() < other.getY())
		{
			return p.getY() == other.getY();
		}
		return false;
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