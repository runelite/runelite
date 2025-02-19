/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
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
package net.runelite.client.plugins.worldhopper;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ChatPlayer;
import net.runelite.api.Client;
import net.runelite.api.EnumID;
import net.runelite.api.Friend;
import net.runelite.api.FriendsChatManager;
import net.runelite.api.FriendsChatMember;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.NameableContainer;
import net.runelite.api.Varbits;
import net.runelite.api.clan.ClanChannel;
import net.runelite.api.clan.ClanChannelMember;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WorldListLoad;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.WorldsFetch;
import net.runelite.client.game.WorldService;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.worldhopper.ping.Ping;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ExecutorServiceExceptionLogger;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;

@PluginDescriptor(
	name = "World Hopper",
	description = "Allows you to quickly hop worlds",
	tags = {"ping", "switcher"}
)
@Slf4j
public class WorldHopperPlugin extends Plugin
{
	private static final int REFRESH_THROTTLE = 60_000; // ms
	private static final int MAX_PLAYER_COUNT = 1950;

	private static final int DISPLAY_SWITCHER_MAX_ATTEMPTS = 3;

	private static final String HOP_TO = "Hop-to";
	private static final String KICK_OPTION = "Kick";
	private static final ImmutableList<String> BEFORE_OPTIONS = ImmutableList.of("Add friend", "Remove friend", KICK_OPTION);
	private static final ImmutableList<String> AFTER_OPTIONS = ImmutableList.of("Message");

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private WorldHopperConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WorldHopperPingOverlay worldHopperOverlay;

	@Inject
	private WorldService worldService;

	private ScheduledExecutorService hopperExecutorService;

	private NavigationButton navButton;
	private WorldSwitcherPanel panel;

	private net.runelite.api.World quickHopTargetWorld;
	private int displaySwitcherAttempts = 0;

	@Getter
	private int lastWorld;

	private int favoriteWorld1, favoriteWorld2;

	private ScheduledFuture<?> pingFuture, currPingFuture;
	private int currentWorld;
	private Instant lastFetch;

	@Getter(AccessLevel.PACKAGE)
	private int currentPing;

	private final Map<Integer, Integer> storedPings = new HashMap<>();

	private final HotkeyListener previousKeyListener = new HotkeyListener(() -> config.previousKey())
	{
		@Override
		public void hotkeyPressed()
		{
			clientThread.invoke(() -> hop(true));
		}
	};
	private final HotkeyListener nextKeyListener = new HotkeyListener(() -> config.nextKey())
	{
		@Override
		public void hotkeyPressed()
		{
			clientThread.invoke(() -> hop(false));
		}
	};

	@Provides
	WorldHopperConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldHopperConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		currentPing = -1;

		keyManager.registerKeyListener(previousKeyListener);
		keyManager.registerKeyListener(nextKeyListener);

		panel = new WorldSwitcherPanel(this);

		BufferedImage icon = ImageUtil.loadImageResource(WorldHopperPlugin.class, "icon.png");
		navButton = NavigationButton.builder()
			.tooltip("World Switcher")
			.icon(icon)
			.priority(3)
			.panel(panel)
			.build();

		if (config.showSidebar())
		{
			clientToolbar.addNavigation(navButton);
		}

		overlayManager.add(worldHopperOverlay);

		panel.setSubscriptionFilterMode(config.subscriptionFilter());
		panel.setRegionFilterMode(config.regionFilter());
		panel.setWorldTypeFilters(config.worldTypeFilter());

