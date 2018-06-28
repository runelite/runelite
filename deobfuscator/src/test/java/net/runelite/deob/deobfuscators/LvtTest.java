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

import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.AStore;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LStore;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.deob.ClassGroupFactory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LvtTest
{
	private static final Logger logger = LoggerFactory.getLogger(LvtTest.class);

	@Test
	public void testReuseIndex()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();
		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		Instruction body[] =
		{
			// var0 = null
			new AConstNull(ins),
			new AStore(ins, 0),
			// var0 = 0
			// this forces a reindex to varn
			new LDC(ins, 0),
			new IStore(ins, 0),
			// var2 = null
			new AConstNull(ins),
			new AStore(ins, 2),
			// var2 = 0
			// this forces a reindex to varn+1
			new LDC(ins, 0),
			new IStore(ins, 2),
			//var0 = 0L
			new LDC(ins, 0L),
			new LStore(ins, 0),
			new VReturn(ins)
		};

		for (Instruction i : body)
		{
			ins.addInstruction(i);
		}

		Lvt lvt = new Lvt();
		lvt.run(group);

		AStore astore1 = (AStore) body[1];
		IStore istore1 = (IStore) body[3];
		AStore astore2 = (AStore) body[5];
		IStore istore2 = (IStore) body[7];
		LStore lstore1 = (LStore) body[9];

		int astore1Idx = astore1.getVariableIndex();
		int istore1Idx = istore1.getVariableIndex();
		int astore2Idx = astore2.getVariableIndex();
		int istore2Idx = istore2.getVariableIndex();
		int lstore1Idx = lstore1.getVariableIndex();

		logger.debug("{} -> {}", astore1, astore1.getVariableIndex());
		logger.debug("{} -> {}", istore1, istore1.getVariableIndex());
		logger.debug("{} -> {}", astore2, astore2.getVariableIndex());
		logger.debug("{} -> {}", istore2, istore2.getVariableIndex());
		logger.debug("{} -> {}", lstore1, lstore1.getVariableIndex());

		Assert.assertNotEquals(astore1Idx, istore1Idx);
		Assert.assertNotEquals(astore2Idx, istore2Idx);

		// assert that the lstore doesn't overwrite an existing index
		Assert.assertNotEquals(lstore1Idx + 1, astore1Idx);
		Assert.assertNotEquals(lstore1Idx + 1, istore1Idx);
		Assert.assertNotEquals(lstore1Idx + 1, astore2Idx);
		Assert.assertNotEquals(lstore1Idx + 1, istore2Idx);
	}
}
