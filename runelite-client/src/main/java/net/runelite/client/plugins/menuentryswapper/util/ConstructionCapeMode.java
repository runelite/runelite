package net.runelite.client.plugins.menuentryswapper.util;

public enum ConstructionCapeMode
{
	TELE_TO_POH("Tele to POH"),
	TELEPORT("Teleport");

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
