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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import lombok.Getter;
import net.runelite.client.plugins.goaltracker.Goal;
import net.runelite.client.plugins.goaltracker.GoalTrackerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.ImageUtil;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoalTrackerPanel extends PluginPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon IMPORT_ICON;
	private static final ImageIcon IMPORT_HOVER_ICON;
	private static final ImageIcon EXPORT_ICON;
	private static final ImageIcon EXPORT_HOVER_ICON;

	private static final Color DEFAULT_BORDER_COLOR = Color.GREEN;
	private static final Color DEFAULT_FILL_COLOR = new Color(0, 255, 0, 0);

	private static final int DEFAULT_BORDER_THICKNESS = 3;

	private final JLabel addGoal = new JLabel(ADD_ICON);
	private final JLabel importButton = new JLabel(IMPORT_ICON);
	private final JLabel exportButton = new JLabel(EXPORT_ICON);
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

		final BufferedImage importIcon = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "import.png");
		IMPORT_ICON = new ImageIcon(importIcon);
		IMPORT_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(importIcon, 0.53f));

		final BufferedImage exportIcon = ImageUtil.getResourceStreamFromClass(GoalTrackerPlugin.class, "export.png");
		EXPORT_ICON = new ImageIcon(exportIcon);
		EXPORT_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(exportIcon, 0.53f));
	}

	public void init()
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel northPanel = new JPanel(new BorderLayout(0, 5));
		northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		JPanel actionWrapper = new JPanel(new BorderLayout(8, 0));

		title.setText("Goal Tracker");
		title.setForeground(Color.WHITE);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addActionListener(e -> onSearchBarChanged());

		actionWrapper.add(importButton, BorderLayout.WEST);
		actionWrapper.add(exportButton, BorderLayout.CENTER);
		actionWrapper.add(addGoal, BorderLayout.EAST);

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(actionWrapper, BorderLayout.EAST);
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

		importButton.setToolTipText("Import goals file...");
		importButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.OPEN_DIALOG);
				fc.setDialogTitle("Choose a goals json file to import");
				fc.setFileFilter(new FileNameExtensionFilter("JSON", "json"));
				int returnVal = fc.showOpenDialog(GoalTrackerPanel.this);
				if (returnVal != JFileChooser.APPROVE_OPTION) return;

				File file = fc.getSelectedFile();

				if (plugin.getGoals().size() > 0)
				{
					int confirm = JOptionPane.showConfirmDialog(GoalTrackerPanel.this,
							"Are you sure you want to import this file? This will DELETE all your current goals.",
							"Warning", JOptionPane.OK_CANCEL_OPTION);

					if (confirm != 0) return;
				}

				try
				{
					BufferedReader in = new BufferedReader(new FileReader(file));
					String line = in.readLine();
					StringBuilder json = new StringBuilder();
					while (line != null)
					{
						json.append(line + System.lineSeparator());
						line = in.readLine();
					}
					plugin.getGoals().clear();
					plugin.loadConfig(json.toString()).forEach(plugin.getGoals()::add);
					plugin.updateConfig();
					updateGoals();
				}
				catch (FileNotFoundException ex)
				{
					JOptionPane.showConfirmDialog(GoalTrackerPanel.this,
							"That file doesn't exist!",
							"Error", JOptionPane.DEFAULT_OPTION);
				}
				catch (IOException ex)
				{
					JOptionPane.showConfirmDialog(GoalTrackerPanel.this,
							"Cannot parse file!",
							"Error", JOptionPane.DEFAULT_OPTION);
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				importButton.setIcon(IMPORT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				importButton.setIcon(IMPORT_ICON);
			}
		});

		exportButton.setToolTipText("Export goals file...");
		exportButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.SAVE_DIALOG);
				fc.setDialogTitle("Save your goals to a json file");
				fc.setSelectedFile(new File("goals.json"));
				fc.setFileFilter(new FileNameExtensionFilter("JSON", "json"));
				int returnVal = fc.showOpenDialog(GoalTrackerPanel.this);
				if (returnVal != JFileChooser.APPROVE_OPTION) return;

				File file = fc.getSelectedFile();

				if (file == null) return;
				if (!file.getName().toLowerCase().endsWith(".json"))
				{
					file = new File(file.getParentFile(), file.getName() + ".json");
				}

				try
				{
					final Gson gson = new GsonBuilder().setPrettyPrinting().create();
					final String json = gson.toJson(plugin.getGoals());
					FileWriter fw = new FileWriter(file);
					fw.write(json);
					fw.close();
				}
				catch (IOException ex)
				{
					JOptionPane.showConfirmDialog(GoalTrackerPanel.this,
							"Cannot write file!",
							"Error", JOptionPane.DEFAULT_OPTION);
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				exportButton.setIcon(EXPORT_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				exportButton.setIcon(EXPORT_ICON);
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
			if (goal != null && (text.isEmpty() || matchesSearchTerms(goal, text.toLowerCase())))
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
			final String t = term;
			if (t.isEmpty()) continue;
			if (t.equals(Integer.toString(goal.getChunk())))
			{
				return true;
			}
			else if (goal.getName().toLowerCase().contains(t))
			{
				return true;
			}
			else if (goal.getRequirements().stream().anyMatch(str -> str.getName().toLowerCase().contains(t)))
			{
				return true;
			}
		}
		return false;
	}
}
