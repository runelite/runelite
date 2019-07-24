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
package net.runelite.deob.deobfuscators.transformers;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.IfNull;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientErrorTransformer implements Transformer
{
	private static final Logger logger = LoggerFactory.getLogger(ClientErrorTransformer.class);

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
		if (!m.isStatic() || m.getDescriptor().size() != 2
			|| !m.getDescriptor().getTypeOfArg(0).equals(Type.STRING)
			|| !m.getDescriptor().getTypeOfArg(1).equals(Type.THROWABLE))
			return;

		Code code = m.getCode();
		Instructions ins = code.getInstructions();

		/*
			Makes it so the old code in this method is logically dead,
			letting the mapper map it but making it so it's never executed.
		 */

		Instruction aload0 = new ALoad(ins, 1); // load throwable

		IfNull ifNull = new IfNull(ins, InstructionType.IFNULL);
		ifNull.setTo(ins.createLabelFor(ins.getInstructions().get(0)));

		Instruction aload1 = new ALoad(ins, 1); // load throwable

		InvokeVirtual printStackTrace = new InvokeVirtual(ins,
			new net.runelite.asm.pool.Method(
				new net.runelite.asm.pool.Class("java/lang/Throwable"),
				"printStackTrace",
				new Signature("()V")
			)
		);

		Instruction ret = new VReturn(ins);

		ins.addInstruction(0, aload0);
		ins.addInstruction(1, ifNull);
		ins.addInstruction(2, aload1);
		ins.addInstruction(3, printStackTrace);
		ins.addInstruction(4, ret);

		done = true;
	}

}
