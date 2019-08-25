package net.runelite.client.plugins.lootassist;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

class LootPile
{
	private static final long TIME_UNTIL_VISIBLE = 62400;

	@Getter(AccessLevel.PACKAGE)
	private final long timeAppearing;

	@Getter(AccessLevel.PACKAGE)
	private final WorldPoint location;

	@Getter(AccessLevel.PACKAGE)
	private final String playerName;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean beingRendered = false;

	LootPile(WorldPoint location, String playerName)
	{
		long timeCreated = System.currentTimeMillis();
		this.location = location;
		this.playerName = playerName;
		this.timeAppearing = timeCreated + TIME_UNTIL_VISIBLE;
	}
}
