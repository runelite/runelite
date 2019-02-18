/*
 * Copyright (c) 2019, halworsen <mwh@halvorsenfamilien.com>
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
package net.runelite.client.plugins.itemgoals;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ThinProgressBar;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.ImageUtil;

// Displays individual goals in the goals tab
public class ItemGoalsGoalPanel extends JPanel
{
	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;
	private static final ImageIcon CONFIRM_ICON;
	private static final ImageIcon CONFIRM_HOVER_ICON;
	private static final ImageIcon CANCEL_ICON;
	private static final ImageIcon CANCEL_HOVER_ICON;

	static
	{
		final BufferedImage deleteIcon = ImageUtil.getResourceStreamFromClass(ItemGoalsPlugin.class, "delete_icon.png");
		final BufferedImage confirmIcon = ImageUtil.getResourceStreamFromClass(ItemGoalsPlugin.class, "confirm_icon.png");
		final BufferedImage cancelIcon = ImageUtil.getResourceStreamFromClass(ItemGoalsPlugin.class, "cancel_icon.png");

		DELETE_ICON = new ImageIcon(deleteIcon);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteIcon, 0.50f));

		CONFIRM_ICON = new ImageIcon(confirmIcon);
		CONFIRM_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(confirmIcon, 0.50f));

		CANCEL_ICON = new ImageIcon(cancelIcon);
		CANCEL_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(cancelIcon, 0.50f));
	}

	private final Dimension ICON_SIZE = new Dimension(32, 32);

	private static final String DELETE_PANEL = "DELETE_PANEL";
	private static final String GOAL_PANEL = "GOAL_PANEL";

	private CardLayout cardLayout = new CardLayout();

	private JPanel mainContainer = new JPanel(cardLayout);
	private JPanel goalContainer = new JPanel();
	private JPanel goalInfo = new JPanel();
	private JPanel deletionContainer = new JPanel();

	private ItemGoalsPlugin plugin;
	private ItemGoal itemGoal;
	private ItemManager itemManager;

	ItemGoalsGoalPanel(ItemGoalsPlugin plugin, ItemGoal itemGoal, ItemManager itemManager)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.itemGoal = itemGoal;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		goalContainer.setLayout(new GridBagLayout());
		goalContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		goalInfo.setLayout(new GridLayout(2, 1));
		goalInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		deletionContainer.setLayout(new BorderLayout());
		deletionContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		deletionContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		populateGoalContainer();
		populateDeletionContainer();

		mainContainer.add(goalContainer, GOAL_PANEL);
		mainContainer.add(deletionContainer, DELETE_PANEL);
		cardLayout.show(mainContainer, GOAL_PANEL);

		add(mainContainer, BorderLayout.CENTER);
	}

	private void populateGoalContainer()
	{
		final AsyncBufferedImage icon = itemManager.getImage(itemGoal.getItemID());

		// Goal item icon
		JLabel itemIcon = new JLabel();
		itemIcon.setPreferredSize(ICON_SIZE);
		itemIcon.setToolTipText(itemGoal.getName());
		if (icon != null)
		{
			icon.addTo(itemIcon);
		}

		// Name of the goal item
		JShadowedLabel itemName = new JShadowedLabel();
		itemName.setText(itemGoal.getName());
		// Cut off longer item names
		int h = itemName.getPreferredSize().height;
		itemName.setPreferredSize(new Dimension(0, h));
		itemName.setForeground(Color.WHITE);

		// "Progress / goal amount" label
		JShadowedLabel itemProgressLabel = new JShadowedLabel();
		itemProgressLabel.setFont(FontManager.getRunescapeSmallFont());

		NumberFormat formatter = NumberFormat.getInstance();
		String progressText = formatter.format(itemGoal.getProgress()) + " / " + formatter.format(itemGoal.getAmount());

		itemProgressLabel.setText(progressText);
		itemProgressLabel.setForeground(Color.WHITE);

		goalInfo.add(itemName);
		goalInfo.add(itemProgressLabel);

		// Progress bar
		ThinProgressBar progressBar = new ThinProgressBar();
		if (itemGoal.getProgress() == itemGoal.getAmount())
		{
			progressBar.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
		}
		else
		{
			progressBar.setForeground(ColorScheme.PROGRESS_INPROGRESS_COLOR);
		}
		progressBar.setMaximumValue(itemGoal.getAmount());
		progressBar.setValue(itemGoal.getProgress());

		// Delete button
		JLabel deleteButton = new JLabel(DELETE_ICON);
		deleteButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				confirmDeletion();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				deleteButton.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				deleteButton.setIcon(DELETE_ICON);
			}
		});

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.weightx = 0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		goalContainer.add(itemIcon, constraints);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 5, 0, 0);
		constraints.weightx = 1;
		constraints.gridx = 1;
		constraints.gridheight = 2;
		goalContainer.add(goalInfo, constraints);

		constraints.insets = new Insets(5, 0, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.weightx = 0;
		constraints.anchor = GridBagConstraints.NORTHEAST;
		goalContainer.add(deleteButton, constraints);

		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		goalContainer.add(progressBar, constraints);
	}

	private void populateDeletionContainer()
	{
		JShadowedLabel info = new JShadowedLabel();
		info.setFont(FontManager.getRunescapeSmallFont());
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setText("Are you sure?");
		info.setForeground(Color.WHITE);

		// Cancel button
		JLabel cancelButton = new JLabel(CANCEL_ICON);
		cancelButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				cancelDeletion();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				cancelButton.setIcon(CANCEL_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				cancelButton.setIcon(CANCEL_ICON);
			}
		});

		// Confirm button
		JLabel confirmButton = new JLabel(CONFIRM_ICON);
		confirmButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				delete();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				confirmButton.setIcon(CONFIRM_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				confirmButton.setIcon(CONFIRM_ICON);
			}
		});

		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new GridLayout(1, 2));
		buttonContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		buttonContainer.add(cancelButton);
		buttonContainer.add(confirmButton);

		deletionContainer.add(info, BorderLayout.NORTH);
		deletionContainer.add(buttonContainer, BorderLayout.SOUTH);
	}

	private void confirmDeletion()
	{
		cardLayout.show(mainContainer, DELETE_PANEL);
	}

	private void cancelDeletion()
	{
		cardLayout.show(mainContainer, GOAL_PANEL);
	}

	private void delete()
	{
		plugin.removeGoal(itemGoal);
	}
}
