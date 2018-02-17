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
import net.runelite.api.OverheadPrayer;
import net.runelite.api.Player;
import net.runelite.api.events.ActorFreeze;
import net.runelite.api.events.ActorFreezeEnded;
import net.runelite.api.events.ActorFreezeImmune;
import net.runelite.api.events.ActorFreezeImmuneEnded;
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

		for (NPC npc : npcs) //process npcs before players just like the game does
		{
			processActor(npc);
		}

		for (Player player : players)
		{
			processActor(player);
		}
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
		else if (graphic == FreezeType.BIND.getGraphic())
		{
			type = FreezeType.BIND;
		}
		else if (graphic == FreezeType.SNARE.getGraphic())
		{
			type = FreezeType.SNARE;
		}
		else if (graphic == FreezeType.ENTANGLE.getGraphic())
		{
			type = FreezeType.ENTANGLE;
		}

		if (type == null)
			return;

		int freezeTicks = type.getTicks();

		if (a instanceof Player)
		{
			log.debug("Player freeze queued");
			OverheadPrayer activeOverhead = OverheadPrayer.fromId(((Player) a).getOverheadIcon());

			if (type.isHalfOnPray() && activeOverhead == OverheadPrayer.PROTECT_MAGIC)
			{
				freezeTicks /= 2;
			}

			a.getFreeze().queueFreeze(type, freezeTicks, false);
		}
		else if (a instanceof NPC)
		{
			log.debug("NPC freeze queued");
			//TODO determine halving of ticks when praying
			a.getFreeze().queueFreeze(type, freezeTicks, false);
		}
	}

	private void processActor(Actor subject)
	{
		FreezeInfo freezeInfo = subject.getFreeze();
		boolean wasImmune = freezeInfo.isImmune();

		freezeInfo.decrementAll();

		//after immunity runs out
		if (!freezeInfo.isFrozen() && !freezeInfo.isImmune() && freezeInfo.getType() == null && wasImmune)
		{
			freezeInfo.resetFreeze();

			ActorFreezeImmuneEnded event = new ActorFreezeImmuneEnded();
			event.setActor(subject);
			eventBus.post(event);

			log.debug("{} is no longer immune", subject.getName());
		}

		//if not frozen, not immune and queued freezes
		if (!freezeInfo.isImmune() && !freezeInfo.isFrozen() && freezeInfo.getType() == null && freezeInfo.hasQueued())
		{
			for (FreezeInfo.QueuedFreeze qf : freezeInfo.getQueuedFreezes())
			{
				if (qf.shouldTrigger())
				{
					int ticks = qf.getLengthTicks();
					//halving has already been determined on cast
					freezeInfo.startFreeze(qf.getType(), ticks, subject.getWorldLocation());

					ActorFreeze event = new ActorFreeze();
					event.setActor(subject);
					eventBus.post(event);

					break;
				}
			}
		}

		//if we were frozen last tick or this tick
		if (freezeInfo.isFrozen())
		{

		}

		//if there is a type set from when we were last frozen but we're not frozen anymore then we're immune
		if (freezeInfo.getType() != null && !freezeInfo.isFrozen())
		{
			freezeInfo.startImmunity();

			ActorFreezeImmune event = new ActorFreezeImmune();
			event.setActor(subject);
			eventBus.post(event);
		}

		//if we're immune
		if (freezeInfo.isImmune())
		{
			
		}

		if (freezeInfo.getPosition() != null && (!freezeInfo.getPosition().equals(subject.getWorldLocation())))
		{
			freezeInfo.resetFreeze();

			ActorFreezeEnded event = new ActorFreezeEnded();
			event.setActor(subject);
			eventBus.post(event);

			log.debug("{} had their freeze cancelled", subject.getName());
		}
	}
}
