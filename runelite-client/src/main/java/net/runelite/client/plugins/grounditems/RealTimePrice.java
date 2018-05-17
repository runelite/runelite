package net.runelite.client.plugins.grounditems;

import lombok.Data;

@Data
public class RealTimePrice
{
	private String itemName;
	private Integer buyPrice;
	private Integer sellPrice;
	private Long lastUpdated;

	RealTimePrice(String itemName, Integer buyPrice, Integer sellPrice, Long lastUpdated)
	{
		this.itemName = itemName;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.lastUpdated = lastUpdated;
	}
}
