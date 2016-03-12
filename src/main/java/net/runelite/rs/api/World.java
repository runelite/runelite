package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface World
{
	@Import("mask")
	int getMask();

	@Import("playerCount")
	int getPlayerCount();

	@Import("location")
	int getLocation();

	@Import("index")
	int getIndex();

	@Import("id")
	int getId();

	@Import("activity")
	String getActivity();

	@Import("address")
	String getAddress();
}
