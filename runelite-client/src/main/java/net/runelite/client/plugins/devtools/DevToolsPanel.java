/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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


import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.PluginPanel;

@Slf4j
public class DevToolsPanel extends PluginPanel
{
	private JButton renderPlayersBtn = new JButton();
	private JButton renderNpcsBtn = new JButton();
	private JButton renderGroundItemsBtn = new JButton();
	private JButton renderGroundObjectsBtn = new JButton();
	private JButton renderGameObjectsBtn = new JButton();
	private JButton renderWallsBtn = new JButton();
	private JButton renderDecorBtn = new JButton();
	private JButton renderInventoryBtn = new JButton();
	private JButton renderProjectilesBtn = new JButton();
	private JPanel boundsDebugPanel = new JPanel();

	private JLabel textLbl = new JLabel();
	private JLabel textColorLbl = new JLabel();
	private JLabel nameLbl = new JLabel();
	private JLabel modelLbl = new JLabel();
	private JLabel textureLbl = new JLabel();
	private JLabel typeLbl = new JLabel();
	private JLabel contentTypeLbl = new JLabel();
	private JButton editWidgetBtn = new JButton();

	private JPanel borderedWrap = null;
	private JPanel widgetTreeContainer = null;
	private WidgetEditPanel editWidgetPanel = null;
	private boolean editActive = false;

	private final Client client;
	private final DevToolsPlugin plugin;

	private final SettingsTracker settingsTracker;

	@Inject
	public DevToolsPanel(Client client, DevToolsPlugin plugin)
	{
		super();
		this.client = client;
		this.plugin = plugin;

		settingsTracker = new SettingsTracker(client);
		borderedWrap = new JPanel();
		borderedWrap.setLayout(new BorderLayout(0, 3));
		borderedWrap.add(createOptionsPanel(), BorderLayout.NORTH);
		borderedWrap.add(createWidgetTreePanel(), BorderLayout.CENTER);
		add(borderedWrap);
	}

	private JPanel createOptionsPanel()
	{
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(6, 2, 3, 3));

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

		renderProjectilesBtn = new JButton("Projectiles");
		renderProjectilesBtn.addActionListener(e ->
		{
			highlightButton(renderProjectilesBtn);
			plugin.toggleProjectiles();
		});
		container.add(renderProjectilesBtn);

		boundsDebugPanel = createBoundsDebugMultiButton();
		container.add(boundsDebugPanel);

		JButton settingsSnapshotBtn = new JButton("Get Settings");
		settingsSnapshotBtn.addActionListener(settingsTracker::snapshot);
		container.add(settingsSnapshotBtn);

		JButton settingsClearBtn = new JButton("Clear Settings");
		settingsClearBtn.addActionListener(settingsTracker::clear);
		container.add(settingsClearBtn);

