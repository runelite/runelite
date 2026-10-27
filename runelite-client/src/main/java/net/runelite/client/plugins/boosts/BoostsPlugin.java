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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameState;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Prayer;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Notification;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boosts Information",
	description = "Show combat and/or skill boost information",
	tags = {"combat", "notifications", "skilling", "overlay"}
)
@Singleton
@Slf4j
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
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER, Skill.SAILING);

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
	private ConfigManager configManager;

	@Inject
	private SkillIconManager skillIconManager;

	@Getter
	private final Set<Skill> skillsToDisplay = EnumSet.noneOf(Skill.class);

	private final Set<Skill> shownSkills = EnumSet.noneOf(Skill.class);

	private boolean isCbBuffed;
	private boolean isNonCbBuffed;
	private boolean isDebuffed;
	private final int[] lastSkillLevels = new int[Skill.values().length];
	private int lastCbBuffDrainUpdate = -1;
	private int lastNonCbBuffDrainUpdate = -1;
	private int nonCbBuffDrainBase = -1;
	private int previousNonCbBuffDrainBase = -1;
	private boolean preserveBoostApplied;
	private int lastDebuffRestorationUpdate = -1;
	private int debuffRestorationBase = -1;
	private boolean preserveBeenActive;
	private long lastTickNanoTime;

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		convertConfig();
		OverlayMenuEntry menuEntry = new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Boosts overlay");

		boostsOverlay.getMenuEntries().add(menuEntry);
		compactBoostsOverlay.getMenuEntries().add(menuEntry);

		overlayManager.add(boostsOverlay);
		overlayManager.add(compactBoostsOverlay);

		updateShownSkills();
		Arrays.fill(lastSkillLevels, -1);

		// Add infoboxes for everything at startup and then determine inside if it will be rendered
		for (BoostTimer boostTimer : BoostTimer.values())
		{
			infoBoxManager.addInfoBox(new StatChangeIndicator(boostTimer, this, config));
		}

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
		reset();
		skillsToDisplay.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			// After world hop and log out timers are in undefined state so just reset
			reset();
		}
	}

	private void convertConfig()
	{
		String migrated = configManager.getConfiguration("boosts", "migrated");
		if (migrated != null)
		{
			return;
		}

		int boostThreshold = config.boostThreshold();
		if (boostThreshold == 0)
		{
			configManager.setConfiguration("boosts", "notifyOnBoost", Notification.OFF);
			log.debug("Disabled boosts notification due to config migration");
		}

		configManager.setConfiguration("boosts", "migrated", "1");
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("boosts"))
		{
			return;
		}

		updateShownSkills();
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		final Skill skill = statChanged.getSkill();

		if (!BOOSTABLE_COMBAT_SKILLS.contains(skill) && !BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
		{
			return;
		}

		final int skillIdx = skill.ordinal();
		final int last = lastSkillLevels[skillIdx];
		final int cur = client.getBoostedSkillLevel(skill);
		final boolean wasBuffed = isCbBuffed || isNonCbBuffed;

		if (BOOSTABLE_COMBAT_SKILLS.contains(skill) && cur == last - 1)
		{
			// combat buff was drained
			lastCbBuffDrainUpdate = client.getTickCount();
		}

		lastSkillLevels[skillIdx] = cur;
		updateBoostedStats();

		final int boostThreshold = config.boostThreshold();

		final int real = client.getRealSkillLevel(skill);
		final int lastBoost = last - real;
		final int boost = cur - real;
		if (boost <= boostThreshold && boostThreshold < lastBoost)
		{
			notifier.notify(config.notifyOnBoost(), skill.getName() + " level is getting low!");
		}

		// reset non-cb buff drain timer to unbuffed state in case of death/stat reset, since var is transmitted every
		// 25 gameticks
		if (wasBuffed && !isCbBuffed && !isNonCbBuffed)
		{
			nonCbBuffDrainBase = client.isPrayerActive(Prayer.PRESERVE) ? 150 : 100;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		lastTickNanoTime = System.nanoTime();
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		final int scriptId = scriptPreFired.getScriptId();

		if (scriptId == ScriptID.NON_CB_BUFF_DRAIN_TIMER_TRANSMIT)
		{
			final Object[] scriptArguments = scriptPreFired.getScriptEvent().getArguments();
			nonCbBuffDrainBase = (int) scriptArguments[scriptArguments.length - 1];
			lastNonCbBuffDrainUpdate = client.getTickCount();

			// detect if the preserve boost has been applied to the var value or not
			if (previousNonCbBuffDrainBase != -1)
			{
				final int diff = nonCbBuffDrainBase - previousNonCbBuffDrainBase;
				// A var value change of 75 -> 100 is problematic. This could be preserve being deactivated at
				// 75-50 ticks, preserve being activated at 100-75 ticks, or with preserve disabled when not
				// buffed. Thus, check if the preserve boost hasn't been applied yet and if a skill is buffed.
				if (nonCbBuffDrainBase > 100 || (diff == 25 && !preserveBoostApplied && (isCbBuffed || isNonCbBuffed)))
				{
					preserveBoostApplied = true;
				}
				else if ((previousNonCbBuffDrainBase < 100 && nonCbBuffDrainBase == 100) || diff == -75)
				{
					preserveBoostApplied = false;
				}
			}

			previousNonCbBuffDrainBase = nonCbBuffDrainBase;

			// A section always starts with at least 25 ticks left of the cycle, so there is no need to check if
			// preserve can be active for a whole section before the next cycle starts.
			if (client.isPrayerActive(Prayer.PRESERVE) && !preserveBoostApplied)
			{
				nonCbBuffDrainBase += 50;
			}

			// The cb & non-cb buff drain timers tick at the same time. The cb RL timer can get slightly desynced in
			// very specific scenarios, e.g. teleporting around, in which case getCbBuffDrainTicks() for example
			// returns 3 instead of 0. The actual ingame timer does not get desynced, i.e. the buff drain actually
			// happens when the script is fired. Resync the timer.
			if (lastCbBuffDrainUpdate != -1)
			{
				lastCbBuffDrainUpdate -= getCbBuffDrainTicks() % 25;
			}

			if (getCbBuffDrainTicks() == 0)
			{
				lastCbBuffDrainUpdate = client.getTickCount();
			}
		}

		if (scriptId == ScriptID.DEBUFF_RESTORATION_BOOST_TIMER_TRANSMIT)
		{
			final Object[] scriptArguments = scriptPreFired.getScriptEvent().getArguments();
			debuffRestorationBase = (int) scriptArguments[scriptArguments.length - 1];
			lastDebuffRestorationUpdate = client.getTickCount();
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (varbitChanged.getVarbitId() == Varbits.PRAYER_PRESERVE)
		{
			if (varbitChanged.getValue() == 0)
			{
				nonCbBuffDrainBase = Math.max(25, nonCbBuffDrainBase - 50);
			}
			// Check if preserve can be active for the final section.
			// At this point, preserveBoostApplied is always false.
			else if (nonCbBuffDrainBase > 25)
			{
				nonCbBuffDrainBase += 50;
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
		isCbBuffed = false;
		isNonCbBuffed = false;
		isDebuffed = false;
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
				if (BOOSTABLE_COMBAT_SKILLS.contains(skill))
				{
					isCbBuffed = true;
				}
				else if (BOOSTABLE_NON_COMBAT_SKILLS.contains(skill))
				{
					isNonCbBuffed = true;
				}
			}
			else if (boosted < base)
			{
				isDebuffed = true;
			}

			if (boosted != base)
			{
				skillsToDisplay.add(skill);
			}
		}
	}

	private void reset()
	{
		preserveBeenActive = false;
		lastCbBuffDrainUpdate = -1;
		lastNonCbBuffDrainUpdate = -1;
		nonCbBuffDrainBase = -1;
		previousNonCbBuffDrainBase = -1;
		preserveBoostApplied = false;
		lastDebuffRestorationUpdate = -1;
		debuffRestorationBase = -1;
		isCbBuffed = false;
		isNonCbBuffed = false;
		isDebuffed = false;
	}

	/**
	 * Calculates the amount of time until boosted combat stats decay,
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
	 * <p>
	 * The combat buff drain timer is separate from the non-cb buff drain timer.
	 * The timers are often not synced, but do tick at the same time.
	 * The cb buff drain timer does not loop the first section while unboosted.
	 *
	 * @return integer value in ticks until next combat buff drain
	 */
	private int getCbBuffDrainTicks()
	{
		if (lastCbBuffDrainUpdate == -1 ||
			config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
			(!isCbBuffed && config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED))
		{
			return -1;
		}

		final int ticksSinceChange = client.getTickCount() - lastCbBuffDrainUpdate;

		if ((client.isPrayerActive(Prayer.PRESERVE) && (ticksSinceChange < 75 || preserveBeenActive))
			|| ticksSinceChange > 125)
		{
			preserveBeenActive = true;
			return 150 - ticksSinceChange;
		}

		preserveBeenActive = false;
		return ticksSinceChange > 100 ? 125 - ticksSinceChange : 100 - ticksSinceChange;
	}

	private int getNonCbBuffDrainTicks()
	{
		if (lastNonCbBuffDrainUpdate == -1 ||
			config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
			(!isNonCbBuffed && config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED))
		{
			return -1;
		}

		final int ticksSinceChange = client.getTickCount() - lastNonCbBuffDrainUpdate;
		return nonCbBuffDrainBase - ticksSinceChange;
	}

	private int getDebuffRestorationTicks()
	{
		if (lastDebuffRestorationUpdate == -1 ||
			config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
			(!isDebuffed && config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED))
		{
			return -1;
		}

		final int ticksSinceChange = client.getTickCount() - lastDebuffRestorationUpdate;
		return debuffRestorationBase - ticksSinceChange;
	}

	int getTicksRemaining(BoostTimer boostTimer)
	{
		switch (boostTimer)
		{
			case COMBAT_BUFFED:
				return getCbBuffDrainTicks();
			case NON_COMBAT_BUFFED:
				return getNonCbBuffDrainTicks();
			case DEBUFFED:
				return getDebuffRestorationTicks();
		}
		return -1;
	}

	/**
	 * Converts tick-based time to accurate second time
	 * @param time tick-based time
	 * @return second-based time
	 */
	int getChangeTime(final int time)
	{
		final long diff = System.nanoTime() - lastTickNanoTime;
		return time != -1 ? (int)((time * Constants.GAME_TICK_LENGTH * 1000000d - diff) / 1000000000d) : time;
	}
}
