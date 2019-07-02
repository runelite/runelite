package net.runelite.client.plugins.chattranslation;

public enum Languages
{

	ENGLISH("en"),
	DUTCH("nl"),
	SPANISH("es"),
	FRENCH("fr");

	private final String shortName;

	Languages(String shortName)
	{
		this.shortName = shortName;
	}

	@Override
	public String toString()
	{
		return shortName;
	}

}
