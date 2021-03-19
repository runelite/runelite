/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.npcunaggroarea;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.geometry.Geometry;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.WildcardMatcher;

@PluginDescriptor(
	name = "NPC Aggression Timer",
	description = "Highlights the unaggressive area of NPCs nearby and timer until it becomes active",
	tags = {"highlight", "lines", "unaggro", "aggro", "aggressive", "npcs", "area", "slayer"},
	enabledByDefault = false
)
public class NpcAggroAreaPlugin extends Plugin
{
	/*
	How it works: The game remembers 2 tiles. When the player goes >10 steps
	away from both tiles, the oldest one is moved to under the player and the
	NPC aggression timer resets.
	So to first figure out where the 2 tiles are, we wait until the player teleports
	a long enough distance. At that point it's very likely that the player
	moved out of the radius of both tiles, which resets one of them. The other
	should reset shortly after as the player starts moving around.
	*/

	private static final int SAFE_AREA_RADIUS = 10;
	private static final int UNKNOWN_AREA_RADIUS = SAFE_AREA_RADIUS * 2;
	private static final int AGGRESSIVE_TIME_SECONDS = 600;
	private static final Splitter NAME_SPLITTER = Splitter.on(',').omitEmptyStrings().trimResults();
	private static final WorldArea WILDERNESS_ABOVE_GROUND = new WorldArea(2944, 3523, 448, 448, 0);
	private static final WorldArea WILDERNESS_UNDERGROUND = new WorldArea(2944, 9918, 320, 442, 0);

	@Inject
	private Client client;

	@Inject
	private NpcAggroAreaConfig config;

	@Inject
	private NpcAggroAreaOverlay overlay;

	@Inject
	private NpcAggroAreaNotWorkingOverlay notWorkingOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Notifier notifier;

	@Getter
	private final WorldPoint[] safeCenters = new WorldPoint[2];

	@Getter
	private final GeneralPath[] linesToDisplay = new GeneralPath[Constants.MAX_Z];

	@Getter
	private boolean active;

	@Getter
	private AggressionTimer currentTimer;

	private WorldPoint lastPlayerLocation;
	private WorldPoint previousUnknownCenter;
	private boolean loggingIn;
	private boolean notifyOnce;

	private List<String> npcNamePatterns;

	@Provides
	NpcAggroAreaConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(NpcAggroAreaConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(notWorkingOverlay);
		npcNamePatterns = NAME_SPLITTER.splitToList(config.npcNamePatterns());
		recheckActive();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeTimer();
		overlayManager.remove(overlay);
		overlayManager.remove(notWorkingOverlay);
		Arrays.fill(safeCenters, null);
		lastPlayerLocation = null;
		currentTimer = null;
		loggingIn = false;
		npcNamePatterns = null;
		active = false;

		Arrays.fill(linesToDisplay, null);
	}

	private Area generateSafeArea()
	{
		final Area area = new Area();

		for (WorldPoint wp : safeCenters)
		{
			if (wp == null)
			{
				continue;
			}

			Polygon poly = new Polygon();
			poly.addPoint(wp.getX() - SAFE_AREA_RADIUS, wp.getY() - SAFE_AREA_RADIUS);
			poly.addPoint(wp.getX() - SAFE_AREA_RADIUS, wp.getY() + SAFE_AREA_RADIUS + 1);
			poly.addPoint(wp.getX() + SAFE_AREA_RADIUS + 1, wp.getY() + SAFE_AREA_RADIUS + 1);
			poly.addPoint(wp.getX() + SAFE_AREA_RADIUS + 1, wp.getY() - SAFE_AREA_RADIUS);
			area.add(new Area(poly));
		}

		return area;
	}

	private void transformWorldToLocal(float[] coords)
	{
		final LocalPoint lp = LocalPoint.fromWorld(client, (int)coords[0], (int)coords[1]);
		coords[0] = lp.getX() - Perspective.LOCAL_TILE_SIZE / 2f;
		coords[1] = lp.getY() - Perspective.LOCAL_TILE_SIZE / 2f;
	}

