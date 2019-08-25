/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.boosts;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Boosts Information",
	description = "Show combat and/or skill boost information",
	tags = {"combat", "notifications", "skilling", "overlay"}
)
@Singleton
public class BoostsPlugin extends Plugin
{
	private static final Set<Skill> BOOSTABLE_COMBAT_SKILLS = ImmutableSet.of(
		Skill.ATTACK,
		Skill.STRENGTH,
		Skill.DEFENCE,
		Skill.RANGED,
		Skill.MAGIC);

	private static final Set<Skill> BOOSTABLE_NON_COMBAT_SKILLS = ImmutableSet.of(
		Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
		Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER);

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BoostsOverlay boostsOverlay;

	//made this a LinkedHashSet so the order stays consistent for my OCD
	@Getter
	private final Set<Skill> shownSkills = new LinkedHashSet<>();
	@Inject
	private BoostsConfig config;

	@Inject
	private SkillIconManager skillIconManager;
	@Inject
	private CombatIconsOverlay combatIconsOverlay;
	@Inject
	private EventBus eventBus;

	private boolean isChangedDown = false;
	private boolean isChangedUp = false;
	private final int[] lastSkillLevels = new int[Skill.values().length - 1];
	private int lastChangeDown = -1;
	private int lastChangeUp = -1;
	private boolean preserveBeenActive = false;
	private long lastTickMillis;
	private final List<String> boostedSkillsChanged = new ArrayList<>();

	private boolean enableSkill;
	@Getter(AccessLevel.PACKAGE)
	private boolean useRelativeBoost;
	@Getter(AccessLevel.PACKAGE)
	private boolean displayInfoboxes;
	@Getter(AccessLevel.PACKAGE)
	private boolean displayIcons;
	@Getter(AccessLevel.PACKAGE)
	private boolean boldIconFont;
	private BoostsConfig.DisplayChangeMode displayNextBuffChange;
	private BoostsConfig.DisplayChangeMode displayNextDebuffChange;
	@Getter(AccessLevel.PACKAGE)
	private int boostThreshold;
	private boolean groupNotifications;

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(boostsOverlay);
		overlayManager.add(combatIconsOverlay);
		updateShownSkills();
		updateBoostedStats();
		Arrays.fill(lastSkillLevels, -1);

		// Add infoboxes for everything at startup and then determine inside if it will be rendered
		infoBoxManager.addInfoBox(new StatChangeIndicator(true, ImageUtil.getResourceStreamFromClass(getClass(), "debuffed.png"), this, config));
		infoBoxManager.addInfoBox(new StatChangeIndicator(false, ImageUtil.getResourceStreamFromClass(getClass(), "buffed.png"), this, config));

		for (final Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				infoBoxManager.addInfoBox(new BoostIndicator(skill, skillIconManager.getSkillImage(skill), this, client));
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(boostsOverlay);
		overlayManager.remove(combatIconsOverlay);
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator || t instanceof StatChangeIndicator);
		preserveBeenActive = false;
		lastChangeDown = -1;
		lastChangeUp = -1;
		isChangedUp = false;
		isChangedDown = false;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(BoostedLevelChanged.class, this, this::onBoostedLevelChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case HOPPING:
				// After world hop and log out timers are in undefined state so just reset
				lastChangeDown = -1;
				lastChangeUp = -1;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("boosts"))
		{
			return;
		}

		updateConfig();
		updateShownSkills();

		if (this.displayNextBuffChange == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeDown = -1;
		}

