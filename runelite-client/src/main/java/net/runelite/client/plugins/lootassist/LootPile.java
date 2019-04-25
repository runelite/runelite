package net.runelite.client.plugins.lootassist;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public class LootPile
{
	private static final long TIME_UNTIL_VISIBLE = 60000;
	private final long timeCreated;
	@Getter
	private final long timeAppearing;
	@Getter
	private final WorldPoint location;
	@Getter
	private final String playerName;
	@Getter @Setter
	private boolean beingRendered = false;

	public LootPile(WorldPoint location, String playerName)
	{
		this.timeCreated = System.currentTimeMillis();
		this.location = location;
		this.playerName = playerName;
		this.timeAppearing = this.timeCreated + TIME_UNTIL_VISIBLE;
	}
}
