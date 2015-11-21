package net.runelite.rs.api;

public interface NPCComposition
{
	String getName();

	int[] getModels();

	String[] getActions();

	boolean isClickable();

	boolean isMinimapVisable();

	boolean isVisable();

	int getId();

	int getCombatLevel();
}
