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
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.annotations.Varp;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.StatChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.RuneScapeProfileChanged;
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
	private OverlayManager overlayManager;

	@Inject
	private XpClient xpClient;

	@Inject
	private XpState xpState;

	@Inject
	private ConfigManager configManager;

	private NavigationButton navButton;
	@Setter(AccessLevel.PACKAGE)
	@VisibleForTesting
	private XpPanel xpPanel;
	private XpWorldType lastWorldType;
	private long lastAccount;
	private long lastTickMillis = 0;
	private boolean fetchXp; // fetch lastXp for the online xp tracker
	private long lastXp = 0;
	private int initializeTracker;

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
		initializeTracker = 2;
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
				assert initializeTracker > 0;
			}
		}
		else if (state == GameState.LOGGING_IN || state == GameState.HOPPING)
		{
			initializeTracker = 2;
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

	@Subscribe
	public void onRuneScapeProfileChanged(RuneScapeProfileChanged event)
	{
		XpSave save = xpState.save();
		if (save != null)
		{
			saveSaveState(event.getPreviousProfile(), save);
		}
	}

	@Subscribe
	public void onClientShutdown(ClientShutdown event)
	{
		XpSave save = xpState.save();
		if (save != null)
		{
			saveSaveState(configManager.getRSProfileKey(), save);
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
		clearSaveState(configManager.getRSProfileKey());
		resetState();

		for (Skill skill : Skill.values())
		{
			long currentXp = client.getSkillExperience(skill);
			xpState.initializeSkill(skill, currentXp);
			removeOverlay(skill);
		}

		xpState.initializeOverall(client.getOverallExperience());
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
		xpState.initializeSkill(skill, currentXp);
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
			if (skill != s)
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
			xpState.resetSkillPerHour(skill);
		}
		xpState.resetOverallPerHour();
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		final Skill skill = statChanged.getSkill();
		final int currentXp = statChanged.getXp();
		final int currentLevel = statChanged.getLevel();
		@Varp final int startGoal = startGoalVarpForSkill(skill);
		@Varp final int endGoal = endGoalVarpForSkill(skill);
		final int startGoalXp = client.getVarpValue(startGoal);
		final int endGoalXp = client.getVarpValue(endGoal);

		if (initializeTracker > 0)
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

		final XpUpdateResult updateResult = xpState.updateSkill(skill, currentXp, startGoalXp, endGoalXp);
		xpPanel.updateSkillExperience(updateResult == XpUpdateResult.UPDATED, xpPauseState.isPaused(skill), skill, xpState.getSkillSnapshot(skill));

		// Also update the total experience
		xpState.updateOverall(client.getOverallExperience());
		xpPanel.updateTotal(xpState.getTotalSnapshot());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (initializeTracker > 0 && --initializeTracker == 0)
		{
			XpSave save;
			// Restore from saved state
			if (!xpState.isOverallInitialized() && xpTrackerConfig.saveState() && (save = loadSaveState(configManager.getRSProfileKey())) != null)
			{
				log.debug("Loading xp state from save");
				xpState.restore(save);

				// xpsave doesn't save or restore xp goals, fetch them from the client
				// and apply them to the xpstate
				for (Skill skill : save.skills.keySet())
				{
					@Varp final int startGoal = startGoalVarpForSkill(skill);
					@Varp final int endGoal = endGoalVarpForSkill(skill);
					final int startGoalXp = client.getVarpValue(startGoal);
					final int endGoalXp = client.getVarpValue(endGoal);

					XpStateSingle x = xpState.getSkill(skill);
					x.updateGoals(x.getCurrentXp(), startGoalXp, endGoalXp);
				}

				// apply state to the panel
				for (Skill skill : save.skills.keySet())
				{
					xpPanel.updateSkillExperience(true, false, skill, xpState.getSkillSnapshot(skill));
				}
				xpPanel.updateTotal(xpState.getTotalSnapshot());
			}

			// Check for xp gained while logged out
			for (Skill skill : Skill.values())
			{
				if (!xpState.isInitialized(skill))
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
						clearSaveState(configManager.getRSProfileKey());
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
				if (!xpState.isInitialized(skill))
				{
					final int currentXp = client.getSkillExperience(skill);
					// goal exps are not necessary for skill initialization
					XpUpdateResult xpUpdateResult = xpState.updateSkill(skill, currentXp, -1, -1);
					assert xpUpdateResult == XpUpdateResult.INITIALIZED;
				}
			}

			// Initialize the overall xp
			if (!xpState.isOverallInitialized())
			{
				long overallXp = client.getOverallExperience();
				log.debug("Initializing XP tracker with {} overall exp", overallXp);
				xpState.initializeOverall(overallXp);
			}
		}

		if (fetchXp)
		{
			lastXp = client.getOverallExperience();
			fetchXp = false;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(final MenuEntryAdded event)
	{
		int widgetID = event.getActionParam1();

		if (WidgetUtil.componentToInterface(widgetID) != InterfaceID.STATS
			|| !event.getOption().startsWith("View")
			|| !xpTrackerConfig.skillTabOverlayMenuOptions())
		{
			return;
		}

		// Get skill from menu option, eg. "View <col=ff981f>Attack</col> guide"
		final String skillText = event.getOption().split(" ")[1];
		final Skill skill;
		try
		{
			skill = Skill.valueOf(Text.removeTags(skillText).toUpperCase());
		}
		catch (IllegalArgumentException ignored)
		{
			return;
		}

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

	private static @Varp int startGoalVarpForSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return VarPlayerID.XPDROPS_ATTACK_START;
			case MINING:
				return VarPlayerID.XPDROPS_MINING_START;
			case WOODCUTTING:
				return VarPlayerID.XPDROPS_WOODCUTTING_START;
			case DEFENCE:
				return VarPlayerID.XPDROPS_DEFENCE_START;
			case MAGIC:
				return VarPlayerID.XPDROPS_MAGIC_START;
			case RANGED:
				return VarPlayerID.XPDROPS_RANGED_START;
			case HITPOINTS:
				return VarPlayerID.XPDROPS_HITPOINTS_START;
			case AGILITY:
				return VarPlayerID.XPDROPS_AGILITY_START;
			case STRENGTH:
				return VarPlayerID.XPDROPS_STRENGTH_START;
			case PRAYER:
				return VarPlayerID.XPDROPS_PRAYER_START;
			case SLAYER:
				return VarPlayerID.XPDROPS_SLAYER_START;
			case FISHING:
				return VarPlayerID.XPDROPS_FISHING_START;
			case RUNECRAFT:
				return VarPlayerID.XPDROPS_RUNECRAFT_START;
			case HERBLORE:
				return VarPlayerID.XPDROPS_HERBLORE_START;
			case FIREMAKING:
				return VarPlayerID.XPDROPS_FIREMAKING_START;
			case CONSTRUCTION:
				return VarPlayerID.XPDROPS_CONSTRUCTION_START;
			case HUNTER:
				return VarPlayerID.XPDROPS_HUNTER_START;
			case COOKING:
				return VarPlayerID.XPDROPS_COOKING_START;
			case FARMING:
				return VarPlayerID.XPDROPS_FARMING_START;
			case CRAFTING:
				return VarPlayerID.XPDROPS_CRAFTING_START;
			case SMITHING:
				return VarPlayerID.XPDROPS_SMITHING_START;
			case THIEVING:
				return VarPlayerID.XPDROPS_THIEVING_START;
			case FLETCHING:
				return VarPlayerID.XPDROPS_FLETCHING_START;
			default:
				throw new IllegalArgumentException();
		}
	}

	private static @Varp int endGoalVarpForSkill(final Skill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return VarPlayerID.XPDROPS_ATTACK_END;
			case MINING:
				return VarPlayerID.XPDROPS_MINING_END;
			case WOODCUTTING:
				return VarPlayerID.XPDROPS_WOODCUTTING_END;
			case DEFENCE:
				return VarPlayerID.XPDROPS_DEFENCE_END;
			case MAGIC:
				return VarPlayerID.XPDROPS_MAGIC_END;
			case RANGED:
				return VarPlayerID.XPDROPS_RANGED_END;
			case HITPOINTS:
				return VarPlayerID.XPDROPS_HITPOINTS_END;
			case AGILITY:
				return VarPlayerID.XPDROPS_AGILITY_END;
			case STRENGTH:
				return VarPlayerID.XPDROPS_STRENGTH_END;
			case PRAYER:
				return VarPlayerID.XPDROPS_PRAYER_END;
			case SLAYER:
				return VarPlayerID.XPDROPS_SLAYER_END;
			case FISHING:
				return VarPlayerID.XPDROPS_FISHING_END;
			case RUNECRAFT:
				return VarPlayerID.XPDROPS_RUNECRAFT_END;
			case HERBLORE:
				return VarPlayerID.XPDROPS_HERBLORE_END;
			case FIREMAKING:
				return VarPlayerID.XPDROPS_FIREMAKING_END;
			case CONSTRUCTION:
				return VarPlayerID.XPDROPS_CONSTRUCTION_END;
			case HUNTER:
				return VarPlayerID.XPDROPS_HUNTER_END;
			case COOKING:
				return VarPlayerID.XPDROPS_COOKING_END;
			case FARMING:
				return VarPlayerID.XPDROPS_FARMING_END;
			case CRAFTING:
				return VarPlayerID.XPDROPS_CRAFTING_END;
			case SMITHING:
				return VarPlayerID.XPDROPS_SMITHING_END;
			case THIEVING:
				return VarPlayerID.XPDROPS_THIEVING_END;
			case FLETCHING:
				return VarPlayerID.XPDROPS_FLETCHING_END;
			default:
				throw new IllegalArgumentException();
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void tickSkillTimes()
	{
		int pauseSkillAfter = xpTrackerConfig.pauseSkillAfter();
		// Adjust unpause states
		for (Skill skill : Skill.values())
		{
			long skillExperience = client.getSkillExperience(skill);
			xpPauseState.tickXp(skill, skillExperience, pauseSkillAfter);
		}
		xpPauseState.tickOverall(client.getOverallExperience(), pauseSkillAfter);

		final boolean loggedIn = client.getGameState().getState() >= GameState.LOADING.getState();
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
		if (!xpPauseState.isOverallPaused())
		{
			xpState.tickOverall(tickDelta);
		}

		rebuildSkills();
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES,
		asynchronous = true
	)
	public void tickStateSave()
	{
		XpSave save = xpState.save();
		if (save != null)
		{
			saveSaveState(configManager.getRSProfileKey(), save);
		}
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
		if (pause)
		{
			xpPauseState.pauseOverall();
		}
		else
		{
			xpPauseState.unpauseOverall();
		}
	}

	private void saveSaveState(String profile, XpSave state)
	{
		configManager.setConfiguration("xpTracker", profile, "state", state);
	}

	private void clearSaveState(String profile)
	{
		configManager.unsetConfiguration("xpTracker", profile, "state");
	}

	private XpSave loadSaveState(String profile)
	{
		return configManager.getConfiguration("xpTracker", profile, "state", XpSave.class);
	}
}
