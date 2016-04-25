package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Item extends Renderable
{
	@Import("id")
	int getId();

	@Import("quantity")
	int getQuantity();
}
