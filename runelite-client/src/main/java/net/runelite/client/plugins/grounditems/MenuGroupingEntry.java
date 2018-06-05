package net.runelite.client.plugins.grounditems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.MenuEntry;

@AllArgsConstructor
class MenuGroupingEntry
{
	@Getter
	private MenuEntry originalEntry;

	@Getter
	private int position;

	@Getter
	@Setter
	private int count;
}
