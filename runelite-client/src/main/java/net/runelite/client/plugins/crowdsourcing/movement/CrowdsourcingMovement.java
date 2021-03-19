/*
 * Copyright (c) 2019, Weird Gloop <admin@weirdgloop.org>
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

package net.runelite.client.plugins.crowdsourcing.movement;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

public class CrowdsourcingMovement
{
	@Inject
	private Client client;

	@Inject
	private CrowdsourcingManager manager;

	private WorldPoint lastPoint;
	private int ticksStill;
	private boolean lastIsInInstance;
	private MenuOptionClicked lastClick;

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (menuOptionClicked.getMenuAction() != MenuAction.WALK
			&& !menuOptionClicked.getMenuOption().equals("Message"))
		{
			lastClick = menuOptionClicked;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		LocalPoint local = LocalPoint.fromWorld(client, client.getLocalPlayer().getWorldLocation());
		WorldPoint nextPoint = WorldPoint.fromLocalInstance(client, local);
		boolean nextIsInInstance = client.isInInstancedRegion();
		if (lastPoint != null)
		{
			int distance = nextPoint.distanceTo(lastPoint);
			if (distance > 2 || nextIsInInstance != lastIsInInstance)
			{
				MovementData data = new MovementData(lastPoint, nextPoint, lastIsInInstance, nextIsInInstance, ticksStill, lastClick);
				manager.storeEvent(data);
			}
			if (distance > 0)
			{
				ticksStill = 0;
			}
		}
		ticksStill++;
		lastPoint = nextPoint;
		lastIsInInstance = nextIsInInstance;
	}
}
