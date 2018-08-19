/*
 * Copyright (c) 2018, JustAPerson <https://github.com/JustAPerson>
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
package net.runelite.client.plugins.refocus;

import com.google.common.eventbus.Subscribe;
import java.awt.Robot;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;

@PluginDescriptor(
		name = "Refocus",
		description = "Move cursor over character after alt-tabbing",
		tags = {"alt", "tab", "cursor", "mouse", "window", "focus"},
		enabledByDefault = false
)
public class RefocusPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private ClientUI clientUi;

	private Robot robot;
	private int mouseX = 0, mouseY = 0;

	@Override
	protected void startUp() throws Exception {
		robot = new Robot();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (focusChanged.isFocused()) {
			Point w = clientUi.getWindowOffset();
			Point c = clientUi.getCanvasOffset();
			int x = w.getX() + c.getX() + client.getViewportXOffset() + mouseX;
			int y = w.getY() + c.getX() + client.getViewportYOffset() + mouseY + 23;
			// constant comes from net.runelite.client.ui.ClientTitleToolbar.TITLEBAR_SIZE
			robot.mouseMove(x, y);
		} else {
			Point p = client.getMouseCanvasPosition(); // -1,-1 if mouse out of bounds
			if (p.getX() >= 0 && p.getY() >= 0) {
				mouseX = p.getX();
				mouseY = p.getY();
			}
		}
	}
}
