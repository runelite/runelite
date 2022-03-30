package net.runelite.client.plugins.discord;

import java.util.Optional;
import static net.runelite.client.plugins.discord.DiscordGameEventType.DiscordEventArea;
import static net.runelite.client.plugins.discord.DiscordGameEventType.FROM_POINT;
import static org.junit.Assert.fail;
import org.junit.Test;

public class DiscordGameEventTypeTest
{
	@Test
	public void ensureNoOverlappingAreas()
	{
		FROM_POINT.asMap().forEach((region, gameAreas) ->
		{
			for (final DiscordEventArea discordEventArea : gameAreas)
			{
				final Optional<DiscordEventArea> overlappingArea = gameAreas.stream()
					.filter(area -> area != discordEventArea &&
						((area.getArea() != null && discordEventArea.getArea() != null && discordEventArea.getArea().intersectsWith2D(area.getArea()))
						|| (area.getArea() == null && discordEventArea.getArea() == null)))
					.findAny();

				if (overlappingArea.isPresent())
				{
					final DiscordEventArea overlap = overlappingArea.get();
					fail("Game event type " + discordEventArea.getEventType() + " has area " + discordEventArea.getArea()
						+ " which overlaps the area of " + overlap.getEventType() + ": " + overlap.getArea());
				}
			}
		});
	}
}
