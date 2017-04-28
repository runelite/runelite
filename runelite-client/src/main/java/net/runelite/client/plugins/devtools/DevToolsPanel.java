/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
package net.runelite.client.plugins.devtools;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.PluginPanel;

public class DevToolsPanel extends PluginPanel
{
	private final EmptyBorder PADDING_BORDER = new EmptyBorder(3, 3, 3, 3);

	private final Client client = RuneLite.getClient();

	private JButton renderPlayersBtn = new JButton();
	private JButton renderNpcsBtn = new JButton();
	private JButton renderGroundItemsBtn = new JButton();
	private JButton renderGroundObjectsBtn = new JButton();
	private JButton renderGameObjectsBtn = new JButton();
	private JButton renderWallsBtn = new JButton();
	private JButton renderDecorBtn = new JButton();
	private JButton renderInventoryBtn = new JButton();

	private JLabel textLbl = new JLabel();
	private JLabel textColorLbl = new JLabel();
	private JLabel nameLbl = new JLabel();
	private JLabel modelLbl = new JLabel();
	private JLabel textureLbl = new JLabel();
	private JLabel typeLbl = new JLabel();
	private JLabel contentTypeLbl = new JLabel();

	private DevTools plugin;

	private DefaultMutableTreeNode widgetListRoot = new DefaultMutableTreeNode();

	public DevToolsPanel(DevTools plugin)
	{
		this.plugin = plugin;

		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLayout(new BorderLayout());
		setVisible(true);

		add(createOptionsPanel(), BorderLayout.NORTH);
		add(createWidgetTreePanel(), BorderLayout.CENTER);
	}

	private JPanel createOptionsPanel()
	{
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(4, 2, 3, 3));
		container.setBorder(PADDING_BORDER);

		renderPlayersBtn = new JButton("Players");
		renderPlayersBtn.addActionListener(e ->
		{
			highlightButton(renderPlayersBtn);
			plugin.togglePlayers();
		});
		container.add(renderPlayersBtn);

		renderNpcsBtn = new JButton("NPCs");
		renderNpcsBtn.addActionListener(e ->
		{
			highlightButton(renderNpcsBtn);
			plugin.toggleNpcs();
		});
		container.add(renderNpcsBtn);

		renderGroundItemsBtn = new JButton("Ground Items");
		renderGroundItemsBtn.addActionListener(e ->
		{
			highlightButton(renderGroundItemsBtn);
			plugin.toggleGroundItems();
		});
		container.add(renderGroundItemsBtn);

		renderGroundObjectsBtn = new JButton("Ground Objects");
		renderGroundObjectsBtn.addActionListener(e ->
		{
			highlightButton(renderGroundObjectsBtn);
			plugin.toggleGroundObjects();
		});
		container.add(renderGroundObjectsBtn);

		renderGameObjectsBtn = new JButton("Game Objects");
		renderGameObjectsBtn.addActionListener(e ->
		{
			highlightButton(renderGameObjectsBtn);
			plugin.toggleGameObjects();
		});
		container.add(renderGameObjectsBtn);

		renderWallsBtn = new JButton("Walls");
		renderWallsBtn.addActionListener(e ->
		{
			highlightButton(renderWallsBtn);
			plugin.toggleWalls();
		});
		container.add(renderWallsBtn);

		renderDecorBtn = new JButton("Decorations");
		renderDecorBtn.addActionListener(e ->
		{
			highlightButton(renderDecorBtn);
			plugin.toggleDecor();
		});
		container.add(renderDecorBtn);

		renderInventoryBtn = new JButton("Inventory");
		renderInventoryBtn.addActionListener(e ->
		{
			highlightButton(renderInventoryBtn);
			plugin.toggleInventory();
		});
		container.add(renderInventoryBtn);

		return container;
	}

	private JPanel createWidgetTreePanel()
	{
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		JTree tree = new JTree(widgetListRoot);
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);
		tree.getSelectionModel().addTreeSelectionListener(e ->
		{
			Object[] path = e.getPath().getPath();
			plugin.setWidgetParent(Integer.parseInt(path[1].toString()));
			plugin.setWidgetChild((path.length > 2) ? Integer.parseInt(path[2].toString()) : -1);
			setWidgetInfo();
		});

		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setBorder(PADDING_BORDER);
		container.add(scrollPane, BorderLayout.CENTER);

		JButton refreshWidgetsBtn = new JButton("Refresh Widgets");
		refreshWidgetsBtn.addActionListener(e ->
		{
			refreshWidgets();
			tree.setModel(new DefaultTreeModel(widgetListRoot));
		});

		JPanel btnContainer = new JPanel();
		btnContainer.setLayout(new BorderLayout());
		btnContainer.setBorder(PADDING_BORDER);
		btnContainer.add(refreshWidgetsBtn);
		container.add(btnContainer, BorderLayout.NORTH);

		JPanel infoContainer = new JPanel();
		infoContainer.setLayout(new GridLayout(0, 1));

		textLbl = new JLabel("Text: ");
		textColorLbl = new JLabel("Text Color: ");
		nameLbl = new JLabel("Name: ");
		modelLbl = new JLabel("Model ID: ");
		textureLbl = new JLabel("Texture ID: ");
		typeLbl = new JLabel("Type: ");
		contentTypeLbl = new JLabel("Content Type: ");

		infoContainer.add(textLbl);
		infoContainer.add(textColorLbl);
		infoContainer.add(nameLbl);
		infoContainer.add(modelLbl);
		infoContainer.add(textureLbl);
		infoContainer.add(typeLbl);
		infoContainer.add(contentTypeLbl);

		JScrollPane infoScrollPane = new JScrollPane(infoContainer);
		infoScrollPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		container.add(infoScrollPane, BorderLayout.SOUTH);

		return container;
	}

	private void setWidgetInfo()
	{
		int parent = plugin.getWidgetParent();
		int child = plugin.getWidgetChild();

		if (parent == -1)
		{
			return;
		}

		Widget widget = client.getWidget(parent, (child == -1) ? 0 : child);

		if (widget == null)
		{
			return;
		}

		textLbl.setText("Text: " + widget.getText().trim());
		textColorLbl.setText("Text Color: " + widget.getTextColor());
		nameLbl.setText("Name: " + widget.getName().trim());
		modelLbl.setText("Model ID: " + widget.getModelId());
		textureLbl.setText("Texture ID: " + widget.getTextureId());
		typeLbl.setText("Type: " + widget.getType());
		contentTypeLbl.setText("Content Type: " + widget.getContentType());
	}

	private void highlightButton(JButton button)
	{
		if (button.getBackground().equals(Color.GREEN))
		{
			button.setBackground(null);
		}
		else
		{
			button.setBackground(Color.GREEN);
		}
	}

	private void refreshWidgets()
	{
		Widget[][] widgets = client.getWidgets();
		boolean[] validInterfaces = client.getValidInterfaces();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();

		plugin.setWidgetParent(-1);
		plugin.setWidgetChild(-1);

		int idx = -1;

		for (Widget[] children : widgets)
		{
			++idx;

			if (!validInterfaces[idx])
			{
				continue;
			}

			if (children == null)
			{
				continue;
			}

			DefaultMutableTreeNode parent = new DefaultMutableTreeNode(idx);
			root.add(parent);

			for (Widget child : children)
			{
				if (child == null || child.isHidden())
				{
					continue;
				}

				parent.add(new DefaultMutableTreeNode(child.getId() & 0xFFFF));
			}
		}

		widgetListRoot = root;
	}

}
