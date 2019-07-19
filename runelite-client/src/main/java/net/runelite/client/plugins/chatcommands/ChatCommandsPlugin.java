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

import com.google.inject.Provides;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.IconID;
import net.runelite.api.ItemDefinition;
import net.runelite.api.MessageNode;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.KILL_LOGS_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import static net.runelite.client.util.Text.sanitize;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.chat.Duels;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.osbuddy.OSBGrandExchangeClient;
import org.apache.commons.text.WordUtils;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Singleton
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final Pattern KILLCOUNT_PATTERN = Pattern.compile("Your (.+) (?:kill|harvest) count is: <col=ff0000>(\\d+)</col>");
	private static final Pattern RAIDS_PATTERN = Pattern.compile("Your completed (.+) count is: <col=ff0000>(\\d+)</col>");
	private static final Pattern WINTERTODT_PATTERN = Pattern.compile("Your subdued Wintertodt count is: <col=ff0000>(\\d+)</col>");
	private static final Pattern BARROWS_PATTERN = Pattern.compile("Your Barrows chest count is: <col=ff0000>(\\d+)</col>");
	private static final Pattern KILL_DURATION_PATTERN = Pattern.compile("Fight duration: <col=ff0000>[0-9:]+</col>. Personal best: ([0-9:]+)");
	private static final Pattern NEW_PB_PATTERN = Pattern.compile("Fight duration: <col=ff0000>([0-9:]+)</col> \\(new personal best\\)");
	private static final Pattern DUEL_ARENA_WINS_PATTERN = Pattern.compile("You (were defeated|won)! You have(?: now)? won (\\d+) duels?");
	private static final Pattern DUEL_ARENA_LOSSES_PATTERN = Pattern.compile("You have(?: now)? lost (\\d+) duels?");
	private static final String TOTAL_LEVEL_COMMAND_STRING = "!total";
	private static final String PRICE_COMMAND_STRING = "!price";
	private static final String LEVEL_COMMAND_STRING = "!lvl";
	private static final String CLUES_COMMAND_STRING = "!clues";
	private static final String KILLCOUNT_COMMAND_STRING = "!kc";
	private static final String CMB_COMMAND_STRING = "!cmb";
	private static final String QP_COMMAND_STRING = "!qp";
	private static final String GC_COMMAND_STRING = "!gc";
	private static final String PB_COMMAND = "!pb";
	private static final String DUEL_ARENA_COMMAND = "!duels";

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final ChatClient chatClient = new ChatClient();
	private final OSBGrandExchangeClient CLIENT = new OSBGrandExchangeClient();

	private boolean logKills;
	private HiscoreEndpoint hiscoreEndpoint; // hiscore endpoint for current player
	private String lastBossKill;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

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
	private EventBus eventBus;

	@Override
	public void startUp()
	{
		addSubscriptions();

		keyManager.registerKeyListener(chatKeyboardListener);

		chatCommandManager.registerCommandAsync(TOTAL_LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CMB_COMMAND_STRING, this::combatLevelLookup);
		chatCommandManager.registerCommand(PRICE_COMMAND_STRING, this::itemPriceLookup);
		chatCommandManager.registerCommandAsync(LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CLUES_COMMAND_STRING, this::clueLookup);
		chatCommandManager.registerCommandAsync(KILLCOUNT_COMMAND_STRING, this::killCountLookup, this::killCountSubmit);
		chatCommandManager.registerCommandAsync(QP_COMMAND_STRING, this::questPointsLookup, this::questPointsSubmit);
		chatCommandManager.registerCommandAsync(GC_COMMAND_STRING, this::gambleCountLookup, this::gambleCountSubmit);
		chatCommandManager.registerCommandAsync(PB_COMMAND, this::personalBestLookup, this::personalBestSubmit);
		chatCommandManager.registerCommandAsync(DUEL_ARENA_COMMAND, this::duelArenaLookup, this::duelArenaSubmit);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		lastBossKill = null;

		keyManager.unregisterKeyListener(chatKeyboardListener);

		chatCommandManager.unregisterCommand(TOTAL_LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CMB_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PRICE_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CLUES_COMMAND_STRING);
		chatCommandManager.unregisterCommand(KILLCOUNT_COMMAND_STRING);
		chatCommandManager.unregisterCommand(QP_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PB_COMMAND);
		chatCommandManager.unregisterCommand(GC_COMMAND_STRING);
		chatCommandManager.unregisterCommand(DUEL_ARENA_COMMAND);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
	}

	@Provides
	ChatCommandsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatCommandsConfig.class);
	}

	private void setKc(String boss, int killcount)
	{
		configManager.setConfiguration("killcount." + client.getUsername().toLowerCase(),
			boss.toLowerCase(), killcount);
	}

	private int getKc(String boss)
	{
		Integer killCount = configManager.getConfiguration("killcount." + client.getUsername().toLowerCase(),
			boss.toLowerCase(), int.class);
		return killCount == null ? 0 : killCount;
	}

	private void setPb(String boss, int seconds)
	{
		configManager.setConfiguration("personalbest." + client.getUsername().toLowerCase(),
			boss.toLowerCase(), seconds);
	}

	private int getPb(String boss)
	{
		Integer personalBest = configManager.getConfiguration("personalbest." + client.getUsername().toLowerCase(),
			boss.toLowerCase(), int.class);
		return personalBest == null ? 0 : personalBest;
	}

	void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.TRADE
			&& chatMessage.getType() != ChatMessageType.GAMEMESSAGE
			&& chatMessage.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String message = chatMessage.getMessage();
		Matcher matcher = KILLCOUNT_PATTERN.matcher(message);
		if (matcher.find())
		{
			String boss = matcher.group(1);
			int kc = Integer.parseInt(matcher.group(2));

			setKc(boss, kc);
			lastBossKill = boss;
			return;
		}

		matcher = WINTERTODT_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1));

			setKc("Wintertodt", kc);
		}

		matcher = RAIDS_PATTERN.matcher(message);
		if (matcher.find())
		{
			String boss = matcher.group(1);
			int kc = Integer.parseInt(matcher.group(2));

			setKc(boss, kc);
			lastBossKill = boss;
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

		matcher = BARROWS_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1));

			setKc("Barrows Chests", kc);
		}

		if (lastBossKill != null)
		{
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
		}

		lastBossKill = null;
	}

	private void matchPb(Matcher matcher)
	{
		String personalBest = matcher.group(1);
		String[] s = personalBest.split(":");
		if (s.length == 2)
		{
			int seconds = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
			log.debug("Got personal best for {}: {}", lastBossKill, seconds);
			setPb(lastBossKill, seconds);
		}
	}

	private void onGameTick(GameTick event)
	{
		if (!logKills)
		{
			return;
		}

		logKills = false;

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
			if (kc != getKc(bossName))
			{
				setKc(bossName, kc);
			}
		}
	}

	private void onWidgetLoaded(WidgetLoaded widget)
	{
		// don't load kc if in an instance, if the player is in another players poh
		// and reading their boss log
		if (widget.getGroupId() != KILL_LOGS_GROUP_ID || client.isInInstancedRegion())
		{
			return;
		}

		logKills = true;
	}

	private void onVarbitChanged(VarbitChanged varbitChanged)
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
			player = sanitize(chatMessage.getName());
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
			.append(Integer.toString(kc))
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
			player = sanitize(chatMessage.getName());
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
			.append(Integer.toString(wins))
			.append(ChatColorType.NORMAL)
			.append("   losses: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(losses))
			.append(ChatColorType.NORMAL)
			.append("   streak: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString((winningStreak != 0 ? winningStreak : -losingStreak)))
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
			player = sanitize(chatMessage.getName());
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

	private void gambleCountLookup(ChatMessage chatMessage, String message)
	{
		if (!config.gc())
		{
			return;
		}

		ChatMessageType type = chatMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATECHAT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(chatMessage.getName());
		}

		int gc;
		try
		{
			gc = chatClient.getGc(player);
			log.info("gc lookup");
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup gamble count", ex);
			log.info("gc lookup error");
			return;
		}

		String response = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Barbarian Assault High-level gambles: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(Integer.toString(gc))
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
			player = sanitize(chatMessage.getName());
		}

		search = longBossName(search);

		final int pb;
		try
		{
			pb = chatClient.getPb(player, search);
		}
		catch (IOException ex)
		{
			log.debug("unable to lookup personal best", ex);
			return;
		}

		int minutes = pb / 60;
		int seconds = pb % 60;

		String response = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(search)
			.append(ChatColorType.NORMAL)
			.append(" personal best: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(String.format("%d:%02d", minutes, seconds))
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

		final int pb = getPb(boss);
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

	/**
	 * Looks up the item price and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message     The chat message
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
			CLIENT.lookupItem(item.getId())
				.subscribeOn(Schedulers.single())
				.subscribe(
					(osbresult) ->
						clientThread.invoke(() ->
						{
							int itemId = item.getId();
							int itemPrice = itemManager.getItemPrice(itemId);

							final ChatMessageBuilder builder = new ChatMessageBuilder();
							builder.append(ChatColorType.NORMAL);
							builder.append(ChatColorType.HIGHLIGHT);
							builder.append(item.getName());
							builder.append(ChatColorType.NORMAL);
							builder.append(": GE ");
							builder.append(ChatColorType.HIGHLIGHT);
							builder.append(StackFormatter.formatNumber(itemPrice));
							builder.append(ChatColorType.NORMAL);
							builder.append(": OSB ");
							builder.append(ChatColorType.HIGHLIGHT);
							builder.append(StackFormatter.formatNumber(osbresult.getOverall_average()));

							ItemDefinition itemComposition = itemManager.getItemDefinition(itemId);
							if (itemComposition != null)
							{
								int alchPrice = itemManager.getAlchValue(itemId);
								builder
									.append(ChatColorType.NORMAL)
									.append(" HA value ")
									.append(ChatColorType.HIGHLIGHT)
									.append(StackFormatter.formatNumber(alchPrice));
							}

							String response = builder.build();

							log.debug("Setting response {}", response);
							messageNode.setRuneLiteFormatMessage(response);
							chatMessageManager.update(messageNode);
							client.refreshChat();
						})
				);
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * response.
	 *
	 * @param chatMessage The chat message containing the command.
	 * @param message     The chat message
	 */
	private void playerSkillLookup(ChatMessage chatMessage, String message)
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

			final String response = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Level ")
				.append(ChatColorType.HIGHLIGHT)
				.append(skill.getName()).append(": ").append(String.valueOf(hiscoreSkill.getLevel()))
				.append(ChatColorType.NORMAL)
				.append(" Experience: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", hiscoreSkill.getExperience()))
				.append(ChatColorType.NORMAL)
				.append(" Rank: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.format("%,d", hiscoreSkill.getRank()))
				.build();

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
			player = sanitize(chatMessage.getName());
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
				.append(Integer.toString(quantity));

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
		final String player;
		final HiscoreEndpoint ironmanStatus;

		if (chatMessage.getType().equals(ChatMessageType.PRIVATECHATOUT))
		{
			player = client.getLocalPlayer().getName();
			ironmanStatus = hiscoreEndpoint;
		}
		else
		{
			player = sanitize(chatMessage.getName());

			if (player.equals(client.getLocalPlayer().getName()))
			{
				// Get ironman status from for the local player
				ironmanStatus = hiscoreEndpoint;
			}
			else
			{
				// Get ironman status from their icon in chat
				ironmanStatus = getHiscoreEndpointByName(chatMessage.getName());
			}
		}

		return new HiscoreLookup(player, ironmanStatus);
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
			if (item.getName().equalsIgnoreCase(originalInput.toLowerCase()))
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
			return toEndPoint(AccountType.IRONMAN);
		}
		else if (name.contains(IconID.ULTIMATE_IRONMAN.toString()))
		{
			return toEndPoint(AccountType.ULTIMATE_IRONMAN);
		}
		else if (name.contains(IconID.HARDCORE_IRONMAN.toString()))
		{
			return toEndPoint(AccountType.HARDCORE_IRONMAN);
		}
		else
		{
			return toEndPoint(AccountType.NORMAL);
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
				return "Chambers of Xeric Challenge Mode";

			// tob
			case "tob":
			case "theatre":
			case "verzik":
			case "verzik vitur":
			case "raids 2":
				return "Theatre of Blood";

			default:
				return WordUtils.capitalize(boss);
		}
	}
}