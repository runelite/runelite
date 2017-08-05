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
package net.runelite.deob.deobfuscators.transformers;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.I2L;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxMemoryTransformer implements Transformer
{
	private static final Logger logger = LoggerFactory.getLogger(MaxMemoryTransformer.class);

	private boolean done = false;

	@Override
	public void transform(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				transform(m);
			}
		}

		logger.info("Transformed: " + done);
	}

	private void transform(Method m)
	{
		Code code = m.getCode();

		if (code == null)
		{
			return;
		}

		Instructions ins = code.getInstructions();

		for (Instruction i : ins.getInstructions())
		{
			if (i instanceof InvokeVirtual)
			{
				/*
					invokestatic          java/lang/Runtime/getRuntime()Ljava/lang/Runtime;
					invokevirtual         java/lang/Runtime/maxMemory()J
					ldc2_w                1048576
					ldiv
					l2i
				 */
				if (((InvokeVirtual) i).getMethod().getName().equals("maxMemory"))
				{
					insert(ins, ins.getInstructions().indexOf(i));
					done = true;
					break;
				}
			}
		}
	}

	private void insert(Instructions ins, int idx)
	{
		Class randomClass = new net.runelite.asm.pool.Class("java/util/Random");
		
		ins.getInstructions().remove(idx);
		ins.getInstructions().add(idx++, new Pop(ins)); // pop runtime
		ins.getInstructions().add(idx++, new New(ins, randomClass));
		ins.getInstructions().add(idx++, new Dup(ins));
		ins.getInstructions().add(idx++, new InvokeSpecial(ins, new net.runelite.asm.pool.Method(randomClass, "<init>", new Signature("()V")))); // new Random
		ins.getInstructions().add(idx++, new LDC(ins, 31457280));
		ins.getInstructions().add(idx++, new InvokeVirtual(ins, new net.runelite.asm.pool.Method(randomClass, "nextInt", new Signature("(I)I")))); // nextInt(31457280)
		ins.getInstructions().add(idx++, new LDC(ins, 230686720));
		ins.getInstructions().add(idx++, new IAdd(ins)); // 230686720 + nextInt(31457280)
		ins.getInstructions().add(idx++, new I2L(ins));
	}

}
