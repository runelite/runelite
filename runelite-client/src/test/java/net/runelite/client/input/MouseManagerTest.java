/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.client.config.RuneLiteConfig;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MouseManagerTest
{
	@Inject
	private MouseManager mouseManager;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

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
		MouseListener a = createMouseListener("A");
		MouseListener b = createMouseListener("B");
		MouseListener c = createMouseListener("C");

		mouseManager.registerMouseListener(a);
		mouseManager.registerMouseListener(b);
		mouseManager.registerMouseListener(c);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testLowerPriorityValueProcessedFirst()
	{
		MouseListener normal = createMouseListener("normal");
		MouseListener high = createMouseListener("high");

		mouseManager.registerMouseListener(normal);
		mouseManager.registerMouseListener(high, -1);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("high", "normal"), order);
	}

	@Test
	public void testMultiplePrioritiesOrdered()
	{
		MouseListener a = createMouseListener("A");
		MouseListener b = createMouseListener("B");
		MouseListener c = createMouseListener("C");
		MouseListener d = createMouseListener("D");

		mouseManager.registerMouseListener(a, 5);
		mouseManager.registerMouseListener(b);
		mouseManager.registerMouseListener(c, -5);
		mouseManager.registerMouseListener(d, -10);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("D", "C", "B", "A"), order);
	}

	@Test
	public void testEqualPriorityPreservesRegistrationOrder()
	{
		MouseListener a = createMouseListener("A");
		MouseListener b = createMouseListener("B");
		MouseListener c = createMouseListener("C");

		mouseManager.registerMouseListener(a, -5);
		mouseManager.registerMouseListener(b, -5);
		mouseManager.registerMouseListener(c, -5);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testMixedPrioritiesWithStableOrder()
	{
		MouseListener a = createMouseListener("A");
		MouseListener b = createMouseListener("B");
		MouseListener c = createMouseListener("C");
		MouseListener d = createMouseListener("D");

		mouseManager.registerMouseListener(a);
		mouseManager.registerMouseListener(b, -1);
		mouseManager.registerMouseListener(c);
		mouseManager.registerMouseListener(d, -1);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("B", "D", "A", "C"), order);
	}

	@Test
	public void testPositivePriorityProcessedAfterDefault()
	{
		MouseListener low = createMouseListener("low");
		MouseListener normal = createMouseListener("normal");
		MouseListener high = createMouseListener("high");

		mouseManager.registerMouseListener(low, 10);
		mouseManager.registerMouseListener(normal);
		mouseManager.registerMouseListener(high, -10);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("high", "normal", "low"), order);
	}

	@Test
	public void testDuplicateRegistrationIgnored()
	{
		MouseListener a = createMouseListener("A");

		mouseManager.registerMouseListener(a);
		mouseManager.registerMouseListener(a);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("A"), order);
	}

	@Test
	public void testUnregisterRemovesListener()
	{
		MouseListener a = createMouseListener("A");
		MouseListener b = createMouseListener("B");

		mouseManager.registerMouseListener(a);
		mouseManager.registerMouseListener(b);
		mouseManager.unregisterMouseListener(a);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("B"), order);
	}

	@Test
	public void testMouseWheelDefaultPriorityRegistrationOrder()
	{
		MouseWheelListener a = createMouseWheelListener("A");
		MouseWheelListener b = createMouseWheelListener("B");
		MouseWheelListener c = createMouseWheelListener("C");

		mouseManager.registerMouseWheelListener(a);
		mouseManager.registerMouseWheelListener(b);
		mouseManager.registerMouseWheelListener(c);

		mouseManager.processMouseWheelMoved(createMouseWheelEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testMouseWheelLowerPriorityValueProcessedFirst()
	{
		MouseWheelListener normal = createMouseWheelListener("normal");
		MouseWheelListener high = createMouseWheelListener("high");

		mouseManager.registerMouseWheelListener(normal);
		mouseManager.registerMouseWheelListener(high, -1);

		mouseManager.processMouseWheelMoved(createMouseWheelEvent());

		assertEquals(List.of("high", "normal"), order);
	}

	@Test
	public void testMouseWheelEqualPriorityPreservesRegistrationOrder()
	{
		MouseWheelListener a = createMouseWheelListener("A");
		MouseWheelListener b = createMouseWheelListener("B");
		MouseWheelListener c = createMouseWheelListener("C");

		mouseManager.registerMouseWheelListener(a, -5);
		mouseManager.registerMouseWheelListener(b, -5);
		mouseManager.registerMouseWheelListener(c, -5);

		mouseManager.processMouseWheelMoved(createMouseWheelEvent());

		assertEquals(List.of("A", "B", "C"), order);
	}

	@Test
	public void testDeprecatedMouseListenerInsertBefore()
	{
		MouseListener first = createMouseListener("first");
		MouseListener second = createMouseListener("second");

		// Both use deprecated overload with position 0 (same priority).
		// INSERT_BEFORE: second goes before first among same-priority.
		mouseManager.registerMouseListener(0, first);
		mouseManager.registerMouseListener(0, second);

		mouseManager.processMousePressed(createMouseEvent());

		assertEquals(List.of("second", "first"), order);
	}

	@Test
	public void testDeprecatedMouseWheelListenerInsertBefore()
	{
		MouseWheelListener first = createMouseWheelListener("first");
		MouseWheelListener second = createMouseWheelListener("second");

		// Both use deprecated overload with position 0 (same priority).
		// INSERT_BEFORE: second goes before first among same-priority.
		mouseManager.registerMouseWheelListener(0, first);
		mouseManager.registerMouseWheelListener(0, second);

		mouseManager.processMouseWheelMoved(createMouseWheelEvent());

		assertEquals(List.of("second", "first"), order);
	}

	private MouseListener createMouseListener(String name)
	{
		return new MouseListener()
		{
			@Override
			public MouseEvent mouseClicked(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}

			@Override
			public MouseEvent mousePressed(MouseEvent mouseEvent)
			{
				order.add(name);
				return mouseEvent;
			}

			@Override
			public MouseEvent mouseReleased(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}

			@Override
			public MouseEvent mouseEntered(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}

			@Override
			public MouseEvent mouseExited(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}

			@Override
			public MouseEvent mouseDragged(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}

			@Override
			public MouseEvent mouseMoved(MouseEvent mouseEvent)
			{
				return mouseEvent;
			}
		};
	}

	private MouseWheelListener createMouseWheelListener(String name)
	{
		return new MouseWheelListener()
		{
			@Override
			public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
			{
				order.add(name);
				return event;
			}
		};
	}

	private static MouseEvent createMouseEvent()
	{
		return new MouseEvent(new Canvas(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
			0, 50, 50, 1, false, MouseEvent.BUTTON1);
	}

	private static MouseWheelEvent createMouseWheelEvent()
	{
		return new MouseWheelEvent(new Canvas(), MouseWheelEvent.MOUSE_WHEEL, System.currentTimeMillis(),
			0, 50, 50, 0, false, MouseWheelEvent.WHEEL_UNIT_SCROLL, 3, 1);
	}
}
