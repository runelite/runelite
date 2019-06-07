/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking.clocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.IconButton;

class StopwatchPanel extends ClockPanel
{
	private static final Color LAP_DATA_COLOR = ColorScheme.LIGHT_GRAY_COLOR.darker();

	private final JPanel lapsContainer;
	private final Stopwatch stopwatch;

	StopwatchPanel(ClockManager clockManager, Stopwatch stopwatch)
	{
		super(clockManager, stopwatch, "stopwatch", false);

		this.stopwatch = stopwatch;

		lapsContainer = new JPanel(new GridBagLayout());
		lapsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		rebuildLapList();

		contentContainer.add(lapsContainer);

		IconButton lapButton = new IconButton(ClockTabPanel.LAP_ICON, ClockTabPanel.LAP_ICON_HOVER);
		lapButton.setPreferredSize(new Dimension(16, 14));
		lapButton.setToolTipText("Add lap time");

		lapButton.addActionListener(e ->
		{
			stopwatch.lap();
			rebuildLapList();
			clockManager.saveStopwatches();
		});

		leftActions.add(lapButton);

		IconButton deleteButton = new IconButton(ClockTabPanel.DELETE_ICON, ClockTabPanel.DELETE_ICON_HOVER);
		deleteButton.setPreferredSize(new Dimension(16, 14));
		deleteButton.setToolTipText("Delete stopwatch");
		deleteButton.addActionListener(e -> clockManager.removeStopwatch(stopwatch));
		rightActions.add(deleteButton);
	}

	@Override
	void reset()
	{
		super.reset();
		rebuildLapList();
	}

	private void rebuildLapList()
	{
		lapsContainer.removeAll();

		List<Long> laps = stopwatch.getLaps();

		if (laps.isEmpty())
		{
			lapsContainer.setBorder(null);
		}
		else
		{
			lapsContainer.setBorder(new EmptyBorder(5, 0, 0, 0));

			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(4, 5, 3, 5);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;

			long previousLap = 0;
			for (long lap : stopwatch.getLaps())
			{
				c.gridx = 0;
				lapsContainer.add(createSmallLabel("" + (c.gridy + 1)), c);

				c.gridx = 1;
				lapsContainer.add(createSmallLabel(getFormattedDuration(lap - previousLap)), c);

				c.gridx = 2;
				lapsContainer.add(createSmallLabel(getFormattedDuration(lap)), c);

				previousLap = lap;
				c.gridy++;
			}
		}

		lapsContainer.revalidate();
		lapsContainer.repaint();
	}

	private JLabel createSmallLabel(String text)
	{
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(FontManager.getRunescapeSmallFont());
		label.setForeground(LAP_DATA_COLOR);

		return label;
	}
}
