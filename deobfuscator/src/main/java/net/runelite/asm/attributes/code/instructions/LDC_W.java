/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import org.objectweb.asm.MethodVisitor;

public class LDC_W extends Instruction implements PushConstantInstruction
{
	private Object value;

	public LDC_W(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
		
		assert type == InstructionType.LDC_W || type == InstructionType.LDC;
	}
	
	public LDC_W(Instructions instructions, Object value)
	{
		super(instructions, InstructionType.LDC_W);
		
		assert !(value instanceof Long);
		assert !(value instanceof Double);
		
		this.value = value;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		Object object = getConstant();
		if (object instanceof net.runelite.asm.pool.Class)
		{
			net.runelite.asm.pool.Class cl = (net.runelite.asm.pool.Class) object;
			org.objectweb.asm.Type type = org.objectweb.asm.Type.getType("L" + cl.getName().replace('.', '/') + ";");
			visitor.visitLdcInsn(type);
		}
		else
		{
			visitor.visitLdcInsn(object);
		}
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, Type.fromBoxedPrimitive(value), new Value(value));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}
	
	
	@Override
	public String toString()
	{
		return "ldc_w " + value;
	}

	@Override
	public Object getConstant()
	{
		return value;
	}

	@Override
	public Instruction setConstant(Object entry)
	{
		value = entry;
		
		assert !(value instanceof Long);
		assert !(value instanceof Double);
		
		return this;
	}
	
	@Override
	public Instruction makeSpecific()
	{
		if (value instanceof Integer)
		{
			int i = (int) value;

			switch (i)
			{
				case -1:
					return new IConst_M1(this.getInstructions());
				case 0:
					return new IConst_0(this.getInstructions());
				case 1:
					return new IConst_1(this.getInstructions());
				case 2:
					return new IConst_2(this.getInstructions());
				case 3:
					return new IConst_3(this.getInstructions());
				case 4:
					return new IConst_4(this.getInstructions());
				case 5:
					return new IConst_5(this.getInstructions());
			}
		}
		
		return super.makeSpecific();
	}
	
	public int getConstantAsInt()
	{
		return (int) value;
	}
	
	public Number getNumber()
	{
		return (Number) value;
	}
}
