package net.runelite.asm.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import org.apache.commons.collections4.map.MultiValueMap;

public class MethodContext
{
	private Execution execution;
	private MultiValueMap<InstructionContext, Instruction> visited = new MultiValueMap<>();

	public MethodContext(Execution execution)
	{
		this.execution = execution;
	}
	
	protected boolean hasJumped(InstructionContext from, Instruction to)
	{
		Collection<Instruction> i = visited.getCollection(from);
		if (i != null && i.contains(to))
			return true;
		
		visited.put(from, to);
		return false;
	}
}
