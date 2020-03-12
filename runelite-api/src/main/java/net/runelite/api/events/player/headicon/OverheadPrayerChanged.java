package net.runelite.api.events.player.headicon;

import lombok.Getter;
import net.runelite.api.HeadIcon;
import net.runelite.api.Player;

public class OverheadPrayerChanged extends PlayerHeadIconChanged
{
	@Getter
	private final HeadIcon oldHeadIcon;

	@Getter
	private final HeadIcon newHeadIcon;

	public OverheadPrayerChanged(Player player, HeadIcon changedFrom, HeadIcon changedTo)
	{
		super(player);
		this.oldHeadIcon = changedFrom;
		this.newHeadIcon = changedTo;
	}
}
