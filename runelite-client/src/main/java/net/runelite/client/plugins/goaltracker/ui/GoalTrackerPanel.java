/*
 * Copyright (c) 2019, Slay to Stay, <https://github.com/slaytostay>
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
package net.runelite.client.plugins.goaltracker.ui;

import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.plugins.goaltracker.Goal;
import net.runelite.client.plugins.goaltracker.GoalTrackerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.ImageUtil;

public class GoalTrackerPanel extends PluginPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;

	private static final Color DEFAULT_BORDER_COLOR = Color.GREEN;
	private static final Color DEFAULT_FILL_COLOR = new Color(0, 255, 0, 0);

	private static final int DEFAULT_BORDER_THICKNESS = 3;

	private final JLabel addGoal = new JLabel(ADD_ICON);
	private final JLabel title = new JLabel();

	private final JPanel goalView = new JPanel(new GridBagLayout());

	private final IconTextField searchBar = new IconTextField();

	@Inject
	private GoalTrackerPlugin plugin;

	@Getter
	private Color selectedColor = DEFAULT_BORDER_COLOR;

	@Getter
	private Color selectedFillColor = DEFAULT_FILL_COLOR;

	@Getter
	private int selectedBorderThickness = DEFAULT_BORDER_THICKNESS;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "add_icon.png");
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));
	}

	public void init()
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		title.setText("Goal Tracker");
		title.setForeground(Color.WHITE);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addActionListener(e -> onSearchBarChanged());

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(addGoal, BorderLayout.EAST);
		northPanel.add(searchBar, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		goalView.setBackground(ColorScheme.DARK_GRAY_COLOR);

		updateGoals();

		addGoal.setToolTipText("Add new goal");
		addGoal.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.addGoal();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addGoal.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addGoal.setIcon(ADD_ICON);
			}
		});

		centerPanel.add(goalView, BorderLayout.CENTER);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

		updateGoals(text);

		repaint();
		revalidate();
	}

	public void rebuild()
	{
		removeAll();
		repaint();
		revalidate();
		init();
	}

	public void updateGoals()
	{
		updateGoals("");
	}

	public void updateGoals(String text)
	{
		goalView.removeAll();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		for (final Goal goal : plugin.getGoals())
		{
			if (text.isEmpty() || matchesSearchTerms(goal, text.toLowerCase()))
			{
				goalView.add(new GoalPanel(plugin, goal), constraints);
				constraints.gridy++;

				goalView.add(Box.createRigidArea(new Dimension(0, 10)), constraints);
				constraints.gridy++;
			}
		}

		repaint();
		revalidate();
	}

	public boolean matchesSearchTerms(Goal goal, String text)
	{
		Pattern p = Pattern.compile("((?:\\\")([^\\\"]*)(?:\\\")|\\w+)");
		Matcher m = p.matcher(text);

		while (m.find())
		{
			String term = m.group();
			term = term.replaceAll("^\"|\"$", "");
			if (term == null) continue;
			if (term.equals(Integer.toString(goal.getChunk())))
			{
				return true;
			}
			else if (goal.getName().toLowerCase().contains(term))
			{
				return true;
			}
			else if (goal.getRequirements().toLowerCase().contains(term))
			{
				return true;
			}
		}
		return false;
	}
}
