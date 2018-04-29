/*
 * Copyright (c) 2016-2017, Morgan Lewis <http://github.com/MESLewis>
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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterRenamer
{
	private static final Logger logger = LoggerFactory.getLogger(ParameterRenamer.class);

	private ClassGroup source;
	private ClassGroup dest;
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
			ClassFile destCF = (ClassFile) mapping.get(sourceCF);

			if (destCF == null)
			{
				continue;
			}

			for (Method sourceM : sourceCF.getMethods())
			{
				if (sourceM != null)
				{
					Method destM = (Method) mapping.get(sourceM);
					if (destM != null)
					{
						destM.setParameters(sourceM.getParameters());
						destM.setLocalVariables(sourceM.getLocalVariables());
					}
				}
			}
		}
	}
}
