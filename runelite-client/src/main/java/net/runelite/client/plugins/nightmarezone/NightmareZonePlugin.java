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
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Nightmare Zone",
	description = "Show NMZ points/absorption and/or notify about expiring potions",
	tags = {"combat", "nmz", "minigame", "notifications"}
)
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
	private InfoBoxManager infoBoxManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private NightmareZoneConfig config;

	@Inject
	private NightmareZoneOverlay overlay;

	@Inject
	private NightmareZoneMinimapOverlay minimapOverlay;
	
	@Getter
	private int pointsPerHour;
	
	private Instant nmzSessionStartTime;

	// This starts as true since you need to get
	// above the threshold before sending notifications
	private boolean absorptionNotificationSend = true;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(minimapOverlay);
		overlay.removeAbsorptionCounter();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		infoBoxManager.removeIf(t -> t instanceof PowerupTimer);
		overlayManager.remove(minimapOverlay);
		overlay.removeAbsorptionCounter();

		Widget nmzWidget = client.getWidget(WidgetInfo.NIGHTMARE_ZONE);

		if (nmzWidget != null)
		{
			nmzWidget.setHidden(false);
		}

		resetPointsPerHour();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		overlay.updateConfig();
		updateInfoBoxes();
	}

	@Provides
	NightmareZoneConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NightmareZoneConfig.class);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!isInNightmareZone())
		{
			infoBoxManager.removeIf(t -> t instanceof PowerupTimer);

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

		if (config.absorptionNotification())
		{
			checkAbsorption();
		}

		if (config.moveOverlay())
		{
			pointsPerHour = calculatePointsPerHour();
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!isInNightmareZone())
		{
			return;
		}

		GameObject gameObject = event.getGameObject();
		Powerup powerup = Powerup.getPowerup(gameObject.getId());

		if (powerup != null)
		{
			addPowerup(gameObject.getWorldLocation(), powerup, false);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!isInNightmareZone())
		{
			return;
		}

		GameObject gameObject = event.getGameObject();
		removePowerup(gameObject);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (!isInNightmareZone())
		{
			return;
		}

		NPC npc = event.getNpc();

		if (npc.getId() == NpcID.ZAPPER)
		{
			addPowerup(npc.getWorldLocation(), Powerup.ZAPPER, true);
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (!isInNightmareZone())
		{
			return;
		}

		NPC npc = event.getNpc();

		if (npc.getId() == NpcID.ZAPPER)
		{
			removePowerup(npc);
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE
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
			else if (msg.contains("Ultimate force"))
			{
				if (config.ultimateForceNotification())
				{
					notifier.notify(msg);
				}
			}
		}

		switch (msg)
		{
			case "You now have recurrent damage.":
			{
				addPowerup(null, Powerup.RECURRENT_DAMAGE, true);
				break;
			}
			case "You feel a surge of special attack power!":
			{
				addPowerup(null, Powerup.POWER_SURGE, true);
				break;
			}
			case "Your recurrent damage has ended.":
			{
				removeOldestPowerup(Powerup.RECURRENT_DAMAGE);
				break;
			}
			case "Your surge of special attack power has ended.":
			{
				removeOldestPowerup(Powerup.POWER_SURGE);
				break;
			}
		}
	}

	List<PowerupTimer> getPowerupTimers()
	{
		return infoBoxManager.getInfoBoxes().stream()
			.filter(t -> t instanceof PowerupTimer)
			.map(t -> (PowerupTimer) t)
			.collect(Collectors.toList());
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

	private void updateInfoBoxes()
	{
		List<PowerupTimer> timers = getPowerupTimers();

		for (PowerupTimer timer : timers)
		{
			Powerup powerup = timer.getPowerup();

			if (powerupNotifies(powerup))
			{
				timer.setVisible(true);
			}
			else
			{
				timer.setVisible(false);
			}
		}
	}

	private void addPowerup(WorldPoint point, Powerup powerup, boolean active)
	{
		PowerupTimer timer = new PowerupTimer(this, point, powerup, active);
		spriteManager.getSpriteAsync(powerup.getSpriteId(), 0, timer);

		boolean visible = powerupNotifies(powerup);
		timer.setVisible(visible);

		infoBoxManager.addInfoBox(timer);
	}

	private void removePowerup(GameObject gameObject)
	{
		infoBoxManager.removeIf(t -> t instanceof PowerupTimer
			&& ((PowerupTimer) t).getWorldLocation() != null
			&& ((PowerupTimer) t).getWorldLocation().equals(gameObject.getWorldLocation())
			&& ((PowerupTimer) t).getPowerup() == Powerup.getPowerup(gameObject.getId()));
	}

	private void removePowerup(NPC npc)
	{
		infoBoxManager.removeIf(t -> t instanceof PowerupTimer
			&& ((PowerupTimer) t).getPowerup() == Powerup.ZAPPER // the only powerup that is an NPC is an active zapper
			&& ((PowerupTimer) t).getWorldLocation() != null
			&& ((PowerupTimer) t).getWorldLocation().equals(npc.getWorldLocation()));
	}

	private void removeOldestPowerup(Powerup powerup)
	{
		infoBoxManager.removeIf(t -> t instanceof PowerupTimer
			&& ((PowerupTimer) t).isActive()
			&& ((PowerupTimer) t).getPowerup() == powerup);
	}

	private boolean powerupNotifies(Powerup powerup)
	{
		return ((powerup == Powerup.POWER_SURGE && config.powerSurgeNotification())
			|| (powerup == Powerup.RECURRENT_DAMAGE && config.recurrentDamageNotification())
			|| (powerup == Powerup.ZAPPER && config.zapperNotification())
			|| (powerup == Powerup.ULTIMATE_FORCE && config.ultimateForceNotification()));
	}

	public boolean isInNightmareZone()
	{
		return Arrays.equals(client.getMapRegions(), NMZ_MAP_REGION);
	}
}
