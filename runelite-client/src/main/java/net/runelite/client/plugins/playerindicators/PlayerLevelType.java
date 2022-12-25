package net.runelite.client.plugins.playerindicators;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PlayerLevelType
{
	LONG("Long", " (Level-"),
	SHORT("Short", " (Lvl-"),
	LEVEL_ONLY("Level only", " (");

	private final String type;
	private final String levelString;

	@Override
	public String toString()
	{
		return type;
	}

	public String getLevelString()
	{
		return levelString;
	}
}
