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
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.SpriteID;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

@Slf4j
@Singleton
class WidgetInspector extends DevToolsFrame
{
	private static final Map<Integer, String> widgetNames = new HashMap<>();

	static final Color SELECTED_WIDGET_COLOR = Color.CYAN;
	private static final float SELECTED_WIDGET_HUE;

	static
	{
		float[] hsb = new float[3];
		Color.RGBtoHSB(SELECTED_WIDGET_COLOR.getRed(), SELECTED_WIDGET_COLOR.getGreen(), SELECTED_WIDGET_COLOR.getBlue(), hsb);
		SELECTED_WIDGET_HUE = hsb[0];
	}

	private final Client client;
	private final ClientThread clientThread;
	private final DevToolsConfig config;
	private final Provider<WidgetInspectorOverlay> overlay;
	private final OverlayManager overlayManager;

	private final JTree widgetTree;
	private final WidgetInfoTableModel infoTableModel;
	private final JCheckBox alwaysOnTop;
	private final JCheckBox hideHidden;

	private DefaultMutableTreeNode root;

	@Getter
	private Widget selectedWidget;

	private Widget picker = null;

	@Getter
	private boolean pickerSelected = false;

	@Inject
	private WidgetInspector(
		Client client,
		ClientThread clientThread,
		WidgetInfoTableModel infoTableModel,
		DevToolsConfig config,
		EventBus eventBus,
		Provider<WidgetInspectorOverlay> overlay,
		OverlayManager overlayManager)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.infoTableModel = infoTableModel;
		this.config = config;
		this.overlay = overlay;
		this.overlayManager = overlayManager;

		eventBus.register(this);

		setTitle("RuneLite Widget Inspector");

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
				setSelectedWidget(widget, false);
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

		hideHidden = new JCheckBox("Hide hidden");
		hideHidden.setSelected(true);
		hideHidden.addItemListener(ev -> refreshWidgets());
		bottomPanel.add(hideHidden);

