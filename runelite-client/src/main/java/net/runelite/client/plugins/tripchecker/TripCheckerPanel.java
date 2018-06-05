/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.tripchecker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxListRenderer;

class TripCheckerPanel extends PluginPanel
{
	private TripCheckerPlugin plugin;

	private JComboBox<String> existingLoadouts;

	@Inject
	TripCheckerPanel(TripCheckerPlugin plugin)
	{
		this.plugin = plugin;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new DynamicGridLayout(0, 1, 0, 5));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());
		JLabel loadoutsLabel = new JLabel("Existing Loadouts");
		loadoutsLabel.setForeground(Color.WHITE);
		item.add(loadoutsLabel, BorderLayout.WEST);

		if (!this.plugin.getTripLists().isEmpty())
		{
			existingLoadouts = new JComboBox<>(this.plugin.getTripLists().keySet().toArray(new String[0]));
		}
		else
		{
			existingLoadouts = new JComboBox<>();
		}
		existingLoadouts.setPreferredSize(new Dimension(existingLoadouts.getPreferredSize().width, 25));
		existingLoadouts.setRenderer(new ComboBoxListRenderer());
		existingLoadouts.setForeground(Color.WHITE);
		existingLoadouts.setFocusable(false);
		if (this.plugin.getTripLists().isEmpty())
		{
			existingLoadouts.setEnabled(false);
		}
		item.add(existingLoadouts, BorderLayout.CENTER);
		add(item);

		JButton saveCurrentLoadoutButton = new JButton("Save Current Loadout");
		saveCurrentLoadoutButton.addActionListener(e -> this.plugin.copyCurrentItemsToTripList());
		add(saveCurrentLoadoutButton);

		JButton checkLoadoutButton = new JButton("Check Loadout");
		checkLoadoutButton.addActionListener(e ->
		{
			Object selectedItem = existingLoadouts.getSelectedItem();
			if (selectedItem == null)
			{
				return;
			}

			this.plugin.checkInventoryAgainstLoadout(selectedItem.toString());
		});
		add(checkLoadoutButton);

		JButton deleteLoadoutButton = new JButton("Delete Current Loadout");
		deleteLoadoutButton.addActionListener(e ->
		{
			Object selectedItem = existingLoadouts.getSelectedItem();
			if (selectedItem == null)
			{
				return;
			}

			if (this.plugin.deleteLoadout(selectedItem.toString()))
			{
				refreshLoadouts();
			}
		});
		add(deleteLoadoutButton);
	}

	void refreshLoadouts()
	{
		existingLoadouts.removeAllItems();
		for (String s : plugin.getTripLists().keySet())
		{
			existingLoadouts.addItem(s);
		}

		if (existingLoadouts.getItemCount() > 0)
		{
			existingLoadouts.setEnabled(true);
		}
		else
		{
			existingLoadouts.removeAllItems();
			existingLoadouts.setSelectedItem(null);
			existingLoadouts.setSelectedIndex(-1);
			existingLoadouts.setEnabled(false);
		}
	}
}
