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

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.ThinProgressBar;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.util.ImageUtil;

// Displays individual search results in the edit/add goal tab
public class ItemGoalsResultPanel extends JPanel
{
	private final Dimension ICON_SIZE = new Dimension(32, 32);

	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon UPDATE_ICON;
	private static final ImageIcon UPDATE_HOVER_ICON;

	private final GridBagConstraints constraints = new GridBagConstraints();

	private final JLabel itemIcon = new JLabel();
	private final JShadowedLabel itemName = new JShadowedLabel();

	private final JPanel configPanel = new JPanel();
	private final JPanel configPanelWrapper = new JPanel();
	private JSpinner amountSpinner;

	private final JPanel mainContainer = new JPanel();
	private final JPanel resultContainer = new JPanel();
	private final JPanel infoContainer = new JPanel();

	private int itemID;

	private boolean configOpen = false;

	private ItemGoalsPlugin plugin;
	private AsyncBufferedImage icon;
	private String name;
	private MouseAdapter clickListener;
	private ItemGoal connectedGoal;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(ItemGoalsPlugin.class, "add_icon.png");

		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.50f));

		final BufferedImage updateIcon = ImageUtil.getResourceStreamFromClass(ItemGoalsPlugin.class, "update_icon.png");

		UPDATE_ICON = new ImageIcon(updateIcon);
		UPDATE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(updateIcon, 0.50f));
	}

	ItemGoalsResultPanel(ItemGoalsPlugin plugin, int itemID, AsyncBufferedImage icon, String name)
	{
		this.plugin = plugin;
		this.itemID = itemID;
		this.icon = icon;
		this.name = name;

		init();
	}

	private void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		mainContainer.setLayout(new BorderLayout());
		mainContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		infoContainer.setLayout(new BorderLayout(5, 0));
		infoContainer.setBorder(new EmptyBorder(0, 5, 5, 5));
		infoContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		resultContainer.setLayout(new BorderLayout(5, 0));
		resultContainer.setBorder(new EmptyBorder(5, 0, 0, 0));
		resultContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		itemIcon.setPreferredSize(ICON_SIZE);
		if (icon != null)
		{
			icon.addTo(itemIcon);
		}

		itemName.setText(name);
		// Cut off longer item names
		itemName.setPreferredSize(new Dimension(0, 0));
		itemName.setForeground(Color.WHITE);

		// Use DARK_GRAY_COLOR since the first time the player sees this is when they click the panel
		configPanel.setLayout(new GridBagLayout());
		configPanel.setBackground(ColorScheme.DARK_GRAY_HOVER_COLOR);

		configPanelWrapper.setLayout(new BorderLayout());
		configPanelWrapper.setBorder(new EmptyBorder(0, 5, 5, 5));
		configPanelWrapper.setBackground(ColorScheme.DARK_GRAY_HOVER_COLOR);
		configPanelWrapper.add(configPanel, BorderLayout.CENTER);

		clickListener = new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				setBackgroundDeep(resultContainer, ColorScheme.DARK_GRAY_HOVER_COLOR);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				setBackgroundDeep(resultContainer, ColorScheme.DARKER_GRAY_COLOR);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				toggleConfigPanel();
			}
		};

		addMouseListener(clickListener);

		findConnectedGoal();

		populate();
		populateConfig();

		mainContainer.add(resultContainer, BorderLayout.CENTER);
		add(mainContainer, BorderLayout.NORTH);
	}

	// If there is an active goal for this item, we store it
	private void findConnectedGoal()
	{
		ArrayList<ItemGoal> goals = plugin.getUserGoals();

		for (ItemGoal goal : goals)
		{
			if (goal.getItemID() == itemID)
			{
				this.connectedGoal = goal;
				return;
			}
		}
	}

	private void populate()
	{
		infoContainer.add(itemIcon, BorderLayout.LINE_START);
		infoContainer.add(itemName, BorderLayout.CENTER);
		resultContainer.add(infoContainer, BorderLayout.PAGE_START);

		// Add the progress bar you'd see on the normal goal tracker card if we're currently tracking this item
		if (hasConnectedGoal())
		{
			// Progress bar
			ThinProgressBar progressBar = new ThinProgressBar();
			if (connectedGoal.getProgress() == connectedGoal.getAmount())
			{
				progressBar.setForeground(ColorScheme.PROGRESS_COMPLETE_COLOR);
			}
			else
			{
				progressBar.setForeground(ColorScheme.PROGRESS_INPROGRESS_COLOR);
			}
			progressBar.setMaximumValue(connectedGoal.getAmount());
			progressBar.setValue(connectedGoal.getProgress());

			resultContainer.add(progressBar, BorderLayout.PAGE_END);
		}
	}

	private void populateConfig()
	{
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 2147483647, 1);
		amountSpinner = new JSpinner(model);
		amountSpinner.setPreferredSize(new Dimension(75, 20));

		if (hasConnectedGoal())
		{
			amountSpinner.setValue(connectedGoal.getAmount());
		}

		JShadowedLabel amountLabel = new JShadowedLabel();
		amountLabel.setText("Amount");
		amountLabel.setForeground(Color.WHITE);

		JLabel confirmButton = new JLabel(hasConnectedGoal() ? UPDATE_ICON : ADD_ICON);
		confirmButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				createGoal();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				confirmButton.setIcon(hasConnectedGoal() ? UPDATE_HOVER_ICON : ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				confirmButton.setIcon(hasConnectedGoal() ? UPDATE_ICON : ADD_ICON);
			}
		});


		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		configPanel.add(amountLabel, constraints);

		constraints.insets = new Insets(0, 15, 0, 0);
		constraints.gridx = 1;
		constraints.weightx = 1;
		configPanel.add(amountSpinner, constraints);

		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.gridx = 2;
		constraints.weightx = 0;
		configPanel.add(confirmButton, constraints);
	}

	private void toggleConfigPanel()
	{
		configOpen = !configOpen;

		if (configOpen)
		{
			resultContainer.add(configPanelWrapper, BorderLayout.CENTER);
		}
		else
		{
			resultContainer.remove(configPanelWrapper);
		}

		revalidate();
		repaint();
	}

	// Creates a new goal and adds it to the list of item goals
	private void createGoal()
	{
		if (hasConnectedGoal())
		{
			// Update the goal amount
			int newGoal = (int)amountSpinner.getValue();
			connectedGoal.setAmount(newGoal);
			// If the goal is adjusted downwards below the progress, cap progress at the new goal
			connectedGoal.setProgress(Math.min(newGoal, connectedGoal.getProgress()));

			plugin.updateGoal(connectedGoal);
		}
		else
		{
			ItemGoal newGoal = new ItemGoal();
			newGoal.setItemID(itemID);
			newGoal.setAmount((int)amountSpinner.getValue());
			newGoal.setName(itemName.getText());

			plugin.addNewGoal(newGoal);
			this.connectedGoal = newGoal;
		}

		// Rebuild the panel after the goal has been added/updated
		rebuild(false);
	}

	protected void rebuild(boolean onlyIfConnected)
	{
		if (onlyIfConnected && !hasConnectedGoal())
		{
			return;
		}

		configOpen = false;
		connectedGoal = null;
		removeMouseListener(clickListener);

		resultContainer.removeAll();
		configPanel.removeAll();
		removeAll();
		init();
		revalidate();
		repaint();
	}

	// Recurses through components and sets their BG colors
	private void setBackgroundDeep(Container cont, Color color)
	{
		cont.setBackground(color);

		for (Component c : cont.getComponents())
		{
			if (c instanceof ThinProgressBar)
			{
				continue;
			}

			c.setBackground(color);
			if (c instanceof Container)
			{
				setBackgroundDeep((Container)c, color);
			}

		}
	}

	private boolean hasConnectedGoal()
	{
		return (connectedGoal != null);
	}
}
