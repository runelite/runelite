package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface XClanMember
{
	@Import("name")
	String getName();

	@Import("world")
	int getWorld();

	@Import("rank")
	byte getRank();
}
