/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
import com.google.common.collect.ObjectArrays;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ChatPlayer;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WorldListLoad;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.worldhopper.ping.Ping;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ExecutorServiceExceptionLogger;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.Text;
import net.runelite.client.util.WorldUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "World Hopper",
	description = "Allows you to quickly hop worlds"
)
@Slf4j
public class WorldHopperPlugin extends Plugin
{
	private static final int WORLD_FETCH_TIMER = 10;
	private static final int WORLD_PING_TIMER = 10;
	private static final int REFRESH_THROTTLE = 60_000;  // ms
	private static final int TICK_THROTTLE = (int) Duration.ofMinutes(10).toMillis();

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
	private ScheduledExecutorService executorService;

	@Inject
	private WorldHopperConfig config;

	private ScheduledExecutorService hopperExecutorService;

	private NavigationButton navButton;
	private WorldSwitcherPanel panel;

	private net.runelite.api.World quickHopTargetWorld;
	private int displaySwitcherAttempts = 0;

	@Getter
	private int lastWorld;

	private int favoriteWorld1, favoriteWorld2;

	private ScheduledFuture<?> worldResultFuture, pingFuture;
	private WorldResult worldResult;
	private Instant lastFetch;
	private boolean firstRun;

	private final HotkeyListener previousKeyListener = new HotkeyListener(() -> config.previousKey())
	{
		@Override
		public void hotkeyPressed()
		{
			hop(true);
		}
	};
	private final HotkeyListener nextKeyListener = new HotkeyListener(() -> config.nextKey())
	{
		@Override
		public void hotkeyPressed()
		{
			hop(false);
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
		firstRun = true;

		keyManager.registerKeyListener(previousKeyListener);
		keyManager.registerKeyListener(nextKeyListener);

		panel = new WorldSwitcherPanel(this);

		final BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("icon.png"));
		}

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

		worldResultFuture = executorService.scheduleAtFixedRate(this::tick, 0, WORLD_FETCH_TIMER, TimeUnit.MINUTES);

