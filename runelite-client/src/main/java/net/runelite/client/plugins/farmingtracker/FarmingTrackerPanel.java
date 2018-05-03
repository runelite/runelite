/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.farmingtracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.vars.Autoweed;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;

@Slf4j
class FarmingTrackerPanel extends PluginPanel
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final FarmingTrackerConfig config;

	private boolean active;

	private List<FarmingPatchPanel> patchPanels = new ArrayList<>();

	FarmingTrackerPanel(
		Client client,
		ItemManager itemManager,
		ConfigManager configManager,
		FarmingTrackerConfig config,
		FarmingWorld farmingWorld
	)
	{
		super(false);

		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;

		setLayout(new BorderLayout());

		JTabbedPane tabs = new JTabbedPane();
		farmingWorld.getTabs().forEach((tab, patches) ->
		{
			JPanel panel = new JPanel(new GridBagLayout())
			{
				@Override
				public Dimension getPreferredSize()
				{
					return new Dimension(PluginPanel.PANEL_WIDTH, super.getPreferredSize().height);
				}
			};
			panel.setBorder(new EmptyBorder(2, 6, 6, 6));

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;

			for (FarmingPatch patch : patches)
			{
				FarmingPatchPanel p = new FarmingPatchPanel(patch);
				patchPanels.add(p);
				panel.add(p, c);
				c.gridy++;
			}

			JPanel wrapped = new JPanel(new BorderLayout());
			wrapped.add(panel, BorderLayout.NORTH);
			JScrollPane scroller = new JScrollPane(wrapped);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.getVerticalScrollBar().setUnitIncrement(16);

			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			tabs.addTab(null, null, scroller, tab.getName());
			int idx = tabs.getTabCount() - 1;
			Runnable resize = () ->
			{
				tabs.setIconAt(idx, new ImageIcon(icon.getScaledInstance(24, 21, Image.SCALE_SMOOTH)));
			};
			icon.onChanged(resize);
			resize.run();

			if (config.patch() == tab)
			{
				tabs.setSelectedComponent(scroller);
			}
			tabs.addChangeListener(e ->
			{
				if (tabs.getSelectedComponent() == scroller)
				{
					config.setPatch(tab);
				}
			});
		});
		add(tabs, BorderLayout.CENTER);
	}

	void update()
	{
		if (!active)
		{
			return;
		}

		long unixNow = Instant.now().getEpochSecond();
		log.debug("Updating panel with username {}", client.getUsername());
		boolean autoweed = false;
		{
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername();
			autoweed = Integer.toString(Autoweed.ON.ordinal())
				.equals(configManager.getConfiguration(group, FarmingTrackerConfig.AUTOWEED));
		}
		for (FarmingPatchPanel panel : patchPanels)
		{
			FarmingPatch patch = panel.getPatch();
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername() + "." + patch.getRegion().getRegionID();
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
				panel.getIcon().setIcon(null);
				panel.getIcon().setToolTipText("Unknown state");
				panel.getProgress().setMaximum(0);
				panel.getProgress().setValue(0);
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
				int stages = state.getCropState() == CropState.HARVESTABLE ?
					state.getProduce().getHarvestStages() :
					state.getProduce().getStages();
				int tickrate = 0;
				switch (state.getCropState())
				{
					case HARVESTABLE:
						tickrate = state.getProduce().getRegrowTickrate() * 60;
						break;
					case GROWING:
						tickrate = state.getProduce().getTickrate() * 60;
						break;
				}
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
					else if (config.estimateRelative())
					{
						int remaining = (int) (59 + doneEstimate - unixNow) / 60;
						StringBuilder f = new StringBuilder();
						f.append("Done in ");
						int min = remaining % 60;
						int hours = (remaining / 60) % 24;
						int days = remaining / (60 * 24);
						if (days > 0)
						{
							f.append(days).append("d ");
						}
						if (hours > 0)
						{
							f.append(hours).append("h ");
						}
						if (min > 0)
						{
							f.append(min).append("m ");
						}
						panel.getEstimate().setText(f.toString());
					}
					else
					{
						StringBuilder f = new StringBuilder();
						LocalDateTime ldtTime = LocalDateTime.ofEpochSecond(doneEstimate, 0, OffsetDateTime.now().getOffset());
						LocalDateTime ldtNow = LocalDateTime.now();
						f.append("Done ");
						if (ldtTime.getDayOfWeek() != ldtNow.getDayOfWeek())
						{
							f.append(ldtTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault())).append(" ");
						}
						f.append(String.format("at %d:%02d", ldtTime.getHour(), ldtTime.getMinute()));
						panel.getEstimate().setText(f.toString());
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

				panel.getProgress().setBackground(state.getCropState().getColor().darker());
				panel.getProgress().setMaximum(stages - 1);
				panel.getProgress().setValue(stage);
			}
		}
	}

	@Override
	public void onActivate()
	{
		active = true;
		update();
	}

	@Override
	public void onDeactivate()
	{
		active = false;
	}
}
