package net.runelite.client.plugins.freezetimers;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.coords.LocalPoint;

@Builder
class FreezeInfo
{
	@Getter(AccessLevel.PACKAGE)
	private final Actor actor;
	@Getter(AccessLevel.PACKAGE)
	private final LocalPoint freezePoint;
}