/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2020 MMagicala
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

public class ItemStatOverlay extends Overlay
{
	// Unarmed attack speed is 4
	@VisibleForTesting
	static final ItemStats UNARMED = new ItemStats(false, true, 0, 0,
		ItemEquipmentStats.builder()
			.aspeed(4)
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

	private enum Potion
	{
		ANTIPOISON(90, ItemID.ANTIPOISON4, ItemID.ANTIPOISON3, ItemID.ANTIPOISON2, ItemID.ANTIPOISON1),
		SUPERANTIPOISON(720, ItemID.SUPERANTIPOISON4, ItemID.SUPERANTIPOISON3, ItemID.SUPERANTIPOISON2, ItemID.SUPERANTIPOISON1),
		ANTIDOTE_P(540, ItemID.ANTIDOTE4, ItemID.ANTIDOTE3, ItemID.ANTIDOTE2, ItemID.ANTIDOTE1),
		ANTIDOTE_PP(720, ItemID.ANTIDOTE4_5952, ItemID.ANTIDOTE3_5954, ItemID.ANTIDOTE2_5956, ItemID.ANTIDOTE1_5958),
		ANTIVENOM(new PotionDurationRange[]{
			new PotionDurationRange("Anti-poison", 720, 720),
			new PotionDurationRange("Anti-venom", 18, 36)},
			ItemID.ANTIVENOM4, ItemID.ANTIVENOM3, ItemID.ANTIVENOM2, ItemID.ANTIVENOM1),
		ANTIVENOM_P(new PotionDurationRange[]{
			new PotionDurationRange("Anti-poison", 900, 900),
			new PotionDurationRange("Anti-venom", 180, 180)},
			ItemID.ANTIVENOM4_12913, ItemID.ANTIVENOM3_12915, ItemID.ANTIVENOM2_12917, ItemID.ANTIVENOM1_12919),
		ANTIFIRE(360, ItemID.ANTIFIRE_POTION4, ItemID.ANTIFIRE_POTION3, ItemID.ANTIFIRE_POTION2, ItemID.ANTIFIRE_POTION1),
		EXTENDED_ANTIFIRE(720, ItemID.EXTENDED_ANTIFIRE4, ItemID.EXTENDED_ANTIFIRE3, ItemID.EXTENDED_ANTIFIRE2, ItemID.EXTENDED_ANTIFIRE1),
		SUPER_ANTIFIRE(180, ItemID.SUPER_ANTIFIRE_POTION4, ItemID.SUPER_ANTIFIRE_POTION3, ItemID.SUPER_ANTIFIRE_POTION2, ItemID.SUPER_ANTIFIRE_POTION1),
		EXTENDED_SUPER_ANTIFIRE(360, ItemID.EXTENDED_SUPER_ANTIFIRE4, ItemID.EXTENDED_SUPER_ANTIFIRE3, ItemID.EXTENDED_SUPER_ANTIFIRE2, ItemID.EXTENDED_SUPER_ANTIFIRE1);

		PotionDurationRange[] durationRanges;

		final int[] itemIds;

		Potion(int duration, int... itemIds)
		{
			PotionDurationRange[] ranges = new PotionDurationRange[1];
			// Only need the duration, not the potion name or a range
			ranges[0] = new PotionDurationRange("", duration, duration);
			this.durationRanges = ranges;

			this.itemIds = itemIds;
		}

		Potion(PotionDurationRange[] durationRanges, int... itemIds)
		{
			this.durationRanges = durationRanges;
			this.itemIds = itemIds;
		}

		private static final Map<Integer, Potion> potions;

		static
		{
			ImmutableMap.Builder<Integer, Potion> builder = new ImmutableMap.Builder<>();

			for (Potion potion : values())
			{
				for (int id : potion.itemIds)
				{
					builder.put(id, potion);
				}
			}

			potions = builder.build();
		}

		static Potion get(int id)
		{
			return potions.get(id);
		}
	}

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

		if (widget == null
			|| !(group == WidgetInfo.INVENTORY.getGroupId()
			|| group == WidgetInfo.EQUIPMENT.getGroupId()
			|| group == WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER.getGroupId()
			|| (config.showStatsInBank()
			&& ((group == WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() && child == WidgetInfo.BANK_ITEM_CONTAINER.getChildId())
			|| group == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId()))))
		{
			return null;
		}

		int itemId = entry.getIdentifier();

		if (group == WidgetInfo.EQUIPMENT.getGroupId() ||
			// For bank worn equipment, check widget parent to differentiate from normal bank items
			(group == WidgetID.BANK_GROUP_ID && widget.getParentId() == WidgetInfo.BANK_EQUIPMENT_CONTAINER.getId()))
		{
			final Widget widgetItem = widget.getChild(1);
			if (widgetItem != null)
			{
				itemId = widgetItem.getItemId();
			}
		}
		else if (group == WidgetInfo.EQUIPMENT_INVENTORY_ITEMS_CONTAINER.getGroupId()
			|| group == WidgetInfo.BANK_ITEM_CONTAINER.getGroupId()
			|| group == WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId())
		{
			int index = entry.getParam0();
			if (index > -1)
			{
				final Widget widgetItem = widget.getChild(index);
				if (widgetItem != null)
				{
					itemId = widgetItem.getItemId();
				}
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

			Potion p = Potion.get(itemId);

			if (p != null)
			{
				if (p.durationRanges.length == 1)
				{
					// Only show "Duration: <time>" if there is one tooltip
					final String durationToolTip = buildDurationString(p.durationRanges[0].lowestDuration);
					tooltipManager.add(new Tooltip(durationToolTip));
				}
				else
				{
					// List the effect names and their duration (ranges)
					for (PotionDurationRange durationRange : p.durationRanges)
					{
						final String durationToolTip = buildDurationString(durationRange);
						tooltipManager.add(new Tooltip(durationToolTip));
					}
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
		final String valueString = QuantityFormatter.formatNumber(value);
		return ColorUtil.wrapWithColorTag(prefix + valueString + suffix, color);
	}

	private String buildStatRow(
		final String label,
		final double value,
		final double diffValue,
		final boolean inverse,
		final boolean showPercent)
	{
		return buildStatRow(label, value, diffValue, inverse, showPercent, true);
	}

	private String buildStatRow(
		final String label,
		final double value,
		final double diffValue,
		final boolean inverse,
		final boolean showPercent,
		final boolean showBase)
	{
		final StringBuilder b = new StringBuilder();

		if (value != 0 || diffValue != 0)
		{
			final String changeStr = getChangeString(diffValue, inverse, showPercent);

			if (config.alwaysShowBaseStats() && showBase)
			{
				final String valueStr = QuantityFormatter.formatNumber(value);
				b.append(label).append(": ").append(valueStr).append((!changeStr.isEmpty() ? " (" + changeStr + ") " : "")).append("</br>");
			}
			else if (!changeStr.isEmpty())
			{
				b.append(label).append(": ").append(changeStr).append("</br>");
			}
		}

		return b.toString();
	}

	@VisibleForTesting
	String buildStatBonusString(ItemStats s)
	{
		ItemStats other = null;
		final ItemEquipmentStats currentEquipment = s.getEquipment();

		ItemContainer c = client.getItemContainer(InventoryID.EQUIPMENT);
		if (s.isEquipable() && currentEquipment != null && c != null)
		{
			final int slot = currentEquipment.getSlot();

			final Item item = c.getItem(slot);
			if (item != null)
			{
				other = itemManager.getItemStats(item.getId(), false);
			}

			if (other == null && slot == EquipmentInventorySlot.WEAPON.getSlotIdx())
			{
				// Unarmed
				other = UNARMED;
			}
		}

		final ItemStats subtracted = s.subtract(other);
		final ItemEquipmentStats e = subtracted.getEquipment();

		final StringBuilder b = new StringBuilder();

		if (config.showWeight())
		{
			double sw = config.alwaysShowBaseStats() ? subtracted.getWeight() : s.getWeight();
			b.append(buildStatRow("Weight", s.getWeight(), sw, true, false, s.isEquipable()));
		}

		if (subtracted.isEquipable() && e != null)
		{
			b.append(buildStatRow("Prayer", currentEquipment.getPrayer(), e.getPrayer(), false, false));
			b.append(buildStatRow("Speed", currentEquipment.getAspeed(), e.getAspeed(), true, false));
			b.append(buildStatRow("Melee Str", currentEquipment.getStr(), e.getStr(), false, false));
			b.append(buildStatRow("Range Str", currentEquipment.getRstr(), e.getRstr(), false, false));
			b.append(buildStatRow("Magic Dmg", currentEquipment.getMdmg(), e.getMdmg(), false, true));

			final StringBuilder abb = new StringBuilder();
			abb.append(buildStatRow("Stab", currentEquipment.getAstab(), e.getAstab(), false, false));
			abb.append(buildStatRow("Slash", currentEquipment.getAslash(), e.getAslash(), false, false));
			abb.append(buildStatRow("Crush", currentEquipment.getAcrush(), e.getAcrush(), false, false));
			abb.append(buildStatRow("Magic", currentEquipment.getAmagic(), e.getAmagic(), false, false));
			abb.append(buildStatRow("Range", currentEquipment.getArange(), e.getArange(), false, false));

			if (abb.length() > 0)
			{
				b.append(ColorUtil.wrapWithColorTag("Attack Bonus</br>", JagexColors.MENU_TARGET)).append(abb);
			}

			final StringBuilder dbb = new StringBuilder();
			dbb.append(buildStatRow("Stab", currentEquipment.getDstab(), e.getDstab(), false, false));
			dbb.append(buildStatRow("Slash", currentEquipment.getDslash(), e.getDslash(), false, false));
			dbb.append(buildStatRow("Crush", currentEquipment.getDcrush(), e.getDcrush(), false, false));
			dbb.append(buildStatRow("Magic", currentEquipment.getDmagic(), e.getDmagic(), false, false));
			dbb.append(buildStatRow("Range", currentEquipment.getDrange(), e.getDrange(), false, false));

			if (dbb.length() > 0)
			{
				b.append(ColorUtil.wrapWithColorTag("Defence Bonus</br>", JagexColors.MENU_TARGET)).append(dbb);
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

	private String buildDurationString(PotionDurationRange durationRange)
	{
		StringBuilder b = new StringBuilder();

		b.append(durationRange.getPotionName());
		b.append(": ");

		int lowestDuration = durationRange.getLowestDuration();
		b.append(buildFormattedDurationString(lowestDuration));

		int highestDuration = durationRange.getHighestDuration();

		if (lowestDuration != highestDuration)
		{
			b.append("~");
			b.append(buildFormattedDurationString(highestDuration));
		}

		return b.toString();
	}

	private String buildDurationString(int duration)
	{
		return "Duration: " + buildFormattedDurationString(duration);
	}

	private String buildFormattedDurationString(int duration)
	{
		StringBuilder b = new StringBuilder();

		int minutes = duration / 60;
		int seconds = duration % 60;
		b.append(minutes);
		b.append(":");

		if (seconds < 10)
		{
			b.append("0");
		}
		b.append(seconds);

		return b.toString();
	}
}
