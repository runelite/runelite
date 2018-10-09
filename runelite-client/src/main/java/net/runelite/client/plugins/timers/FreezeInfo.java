package net.runelite.client.plugins.timers;

import lombok.Builder;
import lombok.Getter;
import net.runelite.api.Actor;

@Builder
public class FreezeInfo
{
	@Getter
	private final GameTimer timer;
	@Getter
	private final Actor actor;
}
