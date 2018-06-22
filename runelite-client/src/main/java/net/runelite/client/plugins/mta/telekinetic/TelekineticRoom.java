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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import com.google.common.eventbus.Subscribe;
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

		WallObjectQuery qry = new WallObjectQuery()
			.idEquals(TELEKINETIC_WALL);
		WallObject[] result = qry.result(client);
		int length = result.length;

		if (maze == null || length != maze.getWalls())
		{
			maze = Maze.build(client, result);
			client.clearHintArrow();
		}
		else if (guardian != null)
		{
			if (!projectileMoving)
			{
				state = maze.getState(state, guardian);
			}

			if (state.moves() == 0)
			{
				client.clearHintArrow();
			}
			else
			{
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

		if (state != null
			&& state.validate())
		{
			state = state.next();
		}

		projectileMoving = projectile.getRemainingCycles() != 0;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
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
		if (inside() && maze != null && guardian != null && state != null)
		{
			if (state.moves() > 0)
			{
				if (state.validate())
				{
					graphics2D.setColor(Color.GREEN);
				}
				else
				{
					graphics2D.setColor(Color.RED);
				}


				Polygon tile = Perspective.getCanvasTilePoly(client, guardian.getLocalLocation());
				if (tile != null)
				{
					graphics2D.drawPolygon(tile);
				}

				if (optimal != null)
				{
					client.setHintArrow(optimal);
					renderWorldPoint(graphics2D, optimal);
				}
			}
		}
	}


	private void renderWorldPoint(Graphics2D graphics, WorldPoint worldPoint)
	{
		renderLocalPoint(graphics, LocalPoint.fromWorld(client, worldPoint));
	}

	private void renderLocalPoint(Graphics2D graphics, LocalPoint local)
	{
		if (local != null)
		{
			Polygon canvasTilePoly = Perspective.getCanvasTilePoly(client, local);
			if (canvasTilePoly != null)
			{
				graphics.drawPolygon(canvasTilePoly);
			}
		}
	}
}
