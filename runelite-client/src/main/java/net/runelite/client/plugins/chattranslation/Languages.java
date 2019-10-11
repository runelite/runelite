package net.runelite.client.plugins.chattranslation;

import lombok.Getter;

// TODO: Doesn't Locale pretty much do this as well?
public enum Languages
{
	ENGLISH("English", "en"),
	WELSH("Welsh", "cy"),
	DUTCH("Dutch", "nl"),
	SPANISH("Spanish", "es"),
	FRENCH("French", "fr"),
	GERMAN("German", "de");

	@Getter
	private final String name;
	private final String shortName;

	Languages(String name, String shortName)
	{
		this.name = name;
		this.shortName = shortName;
	}

	public String toShortString()
	{
		return shortName;
	}

	@Override
	public String toString()
	{
		return name;
	}

}