package net.runelite.client.plugins.shootingstars.event;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.shootingstars.CrashedStar;

/**
 * An event that is fired once a shooting star is found. This event is meant to be consumed by hub plugins.
 */
@Value(staticConstructor = "of")
public class StarCrashEvent
{
	int world;
	WorldPoint worldPoint;
	int tier;

	public static StarCrashEvent from(CrashedStar star)
	{
		return new StarCrashEvent(star.getWorld(), star.getWorldPoint(), star.getTier());
	}
}
