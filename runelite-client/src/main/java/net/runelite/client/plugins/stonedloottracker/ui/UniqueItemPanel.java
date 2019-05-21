/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.stonedloottracker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.stonedloottracker.data.UniqueItemPrepared;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.StackFormatter;

@Getter
class UniqueItemPanel extends JPanel
{
	private ItemManager itemManager;

	private final float alphaMissing = 0.35f;
	private final float alphaHas = 1.0f;

	private static final Dimension panelSize = new Dimension(215, 50);
	private static final Border panelBorder = new EmptyBorder(3, 0, 3, 0);
	private static final Color panelBackgroundColor = ColorScheme.DARK_GRAY_COLOR;

	UniqueItemPanel(Collection<UniqueItemPrepared> items, Map<UniqueItemPrepared, Integer> uniqueMap, ItemManager itemManager)
	{
		this.itemManager = itemManager;

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		panel.setBorder(new EmptyBorder(3, 0, 3, 0));

		this.setLayout(new BorderLayout());
		this.setBorder(panelBorder);
		this.setBackground(panelBackgroundColor);
		this.setPreferredSize(panelSize);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 5;

		// Add each Unique Item icon to the panel
		for (UniqueItemPrepared l : items)
		{
			final int id = l.getUniqueItem().getItemID();
			final int quantity = uniqueMap.getOrDefault(l, 0);
			final float alpha = (quantity > 0 ? alphaHas : alphaMissing);
			AsyncBufferedImage image = itemManager.getImage(l.getUniqueItem().getItemID(), quantity, quantity > 1);
			BufferedImage opaque = ImageUtil.alphaOffset(image, alpha);

			final long price = itemManager.getItemPrice(id);
			final long haPrice = itemManager.getAlchValue(id);

			// Attach Image to Label and append label to Panel
			ImageIcon o = new ImageIcon(opaque);
			JLabel icon = new JLabel(o);
			panel.add(icon, c);
			c.gridx++;

			// in case the image is blank we will refresh it upon load
			// Should only trigger if image hasn't been added
			image.onChanged(() -> SwingUtilities.invokeLater(() -> refreshImage(icon, image, alpha)));

			icon.setToolTipText(tooltipText(price, haPrice, quantity, l.getUniqueItem().getName()));
		}

		this.add(panel, BorderLayout.NORTH);
	}

	static String tooltipText(long price, long haPrice, int quantity, String name)
	{
		String tooltipText = "<html>" + name;
		if (quantity > 1)
		{
			tooltipText += "<br/>Price: " + StackFormatter.quantityToStackSize(price);

			if (haPrice > 0)
			{
				tooltipText += " (HA: " + StackFormatter.quantityToStackSize(haPrice) + ")";
			}
		}

		if (quantity > 0)
		{
			tooltipText += "<br/>Total: " + StackFormatter.quantityToStackSize(quantity * price);

			if (haPrice > 0)
			{
				tooltipText += " (HA: " + StackFormatter.quantityToStackSize(quantity * haPrice) + ")";
			}
		}
		tooltipText += "</html";

		return tooltipText;
	}

	// Used to refresh the item icon if the image was still loading when attempting to create it earlier
	private void refreshImage(JLabel label, AsyncBufferedImage image, float finalAlpha)
	{
		BufferedImage opaque = ImageUtil.alphaOffset(image, finalAlpha);
		ImageIcon o = new ImageIcon(opaque);

		label.setIcon(o);
		label.revalidate();
		label.repaint();
	}
}