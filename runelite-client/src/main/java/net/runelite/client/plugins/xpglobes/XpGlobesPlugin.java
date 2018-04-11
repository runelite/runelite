/*
 * Copyright (c) 2017, Steve <steve.rs.dev@gmail.com>
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
package net.runelite.client.plugins.xpglobes;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.awt.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;

import static net.runelite.client.callback.Hooks.log;

@PluginDescriptor(
	name = "XP Globes"
)
public class XpGlobesPlugin extends Plugin
{
	private static final int SECONDS_TO_SHOW_GLOBE = 10;
	private static final int MAXIMUM_SHOWN_GLOBES = 5;

	private XpGlobe[] globeCache = new XpGlobe[Skill.values().length - 1]; //overall does not trigger xp change event
	private final List<XpGlobe> xpGlobes = new ArrayList<>();
	private final List<XpDrop> xpDrops = new ArrayList<>();
	private boolean xpDropsThisTick = false;

	private Font font;

	@Inject
	private Client client;

	@Inject
	private XpGlobesConfig config;

	@Inject
	private XpGlobesOverlay overlay;

	@Provides
	XpGlobesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpGlobesConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void startUp()
	{
		font = FontManager.getRunescapeFont().deriveFont(Font.BOLD, config.xpDropFontSize());
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("xpDropFontSize"))
		{
			font = FontManager.getRunescapeFont().deriveFont(Font.BOLD, config.xpDropFontSize());
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		xpDropsThisTick = false;
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		Skill skill = event.getSkill();
		int currentXp = client.getSkillExperience(skill);
		int currentLevel = Experience.getLevelForXp(currentXp);
		int skillIdx = skill.ordinal();
		XpGlobe cachedGlobe = globeCache[skillIdx];

		// ExperienceChanged event occurs when stats drain/boost check we have an change to actual xp
		if (cachedGlobe != null && (cachedGlobe.getCurrentXp() >= currentXp))
		{
			return;
		}

		int startingXp = Experience.getXpForLevel(currentLevel);
		int goalXp = currentLevel + 1 <= Experience.MAX_VIRT_LEVEL ? Experience.getXpForLevel(currentLevel + 1) : -1;

		if (cachedGlobe != null)
		{
			if (config.enableXpDrops())
			{
				int deltaXp = currentXp - cachedGlobe.getCurrentXp();

				if (!xpDropsThisTick)
				{
					xpDrops.add(new XpDrop(skill, deltaXp));
					xpDropsThisTick = true;
				}
				else
				{
					xpDrops.get(xpDrops.size() - 1).addXpDrop(skill, deltaXp);
				}

				if (isPrayerTurnedOn(skill))
				{
					xpDrops.get(xpDrops.size() - 1).setPrayerActive(true);
				}
			}

			cachedGlobe.setSkill(skill);
			cachedGlobe.setCurrentXp(currentXp);
			cachedGlobe.setCurrentLevel(currentLevel);
			cachedGlobe.setGoalXp(goalXp);
			cachedGlobe.setTime(Instant.now());
			cachedGlobe.setSkillProgressRadius(startingXp, currentXp, goalXp);

			this.addXpGlobe(globeCache[skillIdx], MAXIMUM_SHOWN_GLOBES);
		}
		else
		{
			//dont draw non cached globes, this is triggered on login to setup all of the initial values
			globeCache[skillIdx] = new XpGlobe(skill, currentXp, currentLevel, goalXp);
		}
	}


	private boolean isPrayerTurnedOn(Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
			case STRENGTH:
			case DEFENCE:
				if (client.isPrayerActive(Prayer.BURST_OF_STRENGTH) || client.isPrayerActive(Prayer.CLARITY_OF_THOUGHT) ||
						client.isPrayerActive(Prayer.SUPERHUMAN_STRENGTH) || client.isPrayerActive(Prayer.IMPROVED_REFLEXES) ||
						client.isPrayerActive(Prayer.ULTIMATE_STRENGTH) || client.isPrayerActive(Prayer.INCREDIBLE_REFLEXES) ||
						client.isPrayerActive(Prayer.CHIVALRY) || client.isPrayerActive(Prayer.PIETY))
				{
					return true;
				}
				break;

			case MAGIC:
				if (client.isPrayerActive(Prayer.MYSTIC_WILL) || client.isPrayerActive(Prayer.MYSTIC_LORE) ||
						client.isPrayerActive(Prayer.MYSTIC_MIGHT) || client.isPrayerActive(Prayer.AUGURY))
				{
					return true;
				}
				break;

			case RANGED:
				if (client.isPrayerActive(Prayer.SHARP_EYE) || client.isPrayerActive(Prayer.HAWK_EYE) ||
						client.isPrayerActive(Prayer.EAGLE_EYE) || client.isPrayerActive(Prayer.RIGOUR))
				{
					return true;
				}
				break;
		}

		return false;
	}


	public List<XpGlobe> getXpGlobes()
	{
		return xpGlobes;
	}

	public void addXpGlobe(XpGlobe xpGlobe, int maxLength)
	{
		if (xpGlobes.contains(xpGlobe))
		{
			//remove the old globe, allowing it to be readded as the most recent (right) side when drawn
			xpGlobes.remove(xpGlobe);
		}
		if (getXpGlobesSize() >= maxLength)
		{
			xpGlobes.remove(0);
		}
		xpGlobes.add(xpGlobe);
	}

	public int getXpGlobesSize()
	{
		return xpGlobes.size();
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void removeExpiredXpGlobes()
	{
		// also remove old xp drops
		removeExpiredXpDrops();

		if (!xpGlobes.isEmpty())
		{
			Instant currentTime = Instant.now();
			for (Iterator<XpGlobe> it = xpGlobes.iterator(); it.hasNext();)
			{
				XpGlobe globe = it.next();
				Instant globeCreationTime = globe.getTime();
				if (currentTime.isBefore(globeCreationTime.plusSeconds(SECONDS_TO_SHOW_GLOBE)))
				{
					//if a globe is not expired, stop checking newer globes
					return;
				}
				it.remove();
			}
		}
	}


	public List<XpDrop> getXpDrops()
	{
		return xpDrops;
	}

	public int getXpDropsSize()
	{
		return xpDrops.size();
	}

	public void removeExpiredXpDrops()
	{
		if (!xpDrops.isEmpty())
		{
			for (Iterator<XpDrop> it = xpDrops.iterator(); it.hasNext();)
			{
				XpDrop drop = it.next();
				if (drop.getY() > -20)
				{
					//if a drop is not out of screen yet, next one shouldn't be either
					return;
				}
				it.remove();
			}
		}
	}

	public Font getFont()
	{
		return font;
	}


	public void resetGlobeState()
	{
		xpGlobes.clear();
		xpDrops.clear();
		globeCache = new XpGlobe[Skill.values().length - 1];
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
				resetGlobeState();
				break;
		}
	}

}
