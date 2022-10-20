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
import javax.swing.JButton;
import javax.swing.JToggleButton;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.SwingUtil;

class TimerPanel extends ClockPanel
{
	private static final Color WARNING_COLOR = ColorScheme.BRAND_ORANGE;

	TimerPanel(ClockManager clockManager, Timer timer)
	{
		super(clockManager, timer, "timer", true);

		JToggleButton loopButton = new JToggleButton(ClockTabPanel.LOOP_ICON);
		loopButton.setRolloverIcon(ClockTabPanel.LOOP_ICON_HOVER);
		loopButton.setSelectedIcon(ClockTabPanel.LOOP_SELECTED_ICON);
		loopButton.setRolloverSelectedIcon(ClockTabPanel.LOOP_SELECTED_ICON_HOVER);
		SwingUtil.removeButtonDecorations(loopButton);
		loopButton.setPreferredSize(new Dimension(16, 14));
		loopButton.setToolTipText("Loop timer");
		loopButton.addActionListener(e -> timer.setLoop(!timer.isLoop()));
		loopButton.setSelected(timer.isLoop());
		leftActions.add(loopButton);

		JButton deleteButton = new JButton(ClockTabPanel.DELETE_ICON);
		SwingUtil.removeButtonDecorations(deleteButton);
		deleteButton.setRolloverIcon(ClockTabPanel.DELETE_ICON_HOVER);
		deleteButton.setPreferredSize(new Dimension(16, 14));
		deleteButton.setToolTipText("Delete timer");
		deleteButton.addActionListener(e -> clockManager.removeTimer(timer));
		rightActions.add(deleteButton);
	}

	@Override
	void updateDisplayInput()
	{
		super.updateDisplayInput();

		Timer timer = (Timer) getClock();
		if (timer.isWarning())
		{
			displayInput.getTextField().setForeground(getColor());
		}
	}

	@Override
	protected Color getColor()
	{
		Timer timer = (Timer) getClock();
		Color warningColor = timer.isActive() ? WARNING_COLOR : WARNING_COLOR.darker();

		return timer.isWarning() ? warningColor : super.getColor();
	}
}
