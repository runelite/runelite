package net.runelite.client.plugins.menuentryswapper.util;

public enum QuestCapeMode
{
	TRIM("Trim"),
	TELEPORT ("Teleport");

	private final String name;

	QuestCapeMode(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
