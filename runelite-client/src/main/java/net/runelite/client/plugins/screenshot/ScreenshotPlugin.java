/*
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
package net.runelite.client.plugins.screenshot;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.ScriptID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import static net.runelite.api.widgets.WidgetID.BARROWS_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.CHAMBERS_OF_XERIC_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.CLUE_SCROLL_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.DIALOG_SPRITE_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.KINGDOM_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.QUEST_COMPLETED_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.THEATRE_OF_BLOOD_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.TOA_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.WILDERNESS_LOOT_CHEST;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageCapture;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Screenshot",
	description = "Enable the manual and automatic taking of screenshots",
	tags = {"external", "images", "imgur", "integration", "notifications"}
)
@Slf4j
public class ScreenshotPlugin extends Plugin
{
	private static final String COLLECTION_LOG_TEXT = "New item added to your collection log: ";
	private static final String CHEST_LOOTED_MESSAGE = "You find some treasure in the chest!";
	private static final Map<Integer, String> CHEST_LOOT_EVENTS = ImmutableMap.of(12127, "The Gauntlet");
	private static final int GAUNTLET_REGION = 7512;
	private static final int CORRUPTED_GAUNTLET_REGION = 7768;
	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final Pattern LEVEL_UP_PATTERN = Pattern.compile(".*Your ([a-zA-Z]+) (?:level is|are)? now (\\d+)\\.");
	private static final Pattern BOSSKILL_MESSAGE_PATTERN = Pattern.compile("Your (.+) kill count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern VALUABLE_DROP_PATTERN = Pattern.compile(".*Valuable drop: ([^<>]+?\\(((?:\\d+,?)+) coins\\))(?:</col>)?");
	private static final Pattern UNTRADEABLE_DROP_PATTERN = Pattern.compile(".*Untradeable drop: ([^<>]+)(?:</col>)?");
	private static final Pattern DUEL_END_PATTERN = Pattern.compile("You have now (won|lost) ([0-9,]+) duels?\\.");
	private static final Pattern QUEST_PATTERN_1 = Pattern.compile(".+?ve\\.*? (?<verb>been|rebuilt|.+?ed)? ?(?:the )?'?(?<quest>.+?)'?(?: [Qq]uest)?[!.]?$");
	private static final Pattern QUEST_PATTERN_2 = Pattern.compile("'?(?<quest>.+?)'?(?: [Qq]uest)? (?<verb>[a-z]\\w+?ed)?(?: f.*?)?[!.]?$");
	private static final Pattern COMBAT_ACHIEVEMENTS_PATTERN = Pattern.compile("Congratulations, you've completed an? (?<tier>\\w+) combat task: <col=[0-9a-f]+>(?<task>(.+))</col>\\.");
	private static final ImmutableList<String> RFD_TAGS = ImmutableList.of("Another Cook", "freed", "defeated", "saved");
	private static final ImmutableList<String> WORD_QUEST_IN_NAME_TAGS = ImmutableList.of("Another Cook", "Doric", "Heroes", "Legends", "Observatory", "Olaf", "Waterfall");
	private static final ImmutableList<String> PET_MESSAGES = ImmutableList.of("You have a funny feeling like you're being followed",
		"You feel something weird sneaking into your backpack",
		"You have a funny feeling like you would have been followed");
	private static final Pattern BA_HIGH_GAMBLE_REWARD_PATTERN = Pattern.compile("(?<reward>.+)!<br>High level gamble count: <col=7f0000>(?<gambleCount>.+)</col>");
	private static final Set<Integer> REPORT_BUTTON_TLIS = ImmutableSet.of(
		WidgetID.FIXED_VIEWPORT_GROUP_ID,
		WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID,
		WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID);
	private static final String SD_KINGDOM_REWARDS = "Kingdom Rewards";
	private static final String SD_BOSS_KILLS = "Boss Kills";
	private static final String SD_CLUE_SCROLL_REWARDS = "Clue Scroll Rewards";
	private static final String SD_FRIENDS_CHAT_KICKS = "Friends Chat Kicks";
	private static final String SD_PETS = "Pets";
	private static final String SD_CHEST_LOOT = "Chest Loot";
	private static final String SD_VALUABLE_DROPS = "Valuable Drops";
	private static final String SD_UNTRADEABLE_DROPS = "Untradeable Drops";
	private static final String SD_DUELS = "Duels";
	private static final String SD_COLLECTION_LOG = "Collection Log";
	private static final String SD_PVP_KILLS = "PvP Kills";
	private static final String SD_DEATHS = "Deaths";
	private static final String SD_COMBAT_ACHIEVEMENTS = "Combat Achievements";
	private static final String SD_WILDERNESS_LOOT_CHEST = "Wilderness Loot Chest";

	private String clueType;
	private Integer clueNumber;

	enum KillType
	{
		BARROWS,
		COX,
		COX_CM,
		TOB,
		TOB_SM,
		TOB_HM,
		TOA_ENTRY_MODE,
		TOA,
		TOA_EXPERT_MODE
	}

	private KillType killType;
	private Integer killCountNumber;

	private boolean shouldTakeScreenshot;
	private boolean notificationStarted;

	@Inject
	private ScreenshotConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ScreenshotOverlay screenshotOverlay;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUi;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private DrawManager drawManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ImageCapture imageCapture;

	@Getter(AccessLevel.PACKAGE)
	private BufferedImage reportButton;

	private NavigationButton titleBarButton;

	private String kickPlayerName;

	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.hotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			manualScreenshot();
		}
	};

	@Provides
	ScreenshotConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ScreenshotConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(screenshotOverlay);
		SCREENSHOT_DIR.mkdirs();
		keyManager.registerKeyListener(hotkeyListener);

		final BufferedImage iconImage = ImageUtil.loadImageResource(getClass(), "screenshot.png");

		titleBarButton = NavigationButton.builder()
			.tab(false)
			.tooltip("Take screenshot")
			.icon(iconImage)
			.onClick(this::manualScreenshot)
			.popup(ImmutableMap
				.<String, Runnable>builder()
				.put("Open screenshot folder...", () ->
				{
					LinkBrowser.open(SCREENSHOT_DIR.toString());
				})
				.build())
			.build();

		clientToolbar.addNavigation(titleBarButton);

		spriteManager.getSpriteAsync(SpriteID.CHATBOX_REPORT_BUTTON, 0, s -> reportButton = s);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(screenshotOverlay);
		clientToolbar.removeNavigation(titleBarButton);
		keyManager.unregisterKeyListener(hotkeyListener);
		kickPlayerName = null;
		notificationStarted = false;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!shouldTakeScreenshot)
		{
			return;
		}

		shouldTakeScreenshot = false;
		String screenshotSubDir = null;

		String fileName = null;
		if (client.getWidget(WidgetInfo.LEVEL_UP_LEVEL) != null)
		{
			fileName = parseLevelUpWidget(WidgetInfo.LEVEL_UP_LEVEL);
			screenshotSubDir = "Levels";
		}
		else if (client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT) != null)
		{
			String text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT).getText();
			if (Text.removeTags(text).contains("High level gamble"))
			{
				if (config.screenshotHighGamble())
				{
					fileName = parseBAHighGambleWidget(text);
					screenshotSubDir = "BA High Gambles";
				}
			}
			else
			{
				if (config.screenshotLevels())
				{
					fileName = parseLevelUpWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
					screenshotSubDir = "Levels";
				}
			}
		}
		else if (client.getWidget(WidgetInfo.QUEST_COMPLETED_NAME_TEXT) != null)
		{
			String text = client.getWidget(WidgetInfo.QUEST_COMPLETED_NAME_TEXT).getText();
			fileName = parseQuestCompletedWidget(text);
			screenshotSubDir = "Quests";
		}

		if (fileName != null)
		{
			takeScreenshot(fileName, screenshotSubDir);
		}
	}

	@Subscribe
	public void onActorDeath(ActorDeath actorDeath)
	{
		Actor actor = actorDeath.getActor();
		if (actor instanceof Player)
		{
			Player player = (Player) actor;
			if (player == client.getLocalPlayer() && config.screenshotPlayerDeath())
			{
				takeScreenshot("Death", SD_DEATHS);
			}
			else if (player != client.getLocalPlayer()
				&& player.getCanvasTilePoly() != null
				&& (((player.isFriendsChatMember() || player.isFriend()) && config.screenshotFriendDeath())
					|| (player.isClanMember() && config.screenshotClanDeath())))
			{
				takeScreenshot("Death " + player.getName(), SD_DEATHS);
			}
		}
	}

	@Subscribe
	public void onPlayerLootReceived(final PlayerLootReceived playerLootReceived)
	{
		if (config.screenshotKills())
		{
			final Player player = playerLootReceived.getPlayer();
			final String name = player.getName();
			String fileName = "Kill " + name;
			takeScreenshot(fileName, SD_PVP_KILLS);
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (!"confirmFriendsChatKick".equals(e.getEventName()))
		{
			return;
		}

		final String[] stringStack = client.getStringStack();
		final int stringSize = client.getStringStackSize();
		kickPlayerName = stringStack[stringSize - 1];
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE
			&& event.getType() != ChatMessageType.SPAM
			&& event.getType() != ChatMessageType.TRADE
			&& event.getType() != ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			return;
		}

		String chatMessage = event.getMessage();

		if (chatMessage.contains("You have completed") && chatMessage.contains("Treasure"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				clueNumber = Integer.valueOf(m.group());
				clueType = chatMessage.substring(chatMessage.lastIndexOf(m.group()) + m.group().length() + 1, chatMessage.indexOf("Treasure") - 1);
				return;
			}
		}

		if (chatMessage.startsWith("Your Barrows chest count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killType = KillType.BARROWS;
				killCountNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("Your completed Chambers of Xeric count is:"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killType = KillType.COX;
				killCountNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("Your completed Chambers of Xeric Challenge Mode count is:"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killType = KillType.COX_CM;
				killCountNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("Your completed Theatre of Blood"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killType = chatMessage.contains("Hard Mode") ? KillType.TOB_HM : (chatMessage.contains("Story Mode") ? KillType.TOB_SM : KillType.TOB);
				killCountNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("Your completed Tombs of Amascut"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				killType = chatMessage.contains("Expert Mode") ? KillType.TOA_EXPERT_MODE :
					chatMessage.contains("Entry Mode") ? KillType.TOA_ENTRY_MODE :
						KillType.TOA;
				killCountNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (config.screenshotKick() && chatMessage.equals("Your request to kick/ban this user was successful."))
		{
			if (kickPlayerName == null)
			{
				return;
			}

			takeScreenshot("Kick " + kickPlayerName, SD_FRIENDS_CHAT_KICKS);
			kickPlayerName = null;
		}

		if (config.screenshotPet() && PET_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			String fileName = "Pet";
			takeScreenshot(fileName, SD_PETS);
		}

		if (config.screenshotBossKills())
		{
			Matcher m = BOSSKILL_MESSAGE_PATTERN.matcher(chatMessage);
			if (m.matches())
			{
				String bossName = m.group(1);
				String bossKillcount = m.group(2);
				String fileName = bossName + "(" + bossKillcount + ")";
				takeScreenshot(fileName, SD_BOSS_KILLS);
			}
		}

		if (chatMessage.equals(CHEST_LOOTED_MESSAGE) && config.screenshotRewards())
		{
			final int regionID = client.getLocalPlayer().getWorldLocation().getRegionID();
			String eventName = CHEST_LOOT_EVENTS.get(regionID);
			if (eventName != null)
			{
				takeScreenshot(eventName, SD_CHEST_LOOT);
			}
		}

		if (config.screenshotValuableDrop())
		{
			Matcher m = VALUABLE_DROP_PATTERN.matcher(chatMessage);
			if (m.matches())
			{
				int valuableDropValue = Integer.parseInt(m.group(2).replaceAll(",", ""));
				if (valuableDropValue >= config.valuableDropThreshold())
				{
					String valuableDropName = m.group(1);
					String fileName = "Valuable drop " + valuableDropName;
					takeScreenshot(fileName, SD_VALUABLE_DROPS);
				}
			}
		}

		if (config.screenshotUntradeableDrop() && !isInsideGauntlet())
		{
			Matcher m = UNTRADEABLE_DROP_PATTERN.matcher(chatMessage);
			if (m.matches())
			{
				String untradeableDropName = m.group(1);
				String fileName = "Untradeable drop " + untradeableDropName;
				takeScreenshot(fileName, SD_UNTRADEABLE_DROPS);
			}
		}

		if (config.screenshotDuels())
		{
			Matcher m = DUEL_END_PATTERN.matcher(chatMessage);
			if (m.find())
			{
				String result = m.group(1);
				String count = m.group(2).replace(",", "");
				String fileName = "Duel " + result + " (" + count + ")";
				takeScreenshot(fileName, SD_DUELS);
			}
		}

		if (config.screenshotCollectionLogEntries() && chatMessage.startsWith(COLLECTION_LOG_TEXT) && client.getVarbitValue(Varbits.COLLECTION_LOG_NOTIFICATION) == 1)
		{
			String entry = Text.removeTags(chatMessage).substring(COLLECTION_LOG_TEXT.length());
			String fileName = "Collection log (" + entry + ")";
			takeScreenshot(fileName, SD_COLLECTION_LOG);
		}

		if (chatMessage.contains("combat task") && config.screenshotCombatAchievements() && client.getVarbitValue(Varbits.COMBAT_ACHIEVEMENTS_POPUP) == 1)
		{
			String fileName = parseCombatAchievementWidget(chatMessage);
			if (!fileName.isEmpty())
			{
				takeScreenshot(fileName, SD_COMBAT_ACHIEVEMENTS);
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		String fileName;
		String screenshotSubDir;
		int groupId = event.getGroupId();

		switch (groupId)
		{
			case QUEST_COMPLETED_GROUP_ID:
			case CLUE_SCROLL_REWARD_GROUP_ID:
			case CHAMBERS_OF_XERIC_REWARD_GROUP_ID:
			case THEATRE_OF_BLOOD_REWARD_GROUP_ID:
			case TOA_REWARD_GROUP_ID:
			case BARROWS_REWARD_GROUP_ID:
				if (!config.screenshotRewards())
				{
					return;
				}
				break;
			case LEVEL_UP_GROUP_ID:
				if (!config.screenshotLevels())
				{
					return;
				}
				break;
			case DIALOG_SPRITE_GROUP_ID:
				if (!(config.screenshotLevels() || config.screenshotHighGamble()))
				{
					return;
				}
				break;
			case KINGDOM_GROUP_ID:
				if (!config.screenshotKingdom())
				{
					return;
				}
				break;
			case WILDERNESS_LOOT_CHEST:
				if (!config.screenshotWildernessLootChest())
				{
					return;
				}
				break;
		}

		switch (groupId)
		{
			case KINGDOM_GROUP_ID:
			{
				fileName = "Kingdom " + LocalDate.now();
				screenshotSubDir = SD_KINGDOM_REWARDS;
				break;
			}
			case CHAMBERS_OF_XERIC_REWARD_GROUP_ID:
			{
				if (killType == KillType.COX)
				{
					fileName = "Chambers of Xeric(" + killCountNumber + ")";
					screenshotSubDir = SD_BOSS_KILLS;
					killType = null;
					killCountNumber = 0;
					break;
				}
				else if (killType == KillType.COX_CM)
				{
					fileName = "Chambers of Xeric Challenge Mode(" + killCountNumber + ")";
					screenshotSubDir = SD_BOSS_KILLS;
					killType = null;
					killCountNumber = 0;
					break;
				}
				return;
			}
			case THEATRE_OF_BLOOD_REWARD_GROUP_ID:
			{
				if (killType != KillType.TOB && killType != KillType.TOB_SM && killType != KillType.TOB_HM)
				{
					return;
				}

				switch (killType)
				{
					case TOB:
						fileName = "Theatre of Blood(" + killCountNumber + ")";
						break;
					case TOB_SM:
						fileName = "Theatre of Blood Story Mode(" + killCountNumber + ")";
						break;
					case TOB_HM:
						fileName = "Theatre of Blood Hard Mode(" + killCountNumber + ")";
						break;
					default:
						throw new IllegalStateException();
				}

				screenshotSubDir = SD_BOSS_KILLS;
				killType = null;
				killCountNumber = 0;
				break;
			}
			case TOA_REWARD_GROUP_ID:
			{
				if (killType != KillType.TOA && killType != KillType.TOA_ENTRY_MODE && killType != KillType.TOA_EXPERT_MODE)
				{
					return;
				}

				switch (killType)
				{
					case TOA:
						fileName = "Tombs of Amascut(" + killCountNumber + ")";
						break;
					case TOA_ENTRY_MODE:
						fileName = "Tombs of Amascut Entry Mode(" + killCountNumber + ")";
						break;
					case TOA_EXPERT_MODE:
						fileName = "Tombs of Amascut Expert Mode(" + killCountNumber + ")";
						break;
					default:
						throw new IllegalStateException();
				}

				screenshotSubDir = SD_BOSS_KILLS;
				killType = null;
				killCountNumber = 0;
				break;
			}
			case BARROWS_REWARD_GROUP_ID:
			{
				if (killType != KillType.BARROWS)
				{
					return;
				}

				fileName = "Barrows(" + killCountNumber + ")";
				screenshotSubDir = SD_BOSS_KILLS;
				killType = null;
				killCountNumber = 0;
				break;
			}
			case LEVEL_UP_GROUP_ID:
			case DIALOG_SPRITE_GROUP_ID:
			case QUEST_COMPLETED_GROUP_ID:
			{
				// level up widget gets loaded prior to the text being set, so wait until the next tick
				shouldTakeScreenshot = true;
				return;
			}
			case CLUE_SCROLL_REWARD_GROUP_ID:
			{
				if (clueType == null || clueNumber == null)
				{
					return;
				}

				fileName = Character.toUpperCase(clueType.charAt(0)) + clueType.substring(1) + "(" + clueNumber + ")";
				screenshotSubDir = SD_CLUE_SCROLL_REWARDS;
				clueType = null;
				clueNumber = null;
				break;
			}
			case WILDERNESS_LOOT_CHEST:
			{
				fileName = "Loot key";
				screenshotSubDir = SD_WILDERNESS_LOOT_CHEST;
				break;
			}
			default:
				return;
		}

		takeScreenshot(fileName, screenshotSubDir);
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		switch (scriptPreFired.getScriptId())
		{
			case ScriptID.NOTIFICATION_START:
				notificationStarted = true;
				break;
			case ScriptID.NOTIFICATION_DELAY:
				if (!notificationStarted)
				{
					return;
				}
				String topText = client.getVarcStrValue(VarClientStr.NOTIFICATION_TOP_TEXT);
				String bottomText = client.getVarcStrValue(VarClientStr.NOTIFICATION_BOTTOM_TEXT);
				if (topText.equalsIgnoreCase("Collection log") && config.screenshotCollectionLogEntries())
				{
					String entry = Text.removeTags(bottomText).substring("New item:".length());
					String fileName = "Collection log (" + entry + ")";
					takeScreenshot(fileName, SD_COLLECTION_LOG);
				}
				if (topText.equalsIgnoreCase("Combat Task Completed!") && config.screenshotCombatAchievements() && client.getVarbitValue(Varbits.COMBAT_ACHIEVEMENTS_POPUP) == 0)
				{
					String entry = Text.removeTags(bottomText).substring("Task Completed: ".length());
					String fileName = "Combat task (" + entry.replaceAll("[:?]", "") + ")";
					takeScreenshot(fileName, SD_COMBAT_ACHIEVEMENTS);
				}
				notificationStarted = false;
				break;
		}
	}

	private void manualScreenshot()
	{
		takeScreenshot("", null);
	}

	/**
	 * Receives a WidgetInfo pointing to the middle widget of the level-up dialog,
	 * and parses it into a shortened string for filename usage.
	 *
	 * @param levelUpLevel WidgetInfo pointing to the required text widget,
	 *                     with the format "Your Skill (level is/are) now 99."
	 * @return Shortened string in the format "Skill(99)"
	 */
	String parseLevelUpWidget(WidgetInfo levelUpLevel)
	{
		Widget levelChild = client.getWidget(levelUpLevel);
		if (levelChild == null)
		{
			return null;
		}

		Matcher m = LEVEL_UP_PATTERN.matcher(levelChild.getText());
		if (!m.matches())
		{
			return null;
		}

		String skillName = m.group(1);
		String skillLevel = m.group(2);
		return skillName + "(" + skillLevel + ")";
	}

	/**
	 * Parses the passed quest completion dialog text into a shortened string for filename usage.
	 *
	 * @param text The {@link Widget#getText() text} of the {@link WidgetInfo#QUEST_COMPLETED_NAME_TEXT} widget.
	 * @return Shortened string in the format "Quest(The Corsair Curse)"
	 */
	@VisibleForTesting
	static String parseQuestCompletedWidget(final String text)
	{
		// "You have completed The Corsair Curse!"
		final Matcher questMatch1 = QUEST_PATTERN_1.matcher(text);
		// "'One Small Favour' completed!"
		final Matcher questMatch2 = QUEST_PATTERN_2.matcher(text);
		final Matcher questMatchFinal = questMatch1.matches() ? questMatch1 : questMatch2;
		if (!questMatchFinal.matches())
		{
			return "Quest(quest not found)";
		}

		String quest = questMatchFinal.group("quest");
		String verb = questMatchFinal.group("verb") != null ? questMatchFinal.group("verb") : "";

		if (verb.contains("kind of"))
		{
			quest += " partial completion";
		}
		else if (verb.contains("completely"))
		{
			quest += " II";
		}

		if (RFD_TAGS.stream().anyMatch((quest + verb)::contains))
		{
			quest = "Recipe for Disaster - " + quest;
		}

		if (WORD_QUEST_IN_NAME_TAGS.stream().anyMatch(quest::contains))
		{
			quest += " Quest";
		}

		return "Quest(" + quest + ')';
	}

	/**
	 * Parses the Barbarian Assault high gamble reward dialog text into a shortened string for filename usage.
	 *
	 * @param text The {@link Widget#getText() text} of the {@link WidgetInfo#DIALOG_SPRITE_TEXT} widget.
	 * @return Shortened string in the format "High Gamble(100)"
	 */
	@VisibleForTesting
	static String parseBAHighGambleWidget(final String text)
	{
		final Matcher highGambleMatch = BA_HIGH_GAMBLE_REWARD_PATTERN.matcher(text);
		if (highGambleMatch.find())
		{
			String gambleCount = highGambleMatch.group("gambleCount");
			return String.format("High Gamble(%s)", gambleCount);
		}

		return "High Gamble(count not found)";
	}

	/**
	 * Parses a combat achievement success chat message into a filename-safe string.
	 *
	 * @param text A received chat message which may or may not be from completing a combat achievement.
	 * @return A formatted string of the achieved combat task name, or the empty string if the passed message
	 *         is not a combat achievement completion message.
	 */
	@VisibleForTesting
	static String parseCombatAchievementWidget(final String text)
	{
		final Matcher m = COMBAT_ACHIEVEMENTS_PATTERN.matcher(text);
		if (m.matches())
		{
			String task = m.group("task").replaceAll("[:?]", "");
			return "Combat task (" + task + ")";
		}
		return "";
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param fileName Filename to use, without file extension.
	 * @param subDir   Subdirectory to store the captured screenshot in.
	 */
	@VisibleForTesting
	void takeScreenshot(String fileName, String subDir)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("Login screenshot prevented");
			return;
		}

		Consumer<Image> imageCallback = (img) ->
		{
			// This callback is on the game thread, move to executor thread
			executor.submit(() -> takeScreenshot(fileName, subDir, img));
		};

		if (config.displayDate() && REPORT_BUTTON_TLIS.contains(client.getTopLevelInterfaceId()))
		{
			screenshotOverlay.queueForTimestamp(imageCallback);
		}
		else
		{
			drawManager.requestNextFrameListener(imageCallback);
		}
	}

	private static int getScaledValue(final double scale, final int value)
	{
		return (int) (value * scale + .5);
	}

	private void takeScreenshot(String fileName, String subDir, Image image)
	{
		final BufferedImage screenshot;
		if (!config.includeFrame())
		{
			// just simply copy the image
			screenshot = ImageUtil.bufferedImageFromImage(image);
		}
		else
		{
			// create a new image, paint the client ui to it, and then draw the screenshot to that
			final GraphicsConfiguration graphicsConfiguration = clientUi.getGraphicsConfiguration();
			final AffineTransform transform = graphicsConfiguration.getDefaultTransform();

			// scaled client dimensions
			int clientWidth = getScaledValue(transform.getScaleX(), clientUi.getWidth());
			int clientHeight = getScaledValue(transform.getScaleY(), clientUi.getHeight());

			screenshot = new BufferedImage(clientWidth, clientHeight, BufferedImage.TYPE_INT_ARGB);

			Graphics2D graphics = (Graphics2D) screenshot.getGraphics();
			AffineTransform originalTransform = graphics.getTransform();
			// scale g2d for the paint() call
			graphics.setTransform(transform);

			// Draw the client frame onto the screenshot
			try
			{
				SwingUtilities.invokeAndWait(() -> clientUi.paint(graphics));
			}
			catch (InterruptedException | InvocationTargetException e)
			{
				log.warn("unable to paint client UI on screenshot", e);
			}

			// Find the position of the canvas inside the frame
			final Point canvasOffset = clientUi.getCanvasOffset();
			final int gameOffsetX = getScaledValue(transform.getScaleX(), canvasOffset.getX());
			final int gameOffsetY = getScaledValue(transform.getScaleY(), canvasOffset.getY());

			// Draw the original screenshot onto the new screenshot
			graphics.setTransform(originalTransform); // the original screenshot is already scaled
			graphics.drawImage(image, gameOffsetX, gameOffsetY, null);
			graphics.dispose();
		}

		imageCapture.takeScreenshot(screenshot, fileName, subDir, config.notifyWhenTaken(), config.uploadScreenshot());
	}

	private boolean isInsideGauntlet()
	{
		return this.client.isInInstancedRegion()
			&& this.client.getMapRegions().length > 0
			&& (this.client.getMapRegions()[0] == GAUNTLET_REGION
			|| this.client.getMapRegions()[0] == CORRUPTED_GAUNTLET_REGION);
	}

	@VisibleForTesting
	int getClueNumber()
	{
		return clueNumber;
	}

	@VisibleForTesting
	String getClueType()
	{
		return clueType;
	}

	@VisibleForTesting
	KillType getKillType()
	{
		return killType;
	}

	@VisibleForTesting
	int getKillCountNumber()
	{
		return killCountNumber;
	}
}
