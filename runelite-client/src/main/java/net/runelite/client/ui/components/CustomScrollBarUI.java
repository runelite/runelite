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
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import lombok.Setter;
import net.runelite.client.ui.ColorScheme;

/**
 * This scroll bar UI is to be used for the "RuneLite Obsidian" client theme.
 * It is a part of the client's redesign as detailed on issue #1342
 */
public class CustomScrollBarUI extends BasicScrollBarUI
{

	/* The background color of the bar's thumb */
	@Setter
	private Color thumbColor = ColorScheme.MEDIUM_GRAY_COLOR;

	/* The background color of the bar's track */
	@Setter
	private Color trackColor = ColorScheme.SCROLL_TRACK_COLOR;

	/**
	 * Overrides the painting of the bar's track (the darker part underneath that extends
	 * the full page length).
	 */
	@Override
	protected void paintTrack(Graphics graphics, JComponent jComponent, Rectangle rectangle)
	{
		graphics.setColor(trackColor);
		graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

	/**
	 * Overrides the painting of the bar's thumb (the lighter part on top that users
	 * use to slide up and down the page).
	 */
	@Override
	protected void paintThumb(Graphics graphics, JComponent jComponent, Rectangle rectangle)
	{
		graphics.setColor(thumbColor);
		graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

	/**
	 * Creates an empty JButton to be used as the scroll bar's arrows (to disable the arrows).
	 */
	protected JButton createEmptyButton()
	{
		JButton button = new JButton();
		Dimension zeroDim = new Dimension(0, 0);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		return button;
	}

	public static ComponentUI createUI(JComponent c)
	{
		JScrollBar bar = (JScrollBar) c;
		bar.setUnitIncrement(16);
		bar.setPreferredSize(new Dimension(7, 0));
		return new CustomScrollBarUI();
	}

	/**
	 * Applies an empty button to the decrease (down arrow) button.
	 */
	@Override
	protected JButton createDecreaseButton(int orientation)
	{
		return createEmptyButton();
	}

	/**
	 * Applies an empty button to the increase (up arrow) button.
	 */
	@Override
	protected JButton createIncreaseButton(int orientation)
	{
		return createEmptyButton();
	}
}