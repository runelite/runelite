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
package net.runelite.client.plugins.timetracking.farming;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.ui.components.DragAndDropReorderPane;
import net.runelite.client.util.AsyncBufferedImage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FarmingTabPanelTest
{
	private static final String GROUP = TimeTrackingConfig.CONFIG_GROUP;
	private static final String ORDER_KEY = "patchOrder." + Tab.HERB.name();

	@Mock
	private FarmingTracker farmingTracker;

	@Mock
	private CompostTracker compostTracker;

	@Mock
	private PaymentTracker paymentTracker;

	@Mock
	private ItemManager itemManager;

	@Mock
	private ConfigManager configManager;

	@Mock
	private TimeTrackingConfig config;

	@Mock
	private FarmingContractManager farmingContractManager;

	private FarmingPatch faladorAllotment;
	private FarmingPatch catherbyAllotment;
	private FarmingPatch ardougneAllotment;
	private FarmingPatch faladorHerb;
	private FarmingPatch catherbyHerb;
	private Set<FarmingPatch> patches;

	@Before
	public void before()
	{
		faladorAllotment = new FarmingPatch("Falador", VarbitID.FARMING_TRANSMIT_A, PatchImplementation.ALLOTMENT);
		catherbyAllotment = new FarmingPatch("Catherby", VarbitID.FARMING_TRANSMIT_B, PatchImplementation.ALLOTMENT);
		ardougneAllotment = new FarmingPatch("Ardougne", VarbitID.FARMING_TRANSMIT_C, PatchImplementation.ALLOTMENT);
		faladorHerb = new FarmingPatch("Falador", VarbitID.FARMING_TRANSMIT_D, PatchImplementation.HERB);
		catherbyHerb = new FarmingPatch("Catherby", VarbitID.FARMING_TRANSMIT_E, PatchImplementation.HERB);

		new FarmingRegion("TestRegion", 9999, true,
			faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb);

		patches = new LinkedHashSet<>(List.of(
			faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb));

		// Completing a drag triggers an immediate update(), which loads patch icons; not
		// every test exercises that path, so this stub is lenient.
		lenient().when(itemManager.getImage(anyInt())).thenReturn(mock(AsyncBufferedImage.class));
	}

	private FarmingTabPanel newPanel()
	{
		return new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
			configManager, config, Tab.HERB, patches, farmingContractManager);
	}

	/**
	 * Drags one row onto another by dispatching real mouse events to the group's
	 * DragAndDropReorderPane, exercising the same code path as a user's drag.
	 */
	private static void drag(FarmingTabPanel panel, int pane, int from, int to)
	{
		DragAndDropReorderPane groupPane = panel.getGroupPanes().get(pane);
		groupPane.setSize(groupPane.getPreferredSize());
		groupPane.doLayout();

		Point start = center(groupPane.getComponent(from).getBounds());
		Point end = center(groupPane.getComponent(to).getBounds());

		dispatchMouseEvent(groupPane, MouseEvent.MOUSE_PRESSED, start);
		dispatchMouseEvent(groupPane, MouseEvent.MOUSE_DRAGGED, end); // passes the drag-start threshold
		dispatchMouseEvent(groupPane, MouseEvent.MOUSE_DRAGGED, end); // reorders the rows
		dispatchMouseEvent(groupPane, MouseEvent.MOUSE_RELEASED, end);
	}

	private static Point center(Rectangle bounds)
	{
		return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
	}

	private static void dispatchMouseEvent(Component target, int id, Point point)
	{
		target.dispatchEvent(new MouseEvent(target, id, System.currentTimeMillis(),
			MouseEvent.BUTTON1_DOWN_MASK, point.x, point.y, 1, false, MouseEvent.BUTTON1));
	}

	@Test
	public void defaultOrderWhenNoSavedConfig()
	{
		FarmingTabPanel panel = newPanel();

		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
		assertEquals(5, panel.getPatchPanels().size());
	}

	@Test
	public void savedOrderIsAppliedWithinGroupOnly()
	{
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY))
			.thenReturn(catherbyAllotment.configKey() + "," + faladorAllotment.configKey());

		FarmingTabPanel panel = newPanel();

		// Ardougne wasn't in the saved order, so it keeps its default relative position at
		// the end of the Allotment group. The Herb group is untouched.
		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
	}

	@Test
	public void unknownSavedKeysAreIgnoredWithoutError()
	{
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY))
			.thenReturn("9999.123456," + catherbyAllotment.configKey());

		FarmingTabPanel panel = newPanel();

		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
	}

	@Test
	public void eachGroupGetsItsOwnReorderPane()
	{
		FarmingTabPanel panel = newPanel();

		// Dragging is confined to a pane, so per-group panes are what prevent a patch
		// from being dragged into another group.
		assertEquals(2, panel.getGroupPanes().size());
		assertEquals(3, panel.getGroupPanes().get(0).getComponentCount());
		assertEquals(2, panel.getGroupPanes().get(1).getComponentCount());
	}

	@Test
	public void draggingAPatchUpdatesAndSavesTheNewOrder()
	{
		when(configManager.getRSProfileKey()).thenReturn("profile1");
		FarmingTabPanel panel = newPanel();

		drag(panel, 0, 0, 1); // faladorAllotment below catherbyAllotment

		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());

		String expectedJoined = catherbyAllotment.configKey() + "," + faladorAllotment.configKey() + ","
			+ ardougneAllotment.configKey() + "," + faladorHerb.configKey() + "," + catherbyHerb.configKey();
		verify(configManager).setRSProfileConfiguration(GROUP, ORDER_KEY, expectedJoined);

		// The rebuilt rows are populated immediately, and the first row's border hack is reapplied
		assertEquals("Unknown", panel.getPatchPanels().get(0).getEstimate().getText());
		assertNull(panel.getPatchPanels().get(0).getBorder());
	}

	@Test
	public void dragDoesNotSaveWithoutAnActiveProfile()
	{
		when(configManager.getRSProfileKey()).thenReturn(null);
		FarmingTabPanel panel = newPanel();

		drag(panel, 0, 0, 1);

		// The in-memory order still changes...
		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
		// ...but nothing was persisted.
		verify(configManager, never()).setRSProfileConfiguration(anyString(), eq(ORDER_KEY), anyString());
	}

	@Test
	public void reloadPatchOrderPicksUpNewlyActiveProfilesSavedOrder()
	{
		FarmingTabPanel panel = newPanel();
		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());

		// Simulate the player logging in after the tab was already built at plugin startup.
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY))
			.thenReturn(catherbyAllotment.configKey() + "," + faladorAllotment.configKey());

		panel.reloadPatchOrder();

		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
	}

	@Test
	public void unnamedImplementationsGetNoSectionLabel()
	{
		// PatchImplementation.ALLOTMENT and HERB have no display name
		FarmingTabPanel panel = newPanel();

		assertNull(panel.getPatchPanels().get(0).getBorder());
		assertEquals(0, countLabelsWithText(panel, "Allotment"));
		assertEquals(0, countLabelsWithText(panel, "Herb"));
	}

	@Test
	public void namedImplementationsShowTheirNameInASectionLabel()
	{
		FarmingPatch cactus = new FarmingPatch("Guild", VarbitID.FARMING_TRANSMIT_F, PatchImplementation.CACTUS);
		new FarmingRegion("TestRegion2", 9998, true, cactus);

		// Once with the named section first, and once below an unnamed section, since the
		// first label of a tab is styled differently.
		for (List<FarmingPatch> order : List.of(List.of(cactus, faladorAllotment), List.of(faladorAllotment, cactus)))
		{
			FarmingTabPanel panel = new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
				configManager, config, Tab.SPECIAL, new LinkedHashSet<>(order), farmingContractManager);

			assertEquals(1, countLabelsWithText(panel, "Cactus"));
		}
	}

	private static int countLabelsWithText(Component root, String text)
	{
		int count = 0;
		if (root instanceof JLabel && text.equals(((JLabel) root).getText()))
		{
			count++;
		}
		if (root instanceof Container)
		{
			for (Component c : ((Container) root).getComponents())
			{
				count += countLabelsWithText(c, text);
			}
		}
		return count;
	}
}
