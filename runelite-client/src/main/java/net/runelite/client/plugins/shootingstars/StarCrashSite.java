package net.runelite.client.plugins.shootingstars;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;

@Value(staticConstructor = "of")
public class StarCrashSite
{
	String name;
	WorldPoint location;
}
