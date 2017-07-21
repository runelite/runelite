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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.client.RuneLite;
import net.runelite.client.events.SetMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.http.api.hiscore.HiscoreClient;
import net.runelite.http.api.hiscore.HiscoreSkill;
import net.runelite.http.api.hiscore.SingleHiscoreSkillResult;
import net.runelite.http.api.hiscore.Skill;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;
import net.runelite.rs.api.ItemComposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatCommands extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(ChatCommands.class);

	private final ChatCommandsConfig config = RuneLite.getRunelite().getConfigManager().getConfig(ChatCommandsConfig.class);
	private final ItemManager itemManager = RuneLite.getRunelite().getItemManager();
	private final ItemClient itemClient = new ItemClient();
	private final RuneLite runelite = RuneLite.getRunelite();
	private final Client client = RuneLite.getClient();
	private final HiscoreClient hiscoreClient = new HiscoreClient();

	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
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

		if (config.price() && message.toLowerCase().startsWith("!price") && message.length() > 7)
		{
			String search = message.substring(7);

			logger.debug("Running price lookup for {}", search);

			ScheduledExecutorService executor = runelite.getExecutor();
			executor.submit(() -> lookup(setMessage.getMessageNode(), search));
		}
		else if (config.lvl() && message.toLowerCase().startsWith("!lvl") && message.length() > 5)
		{
			String search = message.substring(5);

			logger.debug("Running level lookup for {}", search);
			ScheduledExecutorService executor = runelite.getExecutor();
			executor.submit(() -> playerSkillLookup(setMessage, search));
		}
	}

	/**
	 * Looks up the item price and changes the original message to the
	 * reponse.
	 *
	 * @param messageNode The chat message containing the command.
	 * @param search The item given with the command.
	 */
	private void lookup(MessageNode messageNode, String search)
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
			builder.append("Price of ").append(item.getName()).append(": GE average ").append(String.format("%,d", itemPrice.getPrice()));

			ItemComposition itemComposition = client.getItemDefinition(itemId);
			if (itemComposition != null)
			{
				int alchPrice = Math.round(itemComposition.getPrice() * HIGH_ALCHEMY_CONSTANT);
				builder.append(" HA value ").append(alchPrice);
			}

			logger.debug("Setting response {}", builder.toString());

			// XXX hopefully messageNode hasn't been reused yet?
			messageNode.setValue(builder.toString());
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
	private void playerSkillLookup(SetMessage setMessage, String search)
	{
		String player = sanitize(setMessage.getName());

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

			String response = new StringBuilder().append("Level ").append(skill.getName()).append(": ")
				.append(hiscoreSkill.getLevel())
				.append(" Experience: ").append(String.format("%,d", hiscoreSkill.getExperience()))
				.append(" Rank: ").append(String.format("%,d", hiscoreSkill.getRank()))
				.toString();

			logger.debug("Setting response {}", response);

			// XXX hopefully messageNode hasn't been reused yet?
			setMessage.getMessageNode().setValue(response);
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
