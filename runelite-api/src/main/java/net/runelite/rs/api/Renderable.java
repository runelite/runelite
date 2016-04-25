package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Renderable extends Node
{
	@Import("modelHeight")
	int getModelHeight();
}