		if (this.displayNextDebuffChange == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeUp = -1;
		}
	}

	private void onBoostedLevelChanged(BoostedLevelChanged boostedLevelChanged)
	{
		Skill skill = boostedLevelChanged.getSkill();

		if (!BOOSTABLE_COMBAT_SKILLS.contains(skill) && !BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
		{
			return;
		}

		int skillIdx = skill.ordinal();
		int last = lastSkillLevels[skillIdx];
		int cur = client.getBoostedSkillLevel(skill);

		if (cur == last - 1)
		{
			// Stat was restored down (from buff)
			lastChangeDown = client.getTickCount();
		}

		if (cur == last + 1)
		{
			// Stat was restored up (from debuff)
			lastChangeUp = client.getTickCount();
		}

		lastSkillLevels[skillIdx] = cur;
		updateBoostedStats();

		int boostThreshold = this.boostThreshold;

		if (boostThreshold != 0)
		{
			int real = client.getRealSkillLevel(skill);
			int lastBoost = last - real;
			int boost = cur - real;
			if (boost <= boostThreshold && boostThreshold < lastBoost)
			{
				if (this.groupNotifications)
				{
					boostedSkillsChanged.add(skill.getName());
				}
				else
				{
					notifier.notify(skill.getName() + " level is getting low!");
				}
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		lastTickMillis = System.currentTimeMillis();

		if (this.groupNotifications && !boostedSkillsChanged.isEmpty())
		{
			if (boostedSkillsChanged.size() == 1)
			{
				notifier.notify(boostedSkillsChanged.get(0) + " level is getting low!");
			}
			else
			{
				String notification = "";
				for (int i = 0; i < boostedSkillsChanged.size(); i++)
				{
					if (i == 0)
					{
						notification = boostedSkillsChanged.get(i);
					}
					else if (i < boostedSkillsChanged.size() - 1)
					{
						notification = notification + ", " + boostedSkillsChanged.get(i);
					}
					else
					{
						notification = notification + " and " + boostedSkillsChanged.get(i) + " levels are getting low!";
						notifier.notify(notification);
					}
				}
			}
			boostedSkillsChanged.clear();
		}

		if (getChangeUpTicks() <= 0)
		{
			switch (this.displayNextDebuffChange)
			{
				case ALWAYS:
					if (lastChangeUp != -1)
					{
						lastChangeUp = client.getTickCount();
					}

					break;
				case BOOSTED:
				case NEVER:
					lastChangeUp = -1;
					break;
			}
		}

		if (getChangeDownTicks() <= 0)
		{
			switch (this.displayNextBuffChange)
			{
				case ALWAYS:
					if (lastChangeDown != -1)
					{
						lastChangeDown = client.getTickCount();
					}

					break;
				case BOOSTED:
				case NEVER:
					lastChangeDown = -1;
					break;
			}
		}
	}

	private void updateShownSkills()
	{
		if (this.enableSkill)
		{
			shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS);
		}
		else
		{
			shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS);
		}

		shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS);
	}

	private void updateBoostedStats()
	{
		// Reset is boosted
		isChangedDown = false;
		isChangedUp = false;

		// Check if we are still boosted
		for (final Skill skill : Skill.values())
		{
			if (!BOOSTABLE_COMBAT_SKILLS.contains(skill) && !BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
			{
				continue;
			}

			final int boosted = client.getBoostedSkillLevel(skill);
			final int base = client.getRealSkillLevel(skill);

			if (boosted > base)
			{
				isChangedUp = true;
			}
			else if (boosted < base)
			{
				isChangedDown = true;
			}
		}
	}

	boolean canShowBoosts()
	{
		return isChangedDown || isChangedUp;
	}

	/**
	 * Calculates the amount of time until boosted stats decay,
	 * accounting for the effect of preserve prayer.
	 * Preserve extends the time of boosted stats by 50% while active.
	 * The length of a boost is split into 4 sections of 15 seconds each.
	 * If the preserve prayer is active for the entire duration of the final
	 * section it will "activate" adding an additional 15 second section
	 * to the boost timing. If again the preserve prayer is active for that
	 * entire section a second 15 second section will be added.
	 * <p>
	 * Preserve is only required to be on for the 4th and 5th sections of the boost timer
	 * to gain full effect (seconds 45-75).
	 *
	 * @return integer value in ticks until next boost change
	 */
	int getChangeDownTicks()
	{
		if (lastChangeDown == -1 ||
			this.displayNextBuffChange == BoostsConfig.DisplayChangeMode.NEVER ||
			(this.displayNextBuffChange == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedUp))
		{
			return -1;
		}

		int ticksSinceChange = client.getTickCount() - lastChangeDown;
		boolean isPreserveActive = client.isPrayerActive(Prayer.PRESERVE);

		if ((isPreserveActive && (ticksSinceChange < 75 || preserveBeenActive)) || ticksSinceChange > 125)
		{
			preserveBeenActive = true;
			return 150 - ticksSinceChange;
		}

		preserveBeenActive = false;
		return (ticksSinceChange > 100) ? 125 - ticksSinceChange : 100 - ticksSinceChange;
	}

	/**
	 * Restoration from debuff is separate timer as restoration from buff because of preserve messing up the buff timer.
	 * Restoration timer is always in 100 tick cycles.
	 *
	 * @return integer value in ticks until next stat restoration up
	 */
	int getChangeUpTicks()
	{
		if (lastChangeUp == -1 ||
			this.displayNextDebuffChange == BoostsConfig.DisplayChangeMode.NEVER ||
			(this.displayNextDebuffChange == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedDown))
		{
			return -1;
		}

		int ticksSinceChange = client.getTickCount() - lastChangeUp;
		return 100 - ticksSinceChange;
	}


	/**
	 * Converts tick-based time to accurate second time
	 *
	 * @param time tick-based time
	 * @return second-based time
	 */
	int getChangeTime(final int time)
	{
		final long diff = System.currentTimeMillis() - lastTickMillis;
		return time != -1 ? (int) ((time * Constants.GAME_TICK_LENGTH - diff) / 1000d) : time;
	}

	private void updateConfig()
	{
		this.enableSkill = config.enableSkill();
		this.useRelativeBoost = config.useRelativeBoost();
		this.displayInfoboxes = config.displayInfoboxes();
		this.displayIcons = config.displayIcons();
		this.boldIconFont = config.boldIconFont();
		this.displayNextBuffChange = config.displayNextBuffChange();
		this.displayNextDebuffChange = config.displayNextDebuffChange();
		this.boostThreshold = config.boostThreshold();
		this.groupNotifications = config.groupNotifications();
	}
}
