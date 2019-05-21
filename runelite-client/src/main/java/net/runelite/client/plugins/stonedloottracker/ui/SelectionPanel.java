/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.stonedloottracker.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.stonedloottracker.data.BossTab;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

public class SelectionPanel extends JPanel
{
	private TreeSet<String> names;
	private LootTrackerPanel parent;
	private ItemManager itemManager;

	private final static Color BACKGROUND_COLOR = ColorScheme.DARK_GRAY_COLOR;
	private final static Color BUTTON_COLOR = ColorScheme.DARKER_GRAY_COLOR;
	private final static Color BUTTON_HOVER_COLOR = ColorScheme.DARKER_GRAY_HOVER_COLOR;

	private boolean configToggle;

	SelectionPanel(boolean configToggle, TreeSet<String> names, LootTrackerPanel parent, ItemManager itemManager)
	{
		this.names = names == null ? new TreeSet<>() : names;
		this.parent = parent;
		this.itemManager = itemManager;
		this.configToggle = configToggle;

		this.setLayout(new GridBagLayout());
		this.setBackground(BACKGROUND_COLOR);

		createPanel();
	}

	private void createPanel()
	{
		GridBagConstraints c = constrains();
		c.insets = new Insets(5, 0, 0, 0);

		// Add the bosses tabs, by category, to tabGroup
		if (configToggle)
		{
			Set<String> categories = BossTab.categories;
			JPanel container = new JPanel(new GridBagLayout());
			container.setBorder(new EmptyBorder(0, 0, 10, 0));
			int oldc = c.gridy;
			c.gridy = 0;
			for (String categoryName : categories)
			{
				container.add(createTabCategory(categoryName), c);
				c.gridy++;
			}
			c.gridy = oldc;
			this.add(container, c);
			c.gridy++;
		}

		// Add all other names
		for (String name : this.names)
		{
			if (!configToggle || BossTab.getByName(name) == null)
			{
				this.add(createNamePanel(name), c);
				c.gridy++;
			}
		}
	}

	private JPanel createNamePanel(String name)
	{
		JPanel p = new JPanel();
		p.add(new JLabel(name));
		p.setBackground(BUTTON_COLOR);
		p.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				p.setBackground(BUTTON_HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				p.setBackground(BUTTON_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				SwingUtilities.invokeLater(() -> parent.showLootView(name));
			}
		});

		return p;
	}

	static GridBagConstraints constrains()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		return c;
	}

	// Creates all tabs for a specific category
	private JPanel createTabCategory(String categoryName)
	{
		JPanel container = new JPanel();
		container.setLayout(new GridBagLayout());
		container.setBorder(new EmptyBorder(0, 5, 0, 5));

		GridBagConstraints c = constrains();

		MaterialTabGroup thisTabGroup = new MaterialTabGroup();
		thisTabGroup.setLayout(new GridLayout(0, 4, 7, 7));
		thisTabGroup.setBorder(new EmptyBorder(4, 0, 0, 0));

		JLabel name = new JLabel(categoryName);
		name.setBorder(new EmptyBorder(8, 0, 0, 0));
		name.setForeground(Color.WHITE);
		name.setVerticalAlignment(SwingConstants.CENTER);

		ArrayList<BossTab> categoryTabs = BossTab.getByCategoryName(categoryName);
		for (BossTab tab : categoryTabs)
		{
			// Create tab (with hover effects/text)
			MaterialTab materialTab = new MaterialTab("", thisTabGroup, null);
			materialTab.setName(tab.getName());
			materialTab.setToolTipText(tab.getName());
			//materialTab.setSelectedBorder(new EmptyBorder(0, 0, 0, 0));
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

				@Override
				public void mouseClicked(MouseEvent e)
				{
					SwingUtilities.invokeLater(() -> parent.showLootView(tab.getName()));
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

			thisTabGroup.addTab(materialTab);
		}

		container.add(name, c);
		c.gridy++;
		container.add(thisTabGroup, c);

		return container;
	}
}