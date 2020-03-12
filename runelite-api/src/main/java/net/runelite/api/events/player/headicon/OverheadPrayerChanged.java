package net.runelite.api.events.player.headicon;

import lombok.Data;
import net.runelite.api.HeadIcon;
import net.runelite.api.Player;
import net.runelite.api.events.Event;

@Data
public class OverheadPrayerChanged implements Event
{
	private final Player player;

	private final HeadIcon oldHeadIcon;

	private final HeadIcon newHeadIcon;

}
