package net.runelite.client.input;

import java.awt.event.KeyEvent;

@FunctionalInterface
public interface KeyEventInterceptor
{
	default boolean isEnabledOnLoginScreen()
	{
		return false;
	}

	/**
	 * Intercept a key event before it is dispatched to {@link KeyListener}s.
	 * Returning {@code true} stops listener dispatch without consuming the AWT
	 * event. Call {@link KeyEvent#consume()} when the event should also be
	 * blocked from the game client.
	 *
	 * @param event the key event
	 * @return true to stop dispatch to key listeners
	 */
	boolean intercept(KeyEvent event);
}
