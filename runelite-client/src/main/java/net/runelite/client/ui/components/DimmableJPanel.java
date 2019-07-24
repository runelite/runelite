/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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
import javax.swing.JPanel;
import lombok.Getter;

public class DimmableJPanel extends JPanel
{
	// Dimming state, allows for restoring original colors before dimming
	@Getter
	private boolean dimmed = false;
	private Color dimmedForeground = null;
	private Color dimmedBackground = null;
	private Color undimmedForeground = null;
	private Color undimmedBackground = null;

	@Override
	public void setForeground(Color color)
	{
		undimmedForeground = color;
		dimmedForeground = color.darker();
		super.setForeground(color);
	}

	@Override
	public void setBackground(Color color)
	{
		undimmedBackground = color;
		dimmedBackground = color.darker();
		super.setBackground(color);
	}

	@Override
	public Color getForeground()
	{
		return dimmed ? dimmedForeground : undimmedForeground;
	}

	@Override
	public Color getBackground()
	{
		return dimmed ? dimmedBackground : undimmedBackground;
	}

	/**
	 * Dimming sets all parts of this component with darker colors except for the central label
	 * This is useful for showing that progress is paused
	 * Setting dim to false will restore the original colors from before the component was dimmed.
	 *
	 * @param dimmed
	 */
	public void setDimmed(boolean dimmed)
	{
		this.dimmed = dimmed;

		if (dimmed)
		{
			super.setBackground(dimmedBackground);
			super.setForeground(dimmedForeground);
		}
		else
		{
			super.setBackground(undimmedBackground);
			super.setForeground(undimmedForeground);
		}
	}
}
