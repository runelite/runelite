/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.itemstats;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.FontMetrics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.FontID;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

@PluginDescriptor(
	name = "Item Stats",
	description = "Show information about food and potion effects",
	tags = {"food", "inventory", "overlay", "potion"}
)
public class ItemStatPlugin extends Plugin
{
	private static final int ORANGE_TEXT = JagexColors.DARK_ORANGE_INTERFACE_TEXT.getRGB();
	private static final int YELLOW_TEXT = JagexColors.YELLOW_INTERFACE_TEXT.getRGB();
	private static final int TEXT_HEIGHT = 11;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemStatOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ItemStatConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	private Widget itemInformationTitle;

	@Getter(AccessLevel.PACKAGE)
	private boolean consumableStats;
	@Getter(AccessLevel.PACKAGE)
	private boolean equipmentStats;
	private boolean geStats;
	@Getter(AccessLevel.PACKAGE)
	private boolean relative;
	@Getter(AccessLevel.PACKAGE)
	private boolean absolute;
	@Getter(AccessLevel.PACKAGE)
	private boolean theoretical;
	@Getter(AccessLevel.PACKAGE)
	private boolean showWeight;
	@Getter(AccessLevel.PACKAGE)
	private Color colorBetterUncapped;
	@Getter(AccessLevel.PACKAGE)
	private Color colorBetterSomeCapped;
	@Getter(AccessLevel.PACKAGE)
	private Color colorBetterCapped;
	@Getter(AccessLevel.PACKAGE)
	private Color colorNoChange;
	@Getter(AccessLevel.PACKAGE)
	private Color colorWorse;

