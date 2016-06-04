/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
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
import net.runelite.asm.Fields;
import net.runelite.asm.Method;
import net.runelite.asm.Methods;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;

public class ClassGroupFactory
{
	private static void addVoidMethod(Methods methods, String name)
	{
		Method method = new Method(methods, name, new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);

		Attributes methodAttributes = method.getAttributes();

		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);

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

		Fields fields = cf.getFields();
		Field field = new Field(fields, "field", new Type("I"));
		field.setStatic();
		fields.addField(field);

		Methods methods = cf.getMethods();
		Method method = new Method(methods, "func", new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);

		Attributes methodAttributes = method.getAttributes();

		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);

		{
			method = new Method(methods, "func2", new Signature("(III)V"));
			method.setStatic();
			methods.addMethod(method);

			methodAttributes = method.getAttributes();

			code = new Code(methodAttributes);
			methodAttributes.addAttribute(code);

			Instructions ins = code.getInstructions();
			ins.addInstruction(new VReturn(ins));
		}
		
		addVoidMethod(methods, "void1");
		addVoidMethod(methods, "void2");
		addVoidMethod(methods, "void3");
		addVoidMethod(methods, "void4");

		return group;
	}
}
