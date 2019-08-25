package net.runelite.api.events;

import net.runelite.api.Actor;
import lombok.Data;

/**
 * An event where the {@link Actor} has changed animations.
 * <p>
 * In order to get the new animation ID, use {@link Actor#getAnimation()}.
 * <p>
 * Examples of when this event may trigger include:
 * <ul>
 *     <li>A player starts or stops gathering a resource (ie. woodcut, fishing)</li>
 *     <li>A player starts or stops dancing</li>
 * </ul>
 *
 * @see net.runelite.api.AnimationID
 */
@Data
public class AnimationChanged implements Event
{
	/**
	 * The actor that has entered a new animation.
	 */
	private Actor actor;
}
