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

package net.runelite.deob.deobfuscators.arithmetic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.LAdd;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.LSub;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.Swap;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiplicationDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MultiplicationDeobfuscator.class);
	
	private ClassGroup group;
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		
		int i;
		int count = 0;
		while ((i = runOnce()) > 0)
		{
			logger.info("Replaced " + i + " constants");
			count += i;
		}
		logger.info("Total changed " + count);
	}
	
	public static MultiplicationExpression parseExpression(InstructionContext ctx, Class want)
	{
		MultiplicationExpression me = new MultiplicationExpression();
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			
			// loading a variable
			if (!lvt.store())
			{
				int idx = lvt.getVariableIndex(); // var index
				Variables vars = ctx.getVariables(); // variables at time of execution
				
				VariableContext vctx = vars.get(idx); // get the variable
				
				if (vctx.getRead().size() == 1) // ?
				{
					InstructionContext storeCtx = vctx.getInstructionWhichStored(); // this is an istore
					if (storeCtx.getInstruction() instanceof LVTInstruction)
					{
						// invoking funcs can put stuff in lvt
						
						LVTInstruction storelvt = (LVTInstruction) storeCtx.getInstruction();

						if (storelvt instanceof IInc)
							throw new IllegalStateException();

						assert storelvt.store();

						InstructionContext pushed = storeCtx.getPops().get(0).getPushed();
						return parseExpression(pushed, want);
					}
				}
			}
		}
		
		if (ctx.getInstruction() instanceof PushConstantInstruction)
		{
			if (ctx.getInstruction() instanceof BiPush || ctx.getInstruction() instanceof SiPush)
			{
				throw new IllegalStateException();
			}

			me.instructions.add(ctx);
			return me;
		}
		
		for (StackContext sctx : ctx.getPops())
		{
			if (ctx.getInstruction().getClass() == want)
			{
				if (!isOnlyPath(ctx, sctx))
					continue;
			}
			
			InstructionContext i = sctx.getPushed();
			
			// if this instruction is imul, look at pops
			if (ctx.getInstruction().getClass() == want)
			{
				if (i.getInstruction() instanceof Swap)
				{
					logger.debug("Resolving swap");
					
					Swap swap = (Swap) i.getInstruction();
					sctx = swap.getOriginal(sctx);
					i = sctx.getPushed();
				}

				if (i.getInstruction() instanceof PushConstantInstruction)
				{
					// bipush/sipush are always not obfuscated
					if (i.getInstruction() instanceof BiPush || i.getInstruction() instanceof SiPush)
						continue;
					
					// a constant of imul
					me.instructions.add(i);
				}
				else if (i.getInstruction().getClass() == want)
				{
					// chained imul, append to me
					try
					{
						MultiplicationExpression other = parseExpression(i, want);
						if (other.dupmagic != null)
						{
							assert me.dupmagic == null;
							me.dupmagic = other.dupmagic;
						}

						me.instructions.addAll(other.instructions);
						me.dupedInstructions.addAll(other.dupedInstructions);
						me.subexpressions.addAll(other.subexpressions);
					}
					catch (IllegalStateException ex)
					{
						// this is ok? just don't include it?
					}
				}
				else if (i.getInstruction() instanceof IAdd || i.getInstruction() instanceof ISub
					|| i.getInstruction() instanceof LAdd || i.getInstruction() instanceof LSub)
				{
					// imul using result of iadd or isub. evaluate expression
					try
					{
						MultiplicationExpression other = parseExpression(i, want);
						assert other.dupmagic == null;

						// subexpr
						me.subexpressions.add(other);
					}
					catch (IllegalStateException ex)
					{
						assert me.subexpressions.isEmpty();
						// subexpression is too complex. we can still simplify the top level though
					}
				}
				else if (i.getInstruction() instanceof DupInstruction)
				{
					DupInstruction dup = (DupInstruction) i.getInstruction();
					
					// find other branch of the dup instruction
					// sctx = what dup pushed, find other
					StackContext otherCtx = dup.getOtherBranch(sctx); // other side of dup
					InstructionContext otherCtxI = otherCtx.getPopped().get(0); // what popped other side of dup. is this right?

					if (otherCtxI.getInstruction().getClass() == want)
					{
						//assert otherCtxI.getInstruction() instanceof IMul;

						InstructionContext pushConstant = otherCtxI.getPops().get(0).getPushed(); // other side of that imul
						assert pushConstant.getInstruction() instanceof LDC;

						me.dupmagic = pushConstant;

						StackContext orig = dup.getOriginal(sctx); // original
						try
						{
							MultiplicationExpression other = parseExpression(orig.getPushed(), want);
							// this expression is used elsewhere like 'pushConstant' so any changes
							// done to it affect that, too. so multiply it by existing values?
							if (orig.getPushed().getInstruction() instanceof IAdd || orig.getPushed().getInstruction() instanceof ISub
								|| orig.getPushed().getInstruction() instanceof LAdd || orig.getPushed().getInstruction() instanceof LSub)
							{
								me.subexpressions.add(other);
							}
							else
							{
								assert other.dupmagic == null;
								me.instructions.addAll(other.instructions);
								me.dupedInstructions.addAll(other.instructions);
								me.subexpressions.addAll(other.subexpressions);
							}
						}
						catch (IllegalStateException ex)
						{
							assert me.subexpressions.isEmpty();
						}
					}
				}
				else if (i.getInstruction() instanceof GetFieldInstruction)
				{
					me.fieldInstructions.add(i);
					// non constant, ignore
				}
				else
				{
					//System.out.println("imul pops something I don't know " + i.getInstruction());
				}
			}
			// this is an iadd/sub
			else if (ctx.getInstruction() instanceof IAdd || ctx.getInstruction() instanceof ISub
				|| ctx.getInstruction() instanceof LAdd || ctx.getInstruction() instanceof LSub)
			{
				MultiplicationExpression other = parseExpression(i, want); // parse this side of the add/sub
				
				me.subexpressions.add(other);
			}
			else
			{
				//System.out.println(ctx.getInstruction() + " pops something I dont know " + i.getInstruction());
			}
		}
		
		if (me.instructions.isEmpty() && me.subexpressions.isEmpty())
			throw new IllegalStateException();
		
		return me;
	}

	// one = imul, two = other executeion of instruction of one, sctx = popped by imul
	private static boolean ictxEqualsDir(InstructionContext one, InstructionContext two, StackContext sctx)
	{
		assert one.getInstruction() == two.getInstruction();
		
		if (one.getInstruction() != two.getInstruction())
			return false;
		
		assert one.getPops().contains(sctx);
		int i = one.getPops().indexOf(sctx);
		
		StackContext theirsctx = two.getPops().get(i);
	
		if (sctx.getPushed().getInstruction() != theirsctx.getPushed().getInstruction())
			return false;
		
		return true;
	}

	// ctx = imul, sctx = popped by imul
	public static boolean isOnlyPath(InstructionContext ctx, StackContext sctx)
	{
		assert ctx.getInstruction() instanceof IMul || ctx.getInstruction() instanceof LMul;
		
		Collection<InstructionContext> ins = ctx.getFrame().getMethodCtx().getInstructonContexts(ctx.getInstruction());
		for (InstructionContext i : ins)
		{	
			if (sctx == null)
			{
				if (!i.equals(ctx))
				{
					return false;
				}
				
				for (StackContext sctx2 : i.getPushes())
				{
					if (sctx2.getPopped().size() > 1)
					{
						return false;
					}
				}
			}
			else
			{
				// everything which pushed the parameters must be the same
				if (!ictxEqualsDir(ctx, i, sctx))
				{
					return false;
				}

				// everything which pops the result must be the same
				Instruction poppedIns = null;
				for (StackContext s : i.getPushes())
					for (InstructionContext i2 : s.getPopped())
					{
						if (poppedIns == null)
							poppedIns = i2.getInstruction();
						else if (poppedIns != i2.getInstruction())
							return false;
					}
			}
		}
		return true;
	}
	
	private Set<Instruction> done = new HashSet<>();
	
	private void visit(MethodContext ctx)
	{
		for (InstructionContext ictx : ctx.getInstructionContexts())
		{
			Instruction instruction = ictx.getInstruction();

			if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
			{
				continue;
			}

			MultiplicationExpression expression;
			try
			{
				expression = parseExpression(ictx, instruction.getClass());
			}
			catch (IllegalStateException ex)
			{
				continue;
			}

			if (expression == null)
			{
				continue;
			}

			if (done.contains(instruction))
			{
				continue;
			}
			done.add(instruction);

			assert instruction instanceof IMul || instruction instanceof LMul;
			if (instruction instanceof IMul)
			{
				count += expression.simplify(1);
			}
			else if (instruction instanceof LMul)
			{
				count += expression.simplify(1L);
			}
			else
			{
				throw new IllegalStateException();
			}
		}
	}
	
	int count;
	
	private int runOnce()
	{
		group.buildClassGraph();
		
		count = 0;
		
		Execution e = new Execution(group);
		e.addMethodContextVisitor(m -> visit(m));
		e.populateInitialMethods();
		e.run();
		
		return count;
	}

}
