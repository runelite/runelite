package net.runelite.client.plugins.menuentryswapper.comparables;

import lombok.EqualsAndHashCode;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.AbstractComparableEntry;
import net.runelite.api.util.Text;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
public class EquipmentComparableEntry extends AbstractComparableEntry
{
	public EquipmentComparableEntry(String option, String itemName)
	{
		this.setOption(option);
		this.setTarget(Text.standardize(itemName));
	}

	public boolean matches(MenuEntry entry)
	{
		final int groupId = WidgetInfo.TO_GROUP(entry.getParam1());

		if (groupId != WidgetID.EQUIPMENT_GROUP_ID)
		{
			return false;
		}

		return StringUtils.equalsIgnoreCase(entry.getOption(), this.getOption())
			&& Text.standardize(entry.getTarget()).contains(this.getTarget());
	}
}
