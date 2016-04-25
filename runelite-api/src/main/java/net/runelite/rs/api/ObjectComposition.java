package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface ObjectComposition
{
	@Import("name")
	String getName();

	@Import("actions")
	String[] getActions();
}
