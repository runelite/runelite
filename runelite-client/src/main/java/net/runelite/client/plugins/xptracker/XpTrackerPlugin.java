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
import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.WorldType;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.NPCManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.xptracker.XpWorldType.NORMAL;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.xp.XpClient;

@PluginDescriptor(
	name = "XP Tracker",
	description = "Enable the XP Tracker panel",
	tags = {"experience", "levels", "panel"}
)
@Slf4j
public class XpTrackerPlugin extends Plugin
{
	/**
	 * Amount of EXP that must be gained for an update to be submitted.
	 */
	private static final int XP_THRESHOLD = 10_000;

	static final List<Skill> COMBAT = ImmutableList.of(
		Skill.ATTACK,
		Skill.STRENGTH,
		Skill.DEFENCE,
		Skill.RANGED,
		Skill.HITPOINTS,
		Skill.MAGIC);

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private XpTrackerConfig xpTrackerConfig;

	@Inject
	private NPCManager npcManager;

	private NavigationButton navButton;
	private XpPanel xpPanel;
	private XpWorldType lastWorldType;
	private String lastUsername;
	private long lastTickMillis = 0;
	private boolean fetchXp;
	private long lastXp = 0;

	private final XpClient xpClient = new XpClient();
	private final XpState xpState = new XpState();
	private final XpPauseState xpPauseState = new XpPauseState();

