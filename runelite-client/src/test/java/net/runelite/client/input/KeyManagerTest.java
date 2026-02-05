/*
 * Copyright (c) 2026, BenDol
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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.eventbus.EventBus;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KeyManagerTest
{
	@Inject
	private KeyManager keyManager;

	@Mock
	@Bind
	private Client client;

	@Bind
	private EventBus eventBus = new EventBus();

	private final List<String> order = new ArrayList<>();

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		order.clear();
	}

	@Test
	public void testDefaultPriorityRegistrationOrder()
	{
		KeyListener a = createListener("A");
		KeyListener b = createListener("B");
		KeyListener c = createListener("C");

		keyManager.registerKeyListener(a);
		keyManager.registerKeyListener(b);
		keyManager.registerKeyListener(c);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testLowerPriorityValueProcessedFirst()
	{
		KeyListener normal = createListener("normal");
		KeyListener high = createListener("high");

		keyManager.registerKeyListener(normal);
		keyManager.registerKeyListener(high, -1);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("high", "normal"), order);
	}

	@Test
	public void testMultiplePrioritiesOrdered()
	{
		KeyListener a = createListener("A");
		KeyListener b = createListener("B");
		KeyListener c = createListener("C");
		KeyListener d = createListener("D");

		keyManager.registerKeyListener(a, 5);
		keyManager.registerKeyListener(b);
		keyManager.registerKeyListener(c, -5);
		keyManager.registerKeyListener(d, -10);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("D", "C", "B", "A"), order);
	}

	@Test
	public void testEqualPriorityPreservesRegistrationOrder()
	{
		KeyListener a = createListener("A");
		KeyListener b = createListener("B");
		KeyListener c = createListener("C");

		keyManager.registerKeyListener(a, -5);
		keyManager.registerKeyListener(b, -5);
		keyManager.registerKeyListener(c, -5);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testMixedPrioritiesWithStableOrder()
	{
		KeyListener a = createListener("A");
		KeyListener b = createListener("B");
		KeyListener c = createListener("C");
		KeyListener d = createListener("D");

		keyManager.registerKeyListener(a);
		keyManager.registerKeyListener(b, -1);
		keyManager.registerKeyListener(c);
		keyManager.registerKeyListener(d, -1);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("B", "D", "A", "C"), order);
	}

	@Test
	public void testPositivePriorityProcessedAfterDefault()
	{
		KeyListener low = createListener("low");
		KeyListener normal = createListener("normal");
		KeyListener high = createListener("high");

		keyManager.registerKeyListener(low, 10);
		keyManager.registerKeyListener(normal);
		keyManager.registerKeyListener(high, -10);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("high", "normal", "low"), order);
	}

	@Test
	public void testDuplicateRegistrationIgnored()
	{
		KeyListener a = createListener("A");

		keyManager.registerKeyListener(a);
		keyManager.registerKeyListener(a);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("A"), order);
	}

	@Test
	public void testUnregisterRemovesListener()
	{
		KeyListener a = createListener("A");
		KeyListener b = createListener("B");

		keyManager.registerKeyListener(a);
		keyManager.registerKeyListener(b);
		keyManager.unregisterKeyListener(a);

		keyManager.processKeyPressed(createKeyEvent());

		assertEquals(List.of("B"), order);
	}

	private KeyListener createListener(String name)
	{
		return new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				order.add(name);
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
		};
	}

	private static KeyEvent createKeyEvent()
	{
		return new KeyEvent(new Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
			0, KeyEvent.VK_A, 'a');
	}
}
