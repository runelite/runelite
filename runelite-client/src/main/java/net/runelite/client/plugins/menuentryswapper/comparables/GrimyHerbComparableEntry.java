package net.runelite.client.plugins.menuentryswapper.comparables;

import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Skill;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.AbstractComparableEntry;
import net.runelite.client.plugins.menuentryswapper.util.GrimyHerbLookup;
import net.runelite.client.plugins.menuentryswapper.util.HerbNotFoundException;
import net.runelite.client.plugins.menuentryswapper.util.SwapGrimyHerbMode;
import org.apache.commons.lang3.StringUtils;

public class GrimyHerbComparableEntry extends AbstractComparableEntry
{
	private final SwapGrimyHerbMode mode;

	private final GrimyHerbLookup lookup = new GrimyHerbLookup();
	private final Client client;

	public GrimyHerbComparableEntry(SwapGrimyHerbMode mode, Client client)
	{
		this.mode = mode;
		this.client = client;
	}

	@Override
	public int getPriority()
	{
		return 100;
	}

	@Override
	public boolean equals(Object other)
	{
		return other instanceof GrimyHerbComparableEntry && ((GrimyHerbComparableEntry) other).mode == mode && super.equals(other);
	}

	public boolean matches(MenuEntry entry)
	{
		final int groupId = WidgetInfo.TO_GROUP(entry.getParam1());

		if (groupId != WidgetID.INVENTORY_GROUP_ID)
		{
			return false;
		}

		int cleanLevel;
		try
		{
			cleanLevel = lookup.getCleanLevel(entry.getIdentifier());
		}
		catch (HerbNotFoundException e)
		{
			return false;
		}

		if (this.mode == SwapGrimyHerbMode.USE)
		{
			return StringUtils.equalsIgnoreCase(entry.getOption(), "use");
		}

		String swapOption = "use";
		if (client.getBoostedSkillLevel(Skill.HERBLORE) >= cleanLevel)
		{
			swapOption = "clean";
		}

		return StringUtils.equalsIgnoreCase(entry.getOption(), swapOption);
	}
}
