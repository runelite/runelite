package net.runelite.client.plugins.menuentryswapper.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.menus.BaseComparableEntry;
import static net.runelite.client.menus.ComparableEntries.newBaseComparableEntry;

@Getter
@AllArgsConstructor
public enum ConstructionMode
{
	BENCH("Benches",
		newBaseComparableEntry("Remove", "bench", -1, -1, true, false),
		newBaseComparableEntry("Build", "Seating space", -1, -1, true, true)),
	CHAIR("Chairs",
		newBaseComparableEntry("Remove", "chair", -1, -1, true, false),
		newBaseComparableEntry("Build", "Chair space", -1, -1, true, true)),
	DUNGEON("Dungeon Doors",
		newBaseComparableEntry("Remove", "door", -1, -1, true, false),
		newBaseComparableEntry("Build", "Door space", -1, -1, true, true)),
	LARDER("Larders",
		newBaseComparableEntry("Remove", "larder", -1, -1, true, false),
		newBaseComparableEntry("Build", "Larder space", -1, -1, true, true)),
	MYTH_CAPE("Myth Cape",
		newBaseComparableEntry("Remove", "cape", -1, -1, true, false),
		newBaseComparableEntry("Build", "Guild trophy space", -1, -1, true, true)),
	TABLE("Tables",
		newBaseComparableEntry("Remove", "table", -1, -1, true, false),
		newBaseComparableEntry("Build", "Table space", -1, -1, true, true));

	private final String name;
	private final BaseComparableEntry build;
	private final BaseComparableEntry remove;

	@Override
	public String toString()
	{
		return name;
	}
}
