/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
import javax.swing.JPanel;
import lombok.Getter;

class PreviewPanel extends JPanel
{
	private static final int CHECKER_SIZE = 10;

	@Getter
	private Color color;

	void setColor(Color c)
	{
		this.color = c;
		this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		for (int x = 0; x < getWidth(); x += CHECKER_SIZE)
		{
			for (int y = 0; y < getHeight(); y += CHECKER_SIZE)
			{
				int val = (x / CHECKER_SIZE + y / CHECKER_SIZE) % 2;
				g.setColor(val == 0 ? Color.LIGHT_GRAY : Color.WHITE);
				g.fillRect(x, y, CHECKER_SIZE, CHECKER_SIZE);
			}
		}

		g.setColor(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
