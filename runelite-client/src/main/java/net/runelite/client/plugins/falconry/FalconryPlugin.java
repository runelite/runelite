/*
 * Copyright (c) 2019, Cas <https://github.com/stealthAngel>
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
package net.runelite.client.plugins.falconry;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;
import java.util.*;
import java.util.List;


@PluginDescriptor(
	name = "Falconry",
	description = "Aids you with catching Kebbits at the Falconry",
	tags = {"falconry", "hunter", "skilling"}
)
public class FalconryPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> kebbits = new ArrayList<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private KebbitsOverlay kebbitOverlay;

	@Inject
	private FalconryConfig config;

	@Provides
	FalconryConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FalconryConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(kebbitOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(kebbitOverlay);
		kebbits.clear();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		Kebbit kebbit = Kebbit.findKebbit(npc.getId());

		if (kebbit != null)
		{
			kebbits.add(npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		if (kebbits.isEmpty())
		{
			return;
		}

		NPC npc = npcDespawned.getNpc();
		kebbits.remove(npc);
	}

	boolean kebbitHighlightIsEnabled(NPC npc)
	{
		Kebbit kebbit = Kebbit.findKebbit(npc.getId());
		if (kebbit == null)
		{
			return false;
		}
		switch (kebbit.getKebbitType())
		{
			case SPOTTED:
				return config.SpottedKebbitHighlightEnabled();
			case DARK:
				return config.DarkKebbitHighlightEnabled();
			case DASHING:
				return config.DashingKebbitHighlightEnabled();
			case GYR_FALCON:
				return config.GyrFalconHighlightEnabled();
			default:
				return false;
		}
	}

	Color getHighlightColorFromKebbit(NPC npc)
	{
		Kebbit kebbit = Kebbit.findKebbit(npc.getId());
		if (kebbit == null)
		{
			return null;
		}

		switch (kebbit.getKebbitType())
		{
			case SPOTTED:
				return config.getSpottedKebbitHighlightColor();
			case DARK:
				return config.getDarkKebbitHighlightColor();
			case DASHING:
				return config.getDashingKebbitHighlightColor();
			case GYR_FALCON:
				return config.getGyrFalconHighlightColor();
			default:
				return null;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			kebbits.clear();
		}
	}
}