		return container;
	}

	private JPanel createBoundsDebugMultiButton()
	{
		ImageIcon bBox2DIcon;
		ImageIcon bBox3DIcon;
		ImageIcon clickBoxIcon;
		ImageIcon bBox3DMousoverIcon;

		try
		{
			bBox2DIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("2D_bounding_box.png")));
			bBox3DIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("3D_bounding_box.png")));
			clickBoxIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("2D_clickbox_geometry.png")));
			bBox3DMousoverIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("mouseover_3D_bounding_box.png")));
		}
		catch (IOException ex)
		{
			log.warn("unable to load bounding box images", ex);
			return new JPanel();
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		JButton bBox2DButton = new JButton(bBox2DIcon);
		bBox2DButton.addActionListener(e ->
		{
			client.setDrawBoundingBoxes2D(!client.getDrawBoundingBoxes2D());
			highlightButton(bBox2DButton);
		});
		buttonPanel.add(bBox2DButton);

		JButton bBox3DButton = new JButton(bBox3DIcon);
		bBox3DButton.addActionListener(e ->
		{
			client.setDrawBoundingBoxes3D(!client.getDrawBoundingBoxes3D());
			highlightButton(bBox3DButton);
		});
		buttonPanel.add(bBox3DButton);

		JButton clickBoxButton = new JButton(clickBoxIcon);
		clickBoxButton.addActionListener(e ->
		{
			client.setdrawObjectGeometry2D(!client.getdrawObjectGeometry2D());
			highlightButton(clickBoxButton);
		});
		buttonPanel.add(clickBoxButton);

		JButton mouseoverModeButton = new JButton(client.getBoundingBoxAlwaysOnMode() ? bBox3DIcon : bBox3DMousoverIcon);
		mouseoverModeButton.addActionListener(e ->
		{
			client.setBoundingBoxAlwaysOnMode(!client.getBoundingBoxAlwaysOnMode());
			if (client.getBoundingBoxAlwaysOnMode())
			{
				mouseoverModeButton.setIcon(bBox3DIcon);
			}
			else
			{
				mouseoverModeButton.setIcon(bBox3DMousoverIcon);
			}
		});
		buttonPanel.add(mouseoverModeButton);

		return buttonPanel;
	}

	private void editWidget(Widget w)
	{
		if (editWidgetPanel == null)
		{
			editWidgetPanel = new WidgetEditPanel(this, w);
		}
		else
		{
			editWidgetPanel.setWidget(w);
		}

		widgetTreeContainer.setVisible(false);
		this.borderedWrap.remove(widgetTreeContainer);
		this.borderedWrap.add(editWidgetPanel, BorderLayout.CENTER);
		editWidgetPanel.validate();
		editWidgetPanel.setVisible(true);
		editWidgetPanel.repaint();
		editActive = true;
	}

	public void cancelEdit()
	{
		if (!editActive)
			return;

		editWidgetPanel.setVisible(false);
		this.borderedWrap.remove(editWidgetPanel);
		this.borderedWrap.add(widgetTreeContainer, BorderLayout.CENTER);
		widgetTreeContainer.revalidate();
		widgetTreeContainer.setVisible(true);
		widgetTreeContainer.repaint();
	}

	private JPanel createWidgetTreePanel()
	{
		widgetTreeContainer = new JPanel();
		widgetTreeContainer.setLayout(new BorderLayout(0, 3));

		JTree tree = new JTree(new DefaultMutableTreeNode());
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);
		tree.getSelectionModel().addTreeSelectionListener(e ->
		{
			Object selected = tree.getLastSelectedPathComponent();
			if (selected instanceof WidgetTreeNode)
			{
				WidgetTreeNode node = (WidgetTreeNode) selected;
				Widget widget = node.getWidget();
				plugin.currentWidget = widget;
				plugin.itemIndex = widget.getItemId();
				setWidgetInfo(widget);
				log.debug("Set widget to {} and item index to {}", widget, widget.getItemId());
			}
			else if (selected instanceof WidgetItemNode)
			{
				WidgetItemNode node = (WidgetItemNode) selected;
				plugin.itemIndex = node.getWidgetItem().getIndex();
				log.debug("Set item index to {}", plugin.itemIndex);
			}
		});

		JScrollPane scrollPane = new JScrollPane(tree);
		widgetTreeContainer.add(scrollPane, BorderLayout.CENTER);

		JButton refreshWidgetsBtn = new JButton("Refresh Widgets");
		refreshWidgetsBtn.addActionListener(e ->
		{
			new SwingWorker<DefaultMutableTreeNode, Void>()
			{
				@Override
				protected DefaultMutableTreeNode doInBackground() throws Exception
				{
					return refreshWidgets();
				}

				@Override
				protected void done()
				{
					try
					{
						tree.setModel(new DefaultTreeModel(get()));
					}
					catch (InterruptedException | ExecutionException ex)
					{
						throw new RuntimeException(ex);
					}
				}
			}.execute();
		});

		JPanel btnContainer = new JPanel();
		btnContainer.setLayout(new BorderLayout());
		btnContainer.add(refreshWidgetsBtn);
		widgetTreeContainer.add(btnContainer, BorderLayout.NORTH);

		JPanel infoContainer = new JPanel();
		infoContainer.setLayout(new GridLayout(0, 1));

		textLbl = new JLabel("Text: ");
		textColorLbl = new JLabel("Text Color: ");
		nameLbl = new JLabel("Name: ");
		modelLbl = new JLabel("Model ID: ");
		textureLbl = new JLabel("Texture ID: ");
		typeLbl = new JLabel("Type: ");
		contentTypeLbl = new JLabel("Content Type: ");
		editWidgetBtn = new JButton("Edit");
		editWidgetBtn.addActionListener(e ->
		{
			editWidget(plugin.currentWidget);
		});

		infoContainer.add(textLbl);
		infoContainer.add(textColorLbl);
		infoContainer.add(nameLbl);
		infoContainer.add(modelLbl);
		infoContainer.add(textureLbl);
		infoContainer.add(typeLbl);
		infoContainer.add(contentTypeLbl);
		infoContainer.add(editWidgetBtn);

		JScrollPane infoScrollPane = new JScrollPane(infoContainer);
		infoScrollPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		widgetTreeContainer.add(infoScrollPane, BorderLayout.SOUTH);

		return widgetTreeContainer;
	}

	private void setWidgetInfo(Widget widget)
	{
		if (widget == null)
		{
			return;
		}

		textLbl.setText("Text: " + widget.getText().trim());
		textColorLbl.setText("Text Color: " + widget.getTextColor());
		nameLbl.setText("Name: " + widget.getName().trim());
		modelLbl.setText("Model ID: " + widget.getModelId());
		textureLbl.setText("Sprite ID: " + widget.getSpriteId());
		typeLbl.setText("Type: " + widget.getType()
			+ " Parent " + (widget.getParentId() == -1 ? -1 : TO_GROUP(widget.getParentId()) + "." + TO_CHILD(widget.getParentId())));
		contentTypeLbl.setText("Content Type: " + widget.getContentType() + " Hidden " + widget.isHidden());
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

	private DefaultMutableTreeNode refreshWidgets()
	{
		Widget[] rootWidgets = client.getWidgetRoots();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();

		plugin.currentWidget = null;
		plugin.itemIndex = -1;

		for (Widget widget : rootWidgets)
		{
			DefaultMutableTreeNode childNode = addWidget("R", widget);
			if (childNode != null)
			{
				root.add(childNode);
			}
		}

		return root;
	}

	private DefaultMutableTreeNode addWidget(String type, Widget widget)
	{
		if (widget == null || widget.isHidden())
		{
			return null;
		}

		DefaultMutableTreeNode node = new WidgetTreeNode(type, widget);

		Widget[] childComponents = widget.getDynamicChildren();
		if (childComponents != null)
		{
			for (Widget component : childComponents)
			{
				DefaultMutableTreeNode childNode = addWidget("D", component);
				if (childNode != null)
				{
					node.add(childNode);
				}
			}
		}

		childComponents = widget.getStaticChildren();
		if (childComponents != null)
		{
			for (Widget component : childComponents)
			{
				DefaultMutableTreeNode childNode = addWidget("S", component);
				if (childNode != null)
				{
					node.add(childNode);
				}
			}
		}

		childComponents = widget.getNestedChildren();
		if (childComponents != null)
		{
			for (Widget component : childComponents)
			{
				DefaultMutableTreeNode childNode = addWidget("N", component);
				if (childNode != null)
				{
					node.add(childNode);
				}
			}
		}

		Collection<WidgetItem> items = widget.getWidgetItems();
		if (items != null)
		{
			for (WidgetItem item : items)
			{
				if (item == null)
				{
					continue;
				}

				node.add(new WidgetItemNode(item));
			}
		}

		return node;
	}

}
