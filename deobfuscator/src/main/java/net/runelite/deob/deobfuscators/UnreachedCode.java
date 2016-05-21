/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Execution;
import java.util.ArrayList;
import java.util.List;

public class UnreachedCode implements Deobfuscator
{
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
					if (e.getStart() == i)
					{
						e.setStart(insCopy.get(j + 1));
						
						if (e.getStart() == e.getEnd())
						{
							m.getCode().getExceptions().remove(e);
							continue;
						}
					}
					if (e.getHandler() == i)
					{
						m.getCode().getExceptions().remove(e);
					}
				}
				
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
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.getCode() == null)
					continue;
				
				count += removeUnused(m);
			}
		}
		
		System.out.println("Removed " + count + " unused instructions");
	}
}
