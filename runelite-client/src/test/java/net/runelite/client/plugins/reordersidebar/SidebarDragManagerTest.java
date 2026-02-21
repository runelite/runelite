/*
 * Copyright (c) 2026, Swirle13 <https://github.com/swirle13>
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
package net.runelite.client.plugins.reordersidebar;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import net.runelite.client.config.Keybind;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.DragAndDropTabbedPane;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SidebarDragManagerTest
{
	@Mock
	private ReorderSidebarConfig config;

	@Mock
	private DragAndDropTabbedPane sidebar;

	private List<NavigationButton> sidebarTabOrder;
	private AtomicInteger fromIndexCapture;
	private AtomicInteger toIndexCapture;
	private AtomicBoolean callbackInvoked;

	private SidebarDragManager dragManager;

	@Before
	public void setUp()
	{
		sidebarTabOrder = new ArrayList<>();
		fromIndexCapture = new AtomicInteger(-1);
		toIndexCapture = new AtomicInteger(-1);
		callbackInvoked = new AtomicBoolean(false);

		when(config.dragRequiresHotkey()).thenReturn(false);
		when(config.dragHotkey()).thenReturn(Keybind.SHIFT);

		dragManager = new SidebarDragManager(
			config,
			sidebar,
			sidebarTabOrder,
			(from, to) ->
			{
				callbackInvoked.set(true);
				fromIndexCapture.set(from);
				toIndexCapture.set(to);
			}
		);
	}

	private NavigationButton createNavButton(String tooltip, int priority)
	{
		return NavigationButton.builder()
			.tooltip(tooltip)
			.icon(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB))
			.priority(priority)
			.build();
	}

	@Test
	public void testInstallEnablesDragOnSidebar()
	{
		dragManager.install();

		verify(sidebar).setDragEnabled(true);
		verify(sidebar).setDragAllowedSupplier(any());
		verify(sidebar).addTabDragListener(any());
	}

	@Test
	public void testUninstallDisablesDragOnSidebar()
	{
		dragManager.install();
		dragManager.uninstall();

		verify(sidebar).setDragEnabled(false);
		verify(sidebar).setDragAllowedSupplier(null);
		verify(sidebar).removeTabDragListener(any());
	}

	@Test
	public void testDragAllowedWhenHotkeyNotRequired()
	{
		when(config.dragRequiresHotkey()).thenReturn(false);

		dragManager.install();

		ArgumentCaptor<Supplier<Boolean>> captor = ArgumentCaptor.forClass(Supplier.class);
		verify(sidebar).setDragAllowedSupplier(captor.capture());

		Supplier<Boolean> supplier = captor.getValue();
		assertTrue("Drag should be allowed when hotkey not required", supplier.get());
	}

	@Test
	public void testDragNotAllowedWhenHotkeyRequiredButNotPressed()
	{
		when(config.dragRequiresHotkey()).thenReturn(true);
		when(config.dragHotkey()).thenReturn(Keybind.SHIFT);

		dragManager.install();

		ArgumentCaptor<Supplier<Boolean>> captor = ArgumentCaptor.forClass(Supplier.class);
		verify(sidebar).setDragAllowedSupplier(captor.capture());

		Supplier<Boolean> supplier = captor.getValue();
		// hotkeyDown is false by default
		assertFalse("Drag should not be allowed when hotkey required but not pressed", supplier.get());
	}

	@Test
	public void testDragAllowedWhenHotkeyNotSet()
	{
		when(config.dragRequiresHotkey()).thenReturn(true);
		when(config.dragHotkey()).thenReturn(Keybind.NOT_SET);

		dragManager.install();

		ArgumentCaptor<Supplier<Boolean>> captor = ArgumentCaptor.forClass(Supplier.class);
		verify(sidebar).setDragAllowedSupplier(captor.capture());

		Supplier<Boolean> supplier = captor.getValue();
		// If hotkey is NOT_SET, drag should be allowed
		assertTrue("Drag should be allowed when hotkey is NOT_SET", supplier.get());
	}

	@Test
	public void testDragAllowedWhenHotkeyNull()
	{
		when(config.dragRequiresHotkey()).thenReturn(true);
		when(config.dragHotkey()).thenReturn(null);

		dragManager.install();

		ArgumentCaptor<Supplier<Boolean>> captor = ArgumentCaptor.forClass(Supplier.class);
		verify(sidebar).setDragAllowedSupplier(captor.capture());

		Supplier<Boolean> supplier = captor.getValue();
		// If hotkey is null, drag should be allowed
		assertTrue("Drag should be allowed when hotkey is null", supplier.get());
	}

	@Test
	public void testTabDragListenerUpdatesOrder()
	{
		NavigationButton btn1 = createNavButton("Config", 0);
		NavigationButton btn2 = createNavButton("XP Tracker", 2);
		NavigationButton btn3 = createNavButton("Hiscore", 5);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);
		sidebarTabOrder.add(btn3);

		dragManager.install();

		// Capture the tab drag listener
		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();
		assertNotNull(listener);

		// Simulate drag from index 0 to index 2
		listener.onTabDragged(0, 2);

		// Verify the callback was invoked
		assertTrue(callbackInvoked.get());
		assertEquals(0, fromIndexCapture.get());
		assertEquals(2, toIndexCapture.get());

		// Verify the order was updated
		assertEquals("XP Tracker", sidebarTabOrder.get(0).getTooltip());
		assertEquals("Hiscore", sidebarTabOrder.get(1).getTooltip());
		assertEquals("Config", sidebarTabOrder.get(2).getTooltip());
	}

	@Test
	public void testTabDragListenerIgnoresInvalidIndices()
	{
		NavigationButton btn1 = createNavButton("Config", 0);
		sidebarTabOrder.add(btn1);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Test negative indices
		listener.onTabDragged(-1, 0);
		assertFalse("Callback should not be invoked for negative fromIndex", callbackInvoked.get());

		// Test out of bounds indices
		listener.onTabDragged(0, 10);
		assertFalse("Callback should not be invoked for out of bounds toIndex", callbackInvoked.get());
	}

	@Test
	public void testTabDragListenerHandlesSameIndex()
	{
		NavigationButton btn1 = createNavButton("Config", 0);
		NavigationButton btn2 = createNavButton("XP Tracker", 2);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Drag to same position
		listener.onTabDragged(0, 0);

		// Callback should still be invoked (list operations are valid)
		assertTrue(callbackInvoked.get());
		// Order should remain the same
		assertEquals("Config", sidebarTabOrder.get(0).getTooltip());
		assertEquals("XP Tracker", sidebarTabOrder.get(1).getTooltip());
	}

	@Test
	public void testUninstallRemovesKeyDispatcher()
	{
		// Install first
		dragManager.install();

		// Then uninstall
		dragManager.uninstall();

		// Verify drag is disabled
		verify(sidebar).setDragEnabled(false);
	}

	@Test
	public void testDragFirstToLast()
	{
		NavigationButton btn1 = createNavButton("First", 0);
		NavigationButton btn2 = createNavButton("Second", 1);
		NavigationButton btn3 = createNavButton("Third", 2);
		NavigationButton btn4 = createNavButton("Fourth", 3);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);
		sidebarTabOrder.add(btn3);
		sidebarTabOrder.add(btn4);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Drag first item to last position
		listener.onTabDragged(0, 3);

		assertEquals("Second", sidebarTabOrder.get(0).getTooltip());
		assertEquals("Third", sidebarTabOrder.get(1).getTooltip());
		assertEquals("Fourth", sidebarTabOrder.get(2).getTooltip());
		assertEquals("First", sidebarTabOrder.get(3).getTooltip());
	}

	@Test
	public void testDragLastToFirst()
	{
		NavigationButton btn1 = createNavButton("First", 0);
		NavigationButton btn2 = createNavButton("Second", 1);
		NavigationButton btn3 = createNavButton("Third", 2);
		NavigationButton btn4 = createNavButton("Fourth", 3);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);
		sidebarTabOrder.add(btn3);
		sidebarTabOrder.add(btn4);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Drag last item to first position
		listener.onTabDragged(3, 0);

		assertEquals("Fourth", sidebarTabOrder.get(0).getTooltip());
		assertEquals("First", sidebarTabOrder.get(1).getTooltip());
		assertEquals("Second", sidebarTabOrder.get(2).getTooltip());
		assertEquals("Third", sidebarTabOrder.get(3).getTooltip());
	}

	@Test
	public void testDragMiddleToMiddle()
	{
		NavigationButton btn1 = createNavButton("First", 0);
		NavigationButton btn2 = createNavButton("Second", 1);
		NavigationButton btn3 = createNavButton("Third", 2);
		NavigationButton btn4 = createNavButton("Fourth", 3);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);
		sidebarTabOrder.add(btn3);
		sidebarTabOrder.add(btn4);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Drag from index 1 to index 2
		listener.onTabDragged(1, 2);

		assertEquals("First", sidebarTabOrder.get(0).getTooltip());
		assertEquals("Third", sidebarTabOrder.get(1).getTooltip());
		assertEquals("Second", sidebarTabOrder.get(2).getTooltip());
		assertEquals("Fourth", sidebarTabOrder.get(3).getTooltip());
	}

	@Test
	public void testEmptyTabList()
	{
		// sidebarTabOrder is empty

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Should not throw when trying to drag with empty list
		listener.onTabDragged(0, 0);

		assertFalse("Callback should not be invoked for empty list", callbackInvoked.get());
	}

	@Test
	public void testSingleTabList()
	{
		NavigationButton btn1 = createNavButton("Only", 0);
		sidebarTabOrder.add(btn1);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// Drag single item to same position
		listener.onTabDragged(0, 0);

		assertTrue("Callback should be invoked for valid indices", callbackInvoked.get());
		assertEquals("Only", sidebarTabOrder.get(0).getTooltip());
	}

	@Test
	public void testReinstallAfterUninstall()
	{
		dragManager.install();
		dragManager.uninstall();
		dragManager.install();

		// Verify setDragEnabled was called twice with true
		verify(sidebar, times(2)).setDragEnabled(true);
		// And once with false (during uninstall)
		verify(sidebar, times(1)).setDragEnabled(false);
	}

	@Test
	public void testConsecutiveDrags()
	{
		NavigationButton btn1 = createNavButton("A", 0);
		NavigationButton btn2 = createNavButton("B", 1);
		NavigationButton btn3 = createNavButton("C", 2);
		sidebarTabOrder.add(btn1);
		sidebarTabOrder.add(btn2);
		sidebarTabOrder.add(btn3);

		dragManager.install();

		ArgumentCaptor<DragAndDropTabbedPane.TabDragListener> captor =
			ArgumentCaptor.forClass(DragAndDropTabbedPane.TabDragListener.class);
		verify(sidebar).addTabDragListener(captor.capture());

		DragAndDropTabbedPane.TabDragListener listener = captor.getValue();

		// First drag: A B C -> B A C
		listener.onTabDragged(0, 1);
		assertEquals("B", sidebarTabOrder.get(0).getTooltip());
		assertEquals("A", sidebarTabOrder.get(1).getTooltip());
		assertEquals("C", sidebarTabOrder.get(2).getTooltip());

		// Reset callback flag
		callbackInvoked.set(false);

		// Second drag: B A C -> B C A
		listener.onTabDragged(1, 2);
		assertEquals("B", sidebarTabOrder.get(0).getTooltip());
		assertEquals("C", sidebarTabOrder.get(1).getTooltip());
		assertEquals("A", sidebarTabOrder.get(2).getTooltip());

		assertTrue("Callback should be invoked for second drag", callbackInvoked.get());
	}
}
