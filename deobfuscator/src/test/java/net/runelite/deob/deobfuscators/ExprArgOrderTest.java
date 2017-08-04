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

import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IConst_3;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.deob.ClassGroupFactory;
import org.junit.Assert;
import org.junit.Test;

public class ExprArgOrderTest
{
	@Test
	public void test()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new IConst_3(ins),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			// 3 + var0 -> var0 + 3
			new LDC_W(ins, 3), // 2
			new ILoad(ins, 0),
			new IAdd(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		ExprArgOrder exprArgOrder = new ExprArgOrder();
		exprArgOrder.run(group);

		List<Instruction> instructions = ins.getInstructions();

		Assert.assertEquals(InstructionType.ILOAD, instructions.get(2).getType());
		Assert.assertEquals(InstructionType.LDC_W, instructions.get(3).getType());
		Assert.assertEquals(InstructionType.IADD, instructions.get(4).getType());
	}

	@Test
	public void test2()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new IConst_3(ins),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			// var0 + 3 -> var0 + 3
			new ILoad(ins, 0), // 2
			new LDC_W(ins, 3),
			new IAdd(ins),
			new Pop(ins),
			// (3 + var0) + 512 -> (var0 + 3) + 512
			new LDC_W(ins, 3), // 6
			new ILoad(ins, 0),
			new IAdd(ins),
			new SiPush(ins, (short) 512),
			new IAdd(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		ExprArgOrder exprArgOrder = new ExprArgOrder();
		exprArgOrder.run(group);

		List<Instruction> instructions = ins.getInstructions();

		Assert.assertEquals(InstructionType.ILOAD, instructions.get(2).getType());
		Assert.assertEquals(InstructionType.LDC_W, instructions.get(3).getType());
		Assert.assertEquals(InstructionType.IADD, instructions.get(4).getType());

		Assert.assertEquals(InstructionType.ILOAD, instructions.get(6).getType());
		Assert.assertEquals(InstructionType.SIPUSH, instructions.get(7).getType());
		Assert.assertEquals(InstructionType.IADD, instructions.get(8).getType());
	}

	@Test
	public void test3()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new IConst_3(ins),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			// 512 + (3 + var1) -> var1 + 3 + 512
			new LDC_W(ins, 512),
			new IConst_3(ins),
			new ILoad(ins, 0),
			new IAdd(ins),
			new IAdd(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		ExprArgOrder exprArgOrder = new ExprArgOrder();
		exprArgOrder.run(group);

		List<Instruction> instructions = ins.getInstructions();

		// 2: iload
		// 3: iconst 3
		// 4: iadd
		// 5: ldc
		// 6: add
		Assert.assertEquals(InstructionType.IADD, instructions.get(4).getType());
		Assert.assertEquals(InstructionType.IADD, instructions.get(6).getType());
	}

}
