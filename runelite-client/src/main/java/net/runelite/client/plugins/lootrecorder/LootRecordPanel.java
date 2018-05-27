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
package net.runelite.client.plugins.lootrecorder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import lombok.Getter;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;

@Getter
class LootRecordPanel extends JPanel
{
	private LootRecord record;

	LootRecordPanel(LootRecord record)
	{
		this.record = record;

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBorder(new MatteBorder( 0, 0, 1, 0, Color.GRAY));

		// Item Image Icon
		JLabel icon = new JLabel();
		this.record.getIcon().addTo(icon);
		// Item Name (Colored off Item Price)
		JLabel item_name = new JLabel(this.record.getItem_name());
		ColorLabel(item_name, this.record.getValue());
		// Item Values (Colored off Total Value of item)
		JLabel total = new JLabel(numberToString(this.record.getTotal()), SwingConstants.RIGHT);
		ColorLabel(total, this.record.getTotal());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		// Add to Panel
		this.add(icon, c);
		c.gridx++;
		this.add(item_name, c);
		c.gridx++;
		this.add(total, c);
	}

	// Used specifically for the Total Value element inside the tab
	LootRecordPanel(Long totalValue)
	{
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.setBorder(new MatteBorder( 0, 0, 1, 0, Color.GRAY));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		JLabel totalText = new JLabel("Total Value:", SwingConstants.LEFT);
		ColorLabel(totalText, totalValue);

		// Item Values (Colored off Total Value of item)
		JLabel total = new JLabel(numberToString(totalValue), SwingConstants.RIGHT);
		ColorLabel(total, totalValue);

		this.add(totalText, c);
		c.gridx++;
		this.add(total, c);
	}

	// Add K and M Suffix to items
	private String numberToString(long v)
	{
		String suffix = " gp";
		if (v >= 10000000)
		{
			v = v / 1000000;
			suffix = "M" + suffix;

		}
		else if (v >= 100000)
		{
			v = v / 1000;
			suffix = "K" + suffix;
		}

		return (new DecimalFormat("#,###.#").format(v) + suffix);
	}

	// Color label to match RuneScape coloring
	private void ColorLabel(JLabel label, long val)
	{
		Color labelColor = Color.yellow;
		if (val >= 10000000)
		{
			labelColor = Color.green;
		}
		else if (val >= 100000)
		{
			labelColor = Color.white;
		}
		label.setForeground(labelColor);
	}
}