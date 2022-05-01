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
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

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
	private static final String SETNAME_GROUP_5 = "Group 5";
	private static final String SETNAME_GROUP_6 = "Group 6";

	private static final String CONFIGURE = "Configure";
	private static final String SAVE = "Save";
	private static final String MENU_TARGET = "Inventory Tags";
	private static final String MENU_SET = "Mark";
	private static final String MENU_REMOVE = "Remove";

	private static final WidgetMenuOption FIXED_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB);
	private static final WidgetMenuOption FIXED_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB);
	private static final WidgetMenuOption RESIZABLE_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB);
	private static final WidgetMenuOption RESIZABLE_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE = new WidgetMenuOption(CONFIGURE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB);
	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE = new WidgetMenuOption(SAVE,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB);

	private static final List<String> GROUPS = ImmutableList.of(SETNAME_GROUP_6, SETNAME_GROUP_5, SETNAME_GROUP_4, SETNAME_GROUP_3, SETNAME_GROUP_2, SETNAME_GROUP_1);

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private InventoryTagsConfig config;

	@Inject
	private MenuManager menuManager;

	@Inject
	private InventoryTagsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	private boolean editorMode;

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

	private void setTag(int itemId, String tag)
	{
		configManager.setConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId, tag);
	}

	private void unsetTag(int itemId)
	{
		configManager.unsetConfiguration(InventoryTagsConfig.GROUP, ITEM_KEY_PREFIX + itemId);
	}

	@Override
	protected void startUp() throws Exception
	{
		refreshInventoryMenuOptions();
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeInventoryMenuOptions();
		overlayManager.remove(overlay);
		editorMode = false;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(InventoryTagsConfig.GROUP))
		{
			overlay.invalidateCache();
		}
	}

	@Subscribe
	public void onMenuOpened(final MenuOpened event)
	{
		final MenuEntry firstEntry = event.getFirstEntry();
		if (firstEntry == null || !editorMode)
		{
			return;
		}

		final int itemId;
		if (firstEntry.getType() == MenuAction.WIDGET_TARGET && firstEntry.getWidget().getId() == WidgetInfo.INVENTORY.getId())
		{
			itemId = firstEntry.getWidget().getItemId();
		}
		else if (firstEntry.isItemOp())
		{
			itemId = firstEntry.getItemId();
		}
		else
		{
			return;
		}

		// Set menu to only be Cancel
		client.setMenuEntries(Arrays.copyOf(client.getMenuEntries(), 1));

		for (final String groupName : GROUPS)
		{
			final String group = getTag(itemId);
			final Color color = getGroupNameColor(groupName);

			client.createMenuEntry(-1)
				.setOption(groupName.equals(group) ? MENU_REMOVE : MENU_SET)
				.setTarget(ColorUtil.prependColorTag(groupName, MoreObjects.firstNonNull(color, Color.WHITE)))
				.setType(MenuAction.RUNELITE)
				.onClick(e ->
				{
					if (e.getOption().equals(MENU_SET))
					{
						setTag(itemId, groupName);
					}
					else
					{
						unsetTag(itemId);
					}
				});
		}
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
			case SETNAME_GROUP_5:
				return config.getGroup5Color();
			case SETNAME_GROUP_6:
				return config.getGroup6Color();
		}

		return null;
	}

	private void removeInventoryMenuOptions()
	{
		menuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE);
		menuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE);
	}

	private void refreshInventoryMenuOptions()
	{
		removeInventoryMenuOptions();
		if (editorMode)
		{
			menuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE, this::save);
			menuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE, this::save);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE, this::save);
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE, this::configure);
			menuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE, this::configure);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE, this::configure);
		}
	}

	private void save(MenuEntry menuEntry)
	{
		editorMode = false;
		refreshInventoryMenuOptions();
	}

	private void configure(MenuEntry menuEntry)
	{
		editorMode = true;
		refreshInventoryMenuOptions();
	}
}
