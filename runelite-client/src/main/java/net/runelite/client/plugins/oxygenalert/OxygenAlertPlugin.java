/*
 * Copyright (c) 2018 Robin Withes
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
package net.runelite.client.plugins.oxygenalert;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;

@PluginDescriptor(
	name = "Oxygen Alert",
	description = "Gives you warnings when you drop below X oxygen",
	tags = {"health", "warning", "oxygen", "underwater"}
)
public class OxygenAlertPlugin extends Plugin
{

	private int oxygenThreshold;

	@Inject
	private OxygenAlertConfig config;

	@Inject
	private Client client;

	@Inject
	private Notifier notifier;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Provides
	OxygenAlertConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OxygenAlertConfig.class);
	}


	@Subscribe
	private void onVarbitChanged(VarbitChanged ev)
	{
		oxygenThreshold = config.oxygenAlertAmount();
		if (oxygenThreshold >= 100 || oxygenThreshold < 0)
		{
			oxygenThreshold = 20;
		}
		if (client.getVar(Varbits.OXYGEN_LEVEL) <= oxygenThreshold * 10 && client.getVar(Varbits.OXYGEN_LEVEL) > 0)
		{
			if ((config.oxygenChatAlert() && !config.oxygenChatAlertCooldown()) || ((config.oxygenChatAlert() && config.oxygenChatAlertCooldown() && oxygenThreshold == client.getVar(Varbits.OXYGEN_LEVEL) * 0.1)))
			{
				String message = "Your oxygen is dangerously low! Currently: " + client.getVar(Varbits.OXYGEN_LEVEL) * 0.1 + "%";
				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.DUEL)
					.runeLiteFormattedMessage(message)
					.build());
			}

			if ((config.oxygenNotifyAlert() && !config.oxygenNotifyAlertCooldown()) || (config.oxygenNotifyAlert() && config.oxygenNotifyAlertCooldown() && oxygenThreshold == client.getVar(Varbits.OXYGEN_LEVEL) * 0.1))
			{
				notifier.notify("Your oxygen is dangerously low! Currently: " + client.getVar(Varbits.OXYGEN_LEVEL) * 0.1 + "%");
			}
		}
	}
}
