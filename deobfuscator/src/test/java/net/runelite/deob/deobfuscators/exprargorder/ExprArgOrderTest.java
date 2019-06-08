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

import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import static net.runelite.asm.attributes.code.InstructionType.IADD;
import static net.runelite.asm.attributes.code.InstructionType.IAND;
import static net.runelite.asm.attributes.code.InstructionType.IF_ICMPEQ;
import static net.runelite.asm.attributes.code.InstructionType.ILOAD;
import static net.runelite.asm.attributes.code.InstructionType.LDC;
import static net.runelite.asm.attributes.code.InstructionType.SIPUSH;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IAnd;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.deob.ClassGroupFactory;
import static org.junit.Assert.assertEquals;
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
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			// 3 + var0 -> var0 + 3
			new LDC(ins, 3), // 2
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

		assertEquals(ILOAD, instructions.get(2).getType());
		assertEquals(LDC, instructions.get(3).getType());
		assertEquals(IADD, instructions.get(4).getType());
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
			new LDC(ins, 3),
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
			new LDC(ins, 3),
			new IAdd(ins),
			new Pop(ins),
			// (3 + var0) + 512 -> (var0 + 3) + 512
			new LDC(ins, 3), // 6
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

		// ensure this stays the same
		assertEquals(ILOAD, instructions.get(2).getType());
		assertEquals(LDC, instructions.get(3).getType());
		assertEquals(IADD, instructions.get(4).getType());

		//
		assertEquals(ILOAD, instructions.get(6).getType());
		assertEquals(SIPUSH, instructions.get(7).getType());
		assertEquals(IADD, instructions.get(8).getType());
		assertEquals(LDC, instructions.get(9).getType());
		assertEquals(IADD, instructions.get(10).getType());
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
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			// 512 + (3 + var1) -> var1 + 3 + 512
			new LDC(ins, 512),
			new LDC(ins, 3),
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
		assertEquals(IADD, instructions.get(4).getType());
		assertEquals(IADD, instructions.get(6).getType());
	}

	@Test
	public void test4()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Instruction body[] =
		{
			new SiPush(ins, (short) 600),
			new ILoad(ins, 0),
			new LDC(ins, 3),
			new IMul(ins),
			new IAdd(ins),
			new Pop(ins),
			new ILoad(ins, 0),
			new LDC(ins, 3),
			new IMul(ins),
			new SiPush(ins, (short) 600),
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

		for (int i = 2; i <= 7; ++i)
		{
			assertEquals(instructions.get(i).getType(), instructions.get(i + 6).getType());
		}
	}

	@Test
	public void test5()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Label label = new Label(ins);

		Instruction body[] =
		{
			// if (0 == 3 + var0) -> if (var0 + 3 == 0)
			new LDC(ins, 0),
			new LDC(ins, 3),
			new ILoad(ins, 0),
			new IAdd(ins),
			new IfICmpEq(ins, label),
			label,
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		ExprArgOrder exprArgOrder = new ExprArgOrder();
		exprArgOrder.run(group);

		List<Instruction> instructions = ins.getInstructions();

		// ldc iload add -> iload ldc iadd
		assertEquals(ILOAD, instructions.get(2).getType());
		assertEquals(LDC, instructions.get(3).getType());
		assertEquals(IADD, instructions.get(4).getType());

		// idc moves from 2 to 5
		assertEquals(LDC, instructions.get(5).getType());
		assertEquals(IF_ICMPEQ, instructions.get(6).getType());
	}

	@Test
	public void test6()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		// vars[0] = 3
		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		Label label = new Label(ins);

		/*
		iconst_0
		ldc                   8388608
		iload_3
		iadd
		ldc                   -16777216
		iand
		if_icmpeq             LABEL0x49
		 */
		Instruction body[] =
		{
			new LDC(ins, 0),
			new LDC(ins, 8388608),
			new ILoad(ins, 0),
			new IAdd(ins),
			new LDC(ins, -16777216),
			new IAnd(ins),
			new IfICmpEq(ins, label), // 8
			label,
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		ExprArgOrder exprArgOrder = new ExprArgOrder();
		exprArgOrder.run(group);

		List<Instruction> instructions = ins.getInstructions();

		assertEquals(ILOAD, instructions.get(2).getType());
		assertEquals(LDC, instructions.get(3).getType());
		assertEquals(IADD, instructions.get(4).getType());

		assertEquals(LDC, instructions.get(5).getType());
		assertEquals(IAND, instructions.get(6).getType());

		assertEquals(LDC, instructions.get(7).getType());
		assertEquals(IF_ICMPEQ, instructions.get(8).getType());
	}

}
