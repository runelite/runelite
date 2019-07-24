package net.runelite.client.plugins.menuentryswapper.util;

public enum CharterOption
{
	TRADE("Trade"),
	CHARTER("Charter");

	private final String name;

	CharterOption(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}