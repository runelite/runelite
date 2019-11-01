/*
 * Copyright (c) 2019, HSJ
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
package net.runelite.client.plugins.theatreofblood;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Theatre of Blood",
	description = "Extra time splits for Theatre of Blood rooms",
	tags = {"combat", "raid", "pve", "pvm", "bosses", "timer"},
	enabledByDefault = false
)
public class TheatreOfBloodPlugin extends Plugin
{
	private static final int MAIDEN_REGION = 12613;
	private static final int NYLOCAS_REGION = 13122;
	private static final int SOTETSEG_REGION = 13123;
	private static final int SOTETSEG_MAZE_REGION = 13379;
	private static final int XARPUS_REGION = 12612;
	private static final int VERZIK_REGION = 12611;
	private static final int EXHUMED_DELAY_TICKS = 16;
	private static final int NYLOCAS_TOTAL = 120;
	private static final int TICK_LENGTH = 600;
	private static final String MAIDEN_WAVE = "Wave 'The Maiden of Sugadinti' complete!";
	private static final String NYLOCAS_WAVE = "Wave 'The Nylocas' complete!";
	private static final String SOTETSEG_WAVE = "Wave 'Sotetseg' complete!";
	private static final String XARPUS_WAVE = "Wave 'Xarpus' complete!";
	private static final String VERZIK_WAVE = "Theatre of Blood total completion time:";
	private static final Set<Integer> NYLOCAS_TYPES = ImmutableSet.of(
		NpcID.NYLOCAS_HAGIOS, NpcID.NYLOCAS_HAGIOS_8347, NpcID.NYLOCAS_HAGIOS_8350, NpcID.NYLOCAS_HAGIOS_8353,
		NpcID.NYLOCAS_TOXOBOLOS, NpcID.NYLOCAS_TOXOBOLOS_8343, NpcID.NYLOCAS_TOXOBOLOS_8346,
		NpcID.NYLOCAS_TOXOBOLOS_8349, NpcID.NYLOCAS_TOXOBOLOS_8352, NpcID.NYLOCAS_ISCHYROS, NpcID.NYLOCAS_ISCHYROS_8342,
		NpcID.NYLOCAS_ISCHYROS_8345, NpcID.NYLOCAS_ISCHYROS_8348, NpcID.NYLOCAS_ISCHYROS_8351
	);
	private static final Set<Point> NYLOCAS_VALID_SPAWNS = ImmutableSet.of(
		new Point(17, 24), new Point(17, 25), new Point(18, 24), new Point(18, 25),
		new Point(31, 9), new Point(31, 10), new Point(32, 9), new Point(32, 10),
		new Point(46, 24), new Point(46, 25), new Point(47, 24), new Point(47, 25)
	);

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	private int prevRegion;
	private boolean tobInside;
	private boolean instanced;

	private int maidenStartTick;
	private boolean maiden70;
	private String maiden70time;
	private boolean maiden50;
	private String maiden50time;
	private boolean maiden30;
	private String maiden30time;

	private int nyloStartTick;
	private int totalNylos = 0;
	private int currentNylos = 0;
	private boolean nyloWavesFinished;
	private boolean nyloCleanupFinished;
	private String waveTime;
	private String cleanupTime;
	private String bossSpawnTime;

	private int soteStartTick;
	private boolean sote66;
	private String sote66time;
	private boolean sote33;
	private String sote33time;

	private int xarpusStartTick;
	private int xarpusHealAmount = 0;
	private String xarpusAcidTime;
	private String xarpusRecoveryTime;

	private int verzikStartTick;
	private String verzikP1time;
	private String verzikP2time;

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		int tobVar = client.getVar(Varbits.THEATRE_OF_BLOOD);
		tobInside = tobVar == 2 || tobVar == 3;
		int region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		int status = client.getVar(Varbits.THEATRE_OF_BLOOD_ROOM_STATUS);

		switch (status)
		{
			case 1:
				if (region != prevRegion && region != SOTETSEG_MAZE_REGION)
				{
					prevRegion = region;

					switch (region)
					{
						case MAIDEN_REGION:
							maidenStartTick = client.getTickCount();
							break;
						case NYLOCAS_REGION:
							nyloStartTick = client.getTickCount();
							break;
						case SOTETSEG_REGION:
							soteStartTick = client.getTickCount();
							break;
					}
				}

				if (region == XARPUS_REGION && xarpusStartTick != -1 && xarpusRecoveryTime == null)
				{
					xarpusRecoveryTime = formatTime(client.getTickCount() - xarpusStartTick);
				}
				break;
			case 2:
				if (xarpusStartTick == -1 && region == XARPUS_REGION)
				{
					xarpusStartTick = client.getTickCount() - EXHUMED_DELAY_TICKS;
				}
				break;
			case 3:
				if (verzikStartTick == -1 && region == VERZIK_REGION)
				{
					verzikStartTick = client.getTickCount();
				}
				break;
		}

		int bosshp = client.getVar(Varbits.THEATRE_OF_BLOOD_BOSS_HP);

		switch (region)
		{
			case MAIDEN_REGION:
				if (bosshp <= 700 && bosshp > 0 && !maiden70)
				{
					maiden70 = true;
					maiden70time = formatTime(client.getTickCount() - maidenStartTick);
				}
				else if (bosshp <= 500 && bosshp > 0 && !maiden50)
				{
					maiden50 = true;
					maiden50time = formatTime(client.getTickCount() - maidenStartTick);
				}
				else if (bosshp <= 300 && bosshp > 0 && !maiden30)
				{
					maiden30 = true;
					maiden30time = formatTime(client.getTickCount() - maidenStartTick);
				}
				break;
			case SOTETSEG_REGION:
				if (bosshp == 666 && !sote66)
				{
					sote66 = true;
					sote66time = formatTime(client.getTickCount() - soteStartTick);
				}
				else if (bosshp == 333 && !sote33)
				{
					sote33 = true;
					sote33time = formatTime(client.getTickCount() - soteStartTick);
				}
				break;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!tobInside || event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String strippedMessage = Text.removeTags(event.getMessage());
		String message = null;

		if (strippedMessage.startsWith(MAIDEN_WAVE))
		{
			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("70% - ")
				.append(Color.RED, maiden70time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("50% - ")
				.append(Color.RED, maiden50time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("30% - ")
				.append(Color.RED, maiden30time)
				.build();
			resetMaiden();
		}
		else if (strippedMessage.startsWith(NYLOCAS_WAVE))
		{
			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Waves - ")
				.append(Color.RED, waveTime)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Cleanup - ")
				.append(Color.RED, cleanupTime)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Boss Spawn - ")
				.append(Color.RED, bossSpawnTime)
				.build();
			resetNylo();
		}
		else if (strippedMessage.startsWith(SOTETSEG_WAVE))
		{
			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("66% - ")
				.append(Color.RED, sote66time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("33% - ")
				.append(Color.RED, sote33time)
				.build();
			resetSote();
		}
		else if (strippedMessage.startsWith(XARPUS_WAVE))
		{
			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Recovery Phase - ")
				.append(Color.RED, xarpusRecoveryTime)
				.append(Color.RED, " (" + xarpusHealAmount + "HP Healed)")
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Acid Phase - ")
				.append(Color.RED, xarpusAcidTime)
				.build();
			resetXarpus();
		}
		else if (strippedMessage.startsWith(VERZIK_WAVE))
		{
			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("P1 - ")
				.append(Color.RED, verzikP1time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("P2 - ")
				.append(Color.RED, verzikP2time)
				.build();
			resetVerzik();
		}

		if (message != null)
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAMEMESSAGE)
				.runeLiteFormattedMessage(message)
				.build());
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (!tobInside)
		{
			return;
		}

		NPC npc = event.getNpc();
		int npcId = npc.getId();

		switch (npcId)
		{
			case NpcID.NYLOCAS_VASILIAS:
				bossSpawnTime = formatTime(client.getTickCount() - nyloStartTick);
				break;
			case NpcID.VERZIK_VITUR_8371:
				verzikP1time = formatTime(client.getTickCount() - verzikStartTick);
				break;
			case NpcID.VERZIK_VITUR_8373:
				verzikP2time = formatTime(client.getTickCount() - verzikStartTick);
				break;
		}

		if (!NYLOCAS_TYPES.contains(npcId) || prevRegion != NYLOCAS_REGION)
		{
			return;
		}

		currentNylos++;
		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, npc.getLocalLocation());
		Point spawnLoc = new Point(worldPoint.getRegionX(), worldPoint.getRegionY());

		if (!NYLOCAS_VALID_SPAWNS.contains(spawnLoc))
		{
			return;
		}

		totalNylos++;

		if (totalNylos == NYLOCAS_TOTAL && !nyloWavesFinished)
		{
			waveTime = formatTime(client.getTickCount() - nyloStartTick);
			nyloWavesFinished = true;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (!tobInside)
		{
			return;
		}

		int id = event.getNpc().getId();
		if (!NYLOCAS_TYPES.contains(id) || prevRegion != NYLOCAS_REGION)
		{
			return;
		}

		currentNylos--;

		if (nyloWavesFinished && !nyloCleanupFinished && currentNylos == 0)
		{
			cleanupTime = formatTime(client.getTickCount() - nyloStartTick);
			nyloCleanupFinished = true;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOADING)
		{
			return;
		}

		boolean prevInstance = instanced;
		instanced = client.isInInstancedRegion();
		if (prevInstance && !instanced)
		{
			resetMaiden();
			resetNylo();
			resetSote();
			resetXarpus();
			resetVerzik();
		}
		else if (!prevInstance && instanced)
		{
			resetMaiden();
			resetNylo();
			resetSote();
			resetXarpus();
			resetVerzik();
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		Actor npc = event.getActor();
		if (!(npc instanceof NPC) || !tobInside)
		{
			return;
		}

		String npcName = npc.getName();
		if (npcName != null && npcName.equals("Xarpus")
			&& event.getHitsplat().getHitsplatType() == Hitsplat.HitsplatType.HEAL)
		{
			xarpusHealAmount += event.getHitsplat().getAmount();
		}
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event)
	{
		Actor npc = event.getActor();
		if (!(npc instanceof NPC) || !tobInside)
		{
			return;
		}

		String overheadText = event.getOverheadText();
		String npcName = npc.getName();
		if (npcName != null && npcName.equals("Xarpus") && overheadText.equals("Screeeeech!"))
		{
			xarpusAcidTime = formatTime(client.getTickCount() - xarpusStartTick);
		}
	}

	private String formatTime(int ticks)
	{
		int millis = ticks * TICK_LENGTH;
		return String.format("%02d:%02d",
			TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
			TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
	}

	private void resetMaiden()
	{
		maidenStartTick = -1;
		maiden70 = false;
		maiden70time = null;
		maiden50 = false;
		maiden50time = null;
		maiden30 = false;
		maiden30time = null;
	}

	private void resetNylo()
	{
		nyloStartTick = -1;
		totalNylos = 0;
		currentNylos = 0;
		nyloWavesFinished = false;
		nyloCleanupFinished = false;
		waveTime = null;
		cleanupTime = null;
	}

	private void resetSote()
	{
		soteStartTick = -1;
		sote66 = false;
		sote66time = null;
		sote33 = false;
		sote33time = null;
	}

	private void resetXarpus()
	{
		xarpusStartTick = -1;
		xarpusRecoveryTime = null;
		xarpusAcidTime = null;
		xarpusHealAmount = 0;
	}

	private void resetVerzik()
	{
		verzikStartTick = -1;
		verzikP1time = null;
		verzikP2time = null;
	}
}
