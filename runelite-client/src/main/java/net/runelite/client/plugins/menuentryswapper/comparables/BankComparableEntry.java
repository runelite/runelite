package net.runelite.client.plugins.menuentryswapper.comparables;

import lombok.EqualsAndHashCode;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.AbstractComparableEntry;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
public class BankComparableEntry extends AbstractComparableEntry
{
	public BankComparableEntry(String option, String itemName, boolean strictTarget)
	{
		this.setOption(option);
		this.setTarget(Text.standardize(itemName));
		this.setStrictTarget(strictTarget);
	}

	public boolean matches(MenuEntry entry)
	{
		if (isNotBankWidget(entry.getParam1()))
		{
			return false;
		}

		if (isStrictTarget() && !Text.standardize(entry.getTarget()).equals(this.getTarget()))
		{
			return false;
		}

		return StringUtils.containsIgnoreCase(entry.getOption(), this.getOption()) && Text.standardize(entry.getTarget()).contains(this.getTarget());
	}

	static boolean isNotBankWidget(int widgetID)
	{
		final int groupId = WidgetInfo.TO_GROUP(widgetID);

		return groupId != WidgetID.BANK_GROUP_ID
			&& groupId != WidgetID.BANK_INVENTORY_GROUP_ID
			&& groupId != WidgetID.GRAND_EXCHANGE_GROUP_ID;
	}
}
