/*
 * Copyright (c) 2017. l2-
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.volcanicmine;

import static java.lang.Math.abs;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Query;
import net.runelite.api.Region;
import net.runelite.api.Tile;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
	name = "Volcanic mine helper"
)
@Slf4j
public class VolcanicMinePlugin extends Plugin
{
	private static final int REGION_SIZE = 104;
	private static final int MAX_DISTANCE = 2400;
	private static final int LAVA_ID = 30997;
	private static final int LAVA_BEAST_ATTACK_RANGE = 1400;
	private static final int GAS_CHAMBER_ROCK_ID = 31045;
	private static final int GAS_CHAMBER_NO_ROCK_ID = 31046;
	private static final int GAS_CHAMBER_ROCK_RESPAWN_TIMER = 15;
	private static final String LAVA_BEAST = "Lava beast";
	private static final Pattern coltagPattern = Pattern.compile("((<col=([0-f]){6}>)|(<\\/col>))");

	@Inject
	Client client;

	@Inject
	ClientUI clientUI;

	@Inject
	QueryRunner queryRunner;

	@Inject
	Notifier notifier;

	@Inject
	VolcanicMineConfig config;

	@Inject
	VolcanicMineOverlay overlay;

	private Map<Tile, Instant> objectTimerMap = new HashMap<>();
	private boolean drawRangePray = false;
	private boolean isAboutToFall = false;
	private boolean isAboutToCollapse = false;
	private boolean timerRunningLow = false;
	private boolean isInside = false;
	private int stabilityPercentageThreshold;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(VolcanicMineOverlay.class);
	}

	@Provides
	VolcanicMineConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VolcanicMineConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		if (config.stabilityPercentageThreshold() >= -1 && config.stabilityPercentageThreshold() <= 100)
		{
			stabilityPercentageThreshold = config.stabilityPercentageThreshold();
		}
	}

	public Boolean getInside()
	{
		return isInside;
	}

	public VolcanicMineConfig getConfig()
	{
		return config;
	}

	public Map<Tile, Instant> getObjectTimerMap()
	{
		return objectTimerMap;
	}

	public Boolean getDrawRangePray()
	{
		return drawRangePray;
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.stabilityPercentageThreshold() >= -1 && config.stabilityPercentageThreshold() <= 100)
		{
			stabilityPercentageThreshold = config.stabilityPercentageThreshold();
		}
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return;
		}
		isInside = isInside();
		if (!isInside)
		{
			return;
		}
		lookForGameObjects();
		cleanMap();
		//-- it is unlikely more than 1 of the following notifications will be triggered in 1 update call.
		//-- it is possible so maybe send 1 notification per update max which contains the message(s)?
		//check if in range of a lava beast
		boolean lastRangePray = drawRangePray;
		drawRangePray = lavaBeastInRange(client.getLocalPlayer());
		if (!client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES) && drawRangePray && !lastRangePray)
		{
			warnPlayer(config.prayerWarning(), "Turn on prayer!");
		}
		//check if about to fall into lava
		boolean lastIsAboutToFall = isAboutToFall;
		isAboutToFall = isAboutToFall(client.getLocalPlayer().getLocalLocation());
		if (isAboutToFall && !lastIsAboutToFall)
		{
			warnPlayer(config.hotTileWarning(), "Watch out for the lava!");
		}
		//check if timer is about to run out
		boolean lastTimerRunningLow = timerRunningLow;
		timerRunningLow = isTimerRunningLow();
		if (timerRunningLow && !lastTimerRunningLow)
		{
			warnPlayer(config.timerWarning(), "Time to bail!");
		}
		//check if stability is low
		boolean lastIsAboutToCollapse = isAboutToCollapse;
		isAboutToCollapse = isAboutToCollapse();
		if (isAboutToCollapse && !lastIsAboutToCollapse)
		{
			warnPlayer(config.stabilityWarning(), "Stability is low!");
		}
	}

	private boolean isAboutToCollapse()
	{
		Widget widget = client.getWidget(WidgetInfo.VOLCANICMINE_STABILITY);
		if (widget != null && !widget.isHidden())
		{
			try
			{
				if (Integer.parseInt(removeColTags(widget.getText().replace("%", ""))) < stabilityPercentageThreshold) //sanitize of col tags
				{
					return true;
				}
			}
			catch (NumberFormatException ex)
			{
				log.debug("Failed to retrieve stability percentage", ex);
			}
		}
		return false;
	}

	private boolean isTimerRunningLow()
	{
		Widget widget = client.getWidget(WidgetInfo.VOLCANICMINE_TIME_LEFT);
		if (widget != null && !widget.isHidden())
		{
			try
			{
				if (timeToSeconds(widget.getText()) < config.timerThreshold())
				{
					return true;
				}
			}
			catch (NumberFormatException ex)
			{
				log.debug("Failed to retrieve time left", ex);
			}
		}
		return false;
	}

	private boolean isAboutToFall(Point point)
	{
		Instant now = Instant.now();
		for (Tile tile : objectTimerMap.keySet())
		{
			if (tile.getGameObjects() != null
				&& tile.getGameObjects()[0] != null
				&& tile.getGameObjects()[0].getLocalLocation().equals(point)
				&& objectTimerMap.get(tile).isAfter(now) //in case the entry hasn't been removed from the hashmap, ignore.
				&& Duration.between(now, objectTimerMap.get(tile)).getSeconds() < config.platformTimerThreshold())
			{
				return true;
			}
		}
		return false;
	}

	private boolean isInside()
	{
		Widget widget = client.getWidget(WidgetInfo.VOLCANICMINE_GENERAL_INFOBOX_GROUP);
		return widget != null && !widget.isHidden() && client.getPlane() == 1;
	}

	private boolean lavaBeastInRange(Player player)
	{
		Query query = new NPCQuery()
			.nameEquals(LAVA_BEAST)
			.isWithinArea(player.getLocalLocation(), LAVA_BEAST_ATTACK_RANGE);
		NPC[] npcs = queryRunner.runQuery(query);
		return npcs.length > 0;
	}

	private void warnPlayer(WarningMode warningMode, String warning)
	{
		if (warningMode == WarningMode.INGAME || warningMode == WarningMode.INGAME_AND_NOTIFICATION)
		{
			client.sendGameMessage(ChatMessageType.GAME, getColTag(config.platformColorHigh()) + "Volcanic Mine helper: " + warning);
		}
		if (warningMode == WarningMode.NOTIFICATION || warningMode == WarningMode.INGAME_AND_NOTIFICATION)
		{
			sendNotification(warning);
		}
	}

	private void sendNotification(String message)
	{
		if (!config.alertWhenFocused() && clientUI.isFocused())
		{
			return;
		}
		if (config.requestFocus())
		{
			clientUI.requestFocus();
		}
		if (config.sendTrayNotification())
		{
			notifier.notify(message);
		}
	}

	private void lookForGameObjects()
	{
		Player player = client.getLocalPlayer();
		Region region = client.getRegion();
		Tile[][][] tiles = region.getTiles();

		int z = client.getPlane();

		for (int x = 0; x < REGION_SIZE; ++x)
		{
			for (int y = 0; y < REGION_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}

				lookForGameObjects(tile, player);
			}
		}
	}

	private void lookForGameObjects(Tile tile, Player player)
	{
		Point playerLocation = player.getLocalLocation();
		GameObject[] gameObjects = tile.getGameObjects();
		if (gameObjects == null)
		{
			return;
		}

		for (GameObject gameObject : gameObjects)
		{
			if (gameObject == null)
			{
				continue;
			}
			Point objectLocation = gameObject.getLocalLocation();

			if (abs(playerLocation.getX() - objectLocation.getX()) < MAX_DISTANCE
					&& abs(playerLocation.getY() - objectLocation.getY()) < MAX_DISTANCE)
			{
				LavaPlatform lavaPlatform = LavaPlatform.fromId(gameObject.getId());
				Instant now = Instant.now();
				Instant vanishTime;

				if (lavaPlatform != null)
				{
					vanishTime = now.plus(lavaPlatform.getTime());
				}
				else if (gameObject.getId() == GAS_CHAMBER_NO_ROCK_ID)
				{
					vanishTime = now.plus(Duration.ofSeconds(GAS_CHAMBER_ROCK_RESPAWN_TIMER));
				}
				else
				{
					continue;
				}

				Instant returnInstant = objectTimerMap.putIfAbsent(tile, vanishTime);
				if (returnInstant != null)
				{
					if (returnInstant.isBefore(now)
							|| vanishTime.isBefore(returnInstant))
					{
						objectTimerMap.replace(tile, vanishTime);
					}
				}
			}
		}
	}

	private void cleanMap()
	{
		//remove the timers which hit 0
		objectTimerMap = objectTimerMap.entrySet().stream()
			.filter(entry -> Instant.now().isBefore(entry.getValue()))
			.filter(v -> v.getKey().getGameObjects() != null && v.getKey().getGameObjects()[0] != null && v.getKey().getGameObjects()[0].getId() != LAVA_ID && v.getKey().getGameObjects()[0].getId() != GAS_CHAMBER_ROCK_ID)
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}

	public static int timeToSeconds(String s) throws NumberFormatException
	{
		String[] time = s.split(":", 2);
		if (time.length < 2)
		{
			return Integer.parseInt(time[0]);
		}
		return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
	}

	public static String getColTag(Color color)
	{
		return color == null ? "" : "<col=" + Integer.toHexString(color.getRGB() & 0xFFFFFF) + ">";
	}

	public static String removeColTags(String s)
	{
		StringBuffer result = new StringBuffer();
		Matcher m = coltagPattern.matcher(s);
		while (m.find())
		{
			m.appendReplacement(result, "");
		}
		m.appendTail(result);
		return result.toString();
	}
}
