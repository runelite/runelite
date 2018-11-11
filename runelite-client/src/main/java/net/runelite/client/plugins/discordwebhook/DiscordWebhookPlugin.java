/*
 * Copyright (c) 2018, Forsco <https://github.com/forsco>
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

package net.runelite.client.plugins.discordwebhook;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.NPC;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.vars.AccountType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.discord.DiscordClient;
import net.runelite.http.api.discord.DiscordEmbed;
import net.runelite.http.api.discord.DiscordMessage;
import net.runelite.http.api.discord.embed.AuthorEmbed;
import net.runelite.http.api.discord.embed.FieldEmbed;
import net.runelite.http.api.discord.embed.FooterEmbed;
import okhttp3.HttpUrl;

@PluginDescriptor(
	name = "Discord Logger",
	description = "Configure events to be posted to a Discord channel via a webhook",
	tags = {"discord", "webhook", "log", "logger"}
)
@Slf4j
public class DiscordWebhookPlugin extends Plugin
{
	private static final DiscordClient CLIENT = new DiscordClient();
	private static final String ICONBASEURL = "https://static.runelite.net/cache/item/icon/"; // Add item id + ".png"

	private String iconUrl;
	private boolean checkAccount;
	private AccountType accountType;

	private List fieldList = new ArrayList();

	private HttpUrl url;

	@Inject
	private Client client;

	@Inject
	private DiscordWebhookConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ScheduledExecutorService executorService;

	@Provides
	DiscordWebhookConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DiscordWebhookConfig.class);
	}

	@Override
	protected void startUp()
	{
		discordInit();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case LOGGED_IN:
				checkAccount = true;
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (!checkAccount)
		{
			return;
		}

		discordInit();
		checkAccount = false;
		accountType = client.getAccountType();

		if (!client.getWorldType().equals(WorldType.DEADMAN) || !client.getWorldType().equals(WorldType.SEASONAL_DEADMAN))
		{
			switch (accountType)
			{
				case NORMAL:
					iconUrl = getIcon(1038);
					break;
				case IRONMAN:
					iconUrl = "https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/ironman.png";
					break;
				case HARDCORE_IRONMAN:
					iconUrl = "https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/hardcore_ironman.png";
					break;
				case ULTIMATE_IRONMAN:
					iconUrl = "https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/ultimate_ironman.png";
					break;
			}
		}

		if (client.getWorldType().equals(WorldType.DEADMAN) || client.getWorldType().equals(WorldType.SEASONAL_DEADMAN))
		{
			iconUrl = "https://raw.githubusercontent.com/runelite/runelite/master/runelite-client/src/main/resources/net/runelite/client/plugins/hiscore/seasonal_deadman.png";
		}
	}

	@Subscribe
	public void npcLootReceived(final NpcLootReceived npcLootReceived)
	{
		if (config.lootLogType().equals(LootLogType.NONE) || !url.isHttps())
		{
			return;
		}

		if (config.lootLogType().equals(LootLogType.ALL) && url.pathSize() > 1) //todo fix LootLogType check
		{
			final NPC npc = npcLootReceived.getNpc();
			final String npcName = npc.getName();
			final Collection<ItemStack> items = npcLootReceived.getItems();

			for (ItemStack item : items)
			{
				final int itemId = item.getId();
				final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
				final String itemName = itemComposition.getName();
				final int itemQuantity = item.getQuantity();
				final int gePrice = itemManager.getItemPrice(itemId);

				if ((itemQuantity * gePrice) > config.getMinLootValue())
				{
					fieldList.add(FieldEmbed.builder()
					.name(itemName + " x " + itemQuantity)
					.value((itemQuantity * gePrice) + " gp")
					.build());
				}
			}

			if (!fieldList.isEmpty())
			{
				message(npcName, "has been slain for:", fieldList);
				fieldList.clear();
			}
		}
	}

	@Subscribe
	public void localPlayerDeath(LocalPlayerDeath localPlayerDeath)
	{
		final Actor target = client.getLocalPlayer().getInteracting();

		if (config.isLoggingDeaths() && target != null)
		{
			final String npcName = target.getName();

			fieldList.add(FieldEmbed.builder()
			.name(Time.valueOf(LocalTime.now()).toString())
			.value("Oh dear, someone died...")
			.build());

			message(npcName, "", fieldList);
			fieldList.clear();
		}
	}

	private void message(String name, String description, List fields)
	{
		if (name.isEmpty() || description.isEmpty() || fields.isEmpty())
		{
			log.warn("Discord message will fail with a missing name/description/field");
			return;
		}

		DiscordEmbed discordEmbed = DiscordEmbed.builder()
			.author(AuthorEmbed.builder()
				.icon_url("") // Icon of npc / player
				.name(name)
				.build())
			.description(description)
			.fields(fields)
			.footer(FooterEmbed.builder()
				.icon_url(iconUrl)
				.text(client.getLocalPlayer().getName())
				.build())
			.build();

		DiscordMessage discordMessage = new DiscordMessage("Runelite", "", "");
		discordMessage.getEmbeds().add(discordEmbed);
		CLIENT.message(url, discordMessage);
		fields.clear();
	}

	private void discordInit()
	{
		url = HttpUrl.parse(config.getDiscordUrl());
	}

	private String getIcon(int itemID)
	{
		return ICONBASEURL + itemID + ".png";
	}
}