	private void reevaluateActive()
	{
		if (currentTimer != null)
		{
			currentTimer.setVisible(active && config.showTimer());
		}

		calculateLinesToDisplay();
	}

	private void calculateLinesToDisplay()
	{
		if (!active || !config.showAreaLines())
		{
			Arrays.fill(linesToDisplay, null);
			return;
		}

		Rectangle sceneRect = new Rectangle(
			client.getBaseX() + 1, client.getBaseY() + 1,
			Constants.SCENE_SIZE - 2, Constants.SCENE_SIZE - 2);

		for (int i = 0; i < linesToDisplay.length; i++)
		{
			GeneralPath lines = new GeneralPath(generateSafeArea());
			lines = Geometry.clipPath(lines, sceneRect);
			lines = Geometry.splitIntoSegments(lines, 1);
			lines = Geometry.transformPath(lines, this::transformWorldToLocal);
			linesToDisplay[i] = lines;
		}
	}

	private void removeTimer()
	{
		infoBoxManager.removeInfoBox(currentTimer);
		currentTimer = null;
		notifyOnce = false;
	}

	private void createTimer(Duration duration)
	{
		removeTimer();
		BufferedImage image = itemManager.getImage(ItemID.ENSOULED_DEMON_HEAD);
		currentTimer = new AggressionTimer(duration, image, this, active && config.showTimer());
		infoBoxManager.addInfoBox(currentTimer);
		notifyOnce = true;
	}

	private void resetTimer()
	{
		createTimer(Duration.ofSeconds(AGGRESSIVE_TIME_SECONDS));
	}

	private static boolean isInWilderness(WorldPoint location)
	{
		return WILDERNESS_ABOVE_GROUND.distanceTo2D(location) == 0 || WILDERNESS_UNDERGROUND.distanceTo2D(location) == 0;
	}

	private boolean isNpcMatch(NPC npc)
	{
		NPCComposition composition = npc.getTransformedComposition();
		if (composition == null)
		{
			return false;
		}

		if (Strings.isNullOrEmpty(composition.getName()))
		{
			return false;
		}

		// Most NPCs stop aggroing when the player has more than double
		// its combat level.
		int playerLvl = client.getLocalPlayer().getCombatLevel();
		int npcLvl = composition.getCombatLevel();
		String npcName = composition.getName().toLowerCase();
		if (npcLvl > 0 && playerLvl > npcLvl * 2 && !isInWilderness(npc.getWorldLocation()))
		{
			return false;
		}

		for (String pattern : npcNamePatterns)
		{
			if (WildcardMatcher.matches(pattern, npcName))
			{
				return true;
			}
		}

		return false;
	}

	private void checkAreaNpcs(final NPC... npcs)
	{
		for (NPC npc : npcs)
		{
			if (npc == null)
			{
				continue;
			}

			if (isNpcMatch(npc))
			{
				active = true;
				break;
			}
		}

		reevaluateActive();
	}

