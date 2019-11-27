package net.runelite.client.plugins.poison;

import lombok.Data;

@Data
class ActorPoisonInfo
{
	/**
	 * Plain and simple, the last poison damage this actor received
	 */
	private int lastDamage;

	/**
	 * What the poison varp for this actor would be. -1 if unknown
	 * This should always be known if the actor is venomed
	 */
	private int accurateDamage;

	/**
	 * How many ticks after the tickcount is divisible by 30 the poison will hit.
	 * <p>
	 * For instance, if something gets hit by poison on tick 607 this will be 7, as 607 % 30 == 7.
	 * With this info you know all the times to expect a poison hit
	 */
	private int cycle;

	/**
	 * This is to be able to remove the overlay if someone doesn't get hit
	 */
	private int lastDamageTick;
}
