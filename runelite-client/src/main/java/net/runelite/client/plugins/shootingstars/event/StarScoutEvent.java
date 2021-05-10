package net.runelite.client.plugins.shootingstars.event;

import java.time.ZonedDateTime;
import lombok.Value;
import net.runelite.client.plugins.shootingstars.StarRegion;

/**
 * An event that is fired when a shooting star is scouted by looking at a telescope. This event is meant to be consumed by hub plugins.
 */
@Value(staticConstructor = "of")
public class StarScoutEvent
{
	int worldId;
	ZonedDateTime timestamp;
	StarRegion region;
}
