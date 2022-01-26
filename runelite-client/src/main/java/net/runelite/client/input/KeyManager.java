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
package net.runelite.client.input;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;

@Singleton
@Slf4j
public class KeyManager
{
	private final Client client;

	@Inject
	private KeyManager(@Nullable final Client client)
	{
		this.client = client;
	}

	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();

	public void registerKeyListener(KeyListener keyListener)
	{
		if (!keyListeners.contains(keyListener))
		{
			log.debug("Registering key listener: {}", keyListener);
			keyListeners.add(keyListener);
		}
	}

	public void unregisterKeyListener(KeyListener keyListener)
	{
		final boolean unregistered = keyListeners.remove(keyListener);
		if (unregistered)
		{
			log.debug("Unregistered key listener: {}", keyListener);
		}
	}

	public void processKeyPressed(KeyEvent keyEvent)
	{
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			if (!shouldProcess(keyListener))
			{
				continue;
			}

			log.trace("Processing key pressed {} for key listener {}", keyEvent.paramString(), keyListener);

			keyListener.keyPressed(keyEvent);
			if (keyEvent.isConsumed())
			{
				log.debug("Consuming key pressed {} for key listener {}", keyEvent.paramString(), keyListener);
				break;
			}
		}
	}

	public void processKeyReleased(KeyEvent keyEvent)
	{
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			if (!shouldProcess(keyListener))
			{
				continue;
			}

			log.trace("Processing key released {} for key listener {}", keyEvent.paramString(), keyListener);

			keyListener.keyReleased(keyEvent);
			if (keyEvent.isConsumed())
			{
				log.debug("Consuming key released {} for listener {}", keyEvent.paramString(), keyListener);
				break;
			}
		}
	}

	public void processKeyTyped(KeyEvent keyEvent)
	{
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			if (!shouldProcess(keyListener))
			{
				continue;
			}

			log.trace("Processing key typed {} for key listener {}", keyEvent.paramString(), keyListener);

			keyListener.keyTyped(keyEvent);
			if (keyEvent.isConsumed())
			{
				log.debug("Consuming key typed {} for key listener {}", keyEvent.paramString(), keyListener);
				break;
			}
		}
	}

	private boolean shouldProcess(final KeyListener keyListener)
	{
		if (client == null)
		{
			return true;
		}

		final GameState gameState = client.getGameState();

		if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.LOGIN_SCREEN_AUTHENTICATOR)
		{
			return keyListener.isEnabledOnLoginScreen();
		}

		return true;
	}
}
