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
package net.runelite.client.plugins.newraids;

import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InstanceTemplates;
import net.runelite.api.NullObjectID;
import static net.runelite.api.Perspective.SCENE_SIZE;
import net.runelite.api.Point;
import static net.runelite.api.SpriteID.TAB_QUESTS_BROWN_RAIDING_PARTY;
import net.runelite.api.Tile;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.newraids.solver.Layout;
import net.runelite.client.plugins.newraids.solver.LayoutSolver;
import net.runelite.client.plugins.newraids.solver.RotationSolver;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Raids Scouter",
	description = "Show helpful information for the Chambers of Xeric raid",
	tags = {"combat", "raid", "overlay", "pve", "pvm", "bosses"},
	type = PluginType.PVM
)
@Slf4j
public class RaidsPlugin extends Plugin
{
	static final DecimalFormat POINTS_FORMAT = new DecimalFormat("#,###");
	private static final int LOBBY_PLANE = 3;
	private static final String RAID_START_MESSAGE = "The raid has begun!";
	private static final String LEVEL_COMPLETE_MESSAGE = "level complete!";
	private static final String KC_MESSAGE = "Your completed Chambers of Xeric count is:";
	private static final String KC_MESSAGECM = "Your completed Chambers of Xeric Challenge Mode count is:";
	private static final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private static final String RAID_COMPLETE_MESSAGE2 = "Congratulations - your raid is complete! Duration:";
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private static final String SPLIT_REGEX = "\\s*,\\s*";
	private static final Pattern ROTATION_REGEX = Pattern.compile("\\[(.*?)]");
	@Getter
	private final ArrayList<String> roomWhitelist = new ArrayList<>();
	@Getter
	private final ArrayList<String> roomBlacklist = new ArrayList<>();
	@Getter
	private final ArrayList<String> rotationWhitelist = new ArrayList<>();
	@Getter
	private final ArrayList<String> layoutWhitelist = new ArrayList<>();
	public boolean canShow;
	public boolean timerOverride = false;
	data raidToAdd = new data();
	int ticks = 0;
	int raidSeconds;
	int backupTime;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private InfoBoxManager infoBoxManager;
	@Inject
	private SkillIconManager iconManager;
	@Inject
	private Client client;
	@Inject
	private RaidsConfig config;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private RaidsOverlay overlay;
	@Inject
	private RaidsPointsOverlay pointsOverlay;
	@Inject
	private LayoutSolver layoutSolver;
	@Inject
	private SpriteManager spriteManager;
	@Inject
	private ClientThread clientThread;
	@Getter
	private Raid raid;
	private RaidsPanel panel;
	private PointsPanel pointsPanel;
	private NavigationButton navButton;
	private NavigationButton navButton2;
	@Getter
	private boolean inRaidChambers;
	private RaidsTimer timer;
	@Inject
	private ClientToolbar clientToolbar;

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
		if (config.oldOverlay())
		{
			overlayManager.add(pointsOverlay);
		}
		updateLists();
		clientThread.invokeLater(() -> checkRaidPresence(true));
		panel = injector.getInstance(RaidsPanel.class);
		pointsPanel = new PointsPanel(this, config, client, iconManager);
		pointsPanel.init();
		if (config.soloPanel())
		{
			pointsPanel.setSolo(true);
			pointsPanel.updateSolo();
		}
		else
		{
			pointsPanel.setSolo(false);
			pointsPanel.update();
		}
		panel.init(config);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(this.getClass(), "instancereloadhelper.png");
		final BufferedImage iconPoint = ImageUtil.getResourceStreamFromClass(this.getClass(), "cox.png");

