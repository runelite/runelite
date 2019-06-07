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
package net.runelite.client.plugins.skillcalculator.banked.ui;

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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import lombok.Getter;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.skillcalculator.BankedCalculator;
import net.runelite.client.plugins.skillcalculator.banked.CriticalItem;
import net.runelite.client.plugins.skillcalculator.banked.beans.Activity;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.StackFormatter;

public class CriticalItemPanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(36, 36);
	private static final DecimalFormat FORMAT_COMMA = new DecimalFormat("#,###.#");

	private static final BufferedImage ICON_SETTINGS;

	private static final Border PANEL_BORDER = new EmptyBorder(3, 0, 3, 0);
	private final static Color BACKGROUND_COLOR = ColorScheme.DARKER_GRAY_COLOR;
	private final static Color BUTTON_HOVER_COLOR = ColorScheme.DARKER_GRAY_HOVER_COLOR;

	static
	{
		BufferedImage i1;
		try
		{
			synchronized (ImageIO.class)
			{
				i1 = ImageIO.read(BankedCalculator.class.getResourceAsStream("view-more-white.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		ICON_SETTINGS = i1;
	}

	private final BankedCalculator bankedCalculator;
	private final CriticalItem item;
	private final ItemManager itemManager;
	private double xp;
	@Getter
	private int amount;
	@Getter
	private double total;
	private Map<CriticalItem, Integer> linkedMap;
	private JShadowedLabel labelValue;

	private final JPanel infoContainer;
	private final JLabel image;
	private boolean infoVisibility = false;

	public CriticalItemPanel(BankedCalculator bankedCalculator, ItemManager itemManager, CriticalItem item, double xp, int amount, Map<CriticalItem, Integer> linkedMap)
	{
		this.bankedCalculator = bankedCalculator;
		this.item = item;
		this.xp = xp;
		this.amount = amount;
		this.total = xp * amount;
		this.itemManager = itemManager;
		this.linkedMap = linkedMap;

		this.setLayout(new GridBagLayout());
		this.setBorder(PANEL_BORDER);
		this.setBackground(ColorScheme.DARK_GRAY_COLOR);
		this.setVisible(this.amount > 0);

		infoContainer = new JPanel();
		infoContainer.setLayout(new GridBagLayout());
		infoContainer.setVisible(false);
		infoContainer.setBackground(BACKGROUND_COLOR);
		infoContainer.setBorder(new MatteBorder(1, 0, 0, 0, Color.GRAY));

		// Icon
		AsyncBufferedImage icon = itemManager.getImage(item.getItemID(), amount, item.getDefinition().isStackable() || amount > 1);
		image = new JLabel();
		image.setMinimumSize(ICON_SIZE);
		image.setMaximumSize(ICON_SIZE);
		image.setPreferredSize(ICON_SIZE);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBorder(new EmptyBorder(0, 8, 0, 0));

		Runnable resize = () ->
			image.setIcon(new ImageIcon(icon.getScaledInstance((int) ICON_SIZE.getWidth(), (int) ICON_SIZE.getHeight(), Image.SCALE_SMOOTH)));
		icon.onChanged(resize);
		resize.run();

		// Container for Info
		JPanel uiInfo = new JPanel(new GridLayout(2, 1));
		uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));
		uiInfo.setBackground(BACKGROUND_COLOR);

		JShadowedLabel labelName = new JShadowedLabel(item.getDefinition().getName());
		labelName.setForeground(Color.WHITE);
		labelName.setVerticalAlignment(SwingUtilities.BOTTOM);

		labelValue = new JShadowedLabel();
		labelValue.setFont(FontManager.getRunescapeSmallFont());
		labelValue.setVerticalAlignment(SwingUtilities.TOP);
		updateXp(xp);

		uiInfo.add(labelName);
		uiInfo.add(labelValue);

		// Settings Button
		JLabel settingsButton = new JLabel();
		settingsButton.setBorder(new EmptyBorder(0, 5, 0, 5));
		settingsButton.setIcon(new ImageIcon(ICON_SETTINGS));
		settingsButton.setOpaque(true);
		settingsButton.setBackground(BACKGROUND_COLOR);

		settingsButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				settingsButton.setBackground(BUTTON_HOVER_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				settingsButton.setBackground(BACKGROUND_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				toggleInfo();
			}
		});

		// Create and append elements to container panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(BACKGROUND_COLOR);

		panel.add(image, BorderLayout.LINE_START);
		panel.add(uiInfo, BorderLayout.CENTER);

		// Only add button if has activity selection options or linked items
		List<Activity> activities = Activity.getByCriticalItem(item);
		// If linked map has 1 item and it isn't this item still show breakdown (cleaned herbs into unfinished)
		if ((linkedMap.size() > 1 || (linkedMap.size() == 1 && linkedMap.get(item) == null))
			|| activities.size() > 1)
		{
			panel.add(settingsButton, BorderLayout.LINE_END);
		}

		panel.setToolTipText("<html>" + item.getDefinition().getName()
			+ "<br/>xp: " + xp
			+ "<br/>Total: " + StackFormatter.quantityToStackSize((long) total) + "</html");

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;

		this.add(panel, c);
		c.gridy++;
		this.add(infoContainer, c);
	}

	private void toggleInfo()
	{
		infoVisibility = !infoVisibility;

		if (infoVisibility)
		{
			createInfoPanel();
		}
		else
		{
			infoContainer.removeAll();
			infoContainer.setVisible(false);

			infoContainer.revalidate();
			infoContainer.repaint();
		}
	}

	private void createInfoPanel()
	{
		infoContainer.removeAll();
		infoContainer.setVisible(true);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 0;

		JPanel p = createActivitiesPanel();
		if (p != null)
		{
			infoContainer.add(p, c);
			c.gridy++;
		}

		// Show linked item breakdown, including own items
		if (linkedMap.size() > 1 || (linkedMap.size() == 1 && linkedMap.get(item) == null))
		{
			JLabel l = new JLabel("Item Breakdown");
			l.setBorder(new EmptyBorder(3, 0, 3, 0));
			l.setHorizontalAlignment(JLabel.CENTER);
			infoContainer.add(l, c);
			c.gridy++;

			JPanel con = new JPanel();
			con.setLayout(new GridBagLayout());
			con.setBackground(BACKGROUND_COLOR);
			for (Map.Entry<CriticalItem, Integer> e : linkedMap.entrySet())
			{
				// Icon
				AsyncBufferedImage icon = itemManager.getImage(e.getKey().getItemID(), e.getValue(), e.getKey().getDefinition().isStackable() || e.getValue() > 1);
				JLabel image = new JLabel();
				image.setMinimumSize(ICON_SIZE);
				image.setMaximumSize(ICON_SIZE);
				image.setPreferredSize(ICON_SIZE);
				image.setHorizontalAlignment(SwingConstants.CENTER);
				image.setBorder(new EmptyBorder(0, 8, 0, 0));

				Runnable resize = () ->
					image.setIcon(new ImageIcon(icon.getScaledInstance((int) ICON_SIZE.getWidth(), (int) ICON_SIZE.getHeight(), Image.SCALE_SMOOTH)));
				icon.onChanged(resize);
				resize.run();

				image.setToolTipText(e.getKey().getDefinition().getName());

				con.add(image, c);
				c.gridx++;
			}
			c.gridx = 0;
			infoContainer.add(con, c);
		}

	}

	private JPanel createActivitiesPanel()
	{
		ArrayList<Activity> activities = Activity.getByCriticalItem(item);
		if (activities == null || activities.size() == 1)
		{
			return null;
		}

		JPanel p = new JPanel();
		p.setBackground(BACKGROUND_COLOR);
		p.setLayout(new BorderLayout());

		JLabel label = new JLabel("Possible training methods");

		MaterialTabGroup group = new MaterialTabGroup();
		group.setLayout(new GridLayout(0, 6, 0, 2));
		group.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

		Activity selected = this.bankedCalculator.getSelectedActivity(this.item);
		boolean s = false;

		for (Activity option : activities)
		{
			AsyncBufferedImage icon = itemManager.getImage(option.getIcon());
			MaterialTab matTab = new MaterialTab("", group, null);
			matTab.setHorizontalAlignment(SwingUtilities.RIGHT);
			matTab.setToolTipText(option.getName());

			Runnable resize = () ->
				matTab.setIcon(new ImageIcon(icon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
			icon.onChanged(resize);
			resize.run();

			group.addTab(matTab);

			// Select first option by default
			if (!s)
			{
				s = true;
				group.select(matTab);
			}

			// Select the option if its their selected activity
			if (option.equals(selected))
			{
				group.select(matTab);
			}

			// Add click event handler now to prevent above code from triggering it.
			matTab.setOnSelectEvent(() ->
			{
				bankedCalculator.activitySelected(item, option);
				return true;
			});
		}

		p.add(label, BorderLayout.NORTH);
		p.add(group, BorderLayout.SOUTH);

		return p;
	}

	public void updateXp(double newXpRate)
	{
		xp = newXpRate;
		total = xp * amount;
		labelValue.setText(FORMAT_COMMA.format(total) + "xp");
	}

	public void updateAmount(int newAmount, boolean forceVisible)
	{
		this.setVisible(newAmount > 0 || forceVisible);
		this.amount = newAmount;
		AsyncBufferedImage icon = itemManager.getImage(item.getItemID(), amount, item.getDefinition().isStackable() || amount > 1);
		Runnable resize = () ->
			image.setIcon(new ImageIcon(icon.getScaledInstance((int) ICON_SIZE.getWidth(), (int) ICON_SIZE.getHeight(), Image.SCALE_SMOOTH)));
		icon.onChanged(resize);
		resize.run();
	}

	public void updateLinkedMap(Map<CriticalItem, Integer> newLinkedMap)
	{
		this.linkedMap = newLinkedMap;

		int sum = 0;
		for (Integer v : newLinkedMap.values())
		{
			sum += v;
		}
		this.updateAmount(sum, false);

		this.updateXp(xp);

		// Refresh info panel if visible
		if (infoVisibility)
		{
			createInfoPanel();
		}
	}

	public void recalculate()
	{
		updateXp(xp);
	}
}
