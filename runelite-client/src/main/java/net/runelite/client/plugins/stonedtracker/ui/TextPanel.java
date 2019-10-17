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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.QuantityFormatter;

@Getter
class TextPanel extends JPanel
{
	private static final GridBagLayout LAYOUT = new GridBagLayout();

	private static final Border PANEL_BORDER = BorderFactory.createMatteBorder(3, 0, 3, 0, ColorScheme.DARK_GRAY_COLOR);
	private static final Color PANEL_BACKGROUND_COLOR = ColorScheme.DARKER_GRAY_COLOR;

	private static final Border CONTAINER_BORDER = BorderFactory.createMatteBorder(0, 15, 0, 15, PANEL_BACKGROUND_COLOR);

	// Long value should be for Total Value
	TextPanel(final String text, final long totalValue)
	{
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);

		final JLabel totalText = new JLabel(text, SwingConstants.LEFT);
		totalText.setForeground(Color.WHITE);

		// Item Values (Colored off Total Value of item)
		final JLabel total = new JLabel(QuantityFormatter.quantityToStackSize(totalValue) + " gp", SwingConstants.LEFT);
		total.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		total.setForeground(getRSValueColor(totalValue));

		final JPanel panel = createPanel();

		panel.add(totalText, BorderLayout.LINE_START);
		panel.add(total, BorderLayout.CENTER);

		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		panel.setToolTipText(QuantityFormatter.formatNumber(totalValue));

		this.add(panel, c);
	}

	TextPanel(final String text, final int value)
	{
		this.setLayout(LAYOUT);
		this.setBorder(PANEL_BORDER);
		this.setBackground(PANEL_BACKGROUND_COLOR);

		final JLabel textLabel = new JLabel(text, SwingConstants.LEFT);
		textLabel.setForeground(Color.WHITE);

		final JLabel valueLabel = new JLabel(String.valueOf(value), SwingConstants.LEFT);
		valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

		final JPanel panel = createPanel();
		panel.add(textLabel, BorderLayout.LINE_START);
		panel.add(valueLabel, BorderLayout.CENTER);

		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		this.add(panel, c);
	}

	private static JPanel createPanel()
	{
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(CONTAINER_BORDER);
		panel.setBackground(PANEL_BACKGROUND_COLOR);

		return panel;
	}

	private static Color getRSValueColor(long val)
	{
		return (val >= 10000000) ? Color.GREEN : (val >= 100000) ? Color.WHITE : Color.YELLOW;
	}
}