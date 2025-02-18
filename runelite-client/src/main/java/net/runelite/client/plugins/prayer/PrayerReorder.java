/*
 * Copyright (c) 2018, 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.prayer;

import com.google.common.base.MoreObjects;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.ParamID;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Interface;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetConfig.DRAG;
import static net.runelite.api.widgets.WidgetConfig.DRAG_ON;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
class PrayerReorder
{
	private static final int PRAYER_X_OFFSET = 37;
	private static final int PRAYER_Y_OFFSET = 37;
	private static final int QUICK_PRAYER_SPRITE_X_OFFSET = 2;
	private static final int QUICK_PRAYER_SPRITE_Y_OFFSET = 2;
	private static final int PRAYER_COLUMN_COUNT = 5;

	private static final String LOCK = "Disable prayer reordering";
	private static final String UNLOCK = "Enable prayer reordering";

	private static final WidgetMenuOption FIXED_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.FIXED_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption FIXED_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.FIXED_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_PRAYER_TAB_LOCK = new WidgetMenuOption(LOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_PRAYER_TAB);

	private static final WidgetMenuOption RESIZABLE_BOTTOM_LINE_PRAYER_TAB_UNLOCK = new WidgetMenuOption(UNLOCK,
		"", ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_PRAYER_TAB);

	private final Client client;
	private final ClientThread clientThread;
	private final ConfigManager configManager;
	private final ChatMessageManager chatMessageManager;
	private final MenuManager menuManager;

	private boolean reordering;

	void startUp()
	{
		refreshPrayerTabOption();

		// original plugin's config
		configManager.unsetConfiguration("reorderprayers", "unlockPrayerReordering");
		configManager.unsetConfiguration("reorderprayers", "prayerOrder");
		configManager.unsetConfiguration("runelite", "ReorderPrayersPlugin".toLowerCase());

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invokeLater(this::redrawPrayers);
		}
	}

	void shutDown()
	{
		reordering = false;
		clearPrayerTabMenus();
		clientThread.invokeLater(() -> rebuildPrayers(false));
		clientThread.invokeLater(this::redrawPrayers);
	}

	void reset()
	{
		for (var key : configManager.getConfigurationKeys(PrayerConfig.GROUP + ".prayer_order_book"))
		{
			String[] str = key.split("\\.", 2);
			if (str.length == 2)
			{
				configManager.unsetConfiguration(str[0], str[1]);
			}
		}
		for (var key : configManager.getConfigurationKeys(PrayerConfig.GROUP + ".prayer_hidden_book"))
		{
			String[] str = key.split("\\.", 2);
			if (str.length == 2)
			{
				configManager.unsetConfiguration(str[0], str[1]);
			}
		}

		clientThread.invokeLater(this::redrawPrayers);
	}

	private int[] getPrayerOrder(int prayerbook)
	{
		var s = configManager.getConfiguration(PrayerConfig.GROUP, "prayer_order_book_" + prayerbook);
		if (s == null)
		{
			return null;
		}
		return Arrays.stream(s.split(","))
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	private void setPrayerOrder(int prayerbook, int[] prayers)
	{
		var s = Arrays.stream(prayers)
			.mapToObj(Integer::toString)
			.collect(Collectors.joining(","));
		configManager.setConfiguration(PrayerConfig.GROUP, "prayer_order_book_" + prayerbook, s);
	}

	private boolean isHidden(int prayerbook, int prayer)
	{
		Boolean b = configManager.getConfiguration(PrayerConfig.GROUP, "prayer_hidden_book_" + prayerbook + "_" + prayer, boolean.class);
		return b == Boolean.TRUE;
	}

	private void setHidden(int prayerbook, int prayer, boolean hidden)
	{
		if (hidden)
		{
			configManager.setConfiguration(PrayerConfig.GROUP, "prayer_hidden_book_" + prayerbook + "_" + prayer, true);
		}
		else
		{
			configManager.unsetConfiguration(PrayerConfig.GROUP, "prayer_hidden_book_" + prayerbook + "_" + prayer);
		}
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		// is dragging widget and mouse button released
		if (event.isDraggingWidget() && client.getMouseCurrentButton() == 0)
		{
			Widget draggedWidget = client.getDraggedWidget();
			Widget draggedOnWidget = client.getDraggedOnWidget();
			if (draggedWidget != null && draggedOnWidget != null)
			{
				int draggedGroupId = WidgetUtil.componentToInterface(draggedWidget.getId());
				int draggedOnGroupId = WidgetUtil.componentToInterface(draggedOnWidget.getId());
				if (draggedGroupId != InterfaceID.PRAYER || draggedOnGroupId != InterfaceID.PRAYER)
				{
					return;
				}

				int prayerbook = client.getVarbitValue(Varbits.PRAYERBOOK);
				int fromId = findPrayerIdFromComponent(prayerbook, draggedWidget);
				int toId = findPrayerIdFromComponent(prayerbook, draggedOnWidget);
				if (fromId == -1 || toId == -1)
				{
					return;
				}

				// reset dragged on widget to prevent sending a drag widget packet to the server
				client.setDraggedOnWidget(null);

				var prayerOrder = getPrayerOrder(prayerbook);
				if (prayerOrder == null)
				{
					prayerOrder = defaultPrayerOrder(getPrayerBookEnum(prayerbook));
				}

				int fromIdx = ArrayUtils.indexOf(prayerOrder, fromId);
				int toIdx = ArrayUtils.indexOf(prayerOrder, toId);

				log.debug("Swapping prayer {}<->{} (idx {}<->{})", fromId, toId, fromIdx, toIdx);

				var tmp = prayerOrder[toIdx];
				prayerOrder[toIdx] = prayerOrder[fromIdx];
				prayerOrder[fromIdx] = tmp;

				setPrayerOrder(prayerbook, prayerOrder);
				rebuildPrayers(true);
			}
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		int scriptId = scriptPostFired.getScriptId();
		if (
			// this script calls if_clearops on the prayer, removing our hide/unhide, so we just re-build the entire ui
			reordering && scriptId == ScriptID.PRAYER_UPDATEBUTTON ||
			// rebuild after eg. a prayer book swap
			scriptId == ScriptID.PRAYER_REDRAW ||
			// rebuild after opening quick prayers
			scriptId == ScriptID.QUICKPRAYER_INIT
		)
		{
			rebuildPrayers(reordering);
		}
	}

	// from script7823
	private EnumComposition getPrayerBookEnum(int prayerbook)
	{
		if (prayerbook == 1)
		{
			return client.getEnum(EnumID.PRAYERS_RUINOUS);
		}

		boolean deadeye = client.getVarbitValue(Varbits.PRAYER_DEADEYE_UNLOCKED) != 0;
		boolean vigour = client.getVarbitValue(Varbits.PRAYER_MYSTIC_VIGOUR_UNLOCKED) != 0;

		if (deadeye && vigour)
		{
			return client.getEnum(EnumID.PRAYERS_NORMAL_DEADEYE_MYSTIC_VIGOUR);
		}
		else if (deadeye)
		{
			return client.getEnum(EnumID.PRAYERS_NORMAL_DEADEYE);
		}
		else if (vigour)
		{
			return client.getEnum(EnumID.PRAYERS_NORMAL_MYSTIC_VIGOUR);
		}
		else
		{
			return client.getEnum(EnumID.PRAYERS_NORMAL);
		}
	}

	private int[] defaultPrayerOrder(EnumComposition prayerEnum)
	{
		return Arrays.stream(prayerEnum.getKeys())
			.boxed() // IntStream does not accept a custom comparator
			.sorted(Comparator.comparing(id ->
			{
				var prayerObjId = prayerEnum.getIntValue(id);
				var prayerObj = client.getItemDefinition(prayerObjId);
				return prayerObj.getIntValue(ParamID.OC_PRAYER_LEVEL);
			}))
			.mapToInt(i -> i)
			.toArray();
	}

	private int findPrayerIdFromComponent(int prayerbook, Widget component)
	{
		EnumComposition prayers = getPrayerBookEnum(prayerbook);
		int[] keys = prayers.getKeys();
		int[] vals = prayers.getIntVals();
		for (int i = 0; i < keys.length; ++i)
		{
			ItemComposition prayer = client.getItemDefinition(vals[i]);
			if (prayer.getIntValue(ParamID.OC_PRAYER_COMPONENT) == component.getId())
			{
				return keys[i];
			}
		}
		return -1;
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

	private void reordering(boolean state)
	{
		reordering = state;

		var message = reordering ?
			"Prayer book reordering is now enabled." :
			"Prayer book reordering is now disabled.";

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(message)
			.build());

		refreshPrayerTabOption();

		redrawPrayers();
	}

	private void refreshPrayerTabOption()
	{
		clearPrayerTabMenus();
		if (reordering)
		{
			menuManager.addManagedCustomMenu(FIXED_PRAYER_TAB_LOCK, e -> reordering(false));
			menuManager.addManagedCustomMenu(RESIZABLE_PRAYER_TAB_LOCK, e -> reordering(false));
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_LOCK, e -> reordering(false));
		}
		else
		{
			menuManager.addManagedCustomMenu(FIXED_PRAYER_TAB_UNLOCK, e -> reordering(true));
			menuManager.addManagedCustomMenu(RESIZABLE_PRAYER_TAB_UNLOCK, e -> reordering(true));
			menuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_PRAYER_TAB_UNLOCK, e -> reordering(true));
		}
	}

	private void redrawPrayers()
	{
		Widget w = client.getWidget(InterfaceID.PRAYER, 0);
		if (w != null)
		{
			client.runScript(w.getOnVarTransmitListener());
		}
	}

	private void rebuildPrayers(boolean unlocked)
	{
		var prayerbook = client.getVarbitValue(Varbits.PRAYERBOOK);
		var prayerBookEnum = getPrayerBookEnum(prayerbook);
		var prayerIds = MoreObjects.firstNonNull(getPrayerOrder(prayerbook), defaultPrayerOrder(prayerBookEnum));

		if (isInterfaceOpen(InterfaceID.PRAYER))
		{
			int index = 0;
			for (int prayerId : prayerIds)
			{
				var prayerObjId = prayerBookEnum.getIntValue(prayerId);
				var prayerObj = client.getItemDefinition(prayerObjId);
				var prayerWidget = client.getWidget(prayerObj.getIntValue(ParamID.OC_PRAYER_COMPONENT));

				assert prayerWidget != null;

				int widgetConfig = prayerWidget.getClickMask();
				if (unlocked)
				{
					// allow dragging of this widget & to be dragged on
					widgetConfig |= DRAG | DRAG_ON;
				}
				else
				{
					// remove drag flag & drag on flags
					widgetConfig &= ~(DRAG | DRAG_ON);
				}
				prayerWidget.setClickMask(widgetConfig);

				boolean hidden = isHidden(prayerbook, prayerId);
				// in unlocked mode we show the prayers, but they have opacity set
				if (hidden && !unlocked)
				{
					prayerWidget.setHidden(true);
					++index;
					continue;
				}

				if (unlocked)
				{
					prayerWidget.setHidden(false);

					if (hidden)
					{
						prayerWidget.setAction(3, "Unhide");
						prayerWidget.getChild(1).setOpacity(200);
					}
					else
					{
						prayerWidget.setAction(3, "Hide");
					}
				}
				else
				{
					prayerWidget.setAction(3, null);
				}

				int x = index % PRAYER_COLUMN_COUNT;
				int y = index / PRAYER_COLUMN_COUNT;
				int widgetX = x * PRAYER_X_OFFSET;
				int widgetY = y * PRAYER_Y_OFFSET;

				prayerWidget.setPos(widgetX, widgetY);
				prayerWidget.revalidate();

				++index;
			}

			createWarning(unlocked);
		}

		if (isInterfaceOpen(InterfaceID.QUICK_PRAYER))
		{
			Widget prayersContainer = client.getWidget(ComponentID.QUICK_PRAYER_PRAYERS);
			if (prayersContainer == null)
			{
				return;
			}

			Widget[] prayerWidgets = prayersContainer.getDynamicChildren();
			// (op targetable component)* (prayer icon, checkbox)*
			if (prayerWidgets == null || prayerWidgets.length != prayerBookEnum.size() * 3)
			{
				return;
			}

			var sortedPrayers = defaultPrayerOrder(prayerBookEnum);
			int index = 0;
			for (int prayerId : prayerIds)
			{
				int x = index % PRAYER_COLUMN_COUNT;
				int y = index / PRAYER_COLUMN_COUNT;

				Widget prayerWidget = prayerWidgets[prayerId];
				prayerWidget.setPos(x * PRAYER_X_OFFSET, y * PRAYER_Y_OFFSET);
				prayerWidget.revalidate();

				int sortedIdx = ArrayUtils.indexOf(sortedPrayers, prayerId);
				int childId = prayerBookEnum.size() + 2 * sortedIdx;

				Widget prayerSpriteWidget = prayerWidgets[childId];
				prayerSpriteWidget.setPos(
					QUICK_PRAYER_SPRITE_X_OFFSET + x * PRAYER_X_OFFSET,
					QUICK_PRAYER_SPRITE_Y_OFFSET + y * PRAYER_Y_OFFSET);
				prayerSpriteWidget.revalidate();

				Widget prayerToggleWidget = prayerWidgets[childId + 1];
				prayerToggleWidget.setPos(
					x * PRAYER_X_OFFSET,
					y * PRAYER_Y_OFFSET);
				prayerToggleWidget.revalidate();

				++index;
			}
		}
	}

	private void createWarning(boolean unlocked)
	{
		Widget w = client.getWidget(ComponentID.PRAYER_PARENT);
		w.deleteAllChildren();

		if (unlocked)
		{
			Widget c = w.createChild(WidgetType.RECTANGLE);
			c.setHeightMode(WidgetSizeMode.MINUS);
			c.setWidthMode(WidgetSizeMode.MINUS);
			c.setTextColor(0xff0000);
			c.setFilled(true);
			c.setOpacity(220);
			c.revalidate();
		}
	}

	private boolean isInterfaceOpen(@Interface int interfaceId)
	{
		return client.getWidget(interfaceId, 0) != null;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (reordering
			&& menuOptionClicked.getMenuAction() == MenuAction.CC_OP
			&& menuOptionClicked.getId() == 4
			&& ("Hide".equals(menuOptionClicked.getMenuOption()) || "Unhide".equals(menuOptionClicked.getMenuOption())))
		{
			var widget = menuOptionClicked.getWidget();
			var prayerbook = client.getVarbitValue(Varbits.PRAYERBOOK);
			var prayerId = findPrayerIdFromComponent(prayerbook, widget);
			if (prayerId != -1)
			{
				// child 0 is the background if the prayer is active.
				// child 1 is the prayer icon itself.
				widget = widget.getChild(1);

				boolean hidden = isHidden(prayerbook, prayerId);

				if (hidden)
				{
					widget.setOpacity(0);
					setHidden(prayerbook, prayerId, false);
				}
				else
				{
					widget.setOpacity(200);
					setHidden(prayerbook, prayerId, true);
				}
			}
		}
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged e)
	{
		clientThread.invokeLater(this::redrawPrayers);
	}
}
