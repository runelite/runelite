/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

/**
 * A progress bar to be displayed underneath the GE offer item panels
 */
public class ProgressBar extends DimmableJPanel
{
	private int maximumValue;
	private int value;
	private List<Integer> positions = Collections.emptyList();

	private final JLabel leftLabel = new JShadowedLabel();
	private final JLabel rightLabel = new JShadowedLabel();
	private final JLabel centerLabel = new JShadowedLabel();
	private String centerLabelText = "";
	private String dimmedText = "";

	public ProgressBar()
	{
		setLayout(new GridLayout(1, 3));
		// The background color should be overridden
		setBackground(Color.GREEN.darker());
		setForeground(Color.GREEN.brighter());

		setPreferredSize(new Dimension(100, 16));

		leftLabel.setFont(FontManager.getRunescapeSmallFont());
		leftLabel.setForeground(Color.WHITE);
		leftLabel.setBorder(new EmptyBorder(2, 5, 0, 0));

		rightLabel.setFont(FontManager.getRunescapeSmallFont());
		rightLabel.setForeground(Color.WHITE);
		rightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightLabel.setBorder(new EmptyBorder(2, 0, 0, 5));

		centerLabel.setFont(FontManager.getRunescapeSmallFont());
		centerLabel.setForeground(Color.WHITE);
		centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerLabel.setBorder(new EmptyBorder(2, 0, 0, 0));

		// Adds components to be automatically redrawn when paintComponents is called
		add(leftLabel);
		add(centerLabel);
		add(rightLabel);
	}

	@Override
	public void paint(Graphics g)
	{
		int percentage = getPercentage();
		int topWidth = (int) (getSize().width * (percentage / 100f));

		super.paint(g);
		g.setColor(getForeground());
		g.fillRect(0, 0, topWidth, 16);

		for (final Integer position : positions)
		{
			final int xCord = getSize().width * position / maximumValue;
			if (xCord > topWidth)
			{
				g.fillRect(xCord, 0, 1, 16);
			}
		}

		super.paintComponents(g);
	}

	@Override
	public void setDimmed(boolean dimmed)
	{
		super.setDimmed(dimmed);

		if (dimmed)
		{
			leftLabel.setForeground(Color.GRAY);
			rightLabel.setForeground(Color.GRAY);
			centerLabel.setText(dimmedText);
		}
		else
		{
			leftLabel.setForeground(Color.WHITE);
			rightLabel.setForeground(Color.WHITE);
			centerLabel.setText(centerLabelText);
		}
	}

	public void setLeftLabel(String txt)
	{
		leftLabel.setText(txt);
	}

	public void setRightLabel(String txt)
	{
		rightLabel.setText(txt);
	}

	public void setCenterLabel(String txt)
	{
		centerLabelText = txt;
		centerLabel.setText(isDimmed() ? dimmedText : txt);
	}

	public void setDimmedText(String txt)
	{
		dimmedText = txt;
		centerLabel.setText(isDimmed() ? txt : centerLabelText);
	}

	public int getPercentage()
	{
		if (maximumValue == 0)
		{
			return 0;
		}

		return (value * 100) / maximumValue;
	}

	public void setMaximumValue(int maximumValue)
	{
		this.maximumValue = maximumValue;
		repaint();
	}

	public void setValue(int value)
	{
		this.value = value;
		repaint();
	}

	public void setPositions(List<Integer> positions)
	{
		this.positions = positions;
		repaint();
	}
}
