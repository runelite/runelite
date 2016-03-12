package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface XGrandExchangeOffer
{
	@Import("quantitySold")
	int getQuantitySold();

	@Import("itemId")
	int getItemId();

	@Import("totalQuantity")
	int getTotalQuantity();

	@Import("price")
	int getPrice();

	@Import("spent")
	int getSpent();

	@Import("progress")
	byte getProgress();
}
