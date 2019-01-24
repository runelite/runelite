/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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

import com.google.common.base.Strings;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.vars.Autoweed;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.TabContentPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeablePanel;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

@Slf4j
public class FarmingTabPanel extends TabContentPanel
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final List<TimeablePanel<FarmingPatch>> patchPanels;

	FarmingTabPanel(Client client, ItemManager itemManager, ConfigManager configManager,
		TimeTrackingConfig config, Set<FarmingPatch> patches)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;
		this.patchPanels = new ArrayList<>();

		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		PatchImplementation lastImpl = null;

		boolean first = true;
		for (FarmingPatch patch : patches)
		{
			String title = patch.getRegion().getName() + (Strings.isNullOrEmpty(patch.getName()) ? "" : " (" + patch.getName() + ")");
			TimeablePanel<FarmingPatch> p = new TimeablePanel<>(patch, title, 1);

			/* Show labels to subdivide tabs into sections */
			if (patch.getImplementation() != lastImpl && !Strings.isNullOrEmpty(patch.getImplementation().getName()))
			{
				JLabel groupLabel = new JLabel(patch.getImplementation().getName());

				if (first)
				{
					first = false;
					groupLabel.setBorder(new EmptyBorder(4, 0, 0, 0));
				}
				else
				{
					groupLabel.setBorder(new EmptyBorder(15, 0, 0, 0));
				}

				groupLabel.setFont(FontManager.getRunescapeSmallFont());

				add(groupLabel, c);
				c.gridy++;
				lastImpl = patch.getImplementation();
			}

			patchPanels.add(p);
			add(p, c);
			c.gridy++;

			/* This is a weird hack to remove the top border on the first tracker of every tab */
			if (first)
			{
				first = false;
				p.setBorder(null);
			}
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
		log.debug("Updating panel with username {}", client.getUsername());

		boolean autoweed;
		{
			String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername();
			autoweed = Integer.toString(Autoweed.ON.ordinal())
				.equals(configManager.getConfiguration(group, TimeTrackingConfig.AUTOWEED));
		}

		for (TimeablePanel<FarmingPatch> panel : patchPanels)
		{
			FarmingPatch patch = panel.getTimeable();
			String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername() + "." + patch.getRegion().getRegionID();
			String key = Integer.toString(patch.getVarbit().getId());
			String storedValue = configManager.getConfiguration(group, key);
			long unixTime = 0;
			int value = 0;
			if (storedValue != null)
			{
				String[] parts = storedValue.split(":");
				if (parts.length == 2)
				{
					try
					{
						value = Integer.parseInt(parts[0]);
						unixTime = Long.parseLong(parts[1]);
					}
					catch (NumberFormatException e)
					{
					}
				}
			}

			PatchState state = unixTime <= 0 ? null : patch.getImplementation().forVarbitValue(value);
			if (state == null)
			{
				itemManager.getImage(Produce.WEEDS.getItemID()).addTo(panel.getIcon());
				panel.getIcon().setToolTipText("Unknown state");
				panel.getProgress().setMaximumValue(0);
				panel.getProgress().setValue(0);
				panel.getProgress().setVisible(false);
				panel.getEstimate().setText("Unknown");
				panel.getProgress().setBackground(null);
			}
			else
			{
				if (state.getProduce().getItemID() < 0)
				{
					panel.getIcon().setIcon(null);
					panel.getIcon().setToolTipText("Unknown state");
				}
				else
				{
					itemManager.getImage(state.getProduce().getItemID()).addTo(panel.getIcon());
					panel.getIcon().setToolTipText(state.getProduce().getName());
				}

				int stage = state.getStage();
				int stages = state.getStages();
				int tickrate = state.getTickRate() * 60;

				if (autoweed && state.getProduce() == Produce.WEEDS)
				{
					stage = 0;
					stages = 1;
					tickrate = 0;
				}
				if (tickrate > 0)
				{
					long tickNow = unixNow / tickrate;
					long tickTime = unixTime / tickrate;
					int delta = (int) (tickNow - tickTime);

					long doneEstimate = ((stages - 1 - stage) + tickTime) * tickrate;

					stage += delta;
					if (stage >= stages)
					{
						stage = stages - 1;
					}

					if (doneEstimate < unixNow)
					{
						panel.getEstimate().setText("Done");
					}
					else
					{
						panel.getEstimate().setText("Done " + getFormattedEstimate(doneEstimate - unixNow, config.estimateRelative()));
					}
				}
				else
				{
					switch (state.getCropState())
					{
						case HARVESTABLE:
							panel.getEstimate().setText("Done");
							break;
						case GROWING:
							if (stage == stages - 1)
							{
								panel.getEstimate().setText("Done");
							}
							else
							{
								panel.getEstimate().setText("Unknown");
							}
							break;
						case DISEASED:
							panel.getEstimate().setText("Diseased");
							break;
						case DEAD:
							panel.getEstimate().setText("Dead");
							break;
					}
				}

				/* Hide any fully grown weeds' progress bar. */
				if (state.getProduce() != Produce.WEEDS
					|| (state.getProduce() == Produce.WEEDS && !autoweed && stage < stages - 1))
				{
					panel.getProgress().setVisible(true);
					panel.getProgress().setForeground(state.getCropState().getColor().darker());
					panel.getProgress().setMaximumValue(stages - 1);
					panel.getProgress().setValue(stage);
				}
				else
				{
					panel.getProgress().setVisible(false);
				}
			}
		}
	}
}
