package net.runelite.client.plugins.freezetimers;

import lombok.Builder;
import lombok.Getter;
import api.Actor;
import api.coords.LocalPoint;

@Builder
class FreezeInfo
{
	@Getter
	private final Actor actor;
	@Getter
	private final LocalPoint freezePoint;
}