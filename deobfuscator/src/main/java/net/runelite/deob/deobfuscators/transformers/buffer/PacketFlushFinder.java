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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import static net.runelite.asm.attributes.code.InstructionType.GETFIELD;
import static net.runelite.asm.attributes.code.InstructionType.INVOKEVIRTUAL;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.signature.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketFlushFinder
{
	private static final Logger logger = LoggerFactory.getLogger(PacketFlushFinder.class);

	private final ClassGroup group;

	private final List<InstructionContext> queueForWrite = new ArrayList<>();

	public PacketFlushFinder(ClassGroup group)
	{
		this.group = group;
	}

	public List<InstructionContext> getQueueForWrite()
	{
		return queueForWrite;
	}

	public void find()
	{
		ClassFile client = group.findClass("Client");
		if (client == null)
		{
			client = group.findClass("client");
		}

		for (Method method : client.getMethods())
		{
			find(method);
		}
	}

	private void find(Method method)
	{
		Code code = method.getCode();
		Set<Instruction> checked = new HashSet<>();

		Execution e = new Execution(group);
		e.addMethod(method);
		e.noInvoke = true;
		e.noExceptions = true;
		e.addExecutionVisitor(ic ->
		{
			Instruction i = ic.getInstruction();

			if (checked.contains(i))
			{
				return;
			}
			checked.add(i);

			if (i.getType() != INVOKEVIRTUAL)
			{
				return;
			}

			InvokeVirtual iv = (InvokeVirtual) i;
			// queueForWrite
			if (!iv.getMethod().getType().equals(new Signature("([BII)V")))
			{
				return;
			}

			InstructionContext lengthCtx = ic.getPops().get(0).getPushed();
			if (lengthCtx.getInstruction().getType() != GETFIELD)
			{
				return;
			}

			queueForWrite.add(ic);
		});
		e.run();
	}

}
