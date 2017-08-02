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

import java.io.IOException;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Fields;
import net.runelite.asm.signature.Type;
import net.runelite.deob.Transformer;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferFinder;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferMethodInjector;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferPayloadFinder;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuneliteBufferTransformer implements Transformer
{
	private static final Logger logger = LoggerFactory.getLogger(RuneliteBufferTransformer.class);

	private static final String RUNELITE_PACKET = "RUNELITE_PACKET";

	@Override
	public void transform(ClassGroup group)
	{
		injectRunelitePacket(group);
		injectBufferMethods(group);
	}

	/**
	 * inject RUNELITE_PACKET field
	 *
	 * @param group
	 */
	private void injectRunelitePacket(ClassGroup group)
	{
		ClassFile client = findClient(group);
		assert client != null : "no client class";

		Fields fields = client.getFields();

		if (fields.findField(RUNELITE_PACKET) != null)
		{
			return;
		}

		Field field = new Field(fields, RUNELITE_PACKET, Type.BOOLEAN);
		field.setAccessFlags(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC);
		fields.addField(field);
	}

	private ClassFile findClient(ClassGroup group)
	{
		// "client" in vainlla but "Client" in deob..
		ClassFile cf = group.findClass("client");
		return cf != null ? cf : group.findClass("Client");
	}

	/**
	 * inject runelite buffer methods
	 *
	 * @param group
	 */
	private void injectBufferMethods(ClassGroup group)
	{
		BufferFinder bf = new BufferFinder(group);
		bf.find();

		BufferPayloadFinder bpf = new BufferPayloadFinder(bf.getBuffer());
		bpf.find();

		BufferMethodInjector bmi = new BufferMethodInjector(bpf);
		try
		{
			bmi.inject();
		}
		catch (IOException ex)
		{
			logger.warn("unable to inject buffer methods", ex);
		}
	}

}
