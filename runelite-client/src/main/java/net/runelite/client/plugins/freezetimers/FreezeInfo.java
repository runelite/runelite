package net.runelite.client.plugins.freezetimers;

import lombok.Builder;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.coords.LocalPoint;

@Builder
class FreezeInfo
{
	@Getter
	private final Actor actor;
	@Getter
	private final LocalPoint freezePoint;
}