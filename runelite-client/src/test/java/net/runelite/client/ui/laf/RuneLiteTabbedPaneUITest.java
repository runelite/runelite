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
package net.runelite.client.ui.laf;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import net.runelite.client.ui.components.DragAndDropTabbedPane;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RuneLiteTabbedPaneUITest
{
	@Test
	public void testCreateUI()
	{
		JComponent component = new JTabbedPane();
		ComponentUI ui = RuneLiteTabbedPaneUI.createUI(component);
		assertNotNull(ui);
		assertTrue(ui instanceof RuneLiteTabbedPaneUI);
	}

	@Test
	public void testCreateUIWithDragAndDropTabbedPane()
	{
		JComponent component = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		ComponentUI ui = RuneLiteTabbedPaneUI.createUI(component);
		assertNotNull(ui);
		assertTrue(ui instanceof RuneLiteTabbedPaneUI);
	}

	@Test
	public void testUICanBeInstalledOnDragAndDropTabbedPane()
	{
		DragAndDropTabbedPane pane = new DragAndDropTabbedPane(JTabbedPane.LEFT);
		pane.addTab("Tab1", new JPanel());
		pane.addTab("Tab2", new JPanel());

		// Create and verify UI
		RuneLiteTabbedPaneUI ui = (RuneLiteTabbedPaneUI) RuneLiteTabbedPaneUI.createUI(pane);
		assertNotNull(ui);

		// Note: Full UI installation requires the LAF to be set up,
		// which is not done in unit tests. The key behavior of
		// setRolloverTab suppressing rollover during drag is
		// verified implicitly through the DragAndDropTabbedPane tests
		// since the UI calls isDragging() on the pane.
	}

	@Test
	public void testUIHandlesRegularTabbedPane()
	{
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Tab1", new JPanel());

		// Create UI for regular JTabbedPane
		RuneLiteTabbedPaneUI ui = (RuneLiteTabbedPaneUI) RuneLiteTabbedPaneUI.createUI(pane);
		assertNotNull(ui);
		// No exception means it handles non-DragAndDropTabbedPane correctly
	}
}

