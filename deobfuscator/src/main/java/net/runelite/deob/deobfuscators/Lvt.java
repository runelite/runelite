/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators;

import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstructionType;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Mappings
{
	int maxVariables;
	int offset;
	Map<Integer, LVTInstructionType> map = new HashMap<>();
	Map<Integer, Integer> newIdxMap = new HashMap<>();

	static boolean isSame(LVTInstructionType one, LVTInstructionType two)
	{
		return (one == LVTInstructionType.OBJECT) == (two == LVTInstructionType.OBJECT);
	}

	Integer remap(int idx, LVTInstructionType type)
	{
		LVTInstructionType seen = map.get(idx);

		if (seen == null)
		{
			map.put(idx, type);
		}
		else if (!isSame(type, seen))
		{
			Integer newIdx = newIdxMap.get(idx);
			if (newIdx == null)
			{
				newIdx = maxVariables + offset;
				newIdxMap.put(idx, newIdx);
				
				switch (type)
				{
					case LONG:
					case DOUBLE:
						offset += 2;
						break;
					default:
						offset += 1;
				}
			}

			return newIdx;
		}

		return null;
	}
}

public class Lvt implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(Lvt.class);
	
	private int count = 0;

	private void process(Method method)
	{
		Code code = method.getCode();
		if (code == null)
			return;

		Mappings mappings = new Mappings();
		mappings.maxVariables = code.getMaxLocals();

		for (Instruction ins : code.getInstructions().getInstructions())
		{
			if (!(ins instanceof LVTInstruction))
				continue;

			LVTInstruction lv = (LVTInstruction) ins;
			Integer newIdx = mappings.remap(lv.getVariableIndex(), lv.type());

			if (newIdx == null)
				continue;

			assert newIdx != lv.getVariableIndex();

			Instruction newIns = lv.setVariableIndex(newIdx);
			assert ins == newIns;

			++count;
		}
	}

	@Override
	public void run(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
				process(m);

		logger.info("Remapped {} lvt indexes", count);
	}

}
