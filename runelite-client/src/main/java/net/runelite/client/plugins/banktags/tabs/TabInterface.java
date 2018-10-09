/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags.tabs;

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseWheelEvent;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetType;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.banktags.BankTagsConfig;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.CONFIG_GROUP;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.ICON_SEARCH;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_SEARCH;
import net.runelite.client.plugins.banktags.TagManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

@Singleton
public class TabInterface
{
	private static final Color HILIGHT_COLOR = Color.decode("#ff9040");
	private static final String SCROLL_UP = "Scroll up";
	private static final String SCROLL_DOWN = "Scroll down";
	private static final String NEW_TAB = "New tag tab";
	private static final String REMOVE_TAB = "Delete tag tab";
	private static final String VIEW_TAB = "View tag tab";
	private static final String CHANGE_ICON = "Change icon";
	private static final String REMOVE_TAG = "Remove-tag";
	private static final int TAB_HEIGHT = 40;
	private static final int TAB_WIDTH = 39;
	private static final int BUTTON_HEIGHT = 20;
	private static final int MARGIN = 1;
	private static final int SCROLL_TICK = 500;

	// Widget indexes for searching
	private static final int INNER_CONTAINER_IDX = 2;
	private static final int SETTINGS_IDX = 4;
	private static final int ITEM_CONTAINER_IDX = 7;
	private static final int SCROLLBAR_IDX = 8;
	private static final int BOTTOM_BAR_IDX = 9;
	private static final int SEARCH_BUTTON_BACKGROUND_IDX = 15;
	private static final int TITLE_BAR_IDX = 16;
	private static final int ITEM_COUNT_IDX = 17;
	private static final int TAB_BAR_IDX = 18;
	private static final int INCINERATOR_IDX = 19;
	private static final int INCINERATOR_CONFIRM_IDX = 20;
	private static final int HIDDEN_WIDGET_IDX = 21;

	private final Client client;
	private final ClientThread clientThread;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TagManager tagManager;
	private final TabManager tabManager;
	private final ChatboxInputManager chatboxInputManager;
	private final BankTagsConfig config;
	private final Rectangle bounds = new Rectangle();
	private final Rectangle canvasBounds = new Rectangle();

	private TagTab activeTab;
	private int maxTabs;
	private int currentTabIndex;
	private TagTab iconToSet = null;
	private Instant startScroll = Instant.now();
	private Object[] widgetIds;

	@Getter
	private Widget upButton;

	@Getter
	private Widget downButton;

	@Getter
	private Widget newTab;

	@Getter
	private Widget parent;

