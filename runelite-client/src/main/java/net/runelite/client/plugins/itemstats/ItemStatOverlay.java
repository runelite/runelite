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

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

public class ItemStatOverlay extends Overlay
{
	// Unarmed attack speed is 6
	private static final ItemStats UNARMED = new ItemStats(false, true, 0,
		ItemEquipmentStats.builder()
			.aspeed(6)
			.build());

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TooltipManager tooltipManager;

	@Inject
	private ItemStatChanges statChanges;

	@Inject
	private ItemStatConfig config;

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.isMenuOpen() || (!config.relative() && !config.absolute() && !config.theoretical()))
		{
			return null;
		}

		final MenuEntry[] menu = client.getMenuEntries();
		final int menuSize = menu.length;

		if (menuSize <= 0)
		{
			return null;
		}

		final MenuEntry entry = menu[menuSize - 1];
		final int group = WidgetInfo.TO_GROUP(entry.getParam1());
		final int child = WidgetInfo.TO_CHILD(entry.getParam1());
		final Widget widget = client.getWidget(group, child);

		if (widget == null || (group != WidgetInfo.INVENTORY.getGroupId() &&
			group != WidgetInfo.EQUIPMENT.getGroupId() &&
			group != WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER.getGroupId()))
		{
			return null;
		}

		int itemId = entry.getIdentifier();

		if (group == WidgetInfo.EQUIPMENT.getGroupId())
		{
			final Widget widgetItem = widget.getChild(1);
			if (widgetItem != null)
			{
				itemId = widgetItem.getItemId();
			}
		}
		else if (group == WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER.getGroupId())
		{
			final Widget widgetItem = widget.getChild(entry.getParam0());
			if (widgetItem != null)
			{
				itemId = widgetItem.getItemId();
			}
		}

		if (config.consumableStats())
		{
			final Effect change = statChanges.get(itemId);
			if (change != null)
			{
				final StringBuilder b = new StringBuilder();
				final StatsChanges statsChanges = change.calculate(client);

				for (final StatChange c : statsChanges.getStatChanges())
				{
					b.append(buildStatChangeString(c));
				}

				final String tooltip = b.toString();

				if (!tooltip.isEmpty())
				{
					tooltipManager.add(new Tooltip(tooltip));
				}
			}
		}

		if (config.equipmentStats())
		{
			final ItemStats stats = itemManager.getItemStats(itemId, false);

			if (stats != null)
			{
				final String tooltip = buildStatBonusString(stats);

				if (!tooltip.isEmpty())
				{
					tooltipManager.add(new Tooltip(tooltip));
				}
			}
		}

		return null;
	}

	private String getChangeString(
		final String label,
		final double value,
		final boolean inverse,
		final boolean showPercent)
	{
		final Color plus = Positivity.getColor(config, Positivity.BETTER_UNCAPPED);
		final Color minus = Positivity.getColor(config, Positivity.WORSE);

		if (value == 0)
		{
			return "";
		}

		final Color color;

		if (inverse)
		{
			color = value > 0 ? minus : plus;
		}
		else
		{
			color = value > 0 ? plus : minus;
		}

		final String prefix = value > 0 ? "+" : "";
		final String suffix = showPercent ? "%" : "";
		final String valueString = (int)value == value ? String.valueOf((int)value) : String.valueOf(value);
		return label + ": " + ColorUtil.wrapWithColorTag(prefix + valueString + suffix, color) + "</br>";
	}

	private String buildStatBonusString(ItemStats s)
	{
		final StringBuilder b = new StringBuilder();
		b.append(getChangeString("Weight", s.getWeight(), true, false));

		ItemStats other = null;
		final ItemEquipmentStats currentEquipment = s.getEquipment();

		ItemContainer c = client.getItemContainer(InventoryID.EQUIPMENT);
		if (s.isEquipable() && currentEquipment != null && c != null)
		{
			final Item[] items = c.getItems();
			final int slot = currentEquipment.getSlot();

			if (slot != -1 && slot < items.length)
			{
				final Item item = items[slot];
				if (item != null)
				{
					other = itemManager.getItemStats(item.getId(), false);
				}
			}

			if (other == null && slot == EquipmentInventorySlot.WEAPON.getSlotIdx())
			{
				// Unarmed
				other = UNARMED;
			}
		}

		final ItemStats subtracted = s.subtract(other);
		final ItemEquipmentStats e = subtracted.getEquipment();

		if (subtracted.isEquipable() && e != null)
		{
			b.append(getChangeString("Prayer", e.getPrayer(), false, false));
			b.append(getChangeString("Speed", e.getAspeed(), true, false));
			b.append(getChangeString("Melee Str", e.getStr(), false, false));
			b.append(getChangeString("Range Str", e.getRstr(), false, false));
			b.append(getChangeString("Magic Dmg", e.getMdmg(), false, true));

			if (e.getAstab() != 0 || e.getAslash() != 0 || e.getAcrush() != 0 || e.getAmagic() != 0 || e.getArange() != 0)
			{
				b.append(ColorUtil.wrapWithColorTag("Attack Bonus</br>", JagexColors.MENU_TARGET));
				b.append(getChangeString("Stab", e.getAstab(), false, false));
				b.append(getChangeString("Slash", e.getAslash(), false, false));
				b.append(getChangeString("Crush", e.getAcrush(), false, false));
				b.append(getChangeString("Magic", e.getAmagic(), false, false));
				b.append(getChangeString("Range", e.getArange(), false, false));
			}

			if (e.getDstab() != 0 || e.getDslash() != 0 || e.getDcrush() != 0 || e.getDmagic() != 0 || e.getDrange() != 0)
			{
				b.append(ColorUtil.wrapWithColorTag("Defence Bonus</br>", JagexColors.MENU_TARGET));
				b.append(getChangeString("Stab", e.getDstab(), false, false));
				b.append(getChangeString("Slash", e.getDslash(), false, false));
				b.append(getChangeString("Crush", e.getDcrush(), false, false));
				b.append(getChangeString("Magic", e.getDmagic(), false, false));
				b.append(getChangeString("Range", e.getDrange(), false, false));
			}
		}

		return b.toString();
	}

	private String buildStatChangeString(StatChange c)
	{
		StringBuilder b = new StringBuilder();
		b.append(ColorUtil.colorTag(Positivity.getColor(config, c.getPositivity())));

		if (config.relative())
		{
			b.append(c.getFormattedRelative());
		}

		if (config.theoretical())
		{
			if (config.relative())
			{
				b.append("/");
			}
			b.append(c.getFormattedTheoretical());
		}

		if (config.absolute() && (config.relative() || config.theoretical()))
		{
			b.append(" (");
		}
		if (config.absolute())
		{
			b.append(c.getAbsolute());
		}

		if (config.absolute() && (config.relative() || config.theoretical()))
		{
			b.append(")");
		}
		b.append(" ").append(c.getStat().getName());
		b.append("</br>");

		return b.toString();
	}
}
