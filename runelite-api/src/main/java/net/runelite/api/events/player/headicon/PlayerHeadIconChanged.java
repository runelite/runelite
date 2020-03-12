package net.runelite.api.events.player.headicon;

import lombok.Getter;
import net.runelite.api.Player;
import net.runelite.api.events.Event;

public abstract class PlayerHeadIconChanged implements Event
{
	@Getter
	private final Player player;

	public PlayerHeadIconChanged(Player player)
	{
		this.player = player;
	}
}
