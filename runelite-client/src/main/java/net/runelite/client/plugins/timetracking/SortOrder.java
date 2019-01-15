package net.runelite.client.plugins.timetracking;

public enum SortOrder
{
	NONE("NONE"),
	ASC("ASC"),
	DESC("DESC");

	private final String name;

	SortOrder(String name)
	{
		this.name = name;
	}
}
