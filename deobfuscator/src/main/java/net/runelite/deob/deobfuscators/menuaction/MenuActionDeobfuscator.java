/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.menuaction;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPEQ;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPGE;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPGT;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPLE;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPLT;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPNE;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sort the ifs in menuAction
 *
 * @author Adam
 */
public class MenuActionDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MenuActionDeobfuscator.class);

	private static final int THRESHOLD_EQ = 50;
	private static final int THRESHOLD_LT = 1;

	@Override
	public void run(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				run(m);
			}
		}
	}

	private void run(Method method)
	{
		if (method.getCode() == null)
		{
			return;
		}

		Execution execution = new Execution(method.getClassFile().getGroup());
		execution.addMethod(method);
		execution.noInvoke = true;

		Multimap<Integer, Comparison> comps = HashMultimap.create();

		execution.addExecutionVisitor((InstructionContext ictx) ->
		{
			Instruction i = ictx.getInstruction();
			Frame frame = ictx.getFrame();

			if (i instanceof If)
			{
				InstructionContext ctx1 = ictx.getPops().get(0).getPushed(); // constant
				InstructionContext ctx2 = ictx.getPops().get(1).getPushed(); // lvt

				if (ctx1.getInstruction() instanceof PushConstantInstruction
					&& ctx2.getInstruction() instanceof LVTInstruction)
				{
					Comparison comparison = new Comparison();
					comparison.cmp = i;
					comparison.ldc = ctx1.getInstruction();
					comparison.lvt = (LVTInstruction) ctx2.getInstruction();

					comps.put(comparison.lvt.getVariableIndex(), comparison);
				}
			}
		});

		execution.run();

		for (int i : comps.keySet())
		{
			Collection<Comparison> get = comps.get(i);
			long l = get.stream().filter(c -> c.cmp.getType() == IF_ICMPGE
				|| c.cmp.getType() == IF_ICMPGT
				|| c.cmp.getType() == IF_ICMPLE
				|| c.cmp.getType() == IF_ICMPLT
			).count();

			List<Comparison> eqcmp = get.stream()
				.filter(c -> c.cmp.getType() == IF_ICMPEQ || c.cmp.getType() == IF_ICMPNE)
				.collect(Collectors.toList());

			if (get.size() > THRESHOLD_EQ && l <= THRESHOLD_LT)
			{
				logger.info("Sorting {} comparisons in {}", eqcmp.size(), method);
				insert(method, eqcmp);
			}
		}
	}

	private void insert(Method method, List<Comparison> comparisons)
	{
		Instructions instructions = method.getCode().getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		// replace all if(var == constant) with a jump to the false branch
		// then, insert before the first jump the ifs to jump to the old
		// true branch
		//
		// this is probably actually lookupswitch but it isn't mappable
		// currently...
		int min = -1;

		for (Comparison comp : comparisons)
		{
			if (min == -1)
			{
				min = ins.indexOf(comp.lvt);
			}
			else
			{
				min = Math.min(min, ins.indexOf(comp.lvt));
			}

			if (comp.cmp.getType() == InstructionType.IF_ICMPEQ)
			{
				If cmp = (If) comp.cmp;

				// remove
				instructions.remove(comp.ldc);
				instructions.remove((Instruction) comp.lvt);
				instructions.remove(comp.cmp);

				comp.next = cmp.getJumps().get(0);
			}
			else if (comp.cmp.getType() == InstructionType.IF_ICMPNE)
			{
				// replace with goto dest
				If cmp = (If) comp.cmp;

				int idx = ins.indexOf(cmp);
				assert idx != -1;
				comp.next = instructions.createLabelFor(ins.get(idx + 1));

				instructions.remove(comp.ldc);
				instructions.remove((Instruction) comp.lvt);

				instructions.replace(comp.cmp, new Goto(instructions, cmp.getJumps().get(0)));
			}
			else
			{
				throw new IllegalStateException();
			}
		}

		assert min != -1;

		// sort comparisons - but if they jump to the same address, they are equal..
		List<Comparison> sortedComparisons = new ArrayList<>(comparisons);
		Collections.sort(sortedComparisons, (c1, c2) -> compare(comparisons, c1, c2));

		// reinsert jumps
		for (int i = 0; i < sortedComparisons.size(); ++i)
		{
			Comparison comp = sortedComparisons.get(i);
			Instruction lvt = (Instruction) comp.lvt;

			lvt.setInstructions(instructions);
			comp.ldc.setInstructions(instructions);

			instructions.addInstruction(min++, lvt);
			instructions.addInstruction(min++, comp.ldc);

			// use if_icmpeq if what follows also jumps to the same location
			boolean multiple = i + 1 < sortedComparisons.size()
				&& sortedComparisons.get(i + 1).next == comp.next;
			if (multiple)
			{
				instructions.addInstruction(min++, new IfICmpEq(instructions, comp.next));
			}
			else
			{

				// fernflower decompiles a series of if_icmpeq as chains of not equal expressions
				Label label = instructions.createLabelFor(ins.get(min));
				instructions.addInstruction(min++, new IfICmpNe(instructions, label));
				instructions.addInstruction(min++, new Goto(instructions, comp.next));
				++min; // go past label
			}
		}
	}

	private int compare(List<Comparison> comparisons, Comparison c1, Comparison c2)
	{
		// Compare by constant

		assert comparisons.contains(c1);
		assert comparisons.contains(c2);

		// The constant of a comparison is the lowest comparison that jumps to the same location,
		// if all jumps to the same label are in the same location fernflower will decompile
		// to if (foo || bar)
		Comparison mc1 = comparisons.stream()
			.filter(c -> c1.next == c.next)
			.min((m1, m2) -> Integer.compare(m1.getConstant().intValue(), m2.getConstant().intValue()))
			.get();

		Comparison mc2 = comparisons.stream()
			.filter(c -> c2.next == c.next)
			.min((m1, m2) -> Integer.compare(m1.getConstant().intValue(), m2.getConstant().intValue()))
			.get();

		return Integer.compare(mc1.getConstant().intValue(), mc2.getConstant().intValue());
	}
}
