/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.skillcalculator;

import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.text.DecimalFormat;

class BankedExpPanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(35, 35);
	private static final DecimalFormat FORMAT_COMMA = new DecimalFormat("#,###.#");

	BankedExpPanel(ItemManager itemManager, BankedItems item, int amount, double total)
	{
		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Icon
		AsyncBufferedImage icon = itemManager.getImage(item.getItemID());
		JLabel image = new JLabel();
		image.setMinimumSize(ICON_SIZE);
		image.setMaximumSize(ICON_SIZE);
		image.setPreferredSize(ICON_SIZE);
		image.setHorizontalAlignment(SwingConstants.LEFT);
		image.setBorder(new EmptyBorder(0, 8, 0, 0));

		Runnable resize = () ->
			image.setIcon(new ImageIcon(icon.getScaledInstance((int)ICON_SIZE.getWidth(), (int)ICON_SIZE.getHeight(), Image.SCALE_SMOOTH)));
		icon.onChanged(resize);
		resize.run();

		// Amount
		JShadowedLabel amountLabel = new JShadowedLabel(FORMAT_COMMA.format(amount));
		amountLabel.setForeground(Color.WHITE);
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Total Experience
		JShadowedLabel expLabel = new JShadowedLabel(FORMAT_COMMA.format(total) + "xp");
		expLabel.setForeground(Color.WHITE);
		expLabel.setHorizontalAlignment(SwingConstants.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		add(image, c);
		c.gridx++;
		add(amountLabel, c);
		c.gridx++;
		add(expLabel, c);
	}
}
