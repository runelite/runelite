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
package net.runelite.deob.deobfuscators.transformers.buffer;

import java.io.IOException;
import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.visitors.ClassFileVisitor;
import org.objectweb.asm.ClassReader;

public class BufferMethodInjector
{
	private final BufferPayloadFinder bp;

	public BufferMethodInjector(BufferPayloadFinder bp)
	{
		this.bp = bp;
	}

	public void inject() throws IOException
	{
		Field buffer = bp.getBuffer();
		Field offset = bp.getOffset();

		assert buffer.getClassFile() == offset.getClassFile();

		InputStream in = getClass().getResourceAsStream("RuneliteBuffer.class");
		assert in != null : "no RuneliteBuffer";
		ClassFile runeliteBuffer = loadClass(in);

		ClassFile bufferClass = buffer.getClassFile();

		for (Field f : runeliteBuffer.getFields())
		{
			if (!f.getName().startsWith("runelite"))
			{
				continue;
			}

			inject(bufferClass, f);
		}

		for (Method m : runeliteBuffer.getMethods())
		{
			if (!m.getName().startsWith("runelite"))
			{
				continue;
			}

			inject(bufferClass, m);
		}
	}

	private void inject(ClassFile bufferClass, Method method)
	{
		assert method.getExceptions().getExceptions().isEmpty();

		Method newMethod = new Method(bufferClass, method.getName(), method.getDescriptor());
		Code code = new Code(newMethod);
		newMethod.setCode(code);

		method.getCode().getInstructions().getInstructions().stream()
			.forEach(i ->
			{
				if (!(i instanceof Label))
				{
					i = i.clone();
				}

				if (i instanceof FieldInstruction)
				{
					FieldInstruction fi = (FieldInstruction) i;
					if (fi.getField().getName().equals("offset"))
					{
						fi.setField(bp.getOffset().getPoolField());
					}
					else if (fi.getField().getName().equals("payload"))
					{
						fi.setField(bp.getBuffer().getPoolField());
					}
					else if (fi.getField().getName().equals("runeliteLengthOffset"))
					{
						fi.setField(bufferClass.findField("runeliteLengthOffset").getPoolField());
					}
				}

				i.setInstructions(code.getInstructions());
				code.getInstructions().addInstruction(i);
			});

		code.getExceptions().getExceptions().addAll(method.getCode().getExceptions().getExceptions());

		bufferClass.addMethod(newMethod);
	}

	private void inject(ClassFile bufferClass, Field field)
	{
		Field newField = new Field(bufferClass, field.getName(), field.getType());
		newField.setAccessFlags(field.getAccessFlags());
		newField.setValue(field.getValue());
		bufferClass.addField(newField);
	}

	static ClassFile loadClass(InputStream in) throws IOException
	{
		ClassReader reader = new ClassReader(in);
		ClassFileVisitor cv = new ClassFileVisitor();

		reader.accept(cv, ClassReader.SKIP_FRAMES);

		return cv.getClassFile();
	}
}
