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
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import org.objectweb.asm.Opcodes;

public class OpcodesTransformer implements Transformer
{
	public static final String RUNELITE_OPCODES = "net/runelite/rs/Opcodes";

	@Override
	public void transform(ClassGroup group)
	{
		ClassFile runeliteOpcodes = group.findClass(RUNELITE_OPCODES);
		if (runeliteOpcodes == null)
		{
			runeliteOpcodes = new ClassFile(group);
			runeliteOpcodes.setName(RUNELITE_OPCODES);
			runeliteOpcodes.setSuperName(Type.OBJECT.getInternalName());
			runeliteOpcodes.setAccess(Opcodes.ACC_PUBLIC);
			group.addClass(runeliteOpcodes);
		}
		else
		{
			runeliteOpcodes.getFields().clear();
		}

		Method clinit = runeliteOpcodes.findMethod("<clinit>");
		if (clinit == null)
		{
			clinit = new Method(runeliteOpcodes, "<clinit>", new Signature("()V"));
			clinit.setStatic(true);
			Code code = new Code(clinit);
			code.setMaxStack(1);
			clinit.setCode(code);
			runeliteOpcodes.addMethod(clinit);

			Instructions instructions = code.getInstructions();
			instructions.addInstruction(new VReturn(instructions));
		}
	}

}
