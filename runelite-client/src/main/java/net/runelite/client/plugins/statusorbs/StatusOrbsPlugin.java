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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.interfacestyles.InterfaceStylesPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Status Orbs",
	description = "Settings for the Minimap orbs (HP, Run, & Special Attack)",
	tags = {"hp", "heart", "minimap", "run", "energy"}
)
@Slf4j
public class StatusOrbsPlugin extends Plugin
{
	private static final BufferedImage HEART_NORMAL;
	private static final BufferedImage HEART_DISEASE;
	private static final BufferedImage HEART_POISON;
	private static final BufferedImage HEART_VENOM;
	static
	{
		HEART_NORMAL = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-NORMAL.png"), 26, 26);
		HEART_DISEASE = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-DISEASE.png"), 26, 26);
		HEART_POISON = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-POISON.png"), 26, 26);
		HEART_VENOM = ImageUtil.resizeCanvas(ImageUtil.getResourceStreamFromClass(StatusOrbsPlugin.class, "1067-VENOM.png"), 26, 26);
	}

	private static final int SPEC_REGEN_TICKS = 50;
	private static final int NORMAL_HP_REGEN_TICKS = 100;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private StatusOrbsConfig config;;

	@Inject
	private StatusOrbsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Getter
	private double hitpointsPercentage;

	@Getter
	private double specialPercentage;

	// HeartDisplay
	private BufferedImage currentHeart;

	// RegenMeter
	private int ticksSinceSpecRegen;
	private int ticksSinceHPRegen;
	private boolean wasRapidHeal;

	@Provides
	StatusOrbsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusOrbsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		if (config.dynamicHpHeart())
		{
			clientThread.invoke(this::checkHealthIcon);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
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
		// Dynamic HP Heart
		checkHealthIcon();

		// RegenMeter
		boolean isRapidHeal = client.isPrayerActive(Prayer.RAPID_HEAL);
		if (wasRapidHeal != isRapidHeal)
		{
			ticksSinceHPRegen = 0;
		}
		wasRapidHeal = isRapidHeal;
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged ev)
	{
		if (ev.getGameState() == GameState.HOPPING || ev.getGameState() == GameState.LOGIN_SCREEN)
		{
			ticksSinceHPRegen = -2; // For some reason this makes this accurate
			ticksSinceSpecRegen = 0;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) == 1000)
		{
			// The recharge doesn't tick when at 100%
			ticksSinceSpecRegen = 0;
		}
		else
		{
			ticksSinceSpecRegen = (ticksSinceSpecRegen + 1) % SPEC_REGEN_TICKS;
		}
		specialPercentage = ticksSinceSpecRegen / (double) SPEC_REGEN_TICKS;


		int ticksPerHPRegen = NORMAL_HP_REGEN_TICKS;
		if (client.isPrayerActive(Prayer.RAPID_HEAL))
		{
			ticksPerHPRegen /= 2;
		}

		ticksSinceHPRegen = (ticksSinceHPRegen + 1) % ticksPerHPRegen;
		hitpointsPercentage = ticksSinceHPRegen / (double) ticksPerHPRegen;

		int currentHP = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int maxHP = client.getRealSkillLevel(Skill.HITPOINTS);
		if (currentHP == maxHP && !config.showWhenNoChange())
		{
			hitpointsPercentage = 0;
		}
		else if (currentHP > maxHP)
		{
			// Show it going down
			hitpointsPercentage = 1 - hitpointsPercentage;
		}
	}

	/**
	 * Check player afflictions to determine health icon
	 */
	private void checkHealthIcon()
	{
		int poison = client.getVar(VarPlayer.IS_POISONED);
		boolean isVenomed = poison >= 1000000;
		boolean isPoisoned = !isVenomed && poison > 0;
		boolean isDiseased = client.getVar(VarPlayer.DISEASE_VALUE) > 0;

		BufferedImage old = currentHeart;

		currentHeart = isVenomed ? HEART_VENOM : isPoisoned ? HEART_POISON : isDiseased ? HEART_DISEASE : HEART_NORMAL;

		if (old != currentHeart)
		{
			client.getWidgetSpriteCache().reset();
			client.getSpriteOverrides().put(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, InterfaceStylesPlugin.getImageSpritePixels(currentHeart, client));
		}
	}

	/**
	 * Ensure the HP Heart is the default Sprite
	 */
	private void resetHealthIcon()
	{
		client.getWidgetSpriteCache().reset();
		client.getSpriteOverrides().remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON);
		currentHeart = null;
	}
}
