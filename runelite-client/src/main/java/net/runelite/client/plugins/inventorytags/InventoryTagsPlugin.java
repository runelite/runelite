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

import com.google.gson.Gson;
import com.google.inject.Provides;
import java.applet.Applet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import static net.runelite.api.InventoryID.EQUIPMENT;
import static net.runelite.api.InventoryID.INVENTORY;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.KeyCode;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Inventory Tags",
	description = "Add the ability to tag items in your inventory",
	tags = {"highlight", "items", "overlay", "tagging"},
	enabledByDefault = false
)
@Slf4j
public class InventoryTagsPlugin extends Plugin
{
	private static final String ITEM_KEY_PREFIX = "item_";
	private static final String TAG_KEY_PREFIX = "tag_";

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private InventoryTagsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Gson gson;

	@Inject
	private ColorPickerManager colorPickerManager;

	@Provides
	InventoryTagsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventoryTagsConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		convertConfig();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}

	Tag getTag(int itemId)
	{
		String tag = configManager.getConfiguration(InventoryTagsConfig.GROUP, TAG_KEY_PREFIX + itemId);
		if (tag == null || tag.isEmpty())
		{
			return null;
		}

		return gson.fromJson(tag, Tag.class);
	}

	void setTag(int itemId, Tag tag)
	{
		String json = gson.toJson(tag);
		configManager.setConfiguration(InventoryTagsConfig.GROUP, TAG_KEY_PREFIX + itemId, json);
	}

	void unsetTag(int itemId)
	{
		configManager.unsetConfiguration(InventoryTagsConfig.GROUP, TAG_KEY_PREFIX + itemId);
	}

	private void convertConfig()
	{
		String migrated = configManager.getConfiguration(InventoryTagsConfig.GROUP, "migrated");
		if (!"1".equals(migrated))
		{
			return;
		}

		int removed = 0;
		List<String> keys = configManager.getConfigurationKeys(InventoryTagsConfig.GROUP + "." + ITEM_KEY_PREFIX);
		for (String key : keys)
		{
			String[] str = key.split("\\.", 2);
			if (str.length == 2)
			{
				configManager.unsetConfiguration(str[0], str[1]);
				++removed;
			}
		}

		log.debug("Removed {} old tags", removed);
		configManager.setConfiguration(InventoryTagsConfig.GROUP, "migrated", "2");
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
		if (!client.isKeyPressed(KeyCode.KC_SHIFT))
		{
			return;
		}

		final MenuEntry[] entries = event.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			final MenuEntry entry = entries[idx];
			final Widget w = entry.getWidget();

			if (w != null && WidgetUtil.componentToInterface(w.getId()) == InterfaceID.INVENTORY
				&& "Examine".equals(entry.getOption()) && entry.getIdentifier() == 10)
			{
				final int itemId = w.getItemId();
				final Tag tag = getTag(itemId);

				final MenuEntry parent = client.createMenuEntry(idx)
					.setOption("Inventory tag")
					.setTarget(entry.getTarget())
					.setType(MenuAction.RUNELITE);
				final Menu submenu = parent.createSubMenu();

				Set<Color> invEquipmentColors = new HashSet<>();
				invEquipmentColors.addAll(getColorsFromItemContainer(INVENTORY));
				invEquipmentColors.addAll(getColorsFromItemContainer(EQUIPMENT));
				for (Color color : invEquipmentColors)
				{
					if (tag == null || !tag.color.equals(color))
					{
						submenu.createMenuEntry(0)
							.setOption(ColorUtil.prependColorTag("Color", color))
							.setType(MenuAction.RUNELITE)
							.onClick(e ->
							{
								Tag t = new Tag();
								t.color = color;
								setTag(itemId, t);
							});
					}
				}

				submenu.createMenuEntry(0)
					.setOption("Pick")
					.setType(MenuAction.RUNELITE)
					.onClick(e ->
					{
						Color color = tag == null ? Color.WHITE : tag.color;
						SwingUtilities.invokeLater(() ->
						{
							RuneliteColorPicker colorPicker = colorPickerManager.create(SwingUtilities.windowForComponent((Applet) client),
								color, "Inventory Tag", true);
							colorPicker.setOnClose(c ->
							{
								Tag t = new Tag();
								t.color = c;
								setTag(itemId, t);
							});
							colorPicker.setVisible(true);
						});
					});

				if (tag != null)
				{
					submenu.createMenuEntry(0)
						.setOption("Reset")
						.setType(MenuAction.RUNELITE)
						.onClick(e -> unsetTag(itemId));
				}
			}
		}
	}

	private List<Color> getColorsFromItemContainer(InventoryID inventoryID)
	{
		List<Color> colors = new ArrayList<>();
		ItemContainer container = client.getItemContainer(inventoryID);
		if (container != null)
		{
			for (Item item : container.getItems())
			{
				Tag tag = getTag(item.getId());
				if (tag != null && tag.color != null)
				{
					if (!colors.contains(tag.color))
					{
						colors.add(tag.color);
					}
				}
			}
		}
		return colors;
	}
}
