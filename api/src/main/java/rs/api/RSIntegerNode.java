package rs.api;

import api.IntegerNode;
import net.runelite.mapping.Import;

public interface RSIntegerNode extends RSNode, IntegerNode
{
	@Import("integer")
	@Override
	int getValue();

	@Import("integer")
	@Override
	void setValue(int value);
}