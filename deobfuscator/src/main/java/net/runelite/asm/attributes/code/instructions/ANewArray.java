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
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.TypeInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.Class;
import org.objectweb.asm.MethodVisitor;

public class ANewArray extends Instruction implements TypeInstruction
{
	private Class clazz;
	private ClassFile myClass;
	private int dimensions;

	public ANewArray(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public ANewArray(Instructions instructions, Class clazz, int dimensions)
	{
		super(instructions, InstructionType.ANEWARRAY);
		this.clazz = clazz;
		this.dimensions = dimensions;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitTypeInsn(this.getType().getCode(), this.getType_().getFullType());
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext count = stack.pop();
		
		ins.pop(count);
		
		Type t = new Type(new net.runelite.asm.signature.Type("[" + clazz.getName()));
		StackContext ctx = new StackContext(ins, t, Value.newArray(count.getValue()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	@Override
	public void lookup()
	{
		net.runelite.asm.signature.Type t = new net.runelite.asm.signature.Type(clazz.getName());
		String name = t.getType();
		if (name.startsWith("L") && name.endsWith(";"))
			name = name.substring(1, name.length() - 1);
		ClassGroup group = this.getInstructions().getCode().getMethod().getClassFile().getGroup();
		myClass = group.findClass(name);
		dimensions = t.getArrayDims();
	}
	
	@Override
	public void regeneratePool()
	{
		if (myClass != null)
		{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < this.dimensions; ++i)
				sb.append('[');
			if (this.dimensions > 0)
				sb.append("L" + myClass.getName() + ";");
			else
				sb.append(myClass.getName());
			clazz = new Class(sb.toString());
		}
	}

	@Override
	public net.runelite.asm.signature.Type getType_()
	{
		return new net.runelite.asm.signature.Type(clazz.getName());
	}

	@Override
	public void setType(net.runelite.asm.signature.Type type)
	{
		clazz = new Class(type.getFullType());
	}
}
