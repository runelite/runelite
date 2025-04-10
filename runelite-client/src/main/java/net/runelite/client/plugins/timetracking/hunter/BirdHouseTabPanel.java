/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.timetracking.hunter;

import java.awt.Color;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.TabContentPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeablePanel;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import javax.swing.JToggleButton;

public class BirdHouseTabPanel extends TabContentPanel
{
	private static final Color COMPLETED_COLOR = ColorScheme.PROGRESS_COMPLETE_COLOR.darker();

	private final ConfigManager configManager;
	private final ItemManager itemManager;
	private final BirdHouseTracker birdHouseTracker;
	private final TimeTrackingConfig config;
	private final List<TimeablePanel<BirdHouseSpace>> spacePanels;

	BirdHouseTabPanel(ConfigManager configManager, ItemManager itemManager, BirdHouseTracker birdHouseTracker,
		TimeTrackingConfig config)
	{
		this.configManager = configManager;
		this.itemManager = itemManager;
		this.birdHouseTracker = birdHouseTracker;
		this.config = config;
		this.spacePanels = new ArrayList<>();

		setLayout(new DynamicGridLayout(0, 1, 0, 0));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		boolean first = true;
		for (BirdHouseSpace space : BirdHouseSpace.values())
		{
			TimeablePanel<BirdHouseSpace> panel = new TimeablePanel<>(space, space.getName(), BirdHouseTracker.BIRD_HOUSE_DURATION);

			spacePanels.add(panel);
			add(panel);

			// remove the top border on the first panel
			if (first)
			{
				first = false;
				panel.setBorder(null);
			}

			JToggleButton toggleNotify = panel.getNotifyButton();

			toggleNotify.addActionListener(e ->
			{
				if (configManager.getRSProfileKey() != null)
				{
					configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.BIRDHOUSE_NOTIFY, toggleNotify.isSelected());
				}
				spacePanels.forEach(p -> p.getNotifyButton().setSelected(toggleNotify.isSelected()));
			});
		}
	}

	@Override
	public int getUpdateInterval()
	{
		return 50; // 10 seconds
	}

	@Override
	public void update()
	{
		long unixNow = Instant.now().getEpochSecond();

		boolean notifications = Boolean.TRUE
			.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.BIRDHOUSE_NOTIFY, boolean.class));

		for (TimeablePanel<BirdHouseSpace> panel : spacePanels)
		{
			BirdHouseSpace space = panel.getTimeable();
			BirdHouseData data = birdHouseTracker.getBirdHouseData().get(space);
			int value = -1;
			long startTime = 0;

			if (data != null)
			{
				value = data.getVarp();
				startTime = data.getTimestamp();
			}

			BirdHouse birdHouse = BirdHouse.fromVarpValue(value);
			BirdHouseState state = BirdHouseState.fromVarpValue(value);

			if (birdHouse == null)
			{
				itemManager.getImage(ItemID.FEATHER).addTo(panel.getIcon());
				panel.getProgress().setVisible(false);
			}
			else
			{
				itemManager.getImage(birdHouse.getItemID()).addTo(panel.getIcon());
				panel.getIcon().setToolTipText(birdHouse.getName());
				panel.getProgress().setVisible(true);
			}

			panel.getNotifyButton().setSelected(notifications);

			panel.getProgress().setForeground(state.getColor().darker());

			switch (state)
			{
				case EMPTY:
					panel.getIcon().setToolTipText("Empty");
					panel.getEstimate().setText("Empty");
					break;
				case BUILT:
					panel.getProgress().setValue(0);
					panel.getEstimate().setText("Built");
					break;
				case SEEDED:
					long remainingTime = startTime + BirdHouseTracker.BIRD_HOUSE_DURATION - unixNow;
					if (remainingTime <= 0)
					{
						panel.getProgress().setValue(BirdHouseTracker.BIRD_HOUSE_DURATION);
						panel.getProgress().setForeground(COMPLETED_COLOR);
						panel.getEstimate().setText("Done");
					}
					else
					{
						panel.getProgress().setValue((int) (BirdHouseTracker.BIRD_HOUSE_DURATION - remainingTime));
						panel.getEstimate().setText("Done " + getFormattedEstimate(remainingTime, config.timeFormatMode()));
					}
					break;
				default:
					panel.getIcon().setToolTipText("Unknown state");
					panel.getEstimate().setText("Unknown");
					break;
			}
		}
	}
}
