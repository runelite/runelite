/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.ui.components.colorpicker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.function.Consumer;
import javax.swing.JPanel;
import lombok.Setter;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.MiscUtils;

public class ColorValueSlider extends JPanel
{
	static final int KNOB_WIDTH = 4;

	private static final int KNOB_HEIGHT = 14;
	private static final Color TRACK_COLOR = new Color(20, 20, 20);
	private static final Color KNOB_COLOR = new Color(150, 150, 150);

	private int value = ColorUtil.MAX_RGB_VALUE + KNOB_WIDTH;

	@Setter
	private Consumer<Integer> onValueChanged;

	ColorValueSlider()
	{
		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent me)
			{
				moveTarget(me.getX(), true);
			}
		});

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent me)
			{
				moveTarget(me.getX(), true);
			}

			@Override
			public void mousePressed(MouseEvent me)
			{
				moveTarget(me.getX(), true);
			}
		});
	}

	public void setValue(int x)
	{
		moveTarget(x + KNOB_WIDTH, false);
	}

	private void moveTarget(int x, boolean shouldUpdate)
	{
		value = MiscUtils.clamp(x, ColorUtil.MIN_RGB_VALUE + KNOB_WIDTH, ColorUtil.MAX_RGB_VALUE + KNOB_WIDTH);
		paintImmediately(0, 0, this.getWidth(), this.getHeight());

		if (shouldUpdate && onValueChanged != null)
		{
			onValueChanged.accept(getValue());
		}
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		g.setColor(TRACK_COLOR);
		g.fillRect(0, this.getHeight() / 2 - 2, this.getWidth() - KNOB_WIDTH, 5);

		g.setColor(KNOB_COLOR);
		g.fillRect(value - KNOB_WIDTH / 2, this.getHeight() / 2 - KNOB_HEIGHT / 2, KNOB_WIDTH, KNOB_HEIGHT);
	}

	int getValue()
	{
		return value - KNOB_WIDTH;
	}
}
