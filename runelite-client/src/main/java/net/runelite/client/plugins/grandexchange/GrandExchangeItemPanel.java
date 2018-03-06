/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.LinkBrowser;

@Slf4j
class GrandExchangeItemPanel extends JPanel
{
	private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();

	GrandExchangeItemPanel(LinkBrowser linkBrowser, BufferedImage icon, String name, int itemID, int gePrice, Double
		haPrice)
	{
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		setLayout(layout);
		setToolTipText(name);

		Color background = getBackground();

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				setBackground(getBackground().darker().darker());
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				setBackground(background);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				geLink(linkBrowser, name, itemID);
			}
		});

		setBorder(new CompoundBorder
		(
			new LineBorder(getBackground().brighter(), 1),
			new EmptyBorder(5, 5, 5, 5)
		));

		// Icon
		JLabel itemIcon = new JLabel();
		itemIcon.setIcon(new ImageIcon(icon));
		add(itemIcon, BorderLayout.LINE_START);

		// Item details panel
		JPanel rightPanel = new JPanel(new GridLayout(3, 1));
		rightPanel.setOpaque(false);

		// Item name
		JLabel itemName = new JLabel();
		itemName.setText(name);
		rightPanel.add(itemName);

		// Ge price
		JLabel gePriceLabel = new JLabel();
		gePriceLabel.setText(NUMBER_FORMATTER.format(gePrice) + " gp");
		gePriceLabel.setForeground(Color.GREEN);
		rightPanel.add(gePriceLabel);

		// Alch price
		JLabel haPriceLabel = new JLabel();
		haPriceLabel.setText(NUMBER_FORMATTER.format(haPrice.intValue()) + " alch");
		haPriceLabel.setForeground(Color.orange);
		rightPanel.add(haPriceLabel);

		add(rightPanel, BorderLayout.CENTER);
	}

	private void geLink(LinkBrowser linkBrowser, String name, int itemID)
	{
		final String url = "http://services.runescape.com/m=itemdb_oldschool/"
			+ name.replaceAll(" ", "_")
			+ "/viewitem?obj="
			+ itemID;

		linkBrowser.browse(url);
	}
}
