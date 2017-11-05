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

import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.Dup2_X1;
import net.runelite.asm.attributes.code.instructions.Dup_X1;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.LStore;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.Pop2;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.Swap;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.execution.Execution;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Deobfuscator;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationDeobfuscatorTest
{
	//   aload                 2
	//   ldc_w                 1587543155
	//   iload                 4
	//   imul
	//   dup_x1
	//   ldc_w                 -2130376517
	//   imul
	//   putfield              class2/field279 I
	//   ldc_w                 -67313687
	//   imul
	//   putstatic             class29/field949 I
	@Test
	public void test1()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(5);

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

		LDC constant1 = new LDC(ins, 1587543155),
			constant2 = new LDC(ins, -2130376517),
			constant3 = new LDC(ins, -67313687);

		Instruction body[] =
		{
			new LDC(ins, 0), // for dup_x1 to place before this
			constant1,
			new ILoad(ins, 0),
			new IMul(ins),
			new Dup_X1(ins),
			constant2,
			new IMul(ins),
			new Pop(ins),
			new Pop(ins),
			constant3,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;
		assert constant1.getConstantAsInt() * constant3.getConstantAsInt() == -1_095_175_765;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
		Assert.assertEquals(-1_095_175_765, constant3.getConstantAsInt());
	}

	//   aload_0
	//   dup
	//   getfield              class118/field2201 I
	//   ldc_w                 -2079217519
	//   imul
	//   ldc                   -2079217519
	//   iadd
	//   dup_x1
	//   ldc_w                 561453169
	//   imul
	//   putfield              class118/field2201 I
	//   ldc                   561453169
	//   imul
	@Test
	public void test2()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(4);

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

		LDC constant1 = new LDC(ins, -2079217519),
			constant2 = new LDC(ins, -2079217519),
			constant3 = new LDC(ins, 561453169),
			constant4 = new LDC(ins, 561453169);

		Instruction body[] =
		{
			new LDC(ins, 0), // for dup_x1 to place before this
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			constant2,
			new IAdd(ins),
			new Dup_X1(ins), // result, 0, result
			constant3,
			new IMul(ins),
			new Pop(ins),
			new Pop(ins),
			constant4,
			new IMul(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant3.getConstantAsInt() == 1;
		assert constant2.getConstantAsInt() * constant4.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
		Assert.assertEquals(1, constant3.getConstantAsInt());
		Assert.assertEquals(1, constant4.getConstantAsInt());
	}

	@Test
	public void test3()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0),
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 1381104939),
			constant2 = new LDC(ins, 1381104939),
			constant3 = new LDC(ins, 981643079),
			constant4 = new LDC(ins, 1807370871),
			constant5 = new LDC(ins, 981643079);

		Label label1 = new Label(ins);

		Instruction body[] =
		{
			constant4,
			constant1,
			new ILoad(ins, 0),
			new IMul(ins),
			new LDC(ins, 0),
			new IfEq(ins, label1),
			constant2,
			new IMul(ins),
			label1,
			constant3,
			new IMul(ins),
			new IMul(ins), // constant4
			constant5,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant4.getConstantAsInt() * constant5.getConstantAsInt() == 1;

//		{
//			Collection<InstructionContext> ctxs = e.getInstructonContexts(body[3]);
//			assert ctxs.size() == 1;
//			
//			InstructionContext ictx = ctxs.iterator().next();
//			boolean onlyPath = MultiplicationDeobfuscator.isOnlyPath(e, ictx);
//			Assert.assertFalse(onlyPath);
//		}
		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1381104939, constant1.getConstantAsInt());
		Assert.assertEquals(1381104939, constant2.getConstantAsInt());
		Assert.assertEquals(1, constant3.getConstantAsInt());
		Assert.assertEquals(1, constant4.getConstantAsInt());
		Assert.assertEquals(981643079, constant5.getConstantAsInt()); // assumes result is moved to the end here.
	}

	@Test
	public void test4()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0),
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 1807370871);
		LDC constant2 = new LDC(ins, 981643079);

		Label label1 = new Label(ins);

		Instruction body[] =
		{
			new ILoad(ins, 0),
			new LDC(ins, 2),
			new IMul(ins),
			new LDC(ins, 0),
			new IfEq(ins, label1),
			new Pop(ins),
			new LDC(ins, 3),
			label1,
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}

	@Test
	public void test5()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0),
			new LDC(ins, 2),
			new IStore(ins, 1)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, -2079217519),
			constant2 = new LDC(ins, -2079217519),
			constant3 = new LDC(ins, 561453169);

		Instruction body[] =
		{
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			new IStore(ins, 2),
			new ILoad(ins, 2),
			new ILoad(ins, 1),
			constant2,
			new IMul(ins),
			new IAdd(ins),
			constant3,
			new IMul(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant3.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
		Assert.assertEquals(1, constant3.getConstantAsInt());
	}

	@Test
	public void test6()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0),
			new LDC(ins, 2),
			new IStore(ins, 1)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 575391417);
		LDC constant2 = new LDC(ins, -497786999);

		Instruction body[] =
		{
			new ILoad(ins, 0),
			new ILoad(ins, 1),
			new Dup_X1(ins),
			new Pop(ins),
			new Pop(ins),
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}

	@Test
	public void test7()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0),
			new LDC(ins, 2),
			new IStore(ins, 1)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 2131037801),
			constant2 = new LDC(ins, -1306959399),
			constant3 = new LDC(ins, -1);

		Instruction body[] =
		{
			constant3,
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(-1, constant2.getConstantAsInt());
		Assert.assertEquals(1, constant3.getConstantAsInt());
	}

	@Test
	public void test8()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 3),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, -1616202347);
		LDC constant2 = new LDC(ins, 2747837);

		Label label1 = new Label(ins),
			label2 = new Label(ins),
			label3 = new Label(ins);

		Instruction body[] =
		{
			constant1,
			constant2,
			new IMul(ins),
			new ILoad(ins, 0),
			new LDC(ins, 42),
			new IfEq(ins, label1),
			new Goto(ins, label2),
			label1,
			new LDC(ins, -1),
			new Goto(ins, label3),
			label2,
			new LDC(ins, 0),
			new Goto(ins, label3),
			label3,
			new InvokeStatic(ins, group.findClass("test").findMethod("func2").getPoolMethod()),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}

	//   aload                 0
	//   aload                 0
	//   aload                 1
	//   invokevirtual         class226/method4078()J
	//   ldc2_w                -81013729583719545
	//   lmul
	//   dup2_x1
	//   ldc2_w                -6236978337732675017
	//   lmul
	//   putfield              class227/field3204 J
	//   ldc2_w                -6236978337732675017
	//   lmul
	//   putfield              class227/field3196 J
	@Test
	public void test9()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(3);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 1L),
			new LStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, -81013729583719545L),
			constant2 = new LDC(ins, -6236978337732675017L),
			constant3 = new LDC(ins, -6236978337732675017L);

		Instruction body[] =
		{
			new LDC(ins, 0),
			new LLoad(ins, 0),
			constant1,
			new LMul(ins),
			new Dup2_X1(ins), // lmul, 0, lmul

			constant2,
			new LMul(ins),
			new Pop(ins),
			new Pop(ins),
			constant3,
			new LMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsLong() * constant2.getConstantAsLong() == 1L;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1L, constant1.getConstantAsLong());
		Assert.assertEquals(1L, constant2.getConstantAsLong());
		Assert.assertEquals(1L, constant3.getConstantAsLong());
	}

	@Test
	public void test10()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(5);

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

		LDC constant1 = new LDC(ins, -1729723287);
		LDC constant2 = new LDC(ins, -143176743);

		Instruction body[] =
		{
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}

	//020   aload_0
	//021   aload_0
	//022   iload_1
	//023   ldc                   1129258489
	//024   imul
	//025   dup_x1
	//026   ldc                   -1692330935
	//027   imul
	//028   putfield              class81/field1351 I
	//029   ldc                   1641298955
	//030   imul                                         // this pops other side of dup_x1
	//031   ldc                   1043501435
	//032   imul
	//033   putfield              class81/field1326 I
	@Test
	public void test11()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(5);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 1),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 1129258489),
			constant2 = new LDC(ins, -1692330935),
			constant3 = new LDC(ins, 1641298955),
			constant4 = new LDC(ins, 1043501435);

		Instruction body[] =
		{
			new AConstNull(ins), // this
			new AConstNull(ins), // this
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			new Dup_X1(ins),
			constant2,
			new IMul(ins),
			new Pop2(ins), // putfield

			constant3,
			new IMul(ins),
			constant4,
			new IMul(ins),
			new Pop2(ins), // putfield

			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;
		assert constant3.getConstantAsInt() * constant4.getConstantAsInt() * constant1.getConstantAsInt() == 1;
		;
		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
		Assert.assertEquals(1, constant3.getConstantAsInt());
		Assert.assertEquals(1, constant4.getConstantAsInt());
	}

	//020   aload_0
	//021   aload_0
	//022   iload_1
	//023   ldc                   1129258489
	//024   imul						// this, this, mul
	//025   swap						// this, mul s, this
	//026   iload_1
	//027   iconst_1
	//028   imul						// this, mul s, this, mul
	//029   iconst_1
	//030   imul
	//031   putfield              class81/field1351 I       // this, mul
	//032   iconst_1
	//033   imul
	//034   ldc                   -1692330935
	//035   imul
	//036   putfield              class81/field1326 I
	@Test
	public void test12()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(5);

		Instruction[] prepareVariables =
		{
			new LDC(ins, 1),
			new IStore(ins, 0)
		};

		for (Instruction i : prepareVariables)
		{
			ins.addInstruction(i);
		}

		LDC constant1 = new LDC(ins, 1129258489);
		LDC constant2 = new LDC(ins, -1692330935);

		Instruction body[] =
		{
			new AConstNull(ins), // this
			new AConstNull(ins), // this
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			new Swap(ins), // null, mul, null

			new ILoad(ins, 0),
			new Pop2(ins), // putfield

			constant2,
			new IMul(ins),
			new Pop2(ins), // putfield

			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}

	//sipush                512
	//ldc                   -688421113
	//imul
	//ldc                   -585812297
	//imul
	//putstatic             class134/field2009 I
	@Test
	public void test13()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(2);

		LDC constant1 = new LDC(ins, -688421113);
		LDC constant2 = new LDC(ins, -585812297);

		Instruction body[] =
		{
			new SiPush(ins, (short) 512),
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),

			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		assert constant1.getConstantAsInt() * constant2.getConstantAsInt() == 1;

		Deobfuscator d = new MultiplicationDeobfuscator();
		d.run(group);

		Assert.assertEquals(1, constant1.getConstantAsInt());
		Assert.assertEquals(1, constant2.getConstantAsInt());
	}
}
