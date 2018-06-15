package net.runelite.http.service.grandexchange;

import java.time.Instant;
import lombok.Data;
import net.runelite.http.service.grandexchange.osbuddy.GuidePriceResponse;

@Data
public class GrandExchangeEntry
{
	private int item_id;

	private int overall;

	private int buying;

	private int buying_quantity;

	private int selling;

	private int selling_quantity;

	private Instant last_update;

	public GrandExchangeEntry()
	{

	}

	public GrandExchangeEntry(int itemId, GuidePriceResponse guidePrice, Instant lastUpdate)
	{
		this.item_id = itemId;
		this.overall = guidePrice.getOverall();
		this.buying = guidePrice.getBuying();
		this.buying_quantity = guidePrice.getBuyingQuantity();
		this.selling = guidePrice.getSelling();
		this.selling_quantity = guidePrice.getSellingQuantity();
		this.last_update = lastUpdate;
	}

	public int getItemId()
	{
		return item_id;
	}

	public void setItemId(int itemId)
	{
		this.item_id = itemId;
	}

	public int getOverall()
	{
		return overall;
	}

	public void setOverall(int overall)
	{
		this.overall = overall;
	}

	public int getBuying()
	{
		return buying;
	}

	public void setBuying(int buying)
	{
		this.buying = buying;
	}

	public int getBuyingQuantity()
	{
		return buying_quantity;
	}

	public void setBuyingQuantity(int buyingQuantity)
	{
		this.buying_quantity = buyingQuantity;
	}

	public int getSelling()
	{
		return selling;
	}

	public void setSelling(int selling)
	{
		this.selling = selling;
	}

	public int getSellingQuantity()
	{
		return selling_quantity;
	}

	public void setSellingQuantity(int sellingQuantity)
	{
		this.selling_quantity = sellingQuantity;
	}

	public Instant getLastUpdate()
	{
		return last_update;
	}

	public void setLastUpdate(Instant lastUpdate)
	{
		this.last_update = lastUpdate;
	}
}