	private void recheckActive()
	{
		active = config.alwaysActive();
		checkAreaNpcs(client.getCachedNPCs());
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (config.alwaysActive())
		{
			return;
		}

		checkAreaNpcs(event.getNpc());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		WorldPoint newLocation = client.getLocalPlayer().getWorldLocation();

		if (active && currentTimer != null && currentTimer.cull() && notifyOnce)
		{
			if (config.notifyExpire())
			{
				notifier.notify("NPC aggression has expired!");
			}

			notifyOnce = false;
		}

		if (lastPlayerLocation != null)
		{
			if (safeCenters[1] == null && newLocation.distanceTo2D(lastPlayerLocation) > SAFE_AREA_RADIUS * 4)
			{
				safeCenters[0] = null;
				safeCenters[1] = newLocation;
				resetTimer();
				calculateLinesToDisplay();

				// We don't know where the previous area was, so if the player e.g.
				// entered a dungeon and then goes back out, he/she may enter the previous
				// area which is unknown and would make the plugin inaccurate
				previousUnknownCenter = lastPlayerLocation;
			}
		}

		if (safeCenters[0] == null && previousUnknownCenter != null &&
			previousUnknownCenter.distanceTo2D(newLocation) <= UNKNOWN_AREA_RADIUS)
		{
			// Player went back to their previous unknown area before the 2nd
			// center point was found, which means we don't know where it is again.
			safeCenters[1] = null;
			removeTimer();
			calculateLinesToDisplay();
		}

		if (safeCenters[1] != null)
		{
			if (Arrays.stream(safeCenters).noneMatch(
				x -> x != null && x.distanceTo2D(newLocation) <= SAFE_AREA_RADIUS))
			{
				safeCenters[0] = safeCenters[1];
				safeCenters[1] = newLocation;
				resetTimer();
				calculateLinesToDisplay();
				previousUnknownCenter = null;
			}
		}

		lastPlayerLocation = newLocation;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		String key = event.getKey();
		switch (key)
		{
			case "npcUnaggroAlwaysActive":
				recheckActive();
				break;
			case "npcUnaggroShowTimer":
				if (currentTimer != null)
				{
					currentTimer.setVisible(active && config.showTimer());
				}
				break;
			case "npcUnaggroCollisionDetection":
			case "npcUnaggroShowAreaLines":
				calculateLinesToDisplay();
				break;
			case "npcUnaggroNames":
				npcNamePatterns = NAME_SPLITTER.splitToList(config.npcNamePatterns());
				recheckActive();
				break;
		}
	}

	private void loadConfig()
	{
		safeCenters[0] = configManager.getConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER1, WorldPoint.class);
		safeCenters[1] = configManager.getConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER2, WorldPoint.class);
		lastPlayerLocation = configManager.getConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_LOCATION, WorldPoint.class);

		Duration timeLeft = configManager.getConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_DURATION, Duration.class);
		if (timeLeft != null && !timeLeft.isNegative())
		{
			createTimer(timeLeft);
		}
	}

	private void resetConfig()
	{
		configManager.unsetConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER1);
		configManager.unsetConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER2);
		configManager.unsetConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_LOCATION);
		configManager.unsetConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_DURATION);
	}

	private void saveConfig()
	{
		if (safeCenters[0] == null || safeCenters[1] == null || lastPlayerLocation == null || currentTimer == null)
		{
			resetConfig();
		}
		else
		{
			configManager.setConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER1, safeCenters[0]);
			configManager.setConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_CENTER2, safeCenters[1]);
			configManager.setConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_LOCATION, lastPlayerLocation);
			configManager.setConfiguration(NpcAggroAreaConfig.CONFIG_GROUP, NpcAggroAreaConfig.CONFIG_DURATION, Duration.between(Instant.now(), currentTimer.getEndTime()));
		}
	}

	private void onLogin()
	{
		loadConfig();
		resetConfig();

		WorldPoint newLocation = client.getLocalPlayer().getWorldLocation();
		assert newLocation != null;

		// If the player isn't at the location he/she logged out at,
		// the safe unaggro area probably changed, and should be disposed.
		if (lastPlayerLocation == null || newLocation.distanceTo(lastPlayerLocation) != 0)
		{
			safeCenters[0] = null;
			safeCenters[1] = null;
			lastPlayerLocation = newLocation;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGGED_IN:
				if (loggingIn)
				{
					loggingIn = false;
					onLogin();
				}

				recheckActive();
				break;

			case LOGGING_IN:
				loggingIn = true;
				break;

			case LOGIN_SCREEN:
				if (lastPlayerLocation != null)
				{
					saveConfig();
				}

				safeCenters[0] = null;
				safeCenters[1] = null;
				lastPlayerLocation = null;
				break;
		}
	}
}
