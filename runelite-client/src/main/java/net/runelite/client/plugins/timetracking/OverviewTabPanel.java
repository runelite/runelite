/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.Instant;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.clocks.ClockManager;
import net.runelite.client.plugins.timetracking.farming.CropState;
import net.runelite.client.plugins.timetracking.farming.FarmingContractManager;
import net.runelite.client.plugins.timetracking.farming.FarmingTracker;
import net.runelite.client.plugins.timetracking.hunter.BirdHouseTracker;
import net.runelite.client.ui.ColorScheme;

class OverviewTabPanel extends TabContentPanel
{
	private final TimeTrackingConfig config;
	private final FarmingTracker farmingTracker;
	private final BirdHouseTracker birdHouseTracker;
	private final ClockManager clockManager;
	private final FarmingContractManager farmingContractManager;

	private final OverviewItemPanel timerOverview;
	private final OverviewItemPanel stopwatchOverview;
	private final Map<Tab, OverviewItemPanel> farmingOverviews;
	private final OverviewItemPanel birdHouseOverview;
	private final OverviewItemPanel farmingContractOverview;

	OverviewTabPanel(ItemManager itemManager, TimeTrackingConfig config, TimeTrackingPanel pluginPanel,
		FarmingTracker farmingTracker, BirdHouseTracker birdHouseTracker, ClockManager clockManager,
		FarmingContractManager farmingContractManager)
	{
		this.config = config;
		this.farmingTracker = farmingTracker;
		this.birdHouseTracker = birdHouseTracker;
		this.clockManager = clockManager;
		this.farmingContractManager = farmingContractManager;

		setLayout(new GridLayout(0, 1, 0, 8));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		timerOverview = new OverviewItemPanel(itemManager, pluginPanel, Tab.CLOCK, "Timers");
		add(timerOverview);

		stopwatchOverview = new OverviewItemPanel(itemManager, pluginPanel, Tab.CLOCK, "Stopwatches");
		add(stopwatchOverview);

		birdHouseOverview = new OverviewItemPanel(itemManager, pluginPanel, Tab.BIRD_HOUSE, "Bird Houses");
		add(birdHouseOverview);

		farmingOverviews = Stream.of(Tab.FARMING_TABS)
			.filter(v -> v != Tab.OVERVIEW)
			.collect(ImmutableMap.toImmutableMap(
				Function.identity(),
				t ->
				{
					OverviewItemPanel p = new OverviewItemPanel(itemManager, pluginPanel, t, t.getName());
					add(p);
					return p;
				}
			));

		farmingContractOverview = new OverviewItemPanel(itemManager, () -> pluginPanel.switchTab(farmingContractManager.getContractTab()),
			farmingContractManager::hasContract, ItemID.SEEDBOX, "Farming Contract");
		add(farmingContractOverview);
	}

	@Override
	public int getUpdateInterval()
	{
		return 50; // 10 seconds
	}

	@Override
	public void update()
	{
		final long timers = clockManager.getActiveTimerCount();
		final long stopwatches = clockManager.getActiveStopwatchCount();

		if (timers == 0)
		{
			timerOverview.updateStatus("No active timers", Color.GRAY);
		}
		else
		{
			timerOverview.updateStatus(timers + " active timer" + (timers == 1 ? "" : "s"), ColorScheme.PROGRESS_COMPLETE_COLOR);
		}

		if (stopwatches == 0)
		{
			stopwatchOverview.updateStatus("No active stopwatches", Color.GRAY);
		}
		else
		{
			stopwatchOverview.updateStatus(stopwatches + " active stopwatch" + (stopwatches == 1 ? "" : "es"), ColorScheme.PROGRESS_COMPLETE_COLOR);
		}

		farmingOverviews.forEach((patchType, panel) ->
			updateItemPanel(panel, farmingTracker.getSummary(patchType), farmingTracker.getCompletionTime(patchType)));

		updateItemPanel(birdHouseOverview, birdHouseTracker.getSummary(), birdHouseTracker.getCompletionTime());
		updateContractPanel();
	}

	private void updateItemPanel(OverviewItemPanel panel, SummaryState summary, long completionTime)
	{
		switch (summary)
		{
			case COMPLETED:
			case IN_PROGRESS:
			{
				long duration = completionTime - Instant.now().getEpochSecond();

				if (duration <= 0)
				{
					panel.updateStatus("Ready", ColorScheme.PROGRESS_COMPLETE_COLOR);
				}
				else
				{
					panel.updateStatus("Ready " + getFormattedEstimate(duration, config.timeFormatMode()), Color.GRAY);
				}
				break;
			}
			case EMPTY:
				panel.updateStatus("Empty", Color.GRAY);
				break;
			case UNKNOWN:
			default:
				panel.updateStatus("Unknown", Color.GRAY);
				break;
		}
	}

	private void updateContractPanel()
	{
		switch (farmingContractManager.getSummary())
		{
			case COMPLETED:
			case IN_PROGRESS:
				switch (farmingContractManager.getContractCropState())
				{
					case HARVESTABLE:
					case GROWING:
						long duration = farmingContractManager.getCompletionTime() - Instant.now().getEpochSecond();

						if (duration <= 0)
						{
							farmingContractOverview.updateStatus("Ready", ColorScheme.PROGRESS_COMPLETE_COLOR);
							return;
						}

						farmingContractOverview.updateStatus("Ready " + getFormattedEstimate(duration, config.timeFormatMode()), Color.GRAY);
						return;
					case DISEASED:
						farmingContractOverview.updateStatus("Diseased", CropState.DISEASED.getColor());
						return;
					case DEAD:
						farmingContractOverview.updateStatus("Dead", CropState.DEAD.getColor());
						return;
				}
				// fallthrough
			case UNKNOWN:
			default:
				farmingContractOverview.updateStatus("Unknown", Color.GRAY);
				return;
			case EMPTY:
				farmingContractOverview.updateStatus(farmingContractManager.getContractName(), Color.GRAY);
				return;
			case OCCUPIED:
				farmingContractOverview.updateStatus(farmingContractManager.getContractName(), Color.RED);
				return;
		}
	}
}
