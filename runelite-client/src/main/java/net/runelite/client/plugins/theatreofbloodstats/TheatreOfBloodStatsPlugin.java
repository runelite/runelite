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
package net.runelite.client.plugins.theatreofbloodstats;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
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
	name = "Theatre of Blood Stats",
	description = "Theatre of Blood room splits and damage",
	tags = {"combat", "raid", "pve", "pvm", "bosses", "timer"},
	enabledByDefault = false
)
public class TheatreOfBloodStatsPlugin extends Plugin
{
	private static final DecimalFormat DMG_FORMAT = new DecimalFormat("#,###");
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private static final int THEATRE_OF_BLOOD_ROOM_STATUS = 6447;
	private static final int THEATRE_OF_BLOOD_BOSS_HP = 6448;
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
	private static final String BLOAT_WAVE = "Wave 'The Pestilent Bloat' complete!";
	private static final String NYLOCAS_WAVE = "Wave 'The Nylocas' complete!";
	private static final String SOTETSEG_WAVE = "Wave 'Sotetseg' complete!";
	private static final String XARPUS_WAVE = "Wave 'Xarpus' complete!";
	private static final String VERZIK_WAVE = "Your completed Theatre of Blood count is:";
	private static final Set<Integer> NYLOCAS_IDS = ImmutableSet.of(
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
	private static final Set<String> BOSS_NAMES = ImmutableSet.of(
		"The Maiden of Sugadinti", "Pestilent Bloat", "Nylocas Vasilias", "Sotetseg", "Xarpus", "Verzik Vitur"
	);

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	private int prevRegion;
	private boolean tobInside;
	private boolean instanced;

	private int maidenStartTick = -1;
	private boolean maiden70;
	private String maiden70time;
	private boolean maiden50;
	private String maiden50time;
	private boolean maiden30;
	private String maiden30time;

	private int nyloStartTick = -1;
	private int totalNylos;
	private int currentNylos;
	private boolean nyloWavesFinished;
	private boolean nyloCleanupFinished;
	private String waveTime;
	private String cleanupTime;
	private String bossSpawnTime;

	private int soteStartTick = -1;
	private boolean sote66;
	private String sote66time;
	private boolean sote33;
	private String sote33time;

	private int xarpusStartTick = -1;
	private String xarpusAcidTime;
	private String xarpusRecoveryTime;
	private int xarpusPreScreech;

	private int verzikStartTick = -1;
	private String verzikP1time;
	private String verzikP2time;
	private double verzikP1personal;
	private double verzikP1total;
	private double verzikP2personal;
	private double verzikP2total;
	private double verzikP2healed;

	private final Map<String, Integer> personalDamage = new HashMap<>();
	private final Map<String, Integer> totalDamage  = new HashMap<>();
	private final Map<String, Integer> totalHealing  = new HashMap<>();

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
		int status = client.getVarbitValue(THEATRE_OF_BLOOD_ROOM_STATUS);

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

		int bosshp = client.getVarbitValue(THEATRE_OF_BLOOD_BOSS_HP);

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
			double personal = personalDamage.getOrDefault("The Maiden of Sugadinti", 0);
			double total = totalDamage.getOrDefault("The Maiden of Sugadinti", 0);
			int healed = totalHealing.getOrDefault("The Maiden of Sugadinti", 0);
			double percent = (personal / total) * 100;

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
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Personal Boss Damage - ")
				.append(Color.RED, DMG_FORMAT.format(personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Total Healing - ")
				.append(Color.RED, DMG_FORMAT.format(healed))
				.build();
			resetMaiden();
		}
		else if (strippedMessage.startsWith(BLOAT_WAVE))
		{
			double personal = personalDamage.getOrDefault("Pestilent Bloat", 0);
			double total = totalDamage.getOrDefault("Pestilent Bloat", 0);
			double percent = (personal / total) * 100;

			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Personal Boss Damage - ")
				.append(Color.RED, DMG_FORMAT.format(personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.build();
			resetBloat();
		}
		else if (strippedMessage.startsWith(NYLOCAS_WAVE))
		{
			double personal = personalDamage.getOrDefault("Nylocas Vasilias", 0);
			double total = totalDamage.getOrDefault("Nylocas Vasilias", 0);
			double percent = (personal / total) * 100;

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
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Personal Boss Damage - ")
				.append(Color.RED, DMG_FORMAT.format(personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.build();
			resetNylo();
		}
		else if (strippedMessage.startsWith(SOTETSEG_WAVE))
		{
			double personal = personalDamage.getOrDefault("Sotetseg", 0);
			double total = totalDamage.getOrDefault("Sotetseg", 0);
			double percent = (personal / total) * 100;

			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("66% - ")
				.append(Color.RED, sote66time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("33% - ")
				.append(Color.RED, sote33time)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Personal Boss Damage - ")
				.append(Color.RED, DMG_FORMAT.format(personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.build();
			resetSote();
		}
		else if (strippedMessage.startsWith(XARPUS_WAVE))
		{
			double personal = personalDamage.getOrDefault("Xarpus", 0);
			double total = totalDamage.getOrDefault("Xarpus", 0);
			int healed = totalHealing.getOrDefault("Xarpus", 0);
			double xarpusPostScreech = personal - xarpusPreScreech;
			double percent = (personal / total) * 100;

			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Recovery Phase - ")
				.append(Color.RED, xarpusRecoveryTime)
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("Acid Phase - ")
				.append(Color.RED, xarpusAcidTime)
				.append("\n")
				.append("Personal Boss Damage - ")
				.append(Color.RED, DMG_FORMAT.format(personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append(" Post Screech - ")
				.append(Color.RED, DMG_FORMAT.format(xarpusPostScreech))
				.append("\n")
				.append("Total Healed - ")
				.append(Color.RED, DMG_FORMAT.format(healed))
				.build();
			resetXarpus();
		}
		else if (strippedMessage.startsWith(VERZIK_WAVE))
		{
			double p3personal = personalDamage.getOrDefault("Verzik Vitur", 0) - (verzikP1personal + verzikP2personal);
			double p3total = totalDamage.getOrDefault("Verzik Vitur", 0) - (verzikP1total + verzikP2total);
			double p3healed = totalHealing.getOrDefault("Verzik Vitur", 0) - verzikP2healed;
			double percent = (p3personal / p3total) * 100;

			message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("P3 Personal Damage - ")
				.append(Color.RED, DMG_FORMAT.format(p3personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
				.append("\n")
				.append(ChatColorType.NORMAL)
				.append("P3 Healed - ")
				.append(Color.RED, DMG_FORMAT.format(p3healed))
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
			{
				verzikP1time = formatTime(client.getTickCount() - verzikStartTick);
				verzikP1personal = personalDamage.getOrDefault("Verzik Vitur", 0);
				verzikP1total = totalDamage.getOrDefault("Verzik Vitur", 0);
				double percent = (verzikP1personal / verzikP1total) * 100;

				String message = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("P1 - ")
					.append(Color.RED, verzikP1time)
					.append("\n")
					.append(ChatColorType.NORMAL)
					.append("P1 Personal Damage - ")
					.append(Color.RED, DMG_FORMAT.format(verzikP1personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
					.build();

				if (message != null)
				{
					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.GAMEMESSAGE)
						.runeLiteFormattedMessage(message)
						.build());
				}
				break;
			}
			case NpcID.VERZIK_VITUR_8373:
			{
				verzikP2time = formatTime(client.getTickCount() - verzikStartTick);
				verzikP2personal = personalDamage.getOrDefault("Verzik Vitur", 0) - verzikP1personal;
				verzikP2total = totalDamage.getOrDefault("Verzik Vitur", 0) - verzikP1total;
				verzikP2healed = totalHealing.getOrDefault("Verzik Vitur", 0);
				double percent = (verzikP2personal / verzikP2total) * 100;

				String message = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("P2 - ")
					.append(Color.RED, verzikP2time)
					.append("\n")
					.append(ChatColorType.NORMAL)
					.append("P2 Personal Damage - ")
					.append(Color.RED, DMG_FORMAT.format(verzikP2personal) + " (" + DECIMAL_FORMAT.format(percent) + "%)")
					.append("\n")
					.append(ChatColorType.NORMAL)
					.append("P2 Healed - ")
					.append(Color.RED, DMG_FORMAT.format(verzikP2healed))
					.build();

				if (message != null)
				{
					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.GAMEMESSAGE)
						.runeLiteFormattedMessage(message)
						.build());
				}
				break;
			}
		}

		if (!NYLOCAS_IDS.contains(npcId) || prevRegion != NYLOCAS_REGION)
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
		if (!NYLOCAS_IDS.contains(id) || prevRegion != NYLOCAS_REGION)
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
		if (!tobInside)
		{
			return;
		}

		Actor actor = event.getActor();
		if (!(actor instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC) actor;
		String npcName = npc.getName();
		if (npcName == null || !(BOSS_NAMES.contains(npcName)))
		{
			return;
		}

		npcName = Text.removeTags(npcName);
		Hitsplat hitsplat = event.getHitsplat();

		if (hitsplat.isMine())
		{
			int myDmg = personalDamage.getOrDefault(npcName, 0);
			int totalDmg = totalDamage.getOrDefault(npcName, 0);
			myDmg += hitsplat.getAmount();
			totalDmg += hitsplat.getAmount();
			personalDamage.put(npcName, myDmg);
			totalDamage.put(npcName, totalDmg);
		}
		else if (hitsplat.isOthers())
		{
			int totalDmg = totalDamage.getOrDefault(npcName, 0);
			totalDmg += hitsplat.getAmount();
			totalDamage.put(npcName, totalDmg);
		}
		else if (hitsplat.getHitsplatType() == Hitsplat.HitsplatType.HEAL)
		{
			int healed = totalHealing.getOrDefault(npcName, 0);
			healed += hitsplat.getAmount();
			totalHealing.put(npcName, healed);
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
			xarpusPreScreech = personalDamage.getOrDefault(npcName, 0);
			double preScreechTotal = totalDamage.getOrDefault(npcName, 0);
			double percent = (xarpusPreScreech / preScreechTotal) * 100;

			String message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Pre Screech - ")
				.append(Color.RED, DMG_FORMAT.format(xarpusPreScreech))
				.append(ChatColorType.NORMAL)
				.append(" (" + DECIMAL_FORMAT.format(percent) + ")")
				.build();

			if (message != null)
			{
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAMEMESSAGE)
					.runeLiteFormattedMessage(message)
					.build());
			}
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
		personalDamage.remove("The Maiden of Sugadinti");
		totalDamage.remove("The Maiden of Sugadinti");
		totalHealing.remove("The Maiden of Sugadinti");
	}

	private void resetBloat()
	{
		personalDamage.remove("Pestilent Bloat");
		totalDamage.remove("Pestilent Bloat");
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
		personalDamage.remove("Nylocas Vasilias");
		totalDamage.remove("Nylocas Vasilias");
	}

	private void resetSote()
	{
		soteStartTick = -1;
		sote66 = false;
		sote66time = null;
		sote33 = false;
		sote33time = null;
		personalDamage.remove("Sotetseg");
		totalDamage.remove("Sotetseg");
	}

	private void resetXarpus()
	{
		xarpusStartTick = -1;
		xarpusRecoveryTime = null;
		xarpusAcidTime = null;
		xarpusPreScreech = 0;
		personalDamage.remove("Xarpus");
		totalDamage.remove("Xarpus");
		totalHealing.remove("Xarpus");
	}

	private void resetVerzik()
	{
		verzikStartTick = -1;
		verzikP1time = null;
		verzikP2time = null;
		verzikP1personal = 0;
		verzikP1total = 0;
		verzikP2personal = 0;
		verzikP2total = 0;
		verzikP2healed = 0;
		personalDamage.clear();
		totalDamage.clear();
		totalHealing.clear();
	}
}
