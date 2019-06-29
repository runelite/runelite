package net.runelite.client.plugins.stonedloottracker;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemSortTypes
{
	ALPHABETICAL("Alphabetical"),
	ITEM_ID("Item ID"),
	VALUE("Value"),
	PRICE("Price"),
	HAPRICE("HA Price");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}