/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.mixins;

import java.awt.Canvas;
import java.awt.event.FocusListener;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSGameCanvas;

@Mixin(RSGameCanvas.class)
public abstract class RSGameCanvasMixin extends Canvas implements RSGameCanvas
{
	@Shadow("clientInstance")
	private static RSClient client;

	// This is inverted because it is false initialized.
	@Inject
	private static boolean shouldNotHaveFocus;

	@Inject
	@Override
	public void removeFocusListener(FocusListener l)
	{
		super.removeFocusListener(l);
		shouldNotHaveFocus = !this.hasFocus();
	}

	@Inject
	@Override
	public void requestFocus()
	{
		// Runescape requests focus whenever the window is resized. Because of this, PluginPanels cannot have focus
		// if they cause the sidebar to expand. This change prevents Runescape from requesting focus whenever it wants
		if (!shouldNotHaveFocus)
		{
			this.requestFocusInWindow();
		}
	}

	@Inject
	@Override
	public void setSize(int width, int height)
	{
		if (client.isStretchedEnabled())
		{
			super.setSize(client.getStretchedDimensions().width, client.getStretchedDimensions().height);
		}
		else
		{
			super.setSize(width, height);
		}
	}

	@Inject
	@Override
	public void setLocation(int x, int y)
	{
		if (client.isStretchedEnabled())
		{
			super.setLocation((getParent().getWidth() - client.getStretchedDimensions().width) / 2, 0);
		}
		else
		{
			super.setLocation(x, y);
		}
	}
}
