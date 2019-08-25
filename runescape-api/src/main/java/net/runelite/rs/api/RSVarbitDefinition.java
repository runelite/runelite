package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSVarbitDefinition extends RSDualNode
{
	@Import("baseVar")
	int getIndex();

	@Import("startBit")
	int getLeastSignificantBit();

	@Import("endBit")
	int getMostSignificantBit();
}
