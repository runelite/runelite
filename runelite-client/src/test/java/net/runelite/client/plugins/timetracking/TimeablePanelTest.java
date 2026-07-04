/*
 * Copyright (c) 2026, Rob <rob@wilkie.io>
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
package net.runelite.client.plugins.timetracking;

import java.awt.Container;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TimeablePanelTest
{
	@Test
	public void moveButtonsAreEnabledAndNotFocusableByDefault()
	{
		TimeablePanel<String> panel = new TimeablePanel<>("patch", "Title", 3);

		assertTrue(panel.getMoveUpButton().isEnabled());
		assertTrue(panel.getMoveDownButton().isEnabled());
		assertFalse(panel.getMoveUpButton().isFocusable());
		assertFalse(panel.getMoveDownButton().isFocusable());
		assertEquals("Move up", panel.getMoveUpButton().getToolTipText());
		assertEquals("Move down", panel.getMoveDownButton().getToolTipText());
	}

	@Test
	public void notifyButtonOccupiesItsSlotByDefault()
	{
		TimeablePanel<String> panel = new TimeablePanel<>("patch", "Title", 3);

		assertTrue(panel.getNotifyButton().getParent().isVisible());
		assertFalse(panel.getMoveUpButton().getParent().isVisible());
	}

	@Test
	public void reorderCardDoesNotEnlargeTheNotifyButtonsSlot()
	{
		TimeablePanel<String> panel = new TimeablePanel<>("patch", "Title", 3);

		// CardLayout sizes the slot to its largest card, so an oversized reorder card would
		// widen every row's east gutter even when reordering is never enabled
		Container notifyCard = panel.getNotifyButton().getParent();
		assertEquals(notifyCard.getPreferredSize(), notifyCard.getParent().getPreferredSize());
	}

	@Test
	public void setEditingOrderSwapsMoveButtonsIntoTheNotifyButtonsSlotAndBack()
	{
		TimeablePanel<String> panel = new TimeablePanel<>("patch", "Title", 3);

		panel.setEditingOrder(true);
		assertFalse(panel.getNotifyButton().getParent().isVisible());
		assertTrue(panel.getMoveUpButton().getParent().isVisible());
		// The move buttons share the same parent, so they occupy the notify button's slot
		assertSame(panel.getMoveUpButton().getParent(), panel.getMoveDownButton().getParent());

		panel.setEditingOrder(false);
		assertTrue(panel.getNotifyButton().getParent().isVisible());
		assertFalse(panel.getMoveUpButton().getParent().isVisible());
	}
}
