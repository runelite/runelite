/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.ui;

import java.awt.Rectangle;
import javax.swing.JFrame;
import lombok.Getter;

public class ContainableFrame extends JFrame
{
	@Getter
	private boolean containedInScreen;

	public void setContainedInScreen(boolean value)
	{
		this.containedInScreen = value;
		if (value)
		{
			// Reposition the frame if it is intersecting with the bounds
			this.setLocation(this.getX(), this.getY());
			this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void setLocation(int x, int y)
	{
		if (containedInScreen)
		{
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			x = Math.max(x, (int)bounds.getX());
			x = Math.min(x, (int)(bounds.getX() + bounds.getWidth() - this.getWidth()));
			y = Math.max(y, (int)bounds.getY());
			y = Math.min(y, (int)(bounds.getY() + bounds.getHeight() - this.getHeight()));
		}
		super.setLocation(x, y);
	}

	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		if (containedInScreen)
		{
			Rectangle bounds = this.getGraphicsConfiguration().getBounds();
			width = Math.min(width, width - (int)bounds.getX() + x);
			x = Math.max(x, (int)bounds.getX());
			height = Math.min(height, height - (int)bounds.getY() + y);
			y = Math.max(y, (int)bounds.getY());
			width = Math.min(width, (int)(bounds.getX() + bounds.getWidth()) - x);
			height = Math.min(height, (int)(bounds.getY() + bounds.getHeight()) - y);
		}
		super.setBounds(x, y, width, height);
	}
}
