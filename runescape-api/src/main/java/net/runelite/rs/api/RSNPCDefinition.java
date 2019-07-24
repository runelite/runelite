package net.runelite.rs.api;

import net.runelite.api.NPCDefinition;
import net.runelite.mapping.Import;

public interface RSNPCDefinition extends NPCDefinition
{
	@Import("name")
	@Override
	String getName();

	@Import("models")
	@Override
	int[] getModels();

	@Import("actions")
	@Override
	String[] getActions();

	@Import("isClickable")
	@Override
	boolean isClickable();

	@Import("drawMapDot")
	@Override
	boolean isMinimapVisible();

	@Import("isVisible")
	@Override
	boolean isVisible();

	@Import("id")
	@Override
	int getId();

	@Import("combatLevel")
	@Override
	int getCombatLevel();

	@Import("transforms")
	@Override
	int[] getConfigs();

	@Import("transform")
	@Override
	RSNPCDefinition transform();

	@Import("size")
	@Override
	int getSize();

	@Import("headIconPrayer")
	int getRsOverheadIcon();
}
