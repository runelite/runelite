/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2021 andmcadams
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
package net.runelite.client.plugins.crowdsourcing.varbits;

import com.google.common.collect.ImmutableSet;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IndexDataBase;
import net.runelite.api.VarbitComposition;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;

@Slf4j
public class CrowdsourcingVarbits
{

	@Inject
	private Client client;

	@Inject
	private CrowdsourcingManager crowdsourcingManager;

	@Inject
	private ClientThread clientThread;

	private static final int VARBITS_ARCHIVE_ID = 14;
	private static final int VARBIT = 0;
	private static final int VARPLAYER = 1;

	private int[] oldVarps = null;
	private int[] oldVarps2 = null;
	private Multimap<Integer, Integer> varbits;

	private int initializingTick = 0;

	/* Blacklist certain common varbs that give us little useful data.
	 * 357 - Equipped weapon type
	 * 5983 - Dialogue option appear/disappear
	 */
	private static final ImmutableSet<Integer> BLACKLIST = ImmutableSet.of(357, 5983);

	public void startUp()
	{

		varbits = HashMultimap.create();

		if (oldVarps == null)
		{
			oldVarps = new int[client.getVarps().length];
			oldVarps2 = new int[client.getVarps().length];
		}

		// Set oldVarps to be the current varps
		System.arraycopy(client.getVarps(), 0, oldVarps, 0, oldVarps.length);
		System.arraycopy(client.getVarps(), 0, oldVarps2, 0, oldVarps2.length);

		// For all varbits, add their ids to the multimap with the varp index as their key
		clientThread.invoke(() ->
		{
			if (client.getIndexConfig() == null)
			{
				return false;
			}
			if (client.getGameState() == GameState.STARTING || client.getGameState() == GameState.UNKNOWN)
			{
				return false;
			}
			IndexDataBase indexVarbits = client.getIndexConfig();
			final int[] varbitIds = indexVarbits.getFileIds(VARBITS_ARCHIVE_ID);
			for (int id : varbitIds)
			{
				VarbitComposition varbit = client.getVarbit(id);
				if (varbit != null)
				{
					varbits.put(varbit.getIndex(), id);
				}
			}
			return true;
		});
	}

	public void shutDown()
	{
		varbits = null;
		oldVarps = null;
		oldVarps2 = null;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState().equals(GameState.HOPPING)
			|| gameStateChanged.getGameState().equals(GameState.LOGGING_IN))
		{
			initializingTick = client.getTickCount();
			shutDown();
			startUp();
		}
	}

	private void pushVarChange(int varType, int varIndex, int oldValue, int newValue, int tick)
	{
		/* Queues up varbit or varplayer changes to be pushed out to the crowdsourcing manager during the next client
		 * tick.
		 */
		clientThread.invokeLater(() ->
		{
			LocalPoint local = LocalPoint.fromWorld(client, client.getLocalPlayer().getWorldLocation());
			WorldPoint location = WorldPoint.fromLocalInstance(client, local);
			boolean isInInstance = client.isInInstancedRegion();

			log.debug(String.format("Storing VarData (tick %d): %d, %d, %d->%d", tick, varType, varIndex, oldValue, newValue));
			VarData varbitData = new VarData(varType, varIndex, oldValue, newValue, tick, isInInstance, location);
			crowdsourcingManager.storeEvent(varbitData);
		});
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		int tick = client.getTickCount();

		// Whenever a varbit is changed, record it and pass the info off to be submitted.
		int index = varbitChanged.getIndex();
		int[] varps = client.getVarps();

		for (int i : varbits.get(index))
		{
			int oldValue = client.getVarbitValue(oldVarps, i);
			int newValue = client.getVarbitValue(varps, i);

			if (oldValue != newValue)
			{
				// Set oldVarps2 so it doesn't pick up varbit changes
				client.setVarbitValue(oldVarps2, i, newValue);

				// If the varbit is being changed on an initializing tick (when logging in), don't push out a change
				if (tick != initializingTick && !BLACKLIST.contains(i))
				{
					pushVarChange(VARBIT, i, oldValue, newValue, tick);
				}
			}
		}

		int oldValue = oldVarps2[index];
		int newValue = varps[index];

		// Push out varp changes
		if (oldValue != newValue && tick != initializingTick)
		{
			pushVarChange(VARPLAYER, index, oldValue, newValue, tick);
		}

		oldVarps[index] = varps[index];
		oldVarps2[index] = varps[index];
	}

}
