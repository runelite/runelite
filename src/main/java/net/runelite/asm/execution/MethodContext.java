package net.runelite.asm.execution;

import java.util.Collection;
import net.runelite.asm.attributes.code.Instruction;
import org.apache.commons.collections4.map.MultiValueMap;

public class MethodContext
{
	private Execution execution;
	private MultiValueMap<InstructionContext, Instruction> visited = new MultiValueMap<>();
	public MultiValueMap<Instruction, InstructionContext> contexts = new MultiValueMap<>(); // XXX this should move to method ctx probably

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
	
	public Collection<InstructionContext> getInstructonContexts(Instruction i)
	{
		return contexts.getCollection(i);
	}
	
	public Collection<InstructionContext> getInstructionContexts()
	{
		return (Collection) contexts.values();
	}
}
