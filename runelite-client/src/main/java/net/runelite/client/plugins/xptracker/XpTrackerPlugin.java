/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.xptracker;

import static com.google.common.base.MoreObjects.firstNonNull;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.xptracker.XpWorldType.NORMAL;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;
import net.runelite.http.api.xp.XpClient;

@PluginDescriptor(
	name = "XP Tracker"
)
@Slf4j
public class XpTrackerPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private Client client;

	@Inject
	private SkillIconManager skillIconManager;

	private NavigationButton navButton;
	private XpPanel xpPanel;

	private final XpState xpState = new XpState();

	private WorldResult worlds;
	private XpWorldType lastWorldType;
	private String lastUsername;

	private final XpClient xpClient = new XpClient();

	@Override
	public void configure(Binder binder)
	{
		binder.bind(XpTrackerService.class).to(XpTrackerServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		WorldClient worldClient = new WorldClient();
		try
		{
			worlds = worldClient.lookupWorlds();
			if (worlds != null)
			{
				log.debug("Worlds list contains {} worlds", worlds.getWorlds().size());
			}
			else
			{
				log.warn("Unable to look up worlds");
			}
		}
		catch (IOException e)
		{
			log.warn("Error looking up worlds list", e);
		}

		xpPanel = new XpPanel(this, client, skillIconManager);

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("xp.png"));
		}

		navButton = NavigationButton.builder()
			.tooltip("XP Tracker")
			.icon(icon)
			.priority(2)
			.panel(xpPanel)
			.build();

		pluginToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			// LOGGED_IN is triggered between region changes too.
			// Check that the username changed or the world type changed.
			XpWorldType type = getWorldType(client.getWorld());

			if (!Objects.equals(client.getUsername(), lastUsername) || lastWorldType != type)
			{
				// Reset
				log.debug("World change: {} -> {}, {} -> {}",
					lastUsername, client.getUsername(),
					firstNonNull(lastWorldType, "<unknown>"),
					firstNonNull(type, "<unknown>"));

				lastUsername = client.getUsername();
				lastWorldType = type;
				resetState();
			}
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			Player local = client.getLocalPlayer();
			String username = local != null ? local.getName() : null;
			if (username != null)
			{
				xpClient.update(username);
			}
		}
	}

	private XpWorldType getWorldType(int worldNum)
	{
		if (worlds == null)
		{
			return null;
		}

		World world = worlds.findWorld(worldNum);

		if (world == null)
		{
			log.warn("Logged into nonexistent world {}?", client.getWorld());
			return null;
		}

		XpWorldType type = worldSetToType(world.getTypes());
		return type;
	}

	private XpWorldType worldSetToType(EnumSet<WorldType> types)
	{
		XpWorldType xpType = NORMAL;
		for (WorldType type : types)
		{
			XpWorldType t = XpWorldType.of(type);
			if (t != NORMAL)
			{
				xpType = t;
			}
		}
		return xpType;
	}

	/**
	 * Reset internal state and re-initialize all skills with XP currently cached by the RS client
	 * This is called by the user manually clicking resetSkillState in the UI.
	 * It reloads the current skills from the client after resetting internal state.
	 */
	public void resetAndInitState()
	{
		resetState();

		for (Skill skill : Skill.values())
		{
			int currentXp = client.getSkillExperience(skill);
			xpState.initializeSkill(skill, currentXp);
		}
	}

	/**
	 * Throw out everything, the user has chosen a different account or world type.
	 * This resets both the internal state and UI elements
	 */
	public void resetState()
	{
		xpState.reset();
		xpPanel.resetAllInfoBoxes();
		xpPanel.updateTotal(XpSnapshotTotal.zero());
	}

	/**
	 * Reset an individual skill with the client's current known state of the skill
	 * Will also clear the skill from the UI.
	 * @param skill Skill to reset
	 */
	public void resetSkillState(Skill skill)
	{
		int currentXp = client.getSkillExperience(skill);
		xpState.resetSkill(skill, currentXp);
		xpState.recalculateTotal();
		xpPanel.resetSkill(skill);
		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	/**
	 * Reset all skills except for the one provided
	 * @param skill Skill to ignore during reset
	 */
	public void resetOtherSkillState(Skill skill)
	{
		for (Skill s : Skill.values())
		{
			if (skill != s)
			{
				resetSkillState(s);
			}
		}
	}


	@Subscribe
	public void onXpChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int currentXp = client.getSkillExperience(skill);
		final VarPlayer startGoal = startGoalVarpForSkill(skill);
		final VarPlayer endGoal = endGoalVarpForSkill(skill);
		final int startGoalXp = startGoal != null ? client.getVar(startGoal) : -1;
		final int endGoalXp = endGoal != null ? client.getVar(endGoal) : -1;

		final XpUpdateResult updateResult = xpState.updateSkill(skill, currentXp, startGoalXp, endGoalXp);

		final boolean updated = XpUpdateResult.UPDATED.equals(updateResult);
		xpPanel.updateSkillExperience(updated, skill, xpState.getSkillSnapshot(skill));
		xpState.recalculateTotal();
		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Rebuild calculated values like xp/hr in panel
		for (Skill skill : Skill.values())
		{
			xpPanel.updateSkillExperience(false, skill, xpState.getSkillSnapshot(skill));
		}

		xpState.recalculateTotal();
		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	public XpSnapshotSingle getSkillSnapshot(Skill skill)
	{
		return xpState.getSkillSnapshot(skill);
	}

	private static VarPlayer startGoalVarpForSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return VarPlayer.ATTACK_GOAL_START;
			case MINING:
				return VarPlayer.MINING_GOAL_START;
			case WOODCUTTING:
				return VarPlayer.WOODCUTTING_GOAL_START;
			case DEFENCE:
				return VarPlayer.DEFENCE_GOAL_START;
			case MAGIC:
				return VarPlayer.MAGIC_GOAL_START;
			case RANGED:
				return VarPlayer.RANGED_GOAL_START;
			case HITPOINTS:
				return VarPlayer.HITPOINTS_GOAL_START;
			case AGILITY:
				return VarPlayer.AGILITY_GOAL_START;
			case STRENGTH:
				return VarPlayer.STRENGTH_GOAL_START;
			case PRAYER:
				return VarPlayer.PRAYER_GOAL_START;
			case SLAYER:
				return VarPlayer.SLAYER_GOAL_START;
			case FISHING:
				return VarPlayer.FISHING_GOAL_START;
			case RUNECRAFT:
				return VarPlayer.RUNECRAFT_GOAL_START;
			case HERBLORE:
				return VarPlayer.HERBLORE_GOAL_START;
			case FIREMAKING:
				return VarPlayer.FIREMAKING_GOAL_START;
			case CONSTRUCTION:
				return VarPlayer.CONSTRUCTION_GOAL_START;
			case HUNTER:
				return VarPlayer.HUNTER_GOAL_START;
			case COOKING:
				return VarPlayer.COOKING_GOAL_START;
			case FARMING:
				return VarPlayer.FARMING_GOAL_START;
			case CRAFTING:
				return VarPlayer.CRAFTING_GOAL_START;
			case SMITHING:
				return VarPlayer.SMITHING_GOAL_START;
			case THIEVING:
				return VarPlayer.THIEVING_GOAL_START;
			case FLETCHING:
				return VarPlayer.FLETCHING_GOAL_START;
			default:
				return null;
		}
	}

	private static VarPlayer endGoalVarpForSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return VarPlayer.ATTACK_GOAL_END;
			case MINING:
				return VarPlayer.MINING_GOAL_END;
			case WOODCUTTING:
				return VarPlayer.WOODCUTTING_GOAL_END;
			case DEFENCE:
				return VarPlayer.DEFENCE_GOAL_END;
			case MAGIC:
				return VarPlayer.MAGIC_GOAL_END;
			case RANGED:
				return VarPlayer.RANGED_GOAL_END;
			case HITPOINTS:
				return VarPlayer.HITPOINTS_GOAL_END;
			case AGILITY:
				return VarPlayer.AGILITY_GOAL_END;
			case STRENGTH:
				return VarPlayer.STRENGTH_GOAL_END;
			case PRAYER:
				return VarPlayer.PRAYER_GOAL_END;
			case SLAYER:
				return VarPlayer.SLAYER_GOAL_END;
			case FISHING:
				return VarPlayer.FISHING_GOAL_END;
			case RUNECRAFT:
				return VarPlayer.RUNECRAFT_GOAL_END;
			case HERBLORE:
				return VarPlayer.HERBLORE_GOAL_END;
			case FIREMAKING:
				return VarPlayer.FIREMAKING_GOAL_END;
			case CONSTRUCTION:
				return VarPlayer.CONSTRUCTION_GOAL_END;
			case HUNTER:
				return VarPlayer.HUNTER_GOAL_END;
			case COOKING:
				return VarPlayer.COOKING_GOAL_END;
			case FARMING:
				return VarPlayer.FARMING_GOAL_END;
			case CRAFTING:
				return VarPlayer.CRAFTING_GOAL_END;
			case SMITHING:
				return VarPlayer.SMITHING_GOAL_END;
			case THIEVING:
				return VarPlayer.THIEVING_GOAL_END;
			case FLETCHING:
				return VarPlayer.FLETCHING_GOAL_END;
			default:
				return null;
		}
	}
}
