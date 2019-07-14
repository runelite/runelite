/*
 * Copyright (c) 2019, Owain van Brakel <https://github.com/Owain94>
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Zimaya <https://github.com/Zimaya>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Graceful;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Status Orbs",
	description = "Configure settings for the Minimap orbs",
	tags = {"minimap", "orb", "regen", "energy", "special"}
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

	private static final int SPEC_REGEN_TICKS = 50;
	private static final int NORMAL_HP_REGEN_TICKS = 100;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private StatusOrbsConfig config;

	@Inject
	private StatusOrbsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Notifier notifier;

	@Inject
	private EventBus eventBus;

	@Getter
	private double hitpointsPercentage;

	@Getter
	private double specialPercentage;

	@Getter
	private double runPercentage;

	@Getter
	private double hpPerMs;

	@Getter
	private double specPerMs = (double) 1 / (SPEC_REGEN_TICKS * 600);

	// RegenMeter
	private int ticksSinceSpecRegen;
	private int ticksSinceHPRegen;
	private boolean wasRapidHeal;
	private double ticksSinceRunRegen;

	// Run Energy
	private int lastEnergy = 0;
	private boolean localPlayerRunningToDestination;
	private WorldPoint currPoint;
	private WorldPoint prevLocalPlayerLocation;

	private BufferedImage heart;

	private boolean dynamicHpHeart;
	@Getter(AccessLevel.PACKAGE)
	private boolean showHitpoints;
	private boolean showWhenNoChange;
	private int getNotifyBeforeHpRegenSeconds;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSpecial;
	@Getter(AccessLevel.PACKAGE)
	private boolean showRun;
	@Getter(AccessLevel.PACKAGE)
	private boolean replaceOrbText;

	@Provides
	StatusOrbsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusOrbsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		if (this.dynamicHpHeart && client.getGameState().equals(GameState.LOGGED_IN))
		{
			clientThread.invoke(this::checkHealthIcon);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		localPlayerRunningToDestination = false;
		prevLocalPlayerLocation = null;
		resetRunOrbText();
		if (this.dynamicHpHeart)
		{
			clientThread.invoke(this::resetHealthIcon);
		}
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("statusorbs"))
		{
			updateConfig();
			switch (event.getKey())
			{
				case "replaceOrbText":
					if (!this.replaceOrbText)
					{
						resetRunOrbText();
					}
					break;
				case "dynamicHpHeart":
					if (this.dynamicHpHeart)
					{
						checkHealthIcon();
					}
					else
					{
						resetHealthIcon();
					}
					break;
			}
		}
	}

	private void onVarbitChanged(VarbitChanged e)
	{
		if (this.dynamicHpHeart)
		{
			checkHealthIcon();
		}

		boolean isRapidHeal = client.isPrayerActive(Prayer.RAPID_HEAL);
		if (wasRapidHeal != isRapidHeal)
		{
			ticksSinceHPRegen = 0;
		}
		wasRapidHeal = isRapidHeal;
	}

	private void onGameStateChanged(GameStateChanged ev)
	{
		if (ev.getGameState() == GameState.HOPPING || ev.getGameState() == GameState.LOGIN_SCREEN)
		{
			ticksSinceHPRegen = -2; // For some reason this makes this accurate
			ticksSinceSpecRegen = 0;
			ticksSinceRunRegen = -1;
		}
	}

	private void onGameTick(GameTick event)
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
		hpPerMs = ticksPerHPRegen / (double) 6000000;
		if (client.isPrayerActive(Prayer.RAPID_HEAL))
		{
			ticksPerHPRegen /= 2;
			hpPerMs *= 2;
		}

		ticksSinceHPRegen = (ticksSinceHPRegen + 1) % ticksPerHPRegen;
		hitpointsPercentage = ticksSinceHPRegen / (double) ticksPerHPRegen;

		int currentHP = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int maxHP = client.getRealSkillLevel(Skill.HITPOINTS);
		if (currentHP == maxHP && !this.showWhenNoChange)
		{
			hitpointsPercentage = 0;
		}
		else if (currentHP > maxHP)
		{
			// Show it going down
			hitpointsPercentage = 1 - hitpointsPercentage;
		}

		// Run Energy
		localPlayerRunningToDestination =
			prevLocalPlayerLocation != null &&
				client.getLocalDestinationLocation() != null &&
				prevLocalPlayerLocation.distanceTo(client.getLocalPlayer().getWorldLocation()) > 1;

		if (this.getNotifyBeforeHpRegenSeconds > 0 && currentHP < maxHP && shouldNotifyHpRegenThisTick(ticksPerHPRegen))
		{
			notifier.notify("[" + client.getLocalPlayer().getName() + "] regenerates their next hitpoint soon!");
		}

		localPlayerRunningToDestination =
			prevLocalPlayerLocation != null &&
				client.getLocalDestinationLocation() != null &&
				prevLocalPlayerLocation.distanceTo(client.getLocalPlayer().getWorldLocation()) > 1;

		prevLocalPlayerLocation = client.getLocalPlayer().getWorldLocation();

		if (this.replaceOrbText)
		{
			setRunOrbText(getEstimatedRunTimeRemaining(true));
		}

		int currEnergy = client.getEnergy();
		currPoint = client.getLocalPlayer().getWorldLocation();
		if (currEnergy == 100 || (prevLocalPlayerLocation != null && currPoint.distanceTo(prevLocalPlayerLocation) > 1) || currEnergy < lastEnergy)
		{
			ticksSinceRunRegen = 0;
		}
		else if (currEnergy > lastEnergy)
		{
			if (runPercentage < 1)
			{
				ticksSinceRunRegen = (1 - runPercentage) / runRegenPerTick();
				ticksSinceRunRegen = ticksSinceRunRegen > 1 ? 1 : ticksSinceRunRegen;
			}
			else
			{
				ticksSinceRunRegen = (runPercentage - 1) / runRegenPerTick();
			}
		}
		else
		{
			ticksSinceRunRegen += 1;
		}
		runPercentage = ticksSinceRunRegen * runRegenPerTick();
		prevLocalPlayerLocation = currPoint;
		lastEnergy = currEnergy;
	}

	private boolean shouldNotifyHpRegenThisTick(int ticksPerHPRegen)
	{
		// if the configured duration lies between two ticks, choose the earlier tick
		final int ticksBeforeHPRegen = ticksPerHPRegen - ticksSinceHPRegen;
		final int notifyTick = (int) Math.ceil(this.getNotifyBeforeHpRegenSeconds * 1000d / Constants.GAME_TICK_LENGTH);
		return ticksBeforeHPRegen == notifyTick;
	}

	private void setRunOrbText(String text)
	{
		Widget runOrbText = client.getWidget(WidgetInfo.MINIMAP_RUN_ORB_TEXT);

		if (runOrbText != null)
		{
			runOrbText.setText(text);
		}
	}

	private void resetRunOrbText()
	{
		setRunOrbText(Integer.toString(client.getEnergy()));
	}

	String getEstimatedRunTimeRemaining(boolean inSeconds)
	{
		// Calculate the amount of energy lost every 2 ticks (0.6 seconds).
		// Negative weight has the same depletion effect as 0 kg.
		final int effectiveWeight = Math.max(client.getWeight(), 0);
		double lossRate = (Math.min(effectiveWeight, 64) / 100.0) + 0.64;

		if (client.getVar(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
		{
			lossRate *= 0.3; // Stamina effect reduces energy depletion to 30%
		}

		// Calculate the number of seconds left
		final double secondsLeft = (client.getEnergy() * 0.6) / lossRate;

		// Return the text
		if (inSeconds)
		{
			return (int) Math.floor(secondsLeft) + "s";
		}
		else
		{
			final int minutes = (int) Math.floor(secondsLeft / 60.0);
			final int seconds = (int) Math.floor(secondsLeft - (minutes * 60.0));

			return minutes + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, "0");
		}
	}

	int getEstimatedRecoverTimeRemaining()
	{
		if (localPlayerRunningToDestination)
		{
			return -1;
		}

		// Calculate the amount of energy recovered every second
		double recoverRate = (48 + client.getBoostedSkillLevel(Skill.AGILITY)) / 360.0;

		if (Graceful.hasFullSet(client.getItemContainer(InventoryID.EQUIPMENT)))
		{
			recoverRate *= 1.3; // 30% recover rate increase from Graceful set effect
		}

		// Calculate the number of seconds left
		final double secondsLeft = (100 - client.getEnergy()) / recoverRate;
		return (int) secondsLeft;
	}

	/**
	 * Check player afflictions to determine health icon
	 */
	private void checkHealthIcon()
	{
		BufferedImage newHeart;

		int poison = client.getVar(VarPlayer.IS_POISONED);
		if (poison >= 1000000)
		{
			newHeart = HEART_VENOM;
		}
		else if (poison > 0)
		{
			newHeart = HEART_POISON;
		}
		else if (client.getVar(VarPlayer.DISEASE_VALUE) > 0)
		{
			newHeart = HEART_DISEASE;
		}
		else
		{
			heart = null;
			resetHealthIcon();
			return;
		}

		// Only update sprites when the heart icon actually changes
		if (newHeart != heart)
		{
			heart = newHeart;
			client.getWidgetSpriteCache().reset();
			client.getSpriteOverrides().put(SpriteID.MINIMAP_ORB_HITPOINTS_ICON, ImageUtil.getImageSprite(heart, client));
		}
	}

	private double runRegenPerTick()
	{
		double recoverRate = (client.getBoostedSkillLevel(Skill.AGILITY) / 6d + 8) / 100;

		if (Graceful.hasFullSet(client.getItemContainer(InventoryID.EQUIPMENT)))
		{
			return recoverRate * 1.3;
		}
		return recoverRate;
	}

	/**
	 * Ensure the HP Heart is the default Sprite
	 */
	private void resetHealthIcon()
	{
		client.getWidgetSpriteCache().reset();
		client.getSpriteOverrides().remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON);
	}

	/**
	 * Migrates configs from runenergy and regenmeter to this plugin and deletes the old config values.
	 * This method should be removed after a reasonable amount of time.
	 */
	@Deprecated
	private void migrateConfigs()
	{
		migrateConfig("regenmeter", "showHitpoints");
		migrateConfig("regenmeter", "showSpecial");
		migrateConfig("regenmeter", "showWhenNoChange");
		migrateConfig("regenmeter", "notifyBeforeHpRegenDuration");

		migrateConfig("runenergy", "replaceOrbText");
	}

	/**
	 * Wrapper for migrating individual config options
	 * This method should be removed after a reasonable amount of time.
	 *
	 * @param group old group name
	 * @param key   key name to migrate
	 */
	@Deprecated
	private void migrateConfig(String group, String key)
	{
		String value = configManager.getConfiguration(group, key);
		if (value != null)
		{
			configManager.setConfiguration("statusorbs", key, value);
			configManager.unsetConfiguration(group, key);
		}
	}

	private void updateConfig()
	{
		this.dynamicHpHeart = config.dynamicHpHeart();
		this.showHitpoints = config.showHitpoints();
		this.showWhenNoChange = config.showWhenNoChange();
		this.getNotifyBeforeHpRegenSeconds = config.getNotifyBeforeHpRegenSeconds();
		this.showSpecial = config.showSpecial();
		this.showRun = config.showRun();
		this.replaceOrbText = config.replaceOrbText();
	}
}