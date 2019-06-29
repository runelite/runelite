package net.runelite.rs.api;

import net.runelite.api.World;
import net.runelite.mapping.Import;

public interface RSWorld extends World
{
	@Import("properties")
	int getMask();

	@Import("properties")
	void setMask(int mask);

	@Import("population")
	@Override
	int getPlayerCount();

	@Import("population")
	@Override
	void setPlayerCount(int playerCount);

	@Import("location")
	@Override
	int getLocation();

	@Import("location")
	@Override
	void setLocation(int location);

	@Import("index")
	@Override
	int getIndex();

	@Import("index")
	@Override
	void setIndex(int index);

	@Import("id")
	@Override
	int getId();

	@Import("id")
	@Override
	void setId(int id);

	@Import("activity")
	@Override
	String getActivity();

	@Import("activity")
	@Override
	void setActivity(String activity);

	@Import("host")
	@Override
	String getAddress();

	@Import("host")
	@Override
	void setAddress(String address);
}
