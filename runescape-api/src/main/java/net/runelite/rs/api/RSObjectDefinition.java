package net.runelite.rs.api;

import net.runelite.api.ObjectDefinition;
import net.runelite.mapping.Import;

public interface RSObjectDefinition extends ObjectDefinition
{
	@Import("id")
	@Override
	int getId();

	@Import("name")
	@Override
	String getName();

	@Import("actions")
	@Override
	String[] getActions();

	@Import("mapSceneId")
	@Override
	int getMapSceneId();

	@Import("mapIconId")
	@Override
	int getMapIconId();

	@Import("transforms")
	@Override
	int[] getImpostorIds();

	@Import("transform")
	@Override
	RSObjectDefinition getImpostor();
}
