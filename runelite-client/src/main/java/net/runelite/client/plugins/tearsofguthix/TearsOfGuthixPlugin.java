/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.tearsofguthix;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.ObjectID;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Tears Of Guthix",
	description = "Show timers for the Tears Of Guthix streams",
	tags = {"minigame", "overlay", "skilling", "timers", "tog"}
)
public class TearsOfGuthixPlugin extends Plugin
{
	static final int TOG_REGION = 12948;
	private static final Set<Integer> TEARS_OBJECTS = new ImmutableSet.Builder<Integer>().
			add(ObjectID.BLUE_TEARS).
			add(ObjectID.BLUE_TEARS_6665).
			add(ObjectID.GREEN_TEARS).
			add(ObjectID.GREEN_TEARS_6666).
			build();
	static final String WAIT_STRING = "Wait...";

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TearsOfGuthixOverlay overlay;

	@Inject
	private TearsOfGuthixRotationOverlay rotationOverlay;

	@Provides
	TearsOfGuthixConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TearsOfGuthixConfig.class);
	}

	@Getter
	private final Map<DecorativeObject, Instant> streams = new HashMap<>();
	private static String rotation = null;
	private static boolean initialRotation = true;
	private static boolean finalStreamUpdate = true;

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(rotationOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(rotationOverlay);
		streams.clear();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case LOGIN_SCREEN:
			case HOPPING:
			case LOGGED_IN:
				streams.clear();
				rotation = null;
				initialRotation = true;
		}
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned event)
	{
		if (TEARS_OBJECTS.contains(event.getDecorativeObject().getId()))
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == TOG_REGION)
			{
				streams.put(event.getDecorativeObject(), Instant.now());
				if (!finalStreamUpdate)
				{
					finalStreamUpdate = true;
				}
			}
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned event)
	{
		if (streams.isEmpty())
		{
			return;
		}

		DecorativeObject object = event.getDecorativeObject();
		streams.remove(object);
	}

	String getRotation()
	{
		if (rotation != null)
		{
			return rotation;
		}

		// Make certain there are 6 unique Instants. Otherwise the stream timers were set during the same Instant pre-login
		Set<Instant> uniqueValues = new HashSet<>(streams.values());
		if (uniqueValues.size() < 6)
		{
			return WAIT_STRING;
		}

		// With 6 unique Instants, the oldest is still wrong
		if (initialRotation)
		{
			initialRotation = false;
			finalStreamUpdate = false;
			return WAIT_STRING;
		}

		// Wait for the final stream update
		if (!finalStreamUpdate)
		{
			return WAIT_STRING;
		}

		// Sort the Map by the Instant
		Map<DecorativeObject, Instant> sortedMap =
				streams.entrySet().stream().sorted(Map.Entry.comparingByValue()).
						collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));

		// Generate a rotation string from the sorted Map
		StringBuilder stringBuilder = new StringBuilder();
		sortedMap.forEach((k, v) ->
			{
				if (k.getId() == ObjectID.BLUE_TEARS || k.getId() == ObjectID.BLUE_TEARS_6665)
				{
					stringBuilder.append("B");
				}
				else
				{
					stringBuilder.append("G");
				}
			});

		// Check to make certain the player did not log in mid-rotation
		// Otherwise, fix the rotation
		String rotation = stringBuilder.toString();
		long nowMillis = 0;
		long prevMillis;
		long diffMillis;
		int idx = 0;
		for (Map.Entry<DecorativeObject, Instant> entry : sortedMap.entrySet())
		{
			prevMillis = nowMillis;
			nowMillis = entry.getValue().toEpochMilli();
			diffMillis = nowMillis - prevMillis;
			if (idx != 0 && diffMillis > 5000)
			{
				rotation = rotation.substring(idx) + rotation.substring(0, idx);
				break;
			}
			idx++;
		}

		this.rotation = rotation;
		return rotation;
	}
}
