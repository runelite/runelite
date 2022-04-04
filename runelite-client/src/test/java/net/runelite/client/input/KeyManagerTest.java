package net.runelite.client.input;

import java.awt.event.KeyEvent;
import java.util.*;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.Client;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class KeyManagerTest
{
	@Mock
	@Bind
	private Client client;

	@Test
	public void testRegistrationOrder()
	{
		KeyManager keyManager = new KeyManager(client);

		KeyListener keyListenerA = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
		};

		KeyListener keyListenerB = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
		};

		keyManager.registerKeyListener(keyListenerA);
		keyManager.registerKeyListener(keyListenerB);

		Iterator<KeyListener> iterator = keyManager.keyListenerMap.values().iterator();

		for (KeyListener keyListener : Arrays.asList(keyListenerA, keyListenerB))
		{
			assertEquals(iterator.next(), keyListener);
		}
	}


	@Test
	public void testPriorityOrder()
	{
		KeyManager keyManager = new KeyManager(client);

		KeyListener keyListenerNone = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.NONE;
			}
		};

		KeyListener keyListenerLow = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.LOW;
			}
		};

		KeyListener keyListenerMedium = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.MEDIUM;
			}
		};

		KeyListener keyListenerHigh = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.HIGH;
			}
		};

		keyManager.registerKeyListener(keyListenerNone);
		keyManager.registerKeyListener(keyListenerMedium);
		keyManager.registerKeyListener(keyListenerHigh);
		keyManager.registerKeyListener(keyListenerLow);

		Iterator<KeyListener> iterator = keyManager.keyListenerMap.values().iterator();

		for (KeyListener keyListener : Arrays.asList(keyListenerHigh, keyListenerMedium, keyListenerNone, keyListenerLow))
		{
			assertEquals(iterator.next(), keyListener);
		}
	}


	@Test
	public void testPriorityAndLoadOrder()
	{
		KeyManager keyManager = new KeyManager(client);

		KeyListener keyListenerNone = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.NONE;
			}
		};

		KeyListener keyListenerLow = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.LOW;
			}
		};

		KeyListener keyListenerMediumA = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.MEDIUM;
			}
		};

		KeyListener keyListenerMediumB = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.MEDIUM;
			}
		};

		KeyListener keyListenerHigh = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public Priority getPriority()
			{
				return Priority.HIGH;
			}
		};

		keyManager.registerKeyListener(keyListenerNone);
		keyManager.registerKeyListener(keyListenerMediumA);
		keyManager.registerKeyListener(keyListenerHigh);
		keyManager.registerKeyListener(keyListenerMediumB);
		keyManager.registerKeyListener(keyListenerLow);

		Iterator<KeyListener> iterator = keyManager.keyListenerMap.values().iterator();

		for (KeyListener keyListener : Arrays.asList(keyListenerHigh, keyListenerMediumA, keyListenerMediumB, keyListenerNone, keyListenerLow))
		{
			assertEquals(iterator.next(), keyListener);
		}
	}
}
