package net.runelite.client.plugins.minimap;

public enum AlignmentMode
{
	OFF("Off"),
	FIXED("Fixed"),
	RESIZEABLE("Resizeable"),
	BOTH("Both");

	private final String name;

	AlignmentMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
