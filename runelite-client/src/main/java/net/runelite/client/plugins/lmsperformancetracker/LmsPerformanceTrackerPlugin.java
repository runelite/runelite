/*
 * Copyright (c) 2019, Matsyir <https://github.com/matsyir>
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
package net.runelite.client.plugins.lmsperformancetracker;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.Set;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.lang3.ArrayUtils;
import javax.inject.Inject;
import java.time.Duration;

@PluginDescriptor(
	name = "LMS Performance Tracker",
	description = "Tracks your LMS performance by counting how many attacks you & your opponent hit off-pray (ex. used range or melee vs mage pray).",
	tags = {"pvp", "last man standing", "hybrid", "tribrid", "nh", "no honour", "pking"}
)
public class LmsPerformanceTrackerPlugin extends Plugin
{
	// Delay to assume a fight is over. May seem long, but sometimes people barrage &
	// stand under for a while to eat. Fights will automatically end when either player dies.
	private static final Duration NEW_FIGHT_DELAY = Duration.ofSeconds(21);

	// Last man standing map regions, including lobby
	private static final Set<Integer> LAST_MAN_STANDING_REGIONS = ImmutableSet.of(13617, 13658, 13659, 13660, 13914, 13915, 13916);

	@Getter(AccessLevel.PACKAGE)
	private NavigationButton navButton;
	private boolean navButtonShown = false;

	@Getter(AccessLevel.PACKAGE)
	private LmsPerformanceTrackerPanel panel;

	@Inject
	private LmsPerformanceTrackerConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private LmsPerformanceTrackerOverlay overlay;

	@Getter
	private FightPerformance currentFight;

	@Provides
	LmsPerformanceTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LmsPerformanceTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		panel = injector.getInstance(LmsPerformanceTrackerPanel.class);
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "/skill_icons_small/last man standing.png");
		navButton = NavigationButton.builder()
			.tooltip("LMS Fight History")
			.icon(icon)
			.priority(6)
			.panel(panel)
			.build();

		if (config.saveFightHistory() && (!config.restrictToLms() || isAtLMS()))
		{
			navButtonShown = true;
			clientToolbar.addNavigation(navButton);
		}

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
		overlayManager.remove(overlay);
	}

	// if a player enables the panel or restricts/unrestricts the location to LMS, hide/show the panel accordingly
	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("lmsPerformanceTracker"))
		{
			if (event.getKey().equals("saveFightHistory") || event.getKey().equals("restrictToLms"))
			{
				boolean isAtLms = isAtLMS();
				if (!navButtonShown && config.saveFightHistory() &&
					(!config.restrictToLms() || isAtLms))
				{
					SwingUtilities.invokeLater(() -> clientToolbar.addNavigation(navButton));
					navButtonShown = true;
				}
				else if (navButtonShown && (!config.saveFightHistory() || (config.restrictToLms() && !isAtLms)))
				{
					SwingUtilities.invokeLater(() -> clientToolbar.removeNavigation(navButton));
					navButtonShown = false;
				}
			}
		}
	}

	// Keep track of a player's new target using this event.
	// It's worth noting that if you aren't in a fight, all player interactions including
	// trading & following will trigger a new fight and a new opponent. Due to this, set the lastFightTime
	// (in FightPerformance) in the past to only be 5 seconds after the time NEW_FIGHT_DELAY would trigger
	// and unset the opponent, in case the player follows a different player before actually starting
	// a fight or getting attacked. In other words, remain skeptical of the validity of this event.
	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (config.restrictToLms() && !isAtLMS())
		{
			return;
		}

		stopFightIfOver();

		// if the client player already has a valid opponent,
		// or the event source/target aren't players, skip any processing.
		if ((hasOpponent() && currentFight.fightStarted()) ||
			!(event.getSource() instanceof Player) || !(event.getTarget() instanceof Player))
		{
			return;
		}

		Actor opponent;

		// If the event source is the player, then it is the player interacting with their potential opponent.
		if (event.getSource() == client.getLocalPlayer())
		{
			opponent = event.getTarget();
		}
		else if (event.getTarget() == client.getLocalPlayer())
		{
			opponent = event.getSource();
		}
		else // if neither source or target was the player, skip
		{
			return;
		}

		// start a new fight with the new found opponent, if a new one.
		if (!hasOpponent() ||
			(hasOpponent() && !opponent.getName().equals(currentFight.getOpponent().getName())))
		{
			currentFight = new FightPerformance(client.getLocalPlayer(), (Player)opponent);
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (isAtLMS())
		{
			if (!navButtonShown && config.saveFightHistory())
			{
				clientToolbar.addNavigation(navButton);
				navButtonShown = true;
			}
		}
		else
		{
			if (config.restrictToLms())
			{
				if (navButtonShown)
				{
					clientToolbar.removeNavigation(navButton);
					navButtonShown = false;
				}
				return;
			}
		}

		stopFightIfOver();

		if (hasOpponent())
		{
			{
				// if there is an opponent, check both players' animations for attacks.
				// If they attacked, will also add the attack to the current fight stats,
				// taking into account the opponent's overhead prayer.
				currentFight.checkForAttackAnimations();
			}

		}
	}



	// Returns true if the player has an opponent.
	private boolean hasOpponent()
	{
		return currentFight != null;
	}

	private void stopFightIfOver()
	{
		if (hasOpponent() && currentFight.isFightOver())
		{
			stopFight();
		}
	}

	private void stopFight()
	{
		// add fight to fight history if it actually started
		if (currentFight.fightStarted())
		{
			panel.addFight(currentFight);
		}
		currentFight = null;
	}

	// returns true if player is at the Last Man Standing minigame
	// (Thanks to loottracker plugin)
	protected boolean isAtLMS()
	{
		final int[] mapRegions = client.getMapRegions();

		for (int region : LAST_MAN_STANDING_REGIONS)
		{
			if (ArrayUtils.contains(mapRegions, region))
			{
				return true;
			}
		}

		return false;
	}

}
