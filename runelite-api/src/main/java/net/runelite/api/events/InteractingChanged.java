package net.runelite.api.events;

import net.runelite.api.Actor;

import lombok.Data;

/**
 * An event called when the actor an actor is interacting with changes
 */
@Data
public class InteractingChanged
{
	public static final InteractingChanged INSTANCE = new InteractingChanged();

	private InteractingChanged()
	{
		// noop
	}

	private Actor source;

	/**
	 * Target actor, may be null
	 */
	private Actor target;
}
