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
import net.runelite.client.config.Notification;
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
	private ConfigManager configManager;

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
		if (impling != null && implingHighlighted(impling.getImplingType()))
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
		migrateConfig();
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
			final ImplingType implingType = impling.getImplingType();
			final Notification notification = implingNotification(implingType);
			notifier.notify(notification, implingType.getName() + " impling is in the area");
		}
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcCompositionChanged)
	{
		NPC npc = npcCompositionChanged.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			final ImplingType implingType = impling.getImplingType();
			final Notification notification = implingNotification(implingType);
			notifier.notify(notification, implingType.getName() + " impling is in the area");
		}
	}

	private void migrateConfig()
	{
		String migrated = configManager.getConfiguration(ImplingsConfig.GROUP, "migrated");
		if (migrated != null && !"1".equals(migrated))
		{
			return;
		}

		ImplingsConfig.ImplingMode babyImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showbaby", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(babyImplingMode, "highlightBaby", "babyNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showbaby");

		ImplingsConfig.ImplingMode youngImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showyoung", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(youngImplingMode, "highlightYoung", "youngNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showyoung");

		ImplingsConfig.ImplingMode earthImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showearth", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(earthImplingMode, "highlightEarth", "earthNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showearth");

		ImplingsConfig.ImplingMode gourmetImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showgourmet", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(gourmetImplingMode, "highlightGourmet", "gourmetNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showgourmet");

		ImplingsConfig.ImplingMode essenceImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showessence", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(essenceImplingMode, "highlightEssence", "essenceNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showessence");

		ImplingsConfig.ImplingMode eclecticImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showeclectic", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(eclecticImplingMode, "highlightEclectic", "eclecticNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showeclectic");

		ImplingsConfig.ImplingMode natureImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "shownature", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(natureImplingMode, "highlightNature", "natureNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "shownature");

		ImplingsConfig.ImplingMode magpieImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showmagpie", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(magpieImplingMode, "highlightMagpie", "magpieNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showmagpie");

		ImplingsConfig.ImplingMode ninjaImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showninja", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(ninjaImplingMode, "highlightNinja", "ninjaNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showninja");

		ImplingsConfig.ImplingMode crystalImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showCrystal", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(crystalImplingMode, "highlightCrystal", "crystalNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showCrystal");

		ImplingsConfig.ImplingMode dragonImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showdragon", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(dragonImplingMode, "highlightDragon", "dragonNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showdragon");

		ImplingsConfig.ImplingMode luckyImplingMode = configManager.getConfiguration(ImplingsConfig.GROUP, "showlucky", ImplingsConfig.ImplingMode.class);
		setConfigsForImplingMode(luckyImplingMode, "highlightLucky", "luckyNotification");
		configManager.unsetConfiguration(ImplingsConfig.GROUP, "showlucky");

		configManager.setConfiguration(ImplingsConfig.GROUP, "migrated", "2");
	}

	private void setConfigsForImplingMode(ImplingsConfig.ImplingMode implingMode, String highlightKey, String notificationKey)
	{
		if (implingMode == ImplingsConfig.ImplingMode.NONE)
		{
			configManager.setConfiguration(ImplingsConfig.GROUP, highlightKey, false);
			configManager.setConfiguration(ImplingsConfig.GROUP, notificationKey, Notification.OFF);
		}
		else if (implingMode == ImplingsConfig.ImplingMode.HIGHLIGHT)
		{
			configManager.setConfiguration(ImplingsConfig.GROUP, highlightKey, true);
			configManager.setConfiguration(ImplingsConfig.GROUP, notificationKey, Notification.OFF);
		}
		else
		{
			configManager.setConfiguration(ImplingsConfig.GROUP, highlightKey, true);
			configManager.setConfiguration(ImplingsConfig.GROUP, notificationKey, Notification.ON);
		}
	}

	public boolean implingHighlighted(final ImplingType implingType)
	{
		switch (implingType)
		{
			case BABY:
				return config.highlightBaby();
			case YOUNG:
				return config.highlightYoung();
			case GOURMET:
				return config.highlightGourmet();
			case EARTH:
				return config.highlightEarth();
			case ESSENCE:
				return config.highlightEssence();
			case ECLECTIC:
				return config.highlightEclectic();
			case NATURE:
				return config.highlightNature();
			case MAGPIE:
				return config.highlightMagpie();
			case NINJA:
				return config.highlightNinja();
			case CRYSTAL:
				return config.highlightCrystal();
			case DRAGON:
				return config.highlightDragon();
			case LUCKY:
				return config.highlightLucky();
			default:
				throw new IllegalArgumentException();
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

	private Notification implingNotification(final ImplingType implingType)
	{
		switch (implingType)
		{
			case BABY:
				return config.getBabyNotification();
			case YOUNG:
				return config.getYoungNotification();
			case GOURMET:
				return config.getGourmetNotification();
			case EARTH:
				return config.getEarthNotification();
			case ESSENCE:
				return config.getEssenceNotification();
			case ECLECTIC:
				return config.getEclecticNotification();
			case NATURE:
				return config.getNatureNotification();
			case MAGPIE:
				return config.getMagpieNotification();
			case NINJA:
				return config.getNinjaNotification();
			case CRYSTAL:
				return config.getCrystalNotification();
			case DRAGON:
				return config.getDragonNotification();
			case LUCKY:
				return config.getLuckyNotification();
			default:
				throw new IllegalArgumentException();
		}
	}
}
