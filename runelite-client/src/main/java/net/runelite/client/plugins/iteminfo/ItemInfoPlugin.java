/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
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
package net.runelite.client.plugins.iteminfo;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.grandexchange.GrandExchangePlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;

import java.awt.event.KeyEvent;

/**
 * @author Ben Dol
 */
@Slf4j
@PluginDescriptor(
	name = "Item Info",
	description = "Show information about all items",
	tags = {"items", "inventory", "overlay", "info", "stats", "bonus", "details"}
)
public class ItemInfoPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemInfoOverlay overlay;

	@Inject
	private KeyManager keyManager;

	private HotkeyListener ctrlListener = new HotkeyListener(() -> Keybind.CTRL)
	{
		@Override
		public void hotkeyPressed()
		{
			overlay.setActive(true);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			super.keyReleased(e);

			if (Keybind.CTRL.matches(e))
			{
				overlay.setActive(false);
			}
		}
	};

	@Provides
	ItemInfoConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemInfoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		keyManager.registerKeyListener(ctrlListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);

		keyManager.unregisterKeyListener(ctrlListener);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		switch (event.getGroupId())
		{
			// Grand exchange was opened.
			case WidgetID.GRAND_EXCHANGE_GROUP_ID:
				Widget grandExchangeOffer = client.getWidget(WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER);
				overlay.setGrandExchangeItem(grandExchangeOffer.getDynamicChildren()[GrandExchangePlugin.OFFER_CONTAINER_ITEM]);
				break;

			// Grand exchange was closed (if it was open before).
			case WidgetID.INVENTORY_GROUP_ID:
				overlay.setGrandExchangeItem(null);
				break;
		}
	}
}
