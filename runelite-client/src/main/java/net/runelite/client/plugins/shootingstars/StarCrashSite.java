package net.runelite.client.plugins.shootingstars;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Value
public class StarCrashSite
{
	String name;
	WorldPoint location;

	public static StarCrashSite of(String name, WorldPoint location)
	{
		return new StarCrashSite(name, location);
	}
}
