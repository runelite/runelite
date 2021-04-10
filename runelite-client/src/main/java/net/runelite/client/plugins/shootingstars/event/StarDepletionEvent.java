package net.runelite.client.plugins.shootingstars.event;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.shootingstars.CrashedStar;

/**
 * An event that is fired when a shooting star fully depletes. This event is meant to be consumed by hub plugins.
 */
@Value(staticConstructor = "of")
public class StarDepletionEvent
{
	int world;
	WorldPoint worldPoint;

	public static StarDepletionEvent from(CrashedStar star)
	{
		return new StarDepletionEvent(star.getWorld(), star.getWorldPoint());
	}
}
