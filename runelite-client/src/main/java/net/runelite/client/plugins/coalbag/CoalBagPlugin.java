/*
 * Copyright (c) 2018, Anthony <cvballa3g0@gmail.com>
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
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(
		name = "Coal Bag",
		description = "Show the coal count of your Coal Bag",
		tags = {"coalbag", "coal", "bag", "bf", "blastfurnce", "mlm", "motherloadmine", "mining", "smithing"}
)
public class CoalBagPlugin extends Plugin
{
	private static final Pattern COAL_BAG_EMPTY_MESSAGE = Pattern.compile("^The coal bag is (now )?empty\\.$");
	private static final Pattern COAL_BAG_ONE_MESSAGE = Pattern.compile("^The coal bag contains one piece of coal\\.$");
	private static final Pattern COAL_BAG_AMOUNT_MESSAGE = Pattern.compile("^The coal bag contains (\\d+) pieces of coal\\.$");

	static final int MAX_INVY_SPACE = 28;
	private static final int FULL_BAG_AMOUNT = 27;

	static final String FILL_OPTION = "fill";
	static final String EMPTY_OPTION = "empty";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CoalBagOverlay overlay;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private CoalBagConfig config;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Provides
	CoalBagConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoalBagConfig.class);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() != WidgetInfo.INVENTORY.getId())
		{
			return;
		}

		switch (event.getMenuOption().toLowerCase())
		{
			case FILL_OPTION:
				update(queryRunner.runQuery(new InventoryWidgetItemQuery().idEquals(ItemID.COAL)).length);
				break;
			case EMPTY_OPTION:
				int amt = MAX_INVY_SPACE - queryRunner.runQuery(new InventoryWidgetItemQuery()).length;
				update(-amt);
				break;
		}
	}

	/**
	 * Use onChatMessage when a player chooses the `Check` menu option.
	 *
	 * @param event
	 */
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks
		if (COAL_BAG_EMPTY_MESSAGE.matcher(chatMsg).find())
		{
			update(-getAmount());
		}
		else if (COAL_BAG_ONE_MESSAGE.matcher(chatMsg).find())
		{
			update(-getAmount() + 1);
		}
		else
		{
			Matcher matcher = COAL_BAG_AMOUNT_MESSAGE.matcher(chatMsg);
			if (matcher.find())
			{
				update(Integer.parseInt(matcher.group(1)) - getAmount());
			}
		}
	}

	/**
	 * Get amount of coal the player has in their Coal Bag
	 *
	 * @return
	 */
	int getAmount()
	{
		return config.amount();
	}

	/**
	 * Update the player's count of coal in their Coal Bag
	 *
	 * @param delta How much to add/subtract from the amount.
	 *              Supply a negative number to subtract, or positive number to add.
	 */
	private void update(int delta)
	{
		// check for upper/lower bounds of amount of coal in a bag
		// 0 <= X <= 27
		config.amount(Math.max(0, Math.min(FULL_BAG_AMOUNT, getAmount() + delta)));
	}
}
