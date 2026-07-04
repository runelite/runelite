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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeablePanel;
import net.runelite.client.util.AsyncBufferedImage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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

		// movePatch() triggers an immediate update(), which loads patch icons; not every
		// test exercises that path, so this stub is lenient.
		lenient().when(itemManager.getImage(anyInt())).thenReturn(mock(AsyncBufferedImage.class));
	}

	private FarmingTabPanel newPanel()
	{
		return new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
			configManager, config, Tab.HERB, patches, farmingContractManager);
	}

	@Test
	public void defaultOrderWhenNoSavedConfig()
	{
		FarmingTabPanel panel = newPanel();

		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
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
	public void moveDownSwapsAdjacentPatchesInSameGroupAndSaves()
	{
		when(configManager.getRSProfileKey()).thenReturn("profile1");
		FarmingTabPanel panel = newPanel();

		assertTrue(panel.movePatch(faladorAllotment, 1));

		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());

		String expectedJoined = catherbyAllotment.configKey() + "," + faladorAllotment.configKey() + ","
			+ ardougneAllotment.configKey() + "," + faladorHerb.configKey() + "," + catherbyHerb.configKey();
		verify(configManager).setRSProfileConfiguration(GROUP, ORDER_KEY, expectedJoined);
	}

	@Test
	public void moveUpAtStartOfGroupIsNoOp()
	{
		FarmingTabPanel panel = newPanel();

		assertFalse(panel.movePatch(faladorAllotment, -1));

		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
		verify(configManager, never()).setRSProfileConfiguration(anyString(), eq(ORDER_KEY), anyString());
	}

	@Test
	public void moveDownAcrossGroupBoundaryIsNoOp()
	{
		FarmingTabPanel panel = newPanel();

		// Ardougne is the last Allotment patch; below it is the Herb group.
		assertFalse(panel.movePatch(ardougneAllotment, 1));

		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
		verify(configManager, never()).setRSProfileConfiguration(anyString(), eq(ORDER_KEY), anyString());
	}

	@Test
	public void moveDoesNotSaveWithoutAnActiveProfile()
	{
		when(configManager.getRSProfileKey()).thenReturn(null);
		FarmingTabPanel panel = newPanel();

		assertTrue(panel.movePatch(faladorAllotment, 1));

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
	public void patchPanelsAreCreatedOnePerPatch()
	{
		FarmingTabPanel panel = newPanel();
		assertEquals(5, panel.getPatchPanels().size());
	}

	@Test
	public void editOrderButtonHiddenForASingleImplementationPatchGroup()
	{
		FarmingPatch cactus = new FarmingPatch("Guild", VarbitID.FARMING_TRANSMIT_F, PatchImplementation.CACTUS);
		new FarmingRegion("TestRegion2", 9998, true, cactus);

		Set<FarmingPatch> mixedPatches = new LinkedHashSet<>(
			List.of(faladorAllotment, catherbyAllotment, cactus));

		FarmingTabPanel panel = new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
			configManager, config, Tab.SPECIAL, mixedPatches, farmingContractManager);

		// Allotment has two patches, so it can be reordered...
		assertNotNull(panel.getEditOrderButton(PatchImplementation.ALLOTMENT));
		// ...but Cactus only has one, so there's nothing to reorder.
		assertNull(panel.getEditOrderButton(PatchImplementation.CACTUS));
		assertNull(panel.getResetButton(PatchImplementation.CACTUS));
	}

	@Test
	public void eachSectionHasItsOwnIndependentEditOrderButton()
	{
		FarmingTabPanel panel = newPanel();

		assertNotNull(panel.getEditOrderButton(PatchImplementation.ALLOTMENT));
		assertNotNull(panel.getEditOrderButton(PatchImplementation.HERB));
		assertNotSame(
			panel.getEditOrderButton(PatchImplementation.ALLOTMENT),
			panel.getEditOrderButton(PatchImplementation.HERB));
		assertFalse(panel.getEditOrderButton(PatchImplementation.ALLOTMENT).isSelected());
		assertFalse(panel.getEditOrderButton(PatchImplementation.HERB).isSelected());
	}

	@Test
	public void moveButtonsHiddenUntilThatSectionsEditModeIsToggledOn()
	{
		FarmingTabPanel panel = newPanel();

		for (TimeablePanel<FarmingPatch> p : panel.getPatchPanels())
		{
			assertTrue(p.getNotifyButton().getParent().isVisible());
			assertFalse(p.getMoveUpButton().getParent().isVisible());
		}
	}

	@Test
	public void togglingOneSectionsEditOrderDoesNotAffectTheOtherSection()
	{
		FarmingTabPanel panel = newPanel();

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();

		List<TimeablePanel<FarmingPatch>> panels = panel.getPatchPanels();
		// Allotment rows (0-2) now show move buttons instead of the notify button.
		for (int i = 0; i < 3; i++)
		{
			assertFalse(panels.get(i).getNotifyButton().getParent().isVisible());
			assertTrue(panels.get(i).getMoveUpButton().getParent().isVisible());
		}
		// Herb rows (3-4) are untouched.
		for (int i = 3; i < 5; i++)
		{
			assertTrue(panels.get(i).getNotifyButton().getParent().isVisible());
			assertFalse(panels.get(i).getMoveUpButton().getParent().isVisible());
		}

		assertTrue(panel.getEditOrderButton(PatchImplementation.ALLOTMENT).isSelected());
		assertFalse(panel.getEditOrderButton(PatchImplementation.HERB).isSelected());
	}

	@Test
	public void editOrderButtonRefreshesRowsImmediatelyInBothDirections()
	{
		FarmingTabPanel panel = newPanel();

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();
		// Toggling rebuilds every row from scratch; verify update() ran immediately afterwards
		// instead of leaving fresh, unpopulated rows on screen until the next scheduled tick.
		assertEquals("Unknown", panel.getPatchPanels().get(0).getEstimate().getText());

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();
		assertEquals("Unknown", panel.getPatchPanels().get(0).getEstimate().getText());
	}

	@Test
	public void moveButtonEnabledStateMatchesGroupBoundaries()
	{
		FarmingTabPanel panel = newPanel();
		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();
		panel.getEditOrderButton(PatchImplementation.HERB).doClick();

		List<TimeablePanel<FarmingPatch>> panels = panel.getPatchPanels();

		// falador allotment: first overall -> no up, has down (within group)
		assertFalse(panels.get(0).getMoveUpButton().isEnabled());
		assertTrue(panels.get(0).getMoveDownButton().isEnabled());

		// catherby allotment: has both neighbours in the same group
		assertTrue(panels.get(1).getMoveUpButton().isEnabled());
		assertTrue(panels.get(1).getMoveDownButton().isEnabled());

		// ardougne allotment: last of its group -> no down (next patch is a different group)
		assertTrue(panels.get(2).getMoveUpButton().isEnabled());
		assertFalse(panels.get(2).getMoveDownButton().isEnabled());

		// falador herb: first of its group -> no up (previous patch is a different group)
		assertFalse(panels.get(3).getMoveUpButton().isEnabled());
		assertTrue(panels.get(3).getMoveDownButton().isEnabled());

		// catherby herb: last overall -> no down
		assertTrue(panels.get(4).getMoveUpButton().isEnabled());
		assertFalse(panels.get(4).getMoveDownButton().isEnabled());
	}

	@Test
	public void clickingMoveDownButtonSwapsAdjacentPatchesInSameGroup()
	{
		when(configManager.getRSProfileKey()).thenReturn("profile1");
		FarmingTabPanel panel = newPanel();
		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();

		panel.getPatchPanels().get(0).getMoveDownButton().doClick(); // faladorAllotment

		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, faladorHerb, catherbyHerb),
			panel.getPatchOrder());
	}

	@Test
	public void resetButtonHiddenWhenNotEditingEvenIfOrderIsCustomized()
	{
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY))
			.thenReturn(catherbyAllotment.configKey() + "," + faladorAllotment.configKey());

		FarmingTabPanel panel = newPanel();

		// Order differs from default, but we haven't entered edit mode for this section.
		assertNull(panel.getResetButton(PatchImplementation.ALLOTMENT));
	}

	@Test
	public void resetButtonHiddenWhenEditingButOrderIsAlreadyDefault()
	{
		FarmingTabPanel panel = newPanel();

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();

		assertNull(panel.getResetButton(PatchImplementation.ALLOTMENT));
	}

	@Test
	public void resetButtonShownOnlyForTheCustomizedSectionWhileEditing()
	{
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY))
			.thenReturn(catherbyAllotment.configKey() + "," + faladorAllotment.configKey());

		FarmingTabPanel panel = newPanel();

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();
		panel.getEditOrderButton(PatchImplementation.HERB).doClick();

		assertNotNull(panel.getResetButton(PatchImplementation.ALLOTMENT));
		// Herb was never customized, so it has nothing to reset.
		assertNull(panel.getResetButton(PatchImplementation.HERB));
	}

	@Test
	public void clickingResetRestoresThatSectionsDefaultOrderAndExitsItsEditMode()
	{
		when(configManager.getRSProfileKey()).thenReturn("profile1");
		// Customize both sections' order up front.
		when(configManager.getRSProfileConfiguration(GROUP, ORDER_KEY)).thenReturn(
			catherbyAllotment.configKey() + "," + faladorAllotment.configKey() + ","
				+ catherbyHerb.configKey() + "," + faladorHerb.configKey());

		FarmingTabPanel panel = newPanel();
		assertEquals(
			List.of(catherbyAllotment, faladorAllotment, ardougneAllotment, catherbyHerb, faladorHerb),
			panel.getPatchOrder());

		panel.getEditOrderButton(PatchImplementation.ALLOTMENT).doClick();
		panel.getEditOrderButton(PatchImplementation.HERB).doClick();

		panel.getResetButton(PatchImplementation.ALLOTMENT).doClick();

		// Allotment is back to default order; Herb's customization is untouched.
		assertEquals(
			List.of(faladorAllotment, catherbyAllotment, ardougneAllotment, catherbyHerb, faladorHerb),
			panel.getPatchOrder());

		String expectedJoined = faladorAllotment.configKey() + "," + catherbyAllotment.configKey() + ","
			+ ardougneAllotment.configKey() + "," + catherbyHerb.configKey() + "," + faladorHerb.configKey();
		verify(configManager).setRSProfileConfiguration(GROUP, ORDER_KEY, expectedJoined);

		// Resetting also exits Allotment's edit mode: its toggle is deselected, its reset button
		// is gone, and its rows show the notify button again...
		assertFalse(panel.getEditOrderButton(PatchImplementation.ALLOTMENT).isSelected());
		assertNull(panel.getResetButton(PatchImplementation.ALLOTMENT));
		assertTrue(panel.getPatchPanels().get(0).getNotifyButton().getParent().isVisible());
		// ...while Herb is still being edited.
		assertTrue(panel.getEditOrderButton(PatchImplementation.HERB).isSelected());
		assertNotNull(panel.getResetButton(PatchImplementation.HERB));
		assertTrue(panel.getPatchPanels().get(3).getMoveUpButton().getParent().isVisible());
	}

	@Test
	public void reorderableUnnamedSectionsGetAHeaderRowWithoutNameText()
	{
		// PatchImplementation.ALLOTMENT and HERB have no display name, so their header rows
		// (which exist to carry the edit-order button) show no "Allotment"/"Herb" text.
		FarmingTabPanel panel = newPanel();

		assertNull(panel.getPatchPanels().get(0).getBorder());
		assertEquals(0, countLabelsWithText(panel, "Allotment"));
		assertEquals(0, countLabelsWithText(panel, "Herb"));
	}

	@Test
	public void loneUnnamedPatchGroupGetsNoHeaderRow()
	{
		Set<FarmingPatch> lonePatch = new LinkedHashSet<>(List.of(faladorHerb));

		FarmingTabPanel panel = new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
			configManager, config, Tab.HERB, lonePatch, farmingContractManager);

		// A single patch in an unnamed section has nothing to label or reorder, so the tab
		// contains only the patch row itself - no empty header taking up space above it.
		assertEquals(1, panel.getComponentCount());
		assertNull(panel.getEditOrderButton(PatchImplementation.HERB));
		assertNull(panel.getPatchPanels().get(0).getBorder());
	}

	@Test
	public void namedImplementationsShowTheirNameInTheSectionHeader()
	{
		FarmingPatch cactus = new FarmingPatch("Guild", VarbitID.FARMING_TRANSMIT_F, PatchImplementation.CACTUS);
		new FarmingRegion("TestRegion2", 9998, true, cactus);

		Set<FarmingPatch> namedFirstPatches = new LinkedHashSet<>(List.of(cactus, faladorAllotment));

		FarmingTabPanel panel = new FarmingTabPanel(farmingTracker, compostTracker, paymentTracker, itemManager,
			configManager, config, Tab.SPECIAL, namedFirstPatches, farmingContractManager);

		assertEquals(1, countLabelsWithText(panel, "Cactus"));
		// The first row's own top border is still removed, since a header always precedes it.
		assertNull(panel.getPatchPanels().get(0).getBorder());
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
