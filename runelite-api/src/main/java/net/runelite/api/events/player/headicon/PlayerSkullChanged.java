package net.runelite.api.events.player.headicon;

import lombok.Data;
import net.runelite.api.Player;
import net.runelite.api.SkullIcon;
import net.runelite.api.events.Event;

@Data
public class PlayerSkullChanged implements Event
{
	private final Player player;

	private final SkullIcon oldSkullIcon;

	private final SkullIcon newSkullIcon;

}
