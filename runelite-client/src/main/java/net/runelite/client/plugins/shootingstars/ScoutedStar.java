package net.runelite.client.plugins.shootingstars;

import java.time.LocalDateTime;
import lombok.Value;

@Value(staticConstructor = "of")
public class ScoutedStar
{
	int world;
	StarRegion region;
	LocalDateTime earliestTime;
	LocalDateTime latestTime;
}
