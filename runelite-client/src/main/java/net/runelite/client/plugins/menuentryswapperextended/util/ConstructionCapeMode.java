package net.runelite.client.plugins.menuentryswapperextended.util;

public enum ConstructionCapeMode
{
	OFF("None"),
	INVENTORY("Inventory"),
	EQUIPPED("Worn"),
	ALWAYS("Both");

	private final String name;

	ConstructionCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
