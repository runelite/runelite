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
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Boosts Information",
	description = "Show combat and/or skill boost information",
	tags = {"combat", "notifications", "skilling", "overlay"}
)
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
	private BoostsConfig config;

	@Inject
	private SkillIconManager skillIconManager;

	@Getter
	private final Set<Skill> shownSkills = new HashSet<>();

	private boolean isChangedDown = false;
	private boolean isChangedUp = false;
	private final int[] lastSkillLevels = new int[Skill.values().length - 1];
	private Instant lastChangeDown;
	private Instant lastChangeUp;
	private boolean preserveBeenActive = false;

	@Provides
	BoostsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BoostsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(boostsOverlay);
		updateShownSkills();
		updateBoostedStats();
		Arrays.fill(lastSkillLevels, -1);

		// Add infoboxes for everything at startup and then determine inside if it will be rendered
		synchronized (ImageIO.class)
		{
			infoBoxManager.addInfoBox(new StatChangeIndicator(true, ImageIO.read(getClass().getResourceAsStream("debuffed.png")), this, config));
			infoBoxManager.addInfoBox(new StatChangeIndicator(false, ImageIO.read(getClass().getResourceAsStream("buffed.png")), this, config));
		}

		for (final Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				infoBoxManager.addInfoBox(new BoostIndicator(skill, skillIconManager.getSkillImage(skill), this, client, config));
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(boostsOverlay);
		infoBoxManager.removeIf(t -> t instanceof BoostIndicator || t instanceof StatChangeIndicator);
		preserveBeenActive = false;
		lastChangeDown = null;
		lastChangeUp = null;
		isChangedUp = false;
		isChangedDown = false;
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
	public void onBoostedLevelChange(BoostedLevelChanged boostedLevelChanged)
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
			lastChangeDown = Instant.now();
		}

		if (cur == last + 1)
		{
			// Stat was restored up (from debuff)
			lastChangeUp = Instant.now();
		}

		lastSkillLevels[skillIdx] = cur;
		updateBoostedStats();

		int boostThreshold = config.boostThreshold();

		if (boostThreshold != 0)
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
		if (config.displayNextDebuffChange() && getChangeUpTime() < 0)
		{
			lastChangeUp = null;
		}

		if (config.displayNextBuffChange() && getChangeDownTime() < 0)
		{
			lastChangeDown = null;
		}
	}

	private void updateShownSkills()
	{
		if (config.enableSkill())
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
	 *
	 * Preserve is only required to be on for the 4th and 5th sections of the boost timer
	 * to gain full effect (seconds 45-75).
	 *
	 * @return integer value in seconds until next boost change
	 */
	int getChangeDownTime()
	{
		if (lastChangeDown == null || !isChangedUp)
		{
			return -1;
		}

		int timeSinceChange = (int) Duration.between(lastChangeDown, Instant.now()).getSeconds();
		boolean isPreserveActive = client.isPrayerActive(Prayer.PRESERVE);

		if ((isPreserveActive && (timeSinceChange < 45 || preserveBeenActive)) || timeSinceChange > 75)
		{
			preserveBeenActive = true;
			return 90 - timeSinceChange;
		}

		preserveBeenActive = false;
		return (timeSinceChange > 60) ? 75 - timeSinceChange : 60 - timeSinceChange;
	}

	/**
	 * Restoration from debuff is separate timer as restoration from buff, and is always ticking, so just find
	 * diff between last change up and now and limit it to cycles of 60.
	 *
	 * @return integer value in seconds until next stat restoration up
	 */
	int getChangeUpTime()
	{
		if (lastChangeUp == null || !isChangedDown)
		{
			return -1;
		}

		int timeSinceChange = (int) Duration.between(lastChangeUp, Instant.now()).getSeconds();
		return 60 - timeSinceChange;
	}
}
