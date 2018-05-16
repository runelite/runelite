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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class which identifies Buffer and PacketBuffer
 *
 * @author Adam
 */
public class BufferFinder
{
	private static final Logger logger = LoggerFactory.getLogger(BufferFinder.class);

	private final ClassGroup group;

	private ClassFile buffer, packetBuffer;

	public BufferFinder(ClassGroup group)
	{
		this.group = group;
	}

	public ClassFile getBuffer()
	{
		return buffer;
	}

	public ClassFile getPacketBuffer()
	{
		return packetBuffer;
	}

	public void find()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();

				if (findModPow(code))
				{
					buffer = cf;

					// packetBuffer extends this
					packetBuffer = group.getClasses().stream()
						.filter(cl -> cl.getParent() == cf)
						.findAny()
						.get();

					logger.info("Identified buffer {}, packetBuffer {}", buffer, packetBuffer);
				}
			}
		}
	}

	// Find encryptRsa in buffer
	private boolean findModPow(Code code)
	{
		if (code == null)
		{
			return false;
		}

		Instructions instructions = code.getInstructions();

		for (Instruction i : instructions.getInstructions())
		{
			if (!(i instanceof InvokeVirtual))
			{
				continue;
			}

			InvokeVirtual iv = (InvokeVirtual) i;
			net.runelite.asm.pool.Method method = iv.getMethod();
			if (method.getName().equals("modPow"))
			{
				return true;
			}
		}
		return false;
	}
}
