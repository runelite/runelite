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
package net.runelite.deob.c2s;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RWOpcodeFinder
{
	private static final Logger logger = LoggerFactory.getLogger(RWOpcodeFinder.class);

	private final ClassGroup group;

	private Method readOpcode;
	private Method writeOpcode;

	public RWOpcodeFinder(ClassGroup group)
	{
		this.group = group;
	}

	public Method getReadOpcode()
	{
		return readOpcode;
	}

	public Method getWriteOpcode()
	{
		return writeOpcode;
	}

	public ClassFile getSecretBuffer()
	{
		assert writeOpcode.getClassFile() == readOpcode.getClassFile();
		return writeOpcode.getClassFile();
	}

	public ClassFile getBuffer()
	{
		return getSecretBuffer().getParent();
	}

	public void find()
	{
		IsaacCipherFinder ic = new IsaacCipherFinder(group);
		ic.find();

		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();

				find(ic, m, code);
			}
		}

		logger.debug("Found readOpcode {}, writeOpcode {}", readOpcode, writeOpcode);
	}

	private void find(IsaacCipherFinder ic, Method method, Code code)
	{
		if (code == null)
		{
			return;
		}

		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (i instanceof InvokeInstruction)
			{
				if (((InvokeInstruction) i).getMethods().contains(ic.getGetNext()))
				{
					if (method.getDescriptor().size() == 0)
					{
						// read opcode
						readOpcode = method;
					}
					else
					{
						// write opcode
						writeOpcode = method;
					}
				}
			}
		}
	}
}
