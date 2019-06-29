package net.runelite.rs.api;

import net.runelite.api.NPC;
import net.runelite.mapping.Import;

public interface RSNPC extends RSActor, NPC
{
	@Import("definition")
	@Override
	RSNPCDefinition getDefinition();

	@Override
	int getIndex();

	void setIndex(int id);

	void setDead(boolean dead);
}
