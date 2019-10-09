/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerGroup;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerOverlay;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ImageUtil;

public class ScreenMarkerPluginPanel extends PluginPanel
{
	private static final ImageIcon ADD_ICON;
	private static final ImageIcon ADD_HOVER_ICON;
	private static final ImageIcon ADD_GROUP_ICON;
	private static final ImageIcon ADD_GROUP_HOVER_ICON;

	private static final ImageIcon VISIBLE_ICON;
	private static final ImageIcon VISIBLE_HOVER_ICON;
	private static final ImageIcon INVISIBLE_ICON;
	private static final ImageIcon INVISIBLE_HOVER_ICON;

	private static final ImageIcon DELETE_ICON;
	private static final ImageIcon DELETE_HOVER_ICON;

	private static final Color DEFAULT_BORDER_COLOR = Color.GREEN;
	private static final Color DEFAULT_FILL_COLOR = new Color(0, 255, 0, 0);

	private static final int DEFAULT_BORDER_THICKNESS = 3;

	private final JLabel addMarker = new JLabel(ADD_ICON);
	private final JLabel addGroup = new JLabel(ADD_GROUP_ICON);
	private final JLabel groupVisibility = new JLabel();
	private final JLabel deleteGroup = new JLabel(DELETE_ICON);
	private final JLabel renameGroup = new JLabel("Rename");
	private final PluginErrorPanel noMarkersPanel = new PluginErrorPanel();
	private final JPanel markerView = new JPanel(new GridBagLayout());
	private final JPanel groupActions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));

	private JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

	private final ScreenMarkerPlugin plugin;

	@Getter
	private Color selectedColor = DEFAULT_BORDER_COLOR;

	@Getter
	private Color selectedFillColor = DEFAULT_FILL_COLOR;

	@Getter
	private int selectedBorderThickness = DEFAULT_BORDER_THICKNESS;

	@Getter
	private ScreenMarkerCreationPanel creationPanel;

	static
	{
		final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "add_icon.png");
		ADD_ICON = new ImageIcon(addIcon);
		ADD_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));

		final BufferedImage addGroupIcon = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "add_group_icon.png");
		ADD_GROUP_ICON = new ImageIcon(addGroupIcon);
		ADD_GROUP_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addGroupIcon, 0.53f));

		final BufferedImage visibleImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "visible_icon.png");
		VISIBLE_ICON = new ImageIcon(visibleImg);
		VISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(visibleImg, -100));

		final BufferedImage invisibleImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "invisible_icon.png");
		INVISIBLE_ICON = new ImageIcon(invisibleImg);
		INVISIBLE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(invisibleImg, -100));

		final BufferedImage deleteImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "delete_icon.png");
		DELETE_ICON = new ImageIcon(deleteImg);
		DELETE_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(deleteImg, -100));

	}

	public ScreenMarkerPluginPanel(ScreenMarkerPlugin screenMarkerPlugin)
	{
		this.plugin = screenMarkerPlugin;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		JPanel addActions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));

		addActions.add(addGroup);
		addActions.add(addMarker);

		JPanel titlePanel = new JPanel(new BorderLayout());

		titlePanel.add(title, BorderLayout.WEST);
		titlePanel.add(addActions, BorderLayout.EAST);

		northPanel.add(titlePanel, BorderLayout.NORTH);

		groupActions.setBorder(new EmptyBorder(4, 0, 0, 0));

		groupActions.add(groupVisibility);
		groupActions.add(deleteGroup);
		groupActions.add(renameGroup);

		northPanel.add(groupActions, BorderLayout.WEST);

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		markerView.setBackground(ColorScheme.DARK_GRAY_COLOR);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		noMarkersPanel.setContent("Screen Markers", "Highlight a region on your screen.");
		noMarkersPanel.setVisible(false);

		markerView.add(noMarkersPanel, constraints);
		constraints.gridy++;

		creationPanel = new ScreenMarkerCreationPanel(plugin);
		creationPanel.setVisible(false);

		markerView.add(creationPanel, constraints);
		constraints.gridy++;

		addMarker.setToolTipText("Add new screen marker");
		addMarker.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				setCreation(true);
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addMarker.setIcon(ADD_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addMarker.setIcon(ADD_ICON);
			}
		});

		addGroup.setToolTipText("Add new screen marker group");
		addGroup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.createGroup();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				addGroup.setIcon(ADD_GROUP_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				addGroup.setIcon(ADD_GROUP_ICON);
			}
		});

		groupVisibility.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				plugin.getCurrentGroup().setVisible(!plugin.getCurrentGroup().isVisible());
				plugin.updateConfig();
				updateGroupVisibility();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				groupVisibility.setIcon(plugin.getCurrentGroup().isVisible() ? VISIBLE_HOVER_ICON : INVISIBLE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				updateGroupVisibility();
			}
		});

		deleteGroup.setIcon(DELETE_ICON);
		deleteGroup.setToolTipText("Delete screen marker");
		deleteGroup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				int confirm = JOptionPane.showConfirmDialog(ScreenMarkerPluginPanel.this,
					"Are you sure you want to permanently delete this screen marker group and all the markers it contains?",
					"Warning", JOptionPane.OK_CANCEL_OPTION);
				if (confirm == 0)
				{
					plugin.deleteGroup();
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				deleteGroup.setIcon(DELETE_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				deleteGroup.setIcon(DELETE_ICON);
			}
		});

		renameGroup.setFont(FontManager.getRunescapeSmallFont());
		renameGroup.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
		renameGroup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				String input = JOptionPane.showInputDialog(ScreenMarkerPluginPanel.this,
				"Enter a new name for " + plugin.getCurrentGroup(),
				plugin.getCurrentGroup().getName());
				plugin.getCurrentGroup().setName(input);
				plugin.updateConfig();
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				renameGroup.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker().darker());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				renameGroup.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
			}
		});

		centerPanel.add(markerView, BorderLayout.CENTER);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}

	public void rebuild()
	{
		comboBox();

		groupActions.setVisible(plugin.getCurrentGroup() != plugin.getMainGroup());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		markerView.removeAll();

		List<ScreenMarkerOverlay> markersInCurrentGroup = new ArrayList<>();
		markersInCurrentGroup.addAll(plugin.getScreenMarkers());
		markersInCurrentGroup.removeIf(m -> m.getMarker().getGroup() != plugin.getCurrentGroup().getId());

		for (final ScreenMarkerOverlay marker : markersInCurrentGroup)
		{
			markerView.add(new ScreenMarkerPanel(plugin, marker), constraints);
			constraints.gridy++;

			markerView.add(Box.createRigidArea(new Dimension(0, 10)), constraints);
			constraints.gridy++;
		}

		noMarkersPanel.setVisible(markersInCurrentGroup.isEmpty());
		title.setVisible(!markersInCurrentGroup.isEmpty() || !plugin.getScreenMarkerGroups().isEmpty());

		markerView.add(noMarkersPanel, constraints);
		constraints.gridy++;

		markerView.add(creationPanel, constraints);
		constraints.gridy++;

		repaint();
		revalidate();
		updateGroupVisibility();
	}

	private void comboBox()
	{
		JComboBox<ScreenMarkerGroup> groupBox = new JComboBox<>();
		groupBox.addItem(plugin.getMainGroup());
		plugin.getScreenMarkerGroups().forEach(groupBox::addItem);
		groupBox.setSelectedItem(plugin.getCurrentGroup());
		groupBox.setForeground(Color.WHITE);
		groupBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				plugin.setCurrentGroup((ScreenMarkerGroup) groupBox.getSelectedItem());
				rebuild();
			}
		});
		title.removeAll();
		title.add(groupBox);
	}

	/* Enables/Disables new marker creation mode */
	public void setCreation(boolean on)
	{
		if (on)
		{
			noMarkersPanel.setVisible(false);
			title.setVisible(true);
		}
		else
		{
			boolean empty = plugin.getScreenMarkers().isEmpty();
			noMarkersPanel.setVisible(empty);
			title.setVisible(!empty);
		}

		creationPanel.setVisible(on);
		addMarker.setVisible(!on);
		addGroup.setVisible(!on);

		if (on)
		{
			creationPanel.lockConfirm();
			plugin.setMouseListenerEnabled(true);
		}
	}

	private void updateGroupVisibility()
	{
		groupVisibility.setIcon(plugin.getCurrentGroup().isVisible() ? VISIBLE_ICON : INVISIBLE_ICON);
	}
}
