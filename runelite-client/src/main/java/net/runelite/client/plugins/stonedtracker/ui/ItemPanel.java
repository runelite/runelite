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
package net.runelite.client.plugins.stonedtracker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.loottracker.localstorage.LTItemEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.QuantityFormatter;

@Getter
class ItemPanel extends JPanel
{
	private static final GridBagLayout LAYOUT = new GridBagLayout();
	private static final Dimension PANEL_SIZE = new Dimension(215, 50);

	private static final Border PANEL_BORDER = BorderFactory.createMatteBorder(3, 0, 3, 0, ColorScheme.DARK_GRAY_COLOR);
	private static final Color PANEL_BACKGROUND_COLOR = ColorScheme.DARKER_GRAY_COLOR;

	private static final Border CONTAINER_BORDER = BorderFactory.createMatteBorder(4, 15, 4, 15, PANEL_BACKGROUND_COLOR);

	private final LTItemEntry record;
	private final long total;

	ItemPanel(final LTItemEntry record, final ItemManager itemManager)
	{
		setLayout(LAYOUT);
		setBorder(PANEL_BORDER);
		setBackground(PANEL_BACKGROUND_COLOR);
		setPreferredSize(PANEL_SIZE);

		this.record = record;
		this.total = record.getPrice() * record.getQuantity();

		// Item Image Icon
		final JLabel icon = new JLabel();
		final boolean stackable = record.getQuantity() > 1;
		itemManager.getImage(record.getId(), record.getQuantity(), stackable).addTo(icon);
		icon.setHorizontalAlignment(JLabel.CENTER);

		// Container for Info
		final JPanel uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));
		uiInfo.setBackground(PANEL_BACKGROUND_COLOR);

		final JShadowedLabel labelName = new JShadowedLabel(this.record.getName());
		labelName.setFont(FontManager.getRunescapeSmallFont());
		labelName.setForeground(getRSValueColor(this.record.getPrice()));
		labelName.setVerticalAlignment(SwingUtilities.BOTTOM);

		final JShadowedLabel labelValue = new JShadowedLabel(QuantityFormatter.quantityToStackSize(total) + " gp");
		labelValue.setFont(FontManager.getRunescapeSmallFont());
		labelValue.setForeground(getRSValueColor(total));
		labelValue.setVerticalAlignment(SwingUtilities.TOP);

		uiInfo.add(labelName);
		uiInfo.add(labelValue);

		// Create and append elements to container panel
		final JPanel panel = createPanel();
		panel.add(icon, BorderLayout.LINE_START);
		panel.add(uiInfo, BorderLayout.CENTER);

		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		this.add(panel, c);
		this.setToolTipText(buildToolTip(this.record));
	}

	private static String buildToolTip(final LTItemEntry record)
	{
		final String name = record.getName();
		final int quantity = record.getQuantity();
		final long price = record.getPrice();

		return "<html>" + name + " x " + QuantityFormatter.formatNumber(quantity)
			+ "<br/>Price: " + QuantityFormatter.quantityToStackSize(price)
			+ "<br/>Total: " + QuantityFormatter.quantityToStackSize(quantity * price) + "</html>";
	}

	private static Color getRSValueColor(long val)
	{
		return (val >= 10000000) ? Color.GREEN : (val >= 100000) ? Color.WHITE : Color.YELLOW;
	}

	private JPanel createPanel()
	{
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(CONTAINER_BORDER);
		panel.setBackground(PANEL_BACKGROUND_COLOR);

		return panel;
	}
}