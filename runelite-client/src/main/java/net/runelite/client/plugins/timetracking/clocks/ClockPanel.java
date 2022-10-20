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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.FlatTextField;
import net.runelite.client.util.SwingUtil;

abstract class ClockPanel extends JPanel
{
	private static final Border NAME_BOTTOM_BORDER = new CompoundBorder(
		BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
		BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR));

	private static final Color ACTIVE_CLOCK_COLOR = ColorScheme.LIGHT_GRAY_COLOR.brighter();
	private static final Color INACTIVE_CLOCK_COLOR = ColorScheme.LIGHT_GRAY_COLOR.darker();

	private static final String INPUT_HMS_REGEX = ".*[hms].*";
	private static final String WHITESPACE_REGEX = "\\s+";

	// additional content or buttons should be added to these panels in the subclasses
	final JPanel contentContainer;
	final JPanel leftActions;
	final JPanel rightActions;

	private final FlatTextField nameInput;
	private final JToggleButton startPauseButton;
	protected final FlatTextField displayInput;

	@Getter
	private final Clock clock;

	private final String clockType;
	private final boolean editable;

	ClockPanel(ClockManager clockManager, Clock clock, String clockType, boolean editable)
	{
		this.clock = clock;
		this.clockType = clockType;
		this.editable = editable;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(3, 0, 0, 0));

		JPanel nameWrapper = new JPanel(new BorderLayout());
		nameWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameWrapper.setBorder(NAME_BOTTOM_BORDER);

		nameInput = new FlatTextField();
		nameInput.setText(clock.getName());
		nameInput.setBorder(null);
		nameInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		nameInput.setPreferredSize(new Dimension(0, 24));
		nameInput.getTextField().setBorder(new EmptyBorder(0, 8, 0, 0));
		nameInput.addActionListener(e -> getParent().requestFocusInWindow());

		nameInput.getTextField().addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				nameInput.getTextField().selectAll();
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				clock.setName(nameInput.getText());
				clockManager.saveToConfig();
			}
		});

		nameWrapper.add(nameInput, BorderLayout.CENTER);

		JPanel mainContainer = new JPanel(new BorderLayout());
		mainContainer.setBorder(new EmptyBorder(5, 0, 0, 0));
		mainContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		contentContainer = new JPanel(new BorderLayout());
		contentContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		displayInput = new FlatTextField();
		displayInput.setEditable(editable);
		displayInput.setBorder(null);
		displayInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		displayInput.setPreferredSize(new Dimension(0, 24));
		displayInput.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		displayInput.addActionListener(e -> getParent().requestFocusInWindow());

		displayInput.getTextField().addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				displayInput.getTextField().setForeground(INACTIVE_CLOCK_COLOR);
				displayInput.getTextField().selectAll();
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				long duration = 0;

				try
				{
					duration = stringToSeconds(displayInput.getText());
				}
				catch (Exception ignored)
				{
				}

				clock.setDuration(Math.max(0, duration));
				clock.reset();
				clockManager.checkForWarnings();
				updateDisplayInput();
				updateActivityStatus();
				clockManager.saveTimers();
			}
		});

		updateDisplayInput();

		contentContainer.add(displayInput, BorderLayout.NORTH);

		JPanel actionsBar = new JPanel(new BorderLayout());
		actionsBar.setBorder(new EmptyBorder(4, 0, 4, 0));
		actionsBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		leftActions = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
		leftActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		startPauseButton = new JToggleButton(ClockTabPanel.START_ICON);
		startPauseButton.setRolloverIcon(ClockTabPanel.START_ICON_HOVER);
		startPauseButton.setSelectedIcon(ClockTabPanel.PAUSE_ICON);
		startPauseButton.setRolloverSelectedIcon(ClockTabPanel.PAUSE_ICON_HOVER);
		SwingUtil.removeButtonDecorations(startPauseButton);
		startPauseButton.setPreferredSize(new Dimension(16, 14));
		updateActivityStatus();

		startPauseButton.addActionListener(e ->
		{
			if (!startPauseButton.isSelected())
			{
				clock.pause();
			}
			else if (!clock.start())
			{
				return;
			}

			updateActivityStatus();
			clockManager.saveToConfig();
		});

		JButton resetButton = new JButton(ClockTabPanel.RESET_ICON);
		resetButton.setRolloverIcon(ClockTabPanel.RESET_ICON_HOVER);
		SwingUtil.removeButtonDecorations(resetButton);
		resetButton.setPreferredSize(new Dimension(16, 14));
		resetButton.setToolTipText("Reset " + clockType);

		resetButton.addActionListener(e ->
		{
			clock.reset();
			clockManager.checkForWarnings();
			reset();
			clockManager.saveToConfig();
		});

		leftActions.add(startPauseButton);
		leftActions.add(resetButton);

		rightActions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
		rightActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		actionsBar.add(leftActions, BorderLayout.WEST);
		actionsBar.add(rightActions, BorderLayout.EAST);

		mainContainer.add(contentContainer, BorderLayout.CENTER);
		mainContainer.add(actionsBar, BorderLayout.SOUTH);

		add(nameWrapper, BorderLayout.NORTH);
		add(mainContainer, BorderLayout.CENTER);
	}

	void reset()
	{
		updateDisplayInput();
		updateActivityStatus();
	}

	void updateDisplayInput()
	{
		if (!displayInput.getTextField().hasFocus())
		{
			displayInput.setText(getFormattedDuration(clock.getDisplayTime()));
		}
	}

	void updateActivityStatus()
	{
		boolean isActive = clock.isActive();

		displayInput.setEditable(editable && !isActive);
		displayInput.getTextField().setForeground(getColor());
		startPauseButton.setToolTipText(isActive ? "Pause " + clockType : "Start " + clockType);
		startPauseButton.setSelected(isActive);

		if (editable && clock.getDisplayTime() == 0 && !isActive)
		{
			displayInput.getTextField().setForeground(ColorScheme.PROGRESS_ERROR_COLOR.darker());
		}
	}

	protected Color getColor()
	{
		return clock.isActive() ? ACTIVE_CLOCK_COLOR : INACTIVE_CLOCK_COLOR;
	}

	static String getFormattedDuration(long duration)
	{
		long hours = duration / (60 * 60);
		long mins = (duration / 60) % 60;
		long seconds = duration % 60;

		return String.format("%02d:%02d:%02d", hours, mins, seconds);
	}

	static long stringToSeconds(String time) throws NumberFormatException, DateTimeParseException
	{
		long duration = 0;

		if (time.matches(INPUT_HMS_REGEX))
		{
			String textWithoutWhitespaces = time.replaceAll(WHITESPACE_REGEX, "");
			//parse input using ISO-8601 Duration format (e.g. 'PT1h30m10s')
			duration = Duration.parse("PT" + textWithoutWhitespaces).toMillis() / 1000;
		}
		else
		{
			String[] parts = time.split(":");
			// parse from back to front, so as to accept hour:min:sec, min:sec, and sec formats
			for (int i = parts.length - 1, multiplier = 1; i >= 0 && multiplier <= 3600; i--, multiplier *= 60)
			{
				duration += Integer.parseInt(parts[i].trim()) * multiplier;
			}
		}

		return duration;
	}
}
