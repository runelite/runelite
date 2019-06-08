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

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.execution.Execution;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnreachedCode implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(UnreachedCode.class);

	private Execution execution;
	
	private int removeUnused(Method m)
	{
		Instructions ins = m.getCode().getInstructions();
		
		int count = 0;
		List<Instruction> insCopy = new ArrayList<>(ins.getInstructions());
		
		for (int j = 0; j < insCopy.size(); ++j)
		{
			Instruction i = insCopy.get(j);
			
			if (!execution.executed.contains(i))
			{
				// if this is an exception handler, the exception handler is never used...
				for (net.runelite.asm.attributes.code.Exception e : new ArrayList<>(m.getCode().getExceptions().getExceptions()))
				{
					if (e.getStart().next() == i)
					{
						e.setStart(ins.createLabelFor(insCopy.get(j + 1)));

						if (e.getStart().next() == e.getEnd().next())
						{
							m.getCode().getExceptions().remove(e);
							continue;
						}
					}
					if (e.getHandler().next() == i)
					{
						m.getCode().getExceptions().remove(e);
					}
				}

				if (i instanceof Label)
					continue;
				
				ins.remove(i);
				++count;
			}
		}
		return count;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				if (m.getCode() == null)
					continue;
				
				count += removeUnused(m);
			}
		}

		logger.info("Removed {} unused instructions", count);
	}
}
