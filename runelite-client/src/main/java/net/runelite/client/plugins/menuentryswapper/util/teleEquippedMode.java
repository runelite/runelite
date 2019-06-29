package net.runelite.client.plugins.menuentryswapper.util;

public enum teleEquippedMode
{
	TELE_TO_POH("Tele to POH"),
	TELEPORT("teleport");

	private final String name;

	teleEquippedMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
