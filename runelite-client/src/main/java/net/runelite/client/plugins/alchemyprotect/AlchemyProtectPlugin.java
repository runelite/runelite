/*
 * Copyright (c) 2019, Marcel Bostelaar <https://github.com/MarcelBostelaar>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.alchemyprotect;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatcher;
import javax.inject.Inject;
import java.util.List;

@PluginDescriptor(
		name = "Alchemy Protect",
		description = "Protects chosen items against alchemy",
		tags = {"high", "low", "alchemy", "protect", "alch"}
)
public class AlchemyProtectPlugin extends Plugin
{

	private List<String> protectedItems;

	@Inject
	private AlchemyProtectConfig config;
	@Inject
	private ChatMessageManager chatMessageManager;

	@Provides
	AlchemyProtectConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AlchemyProtectConfig.class);
	}

	@Override
	protected void startUp()
	{
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
	}


	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		reset();
	}

	private void reset()
	{
		protectedItems = Text.fromCSV(config.protecteditems());
	}

	private Boolean ItemIsMatch(String itemname)
	{
		if (Strings.isNullOrEmpty(itemname))
		{
			return false;
		}

		final String filteredName = itemname.trim();

		for (final String filter : protectedItems)
		{
			if (WildcardMatcher.matches(filter, filteredName))
			{
				return true;
			}
		}
		return false;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		String Alched_Item = GetTargetItemName(event);
		if (Alched_Item == null)
		{
			return;
		}

		if (ItemIsMatch(Alched_Item))
		{
			event.consume();
			ChatMessageBuilder message = new ChatMessageBuilder()
					.append("Alchemy Protect has prevented ")
					.append(ChatColorType.HIGHLIGHT)
					.append("\"" + Alched_Item + "\"")
					.append(ChatColorType.NORMAL)
					.append(" from being alched.");
			chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAME)
					.runeLiteFormattedMessage(message.build())
					.build());
		}
	}

	private String ExplorersRingGetAlchemyTargetItemName(MenuOptionClicked i)
	{
		if (i.getMenuOption().contains("Alchemy"))
		{
			return Text.removeTags(i.getMenuTarget());
		}
		return null;
	}

	private String RegularGetAlchemyTargetItemName(MenuOptionClicked i)
	{
		if (i.getMenuOption().equals("Cast"))
		{
			String menutarget = i.getMenuTarget();
			if (menutarget.contains("Level Alchemy"))
			{
				String targetitem = menutarget.split(" -> ")[1];
				return Text.removeTags((targetitem));
			}
		}
		return null;
	}

	private String GetTargetItemName(MenuOptionClicked i)
	{
		String ExplorersRing = ExplorersRingGetAlchemyTargetItemName(i);
		String RegularSpell = RegularGetAlchemyTargetItemName(i);
		if (ExplorersRing != null)
		{
			return ExplorersRing;
		}
		if (RegularSpell != null)
		{
			return RegularSpell;
		}
		return null;
	}
}