/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ColorScheme;

@Slf4j
@Singleton
class InventoryInspector extends DevToolsFrame
{
	private static final int MAX_LOG_ENTRIES = 25;

	private final Client client;
	private final EventBus eventBus;
	private final ItemManager itemManager;

	private final Map<Integer, InventoryTreeNode> nodeMap = new HashMap<>();
	private final Map<Integer, InventoryLog> logMap = new HashMap<>();
	private final DefaultMutableTreeNode trackerRootNode = new DefaultMutableTreeNode();
	private final JTree tree = new JTree(trackerRootNode);
	private final InventoryDeltaPanel deltaPanel;

	private static final Map<Integer, String> INV_NAMES = DevToolsPlugin.loadFieldNames(InventoryID.class);

	@Inject
	InventoryInspector(Client client, EventBus eventBus, ItemManager itemManager, ClientThread clientThread)
	{
		this.client = client;
		this.eventBus = eventBus;
		this.itemManager = itemManager;

		this.deltaPanel = new InventoryDeltaPanel(itemManager);

		setLayout(new BorderLayout());
		setTitle("RuneLite Inventory Inspector");
		setIconImages(Arrays.asList(ClientUI.ICON_128, ClientUI.ICON_16));

		tree.setBorder(new EmptyBorder(2, 2, 2, 2));
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);
		tree.addTreeSelectionListener(e ->
		{
			if (e.getNewLeadSelectionPath() == null)
			{
				return;
			}

			final Object node = e.getNewLeadSelectionPath().getLastPathComponent();
			if (node instanceof InventoryLogNode)
			{
				clientThread.invoke(() -> displayItemSnapshot((InventoryLogNode) node));
			}
		});
		tree.setModel(new DefaultTreeModel(trackerRootNode));

		final JPanel leftSide = new JPanel();
		leftSide.setLayout(new BorderLayout());

		final JScrollPane trackerScroller = new JScrollPane(tree);
		trackerScroller.setPreferredSize(new Dimension(200, 400));

