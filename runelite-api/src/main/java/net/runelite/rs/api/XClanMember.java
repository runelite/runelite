package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface XClanMember
{
	@Import("username")
	String getUsernameName();

	@Import("world")
	int getWorld();

	@Import("rank")
	byte getRank();
}
