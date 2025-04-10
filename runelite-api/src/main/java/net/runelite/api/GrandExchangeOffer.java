/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
	 * @see net.runelite.api.gameval.ItemID
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
