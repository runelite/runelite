/*
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
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
package net.runelite.client.plugins.droptracker;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.grounditems.GroundItemsConfig;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.StackFormatter;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
class DropTrackerPanel extends PluginPanel
{
	private List<DropTrackerInfoBox> infoBoxes = new ArrayList<>();

	private final JLabel overallText = new JLabel("Drops");

	/* This displays the "No drops gained" text */
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	private final DropTrackerPlugin dropTrackerPlugin;
	private final Client client;
	private JPanel infoBoxPanel = new JPanel();
	private final GroundItemsConfig groundItemsConfig;
	private final DropTrackerConfig dropTrackerConfig;

	DropTrackerPanel(DropTrackerPlugin dropTrackerPlugin, Client client, DropTrackerConfig dropTrackerConfig, GroundItemsConfig groundItemsConfig)
	{
		super();
		this.dropTrackerPlugin = dropTrackerPlugin;
		this.client = client;
		this.groundItemsConfig = groundItemsConfig;
		this.dropTrackerConfig = dropTrackerConfig;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		add(layoutPanel);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Remove All");
		reset.addActionListener(e -> removeAllDrop());


		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);

		// ------ testing ---------
		if (RuneLite.getOptions().has("developer-mode"))
		{
			final JMenuItem testingDropPanel = new JMenuItem("Add Test Drop");
			testingDropPanel.addActionListener(e -> dropTrackerPlugin.testDrops());
			popupMenu.add(testingDropPanel);
		}
		// ------------------------

		final JPanel overallPanel = new JPanel();
		overallPanel.setComponentPopupMenu(popupMenu);
		overallPanel.add(overallText, BorderLayout.CENTER);

		errorPanel.setContent("Drop tracker", "You have not gained any drop yet.");
		errorPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		errorPanel.setVisible(false);

		infoBoxPanel.setLayout(new BoxLayout(infoBoxPanel, BoxLayout.Y_AXIS));
		layoutPanel.add(infoBoxPanel, BorderLayout.CENTER);

		layoutPanel.add(overallPanel, BorderLayout.NORTH);
		calculatePrice();
	}

	void reload()
	{
		SwingUtilities.invokeLater(() -> reloadDrops());
		infoBoxLimit();
	}

	void newDrop(Drop drop)
	{
		SwingUtilities.invokeLater(() -> addDrop(drop));
		infoBoxLimit();
	}

	private void reloadDrops()
	{
		List<DropTrackerInfoBox> newInfoBoxes = new ArrayList<>();
		for (DropTrackerInfoBox infoBox : infoBoxes)
		{
			infoBoxPanel.remove(infoBox);
			try
			{
				DropTrackerInfoBox instanceInfoBox = new DropTrackerInfoBox(dropTrackerPlugin, client, dropTrackerConfig, groundItemsConfig, this, infoBoxPanel, infoBox.getDrop());
				newInfoBoxes.add(instanceInfoBox);
			}
			catch (IOException e)
			{
				log.warn(null, e);
			}
		}
		infoBoxes = newInfoBoxes;
		for (DropTrackerInfoBox infoBox : infoBoxes)
		{
			if (infoBox.isHiding())
			{
				continue;
			}
			infoBox.AddToPanel(false);
		}
		infoBoxPanel.revalidate();
		calculatePrice();
	}

	private void addDrop(Drop drop)
	{
		try
		{
			DropTrackerInfoBox infoBox = new DropTrackerInfoBox(dropTrackerPlugin, client, dropTrackerConfig, groundItemsConfig, this, infoBoxPanel, drop);
			if (!infoBox.isHiding())
			{
				infoBox.AddToPanel(true);
			}
			infoBoxes.add(infoBox);
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}
		calculatePrice();
	}

	void KeyListenerChanged()
	{
		for (DropTrackerInfoBox infoBox : infoBoxes)
		{
			infoBox.KeyListenerChanged();
		}
	}

	void removeDrop(DropTrackerInfoBox infoBox)
	{
		infoBox.reset();
		infoBoxes.remove(infoBox);
		calculatePrice();
	}

	private void removeAllDrop()
	{
		for (DropTrackerInfoBox infoBoxe : infoBoxes)
		{
			infoBoxe.reset();
		}
		infoBoxes.clear();
		calculatePrice();
	}

	private void calculatePrice()
	{
		long gePrice = 0;
		for (DropTrackerInfoBox infoBoxe : infoBoxes)
		{
			gePrice += infoBoxe.getGePrice();
		}
		if (infoBoxes.size() == 0)
		{
			if (!errorPanel.isVisible())
			{
				errorPanel.setVisible(true);
				add(errorPanel);
			}
			overallText.setText("Drops");
			return;
		}
		if (errorPanel.isVisible())
		{
			errorPanel.setVisible(false);
			remove(errorPanel);
		}
		overallText.setText("Drops - (EX: " + StackFormatter.quantityToStackSize(gePrice) + ")");
	}

	private void infoBoxLimit()
	{
		for (DropTrackerInfoBox infoBox : infoBoxes)
		{
			infoBoxPanel.remove(infoBox);
		}
		infoBoxes = infoBoxes.subList((infoBoxes.size() - dropTrackerConfig.dropTrackerLimit()) < 0 ?
				0 : (infoBoxes.size() - dropTrackerConfig.dropTrackerLimit() + 1),
				infoBoxes.size());
		for (DropTrackerInfoBox infoBox : Lists.reverse(infoBoxes))
		{
			infoBoxPanel.add(infoBox);
		}
	}
}
