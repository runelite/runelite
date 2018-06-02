/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.Actor;
import net.runelite.api.CollisionDataFlag;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.Item;
import net.runelite.api.ItemLayer;
import net.runelite.api.Node;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemLayerChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSCollisionData;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSTile;
import java.util.ArrayList;
import java.util.List;

@Mixin(RSTile.class)
public abstract class RSTileMixin implements RSTile
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private static GameObject lastGameObject;

	@Inject
	private WallObject previousWallObject;

	@Inject
	private DecorativeObject previousDecorativeObject;

	@Inject
	private GroundObject previousGroundObject;

	@Inject
	private GameObject[] previousGameObjects;

	@Inject
	@Override
	public WorldPoint getWorldLocation()
	{
		return WorldPoint.fromRegion(client, getX(), getY(), getPlane());
	}

	@Inject
	@Override
	public Point getRegionLocation()
	{
		return new Point(getX(), getY());
	}

	@Inject
	@Override
	public LocalPoint getLocalLocation()
	{
		return LocalPoint.fromRegion(getX(), getY());
	}

	@FieldHook("wallObject")
	@Inject
	public void wallObjectChanged(int idx)
	{
		WallObject previous = previousWallObject;
		WallObject current = getWallObject();

		previousWallObject = current;

		if (current == null && previous != null)
		{
			WallObjectDespawned wallObjectDespawned = new WallObjectDespawned();
			wallObjectDespawned.setTile(this);
			wallObjectDespawned.setWallObject(previous);
			eventBus.post(wallObjectDespawned);
		}
		else if (current != null && previous == null)
		{
			WallObjectSpawned wallObjectSpawned = new WallObjectSpawned();
			wallObjectSpawned.setTile(this);
			wallObjectSpawned.setWallObject(current);
			eventBus.post(wallObjectSpawned);
		}
		else if (current != null && previous != null)
		{
			WallObjectChanged wallObjectChanged = new WallObjectChanged();
			wallObjectChanged.setTile(this);
			wallObjectChanged.setPrevious(previous);
			wallObjectChanged.setWallObject(current);
			eventBus.post(wallObjectChanged);
		}
	}

	@FieldHook("decorativeObject")
	@Inject
	public void decorativeObjectChanged(int idx)
	{
		DecorativeObject previous = previousDecorativeObject;
		DecorativeObject current = getDecorativeObject();

		previousDecorativeObject = current;

		if (current == null && previous != null)
		{
			DecorativeObjectDespawned decorativeObjectDespawned = new DecorativeObjectDespawned();
			decorativeObjectDespawned.setTile(this);
			decorativeObjectDespawned.setDecorativeObject(previous);
			eventBus.post(decorativeObjectDespawned);
		}
		else if (current != null && previous == null)
		{
			DecorativeObjectSpawned decorativeObjectSpawned = new DecorativeObjectSpawned();
			decorativeObjectSpawned.setTile(this);
			decorativeObjectSpawned.setDecorativeObject(current);
			eventBus.post(decorativeObjectSpawned);
		}
		else if (current != null && previous != null)
		{
			DecorativeObjectChanged decorativeObjectChanged = new DecorativeObjectChanged();
			decorativeObjectChanged.setTile(this);
			decorativeObjectChanged.setPrevious(previous);
			decorativeObjectChanged.setDecorativeObject(current);
			eventBus.post(decorativeObjectChanged);
		}
	}

	@FieldHook("groundObject")
	@Inject
	public void groundObjectChanged(int idx)
	{
		GroundObject previous = previousGroundObject;
		GroundObject current = getGroundObject();

		previousGroundObject = current;

		if (current == null && previous != null)
		{
			GroundObjectDespawned groundObjectDespawned = new GroundObjectDespawned();
			groundObjectDespawned.setTile(this);
			groundObjectDespawned.setGroundObject(previous);
			eventBus.post(groundObjectDespawned);
		}
		else if (current != null && previous == null)
		{
			GroundObjectSpawned groundObjectSpawned = new GroundObjectSpawned();
			groundObjectSpawned.setTile(this);
			groundObjectSpawned.setGroundObject(current);
			eventBus.post(groundObjectSpawned);
		}
		else if (current != null && previous != null)
		{
			GroundObjectChanged groundObjectChanged = new GroundObjectChanged();
			groundObjectChanged.setTile(this);
			groundObjectChanged.setPrevious(previous);
			groundObjectChanged.setGroundObject(current);
			eventBus.post(groundObjectChanged);
		}
	}

	@FieldHook("objects")
	@Inject
	public void gameObjectsChanged(int idx)
	{
		if (idx == -1) // this happens from the field assignment
		{
			return;
		}

		if (previousGameObjects == null)
		{
			previousGameObjects = new GameObject[5];
		}

		// Previous game object
		GameObject previous = previousGameObjects[idx];

		// GameObject that was changed.
		RSGameObject current = (RSGameObject) getGameObjects()[idx];

		// Last game object
		GameObject last = lastGameObject;

		// Update last game object
		lastGameObject = current;

		// Update previous object to current
		previousGameObjects[idx] = current;

		// Duplicate event, return
		if (current != null && current.equals(last))
		{
			return;
		}

		// Characters seem to generate a constant stream of new GameObjects
		if (current == null || !(current.getRenderable() instanceof Actor))
		{
			if (current == null && previous != null)
			{
				GameObjectDespawned gameObjectDespawned = new GameObjectDespawned();
				gameObjectDespawned.setTile(this);
				gameObjectDespawned.setGameObject(previous);
				eventBus.post(gameObjectDespawned);
			}
			else if (current != null && previous == null)
			{
				GameObjectSpawned gameObjectSpawned = new GameObjectSpawned();
				gameObjectSpawned.setTile(this);
				gameObjectSpawned.setGameObject(current);
				eventBus.post(gameObjectSpawned);
			}
			else if (current != null && previous != null)
			{
				GameObjectChanged gameObjectsChanged = new GameObjectChanged();
				gameObjectsChanged.setTile(this);
				gameObjectsChanged.setPrevious(previous);
				gameObjectsChanged.setGameObject(current);
				eventBus.post(gameObjectsChanged);
			}
		}
	}

	@FieldHook("itemLayer")
	@Inject
	public void itemLayerChanged(int idx)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			// during region loading this gets set to null 104x104 times
			return;
		}

		ItemLayerChanged itemLayerChanged = new ItemLayerChanged(this);
		eventBus.post(itemLayerChanged);
	}

	@Inject
	@Override
	public boolean hasLineOfSightTo(Tile other)
	{
		// Thanks to Henke for this method :)

		if (this.getPlane() != other.getPlane())
		{
			return false;
		}

		RSCollisionData[] collisionData = client.getCollisionMaps();
		int z = this.getPlane();
		int[][] collisionDataFlags = collisionData[z].getFlags();

		Point p1 = this.getRegionLocation();
		Point p2 = other.getRegionLocation();
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

	@Inject
	@Override
	public List<Item> getGroundItems()
	{
		ItemLayer layer = this.getItemLayer();
		if (layer == null)
		{
			return null;
		}

		List<Item> result = new ArrayList<Item>();
		Node node = layer.getBottom();
		while (node instanceof Item)
		{
			result.add((Item)node);
			node = node.getNext();
		}
		return result;
	}
}
