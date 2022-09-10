package net.runelite.client.plugins.menuentryswapperextended.util;

public enum MagicCapeMode
{
	OFF("None"),
	INVENTORY("Inventory"),
	EQUIPPED("Worn"),
	ALWAYS("Both");

	private final String name;

	MagicCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
