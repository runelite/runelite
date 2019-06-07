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

import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.Return;
import static net.runelite.asm.execution.StaticStep.popStack;
import static net.runelite.asm.execution.StaticStep.stepInto;
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
		{
			return false;
		}

		Frame f1 = e.frames.get(0),
			f2 = f1.other;

		if (f2 == null)
		{
			// this is from anything which creates frames without mapping the .other
			// and/or is not mappable
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
		{
			f1.execute();
		}
		else
		{
			step1 = true;
		}

		if (step2)
		{
			f2.execute();
		}
		else
		{
			step2 = true;
		}

		if (!f1.isExecuting() && !f2.isExecuting() && e.paused && e2.paused)
		{
			// this can happen from a return (which is mappable), or from a mapped instruction
			// which jumps on the executing frame (currently just tableswitch?)

			p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
			p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);

			assert p1.getInstruction() instanceof ReturnInstruction == p2.getInstruction() instanceof ReturnInstruction;

			if (p1.getInstruction() instanceof ReturnInstruction)
			{
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
			}

			e.paused = e2.paused = false;

			return true;
		}

		e.paused = e2.paused = false;

		Frame oldf1 = f1, oldf2 = f2;

		f1 = popStack(f1);
		f2 = popStack(f2);

		if (oldf1 != f1 && oldf2 != f2)
		{
			if (oldf1.otherStatic == oldf2 && oldf2.otherStatic == oldf1)
			{
				mappings.map(null, oldf1.getMethod(), oldf2.getMethod());
				//System.out.println("STEP OUT " + oldf1.getMethod() + " <-> " + oldf2.getMethod());
			}
		}

		if (oldf1 != f1 || oldf2 != f2)
		{
			if (f1 == oldf1)
			{
				step1 = false;
			}
			if (f2 == oldf2)
			{
				step2 = false;
			}
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
			if (stepInto(f1, p1) == null)
			{
				// ensure this is stopped or else on the
				// next step the frame is reused
				// and the other side is stepped

				// I think this must be a crash - but note
				// stopping of frames with a return frame
				f1.stop();
				return step();
			}

			// p2 is already at the first mappable instruction of
			// the inlined method - so only step p1
			step2 = false;
			return step();
		}
		else if (MappingExecutorUtil.isInlineable(p2.getInstruction()) && !MappingExecutorUtil.isInlineable(p1.getInstruction()))
		{
			if (stepInto(f2, p2) == null)
			{
				// I think this must be a crash - but note
				// stopping of frames with a return frame
				f2.stop();
				return step();
			}

			step1 = false;
			return step();
		}
		else if (MappingExecutorUtil.isInlineable(p1.getInstruction()) && MappingExecutorUtil.isInlineable(p2.getInstruction()))
		{
			Frame stepf1 = stepInto(f1, p1);
			Frame stepf2 = stepInto(f2, p2);

			if (stepf1 == null && stepf2 == null)
			{
				// may have to return to a new frame, don't stop
				// yet
				return step();
			}

			if (stepf1 == null || stepf2 == null)
			{
				// I think this must be a crash - but note
				// stopping of frames with a return frame
				if (stepf1 == null)
				{
					f1.stop();
				}
				if (stepf2 == null)
				{
					f2.stop();
				}
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
}
