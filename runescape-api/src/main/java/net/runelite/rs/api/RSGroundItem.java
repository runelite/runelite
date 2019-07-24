package net.runelite.rs.api;

import net.runelite.api.Item;
import net.runelite.api.Tile;
import net.runelite.mapping.Import;

public interface RSGroundItem extends RSEntity, Item
{
	@Import("id")
	@Override
	int getId();

	@Import("id")
	void setId(int id);

	@Import("quantity")
	@Override
	int getQuantity();

	@Import("quantity")
	void setQuantity(int quantity);

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);

	/**
	 * Get the tile this item is on
	 * @return
	 */
	Tile getTile();
}
