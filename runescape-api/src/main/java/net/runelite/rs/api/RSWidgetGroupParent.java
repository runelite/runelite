package net.runelite.rs.api;

import net.runelite.api.WidgetNode;
import net.runelite.mapping.Import;

public interface RSWidgetGroupParent extends RSNode, WidgetNode
{
	@Import("group")
	@Override
	int getId();
}