		final JButton revalidateWidget = new JButton("Revalidate");
		revalidateWidget.addActionListener(ev -> clientThread.invokeLater(() ->
		{
			if (selectedWidget == null)
			{
				return;
			}

			selectedWidget.revalidate();
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
			root = new DefaultMutableTreeNode();

			Widget wasSelectedWidget = selectedWidget;

			selectedWidget = null;

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
				widgetTree.setModel(new DefaultTreeModel(root));
				setSelectedWidget(wasSelectedWidget, true);
			});
		});
	}

	private DefaultMutableTreeNode addWidget(String type, Widget widget)
	{
		if (widget == null || (hideHidden.isSelected() && widget.isHidden()))
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

		return node;
	}

	private void setSelectedWidget(Widget widget, boolean updateTree)
	{
		infoTableModel.setWidget(widget);

		if (this.selectedWidget == widget)
		{
			return;
		}

		this.selectedWidget = widget;

		if (root == null || !updateTree)
		{
			return;
		}

		clientThread.invoke(() ->
		{
			Stack<Widget> treePath = new Stack<>();
			for (Widget w = widget; w != null; w = w.getParent())
			{
				treePath.push(w);
			}

			DefaultMutableTreeNode node = root;
			deeper:
			while (!treePath.empty())
			{
				Widget w = treePath.pop();
				for (Enumeration<?> it = node.children(); it.hasMoreElements(); )
				{
					WidgetTreeNode inner = (WidgetTreeNode) it.nextElement();
					if (inner.getWidget().getId() == w.getId() && inner.getWidget().getIndex() == w.getIndex())
					{
						node = inner;
						continue deeper;
					}
				}
			}

			final DefaultMutableTreeNode fnode = node;
			SwingUtilities.invokeLater(() ->
			{
				widgetTree.getSelectionModel().clearSelection();
				widgetTree.getSelectionModel().addSelectionPath(new TreePath(fnode.getPath()));
			});
		});
	}

	static String getWidgetName(int componentId)
	{
		if (widgetNames.isEmpty())
		{
			//Initialize map here, so it doesn't create the index
			//until it's actually needed.
			try
			{
				for (Field f : ComponentID.class.getDeclaredFields())
				{
					widgetNames.put(f.getInt(null), f.getName());
				}
			}
			catch (IllegalAccessException ex)
			{
				log.error("error setting up widget names", ex);
			}
		}

		return widgetNames.get(componentId);
	}

	@Override
	public void open()
	{
		super.open();
		overlayManager.add(this.overlay.get());
		clientThread.invokeLater(this::addPickerWidget);
	}

	@Override
	public void close()
	{
		overlayManager.remove(this.overlay.get());
		clientThread.invokeLater(this::removePickerWidget);
		setSelectedWidget(null, false);
		super.close();
	}

	private void removePickerWidget()
	{
		if (picker == null)
		{
			return;
		}

		Widget parent = picker.getParent();
		if (parent == null)
		{
			return;
		}

		Widget[] children = parent.getChildren();
		if (children == null || children.length <= picker.getIndex() || children[picker.getIndex()] != picker)
		{
			return;
		}

		children[picker.getIndex()] = null;
	}

	private void addPickerWidget()
	{
		removePickerWidget();

		int x = 10, y = 2;
		Widget parent = client.getWidget(InterfaceID.Orbs.UNIVERSE);
		if (parent == null)
		{
			Widget[] roots = client.getWidgetRoots();

			parent = Stream.of(roots)
				.filter(w -> w.getType() == WidgetType.LAYER && w.getContentType() == 0 && !w.isSelfHidden())
				.sorted(Comparator.comparingInt((Widget w) -> w.getRelativeX() + w.getRelativeY())
					.reversed()
					.thenComparingInt(Widget::getId)
					.reversed())
				.findFirst().get();
			x = 4;
			y = 4;
		}

		picker = parent.createChild(-1, WidgetType.GRAPHIC);

		log.info("Picker is {}.{} [{}]", WidgetUtil.componentToInterface(picker.getId()), WidgetUtil.componentToId(picker.getId()), picker.getIndex());

		picker.setSpriteId(SpriteID.MOBILE_FINGER_ON_INTERFACE);
		picker.setOriginalWidth(15);
		picker.setOriginalHeight(17);
		picker.setOriginalX(x);
		picker.setOriginalY(y);
		picker.revalidate();
		picker.setTargetVerb("Select");
		picker.setName("Pick");
		picker.setClickMask(WidgetConfig.USE_WIDGET);
		picker.setNoClickThrough(true);
		picker.setOnTargetEnterListener((JavaScriptCallback) ev ->
		{
			pickerSelected = true;
			picker.setOpacity(30);
			client.setAllWidgetsAreOpTargetable(true);
		});
		picker.setOnTargetLeaveListener((JavaScriptCallback) ev -> onPickerDeselect());
	}

	private void onPickerDeselect()
	{
		client.setAllWidgetsAreOpTargetable(false);
		picker.setOpacity(0);
		pickerSelected = false;
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked ev)
	{
		if (!pickerSelected)
		{
			return;
		}

		onPickerDeselect();
		client.setWidgetSelected(false);
		ev.consume();

		Widget target = getWidgetForMenuOption(ev.getMenuAction(), ev.getParam0(), ev.getParam1());
		if (target == null)
		{
			return;
		}

		setSelectedWidget(target, true);
	}

	@Subscribe
	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (!pickerSelected)
		{
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();

		for (int i = 0; i < menuEntries.length; i++)
		{
			MenuEntry entry = menuEntries[i];
			if (entry.getType() != MenuAction.WIDGET_TARGET_ON_WIDGET)
			{
				continue;
			}
			String name = WidgetUtil.componentToInterface(entry.getParam1()) + "." + WidgetUtil.componentToId(entry.getParam1());

			if (entry.getParam0() != -1)
			{
				name += " [" + entry.getParam0() + "]";
			}

			Color color = colorForWidget(i, menuEntries.length);

			entry.setTarget(ColorUtil.wrapWithColorTag(name, color));
		}
	}

	Color colorForWidget(int index, int length)
	{
		float h = SELECTED_WIDGET_HUE + .1f + (.8f / length) * index;

		return Color.getHSBColor(h, 1, 1);
	}

	Widget getWidgetForMenuOption(MenuAction type, int param0, int param1)
	{
		if (type == MenuAction.WIDGET_TARGET_ON_WIDGET)
		{
			Widget w = client.getWidget(param1);
			if (param0 != -1)
			{
				w = w.getChild(param0);
			}

			return w;
		}

		return null;
	}

	public static String getWidgetIdentifier(Widget widget)
	{
		int id = widget.getId();
		String str = WidgetUtil.componentToInterface(id) + "." + WidgetUtil.componentToId(id);

		if (widget.getIndex() != -1)
		{
			str += "[" + widget.getIndex() + "]";
		}

		var name = getWidgetName(id);
		if (name != null)
		{
			str += " " + name;
		}

		return str;
	}
}
