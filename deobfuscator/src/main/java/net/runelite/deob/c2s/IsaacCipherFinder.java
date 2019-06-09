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
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsaacCipherFinder
{
	private static final Logger logger = LoggerFactory.getLogger(IsaacCipherFinder.class);

	private static final int GOLDEN_RATIO = 0x9E3779B9; // 2^32 / phi
	private final ClassGroup group;

	private ClassFile isaacCipher;
	private Method getNext;

	public IsaacCipherFinder(ClassGroup group)
	{
		this.group = group;
	}

	public ClassFile getIsaacCipher()
	{
		return isaacCipher;
	}

	public Method getGetNext()
	{
		return getNext;
	}

	public void find()
	{
		Method highest = null;
		int count = 0;

		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();

				int i = find(m, code);
				if (i > count)
				{
					count = i;
					highest = m;
				}
			}
		}

		assert highest != null;
		isaacCipher = highest.getClassFile();

		// find nextInt
		for (Method method : isaacCipher.getMethods())
		{
			if (method.getDescriptor().size() == 0 && method.getDescriptor().getReturnValue().equals(Type.INT))
			{
				getNext = method;
			}
		}

		logger.debug("Found cipher {}, getNext {}", isaacCipher, getNext);
	}

	private int find(Method method, Code code)
	{
		if (code == null)
		{
			return 0;
		}

		int gr = 0;

		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (i instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) i;

				if (pci.getConstant().equals(GOLDEN_RATIO))
				{
					++gr;
				}
			}
		}

		return gr;
	}
}
