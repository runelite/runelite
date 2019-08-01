package net.runelite.client.plugins.coxhelper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Player;

@Getter(AccessLevel.PACKAGE)
class Victim
{
	private Player player;
	private Type type;
	private int ticks;

	Victim(Player player, Type type)
	{
		this.player = player;
		this.type = type;
		this.ticks = type.getTicks();
	}

	void updateTicks()
	{
		if (ticks > 0)
		{
			ticks--;
		}
	}

	@AllArgsConstructor
	@Getter(AccessLevel.PACKAGE)
	enum Type
	{
		BURN(41),
		ACID(23),
		TELEPORT(10);

		private int ticks;
	}
}
