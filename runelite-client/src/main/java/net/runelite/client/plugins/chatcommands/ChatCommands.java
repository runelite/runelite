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
import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.MessageNode;
import net.runelite.api.Varbits;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.SetMessage;
import net.runelite.client.events.ResizeableChanged;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.VarbitChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PluginDescriptor(
	name = "Chat commands"
)
public class ChatCommands extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(ChatCommands.class);

	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private final String colKeyword = "<colRegular>";
	private final String colKeywordHighLight = "<colHighlight>";
	private final ItemClient itemClient = new ItemClient();
	private final HiscoreClient hiscoreClient = new HiscoreClient();
	private int transparancyVarbit = -1;

	@Inject
	@Nullable
	Client client;

	@Inject
	ChatCommandsConfig config;

	@Inject
	ItemManager itemManager;

	@Inject
	ScheduledExecutorService executor;

	@Provides
	ChatCommandsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatCommandsConfig.class);
	}

	/**
	 * Checks if the chatbox is no longer transparent and if messages need
	 * to be recolored
	 *
	 * @param event the event object
	 */
	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		if (transparancyVarbit == -1)
		{
			transparancyVarbit = client.getSetting(Varbits.TRANSPARANT_CHATBOX);
		}
		else if (transparancyVarbit != client.getSetting(Varbits.TRANSPARANT_CHATBOX))
		{
			transparancyVarbit = client.getSetting(Varbits.TRANSPARANT_CHATBOX);
			executor.submit(() -> recolorChat());
		}
	}

	@Subscribe
	public void onResizableChanged(ResizeableChanged event)
	{
		executor.submit(() -> recolorChat());
	}

	/**
	 * get the MessageNodes that have a runeltie message
	 *
	 * @return
	 */
	private Collection<MessageNode> getRuneliteMessages()
	{
		return client.getChatLineMap().values().stream()
			.filter(Objects::nonNull)
			.flatMap(clb -> Arrays.stream(clb.getLines()))
			.filter(Objects::nonNull)
			.filter(mn -> mn.getRuneLiteFormatMessage() != null)
			.collect(Collectors.toList());
	}

	/**
	 * Updates the ingame recolored messages to the new config recolorChat
	 * cannot color messages without color tags because it won't know what
	 * to replace.
	 *
	 * @param event the event object
	 */
	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		executor.submit(() -> recolorChat());
	}

	/**
	 * Checks if the chat message is a command.
	 *
	 * @param setMessage The chat message
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

		// clear runelite formatted messsage as the message node is
		// being reused
		messageNode.setRuneLiteFormatMessage(null);

		if (config.lvl() && message.toLowerCase().equals("!total"))
		{
			logger.debug("Running total level lookup");
			executor.submit(() -> playerSkillLookup(setMessage.getType(), setMessage, "total"));
		}
		else if (config.price() && message.toLowerCase().startsWith("!price") && message.length() > 7)
		{
			String search = message.substring(7);

			logger.debug("Running price lookup for {}", search);

			executor.submit(() -> lookup(setMessage.getType(), setMessage.getMessageNode(), search));
		}
		else if (config.lvl() && message.toLowerCase().startsWith("!lvl") && message.length() > 5)
		{
			String search = message.substring(5);

			logger.debug("Running level lookup for {}", search);
			executor.submit(() -> playerSkillLookup(setMessage.getType(), setMessage, search));
		}
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * reponse.
	 *
	 * @param messageNode The chat message containing the command.
	 * @param search The item given with the command.
	 */
	private void lookup(ChatMessageType type, MessageNode messageNode, String search)
	{
		SearchResult result;

		try
		{
			result = itemClient.search(search);
		}
		catch (IOException ex)
		{
			logger.warn("Unable to search for item {}", search, ex);
			return;
		}

		if (result != null && !result.getItems().isEmpty())
		{
			Item item = retrieveFromList(result.getItems(), search);
			if (item == null)
			{
				logger.debug("Unable to find item {} in result {}", search, result);
				return;
			}

			int itemId = item.getId();
			ItemPrice itemPrice;

			try
			{
				itemPrice = itemManager.getItemPrice(itemId);
			}
			catch (IOException ex)
			{
				logger.warn("Unable to fetch item price for {}", itemId, ex);
				return;
			}

			StringBuilder builder = new StringBuilder();
			builder.append(colKeyword).append("Price of ")
				.append(colKeywordHighLight).append(item.getName())
				.append(colKeyword).append(": GE average ")
				.append(colKeywordHighLight).append(String.format("%,d", itemPrice.getPrice()));

			ItemComposition itemComposition = client.getItemDefinition(itemId);
			if (itemComposition != null)
			{
				int alchPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);
				builder.append(colKeyword).append(" HA value ")
					.append(colKeywordHighLight).append(String.format("%,d", alchPrice));
			}

			String response = builder.toString();

			logger.debug("Setting response {}", response);

			// XXX hopefully messageNode hasn't been reused yet?
			messageNode.setRuneLiteFormatMessage(response);
			messageNode.setValue(recolorMessage(messageNode.getType(), response));
			client.refreshChat();
		}
	}

	/**
	 * Looks up the player skill and changes the original message to the
	 * reponse.
	 *
	 * @param setMessage The chat message containing the command.
	 * @param search The item given with the command.
	 */
	private void playerSkillLookup(ChatMessageType type, SetMessage setMessage, String search)
	{
		String player;
		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			player = client.getLocalPlayer().getName();
		}
		else
		{
			player = sanitize(setMessage.getName());
		}
		try
		{
			search = SkillAbbreviations.valueOf(search.toUpperCase()).getName();
		}
		catch (IllegalArgumentException i)
		{
		}

		HiscoreSkill skill;
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
			SingleHiscoreSkillResult result = hiscoreClient.lookup(player, skill);
			Skill hiscoreSkill = result.getSkill();

			String response = new StringBuilder()
				.append(colKeyword).append("Level ")
				.append(colKeywordHighLight).append(skill.getName()).append(": ").append(hiscoreSkill.getLevel())
				.append(colKeyword).append(" Experience: ")
				.append(colKeywordHighLight).append(String.format("%,d", hiscoreSkill.getExperience()))
				.append(colKeyword).append(" Rank: ")
				.append(colKeywordHighLight).append(String.format("%,d", hiscoreSkill.getRank()))
				.toString();

			logger.debug("Setting response {}", response);

			// XXX hopefully messageNode hasn't been reused yet?
			setMessage.getMessageNode().setRuneLiteFormatMessage(response);
			setMessage.getMessageNode().setValue(recolorMessage(setMessage.getType(), response));
			client.refreshChat();
		}
		catch (IOException ex)
		{
			logger.warn("unable to look up skill {} for {}", skill, search, ex);
		}
	}

	/**
	 * Compares the names of the items in the list with the original input.
	 * returns the item if its name is equal to the original input or null
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

	private ChatColor getChatColor(ChatMessageType type)
	{
		if ((type == ChatMessageType.PRIVATE_MESSAGE_SENT || type == ChatMessageType.PRIVATE_MESSAGE_RECEIVED) && !config.isPrivateRecolor())
		{
			return null;
		}
		if (client.getSetting(Varbits.TRANSPARANT_CHATBOX) == 0 || !client.isResized() || !config.transparancyRecolor())
		{
			switch (type)
			{
				case PUBLIC:
					return new ChatColor(config.getPublicRecolor(), type, false, false);
				case PRIVATE_MESSAGE_RECEIVED:
				case PRIVATE_MESSAGE_SENT:
					return new ChatColor(config.getPrivateRecolor(), type, false, false);
				case CLANCHAT:
					return new ChatColor(config.getCcRecolor(), type, false, false);
			}
		}
		else
		{
			switch (type)
			{
				case PUBLIC:
					return new ChatColor(config.getTransparentPublicRecolor(), type, true, false);
				case PRIVATE_MESSAGE_RECEIVED:
				case PRIVATE_MESSAGE_SENT:
					return new ChatColor(config.getTransparentPrivateRecolor(), type, true, false);
				case CLANCHAT:
					return new ChatColor(config.getTransparentCcRecolor(), type, true, false);
			}
		}
		return null;
	}

	private ChatColor getChatColorH(ChatMessageType type)
	{
		if ((type == ChatMessageType.PRIVATE_MESSAGE_SENT || type == ChatMessageType.PRIVATE_MESSAGE_RECEIVED) && !config.isPrivateRecolor())
		{
			return null;
		}
		if (client.getSetting(Varbits.TRANSPARANT_CHATBOX) == 0 || !client.isResized() || !config.transparancyRecolor())
		{
			switch (type)
			{
				case PUBLIC:
					return new ChatColor(config.getPublicHRecolor(), type, false, true);
				case PRIVATE_MESSAGE_RECEIVED:
				case PRIVATE_MESSAGE_SENT:
					return new ChatColor(config.getPrivateHRecolor(), type, false, true);
				case CLANCHAT:
					return new ChatColor(config.getCcHRecolor(), type, false, true);
			}
		}
		else
		{
			switch (type)
			{
				case PUBLIC:
					return new ChatColor(config.getTransparentPublicHRecolor(), type, true, true);
				case PRIVATE_MESSAGE_RECEIVED:
				case PRIVATE_MESSAGE_SENT:
					return new ChatColor(config.getTransparentPrivateHRecolor(), type, true, true);
				case CLANCHAT:
					return new ChatColor(config.getTransparentCcHRecolor(), type, true, true);
			}
		}
		return null;
	}

	private String recolorMessage(ChatMessageType type, String value)
	{
		ChatColor chatcolor = getChatColor(type);
		ChatColor chatColorH = getChatColorH(type);
		if (config.recolorEnabled() && chatcolor != null && chatColorH != null)
		{
			value = value.replace(colKeyword, getColTag(chatcolor.color))
				.replace(colKeywordHighLight, getColTag(chatColorH.color));
		}
		else
		{
			value = value.replace(colKeyword, "")
				.replace(colKeywordHighLight, "");
		}
		return value;
	}

	private void recolorChat()
	{
		Collection<MessageNode> nodes = getRuneliteMessages();
		for (MessageNode message : nodes)
		{
			message.setValue(recolorMessage(message.getType(), message.getRuneLiteFormatMessage()));
		}
		client.refreshChat();
	}

	public static String getColTag(Color color)
	{
		return color == null ? "" : "<col=" + Integer.toHexString(color.getRGB() & 0xFFFFFF) + ">";
	}

	/**
	 * Cleans the playername string from ironman status icon if present and
	 * corrects spaces
	 *
	 * @param lookup Playername to lookup
	 * @return Cleaned playername
	 */
	private static String sanitize(String lookup)
	{
		String cleaned = lookup.contains("<img") ? lookup.substring(lookup.lastIndexOf('>') + 1) : lookup;
		return cleaned.replace('\u00A0', ' ');
	}
}
