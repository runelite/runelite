package net.runelite.rs.api;

public interface Player extends Actor
{
	PlayerComposition getComposition();

	String getName();

	Model getModel();

	int getCombatLevel();

	int getTotalLevel();

	int getTeam();
}
