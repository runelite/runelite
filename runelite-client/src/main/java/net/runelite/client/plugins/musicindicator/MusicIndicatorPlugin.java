/*
 * Copyright (c) 2019, Shaun Dreclin <https://github.com/ShaunDreclin>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.musicindicator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumDefinition;
import net.runelite.api.EnumID;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Music Track Indicator",
	description = "Show chat notifications when unlocking music tracks",
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class MusicIndicatorPlugin extends Plugin
{
	private static final List<VarPlayer> MUSIC_TRACK_VARPS = ImmutableList.of(
		VarPlayer.MUSIC_TRACKS_UNLOCKED_1, VarPlayer.MUSIC_TRACKS_UNLOCKED_2, VarPlayer.MUSIC_TRACKS_UNLOCKED_3,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_4, VarPlayer.MUSIC_TRACKS_UNLOCKED_5, VarPlayer.MUSIC_TRACKS_UNLOCKED_6,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_7, VarPlayer.MUSIC_TRACKS_UNLOCKED_8, VarPlayer.MUSIC_TRACKS_UNLOCKED_9,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_10, VarPlayer.MUSIC_TRACKS_UNLOCKED_11, VarPlayer.MUSIC_TRACKS_UNLOCKED_12,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_13, VarPlayer.MUSIC_TRACKS_UNLOCKED_14, VarPlayer.MUSIC_TRACKS_UNLOCKED_15,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_16, VarPlayer.MUSIC_TRACKS_UNLOCKED_17, VarPlayer.MUSIC_TRACKS_UNLOCKED_18,
		VarPlayer.MUSIC_TRACKS_UNLOCKED_19
	);

	private static final Map<Integer, VarPlayer> VARP_INDEX_TO_VARPLAYER = MUSIC_TRACK_VARPS.stream()
		.collect(Collectors.collectingAndThen(Collectors.toMap(VarPlayer::getId, Function.identity()),
			ImmutableMap::copyOf));

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private EventBus eventBus;

	// Mapping of relevant varps to their values, used to compare against new values
	private final Map<VarPlayer, Integer> musicTrackVarpValues = new HashMap<>();

	private boolean loggingIn;

	@Override
	public void startUp()
	{
		addSubscriptions();
		loggingIn = true;
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);
		musicTrackVarpValues.clear();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGGING_IN:
			case CONNECTION_LOST:
			case HOPPING:
				musicTrackVarpValues.clear();
				loggingIn = true;
		}
	}

	private void onGameTick(GameTick event)
	{
		if (!loggingIn)
		{
			return;
		}

		loggingIn = false;

		for (VarPlayer musicTrackVarp : MUSIC_TRACK_VARPS)
		{
			int value = client.getVar(musicTrackVarp);
			musicTrackVarpValues.put(musicTrackVarp, value);
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		int idx = event.getIndex();

		VarPlayer varPlayer = VARP_INDEX_TO_VARPLAYER.get(idx);
		if (varPlayer == null)
		{
			return;
		}

		// Old varplayer values have not been initialized yet
		if (musicTrackVarpValues.isEmpty())
		{
			return;
		}

		assert musicTrackVarpValues.containsKey(varPlayer);

		int newValue = client.getVar(varPlayer);
		int oldValue = musicTrackVarpValues.put(varPlayer, newValue);
		int musicTracksUnlocked = ~oldValue & newValue;

		if (musicTracksUnlocked == 0)
		{
			return;
		}

		final EnumDefinition names = client.getEnum(EnumID.MUSIC_TRACK_NAMES);
		final int varpId = MUSIC_TRACK_VARPS.indexOf(varPlayer) + 1;

		for (int bit = 0; bit < Integer.SIZE; ++bit)
		{
			if ((musicTracksUnlocked & (1 << bit)) == 0)
			{
				continue;
			}

			int musicTrackId = getTrackId(varpId, bit);
			String musicTrackName = names.getStringValue(musicTrackId);

			sendChatMessage("You have unlocked a new music track: " + musicTrackName + ".");
		}
	}

	/**
	 * Get the id for a track identified by the given varp and a bit index
	 * @param variableId
	 * @param bit
	 * @return
	 */
	private int getTrackId(int variableId, int bit)
	{
		// values are packed into a coordgrid
		int packed = (variableId << 14) | bit;
		EnumDefinition ids = client.getEnum(EnumID.MUSIC_TRACK_IDS);
		for (int key : ids.getKeys())
		{
			int value = ids.getIntValue(key);
			if (value == packed)
			{
				return key;
			}
		}
		return -1;
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(chatMessage)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}
}