		hopperExecutorService = new ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor());
		pingFuture = hopperExecutorService.scheduleAtFixedRate(this::pingWorlds, WORLD_PING_TIMER, WORLD_PING_TIMER, TimeUnit.MINUTES);
	}

	@Override
	protected void shutDown() throws Exception
	{
		pingFuture.cancel(true);
		pingFuture = null;

		keyManager.unregisterKeyListener(previousKeyListener);
		keyManager.unregisterKeyListener(nextKeyListener);

		worldResultFuture.cancel(true);
		worldResultFuture = null;
		worldResult = null;
		lastFetch = null;

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
			}
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
		panel.resetAllFavoriteMenus();
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

	void hopTo(World world)
	{
		hop(world.getId());
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
		int old1 = favoriteWorld1;
		int old2 = favoriteWorld2;

		favoriteWorld1 = client.getVar(Varbits.WORLDHOPPER_FAVROITE_1);
		favoriteWorld2 = client.getVar(Varbits.WORLDHOPPER_FAVROITE_2);

		if (old1 != favoriteWorld1 || old2 != favoriteWorld2)
		{
			SwingUtilities.invokeLater(panel::updateList);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());
		String option = event.getOption();

		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() || groupId == WidgetInfo.CLAN_CHAT.getGroupId())
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

			if (player == null || player.getWorld() == 0 || player.getWorld() == client.getWorld())
			{
				return;
			}

			final MenuEntry hopTo = new MenuEntry();
			hopTo.setOption(HOP_TO);
			hopTo.setTarget(event.getTarget());
			hopTo.setType(MenuAction.RUNELITE.getId());
			hopTo.setParam0(event.getActionParam0());
			hopTo.setParam1(event.getActionParam1());

			insertMenuEntry(hopTo, client.getMenuEntries(), after);
		}
	}

	private void insertMenuEntry(MenuEntry newEntry, MenuEntry[] entries, boolean after)
	{
		MenuEntry[] newMenu = ObjectArrays.concat(entries, newEntry);

		if (after)
		{
			int menuEntryCount = newMenu.length;
			ArrayUtils.swap(newMenu, menuEntryCount - 1, menuEntryCount - 2);
		}

		client.setMenuEntries(newMenu);
	}

	@Subscribe
	public void onPlayerMenuOptionClicked(PlayerMenuOptionClicked event)
	{
		if (!event.getMenuOption().equals(HOP_TO))
		{
			return;
		}

		ChatPlayer player = getChatPlayerFromName(event.getMenuTarget());

		if (player != null)
		{
			hop(player.getWorld());
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

	private void tick()
	{
		Instant now = Instant.now();
		if (lastFetch != null && now.toEpochMilli() - lastFetch.toEpochMilli() < TICK_THROTTLE)
		{
			log.debug("Throttling world refresh tick");
			return;
		}

		fetchWorlds();

		// Ping worlds once at startup
		if (firstRun)
		{
			firstRun = false;
			hopperExecutorService.execute(this::pingWorlds);
		}
	}

	void refresh()
	{
		Instant now = Instant.now();
		if (lastFetch != null && now.toEpochMilli() - lastFetch.toEpochMilli() < REFRESH_THROTTLE)
		{
			log.debug("Throttling world refresh");
			return;
		}

		fetchWorlds();
	}

	private void fetchWorlds()
	{
		log.debug("Fetching worlds");

		try
		{
			WorldResult worldResult = new WorldClient().lookupWorlds();

			if (worldResult != null)
			{
				worldResult.getWorlds().sort(Comparator.comparingInt(World::getId));
				this.worldResult = worldResult;
				this.lastFetch = Instant.now();
				updateList();
			}
		}
		catch (IOException ex)
		{
			log.warn("Error looking up worlds", ex);
		}
	}

	/**
	 * This method ONLY updates the list's UI, not the actual world list and data it displays.
	 */
	private void updateList()
	{
		SwingUtilities.invokeLater(() -> panel.populate(worldResult.getWorlds()));
	}

	private void hop(boolean previous)
	{
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
			currentWorldTypes.remove(WorldType.PVP_HIGH_RISK);
		}
		// Don't regard these worlds as a type that must be hopped between
		currentWorldTypes.remove(WorldType.BOUNTY);
		currentWorldTypes.remove(WorldType.SKILL_TOTAL);
		currentWorldTypes.remove(WorldType.LAST_MAN_STANDING);

		List<World> worlds = worldResult.getWorlds();

		int worldIdx = worlds.indexOf(currentWorld);
		int totalLevel = client.getTotalLevel();

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
				.type(ChatMessageType.GAME)
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
		// Don't try to hop if the world doesn't exist
		World world = worldResult.findWorld(worldId);
		if (world == null)
		{
			return;
		}

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
					.type(ChatMessageType.GAME)
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

		if (client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) == null)
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
						.type(ChatMessageType.GAME)
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
		if (event.getType() != ChatMessageType.SERVER)
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

		// Search clan members first, because if a friend is in the clan chat but their private
		// chat is 'off', then the hop-to option will not get shown in the menu (issue #5679).
		ClanMember[] clanMembers = client.getClanMembers();

		if (clanMembers != null)
		{
			for (ClanMember clanMember : clanMembers)
			{
				if (clanMember != null && clanMember.getUsername().equals(cleanName))
				{
					return clanMember;
				}
			}
		}

		Friend[] friends = client.getFriends();

		if (friends != null)
		{
			for (Friend friend : friends)
			{
				if (friend != null && friend.getName().equals(cleanName))
				{
					return friend;
				}
			}
		}

		return null;
	}

	private void pingWorlds()
	{
		if (worldResult == null || !config.showSidebar() || !config.ping())
		{
			return;
		}

		Stopwatch stopwatch = Stopwatch.createStarted();

		for (World world : worldResult.getWorlds())
		{
			int ping = Ping.ping(world);
			SwingUtilities.invokeLater(() -> panel.updatePing(world.getId(), ping));
		}

		stopwatch.stop();

		log.debug("Done pinging worlds in {}", stopwatch.elapsed());
	}
}
