package net.runelite.api;

/**
 * @author Robbie, created on 29/10/2017 10:34 AM
 */
public interface GrandExchangeOffer
{

	int getQuantitySold();

	int getItemId();

	int getTotalQuantity();

	int getPrice();

	int getSpent();

	byte getProgress();



}
