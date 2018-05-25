/*
 * Copyright (c) 2018, Tanner <https://github.com/Reasel>
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
package net.runelite.client.plugins.chatnotifier;

import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatchLoader;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static java.lang.Boolean.TRUE;

@PluginDescriptor(
	name = "Chat Notifier"
)
public class ChatNotifierPlugin extends Plugin
{
	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private ChatNotifierConfig config;

	private LoadingCache<String, Boolean> notifiedMessages;
	private List<String> notifiedMessagesList = new ArrayList<>();
	private final String recoilCheck = "Your Ring of Recoil has shattered.";


	@Provides
	ChatNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatNotifierConfig.class);
	}

	private void reset()
	{
		Splitter COMMA_SPLITTER = Splitter.on(Pattern.compile("\\s*,\\s*"));

		// gets the highlighted items from the text box in the config
		notifiedMessagesList = COMMA_SPLITTER.splitToList(config.getMessageNotification().trim());

		notifiedMessages = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(notifiedMessagesList));
	}

	@Override
	protected void startUp()
	{
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		notifiedMessages.invalidateAll();
		notifiedMessages = null;
		notifiedMessagesList = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("chatnotifier"))
		{
			reset();
		}
	}

	@Subscribe
	public void onChatMessageReceived(ChatMessage event)
	{
		if ((event.getType() == ChatMessageType.FILTERED && config.ignoreFiltered()) || (Text.removeTags(event.getName()).equals(client.getUsername())))
		{
			return;
		}

		if (event.getType() == ChatMessageType.TRADE && config.notifyTrade())
		{
			notifier.notify(client.getLocalPlayer().getName() + " got a trade request");
		}
		else if (event.getType() == ChatMessageType.DUEL && config.notifyDuel())
		{
			notifier.notify(client.getLocalPlayer().getName() + " has been challenged");
		}
		else if (config.notifyRecoil() && event.getMessage().contains(recoilCheck))
		{
			notifier.notify(client.getLocalPlayer().getName() + "'s ring of recoil has shattered");
		}
		else if (isNotificationMessage(event.getMessage()))
		{
			notifier.notify(client.getLocalPlayer().getName() + " got message: " + event.getMessage());
		}
	}

	private boolean isNotificationMessage(String message)
	{
		return TRUE.equals(notifiedMessages.getUnchecked(message));
	}
}