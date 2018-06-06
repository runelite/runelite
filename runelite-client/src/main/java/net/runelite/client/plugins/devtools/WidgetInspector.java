/*
 * Copyright (c) 2018, Damien <https://github.com/ADHDDamien>
 * Copyright (c) 2018, Abex
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

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.ClientUI;

@Slf4j
class WidgetInspector extends JFrame
{
	private final Client client;
	private final DevToolsConfig config;
	private final DevToolsPlugin plugin;
	private final WidgetInfoTableModel infoTableModel;

	private final JButton nextResultBtn;
	private final JCheckBox alwaysOnTop;
	private final JTree widgetTree;

	private List<DefaultMutableTreeNode> searchNodes = new ArrayList<>();
	private List<Widget> widgetResults = new ArrayList<>();
	private WidgetSearch widgetSearch = new WidgetSearch();
	private static final Map<Integer, WidgetInfo> widgetIdMap = new HashMap<>();

	private boolean readyToSelectWidget;
	private boolean searchIsActive;
	private int searchIndex;
	private Point mousePos;

	@Inject
	WidgetInspector(DevToolsPlugin plugin, Client client, WidgetInfoTableModel infoTableModel, DevToolsConfig config, EventBus eventBus)
	{
		this.plugin = plugin;
		this.client = client;
		this.infoTableModel = infoTableModel;
		this.config = config;

		eventBus.register(this);

		setTitle("RuneLite Widget Inspector");
		setIconImage(ClientUI.ICON);

		// Reset highlight on close
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				plugin.currentWidget = null;
				plugin.itemIndex = -1;
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
				plugin.currentWidget = widget;
				plugin.itemIndex = widget.getItemId();
				refreshInfo();
				log.debug("Set widget to {} and item index to {}", widget, widget.getItemId());
			}
			else if (selected instanceof WidgetItemNode)
			{
				WidgetItemNode node = (WidgetItemNode) selected;
				plugin.itemIndex = node.getWidgetItem().getIndex();
				log.debug("Set item index to {}", plugin.itemIndex);
			}

		});

		final JScrollPane treeScrollPane = new JScrollPane(widgetTree);
		treeScrollPane.setPreferredSize(new Dimension(200, 400));

		final JTable widgetInfo = new JTable(infoTableModel);

		final JScrollPane searchFieldPane = new JScrollPane(widgetInfo);
		searchFieldPane.setPreferredSize(new Dimension(400, 400));

		final JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);

		final JButton refreshWidgetsBtn = new JButton("Load Widgets");
		refreshWidgetsBtn.addActionListener(e ->
		{
			if (loggedIn())
			{
				refreshWidgets(client.getWidgetRoots());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please log in to the game before trying to load widgets.");
			}
		});
		bottomPanel.add(refreshWidgetsBtn);

		final JButton widgetSelectorBtn = new JButton("Select in-game Widgets");
		widgetSelectorBtn.addActionListener(e ->
		{
			if (loggedIn())
			{
				readyToSelectWidget = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please log in to the game before trying to select widgets.");
			}
		});
		bottomPanel.add(widgetSelectorBtn);

		final JButton searchHelpBtn = new JButton("Search Help");
		searchHelpBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Search examples: \nId:10747904 where 10747904 is the Widget ID you are searching for\n\nCanvasLocation:0,0 with 0,0 being the X & Y in the Point\n\nText:Bank Of Runescape (Partial text searches work as well)\n\nHidden=true where true is the boolean result you are searching for, etc.\n\nAll fields are searchable.\n\nMultiple searches:\nChain searches with a pipe separating each search term to get more exact results, for example Width:1642|Height:1057 or Text:Bank Of Runescape|Hidden:false\n\nThe enter key submits your search.\n\nSelecting on-screen widgets:\nClick \"Select in-game Widgets\" and then click the widget in game you wish to find in the list."));
		bottomPanel.add(searchHelpBtn);

		nextResultBtn = new JButton("Next Result");
		nextResultBtn.addActionListener(e -> nextResult());
		nextResultBtn.setEnabled(false);
		bottomPanel.add(nextResultBtn);

		alwaysOnTop = new JCheckBox("Always on top");
		alwaysOnTop.addItemListener(ev -> config.inspectorAlwaysOnTop(alwaysOnTop.isSelected()));
		onConfigChanged(null);
		bottomPanel.add(alwaysOnTop);

		final JTextField searchField = new JTextField("Search");
		searchField.setBackground(Color.GRAY);
		searchField.setText("Enter search here...");
		searchField.addActionListener(e -> startSearch(searchField.getText()));
		searchField.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				if (searchField.getText().equals("Enter search here..."))
				{
					searchField.setText("");
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(searchField);
		add(scrollPane, BorderLayout.NORTH);
		final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, searchFieldPane);
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

	@Subscribe
	private void MenuOptionClicked(MenuOptionClicked event)
	{
		if (readyToSelectWidget)
		{
			if (searchNodes.size() > 0 && widgetResults.size() > 0)
			{
				searchNodes.clear();
				widgetResults.clear();
			}

			searchIndex = 0;
			mousePos = client.getMouseCanvasPosition();
			event.consume();
			refreshWidgets(client.getWidgetRoots());
		}
	}

	private void startSearch(String search)
	{
		if (loggedIn())
		{
			if (searchNodes.size() > 0 && widgetResults.size() > 0)
			{
				searchNodes.clear();
				widgetResults.clear();
			}

			searchIndex = 0;
			searchIsActive = true;
			widgetSearch.searchRequest(search);
			refreshWidgets(client.getWidgetRoots());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please log in to the game before trying to search widgets.");
		}
	}

	private void nextResult()
	{
		searchIndex++;

		if (searchIndex >= searchNodes.size())
		{
			searchIndex = 0;
		}

		updateResults();
	}

	private void updateResults()
	{
		plugin.currentWidget = widgetResults.get(searchIndex);
		plugin.itemIndex = -1;
		refreshInfo();
		widgetTree.expandPath(new TreePath(searchNodes.get(searchIndex).getPath()));
		widgetTree.setSelectionPath(new TreePath(searchNodes.get(searchIndex).getPath()));
		nextResultBtn.setText("Next Result: " + String.valueOf(searchIndex + 1) + "/" + searchNodes.size());
		pack();
	}

	private Boolean loggedIn()
	{
		return client.getGameState().equals(GameState.LOGGED_IN);
	}

	private void refreshWidgets(Widget[] widgets )
	{
		new SwingWorker<DefaultMutableTreeNode, Void>()
		{
			@Override
			protected DefaultMutableTreeNode doInBackground() throws Exception
			{
				DefaultMutableTreeNode root = new DefaultMutableTreeNode();

				for (Widget widget : widgets)
				{
					DefaultMutableTreeNode childNode = addWidget("R", widget);
					if (childNode != null)
					{
						root.add(childNode);
						if (searchIsActive && widgetSearch.isMatch(widget) || readyToSelectWidget && widgetSearch.matchesMousePosition(widget.getBounds(), mousePos))
						{
							searchNodes.add(childNode);
							widgetResults.add(widget);
						}
					}
				}

				return root;
			}

			@Override
			protected void done()
			{
				try
				{
					plugin.currentWidget = null;
					plugin.itemIndex = -1;
					refreshInfo();
					widgetTree.setModel(new DefaultTreeModel(get()));

					if (searchIsActive || readyToSelectWidget)
					{
						searchIndex = 0;
						updateResults();
						nextResultBtn.setEnabled(true);
						readyToSelectWidget = false;
						searchIsActive = false;
					}
					else
					{
						//reset search iterator button incase you are loading widgets after a search
						searchIndex = 0;
						nextResultBtn.setText("Next Result");
						nextResultBtn.setEnabled(false);
					}

				}
				catch (InterruptedException | ExecutionException ex)
				{
					throw new RuntimeException(ex);
				}
			}
		}.execute();
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
					if (searchIsActive && widgetSearch.isMatch(component) || readyToSelectWidget && widgetSearch.matchesMousePosition(component.getBounds(), mousePos))
					{
						searchNodes.add(childNode);
						widgetResults.add(component);
					}
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
					if (searchIsActive && widgetSearch.isMatch(component) || readyToSelectWidget && widgetSearch.matchesMousePosition(component.getBounds(), mousePos))
					{
						searchNodes.add(childNode);
						widgetResults.add(component);
					}
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
					if (searchIsActive && widgetSearch.isMatch(component) || readyToSelectWidget && widgetSearch.matchesMousePosition(component.getBounds(), mousePos))
					{
						searchNodes.add(childNode);
						widgetResults.add(component);
					}
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
		infoTableModel.setWidget(plugin.currentWidget);
	}

	public static WidgetInfo getWidgetInfo(int packedId)
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
}