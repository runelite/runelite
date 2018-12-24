/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.plugins.implings;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

/**
 * @author robin
 */
@PluginDescriptor(
	name = "Implings",
	description = "Highlight nearby implings on the minimap and on-screen",
	tags = {"hunter", "minimap", "overlay"}
)
public class ImplingsPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> implings = new ArrayList<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ImplingsOverlay overlay;

	@Inject
	private ImplingMinimapOverlay minimapOverlay;

	@Inject
	private ImplingsConfig config;

	@Provides
	ImplingsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingsConfig.class);
	}


	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(minimapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(minimapOverlay);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			implings.add(npc);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			implings.clear();
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		if (implings.isEmpty())
		{
			return;
		}

		NPC npc = npcDespawned.getNpc();
		implings.remove(npc);
	}

	boolean showNpc(NPC npc)
	{
		Impling impling = Impling.findImpling(npc.getId());
		if (impling == null)
		{
			return false;
		}

		return showImplingType(impling.getImplingType());
	}

	boolean showImplingType(ImplingType implingType)
	{
		switch (implingType)
		{
			case BABY:
				return config.showBaby();
			case YOUNG:
				return config.showYoung();
			case GOURMET:
				return config.showGourmet();
			case EARTH:
				return config.showEarth();
			case ESSENCE:
				return config.showEssence();
			case ECLECTIC:
				return config.showEclectic();
			case NATURE:
				return config.showNature();
			case MAGPIE:
				return config.showMagpie();
			case NINJA:
				return config.showNinja();
			case DRAGON:
				return config.showDragon();
			case LUCKY:
				return config.showLucky();
			default:
				return false;
		}
	}

	Color npcToColor(NPC npc)
	{
		Impling impling = Impling.findImpling(npc.getId());
		if (impling == null)
		{
			return null;
		}

		switch (impling.getImplingType())
		{

			case BABY:
				return config.getBabyColor();
			case YOUNG:
				return config.getYoungColor();
			case GOURMET:
				return config.getGourmetColor();
			case EARTH:
				return config.getEarthColor();
			case ESSENCE:
				return config.getEssenceColor();
			case ECLECTIC:
				return config.getEclecticColor();
			case NATURE:
				return config.getNatureColor();
			case MAGPIE:
				return config.getMagpieColor();
			case NINJA:
				return config.getNinjaColor();
			case DRAGON:
				return config.getDragonColor();
			case LUCKY:
				return config.getLuckyColor();
			default:
				return null;
		}
	}
}
