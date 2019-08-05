package net.runelite.client.plugins.menuentryswapper;

import lombok.EqualsAndHashCode;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.AbstractComparableEntry;
import net.runelite.client.util.Text;

@EqualsAndHashCode(callSuper = true)
public class BankComparableEntry extends AbstractComparableEntry
{
	public BankComparableEntry(String option, String itemName)
	{
		this.setOption(Text.standardize(option));
		this.setTarget(Text.standardize(itemName));
	}

	public boolean matches(MenuEntry entry)
	{
		final int groupId = WidgetInfo.TO_GROUP(entry.getParam1());
		if (groupId != WidgetID.BANK_GROUP_ID && groupId != WidgetID.BANK_INVENTORY_GROUP_ID)
		{
			return false;
		}

		return Text.standardize(entry.getOption()).contains(this.getOption()) && Text.standardize(entry.getTarget()).equals(this.getTarget());
	}
}
