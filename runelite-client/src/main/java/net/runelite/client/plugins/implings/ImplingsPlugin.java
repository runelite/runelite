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

import com.google.common.eventbus.Subscribe;
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

/**
 *
 * @author robin
 */
@PluginDescriptor(
	name = "Implings"
)
public class ImplingsPlugin extends Plugin
{
	private static final int DYNAMIC_SPAWN_NATURE_DRAGON = 1618;
	private static final int DYNAMIC_SPAWN_ECLECTIC = 1633;
	private static final int DYNAMIC_SPAWN_BABY_ESSENCE = 1634;

	@Getter(AccessLevel.PACKAGE)
	private NPC[] implings;

	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, Color> ids = new HashMap<>();
	
	@Getter(AccessLevel.PACKAGE)
	private Map<WorldPoint, String> staticSpawns = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, String> dynamicSpawns = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private List<String> hideSpawns;

	@Inject
	private ImplingsOverlay overlay;

	@Inject
	private ImplingMinimapOverlay minimapOverlay;

	@Inject
	private ImplingsConfig config;

	@Inject
	private QueryRunner queryRunner;

	@Provides
	ImplingsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		// Initialize overlay config
		updateConfig();
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, minimapOverlay);
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		updateConfig();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		NPCQuery implingQuery = new NPCQuery()
			.idEquals(Ints.toArray(ids.keySet()));
		implings = queryRunner.runQuery(implingQuery);
	}

	public void updateConfig()
	{
		ids.clear();
		if (config.showBaby())
		{
			ids.put(NpcID.BABY_IMPLING, config.getBabyColor());
			ids.put(NpcID.BABY_IMPLING_1645, config.getBabyColor());
		}
		if (config.showYoung())
		{
			ids.put(NpcID.YOUNG_IMPLING, config.getYoungColor());
			ids.put(NpcID.YOUNG_IMPLING_1646, config.getYoungColor());
		}
		if (config.showGourmet())
		{
			ids.put(NpcID.GOURMET_IMPLING, config.getGourmetColor());
			ids.put(NpcID.GOURMET_IMPLING_1647, config.getGourmetColor());
		}
		if (config.showEarth())
		{
			ids.put(NpcID.EARTH_IMPLING, config.getEarthColor());
			ids.put(NpcID.EARTH_IMPLING_1648, config.getEarthColor());
		}
		if (config.showEssence())
		{
			ids.put(NpcID.ESSENCE_IMPLING, config.getEssenceColor());
			ids.put(NpcID.ESSENCE_IMPLING_1649, config.getEssenceColor());
		}
		if (config.showEclectic())
		{
			ids.put(NpcID.ECLECTIC_IMPLING, config.getEclecticColor());
			ids.put(NpcID.ECLECTIC_IMPLING_1650, config.getEclecticColor());
		}
		if (config.showNature())
		{
			ids.put(NpcID.NATURE_IMPLING, config.getNatureColor());
			ids.put(NpcID.NATURE_IMPLING_1651, config.getNatureColor());
		}
		if (config.showMagpie())
		{
			ids.put(NpcID.MAGPIE_IMPLING, config.getMagpieColor());
			ids.put(NpcID.MAGPIE_IMPLING_1652, config.getMagpieColor());
		}
		if (config.showNinja())
		{
			ids.put(NpcID.NINJA_IMPLING, config.getNinjaColor());
			ids.put(NpcID.NINJA_IMPLING_1653, config.getNinjaColor());
		}
		if (config.showDragon())
		{
			ids.put(NpcID.DRAGON_IMPLING, config.getDragonColor());
			ids.put(NpcID.DRAGON_IMPLING_1654, config.getDragonColor());
		}
		if (config.showLucky())
		{
			ids.put(NpcID.LUCKY_IMPLING, config.getLuckyColor());
			ids.put(NpcID.LUCKY_IMPLING_7302, config.getLuckyColor());
		}
		if (config.showSpawn())
		{
			UpdateList();
			dynamicSpawns.put(DYNAMIC_SPAWN_NATURE_DRAGON, "T3 Nature-Dragon Dynamic");
			dynamicSpawns.put(DYNAMIC_SPAWN_ECLECTIC, "T2 Eclectic Dynamic");
			dynamicSpawns.put(DYNAMIC_SPAWN_BABY_ESSENCE, "T1 Baby-Essence Dynamic");
			staticSpawns = ImplingPuroPuroSpawn.getSpawns();
		}
	}
	private void UpdateList()
	{
		String toHide = config.getHiddenSpawns().toLowerCase();
		hideSpawns = Arrays.asList(toHide.split("\\s*,\\s*"));
	}
}
