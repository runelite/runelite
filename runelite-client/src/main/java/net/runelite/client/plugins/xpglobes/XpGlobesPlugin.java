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

import com.google.inject.Provides;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "XP Globes",
	description = "Show XP globes for the respective skill when gaining XP",
	tags = {"experience", "levels", "overlay"},
	enabledByDefault = false
)
@PluginDependency(XpTrackerPlugin.class)
public class XpGlobesPlugin extends Plugin
{
	private static final int MAXIMUM_SHOWN_GLOBES = 5;

	private XpGlobe[] globeCache = new XpGlobe[Skill.values().length - 1]; //overall does not trigger xp change event

	@Getter
	private final List<XpGlobe> xpGlobes = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private XpGlobesConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private XpGlobesOverlay overlay;

	@Provides
	XpGlobesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpGlobesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
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

		if (config.hideMaxed() && currentLevel >= Experience.MAX_REAL_LEVEL)
		{
			return;
		}

		if (cachedGlobe != null)
		{
			cachedGlobe.setSkill(skill);
			cachedGlobe.setCurrentXp(currentXp);
			cachedGlobe.setCurrentLevel(currentLevel);
			cachedGlobe.setTime(Instant.now());
			this.addXpGlobe(globeCache[skillIdx], MAXIMUM_SHOWN_GLOBES);
		}
		else
		{
			// dont draw non cached globes, this is triggered on login to setup all of the initial values
			globeCache[skillIdx] = new XpGlobe(skill, currentXp, currentLevel, Instant.now());
		}
	}

	private void addXpGlobe(XpGlobe xpGlobe, int maxLength)
	{
		//remove the old globe, allowing it to be readded as the most recent (right) side when drawn
		xpGlobes.remove(xpGlobe);
		if (getXpGlobesSize() >= maxLength)
		{
			xpGlobes.remove(0);
		}
		xpGlobes.add(xpGlobe);
	}

	int getXpGlobesSize()
	{
		return xpGlobes.size();
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void removeExpiredXpGlobes()
	{
		if (!xpGlobes.isEmpty())
		{
			Instant currentTime = Instant.now();
			for (Iterator<XpGlobe> it = xpGlobes.iterator(); it.hasNext();)
			{
				XpGlobe globe = it.next();
				Instant globeCreationTime = globe.getTime();
				if (currentTime.isBefore(globeCreationTime.plusSeconds(config.xpOrbDuration())))
				{
					//if a globe is not expired, stop checking newer globes
					return;
				}
				it.remove();
			}
		}
	}

	private void resetGlobeState()
	{
		xpGlobes.clear();
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
