package net.runelite.client.plugins.flipping;

import javax.swing.*;

public class FlippingItem
{

	private final String itemName;
	private final Icon icon;
	private final Long buyPrice;
	private final Long sellPrice;

	FlippingItem(String itemName, Icon icon, Long buyPrice, Long sellPrice)
	{
		this.itemName = itemName;
		this.icon = icon;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}

	public String getItemName()
	{
		return itemName;
	}

	public Icon getIcon()
	{
		return icon;
	}

	public Long getBuyPrice()
	{
		return buyPrice;
	}

	public Long getSellPrice()
	{
		return sellPrice;
	}
}
