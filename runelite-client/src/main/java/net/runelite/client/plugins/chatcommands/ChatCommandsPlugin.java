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

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
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
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.chat.ChatDataClient;
import net.runelite.http.api.chat.ChatDataType;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.SearchResult;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final Joiner JOINER = Joiner.on(" ").skipNulls();
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final Pattern KILLCOUNT_PATERN = Pattern.compile("Your (.+) kill count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern RAIDS_PATTERN = Pattern.compile("Your completed (.+) count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern WINTERTODT_PATERN = Pattern.compile("Your subdued Wintertodt count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern BARROWS_PATERN = Pattern.compile("Your Barrows chest count is: <col=ff0000>(\\d+)</col>.");
	private static final String TOTAL_LEVEL_COMMAND_STRING = "!total";
	private static final String PRICE_COMMAND_STRING = "!price";
	private static final String LEVEL_COMMAND_STRING = "!lvl";
	private static final String CLUES_COMMAND_STRING = "!clues";
	private static final String KILLCOUNT_COMMAND_STRING = "!kc";
	private static final String CMB_COMMAND_STRING = "!cmb";

	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private final ChatDataClient chatDataClient = new ChatDataClient();

	private boolean logKills;

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
	private KeyManager keyManager;

	@Inject
	private ChatKeyboardListener chatKeyboardListener;

	@Inject
	private ChatCommandManager commandManager;

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(chatKeyboardListener);
		setupCommands();
	}

	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(chatKeyboardListener);
		clearCommands();
	}

	@Provides
	ChatCommandsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatCommandsConfig.class);
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		if (!event.getKey().equals("chatcommands"))
		{
			return;
		}

		clearCommands();
		setupCommands();
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.SERVER && chatMessage.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String message = chatMessage.getMessage();
		Matcher matcher = KILLCOUNT_PATERN.matcher(message);
		if (matcher.find())
		{
			String boss = matcher.group(1);
			int kc = Integer.parseInt(matcher.group(2));

			setKc(boss, kc);
		}

		matcher = WINTERTODT_PATERN.matcher(message);
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

		matcher = BARROWS_PATERN.matcher(message);
		if (matcher.find())
		{
			int kc = Integer.parseInt(matcher.group(1));

			setKc("Barrows", kc);
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

	/**
	 * Remove all commands from command manager
	 */
	private void clearCommands()
	{
		commandManager.remove(TOTAL_LEVEL_COMMAND_STRING);
		commandManager.remove(LEVEL_COMMAND_STRING);
		commandManager.remove(CMB_COMMAND_STRING);
		commandManager.remove(PRICE_COMMAND_STRING);
		commandManager.remove(KILLCOUNT_COMMAND_STRING);
		commandManager.remove(CLUES_COMMAND_STRING);
	}

	/**
	 * Add all commands to command manager if they are enabled
	 */
	private void setupCommands()
	{
		if (config.lvl())
		{
			commandManager.add(ChatCommandManager.Command.builder()
				.command(TOTAL_LEVEL_COMMAND_STRING)
				.print(((data, args) -> playerSkillLookup(data, "total")))
				.build());

			commandManager.add(ChatCommandManager.Command.builder()
				.command(LEVEL_COMMAND_STRING)
				.print(((data, args) -> playerSkillLookup(data, JOINER.join(args))))
				.build());

			commandManager.add(ChatCommandManager.Command.builder()
				.command(CMB_COMMAND_STRING)
				.print(((data, args) -> combatLevelLookup(data)))
				.build());
		}

		if (config.price())
		{
			commandManager.add(ChatCommandManager.Command.builder()
				.command(PRICE_COMMAND_STRING)
				.print(((data, args) -> itemPriceLookup(data, JOINER.join(args))))
				.build());
		}

		if (config.killcount())
		{
			commandManager.add(ChatCommandManager.Command.builder()
				.command(KILLCOUNT_COMMAND_STRING)
				.block((sender, args) -> killCountBlock(sender, JOINER.join(args)))
				.print(((data, args) -> killCountLookup(data, JOINER.join(args))))
				.build());
		}

		if (config.clue())
		{
			commandManager.add(ChatCommandManager.Command.builder()
				.command(CLUES_COMMAND_STRING)
				.print(((data, args) -> playerClueLookup(data, JOINER.join(args))))
				.build());
		}
	}

	/**
	 * Blocks sending of kill count until this method completes
	 */
	private void killCountBlock(final String sender, String search)
	{
		if (Strings.isNullOrEmpty(search))
		{
			return;
		}

		search = longBossName(search);
		final int kc = getKc(search);

		if (kc <= 0)
		{
			return;
		}

		try
		{
			chatDataClient.submit(sender, ChatDataType.KILL_COUNT, search, String.valueOf(kc));
		}
		catch (Exception ex)
		{
			log.warn("unable to submit killcount", ex);
		}
	}

	/**
	 * Looks up the player kill count and updates message with response.
	 */
	private void killCountLookup(final ChatCommandManager.CommandData data, String search)
	{
		if (Strings.isNullOrEmpty(search))
		{
			return;
		}

		search = longBossName(search);

		final int kc;
		try
		{
			kc = Integer.parseInt(chatDataClient.get(data.getName(), ChatDataType.KILL_COUNT, search));
		}
		catch (NumberFormatException | IOException ex)
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
		data.getMessage().setRuneLiteFormatMessage(response);
		chatMessageManager.update(data.getMessage());
		client.refreshChat();
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * response.
	 */
	private void itemPriceLookup(final ChatCommandManager.CommandData data, String search)
	{
		if (Strings.isNullOrEmpty(search))
		{
			return;
		}

		SearchResult result;

		try
		{
			result = itemManager.searchForItem(search);
		}
		catch (ExecutionException ex)
		{
			log.warn("Unable to search for item {}", search, ex);
			return;
		}

		if (result != null && !result.getItems().isEmpty())
		{
			Item item = retrieveFromList(result.getItems(), search);
			if (item == null)
			{
				log.debug("Unable to find item {} in result {}", search, result);
				return;
			}

			int itemId = item.getId();
			int itemPrice = itemManager.getItemPrice(itemId);

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
			data.getMessage().setRuneLiteFormatMessage(response);
			chatMessageManager.update(data.getMessage());
			client.refreshChat();
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * response.
	 */
	private void playerSkillLookup(final ChatCommandManager.CommandData data, String search)
	{
		if (Strings.isNullOrEmpty(search))
		{
			return;
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

		try
		{
			final SingleHiscoreSkillResult result = hiscoreClient
				.lookup(data.getName(), skill, toEndPoint(data.getAccountType()));
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
			data.getMessage().setRuneLiteFormatMessage(response);
			chatMessageManager.update(data.getMessage());
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("unable to look up skill {} for {}", skill, search, ex);
		}
	}

	/**
	 * Lookup player's combat stats and update message.
	 */
	private void combatLevelLookup(final ChatCommandManager.CommandData data)
	{
		try
		{
			HiscoreResult playerStats = hiscoreClient.lookup(data.getName(), toEndPoint(data.getAccountType()));

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
			data.getMessage().setRuneLiteFormatMessage(response);
			chatMessageManager.update(data.getMessage());
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("Error fetching hiscore data", ex);
		}
	}

	/**
	 * Looks up the quantities of clues completed
	 * for the requested clue-level (no arg if requesting total)
	 * easy, medium, hard, elite, master
	 */
	private void playerClueLookup(final ChatCommandManager.CommandData data, String search)
	{
		if (Strings.isNullOrEmpty(search))
		{
			search = "total";
		}

		try
		{
			final Skill hiscoreSkill;
			final HiscoreResult result = hiscoreClient.lookup(data.getName(), toEndPoint(data.getAccountType()));
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
			data.getMessage().setRuneLiteFormatMessage(response);
			chatMessageManager.update(data.getMessage());
			client.refreshChat();
		}
		catch (IOException ex)
		{
			log.warn("error looking up clues", ex);
		}
	}

	/**
	 * Compares the names of the items in the list with the original input.
	 * Returns the item if its name is equal to the original input or null
	 * if it can't find the item.
	 *
	 * @param items         List of items.
	 * @param originalInput String with the original input.
	 * @return Item which has a name equal to the original input.
	 */
	private Item retrieveFromList(List<Item> items, String originalInput)
	{
		for (Item item : items)
		{
			if (item.getName().toLowerCase().equals(originalInput.toLowerCase()))
			{
				return item;
			}
		}
		return null;
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
}
