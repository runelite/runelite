package net.runelite.rs.api;

import net.runelite.api.GrandExchangeOffer;
import net.runelite.mapping.Import;

public interface RSGrandExchangeOffer extends GrandExchangeOffer
{
	@Import("currentQuantity")
	@Override
	int getQuantitySold();

	@Import("id")
	@Override
	int getItemId();

	@Import("totalQuantity")
	@Override
	int getTotalQuantity();

	@Import("unitPrice")
	@Override
	int getPrice();

	@Import("currentPrice")
	@Override
	int getSpent();

	@Import("state")
	byte getRSState();
}
