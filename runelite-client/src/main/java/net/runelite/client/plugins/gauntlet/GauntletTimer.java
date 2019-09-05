/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.gauntlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Player;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import static net.runelite.client.plugins.gauntlet.GauntletTimer.RaidState.IN_BOSS;
import static net.runelite.client.plugins.gauntlet.GauntletTimer.RaidState.IN_RAID;
import static net.runelite.client.plugins.gauntlet.GauntletTimer.RaidState.UNKNOWN;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

class GauntletTimer extends Overlay
{
	private final Client client;
	private final GauntletPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();
	@Inject
	private ChatMessageManager chatMessageManager;
	private long timeRaidStart = -1L;
	private long timeBossEnter = -1L;
	private RaidState currentState = UNKNOWN;

	@Inject
	public GauntletTimer(Client client, GauntletPlugin plugin)
	{
		super(plugin);

		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		setPriority(OverlayPriority.HIGH);

		this.client = client;
		this.plugin = plugin;

		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Gauntlet Timer Overlay"));
	}

	/**
	 * Resets the timer.
	 */
	void resetStates()
	{
		timeRaidStart = -1L;
		timeBossEnter = -1L;

		currentState = UNKNOWN;
	}

	/**
	 * This is called when the player resets the plugin mid-raid. We do not want to confuse the timer.
	 * <p>
	 * TODO: Originally, this function will disable the timer if the plugin is started mid raid.
	 * Unfortunately, VARBITS can't be checked unless you're on the client thread.
	 * I've no idea how to access RL's task handler.
	 * Good luck to you. If you restart plugin mid raid, oh well. Your timer's going to be inaccurate.
	 */
	void initStates()
	{
		timeRaidStart = -1L;
		timeBossEnter = -1L;

		if (plugin.startedGauntlet())
		{
			currentState = IN_RAID;
			if (plugin.fightingBoss())
			{
				currentState = IN_BOSS;
			}
		}
		else
		{
			currentState = UNKNOWN;
		}
	}

	/**
	 * Converts the different between two epoch times into minutes:seconds format.
	 *
	 * @param epochA long
	 * @param epochB long
	 * @return String
	 */
	private String calculateElapsedTime(long epochA, long epochB)
	{
		long max = Math.max(epochA, epochB);
		long min = Math.min(epochA, epochB);

		long elapsedEpoch = max - min;
		long seconds = elapsedEpoch / 1000L;

		long minutes = seconds / 60L;
		seconds = seconds % 60;

		if (seconds == 0)
		{
			return minutes + ":00";
		}

		if (seconds < 10)
		{
			return minutes + ":0" + seconds;
		}

		return minutes + ":" + seconds;
	}

	/**
	 * Called when varbit changes. See if the the raid state has changed.
	 */
	void checkStates(boolean checkVarps)
	{
		final Player p = client.getLocalPlayer();

		if (p == null || !plugin.isCompleteStartup())
		{
			return;
		}

		if (checkVarps)
		{
			switch (currentState)
			{
				case UNKNOWN:
					if (plugin.startedGauntlet() && p.getHealthRatio() != 0)
					{
						// Player has started a new raid.
						if (!plugin.fightingBoss())
						{
							currentState = IN_RAID;
							timeRaidStart = System.currentTimeMillis();
							return;
						}
						currentState = IN_RAID;
						timeRaidStart = timeBossEnter = System.currentTimeMillis();
					}
					break;
				case IN_RAID:
					if (!plugin.startedGauntlet())
					{
						printPrepTime();
						resetStates();
						return;
					}
					if (plugin.fightingBoss())
					{
						// Player has begun the boss fight.
						printPrepTime();
						currentState = IN_BOSS;
						timeBossEnter = System.currentTimeMillis();
					}
					break;
				case IN_BOSS:
					if (!plugin.fightingBoss() || !plugin.startedGauntlet())
					{
						// Player has killed the boss.
						resetStates();
					}
					break;
			}
		}
		else
		{
			if (currentState == IN_BOSS && p.getHealthRatio() == 0)
			{
				printBossTime();
				resetStates();
			}
		}
	}

	private void printPrepTime()
	{
		if (!plugin.isDisplayTimerChat() || timeRaidStart == -1L)
		{
			return;
		}

		String elapsedTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);

		final ChatMessageBuilder prepmessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Preparation time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedTime);

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(prepmessage.build())
			.build());
	}

	private void printBossTime()
	{
		if (!plugin.isDisplayTimerChat() || timeRaidStart == -1L || timeBossEnter == -1L)
		{
			return;
		}

		String elapsedBossTime = calculateElapsedTime(System.currentTimeMillis(), timeBossEnter);
		String elapsedPrepTime = calculateElapsedTime(timeRaidStart, timeBossEnter);
		String elapsedTotalTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);

		final ChatMessageBuilder challengedurationmessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Challenge duration: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedTotalTime);

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(challengedurationmessage.build())
			.build());

		final ChatMessageBuilder prepdeathmessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Preparation time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedPrepTime)
			.append(ChatColorType.NORMAL)
			.append(" player/boss death time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedBossTime);

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(prepdeathmessage.build())
			.build());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (currentState == UNKNOWN)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().text("Gauntlet Timer").color(Color.WHITE).build());
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		if (timeRaidStart == -1L)
		{ // User restarted the plugin mid raid. Timer is inaccurate.
			tableComponent.addRow("Inactive", "0:00");
		}
		else
		{
			String elapsedPrepTime, elapsedBossTime, elapsedTotalTime;
			elapsedTotalTime = calculateElapsedTime(System.currentTimeMillis(), timeRaidStart);

			if (currentState == IN_RAID)
			{
				elapsedPrepTime = calculateElapsedTime(timeRaidStart, System.currentTimeMillis());
				elapsedBossTime = "0:00";
			}
			else
			{
				elapsedPrepTime = calculateElapsedTime(timeRaidStart, timeBossEnter);
				elapsedBossTime = calculateElapsedTime(System.currentTimeMillis(), timeBossEnter);
			}
			tableComponent.addRow("Preparation", elapsedPrepTime);
			tableComponent.addRow("Boss Fight", elapsedBossTime);
			tableComponent.addRow("Total Time", elapsedTotalTime);
			panelComponent.getChildren().add(tableComponent);
		}
		return panelComponent.render(graphics);
	}

	public enum RaidState
	{
		UNKNOWN, IN_RAID, IN_BOSS
	}
}
