package net.runelite.api;

/**
 * Represents an offer in a grand exchange slot.
 */
public interface GrandExchangeOffer
{
	/**
	 * Gets the quantity of bought or sold items.
	 *
	 * @return the quantity bought or sold
	 */
	int getQuantitySold();

	/**
	 * Gets the ID of the item being bought or sold.
	 *
	 * @return item ID
	 * @see ItemID
	 */
	int getItemId();

	/**
	 * Gets the total quantity being bought or sold.
	 *
	 * @return the total quantity
	 */
	int getTotalQuantity();

	/**
	 * Gets the offer or sell price per item.
	 *
	 * @return the offer price
	 */
	int getPrice();

	/**
	 * Gets the total amount of money spent so far.
	 *
	 * @return the amount spent
	 */
	int getSpent();

	/**
	 * Gets the current state of the offer.
	 *
	 * @return the offers state
	 */
	GrandExchangeOfferState getState();
}
