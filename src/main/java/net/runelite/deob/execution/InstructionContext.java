package net.runelite.deob.execution;

import java.util.ArrayList;
import java.util.List;

import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import java.util.Objects;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;

public class InstructionContext
{
	private Instruction ins;
	private Frame frame;
	private Stack stack; // stack at time ins was executed
	private Variables variables; // variables at time ins was executed
	private List<StackContext> pops = new ArrayList<>(); // stack contexts popped by instruction execution
	private List<StackContext> pushes = new ArrayList<>(); // stack contexts pushed by instruction execution
	private List<VariableContext> reads = new ArrayList<>(); // lvt reads
	private List<Method> invokes = new ArrayList<>(); // invokes
	private List<Frame> branches = new ArrayList<>();
	
	public InstructionContext(Instruction i, Frame f)
	{
		ins = i;
		frame = f;
		stack = new Stack(frame.getStack());
		variables = new Variables(frame.getVariables());
	}
	
	public void pop(StackContext... ctx)
	{
		for (StackContext c : ctx)
		{
			c.addPopped(this); // now we know which instruction popped this, record it
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
		{
			c.addRead(this);
			reads.add(c);
		}
	}
	
	public void invoke(Method method)
	{
		invokes.add(method);
	}
	
	public void branch(Frame frame)
	{
		assert frame != this.frame;
		assert !branches.contains(frame);
		
		branches.add(frame);
	}
	
	public Instruction getInstruction()
	{
		return ins;
	}

	public Frame getFrame()
	{
		return frame;
	}
	
	public Stack getStack()
	{
		return stack;
	}
	
	public Variables getVariables()
	{
		return variables;
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

	public List<Frame> getBranches()
	{
		return branches;
	}
	
	public List<StackContext> removeStack(int idx)
	{
		// idx 0 is top of the stack, 1 is one under
		// stack contexts are added to 'pops' in the order that they are popped from the stack,
		StackContext ctx = pops.get(idx);
		assert !ctx.removed;
		ctx.removed = true;
		
		// start recursively removing
		return ctx.removeStack();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof InstructionContext))
			return false;
		
		InstructionContext ic = (InstructionContext) other;
		
		if (ins != ic.ins)
			return false;
		
		// check if stack at time of execution is equal
		Stack ours = new Stack(this.getStack()), // copy stacks since we destroy them
			theirs = new Stack(ic.getStack());
		
		if (ours.getSize() != theirs.getSize()) // is this possible?
			return false;
		
		while (ours.getSize() > 0)
		{
			StackContext s1 = ours.pop(), s2 = theirs.pop();
			
			if (s1.getPushed().getInstruction() != s2.getPushed().getInstruction())
				return false;
		}
		
		return true;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 73 * hash + Objects.hashCode(this.ins);
		return hash;
	}

	@Override
	public String toString()
	{
		return "InstructionContext{" + "ins=" + ins + '}';
	}
	
	public InstructionContext resolve(
		StackContext from // pushed from this
	)
	{
		InstructionContext ctx = this;
		
		if (ctx.getInstruction() instanceof SetFieldInstruction)
		{
			StackContext s = ctx.getPops().get(0);
			return s.getPushed().resolve(s);
		}
		
		if (ctx.getInstruction() instanceof DupInstruction)
		{
			DupInstruction d = (DupInstruction) ctx.getInstruction();
			StackContext s = d.getOriginal(from);
			return s.getPushed().resolve(s);
		}
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			Variables variables = ctx.getVariables();
			
			if (lvt.store())
			{
				StackContext s = ctx.getPops().get(0); // is this right?
				return s.getPushed().resolve(s);
			}
			else
			{
				VariableContext vctx = variables.get(lvt.getVariableIndex()); // variable being loaded
				assert vctx != null;

				InstructionContext storedCtx = vctx.getInstructionWhichStored();
				if (storedCtx == null)
					return ctx; // initial parameter
				
				if (vctx.isIsParameter())
					return ctx; // parameter (storedCtx is invoking instruction in another frame). this lvt index is fixed.
				
				return storedCtx.resolve(null);
			}
		}
		
		return ctx;
	}
}
