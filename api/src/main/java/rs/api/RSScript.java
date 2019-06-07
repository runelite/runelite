package rs.api;

import api.Script;
import net.runelite.mapping.Import;

public interface RSScript extends Script, RSDualNode
{
	@Import("intOperands")
	@Override
	int[] getIntOperands();

	@Import("opcodes")
	@Override
	int[] getInstructions();
}
