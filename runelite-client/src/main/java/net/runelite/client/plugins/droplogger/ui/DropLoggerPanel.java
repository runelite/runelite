/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.ui;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.droplogger.DropLoggerConfig;
import net.runelite.client.plugins.droplogger.DropLoggerPlugin;
import net.runelite.client.plugins.droplogger.data.SessionLog;
import net.runelite.client.plugins.droplogger.data.SessionLogData;
import net.runelite.client.ui.PluginPanel;
import net.runelite.http.api.item.ItemPrice;

@Slf4j
public class DropLoggerPanel extends PluginPanel
{
	@Inject
	private DropLoggerPlugin plugin;

	@Inject
	private DropLoggerConfig config;

	@Inject
	@Getter
	private ItemManager itemManager;

	@Inject
	@Getter
	private Client client;

	@Inject
	@Getter
	private ClientThread clientThread;

	private JTabbedPane tabPane;

	private JPanel container;

	private Map<Integer, Integer> itemPriceMap;
	private Set<Integer> itemsToLookup;

	private boolean active;

	private TabPanel getTab()
	{
		return (TabPanel)this.tabPane.getSelectedComponent();
	}

	public void init(SessionLogData sessionLogData)
	{
		this.itemPriceMap = new HashMap<>();
		this.itemPriceMap.put(ItemID.COINS_995, 1);
		this.itemPriceMap.put(ItemID.PLATINUM_TOKEN, 1000);
		this.itemsToLookup = new HashSet<>();

		JTabbedPane tabPane = new JTabbedPane();
		this.tabPane = tabPane;
		tabPane.addTab("Session", new SessionLogPanel(this, sessionLogData, itemPriceMap, plugin, config));
		tabPane.setSelectedIndex(0);
		tabPane.addChangeListener(e -> getTab().onLogShouldUpdate());

		tabPane.setPreferredSize(new Dimension(0, 0));
		this.add(tabPane);
		this.container = this;

		this.getParent().addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				super.componentResized(e);
				int width = container.getParent().getWidth();
				int height = container.getParent().getParent().getHeight();
				tabPane.setPreferredSize(new Dimension(width, height - 12));
				tabPane.invalidate();
				tabPane.repaint();
			}
		});
	}

	@Override
	public void onActivate()
	{
		this.active = true;
		update();
	}

	@Override
	public void onDeactivate()
	{
		this.active = false;
	}

	private void update()
	{
		TabPanel tabPanel = getTab();
		this.updatePrices(tabPanel::onLogShouldUpdate);
	}

	private void updatePrices(Runnable onDonefunc)
	{
		CompletableFuture<ItemPrice[]> future = itemManager.getItemPriceBatch(itemsToLookup);
		if (!future.isDone())
		{
			// If prices aren't immediately known,
			// update the panel with what we already have
			onDonefunc.run();
		}
		future.whenComplete((ItemPrice[] itemPrices, Throwable ex) ->
		{
			if (ex != null)
			{
				log.error("Error looking up item prices", ex);
				return;
			}

			if (itemPrices == null)
			{
				log.error("Error looking up item prices");
				return;
			}

			for (ItemPrice itemPrice : itemPrices)
			{
				if (itemPrice.getItem() == null)
				{
					continue;
				}
				if (itemPrice.getPrice() > 0)
				{
					this.itemPriceMap.put(itemPrice.getItem().getId(), itemPrice.getPrice());
				}
			}
			onDonefunc.run();
		});
	}

	public void onLogItemsAdded(SessionLog sessionLog)
	{
		sessionLog.getAllItems().keySet().forEach(x ->
			itemsToLookup.add(itemManager.getUnnotedItemComposition(x).getId()));

		onLogUpdated();
	}

	public void onLogUpdated()
	{
		if (!active)
		{
			return;
		}

		update();
	}
}