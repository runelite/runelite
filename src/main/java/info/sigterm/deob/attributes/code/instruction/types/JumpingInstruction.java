package info.sigterm.deob.attributes.code.instruction.types;

import info.sigterm.deob.attributes.code.Instruction;
import java.util.List;

public interface JumpingInstruction
{
	public void buildJumpGraph();
	
	List<Instruction> getJumps();
}
