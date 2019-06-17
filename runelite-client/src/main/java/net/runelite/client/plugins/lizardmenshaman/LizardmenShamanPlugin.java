/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.lizardmenshaman;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Lizard Shamans",
	description = "Configures timer for lizardmen shaman spawns.",
	tags = {"shaman", "lizard", "lizardmen"},
	type = PluginType.PVM,
	enabledByDefault = false
)

@Slf4j
public class LizardmenShamanPlugin extends Plugin
{
	private static final String SHAMAN = "Lizardman shaman";
	private static final String MESSAGE = "A Lizardman shaman has summoned his spawn!";

	@Getter(AccessLevel.PACKAGE)
	private final Map<LocalPoint, LizardmenShamanSpawn> spawns = new HashMap<>();

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ShamanSpawnOverlay overlay;

	@Inject
	private LizardmenShamanConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Provides
	LizardmenShamanConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LizardmenShamanConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		spawns.clear();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (config.notifyOnSpawn())
		{
			if (event.getMessage().contains(MESSAGE))
			{
				notifier.notify(MESSAGE);
			}
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		Actor actor = event.getActor();
		if (actor == null || actor.getName() == null)
		{
			return;
		}

		if (actor.getName().equals(SHAMAN) && actor.getAnimation() == 7157)
		{
			if (config.showTimer())
			{
				spawns.put(event.getActor().getLocalLocation(), new LizardmenShamanSpawn(8.4, null));
			}
		}
	}
}
