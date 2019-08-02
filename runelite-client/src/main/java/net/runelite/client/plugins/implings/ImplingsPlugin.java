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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDefinitionChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Implings",
	description = "Highlight nearby implings on the minimap and on-screen",
	tags = {"hunter", "minimap", "overlay", "imp"}
)
@Singleton
public class ImplingsPlugin extends Plugin
{
	private static final int DYNAMIC_SPAWN_NATURE_DRAGON = 1618;
	private static final int DYNAMIC_SPAWN_ECLECTIC = 1633;
	private static final int DYNAMIC_SPAWN_BABY_ESSENCE = 1634;

	@Getter(AccessLevel.PACKAGE)
	private Map<ImplingType, Integer> implingCounterMap = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> implings = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, String> dynamicSpawns = new HashMap<>();

	@Inject
	private ImplingsOverlay overlay;

	@Inject
	private ImplingCounterOverlay implingCounterOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ImplingMinimapOverlay minimapOverlay;

	@Inject
	private ImplingsConfig config;

	@Inject
	private EventBus eventBus;

	private boolean showBaby;
	private Color getBabyColor;
	private boolean showYoung;
	private Color getYoungColor;
	private boolean showGourmet;
	private Color getGourmetColor;
	private boolean showEarth;
	private Color getEarthColor;
	private boolean showEssence;
	private Color getEssenceColor;
	private boolean showEclectic;
	private Color getEclecticColor;
	private boolean showNature;
	private Color getNatureColor;
	private boolean showMagpie;
	private Color getMagpieColor;
	private boolean showNinja;
	private Color getNinjaColor;
	private boolean showCrystal;
	private Color getCrystalColor;
	private boolean showDragon;
	private Color getDragonColor;
	private boolean showLucky;
	private Color getLuckyColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSpawn;
	@Getter(AccessLevel.PACKAGE)
	private Color getSpawnColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showName;
	@Getter(AccessLevel.PACKAGE)
	private Color getDynamicSpawnColor;

	@Provides
	ImplingsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingsConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();

		dynamicSpawns.put(DYNAMIC_SPAWN_NATURE_DRAGON, "T3 Nature-Lucky Dynamic");
		dynamicSpawns.put(DYNAMIC_SPAWN_ECLECTIC, "T2 Eclectic Dynamic");
		dynamicSpawns.put(DYNAMIC_SPAWN_BABY_ESSENCE, "T1 Baby-Essence Dynamic");

		overlayManager.add(overlay);
		overlayManager.add(minimapOverlay);
		overlayManager.add(implingCounterOverlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		implings.clear();
		overlayManager.remove(overlay);
		overlayManager.remove(minimapOverlay);
		overlayManager.remove(implingCounterOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(NpcDefinitionChanged.class, this, this::onNpcDefinitionChanged);
	}

	private void onGameTick(GameTick event)
	{
		implingCounterMap.clear();
		for (NPC npc : implings)
		{
			Impling impling = Impling.findImpling(npc.getId());

			if (impling == null || impling.getImplingType() == null)
			{
				continue;
			}

			ImplingType type = impling.getImplingType();
			if (implingCounterMap.containsKey(type))
			{
				implingCounterMap.put(type, implingCounterMap.get(type) + 1);
			}
			else
			{
				implingCounterMap.put(type, 1);
			}
		}
	}

	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			implings.add(npc);
		}
	}

	private void onNpcDefinitionChanged(NpcDefinitionChanged npcCompositionChanged)
	{
		NPC npc = npcCompositionChanged.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null && !implings.contains(npc))
		{
			implings.add(npc);
		}
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			implings.clear();
			implingCounterMap.clear();
		}
	}

	private void onNpcDespawned(NpcDespawned npcDespawned)
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
			return true;
		}

		return !showImplingType(impling.getImplingType());
	}

	boolean showImplingType(ImplingType implingType)
	{
		switch (implingType)
		{
			case BABY:
				return this.showBaby;
			case YOUNG:
				return this.showYoung;
			case GOURMET:
				return this.showGourmet;
			case EARTH:
				return this.showEarth;
			case ESSENCE:
				return this.showEssence;
			case ECLECTIC:
				return this.showEclectic;
			case NATURE:
				return this.showNature;
			case MAGPIE:
				return this.showMagpie;
			case NINJA:
				return this.showNinja;
			case CRYSTAL:
				return this.showCrystal;
			case DRAGON:
				return this.showDragon;
			case LUCKY:
				return this.showLucky;
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

		return typeToColor(impling.getImplingType());
	}

	private Color typeToColor(ImplingType type)
	{
		switch (type)
		{

			case BABY:
				return this.getBabyColor;
			case YOUNG:
				return this.getYoungColor;
			case GOURMET:
				return this.getGourmetColor;
			case EARTH:
				return this.getEarthColor;
			case ESSENCE:
				return this.getEssenceColor;
			case ECLECTIC:
				return this.getEclecticColor;
			case NATURE:
				return this.getNatureColor;
			case MAGPIE:
				return this.getMagpieColor;
			case NINJA:
				return this.getNinjaColor;
			case CRYSTAL:
				return this.getCrystalColor;

			case DRAGON:
				return this.getDragonColor;
			case LUCKY:
				return this.getLuckyColor;
			default:
				return null;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("implings"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.showBaby = config.showBaby();
		this.getBabyColor = config.getBabyColor();
		this.showYoung = config.showYoung();
		this.getYoungColor = config.getYoungColor();
		this.showGourmet = config.showGourmet();
		this.getGourmetColor = config.getGourmetColor();
		this.showEarth = config.showEarth();
		this.getEarthColor = config.getEarthColor();
		this.showEssence = config.showEssence();
		this.getEssenceColor = config.getEssenceColor();
		this.showEclectic = config.showEclectic();
		this.getEclecticColor = config.getEclecticColor();
		this.showNature = config.showNature();
		this.getNatureColor = config.getNatureColor();
		this.showMagpie = config.showMagpie();
		this.getMagpieColor = config.getMagpieColor();
		this.showNinja = config.showNinja();
		this.getNinjaColor = config.getNinjaColor();
		this.showCrystal = config.showCrystal();
		this.getCrystalColor = config.getCrystalColor();
		this.showDragon = config.showDragon();
		this.getDragonColor = config.getDragonColor();
		this.showLucky = config.showLucky();
		this.getLuckyColor = config.getLuckyColor();
		this.showSpawn = config.showSpawn();
		this.getSpawnColor = config.getSpawnColor();
		this.showName = config.showName();
		this.getDynamicSpawnColor = config.getDynamicSpawnColor();
	}
}
