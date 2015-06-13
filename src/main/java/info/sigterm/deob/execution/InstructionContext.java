package info.sigterm.deob.execution;

import java.util.ArrayList;
import java.util.List;

import info.sigterm.deob.attributes.code.Instruction;

public class InstructionContext
{
	private Instruction ins;
	private Frame frame;
	private List<StackContext> pops = new ArrayList<>();
	private List<VariableContext> reads = new ArrayList<>(); // lvt reads
	
	public InstructionContext(Instruction i, Frame f)
	{
		ins = i;
		frame = f;
	}
	
	public void pop(StackContext... ctx)
	{
		for (StackContext c : ctx)
			pops.add(c);
	}
	
	public void read(VariableContext... ctx)
	{
		for (VariableContext c : ctx)
			reads.add(c);
	}
	
	public Instruction getInstruction()
	{
		return ins;
	}
	
	public List<StackContext> getPops()
	{
		return pops;
	}
	
	public void removeStack(int idx)
	{
		// idx 0 is top of the stack, 1 is one under
		// stack contexts are added to 'pops' in the order that they are popped from the stack,
		// so just remove at index idx
		StackContext ctx = pops.remove(idx);
		
		// start recursively removing
		ctx.removeStack();
	}
}
