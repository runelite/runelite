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
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.StatChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
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

	@Inject
	private CompactBoostsOverlay compactBoostsOverlay;

	@Inject
	private BoostsConfig config;

	@Inject
	private SkillIconManager skillIconManager;

	@Getter
	private final Set<Skill> skillsToDisplay = EnumSet.noneOf(Skill.class);

	private final Set<Skill> shownSkills = EnumSet.noneOf(Skill.class);

	private boolean isChangedDown = false;
	private boolean isChangedUp = false;
	private final int[] lastSkillLevels = new int[Skill.values().length];
	private int lastChangeDown = -1;
	private int lastChangeUp = -1;
	private boolean preserveBeenActive = false;
	private long lastTickMillis;

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		OverlayMenuEntry menuEntry = new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Boosts overlay");

		boostsOverlay.getMenuEntries().add(menuEntry);
		compactBoostsOverlay.getMenuEntries().add(menuEntry);;

		overlayManager.add(boostsOverlay);
		overlayManager.add(compactBoostsOverlay);

		updateShownSkills();
		Arrays.fill(lastSkillLevels, -1);

		// Add infoboxes for everything at startup and then determine inside if it will be rendered
		infoBoxManager.addInfoBox(new StatChangeIndicator(true, ImageUtil.loadImageResource(getClass(), "debuffed.png"), this, config));
		infoBoxManager.addInfoBox(new StatChangeIndicator(false, ImageUtil.loadImageResource(getClass(), "buffed.png"), this, config));

		for (final Skill skill : Skill.values())
		{
			infoBoxManager.addInfoBox(new BoostIndicator(skill, skillIconManager.getSkillImage(skill), this, client, config));
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		boostsOverlay.getMenuEntries().clear();
		compactBoostsOverlay.getMenuEntries().clear();
		overlayManager.remove(boostsOverlay);
		overlayManager.remove(compactBoostsOverlay);
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator || t instanceof StatChangeIndicator);
		preserveBeenActive = false;
		lastChangeDown = -1;
		lastChangeUp = -1;
		isChangedUp = false;
		isChangedDown = false;
		skillsToDisplay.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
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

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("boosts"))
		{
			return;
		}

		updateShownSkills();

		if (config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeDown = -1;
		}

		if (config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER)
		{
			lastChangeUp = -1;
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		Skill skill = statChanged.getSkill();

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

		int boostThreshold = config.boostThreshold();

		if (boostThreshold != 0 && config.notifyOnBoost())
		{
			int real = client.getRealSkillLevel(skill);
			int lastBoost = last - real;
			int boost = cur - real;
			if (boost <= boostThreshold && boostThreshold < lastBoost)
			{
				notifier.notify(skill.getName() + " level is getting low!");
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		lastTickMillis = System.currentTimeMillis();

		if (getChangeUpTicks() <= 0)
		{
			switch (config.displayNextDebuffChange())
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
			switch (config.displayNextBuffChange())
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
		switch (config.displayBoosts())
		{
			case NONE:
				shownSkills.removeAll(BOOSTABLE_COMBAT_SKILLS);
				shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS);
				break;
			case COMBAT:
				shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS);
				shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS);
				break;
			case NON_COMBAT:
				shownSkills.removeAll(BOOSTABLE_COMBAT_SKILLS);
				shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS);
				break;
			case BOTH:
				shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS);
				shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS);
				break;
		}
		updateBoostedStats();
	}

	private void updateBoostedStats()
	{
		// Reset is boosted
		isChangedDown = false;
		isChangedUp = false;
		skillsToDisplay.clear();

		// Check if we are still boosted
		for (final Skill skill : Skill.values())
		{
			if (!shownSkills.contains(skill))
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

			if (boosted != base)
			{
				skillsToDisplay.add(skill);
			}
		}
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
	 *
	 * Preserve is only required to be on for the 4th and 5th sections of the boost timer
	 * to gain full effect (seconds 45-75).
	 *
	 * @return integer value in ticks until next boost change
	 */
	int getChangeDownTicks()
	{
		if (lastChangeDown == -1 ||
				config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
				(config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedUp))
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
				config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
				(config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED && !isChangedDown))
		{
			return -1;
		}

		int ticksSinceChange = client.getTickCount() - lastChangeUp;
		return 100 - ticksSinceChange;
	}


	/**
	 * Converts tick-based time to accurate second time
	 * @param time tick-based time
	 * @return second-based time
	 */
	int getChangeTime(final int time)
	{
		final long diff = System.currentTimeMillis() - lastTickMillis;
		return time != -1 ? (int)((time * Constants.GAME_TICK_LENGTH - diff) / 1000d) : time;
	}
}
