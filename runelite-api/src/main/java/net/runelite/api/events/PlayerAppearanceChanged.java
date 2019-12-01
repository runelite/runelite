package net.runelite.api.events;

import lombok.Value;
import net.runelite.api.Player;

/**
 * This will fire whenever the {@link net.runelite.api.PlayerAppearance} hash changes.
 */
@Value
public class PlayerAppearanceChanged implements Event
{
	private Player player;
}