	@Inject
	private TabInterface(
		final Client client,
		final ClientThread clientThread,
		final ItemManager itemManager,
		final ConfigManager configManager,
		final TagManager tagManager,
		final TabManager tabManager,
		final ChatboxInputManager chatboxInputManager,
		final BankTagsConfig config)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.tagManager = tagManager;
		this.tabManager = tabManager;
		this.chatboxInputManager = chatboxInputManager;
		this.config = config;
	}

	public boolean isActive()
	{
		return activeTab != null;
	}

	public void init()
	{
		if (isHidden())
		{
			return;
		}

		Widget bankContainer = client.getWidget(WidgetInfo.BANK_CONTAINER);
		widgetIds = bankContainer.getOnLoadListener();

		currentTabIndex = config.position();
		parent = client.getWidget(WidgetInfo.BANK_CONTENT_CONTAINER);

		updateBounds();

		upButton = createGraphic("", TabSprites.UP_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, bounds.x, 0, true);
		upButton.setAction(1, SCROLL_UP);
		int clickmask = upButton.getClickMask();
		clickmask |= WidgetConfig.DRAG;
		upButton.setClickMask(clickmask);

		downButton = createGraphic("", TabSprites.DOWN_ARROW.getSpriteId(), -1, TAB_WIDTH, BUTTON_HEIGHT, bounds.x, 0, true);
		downButton.setAction(1, SCROLL_DOWN);
		clickmask = downButton.getClickMask();
		clickmask |= WidgetConfig.DRAG;
		downButton.setClickMask(clickmask);

		newTab = createGraphic("", TabSprites.NEW_TAB.getSpriteId(), -1, TAB_WIDTH, 39, bounds.x, 0, true);
		newTab.setAction(1, NEW_TAB);

		tabManager.clear();
		tabManager.getAllTabs().forEach(this::loadTab);
		activateTab(null);
		scrollTab(0);
	}

	public void destroy()
	{
		activeTab = null;
		currentTabIndex = 0;
		maxTabs = 0;
		parent = null;

		if (upButton != null)
		{
			upButton.setHidden(true);
			downButton.setHidden(true);
			newTab.setHidden(true);
		}

		tabManager.clear();
	}

	public void update()
	{
		if (isHidden())
		{
			parent = null;

			// If bank window was just hidden, update last active tab position
			if (currentTabIndex != config.position())
			{
				config.position(currentTabIndex);
			}

			return;
		}

		String str = client.getVar(VarClientStr.INPUT_TEXT);

		if (Strings.isNullOrEmpty(str))
		{
			str = "";
		}

		Widget bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		if (bankTitle != null && !bankTitle.isHidden())
		{
			str = bankTitle.getText().replaceFirst("Showing items: ", "");

			if (str.startsWith("Tab "))
			{
				str = "";
			}
		}

		str = Text.standardize(str);

		if (str.startsWith("tag:"))
		{
			str = str.substring(4);
			activateTab(tabManager.find(str));
		}
		else
		{
			activateTab(null);
		}

		updateBounds();
		scrollTab(0);
	}

	public void handleWheel(final MouseWheelEvent event)
	{
		if (isHidden())
		{
			return;
		}

		if (canvasBounds.contains(event.getPoint()))
		{
			scrollTab(event.getWheelRotation());
		}
	}

	public void handleAdd(MenuEntryAdded event)
	{
		if (isHidden())
		{
			return;
		}

		MenuEntry[] entries = client.getMenuEntries();
		MenuEntry entry = entries[entries.length - 1];

		if (activeTab != null
			&& event.getActionParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getOption().equals("Examine"))
		{
			MenuEntry removeTag = new MenuEntry();
			removeTag.setParam0(event.getActionParam0());
			removeTag.setParam1(event.getActionParam1());
			removeTag.setTarget(event.getTarget());
			removeTag.setOption(REMOVE_TAG + " (" + activeTab.getTag() + ")");
			removeTag.setType(MenuAction.RUNELITE.getId());
			removeTag.setIdentifier(event.getIdentifier());
			entries = Arrays.copyOf(entries, entries.length + 1);
			entries[entries.length - 1] = removeTag;
			client.setMenuEntries(entries);
		}
		else if (iconToSet != null && (entry.getOption().startsWith("Withdraw-") || entry.getOption().equals("Release")))
		{
			// TODO: Do not replace every withdraw option with change icon option
			entry.setOption(CHANGE_ICON + " (" + iconToSet.getTag() + ")");
			client.setMenuEntries(entries);
		}
	}

	public void handleClick(MenuOptionClicked event)
	{
		if (isHidden())
		{
			return;
		}

		if (iconToSet != null)
		{
			if (event.getMenuOption().startsWith(CHANGE_ICON))
			{
				ItemComposition item = getItem(event.getActionParam());
				int itemId = itemManager.canonicalize(item.getId());
				iconToSet.setIconItemId(itemId);
				iconToSet.getIcon().setItemId(itemId);
				configManager.setConfiguration(CONFIG_GROUP, ICON_SEARCH + iconToSet.getTag(), itemId + "");
				event.consume();
			}

			// Reset icon selection even when we do not clicked item with icon
			iconToSet = null;
		}

		if (activeTab != null
			&& event.getMenuOption().equals("Search")
			&& client.getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND).getSpriteId() != SpriteID.EQUIPMENT_SLOT_SELECTED)
		{
			activateTab(null);
			// This ensures that when clicking Search when tab is selected, the search input is opened rather
			// than client trying to close it first
			client.setVar(VarClientStr.INPUT_TEXT, "");
			client.setVar(VarClientInt.INPUT_TYPE, 0);
		}
		else if (activeTab != null
			&& event.getMenuOption().startsWith("View tab"))
		{
			activateTab(null);
		}
		else if (activeTab != null
			&& event.getWidgetId() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getMenuAction() == MenuAction.RUNELITE
			&& event.getMenuOption().startsWith(REMOVE_TAG))
		{
			// Add "remove" menu entry to all items in bank while tab is selected
			event.consume();
			final ItemComposition item = getItem(event.getActionParam());
			final int itemId = itemManager.canonicalize(item.getId());
			tagManager.removeTag(itemId, activeTab.getTag());
			doSearch(InputType.SEARCH, TAG_SEARCH + activeTab.getTag());
		}
		else
		{
			switch (event.getMenuOption())
			{
				case SCROLL_UP:
					event.consume();
					scrollTab(-1);
					break;
				case SCROLL_DOWN:
					event.consume();
					scrollTab(1);
					break;
				case CHANGE_ICON:
					event.consume();
					iconToSet = tabManager.find(Text.removeTags(event.getMenuTarget()));
					break;
				case VIEW_TAB:
					event.consume();
					client.setVarbitValue(client.getVarps(), Varbits.CURRENT_BANK_TAB.getId(), 0);
					Widget[] children = parent.getDynamicChildren();
					Widget clicked = children[event.getActionParam()];

					TagTab tab = tabManager.find(Text.removeTags(clicked.getName()));

					if (tab.equals(activeTab))
					{
						resetSearch();

						clientThread.invokeLater(() -> client.runScript(ScriptID.CLOSE_CHATBOX_INPUT));
					}
					else
					{
						openTag(TAG_SEARCH + Text.removeTags(clicked.getName()));
					}

					client.playSoundEffect(SoundEffectID.UI_BOOP);

					break;
				case NEW_TAB:
					event.consume();
					chatboxInputManager.openInputWindow("Tag Name", "", (tagName) ->
					{
						if (!Strings.isNullOrEmpty(tagName))
						{
							loadTab(tagName);
							tabManager.save();
							scrollTab(0);
						}
					});
					break;
				case REMOVE_TAB:
					event.consume();
					String target = Text.standardize(event.getMenuTarget());

					// TODO: Replace this number input selection with actual in-game select input
					chatboxInputManager.openInputWindow(
						"1. Delete tab " + target + " and tag from all items<br>" +
							"2. Delete tab " + target + "<br>" +
							"3. Cancel", "", (response) ->
						{
							switch (response)
							{
								case "1":
									tagManager.removeTag(target);
									if (activeTab != null && activeTab.getTag().equals(target))
									{
										resetSearch();
									}
								case "2":
									deleteTab(target);
									break;
								default:
									break;
							}
						});
					break;
			}
		}
	}

	public void handleDrag(boolean isDragging)
	{
		if (isHidden())
		{
			return;
		}

		Widget draggedOn = client.getDraggedOnWidget();
		Widget draggedWidget = client.getDraggedWidget();

		if (!isDragging || draggedOn == null)
		{
			return;
		}

		// is dragging widget and mouse button released
		if (client.getMouseCurrentButton() == 0)
		{
			if (draggedWidget.getItemId() > 0 && draggedWidget.getId() != parent.getId())
			{
				// Tag an item dragged on a tag tab
				if (draggedOn.getId() == parent.getId())
				{
					int itemId = itemManager.canonicalize(draggedWidget.getItemId());
					tagManager.addTag(itemId, draggedOn.getName());
				}
			}
			else if (parent.getId() == draggedOn.getId() && parent.getId() == draggedWidget.getId())
			{
				// Reorder tag tabs
				if (!Strings.isNullOrEmpty(draggedOn.getName()))
				{
					tabManager.move(draggedWidget.getName(), draggedOn.getName());
					tabManager.save();
					updateTabs();
				}
			}
		}
		else if (draggedWidget.getItemId() > 0)
		{
			MenuEntry[] entries = client.getMenuEntries();

			if (entries.length > 0)
			{
				MenuEntry entry = entries[entries.length - 1];

				if (draggedWidget.getItemId() > 0 && entry.getOption().equals(VIEW_TAB) && draggedOn.getId() != draggedWidget.getId())
				{
					entry.setOption(TAG_SEARCH + Text.removeTags(entry.getTarget()));
					entry.setTarget(draggedWidget.getName());
					client.setMenuEntries(entries);
				}

				if (entry.getOption().equals(SCROLL_UP))
				{
					scrollTick(-1);
				}
				else if (entry.getOption().equals(SCROLL_DOWN))
				{
					scrollTick(1);
				}
			}
		}
	}

	private void resetSearch()
	{
		doSearch(InputType.NONE, "");
	}

	private boolean isHidden()
	{
		Widget widget = client.getWidget(WidgetInfo.BANK_CONTAINER);
		return !config.tabs() || widget == null || widget.isHidden();
	}

	private void loadTab(String tag)
	{
		TagTab tagTab = tabManager.load(tag);

		if (tagTab.getBackground() == null)
		{
			Widget btn = createGraphic(ColorUtil.wrapWithColorTag(tagTab.getTag(), HILIGHT_COLOR), TabSprites.TAB_BACKGROUND.getSpriteId(), -1, TAB_WIDTH, TAB_HEIGHT, bounds.x, 1, true);
			btn.setAction(1, VIEW_TAB);
			btn.setAction(2, CHANGE_ICON);
			btn.setAction(3, REMOVE_TAB);
			tagTab.setBackground(btn);
		}

		if (tagTab.getIcon() == null)
		{
			Widget icon = createGraphic(ColorUtil.wrapWithColorTag(tagTab.getTag(), HILIGHT_COLOR), -1, tagTab.getIconItemId(), 36, 32, bounds.x + 3, 1, false);
			int clickmask = icon.getClickMask();
			clickmask |= WidgetConfig.DRAG;
			clickmask |= WidgetConfig.DRAG_ON;
			icon.setClickMask(clickmask);
			icon.setDragDeadTime(5);
			icon.setDragDeadZone(5);
			tagTab.setIcon(icon);
		}

		tabManager.add(tagTab);
	}

	private void deleteTab(String tag)
	{
		if (activeTab != null && activeTab.getTag().equals(tag))
		{
			doSearch(InputType.SEARCH, "");
		}

		tabManager.remove(tag);
		configManager.unsetConfiguration(CONFIG_GROUP, ICON_SEARCH + tag);
		tabManager.save();

		updateBounds();
		scrollTab(0);
	}

	private void scrollTick(int direction)
	{
		// This ensures that dragging on scroll buttons do not scrolls too fast
		if (startScroll.until(Instant.now(), ChronoUnit.MILLIS) >= SCROLL_TICK)
		{
			startScroll = Instant.now();
			scrollTab(direction);
		}
	}

	private void scrollTab(int direction)
	{
		maxTabs = (bounds.height - BUTTON_HEIGHT * 2 - MARGIN * 2) / TAB_HEIGHT;

		// prevent running into the incinerator
		while (bounds.y + maxTabs * TAB_HEIGHT + MARGIN * maxTabs + BUTTON_HEIGHT * 2 + MARGIN > bounds.y + bounds.height)
		{
			--maxTabs;
		}

		if (currentTabIndex + direction >= tabManager.size() || currentTabIndex + direction < 0)
		{
			currentTabIndex = 0;
		}

		if ((tabManager.size() - (currentTabIndex + direction) >= maxTabs) && (currentTabIndex + direction > -1))
		{
			currentTabIndex += direction;
		}
		else if (maxTabs < tabManager.size() && tabManager.size() - (currentTabIndex + direction) < maxTabs)
		{
			// Edge case when only 1 tab displays instead of up to maxTabs when one is deleted at the end of the list
			currentTabIndex += direction;
			scrollTab(-1);
		}

		updateTabs();
	}

	private void activateTab(TagTab tagTab)
	{
		if (activeTab != null && activeTab.equals(tagTab))
		{
			return;
		}

		if (activeTab != null)
		{
			Widget tab = activeTab.getBackground();
			tab.setSpriteId(TabSprites.TAB_BACKGROUND.getSpriteId());
			tab.revalidate();
			activeTab = null;
		}

		if (tagTab != null)
		{
			Widget tab = tagTab.getBackground();
			tab.setSpriteId(TabSprites.TAB_BACKGROUND_ACTIVE.getSpriteId());
			tab.revalidate();
			activeTab = tagTab;
		}
	}

	private void updateBounds()
	{
		Widget itemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		if (itemContainer == null)
		{
			return;
		}

		int height = itemContainer.getHeight();

		// If player isn't using normal bank tabs
		if (itemContainer.getRelativeY() == 0)
		{
			height -= (TAB_HEIGHT + MARGIN);
		}

		bounds.setSize(TAB_WIDTH + MARGIN * 2, height);
		bounds.setLocation(MARGIN, TAB_HEIGHT + MARGIN);

		Widget incinerator = client.getWidget(WidgetInfo.BANK_INCINERATOR);

		if (incinerator != null && !incinerator.isHidden())
		{
			// This is the required way to move incinerator, don't change it!
			incinerator.setOriginalHeight(39);
			incinerator.setOriginalWidth(48);
			incinerator.setRelativeY(itemContainer.getHeight());
			incinerator.revalidate();

			Widget child = incinerator.getDynamicChildren()[0];
			child.setHeight(39);
			child.setWidth(48);
			child.setType(WidgetType.GRAPHIC);
			child.setSpriteId(TabSprites.INCINERATOR.getSpriteId());

			bounds.setSize(TAB_WIDTH + MARGIN * 2, height - incinerator.getHeight());
		}

		if (upButton != null)
		{
			Point p = upButton.getCanvasLocation();
			canvasBounds.setBounds(p.getX(), p.getY() + BUTTON_HEIGHT, bounds.width, maxTabs * TAB_HEIGHT + maxTabs * MARGIN);
		}
	}

	private void updateTabs()
	{
		int y = bounds.y + MARGIN + BUTTON_HEIGHT;

		if (maxTabs >= tabManager.size())
		{
			currentTabIndex = 0;
		}
		else
		{
			y -= (currentTabIndex * TAB_HEIGHT + currentTabIndex * MARGIN);
		}

		for (TagTab tab : tabManager.getTabs())
		{
			updateWidget(tab.getBackground(), y);
			updateWidget(tab.getIcon(), y + 4);

			// Edge case where item icon is 1 pixel out of bounds
			tab.getIcon().setHidden(tab.getBackground().isHidden());

			// Keep item widget shown while drag scrolling
			if (client.getDraggedWidget() == tab.getIcon())
			{
				tab.getIcon().setHidden(false);
			}

			y += TAB_HEIGHT + MARGIN;
		}

		boolean hidden = !(tabManager.size() > 0);

		upButton.setHidden(hidden);
		upButton.setOriginalY(bounds.y);
		upButton.revalidate();

		downButton.setHidden(hidden);
		downButton.setOriginalY(bounds.y + maxTabs * TAB_HEIGHT + MARGIN * maxTabs + BUTTON_HEIGHT + MARGIN);
		downButton.revalidate();
	}

	private Widget createGraphic(String name, int spriteId, int itemId, int width, int height, int x, int y, boolean hasListener)
	{
		Widget widget = parent.createChild(-1, WidgetType.GRAPHIC);
		widget.setOriginalWidth(width);
		widget.setOriginalHeight(height);
		widget.setOriginalX(x);
		widget.setOriginalY(y);

		widget.setSpriteId(spriteId);

		if (itemId > -1)
		{
			widget.setItemId(itemId);
			widget.setItemQuantity(-1);
			widget.setBorderType(1);
		}

		if (hasListener)
		{
			widget.setOnOpListener(ScriptID.NULL);
			widget.setHasListener(true);
		}

		widget.setName(name);
		widget.revalidate();

		return widget;
	}

	private void updateWidget(Widget t, int y)
	{
		t.setOriginalY(y);
		t.setRelativeY(y);
		t.setHidden(y < (bounds.y + BUTTON_HEIGHT + MARGIN) || y > (bounds.y + bounds.height - TAB_HEIGHT - MARGIN - BUTTON_HEIGHT));
		t.revalidate();
	}

	private void doSearch(InputType inputType, String search)
	{
		// In case the widget ids array is incorrect, do not proceed
		if (widgetIds == null || widgetIds.length < 21)
		{
			return;
		}

		clientThread.invokeLater(() ->
		{
			// This ensures that any chatbox input (e.g from search) will not remain visible when
			// selecting/changing tab
			client.runScript(ScriptID.CLOSE_CHATBOX_INPUT);

			client.setVar(VarClientInt.INPUT_TYPE, inputType.getType());
			client.setVar(VarClientStr.INPUT_TEXT, search);

			client.runScript(ScriptID.BANK_LAYOUT,
				WidgetInfo.BANK_CONTAINER.getId(),
				widgetIds[INNER_CONTAINER_IDX],
				widgetIds[SETTINGS_IDX],
				widgetIds[ITEM_CONTAINER_IDX],
				widgetIds[SCROLLBAR_IDX],
				widgetIds[BOTTOM_BAR_IDX],
				widgetIds[TITLE_BAR_IDX],
				widgetIds[ITEM_COUNT_IDX],
				widgetIds[SEARCH_BUTTON_BACKGROUND_IDX],
				widgetIds[TAB_BAR_IDX],
				widgetIds[INCINERATOR_IDX],
				widgetIds[INCINERATOR_CONFIRM_IDX],
				widgetIds[HIDDEN_WIDGET_IDX]);
		});
	}

	private ItemComposition getItem(int idx)
	{
		ItemContainer bankContainer = client.getItemContainer(InventoryID.BANK);
		Item item = bankContainer.getItems()[idx];
		return itemManager.getItemComposition(item.getId());
	}

	private void openTag(String tag)
	{
		doSearch(InputType.SEARCH, tag);
		activateTab(tabManager.find(tag.substring(4)));

		// When tab is selected with search window open, the search window closes but the search button
		// stays highlighted, this solves that issue
		Widget searchBackground = client.getWidget(WidgetInfo.BANK_SEARCH_BUTTON_BACKGROUND);
		searchBackground.setSpriteId(SpriteID.EQUIPMENT_SLOT_TILE);
	}
}
