package rs.api;

import api.ChatPlayer;
import net.runelite.mapping.Import;

public interface RSBuddy extends ChatPlayer, RSUser
{
	@Import("world")
	@Override
	int getWorld();

	@Import("rank")
	int getRSRank();
}
