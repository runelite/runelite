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
import java.util.function.Function;
import javax.inject.Inject;
import net.runelite.api.NPC;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.npcoverlay.HighlightedNpc;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Implings",
	description = "Highlight nearby implings on the minimap and on-screen",
	tags = {"hunter", "minimap", "overlay", "imp"}
)
public class ImplingsPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ImplingsOverlay overlay;

	@Inject
	private ImplingsConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private NpcOverlayService npcOverlayService;

	public final Function<NPC, HighlightedNpc> isTarget = (npc) ->
	{
		Impling impling = Impling.findImpling(npc.getId());
		if (impling != null && showImpling(impling))
		{
			Color color = implingColor(impling);
			return HighlightedNpc.builder()
				.npc(npc)
				.highlightColor(color)
				.tile(true)
				.name(true)
				.nameOnMinimap(config.showName())
				.build();
		}
		return null;
	};

	@Provides
	ImplingsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingsConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		npcOverlayService.registerHighlighter(isTarget);
	}

	@Override
	protected void shutDown()
	{
		npcOverlayService.unregisterHighlighter(isTarget);
		overlayManager.remove(overlay);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(ImplingsConfig.GROUP))
		{
			return;
		}

		npcOverlayService.rebuild();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			if (showImplingType(impling.getImplingType()) == ImplingsConfig.ImplingMode.NOTIFY)
			{
				notifier.notify(impling.getImplingType().getName() + " impling is in the area");
			}
		}
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcCompositionChanged)
	{
		NPC npc = npcCompositionChanged.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			if (showImplingType(impling.getImplingType()) == ImplingsConfig.ImplingMode.NOTIFY)
			{
				notifier.notify(impling.getImplingType().getName() + " impling is in the area");
			}
		}
	}

	private boolean showImpling(Impling impling)
	{
		ImplingsConfig.ImplingMode impMode = showImplingType(impling.getImplingType());
		return impMode == ImplingsConfig.ImplingMode.HIGHLIGHT || impMode == ImplingsConfig.ImplingMode.NOTIFY;
	}

	ImplingsConfig.ImplingMode showImplingType(ImplingType implingType)
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
			case CRYSTAL:
				return config.showCrystal();
			case DRAGON:
				return config.showDragon();
			case LUCKY:
				return config.showLucky();
			default:
				return ImplingsConfig.ImplingMode.NONE;
		}
	}

	private Color implingColor(Impling impling)
	{
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
			case CRYSTAL:
				return config.getCrystalColor();
			case DRAGON:
				return config.getDragonColor();
			case LUCKY:
				return config.getLuckyColor();
			default:
				throw new IllegalArgumentException();
		}
	}
}
