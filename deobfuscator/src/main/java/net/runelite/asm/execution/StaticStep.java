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
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.Return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticStep
{
	private static final Logger logger = LoggerFactory.getLogger(StaticStep.class);

	private static boolean isLoop(Frame f)
	{
		Set<Method> set = new HashSet<>();
		while (f != null)
		{
			if (set.contains(f.getMethod()))
			{
				return true;
			}

			set.add(f.getMethod());
			f = f.returnTo;
		}

		return false;
	}

	public static Frame stepInto(Frame f, InstructionContext i)
	{
		Execution e = f.getExecution();

		assert i.getInstruction() instanceof InvokeStatic;

		InvokeStatic is = (InvokeStatic) i.getInstruction();
		List<Method> methods = is.getMethods();

		assert methods.size() == 1;

		Method to = methods.get(0);

		if (isLoop(f))
		{
			return null;
		}

		if (e.hasInvoked(i, to))
		{
			return null;
		}

		if (to.isNative())
		{
			return null;
		}

		Frame f2 = new Frame(e, to);
		f2.initialize(i);
		f2.setOrder(f.getOrder());

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

		// only mapping executor has other
		if (f.other != null)
		{
			assert f.other.other == f;

			f2.other = f.other; // even though theyre in different methods
			f.other.other = f2;

			f.other = null;
		}

		f2.returnTo = new Frame(f); // where to go when we're done
		//assert f.getInstructions().isEmpty() == false; // this is wrong?
		f2.returnTo.getInstructions().addAll(f.getInstructions()); // also wrong?

		logger.trace("Stepping into {} from {}", f2, f);

		return f2;
	}

	public static Frame popStack(Frame f)
	{
		if (f.isExecuting() || f.returnTo == null || f.getInstructions().isEmpty())
		{
			return f;
		}

		InstructionContext i = f.getInstructions().get(f.getInstructions().size() - 1);
		if (!(i.getInstruction() instanceof ReturnInstruction))
		{
			return f;
		}

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

		logger.trace("Stepping out of {} into {}", f, r);

		return r;
	}

	private static Frame popStackForce(Frame f)
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

		Frame newFrame = f.returnTo;

		if (f.other != null)
		{
			assert f.other.other == f;
			assert f.returnTo.other == null;

			newFrame.other = f.other;
			newFrame.other.other = newFrame;

			f.other = null;
		}

		// Update order
		assert f.getOrder() >= newFrame.getOrder();
		newFrame.setOrder(f.getOrder());

		return newFrame;
	}
}
