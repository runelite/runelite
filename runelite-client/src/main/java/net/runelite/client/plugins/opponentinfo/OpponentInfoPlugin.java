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

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provides;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.ScriptID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Opponent Information",
	description = "Show name and hitpoints information about the NPC you are fighting",
	tags = {"combat", "health", "hitpoints", "npcs", "overlay"}
)
public class OpponentInfoPlugin extends Plugin
{
	private static final Duration WAIT = Duration.ofSeconds(5);
	private static final DecimalFormat PERCENT_FORMAT = new DecimalFormat("0.0");

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

	@Getter(AccessLevel.PACKAGE)
	private HiscoreEndpoint hiscoreEndpoint = HiscoreEndpoint.NORMAL;

	@Getter(AccessLevel.PACKAGE)
	private Actor lastOpponent;

	@Getter(AccessLevel.PACKAGE)
	@VisibleForTesting
	private Instant lastTime;

	@Provides
	OpponentInfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OpponentInfoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(opponentInfoOverlay);
		overlayManager.add(playerComparisonOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastOpponent = null;
		lastTime = null;
		overlayManager.remove(opponentInfoOverlay);
		overlayManager.remove(playerComparisonOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		hiscoreEndpoint = HiscoreEndpoint.fromWorldTypes(client.getWorldType());
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
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

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (lastOpponent != null
			&& lastTime != null
			&& client.getLocalPlayer().getInteracting() == null)
		{
			if (Duration.between(lastTime, Instant.now()).compareTo(WAIT) > 0)
			{
				lastOpponent = null;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		if (menuEntryAdded.getType() != MenuAction.NPC_SECOND_OPTION.getId()
			|| !menuEntryAdded.getOption().equals("Attack")
			|| !config.showOpponentsInMenu())
		{
			return;
		}

		NPC npc = menuEntryAdded.getMenuEntry().getNpc();
		if (npc == null)
		{
			return;
		}

		if (npc.getInteracting() == client.getLocalPlayer() || lastOpponent == npc)
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries[menuEntries.length - 1].setTarget("*" + menuEntries[menuEntries.length - 1].getTarget());
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.HP_HUD_UPDATE)
		{
			updateBossHealthBarText();
		}
	}

	/**
	 * Update the in-game boss health bar overlay text to what the user's config specifies.
	 * This health bar is used in CoX, ToA, Gauntlet, quest bosses, etc. It is not used in ToB, which has its own.
	 */
	private void updateBossHealthBarText()
	{
		Widget widget = client.getWidget(InterfaceID.HpbarHud.HP_BAR_TEXT);
		if (widget == null)
		{
			return;
		}

		final int currHp = client.getVarbitValue(VarbitID.HPBAR_HUD_HP);
		final int maxHp = client.getVarbitValue(VarbitID.HPBAR_HUD_BASEHP);
		if (maxHp <= 0)
		{
			return;
		}

		switch (config.hitpointsDisplayStyle())
		{
			case PERCENTAGE:
				widget.setText(getPercentText(currHp, maxHp));
				break;
			case BOTH:
				widget.setText(widget.getText() + " (" + getPercentText(currHp, maxHp) + ")");
				break;
		}
	}

	private static String getPercentText(int current, int maximum)
	{
		double percent = 100.0 * current / maximum;
		return PERCENT_FORMAT.format(percent) + "%";
	}
}
