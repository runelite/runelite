/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.itemcharges;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ItemChargeChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Item Charges",
	description = "Show number of item charges remaining",
	tags = {"inventory", "notifications", "overlay"}
)
public class ItemChargePlugin extends Plugin
{
	private static final String RING_OF_RECOIL_BREAK_MESSAGE = "<col=7f007f>Your Ring of Recoil has shattered.</col>";

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemChargeOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemChargeConfig config;

	@Provides
	ItemChargeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemChargeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		if (event.getType() == ChatMessageType.SERVER || event.getType() == ChatMessageType.FILTERED)
		{
			if (config.recoilNotification() && message.contains(RING_OF_RECOIL_BREAK_MESSAGE))
			{
				notifier.notify("Your Ring of Recoil has shattered");
			}
		}
	}

	@Subscribe
	public void onItemChargeChanged(ItemChargeChanged event)
	{
		if (event.getItemID() == ItemID.DODGY_NECKLACE && event.getCharges() == 0 && config.dodgyNotification())
		{
			notifier.notify("Your dodgy necklace has crumbled to dust.");
		}
		else if (event.getItemID() == ItemID.AMULET_OF_CHEMISTRY && event.getCharges() == 0 && config.chemistryNotification())
		{
			notifier.notify("Your amulet of chemistry has crumbled to dust.");
		}
	}
}