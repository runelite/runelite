/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2018, DrizzyBot <https://github.com/drizzybot>
 * Copyright (c) 2018, DaveInga <https://github.com/daveinga>
 *
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

import com.google.common.eventbus.Subscribe;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Fight Cave",
	description = "Show what to pray against Jad",
	tags = {"bosses", "combat", "minigame", "overlay", "prayer", "pve", "pvm"}
)

public class FightCavePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FightCaveWaveOverlay fightCaveWaveOverlay;

	@Inject
	private FightCaveMinimapOverlay fightWaveMinimapOverlay;

	@Inject
	private FightCaveOverlay fightCaveOverlay;

	@Getter(AccessLevel.PACKAGE)
	@Nullable
	private JadAttack attack;

	private NPC jad;

	private static final int FIGHT_CAVE_REGION = 9551;

	@Getter(AccessLevel.PACKAGE)
	private int currentWaveNumber;

	@Getter(AccessLevel.PACKAGE)
	private int nextWaveNumber;

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, String> monsters;

	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, int[]> waves;

	@Getter(AccessLevel.PACKAGE)
	private List<Actor> waveMonsters = new ArrayList<>();

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(fightCaveOverlay);
		overlayManager.add(fightCaveWaveOverlay);
		overlayManager.add(fightWaveMinimapOverlay);
		monsters = FightCaveMappings.npcNameMapping();
		waves = FightCaveMappings.waveMapping();

	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(fightCaveOverlay);
		overlayManager.remove(fightCaveWaveOverlay);
		overlayManager.remove(fightWaveMinimapOverlay);
		jad = null;
		attack = null;
		monsters = null;
		waves = null;
		currentWaveNumber = -1;
		nextWaveNumber = -1;

	}

	@Provides
	FightCaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FightCaveConfig.class);
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final int id = event.getNpc().getId();


		if (id == NpcID.TZTOKJAD || id == NpcID.TZTOKJAD_6506)
		{
			jad = event.getNpc();
		}

		final Actor actor = event.getActor();

		if (actor != null)
		{
			waveMonsters.add(actor);
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

		final Actor actor = event.getActor();

		if (actor != null)
		{
			waveMonsters.remove(actor);
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

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!isInFightCaveInstance())
		{
			currentWaveNumber = -1;
			nextWaveNumber = -1;
		}

	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER || !isInFightCaveInstance())
		{
			return;
		}

		String message = event.getMessage();
		if (event.getMessage().contains("Wave:"))
		{
			message = message.substring(message.indexOf(": ") + 2);
			currentWaveNumber = Integer.parseInt(message.substring(0, message.indexOf("<")));
			nextWaveNumber = currentWaveNumber < 63 ? currentWaveNumber + 1 : -1;
		}

	}

	protected boolean isInFightCaveInstance()
	{
		return ArrayUtils.contains(client.getMapRegions(), FIGHT_CAVE_REGION);
	}

	public boolean isNotFinalWave()
	{
		return currentWaveNumber <= 62;
	}
}
