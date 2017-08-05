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

import java.util.ArrayList;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionTransformer implements Transformer
{
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTransformer.class);

	@Override
	public void transform(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				transform(method);
			}
		}
	}

	private void transform(Method method)
	{
		Code code = method.getCode();

		if (code == null)
		{
			return;
		}

		Instructions ins = code.getInstructions();

		for (Instruction i : new ArrayList<>(ins.getInstructions()))
		{
			transformFindClass(i);
			transformMethodName(ins, i);
			transformGetParameterTypes(ins, i);
			transformGetDeclaredField(ins, i);
			transformSetInt(ins, i);
			transformGetInt(ins, i);
			transformInvokeVirtual(ins, i);
		}
	}

	// invokestatic          java/lang/Class/forName(Ljava/lang/String;)Ljava/lang/Class;
	// to
	// invokestatic          net/runelite/rs/Reflection/findClass(Ljava/lang/String;)Ljava/lang/Class;
	private void transformFindClass(Instruction i)
	{
		if (!(i instanceof InvokeStatic))
		{
			return;
		}

		InvokeStatic is = (InvokeStatic) i;

		if (is.getMethod().getClazz().getName().equals("java/lang/Class")
			&& is.getMethod().getName().equals("forName"))
		{
			is.setMethod(
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "findClass", new Signature("(Ljava/lang/String;)Ljava/lang/Class;")
				)
			);

			logger.info("Transformed Class.forName call");
		}
	}

	// invokevirtual         java/lang/reflect/Method/getName()Ljava/lang/String;
	// to
	// invokestatic          net/runelite/rs/Reflection/getMethodName(Ljava/lang/reflect/Method;)Ljava/lang/String;
	private void transformMethodName(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/reflect/Method")
			&& iv.getMethod().getName().equals("getName"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "getMethodName", new Signature("(Ljava/lang/reflect/Method;)Ljava/lang/String;")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Method.getName call");
		}
	}

	// invokevirtual         java/lang/reflect/Method/getParameterTypes()[Ljava/lang/Class;
	// to
	// invokestatic          net/runelite/rs/Reflection/getParameterTypes(Ljava/lang/reflect/Method;)[Ljava/lang/Class;
	private void transformGetParameterTypes(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/reflect/Method")
			&& iv.getMethod().getName().equals("getParameterTypes"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "getParameterTypes", new Signature("(Ljava/lang/reflect/Method;)[Ljava/lang/Class;")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Method.getParameterTypes call");
		}
	}

	// invokevirtual         java/lang/Class/getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
	// to
	// invokestatic          net/runelite/rs/Reflection/findField
	private void transformGetDeclaredField(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/Class")
			&& iv.getMethod().getName().equals("getDeclaredField"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "findField", new Signature("(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Class.getDeclaredField call");
		}
	}

	// invokevirtual         java/lang/reflect/Field/setInt(Ljava/lang/Object;I)V
	private void transformSetInt(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/reflect/Field")
			&& iv.getMethod().getName().equals("setInt"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "setInt", new Signature("(Ljava/lang/reflect/Field;Ljava/lang/Object;I)V")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Field.setInt call");
		}
	}

	// invokevirtual         java/lang/reflect/Field/getInt(Ljava/lang/Object;)I
	private void transformGetInt(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/reflect/Field")
			&& iv.getMethod().getName().equals("getInt"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "getInt", new Signature("(Ljava/lang/reflect/Field;Ljava/lang/Object;)I")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Field.getInt call");
		}
	}

	// invokevirtual         java/lang/reflect/Method/invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
	private void transformInvokeVirtual(Instructions instructions, Instruction i)
	{
		if (!(i instanceof InvokeVirtual))
		{
			return;
		}

		InvokeVirtual iv = (InvokeVirtual) i;

		if (iv.getMethod().getClazz().getName().equals("java/lang/reflect/Method")
			&& iv.getMethod().getName().equals("invoke"))
		{
			InvokeStatic is = new InvokeStatic(instructions,
				new net.runelite.asm.pool.Method(
					new net.runelite.asm.pool.Class("net/runelite/rs/Reflection"), "invoke", new Signature("(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;")
				)
			);
			instructions.replace(iv, is);

			logger.info("Transformed Method.invoke call");
		}
	}
}
