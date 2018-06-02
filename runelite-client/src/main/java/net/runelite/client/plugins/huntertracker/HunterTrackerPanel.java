/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018 Jeff LaJoie
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
package net.runelite.client.plugins.huntertracker;


import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

@Slf4j
class HunterTrackerPanel extends PluginPanel
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final HunterTrackerConfig config;

	boolean active;

	private List<BirdhouseSpacePanel> spacePanels = new ArrayList<>();

	/* This is the panel the tabs' respective panels will be displayed on. */
	private final JPanel display = new JPanel();
	private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);

	HunterTrackerPanel(
			Client client,
			ItemManager itemManager,
			ConfigManager configManager,
			HunterTrackerConfig config,
			HunterWorld hunterWorld
	)
	{
		super(false);

		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		display.setBorder(new EmptyBorder(10, 10, 8, 10));

		tabGroup.setBorder(new EmptyBorder(10, 1, 0, 0));

		add(tabGroup, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);

		hunterWorld.getTabs().forEach((tab, spaces) ->
		{
			JPanel container = new JPanel(new GridBagLayout())
			{
				@Override
				public Dimension getPreferredSize()
				{
					return new Dimension(PluginPanel.PANEL_WIDTH, super.getPreferredSize().height);
				}
			};
			container.setBackground(ColorScheme.DARK_GRAY_COLOR);

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;

			SpaceImplementation lastImpl = null;

			boolean first = true;
			for (BirdhouseSpace space : spaces)
			{
				BirdhouseSpacePanel p = new BirdhouseSpacePanel(space);

				/* Show labels to subdivide tabs into sections */
				if (space.getImplementation() != lastImpl && !Strings.isNullOrEmpty(space.getImplementation().getName()))
				{
					JLabel groupLabel = new JLabel(space.getImplementation().getName());

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

					container.add(groupLabel, c);
					c.gridy++;
					lastImpl = space.getImplementation();
				}

				spacePanels.add(p);
				container.add(p, c);
				c.gridy++;

				/* This is a weird hack to remove the top border on the first tracker of every tab */
				if (first)
				{
					first = false;
					p.setBorder(null);
				}
			}

			JPanel wrapped = new JPanel(new BorderLayout());
			wrapped.add(container, BorderLayout.NORTH);
			wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

			JScrollPane scroller = new JScrollPane(wrapped);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 9, 0, 0));
			scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

			//Use a placeholder icon until the async image gets loaded
			MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
			materialTab.setPreferredSize(new Dimension(30, 27));
			materialTab.setName(tab.getName());

			AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
			Runnable resize = () ->
			{
				BufferedImage subIcon = icon.getSubimage(0, 0, 32, 32);
				materialTab.setIcon(new ImageIcon(subIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
			};
			icon.onChanged(resize);
			resize.run();

			materialTab.setOnSelectEvent(() -> config.setRegion(tab));

			tabGroup.addTab(materialTab);
			if (config.region() == tab)
			{
				tabGroup.select(materialTab);
			}
		});
	}

	void update()
	{
		if (!active)
		{
			return;
		}

		long unixNow = Instant.now().getEpochSecond();
		log.debug("Updating panel with username {}", client.getUsername());
		for (BirdhouseSpacePanel panel : spacePanels)
		{
			BirdhouseSpace space = panel.getSpace();
			String group = HunterTrackerConfig.KEY_NAME + "." + client.getUsername() + "." + space.getRegion().getRegionID();
			String key = Integer.toString(space.getVarPlayer().getId());
			String storedValue = configManager.getConfiguration(group, key);
			int value = 0;
			long startTime = 0;
			long updatedAt = 0;
			if (storedValue != null)
			{
				String[] parts = storedValue.split(":");
				if (parts.length == 3)
				{
					try
					{
						value = Integer.parseInt(parts[0]);
						startTime = Long.parseLong(parts[1]);
						updatedAt = Long.parseLong(parts[2]);
					}
					catch (NumberFormatException e)
					{
						log.debug(e.getMessage());
					}
				}
			}

			SpaceState state = updatedAt <= 0 ? null : space.getImplementation().forVarPlayerValue(value);
			if (state == null)
			{
				panel.getIcon().setIcon(null);
				panel.getIcon().setToolTipText("Unknown state");
				panel.getProgress().setValue(0);
				panel.getProgress().setVisible(false);
				panel.getEstimate().setText("Unknown");
				panel.getProgress().setBackground(null);
			}
			else
			{
				if (state.getBirdhouse() == null || state.getBirdhouse().getItemID() < 0)
				{
					panel.getIcon().setIcon(null);
					panel.getIcon().setToolTipText("Empty");
				}
				else
				{
					itemManager.getImage(state.getBirdhouse().getItemID()).addTo(panel.getIcon());
					panel.getIcon().setToolTipText(state.getBirdhouse().getName());
				}
				long doneEstimate = startTime + config.DURATION.getSeconds();

				panel.getProgress().setVisible(true);
				panel.getProgress().setForeground(state.getSpaceState().getColor().darker());
				if (doneEstimate < unixNow)
				{
					panel.getProgress().setValue((int)config.DURATION.getSeconds()); // Mark as complete
					panel.getProgress().setForeground(BirdhouseState.COMPLETE.getColor());
					panel.getEstimate().setText("Done");
				}
				else
				{
					switch (state.getSpaceState())
					{
						case EMPTY:
							panel.getProgress().setVisible(false);
							panel.getEstimate().setText("Empty");
							break;
						case BUILT:
							panel.getProgress().setValue(0);
							panel.getEstimate().setText("Built");
							break;
						case SEEDED:
							int remainingSeconds = (int) (59 + doneEstimate - unixNow);
							int remaining = remainingSeconds / 60;
							panel.getProgress().setValue((int)config.DURATION.getSeconds() - remainingSeconds);
							StringBuilder f = new StringBuilder("Done in ");
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
							break;
						default:
							panel.getIcon().setIcon(null);
							panel.getIcon().setToolTipText("Unknown state");
							panel.getProgress().setValue(0);
							panel.getProgress().setVisible(false);
							panel.getEstimate().setText("Unknown");
							panel.getProgress().setBackground(null);
							break;
					}
				}
			}
			panel.getProgress().update();
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
