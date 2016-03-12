package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Friend
{
	@Import("name")
	String getName();

	@Import("previousName")
	String getPreviousName();

	@Import("world")
	int getWorld();
}
