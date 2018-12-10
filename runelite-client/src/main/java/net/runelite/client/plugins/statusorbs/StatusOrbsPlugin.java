/*
 * Copyright (c) 2018 TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.statusorbs;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import javax.inject.Inject;
import net.runelite.api.Affliction;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Status Orbs",
	description = "Settings for the Minimap orbs (HP, Run, & Special Attack)",
	tags = {"hp", "heart", "minimap", "run", "energy"}
)
public class StatusOrbsPlugin extends Plugin
{
	private static final BufferedImage HEART_DISEASE;
	private static final BufferedImage HEART_POISON;
	private static final BufferedImage HEART_VENOM;
	static
	{
		HEART_DISEASE = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-DISEASE.png"), 26, 26);
		HEART_POISON = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-POISON.png"), 26, 26);
		HEART_VENOM = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-VENOM.png"), 26, 26);
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private StatusOrbsConfig config;

	// HeartDisplay
	private EnumSet<Affliction> currentAfflictions;

	@Provides
	StatusOrbsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusOrbsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (config.dynamicHpHeart())
		{
			clientThread.invoke(this::checkHealthIcon);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (config.dynamicHpHeart())
		{
			clientThread.invoke(this::resetHealthIcon);
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged c)
	{
		if (c.getGroup().equals("statusorbs"))
		{
			switch (c.getKey())
			{
				case "dynamicHpHeart":
					if (config.dynamicHpHeart())
					{
						checkHealthIcon();
					}
					else
					{
						resetHealthIcon();
					}
					break;
				default:
					return;
			}
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged e)
	{
		if (config.dynamicHpHeart())
		{
			checkHealthIcon();
		}
	}

	/**
	 * Check player afflictions to determine health icon
	 */
	private void checkHealthIcon()
	{
		EnumSet<Affliction> old = currentAfflictions;
		currentAfflictions = client.getCurrentAfflictions();

		if (!old.equals(currentAfflictions))
		{
			BufferedImage heart;
			if (currentAfflictions.contains(Affliction.VENOMED))
			{
				heart = HEART_VENOM;

			}
			else if (currentAfflictions.contains(Affliction.POISONED))
			{
				heart = HEART_POISON;
			}
			else if (currentAfflictions.contains(Affliction.DISEASED))
			{
				heart = HEART_DISEASE;
			}
			else
			{
				resetHealthIcon();
				return;
			}

			client.getWidgetSpriteCache().reset();
			client.getSpriteOverrides().put(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, ImageUtil.getImageSpritePixels(heart, client));
		}
	}

	/**
	 * Ensure the HP Heart is the default Sprite
	 */
	private void resetHealthIcon()
	{
		client.getWidgetSpriteCache().reset();
		client.getSpriteOverrides().remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON);
		currentAfflictions = null;
	}
}
