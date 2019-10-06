package net.runelite.client.plugins.menuentryswapper.util;

public enum SwapGrimyHerbMode
{
	USE("Use"),
	DYNAMIC("By level");

	private final String name;

	SwapGrimyHerbMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
