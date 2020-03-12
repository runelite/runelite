package net.runelite.api.events.player.headicon;

import lombok.Getter;
import net.runelite.api.Player;
import net.runelite.api.SkullIcon;

public class PlayerSkullChanged extends PlayerHeadIconChanged
{
	@Getter
	private final SkullIcon oldSkullIcon;

	@Getter
	private final SkullIcon newSkullIcon;

	public PlayerSkullChanged(Player player, SkullIcon changedFrom, SkullIcon changedTo)
	{
		super(player);
		this.oldSkullIcon = changedFrom;
		this.newSkullIcon = changedTo;
	}
}
