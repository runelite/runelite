/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import lombok.Getter;

/**
 * A progress bar to be displayed underneath the GE offer item panels
 */
public class ThinProgressBar extends JPanel
{
	@Getter
	private int maximumValue = 1;

	@Getter
	private int value;

	public ThinProgressBar()
	{
		setForeground(Color.GREEN);
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 4));
		setMinimumSize(new Dimension(0, 4));
		setPreferredSize(new Dimension(0, 4));
		setSize(new Dimension(0, 4));
		setOpaque(true);
	}

	public double getPercentage()
	{
		return (value * 100) / maximumValue;
	}

	@Override
	public void setForeground(Color color)
	{
		super.setForeground(color);
		setBackground(color.darker().darker());
	}

	public void setMaximumValue(int maximumValue)
	{
		if (maximumValue < 1)
		{
			maximumValue = 1;
		}
		this.maximumValue = maximumValue;
		repaint();
	}

	public void setValue(int value)
	{
		this.value = value;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int div = (value * w) / maximumValue;
		g.setColor(getBackground());
		g.fillRect(div, 0, w, h);
		g.setColor(getForeground());
		g.fillRect(0, 0, div, h);
	}
}