/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.reorderprayers;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HashTable;
import net.runelite.api.Prayer;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetConfig.DRAG;
import static net.runelite.api.widgets.WidgetConfig.DRAG_ON;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Reorder Prayers",
	description = "Reorder the prayers displayed on the Prayer panel"
)
@Singleton
public class ReorderPrayersPlugin extends Plugin
{

	static final String CONFIG_GROUP_KEY = "reorderprayers";

	static final String CONFIG_UNLOCK_REORDERING_KEY = "unlockPrayerReordering";

	static final String CONFIG_PRAYER_ORDER_KEY = "prayerOrder";

	private static final int PRAYER_WIDTH = 34;

	private static final int PRAYER_HEIGHT = 34;

	private static final int PRAYER_X_OFFSET = 37;

	private static final int PRAYER_Y_OFFSET = 37;

	private static final int QUICK_PRAYER_SPRITE_X_OFFSET = 2;

	private static final int QUICK_PRAYER_SPRITE_Y_OFFSET = 2;

	private static final int PRAYER_COLUMN_COUNT = 5;

	private static final int PRAYER_COUNT = Prayer.values().length;

	private static final List<WidgetInfo> PRAYER_WIDGET_INFO_LIST = ImmutableList.of(
		WidgetInfo.PRAYER_THICK_SKIN,
		WidgetInfo.PRAYER_BURST_OF_STRENGTH,
		WidgetInfo.PRAYER_CLARITY_OF_THOUGHT,
		WidgetInfo.PRAYER_SHARP_EYE,
		WidgetInfo.PRAYER_MYSTIC_WILL,
		WidgetInfo.PRAYER_ROCK_SKIN,
		WidgetInfo.PRAYER_SUPERHUMAN_STRENGTH,
		WidgetInfo.PRAYER_IMPROVED_REFLEXES,
		WidgetInfo.PRAYER_RAPID_RESTORE,
		WidgetInfo.PRAYER_RAPID_HEAL,
		WidgetInfo.PRAYER_PROTECT_ITEM,
		WidgetInfo.PRAYER_HAWK_EYE,
		WidgetInfo.PRAYER_MYSTIC_LORE,
		WidgetInfo.PRAYER_STEEL_SKIN,
		WidgetInfo.PRAYER_ULTIMATE_STRENGTH,
		WidgetInfo.PRAYER_INCREDIBLE_REFLEXES,
		WidgetInfo.PRAYER_PROTECT_FROM_MAGIC,
		WidgetInfo.PRAYER_PROTECT_FROM_MISSILES,
		WidgetInfo.PRAYER_PROTECT_FROM_MELEE,
		WidgetInfo.PRAYER_EAGLE_EYE,
		WidgetInfo.PRAYER_MYSTIC_MIGHT,
		WidgetInfo.PRAYER_RETRIBUTION,
		WidgetInfo.PRAYER_REDEMPTION,
		WidgetInfo.PRAYER_SMITE,
		WidgetInfo.PRAYER_PRESERVE,
		WidgetInfo.PRAYER_CHIVALRY,
		WidgetInfo.PRAYER_PIETY,
		WidgetInfo.PRAYER_RIGOUR,
		WidgetInfo.PRAYER_AUGURY
	);

	private static final List<Integer> QUICK_PRAYER_CHILD_IDS = ImmutableList.of(
		WidgetID.QuickPrayer.THICK_SKIN_CHILD_ID,
		WidgetID.QuickPrayer.BURST_OF_STRENGTH_CHILD_ID,
		WidgetID.QuickPrayer.CLARITY_OF_THOUGHT_CHILD_ID,
		WidgetID.QuickPrayer.SHARP_EYE_CHILD_ID,
		WidgetID.QuickPrayer.MYSTIC_WILL_CHILD_ID,
		WidgetID.QuickPrayer.ROCK_SKIN_CHILD_ID,
		WidgetID.QuickPrayer.SUPERHUMAN_STRENGTH_CHILD_ID,
		WidgetID.QuickPrayer.IMPROVED_REFLEXES_CHILD_ID,
		WidgetID.QuickPrayer.RAPID_RESTORE_CHILD_ID,
		WidgetID.QuickPrayer.RAPID_HEAL_CHILD_ID,
		WidgetID.QuickPrayer.PROTECT_ITEM_CHILD_ID,
		WidgetID.QuickPrayer.HAWK_EYE_CHILD_ID,
		WidgetID.QuickPrayer.MYSTIC_LORE_CHILD_ID,
		WidgetID.QuickPrayer.STEEL_SKIN_CHILD_ID,
		WidgetID.QuickPrayer.ULTIMATE_STRENGTH_CHILD_ID,
		WidgetID.QuickPrayer.INCREDIBLE_REFLEXES_CHILD_ID,
		WidgetID.QuickPrayer.PROTECT_FROM_MAGIC_CHILD_ID,
		WidgetID.QuickPrayer.PROTECT_FROM_MISSILES_CHILD_ID,
		WidgetID.QuickPrayer.PROTECT_FROM_MELEE_CHILD_ID,
		WidgetID.QuickPrayer.EAGLE_EYE_CHILD_ID,
		WidgetID.QuickPrayer.MYSTIC_MIGHT_CHILD_ID,
		WidgetID.QuickPrayer.RETRIBUTION_CHILD_ID,
		WidgetID.QuickPrayer.REDEMPTION_CHILD_ID,
		WidgetID.QuickPrayer.SMITE_CHILD_ID,
		WidgetID.QuickPrayer.PRESERVE_CHILD_ID,
		WidgetID.QuickPrayer.CHIVALRY_CHILD_ID,
		WidgetID.QuickPrayer.PIETY_CHILD_ID,
		WidgetID.QuickPrayer.RIGOUR_CHILD_ID,
		WidgetID.QuickPrayer.AUGURY_CHILD_ID
	);