	@Provides
	ItemStatConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemStatConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ItemStatChangesService.class).to(ItemStatChangesServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		clientThread.invokeLater(this::resetGEInventory);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("geStats"))
		{
			updateConfig();
			clientThread.invokeLater(this::resetGEInventory);
		}
	}

	private void onGameTick(GameTick event)
	{
		if (itemInformationTitle != null && this.geStats
			&& (client.getWidget(WidgetInfo.GRAND_EXCHANGE_WINDOW_CONTAINER) == null
			|| client.getWidget(WidgetInfo.GRAND_EXCHANGE_WINDOW_CONTAINER).isHidden()))
		{
			resetGEInventory();
		}
	}


	private void onVarbitChanged(VarbitChanged event)
	{
		if (client.getVar(VarPlayer.CURRENT_GE_ITEM) == -1 && this.geStats)
		{
			resetGEInventory();
		}
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (event.getEventName().equals("geBuilt") && this.geStats)
		{
			int currentGeItem = client.getVar(VarPlayer.CURRENT_GE_ITEM);
			if (currentGeItem != -1 && client.getVar(Varbits.GE_OFFER_CREATION_TYPE) == 0)
			{
				createItemInformation(currentGeItem);
			}
		}
	}

	private void createItemInformation(int id)
	{
		final ItemStats itemStats = itemManager.getItemStats(id, false);

		if (itemStats == null || !itemStats.isEquipable())
		{
			return;
		}

		final ItemEquipmentStats equipmentStats = itemStats.getEquipment();

		if (equipmentStats == null)
		{
			return;
		}

		final Widget geInv = client.getWidget(WidgetInfo.GRAND_EXCHANGE_INVENTORY_ITEMS_CONTAINER);

		if (geInv == null)
		{
			return;
		}

		final Widget invContainer = getInventoryContainer();

		if (invContainer == null)
		{
			return;
		}

		invContainer.deleteAllChildren();
		geInv.setHidden(true);

		int yPos = 0;

		final FontMetrics smallFM = client.getCanvas().getFontMetrics(FontManager.getRunescapeSmallFont());

		// HEADER

		itemInformationTitle = createText(invContainer, "Item Information", FontID.BOLD_12, ORANGE_TEXT,
			8, 8, invContainer.getWidth(), 16);
		itemInformationTitle.setYTextAlignment(WidgetTextAlignment.CENTER);

		Widget closeButton = invContainer.createChild(-1, WidgetType.GRAPHIC);
		closeButton.setOriginalY(8);
		closeButton.setOriginalX(invContainer.getWidth() - 24);
		closeButton.setOriginalHeight(16);
		closeButton.setOriginalWidth(16);
		closeButton.setSpriteId(SpriteID.BOTTOM_LINE_MODE_WINDOW_CLOSE_BUTTON_SMALL);
		closeButton.setAction(0, "Close");
		closeButton.setOnMouseOverListener((JavaScriptCallback) (ev) ->
			closeButton.setSpriteId(SpriteID.BOTTOM_LINE_MODE_WINDOW_CLOSE_BUTTON_SMALL_HOVERED));
		closeButton.setOnMouseLeaveListener((JavaScriptCallback) (ev) ->
			closeButton.setSpriteId(SpriteID.BOTTOM_LINE_MODE_WINDOW_CLOSE_BUTTON_SMALL));
		closeButton.setOnOpListener((JavaScriptCallback) (ev) -> resetGEInventory());
		closeButton.setHasListener(true);
		closeButton.revalidate();

		yPos += 15;

		createSeparator(invContainer, yPos);

		// ICON AND TITLE

		yPos += 25;

		Widget icon = invContainer.createChild(-1, WidgetType.GRAPHIC);
		icon.setOriginalX(8);
		icon.setOriginalY(yPos);
		icon.setOriginalWidth(Constants.ITEM_SPRITE_WIDTH);
		icon.setOriginalHeight(Constants.ITEM_SPRITE_HEIGHT);
		icon.setItemId(id);
		icon.setItemQuantityMode(0);
		icon.setBorderType(1);
		icon.revalidate();

		Widget itemName = createText(invContainer, itemManager.getItemDefinition(id).getName(), FontID.PLAIN_12, ORANGE_TEXT,
			50, yPos, invContainer.getWidth() - 40, 30);
		itemName.setYTextAlignment(WidgetTextAlignment.CENTER);

		yPos += 20;

		createSeparator(invContainer, yPos);

		// STATS HEADER

		yPos += 25;

		createText(invContainer, "Attack", FontID.PLAIN_11, ORANGE_TEXT, 5, yPos, 50, -1);

		int defenceXPos = invContainer.getWidth() - (smallFM.stringWidth("Defence") + 5);
		createText(invContainer, "Defence", FontID.PLAIN_11, ORANGE_TEXT, defenceXPos, yPos, 50, -1);

		// STYLE BONUSES

		final Set<String> stats = ImmutableSet.of(
			"Stab",
			"Slash",
			"Crush",
			"Magic",
			"Ranged"
		);

		final List<Integer> attackStats = ImmutableList.of(
			equipmentStats.getAstab(),
			equipmentStats.getAslash(),
			equipmentStats.getAcrush(),
			equipmentStats.getAmagic(),
			equipmentStats.getArange()
		);

		final List<Integer> defenceStats = ImmutableList.of(
			equipmentStats.getDstab(),
			equipmentStats.getDslash(),
			equipmentStats.getDcrush(),
			equipmentStats.getDmagic(),
			equipmentStats.getDrange()
		);

		int index = 0;

		for (final String stat : stats)
		{
			yPos += TEXT_HEIGHT + 2;

			// Style label
			final Widget styleText = createText(invContainer, stat, FontID.PLAIN_11, ORANGE_TEXT,
				0, yPos, invContainer.getWidth(), -1);
			styleText.setXTextAlignment(WidgetTextAlignment.CENTER);

			// Attack bonus
			createText(invContainer, attackStats.get(index).toString(), FontID.PLAIN_11, YELLOW_TEXT,
				5, yPos, 50, -1);

			// Defence bonus
			final int defenceX = invContainer.getWidth() - (smallFM.stringWidth(defenceStats.get(index).toString()) + 5);
			createText(invContainer, defenceStats.get(index).toString(), FontID.PLAIN_11, YELLOW_TEXT,
				defenceX, yPos, 50, -1);

			index++;
		}

		// MISC BONUSES

		yPos += TEXT_HEIGHT + 8;

		final Map<String, Integer> miscStats = ImmutableMap.of(
			"Strength", equipmentStats.getStr(),
			"Ranged Strength", equipmentStats.getRstr(),
			"Magic Damage", equipmentStats.getMdmg(),
			"Prayer Bonus", equipmentStats.getPrayer()
		);

		for (final Map.Entry<String, Integer> miscStat : miscStats.entrySet())
		{
			final String name = miscStat.getKey();
			final String value = miscStat.getValue().toString();

			// Stat label
			createText(invContainer, name, FontID.PLAIN_11, ORANGE_TEXT, 5, yPos, 50, -1);

			// Stat bonus
			int valueXPos = invContainer.getWidth() - (smallFM.stringWidth(value) + 5);
			createText(invContainer, value, FontID.PLAIN_11, YELLOW_TEXT, valueXPos, yPos, 50, -1);

			yPos += TEXT_HEIGHT + 2;
		}

		// COINS

		createSeparator(invContainer, invContainer.getHeight() - 40);

		final String coinText = "You have " + QuantityFormatter.quantityToStackSize(getCurrentGP())
			+ (getCurrentGP() == 1 ? " coin." : " coins.");

		final Widget coinWidget = createText(invContainer, coinText, FontID.PLAIN_12, ORANGE_TEXT,
			0, invContainer.getHeight() - 18, invContainer.getWidth(), -1);

		coinWidget.setXTextAlignment(WidgetTextAlignment.CENTER);
	}

	private static Widget createText(Widget parent, String text, int fontId, int textColor,
									int x, int y, int width, int height)
	{
		final Widget widget = parent.createChild(-1, WidgetType.TEXT);
		widget.setText(text);
		widget.setFontId(fontId);
		widget.setTextColor(textColor);
		widget.setTextShadowed(true);
		widget.setOriginalHeight(height == -1 ? TEXT_HEIGHT : height);
		widget.setOriginalWidth(width);
		widget.setOriginalY(y);
		widget.setOriginalX(x);
		widget.revalidate();
		return widget;
	}

	private static void createSeparator(Widget parent, int y)
	{
		Widget separator = parent.createChild(-1, WidgetType.GRAPHIC);
		separator.setOriginalWidth(parent.getWidth());
		separator.setOriginalY(y);
		separator.setOriginalHeight(32);
		separator.setSpriteId(SpriteID.UNKNOWN_BORDER_EDGE_HORIZONTAL_995);
		separator.revalidate();
	}

	private void resetGEInventory()
	{
		final Widget invContainer = getInventoryContainer();

		if (invContainer == null)
		{
			return;
		}

		if (itemInformationTitle != null && invContainer.getChild(0) == itemInformationTitle)
		{
			invContainer.deleteAllChildren();
			itemInformationTitle = null;
		}

		final Widget geInv = client.getWidget(WidgetInfo.GRAND_EXCHANGE_INVENTORY_ITEMS_CONTAINER);
		if (geInv != null)
		{
			geInv.setHidden(false);
		}
	}

	private int getCurrentGP()
	{
		final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

		if (inventory == null)
		{
			return 0;
		}

		for (final Item item : inventory.getItems())
		{
			if (item.getId() == ItemID.COINS_995)
			{
				return item.getQuantity();
			}
		}

		return 0;
	}

	private Widget getInventoryContainer()
	{
		if (client.isResized())
		{
			if (client.getVar(Varbits.SIDE_PANELS) == 1)
			{
				return client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_CONTAINER);
			}
			else
			{
				return client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_CONTAINER);
			}
		}
		else
		{
			return client.getWidget(WidgetInfo.FIXED_VIEWPORT_INVENTORY_CONTAINER);
		}
	}

	private void updateConfig()
	{
		this.consumableStats = config.consumableStats();
		this.equipmentStats = config.equipmentStats();
		this.geStats = config.geStats();
		this.relative = config.relative();
		this.absolute = config.absolute();
		this.theoretical = config.theoretical();
		this.showWeight = config.showWeight();
		this.colorBetterUncapped = config.colorBetterUncapped();
		this.colorBetterSomeCapped = config.colorBetterSomeCapped();
		this.colorBetterCapped = config.colorBetterCapped();
		this.colorNoChange = config.colorNoChange();
		this.colorWorse = config.colorWorse();
	}
}
