package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSVarbitDefinition extends RSDualNode
{
	@Import("varp")
	int getIndex();

	@Import("lowBit")
	int getLeastSignificantBit();

	@Import("highBit")
	int getMostSignificantBit();
}
