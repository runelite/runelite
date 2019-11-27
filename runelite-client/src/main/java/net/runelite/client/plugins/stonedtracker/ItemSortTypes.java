package net.runelite.client.plugins.stonedtracker;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(AccessLevel.PACKAGE)
@RequiredArgsConstructor
public enum ItemSortTypes
{
	ALPHABETICAL("Alphabetical"),
	ITEM_ID("Item ID"),
	VALUE("Value"),
	PRICE("Price");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}