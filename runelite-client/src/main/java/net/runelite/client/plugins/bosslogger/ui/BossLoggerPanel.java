/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.bosslogger.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslogger.BossLoggerPlugin;
import net.runelite.client.plugins.bosslogger.Tab;
import net.runelite.client.plugins.bosslogger.UniqueItem;
import net.runelite.client.plugins.bosslogger.data.LootEntry;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;


@Slf4j
public class BossLoggerPanel extends PluginPanel
{
	private final ItemManager itemManager;
	private final BossLoggerPlugin bossLoggerPlugin;

	// Displayed on Recorded Loot Page (updated for each tab)
	private JPanel title;
	private LootPanel lootPanel;
	private Tab currentTab = null;

	// Displayed on Landing/Selection Page
	private PluginErrorPanel errorPanel;
	private JPanel tabGroup;

	// Panel Colors
	private final static Color BACKGROUND_COLOR = ColorScheme.DARK_GRAY_COLOR;
	private final static Color BUTTON_COLOR = ColorScheme.DARKER_GRAY_COLOR;
	private final static Color BUTTON_HOVER_COLOR = ColorScheme.DARKER_GRAY_HOVER_COLOR;

	@Inject
	public BossLoggerPanel(ItemManager itemManager, BossLoggerPlugin bossLoggerPlugin)
	{
		super(false);

		this.itemManager = itemManager;
		this.bossLoggerPlugin = bossLoggerPlugin;

		this.setLayout(new BorderLayout());
		this.setBackground(BACKGROUND_COLOR);

		tabGroup = new JPanel();
		tabGroup.setBorder(new EmptyBorder(0, 8, 0, 0));
		tabGroup.setLayout(new GridBagLayout());
		tabGroup.setBackground(BACKGROUND_COLOR);

		title = new JPanel();
		title.setBorder(new CompoundBorder(
				new EmptyBorder(10, 8, 8, 8),
				new MatteBorder(0, 0, 1, 0, Color.GRAY)
		));
		title.setLayout(new BorderLayout());
		title.setBackground(BACKGROUND_COLOR);

		errorPanel = new PluginErrorPanel();
		errorPanel.setBorder(new EmptyBorder(10, 25, 10, 25));

		createLandingPanel();
	}

	// Landing page (Boss Selection Screen)
	private void createLandingPanel()
	{
		currentTab = null;
		this.removeAll();

		errorPanel.setContent("Boss Logger Plugin", "Select a boss icon to view the recorded loot for it");

		createTabGroup();

		this.add(errorPanel, BorderLayout.NORTH);
		this.add(wrapContainer(tabGroup), BorderLayout.CENTER);
	}

	private void createTabGroup()
	{
		tabGroup.removeAll();

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;

		// Add the bosses tabs, by category, to tabGroup
		Set<String> categories = Tab.categories;
		for (String categoryName : categories)
		{
			createTabCategory(categoryName, c);
		}
	}

	// Creates all tabs for a specific category
	private void createTabCategory(String categoryName, GridBagConstraints c)
	{
		MaterialTabGroup thisTabGroup = new MaterialTabGroup();
		thisTabGroup.setLayout(new GridLayout(0, 4, 7, 7));
		thisTabGroup.setBorder(new EmptyBorder(4, 0, 0, 0));

		JLabel name = new JLabel(categoryName);
		name.setBorder(new EmptyBorder(8, 0, 0, 0));
		name.setForeground(Color.WHITE);
		name.setVerticalAlignment(SwingConstants.CENTER);

		ArrayList<Tab> categoryTabs = Tab.getByCategoryName(categoryName);
		for (Tab tab : categoryTabs)
		{
			// Only create tabs for enabled recording options
			if (bossLoggerPlugin.isBeingRecorded(tab.getName()))
			{
				// Create tab (with hover effects/text)
				MaterialTab materialTab = new MaterialTab("", thisTabGroup, null);
				materialTab.setName(tab.getName());
				materialTab.setToolTipText(tab.getBossName());
				materialTab.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseEntered(MouseEvent e)
					{
						materialTab.setBackground(BUTTON_HOVER_COLOR);
					}

					@Override
					public void mouseExited(MouseEvent e)
					{
						materialTab.setBackground(BUTTON_COLOR);
					}
				});

				// Attach Icon to the Tab
				AsyncBufferedImage image = itemManager.getImage(tab.getItemID());
				Runnable resize = () ->
				{
					materialTab.setIcon(new ImageIcon(image.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
					materialTab.setOpaque(true);
					materialTab.setBackground(BUTTON_COLOR);
					materialTab.setHorizontalAlignment(SwingConstants.CENTER);
					materialTab.setVerticalAlignment(SwingConstants.CENTER);
					materialTab.setPreferredSize(new Dimension(35, 35));
				};
				image.onChanged(resize);
				resize.run();

				materialTab.setOnSelectEvent(() ->
				{
					this.showTabDisplay(tab);
					materialTab.unselect();
					materialTab.setBackground(BACKGROUND_COLOR);
					return true;
				});

				thisTabGroup.addTab(materialTab);
			}
		}

		if (thisTabGroup.getComponentCount() > 0)
		{
			tabGroup.add(name, c);
			c.gridy++;
			tabGroup.add(thisTabGroup, c);
			c.gridy++;
		}
	}

