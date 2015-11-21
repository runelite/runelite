package net.runelite.rs.api;

public interface XGrandExchangeOffer
{
	int getQuantitySold();

	int getItemId();

	int getTotalQuantity();

	int getPrice();

	int getSpent();

	byte getProgress();
}
