/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.execution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

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

	public boolean step()
	{		
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
		
		assert f2.other == f1;

		// this will happen because conditional branches will create their frame
		// before realizing its already executed it before, so it will set the frame
		// as not executing
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			e.frames.remove(f1);
			e2.frames.remove(f2);
			
			step1 = step2 = true;
			
			return step();
		}

		// step frame
		if (step1)
			f1.execute();
		else
			step1 = true;
		
		if (step2)
			f2.execute();
		else
			step2 = true;
		
		if (!f1.isExecuting() && !f2.isExecuting() && e.paused && e2.paused)
		{
			// this is a mappable return
			
			p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
			p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);
			
			// the only mappable returns are of objects
			assert p1.getInstruction() instanceof Return;
			assert p2.getInstruction() instanceof Return;
			
			// the only mappable returns are in non static methods
			assert f1.getMethod().isStatic() == false;
			assert f2.getMethod().isStatic() == false;
			
			// because this method isnt static theres nothing to return to
			assert f1.returnTo == null;
			assert f2.returnTo == null;
			
			// because theres nothing to return to, this will hit the !isExecuting check above
			// next step, and move to the next frame
			
			e.paused = e2.paused = false;
			
			return true;
		}
		
		e.paused = e2.paused = false;
		
		Frame oldf1 = f1, oldf2 = f2;
		
		f1 = popStack(f1);
		f2 = popStack(f2);
		
		if (oldf1 != f1 && oldf2 != f2)
			if (oldf1.otherStatic == oldf2 && oldf2.otherStatic == oldf1)
			{
				mappings.map(null, oldf1.getMethod(), oldf2.getMethod());
			//	System.out.println("STEP OUT " + oldf1.getMethod() + " <-> " + oldf2.getMethod());
			}
		
		if (oldf1 != f1 || oldf2 != f2)
		{
			if (f1 == oldf1)
				step1 = false;
			if (f2 == oldf2)
				step2 = false;
			return step();
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
				// ensure this is stopped or else on the
				// next step the frame is reused
				// and the other side is stepped
				f1.stop();
				return step();
			}
			
			step2 = false;
			return step();
		}
		else if (MappingExecutorUtil.isInlineable(p2.getInstruction()) && !MappingExecutorUtil.isInlineable(p1.getInstruction()))
		{
			if (stepInto(f2) == null)
			{
				f2.stop();
				return step();
			}

			step1 = false;
			return step();
		}
		else if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			Frame stepf1 = stepInto(f1);
			Frame stepf2 = stepInto(f2);
			
			if (stepf1 == null || stepf2 == null)
			{
				if (stepf1 == null)
					// move to next frame
					f1.stop();
				if (stepf2 == null)
					f2.stop();
				return step();
			}
			
			stepf1.otherStatic = stepf2;
			stepf2.otherStatic = stepf1;
			
			//System.out.println("STEP " + stepf1.getMethod() + " <-> " + stepf2.getMethod());
			
			return step();
		}
		
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
		
		Frame f2 = new Frame(e, to);
		f2.initialize(i);
		
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

	private Frame popStack(Frame f)
	{
		Execution e = f.getExecution();
		
		if (f.isExecuting() || f.returnTo == null)
			return f;
			
		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		if (!(i.getInstruction() instanceof ReturnInstruction))
			return f;

		StackContext returnValue = null; // the value returned by by the frame
		if (i.getInstruction() instanceof Return)
		{
			assert i.getPops().size() == 1;
			
			returnValue = i.getPops().get(0);
		}
		else
		{
			assert i.getPops().isEmpty();
		}
		
		Frame r = popStackForce(f); // we return to this frame
		
		f.returnTo = null;

		// last ins must be an invokestatic
		InstructionContext i2 = r.getInstructions().get(r.getInstructions().size() - 1); // this was the ins which invoked frame f
		assert i2.getInstruction() instanceof InvokeStatic;
		if (returnValue != null)
		{
			// if the function returned something, we must have pushed
			assert i2.getPushes().size() == 1;
			
			StackContext invokePushed = i2.getPushes().get(0);

			// set the return value of the invokestatic ins
			invokePushed.returnSource = returnValue;
		}
		
		return r;
	}
	
	private Frame popStackForce(Frame f)
	{
		Execution e = f.getExecution();
		
		assert f.returnTo != null;
		
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
