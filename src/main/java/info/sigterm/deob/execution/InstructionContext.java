package info.sigterm.deob.execution;

import java.util.ArrayList;
import java.util.List;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;

public class InstructionContext
{
	private Instruction ins;
	private Frame frame;
	private List<StackContext> pops = new ArrayList<>(); // stack contexts popped by instruction execution
	private List<StackContext> pushes = new ArrayList<>(); // stack contexts pushed by instruction execution
	private List<VariableContext> reads = new ArrayList<>(); // lvt reads
	private List<Method> invokes = new ArrayList<>(); // invokes
	
	public InstructionContext(Instruction i, Frame f)
	{
		ins = i;
		frame = f;
	}
	
	public void pop(StackContext... ctx)
	{
		for (StackContext c : ctx)
		{
			c.setPopped(this); // now we know which instruction popped this, record it
			pops.add(c);
		}
	}
	
	public void push(StackContext... ctx)
	{
		for (StackContext c : ctx)
			pushes.add(c);
	}
	
	public void read(VariableContext... ctx)
	{
		for (VariableContext c : ctx)
			reads.add(c);
	}
	
	public void invoke(Method method)
	{
		invokes.add(method);
	}
	
	public Instruction getInstruction()
	{
		return ins;
	}
	
	public List<StackContext> getPops()
	{
		return pops;
	}
	
	public List<StackContext> getPushes()
	{
		return pushes;
	}
	
	public List<Method> getInvokes()
	{
		return invokes;
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
