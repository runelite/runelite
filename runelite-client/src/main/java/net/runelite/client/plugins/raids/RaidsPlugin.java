/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InstanceTemplates;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.NullObjectID;
import static net.runelite.api.Perspective.SCENE_SIZE;
import net.runelite.api.Point;
import static net.runelite.api.SpriteID.TAB_QUESTS_BROWN_RAIDING_PARTY;
import net.runelite.api.Tile;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.raids.solver.Layout;
import net.runelite.client.plugins.raids.solver.LayoutSolver;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageCapture;
import net.runelite.client.util.Text;
import static net.runelite.client.util.Text.sanitize;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.chat.LayoutRoom;
import net.runelite.http.api.ws.messages.party.PartyChatMessage;

@PluginDescriptor(
	name = "Chambers Of Xeric",
	description = "Show helpful information for the Chambers of Xeric raid",
	tags = {"combat", "raid", "overlay", "pve", "pvm", "bosses"}
)
@Slf4j
public class RaidsPlugin extends Plugin
{
	private static final int LOBBY_PLANE = 3;
	private static final String RAID_START_MESSAGE = "The raid has begun!";
	private static final String LEVEL_COMPLETE_MESSAGE = "level complete!";
	private static final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private static final DecimalFormat POINTS_FORMAT = new DecimalFormat("#,###");
	private static final String LAYOUT_COMMAND = "!layout";
	private static final int MAX_LAYOUT_LEN = 300;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Client client;

	@Inject
	private RaidsConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RaidsOverlay overlay;

	@Inject
	private LayoutSolver layoutSolver;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private PartyService party;

	@Inject
	private WSClient ws;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ChatClient chatClient;

	@Inject
	private ScheduledExecutorService scheduledExecutorService;

	@Inject
	private ItemManager itemManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ImageCapture imageCapture;

	@Getter
	private final Set<String> roomWhitelist = new HashSet<String>();

	@Getter
	private final Set<String> roomBlacklist = new HashSet<String>();

	@Getter
	private final Set<String> rotationWhitelist = new HashSet<String>();

	@Getter
	private final Set<String> layoutWhitelist = new HashSet<String>();

	@Setter(AccessLevel.PACKAGE) // for the test
	@Getter
	private Raid raid;

	@Getter
	private boolean inRaidChambers;

	private boolean chestOpened;

	private RaidsTimer timer;

	@Provides
	RaidsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(RaidsOverlay.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		updateLists();
		clientThread.invokeLater(() -> checkRaidPresence(true));
		chatCommandManager.registerCommandAsync(LAYOUT_COMMAND, this::lookupRaid, this::submitRaid);
		keyManager.registerKeyListener(screenshotHotkeyListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		chatCommandManager.unregisterCommand(LAYOUT_COMMAND);
		overlayManager.remove(overlay);
		infoBoxManager.removeInfoBox(timer);
		inRaidChambers = false;
		raid = null;
		timer = null;
		chestOpened = false;
		keyManager.unregisterKeyListener(screenshotHotkeyListener);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("raids"))
		{
			return;
		}

		if (event.getKey().equals("raidsTimer"))
		{
			updateInfoBoxState();
			return;
		}

		updateLists();
		clientThread.invokeLater(() -> checkRaidPresence(true));
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID ||
			!config.showLootValue() ||
			chestOpened)
		{
			return;
		}

		chestOpened = true;

