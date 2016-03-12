package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Player extends Actor
{
	@Import("composition")
	PlayerComposition getComposition();

	@Import("name")
	String getName();

	@Import("model")
	Model getModel();

	@Import("combatLevel")
	int getCombatLevel();

	@Import("totalLevel")
	int getTotalLevel();

	@Import("team")
	int getTeam();
}
