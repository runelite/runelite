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

package net.runelite.deob.deobfuscators.mapping;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.ArrayLoad;
import net.runelite.asm.attributes.code.instruction.types.ConversionInstruction;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.ParallellMappingExecutor;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;
import net.runelite.asm.signature.Signature;

public class MappingExecutorUtil
{	
	public static ParallelExecutorMapping map(Method m1, Method m2)
	{
		ClassGroup group1 = m1.getClassFile().getGroup();
		ClassGroup group2 = m2.getClassFile().getGroup();

		Execution e = new Execution(group1);
		e.step = true;
		Frame frame = new Frame(e, m1);
		frame.initialize();
		e.frames.add(frame);

		Execution e2 = new Execution(group2);
		e2.step = true;
		Frame frame2 = new Frame(e2, m2);
		frame2.initialize();
		e2.frames.add(frame2);
		
		frame.other = frame2;
		frame2.other = frame;
		
		ParallellMappingExecutor parallel = new ParallellMappingExecutor(e, e2);
		ParallelExecutorMapping mappings = new ParallelExecutorMapping(m1.getClassFile().getGroup(),
			m2.getClassFile().getGroup());
		
		mappings.m1 = m1;
		mappings.m2 = m2;
		
		parallel.mappings = mappings;

		int same = 0;
		while (parallel.step())
		{
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;
			
			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction(),
				mi2 = (MappableInstruction) p2.getInstruction();

			boolean isSame = mi1.isSame(p1, p2);
			assert isSame == mi2.isSame(p2, p1)
				: "isSame fail " + p1.getInstruction() + " <> " + p2.getInstruction();
			
			if (!isSame)
			{
				mappings.crashed = true;
				p1.getFrame().stop();
				p2.getFrame().stop();
				continue;
			}

			++same;
			mi1.map(mappings, p1, p2);
		}

		mappings.same = same;
		
		return mappings;
	}
	
	public static boolean isMappable(InvokeInstruction ii)
	{
		String className;
		
		net.runelite.asm.pool.Method m = ii.getMethod();
		className = m.getClazz().getName();

		if (className.startsWith("java/lang/reflect/") || className.startsWith("java/io/") || className.startsWith("java/util/"))
			return true;
		
		if (className.startsWith("java/") || className.startsWith("netscape/") || className.startsWith("javax/"))
			return false;
		
		return true;
	}
	
	public static boolean isInlineable(Instruction i)
	{
		if (!(i instanceof InvokeStatic))
			return false;

		ClassGroup group = i.getInstructions().getCode().getMethod().getClassFile().getGroup();
		InvokeStatic is = (InvokeStatic) i;
		net.runelite.asm.pool.Method m = is.getMethod();

		return group.findClass(m.getClazz().getName()) != null;
	}
	
	public static InstructionContext resolve(
		InstructionContext ctx,
		StackContext from // pushed from ctx
	)
	{
		if (ctx.getInstruction() instanceof SetFieldInstruction)
		{
			StackContext s = ctx.getPops().get(0);
			return resolve(s.getPushed(), s);
		}

		if (ctx.getInstruction() instanceof ConversionInstruction)
		{
			// assume it pops one and pushes one
			StackContext s = ctx.getPops().get(0);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof DupInstruction)
		{
			DupInstruction d = (DupInstruction) ctx.getInstruction();
			StackContext s = d.getOriginal(from);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof ArrayLoad)
		{
			// might be multidimensional array
			StackContext s = ctx.getPops().get(1); // the array
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			Variables variables = ctx.getVariables();
			
			if (lvt.store())
			{
				StackContext s = ctx.getPops().get(0); // is this right?
				return resolve(s.getPushed(), s);
			}
			else
			{
				VariableContext vctx = variables.get(lvt.getVariableIndex()); // variable being loaded
				assert vctx != null;

				InstructionContext storedCtx = vctx.getInstructionWhichStored();
				if (storedCtx == null)
					return ctx; // initial parameter
				
				if (vctx.isIsParameter())
				{
					// Normally storedCtx being an InvokeInstruction means that this resolves to the
					// return value of an invoke instruction, but if the variable is a parameter, it means
					// this storedCtx is the invoke instruction which called this method.
					assert storedCtx.getInstruction() instanceof InvokeInstruction;
					// In PME non static functions are never stepped into/aren't inline obfuscated
					assert storedCtx.getInstruction() instanceof InvokeStatic;
					
					// Figure out parameter index from variable index.
					Signature sig = ctx.getFrame().getMethod().getDescriptor(); // signature of current method
					int paramIndex = 0;
					for (int lvtIndex = 0 /* static */;
						paramIndex < sig.size();
						lvtIndex += sig.getTypeOfArg(paramIndex++).getSize())
						if (lvtIndex == lvt.getVariableIndex())
							break;
					assert paramIndex < sig.size();

					// Get stack context that was popped by the invoke
					// pops[0] is the first thing popped, which is the last parameter.
					StackContext sctx = storedCtx.getPops().get(sig.size() - 1 - paramIndex);
					return resolve(sctx.getPushed(), sctx);
				}
				
				return resolve(storedCtx, null);
			}
		}

		if (ctx.getInstruction() instanceof InvokeStatic)
		{
			if (from.returnSource != null)
			{
				return resolve(from.returnSource.getPushed(), from.returnSource);
			}
		}
		
		return ctx;
	}

	public static boolean isMaybeEqual(Type t1, Type t2)
	{
		if (t1.getDimensions() != t2.getDimensions())
			return false;

		while (t1.getDimensions() > 0)
		{
			t1 = t1.getSubtype();
			t2 = t2.getSubtype();
		}

		if (t1.isPrimitive() || t2.isPrimitive())
			return t1.equals(t2);

		return true;
	}

	public static boolean isMaybeEqual(Signature s1, Signature s2)
	{
		if (s1.size() != s2.size())
			return false;

		if (!isMaybeEqual(s1.getReturnValue(), s2.getReturnValue()))
			return false;

		for (int i = 0; i < s1.size(); ++i)
		{
			Type t1 = s1.getTypeOfArg(i), t2 = s2.getTypeOfArg(i);

			if (!isMaybeEqual(t1, t2))
				return false;
		}

		return true;
	}

	public static boolean isMaybeEqual(ClassFile cf1, ClassFile cf2)
	{
		if (cf1 == null && cf2 == null)
			return true;
		
		if (cf1 == null || cf2 == null)
			return false;
		
		if (cf1.getParent() != null || cf2.getParent() != null)
		{
			if (!isMaybeEqual(cf1.getParent(), cf2.getParent()))
				return false;
		}
		else
		{
			// otherwise parents are not our classes
			if (!cf1.getParentClass().equals(cf2.getParentClass()))
				return false;
		}
		
		Interfaces i1 = cf1.getInterfaces(), i2 = cf2.getInterfaces();
		if (i1.getInterfaces().size() != i2.getInterfaces().size())
			return false;
		
		return true;
	}
	
	public static boolean isMaybeEqual(Field f1, Field f2)
	{
		if (f1 == null && f2 == null)
			return true;
		
		if (f1 == null || f2 == null)
			return false;
		
		if (f1.isStatic() != f2.isStatic())
			return false;
		
		return isMaybeEqual(f1.getType(), f2.getType());
	}
}
