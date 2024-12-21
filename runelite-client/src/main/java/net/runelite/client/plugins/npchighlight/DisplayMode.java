package net.runelite.client.plugins.npchighlight;
import lombok.Getter;

@Getter
public enum DisplayMode
{
	NONE("None", 0),
	LEVEL("Name", 1),
	NAME("Level", 2),
	BOTH("Both", 3);

	private final String name;
	private final int id;

	DisplayMode(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
}
