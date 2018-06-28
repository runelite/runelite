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

import java.util.Optional;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.deob.ClassGroupFactory;
import org.junit.Assert;
import org.junit.Test;

public class CastNullTest
{
	@Test
	public void testRun()
	{
		ClassGroup group = ClassGroupFactory.generateGroup();

		Code code = group.findClass("test").findMethod("func").getCode();
		Instructions ins = code.getInstructions();

		code.setMaxStack(3);

		CheckCast checkCast = new CheckCast(ins);
		checkCast.setType(new Type("test"));

		Instruction[] instructions =
		{
			new LDC(ins, 2),
			new AConstNull(ins),
			checkCast,
			new LDC(ins, 2),
			new IAdd(ins),
			new Return(ins, InstructionType.IRETURN)
		};

		for (Instruction i : instructions)
		{
			ins.addInstruction(i);
		}

		Assert.assertEquals(6, ins.getInstructions().size());

		CastNull lvt = new CastNull();
		lvt.run(group);

		Assert.assertEquals(5, ins.getInstructions().size());

		Optional<Instruction> o = ins.getInstructions().stream().filter(i -> i instanceof CheckCast).findAny();
		Assert.assertFalse(o.isPresent());
	}
}
