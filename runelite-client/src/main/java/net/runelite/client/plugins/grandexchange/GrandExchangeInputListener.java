/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.grandexchange;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemMapping;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;
import static net.runelite.client.plugins.grandexchange.GrandExchangePlugin.SEARCH_GRAND_EXCHANGE;

public class GrandExchangeInputListener extends MouseAdapter implements KeyListener
{
	private final Client client;
	private final GrandExchangePlugin plugin;

	@Inject
	private ItemManager itemManager;

	@Inject
	private GrandExchangeInputListener(Client client, GrandExchangePlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent e)
	{
		// Check if left click + alt
		if (e.getButton() == MouseEvent.BUTTON1 && e.isAltDown())
		{
			final MenuEntry[] menuEntries = client.getMenuEntries();
			for (final MenuEntry menuEntry : menuEntries)
			{
				if (menuEntry.getOption().equals(SEARCH_GRAND_EXCHANGE))
				{
					final int widgetIndex = menuEntry.getParam0();
					final int widgetId = menuEntry.getParam1();
					final Widget widget = getWidget(widgetId, widgetIndex);

					int itemId = itemManager.canonicalize(widget.getItemId());

					// Try to replace an untradeable item id with a tradeable component
					final Collection<ItemMapping> mappedItems = ItemMapping.map(itemId);
					if (mappedItems != null)
					{
						final ItemMapping firstMappedItem = mappedItems.iterator().next();
						itemId = firstMappedItem.getTradeableItem();
					}

					String itemName = itemManager.getItemComposition(itemId).getMembersName();
					search(itemName);

					e.consume();
					break;
				}
			}
		}

		return super.mouseClicked(e);
	}

	// Copied from WikiPlugin
	private Widget getWidget(int wid, int index)
	{
		Widget w = client.getWidget(wid);
		if (index != -1)
		{
			w = w.getChild(index);
		}
		return w;
	}

	private void search(final String itemName)
	{
		SwingUtilities.invokeLater(() ->
		{
			plugin.getPanel().showSearch();

			if (!plugin.getButton().isSelected())
			{
				plugin.getButton().getOnSelect().run();
			}

			plugin.getPanel().getSearchPanel().priceLookup(itemName);
		});
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isAltDown())
		{
			plugin.setHotKeyPressed(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown())
		{
			plugin.setHotKeyPressed(false);
		}
	}
}
