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

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.plugins.grounditems.GroundItemsConfig;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.StackFormatter;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

class DropTrackerInfoBox extends JPanel
{
	private final DropTrackerPlugin dropTrackerPlugin;
	private final DropTrackerPanel dropTrackerPanel;
	private final JPanel panel;

	/* The tracker's wrapping container */
	private final JPanel container = new JPanel();

	@Getter(AccessLevel.PACKAGE)
	private long gePrice = 0;

	@Getter(AccessLevel.PACKAGE)
	private Drop drop;

	@Getter(AccessLevel.PACKAGE)
	private boolean isHiding;

	private List<Color> backgroundColor;

	DropTrackerInfoBox(DropTrackerPlugin dropTrackerPlugin, Client client, DropTrackerConfig dropTrackerConfig, GroundItemsConfig groundItemsConfig, DropTrackerPanel dropTrackerPanel, JPanel panel, Drop drop) throws IOException
	{
		this.panel = panel;
		this.dropTrackerPlugin = dropTrackerPlugin;
		this.dropTrackerPanel = dropTrackerPanel;
		this.drop = drop;
		this.backgroundColor = new ArrayList<>();

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, -1, 6, -1));

		container.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				for (Component component : getAllComponents(container))
				{
					backgroundColor.add(component.getBackground());
					component.setBackground(component.getBackground().brighter().brighter());
				}
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				int i = 0;
				for (Component component : getAllComponents(container))
				{
					component.setBackground(backgroundColor.get(i++));
				}
				backgroundColor.clear();
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				remove();
			}
		});

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		container.setBorder(new EmptyBorder(0, 1, 0, 1));

		// Create reset menu
		final JMenuItem clear = new JMenuItem("Remove");
		clear.addActionListener(e -> dropTrackerPanel.removeDrop(this));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(clear);
		container.setComponentPopupMenu(popupMenu);

		final JPanel headerPanel = new JPanel();
		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setBorder(new EmptyBorder(0, 0, -3, 0));

		final JPanel itemDropLayout = new JPanel();
		itemDropLayout.setBorder(new EmptyBorder(0, 0, 0, 0));
		itemDropLayout.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		final JPanel middlePanel = new JPanel();
		middlePanel.setBorder(new EmptyBorder(-5, 3, -2, 3));
		middlePanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel nameLabel = new JLabel("NPC");
		nameLabel.setFont(FontManager.getRunescapeSmallFont());

		int items = 0;
		for (int i = 0; i < drop.getDrop().length; i++)
		{
			final String name = drop.getDrop()[i].getName();
			final int amount = drop.getDrop()[i].getAmount();
			final long price = drop.getDrop()[i].getPrice();
			Color color;
			Color fontcolor = null;

			gePrice += price;
			if (dropTrackerConfig.takeSettingFromGroundItem())
			{
				if (!Arrays.asList(groundItemsConfig.getHighlightItems().split(", ")).contains(name) && (
						price < groundItemsConfig.getHideUnderGeValue() ||
						Arrays.asList(groundItemsConfig.getHiddenItems().split(", ")).contains(name)))
				{
					continue;
				}

				if (Arrays.asList(groundItemsConfig.getHighlightItems().split(", ")).contains(name))
				{
					fontcolor = groundItemsConfig.highlightedColor();
				}
				else if (price >= groundItemsConfig.insaneValuePrice())
				{
					fontcolor = groundItemsConfig.insaneValueColor();
				}
				else if (price >= groundItemsConfig.highValuePrice())
				{
					fontcolor = groundItemsConfig.highValueColor();
				}
				else if (price >= groundItemsConfig.mediumValuePrice())
				{
					fontcolor = groundItemsConfig.mediumValueColor();
				}
				else if (price >= groundItemsConfig.lowValuePrice())
				{
					fontcolor = groundItemsConfig.lowValueColor();
				}
			}
			color = ColorScheme.DARK_GRAY_HOVER_COLOR;
			if (items % 2 == 0)
			{
				color = color.darker();
			}

			JPanel dropPanel = new JPanel();
			dropPanel.setLayout(new GridLayout(1, 2));
			dropPanel.setBorder(new EmptyBorder(-4, 2, -4, 1));
			dropPanel.setBackground(color);

			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BorderLayout());

			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new GridLayout(1, 2));

			JPanel rightPanelAmount = new JPanel();
			JPanel rightPanelGP = new JPanel();

			JLabel labelName = new JLabel();
			JLabel labelAmount = new JLabel();
			JLabel labelGP = new JLabel();

			labelName.setText(ColorLabel(fontcolor, name));
			labelAmount.setText(ColorLabel(fontcolor, "(" + StackFormatter.quantityToStackSize(amount) + ")"));
			labelGP.setText(ColorLabel(fontcolor, StackFormatter.quantityToStackSize(price)));

			labelName.setFont(FontManager.getRunescapeSmallFont());
			labelAmount.setFont(FontManager.getRunescapeSmallFont());
			labelGP.setFont(FontManager.getRunescapeSmallFont());

			rightPanelAmount.add(labelAmount, BorderLayout.EAST);
			rightPanelAmount.setBackground(color);

			rightPanelGP.add(labelGP, BorderLayout.EAST);
			rightPanelGP.setBackground(color);

			rightPanel.add(rightPanelAmount);
			rightPanel.add(rightPanelGP);
			rightPanel.setBackground(color);

			leftPanel.add(labelName, BorderLayout.WEST);
			leftPanel.setBackground(color);

			dropPanel.add(leftPanel);
			dropPanel.add(rightPanel);

			itemDropLayout.add(dropPanel);
			items++;
		}

		if (dropTrackerConfig.hideDropWith0Loot() && gePrice <= 0)
		{
			isHiding = true;
			return;
		}
		isHiding = false;

		itemDropLayout.setLayout(new GridLayout(items, 1));
		middlePanel.add(itemDropLayout);
		nameLabel.setText(drop.getName() + " - ( EX: " + StackFormatter.quantityToStackSize(gePrice) + " )");

		headerPanel.add(nameLabel, BorderLayout.CENTER);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(middlePanel, BorderLayout.CENTER);

		add(container, BorderLayout.NORTH);
	}

	void AddToPanel(boolean toRevalidate)
	{
		if (!isHiding)
		{
			panel.add(this, 0);
		}
		if (toRevalidate)
		{
			panel.revalidate();
		}
	}

	void KeyListenerChanged()
	{
		if (dropTrackerPlugin.isKeyIsPress())
		{
			container.setToolTipText("Remove");
			return;
		}
		container.setToolTipText(null);
	}

	private void remove()
	{
		if (dropTrackerPlugin.isKeyIsPress())
		{
			dropTrackerPanel.removeDrop(this);
		}
	}

	void reset()
	{
		panel.remove(this);
		panel.revalidate();
	}

	private String ColorLabel(Color code, String value)
	{
		if (code == null)
		{
			return value;
		}
		final int r = code.getRed();
		final int g = code.getGreen();
		final int b = code.getBlue();
		return "<html><body style = 'color:" + String.format("#%02x%02x%02x", r, g, b) + "'>" + value + "</body></html>";
	}

	private Collection<Component> getAllComponents(final Container c)
	{
		Component[] comps = c.getComponents();
		Collection<Component> compList = new ArrayList<>();
		for (Component comp : comps)
		{
			compList.add(comp);
			if (comp instanceof Container)
			{
				compList.addAll(getAllComponents((Container) comp));
			}
		}
		return compList;
	}
}
