package net.runelite.client.plugins.grandexchange;

import net.runelite.api.GrandExchangeOffer;

public class GrandExchangeOfferImpl implements GrandExchangeOffer
{

	@Override
	public int getQuantitySold()
	{
		return -99;
	}

	@Override
	public int getItemId()
	{
		return -99;
	}

	@Override
	public int getTotalQuantity()
	{
		return -99;
	}

	@Override
	public int getPrice()
	{
		return -99;
	}

	@Override
	public int getSpent()
	{
		return -99;
	}

	@Override
	public byte getProgress()
	{
		return -99;
	}

	@Override
	public String toString()
	{
		return "GrandExchangeOffer{" +
				"id=" + this.getItemId() + ", " +
				"price=" + this.getPrice() + ", " +
				"quantitySold=" + this.getQuantitySold() + ", " +
				"totalQuantity=" + this.getTotalQuantity() +
				"}";
	}
}
