package net.runelite.client.plugins.timers;

import lombok.Builder;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.timers.GameTimer;

@Builder
public class FreezeInfo
{
	private final GameTimer timer;
	private final WorldPoint worldPoint;
}
