package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.attributes.code.Instruction;
import java.util.List;

public interface JumpingInstruction
{
	List<Instruction> getJumps();
}
