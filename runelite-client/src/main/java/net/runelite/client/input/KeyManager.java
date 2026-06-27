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
import java.util.function.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.util.Prioritized;

@Singleton
@Slf4j
public class KeyManager
{
	private final Client client;
	private final List<Prioritized<KeyListener>> keyListeners = new CopyOnWriteArrayList<>();

	@Inject
	private KeyManager(@Nullable final Client client, final EventBus eventBus)
	{
		this.client = client;
		eventBus.register(this);
	}

	/**
	 * Register a key listener with default priority (0).
	 * First in first served at priority 0.
	 *
	 * @param keyListener the key listener to register
	 */
	public void registerKeyListener(KeyListener keyListener)
	{
		registerKeyListener(keyListener, 0);
	}

	/**
	 * Register a key listener with the given priority.
	 * Listeners with lower priority values are processed first.
	 *
	 * @param keyListener the key listener to register
	 * @param priority the priority value
	 */
	public void registerKeyListener(KeyListener keyListener, int priority)
	{
		registerKeyListener(keyListener, priority, false);
	}

	/**
	 * Register a key listener with the given priority.
	 * Listeners with lower priority values are processed first.
	 *
	 * @param keyListener the key listener to register
	 * @param priority the priority value
	 */
	public void registerKeyListener(KeyListener keyListener, int priority, boolean insertBefore)
	{
		if (findEntry(keyListener) != null)
		{
			return;
		}

		log.debug("Registering key listener: {}", keyListener);
		Prioritized<KeyListener> entry = new Prioritized<>(keyListener, priority);
		int index = findInsertionIndex(keyListeners, priority, Prioritized::getPriority, insertBefore);
		keyListeners.add(index, entry);
	}

	public void unregisterKeyListener(KeyListener keyListener)
	{
		Prioritized<KeyListener> entry = findEntry(keyListener);
		if (entry != null)
		{
			keyListeners.remove(entry);
			log.debug("Unregistered key listener: {}", keyListener);
		}
	}

	public void processKeyPressed(KeyEvent keyEvent)
	{
		if (keyEvent.isConsumed())
		{
			return;
		}

		for (Prioritized<KeyListener> entry : keyListeners)
		{
			KeyListener keyListener = entry.getObject();
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

		for (Prioritized<KeyListener> entry : keyListeners)
		{
			KeyListener keyListener = entry.getObject();
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

		for (Prioritized<KeyListener> entry : keyListeners)
		{
			KeyListener keyListener = entry.getObject();
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

	@Subscribe
	private void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			for (Prioritized<KeyListener> entry : keyListeners)
			{
				entry.getObject().focusLost();
			}
		}
	}

	private Prioritized<KeyListener> findEntry(KeyListener keyListener)
	{
		for (Prioritized<KeyListener> entry : keyListeners)
		{
			if (entry.getObject() == keyListener)
			{
				return entry;
			}
		}
		return null;
	}

	/**
	 * Find the insertion index for a listener with the given priority.
	 * The list is sorted in ascending order (lower value = higher priority = processed first).
	 *
	 * @param list the list to search
	 * @param priority the priority value
	 * @param priorityProvider function to extract the priority from list entries
	 * @param insertBefore if true, insert before existing listeners with the same priority;
	 *                     if false, insert after them (preserving registration order)
	 * @return the index at which to insert a new listener with the given priority
	 */
	private <T> int findInsertionIndex(List<T> list, int priority, Function<T, Integer> priorityProvider, boolean insertBefore)
	{
		int lo = 0, hi = list.size();
		while (lo < hi)
		{
			int mid = (lo + hi) >>> 1;
			if (insertBefore
				? priorityProvider.apply(list.get(mid)) < priority
				: priorityProvider.apply(list.get(mid)) <= priority)
			{
				lo = mid + 1;
			}
			else
			{
				hi = mid;
			}
		}
		return lo;
	}
}
