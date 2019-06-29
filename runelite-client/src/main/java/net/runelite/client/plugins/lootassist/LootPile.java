package net.runelite.client.plugins.lootassist;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.WorldPoint;

class LootPile
{
	private static final long TIME_UNTIL_VISIBLE = 60000;

	@Getter
	private final long timeAppearing;

	@Getter
	private final WorldPoint location;

	@Getter
	private final String playerName;

	@Getter
	@Setter
	private boolean beingRendered = false;

	LootPile(WorldPoint location, String playerName)
	{
		long timeCreated = System.currentTimeMillis();
		this.location = location;
		this.playerName = playerName;
		this.timeAppearing = timeCreated + TIME_UNTIL_VISIBLE;
	}
}
