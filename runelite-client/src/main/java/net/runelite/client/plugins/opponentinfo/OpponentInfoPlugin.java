/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.opponentinfo;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.EnumSet;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.WorldType;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.util.Text;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.game.NPCManager;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;

@PluginDescriptor(
	name = "Opponent Information",
	description = "Show name and hitpoints information about the NPC you are fighting",
	tags = {"combat", "health", "hitpoints", "npcs", "overlay"}
)
@Singleton
@Slf4j
public class OpponentInfoPlugin extends Plugin
{
	private static final Duration WAIT = Duration.ofSeconds(5);
	private static final Object MENU = new Object();
	private static final int COLOR_TAG_LENGTH = 12;

	@Inject
	private Client client;

	@Inject
	private OpponentInfoConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private OpponentInfoOverlay opponentInfoOverlay;

	@Inject
	private PlayerComparisonOverlay playerComparisonOverlay;

	@Inject
	private EventBus eventBus;

	@Inject
	private HiscoreManager hiscoreManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private NPCManager npcManager;

	@Getter(AccessLevel.PACKAGE)
	private HiscoreEndpoint hiscoreEndpoint = HiscoreEndpoint.NORMAL;

	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent;

	private Instant lastTime;

	@Getter(AccessLevel.PACKAGE)
	private boolean lookupOnInteraction;
	@Getter(AccessLevel.PACKAGE)
	private HitpointsDisplayStyle hitpointsDisplayStyle;
	@Getter(AccessLevel.PACKAGE)
	private boolean showOpponentsOpponent;

	private String attackingColTag;
	private boolean showAttackers;
	private boolean showAttacking;
	private boolean showHitpoints;

	@Provides
	OpponentInfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OpponentInfoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		this.attackingColTag = ColorUtil.colorTag(config.attackingColor());
		this.showAttackers = config.showAttackersMenu();
		this.showAttacking = config.showAttackingMenu();
		this.showHitpoints = config.showHitpointsMenu();

		updateConfig();
		addSubscriptions();

