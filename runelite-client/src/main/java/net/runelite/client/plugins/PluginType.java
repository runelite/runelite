package net.runelite.client.plugins;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
public enum PluginType
{
	PVM("PvM"),
	PVP("PvP"),
	SKILLING("Skilling"),
	UTILITY("Utilities"),
	MISCELLANEOUS("Miscellaneous"),
	EXTERNAL("Legacy External"),
	IMPORTANT("System"),
	MINIGAME("Minigame"),
	GAMEMODE("Gamemode"),
	UNCATEGORIZED("Uncategorized");

	private String name;

	@Override
	public String toString()
	{
		return getName();
	}
}
