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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import lombok.Setter;
import net.runelite.client.ui.ColorScheme;

/**
 * A progress bar to be displayed underneath the GE offer item panels
 */
public class ThinProgressBar extends JPanel
{
	@Setter
	private int maximumValue;

	@Setter
	private int value;

	private final JPanel topBar = new JPanel();

	public ThinProgressBar()
	{
		setLayout(new BorderLayout());
		setBackground(Color.GREEN.darker());

		topBar.setPreferredSize(new Dimension(100, 4));
		topBar.setBackground(ColorScheme.PROGRESS_COMPLETE_COLOR);

		add(topBar, BorderLayout.WEST);
	}

	/**
	 * Updates the UI based on the percentage progress
	 */
	public void update()
	{
		double percentage = getPercentage();
		int topWidth = (int) (getSize().width * (percentage / 100));

		topBar.setPreferredSize(new Dimension(topWidth, 4));
		topBar.repaint();

		revalidate();
		repaint();
	}

	public double getPercentage()
	{
		if (value == 0)
		{
			return 0;
		}

		return (value * 100) / maximumValue;
	}

	@Override
	public void setForeground(Color color)
	{
		if (topBar != null)
		{
			topBar.setBackground(color);
		}
		setBackground(color.darker());
	}
}