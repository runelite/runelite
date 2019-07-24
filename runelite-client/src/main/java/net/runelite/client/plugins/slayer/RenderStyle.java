package net.runelite.client.plugins.slayer;

public enum RenderStyle
{
	TILE("Tile"),
	HULL("Hull"),
	SOUTH_WEST_TILE("South West Tile"),
	THIN_OUTLINE("Thin outline"),
	OUTLINE("Outline"),
	THIN_GLOW("Thin glow"),
	GLOW("Glow"),
	TRUE_LOCATIONS("True Location");

	private final String name;

	RenderStyle(final String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
