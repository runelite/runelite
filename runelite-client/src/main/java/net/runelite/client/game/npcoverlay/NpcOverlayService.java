/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.game.npcoverlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

@Singleton
public class NpcOverlayService
{
	private final Client client;
	private final ClientThread clientThread;
	private final List<Function<NPC, HighlightedNpc>> highlightFunctions = new ArrayList<>();
	private final Map<NPC, HighlightedNpc> highlightedNpcs = new HashMap<>();

	@Inject
	private NpcOverlayService(Client client, ClientThread clientThread,
		OverlayManager overlayManager, ModelOutlineRenderer modelOutlineRenderer, EventBus eventBus)
	{
		this.client = client;
		this.clientThread = clientThread;
		overlayManager.add(new NpcOverlay(client, modelOutlineRenderer, highlightedNpcs));
		overlayManager.add(new NpcMinimapOverlay(highlightedNpcs));
		eventBus.register(this);
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN ||
			event.getGameState() == GameState.HOPPING)
		{
			highlightedNpcs.clear();
		}
	}

	@Subscribe(
		// Run after plugins, which typically capture NPCs on spawn and reference them in the highlight functions
		priority = -1
	)
	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();

		for (Function<NPC, HighlightedNpc> f : highlightFunctions)
		{
			HighlightedNpc highlightedNpc = f.apply(npc);
			if (highlightedNpc != null)
			{
				highlightedNpcs.put(npc, highlightedNpc);
				return;
			}
		}
	}

	@Subscribe(
		priority = -1
	)
	private void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();
		highlightedNpcs.remove(npc);
	}

	@Subscribe(
		priority = -1
	)
	private void onNpcChanged(NpcChanged event)
	{
		final NPC npc = event.getNpc();

		highlightedNpcs.remove(npc);

		for (Function<NPC, HighlightedNpc> f : highlightFunctions)
		{
			HighlightedNpc highlightedNpc = f.apply(npc);
			if (highlightedNpc != null)
			{
				highlightedNpcs.put(npc, highlightedNpc);
				return;
			}
		}
	}

	public void rebuild()
	{
		clientThread.invoke(() ->
		{
			highlightedNpcs.clear();

			outer:
			for (NPC npc : client.getNpcs())
			{
				for (Function<NPC, HighlightedNpc> f : highlightFunctions)
				{
					HighlightedNpc highlightedNpc = f.apply(npc);
					if (highlightedNpc != null)
					{
						highlightedNpcs.put(npc, highlightedNpc);
						continue outer;
					}
				}
			}
		});
	}

	public void registerHighlighter(Function<NPC, HighlightedNpc> p)
	{
		highlightFunctions.add(p);
		rebuild();
	}

	public void unregisterHighlighter(Function<NPC, HighlightedNpc> p)
	{
		highlightFunctions.remove(p);
		rebuild();
	}
}
