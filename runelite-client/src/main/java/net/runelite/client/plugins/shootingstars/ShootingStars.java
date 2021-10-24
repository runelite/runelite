/*
 * Copyright (c) 2021, Hexagon <hexagon@fking.work>
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
import com.google.inject.name.Named;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.LocalDateTime;
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
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.shootingstars.event.StarCrashEvent;
import net.runelite.client.plugins.shootingstars.event.StarDepletionEvent;
import net.runelite.client.plugins.shootingstars.event.StarDowngradeEvent;
import net.runelite.client.plugins.shootingstars.event.StarScoutEvent;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.lang3.time.DurationFormatUtils;

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
	private ChatMessageManager chatMessageManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	@Named("developerMode")
	private boolean developerMode;

	@Getter
	private CrashedStar crashedStar;

	@Getter
	private final List<PossibleCrashSite> possibleSites = new ArrayList<>();

	private final List<ScoutedStar> scouts = new ArrayList<>();

	private BufferedImage worldMapImage;

	private ShootingStarsPanel starsPanel;

	private NavigationButton navigationButton;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		starsPanel = new ShootingStarsPanel();

		BufferedImage icon = ImageUtil.loadImageResource(ShootingStars.class, "panel_icon.png");

		navigationButton = NavigationButton.builder()
			.tooltip("Shooting Stars")
			.icon(icon)
			.priority(2)
			.panel(starsPanel)
			.build();

		clientToolbar.addNavigation(navigationButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		clientToolbar.removeNavigation(navigationButton);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING)
		{
			resetStarTrackingState();
		}
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
		if (event.getGroupId() != CHATBOX_MESSAGE_INTERFACE)
		{
			return;
		}
		clientThread.invokeLater(this::parseTelescopeWidget);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		int starTier = getStarTier(event.getGameObject().getId());

		if (starTier <= 0)
		{
			return;
		}
		CrashedStar newStar = CrashedStar.of(client.getWorld(), event.getTile().getWorldLocation(), starTier);

		if (crashedStar == null || !crashedStar.equals(newStar))
		{
			handleNewSpottedStar(newStar);
			this.crashedStar = newStar;
		}
		else if (newStar.equals(crashedStar) && starTier < this.crashedStar.getTier())
		{
			handleDowngradedStar(newStar);
			this.crashedStar = newStar;
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		int starTier = getStarTier(event.getGameObject().getId());

		if (starTier <= 0)
		{
			return;
		}
		CrashedStar crashedStar = CrashedStar.of(client.getWorld(), event.getTile().getWorldLocation(), starTier);

		if (crashedStar.getTier() == CrashedStar.MIN_TIER)
		{
			handleDepletedStar(crashedStar);
		}
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (!developerMode)
		{
			return;
		}
		if (commandExecuted.getCommand().equals("ssregion"))
		{
			String[] args = commandExecuted.getArguments();

			if (args.length < 1)
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Insufficient parameters, usage: ssregion <regionname>", null);
				return;
			}
			String region = args[0].toUpperCase();
			try
			{
				StarRegion starRegion = StarRegion.valueOf(region);
				resetStarTrackingState();
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
			resetStarTrackingState();
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Cleared current crashed star", null);
		}
	}

	@Subscribe
	public void onStarScoutEvent(StarScoutEvent event)
	{
		StarRegion region = event.getRegion();
		setupPossibleCrashSites(region);

		String chatMessage = new ChatMessageBuilder()
			.append("A new shooting star has been scouted in this world, it'll land at ")
			.append(Color.CYAN, region.getShortName())
			.append(" in approximately ")
			.append(Color.CYAN, DurationFormatUtils.formatDurationWords(event.getOffset().toMillis(), true, true))
			.append(".")
			.build();

		QueuedMessage queuedMessage = QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(chatMessage)
			.build();

		chatMessageManager.queue(queuedMessage);
	}

	private void setupScoutedStar(ScoutedStar scoutedStar)
	{
		StarRegion region = scoutedStar.getRegion();
		setupPossibleCrashSites(region);

		LocalDateTime now = LocalDateTime.now();
		Duration earliest = Duration.between(now, scoutedStar.getEarliestTime());
		Duration latest = Duration.between(now, scoutedStar.getLatestTime());

		String chatMessage = new ChatMessageBuilder()
			.append("A shooting star has been scouted in this world, it'll land at ")
			.append(Color.CYAN, region.getShortName())
			.append(" in approximately ")
			.append(Color.CYAN, DurationFormatUtils.formatDurationWords(earliest.toMillis(), true, true))
			.append(" to ")
			.append(Color.CYAN, DurationFormatUtils.formatDurationWords(latest.toMillis(), true, true))
			.append(".")
			.build();

		QueuedMessage queuedMessage = QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(chatMessage)
			.build();

		chatMessageManager.queue(queuedMessage);
	}

	private void parseTelescopeWidget()
	{
		int world = client.getWorld();
		Widget widget = client.getWidget(CHATBOX_MESSAGE_INTERFACE, CHATBOX_MESSAGE_COMPONENT);

		if (widget == null)
		{
			return;
		}
		StarRegion region = TelescopeParser.extractStarRegion(widget.getText());
		if (region == null)
		{
			return;
		}
		Duration earliest = TelescopeParser.extractDuration(widget.getText());
		eventBus.post(StarScoutEvent.of(world, earliest, region));
	}

	/**
	 * Returns the shooting star tier for a given locId (gameObjectId). Returns -1 if the loc isn't a shooting star.
	 *
	 * @param locId The locId (gameObjectId).
	 * @return The star tier or -1 if the loc isn't a shooting star.
	 */
	private int getStarTier(int locId)
	{
		return Ints.indexOf(CRASHED_STARS, locId) + 1;
	}

	/**
	 * Returns if the given locId (gameObjectId) is a shooting star.
	 *
	 * @param locId The locId (gameObjectId)
	 * @return If the given locId is a shooting star or not.
	 */
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

			if (worldPoint.distanceTo(localPlayer.getWorldLocation()) >= MINIMUM_EVICTION_DISTANCE || checkForShootingStar(worldPoint))
			{
				continue;
			}
			QueuedMessage queuedMessage = QueuedMessage.builder()
				.type(ChatMessageType.GAMEMESSAGE)
				.runeLiteFormattedMessage(ColorUtil.wrapWithColorTag("No shooting star was found, ignoring nearby crash site.", Color.ORANGE))
				.build();

			chatMessageManager.queue(queuedMessage);
			log.debug("Removing possible crash site as no star was found at {}", worldPoint);
			worldMapPointManager.remove(possibleSite.getWorldMapPoint());
			iterator.remove();
		}
	}

	/**
	 * Resets all the plugin state to the default values.
	 */
	private void resetStarTrackingState()
	{
		crashedStar = null;
		clearPossibleSites();
	}

	private void clearPossibleSites()
	{
		possibleSites.stream()
			.map(PossibleCrashSite::getWorldMapPoint)
			.forEach(worldMapPointManager::remove);
		possibleSites.clear();
	}

	/**
	 * Sets up the world map with the possible crash sites for the given region.
	 *
	 * @param region The region where the star will land in.
	 */
	private void setupPossibleCrashSites(StarRegion region)
	{
		List<StarRegion.LandingSite> crashSites = region.getCrashSites();

		if (worldMapImage == null)
		{
			worldMapImage = createWorldMapImage();
		}

		for (StarRegion.LandingSite crashSite : crashSites)
		{
			WorldMapPoint mapPoint = WorldMapPoint.builder()
				.worldPoint(crashSite.getLocation())
				.name("Landing site")
				.image(worldMapImage)
				.jumpOnClick(true)
				.snapToEdge(true)
				.build();

			worldMapPointManager.add(mapPoint);
			possibleSites.add(PossibleCrashSite.of(crashSite.getName(), crashSite.getLocation(), mapPoint));
		}
	}

	/**
	 * Checks if there's a shooting star at the given world point.
	 *
	 * @param worldPoint The world point to be checked.
	 * @return If there's a shooting star at the world point.
	 */
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

	private void handleNewSpottedStar(CrashedStar star)
	{
		log.debug("New shooting star spotted {}", star);
		QueuedMessage queuedMessage = QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(ColorUtil.wrapWithColorTag("A shooting star has been spotted nearby!", Color.CYAN))
			.build();

		chatMessageManager.queue(queuedMessage);
		client.setHintArrow(star.getWorldPoint());
		eventBus.post(StarCrashEvent.from(star));
	}

	private void handleDowngradedStar(CrashedStar star)
	{
		log.debug("Shooting star degraded to tier {}, world={}, worldPoint={}", star.getTier(), star.getWorld(), star.getWorldPoint());
		eventBus.post(StarDowngradeEvent.from(star));
	}

	private void handleDepletedStar(CrashedStar star)
	{
		log.debug("Shooting star depleted, world={}, worldPoint={}", star.getWorld(), star.getWorldPoint());
		eventBus.post(StarDepletionEvent.from(star));
		resetStarTrackingState();
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

	@Value(staticConstructor = "of")
	private static class PossibleCrashSite
	{
		String name;
		WorldPoint worldPoint;
		WorldMapPoint worldMapPoint;
	}
}
