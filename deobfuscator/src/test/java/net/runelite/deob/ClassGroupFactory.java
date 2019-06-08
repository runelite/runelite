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
package net.runelite.deob;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;

public class ClassGroupFactory
{
	private static void addVoidMethod(ClassFile cf, String name)
	{
		Method method = new Method(cf, name, new Signature("()V"));
		method.setStatic();
		cf.addMethod(method);

		Code code = new Code(method);
		method.setCode(code);

		Instructions ins = code.getInstructions();
		ins.addInstruction(new VReturn(ins));
	}

	public static ClassGroup generateGroup()
	{
		ClassGroup group = new ClassGroup();

		ClassFile cf = new ClassFile(group);
		cf.setName("test");
		cf.setSuperName("java/lang/Object");
		group.addClass(cf);

		Field field = new Field(cf, "field", Type.INT);
		field.setStatic();
		cf.addField(field);

		Method method = new Method(cf, "func", new Signature("()V"));
		method.setStatic();
		cf.addMethod(method);

		Code code = new Code(method);
		method.setCode(code);

		{
			method = new Method(cf, "func2", new Signature("(III)V"));
			method.setStatic();
			cf.addMethod(method);

			code = new Code(method);
			method.setCode(code);

			Instructions ins = code.getInstructions();
			ins.addInstruction(new VReturn(ins));
		}

		addVoidMethod(cf, "void1");
		addVoidMethod(cf, "void2");
		addVoidMethod(cf, "void3");
		addVoidMethod(cf, "void4");

		return group;
	}
}
