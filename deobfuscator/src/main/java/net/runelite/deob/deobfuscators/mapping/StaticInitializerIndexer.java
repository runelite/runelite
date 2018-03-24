/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.mapping;

import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finds fields which are initialized in clinit
 *
 * @author Adam
 */
public class StaticInitializerIndexer
{
	private static final Logger logger = LoggerFactory.getLogger(StaticInitializerIndexer.class);

	private final ClassGroup group;
	private final Set<Field> fields = new HashSet<>();

	public StaticInitializerIndexer(ClassGroup group)
	{
		this.group = group;
	}

	public void index()
	{
		for (ClassFile cf : group.getClasses())
		{
			Method method = cf.findMethod("<clinit>");
			if (method == null)
			{
				continue;
			}

			Instructions instructions = method.getCode().getInstructions();
			for (Instruction i : instructions.getInstructions())
			{
				if (i.getType() != InstructionType.PUTSTATIC)
				{
					continue;
				}

				PutStatic putstatic = (PutStatic) i;
				if (!putstatic.getField().getClazz().equals(cf.getPoolClass()) || putstatic.getMyField() == null)
				{
					continue;
				}

				fields.add(putstatic.getMyField());
			}
		}

		logger.debug("Indexed {} statically initialized fields", fields.size());
	}

	public boolean isStatic(Field field)
	{
		return fields.contains(field);
	}
}
