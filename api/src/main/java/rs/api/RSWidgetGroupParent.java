package rs.api;

import api.WidgetNode;
import net.runelite.mapping.Import;

public interface RSWidgetGroupParent extends RSNode, WidgetNode
{
	@Import("group")
	@Override
	int getId();
}
