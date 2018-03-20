/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.wasdcamera;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.input.KeyListener;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

@Slf4j
public class WASDCameraInputListener implements KeyListener
{
	@Inject
	private WASDCameraPlugin plugin;

	@Override
	public void keyTyped(KeyEvent e)
	{
		//log.debug("Typed: " + e);

		if (plugin.isInGame() && !plugin.isChatMode())
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//log.debug("Pressed: " + e);

		if (!plugin.isInGame())
		{
			return;
		}

		if (plugin.isChatMode())
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_ESCAPE:
					e.consume();
				case KeyEvent.VK_ENTER:
					plugin.setChatMode(false);
					break;
			}
		}
		else
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_W:
					e.setKeyCode(KeyEvent.VK_UP);
					break;
				case KeyEvent.VK_A:
					e.setKeyCode(KeyEvent.VK_LEFT);
					break;
				case KeyEvent.VK_S:
					e.setKeyCode(KeyEvent.VK_DOWN);
					break;
				case KeyEvent.VK_D:
					e.setKeyCode(KeyEvent.VK_RIGHT);
					break;

				case KeyEvent.VK_ENTER:
					e.consume();
					plugin.setChatMode(true);
					break;

				case KeyEvent.VK_BACK_SPACE:
					e.consume();
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//log.debug("Released: " + e);

		if (plugin.isInGame() && !plugin.isChatMode())
		{
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_W:
					e.setKeyCode(KeyEvent.VK_UP);
					break;
				case KeyEvent.VK_A:
					e.setKeyCode(KeyEvent.VK_LEFT);
					break;
				case KeyEvent.VK_S:
					e.setKeyCode(KeyEvent.VK_DOWN);
					break;
				case KeyEvent.VK_D:
					e.setKeyCode(KeyEvent.VK_RIGHT);
					break;

				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_BACK_SPACE:
					e.consume();
					break;
			}
		}
	}
}

