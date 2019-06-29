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
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.stonedloottracker.data.LootTrackerItemEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.StackFormatter;

@Getter
class ItemPanel extends JPanel
{
	private static final GridBagLayout LAYOUT = new GridBagLayout();
	private static final Dimension PANEL_SIZE = new Dimension(215, 50);

	private static final Border PANEL_BORDER = BorderFactory.createMatteBorder(3, 0, 3, 0, ColorScheme.DARK_GRAY_COLOR);
	private static final Color PANEL_BACKGROUND_COLOR = ColorScheme.DARKER_GRAY_COLOR;

	private static final Border CONTAINER_BORDER = BorderFactory.createMatteBorder(4, 15, 4, 15, PANEL_BACKGROUND_COLOR);

	private LootTrackerItemEntry record;

	ItemPanel(LootTrackerItemEntry record, ItemManager itemManager)
	{
		this.record = record;
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);
		this.setPreferredSize(PANEL_SIZE);

		// Item Image Icon
		JLabel icon = new JLabel();
		itemManager.getImage(record.getId(), record.getQuantity(), (record.isStackable() || record.getQuantity() > 1)).addTo(icon);
		icon.setHorizontalAlignment(JLabel.CENTER);

		// Container for Info
		JPanel uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));
		uiInfo.setBackground(PANEL_BACKGROUND_COLOR);

		JShadowedLabel labelName = new JShadowedLabel(this.record.getName());
		labelName.setForeground(Color.WHITE);
		colorLabel(labelName, this.record.getPrice());
		labelName.setVerticalAlignment(SwingUtilities.BOTTOM);

		String gpLabel = StackFormatter.quantityToStackSize(this.record.getTotal()) + " gp";

		if (this.record.getHaTotal() > 0 && this.record.getHaPrice() > 1)
		{
			gpLabel += " (HA: " + StackFormatter.quantityToStackSize(this.record.getHaTotal()) + " gp)";
		}

		JShadowedLabel labelValue = new JShadowedLabel(gpLabel);
		labelValue.setFont(FontManager.getRunescapeSmallFont());
		colorLabel(labelValue, this.record.getTotal());
		labelValue.setVerticalAlignment(SwingUtilities.TOP);

		uiInfo.add(labelName);
		uiInfo.add(labelValue);

		// Create and append elements to container panel
		JPanel panel = createPanel();
		panel.add(icon, BorderLayout.LINE_START);
		panel.add(uiInfo, BorderLayout.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		this.add(panel, c);
		this.setToolTipText(UniqueItemPanel.tooltipText(this.record.getPrice(), this.record.getHaPrice(), this.record.getQuantity(), this.record.getName()));
	}

	static JPanel createPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(CONTAINER_BORDER);
		panel.setBackground(PANEL_BACKGROUND_COLOR);

		return panel;
	}

	// Color label to match RuneScape coloring
	private void colorLabel(JLabel label, long val)
	{
		Color labelColor = (val >= 10000000) ? Color.GREEN : (val >= 100000) ? Color.WHITE : Color.YELLOW;
		label.setForeground(labelColor);
	}
}