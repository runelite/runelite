package net.runelite.deob.deobfuscators.arithmetic;

import net.runelite.deob.ClassGroup;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.Goto;
import net.runelite.deob.attributes.code.instructions.IConst_1;
import net.runelite.deob.attributes.code.instructions.IConst_2;
import net.runelite.deob.attributes.code.instructions.IConst_3;
import net.runelite.deob.attributes.code.instructions.ILoad;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.IStore_0;
import net.runelite.deob.attributes.code.instructions.If0;
import net.runelite.deob.attributes.code.instructions.NOP;
import net.runelite.deob.attributes.code.instructions.SiPush;
import net.runelite.deob.attributes.code.instructions.VReturn;
import net.runelite.deob.execution.Execution;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyOneDeobfuscatorTest
{
	@Test
	public void testDir()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();
		
		code.setMaxStack(2);
		
		// vars[0] = 3
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		NOP label = new NOP(ins),
		    label2 = new NOP(ins);
		
		IConst_1 one = new IConst_1(ins);
		
		Instruction body[] = {
			new SiPush(ins, (short) 256),
			
			new ILoad(ins, 0),
			new If0(ins, label),
			
			new IConst_2(ins),
			new Goto(ins, label2),
			
			label,
			one,
			
			label2,
			new IMul(ins),
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		Deobfuscator d = new MultiplyOneDeobfuscator();
		d.run(group);
		
		Assert.assertTrue(one.getInstructions() != null);
	}
	
	@Test
	public void test()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();
		
		code.setMaxStack(2);
		
		// vars[0] = 3
		Instruction[] prepareVariables = {
			new IConst_3(ins),
			new IStore_0(ins)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		NOP label = new NOP(ins),
		    label2 = new NOP(ins);
		
		IConst_1 one = new IConst_1(ins);
		IMul mul = new IMul(ins);
		
		Instruction body[] = {
			new SiPush(ins, (short) 256),
			
			new ILoad(ins, 0),
			new If0(ins, label),
			
			label,
			one,
			
			label2,
			mul,
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		Deobfuscator d = new MultiplyOneDeobfuscator();
		d.run(group);
		
		Assert.assertTrue(one.getInstructions() == null);
		Assert.assertTrue(mul.getInstructions() == null);
	}
}
