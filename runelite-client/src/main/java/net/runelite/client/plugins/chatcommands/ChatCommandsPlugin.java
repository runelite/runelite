/*
 * Copyright (c) 2017. l2-
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.chatcommands;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.IconID;
import net.runelite.api.ItemComposition;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.ADVENTURE_LOG_ID;
import static net.runelite.api.widgets.WidgetID.GENERIC_SCROLL_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.KILL_LOGS_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.util.Text;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.chat.Duels;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.ItemPrice;
import okhttp3.OkHttpClient;
import org.apache.commons.text.WordUtils;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final Pattern KILLCOUNT_PATTERN = Pattern.compile("Your (?:completion count for |subdued |completed )?(.+?) (?:(?:kill|harvest|lap|completion) )?(?:count )?is: <col=ff0000>(\\d+)</col>");
	private static final String COX_TEAM_SIZES = "(?:\\d+(?:\\+|-\\d+)? players|Solo)";
	private static final Pattern RAIDS_PB_PATTERN = Pattern.compile("<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>" + COX_TEAM_SIZES + "</col> Duration:</col> <col=ff0000>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col> \\(new personal best\\)</col>");
	private static final Pattern RAIDS_DURATION_PATTERN = Pattern.compile("<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>" + COX_TEAM_SIZES + "</col> Duration:</col> <col=ff0000>[0-9:.]+</col> Personal best: </col><col=ff0000>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col>");
	private static final Pattern TOB_WAVE_PB_PATTERN = Pattern.compile("^.*Theatre of Blood wave completion time: <col=ff0000>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col> \\(Personal best!\\)");
	private static final Pattern TOB_WAVE_DURATION_PATTERN = Pattern.compile("^.*Theatre of Blood wave completion time: <col=ff0000>[0-9:.]+</col><br></col>Personal best: (?<pb>[0-9:]+(?:\\.[0-9]+)?)");
	private static final Pattern KILL_DURATION_PATTERN = Pattern.compile("(?i)^(?:(?:Fight |Lap |Challenge |Corrupted challenge )?duration:|Subdued in) <col=[0-9a-f]{6}>[0-9:.]+</col>\\. Personal best: (?:<col=ff0000>)?(?<pb>[0-9:]+(?:\\.[0-9]+)?)");
	private static final Pattern NEW_PB_PATTERN = Pattern.compile("(?i)^(?:(?:Fight |Lap |Challenge |Corrupted challenge )?duration:|Subdued in) <col=[0-9a-f]{6}>(?<pb>[0-9:]+(?:\\.[0-9]+)?)</col> \\(new personal best\\)");
	private static final Pattern DUEL_ARENA_WINS_PATTERN = Pattern.compile("You (were defeated|won)! You have(?: now)? won (\\d+) duels?");
	private static final Pattern DUEL_ARENA_LOSSES_PATTERN = Pattern.compile("You have(?: now)? lost (\\d+) duels?");
	private static final Pattern ADVENTURE_LOG_TITLE_PATTERN = Pattern.compile("The Exploits of (.+)");
	private static final Pattern ADVENTURE_LOG_COX_PB_PATTERN = Pattern.compile("Fastest (?:kill|run)(?: - \\(Team size: " + COX_TEAM_SIZES  + "\\))?: ([0-9:]+(?:\\.[0-9]+)?)");
	private static final Pattern ADVENTURE_LOG_BOSS_PB_PATTERN = Pattern.compile("[a-zA-Z]+(?: [a-zA-Z]+)*");
	private static final Pattern ADVENTURE_LOG_PB_PATTERN = Pattern.compile("(" + ADVENTURE_LOG_BOSS_PB_PATTERN + "(?: - " + ADVENTURE_LOG_BOSS_PB_PATTERN + ")*) (?:" + ADVENTURE_LOG_COX_PB_PATTERN + "( )*)+");
	private static final Pattern HS_PB_PATTERN = Pattern.compile("Floor (?<floor>\\d) time: <col=ff0000>(?<floortime>[0-9:]+(?:\\.[0-9]+)?)</col>(?: \\(new personal best\\)|. Personal best: (?<floorpb>[0-9:]+(?:\\.[0-9]+)?))" +
		"(?:<br>Overall time: <col=ff0000>(?<otime>[0-9:]+(?:\\.[0-9]+)?)</col>(?: \\(new personal best\\)|. Personal best: (?<opb>[0-9:]+(?:\\.[0-9]+)?)))?");
	private static final Pattern HS_KC_FLOOR_PATTERN = Pattern.compile("You have completed Floor (\\d) of the Hallowed Sepulchre! Total completions: <col=ff0000>([0-9,]+)</col>\\.");
	private static final Pattern HS_KC_GHC_PATTERN = Pattern.compile("You have opened the Grand Hallowed Coffin <col=ff0000>([0-9,]+)</col> times?!");

	private static final String TOTAL_LEVEL_COMMAND_STRING = "!total";
	private static final String PRICE_COMMAND_STRING = "!price";
	private static final String LEVEL_COMMAND_STRING = "!lvl";
	private static final String BOUNTY_HUNTER_HUNTER_COMMAND = "!bh";
	private static final String BOUNTY_HUNTER_ROGUE_COMMAND = "!bhrogue";
	private static final String CLUES_COMMAND_STRING = "!clues";
	private static final String LAST_MAN_STANDING_COMMAND = "!lms";
	private static final String KILLCOUNT_COMMAND_STRING = "!kc";
	private static final String CMB_COMMAND_STRING = "!cmb";
	private static final String QP_COMMAND_STRING = "!qp";
	private static final String PB_COMMAND = "!pb";
	private static final String GC_COMMAND_STRING = "!gc";
	private static final String DUEL_ARENA_COMMAND = "!duels";
	private static final String LEAGUE_POINTS_COMMAND = "!lp";
	private static final String SOUL_WARS_ZEAL_COMMAND = "!sw";

	@VisibleForTesting
	static final int ADV_LOG_EXPLOITS_TEXT_INDEX = 1;

	private static final Map<String, String> KILLCOUNT_RENAMES = ImmutableMap.of(
		"Barrows chest", "Barrows Chests"
	);

	private boolean bossLogLoaded;
	private boolean advLogLoaded;
	private boolean scrollInterfaceLoaded;
	private String pohOwner;
	private HiscoreEndpoint hiscoreEndpoint; // hiscore endpoint for current player
	private String lastBossKill;
	private int lastBossTime = -1;
	private double lastPb = -1;

	@Inject
	private Client client;

	@Inject
	private ChatCommandsConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatKeyboardListener chatKeyboardListener;

	@Inject
	private HiscoreClient hiscoreClient;

	@Inject
	private ChatClient chatClient;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(chatKeyboardListener);

		chatCommandManager.registerCommandAsync(TOTAL_LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CMB_COMMAND_STRING, this::combatLevelLookup);
		chatCommandManager.registerCommand(PRICE_COMMAND_STRING, this::itemPriceLookup);
		chatCommandManager.registerCommandAsync(LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(BOUNTY_HUNTER_HUNTER_COMMAND, this::bountyHunterHunterLookup);
		chatCommandManager.registerCommandAsync(BOUNTY_HUNTER_ROGUE_COMMAND, this::bountyHunterRogueLookup);
		chatCommandManager.registerCommandAsync(CLUES_COMMAND_STRING, this::clueLookup);
		chatCommandManager.registerCommandAsync(LAST_MAN_STANDING_COMMAND, this::lastManStandingLookup);
		chatCommandManager.registerCommandAsync(LEAGUE_POINTS_COMMAND, this::leaguePointsLookup);
		chatCommandManager.registerCommandAsync(KILLCOUNT_COMMAND_STRING, this::killCountLookup, this::killCountSubmit);
		chatCommandManager.registerCommandAsync(QP_COMMAND_STRING, this::questPointsLookup, this::questPointsSubmit);
		chatCommandManager.registerCommandAsync(PB_COMMAND, this::personalBestLookup, this::personalBestSubmit);
		chatCommandManager.registerCommandAsync(GC_COMMAND_STRING, this::gambleCountLookup, this::gambleCountSubmit);
		chatCommandManager.registerCommandAsync(DUEL_ARENA_COMMAND, this::duelArenaLookup, this::duelArenaSubmit);
		chatCommandManager.registerCommandAsync(SOUL_WARS_ZEAL_COMMAND, this::soulWarsZealLookup);
	}

	@Override
	public void shutDown()
	{
		lastBossKill = null;
		lastBossTime = -1;

		keyManager.unregisterKeyListener(chatKeyboardListener);

		chatCommandManager.unregisterCommand(TOTAL_LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CMB_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PRICE_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(BOUNTY_HUNTER_HUNTER_COMMAND);
		chatCommandManager.unregisterCommand(BOUNTY_HUNTER_ROGUE_COMMAND);
		chatCommandManager.unregisterCommand(CLUES_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LAST_MAN_STANDING_COMMAND);
		chatCommandManager.unregisterCommand(LEAGUE_POINTS_COMMAND);
		chatCommandManager.unregisterCommand(KILLCOUNT_COMMAND_STRING);
		chatCommandManager.unregisterCommand(QP_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PB_COMMAND);
		chatCommandManager.unregisterCommand(GC_COMMAND_STRING);
		chatCommandManager.unregisterCommand(DUEL_ARENA_COMMAND);
		chatCommandManager.unregisterCommand(SOUL_WARS_ZEAL_COMMAND);
	}

	@Provides
	ChatCommandsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatCommandsConfig.class);
	}

	@Provides
	HiscoreClient provideHiscoreClient(OkHttpClient okHttpClient)
	{
		return new HiscoreClient(okHttpClient);
	}

	private void setKc(String boss, int killcount)
	{
		configManager.setRSProfileConfiguration("killcount", boss.toLowerCase(), killcount);
	}

	private int getKc(String boss)
	{
		Integer killCount = configManager.getRSProfileConfiguration("killcount", boss.toLowerCase(), int.class);
		return killCount == null ? 0 : killCount;
	}

	private void setPb(String boss, double seconds)
	{
		configManager.setRSProfileConfiguration("personalbest", boss.toLowerCase(), seconds);
	}

	private double getPb(String boss)
	{
		Double personalBest = configManager.getRSProfileConfiguration("personalbest", boss.toLowerCase(), double.class);
		return personalBest == null ? 0 : personalBest;
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.TRADE
			&& chatMessage.getType() != ChatMessageType.GAMEMESSAGE
			&& chatMessage.getType() != ChatMessageType.SPAM
			&& chatMessage.getType() != ChatMessageType.FRIENDSCHATNOTIFICATION)
		{
			return;
		}

		String message = chatMessage.getMessage();
		Matcher matcher = KILLCOUNT_PATTERN.matcher(message);
		if (matcher.find())
		{
			String boss = matcher.group(1);
			int kc = Integer.parseInt(matcher.group(2));

			boss = KILLCOUNT_RENAMES.getOrDefault(boss, boss);

			setKc(boss, kc);
			// We either already have the pb, or need to remember the boss for the upcoming pb
			if (lastPb > -1)
			{
				log.debug("Got out-of-order personal best for {}: {}", boss, lastPb);
				setPb(boss, lastPb);
				lastPb = -1;
			}
			else
			{
				lastBossKill = boss;
				lastBossTime = client.getTickCount();
			}
			return;
		}

		matcher = DUEL_ARENA_WINS_PATTERN.matcher(message);
		if (matcher.find())
		{
			final int oldWins = getKc("Duel Arena Wins");
			final int wins = Integer.parseInt(matcher.group(2));
			final String result = matcher.group(1);
			int winningStreak = getKc("Duel Arena Win Streak");
			int losingStreak = getKc("Duel Arena Lose Streak");

			if (result.equals("won") && wins > oldWins)
			{
				losingStreak = 0;
				winningStreak += 1;
			}
			else if (result.equals("were defeated"))
			{
				losingStreak += 1;
				winningStreak = 0;
			}
			else
			{
				log.warn("unrecognized duel streak chat message: {}", message);
			}

			setKc("Duel Arena Wins", wins);
			setKc("Duel Arena Win Streak", winningStreak);
			setKc("Duel Arena Lose Streak", losingStreak);
		}

		matcher = DUEL_ARENA_LOSSES_PATTERN.matcher(message);
		if (matcher.find())
		{
			int losses = Integer.parseInt(matcher.group(1));

			setKc("Duel Arena Losses", losses);
		}

		matcher = KILL_DURATION_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = NEW_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = RAIDS_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = RAIDS_DURATION_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = TOB_WAVE_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = TOB_WAVE_DURATION_PATTERN.matcher(message);
		if (matcher.find())
		{
			matchPb(matcher);
		}

		matcher = HS_PB_PATTERN.matcher(message);
		if (matcher.find())
		{
			int floor = Integer.parseInt(matcher.group("floor"));
			String floortime = matcher.group("floortime");
			String floorpb = matcher.group("floorpb");
			String otime = matcher.group("otime");
			String opb = matcher.group("opb");

			String pb = MoreObjects.firstNonNull(floorpb, floortime);
			setPb("Hallowed Sepulchre Floor " + floor, timeStringToSeconds(pb));

			if (otime != null)
			{
				pb = MoreObjects.firstNonNull(opb, otime);
				setPb("Hallowed Sepulchre", timeStringToSeconds(pb));
			}
		}

		matcher = HS_KC_FLOOR_PATTERN.matcher(message);
		if (matcher.find())
		{
			int floor = Integer.parseInt(matcher.group(1));
			int kc = Integer.parseInt(matcher.group(2).replaceAll(",", ""));
			setKc("Hallowed Sepulchre Floor " + floor, kc);
		}

		matcher = HS_KC_GHC_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1).replaceAll(",", ""));
			setKc("Hallowed Sepulchre", kc);
		}

		if (lastBossKill != null && lastBossTime != client.getTickCount())
		{
			lastBossKill = null;
			lastBossTime = -1;
		}
	}

	@VisibleForTesting
	static double timeStringToSeconds(String timeString)
	{
		String[] s = timeString.split(":");
		if (s.length == 2) // mm:ss
		{
			return Integer.parseInt(s[0]) * 60 + Double.parseDouble(s[1]);
		}
		else if (s.length == 3) // h:mm:ss
		{
			return Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Double.parseDouble(s[2]);
		}
		return Double.parseDouble(timeString);
	}

	private void matchPb(Matcher matcher)
	{
		double seconds = timeStringToSeconds(matcher.group("pb"));
		if (lastBossKill != null)
		{
			// Most bosses sent boss kill message, and then pb message, so we
			// use the remembered lastBossKill
			log.debug("Got personal best for {}: {}", lastBossKill, seconds);
			setPb(lastBossKill, seconds);
			lastPb = -1;
		}
		else
		{
			// Some bosses send the pb message, and then the kill message!
			lastPb = seconds;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		if (advLogLoaded)
		{
			advLogLoaded = false;

			Widget adventureLog = client.getWidget(WidgetInfo.ADVENTURE_LOG);

			if (adventureLog != null)
			{
				Matcher advLogExploitsText = ADVENTURE_LOG_TITLE_PATTERN.matcher(adventureLog.getChild(ADV_LOG_EXPLOITS_TEXT_INDEX).getText());
				if (advLogExploitsText.find())
				{
					pohOwner = advLogExploitsText.group(1);
				}
			}
		}

		if (bossLogLoaded && (pohOwner == null || pohOwner.equals(client.getLocalPlayer().getName())))
		{
			bossLogLoaded = false;

			Widget title = client.getWidget(WidgetInfo.KILL_LOG_TITLE);
			Widget bossMonster = client.getWidget(WidgetInfo.KILL_LOG_MONSTER);
			Widget bossKills = client.getWidget(WidgetInfo.KILL_LOG_KILLS);

			if (title == null || bossMonster == null || bossKills == null
				|| !"Boss Kill Log".equals(title.getText()))
			{
				return;
			}

			Widget[] bossChildren = bossMonster.getChildren();
			Widget[] killsChildren = bossKills.getChildren();

			for (int i = 0; i < bossChildren.length; ++i)
			{
				Widget boss = bossChildren[i];
				Widget kill = killsChildren[i];

				String bossName = boss.getText().replace(":", "");
				int kc = Integer.parseInt(kill.getText().replace(",", ""));
				if (kc != getKc(longBossName(bossName)))
				{
					setKc(longBossName(bossName), kc);
				}
			}
		}

		if (scrollInterfaceLoaded)
		{
			scrollInterfaceLoaded = false;

			if (client.getLocalPlayer().getName().equals(pohOwner))
			{
				String counterText = Text.sanitizeMultilineText(client.getWidget(WidgetInfo.GENERIC_SCROLL_TEXT).getText());
				Matcher mCounterText = ADVENTURE_LOG_PB_PATTERN.matcher(counterText);
				while (mCounterText.find())
				{
					String bossName = longBossName(mCounterText.group(1));
					if (bossName.equalsIgnoreCase("chambers of xeric") ||
						bossName.equalsIgnoreCase("chambers of xeric challenge mode"))
					{
						Matcher mCoxRuns = ADVENTURE_LOG_COX_PB_PATTERN.matcher(mCounterText.group());
						double bestPbTime = Double.MAX_VALUE;
						while (mCoxRuns.find())
						{
							bestPbTime = Math.min(timeStringToSeconds(mCoxRuns.group(1)), bestPbTime);
						}
						// So we don't reset people's already saved PB's if they had one before the update
						double currentPb = getPb(bossName);
						if (currentPb == 0 || currentPb > bestPbTime)
						{
							setPb(bossName, bestPbTime);
						}
					}
					else
					{
						String pbTime = mCounterText.group(2);
						setPb(bossName, timeStringToSeconds(pbTime));
					}
				}
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widget)
	{
		switch (widget.getGroupId())
		{
			case ADVENTURE_LOG_ID:
				advLogLoaded = true;
				break;
			case KILL_LOGS_GROUP_ID:
				bossLogLoaded = true;
				break;
			case GENERIC_SCROLL_GROUP_ID:
				scrollInterfaceLoaded = true;
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
			case HOPPING:
				pohOwner = null;
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		hiscoreEndpoint = getLocalHiscoreEndpointType();
	}

	private boolean killCountSubmit(ChatInput chatInput, String value)
	{
		int idx = value.indexOf(' ');
		final String boss = longBossName(value.substring(idx + 1));

		final int kc = getKc(boss);
		if (kc <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitKc(playerName, boss, kc);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit killcount", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void killCountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.killcount())
		{
			return;
		}

		if (message.length() <= KILLCOUNT_COMMAND_STRING.length())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();
		String search = message.substring(KILLCOUNT_COMMAND_STRING.length() + 1);

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		search = longBossName(search);

		final int kc;
		try
		{
			kc = chatClient.getKc(player, search);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup killcount", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(search)
			.append(ChatColorType.NORMAL)
			.append(" kill count: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", kc))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean duelArenaSubmit(ChatInput chatInput, String value)
	{
		final int wins = getKc("Duel Arena Wins");
		final int losses = getKc("Duel Arena Losses");
		final int winningStreak = getKc("Duel Arena Win Streak");
		final int losingStreak = getKc("Duel Arena Lose Streak");

		if (wins <= 0 && losses <= 0 && winningStreak <= 0 && losingStreak <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitDuels(playerName, wins, losses, winningStreak, losingStreak);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit duels", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void duelArenaLookup(ChatMessage chatMessage, String message)
	{
		if (!config.duels())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type == ChatMessageType.PRIVATECHATOUT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		Duels duels;
		try
		{
			duels = chatClient.getDuels(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup duels", ex);
			return;
		}

		final int wins = duels.getWins();
		final int losses = duels.getLosses();
		final int winningStreak = duels.getWinningStreak();
		final int losingStreak = duels.getLosingStreak();

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Duel Arena wins: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", wins))
			.append(ChatColorType.NORMAL)
			.append("   losses: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", losses))
			.append(ChatColorType.NORMAL)
			.append("   streak: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", winningStreak != 0 ? winningStreak : -losingStreak))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private void questPointsLookup(ChatMessage chatMessage, String message)
	{
		if (!config.qp())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		int qp;
		try
		{
			qp = chatClient.getQp(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup quest points", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Quest points: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(qp))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean questPointsSubmit(ChatInput chatInput, String value)
	{
		final int qp = client.getVar(VarPlayer.QUEST_POINTS);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitQp(playerName, qp);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit quest points", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void personalBestLookup(ChatMessage chatMessage, String message)
	{
		if (!config.pb())
		{
			return;
		}

		if (message.length() <= PB_COMMAND.length())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();
		String search = message.substring(PB_COMMAND.length() + 1);

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		search = longBossName(search);

		final double pb;
		try
		{
			pb = chatClient.getPb(player, search);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup personal best", ex);
			return;
		}

		int minutes = (int) (Math.floor(pb) / 60);
		double seconds = pb % 60;

		// If the seconds is an integer, it is ambiguous if the pb is a precise
		// pb or not. So we always show it without the trailing .00.
		final String time = Math.floor(seconds) == seconds ?
			String.format("%d:%02d", minutes, (int) seconds) :
			String.format("%d:%05.2f", minutes, seconds);

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(search)
			.append(ChatColorType.NORMAL)
			.append(" personal best: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(time)
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean personalBestSubmit(ChatInput chatInput, String value)
	{
		int idx = value.indexOf(' ');
		final String boss = longBossName(value.substring(idx + 1));

		final double pb = getPb(boss);
		if (pb <= 0)
		{
			return false;
		}

		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitPb(playerName, boss, pb);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit personal best", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	private void gambleCountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.gc())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type == ChatMessageType.PRIVATECHATOUT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		int gc;
		try
		{
			gc = chatClient.getGc(player);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup gamble count", ex);
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Barbarian Assault High-level gambles: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%,d", gc))
			.build();

		log.debug("Setting response {}", response);
		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private boolean gambleCountSubmit(ChatInput chatInput, String value)
	{
		final int gc = client.getVar(Varbits.BA_GC);
		final String playerName = client.getLocalPlayer().getName();

		executor.execute(() ->
		{
			try
			{
				chatClient.submitGc(playerName, gc);
			}
			catch (Exception ex)
			{
				log.warn("unable to submit gamble count", ex);
			}
			finally
			{
				chatInput.resume();
			}
		});

		return true;
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	private void itemPriceLookup(ChatMessage chatMessage, String message)
	{
		if (!config.price())
		{
			return;
		}

		if (message.length() <= PRICE_COMMAND_STRING.length())
		{
			return;
		}

		MessageNode messageNode = chatMessage.getMessageNode();
		String search = message.substring(PRICE_COMMAND_STRING.length() + 1);

		List<ItemPrice> results = itemManager.search(search);

		if (!results.isEmpty())
		{
			ItemPrice item = retrieveFromList(results, search);

			int itemId = item.getId();
			int itemPrice = runeLiteConfig.useWikiItemPrices() && item.getWikiPrice() > 0 ? item.getWikiPrice() : item.getPrice();

			final ChatMessageBuilder builder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT)
				.append(item.getName())
				.append(ChatColorType.NORMAL)
				.append(": GE average ")
				.append(ChatColorType.HIGHLIGHT)
				.append(QuantityFormatter.formatNumber(itemPrice));

			ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			final int alchPrice = itemComposition.getHaPrice();
			builder
				.append(ChatColorType.NORMAL)
				.append(" HA value ")
				.append(ChatColorType.HIGHLIGHT)
				.append(QuantityFormatter.formatNumber(alchPrice));

			String response = builder.build();

			log.debug("Setting response {}", response);
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	@VisibleForTesting
	void playerSkillLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lvl())
		{
			return;
		}

		String search;
		if (message.equalsIgnoreCase(TOTAL_LEVEL_COMMAND_STRING))
		{
			search = "total";
		}
		else
		{
			if (message.length() <= LEVEL_COMMAND_STRING.length())
			{
				return;
			}

			search = message.substring(LEVEL_COMMAND_STRING.length() + 1);
		}

		search = SkillAbbreviations.getFullName(search);
		final HiscoreSkill skill;
		try
		{
			skill = HiscoreSkill.valueOf(search.toUpperCase());
		}
		catch (IllegalArgumentException i)
		{
			return;
		}

		final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);

		try
		{
			final SingleHiscoreSkillResult result = hiscoreClient.lookup(lookup.getName(), skill, lookup.getEndpoint());

			if (result == null)
			{
				log.warn("unable to look up skill {} for {}: not found", skill, search);
				return;
			}

			final Skill hiscoreSkill = result.getSkill();

			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Level ")
				.append(ChatColorType.HIGHLIGHT)
				.append(skill.getName()).append(": ").append(String.valueOf(hiscoreSkill.getLevel()))
				.append(ChatColorType.NORMAL);
			if (hiscoreSkill.getExperience() != -1)
			{
				chatMessageBuilder.append(" Experience: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", hiscoreSkill.getExperience()))
					.append(ChatColorType.NORMAL);
			}
			if (hiscoreSkill.getRank() != -1)
			{
				chatMessageBuilder.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", hiscoreSkill.getRank()));
			}

			final String response = chatMessageBuilder.build();
			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("unable to look up skill {} for {}", skill, search, ex);
		}
	}

	private void combatLevelLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lvl())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		String player;
		if (type == ChatMessageType.PRIVATECHATOUT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = Text.sanitize(chatMessage.getName());
		}

		try
		{
			HiscoreResult playerStats = hiscoreClient.lookup(player);

			if (playerStats == null)
			{
				log.warn("Error fetching hiscore data: not found");
				return;
			}

			int attack = playerStats.getAttack().getLevel();
			int strength = playerStats.getStrength().getLevel();
			int defence = playerStats.getDefence().getLevel();
			int hitpoints = playerStats.getHitpoints().getLevel();
			int ranged = playerStats.getRanged().getLevel();
			int prayer = playerStats.getPrayer().getLevel();
			int magic = playerStats.getMagic().getLevel();
			int combatLevel = Experience.getCombatLevel(attack, strength, defence, hitpoints, magic, ranged, prayer);

			String response = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Combat Level: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(combatLevel))
				.append(ChatColorType.NORMAL)
				.append(" A: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(attack))
				.append(ChatColorType.NORMAL)
				.append(" S: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(strength))
				.append(ChatColorType.NORMAL)
				.append(" D: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(defence))
				.append(ChatColorType.NORMAL)
				.append(" H: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(hitpoints))
				.append(ChatColorType.NORMAL)
				.append(" R: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(ranged))
				.append(ChatColorType.NORMAL)
				.append(" P: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(prayer))
				.append(ChatColorType.NORMAL)
				.append(" M: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(magic))
				.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("Error fetching hiscore data", ex);
		}
	}

	private void leaguePointsLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lp())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.LEAGUE_POINTS);
	}

	private void bountyHunterHunterLookup(ChatMessage chatMessage, String message)
	{
		if (!config.bh())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.BOUNTY_HUNTER_HUNTER);
	}

	private void bountyHunterRogueLookup(ChatMessage chatMessage, String message)
	{
		if (!config.bhRogue())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.BOUNTY_HUNTER_ROGUE);
	}

	private void lastManStandingLookup(ChatMessage chatMessage, String message)
	{
		if (!config.lms())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.LAST_MAN_STANDING);
	}

	private void soulWarsZealLookup(ChatMessage chatMessage, String message)
	{
		if (!config.sw())
		{
			return;
		}

		minigameLookup(chatMessage, HiscoreSkill.SOUL_WARS_ZEAL);
	}

	private void minigameLookup(ChatMessage chatMessage, HiscoreSkill minigame)
	{
		try
		{
			final Skill hiscoreSkill;
			final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);

			// League points only exist on the league hiscores
			final HiscoreEndpoint endPoint = minigame == HiscoreSkill.LEAGUE_POINTS ?
				HiscoreEndpoint.LEAGUE :
				lookup.getEndpoint();

			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), endPoint);

			if (result == null)
			{
				log.warn("error looking up {} score: not found", minigame.getName().toLowerCase());
				return;
			}

			switch (minigame)
			{
				case BOUNTY_HUNTER_HUNTER:
					hiscoreSkill = result.getBountyHunterHunter();
					break;
				case BOUNTY_HUNTER_ROGUE:
					hiscoreSkill = result.getBountyHunterRogue();
					break;
				case LAST_MAN_STANDING:
					hiscoreSkill = result.getLastManStanding();
					break;
				case LEAGUE_POINTS:
					hiscoreSkill = result.getLeaguePoints();
					break;
				case SOUL_WARS_ZEAL:
					hiscoreSkill = result.getSoulWarsZeal();
					break;
				default:
					log.warn("error looking up {} score: not implemented", minigame.getName().toLowerCase());
					return;
			}

			int score = hiscoreSkill.getLevel();
			if (score == -1)
			{
				return;
			}

			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(minigame.getName())
				.append(" Score: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", score));

			int rank = hiscoreSkill.getRank();
			if (rank != -1)
			{
				chatMessageBuilder.append(ChatColorType.NORMAL)
					.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", rank));
			}

			String response = chatMessageBuilder.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("error looking up {}", minigame.getName().toLowerCase(), ex);
		}
	}

	private void clueLookup(ChatMessage chatMessage, String message)
	{
		if (!config.clue())
		{
			return;
		}

		String search;

		if (message.equalsIgnoreCase(CLUES_COMMAND_STRING))
		{
			search = "total";
		}
		else
		{
			search = message.substring(CLUES_COMMAND_STRING.length() + 1);
		}

		try
		{
			final Skill hiscoreSkill;
			final HiscoreLookup lookup = getCorrectLookupFor(chatMessage);
			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());

			if (result == null)
			{
				log.warn("error looking up clues: not found");
				return;
			}

			String level = search.toLowerCase();

			switch (level)
			{
				case "beginner":
					hiscoreSkill = result.getClueScrollBeginner();
					break;
				case "easy":
					hiscoreSkill = result.getClueScrollEasy();
					break;
				case "medium":
					hiscoreSkill = result.getClueScrollMedium();
					break;
				case "hard":
					hiscoreSkill = result.getClueScrollHard();
					break;
				case "elite":
					hiscoreSkill = result.getClueScrollElite();
					break;
				case "master":
					hiscoreSkill = result.getClueScrollMaster();
					break;
				case "total":
					hiscoreSkill = result.getClueScrollAll();
					break;
				default:
					return;
			}

			int quantity = hiscoreSkill.getLevel();
			int rank = hiscoreSkill.getRank();
			if (quantity == -1)
			{
				return;
			}

			ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Clue scroll (" + level + ")").append(": ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", quantity));

			if (rank != -1)
			{
				chatMessageBuilder.append(ChatColorType.NORMAL)
					.append(" Rank: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(String.format("%,d", rank));
			}

			String response = chatMessageBuilder.build();

			log.debug("Setting response {}", response);
			final MessageNode messageNode = chatMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("error looking up clues", ex);
		}
	}

	/**
	 * Gets correct lookup data for message
	 *
	 * @param chatMessage chat message
	 * @return hiscore lookup data
	 */
	private HiscoreLookup getCorrectLookupFor(final ChatMessage chatMessage)
	{
		Player localPlayer = client.getLocalPlayer();
		final String player = Text.sanitize(chatMessage.getName());

		// If we are sending the message then just use the local hiscore endpoint for the world
		if (chatMessage.getType().equals(ChatMessageType.PRIVATECHATOUT)
			|| player.equals(localPlayer.getName()))
		{
			return new HiscoreLookup(localPlayer.getName(), hiscoreEndpoint);
		}

		// Public chat on a leagues world is always league hiscores, regardless of icon
		if (chatMessage.getType() == ChatMessageType.PUBLICCHAT || chatMessage.getType() == ChatMessageType.MODCHAT)
		{
			if (client.getWorldType().contains(WorldType.LEAGUE))
			{
				return new HiscoreLookup(player, HiscoreEndpoint.LEAGUE);
			}
		}

		// Get ironman status from their icon in chat, this handles leagues too
		HiscoreEndpoint endpoint = getHiscoreEndpointByName(chatMessage.getName());
		return new HiscoreLookup(player, endpoint);
	}

	/**
	 * Compares the names of the items in the list with the original input.
	 * Returns the item if its name is equal to the original input or the
	 * shortest match if no exact match is found.
	 *
	 * @param items         List of items.
	 * @param originalInput String with the original input.
	 * @return Item which has a name equal to the original input.
	 */
	private ItemPrice retrieveFromList(List<ItemPrice> items, String originalInput)
	{
		ItemPrice shortest = null;
		for (ItemPrice item : items)
		{
			if (item.getName().toLowerCase().equals(originalInput.toLowerCase()))
			{
				return item;
			}

			if (shortest == null || item.getName().length() < shortest.getName().length())
			{
				shortest = item;
			}
		}

		// Take a guess
		return shortest;
	}

	/**
	 * Looks up the ironman status of the local player. Does NOT work on other players.
	 *
	 * @return hiscore endpoint
	 */
	private HiscoreEndpoint getLocalHiscoreEndpointType()
	{
		EnumSet<WorldType> worldType = client.getWorldType();
		if (worldType.contains(WorldType.LEAGUE))
		{
			return HiscoreEndpoint.LEAGUE;
		}

		return toEndPoint(client.getAccountType());
	}

	/**
	 * Returns the ironman status based on the symbol in the name of the player.
	 *
	 * @param name player name
	 * @return hiscore endpoint
	 */
	private static HiscoreEndpoint getHiscoreEndpointByName(final String name)
	{
		if (name.contains(IconID.IRONMAN.toString()))
		{
			return HiscoreEndpoint.IRONMAN;
		}
		else if (name.contains(IconID.ULTIMATE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.ULTIMATE_IRONMAN;
		}
		else if (name.contains(IconID.HARDCORE_IRONMAN.toString()))
		{
			return HiscoreEndpoint.HARDCORE_IRONMAN;
		}
		else if (name.contains(IconID.LEAGUE.toString()))
		{
			return HiscoreEndpoint.LEAGUE;
		}
		else
		{
			return HiscoreEndpoint.NORMAL;
		}
	}

	/**
	 * Converts account type to hiscore endpoint
	 *
	 * @param accountType account type
	 * @return hiscore endpoint
	 */
	private static HiscoreEndpoint toEndPoint(final AccountType accountType)
	{
		switch (accountType)
		{
			case IRONMAN:
				return HiscoreEndpoint.IRONMAN;
			case ULTIMATE_IRONMAN:
				return HiscoreEndpoint.ULTIMATE_IRONMAN;
			case HARDCORE_IRONMAN:
				return HiscoreEndpoint.HARDCORE_IRONMAN;
			default:
				return HiscoreEndpoint.NORMAL;
		}
	}

	@Value
	private static class HiscoreLookup
	{
		private final String name;
		private final HiscoreEndpoint endpoint;
	}

	private static String longBossName(String boss)
	{
		switch (boss.toLowerCase())
		{
			case "corp":
				return "Corporeal Beast";

			case "jad":
			case "tzhaar fight cave":
				return "TzTok-Jad";

			case "kq":
				return "Kalphite Queen";

			case "chaos ele":
				return "Chaos Elemental";

			case "dusk":
			case "dawn":
			case "gargs":
				return "Grotesque Guardians";

			case "crazy arch":
				return "Crazy Archaeologist";

			case "deranged arch":
				return "Deranged Archaeologist";

			case "mole":
				return "Giant Mole";

			case "vetion":
				return "Vet'ion";

			case "vene":
				return "Venenatis";

			case "kbd":
				return "King Black Dragon";

			case "vork":
				return "Vorkath";

			case "sire":
				return "Abyssal Sire";

			case "smoke devil":
			case "thermy":
				return "Thermonuclear Smoke Devil";

			case "cerb":
				return "Cerberus";

			case "zuk":
			case "inferno":
				return "TzKal-Zuk";

			case "hydra":
				return "Alchemical Hydra";

			// gwd
			case "sara":
			case "saradomin":
			case "zilyana":
			case "zily":
				return "Commander Zilyana";
			case "zammy":
			case "zamorak":
			case "kril":
			case "kril trutsaroth":
				return "K'ril Tsutsaroth";
			case "arma":
			case "kree":
			case "kreearra":
			case "armadyl":
				return "Kree'arra";
			case "bando":
			case "bandos":
			case "graardor":
				return "General Graardor";

			// dks
			case "supreme":
				return "Dagannoth Supreme";
			case "rex":
				return "Dagannoth Rex";
			case "prime":
				return "Dagannoth Prime";

			case "wt":
				return "Wintertodt";
			case "barrows":
				return "Barrows Chests";
			case "herbi":
				return "Herbiboar";

			// cox
			case "cox":
			case "xeric":
			case "chambers":
			case "olm":
			case "raids":
				return "Chambers of Xeric";

			// cox cm
			case "cox cm":
			case "xeric cm":
			case "chambers cm":
			case "olm cm":
			case "raids cm":
			case "chambers of xeric - challenge mode":
				return "Chambers of Xeric Challenge Mode";

			// tob
			case "tob":
			case "theatre":
			case "verzik":
			case "verzik vitur":
			case "raids 2":
				return "Theatre of Blood";

			// agility course
			case "prif":
			case "prifddinas":
				return "Prifddinas Agility Course";

			// The Gauntlet
			case "gaunt":
			case "gauntlet":
			case "the gauntlet":
				return "Gauntlet";

			// Corrupted Gauntlet
			case "cgaunt":
			case "cgauntlet":
			case "the corrupted gauntlet":
				return "Corrupted Gauntlet";

			case "nm":
			case "tnm":
			case "nmare":
			case "the nightmare":
				return "Nightmare";

			// Hallowed Sepulchre
			case "hs":
			case "sepulchre":
			case "ghc":
				return "Hallowed Sepulchre";
			case "hs1":
			case "hs 1":
				return "Hallowed Sepulchre Floor 1";
			case "hs2":
			case "hs 2":
				return "Hallowed Sepulchre Floor 2";
			case "hs3":
			case "hs 3":
				return "Hallowed Sepulchre Floor 3";
			case "hs4":
			case "hs 4":
				return "Hallowed Sepulchre Floor 4";
			case "hs5":
			case "hs 5":
				return "Hallowed Sepulchre Floor 5";

			// Ape Atoll Agility
			case "aa":
			case "ape atoll":
				return "Ape Atoll Agility";

			// Draynor Village Rooftop Course
			case "draynor":
			case "draynor agility":
				return "Draynor Village Rooftop";

			// Al-Kharid Rooftop Course
			case "al kharid":
			case "al kharid agility":
			case "al-kharid":
			case "al-kharid agility":
			case "alkharid":
			case "alkharid agility":
				return "Al-Kharid Rooftop";

			// Varrock Rooftop Course
			case "varrock":
			case "varrock agility":
				return "Varrock Rooftop";

			// Canifis Rooftop Course
			case "canifis":
			case "canifis agility":
				return "Canifis Rooftop";

			// Falador Rooftop Course
			case "fally":
			case "fally agility":
			case "falador":
			case "falador agility":
				return "Falador Rooftop";

			// Seers' Village Rooftop Course
			case "seers":
			case "seers agility":
			case "seers village":
			case "seers village agility":
			case "seers'":
			case "seers' agility":
			case "seers' village":
			case "seers' village agility":
			case "seer's":
			case "seer's agility":
			case "seer's village":
			case "seer's village agility":
				return "Seers' Village Rooftop";

			// Pollnivneach Rooftop Course
			case "pollnivneach":
			case "pollnivneach agility":
				return "Pollnivneach Rooftop";

			// Rellekka Rooftop Course
			case "rellekka":
			case "rellekka agility":
				return "Rellekka Rooftop";

			// Ardougne Rooftop Course
			case "ardy":
			case "ardy agility":
			case "ardy rooftop":
			case "ardougne":
			case "ardougne agility":
				return "Ardougne Rooftop";

			// Agility Pyramid
			case "ap":
			case "pyramid":
				return "Agility Pyramid";

			// Barbarian Outpost
			case "barb":
			case "barb outpost":
				return "Barbarian Outpost";

			// Brimhaven Agility Arena
			case "brimhaven":
			case "brimhaven agility":
				return "Agility Arena";

			// Dorgesh-Kaan Agility Course
			case "dorg":
			case "dorgesh kaan":
			case "dorgesh-kaan":
				return "Dorgesh-Kaan Agility";

			// Gnome Stronghold Agility Course
			case "gnome stronghold":
				return "Gnome Stronghold Agility";

			// Penguin Agility
			case "penguin":
				return "Penguin Agility";

			// Werewolf Agility
			case "werewolf":
				return "Werewolf Agility";

			// Skullball
			case "skullball":
				return "Werewolf Skullball";

			// Wilderness Agility Course
			case "wildy":
			case "wildy agility":
				return "Wilderness Agility";

			// Jad challenge
			case "jad 1":
				return "TzHaar-Ket-Rak's First Challenge";
			case "jad 2":
				return "TzHaar-Ket-Rak's Second Challenge";
			case "jad 3":
				return "TzHaar-Ket-Rak's Third Challenge";
			case "jad 4":
				return "TzHaar-Ket-Rak's Fourth Challenge";
			case "jad 5":
				return "TzHaar-Ket-Rak's Fifth Challenge";
			case "jad 6":
				return "TzHaar-Ket-Rak's Sixth Challenge";

			default:
				return WordUtils.capitalize(boss);
		}
	}
}
