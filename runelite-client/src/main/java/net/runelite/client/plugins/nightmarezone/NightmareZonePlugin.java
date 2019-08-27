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

import com.google.inject.Provides;

import java.awt.Color;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.util.Text;

@PluginDescriptor(
	name = "Nightmare Zone",
	description = "Show NMZ points/absorption and/or notify about expiring potions",
	tags = {"combat", "nmz", "minigame", "notifications"}
)
@Singleton
public class NightmareZonePlugin extends Plugin
{
	private static final int[] NMZ_MAP_REGION = {9033};
	private static final Duration HOUR = Duration.ofHours(1);

	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private NightmareZoneConfig config;

	@Inject
	private NightmareZoneOverlay overlay;

	@Inject
	private EventBus eventBus;

	@Getter
	private int pointsPerHour;
	
	private Instant nmzSessionStartTime;

	// This starts as true since you need to get
	// above the threshold before sending notifications
	private boolean absorptionNotificationSend = true;

	@Getter(AccessLevel.PACKAGE)
	private boolean moveOverlay;
	@Getter(AccessLevel.PACKAGE)
	private boolean showtotalpoints;
	private boolean powerSurgeNotification;
	private boolean recurrentDamageNotification;
	private boolean zapperNotification;
	private boolean ultimateForceNotification;
	private boolean overloadNotification;
	private boolean absorptionNotification;
	@Getter(AccessLevel.PACKAGE)
	private int absorptionThreshold;
	@Getter(AccessLevel.PACKAGE)
	private Color absorptionColorAboveThreshold;
	@Getter(AccessLevel.PACKAGE)
	private Color absorptionColorBelowThreshold;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlay.removeAbsorptionCounter();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlay.removeAbsorptionCounter();

		Widget nmzWidget = client.getWidget(WidgetInfo.NIGHTMARE_ZONE);

		if (nmzWidget != null)
		{
			nmzWidget.setHidden(false);
		}

		resetPointsPerHour();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("nightmareZone"))
		{
			return;
		}

		updateConfig();
		overlay.updateConfig();
	}

	@Provides
	NightmareZoneConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NightmareZoneConfig.class);
	}

	private void onGameTick(GameTick event)
	{
		if (isNotInNightmareZone())
		{
			if (!absorptionNotificationSend)
			{
				absorptionNotificationSend = true;
			}

			if (nmzSessionStartTime != null)
			{
				resetPointsPerHour();
			}

			return;
		}

		if (this.absorptionNotification)
		{
			checkAbsorption();
		}

		if (config.moveOverlay())
		{
			pointsPerHour = calculatePointsPerHour();
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE
			|| isNotInNightmareZone())
		{
			return;
		}

		String msg = Text.removeTags(event.getMessage()); //remove color
		if (msg.contains("The effects of overload have worn off, and you feel normal again."))
		{
			if (this.overloadNotification)
			{
				notifier.notify("Your overload has worn off");
			}
		}
		else if (msg.contains("A power-up has spawned:"))
		{
			if (msg.contains("Power surge"))
			{
				if (this.powerSurgeNotification)
				{
					notifier.notify(msg);
				}
			}
			else if (msg.contains("Recurrent damage"))
			{
				if (this.recurrentDamageNotification)
				{
					notifier.notify(msg);
				}
			}
			else if (msg.contains("Zapper"))
			{
				if (this.zapperNotification)
				{
					notifier.notify(msg);
				}
			}
			else if (msg.contains("Ultimate force"))
			{
				if (this.ultimateForceNotification)
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
			if (absorptionPoints < this.absorptionThreshold)
			{
				notifier.notify("Absorption points below: " + this.absorptionThreshold);
				absorptionNotificationSend = true;
			}
		}
		else
		{
			if (absorptionPoints > this.absorptionThreshold)
			{
				absorptionNotificationSend = false;
			}
		}
	}

	boolean isNotInNightmareZone()
	{
		return !Arrays.equals(client.getMapRegions(), NMZ_MAP_REGION);
	}

	private int calculatePointsPerHour()
	{
		Instant now = Instant.now();
		final int currentPoints = client.getVar(Varbits.NMZ_POINTS);

		if (nmzSessionStartTime == null)
		{
			nmzSessionStartTime = now;
		}

		Duration timeSinceStart = Duration.between(nmzSessionStartTime, now);

		if (!timeSinceStart.isZero())
		{
			return (int) ((double) currentPoints * (double) HOUR.toMillis() / (double) timeSinceStart.toMillis());
		}

		return 0;
	}

	private void resetPointsPerHour()
	{
		nmzSessionStartTime = null;
		pointsPerHour = 0;
	}

	private void updateConfig()
	{
		this.moveOverlay = config.moveOverlay();
		this.showtotalpoints = config.showtotalpoints();
		this.powerSurgeNotification = config.powerSurgeNotification();
		this.recurrentDamageNotification = config.recurrentDamageNotification();
		this.zapperNotification = config.zapperNotification();
		this.ultimateForceNotification = config.ultimateForceNotification();
		this.overloadNotification = config.overloadNotification();
		this.absorptionNotification = config.absorptionNotification();
		this.absorptionThreshold = config.absorptionThreshold();
		this.absorptionColorAboveThreshold = config.absorptionColorAboveThreshold();
		this.absorptionColorBelowThreshold = config.absorptionColorBelowThreshold();
	}
}
