/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

package net.runelite.client.plugins.cerberus;

import com.google.common.collect.ComparisonChain;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Cerberus",
	description = "Show what to pray against the summoned souls",
	tags = {"bosses", "combat", "ghosts", "prayer", "pve", "overlay", "souls"}
)
@Singleton
public class CerberusPlugin extends Plugin
{
	@Getter
	private final List<NPC> ghosts = new ArrayList<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CerberusOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		ghosts.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState gameState = event.getGameState();
		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.HOPPING || gameState == GameState.CONNECTION_LOST)
		{
			ghosts.clear();
		}
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		CerberusGhost.fromNPC(npc).ifPresent(ghost -> ghosts.add(npc));
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		ghosts.remove(event.getNpc());
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (ghosts.isEmpty())
		{
			return;
		}

		ghosts.sort((a, b) -> ComparisonChain.start()
			// First, sort by the southernmost ghost (e.g with lowest y)
			.compare(a.getLocalLocation().getY(), b.getLocalLocation().getY())
			// Then, sort by the westernmost ghost (e.g with lowest x)
			.compare(a.getLocalLocation().getX(), b.getLocalLocation().getX())
			// This will give use the current wave and order of the ghosts based on
			// what ghost will attack first
			.result());
	}
}
