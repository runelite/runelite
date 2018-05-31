/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "World Map"
)
public class WorldMapPlugin extends Plugin
{
	static final BufferedImage BLANK_ICON;
	static final BufferedImage FAIRY_TRAVEL_ICON;
	static final BufferedImage NOPE_ICON;

	static final String CONFIG_KEY = "worldmap";
	static final String CONFIG_KEY_FAIRY_RING_TOOLTIPS = "fairyRingTooltips";
	static final String CONFIG_KEY_FAIRY_RING_ICON = "fairyRingIcon";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS = "agilityShortcutTooltips";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON = "agilityShortcutIcon";
	static final String CONFIG_KEY_NORMAL_TELEPORT_ICON = "standardSpellbookIcon";
	static final String CONFIG_KEY_ANCIENT_TELEPORT_ICON = "ancientSpellbookIcon";
	static final String CONFIG_KEY_LUNAR_TELEPORT_ICON = "lunarSpellbookIcon";
	static final String CONFIG_KEY_ARCEUUS_TELEPORT_ICON = "arceuusSpellbookIcon";
	static final String CONFIG_KEY_JEWELLERY_TELEPORT_ICON = "jewelleryIcon";
	static final String CONFIG_KEY_SCROLL_TELEPORT_ICON = "scrollIcon";
	static final String CONFIG_KEY_MISC_TELEPORT_ICON = "miscellaneousTeleportIcon";

	static
	{
		//A size of 17 gives us a buffer when triggering tooltips
		final int iconBufferSize = 17;

		BLANK_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);

		try
		{
			synchronized (ImageIO.class)
			{
				FAIRY_TRAVEL_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
				final BufferedImage icon = ImageIO.read(WorldMapPlugin.class.getResourceAsStream("fairy_ring_travel.png"));
				FAIRY_TRAVEL_ICON.getGraphics().drawImage(icon, 1, 1, null);

				NOPE_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
				final BufferedImage nopeImage = ImageIO.read(WorldMapPlugin.class.getResourceAsStream("nope_icon.png"));
				NOPE_ICON.getGraphics().drawImage(nopeImage, 1, 1, null);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Inject
	private Client client;

	@Inject
	private WorldMapConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	private int agilityLevel = 0;

	@Provides
	WorldMapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldMapConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_KEY))
		{
			switch (event.getKey())
			{
				case CONFIG_KEY_FAIRY_RING_TOOLTIPS:
					if (config.fairyRingTooltips())
					{
						Arrays.stream(FairyRingLocation.values())
							.map(FairyRingLocation::getFairyRingPoint)
							.forEach(worldMapPointManager::add);
					}
					else
					{
						worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
					}
					break;
				case CONFIG_KEY_FAIRY_RING_ICON:
					FairyRingLocation.setIcon(config.fairyRingIcon() ? FAIRY_TRAVEL_ICON : BLANK_ICON);
					break;
				case CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS:
				case CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON:
					worldMapPointManager.removeIf(AgilityShortcutPoint.class::isInstance);

					if (config.agilityShortcutTooltips())
					{
						int agilityLevel = client.getRealSkillLevel(Skill.AGILITY);
						Arrays.stream(AgilityShortcutLocation.values())
							.map(value -> new AgilityShortcutPoint(value, config.agilityShortcutLevelIcon() && value.getLevelReq() > agilityLevel ? NOPE_ICON : BLANK_ICON))
							.forEach(worldMapPointManager::add);
					}
				case CONFIG_KEY_NORMAL_TELEPORT_ICON:
				case CONFIG_KEY_ANCIENT_TELEPORT_ICON:
				case CONFIG_KEY_LUNAR_TELEPORT_ICON:
				case CONFIG_KEY_ARCEUUS_TELEPORT_ICON:
				case CONFIG_KEY_JEWELLERY_TELEPORT_ICON:
				case CONFIG_KEY_MISC_TELEPORT_ICON:
				case CONFIG_KEY_SCROLL_TELEPORT_ICON:
					worldMapPointManager.removeIf(TeleportPoint.class::isInstance);
					createMagicTeleportPoints();
					break;
			}
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		FairyRingLocation.setIcon(config.fairyRingIcon() ? FAIRY_TRAVEL_ICON : BLANK_ICON);

		if (config.fairyRingTooltips())
		{
			Arrays.stream(FairyRingLocation.values())
				.map(FairyRingLocation::getFairyRingPoint)
				.forEach(worldMapPointManager::add);
		}
		if (config.agilityShortcutTooltips())
		{
			Arrays.stream(AgilityShortcutLocation.values())
				.map(value -> new AgilityShortcutPoint(value, BLANK_ICON))
				.forEach(worldMapPointManager::add);
		}

		if (config.normalTeleportIcon()
			|| config.ancientTeleportIcon()
			|| config.lunarTeleportIcon()
			|| config.arceuusTeleportIcon()
			|| config.jewelleryTeleportIcon()
			|| config.miscellaneousTeleportIcon()
			|| config.scrollTeleportIcon())
		{
			createMagicTeleportPoints();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
		worldMapPointManager.removeIf(AgilityShortcutPoint.class::isInstance);
		worldMapPointManager.removeIf(TeleportPoint.class::isInstance);
	}

	@Subscribe
	public void onXpChanged(ExperienceChanged event)
	{
		if (event.getSkill() == Skill.AGILITY)
		{
			int newAgilityLevel = Experience.getLevelForXp(client.getSkillExperience(Skill.AGILITY));
			if (config.agilityShortcutLevelIcon() && newAgilityLevel != agilityLevel)
			{
				agilityLevel = newAgilityLevel;

				worldMapPointManager.removeIf(AgilityShortcutPoint.class::isInstance);
				Arrays.stream(AgilityShortcutLocation.values())
					.map(value -> new AgilityShortcutPoint(value, config.agilityShortcutLevelIcon() && value.getLevelReq() > agilityLevel ? NOPE_ICON : BLANK_ICON))
					.forEach(worldMapPointManager::add);
			}
		}
	}

	private void createMagicTeleportPoints()
	{
		Arrays.stream(TeleportLocationData.values())
			.filter(data ->
			{
				switch (data.getType())
				{
					case NORMAL_MAGIC:
						return config.normalTeleportIcon();
					case ANCIENT_MAGICKS:
						return config.ancientTeleportIcon();
					case LUNAR_MAGIC:
						return config.lunarTeleportIcon();
					case ARCEUUS_MAGIC:
						return config.arceuusTeleportIcon();
					case JEWELLERY:
						return config.jewelleryTeleportIcon();
					case SCROLL:
						return config.scrollTeleportIcon();
					case OTHER:
						return config.miscellaneousTeleportIcon();
					default:
						return false;
				}
			}).map(TeleportPoint::new)
			.forEach(worldMapPointManager::add);
	}
}
