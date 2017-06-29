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
package net.runelite.deob.deobfuscators;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IfACmpEq;
import net.runelite.asm.attributes.code.instructions.IfACmpNe;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExprArgOrder implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(ExprArgOrder.class);

	private static final MessageDigest sha256;

	private final Set<Instruction> swap = new HashSet<>();
	private int count;

	static
	{
		try
		{
			sha256 = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	private void visit(InstructionContext ctx)
	{
		Instruction ins = ctx.getInstruction();

		if (ins instanceof IAdd || ins instanceof IMul)
		{
			swap.add(ins);
		}
		if (ins instanceof IfICmpEq || ins instanceof IfICmpNe
			|| ins instanceof IfACmpEq || ins instanceof IfACmpNe)
		{
			swap.add(ins);
		}
	}

	private boolean canRemove(MethodContext mctx, Instructions ins, Instruction i)
	{
		Set<InstructionContext> ctxs = new HashSet<>(mctx.getInstructonContexts(i));

		if (!alwaysPoppedBySameInstruction(ctxs, i) || !alwaysPopsFromSameInstructions(ctxs, i))
		{
			return false;
		}

		if (i instanceof InvokeInstruction)
		{
			// don't ever order lhs/rhs if an invoke is involved?
			// func1() + func2() vs func2() + func1() is not the same thing
			return false;
		}

		int idx = ins.getInstructions().indexOf(i);
		assert idx != -1;

		for (InstructionContext ictx : ctxs)
		{
			for (StackContext sctx : ictx.getPops())
			{
				Instruction pushed = sctx.getPushed().getInstruction();

				int idx2 = ins.getInstructions().indexOf(pushed);
				assert idx2 != -1;

				assert idx > idx2;

				// If there is a lvt store (incl iinc!) between the two
				// instructions, we can't move them
				for (int j = idx2; j <= idx; ++j)
				{
					Instruction i2 = ins.getInstructions().get(j);
					if (i2 instanceof LVTInstruction)
					{
						if (((LVTInstruction) i2).store())
						{
							return false;
						}
					}
					if (i2 instanceof IInc)
					{
						return false;
					}
				}

				if (!canRemove(mctx, ins, pushed))
				{
					return false;
				}
			}
		}

		return true;

	}

	private void remove(Instructions ins, InstructionContext ic)
	{
		ins.remove(ic.getInstruction());

		for (StackContext sc : ic.getPops())
		{
			assert sc.getPopped().size() == 1;
			remove(ins, sc.getPushed());
		}
	}

	private void insert(Instructions ins, InstructionContext ic, Instruction before)
	{
		List<StackContext> pops = new ArrayList<>(ic.getPops());
		Collections.reverse(pops);
		for (StackContext sc : pops)
		{
			insert(ins, sc.getPushed(), before);
		}

		Instruction i = ic.getInstruction();
		assert i.getInstructions() == null;

		int idx = ins.getInstructions().indexOf(before);
		assert idx != -1;

		i.setInstructions(ins);
		ins.addInstruction(idx, i);
	}

	private int hash(Method method, InstructionContext ic)
	{
		hash(method, sha256, ic);
		byte[] res = sha256.digest();
		return Ints.fromByteArray(res);
	}

	private void hash(Method method, MessageDigest sha256, InstructionContext ic)
	{
		sha256.update((byte) ic.getInstruction().getType().getCode());

		Instruction i = ic.getInstruction();
		if (i instanceof PushConstantInstruction)
		{
			PushConstantInstruction pci = (PushConstantInstruction) i;
			Object constant = pci.getConstant();
			if (constant instanceof Number)
			{
				long l = ((Number) constant).longValue();
				sha256.update(Longs.toByteArray(l));
			}
		}
		else if (i instanceof LVTInstruction)
		{
			int idx = ((LVTInstruction) i).getVariableIndex();
			Signature signature = method.getDescriptor();
			
			int lvt = method.isStatic() ? 0 : 1;
			for (Type type : signature.getArguments())
			{
				if (idx == lvt)
				{
					// Accessing a method parameter
					sha256.update(Ints.toByteArray(idx));
					break;
				}
				
				lvt += type.getSlots();
			}
		}

		for (StackContext sctx : ic.getPops())
		{
			hash(method, sha256, sctx.getPushed());
		}
	}

	private boolean alwaysPopsFromSameInstructions(Set<InstructionContext> instructonContexts, Instruction i)
	{
		InstructionContext ictx = instructonContexts.iterator().next();

		for (InstructionContext i2 : instructonContexts)
		{
			if (!i2.equals(ictx))
			{
				// this instruction doesn't always pop the same thing
				return false;
			}
		}

		return true;
	}

	private boolean alwaysPoppedBySameInstruction(Set<InstructionContext> instructonContexts, Instruction i)
	{
		Set<Instruction> c = new HashSet<>();

		for (InstructionContext i2 : instructonContexts)
		{
			i2.getPushes().stream()
				.flatMap(sctx -> sctx.getPopped().stream())
				.map(ic -> ic.getInstruction())
				.forEach(i3 -> c.add(i3));
		}

		return c.size() <= 1;
	}

	private int compare(Method method, Instruction ins, InstructionContext ic1, InstructionContext ic2)
	{
		Instruction i1 = ic1.getInstruction();
		Instruction i2 = ic2.getInstruction();

		if (ins instanceof IfICmpEq || ins instanceof IfICmpNe
			|| ins instanceof IAdd || ins instanceof IMul)
		{
			if (!(i1 instanceof PushConstantInstruction)
				&& (i2 instanceof PushConstantInstruction))
			{
				return 1;
			}

			if (i1 instanceof PushConstantInstruction
				&& !(i2 instanceof PushConstantInstruction))
			{
				return -1;
			}
		}

		if (ins instanceof IfACmpEq || ins instanceof IfACmpNe)
		{
			if (!(i1 instanceof AConstNull)
				&& (i2 instanceof AConstNull))
			{
				return 1;
			}

			if (i1 instanceof AConstNull
				&& !(i2 instanceof AConstNull))
			{
				return -1;
			}
		}

		int hash1 = hash(method, ic1);
		int hash2 = hash(method, ic2);

		if (hash1 == hash2)
		{
			logger.debug("Unable to differentiate {} from {}", ic1, ic2);
		}

		return Integer.compare(hash1, hash2);
	}

	private void visit(MethodContext ctx)
	{
		Instructions ins = ctx.getMethod().getCode().getInstructions();

		for (Instruction i : swap)
		{
			if (!canRemove(ctx, ins, i))
			{
				continue;
			}

			InstructionContext ictx = ctx.getInstructonContexts(i).iterator().next();

			StackContext one = ictx.getPops().get(0),
				two = ictx.getPops().get(1);

			InstructionContext ic1 = one.getPushed(),
				ic2 = two.getPushed();

			Instruction i1 = ic1.getInstruction(),
				i2 = ic2.getInstruction();

			if (i1.getInstructions() == null || i2.getInstructions() == null)
			{
				continue;
			}

			assert i1.getInstructions() == ins;
			assert i2.getInstructions() == ins;

			assert ins.getInstructions().contains(i1);
			assert ins.getInstructions().contains(i2);

			int cval = compare(ctx.getMethod(), i, ic1, ic2);
			if (cval <= 0)
			{
				continue;
			}

			remove(ins, ic1);
			remove(ins, ic2);

			insert(ins, ic1, i);
			insert(ins, ic2, i);

			++count;
		}

		swap.clear();
	}

	@Override
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> visit(i));
		execution.addMethodContextVisitor(i -> visit(i));
		execution.populateInitialMethods();
		execution.run();

		logger.info("Reordered {} expressions", count);
	}
}
