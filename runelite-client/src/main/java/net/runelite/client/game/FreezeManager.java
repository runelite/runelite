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

	private static void processActor(Actor subject)
	{
		FreezeInfo freezeInfo = subject.getFreeze();
		boolean wasImmune = freezeInfo.isImmune();

		freezeInfo.decrementAll();

		//after immunity runs out reset everything (no bars)
		if (!freezeInfo.isFrozen() && !freezeInfo.isImmune() && freezeInfo.getType() == null && wasImmune)
		{
			freezeInfo.resetFreeze();
			log.debug("{} is no longer immune", subject.getName());
		}

		//if not frozen, not immune and queued freezes
		//whilst immune we want to skip this
		//when we're frozen we cannot have a freeze reapply so skip this too
		//we must have a freeze queued which can be applied
		//the freeze type must be null which is implied by us not being in a frozen state
		if (!freezeInfo.isImmune() && !freezeInfo.isFrozen() && freezeInfo.getType() == null && freezeInfo.hasQueued())
		{
			for (FreezeInfo.QueuedFreeze qf : freezeInfo.getQueuedFreezes())
			{
				//shouldTrigger will check if the freeze is ready to be activated
				//the freeze graphic usually occurs 1/2 ticks before the freeze is actually applied
				//that's why freezes are stored because freezes casted whilst we were immune might take
				//effect when we're no longer immune.
				//we must queue all freezes despite one already being queued because in the case where we don't have
				//pid our queued freeze could potentially inhibit a new freeze from being queued which would actually
				//end up freezing the subject
				if (qf.shouldTrigger()) {
					//the freeze time in ticks cannot simply be derived from the currently activate overhead prayer
					//and freeze type.
					//unlike freezes which apply 1/2 ticks after casting the length of the freeze is determined during
					//the tick the graphic changes, so this information must be stored along with the type
					int ticks = qf.getLengthTicks();
					//halving has already been determined on cast
					freezeInfo.startFreeze(qf.getType(), ticks, subject.getWorldLocation());
					break;
				}
			}
		}

		//if there is a type set from when we were last frozen but we're not frozen anymore then we're immune
		if (freezeInfo.getType() != null && !freezeInfo.isFrozen())
		{
			freezeInfo.startImmunity();
		}

		//this acts as a fail safe in case a freeze is cancelled early
		//this would not necessarily be due to a bug, it could happen due to the subject having a freeze in effect
		//before the subject was known to the client or when the attacker is over 10 tiles away the freeze
		//automatically gets cancelled
		if (freezeInfo.getPosition() != null && (!freezeInfo.getPosition().equals(subject.getWorldLocation())))
		{
			freezeInfo.resetFreeze();
			log.debug("{} had their freeze cancelled", subject.getName());
		}
	}
}
