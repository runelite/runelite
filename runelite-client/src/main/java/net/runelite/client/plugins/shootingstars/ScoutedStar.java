package net.runelite.client.plugins.shootingstars;

import java.time.LocalDateTime;
import lombok.Value;
import net.runelite.client.plugins.shootingstars.event.StarScoutEvent;

@Value(staticConstructor = "of")
public class ScoutedStar
{
	int world;
	StarRegion region;
	LocalDateTime earliestTime;
	LocalDateTime latestTime;

	public static ScoutedStar from(StarScoutEvent event)
	{
		LocalDateTime now = LocalDateTime.now();

		return new ScoutedStar(event.getWorld(), event.getRegion(), now.plus(event.getEarliest()), now.plus(event.getLatest()));
	}
}
