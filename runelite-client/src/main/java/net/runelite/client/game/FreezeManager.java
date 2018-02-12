/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.game;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.FreezeInfo;
import net.runelite.api.FreezeType;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;

import java.util.List;

@Slf4j
public class FreezeManager
{
	public static final int IMMUNE_TICKS = 6;

	private Client client;
	private EventBus eventBus;

	public FreezeManager(Client client, EventBus eventBus)
	{
		this.client = client;
		this.eventBus = eventBus;

		//register ourself with the event bus to process changes
		this.eventBus.register(this);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		List<NPC> npcs = client.getNpcs();
		List<Player> players = client.getPlayers();
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		Actor a = event.getActor();
		int graphic = a.getGraphic();
		FreezeType type = null;

		if (graphic == FreezeType.ICE_RUSH.getGraphic())
		{
			type = FreezeType.ICE_RUSH;
		}
		else if (graphic == FreezeType.ICE_BURST.getGraphic())
		{
			type = FreezeType.ICE_BURST;
		}
		else if (graphic == FreezeType.ICE_BLITZ.getGraphic())
		{
			type = FreezeType.ICE_BLITZ;
		}
		else if (graphic == FreezeType.ICE_BARRAGE.getGraphic())
		{
			type = FreezeType.ICE_BARRAGE;
		}

		if (type == null)
			return;

		if (a instanceof Player)
		{
			a.getFreeze().queueFreeze(type, false);
		}
		else if (a instanceof NPC)
		{
			a.getFreeze().queueFreeze(type, true);
		}
	}

	private static void processActor(Actor subject)
	{
		FreezeInfo freezeInfo = subject.getFreeze();

		switch (freezeInfo.getState())
		{
			case FROZEN:
				freezeInfo.setFrozen(freezeInfo.getFrozen() - 1); //decrement freeze time

				if (freezeInfo.getFrozen() == 0)
				{
					freezeInfo.setImmune(IMMUNE_TICKS);
					freezeInfo.setType(null);
					//TODO broadcast changes
				}
				return;
			case IMMUNE:
				freezeInfo.setImmune(freezeInfo.getImmune() - 1); //decrement immune time

				if (freezeInfo.getImmune() > 0) //return if still immune
				{
					return;
				}
				//TODO broadcast immunity lift
				//if immunity lifted we also go into the queued case
			case QUEUED:
				freezeInfo.setQueued(freezeInfo.getQueued() - 1); //decrement queued time

				if (freezeInfo.getQueued() == 0)
				{
					//TODO check overhead prayer and broadcast frozen status
					freezeInfo.setFrozen(freezeInfo.getType().getTicks());
				}
		}
	}
}
