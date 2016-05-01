package net.runelite.asm.execution;

import java.util.Collection;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import org.apache.commons.collections4.map.MultiValueMap;

public class MethodContext
{
	private Execution execution;
	private Method method;
	private MultiValueMap<InstructionContext, Instruction> visited = new MultiValueMap<>();
	public MultiValueMap<Instruction, InstructionContext> contexts = new MultiValueMap<>();

	public MethodContext(Execution execution, Method method)
	{
		this.execution = execution;
		this.method = method;
	}

	public Execution getExecution()
	{
		return execution;
	}

	public Method getMethod()
	{
		return method;
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
