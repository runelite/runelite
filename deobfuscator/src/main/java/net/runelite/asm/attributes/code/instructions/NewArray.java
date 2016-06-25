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
import net.runelite.asm.attributes.code.instruction.types.IntInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import org.objectweb.asm.MethodVisitor;

public class NewArray extends Instruction implements IntInstruction
{
	private int type;

	public NewArray(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public int getArrayType()
	{
		return type;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitIntInsn(this.getType().getCode(), type & 0xFF);
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext count = stack.pop();
		ins.pop(count);
		
		Class<?> t = null;
		switch (type)
		{
			case 4:
				t = boolean.class;
				break;
			case 5:
				t = char.class;
				break;
			case 6:
				t = float.class;
				break;
			case 7:
				t = double.class;
				break;
			case 8:
				t = byte.class;
				break;
			case 9:
				t = short.class;
				break;
			case 10:
				t = int.class;
				break;
			case 11:
				t = long.class;
				break;
			default:
				throw new IllegalStateException("unknown array type " + type);
		}
		
		StackContext ctx = new StackContext(ins, new Type(t.getName() + "[]"), Value.newArray(count.getValue()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

	@Override
	public int getOperand()
	{
		return type;
	}

	@Override
	public void setOperand(int operand)
	{
		type = operand;
	}

}
