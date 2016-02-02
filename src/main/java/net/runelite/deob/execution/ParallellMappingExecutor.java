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
	int count;
	public boolean step()
	{
		++count;
		

		if (count == 18223)
		{
			int i = 5;
		}
		// this no longer holds with recursive stepinfo
		//assert e.frames.size() == e2.frames.size();
		
		p1 = p2 = null;
		
		if (e.frames.isEmpty() || e2.frames.isEmpty())
			return false;
		
		Frame f1 = e.frames.get(0), f2 = e2.frames.get(0);
		
//		assert f1.other.other == f1;
//		assert f2.other.other == f2;

		assert f1.other == f2;
		assert f2.other == f1;

		//assert f1.isExecuting() == f2.isExecuting();

		// this will happen because conditional branches will create their frame
		// before realizing its already executed it before, so it will set the frame
		// as not executing
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			assert f1.returnTo == null || !e.frames.contains(f1.returnTo);
			assert f2.returnTo == null || !e2.frames.contains(f2.returnTo);
			
			InstructionContext fork1 = f1.getInstructions().isEmpty() ? f1.forking : f1.getInstructions().get(f1.getInstructions().size() - 1);
			InstructionContext fork2 = f2.getInstructions().isEmpty() ? f2.forking : f2.getInstructions().get(f2.getInstructions().size() - 1);
			
			assert fork1 != null;
			assert fork2 != null;
			
			if (!(f1.getInstructions().isEmpty() == f2.getInstructions().isEmpty()))
			{
				int i = 5;
			}
			
			// Due to jump ob one side can stop while the other side jumps
			//if (f1.getInstructions().size() > 0)
			if (fork1 == f1.forking)
			{
				assert fork1.getBranches().size() == 1;
				//assert fork1.getBranches().get(0) == f1;
				
				int i1 = e.frames.indexOf(fork1.getFrame());
				int i2 = e.frames.indexOf(fork1.getBranches().get(0));
				
				// remove fork1.frame
				e.frames.remove(fork1.getFrame());
				//e.frames.remove(fork1.getBranches().get(0));
			}
			else
			{
				//p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);

				for (Frame branch : fork1.getBranches())
				{
					e.frames.remove(branch);
				}
			}

			// this is empty but should be removing a branch, because of the map other, theres no prev instruction.
			// should always populate prev instruction
			//if (f2.getInstructions().size() > 0)
			if (fork2 == f2.forking)
			{
				assert fork2.getBranches().size() == 1;
				//assert fork2.getBranches().get(0) == f2;
				
				int i1 = e2.frames.indexOf(fork2.getFrame());
				int i2 = e2.frames.indexOf(fork2.getBranches().get(0));
				
				e2.frames.remove(fork2.getFrame());
				//e.frames.remove(fork2.getBranches().get(0));
			}
			else
			{
				//p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);
				
				for (Frame branch : fork2.getBranches())
				{
					e2.frames.remove(branch);
				}
			}
			
			assert e.frames.get(0) == f1;
			assert e2.frames.get(0) == f2;
			
			e.frames.remove(0);
			e2.frames.remove(0);
			
			//assert (f1.returnTo != null) == (f2.returnTo != null);
//			boolean exit1 = !f1.isExecuting() && f1.returnTo != null,
//				exit2 = !f2.isExecuting() && f2.returnTo != null;
//			
//			if (exit1 && exit2)
//			{
				//removeOrPop(e, f1);
				//removeOrPop(e2, f2);
//			}
//			else if (exit1)
//			{
//				removeOrPop(e, f1);
//			}
//			else if (exit2)
//			{
//				removeOrPop(e2, f2);
//			}
//			else
//			{
//				assert false;
//			}

			Frame f1wtf = e.frames.get(0),
				f2wtf = e2.frames.get(0);
			
			int otherIndex1 = e2.frames.indexOf(f1wtf.other),
				otherIndex2 = e.frames.indexOf(f2wtf.other);

	//		assert f1wtf.other.other == f1wtf;
	//		assert f2wtf.other.other == f2wtf;

			assert f1wtf.other == f2wtf;
			assert f2wtf.other == f1wtf;
			
			step1 = step2 = true;
			
			return step();
		}
		
		Frame old1 = new Frame(f1), old2 = new Frame(f2);
		int s1 = e.frames.size(), s2 = e2.frames.size();

		// step frame
		if (step1)
			f1.execute();
		else
			step1 = true;
		
		if (step2)
			f2.execute();
		else
			step2 = true;
		
		Frame oldf1 = f1, oldf2 = f2;
		
		f1 = popStack(f1);
		f2 = popStack(f2);
		
