package net.runelite.asm.execution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public class ParallellMappingExecutor
{
	private Execution e, e2;
	private InstructionContext p1, p2;
	public ParallelExecutorMapping mappings;

	public ParallellMappingExecutor(Execution one, Execution two)
	{
		this.e = one;
		this.e2 = two;
	}
	
	boolean step1 = true, step2 = true;
	static int count;
	public boolean step()
	{
		++count;
		

		if (count == 26)
		{
			int i = 5;
		}
		// this no longer holds with recursive stepinfo
		//assert e.frames.size() == e2.frames.size();
		
		p1 = p2 = null;
		
		if (e.frames.isEmpty())
			return false;
		
		Frame f1 = e.frames.get(0),
			f2 = f1.other;
		
		if (f2 == null)
		{
			// why?
			e.frames.remove(0);
			return step();
		}
		
		//assert e2.frames.contains(f2);
		
//		assert f1.other.other == f1;
//		assert f2.other.other == f2;

		//assert f1.other == f2;
		assert f2.other == f1;

		//assert f1.isExecuting() == f2.isExecuting();

		// this will happen because conditional branches will create their frame
		// before realizing its already executed it before, so it will set the frame
		// as not executing
		if (!f1.isExecuting() || !f2.isExecuting())
		{	
//			assert f1.returnTo == null;
//			assert f2.returnTo == null;
			
			// XXX I dont know if this is right! only helps a few fields.
			// XXX if a frame exits from a jump loop it would step out which might be bad
			//popStack(f1);
			//popStack(f2);
			
			e.frames.remove(f1);
			e2.frames.remove(f2);
			
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
		
		if (oldf1 != f1 && oldf2 != f2)
			if (oldf1.otherStatic == oldf2 && oldf2.otherStatic == oldf1)
			{
				mappings.map(oldf1.getMethod(), oldf2.getMethod());
			//	System.out.println("STEP OUT " + oldf1.getMethod() + " <-> " + oldf2.getMethod());
			}
		
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
		
		if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && !MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			if (stepInto(f1) == null)
			{
				f1.stop();
				return step();
			}
			
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
			if (stepInto(f2) == null)
			{
				f2.stop();
				return step();
			}

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
			
			if (stepf1 == null)
			{
				f1.stop();
			}
			if (stepf2 == null)
			{
				f2.stop();
			}
			if (stepf1 == null || stepf2 == null)
				return step();
			
			stepf1.otherStatic = stepf2;
			stepf2.otherStatic = stepf1;
			
			doubleStep.add(stepf1.getMethod());
			//System.out.println("STEP " + stepf1.getMethod() + " <-> " + stepf2.getMethod());
			
			return step();
		}

		assert e.paused;
		assert e2.paused;
		
		return true;
	}
	public static Set<Method> doubleStep = new HashSet();

	public InstructionContext getP1()
	{
		return p1;
	}

	public InstructionContext getP2()
	{
		return p2;
	}
	
	private boolean isLoop(Frame f)
	{
		Set<Method> set = new HashSet<>();
		while (f != null)
		{
			if (set.contains(f.getMethod()))
				return true;
			
			set.add(f.getMethod());
			f = f.returnTo;
		}
		
		return false;
	}
	
	private Frame stepInto(Frame f)
	{
		Execution e = f.getExecution();
		
		assert e == this.e || e == e2;
		
		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		assert i.getInstruction() instanceof InvokeStatic;
		
		InvokeStatic is = (InvokeStatic) i.getInstruction();
		List<Method> methods = is.getMethods();
		
		assert methods.size() == 1;
		
		Method to = methods.get(0);
		
		if (isLoop(f))
			return null;
		
		if (e.hasInvoked(i, to))
			return null;
		//assert e.methods.contains(to) == false;
		//e.methods.add(to);
		
		Frame f2 = new Frame(e, to);
		f2.created = is;
		f2.initialize(i);
		
//		assert e.frames.contains(f);
		if (e.frames.contains(f))
		{
			int idx = e.frames.indexOf(f);
			e.frames.remove(f); // old frame goes away
			e.frames.add(idx, f2);
		}
		else
		{
			e.frames.add(f);
		}
		
		assert f.other.other == f;
		
		f2.other = f.other; // even though theyre in different methods
		f.other.other = f2;
		
		f.other = null;
		
		f2.returnTo = new Frame(f); // where to go when we're done
		assert f.getInstructions().isEmpty() == false; // this is wrong?
		f2.returnTo.getInstructions().addAll(f.getInstructions()); // also wrong?
		
		return f2;
	}

	public static boolean enable = true;
	public static List<StackContext> returnStacks = new ArrayList<>();
	private Frame popStack(Frame f)
	{
		Execution e = f.getExecution();
		
		if (f.isExecuting() || f.returnTo == null)
			return f;
		
//		if (!f.getInstructions().isEmpty())
//			return f;
//		
		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		if (!(i.getInstruction() instanceof ReturnInstruction))
			return f;

		StackContext returnValue = null;
		if (enable&& i.getInstruction() instanceof Return)
		{
			assert i.getPops().size() == 1;
			
			returnValue = i.getPops().get(0);
		}
		
		Frame r = popStackForce(f);
		
		f.returnTo = null;

		// last ins must be an invokestatic
		InstructionContext i2 = r.getInstructions().get(r.getInstructions().size() - 1);
		assert i2.getInstruction() instanceof InvokeStatic;
		if (returnValue != null)
		{
			// if the function retunred something, we must have pushed
			assert i2.getPushes().size() == 1;
			
			StackContext invokePushed = i2.getPushes().get(0);

			//assert invokePushed.returnSource == null;
			invokePushed.returnSource = returnValue;
//
//			if (invokePushed.getPushed().getInstruction() != i2.getInstruction())
//			//if (!(invokePushed.getPushed().getInstruction() instanceof InvokeStatic))
//			{
//				return r;
//			}
//
//			//returnStacks.add(invokePushed);
//			returnStacks.add(returnValue);
//			boolean b = returnStacks.contains(invokePushed);
//			assert invokePushed.getPopped().isEmpty();
//
//			// replace invokePushed with returnValue?
//			i2.getPushes().remove(invokePushed);
//			i2.getPushes().add(returnValue);
//
//			//invokePushed.setpushed = null
//
//			Stack stack = r.getStack();
//			StackContext s = stack.pop();
//			assert s == invokePushed;
//			stack.push(returnValue);

			//assert invokePushed.getPushed().getPushes().contains(invokePushed);
			//invokePushed.getpu
		}
		
		// step return frame
		//r.execute();
		
		return r;
	}
	
	private Frame popStackForce(Frame f)
	{
		Execution e = f.getExecution();
		
		assert f.returnTo != null;
		
		//assert e.frames.contains(f);
		assert !e.frames.contains(f.returnTo);
		
		if (e.frames.contains(f))
		{
			// replace frame with returnTo
			int idx = e.frames.indexOf(f);
			e.frames.remove(f);
			assert !e.frames.contains(f.returnTo);
			e.frames.add(idx, f.returnTo);
		}
		else
		{
			e.frames.add(f.returnTo);
		}
		
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
	
	public void removeFramesFromMethod(Method m)
	{
		e.frames = e.frames.stream().filter(f -> f.getMethod() != m).collect(Collectors.toList());
		e2.frames = e2.frames.stream().filter(f -> f.getMethod() != m).collect(Collectors.toList());
	}
	
	public void addFrame(Frame f1, Frame f2)
	{
		e.frames.add(0, f1);
		e2.frames.add(0, f2);
	}
}
