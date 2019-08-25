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
package net.runelite.asm.execution;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;

public class MethodContext
{
	private Execution execution;
	private Method method;
	private Multimap<InstructionContext, Instruction> visited = HashMultimap.create();
	public Multimap<Instruction, InstructionContext> contexts = HashMultimap.create();

	public MethodContext(Execution execution, Method method)
	{
		this.execution = execution;
		this.method = method;
	}

	public Execution getExecution()
	{
		return execution;
	}

	public Method getMethod()
	{
		return method;
	}

	protected boolean hasJumped(InstructionContext from, Instruction to)
	{
		Collection<Instruction> i = visited.get(from);
		if (i != null && i.contains(to))
		{
			return true;
		}

		visited.put(from, to);
		return false;
	}

	public Collection<InstructionContext> getInstructonContexts(Instruction i)
	{
		return contexts.get(i);
	}

	@SuppressWarnings("unchecked")
	public Collection<InstructionContext> getInstructionContexts()
	{
		return (Collection) contexts.values();
	}

	public void reset()
	{
		contexts.clear();
		visited.clear();
	}
}
