/*
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
package net.runelite.client.plugins.fightcave;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
public class FightCavePlugin extends Plugin
{
	private static final Pattern WAVE_PATTERN = Pattern.compile(".*Wave: (\\d+).*");
	private static final int FIGHT_CAVE_REGION = 9551;
	private static final int MAX_MONSTERS_OF_TYPE_PER_WAVE = 2;

	static final int MAX_WAVE = 63;

	@Getter
	static final List<EnumMap<WaveMonster, Integer>> WAVES = new ArrayList<>();

	@Getter
	private int currentWave = -1;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WaveOverlay waveOverlay;

	@Inject
	private JadOverlay jadOverlay;

	@Getter(AccessLevel.PACKAGE)
	@Nullable
	private JadAttack attack;

	private NPC jad;

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

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Override
	public void startUp()
	{
		overlayManager.add(waveOverlay);
		overlayManager.add(jadOverlay);
	}

	@Override
	public void shutDown()
	{
		overlayManager.remove(waveOverlay);
		currentWave = -1;

		overlayManager.remove(jadOverlay);
		jad = null;
		attack = null;

	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (!inFightCave())
		{
			currentWave = -1;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		final Matcher waveMatcher = WAVE_PATTERN.matcher(event.getMessage());

		if (event.getType() != ChatMessageType.GAMEMESSAGE
			|| !inFightCave()
			|| !waveMatcher.matches())
		{
			return;
		}

		currentWave = Integer.parseInt(waveMatcher.group(1));
	}

	boolean inFightCave()
	{
		return ArrayUtils.contains(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	static String formatMonsterQuantity(final WaveMonster monster, final int quantity)
	{
		return String.format("%dx %s", quantity, monster);
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final int id = event.getNpc().getId();

		if (id == NpcID.TZTOKJAD || id == NpcID.TZTOKJAD_6506)
		{
			jad = event.getNpc();
		}
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		if (jad == event.getNpc())
		{
			jad = null;
			attack = null;
		}
	}

	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() != jad)
		{
			return;
		}

		if (jad.getAnimation() == JadAttack.MAGIC.getAnimation())
		{
			attack = JadAttack.MAGIC;
		}
		else if (jad.getAnimation() == JadAttack.RANGE.getAnimation())
		{
			attack = JadAttack.RANGE;
		}
	}
}