		navButton = NavigationButton.builder()
			.tooltip("Raids Reload")
			.icon(icon)
			.priority(8)
			.panel(panel)
			.build();
		navButton2 = NavigationButton.builder()
			.tooltip("CoX Points")
			.icon(iconPoint)
			.priority(9)
			.panel(pointsPanel)
			.build();
		clientToolbar.addNavigation(navButton);
		if (config.ptsPanel())
		{
			clientToolbar.addNavigation(navButton2);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
		clientToolbar.removeNavigation(navButton2);
		overlayManager.remove(overlay);
		infoBoxManager.removeInfoBox(timer);
		overlayManager.remove(pointsOverlay);
		inRaidChambers = false;
		raid = null;
		timer = null;

		final Widget widget = client.getWidget(WidgetInfo.RAIDS_POINTS_INFOBOX);
		if (widget != null)
		{
			widget.setHidden(false);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.ptsPanel())
		{
			if (config.soloPanel())
			{
				pointsPanel.updateSolo();
				pointsPanel.setSolo(true);
			}
			else
			{
				pointsPanel.update();
				pointsPanel.setSolo(false);
			}
			pointsPanel.revalidate();
		}
		if (!config.oldOverlay())
		{
			overlayManager.remove(pointsOverlay);
		}
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
	public void onVarbitChanged(VarbitChanged event)
	{
		checkRaidPresence(false);
	}


	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (!inRaidChambers || event.isHidden())
		{
			return;
		}

		Widget widget = event.getWidget();

		if (widget == client.getWidget(WidgetInfo.RAIDS_POINTS_INFOBOX))
		{

			if (config.oldOverlay())
			{
				widget.setHidden(true);
				overlayManager.add(pointsOverlay);
			}
			else
			{
				widget.setHidden(false);
				overlayManager.remove(pointsOverlay);
			}

		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
/*
		String t = Text.removeTags(event.getMessage());
		System.out.println(t);
		if(t.equals("Test")){
			long timeTake = r(2000,5000);
			data test = new data();
			test.add(r(50000,75000),r(10000,20000),r(20000,40000), (int) timeTake,2000,"TEST",new Date(),new Date());
			pointsPanel.raids.add(test);
			if(config.soloPanel()){
				pointsPanel.updateSolo();
			}else{
				pointsPanel.update();
			}
			if(!pointsPanel.timer.started){
				pointsPanel.timer.start(timeTake);
			}

		}
*/
		String test = Text.removeTags(event.getMessage());
		if (raidToAdd != null)
		{
			raidToAdd.cm = false;
		}
		if (test.startsWith(KC_MESSAGE))
		{
			PointsPanel.raids.get(PointsPanel.raids.size() - 1).kc = Integer.parseInt(test.replaceAll("\\D+", ""));
			PointsPanel.raids.get(PointsPanel.raids.size() - 1).cm = false;

			if (config.soloPanel())
			{
				pointsPanel.updateSolo();
			}
			else
			{
				pointsPanel.update();
			}

			//raidToAdd.kc = Integer.parseInt(test.replaceAll("\\D+",""));
		}
		if (test.startsWith(KC_MESSAGECM))
		{
			PointsPanel.raids.get(PointsPanel.raids.size() - 1).kc = Integer.parseInt(test.replaceAll("\\D+", ""));
			PointsPanel.raids.get(PointsPanel.raids.size() - 1).cm = true;

			if (config.soloPanel())
			{
				pointsPanel.updateSolo();
			}
			else
			{
				pointsPanel.update();
			}

			//raidToAdd.kc = Integer.parseInt(test.replaceAll("\\D+",""));
		}
		if (inRaidChambers && event.getType() == ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			String message = Text.removeTags(event.getMessage());
			if (message.startsWith(RAID_START_MESSAGE))
			{
				raidToAdd.start = new Date();
			}
			if (message.startsWith(RAID_COMPLETE_MESSAGE))
			{
				raidToAdd.finish = new Date();
			}

			if (config.raidsTimer() && message.startsWith(RAID_START_MESSAGE))
			{

				timer = new RaidsTimer(spriteManager.getSprite(TAB_QUESTS_BROWN_RAIDING_PARTY, 0), this, Instant.now());
				infoBoxManager.addInfoBox(timer);
			}

			if (timer != null && message.contains(LEVEL_COMPLETE_MESSAGE))
			{
				timer.timeFloor();
			}


			if (message.startsWith(RAID_COMPLETE_MESSAGE))
			{
				String stripped = message.replaceAll("[^\\d]", "");
				backupTime = 0;
				int sSec = 0;
				int sMin = 0;
				int sHour = 0;
				if (stripped.length() > 1)
				{
					sSec = Integer.parseInt(stripped.substring(stripped.length() - 2));
					stripped = stripped.substring(0, stripped.length() - 2);
				}
				if (stripped.length() > 1)
				{
					sMin = Integer.parseInt(stripped.substring(stripped.length() - 2));
					stripped = stripped.substring(0, stripped.length() - 2);
				}
				else if (stripped.length() > 0)
				{
					sMin = Integer.parseInt(stripped.substring(stripped.length() - 1));
					stripped = stripped.substring(0, stripped.length() - 1);
				}
				if (stripped.length() > 1)
				{
					sHour = Integer.parseInt(stripped.substring(stripped.length() - 2));
					stripped = stripped.substring(0, stripped.length() - 2);
				}
				else if (stripped.length() > 0)
				{
					sHour = Integer.parseInt(stripped.substring(stripped.length() - 1));
					stripped = stripped.substring(0, stripped.length() - 1);
				}
				backupTime = (sSec) + (sMin * 60) + (sHour * 3600);
				raidToAdd.timeTaken = backupTime;
				if (timer != null)
				{

					timer.timeOlm();
					raidSeconds = backupTime;
					timerOverride = false;
					timer.setStopped(true);
				}
				raidToAdd.personal = client.getVar(Varbits.PERSONAL_POINTS);
				raidToAdd.total = client.getVar(Varbits.TOTAL_POINTS);
				raidToAdd.hr = (int) (((float) raidToAdd.personal / (float) raidToAdd.timeTaken) * 3600);
				if (config.ptsPanel())
				{
					PointsPanel.raids.add(raidToAdd);
					if (!pointsPanel.timer.started)
					{
						pointsPanel.timer.start(raidToAdd.timeTaken);
					}
					if (config.soloPanel())
					{
						pointsPanel.updateSolo();
					}
					else
					{
						pointsPanel.update();
					}
					raidToAdd = new data();
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
					if (config.ptsHr())
					{
						String pts;
						if (timer != null)
						{
							pts = POINTS_FORMAT.format(((float) personalPoints / (float) raidSeconds) * 3600);
						}
						else
						{
							pts = POINTS_FORMAT.format(((float) personalPoints / (float) backupTime) * 3600);
						}


						String chatMessage2 = new ChatMessageBuilder()
							.append(ChatColorType.NORMAL)
							.append("Pts/Hr: ")
							.append(ChatColorType.HIGHLIGHT)
							.append(pts)
							.build();

						chatMessageManager.queue(QueuedMessage.builder()
							.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
							.runeLiteFormattedMessage(chatMessage2)
							.build());
					}
				}
			}
		}
	}

	public void checkRaidPresence(boolean force)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		boolean setting = true;
		if (!force)
		{
			setting = client.getVar(Varbits.IN_RAID) == 1;
		}
		else
		{

		}
		if (force || inRaidChambers != setting)
		{
			inRaidChambers = setting;
			updateInfoBoxState();

			if (inRaidChambers)
			{
				raid = buildRaid();

				if (raid == null)
				{
					System.out.println("in cm");
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
				RotationSolver.solve(raid.getCombatRooms());
				raidToAdd.raid = getRaid().toRoomString();
				sendRaidLayoutMessage();
				Vector<String> puzzles = new Vector<String>();
				puzzles.clear();
				for (RaidRoom r : raid.getRooms())
				{
					if (r != null)
					{
						if (r.getPuzzle() != null)
						{
							if (r.getPuzzle().getName() != null)
							{
								puzzles.add(r.getPuzzle().getName());
							}
						}
					}
				}
				//Push puzzles to api
				String urlString = "http://lyzrds.com/puzzles/api.php";
				boolean add = true;
				if (puzzles.size() > 3)
				{
					add = false;
				}
				if (puzzles.size() == 0)
				{
					add = false;
				}
				switch (puzzles.size())
				{
					case 1:
						urlString = urlString + "?p1=" + puzzles.get(0);
						break;
					case 2:
						urlString = urlString + "?p1=" + puzzles.get(0) + "&p2=" + puzzles.get(1);
						break;
					case 3:
						urlString = urlString + "?p1=" + puzzles.get(0) + "&p2=" + puzzles.get(1) + "&p3=" + puzzles.get(2);
						break;

				}
				urlString = urlString + "&r=" + getRaid().getLayout().toCodeString() + ":" + getRaid().toRoomString();
				//System.out.println(urlString +"&r=" + getRaid().getLayout().toCodeString() +":"+ getRaid().toRoomString());
				if (add && canShow)
				{
					URL oracle = null;
					try
					{
						oracle = new URL(urlString.replace(" ", ""));
					}
					catch (MalformedURLException e)
					{
						e.printStackTrace();
					}
					URLConnection yc = null;
					try
					{
						yc = oracle.openConnection();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					BufferedReader in = null;
					try
					{
						in = new BufferedReader(new InputStreamReader(
							yc.getInputStream()));
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					try
					{
						in.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}

				}
				canShow = true;
				overlay.setScoutOverlayShown(true);
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
			canShow = true;
		}
	}

	private void sendRaidLayoutMessage()
	{
		if (!config.layoutMessage())
		{
			return;
		}

		final String layout = getRaid().getLayout().toCodeString();
		final String rooms = getRaid().toRoomString();
		final String raidData = "[" + layout + "]: " + rooms;

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Layout: ")
				.append(ChatColorType.NORMAL)
				.append(raidData)
				.build())
			.build());
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

	private void updateLists()
	{
		updateList(roomWhitelist, config.whitelistedRooms());
		updateList(roomBlacklist, config.blacklistedRooms());
		updateList(rotationWhitelist, config.whitelistedRotations());
		updateList(layoutWhitelist, config.whitelistedLayouts());
	}

	private void updateList(ArrayList<String> list, String input)
	{
		list.clear();

		if (list == rotationWhitelist)
		{
			Matcher m = ROTATION_REGEX.matcher(input);
			while (m.find())
			{
				String rotation = m.group(1).toLowerCase();

				if (!list.contains(rotation))
				{
					list.add(rotation);
				}
			}
		}
		else
		{
			list.addAll(Arrays.asList(input.toLowerCase().split(SPLIT_REGEX)));
		}
	}

	int getRotationMatches()
	{
		String rotation = raid.getRotationString().toLowerCase();
		String[] bosses = rotation.split(SPLIT_REGEX);

		if (rotationWhitelist.contains(rotation))
		{
			return bosses.length;
		}

		for (String whitelisted : rotationWhitelist)
		{
			int matches = 0;
			String[] whitelistedBosses = whitelisted.split(SPLIT_REGEX);

			for (int i = 0; i < whitelistedBosses.length; i++)
			{
				if (i < bosses.length && whitelistedBosses[i].equals(bosses[i]))
				{
					matches++;
				}
				else
				{
					matches = 0;
					break;
				}
			}

			if (matches >= 2)
			{
				return matches;
			}
		}

		return 0;
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
		RaidRoom room = new RaidRoom(base, RaidRoom.Type.EMPTY);
		int chunkData = client.getInstanceTemplateChunks()[base.getPlane()][(base.getSceneLocation().getX()) / 8][base.getSceneLocation().getY() / 8];
		InstanceTemplates template = InstanceTemplates.findMatch(chunkData);

		if (template == null)
		{
			return room;
		}

		switch (template)
		{
			case RAIDS_LOBBY:
			case RAIDS_START:
				room.setType(RaidRoom.Type.START);
				break;

			case RAIDS_END:
				room.setType(RaidRoom.Type.END);
				break;

			case RAIDS_SCAVENGERS:
			case RAIDS_SCAVENGERS2:
				room.setType(RaidRoom.Type.SCAVENGERS);
				break;

			case RAIDS_SHAMANS:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.SHAMANS);
				break;

			case RAIDS_VASA:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.VASA);
				break;

			case RAIDS_VANGUARDS:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.VANGUARDS);
				break;

			case RAIDS_ICE_DEMON:
				room.setType(RaidRoom.Type.PUZZLE);
				room.setPuzzle(RaidRoom.Puzzle.ICE_DEMON);
				break;

			case RAIDS_THIEVING:
				room.setType(RaidRoom.Type.PUZZLE);
				room.setPuzzle(RaidRoom.Puzzle.THIEVING);
				break;

			case RAIDS_FARMING:
			case RAIDS_FARMING2:
				room.setType(RaidRoom.Type.FARMING);
				break;

			case RAIDS_MUTTADILES:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.MUTTADILES);
				break;

			case RAIDS_MYSTICS:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.MYSTICS);
				break;

			case RAIDS_TEKTON:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.TEKTON);
				break;

			case RAIDS_TIGHTROPE:
				room.setType(RaidRoom.Type.PUZZLE);
				room.setPuzzle(RaidRoom.Puzzle.TIGHTROPE);
				break;

			case RAIDS_GUARDIANS:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.GUARDIANS);
				break;

			case RAIDS_CRABS:
				room.setType(RaidRoom.Type.PUZZLE);
				room.setPuzzle(RaidRoom.Puzzle.CRABS);
				break;

			case RAIDS_VESPULA:
				room.setType(RaidRoom.Type.COMBAT);
				room.setBoss(RaidRoom.Boss.VESPULA);
				break;
		}

		return room;
	}
}