//		if (e.frames.size() - s1 != e2.frames.size() - s2)
//		{
//			System.out.println("fr mismatch");
//		}
		
		if (oldf1 != f1 || oldf2 != f2)
		{
			if (f1 == oldf1)
				step1 = false;
			if (f2 == oldf2)
				step2 = false;
			return step();
		}
		
		if (oldf1 != f1 || oldf2 != f2)
		{
//			assert oldf1 != f1;
//			assert oldf2 != f2;
//			
//			Method m1 = oldf1.getMethod(), m2 = oldf2.getMethod();
//			
//			System.out.println("RETURN MAP " + m1 + " -> " + m2);
//			
//			// if one exits and the other doesnt, the functions arent equal
//			assert oldf1.otherStatic == oldf2;
//			assert oldf2.otherStatic == oldf1;
		}

		// get what each frame is paused/exited on
		p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
		p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);

		// frames can stop executing at different times if one sees a jump
		// that has been done before, so stop both and remove the pending branch
		// of the jump
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			return step();
		}
		
		if (!(e.frames.size() == e2.frames.size()))
		{
			int i =56;
		}
		
		if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && !MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			f1 = stepInto(f1);
			
			//try
			//{
				step2 = false;
				return step();
//			}
//			finally
//			{
//				step2 = true;
//			}
		}
		else if (MappingExecutorUtil.isInlineable(p2.getInstruction()) && !MappingExecutorUtil.isInlineable(p1.getInstruction()))
		{
			f2 = stepInto(f2);

			//try
			//{
				step1 = false;
				return step();
//			}
//			finally
//			{
//				step1 = true;
//			}
		}
		else if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			Frame stepf1 = stepInto(f1);
			Frame stepf2 = stepInto(f2);
			
			stepf1.otherStatic = stepf2;
			stepf2.otherStatic = stepf1;
			
			System.out.println("STEP " + stepf1.getMethod() + " <-> " + stepf2.getMethod());
			
			return step();
		}
		
		if (!(e.frames.size() == e2.frames.size()))
		{
			int i =56;
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
		
		Method to = methods.get(0);
		
		Frame f2 = new Frame(e, to);
		f2.created = is;
		f2.initialize(i);
		
		e.frames.remove(0); // old frame goes away
		e.frames.add(0, f2);
		
		assert f.other.other == f;
		
		f2.other = f.other; // even though theyre in different methods
		f.other.other = f2;
		
		f.other = null;
		
		f2.returnTo = new Frame(f); // where to go when we're done
		assert f.getInstructions().isEmpty() == false;
		f2.returnTo.getInstructions().addAll(f.getInstructions());
		
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
		
		f = popStackForce(f);
		
		// step return frame
		//f.execute();
		
		return f;
	}
	
	private Frame popStackForce(Frame f)
	{
		Execution e = f.getExecution();
		
		assert f.returnTo != null;
		
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
		//f.returnTo.execute();
		
		return f.returnTo;
	}
	
	private void removeOrPop(Execution e, Frame f)
	{
		// get what each frame is paused/exited on
		InstructionContext p = f.getInstructions().get(f.getInstructions().size() - 1);

		for (Frame branch : p.getBranches())
		{
			e.frames.remove(branch);
		}
		
		if (f.returnTo != null)
		{
			popStackForce(f);
		}
		else
		{
			assert e.frames.get(0) == f;

			e.frames.remove(0);
		}
	}
}
