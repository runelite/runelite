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
package net.runelite.deob.deobfuscators.exprargorder;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import static net.runelite.asm.attributes.code.InstructionType.IADD;
import static net.runelite.asm.attributes.code.InstructionType.IF_ACMPEQ;
import static net.runelite.asm.attributes.code.InstructionType.IF_ACMPNE;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPEQ;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPNE;
import static net.runelite.asm.attributes.code.InstructionType.IMUL;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.IfACmpEq;
import net.runelite.asm.attributes.code.instructions.IfACmpNe;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExprArgOrder implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(ExprArgOrder.class);

	private final List<Instruction> exprIns = new ArrayList<>();
	private final Map<Instruction, Expression> exprs = new HashMap<>();
	private int count;

	static boolean isCommutative(InstructionType type)
	{
		switch (type)
		{
			case IADD:
			case IMUL:
			case IF_ICMPEQ:
			case IF_ICMPNE:
			case IF_ACMPEQ:
			case IF_ACMPNE:
				return true;
			default:
				return false;
		}
	}

	private Instruction newInstruction(Instructions ins, Instruction old, InstructionType type)
	{
		assert isCommutative(type) : "type is " + type;

		switch (type)
		{
			case IADD:
				return new IAdd(ins);
			case IMUL:
				return new IMul(ins);
			case IF_ICMPEQ:
			{
				If i = (If) old;
				return new IfICmpEq(ins, i.getJumps().get(0));
			}
			case IF_ICMPNE:
			{
				If i = (If) old;
				return new IfICmpNe(ins, i.getJumps().get(0));
			}
			case IF_ACMPEQ:
			{
				If i = (If) old;
				return new IfACmpEq(ins, i.getJumps().get(0));
			}
			case IF_ACMPNE:
			{
				If i = (If) old;
				return new IfACmpNe(ins, i.getJumps().get(0));
			}
			default:
				throw new IllegalStateException();
		}
	}

	private void parseExpr(Expression expr, InstructionContext ctx)
	{
		InstructionType type = ctx.getInstruction().getType();

		List<StackContext> pops = ctx.getPops();

		for (StackContext sctx : pops)
		{
			InstructionContext i = sctx.getPushed();

			if (isCommutative(type) && i.getInstruction().getType() == type)
			{
				parseExpr(expr, i);
			}
			else if (isCommutative(type))
			{
				Expression sub = new Expression(i);
				parseExpr(sub, i);
				expr.addComExpr(sub);
			}
			else
			{
				Expression sub = new Expression(i);
				parseExpr(sub, i);
				expr.addExpr(sub);
			}

			exprIns.remove(i.getInstruction());
			exprs.remove(i.getInstruction()); // remove sub expr
		}
	}

	private void visit(InstructionContext ctx)
	{
		Instruction ins = ctx.getInstruction();

		if (ins instanceof IAdd || ins instanceof IMul
			|| ins instanceof IfICmpEq || ins instanceof IfICmpNe
			|| ins instanceof IfACmpEq || ins instanceof IfACmpNe)
		{
			Expression expression = new Expression(ctx);
			parseExpr(expression, ctx);
			if (!exprs.containsKey(ins))
			{
				exprIns.add(ins);
				exprs.put(ins, expression);
			}
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
		if (idx == -1)
		{
			return false;
		}

		for (InstructionContext ictx : ctxs)
		{
			for (StackContext sctx : ictx.getPops())
			{
				Instruction pushed = sctx.getPushed().getInstruction();

				int idx2 = ins.getInstructions().indexOf(pushed);
				if (idx2 == -1)
				{
					return false;
				}

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
		Instruction i = ic.getInstruction();
		assert i.getInstructions() == null;

		int idx = ins.getInstructions().indexOf(before);
		assert idx != -1;

		i.setInstructions(ins);
		ins.addInstruction(idx, i);
	}

	public static int hash(Method method, InstructionContext ic)
	{
		MessageDigest sha256;
		try
		{
			sha256 = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}

		hash(method, sha256, ic);
		byte[] res = sha256.digest();
		return Ints.fromByteArray(res);
	}

	private static void hash(Method method, MessageDigest sha256, InstructionContext ic)
	{
		Instruction i = ic.getInstruction();

		// this relies on all push constants are converted to ldc..
		sha256.update((byte) i.getType().getCode());

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

				lvt += type.getSize();
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

	public static int compare(Method method, InstructionType type, InstructionContext ic1, InstructionContext ic2)
	{
		Instruction i1 = ic1.getInstruction();
		Instruction i2 = ic2.getInstruction();

		if (type == IF_ICMPEQ || type == IF_ICMPNE
			|| type == IADD || type == IMUL)
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

		if (type == IF_ACMPEQ || type == IF_ACMPNE)
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

	public static int compare(Method method, InstructionType type, Expression expr1, Expression expr2)
	{
		Instruction i1 = expr1.getHead().getInstruction();
		Instruction i2 = expr2.getHead().getInstruction();

		if (type == IF_ICMPEQ || type == IF_ICMPNE
			|| type == IADD || type == IMUL)
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

		if (type == IF_ACMPEQ || type == IF_ACMPNE)
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

		int hash1 = hash(method, expr1.getHead());
		int hash2 = hash(method, expr2.getHead());

		if (hash1 == hash2)
		{
			logger.debug("Unable to differentiate {} from {}", expr1.getHead(), expr2.getHead());
		}

		return Integer.compare(hash1, hash2);
	}

	private void insert(Instructions ins, Instruction next, Expression expression)
	{
		int count = 0;

		if (expression.sortedExprs != null)
		{
			for (Expression sub : expression.sortedExprs)
			{
				if (count == 2)
				{
					Instruction newOp;
					if (isCommutative(expression.getType()))
					{
						// there might be >2 sortedExprs so we can't reuse instructions
						newOp = newInstruction(ins, expression.getHead().getInstruction(), expression.getType());
					}
					else
					{
						newOp = expression.getHead().getInstruction();
						assert newOp.getInstructions() == null;
						newOp.setInstructions(ins);
					}

					int idx = ins.getInstructions().indexOf(next);
					assert idx != -1;

					ins.addInstruction(idx, newOp);
					count = 1;
				}

				insert(ins, next, sub);
				++count;
			}
		}

		List<Expression> reverseExpr = new ArrayList<>(expression.getExprs());
		Collections.reverse(reverseExpr);
		for (Expression sub : reverseExpr)
		{
			insert(ins, next, sub);
		}

		insert(ins, expression.getHead(), next);
	}

	private void visit(MethodContext ctx)
	{
		Instructions ins = ctx.getMethod().getCode().getInstructions();

		for (Instruction i : exprIns)
		{
			Expression expression = exprs.get(i);
			assert expression != null;

			if (!canRemove(ctx, ins, i))
			{
				continue;
			}

			int idx = ins.getInstructions().indexOf(expression.getHead().getInstruction());
			assert idx != -1;

			// get next instruction
			Instruction next = ins.getInstructions().get(idx + 1);;

			// remove expression
			remove(ins, expression.getHead());

			// sort expression
			expression.sort(ctx);

			// insert expression
			insert(ins, next, expression);

			++count;
		}

		exprIns.clear();
		exprs.clear();
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
