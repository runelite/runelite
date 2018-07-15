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
package net.runelite.client.plugins.bosslogger.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import net.runelite.client.plugins.bosslogger.data.LootRecord;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.StackFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

@Getter
class LootRecordPanel extends JPanel
{
	private static final GridBagLayout LAYOUT = new GridBagLayout();

	private static final Border PANEL_BORDER = new EmptyBorder(3, 0, 3, 0);
	private static final Color PANEL_BACKGROUND_COLOR = ColorScheme.DARK_GRAY_COLOR;

	private static final Border CONTAINER_BORDER = new EmptyBorder(0, 15, 0, 15);
	private static final Color CONTAINER_BACKGROUND_COLOR = ColorScheme.DARKER_GRAY_COLOR;

	private LootRecord record;

	LootRecordPanel(LootRecord record)
	{
		this.record = record;
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);

		// Item Image Icon
		JLabel icon = new JLabel();
		this.record.getIcon().addTo(icon);
		icon.setHorizontalAlignment(JLabel.CENTER);

		// Container for Info
		JPanel uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));
		uiInfo.setBackground(CONTAINER_BACKGROUND_COLOR);

		JShadowedLabel labelName = new JShadowedLabel(this.record.getItemName());
		labelName.setForeground(Color.WHITE);
		colorLabel(labelName, this.record.getValue());
		labelName.setVerticalAlignment(SwingUtilities.BOTTOM);

		JShadowedLabel labelValue = new JShadowedLabel(StackFormatter.quantityToStackSize(this.record.getTotal()) + " gp");
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
		c.ipady = 20;

		this.add(panel, c);
	}

	// Used specifically for the Total Value element inside the tab
	LootRecordPanel(long totalValue)
	{
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);

		JLabel totalText = new JLabel("Total Value:", SwingConstants.LEFT);
		totalText.setForeground(Color.WHITE);

		// Item Values (Colored off Total Value of item)
		JLabel total = new JLabel(StackFormatter.quantityToStackSize(totalValue) + " gp", SwingConstants.LEFT);
		total.setBorder(new EmptyBorder(0, 5, 0, 0));
		colorLabel(total, totalValue);

		JPanel panel = createPanel();

		panel.add(totalText, BorderLayout.LINE_START);
		panel.add(total, BorderLayout.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		this.add(panel, c);
	}


	// Used specifically for the Killcount entry
	LootRecordPanel(String text, int value)
	{
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);

		JLabel textLabel = new JLabel(text, SwingConstants.LEFT);
		textLabel.setForeground(Color.WHITE);

		JLabel valueLabel = new JLabel(String.valueOf(value), SwingConstants.LEFT);
		valueLabel.setBorder(new EmptyBorder(0, 5, 0, 0));

		JPanel panel = createPanel();
		panel.add(textLabel, BorderLayout.LINE_START);
		panel.add(valueLabel, BorderLayout.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		this.add(panel, c);
	}

	private JPanel createPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(CONTAINER_BORDER);
		panel.setBackground(CONTAINER_BACKGROUND_COLOR);

		return panel;
	}

	// Color label to match RuneScape coloring
	private void colorLabel(JLabel label, long val)
	{
		Color labelColor = (val >= 10000000) ? Color.GREEN : (val >= 100000) ? Color.WHITE : Color.YELLOW;
		label.setForeground(labelColor);
	}
}