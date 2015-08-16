package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.attributes.code.Instruction;
import java.util.List;

public interface JumpingInstruction
{
	public void buildJumpGraph();
	
	List<Instruction> getJumps();
}
