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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.SwingUtilities;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.clocks.ClockManager;
import net.runelite.client.plugins.timetracking.clocks.ClockTabPanel;
import net.runelite.client.plugins.timetracking.farming.CompostTracker;
import net.runelite.client.plugins.timetracking.farming.FarmingContractManager;
import net.runelite.client.plugins.timetracking.farming.FarmingTabPanel;
import net.runelite.client.plugins.timetracking.farming.FarmingTracker;
import net.runelite.client.plugins.timetracking.farming.PaymentTracker;
import net.runelite.client.plugins.timetracking.hunter.BirdHouseTabPanel;
import net.runelite.client.plugins.timetracking.hunter.BirdHouseTracker;
import net.runelite.client.util.AsyncBufferedImage;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimeTrackingPanelTest
{
	@Mock
	private ItemManager itemManager;

	@Mock
	private TimeTrackingConfig config;

	@Mock
	private FarmingTracker farmingTracker;

	@Mock
	private CompostTracker compostTracker;

	@Mock
	private PaymentTracker paymentTracker;

	@Mock
	private BirdHouseTracker birdHouseTracker;

	@Mock
	private ClockManager clockManager;

	@Mock
	private FarmingContractManager farmingContractManager;

	@Mock
	private ConfigManager configManager;

	private final List<FarmingTabPanel> createdFarmingTabPanels = new ArrayList<>();

	@Before
	public void before()
	{
		when(itemManager.getImage(anyInt())).thenReturn(mock(AsyncBufferedImage.class));

		// The tab panels are mocked with useConstructor() so their real AWT/Swing internals are
		// initialized; a plain mock() skips the constructor and NPEs when added to a real container.
		when(clockManager.getTimers()).thenReturn(new CopyOnWriteArrayList<>());
		when(clockManager.getStopwatches()).thenReturn(new ArrayList<>());
		ClockTabPanel clockTabPanel = mock(ClockTabPanel.class, withSettings().useConstructor(clockManager));
		when(clockManager.getClockTabPanel()).thenReturn(clockTabPanel);

		BirdHouseTabPanel birdHouseTabPanel = mock(BirdHouseTabPanel.class,
			withSettings().useConstructor(configManager, itemManager, birdHouseTracker, config));
		when(birdHouseTracker.createBirdHouseTabPanel()).thenReturn(birdHouseTabPanel);

		when(farmingTracker.createTabPanel(any(Tab.class), any(FarmingContractManager.class))).thenAnswer(inv ->
		{
			Tab tab = inv.getArgument(0);
			FarmingTabPanel farmingTabPanel = mock(FarmingTabPanel.class, withSettings().useConstructor(
				farmingTracker, compostTracker, paymentTracker, itemManager, configManager, config, tab,
				Collections.emptySet(), farmingContractManager));
			createdFarmingTabPanels.add(farmingTabPanel);
			return farmingTabPanel;
		});
	}

	private TimeTrackingPanel newPanel()
	{
		return new TimeTrackingPanel(itemManager, config, farmingTracker, birdHouseTracker, clockManager,
			farmingContractManager, configManager, false);
	}

	@Test
	public void createsOneFarmingTabPanelPerFarmingTab()
	{
		newPanel();

		assertEquals(Tab.FARMING_TABS.length, createdFarmingTabPanels.size());
	}

	@Test
	public void reloadFarmingPatchOrderReloadsEveryFarmingTab() throws Exception
	{
		TimeTrackingPanel panel = newPanel();

		panel.reloadFarmingPatchOrder();
		// The reload is posted to the event dispatch thread; wait for it to run
		SwingUtilities.invokeAndWait(() ->
		{
		});

		assertEquals(Tab.FARMING_TABS.length, createdFarmingTabPanels.size());
		for (FarmingTabPanel farmingTabPanel : createdFarmingTabPanels)
		{
			verify(farmingTabPanel).reloadPatchOrder();
		}
	}
}
