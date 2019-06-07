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
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import static net.runelite.asm.attributes.code.InstructionType.RETURN;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import net.runelite.deob.c2s.RWOpcodeFinder;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferFinder;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferMethodInjector;
import net.runelite.deob.deobfuscators.transformers.buffer.BufferPayloadFinder;
import net.runelite.deob.deobfuscators.transformers.buffer.PacketFlushFinder;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuneliteBufferTransformer implements Transformer
{
	private static final Logger logger = LoggerFactory.getLogger(RuneliteBufferTransformer.class);

	private static final String RUNELITE_PACKET = "RUNELITE_PACKET";
	private static final String RUNELITE_INIT_PACKET = "runeliteInitPacket";
	private static final String RUNELITE_FINISH_PACKET = "runeliteFinishPacket";

	@Override
	public void transform(ClassGroup group)
	{
		injectRunelitePacket(group);
		injectBufferMethods(group);
		injectLengthHeader(group);
		injectPacketFinish(group);
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

		if (client.findField(RUNELITE_PACKET) != null)
		{
			return;
		}

		Field field = new Field(client, RUNELITE_PACKET, Type.BOOLEAN);
		field.setAccessFlags(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC);
		client.addField(field);
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

	/**
	 * inject the length header after the packet opcode
	 *
	 * @param group
	 */
	private void injectLengthHeader(ClassGroup group)
	{
		RWOpcodeFinder rw = new RWOpcodeFinder(group);
		rw.find();

		Method writeOpcode = rw.getWriteOpcode();
		Code code = writeOpcode.getCode();
		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		Instruction start = ins.get(0);
		Instruction end = ins.stream().filter(i -> i.getType() == RETURN).findFirst().get();

		Label labelForStart = instructions.createLabelFor(start);
		Label labelForEnd = instructions.createLabelFor(end);

		final net.runelite.asm.pool.Field runelitePacketField = new net.runelite.asm.pool.Field(
			new net.runelite.asm.pool.Class(findClient(group).getName()),
			RUNELITE_PACKET,
			Type.BOOLEAN
		);

		int idx = ins.indexOf(labelForStart);

		instructions.addInstruction(idx++, new GetStatic(instructions, runelitePacketField));
		instructions.addInstruction(idx++, new IfEq(instructions, labelForStart));

		net.runelite.asm.pool.Method method = new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(writeOpcode.getClassFile().getName()),
			RUNELITE_FINISH_PACKET,
			new Signature("()V")
		);
		instructions.addInstruction(idx++, new ALoad(instructions, 0));
		instructions.addInstruction(idx++, new InvokeVirtual(instructions, method));

		idx = ins.indexOf(labelForEnd);

		instructions.addInstruction(idx++, new GetStatic(instructions, runelitePacketField));
		instructions.addInstruction(idx++, new IfEq(instructions, labelForEnd));

		method = new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(writeOpcode.getClassFile().getName()),
			RUNELITE_INIT_PACKET,
			new Signature("()V")
		);
		instructions.addInstruction(idx++, new ALoad(instructions, 0));
		instructions.addInstruction(idx++, new InvokeVirtual(instructions, method));

		logger.info("Injected finish/init packet calls into {}", writeOpcode);
	}

	private void injectPacketFinish(ClassGroup group)
	{
		PacketFlushFinder pff = new PacketFlushFinder(group);
		pff.find();

		for (InstructionContext queueForWriteCtx : pff.getQueueForWrite())
		{
			Instruction before = queueForWriteCtx.getPops().get(3) // socket
				.getPushed().getInstruction();
			GetStatic getBuffer;

			try
			{
				getBuffer = (GetStatic) queueForWriteCtx.getPops().get(2) // buffer
					.getPushed().getPops().get(0) // getstatic
					.getPushed().getInstruction();
			}
			catch (ClassCastException ex)
			{
				continue;
			}

			Instructions instructions = before.getInstructions();

			int idx = instructions.getInstructions().indexOf(before);
			assert idx != -1;

			instructions.addInstruction(idx++, getBuffer.clone());

			net.runelite.asm.pool.Method method = new net.runelite.asm.pool.Method(
				new net.runelite.asm.pool.Class(getBuffer.getField().getType().getInternalName()),
				RUNELITE_FINISH_PACKET,
				new Signature("()V")
			);
			instructions.addInstruction(idx++, new InvokeVirtual(instructions, method));
		}
	}

}
