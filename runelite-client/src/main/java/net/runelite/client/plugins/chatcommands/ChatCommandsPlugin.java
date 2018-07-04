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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.SetMessage;
import net.runelite.api.vars.AccountType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

@PluginDescriptor(
	name = "Chat Commands",
	description = "Enable chat commands",
	tags = {"grand", "exchange", "level", "prices"}
)
@Slf4j
public class ChatCommandsPlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final Pattern KILLCOUNT_PATERN = Pattern.compile("Your ([a-zA-Z ]+) kill count is: <col=ff0000>(\\d+)</col>.");
	private static final Pattern WINTERTODT_PATERN = Pattern.compile("Your subdued Wintertodt count is: <col=ff0000>(\\d+)</col>.");

	private final HiscoreClient hiscoreClient = new HiscoreClient();

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
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ChatKeyboardListener chatKeyboardListener;

	@Override
	public void startUp()
	{
		keyManager.registerKeyListener(chatKeyboardListener);
	}

	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(chatKeyboardListener);
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

	/**
	 * Checks if the chat message is a command.
	 *
	 * @param setMessage The chat message.
	 */
	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		switch (setMessage.getType())
		{
			case PUBLIC:
			case CLANCHAT:
			case PRIVATE_MESSAGE_RECEIVED:
			case PRIVATE_MESSAGE_SENT:
				break;
			default:
				return;
		}

		String message = setMessage.getValue();
		MessageNode messageNode = setMessage.getMessageNode();

		// clear RuneLite formatted message as the message node is
		// being reused
		messageNode.setRuneLiteFormatMessage(null);

		if (config.lvl() && message.toLowerCase().equals("!total"))
		{
			log.debug("Running total level lookup");
			executor.submit(() -> playerSkillLookup(setMessage, "total"));
		}
		else if (config.price() && message.toLowerCase().startsWith("!price") && message.length() > 7)
		{
			String search = message.substring(7);

			log.debug("Running price lookup for {}", search);
			executor.submit(() -> itemPriceLookup(setMessage.getMessageNode(), search));
		}
		else if (config.lvl() && message.toLowerCase().startsWith("!lvl") && message.length() > 5)
		{
			String search = message.substring(5);

			log.debug("Running level lookup for {}", search);
			executor.submit(() -> playerSkillLookup(setMessage, search));
		}
		else if (config.clue() && message.toLowerCase().equals("!clues"))
		{
			log.debug("Running lookup for overall clues");
			executor.submit(() -> playerClueLookup(setMessage, "total"));
		}
		else if (config.clue() && message.toLowerCase().startsWith("!clues") && message.length() > 7)
		{
			String search = message.substring(7);

			log.debug("Running clue lookup for {}", search);
			executor.submit(() -> playerClueLookup(setMessage, search));
		}
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
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * response.
	 *
	 * @param messageNode The chat message containing the command.
	 * @param search The item given with the command.
	 */
	private void itemPriceLookup(MessageNode messageNode, String search)
	{
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
			ItemPrice itemPrice = itemManager.getItemPrice(itemId);

			final ChatMessageBuilder builder = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT)
				.append(item.getName())
				.append(ChatColorType.NORMAL)
				.append(": GE average ")
				.append(ChatColorType.HIGHLIGHT)
				.append(StackFormatter.formatNumber(itemPrice.getPrice()));

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
	 * @param search The item given with the command.
	 */
	private void playerSkillLookup(SetMessage setMessage, String search)
	{
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

	/**
	 * Looks up the quantities of clues completed
	 * for the requested clue-level (no arg if requesting total)
	 * easy, medium, hard, elite, master
	 */
	private void playerClueLookup(SetMessage setMessage, String search)
	{
		final HiscoreLookup lookup = getCorrectLookupFor(setMessage);

		try
		{
			final Skill hiscoreSkill;
			final HiscoreResult result = hiscoreClient.lookup(lookup.getName(), lookup.getEndpoint());
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
			ironmanStatus = getHiscoreEndpointType();
		}
		else
		{
			player = sanitize(setMessage.getName());

			if (player.equals(client.getLocalPlayer().getName()))
			{
				// Get ironman status from for the local player
				ironmanStatus = getHiscoreEndpointType();
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
	 * Returns the item if its name is equal to the original input or null
	 * if it can't find the item.
	 *
	 * @param items List of items.
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
	 * @return hiscore endpoint
	 */
	private HiscoreEndpoint getHiscoreEndpointType()
	{
		return toEndPoint(client.getAccountType());
	}

	/**
	 * Returns the ironman status based on the symbol in the name of the player.
	 * @param name player name
	 * @return hiscore endpoint
	 */
	private static HiscoreEndpoint getHiscoreEndpointByName(final String name)
	{
		if (name.contains("<img=2>"))
		{
			return toEndPoint(AccountType.IRONMAN);
		}
		else if (name.contains("<img=3>"))
		{
			return toEndPoint(AccountType.ULTIMATE_IRONMAN);
		}
		else if (name.contains("<img=10>"))
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
}
