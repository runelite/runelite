package net.runelite.client.events;

import lombok.Value;
import net.runelite.api.Player;
import net.runelite.api.events.Event;
import net.runelite.client.game.AttackStyle;

/**
 * This will fire when {@link net.runelite.client.game.PlayerManager} detects
 * a change in the player appearance that resulted in the shifting of an attack style.
 * For example, ranged str went to 0, but melee str went to 108.
 */
@Value
public class AttackStyleChanged implements Event
{
	/**
	 * The player that changed styles.
	 */
	private final Player player;

	/**
	 * Can be Unknown(nullable)
	 *
	 * @see net.runelite.client.game.AttackStyle
	 */
	private final AttackStyle oldStyle;

	/**
	 * Can be Unknown(nullable)
	 *
	 * @see net.runelite.client.game.AttackStyle
	 */
	private final AttackStyle newStyle;
}
