/*
 * Copyright (c) 2018-2019, Ethan <https://github.com/Wea1thRS/>
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.inventorysetups.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.runelite.api.InventoryID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.inventorysetups.InventorySetup;
import net.runelite.client.plugins.inventorysetups.InventorySetupItem;
import net.runelite.client.plugins.inventorysetups.InventorySetupPlugin;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ImageUtil;

@Singleton
public class InventorySetupPluginPanel extends PluginPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon REMOVE_ICON;
	private static final ImageIcon REMOVE_HOVER_ICON;

	private final JPanel noSetupsPanel;
	private final JPanel invEqPanel;

	private final InventorySetupInventoryPanel invPanel;
	private final InventorySetupEquipmentPanel eqpPanel;

	private final JComboBox<String> setupComboBox;

	private final JLabel removeMarker;

	private final InventorySetupPlugin plugin;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "add_icon.png");
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage removeIcon = ImageUtil.getResourceStreamFromClass(InventorySetupPlugin.class, "remove_icon.png");
		REMOVE_ICON = new ImageIcon(removeIcon);
		REMOVE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(removeIcon, 0.53f));
	}

	public InventorySetupPluginPanel(final InventorySetupPlugin plugin, final ItemManager itemManager)
	{
		super(false);
		this.plugin = plugin;
		this.removeMarker = new JLabel(REMOVE_ICON);
		this.invPanel = new InventorySetupInventoryPanel(itemManager, plugin);
		this.eqpPanel = new InventorySetupEquipmentPanel(itemManager, plugin);
		this.noSetupsPanel = new JPanel();
		this.invEqPanel = new JPanel();
		this.setupComboBox = new JComboBox<>();

		// setup the title
		final JLabel addMarker = new JLabel(ADD_ICON);
		final JLabel title = new JLabel();
		title.setText("Inventory Setups");
		title.setForeground(Color.WHITE);

		// setup the add marker (+ sign in the top right)
		addMarker.setToolTipText("Add a new inventory setup");
		addMarker.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				plugin.addInventorySetup();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				addMarker.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				addMarker.setIcon(ADD_ICON);
			}
		});

		// setup the remove marker (X sign in the top right)
		removeMarker.setToolTipText("Remove the current inventory setup");
		removeMarker.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				final String name = (String) setupComboBox.getSelectedItem();
				plugin.removeInventorySetup(name, true);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				if (removeMarker.isEnabled())
				{
					removeMarker.setIcon(REMOVE_HOVER_ICON);
				}
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				removeMarker.setIcon(REMOVE_ICON);
			}
		});

		// setup the combo box for selection switching
		// add empty to indicate the empty position
		setupComboBox.addItem("");
		setupComboBox.setSelectedIndex(0);
		setupComboBox.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				String selection = (String) e.getItem();
				setCurrentInventorySetup(selection);
			}
		});

		// the panel on the top right that holds the add and delete buttons
		final JPanel markersPanel = new JPanel();
		markersPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		markersPanel.add(removeMarker);
		markersPanel.add(addMarker);

		// the top panel that has the title and the buttons
		final JPanel titleAndMarkersPanel = new JPanel();
		titleAndMarkersPanel.setLayout(new BorderLayout());
		titleAndMarkersPanel.add(title, BorderLayout.WEST);
		titleAndMarkersPanel.add(markersPanel, BorderLayout.EAST);

		// the panel that stays at the top and doesn't scroll
		// contains the title, buttons, and the combo box
		final JPanel northAnchoredPanel = new JPanel();
		northAnchoredPanel.setLayout(new BoxLayout(northAnchoredPanel, BoxLayout.Y_AXIS));
		northAnchoredPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		northAnchoredPanel.add(titleAndMarkersPanel);
		northAnchoredPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		northAnchoredPanel.add(setupComboBox);

		// the panel that holds the inventory and equipment panels
		final BoxLayout invEqLayout = new BoxLayout(invEqPanel, BoxLayout.Y_AXIS);
		invEqPanel.setLayout(invEqLayout);
		invEqPanel.add(invPanel);
		invEqPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		invEqPanel.add(eqpPanel);

		// setup the error panel. It's wrapped around a normal panel
		// so it doesn't stretch to fill the parent panel
		final PluginErrorPanel errorPanel = new PluginErrorPanel();
		errorPanel.setContent("Inventory Setups", "Select or create an inventory setup.");
		noSetupsPanel.add(errorPanel);

		// the panel that holds the inventory panels, and the error panel
		final JPanel contentPanel = new JPanel();
		final BoxLayout contentLayout = new BoxLayout(contentPanel, BoxLayout.Y_AXIS);
		contentPanel.setLayout(contentLayout);
		contentPanel.add(invEqPanel);
		contentPanel.add(noSetupsPanel);

		// wrapper for the main content panel to keep it from stretching
		final JPanel contentWrapper = new JPanel(new BorderLayout());
		contentWrapper.add(Box.createGlue(), BorderLayout.CENTER);
		contentWrapper.add(contentPanel, BorderLayout.NORTH);
		final JScrollPane contentWrapperPane = new JScrollPane(contentWrapper);
		contentWrapperPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		add(northAnchoredPanel, BorderLayout.NORTH);
		add(contentWrapperPane, BorderLayout.CENTER);

		// show the no setups panel on startup
		showNoSetupsPanel();

	}

	public void showNoSetupsPanel()
	{
		setupComboBox.setSelectedIndex(0);
		removeMarker.setEnabled(false);
		noSetupsPanel.setVisible(true);
		invEqPanel.setVisible(false);
	}

	private void showHasSetupPanel(final String name)
	{
		setupComboBox.setSelectedItem(name);
		removeMarker.setEnabled(true);
		noSetupsPanel.setVisible(false);
		invEqPanel.setVisible(true);
	}

	public void setCurrentInventorySetup(final String name)
	{
		if (name.isEmpty())
		{
			showNoSetupsPanel();
			return;
		}

		showHasSetupPanel(name);

		final InventorySetup inventorySetup = plugin.getInventorySetup(name);

		invPanel.setInventorySetupSlots(inventorySetup);
		eqpPanel.setEquipmentSetupSlots(inventorySetup);

		if (plugin.getHighlightDifference())
		{
			final List<InventorySetupItem> normInv = plugin.getNormalizedContainer(InventoryID.INVENTORY);
			final List<InventorySetupItem> normEqp = plugin.getNormalizedContainer(InventoryID.EQUIPMENT);

			highlightDifferences(normInv, inventorySetup, InventoryID.INVENTORY);
			highlightDifferences(normEqp, inventorySetup, InventoryID.EQUIPMENT);
		}
		else
		{
			invPanel.resetInventorySlotsColor();
			eqpPanel.resetEquipmentSlotsColor();
		}

		validate();
		repaint();
	}

	public void addInventorySetup(final String name)
	{
		setupComboBox.addItem(name);
	}

	public void removeInventorySetup(final String name)
	{
		setupComboBox.removeItem(name);
		showNoSetupsPanel();

		invPanel.resetInventorySlotsColor();
		eqpPanel.resetEquipmentSlotsColor();

		validate();
		repaint();
	}

	public void highlightDifferences(final List<InventorySetupItem> container,
									final InventorySetup setupToCheck,
									final InventoryID type)
	{
		switch (type)
		{
			case INVENTORY:
				invPanel.highlightDifferentSlots(container, setupToCheck);
				break;

			case EQUIPMENT:
				eqpPanel.highlightDifferences(container, setupToCheck);
				break;
		}
	}

	public final String getSelectedInventorySetup()
	{
		return (String) setupComboBox.getSelectedItem();
	}
}