package net.runelite.http.api.grandexchange;

import java.time.Instant;

public class GrandExchangeResult
{
	private int item_id;

	private int overall;

	private int buying;

	private int buying_quantity;

	private int selling;

	private int selling_quantity;

	private Instant last_update;

	public int getItemId()
	{
		return item_id;
	}

	public int getOverall()
	{
		return overall;
	}

	public int getBuying()
	{
		return buying;
	}

	public int getBuyingQuantity()
	{
		return buying_quantity;
	}

	public int getSelling()
	{
		return selling;
	}

	public int getSellingQuantity()
	{
		return selling_quantity;
	}

	public Instant getLastUpdate()
	{
		return last_update;
	}
}
