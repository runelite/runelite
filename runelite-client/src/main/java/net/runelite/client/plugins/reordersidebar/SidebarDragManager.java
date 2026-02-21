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

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.function.BiConsumer;
import net.runelite.client.config.Keybind;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.DragAndDropTabbedPane;

/**
 * Manages drag-and-drop functionality for sidebar tab reordering.
 * Handles hotkey detection and drag event listening.
 */
class SidebarDragManager
{
	private final ReorderSidebarConfig config;
	private final DragAndDropTabbedPane sidebar;
	private final List<NavigationButton> sidebarTabOrder;
	private final BiConsumer<Integer, Integer> onTabDragged;

	private KeyEventDispatcher keyDispatcher;
	private volatile boolean hotkeyDown;
	private DragAndDropTabbedPane.TabDragListener tabDragListener;

	SidebarDragManager(
		ReorderSidebarConfig config,
		DragAndDropTabbedPane sidebar,
		List<NavigationButton> sidebarTabOrder,
		BiConsumer<Integer, Integer> onTabDragged)
	{
		this.config = config;
		this.sidebar = sidebar;
		this.sidebarTabOrder = sidebarTabOrder;
		this.onTabDragged = onTabDragged;
	}

	void install()
	{
		installKeyDispatcher();
		installDragHandler();
	}

	void uninstall()
	{
		removeKeyDispatcher();
		removeDragHandler();
	}

	private void installKeyDispatcher()
	{
		keyDispatcher = e ->
		{
			if (matchesHotkey(e))
			{
				hotkeyDown = e.getID() == KeyEvent.KEY_PRESSED;
			}
			return false;
		};
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyDispatcher);
	}

	private void removeKeyDispatcher()
	{
		if (keyDispatcher != null)
		{
			KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyDispatcher);
			keyDispatcher = null;
		}
		hotkeyDown = false;
	}

	private boolean matchesHotkey(KeyEvent e)
	{
		Keybind hotkey = config.dragHotkey();
		if (hotkey == null || hotkey.equals(Keybind.NOT_SET))
		{
			return false;
		}
		return hotkey.matches(e);
	}

	private void installDragHandler()
	{
		sidebar.setDragEnabled(true);
		sidebar.setDragAllowedSupplier(this::isDragAllowed);

		tabDragListener = (fromIndex, toIndex) ->
		{
			if (fromIndex >= 0 && fromIndex < sidebarTabOrder.size() &&
				toIndex >= 0 && toIndex < sidebarTabOrder.size())
			{
				NavigationButton moved = sidebarTabOrder.remove(fromIndex);
				sidebarTabOrder.add(toIndex, moved);
				onTabDragged.accept(fromIndex, toIndex);
			}
		};
		sidebar.addTabDragListener(tabDragListener);
	}

	private void removeDragHandler()
	{
		sidebar.setDragEnabled(false);
		sidebar.setDragAllowedSupplier(null);
		if (tabDragListener != null)
		{
			sidebar.removeTabDragListener(tabDragListener);
			tabDragListener = null;
		}
	}

	private boolean isDragAllowed()
	{
		Keybind hotkey = config.dragHotkey();
		boolean hotkeyRequired = config.dragRequiresHotkey() && hotkey != null && !hotkey.equals(Keybind.NOT_SET);
		return !hotkeyRequired || hotkeyDown;
	}
}

