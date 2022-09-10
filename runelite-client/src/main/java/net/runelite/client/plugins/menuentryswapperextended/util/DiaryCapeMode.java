package net.runelite.client.plugins.menuentryswapperextended.util;

public enum DiaryCapeMode
{
	OFF("None"),
	INVENTORY("Inventory"),
	EQUIPPED("Worn"),
	ALWAYS("Both");

	private final String name;

	DiaryCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}