	// Landing page (Boss Selection Screen)
	private void createTabPanel(Tab tab)
	{
		currentTab = tab;
		this.removeAll();

		createTabTitle(tab.getBossName());

		bossLoggerPlugin.loadTabData(tab);

		this.add(title, BorderLayout.NORTH);
		this.add(wrapContainer(createLootPanel(tab)), BorderLayout.CENTER);
	}

	private JLabel createIconLabel(String iconName)
	{
		JLabel label = new JLabel();
		BufferedImage icon = null;
		synchronized (ImageIO.class)
		{
			try
			{
				icon = ImageIO.read(getClass().getResourceAsStream(iconName));
			}
			catch (IOException e)
			{
				log.warn("Error getting resource icon: {0} | Message: {1}", iconName, e.getMessage());
			}
		}

		if (icon == null)
			return label;

		label.setIcon(new ImageIcon(icon));
		label.setOpaque(true);
		label.setBackground(BACKGROUND_COLOR);

		label.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				label.setBackground(BUTTON_HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				label.setBackground(BACKGROUND_COLOR);
			}
		});

		return label;
	}

	// Creates the title panel for the recorded loot tab
	private void createTabTitle(String name)
	{
		title.removeAll();

		JPanel first = new JPanel();
		first.setBackground(BACKGROUND_COLOR);

		// Back Button
		JLabel back = createIconLabel("back-arrow-white.png");
		back.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				showLandingPage();
			}
		});

		// Plugin Name
		JLabel text = new JLabel(name);
		text.setForeground(Color.WHITE);

		first.add(back);
		first.add(text);

		JPanel second = new JPanel();
		second.setBackground(BACKGROUND_COLOR);

		// Refresh Data button
		JLabel refresh = createIconLabel("refresh-white.png");
		refresh.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				refreshLootPanel(lootPanel, currentTab);
			}
		});

		// Clear data button
		JLabel clear = createIconLabel("delete-white.png");
		clear.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clearData(currentTab);
			}
		});

		second.add(refresh);
		second.add(clear);

		title.add(first, BorderLayout.WEST);
		title.add(second, BorderLayout.EAST);
	}

	// Wrapper for creating LootPanel
	private JPanel createLootPanel(Tab tab)
	{
		// Grab Tab Data
		ArrayList<LootEntry> data = bossLoggerPlugin.getData(tab);

		// Unique Items Info
		ArrayList<UniqueItem> list = UniqueItem.getByActivityName(tab.getName());
		Map<Integer, ArrayList<UniqueItem>> sets = UniqueItem.createPositionSetMap(list);

		// Create & Return Loot Panel
		lootPanel = new LootPanel(data, sets, itemManager);

		return lootPanel;
	}

	private void showTabDisplay(Tab tab)
	{
		createTabPanel(tab);

		this.revalidate();
		this.repaint();
	}

	private void showLandingPage()
	{
		createLandingPanel();

		this.revalidate();
		this.repaint();
	}

	// Wrap the panel inside a scroll pane
	private JScrollPane wrapContainer(JPanel container)
	{
		JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(container, BorderLayout.NORTH);
		wrapped.setBackground(BACKGROUND_COLOR);

		JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
		scroller.setBackground(BACKGROUND_COLOR);

		return scroller;
	}

	// Refresh the Loot Panel with updated data (requests the data from file)
	private void refreshLootPanel(LootPanel lootPanel, Tab tab)
	{
		// Refresh data for necessary tab
		bossLoggerPlugin.loadTabData(tab);

		// Recreate the loot panel
		lootPanel.updateRecords(bossLoggerPlugin.getData(tab));

		// Ensure changes are applied
		this.revalidate();
		this.repaint();
	}

	private void clearData(Tab tab)
	{
		if (lootPanel.getRecords().size() == 0)
		{
			JOptionPane.showMessageDialog(this.getRootPane(), "No data to remove!");
			return;
		}

		int delete = JOptionPane.showConfirmDialog(this.getRootPane(), "<html>Are you sure you want to clear all data for this tab?<br/>There is no way to undo this action.</html>", "Warning", JOptionPane.YES_NO_OPTION);
		if (delete == JOptionPane.YES_OPTION)
		{
			bossLoggerPlugin.clearData(tab);
			// Refresh current panel
			refreshLootPanel(lootPanel, tab);
		}
	}

	public void toggleTab(Tab tab)
	{
		// Recreate landing page if currently being shown or toggled active tab
		if (currentTab == null || tab.equals(currentTab))
			createLandingPanel();
	}

	// Refresh tab data if being shown
	public void refreshCurrentTab()
	{
		if (currentTab != null)
			showTabDisplay(currentTab);
	}

	// Updates panel for this tab name
	public void updateTab(Tab tab)
	{
		// Change to tab of recently killed boss if on landing page
		if (currentTab == null)
		{
			currentTab = tab;
			SwingUtilities.invokeLater(() -> showTabDisplay(tab));
			return;
		}

		// only update the tab if they are looking at this boss tab
		if (tab.equals(currentTab))
		{
			// Reload data from file to ensure data and UI match
			bossLoggerPlugin.loadTabData(currentTab);
			// Grab LootPanel that needs to be updated
			SwingUtilities.invokeLater(() -> lootPanel.updateRecords(bossLoggerPlugin.getData(tab)));
		}
	}
}