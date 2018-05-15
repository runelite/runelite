/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import java.applet.Applet;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseListener;

class ClientUIInputListener extends MouseListener implements KeyListener
{
	private final Applet client;
	private final ClientUI clientUi;

	ClientUIInputListener(Applet client, ClientUI clientUi)
	{
		this.client = client;
		this.clientUi = clientUi;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		if (client == null || !(client instanceof Client) || !SwingUtilities.isLeftMouseButton(mouseEvent))
		{
			return mouseEvent;
		}

		final Client client = (Client)this.client;
		final Rectangle bounds = new Rectangle(
			client.getRealDimensions().width - ClientUI.SIDEBAR_OPEN.getWidth() - 5,
			5,
			ClientUI.SIDEBAR_OPEN.getWidth(),
			ClientUI.SIDEBAR_OPEN.getHeight());

		if (bounds.contains(mouseEvent.getPoint()))
		{
			SwingUtilities.invokeLater(clientUi::toggleSidebar);
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F11)
		{
			SwingUtilities.invokeLater(clientUi::toggleSidebar);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
