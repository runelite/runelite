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
package net.runelite.asm.attributes.code.instructions;

import java.util.Collections;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.pool.Method;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;

public class InvokeDynamic extends Instruction implements InvokeInstruction
{
	private String name;
	private String desc;
	private Handle bsm;
	private Object[] bsmArgs;

	public InvokeDynamic(Instructions instructions, String name, String desc, Handle bsm, Object[] bsmArgs)
	{
		super(instructions, InstructionType.INVOKEDYNAMIC);
		this.name = name;
		this.desc = desc;
		this.bsm = bsm;
		this.bsmArgs = bsmArgs;
	}

	@Override
	public String toString()
	{
		return "invokedynamic in " + this.getInstructions().getCode().getMethod();
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
	}

	@Override
	public List<net.runelite.asm.Method> getMethods()
	{
		return Collections.EMPTY_LIST;
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		throw new UnsupportedOperationException("invokedynamic not supported");
	}

	@Override
	public void removeParameter(int idx)
	{
		throw new UnsupportedOperationException("invokedynamic not supported");
	}

	@Override
	public Method getMethod()
	{
		return null;
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		throw new UnsupportedOperationException("invokedynamic not supported");
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		throw new UnsupportedOperationException("invokedynamic not supported");
	}

	@Override
	public void setMethod(Method method)
	{
		throw new UnsupportedOperationException("invokedynamic not supported");
	}
}
