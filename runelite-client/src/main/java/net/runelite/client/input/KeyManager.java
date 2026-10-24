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
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;

@Singleton
@Slf4j
public class KeyManager
{
	private final Client client;
	private final ChatboxInputManager chatboxInputManager;

	@Inject
	private KeyManager(@Nullable final Client client, final EventBus eventBus, final ChatboxInputManager chatboxInputManager)
	{
		this.client = client;
		this.chatboxInputManager = chatboxInputManager;
		eventBus.register(this);
	}

	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
	// Raw physical keys, before listeners can remap the event. Guarded by pressedKeys;
	// registration and focus changes can arrive outside the AWT dispatch thread.
	private final Map<Long, Set<KeyListener>> pressedKeys = new HashMap<>();

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
			synchronized (pressedKeys)
			{
				pressedKeys.values().forEach(listeners -> listeners.remove(keyListener));
				pressedKeys.values().removeIf(Set::isEmpty);
			}
			log.debug("Unregistered key listener: {}", keyListener);
		}
	}

	public void processKeyPressed(KeyEvent keyEvent)
	{
		final long key = physicalKey(keyEvent);
		if (keyEvent.isConsumed())
		{
			return;
		}

		boolean chatInputActive = chatboxInputManager.isChatInputActive();
		chatboxInputManager.processKeyPressed(keyEvent);
		chatInputActive |= chatboxInputManager.isChatInputActive();
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			if (!shouldProcess(keyListener, chatInputActive))
			{
				continue;
			}

			log.trace("Processing key pressed {} for key listener {}", keyEvent.paramString(), keyListener);

			synchronized (pressedKeys)
			{
				if (!keyListeners.contains(keyListener))
				{
					continue;
				}
				pressedKeys.computeIfAbsent(key, k -> Collections.newSetFromMap(new IdentityHashMap<>())).add(keyListener);
			}
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
		final Set<KeyListener> listeners;
		synchronized (pressedKeys)
		{
			listeners = pressedKeys.remove(physicalKey(keyEvent));
		}

		if (keyEvent.isConsumed())
		{
			return;
		}

		chatboxInputManager.processKeyReleased(keyEvent);
		if (keyEvent.isConsumed() || listeners == null)
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			// Release pre-chat presses even while typing, but never deliver an orphan release.
			if (!listeners.contains(keyListener) || !shouldProcess(keyListener, false))
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

		boolean chatInputActive = chatboxInputManager.isChatInputActive();
		chatInputActive |= chatboxInputManager.processKeyTyped(keyEvent);
		chatInputActive |= chatboxInputManager.isChatInputActive();
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (KeyListener keyListener : keyListeners)
		{
			if (!shouldProcess(keyListener, chatInputActive))
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

	private boolean shouldProcess(final KeyListener keyListener, boolean chatInputActive)
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

		if (chatInputActive)
		{
			return keyListener.isEnabledOnChatInput();
		}

		return true;
	}

	private static long physicalKey(KeyEvent event)
	{
		return ((long) event.getKeyCode() << 32) | event.getKeyLocation();
	}

	@Subscribe
	private void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			synchronized (pressedKeys)
			{
				pressedKeys.clear();
			}
			for (KeyListener keyListener : keyListeners)
			{
				keyListener.focusLost();
			}
		}
	}
}