		// The plugin has its own executor for pings, as it blocks for a long time
		hopperExecutorService = new ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor());
		// populate initial world list
		hopperExecutorService.execute(this::updateList);
		// Run the first-run ping
		hopperExecutorService.execute(this::pingInitialWorlds);

		// Give some initial delay - this won't run until after pingInitialWorlds finishes anyway
		pingFuture = hopperExecutorService.scheduleWithFixedDelay(this::pingNextWorld, 15, 3, TimeUnit.SECONDS);
		currPingFuture = hopperExecutorService.scheduleWithFixedDelay(this::pingCurrentWorld, 15, 1, TimeUnit.SECONDS);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pingFuture.cancel(true);
		pingFuture = null;

		currPingFuture.cancel(true);
		currPingFuture = null;

		overlayManager.remove(worldHopperOverlay);

		keyManager.unregisterKeyListener(previousKeyListener);
		keyManager.unregisterKeyListener(nextKeyListener);

		clientToolbar.removeNavigation(navButton);

		hopperExecutorService.shutdown();
		hopperExecutorService = null;
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		if (event.getGroup().equals(WorldHopperConfig.GROUP))
		{
			switch (event.getKey())
			{
				case "showSidebar":
					if (config.showSidebar())
					{
						clientToolbar.addNavigation(navButton);
					}
					else
					{
						clientToolbar.removeNavigation(navButton);
					}
					break;
				case "ping":
					if (config.ping())
					{
						SwingUtilities.invokeLater(() -> panel.showPing());
					}
					else
					{
						SwingUtilities.invokeLater(() -> panel.hidePing());
					}
					break;
				case "subscriptionFilter":
					panel.setSubscriptionFilterMode(config.subscriptionFilter());
					updateList();
					break;
				case "regionFilter":
					panel.setRegionFilterMode(config.regionFilter());
					updateList();
					break;
				case "worldTypeFilter":
					panel.setWorldTypeFilters(config.worldTypeFilter());
					updateList();
					break;
			}
		}
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if ("hop".equalsIgnoreCase(commandExecuted.getCommand()))
		{
			int worldNumber;
			try
			{
				String[] arguments = commandExecuted.getArguments();
				worldNumber = Integer.parseInt(arguments[0]);
			}
			catch (NumberFormatException | ArrayIndexOutOfBoundsException ex)
			{
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.value("Usage: ::hop world")
					.build());
				return;
			}

			World world = worldService.getWorlds().findWorld(worldNumber);
			if (world == null)
			{
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.value("Unknown world " + worldNumber)
					.build());
				return;
			}

			hop(world);
		}
	}

	private void setFavoriteConfig(int world)
	{
		configManager.setConfiguration(WorldHopperConfig.GROUP, "favorite_" + world, true);
	}

	private boolean isFavoriteConfig(int world)
	{
		Boolean favorite = configManager.getConfiguration(WorldHopperConfig.GROUP, "favorite_" + world, Boolean.class);
		return favorite != null && favorite;
	}

	private void clearFavoriteConfig(int world)
	{
		configManager.unsetConfiguration(WorldHopperConfig.GROUP, "favorite_" + world);
	}

	boolean isFavorite(World world)
	{
		int id = world.getId();
		return id == favoriteWorld1 || id == favoriteWorld2 || isFavoriteConfig(id);
	}

	int getCurrentWorld()
	{
		return client.getWorld();
	}

	void addToFavorites(World world)
	{
		log.debug("Adding world {} to favorites", world.getId());
		setFavoriteConfig(world.getId());
		panel.updateFavoriteMenu(world.getId(), true);
	}

	void removeFromFavorites(World world)
	{
		log.debug("Removing world {} from favorites", world.getId());
		clearFavoriteConfig(world.getId());
		panel.updateFavoriteMenu(world.getId(), false);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (varbitChanged.getVarbitId() == Varbits.WORLDHOPPER_FAVORITE_1
			|| varbitChanged.getVarbitId() == Varbits.WORLDHOPPER_FAVORITE_2)
		{
			favoriteWorld1 = client.getVarbitValue(Varbits.WORLDHOPPER_FAVORITE_1);
			favoriteWorld2 = client.getVarbitValue(Varbits.WORLDHOPPER_FAVORITE_2);
			SwingUtilities.invokeLater(panel::updateList);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!config.menuOption())
		{
			return;
		}

		final int componentId = event.getActionParam1();
		int groupId = WidgetUtil.componentToInterface(componentId);
		String option = event.getOption();

		if (groupId == InterfaceID.FRIEND_LIST || groupId == InterfaceID.FRIENDS_CHAT
			|| componentId == ComponentID.CLAN_MEMBERS || componentId == ComponentID.CLAN_GUEST_MEMBERS)
		{
			boolean after;

			if (AFTER_OPTIONS.contains(option))
			{
				after = true;
			}
			else if (BEFORE_OPTIONS.contains(option))
			{
				after = false;
			}
			else
			{
				return;
			}

			// Don't add entry if user is offline
			ChatPlayer player = getChatPlayerFromName(event.getTarget());
			WorldResult worldResult = worldService.getWorlds();

			if (player == null || player.getWorld() == 0 || player.getWorld() == client.getWorld()
				|| worldResult == null)
			{
				return;
			}

			World currentWorld = worldResult.findWorld(client.getWorld());
			World targetWorld = worldResult.findWorld(player.getWorld());
			if (targetWorld == null || currentWorld == null
				|| (!currentWorld.getTypes().contains(WorldType.PVP) && targetWorld.getTypes().contains(WorldType.PVP)))
			{
				// Disable Hop-to a PVP world from a regular world
				return;
			}

			client.createMenuEntry(after ? -2 : -1)
				.setOption(HOP_TO)
				.setTarget(event.getTarget())
				.setType(MenuAction.RUNELITE)
				.onClick(e ->
				{
					ChatPlayer p = getChatPlayerFromName(e.getTarget());

					if (p != null)
					{
						hop(p.getWorld());
					}
				});
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		// If the player has disabled the side bar plugin panel, do not update the UI
		if (config.showSidebar() && gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			if (lastWorld != client.getWorld())
			{
				int newWorld = client.getWorld();
				panel.switchCurrentHighlight(newWorld, lastWorld);
				lastWorld = newWorld;
			}
		}
	}

	@Subscribe
	public void onWorldListLoad(WorldListLoad worldListLoad)
	{
		if (!config.showSidebar())
		{
			return;
		}

		Map<Integer, Integer> worldData = new HashMap<>();

		for (net.runelite.api.World w : worldListLoad.getWorlds())
		{
			worldData.put(w.getId(), w.getPlayerCount());
		}

		panel.updateListData(worldData);
		this.lastFetch = Instant.now(); // This counts as a fetch as it updates populations
	}

	void refresh()
	{
		Instant now = Instant.now();
		if (lastFetch != null && now.toEpochMilli() - lastFetch.toEpochMilli() < REFRESH_THROTTLE)
		{
			log.debug("Throttling world refresh");
			return;
		}

		lastFetch = now;
		worldService.refresh();
	}

	@Subscribe
	public void onWorldsFetch(WorldsFetch worldsFetch)
	{
		updateList();
	}

	/**
	 * This method ONLY updates the list's UI, not the actual world list and data it displays.
	 */
	private void updateList()
	{
		WorldResult worldResult = worldService.getWorlds();
		if (worldResult != null)
		{
			clientThread.invokeLater(() ->
			{
				var locationEnum = client.getGameState().getState() >= GameState.LOGIN_SCREEN.getState() ? client.getEnum(EnumID.WORLD_LOCATIONS) : null;
				SwingUtilities.invokeLater(() -> panel.populate(worldResult.getWorlds(), locationEnum));
			});
		}
	}

	private void hop(boolean previous)
	{
		WorldResult worldResult = worldService.getWorlds();
		if (worldResult == null || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		World currentWorld = worldResult.findWorld(client.getWorld());

		if (currentWorld == null)
		{
			return;
		}

		EnumSet<WorldType> currentWorldTypes = currentWorld.getTypes().clone();
		// Make it so you always hop out of PVP and high risk worlds
		if (config.quickhopOutOfDanger())
		{
			currentWorldTypes.remove(WorldType.PVP);
			currentWorldTypes.remove(WorldType.HIGH_RISK);
		}
		// Don't regard these worlds as a type that must be hopped between
		currentWorldTypes.remove(WorldType.BOUNTY);
		currentWorldTypes.remove(WorldType.SKILL_TOTAL);
		currentWorldTypes.remove(WorldType.LAST_MAN_STANDING);

		List<World> worlds = worldResult.getWorlds();

		int worldIdx = worlds.indexOf(currentWorld);
		int totalLevel = client.getTotalLevel();

		final Set<RegionFilterMode> regionFilter = config.regionFilter();

		World world;
		do
		{
			/*
				Get the previous or next world in the list,
				starting over at the other end of the list
				if there are no more elements in the
				current direction of iteration.
			 */
			if (previous)
			{
				worldIdx--;

				if (worldIdx < 0)
				{
					worldIdx = worlds.size() - 1;
				}
			}
			else
			{
				worldIdx++;

				if (worldIdx >= worlds.size())
				{
					worldIdx = 0;
				}
			}

			world = worlds.get(worldIdx);

			// Check world region if filter is enabled
			if (!regionFilter.isEmpty() && !regionFilter.contains(RegionFilterMode.of(world.getRegion())))
			{
				continue;
			}

			EnumSet<WorldType> types = world.getTypes().clone();

			types.remove(WorldType.BOUNTY);
			// Treat LMS world like casual world
			types.remove(WorldType.LAST_MAN_STANDING);

			if (types.contains(WorldType.SKILL_TOTAL))
			{
				try
				{
					int totalRequirement = Integer.parseInt(world.getActivity().substring(0, world.getActivity().indexOf(" ")));

					if (totalLevel >= totalRequirement)
					{
						types.remove(WorldType.SKILL_TOTAL);
					}
				}
				catch (NumberFormatException ex)
				{
					log.warn("Failed to parse total level requirement for target world", ex);
				}
			}

			// Avoid switching to near-max population worlds, as it will refuse to allow the hop if the world is full
			if (world.getPlayers() >= MAX_PLAYER_COUNT)
			{
				continue;
			}

			if (world.getPlayers() < 0)
			{
				// offline world
				continue;
			}

			// Break out if we've found a good world to hop to
			if (currentWorldTypes.equals(types))
			{
				break;
			}
		}
		while (world != currentWorld);

		if (world == currentWorld)
		{
			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Couldn't find a world to quick-hop to.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}
		else
		{
			hop(world.getId());
		}
	}

	private void hop(int worldId)
	{
		WorldResult worldResult = worldService.getWorlds();
		// Don't try to hop if the world doesn't exist
		World world = worldResult.findWorld(worldId);
		if (world == null)
		{
			return;
		}

		hop(world);
	}

	void hopTo(World world)
	{
		// this is called from the panel, on edt
		clientThread.invoke(() -> hop(world));
	}

	private void hop(World world)
	{
		assert client.isClientThread();

		final net.runelite.api.World rsWorld = client.createWorld();
		rsWorld.setActivity(world.getActivity());
		rsWorld.setAddress(world.getAddress());
		rsWorld.setId(world.getId());
		rsWorld.setPlayerCount(world.getPlayers());
		rsWorld.setLocation(world.getLocation());
		rsWorld.setTypes(WorldUtil.toWorldTypes(world.getTypes()));

		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// on the login screen we can just change the world by ourselves
			client.changeWorld(rsWorld);
			return;
		}

		if (config.showWorldHopMessage())
		{
			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Quick-hopping to World ")
				.append(ChatColorType.HIGHLIGHT)
				.append(Integer.toString(world.getId()))
				.append(ChatColorType.NORMAL)
				.append("..")
				.build();

			chatMessageManager
				.queue(QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(chatMessage)
					.build());
		}

		quickHopTargetWorld = rsWorld;
		displaySwitcherAttempts = 0;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (quickHopTargetWorld == null)
		{
			return;
		}

		if (client.getWidget(ComponentID.WORLD_SWITCHER_WORLD_LIST) == null)
		{
			client.openWorldHopper();

			if (++displaySwitcherAttempts >= DISPLAY_SWITCHER_MAX_ATTEMPTS)
			{
				String chatMessage = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Failed to quick-hop after ")
					.append(ChatColorType.HIGHLIGHT)
					.append(Integer.toString(displaySwitcherAttempts))
					.append(ChatColorType.NORMAL)
					.append(" attempts.")
					.build();

				chatMessageManager
					.queue(QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage(chatMessage)
						.build());

				resetQuickHopper();
			}
		}
		else
		{
			client.hopToWorld(quickHopTargetWorld);
			resetQuickHopper();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		if (event.getMessage().equals("Please finish what you're doing before using the World Switcher."))
		{
			resetQuickHopper();
		}
	}

	private void resetQuickHopper()
	{
		displaySwitcherAttempts = 0;
		quickHopTargetWorld = null;
	}

	private ChatPlayer getChatPlayerFromName(String name)
	{
		String cleanName = Text.removeTags(name);

		// Search friends chat members first, because we can always get their world;
		// friends worlds may be hidden if they have private off. (#5679)
		FriendsChatManager friendsChatManager = client.getFriendsChatManager();
		if (friendsChatManager != null)
		{
			FriendsChatMember member = friendsChatManager.findByName(cleanName);
			if (member != null)
			{
				return member;
			}
		}

		ClanChannel clanChannel = client.getClanChannel();
		if (clanChannel != null)
		{
			ClanChannelMember member = clanChannel.findMember(cleanName);
			if (member != null)
			{
				return member;
			}
		}

		clanChannel = client.getGuestClanChannel();
		if (clanChannel != null)
		{
			ClanChannelMember member = clanChannel.findMember(cleanName);
			if (member != null)
			{
				return member;
			}
		}

		NameableContainer<Friend> friendContainer = client.getFriendContainer();
		if (friendContainer != null)
		{
			return friendContainer.findByName(cleanName);
		}

		return null;
	}

	/**
	 * Ping all worlds. This takes a long time and is only run on first run.
	 */
	private void pingInitialWorlds()
	{
		WorldResult worldResult = worldService.getWorlds();
		if (worldResult == null || !config.showSidebar() || !config.ping())
		{
			return;
		}

		Stopwatch stopwatch = Stopwatch.createStarted();

		for (World world : worldResult.getWorlds())
		{
			int ping = ping(world);
			SwingUtilities.invokeLater(() -> panel.updatePing(world.getId(), ping));
		}

		stopwatch.stop();

		log.debug("Done pinging worlds in {}", stopwatch.elapsed());
	}

	/**
	 * Ping the next world
	 */
	private void pingNextWorld()
	{
		WorldResult worldResult = worldService.getWorlds();
		if (worldResult == null || !config.showSidebar() || !config.ping())
		{
			return;
		}

		List<World> worlds = worldResult.getWorlds();
		if (worlds.isEmpty())
		{
			return;
		}

		if (currentWorld >= worlds.size())
		{
			// Wrap back around
			currentWorld = 0;
		}

		World world = worlds.get(currentWorld++);

		// If we are displaying the ping overlay, there is a separate scheduled task for the current world
		boolean displayPing = config.displayPing() && client.getGameState() == GameState.LOGGED_IN;
		if (displayPing && client.getWorld() == world.getId())
		{
			return;
		}

		int ping = ping(world);
		log.trace("Ping for world {} is: {}", world.getId(), ping);

		if (panel.isActive())
		{
			SwingUtilities.invokeLater(() -> panel.updatePing(world.getId(), ping));
		}
	}

	/**
	 * Ping the current world for the ping overlay
	 */
	private void pingCurrentWorld()
	{
		WorldResult worldResult = worldService.getWorlds();
		// There is no reason to ping the current world if not logged in, as the overlay doesn't draw
		if (worldResult == null || !config.displayPing() || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final World currentWorld = worldResult.findWorld(client.getWorld());
		if (currentWorld == null)
		{
			log.trace("unable to find current world: {}", client.getWorld());
			return;
		}

		int ping = ping(currentWorld);
		log.trace("Ping for current world is: {}", currentPing);

		if (ping < 0)
		{
			return;
		}

		currentPing = ping;

		if (panel.isActive())
		{
			SwingUtilities.invokeLater(() -> panel.updatePing(currentWorld.getId(), currentPing));
		}
	}

	Integer getStoredPing(World world)
	{
		if (!config.ping())
		{
			return null;
		}

		return storedPings.get(world.getId());
	}

	private int ping(World world)
	{
		int ping = Ping.ping(world);
		storedPings.put(world.getId(), ping);
		return ping;
	}
}
