package net.runelite.client.plugins.menuentryswapperextended.util;

public enum FarmCapeMode
{
	OFF("None"),
	INVENTORY("Inventory"),
	EQUIPPED("Worn"),
	ALWAYS("Both");

	private final String name;

	FarmCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}