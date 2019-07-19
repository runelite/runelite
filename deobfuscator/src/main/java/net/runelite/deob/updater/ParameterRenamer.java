/*
 * Copyright (c) 2018, Morgan Lewis <http://github.com/MESLewis>
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
package net.runelite.deob.updater;

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.LocalVariable;
import net.runelite.asm.attributes.code.Parameter;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class ParameterRenamer
{
	private final ClassGroup source;
	private final ClassGroup dest;
	private final ParallelExecutorMapping mapping;

	public ParameterRenamer(ClassGroup source, ClassGroup dest, ParallelExecutorMapping mapping)
	{
		this.source = source;
		this.dest = dest;
		this.mapping = mapping;
	}

	public void run()
	{
		for (ClassFile sourceCF : source.getClasses())
		{
			for (Method sourceM : sourceCF.getMethods())
			{
				Method destM = (Method) mapping.get(sourceM);
				if (destM != null && destM.getParameters().size() > 0 && sourceM.getParameters() != null && !sourceM.getParameters().isEmpty() && sourceM.getParameters().size() >= 1)
				{
					List<Parameter> oldParams = destM.getParameters();
					for (int i = 0; i < sourceM.getParameters().size(); i++)
					{
						String name = sourceM.getParameters().get(i).getName();
						if (name.matches("var[0-9]") || name.length() <= 2 && (name.charAt(0) != 'x' || name.charAt(0) != 'y' || name.charAt(0) != 'z'))
						{
							continue;
						}

						Parameter oldParam = oldParams.get(i);
						LocalVariable oldVar = oldParam.getLocalVariable();

						Parameter newParam = new Parameter(name, oldParam.getAccess());
						oldParams.set(i, newParam);

						if (oldVar == null)
						{
							continue;
						}

						LocalVariable newVar = new LocalVariable(
							name,
							oldVar.getDesc(),
							oldVar.getSignature(),
							oldVar.getStart(),
							oldVar.getEnd(),
							oldVar.getIndex()
						);

						newParam.setLocalVariable(newVar);
					}
				}
			}
		}
	}
}