		overlayManager.add(opponentInfoOverlay);
		overlayManager.add(playerComparisonOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		eventBus.unregister(MENU);

		lastOpponent = null;
		lastTime = null;
		overlayManager.remove(opponentInfoOverlay);
		overlayManager.remove(playerComparisonOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(InteractingChanged.class, this, this::onInteractingChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		updateMenuSubs();
	}

	private void updateMenuSubs()
	{
		if (showAttackers || showAttacking || showHitpoints)
		{
			eventBus.subscribe(BeforeRender.class, MENU, this::onBeforeRender);
			eventBus.subscribe(MenuOpened.class, MENU, this::onMenuOpened);
		}
		else
		{
			eventBus.unregister(MENU);
		}
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final EnumSet<WorldType> worldType = client.getWorldType();
		if (worldType.contains(WorldType.DEADMAN_TOURNAMENT))
		{
			hiscoreEndpoint = HiscoreEndpoint.DEADMAN_TOURNAMENT;
		}
		else if (worldType.contains(WorldType.SEASONAL_DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.SEASONAL_DEADMAN;
		}
		else if (worldType.contains(WorldType.DEADMAN))
		{
			hiscoreEndpoint = HiscoreEndpoint.DEADMAN;
		}
		else
		{
			hiscoreEndpoint = HiscoreEndpoint.NORMAL;
		}
	}

	private void onInteractingChanged(InteractingChanged event)
	{
		if (event.getSource() != client.getLocalPlayer())
		{
			return;
		}

		Actor opponent = event.getTarget();

		if (opponent == null)
		{
			lastTime = Instant.now();
			return;
		}

		lastOpponent = opponent;
	}

	private void onGameTick(GameTick gameTick)
	{
		if (lastOpponent != null
			&& lastTime != null
			&& client.getLocalPlayer().getInteracting() == null
			&& Duration.between(lastTime, Instant.now()).compareTo(WAIT) > 0)
		{
			lastOpponent = null;
		}

	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("opponentinfo"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "showAttackersMenu":
				this.showAttackers = config.showAttackersMenu();
				updateMenuSubs();
				break;
			case "showAttackingMenu":
				this.showAttacking = config.showAttackingMenu();
				updateMenuSubs();
				break;
			case "showHitpointsMenu":
				this.showHitpoints = config.showHitpointsMenu();
				updateMenuSubs();
				break;
			case "attackingColor":
				attackingColTag = ColorUtil.colorTag(config.attackingColor());
				break;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.lookupOnInteraction = config.lookupOnInteraction();
		this.hitpointsDisplayStyle = config.hitpointsDisplayStyle();
		this.showOpponentsOpponent = config.showOpponentsOpponent();
	}

	private void onBeforeRender(BeforeRender event)
	{
		if (client.getMenuOptionCount() <= 0)
		{
			return;
		}
		if (client.isMenuOpen())
		{
			boolean changed = false;
			final MenuEntry[] entries = client.getMenuEntries();
			for (final MenuEntry entry : entries)
			{
				changed |= fixup(entry);
			}

			if (changed)
			{
				client.setMenuEntries(entries);
			}
			return;
		}

		final MenuEntry entry = client.getLeftClickMenuEntry();
		if (modify(entry))
		{
			client.setLeftClickMenuEntry(entry);
		}
	}

	private void onMenuOpened(MenuOpened event)
	{
		boolean changed = false;
		for (MenuEntry entry : event.getMenuEntries())
		{
			changed |= modify(entry);
		}

		if (changed)
		{
			event.setModified();
		}
	}

	private boolean modify(MenuEntry entry)
	{
		if (isNotAttackEntry(entry))
		{
			return false;
		}

		boolean changed = false;

		int index = entry.getIdentifier();
		Actor actor = getActorFromIndex(index);

		if (actor == null)
		{
			return false;
		}

		if (actor instanceof Player)
		{
			index -= 32768;
		}

		String target = entry.getTarget();

		if (showAttacking &&
			client.getLocalPlayer().getRSInteracting() == index)
		{
			target = attackingColTag + target.substring(COLOR_TAG_LENGTH);
			changed = true;
		}

		if (showAttackers &&
			actor.getRSInteracting() - 32768 == client.getLocalPlayerIndex())
		{
			target = '*' + target;
			changed = true;
		}

		if (showHitpoints &&
			actor.getHealth() > 0)
		{
			int lvlIndex = target.lastIndexOf("(level-");
			if (lvlIndex != -1)
			{
				String levelReplacement = getHpString(actor, true);

				target = target.substring(0, lvlIndex) + levelReplacement;
				changed = true;
			}
		}

		if (changed)
		{
			entry.setTarget(target);
			return true;
		}

		return false;
	}

	private boolean fixup(MenuEntry entry)
	{
		if (isNotAttackEntry(entry))
		{
			return false;
		}

		int index = entry.getIdentifier();

		Actor actor = getActorFromIndex(index);

		if (actor == null)
		{
			return false;
		}

		if (actor instanceof Player)
		{
			index -= 32768;
		}

		String target = entry.getTarget();

		boolean hasAggro = actor.getRSInteracting() - 32768 == client.getLocalPlayerIndex();
		boolean hadAggro = target.charAt(0) == '*';
		boolean isTarget = client.getLocalPlayer().getRSInteracting() == index;
		boolean hasHp = showHitpoints && actor instanceof NPC && actor.getHealth() > 0;

		boolean aggroChanged = showAttackers && hasAggro != hadAggro;
		boolean targetChanged = showAttacking && isTarget != target.startsWith(attackingColTag, aggroChanged ? 1 : 0);
		boolean hpChanged = showHitpoints && hasHp == target.contains("(level-");

		if (!aggroChanged &&
			!targetChanged &&
			!hasHp &&
			!hpChanged)
		{
			return false;
		}

		if (targetChanged)
		{
			boolean player = actor instanceof Player;
			final int start = hadAggro ? 1 + COLOR_TAG_LENGTH : COLOR_TAG_LENGTH;
			target =
				(hasAggro ? '*' : "") +
				(isTarget ? attackingColTag :
					player ? ColorUtil.colorStartTag(0xffffff) : ColorUtil.colorStartTag(0xffff00)) +
				target.substring(start);
		}
		else if (aggroChanged)
		{
			if (hasAggro)
			{
				target = '*' + target;
			}
			else
			{
				target = target.substring(1);
			}
		}

		if (hpChanged || hasHp)
		{
			final int braceIdx;

			if (!hasHp)
			{
				braceIdx = target.lastIndexOf("<col=ff0000>(");
				if (braceIdx != -1)
				{
					target = target.substring(0, braceIdx - 1) + "(level-" + actor.getCombatLevel() + ")";
				}
			}
			else if ((braceIdx = target.lastIndexOf('(')) != -1)
			{
				final String hpString = getHpString(actor, hpChanged);

				target = target.substring(0, braceIdx) + hpString;
			}
		}

		entry.setTarget(target);
		return true;
	}

	private boolean isNotAttackEntry(MenuEntry entry)
	{
		return entry.getOpcode() != MenuOpcode.NPC_SECOND_OPTION.getId() &&
			entry.getOpcode() != menuManager.getPlayerAttackOpcode()
			|| !entry.getOption().equals("Attack");
	}

	private String getHpString(Actor actor, boolean withColorTag)
	{
		int maxHp = getMaxHp(actor);
		int health = actor.getHealth();
		int ratio = actor.getHealthRatio();

		final String result;
		if (maxHp != -1)
		{
			final int exactHealth = OpponentInfoOverlay.getExactHp(ratio, health, maxHp);
			result = "(" + exactHealth + "/" + maxHp + ")";
		}
		else
		{
			result =  "(" + (100 * ratio) / health + "%)";
		}

		return withColorTag ? ColorUtil.colorStartTag(0xff0000) + result : result;
	}

	int getMaxHp(Actor actor)
	{
		if (actor instanceof NPC)
		{
			return npcManager.getHealth(((NPC) actor).getId());
		}
		else
		{
			final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(Text.removeTags(actor.getName()), getHiscoreEndpoint());
			if (hiscoreResult != null)
			{
				final int hp = hiscoreResult.getHitpoints().getLevel();
				if (hp > 0)
				{
					return hp;
				}
			}

			return -1;
		}
	}

	private Actor getActorFromIndex(int index)
	{
		if (index < 32768)
		{
			return client.getCachedNPCs()[index];
		}
		else
		{
			return client.getCachedPlayers()[index - 32768];
		}
	}
}
