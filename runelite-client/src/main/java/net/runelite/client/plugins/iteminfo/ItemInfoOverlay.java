/*
 * Copyright (c) 2018 Ben Dol <dolb90@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.iteminfo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemInfoManager;
import net.runelite.http.api.osrsbox.ItemNotFoundException;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.Text;
import net.runelite.http.api.item.ItemBonus;
import net.runelite.http.api.item.ItemInfo;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ben Dol
 */
@Slf4j
public class ItemInfoOverlay extends Overlay
{
	private static final String LOADING_MSG = "Loading information...";

	private static final List<Integer> blacklisted = new ArrayList<>();
	static
	{
		blacklisted.add(ItemID.COINS_995); // Coins
	}

	@Inject
	private Client client;

	@Inject
	private TooltipManager tooltipManager;

	@Inject
	private ItemInfoManager itemInfoManager;

	@Inject
	private ItemInfoConfig config;

	@Getter
	@Setter
	private boolean active;

	@Getter
	private Tooltip tooltip = new Tooltip("");

	@Setter
	private Widget grandExchangeItem;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen())
		{
			return null;
		}
		else if (!active && config.useHotkeyToShow())
		{
			return null;
		}

		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;

		if (menuSize <= 0)
		{
			return null;
		}

		final MenuEntry menuEntry = menu[menuSize - 1];
		applyItem(menuEntry);
		return null;
	}

	public void applyItem(MenuEntry menuEntry)
	{
		int widgetId = menuEntry.getParam1();
		MenuAction action = MenuAction.of(menuEntry.getType());

		if (isGrandExchange()
			&& widgetId == WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER.getId()
			&& menuEntry.getOption().equals("Choose item"))
		{
			applyItem(grandExchangeItem.getItemId());
		}
		else if (isInventory(action, widgetId) || isEquipment(widgetId)
			|| (config.enableOnFloorItems() && isGround(action))
			|| (config.enableOnBankItems() && isBank(widgetId)))
		{
			int id = menuEntry.getIdentifier();
			if (id > 0 && !hasInvalidIdentifier(widgetId))
			{
				applyItem(id);
			}
			else
			{
				String target = Text.removeTags(menuEntry.getTarget());
				if (!target.isEmpty())
				{
					applyItem(target);
				}
			}
		}
	}

	public void applyItem(String itemName)
	{
		try
		{
			if (!itemInfoManager.isUnsuitableSearchTerm(itemName))
			{
				setItemInfo(itemInfoManager.lookupAsync(itemName));
			}
			else
			{
				clearTooltip();
			}
		}
		catch (ItemNotFoundException ex)
		{
			log.error("Could not find item:", ex);
		}
	}

	public void applyItem(int itemId)
	{
		try
		{
			setItemInfo(itemInfoManager.lookupAsync(itemId));
		}
		catch (ItemNotFoundException ex)
		{
			log.error("Could not find item:", ex);
		}
	}

	private void setItemInfo(ItemInfo itemInfo)
	{
		if (itemInfo != null)
		{
			if (isBlacklisted(itemInfo.getId()))
			{
				clearTooltip();
			}
			else
			{
				tooltip.setText(buildItemInfoString(itemInfo));
			}
		}
		else if (itemInfoManager.isLoading())
		{
			tooltip.setText(LOADING_MSG);
		}

		if (!tooltip.getText().isEmpty() && !tooltipManager.getTooltips().contains(tooltip))
		{
			tooltipManager.add(tooltip);
		}
	}

	public void clearTooltip()
	{
		tooltip.setText("");
		tooltipManager.remove(tooltip);
	}

	private String buildItemInfoString(ItemInfo item)
	{
		StringBuilder b = new StringBuilder();

		if (config.showDescription())
		{
			b.append(" ").append(item.getExamine());
			b.append("</br>");
		}
		if (config.showWeight())
		{
			b.append(" Weight: ").append(item.getWeight());
			b.append("</br>");
		}
		if (config.showCost())
		{
			b.append(" Cost: ").append(item.getCost()).append("gp");
			b.append("</br>");
		}
		if (item.getBuy_limit() > 0 && config.showBuyLimit())
		{
			b.append(" Buy Limit: ").append(item.getBuy_limit());
			b.append("</br>");
		}

		if (config.showAlchemyInfo() && (item.getLowalch() > 0 || item.getHighalch() > 0))
		{
			b.append(" Low Alch: ").append(item.getLowalch()).append("gp");
			b.append("</br>");
			b.append(" High Alch: ").append(item.getHighalch()).append("gp");
			b.append("</br>");
		}

		if (config.showIsMemberOrFreeToPlay())
		{
			if (item.isMembers())
			{
				b.append(" Members Only");
			}
			else
			{
				b.append(" Free To Play");
			}
			b.append("</br>");
		}

		if (!item.isTradeable() && config.showIsTradable())
		{
			b.append(" Not Tradeable");
			b.append("</br>");
		}

		if (item.isQuest_item() && config.showIsQuestItem())
		{
			b.append(" Quest Item");
			b.append("</br>");
		}

		if (!item.isNoteable() && config.showIsNoteable())
		{
			b.append(" Not Noteable");
			b.append("</br>");
		}

		b.append("</br>");

		if (config.showBonuses())
		{
			Map<ItemBonus, Integer> bonuses = item.getBonuses();
			if (bonuses != null && !bonuses.isEmpty())
			{
				b.append(" Bonuses:</br>");

				for (Map.Entry<ItemBonus, Integer> entry : bonuses.entrySet())
				{
					Integer bonus = entry.getValue();
					if (config.showEmptyBonuses() || bonus != 0)
					{
						b.append("   ").append(entry.getKey().getTitle()).append(": ").append(bonus)
							.append("</br>");
					}
				}
			}
		}

		// avoid ever being empty, they can simply disable the plugin
		if (b.toString().equals("</br>"))
		{
			b = new StringBuilder();
			b.append(" ").append(item.getExamine());
			b.append("</br>");
		}
		return b.toString();
	}

	public boolean isShowing()
	{
		return !tooltip.getText().isEmpty()
			&& !tooltip.getText().equals(LOADING_MSG)
			&& tooltipManager.getTooltips().contains(tooltip);
	}

	private boolean isGround(MenuAction action)
	{
		switch (action)
		{
			case GROUND_ITEM_FIRST_OPTION:
			case GROUND_ITEM_SECOND_OPTION:
			case GROUND_ITEM_THIRD_OPTION:
			case GROUND_ITEM_FOURTH_OPTION:
			case GROUND_ITEM_FIFTH_OPTION:
			case EXAMINE_ITEM_GROUND:
				return true;
		}
		return false;
	}

	private boolean isInventory(MenuAction action, int widgetId)
	{
		switch (action)
		{
			case ITEM_FIRST_OPTION:
			case ITEM_SECOND_OPTION:
			case ITEM_THIRD_OPTION:
			case ITEM_FOURTH_OPTION:
			case ITEM_FIFTH_OPTION:
			case ITEM_DROP:
			case ITEM_USE:
			case EXAMINE_ITEM:
			case EXAMINE_ITEM_BANK_EQ:
				return true;
		}
		return widgetId == WidgetInfo.GRAND_EXCHANGE_INVENTORY_ITEMS_CONTAINER.getId()
			|| widgetId == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getId();
	}

	private boolean isEquipment(int widgetId)
	{
		return widgetId == WidgetInfo.EQUIPMENT.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_WEAPON.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_SHIELD.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_RING.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_LEGS.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_HELMET.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_GLOVES.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_CAPE.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_BOOTS.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_BODY.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_AMULET.getId()
			|| widgetId == WidgetInfo.EQUIPMENT_AMMO.getId();
	}

	private boolean isBank(int widgetId)
	{
		return widgetId == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			|| widgetId == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getId();
	}

	private boolean isGrandExchange()
	{
		return grandExchangeItem != null;
	}

	private boolean hasInvalidIdentifier(int widgetId)
	{
		return widgetId == WidgetInfo.GRAND_EXCHANGE_INVENTORY_ITEMS_CONTAINER.getId()
			|| isBank(widgetId)
			|| isEquipment(widgetId);
	}

	private static boolean isBlacklisted(int id)
	{
		return blacklisted.contains(id);
	}
}