		ItemContainer rewardItemContainer = client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST);
		if (rewardItemContainer == null)
		{
			return;
		}

		long totalValue = Arrays.stream(rewardItemContainer.getItems())
			.filter(item -> item.getId() > -1)
			.mapToLong(item -> (long) itemManager.getItemPrice(item.getId()) * item.getQuantity())
			.sum();

		String chatMessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Your loot is worth around ")
			.append(ChatColorType.HIGHLIGHT)
			.append(QuantityFormatter.formatNumber(totalValue))
			.append(ChatColorType.NORMAL)
			.append(" coins.")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(chatMessage)
			.build());
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		checkRaidPresence(false);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (inRaidChambers && event.getType() == ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			String message = Text.removeTags(event.getMessage());

			if (config.raidsTimer() && message.startsWith(RAID_START_MESSAGE))
			{
				timer = new RaidsTimer(this, Instant.now());
				spriteManager.getSpriteAsync(TAB_QUESTS_BROWN_RAIDING_PARTY, 0, timer);
				infoBoxManager.addInfoBox(timer);
			}

			if (timer != null && message.contains(LEVEL_COMPLETE_MESSAGE))
			{
				timer.timeFloor();
			}

			if (message.startsWith(RAID_COMPLETE_MESSAGE))
			{
				if (timer != null)
				{
					timer.timeOlm();
					timer.setStopped(true);
				}

				if (config.pointsMessage())
				{
					int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
					int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);

					double percentage = personalPoints / (totalPoints / 100.0);

					String chatMessage = new ChatMessageBuilder()
						.append(ChatColorType.NORMAL)
						.append("Total points: ")
						.append(ChatColorType.HIGHLIGHT)
						.append(POINTS_FORMAT.format(totalPoints))
						.append(ChatColorType.NORMAL)
						.append(", Personal points: ")
						.append(ChatColorType.HIGHLIGHT)
						.append(POINTS_FORMAT.format(personalPoints))
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(DECIMAL_FORMAT.format(percentage))
						.append(ChatColorType.NORMAL)
						.append("%)")
						.build();

					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
						.runeLiteFormattedMessage(chatMessage)
						.build());
				}
			}
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(final OverlayMenuClicked event)
	{
		if (!(event.getEntry().getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& event.getOverlay() == overlay))
		{
			return;
		}

		if (event.getEntry().getOption().equals(RaidsOverlay.BROADCAST_ACTION))
		{
			sendRaidLayoutMessage();
		}
		else if (event.getEntry().getOption().equals(RaidsOverlay.SCREENSHOT_ACTION))
		{
			screenshotScoutOverlay();
		}
	}

	private void checkRaidPresence(boolean force)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		boolean setting = client.getVar(Varbits.IN_RAID) == 1;

		if (force || inRaidChambers != setting)
		{
			inRaidChambers = setting;
			updateInfoBoxState();

			if (inRaidChambers)
			{
				raid = buildRaid();
				chestOpened = false;

				if (raid == null)
				{
					log.debug("Failed to build raid");
					return;
				}

				Layout layout = layoutSolver.findLayout(raid.toCode());

				if (layout == null)
				{
					log.debug("Could not find layout match");
					return;
				}

				raid.updateLayout(layout);
				RaidRoom[] rooms = raid.getCombatRooms();
				RotationSolver.solve(rooms);
				raid.setCombatRooms(rooms);
				overlay.setScoutOverlayShown(true);

				if (config.layoutMessage())
				{
					sendRaidLayoutMessage();
				}
			}
			else if (!config.scoutOverlayAtBank())
			{
				overlay.setScoutOverlayShown(false);
			}
		}

		// If we left party raid was started or we left raid
		if (client.getVar(VarPlayer.IN_RAID_PARTY) == -1 && (!inRaidChambers || !config.scoutOverlayInRaid()))
		{
			overlay.setScoutOverlayShown(false);
		}
	}

	private void sendRaidLayoutMessage()
	{
		final String layout = getRaid().getLayout().toCodeString();
		final String rooms = getRaid().toRoomString();
		final String raidData = "[" + layout + "]: " + rooms;

		final String layoutMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Layout: ")
			.append(ChatColorType.NORMAL)
			.append(raidData)
			.build();

		final PartyMember localMember = party.getLocalMember();

		if (party.getMembers().isEmpty() || localMember == null)
		{
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
				.runeLiteFormattedMessage(layoutMessage)
				.build());
		}
		else
		{
			final PartyChatMessage message = new PartyChatMessage(layoutMessage);
			message.setMemberId(localMember.getMemberId());
			ws.send(message);
		}
	}

	private void updateInfoBoxState()
	{
		if (timer == null)
		{
			return;
		}

		if (inRaidChambers && config.raidsTimer())
		{
			if (!infoBoxManager.getInfoBoxes().contains(timer))
			{
				infoBoxManager.addInfoBox(timer);
			}
		}
		else
		{
			infoBoxManager.removeInfoBox(timer);
		}

		if (!inRaidChambers)
		{
			timer = null;
		}
	}

	@VisibleForTesting
	void updateLists()
	{
		updateList(roomWhitelist, config.whitelistedRooms());
		updateList(roomBlacklist, config.blacklistedRooms());
		updateList(layoutWhitelist, config.whitelistedLayouts());

		// Update rotation whitelist
		rotationWhitelist.clear();
		for (String line : config.whitelistedRotations().split("\\n"))
		{
			rotationWhitelist.add(line.toLowerCase().replace(" ", ""));
		}
	}

	private void updateList(Collection<String> list, String input)
	{
		list.clear();
		for (String s : Text.fromCSV(input.toLowerCase()))
		{
			if (s.equals("unknown"))
			{
				list.add("unknown (combat)");
				list.add("unknown (puzzle)");
			}
			else
			{
				list.add(s);
			}
		}
	}

	boolean getRotationMatches()
	{
		RaidRoom[] combatRooms = raid.getCombatRooms();
		String rotation = Arrays.stream(combatRooms)
			.map(RaidRoom::getName)
			.map(String::toLowerCase)
			.collect(Collectors.joining(","));

		return rotationWhitelist.contains(rotation);
	}

	private Point findLobbyBase()
	{
		Tile[][] tiles = client.getScene().getTiles()[LOBBY_PLANE];

		for (int x = 0; x < SCENE_SIZE; x++)
		{
			for (int y = 0; y < SCENE_SIZE; y++)
			{
				if (tiles[x][y] == null || tiles[x][y].getWallObject() == null)
				{
					continue;
				}

				if (tiles[x][y].getWallObject().getId() == NullObjectID.NULL_12231)
				{
					return tiles[x][y].getSceneLocation();
				}
			}
		}

		return null;
	}

	private Raid buildRaid()
	{
		Point gridBase = findLobbyBase();

		if (gridBase == null)
		{
			return null;
		}

		Raid raid = new Raid();
		Tile[][] tiles;
		int position, x, y, offsetX;
		int startX = -2;

		for (int plane = 3; plane > 1; plane--)
		{
			tiles = client.getScene().getTiles()[plane];

			if (tiles[gridBase.getX() + RaidRoom.ROOM_MAX_SIZE][gridBase.getY()] == null)
			{
				position = 1;
			}
			else
			{
				position = 0;
			}

			for (int i = 1; i > -2; i--)
			{
				y = gridBase.getY() + (i * RaidRoom.ROOM_MAX_SIZE);

				for (int j = startX; j < 4; j++)
				{
					x = gridBase.getX() + (j * RaidRoom.ROOM_MAX_SIZE);
					offsetX = 0;

					if (x > SCENE_SIZE && position > 1 && position < 4)
					{
						position++;
					}

					if (x < 0)
					{
						offsetX = Math.abs(x) + 1; //add 1 because the tile at x=0 will always be null
					}

					if (x < SCENE_SIZE && y >= 0 && y < SCENE_SIZE)
					{
						if (tiles[x + offsetX][y] == null)
						{
							if (position == 4)
							{
								position++;
								break;
							}

							continue;
						}

						if (position == 0 && startX != j)
						{
							startX = j;
						}

						Tile base = tiles[offsetX > 0 ? 1 : x][y];
						RaidRoom room = determineRoom(base);
						raid.setRoom(room, position + Math.abs((plane - 3) * 8));
						position++;
					}
				}
			}
		}

		return raid;
	}

	private RaidRoom determineRoom(Tile base)
	{
		int chunkData = client.getInstanceTemplateChunks()[base.getPlane()][(base.getSceneLocation().getX()) / 8][base.getSceneLocation().getY() / 8];
		InstanceTemplates template = InstanceTemplates.findMatch(chunkData);

		if (template == null)
		{
			return RaidRoom.EMPTY;
		}

		switch (template)
		{
			case RAIDS_LOBBY:
			case RAIDS_START:
				return RaidRoom.START;

			case RAIDS_END:
				return RaidRoom.END;

			case RAIDS_SCAVENGERS:
			case RAIDS_SCAVENGERS2:
				return RaidRoom.SCAVENGERS;

			case RAIDS_SHAMANS:
				return RaidRoom.SHAMANS;

			case RAIDS_VASA:
				return RaidRoom.VASA;

			case RAIDS_VANGUARDS:
				return RaidRoom.VANGUARDS;

			case RAIDS_ICE_DEMON:
				return RaidRoom.ICE_DEMON;

			case RAIDS_THIEVING:
				return RaidRoom.THIEVING;

			case RAIDS_FARMING:
			case RAIDS_FARMING2:
				return RaidRoom.FARMING;

			case RAIDS_MUTTADILES:
				return RaidRoom.MUTTADILES;

			case RAIDS_MYSTICS:
				return RaidRoom.MYSTICS;

			case RAIDS_TEKTON:
				return RaidRoom.TEKTON;

			case RAIDS_TIGHTROPE:
				return RaidRoom.TIGHTROPE;

			case RAIDS_GUARDIANS:
				return RaidRoom.GUARDIANS;

			case RAIDS_CRABS:
				return RaidRoom.CRABS;

			case RAIDS_VESPULA:
				return RaidRoom.VESPULA;

			default:
				return RaidRoom.EMPTY;
		}
	}

	private void lookupRaid(ChatMessage chatMessage, String s)
	{
		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(chatMessage.getName());
		}

		LayoutRoom[] layout;
		try
		{
			layout = chatClient.getLayout(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup layout", ex);
			return;
		}

		if (layout == null || layout.length == 0)
		{
			return;
		}

		String layoutMessage = Joiner.on(", ").join(Arrays.stream(layout)
			.map(l -> RaidRoom.valueOf(l.name()))
			.filter(room -> room.getType() == RoomType.COMBAT || room.getType() == RoomType.PUZZLE)
			.map(RaidRoom::getName)
			.toArray());

		if (layoutMessage.length() > MAX_LAYOUT_LEN)
		{
			log.debug("layout message too long! {}", layoutMessage.length());
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Layout: ")
			.append(ChatColorType.NORMAL)
			.append(layoutMessage)
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean submitRaid(ChatInput chatInput, String s)
	{
		if (raid == null)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();
		List<RaidRoom> orderedRooms = raid.getOrderedRooms();

		LayoutRoom[] layoutRooms = orderedRooms.stream()
			.map(room -> LayoutRoom.valueOf(room.name()))
			.toArray(LayoutRoom[]::new);

		scheduledExecutorService.execute(() ->
		{
			try
			{
				chatClient.submitLayout(playerName, layoutRooms);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit layout", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private final HotkeyListener screenshotHotkeyListener = new HotkeyListener(() -> config.screenshotHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			screenshotScoutOverlay();
		}
	};

	private void screenshotScoutOverlay()
	{
		if (!overlay.isScoutOverlayShown())
		{
			return;
		}

		Rectangle overlayDimensions = overlay.getBounds();
		BufferedImage overlayImage = new BufferedImage(overlayDimensions.width, overlayDimensions.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphic = overlayImage.createGraphics();
		graphic.setFont(runeLiteConfig.interfaceFontType().getFont());
		graphic.setColor(Color.BLACK);
		graphic.fillRect(0, 0, overlayDimensions.width, overlayDimensions.height);
		overlay.render(graphic);

		imageCapture.takeScreenshot(overlayImage, "CoX_scout-", false, config.uploadScreenshot());
		graphic.dispose();
	}
}
