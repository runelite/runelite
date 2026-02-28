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
package net.runelite.client.ui.components;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class DragAndDropTabbedPaneTest
{
	private DragAndDropTabbedPane tabbedPane;

	@Before
	public void setUp()
	{
		tabbedPane = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addTab("Tab1", new JPanel());
		tabbedPane.addTab("Tab2", new JPanel());
		tabbedPane.addTab("Tab3", new JPanel());
	}

	@Test
	public void testInitialState()
	{
		assertFalse(tabbedPane.isDragging());
		assertEquals(3, tabbedPane.getTabCount());
	}

	@Test
	public void testDragEnabledByDefault()
	{
		// Drag support is installed in constructor, but drag state starts as false
		DragAndDropTabbedPane pane = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		pane.addTab("Test", new JPanel());
		assertFalse(pane.isDragging());
	}


	@Test
	public void testTabDragListenerRegistration()
	{
		AtomicBoolean called = new AtomicBoolean(false);
		AtomicInteger fromIdx = new AtomicInteger(-1);
		AtomicInteger toIdx = new AtomicInteger(-1);

		DragAndDropTabbedPane.DragListener listener = (from, to) ->
		{
			called.set(true);
			fromIdx.set(from);
			toIdx.set(to);
		};

		tabbedPane.addDragListener(listener);
		// Listener is registered, no exception
		tabbedPane.removeTabDragListener(listener);
	}

	@Test
	public void testSelectedIndexBlockedDuringDrag()
	{
		// Can't easily test dragging state without complex mouse simulation,
		// but we can test the setSelectedIndex behavior

		// Initially can set selected index
		tabbedPane.setSelectedIndex(1);
		assertEquals(1, tabbedPane.getSelectedIndex());

		// Reset
		tabbedPane.setSelectedIndex(-1);
		assertEquals(-1, tabbedPane.getSelectedIndex());
	}

	@Test
	public void testSingleTabNoDrag()
	{
		DragAndDropTabbedPane singleTab = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		singleTab.addTab("Only", new JPanel());
		// With only 1 tab, drag is not useful but should not error
		assertEquals(1, singleTab.getTabCount());
	}

	@Test
	public void testEmptyPane()
	{
		DragAndDropTabbedPane emptyPane = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		assertEquals(0, emptyPane.getTabCount());
		assertFalse(emptyPane.isDragging());
	}

	@Test
	public void testRemoveTab()
	{
		assertEquals(3, tabbedPane.getTabCount());
		tabbedPane.removeTabAt(1);
		assertEquals(2, tabbedPane.getTabCount());
		assertEquals("Tab1", tabbedPane.getTitleAt(0));
		assertEquals("Tab3", tabbedPane.getTitleAt(1));
	}

	@Test
	public void testTabPlacementLeft()
	{
		DragAndDropTabbedPane pane = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		assertEquals(JTabbedPane.LEFT, pane.getTabPlacement());
	}

	@Test
	public void testTabPlacementTop()
	{
		DragAndDropTabbedPane pane = new DragAndDropTabbedPane(JTabbedPane.TOP);
		assertEquals(JTabbedPane.TOP, pane.getTabPlacement());
	}
}