	private static final String LOCK = "Lock";

	private static final String UNLOCK = "Unlock";

	private static final String MENU_TARGET = "Reordering";

	private static final WidgetMenuOption FIXED_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption FIXED_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_PRAYER_TAB);

	@Inject
	private Client client;

	@Inject
	private ReorderPrayersConfig config;

	@Inject
	private MenuManager menuManager;

	@Inject
	private EventBus eventBus;

	private Prayer[] prayerOrder;

	static String prayerOrderToString(Prayer[] prayerOrder)
	{
		return Arrays.stream(prayerOrder)
			.map(Prayer::name)
			.collect(Collectors.joining(","));
	}

	private static Prayer[] stringToPrayerOrder(String string)
	{
		return Arrays.stream(string.split(","))
			.map(Prayer::valueOf)
			.toArray(Prayer[]::new);
	}

	private static int getPrayerIndex(Widget widget)
	{
		int x = widget.getOriginalX() / PRAYER_X_OFFSET;
		int y = widget.getOriginalY() / PRAYER_Y_OFFSET;
		return x + y * PRAYER_COLUMN_COUNT;
	}

	private static void setWidgetPosition(Widget widget, int x, int y)
	{
		widget.setRelativeX(x);
		widget.setRelativeY(y);
		widget.setOriginalX(x);
		widget.setOriginalY(y);
	}

	@Provides
	ReorderPrayersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ReorderPrayersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		refreshPrayerTabOption();
		prayerOrder = stringToPrayerOrder(config.prayerOrder());
		reorderPrayers();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		clearPrayerTabMenus();
		prayerOrder = Prayer.values();
		reorderPrayers(false);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(DraggingWidgetChanged.class, this, this::onDraggingWidgetChanged);
		eventBus.subscribe(WidgetMenuOptionClicked.class, this, this::onWidgetMenuOptionClicked);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			reorderPrayers();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_KEY))
		{
			if (event.getKey().equals(CONFIG_PRAYER_ORDER_KEY))
			{
				prayerOrder = stringToPrayerOrder(config.prayerOrder());
			}
			else if (event.getKey().equals(CONFIG_UNLOCK_REORDERING_KEY))
			{
				refreshPrayerTabOption();
			}
			reorderPrayers();
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.PRAYER_GROUP_ID || event.getGroupId() == WidgetID.QUICK_PRAYERS_GROUP_ID)
		{
			reorderPrayers();
		}
	}

	private void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		// is dragging widget and mouse button released
		if (event.isDraggingWidget() && client.getMouseCurrentButton() == 0)
		{
			Widget draggedWidget = client.getDraggedWidget();
			Widget draggedOnWidget = client.getDraggedOnWidget();
			if (draggedWidget != null && draggedOnWidget != null)
			{
				int draggedGroupId = WidgetInfo.TO_GROUP(draggedWidget.getId());
				int draggedOnGroupId = WidgetInfo.TO_GROUP(draggedOnWidget.getId());
				if (draggedGroupId != WidgetID.PRAYER_GROUP_ID || draggedOnGroupId != WidgetID.PRAYER_GROUP_ID
					|| draggedOnWidget.getWidth() != PRAYER_WIDTH || draggedOnWidget.getHeight() != PRAYER_HEIGHT)
				{
					return;
				}
				// reset dragged on widget to prevent sending a drag widget packet to the server
				client.setDraggedOnWidget(null);

				int fromPrayerIndex = getPrayerIndex(draggedWidget);
				int toPrayerIndex = getPrayerIndex(draggedOnWidget);

				Prayer tmp = prayerOrder[toPrayerIndex];
				prayerOrder[toPrayerIndex] = prayerOrder[fromPrayerIndex];
				prayerOrder[fromPrayerIndex] = tmp;

				save();
			}
		}
	}

	private void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() == WidgetInfo.FIXED_VIEWPORT_PRAYER_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_PRAYER_TAB
			|| event.getWidget() == WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_PRAYER_TAB)
		{
			config.unlockPrayerReordering(event.getMenuOption().equals(UNLOCK));
		}
	}

	private void clearPrayerTabMenus()
	{
		menuManager.removeManagedCustomMenu(FIXED_PRAYER_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_PRAYER_TAB_LOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_LOCK);
		menuManager.removeManagedCustomMenu(FIXED_PRAYER_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_PRAYER_TAB_UNLOCK);
		menuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_UNLOCK);
	}

	private void refreshPrayerTabOption()
	{
		clearPrayerTabMenus();
		if (config.unlockPrayerReordering())
		{
			menuManager.addManagedCustomMenu(FIXED_PRAYER_TAB_LOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_PRAYER_TAB_LOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_LOCK);
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_PRAYER_TAB_UNLOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_PRAYER_TAB_UNLOCK);
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_UNLOCK);
		}
	}

	private PrayerTabState getPrayerTabState()
	{
		HashTable<WidgetNode> componentTable = client.getComponentTable();
		for (WidgetNode widgetNode : componentTable.getNodes())
		{
			if (widgetNode.getId() == WidgetID.PRAYER_GROUP_ID)
			{
				return PrayerTabState.PRAYERS;
			}
			else if (widgetNode.getId() == WidgetID.QUICK_PRAYERS_GROUP_ID)
			{
				return PrayerTabState.QUICK_PRAYERS;
			}
		}
		return PrayerTabState.NONE;
	}

	private void save()
	{
		config.prayerOrder(prayerOrderToString(prayerOrder));
	}

	private void reorderPrayers()
	{
		reorderPrayers(config.unlockPrayerReordering());
	}

	private void reorderPrayers(boolean unlocked)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		PrayerTabState prayerTabState = getPrayerTabState();

		if (prayerTabState == PrayerTabState.PRAYERS)
		{
			List<Widget> prayerWidgets = PRAYER_WIDGET_INFO_LIST.stream()
				.map(client::getWidget)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

			if (prayerWidgets.size() != PRAYER_WIDGET_INFO_LIST.size())
			{
				return;
			}

			for (int index = 0; index < prayerOrder.length; index++)
			{
				Prayer prayer = prayerOrder[index];
				Widget prayerWidget = prayerWidgets.get(prayer.ordinal());

				int widgetConfig = prayerWidget.getClickMask();
				if (unlocked)
				{
					// allow dragging of this widget
					widgetConfig |= DRAG;
					// allow this widget to be dragged on
					widgetConfig |= DRAG_ON;
				}
				else
				{
					// remove drag flag
					widgetConfig &= ~DRAG;
					// remove drag on flag
					widgetConfig &= ~DRAG_ON;
				}
				prayerWidget.setClickMask(widgetConfig);

				int x = index % PRAYER_COLUMN_COUNT;
				int y = index / PRAYER_COLUMN_COUNT;
				int widgetX = x * PRAYER_X_OFFSET;
				int widgetY = y * PRAYER_Y_OFFSET;
				setWidgetPosition(prayerWidget, widgetX, widgetY);
			}
		}
		else if (prayerTabState == PrayerTabState.QUICK_PRAYERS)
		{
			Widget prayersContainer = client.getWidget(WidgetInfo.QUICK_PRAYER_PRAYERS);
			if (prayersContainer == null)
			{
				return;
			}
			Widget[] prayerWidgets = prayersContainer.getDynamicChildren();
			if (prayerWidgets == null || prayerWidgets.length != PRAYER_COUNT * 3)
			{
				return;
			}

			for (int index = 0; index < prayerOrder.length; index++)
			{
				Prayer prayer = prayerOrder[index];

				int x = index % PRAYER_COLUMN_COUNT;
				int y = index / PRAYER_COLUMN_COUNT;

				Widget prayerWidget = prayerWidgets[QUICK_PRAYER_CHILD_IDS.get(prayer.ordinal())];
				setWidgetPosition(prayerWidget, x * PRAYER_X_OFFSET, y * PRAYER_Y_OFFSET);

				int childId = PRAYER_COUNT + 2 * prayer.ordinal();

				Widget prayerSpriteWidget = prayerWidgets[childId];
				setWidgetPosition(prayerSpriteWidget,
					QUICK_PRAYER_SPRITE_X_OFFSET + x * PRAYER_X_OFFSET,
					QUICK_PRAYER_SPRITE_Y_OFFSET + y * PRAYER_Y_OFFSET);

				Widget prayerToggleWidget = prayerWidgets[childId + 1];
				setWidgetPosition(prayerToggleWidget, x * PRAYER_X_OFFSET, y * PRAYER_Y_OFFSET);
			}
		}
	}

}
