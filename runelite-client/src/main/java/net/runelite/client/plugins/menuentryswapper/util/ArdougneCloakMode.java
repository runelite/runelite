package net.runelite.client.plugins.menuentryswapper.util;

public enum ArdougneCloakMode
{
	TELE_TO_MONASTERY("Monastery Teleport", "Kandarin Monastery"),
	TELE_TO_FARM("Farm Teleport", "Ardougne Farm");

	private final String name, name2;

	ArdougneCloakMode(String name, String name2)
	{
		this.name = name;
		this.name2 = name2;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public String toString2()
	{
		return name2;
	}
}

