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

import com.google.common.eventbus.Subscribe;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.Perspective;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.queries.WallObjectQuery;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.plugins.mta.MTAConfig;
import net.runelite.client.plugins.mta.MTARoom;

public class TelekineticRoom extends MTARoom
{
	private static final int TELEKINETIC_WALL = NullObjectID.NULL_10755;

	private final Client client;

	private NPC guardian;
	private Maze maze;
	private MazeState state;
	private boolean projectileMoving;
	private WorldPoint optimal;

	@Inject
	public TelekineticRoom(MTAConfig config, Client client)
	{
		super(config);
		this.client = client;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!getConfig().telekinetic()
			|| !inside())
		{
			return;
		}

		// Queries the walls around the maze. These are both used to detect when we enter a new maze
		// as well as building the bounds around the maze.
		WallObjectQuery qry = new WallObjectQuery()
			.idEquals(TELEKINETIC_WALL);
		WallObject[] result = qry.result(client);
		int length = result.length;

		// If the amount of walls in the currently stored maze are not equal to the amount of walls we've
		// queried there must be a new maze.
		if (maze == null || length != maze.getWalls())
		{
			maze = Maze.build(client, result);
			client.clearHintArrow();
		}
		else if (guardian != null)
		{
			// We don't want to get a new state when the projectile is moving as it will
			// move the state back to the previous state (guardian hasnt moved yet) when we
			// might have just moved to the next state (when telekinetic grab is cast and we
			// saw that the player was in the right position)
			if (!projectileMoving)
			{
				state = maze.getState(state, guardian);
			}

			// If there are no moves left we can clear the hint arrow
			if (state.moves() == 0)
			{
				client.clearHintArrow();
			}
			else
			{
				// Only compute the optimal once per tick
				WorldPoint current = client.getLocalPlayer().getWorldLocation();
				WorldPoint currentOptimal = state.optimal(current);
				if (optimal == null || !currentOptimal.equals(optimal))
				{
					optimal = currentOptimal;
				}
			}
		}
		else
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();
		if (projectile.getId() != ProjectileID.TELEKINETIC_SPELL)
		{
			return;
		}

		// If the current state is not null and we were in the correct position to cast the spell
		// we can prematurely move to the next state so the user can see the next move a bit sooner
		if (state != null
			&& state.validate())
		{
			state = state.next();
		}

		// Used for determining whether or not to recompute the state
		projectileMoving = projectile.getRemainingCycles() != 0;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		// Clear if we loaded a region and we're not inside
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (!inside())
			{
				maze = null;
				optimal = null;
				state = null;
				client.clearHintArrow();
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();

		if (npc.getId() == NpcID.MAZE_GUARDIAN)
		{
			guardian = npc;
		}
	}


	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();

		if (npc.getId() == NpcID.MAZE_GUARDIAN)
		{
			guardian = null;
		}
	}

	@Override
	public boolean inside()
	{
		return client.getWidget(WidgetID.MTA_TELEKINETIC_GROUP_ID, 0) != null;
	}

	@Override
	public void under(Graphics2D graphics2D)
	{
		if (!inside() || maze == null || guardian == null || state == null || state.moves() == 0)
		{
			return;
		}

		// If we are in the correct position we want to colour the tiles green
		if (state.validate())
		{
			graphics2D.setColor(Color.GREEN);
		}
		else
		{
			graphics2D.setColor(Color.RED);
		}

		Polygon guardianTilePoly = Perspective.getCanvasTilePoly(client, guardian.getLocalLocation());
		if (guardianTilePoly != null)
		{
			graphics2D.drawPolygon(guardianTilePoly);
		}

		if (optimal == null)
		{
			return;
		}

		client.setHintArrow(optimal);
		LocalPoint optimalPoint = LocalPoint.fromWorld(client, optimal);

		if (optimalPoint == null)
		{
			return;
		}

		Polygon canvasTilePoly = Perspective.getCanvasTilePoly(client, optimalPoint);
		if (canvasTilePoly == null)
		{
			return;
		}

		graphics2D.drawPolygon(canvasTilePoly);
	}
}