	@Provides
	XpTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(XpTrackerConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(XpTrackerService.class).to(XpTrackerServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		xpPanel = new XpPanel(this, xpTrackerConfig, client, skillIconManager);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "/skill_icons/overall.png");

		navButton = NavigationButton.builder()
			.tooltip("XP Tracker")
			.icon(icon)
			.priority(2)
			.panel(xpPanel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		xpState.reset();
		clientToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		GameState state = event.getGameState();
		if (state == GameState.LOGGED_IN)
		{
			// LOGGED_IN is triggered between region changes too.
			// Check that the username changed or the world type changed.
			XpWorldType type = worldSetToType(client.getWorldType());

			if (!Objects.equals(client.getUsername(), lastUsername) || lastWorldType != type)
			{
				// Reset
				log.debug("World change: {} -> {}, {} -> {}",
					lastUsername, client.getUsername(),
					firstNonNull(lastWorldType, "<unknown>"),
					firstNonNull(type, "<unknown>"));

				lastUsername = client.getUsername();
				// xp is not available until after login is finished, so fetch it on the next gametick
				fetchXp = true;
				lastWorldType = type;
				resetState();
			}
		}
		else if (state == GameState.LOGIN_SCREEN)
		{
			Player local = client.getLocalPlayer();
			if (local == null)
			{
				return;
			}

			String username = local.getName();
			if (username == null)
			{
				return;
			}

			long totalXp = client.getOverallExperience();
			// Don't submit xptrack unless xp threshold is reached
			if (Math.abs(totalXp - lastXp) > XP_THRESHOLD)
			{
				xpClient.update(username);
			}
		}
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
	void resetAndInitState()
	{
		resetState();

		for (Skill skill : Skill.values())
		{
			long currentXp;
			if (skill == Skill.OVERALL)
			{
				currentXp = client.getOverallExperience();
			}
			else
			{
				currentXp = client.getSkillExperience(skill);
			}

			xpState.initializeSkill(skill, currentXp);
		}
	}

	/**
	 * Throw out everything, the user has chosen a different account or world type.
	 * This resets both the internal state and UI elements
	 */
	private void resetState()
	{
		xpState.reset();
		xpPanel.resetAllInfoBoxes();
		xpPanel.updateTotal(new XpSnapshotSingle.XpSnapshotSingleBuilder().build());
	}

	/**
	 * Reset an individual skill with the client's current known state of the skill
	 * Will also clear the skill from the UI.
	 * @param skill Skill to reset
	 */
	void resetSkillState(Skill skill)
	{
		int currentXp = client.getSkillExperience(skill);
		xpState.resetSkill(skill, currentXp);
		xpPanel.resetSkill(skill);
		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	/**
	 * Reset all skills except for the one provided
	 * @param skill Skill to ignore during reset
	 */
	void resetOtherSkillState(Skill skill)
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
	public void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();
		final int currentXp = client.getSkillExperience(skill);
		final int currentLevel = Experience.getLevelForXp(currentXp);
		final VarPlayer startGoal = startGoalVarpForSkill(skill);
		final VarPlayer endGoal = endGoalVarpForSkill(skill);
		final int startGoalXp = startGoal != null ? client.getVar(startGoal) : -1;
		final int endGoalXp = endGoal != null ? client.getVar(endGoal) : -1;

		if (xpTrackerConfig.hideMaxed() && currentLevel >= Experience.MAX_REAL_LEVEL)
		{
			return;
		}

		final XpStateSingle state = xpState.getSkill(skill);
		state.setActionType(XpActionType.EXPERIENCE);

		final Actor interacting = client.getLocalPlayer().getInteracting();
		if (interacting instanceof NPC && COMBAT.contains(skill))
		{
			final NPC npc = (NPC) interacting;
			xpState.updateNpcExperience(skill, npc, npcManager.getHealth(npc.getName(), npc.getCombatLevel()));
		}

		final XpUpdateResult updateResult = xpState.updateSkill(skill, currentXp, startGoalXp, endGoalXp);
		xpPanel.updateSkillExperience(updateResult == XpUpdateResult.UPDATED, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));

		if (skill == Skill.CONSTRUCTION && updateResult == XpUpdateResult.INITIALIZED)
		{
			// Construction is the last skill initialized on login, now initialize the total experience
			long overallXp = client.getOverallExperience();
			log.debug("Initializing XP tracker with {} overall exp", overallXp);
			xpState.initializeSkill(Skill.OVERALL, overallXp);
		}
		else if (xpState.isInitialized(Skill.OVERALL))
		{
			xpState.updateSkill(Skill.OVERALL, client.getOverallExperience(), -1, -1);
			xpPanel.updateTotal(xpState.getTotalSnapshot());
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (!npc.isDead())
		{
			return;
		}

		for (Skill skill : COMBAT)
		{
			final XpUpdateResult updateResult = xpState.updateNpcKills(skill, npc, npcManager.getHealth(npc.getName(), npc.getCombatLevel()));
			final boolean updated = XpUpdateResult.UPDATED.equals(updateResult);
			xpPanel.updateSkillExperience(updated, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));
		}

		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		rebuildSkills();
		if (fetchXp)
		{
			lastXp = client.getOverallExperience();
			fetchXp = false;
		}
	}

	XpSnapshotSingle getSkillSnapshot(Skill skill)
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

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void tickSkillTimes()
	{
		// Adjust unpause states
		for (Skill skill : Skill.values())
		{
			long skillExperience;
			if (skill == Skill.OVERALL)
			{
				skillExperience = client.getOverallExperience();
			}
			else
			{
				skillExperience = client.getSkillExperience(skill);
			}

			xpPauseState.tickXp(skill, skillExperience, xpTrackerConfig.pauseSkillAfter());
		}

		xpPauseState.tickLogout(xpTrackerConfig.pauseOnLogout(), !GameState.LOGIN_SCREEN.equals(client.getGameState()));

		if (lastTickMillis == 0)
		{
			lastTickMillis = System.currentTimeMillis();
			return;
		}

		final long nowMillis = System.currentTimeMillis();
		final long tickDelta = nowMillis - lastTickMillis;
		lastTickMillis = nowMillis;

		for (Skill skill : Skill.values())
		{
			if (!xpPauseState.isPaused(skill))
			{
				xpState.tick(skill, tickDelta);
			}
		}

		rebuildSkills();
	}

	private void rebuildSkills()
	{
		// Rebuild calculated values like xp/hr in panel
		for (Skill skill : Skill.values())
		{
			xpPanel.updateSkillExperience(false, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));
		}

		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	void pauseSkill(Skill skill, boolean pause)
	{
		if (pause ? xpPauseState.pauseSkill(skill) : xpPauseState.unpauseSkill(skill))
		{
			xpPanel.updateSkillExperience(false, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));
		}
	}

	void pauseAllSkills(boolean pause)
	{
		for (Skill skill : Skill.values())
		{
			pauseSkill(skill, pause);
		}
	}
}
