/*
 * Copyright (c) 2018 Abex
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

import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.ui.ClientUI;

@Slf4j
class WidgetInspector extends JFrame
{
	private final Client client;
	private final ClientThread clientThread;
	private final DevToolsConfig config;
	private final DevToolsOverlay overlay;
	private final DevToolsPlugin plugin;

	private final JTree widgetTree;
	private final WidgetInfoTableModel infoTableModel;
	private final JCheckBox alwaysOnTop;

	private static final Map<Integer, WidgetInfo> widgetIdMap = new HashMap<>();

	@Inject
	private WidgetInspector(
		Client client,
		ClientThread clientThread,
		WidgetInfoTableModel infoTableModel,
		DevToolsConfig config,
		EventBus eventBus,
		DevToolsOverlay overlay,
		DevToolsPlugin plugin)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.infoTableModel = infoTableModel;
		this.config = config;
		this.overlay = overlay;
		this.plugin = plugin;

		eventBus.register(this);

		setTitle("RuneLite Widget Inspector");
		setIconImage(ClientUI.ICON);

		// Reset highlight on close
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				close();
				plugin.getWidgetInspector().setActive(false);
			}
		});

		setLayout(new BorderLayout());

		widgetTree = new JTree(new DefaultMutableTreeNode());
		widgetTree.setRootVisible(false);
		widgetTree.setShowsRootHandles(true);
		widgetTree.getSelectionModel().addTreeSelectionListener(e ->
		{
			Object selected = widgetTree.getLastSelectedPathComponent();
			if (selected instanceof WidgetTreeNode)
			{
				WidgetTreeNode node = (WidgetTreeNode) selected;
				Widget widget = node.getWidget();
				overlay.setWidget(widget);
				overlay.setItemIndex(widget.getItemId());
				refreshInfo();
				log.debug("Set widget to {} and item index to {}", widget, widget.getItemId());
			}
			else if (selected instanceof WidgetItemNode)
			{
				WidgetItemNode node = (WidgetItemNode) selected;
				overlay.setItemIndex(node.getWidgetItem().getIndex());
				log.debug("Set item index to {}", node.getWidgetItem().getIndex());
			}
		});

		final JScrollPane treeScrollPane = new JScrollPane(widgetTree);
		treeScrollPane.setPreferredSize(new Dimension(200, 400));


		final JTable widgetInfo = new JTable(infoTableModel);

		final JScrollPane infoScrollPane = new JScrollPane(widgetInfo);
		infoScrollPane.setPreferredSize(new Dimension(400, 400));


		final JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);

		final JButton refreshWidgetsBtn = new JButton("Refresh");
		refreshWidgetsBtn.addActionListener(e -> refreshWidgets());
		bottomPanel.add(refreshWidgetsBtn);

		alwaysOnTop = new JCheckBox("Always on top");
		alwaysOnTop.addItemListener(ev -> config.inspectorAlwaysOnTop(alwaysOnTop.isSelected()));
		onConfigChanged(null);
		bottomPanel.add(alwaysOnTop);

		final JButton revalidateWidget = new JButton("Revalidate");
		revalidateWidget.addActionListener(ev -> clientThread.invokeLater(() ->
		{
			if (overlay.getWidget() == null)
			{
				return;
			}

			overlay.getWidget().revalidate();
		}));
		bottomPanel.add(revalidateWidget);

		final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoScrollPane);
		add(split, BorderLayout.CENTER);

		pack();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged ev)
	{
		boolean onTop = config.inspectorAlwaysOnTop();
		setAlwaysOnTop(onTop);
		alwaysOnTop.setSelected(onTop);
	}

	private void refreshWidgets()
	{
		clientThread.invokeLater(() ->
		{
			Widget[] rootWidgets = client.getWidgetRoots();
			DefaultMutableTreeNode root = new DefaultMutableTreeNode();

			overlay.setWidget(null);
			overlay.setItemIndex(-1);

			for (Widget widget : rootWidgets)
			{
				DefaultMutableTreeNode childNode = addWidget("R", widget);
				if (childNode != null)
				{
					root.add(childNode);
				}
			}

			SwingUtilities.invokeLater(() ->
			{
				overlay.setWidget(null);
				overlay.setItemIndex(-1);
				refreshInfo();
				widgetTree.setModel(new DefaultTreeModel(root));
			});
		});
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

	private void refreshInfo()
	{
		infoTableModel.setWidget(overlay.getWidget());
	}

	static WidgetInfo getWidgetInfo(int packedId)
	{
		if (widgetIdMap.size() == 0)
		{
			//Initialize map here so it doesn't create the index
			//until it's actually needed.
			WidgetInfo[] widgets = WidgetInfo.values();
			for (WidgetInfo w : widgets)
			{
				widgetIdMap.put(w.getPackedId(), w);
			}
		}

		return widgetIdMap.get(packedId);
	}

	public void open()
	{
		setVisible(true);
		toFront();
		repaint();
	}

	public void close()
	{
		overlay.setWidget(null);
		overlay.setItemIndex(-1);
		setVisible(false);
	}
}
