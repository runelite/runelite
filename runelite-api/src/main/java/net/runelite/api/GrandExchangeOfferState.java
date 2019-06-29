package net.runelite.api;

/**
 * Describes the state of a Grand Exchange offer.
 */
public enum GrandExchangeOfferState
{
	/**
	 * An empty slot.
	 */
	EMPTY,
	/**
	 * A cancelled buy offer.
	 */
	CANCELLED_BUY,
	/**
	 * A cancelled sell offer.
	 */
	CANCELLED_SELL,
	/**
	 * A buy offer that is currently in progress.
	 */
	BUYING,
	/**
	 * A buy offer that has completed.
	 */
	BOUGHT,
	/**
	 * A sell offer that is currently in progress.
	 */
	SELLING,
	/**
	 * A sell offer that has completed.
	 */
	SOLD;
}
