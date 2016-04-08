package net.runelite.deob.deobfuscators.arithmetic;

import net.runelite.asm.ClassGroup;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.Dup2_X1;
import net.runelite.asm.attributes.code.instructions.Dup_X1;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IConst_0;
import net.runelite.asm.attributes.code.instructions.IConst_2;
import net.runelite.asm.attributes.code.instructions.IConst_3;
import net.runelite.asm.attributes.code.instructions.IConst_M1;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IStore_0;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LConst_1;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.LStore_0;
import net.runelite.asm.attributes.code.instructions.NOP;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.execution.Execution;
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
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins,  1587543155),
		      constant2 = new LDC_W(ins, -2130376517),
		      constant3 = new LDC_W(ins,   -67313687);

		Instruction body[] = {
			new IConst_0(ins), // for dup_x1 to place before this
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
			ins.addInstruction(i);
		
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
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);

		LDC_W constant1 = new LDC_W(ins, -2079217519),
		      constant2 = new LDC_W(ins, -2079217519),
		      constant3 = new LDC_W(ins,  561453169),
		      constant4 = new LDC_W(ins,  561453169);
		
		Instruction body[] = {
			new IConst_0(ins), // for dup_x1 to place before this
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
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins),
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, 1381104939),
		      constant2 = new LDC_W(ins, 1381104939),
		      constant3 = new LDC_W(ins, 981643079),
		      constant4 = new LDC_W(ins, 1807370871),
		      constant5 = new LDC_W(ins, 981643079);
		
		NOP label1 = new NOP(ins);
		
		Instruction body[] = {
			constant4,
			constant1,
			new ILoad(ins, 0),
			new IMul(ins),
			new IConst_0(ins),
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
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins),
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, 1807370871),
		      constant2 = new LDC_W(ins, 981643079);
		
		NOP label1 = new NOP(ins);
		
		Instruction body[] = {
			new ILoad(ins, 0),
			new LDC_W(ins, 2),
			new IMul(ins),
			
			new IConst_0(ins),
			new IfEq(ins, label1),
			
			new Pop(ins),
			new LDC_W(ins, 3),
			
			label1,
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins),
			new IConst_2(ins),
			new IStore(ins, 1)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, -2079217519),
		      constant2 = new LDC_W(ins, -2079217519),
		      constant3 = new LDC_W(ins, 561453169);
		
		Instruction body[] = {
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
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins),
			new IConst_2(ins),
			new IStore(ins, 1)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, 575391417),
		      constant2 = new LDC_W(ins, -497786999);
		
		Instruction body[] = {
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
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins),
			new IConst_2(ins),
			new IStore(ins, 1)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, 2131037801),
		      constant2 = new LDC_W(ins, -1306959399),
		      constant3 = new LDC_W(ins, -1);
		
		Instruction body[] = {
			constant3,
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new Pop(ins),
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC_W constant1 = new LDC_W(ins, -1616202347),
		      constant2 = new LDC_W(ins, 2747837);
		
		NOP label1 = new NOP(ins),
		    label2 = new NOP(ins),
		    label3 = new NOP(ins);
		
		Instruction body[] = {
			constant1,
			constant2,
			new IMul(ins),
			
			new ILoad(ins, 0),
			
			new LDC_W(ins, 42),
			new IfEq(ins, label1),
			new Goto(ins, label2),
			
			label1,
			new IConst_M1(ins),
			new Goto(ins, label3),
			
			label2,
			new IConst_0(ins),
			new Goto(ins, label3),
			
			label3,
			new InvokeStatic(ins, group.findClass("test").findMethod("func2").getPoolMethod()),
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
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
		
		Instruction[] prepareVariables = {
			new LConst_1(ins),
			new LStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		LDC2_W constant1 = new LDC2_W(ins, -81013729583719545L),
		       constant2 = new LDC2_W(ins, -6236978337732675017L),
		       constant3 = new LDC2_W(ins, -6236978337732675017L);
		
		Instruction body[] = {
			new IConst_0(ins),
			
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
			ins.addInstruction(i);
		
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
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};

		for (Instruction i : prepareVariables)
			ins.addInstruction(i);

		LDC_W constant1 = new LDC_W(ins, -1729723287),
		      constant2 = new LDC_W(ins, -143176743);

		Instruction body[] = {
			new ILoad(ins, 0),
			constant1,
			new IMul(ins),
			constant2,
			new IMul(ins),
			new VReturn(ins)
		};

		for (Instruction i : body)
			ins.addInstruction(i);

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
}
