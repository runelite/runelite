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
package net.runelite.deob.deobfuscators.exprargorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;

public class Expression
{
	private final InstructionType type;
	private final InstructionContext head;
	private final List<Expression> exprs = new ArrayList<>();
	private final List<InstructionContext> ins = new ArrayList<>();

	public List<Expression> sortedExprs;
	public List<InstructionContext> sortedIns;
	private int exprHash;

	public Expression(InstructionType type, InstructionContext head)
	{
		this.type = type;
		this.head = head;
	}

	public InstructionType getType()
	{
		return type;
	}

	public InstructionContext getHead()
	{
		return head;
	}

	public void addExpr(Expression expr)
	{
		exprs.add(expr);
	}

	public List<Expression> getExprs()
	{
		return Collections.unmodifiableList(exprs);
	}

	public void addInstruction(InstructionContext ctx)
	{
		ins.add(ctx);
	}

	public List<InstructionContext> getIns()
	{
		return Collections.unmodifiableList(ins);
	}

	public void sort(MethodContext ctx)
	{
		for (Expression e : exprs)
		{
			e.sort(ctx);
		}

		// sort instructions
		sortedIns = new ArrayList<>(ins);
		Collections.sort(sortedIns, (i1, i2) -> ExprArgOrder.compare(ctx.getMethod(), head.getInstruction().getType(), i1, i2));
		Collections.reverse(sortedIns);

		// sort sub exprs
		sortedExprs = new ArrayList<>(exprs);
		Collections.sort(sortedExprs, (e1, e2) -> Integer.compare(e1.exprHash, e2.exprHash));

		int hash = 0;
		for (InstructionContext ic : sortedIns)
		{
			hash ^= ExprArgOrder.hash(ctx.getMethod(), ic);
		}
		for (Expression e : sortedExprs)
		{
			hash ^= e.exprHash;
		}
		exprHash = hash;
	}
}
