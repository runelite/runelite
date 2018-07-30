/*
 * Copyright (c) 2018, Shingyx <https://github.com/Shingyx>
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
package net.runelite.client.plugins.grandexchange;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

class GrandExchangePricesPopupMenu extends JPopupMenu
{
	private final String name;
	private final int itemId;

	GrandExchangePricesPopupMenu(String name, int itemId, boolean enableOsbPrices)
	{
		this.name = name;
		this.itemId = itemId;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		recalculateMenuItems(enableOsbPrices);
	}

	void recalculateMenuItems(boolean enableOsbPrices)
	{
		removeAll();

		if (enableOsbPrices)
		{
			final JMenuItem openOsbuddyGeLink = new JMenuItem("Lookup OSBuddy GE price");
			openOsbuddyGeLink.addActionListener(e -> GrandExchangeLinks.openOsbuddyGeLink(itemId));
			add(openOsbuddyGeLink);
		}

		final JMenuItem openGeLink = new JMenuItem("Lookup GE price");
		openGeLink.addActionListener(e -> GrandExchangeLinks.openGeLink(name, itemId));
		add(openGeLink);
	}
}
