/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
 * Copyright (c) 2019, Parker <https://github.com/Judaxx>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import com.google.common.collect.ImmutableSet;
import java.text.NumberFormat;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.ItemID.TEAK_CHEST;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Kingdom of Miscellania",
	description = "Show various informations about your Kingdom of Miscellania",
	tags = {"favor", "favour", "managing", "overlay", "indication", "notification"},
	enabledByDefault = false
)
@Slf4j
@Singleton
public class KingdomPlugin extends Plugin
{
	private static final ImmutableSet<Integer> KINGDOM_REGION = ImmutableSet.of(10044, 10300);

	@Inject
	private Client client;

	@Inject
	private KingdomConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private int favor = 0, coffer = 0;

	private KingdomCounter counter;
	private boolean showInfoboxAnywhere;
	private int notifyFavorThreshold;
	private int notifyCofferThreshold;

	@Provides
	KingdomConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KingdomConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		removeKingdomInfobox();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		updateKingdomVarbits();
		processInfobox();
	}

	public void onGameStateChanged(GameStateChanged event)
	{

		if (event.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(() ->
			{
				updateKingdomVarbits();
				processInfobox();
				notifyFavor();
				notifyCoffer();
			});
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("kingdomofmiscellania"))
		{
			return;
		}

		updateConfig();
		processInfobox();
	}

	private void processInfobox()
	{
		if (client.getGameState() == GameState.LOGGED_IN && hasCompletedQuest() && (isInKingdom() || this.showInfoboxAnywhere))
		{
			addKingdomInfobox();
		}
		else
		{
			removeKingdomInfobox();
		}

	}

	private void updateKingdomVarbits()
	{
		if (!hasCompletedQuest())
		{
			return;
		}

		this.favor = client.getVar(Varbits.KINGDOM_FAVOR);
		this.coffer = client.getVar(Varbits.KINGDOM_COFFER);
	}

	private void addKingdomInfobox()
	{
		if (counter == null)
		{
			counter = new KingdomCounter(itemManager.getImage(TEAK_CHEST), this);
			infoBoxManager.addInfoBox(counter);
		}
	}

	private void removeKingdomInfobox()
	{
		if (counter != null)
		{
			infoBoxManager.removeInfoBox(counter);
			counter = null;
		}
	}

	private boolean isInKingdom()
	{
		return client.getLocalPlayer() != null
			&& KINGDOM_REGION.contains(client.getLocalPlayer().getWorldLocation().getRegionID());
	}

	private boolean hasCompletedQuest()
	{
		return client.getVar(VarPlayer.THRONE_OF_MISCELLANIA) > 0;
	}

	static int getFavorPercent(int favor)
	{
		return (favor * 100) / 127;
	}

	private void notifyFavor()
	{
		if (hasCompletedQuest() && getFavorPercent(favor) < this.notifyFavorThreshold)
		{
			sendChatMessage("Your favor with your kingdom is below " + this.notifyFavorThreshold + "%.");
		}
	}

	private void notifyCoffer()
	{
		if (hasCompletedQuest() && coffer < this.notifyCofferThreshold)
		{
			sendChatMessage("Your kingdom's coffer has less than " + NumberFormat.getIntegerInstance().format(this.notifyCofferThreshold) + " coins in it.");
		}
	}

	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(chatMessage)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}

	private void updateConfig()
	{
		this.showInfoboxAnywhere = config.showInfoboxAnywhere();
		this.notifyFavorThreshold = config.notifyFavorThreshold();
		this.notifyCofferThreshold = config.notifyCofferThreshold();
	}
}
