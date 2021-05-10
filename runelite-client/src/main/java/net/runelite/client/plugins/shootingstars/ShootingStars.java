/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.shootingstars;

import com.google.common.primitives.Ints;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.shootingstars.event.StarCrashEvent;
import net.runelite.client.plugins.shootingstars.event.StarDepletionEvent;
import net.runelite.client.plugins.shootingstars.event.StarDowngradeEvent;
import net.runelite.client.plugins.shootingstars.event.StarScoutEvent;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Shooting Stars",
	description = "Helps you track shooting stars",
	enabledByDefault = false
)
public class ShootingStars extends Plugin
{

	private static final int MINIMUM_EVICTION_DISTANCE = 26;
	private static final int HINT_ARROW_CLEAR_DISTANCE = 6;

	private static final int CHATBOX_MESSAGE_INTERFACE = 229;
	private static final int CHATBOX_MESSAGE_COMPONENT = 1;

	private static final int[] CRASHED_STARS = {
		ObjectID.CRASHED_STAR_41229,
		ObjectID.CRASHED_STAR_41228,
		ObjectID.CRASHED_STAR_41227,
		ObjectID.CRASHED_STAR_41226,
		ObjectID.CRASHED_STAR_41225,
		ObjectID.CRASHED_STAR_41224,
		ObjectID.CRASHED_STAR_41223,
		ObjectID.CRASHED_STAR_41021,
		ObjectID.CRASHED_STAR
	};

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ShootingStarsOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Getter
	private CrashedStar crashedStar;

	@Getter
	private final List<PossibleCrashSite> possibleSites = new ArrayList<>();

