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
import java.io.IOException;
import java.util.List;
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
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.KILL_LOGS_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.chat.ChatClient;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.ItemPrice;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final Pattern KILLCOUNT_PATTERN = Pattern.compile("Your (.+) kill count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern RAIDS_PATTERN = Pattern.compile("Your completed (.+) count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern WINTERTODT_PATTERN = Pattern.compile("Your subdued Wintertodt count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern BARROWS_PATTERN = Pattern.compile("Your Barrows chest count is: <col=ff0000>(\\d+)</col>.");
	private static final String TOTAL_LEVEL_COMMAND_STRING = "!total";
	private static final String PRICE_COMMAND_STRING = "!price";
	private static final String LEVEL_COMMAND_STRING = "!lvl";
	private static final String CLUES_COMMAND_STRING = "!clues";
	private static final String KILLCOUNT_COMMAND_STRING = "!kc";
	private static final String CMB_COMMAND_STRING = "!cmb";
	private static final String QP_COMMAND_STRING = "!qp";

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final ChatClient chatClient = new ChatClient();

	private boolean logKills;
	private HiscoreEndpoint hiscoreEndpoint; // hiscore endpoint for current player

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

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(chatKeyboardListener);

		chatCommandManager.registerCommandAsync(TOTAL_LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CMB_COMMAND_STRING, this::combatLevelLookup);
		chatCommandManager.registerCommand(PRICE_COMMAND_STRING, this::itemPriceLookup);
		chatCommandManager.registerCommandAsync(LEVEL_COMMAND_STRING, this::playerSkillLookup);
		chatCommandManager.registerCommandAsync(CLUES_COMMAND_STRING, this::clueLookup);
		chatCommandManager.registerCommandAsync(KILLCOUNT_COMMAND_STRING, this::killCountLookup, this::killCountSubmit);
		chatCommandManager.registerCommandAsync(QP_COMMAND_STRING, this::questPointsLookup, this::questPointsSubmit);
	}

	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(chatKeyboardListener);

		chatCommandManager.unregisterCommand(TOTAL_LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CMB_COMMAND_STRING);
		chatCommandManager.unregisterCommand(PRICE_COMMAND_STRING);
		chatCommandManager.unregisterCommand(LEVEL_COMMAND_STRING);
		chatCommandManager.unregisterCommand(CLUES_COMMAND_STRING);
		chatCommandManager.unregisterCommand(KILLCOUNT_COMMAND_STRING);
		chatCommandManager.unregisterCommand(QP_COMMAND_STRING);
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

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.SERVER && chatMessage.getType() != ChatMessageType.FILTERED)
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
		}

		matcher = BARROWS_PATTERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1));

			setKc("Barrows Chests", kc);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
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

			String bossName = boss.getText();
			int kc = Integer.parseInt(kill.getText().replace(",", ""));
			if (kc != getKc(bossName))
			{
				setKc(bossName, kc);
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widget)
	{
		// don't load kc if in an instance, if the player is in another players poh
		// and reading their boss log
		if (widget.getGroupId() != KILL_LOGS_GROUP_ID || client.isInInstancedRegion())
		{
			return;
		}

		logKills = true;
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

	private void killCountLookup(SetMessage setMessage, String message)
	{
		if (!config.killcount())
		{
			return;
		}

		ChatMessageType type = setMessage.getType();
		String search = message.substring(KILLCOUNT_COMMAND_STRING.length() + 1);

		final String player;
		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(setMessage.getName());
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
		final MessageNode messageNode = setMessage.getMessageNode();
		messageNode.setRuneLiteFormatMessage(response);
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private void questPointsLookup(SetMessage setMessage, String message)
	{
		if (!config.qp())
		{
			return;
		}

		ChatMessageType type = setMessage.getType();

		final String player;
		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(setMessage.getName());
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
		final MessageNode messageNode = setMessage.getMessageNode();
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
				log.warn("unable to submit quest poinits", ex);
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
	 * @param setMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	private void itemPriceLookup(SetMessage setMessage, String message)
	{
		if (!config.price())
		{
			return;
		}

		MessageNode messageNode = setMessage.getMessageNode();
		String search = message.substring(PRICE_COMMAND_STRING.length() + 1);

		List<ItemPrice> results = itemManager.search(search);

		if (!results.isEmpty())
		{
			ItemPrice item = retrieveFromList(results, search);

			int itemId = item.getId();
			int itemPrice = item.getPrice();

			final ChatMessageBuilder builder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT)
				.append(item.getName())
				.append(ChatColorType.NORMAL)
				.append(": GE average ")
				.append(ChatColorType.HIGHLIGHT)
				.append(StackFormatter.formatNumber(itemPrice));

			ItemComposition itemComposition = itemManager.getItemComposition(itemId);
			if (itemComposition != null)
			{
				int alchPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);
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
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * response.
	 *
	 * @param setMessage The chat message containing the command.
	 * @param message    The chat message
	 */
	private void playerSkillLookup(SetMessage setMessage, String message)
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

		final HiscoreLookup lookup = getCorrectLookupFor(setMessage);

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
			final MessageNode messageNode = setMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("unable to look up skill {} for {}", skill, search, ex);
		}
	}

	private void combatLevelLookup(SetMessage setMessage, String message)
	{
		if (!config.lvl())
		{
			return;
		}

		ChatMessageType type = setMessage.getType();

		String player;
		if (type == ChatMessageType.PRIVATE_MESSAGE_SENT)
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(setMessage.getName());
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
			final MessageNode messageNode = setMessage.getMessageNode();
			messageNode.setRuneLiteFormatMessage(response);
			chatMessageManager.update(messageNode);
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("Error fetching hiscore data", ex);
		}
	}

	private void clueLookup(SetMessage setMessage, String message)
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
			final HiscoreLookup lookup = getCorrectLookupFor(setMessage);
			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());

			if (result == null)
			{
				log.warn("error looking up clues: not found");
				return;
			}

			String level = search.toLowerCase();

			switch (level)
			{
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
			final MessageNode messageNode = setMessage.getMessageNode();
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
	 * @param setMessage chat message
	 * @return hiscore lookup data
	 */
	private HiscoreLookup getCorrectLookupFor(final SetMessage setMessage)
	{
		final String player;
		final HiscoreEndpoint ironmanStatus;

		if (setMessage.getType().equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			player = client.getLocalPlayer().getName();
			ironmanStatus = hiscoreEndpoint;
		}
		else
		{
			player = sanitize(setMessage.getName());

			if (player.equals(client.getLocalPlayer().getName()))
			{
				// Get ironman status from for the local player
				ironmanStatus = hiscoreEndpoint;
			}
			else
			{
				// Get ironman status from their icon in chat
				ironmanStatus = getHiscoreEndpointByName(setMessage.getName());
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
	 * Cleans the ironman status icon from playername string if present and
	 * corrects spaces.
	 *
	 * @param lookup Playername to lookup.
	 * @return Cleaned playername.
	 */
	private static String sanitize(String lookup)
	{
		String cleaned = lookup.contains("<img") ? lookup.substring(lookup.lastIndexOf('>') + 1) : lookup;
		return cleaned.replace('\u00A0', ' ');
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

			case "cox":
			case "xeric":
			case "chambers":
			case "olm":
			case "raids":
				return "Chambers of Xeric";

			case "tob":
			case "theatre":
			case "verzik":
			case "verzik vitur":
			case "raids 2":
				return "Theatre of Blood";

			default:
				return boss;
		}
	}
}
