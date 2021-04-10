package net.runelite.client.plugins.shootingstars.event;

import lombok.Value;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.shootingstars.CrashedStar;

/**
 * An event that is fired when a shooting star downgrades it's tier. This event is meant to be consumed by hub plugins.
 */
@Value(staticConstructor = "of")
public class StarDowngradeEvent
{
	int world;
	WorldPoint worldPoint;
	int tier;

	public static StarDowngradeEvent from(CrashedStar star)
	{
		return new StarDowngradeEvent(star.getWorld(), star.getWorldPoint(), star.getTier());
	}
}
