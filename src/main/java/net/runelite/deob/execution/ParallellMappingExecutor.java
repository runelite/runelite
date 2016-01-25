package net.runelite.deob.execution;

import java.util.List;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeSpecial;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;

public class ParallellMappingExecutor
{
	private Execution e, e2;
	private InstructionContext p1, p2;

	public ParallellMappingExecutor(Execution one, Execution two)
	{
		this.e = one;
		this.e2 = two;
	}
	
	boolean step1 = true, step2 = true;
	public boolean step()
	{
		assert e.frames.size() == e2.frames.size();
		
		p1 = p2 = null;
		
		if (e.frames.isEmpty() || e2.frames.isEmpty())
			return false;
		
		Frame f1 = e.frames.get(0), f2 = e2.frames.get(0);

		assert f1.other == f2;
		assert f2.other == f1;

		//assert f1.isExecuting() == f2.isExecuting();

		// this will happen because conditional branches will create their frame
		// before realizing its already executed it before, so it will set the frame
		// as not executing
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			assert e.frames.get(0) == f1;
			assert e2.frames.get(0) == f2;

			e.frames.remove(0);
			e2.frames.remove(0);
			
			return step();
		}

		// step frame
		if (step1)
			f1.execute();
		if (step2)
			f2.execute();
		
		f1 = popStack(f1);
		f2 = popStack(f2);

		// get what each frame is paused/exited on
		p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
		p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);

		// frames can stop executing at different times if one sees a jump
		// that has been done before, so stop both and remove the pending branch
		// of the jump
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			for (Frame branch : p1.getBranches())
			{
				e.frames.remove(branch);
			}
			for (Frame branch : p2.getBranches())
			{
				e2.frames.remove(branch);
			}

		//	System.out.println("Something exited " + f1 + " " + f2);

			assert e.frames.get(0) == f1;
			assert e2.frames.get(0) == f2;

			e.frames.remove(0);
			e2.frames.remove(0);
			
			return step();
		}
		
		Frame oldf1 = f1, oldf2 = f2;
		if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && !MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			f1 = stepInto(f1);
			try
			{
				step2 = false;
				return step();
			}
			finally
			{
				step2 = true;
			}
			//f1 = popStack(f1);
			//p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
		}
		else if (MappingExecutorUtil.isInlineable(p2.getInstruction()) && !MappingExecutorUtil.isInlineable(p1.getInstruction()))
		{
			f2 = stepInto(f2);
			//f2 = popStack(f2);
			//p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);
			try
			{
				step1 = false;
				return step();
			}
			finally
			{
				step1 = true;
			}
		}
		else if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			// p1s func might equal p2s func
			
			// step into both at once, and insert to beginning of e.frames
			
			// when two funcs exit at once, map them then (if static?)
			
//			f1 = stepInto(f1);
//			f1 = popStack(f1);
//			p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
//			
//			f2 = stepInto(f2);
//			f2 = popStack(f2);
//			p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);
		}
		
		if (p1.getInstruction() instanceof InvokeSpecial && p2.getInstruction() instanceof InvokeStatic)
		{
			int i = 5;
		}

		assert e.paused;
		assert e2.paused;
		
		return true;
	}

	public InstructionContext getP1()
	{
		return p1;
	}

	public InstructionContext getP2()
	{
		return p2;
	}
	
	private Frame stepInto(Frame f)
	{
		Execution e = f.getExecution();
		
		assert e == this.e || e == e2;
		assert e.frames.get(0) == f;
		
		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		assert i.getInstruction() instanceof InvokeStatic;
		
		InvokeStatic is = (InvokeStatic) i.getInstruction();
		List<Method> methods = is.getMethods();
		
		assert methods.size() == 1;
		//if (methods.isEmpty()) // not my method
		//	return null;
		
		Method to = is.getMethods().get(0);
		
		Frame f2 = new Frame(e, to);
		f2.initialize(i);
		
		e.frames.remove(0); // old frame goes away
		e.frames.add(0, f2);
		
		assert f.other.other == f;
		
		f2.other = f.other; // even though theyre in different methods
		f.other.other = f2;
		
		f.other = null;
		
		f2.returnTo = new Frame(f); // where to go when we're done
		
		// step new frame
		//f2.execute();
		
		return f2;
	}
	
	private Frame popStack(Frame f)
	{
		Execution e = f.getExecution();
		
		if (f.isExecuting() || f.returnTo == null)
			return f;
		
		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		if (!(i.getInstruction() instanceof ReturnInstruction))
			return f;
		
		assert e.frames.contains(f);
		assert !e.frames.contains(f.returnTo);
		
		// replace frame with returnTo
		assert e.frames.get(0) == f;
		e.frames.remove(0);
		e.frames.add(0, f.returnTo);
		
		assert f.other.other == f;
		assert f.returnTo.other == null;
		
		Frame newFrame = f.returnTo;
		newFrame.other = f.other;
		newFrame.other.other = newFrame;
		
		f.other = null;
		
		// step return frame
		f.returnTo.execute();
		
		return f.returnTo;
	}
}