	private BufferedImage worldMapImage;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		Player localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			return;
		}
		if (crashedStar == null)
		{
			evaluatePossibleCrashSites(localPlayer);
		}
		else
		{
			if (client.hasHintArrow() && localPlayer.getWorldLocation().distanceTo(crashedStar.getWorldPoint()) < HINT_ARROW_CLEAR_DISTANCE)
			{
				client.clearHintArrow();
			}
			if (!possibleSites.isEmpty())
			{
				log.debug("Clearing possible landing sites as we've found the star already.");
				clearPossibleSites();
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == CHATBOX_MESSAGE_INTERFACE)
		{
			clientThread.invokeLater(() -> {
				int world = client.getWorld();
				Widget widget = client.getWidget(CHATBOX_MESSAGE_INTERFACE, CHATBOX_MESSAGE_COMPONENT);

				if (widget == null)
				{
					return;
				}
				eventBus.post(new StarScoutEvent());
			});
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		int starTier = getStarTier(event.getGameObject().getId());

		if (starTier > 0)
		{
			CrashedStar newStar = new CrashedStar(client.getWorld(), event.getTile().getWorldLocation(), starTier);

			if (crashedStar == null || crashedStar.depleted() || !crashedStar.isSame(newStar))
			{
				log.debug("New shooting star spotted {}", newStar);
				this.crashedStar = newStar;
				client.setHintArrow(newStar.getWorldPoint());
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "A shooting star has been spotted nearby!", null);
				eventBus.post(StarCrashEvent.from(crashedStar));
			}
			else if (starTier != this.crashedStar.getTier() && newStar.isSame(crashedStar))
			{
				this.crashedStar = this.crashedStar.reduceTier();
				log.debug("Shooting star degraded to tier {}, world={}, worldPoint={}", crashedStar.getTier(), crashedStar.getWorld(), crashedStar.getWorldPoint());
				eventBus.post(StarDowngradeEvent.from(crashedStar));
			}
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (isShootingStar(event.getGameObject().getId()) && crashedStar != null && crashedStar.getTier() == CrashedStar.MIN_TIER)
		{
			log.debug("Shooting star depleted, world={}, worldPoint={}", crashedStar.getWorld(), crashedStar.getWorldPoint());
			eventBus.post(StarDepletionEvent.from(crashedStar));
			crashedStar = null;
		}
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (commandExecuted.getCommand().equals("ssregion"))
		{
			String[] args = commandExecuted.getArguments();

			if (args.length < 1)
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Insufficient parameters, usage: ssregion <regionname>", null);
			}
			String region = args[0].toUpperCase();
			try
			{
				StarRegion starRegion = StarRegion.valueOf(region);
				setupPossibleCrashSites(starRegion);
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Star region set to: " + starRegion, null);
			}
			catch (IllegalArgumentException e)
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "No star region could be found with name: " + region, null);
			}
		}
		else if (commandExecuted.getCommand().equals("ssclear"))
		{
			crashedStar = null;
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Cleared current crashed star", null);
		}
	}

	/**
	 * Returns the shooting star tier for a given locId. Returns -1 if the loc isn't a shooting star.
	 *
	 * @param locId The locId.
	 * @return The star tier or -1 if the loc isn't a shooting star.
	 */
	private int getStarTier(int locId)
	{
		return Ints.indexOf(CRASHED_STARS, locId) + 1;
	}

	private boolean isShootingStar(int locId)
	{
		return getStarTier(locId) > 0;
	}

	/**
	 * Evaluates and excludes crash sites where a star isn't found.
	 */
	private void evaluatePossibleCrashSites(Player localPlayer)
	{
		Iterator<PossibleCrashSite> iterator = possibleSites.iterator();
		while (iterator.hasNext())
		{
			PossibleCrashSite possibleSite = iterator.next();
			WorldPoint worldPoint = possibleSite.getWorldPoint();

			if (worldPoint.distanceTo(localPlayer.getWorldLocation()) < MINIMUM_EVICTION_DISTANCE && !checkForShootingStar(worldPoint))
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "No shooting star was found nearby, ignoring this crash site.", null);
				log.debug("Removing possible crash site as no star was found at {}", worldPoint);
				worldMapPointManager.remove(possibleSite.getWorldMapPoint());
				iterator.remove();
			}
		}
	}

	private void clearPossibleSites()
	{
		possibleSites.stream()
			.map(PossibleCrashSite::getWorldMapPoint)
			.forEach(worldMapPointManager::remove);
		possibleSites.clear();
	}

	private boolean checkForShootingStar(WorldPoint worldPoint)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(client, worldPoint);

		if (localPoint == null)
		{
			return false;
		}
		Tile tile = client.getScene().getTiles()[client.getPlane()][localPoint.getSceneX()][localPoint.getSceneY()];

		for (GameObject gameObject : tile.getGameObjects())
		{
			if (gameObject != null && isShootingStar(gameObject.getId()))
			{
				return true;
			}
		}
		return false;
	}

	private BufferedImage createWorldMapImage()
	{
		BufferedImage background = ImageUtil.loadImageResource(ShootingStars.class, "/util/clue_arrow.png");
		AsyncBufferedImage starFragment = itemManager.getImage(ItemID.STAR_FRAGMENT);

		BufferedImage image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();

		graphics.drawImage(background, 0, 0, null);
		graphics.drawImage(starFragment, 0, 0, null);
		return image;
	}

	private void setupPossibleCrashSites(StarRegion region)
	{
		List<StarCrashSite> crashSites = region.getCrashSites();
		clearPossibleSites();

		if (worldMapImage == null)
		{
			worldMapImage = createWorldMapImage();
		}

		for (StarCrashSite crashSite : crashSites)
		{
			WorldMapPoint mapPoint = WorldMapPoint.builder()
				.worldPoint(crashSite.getLocation())
				.tooltip("Shooting Star")
				.image(worldMapImage)
				.jumpOnClick(true)
				.snapToEdge(true)
				.build();

			worldMapPointManager.add(mapPoint);
			possibleSites.add(PossibleCrashSite.of(crashSite.getName(), crashSite.getLocation(), mapPoint));
		}
	}

	@Value(staticConstructor = "of")
	private static class PossibleCrashSite
	{
		String name;
		WorldPoint worldPoint;
		WorldMapPoint worldMapPoint;
	}
}
