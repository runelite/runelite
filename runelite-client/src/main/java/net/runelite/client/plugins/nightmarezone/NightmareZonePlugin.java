/*
 * Copyright (c) 2018, Nickolaj <https://github.com/fire-proof>
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
package net.runelite.client.plugins.nightmarezone;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import javax.inject.Inject;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Nightmare Zone"
)
public class NightmareZonePlugin extends Plugin
{
	private static final int[] NMZ_MAP_REGION = {9033};

	@Getter
	private Instant firstAnimTime;

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private NightmareZoneConfig config;

	@Inject
	private NightmareZoneOverlay overlay;


	// This starts as true since you need to get
	// above the threshold before sending notifications
	private boolean absorptionNotificationSend = true;

	// This starts as true since you need to
	// drink an overload before sending notifications
	private boolean overloadNotificationSend = true;

	// Becomes true once the first overload damage
	// animation is triggered
	private boolean animationFlag = false;

	@Override
	protected void shutDown()
	{
		overlay.removeAbsorptionCounter();
	}

	@Subscribe
	public void updateConfig(ConfigChanged event)
	{
		overlay.updateConfig();
	}

	@Provides
	NightmareZoneConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NightmareZoneConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!isInNightmareZone())
		{
			if (!absorptionNotificationSend)
			{
				absorptionNotificationSend = true;
			}
			if (!overloadNotificationSend)
			{
				overloadNotificationSend = true;
			}
			return;
		}
		if (config.absorptionNotification())
		{
			checkAbsorption();
		}
		if (config.overloadWarningNotification())
		{
			checkOverloadTimer();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER
				|| !isInNightmareZone())
		{
			return;
		}

		String msg = Text.removeTags(event.getMessage()); //remove color
		if (msg.contains("The effects of overload have worn off, and you feel normal again."))
		{
			if (config.overloadNotification())
			{
				notifier.notify("Your overload has worn off");
			}
		}
		else if (msg.contains("A power-up has spawned:"))
		{
			if (msg.contains("Power surge"))
			{
				if (config.powerSurgeNotification())
				{
					notifier.notify(msg);
				}
			}
			else if (msg.contains("Recurrent damage"))
			{
				if (config.recurrentDamageNotification())
				{
					notifier.notify(msg);
				}
			}
			else if (msg.contains("Zapper"))
			{
				if (config.zapperNotification())
				{
					notifier.notify(msg);
				}
			}
		}
	}

	private void checkAbsorption()
	{
		int absorptionPoints = client.getVar(Varbits.NMZ_ABSORPTION);

		if (!absorptionNotificationSend)
		{
			if (absorptionPoints < config.absorptionThreshold())
			{
				notifier.notify("Absorption points below: " + config.absorptionThreshold());
				absorptionNotificationSend = true;
			}
		}
		else
		{
			if (absorptionPoints > config.absorptionThreshold())
			{
				absorptionNotificationSend = false;
			}
		}
	}


	private void checkOverloadTimer()
	{
		final Player local = client.getLocalPlayer();
		int warningTime = config.overloadWarningTime();
		int timeToWait = (300 - warningTime);

		if (local.getAnimation() == (AnimationID.OVERLOAD_DAMAGE) && animationFlag == false)
		{
			firstAnimTime = Instant.now();
			animationFlag = true;
		}
		if (firstAnimTime != null)
		{
			if (!overloadNotificationSend)
			{
				if (Duration.between(firstAnimTime, Instant.now()).getSeconds() >= timeToWait)
				{
					notifier.notify("[" + local.getName() + "]'s overload expires in " + warningTime + " seconds!");
					overloadNotificationSend = true;
				}
			}
			else
			{
				if (Duration.between(firstAnimTime, Instant.now()).getSeconds() < timeToWait)
				{
					overloadNotificationSend = false;
				}
			}
		}
	}

	public boolean isInNightmareZone()
	{
		return Arrays.equals(client.getMapRegions(), NMZ_MAP_REGION);
	}
}
