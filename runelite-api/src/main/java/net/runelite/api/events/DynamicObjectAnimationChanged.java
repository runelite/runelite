package net.runelite.api.events;

import lombok.Data;

@Data
public class DynamicObjectAnimationChanged implements Event
{
	/**
	 * The object that has entered a new animation.
	 */
	private int object;
	/**
	 * The id of the animation animation.
	 */
	private int animation;
}
