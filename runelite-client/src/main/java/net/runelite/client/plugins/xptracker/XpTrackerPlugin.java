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

import com.google.common.annotations.VisibleForTesting;
import static com.google.common.base.MoreObjects.firstNonNull;
import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.StatChanged;
import net.runelite.api.widgets.WidgetID;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.callback.ClientThread;
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
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

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

	private static final String MENUOP_ADD_CANVAS_TRACKER = "Add to canvas";
	private static final String MENUOP_REMOVE_CANVAS_TRACKER = "Remove from canvas";

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
	private ClientThread clientThread;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private XpTrackerConfig xpTrackerConfig;

	@Inject
	private NPCManager npcManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private XpClient xpClient;

	@Inject
	private XpState xpState;

	private NavigationButton navButton;
	@Setter(AccessLevel.PACKAGE)
	@VisibleForTesting
	private XpPanel xpPanel;
	private XpWorldType lastWorldType;
	private long lastAccount;
	private long lastTickMillis = 0;
	private boolean fetchXp; // fetch lastXp for the online xp tracker
	private long lastXp = 0;
	private boolean initializeTracker;

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

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "/skill_icons/overall.png");

		navButton = NavigationButton.builder()
			.tooltip("XP Tracker")
			.icon(icon)
			.priority(2)
			.panel(xpPanel)
			.build();

		clientToolbar.addNavigation(navButton);

		// Initialize the tracker & last xp if already logged in
		fetchXp = true;
		initializeTracker = true;
		lastAccount = -1L;
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				lastAccount = client.getAccountHash();
				lastWorldType = worldSetToType(client.getWorldType());
			}
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.removeIf(e -> e instanceof XpInfoBoxOverlay);
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

			if (client.getAccountHash() != lastAccount || lastWorldType != type)
			{
				// Reset
				log.debug("World change: {} -> {}, {} -> {}",
					lastAccount, client.getAccountHash(),
					firstNonNull(lastWorldType, "<unknown>"),
					firstNonNull(type, "<unknown>"));

				lastAccount = client.getAccountHash();
				// xp is not available until after login is finished, so fetch it on the next gametick
				fetchXp = true;
				lastWorldType = type;
				resetState();
				// Must be set from hitting the LOGGING_IN or HOPPING case below
				assert initializeTracker;
			}
		}
		else if (state == GameState.LOGGING_IN || state == GameState.HOPPING)
		{
			initializeTracker = true;
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
				lastXp = totalXp;
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
	 * Adds an overlay to the canvas for tracking a specific skill.
	 *
	 * @param skill the skill for which the overlay should be added
	 */
	void addOverlay(Skill skill)
	{
		removeOverlay(skill);
		overlayManager.add(new XpInfoBoxOverlay(this, xpTrackerConfig, skill, skillIconManager.getSkillImage(skill)));
	}

	/**
	 * Removes an overlay from the overlayManager if it's present.
	 *
	 * @param skill the skill for which the overlay should be removed.
	 */
	void removeOverlay(Skill skill)
	{
		overlayManager.removeIf(e -> e instanceof XpInfoBoxOverlay && ((XpInfoBoxOverlay) e).getSkill() == skill);
	}

	/**
	 * Check if there is an overlay on the canvas for the skill.
	 *
	 * @param skill the skill which should have an overlay.
	 * @return true if the skill has an overlay.
	 */
	boolean hasOverlay(final Skill skill)
	{
		return overlayManager.anyMatch(o -> o instanceof XpInfoBoxOverlay && ((XpInfoBoxOverlay) o).getSkill() == skill);
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
			removeOverlay(skill);
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
		overlayManager.removeIf(e -> e instanceof XpInfoBoxOverlay);
	}

	/**
	 * Reset an individual skill with the client's current known state of the skill
	 * Will also clear the skill from the UI.
	 *
	 * @param skill Skill to reset
	 */
	void resetSkillState(Skill skill)
	{
		int currentXp = client.getSkillExperience(skill);
		xpState.resetSkill(skill, currentXp);
		xpPanel.resetSkill(skill);
		removeOverlay(skill);
	}

	/**
	 * Reset all skills except for the one provided
	 *
	 * @param skill Skill to ignore during reset
	 */
	void resetOtherSkillState(Skill skill)
	{
		for (Skill s : Skill.values())
		{
			// Overall is not reset from resetting individual skills
			if (skill != s && s != Skill.OVERALL)
			{
				resetSkillState(s);
			}
		}
	}

	/**
	 * Reset the xp gained since last reset of the skill
	 * Does not clear the skill from the UI.
	 *
	 * @param skill Skill to reset per hour rate
	 */
	void resetSkillPerHourState(Skill skill)
	{
		xpState.resetSkillPerHour(skill);
	}

	/**
	 * Reset the xp gained since last reset of all skills including OVERALL
	 * Does not clear the UI.
	 */
	void resetAllSkillsPerHourState()
	{
		for (Skill skill : Skill.values())
		{
			resetSkillPerHourState(skill);
		}
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		final Skill skill = statChanged.getSkill();
		final int currentXp = statChanged.getXp();
		final int currentLevel = statChanged.getLevel();
		final VarPlayer startGoal = startGoalVarpForSkill(skill);
		final VarPlayer endGoal = endGoalVarpForSkill(skill);
		final int startGoalXp = startGoal != null ? client.getVarpValue(startGoal) : -1;
		final int endGoalXp = endGoal != null ? client.getVarpValue(endGoal) : -1;

		if (initializeTracker)
		{
			// This is the XP sync on login, wait until after login to begin counting
			return;
		}

		if (xpTrackerConfig.hideMaxed() && currentLevel >= Experience.MAX_REAL_LEVEL)
		{
			xpPanel.resetSkill(skill);
			removeOverlay(skill);
			return;
		}

		final XpStateSingle state = xpState.getSkill(skill);
		state.setActionType(XpActionType.EXPERIENCE);

		final Actor interacting = client.getLocalPlayer().getInteracting();
		if (interacting instanceof NPC && COMBAT.contains(skill))
		{
			final int xpModifier = worldSetToType(client.getWorldType()).modifier(client);
			final NPC npc = (NPC) interacting;
			xpState.updateNpcExperience(skill, npc, npcManager.getHealth(npc.getId()), xpModifier);
		}

		final XpUpdateResult updateResult = xpState.updateSkill(skill, currentXp, startGoalXp, endGoalXp);
		xpPanel.updateSkillExperience(updateResult == XpUpdateResult.UPDATED, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));

		// Also update the total experience
		xpState.updateSkill(Skill.OVERALL, client.getOverallExperience(), -1, -1);
		xpPanel.updateTotal(xpState.getTotalSnapshot());
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
			final XpUpdateResult updateResult = xpState.updateNpcKills(skill, npc, npcManager.getHealth(npc.getId()));
			final boolean updated = XpUpdateResult.UPDATED.equals(updateResult);
			xpPanel.updateSkillExperience(updated, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));
		}

		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (initializeTracker)
		{
			initializeTracker = false;

			// Check for xp gained while logged out
			for (Skill skill : Skill.values())
			{
				if (skill == Skill.OVERALL || !xpState.isInitialized(skill))
				{
					continue;
				}

				XpStateSingle skillState = xpState.getSkill(skill);
				final int currentXp = client.getSkillExperience(skill);
				if (skillState.getCurrentXp() != currentXp)
				{
					if (currentXp < skillState.getCurrentXp())
					{
						log.debug("Xp is going backwards! {} {} -> {}", skill, skillState.getCurrentXp(), currentXp);
						resetState();
						break;
					}

					log.debug("Skill xp for {} changed when offline: {} -> {}", skill, skillState.getCurrentXp(), currentXp);
					// Offset start xp for offline gains
					long diff = currentXp - skillState.getCurrentXp();
					skillState.setStartXp(skillState.getStartXp() + diff);
				}
			}

			// Initialize the tracker with the initial xp if not already initialized
			for (Skill skill : Skill.values())
			{
				if (skill == Skill.OVERALL)
				{
					continue;
				}

				if (!xpState.isInitialized(skill))
				{
					final int currentXp = client.getSkillExperience(skill);
					// goal exps are not necessary for skill initialization
					XpUpdateResult xpUpdateResult = xpState.updateSkill(skill, currentXp, -1, -1);
					assert xpUpdateResult == XpUpdateResult.INITIALIZED;
				}
			}

			// Initialize the overall xp
			if (!xpState.isInitialized(Skill.OVERALL))
			{
				long overallXp = client.getOverallExperience();
				log.debug("Initializing XP tracker with {} overall exp", overallXp);
				xpState.initializeSkill(Skill.OVERALL, overallXp);
			}
		}

		if (fetchXp)
		{
			lastXp = client.getOverallExperience();
			fetchXp = false;
		}

		rebuildSkills();
	}

	@Subscribe
	public void onMenuEntryAdded(final MenuEntryAdded event)
	{
		int widgetID = event.getActionParam1();

		if (TO_GROUP(widgetID) != WidgetID.SKILLS_GROUP_ID
			|| !event.getOption().startsWith("View")
			|| !xpTrackerConfig.skillTabOverlayMenuOptions())
		{
			return;
		}

		// Get skill from menu option, eg. "View <col=ff981f>Attack</col> guide"
		final String skillText = event.getOption().split(" ")[1];
		final Skill skill = Skill.valueOf(Text.removeTags(skillText).toUpperCase());

		client.createMenuEntry(-1)
			.setTarget(skillText)
			.setOption(hasOverlay(skill) ? MENUOP_REMOVE_CANVAS_TRACKER : MENUOP_ADD_CANVAS_TRACKER)
			.setType(MenuAction.RUNELITE)
			.onClick(e ->
			{
				if (hasOverlay(skill))
				{
					removeOverlay(skill);
				}
				else
				{
					addOverlay(skill);
				}
			});
	}

	XpStateSingle getSkillState(Skill skill)
	{
		return xpState.getSkill(skill);
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

		final boolean loggedIn;
		switch (client.getGameState())
		{
			case LOGIN_SCREEN:
			case LOGGING_IN:
			case LOGIN_SCREEN_AUTHENTICATOR:
				loggedIn = false;
				break;
			default:
				loggedIn = true;
				break;
		}
		xpPauseState.tickLogout(xpTrackerConfig.pauseOnLogout(), loggedIn);

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
