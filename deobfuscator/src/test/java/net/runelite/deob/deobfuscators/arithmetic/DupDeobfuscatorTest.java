/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.Dup_X1;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.Pop2;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.deob.ClassGroupFactory;
import net.runelite.deob.Deobfuscator;
import org.junit.Assert;
import org.junit.Test;

public class DupDeobfuscatorTest
{
	@Test
	public void test()
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

		Deobfuscator d = new DupDeobfuscator();
		d.run(group);

		// assert the dup_x1 was removed
		long dupCount = ins.getInstructions().stream()
			.filter(i -> i instanceof Dup_X1)
			.count();
		Assert.assertEquals(0, dupCount);
	}

	//035   aload_0               // this
	//036   dup                   // this this
	//037   getfield              class153/field2097 I // this I
	//038   ldc                   830083863
	//039   imul                                      // this I
	//040   ldc                   830083863
	//041   iadd                                      // this I
	//042   dup_x1                                    // I this I
	@Test
	public void test2()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(3);

		Instruction body[] =
		{
			new AConstNull(ins), // this
			new Dup(ins), // this this
			new GetField(ins, new Field(new Class("test"), "field", Type.INT)),
			new LDC(ins, 830083863), // this this I I
			new IMul(ins), // this this I
			new LDC(ins, 830083863),
			new IAdd(ins),
			new Dup_X1(ins),
			new LDC(ins, 636900519),
			new IMul(ins), // pops dup
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();

		Deobfuscator d = new DupDeobfuscator();
		d.run(group);

		// assert the dup wasn't duplicated
		long dupCount = ins.getInstructions().stream()
			.filter(i -> i instanceof Dup)
			.count();
		Assert.assertEquals(1, dupCount);

		// assert the dup_x1 was removed
		dupCount = ins.getInstructions().stream()
			.filter(i -> i instanceof Dup_X1)
			.count();
		Assert.assertEquals(0, dupCount);
	}
}
