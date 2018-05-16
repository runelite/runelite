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
package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import org.objectweb.asm.MethodVisitor;

public class MultiANewArray extends Instruction
{
	private Type type;
	private int dimensions;
	private ClassFile myClass;

	public MultiANewArray(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitMultiANewArrayInsn(type.toString(), dimensions);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		Value[] lenghts = new Value[dimensions];
		for (int i = 0; i < dimensions; ++i)
		{
			StackContext ctx = stack.pop();
			ins.pop(ctx);

			lenghts[i] = ctx.getValue();
		}

		StackContext ctx = new StackContext(ins, type, Value.newArray(lenghts));
		stack.push(ctx);

		ins.push(ctx);

		return ins;
	}

	@Override
	public void lookup()
	{
		ClassGroup group = this.getInstructions().getCode().getMethod().getClassFile().getGroup();
		myClass = group.findClass(type.getInternalName());
	}

	@Override
	public void regeneratePool()
	{
		if (myClass != null)
		{
			type = Type.getType("L" + myClass.getName() + ";", type.getDimensions());
		}
	}

	public Type getArrayType()
	{
		return type;
	}

	public void setArrayType(Type type)
	{
		this.type = type;
	}

	public int getDimensions()
	{
		return this.dimensions;
	}

	public void setDimensions(int dimensions)
	{
		this.dimensions = dimensions;
	}
}
