/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.coalbag;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(name = "Coal Bag")
public class CoalBagPlugin extends Plugin
{
	private static final Pattern COAL_BAG_FILL_MESSAGE = Pattern.compile("The coal bag (still )?contains (.*) piece(s)? of coal\\.");
	private static final Pattern COAL_BAG_EMPTY_MESSAGE = Pattern.compile("The coal bag is (now )?empty.");

	@Getter
	private int amount = -1;

	public void setAmount(int amount)
	{
		this.amount = amount;
		config.amount(amount);
	}

	@Inject
	Client client;

	@Inject
	private CoalBagOverlay overlay;

	@Inject
	private CoalBagConfig config;

	@Provides
	CoalBagConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoalBagConfig.class);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case HOPPING:
			case LOGGING_IN:
			case LOGGED_IN:
				if (config.amount() != -1)
				{
					setAmount(config.amount());
				}
				break;
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Widget NPCDialog = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (NPCDialog != null)
		{
			String NPCText = Text.removeTags(NPCDialog.getText()); //remove color and linebreaks
			Matcher mEmpty = COAL_BAG_EMPTY_MESSAGE.matcher(NPCText); //empty
			boolean foundEmpty = mEmpty.find();
			if (foundEmpty)
			{
				setAmount(0);
				return;
			}

			Matcher mCoalAmount = COAL_BAG_FILL_MESSAGE.matcher(NPCText); //number
			boolean found = mCoalAmount.find();
			if (!found)
			{
				return;
			}

			String amount = mCoalAmount.group(2).toLowerCase();
			if (amount.equals("one"))
			{
				setAmount(1);
				return;
			}

			setAmount(Integer.parseInt(mCoalAmount.group(2)));
		}
	}


	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks
		Matcher mEmpty = COAL_BAG_EMPTY_MESSAGE.matcher(chatMsg); //empty
		boolean foundEmpty = mEmpty.find();
		if (foundEmpty)
		{
			setAmount(0);
		}
	}
}
