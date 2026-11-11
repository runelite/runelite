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

import java.lang.reflect.Field;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.plugins.timetracking.farming.FarmingContractManager;
import net.runelite.client.plugins.timetracking.farming.FarmingTracker;
import net.runelite.client.plugins.timetracking.hunter.BirdHouseTracker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * The plugin's collaborators are set via reflection: {@code panel} is only assigned in startUp(),
 * which needs a live ClientToolbar and injector - too much machinery to stand up just to exercise
 * onRuneScapeProfileChanged().
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeTrackingPluginTest
{
	private final TimeTrackingPlugin plugin = new TimeTrackingPlugin();

	@Mock
	private FarmingTracker farmingTracker;

	@Mock
	private BirdHouseTracker birdHouseTracker;

	@Mock
	private FarmingContractManager farmingContractManager;

	@Mock
	private TimeTrackingPanel panel;

	@Before
	public void before() throws Exception
	{
		setField("farmingTracker", farmingTracker);
		setField("birdHouseTracker", birdHouseTracker);
		setField("farmingContractManager", farmingContractManager);
		setField("panel", panel);
	}

	private void setField(String name, Object value) throws Exception
	{
		Field field = TimeTrackingPlugin.class.getDeclaredField(name);
		field.setAccessible(true);
		field.set(plugin, value);
	}

	@Test
	public void onRuneScapeProfileChangedReloadsFarmingStateAndPatchOrder()
	{
		plugin.onRuneScapeProfileChanged(new RuneScapeProfileChanged(null, "profile1"));

		verify(farmingTracker).loadCompletionTimes();
		verify(birdHouseTracker).loadFromConfig();
		verify(farmingContractManager).loadContractFromConfig();
		verify(panel).reloadFarmingPatchOrder();
		verify(panel).update();
	}
}
