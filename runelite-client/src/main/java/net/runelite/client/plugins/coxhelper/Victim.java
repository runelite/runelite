package net.runelite.client.plugins.coxhelper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Player;

@Getter(AccessLevel.PACKAGE)
class Victim
{
	private final Player player;
	private final Type type;
	private int ticks;

	Victim(Player player, Type type)
	{
		this.player = player;
		this.type = type;
		this.ticks = type.getTicks();
	}

	void updateTicks()
	{
		if (this.ticks > 0)
		{
			this.ticks--;
		}
	}

	@AllArgsConstructor
	@Getter(AccessLevel.PACKAGE)
	enum Type
	{
		BURN(41),
		ACID(23),
		TELEPORT(10);

		private final int ticks;
	}
}
