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

package net.runelite.deob.deobfuscators.mapping;

import java.util.Collection;
import net.runelite.asm.Method;

public class ExecutionMapper
{
	// method1 maps to one of methods2, find out based on mappings
	
	private Method method1;
	private Collection<Method> methods2;

	public ExecutionMapper(Method method1, Collection<Method> methods2)
	{
		this.method1 = method1;
		this.methods2 = methods2;
	}

	public ParallelExecutorMapping run()
	{
		ParallelExecutorMapping highest = null;
		boolean multiple = false;

		for (Method m : methods2)
		{
			ParallelExecutorMapping mapping = MappingExecutorUtil.map(method1, m);

			if (highest == null || mapping.same > highest.same)
			{
				highest = mapping;
				multiple = false;
			}
			else if (mapping.same == highest.same)
			{
				multiple = true;
			}
		}

		if (multiple)
			return null;

		return highest;
	}
}
