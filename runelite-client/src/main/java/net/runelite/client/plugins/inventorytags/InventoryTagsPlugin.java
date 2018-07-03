/*
 * Copyright (c) 2018 kulers
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
package net.runelite.client.plugins.inventorytags;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Inventory Tags",
	description = "Add the ability to tag items in your inventory",
	tags = {"highlight", "items", "overlay", "tagging"},
	enabledByDefault = false
)
public class InventoryTagsPlugin extends Plugin
{
	private static final String ITEM_KEY_PREFIX = "item_";

	private static final String SETNAME_GROUP_1 = "Group 1";
	private static final String SETNAME_GROUP_2 = "Group 2";
	private static final String SETNAME_GROUP_3 = "Group 3";
	private static final String SETNAME_GROUP_4 = "Group 4";

	private static final String CONFIGURE = "Configure";
	private static final String SAVE = "Save";
	private static final String MENU_TARGET = "<col=ff9040>Inventory Tags";
	private static final String MENU_SET = "Mark";
	private static final String MENU_REMOVE = "Remove";

	private static final List<String> GROUPS = ImmutableList.of(SETNAME_GROUP_4, SETNAME_GROUP_3, SETNAME_GROUP_2, SETNAME_GROUP_1);

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private InventoryTagsConfig config;

	@Inject
	private InventoryTagsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Getter(AccessLevel.PACKAGE)
	private boolean hasTaggedItems;

	private boolean editorMode = false;

	@Provides
	InventoryTagsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventoryTagsConfig.class);
	}

	String getTag(int itemId)
	{
		String tag = configManager.getConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId);
		if (tag == null || tag.isEmpty())
		{
			return null;
		}

		return tag;
	}

	void setTag(int itemId, String tag)
	{
		configManager.setConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId, tag);
	}

	void unsetTag(int itemId)
	{
		configManager.unsetConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		hasTaggedItems = editorMode = false;
	}

	@Subscribe
	public void onClickMenu(final MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE)
		{
			return;
		}

		if (MENU_TARGET.equals(event.getMenuTarget()))
		{
			switch (event.getMenuOption())
			{
				case CONFIGURE:
					editorMode = true;
					break;
				case SAVE:
					editorMode = false;
					break;
			}

			return;
		}

		final String selectedMenu = Text.removeTags(event.getMenuTarget());

		if (event.getMenuOption().equals(MENU_SET))
		{
			setTag(event.getId(), selectedMenu);

			hasTaggedItems = true;
		}
		else if (event.getMenuOption().equals(MENU_REMOVE))
		{
			unsetTag(event.getId());

			checkForTags(client.getItemContainer(InventoryID.INVENTORY));
		}
	}

	@Subscribe
	public void onMenuOpened(final MenuOpened event)
	{
		final MenuEntry firstEntry = event.getFirstEntry();

		if (firstEntry == null)
		{
			return;
		}

		final int widgetId = firstEntry.getParam1();

		// Inventory button menu
		if (widgetId == WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB.getId() ||
			widgetId == WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB.getId() ||
			widgetId == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB.getId())
		{
			final int itemId = firstEntry.getIdentifier();

			if (itemId == -1)
			{
				return;
			}

			MenuEntry[] entries = event.getMenuEntries();

			final MenuEntry configureOption = new MenuEntry();
			configureOption.setOption(editorMode ? SAVE : CONFIGURE);
			configureOption.setTarget(MENU_TARGET);
			configureOption.setIdentifier(itemId);
			configureOption.setParam1(widgetId);
			configureOption.setType(MenuAction.RUNELITE.getId());
			entries = ArrayUtils.addAll(entries, configureOption);

			client.setMenuEntries(entries);
		}

		// Inventory item menu
		if (widgetId == WidgetInfo.INVENTORY.getId() && editorMode)
		{
			int itemId = firstEntry.getIdentifier();

			if (itemId == -1)
			{
				return;
			}

			MenuEntry[] menuList = new MenuEntry[GROUPS.size()];
			int num = 0;

			for (final String groupName : GROUPS)
			{
				final String group = getTag(itemId);
				final MenuEntry newMenu = new MenuEntry();
				final Color color = getGroupNameColor(groupName);
				newMenu.setOption(group != null && groupName.equals(group) ? MENU_REMOVE : MENU_SET);
				newMenu.setTarget("<col=" + getHexColor(MoreObjects.firstNonNull(color, Color.WHITE)) + ">" + groupName);
				newMenu.setIdentifier(itemId);
				newMenu.setParam1(widgetId);
				newMenu.setType(MenuAction.RUNELITE.getId());
				menuList[num++] = newMenu;
			}

			client.setMenuEntries(menuList);
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
	{
		ItemContainer itemContainer = itemContainerChanged.getItemContainer();
		if (itemContainer == client.getItemContainer(InventoryID.INVENTORY))
		{
			checkForTags(itemContainer);
		}
	}

	private void checkForTags(ItemContainer itemContainer)
	{
		hasTaggedItems = false;

		if (itemContainer == null)
		{
			return;
		}

		Item[] items = itemContainer.getItems();
		if (items != null)
		{
			for (Item item : items)
			{
				if (item == null)
				{
					continue;
				}

				String tag = getTag(item.getId());
				if (tag == null)
				{
					continue;
				}

				hasTaggedItems = true;
				return;
			}
		}
	}

	private String getHexColor(final Color color)
	{
		return String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	Color getGroupNameColor(final String name)
	{
		switch (name)
		{
			case SETNAME_GROUP_1:
				return config.getGroup1Color();
			case SETNAME_GROUP_2:
				return config.getGroup2Color();
			case SETNAME_GROUP_3:
				return config.getGroup3Color();
			case SETNAME_GROUP_4:
				return config.getGroup4Color();
		}

		return null;
	}
}
