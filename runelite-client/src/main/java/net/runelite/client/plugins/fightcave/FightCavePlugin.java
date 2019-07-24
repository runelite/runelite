/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.fightcave;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.NPCManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Fight Cave",
	description = "Displays current and upcoming wave monsters in the Fight Caves",
	tags = {"bosses", "combat", "minigame", "overlay", "pve", "pvm", "jad", "fire", "cape", "wave"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class FightCavePlugin extends Plugin
{
	static final int MAX_WAVE = 63;
	@Getter(AccessLevel.PACKAGE)
	static final List<EnumMap<WaveMonster, Integer>> WAVES = new ArrayList<>();
	private static final Pattern WAVE_PATTERN = Pattern.compile(".*Wave: (\\d+).*");
	private static final int FIGHT_CAVE_REGION = 9551;
	private static final int MAX_MONSTERS_OF_TYPE_PER_WAVE = 2;

	static
	{
		final WaveMonster[] waveMonsters = WaveMonster.values();

		// Add wave 1, future waves are derived from its contents
		final EnumMap<WaveMonster, Integer> waveOne = new EnumMap<>(WaveMonster.class);
		waveOne.put(waveMonsters[0], 1);
		WAVES.add(waveOne);

		for (int wave = 1; wave < MAX_WAVE; wave++)
		{
			final EnumMap<WaveMonster, Integer> prevWave = WAVES.get(wave - 1).clone();
			int maxMonsterOrdinal = -1;

			for (int i = 0; i < waveMonsters.length; i++)
			{
				final int ordinalMonsterQuantity = prevWave.getOrDefault(waveMonsters[i], 0);

				if (ordinalMonsterQuantity == MAX_MONSTERS_OF_TYPE_PER_WAVE)
				{
					maxMonsterOrdinal = i;
					break;
				}
			}

			if (maxMonsterOrdinal >= 0)
			{
				prevWave.remove(waveMonsters[maxMonsterOrdinal]);
			}

			final int addedMonsterOrdinal = maxMonsterOrdinal >= 0 ? maxMonsterOrdinal + 1 : 0;
			final WaveMonster addedMonster = waveMonsters[addedMonsterOrdinal];
			final int addedMonsterQuantity = prevWave.getOrDefault(addedMonster, 0);

			prevWave.put(addedMonster, addedMonsterQuantity + 1);

			WAVES.add(prevWave);
		}
	}

	@Inject
	private Client client;
	@Inject
	private NPCManager npcManager;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private WaveOverlay waveOverlay;
	@Inject
	private FightCaveOverlay fightCaveOverlay;
	@Inject
	private FightCaveConfig config;
	@Inject
	private EventBus eventBus;
	@Getter(AccessLevel.PACKAGE)
	private Set<FightCaveContainer> fightCaveContainer = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private int currentWave = -1;
	@Getter(AccessLevel.PACKAGE)
	private boolean validRegion;
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> mageTicks = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> rangedTicks = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private List<Integer> meleeTicks = new ArrayList<>();

	static String formatMonsterQuantity(final WaveMonster monster, final int quantity)
	{
		return String.format("%dx %s", quantity, monster);
	}


	@Getter(AccessLevel.PACKAGE)
	private WaveDisplayMode waveDisplay;
	@Getter(AccessLevel.PACKAGE)
	private boolean tickTimersWidget;
	@Getter(AccessLevel.PACKAGE)
	private FightCaveConfig.FontStyle fontStyle;
	@Getter(AccessLevel.PACKAGE)
	private int textSize;
	@Getter(AccessLevel.PACKAGE)
	private boolean shadows;

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Override
	public void startUp()
	{
		updateConfig();
		addSubscriptions();

		if (client.getGameState() == GameState.LOGGED_IN && regionCheck())
		{
			validRegion = true;
			overlayManager.add(waveOverlay);
			overlayManager.add(fightCaveOverlay);
		}
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(waveOverlay);
		overlayManager.remove(fightCaveOverlay);
		currentWave = -1;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("fightcave"))
		{
			return;
		}

		updateConfig();
	}

	private void onChatMessage(ChatMessage event)
	{
		if (!validRegion)
		{
			return;
		}

		final Matcher waveMatcher = WAVE_PATTERN.matcher(event.getMessage());

		if (event.getType() != ChatMessageType.GAMEMESSAGE || !waveMatcher.matches())
		{
			return;
		}

		currentWave = Integer.parseInt(waveMatcher.group(1));
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (regionCheck())
		{
			validRegion = true;
			overlayManager.add(waveOverlay);
			overlayManager.add(fightCaveOverlay);
		}
		else
		{
			validRegion = false;
			overlayManager.remove(fightCaveOverlay);
			overlayManager.remove(fightCaveOverlay);
		}

		fightCaveContainer.clear();
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (!validRegion)
		{
			return;
		}

		NPC npc = event.getNpc();

		switch (npc.getId())
		{
			case NpcID.TOKXIL_3121:
			case NpcID.TOKXIL_3122:
			case NpcID.YTMEJKOT:
			case NpcID.YTMEJKOT_3124:
			case NpcID.KETZEK:
			case NpcID.KETZEK_3126:
			case NpcID.TZTOKJAD:
			case NpcID.TZTOKJAD_6506:
				fightCaveContainer.add(new FightCaveContainer(npc, npcManager.getAttackSpeed(npc.getId())));
				break;
		}
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (!validRegion)
		{
			return;
		}

		NPC npc = event.getNpc();

		switch (npc.getId())
		{
			case NpcID.TOKXIL_3121:
			case NpcID.TOKXIL_3122:
			case NpcID.YTMEJKOT:
			case NpcID.YTMEJKOT_3124:
			case NpcID.KETZEK:
			case NpcID.KETZEK_3126:
			case NpcID.TZTOKJAD:
			case NpcID.TZTOKJAD_6506:
				fightCaveContainer.removeIf(c -> c.getNpc() == npc);
				break;
		}
	}

	private void onGameTick(GameTick Event)
	{
		if (!validRegion)
		{
			return;
		}

		mageTicks.clear();
		rangedTicks.clear();
		meleeTicks.clear();

		for (FightCaveContainer npc : fightCaveContainer)
		{
			if (npc.getTicksUntilAttack() >= 0)
			{
				npc.setTicksUntilAttack(npc.getTicksUntilAttack() - 1);
			}

			for (int anims : npc.getAnimations())
			{
				if (anims == npc.getNpc().getAnimation())
				{
					if (npc.getTicksUntilAttack() < 1)
					{
						npc.setTicksUntilAttack(npc.getAttackSpeed());
					}

					switch (anims)
					{
						case AnimationID.TZTOK_JAD_RANGE_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.RANGE);
							break;
						case AnimationID.TZTOK_JAD_MAGIC_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.MAGE);
							break;
						case AnimationID.TZTOK_JAD_MELEE_ATTACK:
							npc.setAttackStyle(FightCaveContainer.AttackStyle.MELEE);
							break;
					}
				}
			}

			if (npc.getNpcName().equals("TzTok-Jad"))
			{
				continue;
			}

			switch (npc.getAttackStyle())
			{
				case RANGE:
					if (npc.getTicksUntilAttack() > 0)
					{
						rangedTicks.add(npc.getTicksUntilAttack());
					}
					break;
				case MELEE:
					if (npc.getTicksUntilAttack() > 0)
					{
						meleeTicks.add(npc.getTicksUntilAttack());
					}
					break;
				case MAGE:
					if (npc.getTicksUntilAttack() > 0)
					{
						mageTicks.add(npc.getTicksUntilAttack());
					}
					break;
			}
		}

		Collections.sort(mageTicks);
		Collections.sort(rangedTicks);
		Collections.sort(meleeTicks);
	}

	private boolean regionCheck()
	{
		return ArrayUtils.contains(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	private void updateConfig()
	{
		this.waveDisplay = config.waveDisplay();
		this.tickTimersWidget = config.tickTimersWidget();
		this.fontStyle = config.fontStyle();
		this.textSize = config.textSize();
		this.shadows = config.shadows();
	}
}
