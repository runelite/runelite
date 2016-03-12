package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface NPCComposition
{
	@Import("name")
	String getName();

	@Import("models")
	int[] getModels();

	@Import("actions")
	String[] getActions();

	@Import("isClickable")
	boolean isClickable();

	@Import("isMinimapVisible")
	boolean isMinimapVisable();

	@Import("isVisible")
	boolean isVisable();

	@Import("id")
	int getId();

	@Import("combatLevel")
	int getCombatLevel();
}
