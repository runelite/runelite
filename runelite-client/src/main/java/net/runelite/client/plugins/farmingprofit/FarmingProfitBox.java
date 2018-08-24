/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.farmingprofit;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;

class FarmingProfitBox extends JPanel
{

	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	FarmingProfitBox(ItemManager itemManager, FarmingProfitRun run)
	{
		// Set panel properties
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(5, 0, 0, 0));
		setToolTipText(run.getTooltip());

		// Item name
		String itemName = run.getCrop().getDisplayName();

		// Run image
		final JPanel runImage = new JPanel();
		runImage.setLayout(new BorderLayout(0, 0));
		runImage.setBorder(new EmptyBorder(7, 7, 7, 0));
		runImage.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		final JLabel runImageLabel = new JLabel();
		runImageLabel.setVerticalAlignment(SwingConstants.CENTER);
		runImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemManager.getImage(run.getCrop().getProductId(), run.getAmount(), true).addTo(runImageLabel);
		runImage.add(runImageLabel);

		// Run information
		final JPanel runInfo = new JPanel();
		runInfo.setLayout(new BorderLayout(0, 0));
		runInfo.setBorder(new EmptyBorder(7, 7, 7, 7));
		runInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Run information: Title
		final JLabel runTitle = new JLabel(itemName);
		runTitle.setFont(FontManager.getRunescapeSmallFont());
		runTitle.setForeground(Color.WHITE);
		runInfo.add(runTitle, BorderLayout.NORTH);

		// Run information: Profit
		final JLabel profitLabel = new JLabel();
		profitLabel.setText(htmlLabel("Profit: ", run.getProfit()));
		profitLabel.setFont(FontManager.getRunescapeSmallFont());
		profitLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		runInfo.add(profitLabel, BorderLayout.CENTER);

		// Run information: Amount harvested
		if (run.getAmount() > 0)
		{
			final JLabel amountLabel = new JLabel();
			amountLabel.setText(htmlLabel("Amount: ", run.getAmount()));
			amountLabel.setFont(FontManager.getRunescapeSmallFont());
			amountLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			runInfo.add(amountLabel, BorderLayout.SOUTH);
		}

		// Add image and info to the panel
		add(runImage, BorderLayout.WEST);
		add(runInfo, BorderLayout.CENTER);
	}

	private static String htmlLabel(String key, long value)
	{
		final String valueStr = StackFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

}
