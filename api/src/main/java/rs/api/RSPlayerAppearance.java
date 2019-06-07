package rs.api;

import api.PlayerAppearance;
import net.runelite.mapping.Import;

public interface RSPlayerAppearance extends PlayerAppearance
{
	@Import("isFemale")
	boolean isFemale();

	@Import("bodyColors")
	int[] getBodyPartColours();

	@Import("equipment")
	@Override
	int[] getEquipmentIds();

	@Import("npcTransformId")
	@Override
	void setTransformedNpcId(int id);

	@Import("setHash")
	@Override
	void setHash();
}
