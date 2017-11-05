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
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.IDiv;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.execution.Execution;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Deobfuscator;
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
			new LDC(ins, 3),
			new IStore(ins, 0)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		Label label = new Label(ins),
		    label2 = new Label(ins);
		
		LDC one = new LDC(ins, 1);
		
		Instruction body[] = {
			new SiPush(ins, (short) 256),
			
			new ILoad(ins, 0),
			new IfEq(ins, label),
			
			new LDC(ins, 2),
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
		
		Deobfuscator d = new MultiplyOneDeobfuscator(false);
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
			new LDC(ins, 3),
			new IStore(ins, 0)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		Label label = new Label(ins),
		    label2 = new Label(ins);
		
		LDC one = new LDC(ins, 1);
		IMul mul = new IMul(ins);
		
		Instruction body[] = {
			new SiPush(ins, (short) 256),
			
			new ILoad(ins, 0),
			new IfEq(ins, label),
			
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
		
		Deobfuscator d = new MultiplyOneDeobfuscator(false);
		d.run(group);
		
		Assert.assertTrue(one.getInstructions() == null);
		Assert.assertTrue(mul.getInstructions() == null);
	}
	
	//   iconst_1
	//   iconst_m1
	//   iload                 5
	//   if_icmpeq             LABEL0x56d1
	//   iload                 5
	//   iconst_1
	//   if_icmpne             LABEL0x56e8
	//   goto                  LABEL0x56d1
	//LABEL0x56d1:
	//   getstatic             class139/field2130 I
	//   ldc_w                 -1440517609
	//   imul
	//   goto                  LABEL0x5708
	//LABEL0x56e8:
	//   getstatic             class139/field2130 I
	//   ldc_w                 -1440517609
	//   imul
	//   getstatic             client/field377 I
	//   iadd
	//   iconst_2
	//   idiv
	//LABEL0x5708:
	//   imul
	//   putstatic             client/field377 I
	//
	// client.field377 = 1 * (-1 != var5 && var5 != 1?(class139.field2130 + client.field377) / 2:class139.field2130);
	@Test
	public void test2()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();
		
		code.setMaxStack(2);
		
		// vars[0] = 3
		Instruction[] prepareVariables = {
			new LDC(ins, 3),
			new IStore(ins, 0),
			new LDC(ins, 2),
			new IStore(ins, 1)
		};
		
		for (Instruction i : prepareVariables)
			ins.addInstruction(i);
		
		Label label = new Label(ins),
		    label2 = new Label(ins),
		    label3 = new Label(ins);
		
		LDC one = new LDC(ins, 1);
		IMul mul = new IMul(ins);
		
		Instruction body[] = {
			one,
			
			new LDC(ins, -1),
			new ILoad(ins, 0),
			new IfICmpEq(ins, label),

			new Goto(ins, label2),
			
			label,
			new ILoad(ins, 1),
			new LDC(ins, -1440517609),
			new IDiv(ins),
			new Goto(ins, label3),
			
			label2,
			new ILoad(ins, 1),
			new LDC(ins, -1440517609),
			new IDiv(ins),
			
			label3,
			mul,
			
			new VReturn(ins)
		};
		
		for (Instruction i : body)
			ins.addInstruction(i);
		
		// check execution runs ok
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		Deobfuscator d = new MultiplyOneDeobfuscator(false);
		d.run(group);
		
		Assert.assertTrue(one.getInstructions() == null);
		Assert.assertTrue(mul.getInstructions() == null);
	}
}
