package net.runelite.rs.api;

import net.runelite.api.ChatPlayer;
import net.runelite.mapping.Import;

public interface RSBuddy extends ChatPlayer, RSUser
{
	@Import("getWorld")
	@Override
	int getWorld();

	@Import("rank")
	int getRSRank();
}
