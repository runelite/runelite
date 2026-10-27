package net.runelite.client.input;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KeyManagerTest
{
	@Inject
	private KeyManager keyManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private EventBus eventBus;

	@Mock
	private KeyListener keyListener;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);

		keyManager.registerKeyListener(keyListener);
	}

	@Test
	public void testInterceptorStopsListenerDispatchWithoutConsumingEvent()
	{
		KeyEvent event = keyEvent(KeyEvent.KEY_PRESSED);
		keyManager.registerKeyEventInterceptor(e -> true);

		keyManager.processKeyPressed(event);

		verify(keyListener, never()).keyPressed(event);
		assertFalse(event.isConsumed());
	}

	@Test
	public void testInterceptorPassesEventThrough()
	{
		KeyEvent event = keyEvent(KeyEvent.KEY_PRESSED);
		keyManager.registerKeyEventInterceptor(e -> false);

		keyManager.processKeyPressed(event);

		verify(keyListener).keyPressed(event);
		assertFalse(event.isConsumed());
	}

	private static KeyEvent keyEvent(int id)
	{
		return new KeyEvent(new Canvas(), id, 0, 0, KeyEvent.VK_A, 'a');
	}
}