		final JScrollBar vertical = trackerScroller.getVerticalScrollBar();
		vertical.addAdjustmentListener(new AdjustmentListener()
		{
			int lastMaximum = actualMax();

			private int actualMax()
			{
				return vertical.getMaximum() - vertical.getModel().getExtent();
			}

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e)
			{
				if (vertical.getValue() >= lastMaximum)
				{
					vertical.setValue(actualMax());
				}
				lastMaximum = actualMax();
			}
		});

		leftSide.add(trackerScroller, BorderLayout.CENTER);

		final JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setFocusable(false);
		refreshBtn.addActionListener(e -> refreshTracker());

		final JButton clearBtn = new JButton("Clear");
		clearBtn.setFocusable(false);
		clearBtn.addActionListener(e -> clearTracker());

		final JPanel bottomRow = new JPanel();
		bottomRow.add(refreshBtn);
		bottomRow.add(clearBtn);

		leftSide.add(bottomRow, BorderLayout.SOUTH);

		final JScrollPane gridScroller = new JScrollPane(deltaPanel);
		gridScroller.getViewport().setBackground(ColorScheme.DARK_GRAY_COLOR);
		gridScroller.setPreferredSize(new Dimension(200, 400));

		final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, gridScroller);
		add(split, BorderLayout.CENTER);

		pack();
	}

	@Override
	public void open()
	{
		eventBus.register(this);
		super.open();
	}

	@Override
	public void close()
	{
		eventBus.unregister(this);
		clearTracker();
		super.close();
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		final int id = event.getContainerId();
		final InventoryLog log = new InventoryLog(id, INV_NAMES.getOrDefault(id, "" + id), event.getItemContainer().getItems(), client.getTickCount());

		// Delay updates until refresh button is pressed
		logMap.put(id, log);
	}

	private void addLog(final InventoryLog invLog)
	{
		final InventoryTreeNode node = nodeMap.computeIfAbsent(invLog.getContainerId(), (k) -> new InventoryTreeNode(invLog.getContainerId(), invLog.getContainerName()));
		node.add(new InventoryLogNode(invLog));

		// Cull very old stuff
		while (node.getChildCount() > MAX_LOG_ENTRIES)
		{
			node.remove(0);
		}
	}

	private void clearTracker()
	{
		logMap.clear();
		nodeMap.clear();
		deltaPanel.clear();
		trackerRootNode.removeAllChildren();
		tree.setModel(new DefaultTreeModel(trackerRootNode));
	}

	private void refreshTracker()
	{
		deltaPanel.clear();

		if (logMap.size() > 0)
		{
			logMap.values().forEach(this::addLog);
			logMap.clear();
		}

		SwingUtilities.invokeLater(() ->
		{
			trackerRootNode.removeAllChildren();
			nodeMap.values().forEach(trackerRootNode::add);
			tree.setModel(new DefaultTreeModel(trackerRootNode));
		});
	}

	private void displayItemSnapshot(final InventoryLogNode logNode)
	{
		final InventoryTreeNode treeNode = nodeMap.get(logNode.getLog().getContainerId());
		if (treeNode == null)
		{
			log.warn("Clicked on a JTree node that doesn't map anywhere: {}", logNode);
			return;
		}

		final Item[] curItems = logNode.getLog().getItems();
		final InventoryItem[] curInventory = convertToInventoryItems(curItems);

		InventoryItem[][] deltas = null;
		// Compare against previous snapshot
		if (treeNode.getIndex(logNode) > 0)
		{
			final TreeNode prevNode = treeNode.getChildBefore(logNode);
			if (prevNode instanceof InventoryLogNode)
			{
				final InventoryLogNode prevLogNode = (InventoryLogNode) prevNode;
				deltas = compareItemSnapshots(prevLogNode.getLog().getItems(), curItems);
			}
		}

		final InventoryItem[] added = deltas == null ? null : deltas[0];
		final InventoryItem[] removed = deltas == null ? null : deltas[1];

		SwingUtilities.invokeLater(() -> deltaPanel.displayItems(curInventory, added, removed));
	}

	private InventoryItem[] convertToInventoryItems(final Item[] items)
	{
		final InventoryItem[] out = new InventoryItem[items.length];
		for (int i = 0; i < items.length; i++)
		{
			final Item item = items[i];
			final ItemComposition c = itemManager.getItemComposition(item.getId());
			out[i] = new InventoryItem(i, item, c.getMembersName(), c.isStackable());
		}

		return out;
	}

	/**
	 * Compares the current inventory to the old one returning the InventoryItems that were added and removed.
	 * @param previous old snapshot
	 * @param current new snapshot
	 * @return The first InventoryItem[] contains the items that were added and the second contains the items that were removed
	 */
	private InventoryItem[][] compareItemSnapshots(final Item[] previous, final Item[] current)
	{
		final Map<Integer, Integer> qtyMap = new HashMap<>();

		// ItemContainers shouldn't become smaller over time, but just in case
		final int maxSlots = Math.max(previous.length, current.length);
		for (int i = 0; i < maxSlots; i++)
		{
			final Item prev = previous.length > i ? previous[i] : null;
			final Item cur = current.length > i ? current[i] : null;

			if (prev != null)
			{
				qtyMap.merge(prev.getId(), -1 * prev.getQuantity(), Integer::sum);
			}
			if (cur != null)
			{
				qtyMap.merge(cur.getId(), cur.getQuantity(), Integer::sum);
			}
		}

		final Map<Boolean, List<InventoryItem>> result = qtyMap.entrySet().stream()
			.filter(e -> e.getValue() != 0)
			.flatMap(e ->
			{
				final int id = e.getKey();
				final int qty = e.getValue();
				final ItemComposition c = itemManager.getItemComposition(e.getKey());

				InventoryItem[] items = {
					new InventoryItem(-1, new Item(id, qty), c.getMembersName(), c.isStackable())
				};
				if (!c.isStackable() && (qty > 1 || qty < -1))
				{
					items = new InventoryItem[Math.abs(qty)];
					for (int i = 0; i < Math.abs(qty); i++)
					{
						final Item item = new Item(id, Integer.signum(qty));
						items[i] = new InventoryItem(-1, item, c.getMembersName(), c.isStackable());
					}
				}

				return Arrays.stream(items);
			})
			.collect(Collectors.partitioningBy(item -> item.getItem().getQuantity() > 0));

		final InventoryItem[] added = result.get(true).toArray(new InventoryItem[0]);
		final InventoryItem[] removed = result.get(false).stream()
			// Make quantities positive now that its been sorted.
			.peek(i -> i.setItem(new Item(i.getItem().getId(), -i.getItem().getQuantity())))
			.toArray(InventoryItem[]::new);

		return new InventoryItem[][]{
			added, removed
		};
	}
}
