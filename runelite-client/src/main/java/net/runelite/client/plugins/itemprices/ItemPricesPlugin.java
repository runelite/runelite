/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.itemprices;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.StackFormatter;

import java.io.IOException;

@PluginDescriptor(
		name = "Item Prices",
		enabledByDefault = false
)
@Slf4j
public class ItemPricesPlugin extends Plugin
{
	@Inject
	private ItemPricesConfig config;
	@Inject
	private ItemPricesOverlay overlay;
	@Inject
	private ItemManager itemManager;
	@Inject
	private Client client;
	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private ScheduledExecutorService executor;

	private int sackValue = 0;
	private int sackHerbCount = 0;
	private int sackHerbCountLoaded = 0;

	@Provides
	ItemPricesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemPricesConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (sackValue != 0 && sackHerbCount == sackHerbCountLoaded)
		{
			client.addChatMessage(ChatMessageType.SERVER, "", "Total Herb Sack value: <col=0000ff>" + StackFormatter.formatNumber(sackValue), null);
			sackValue = 0;
			sackHerbCount = 0;
			sackHerbCountLoaded = 0;
		}
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (!config.herbSackValue())
		{
			return;
		}

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (setMessage.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		String message = setMessage.getValue();
		MessageNode messageNode = setMessage.getMessageNode();

		if (message.equals("You look in your herb sack and see:"))
		{
			sackValue = 0;
		}

		messageNode.setRuneLiteFormatMessage(null);

		if (message.toLowerCase().contains(" x grimy"))
		{
			String[] splitString = message.toLowerCase().split(" x ");
			int herbAmount = Integer.parseInt(splitString[0]);
			String herbName = splitString[1];
			sackHerbCount++;
			executor.submit(() -> herbPriceLookup(messageNode, message, herbName, herbAmount));
		}
	}

	private void herbPriceLookup(MessageNode messageNode, String message, String herbName, int herbAmount)
	{

		int price = 0;
		try
		{
			price = itemManager.getItemPrice(Herbs.getHerbs(herbName).getItemId()).getPrice();
		}
		catch (IOException e)
		{
			log.warn("unable to get herb {}", herbName);
		}
		sackHerbCountLoaded++;
		sackValue += price * herbAmount;
		messageNode.setRuneLiteFormatMessage(message + " / <col=000000>Ge Price: <col=0000ff>" + StackFormatter.formatNumber(price * herbAmount));
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

}
