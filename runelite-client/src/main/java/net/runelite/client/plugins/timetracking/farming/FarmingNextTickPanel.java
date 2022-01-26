/*
 * Copyright (c) 2020 Morgan Lewis
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking.farming;

import com.google.inject.Inject;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.timetracking.TabContentPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeablePanel;
import net.runelite.client.ui.ColorScheme;

public class FarmingNextTickPanel extends TabContentPanel
{
	private final FarmingTracker farmingTracker;
	private final TimeTrackingConfig config;
	private final ConfigManager configManager;
	private final List<TimeablePanel<Void>> patchPanels;
	private final JTextArea infoTextArea;

	@Inject
	public FarmingNextTickPanel(
		FarmingTracker farmingTracker,
		TimeTrackingConfig config,
		ConfigManager configManager
	)
	{
		this.farmingTracker = farmingTracker;
		this.config = config;
		this.configManager = configManager;
		this.patchPanels = new ArrayList<>();

		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		int[] times = {5, 10, 20, 40, 80, 160, 320, 640};

		for (int time : times)
		{
			TimeablePanel<Void> panel = new TimeablePanel<>(null, time + " minute tick", time);
			patchPanels.add(panel);
			add(panel, c);
			c.gridy++;
		}

		infoTextArea = new JTextArea();
		add(infoTextArea, c);
		c.gridy++;
	}

	@Override
	public int getUpdateInterval()
	{
		return 50;
	}

	@Override
	public void update()
	{
		long unixNow = Instant.now().getEpochSecond();

		for (TimeablePanel<Void> panel : patchPanels)
		{
			int tickLength = panel.getProgress().getMaximumValue();
			long nextTick = farmingTracker.getTickTime(tickLength, 1);
			panel.getEstimate().setText(getFormattedEstimate(nextTick - unixNow, config.timeFormatMode()));
		}

		String offsetPrecisionMins = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION);
		String offsetTimeMins = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET);

		infoTextArea.setText("Offset precision:" + offsetPrecisionMins + "\nFarming tick offset: -" + offsetTimeMins);
	}
}
