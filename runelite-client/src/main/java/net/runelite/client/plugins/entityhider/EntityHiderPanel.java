/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.entityhider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

public class EntityHiderPanel extends PluginPanel
{
	private final EntityHiderPlugin plugin;
	private final JPanel listContainer;
	private final JLabel countLabel;
	private List<EntityHiderPlugin.NpcData> lastDisplayedNpcs = new ArrayList<>();

	public EntityHiderPanel(EntityHiderPlugin plugin)
	{
		super(false);
		this.plugin = plugin;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Header
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		headerPanel.setBorder(new EmptyBorder(0, 0, 5, 0));

		JLabel titleLabel = new JLabel("Nearby NPCs");
		titleLabel.setFont(FontManager.getRunescapeBoldFont());
		titleLabel.setForeground(Color.WHITE);
		headerPanel.add(titleLabel, BorderLayout.WEST);

		countLabel = new JLabel("0");
		countLabel.setFont(FontManager.getRunescapeSmallFont());
		countLabel.setForeground(Color.GRAY);
		headerPanel.add(countLabel, BorderLayout.EAST);

		// Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		buttonPanel.setBorder(new EmptyBorder(5, 0, 5, 0));

		JButton unhideAllBtn = new JButton("Unhide All");
		unhideAllBtn.setFont(FontManager.getRunescapeSmallFont());
		unhideAllBtn.setToolTipText("Unhide all NPCs everywhere (clears entire hidden list)");
		unhideAllBtn.setAlignmentX(0.5f);
		unhideAllBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, unhideAllBtn.getPreferredSize().height));
		unhideAllBtn.addActionListener(e ->
		{
			int result = JOptionPane.showConfirmDialog(
				this,
				"Unhide all NPCs everywhere?",
				"Unhide All",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE
			);
			if (result == JOptionPane.YES_OPTION)
			{
				plugin.unhideAllNpcs();
			}
		});
		buttonPanel.add(unhideAllBtn);

		buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		JPanel vicinityPanel = new JPanel(new GridLayout(1, 2, 5, 0));
		vicinityPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		vicinityPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

		JButton hideVicinityBtn = new JButton("Hide Vicinity");
		hideVicinityBtn.setFont(FontManager.getRunescapeSmallFont());
		hideVicinityBtn.setToolTipText("Hide all NPCs currently nearby");
		hideVicinityBtn.addActionListener(e -> plugin.hideVicinityNpcs());
		vicinityPanel.add(hideVicinityBtn);

		JButton unhideVicinityBtn = new JButton("Unhide Vicinity");
		unhideVicinityBtn.setFont(FontManager.getRunescapeSmallFont());
		unhideVicinityBtn.setToolTipText("Unhide all NPCs currently nearby");
		unhideVicinityBtn.addActionListener(e -> plugin.unhideVicinityNpcs());
		vicinityPanel.add(unhideVicinityBtn);

		buttonPanel.add(vicinityPanel);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
		topPanel.add(headerPanel, BorderLayout.NORTH);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(topPanel, BorderLayout.NORTH);

		// List container
		listContainer = new JPanel();
		listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
		listContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JScrollPane scrollPane = new JScrollPane(listContainer);
		scrollPane.setBackground(ColorScheme.DARK_GRAY_COLOR);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(scrollPane, BorderLayout.CENTER);
	}

	public void update(List<EntityHiderPlugin.NpcData> npcs)
	{
		// Sort by name, then by ID
		List<EntityHiderPlugin.NpcData> sorted;
		if (npcs == null || npcs.isEmpty())
		{
			sorted = new ArrayList<>();
		}
		else
		{
			sorted = new ArrayList<>(npcs);
			sorted.sort(Comparator
				.comparing((EntityHiderPlugin.NpcData n) -> n.name)
				.thenComparingInt(n -> n.id));
		}

		// Skip rebuild if nothing changed
		if (isSameNpcList(lastDisplayedNpcs, sorted))
		{
			return;
		}
		lastDisplayedNpcs = sorted;

		listContainer.removeAll();

		if (sorted.isEmpty())
		{
			JLabel emptyLabel = new JLabel("No NPCs nearby");
			emptyLabel.setForeground(Color.GRAY);
			emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
			listContainer.add(emptyLabel);
			countLabel.setText("0");
		}
		else
		{
			for (int i = 0; i < sorted.size(); i++)
			{
				if (i > 0)
				{
					listContainer.add(Box.createRigidArea(new Dimension(0, 3)));
				}
				listContainer.add(createNpcRow(sorted.get(i)));
			}
			listContainer.add(Box.createVerticalGlue());
			countLabel.setText(String.valueOf(sorted.size()));
		}

		listContainer.revalidate();
		listContainer.repaint();
	}

	private boolean isSameNpcList(List<EntityHiderPlugin.NpcData> a, List<EntityHiderPlugin.NpcData> b)
	{
		if (a.size() != b.size())
		{
			return false;
		}
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i).id != b.get(i).id || a.get(i).hidden != b.get(i).hidden)
			{
				return false;
			}
		}
		return true;
	}

	private JPanel createNpcRow(EntityHiderPlugin.NpcData npc)
	{
		JPanel row = new JPanel(new BorderLayout(5, 0));
		row.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		row.setBorder(new EmptyBorder(3, 8, 3, 8));
		row.setMinimumSize(new Dimension(0, 32));
		row.setPreferredSize(new Dimension(0, 32));
		row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
		row.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel nameLabel = new JLabel("<html>" + npc.name + "<br><font color='gray'>ID: " + npc.id + "</font></html>");
		nameLabel.setFont(FontManager.getRunescapeSmallFont());
		nameLabel.setForeground(npc.hidden ? Color.RED : Color.WHITE);

		row.add(nameLabel, BorderLayout.CENTER);

		row.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				boolean nowHidden = plugin.toggleNpcHidden(npc.id);
				nameLabel.setForeground(nowHidden ? Color.RED : Color.WHITE);
			}
		});

		return row;
	}
}
