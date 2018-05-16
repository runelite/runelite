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
import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.Deob;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnusedMethods implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(UnusedMethods.class);

	private final Set<Method> methods = new HashSet<>();

	@Override
	public void run(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				run(method);
			}
		}

		int count = 0;
		for (ClassFile cf : group.getClasses())
		{
			boolean extendsApplet = extendsApplet(cf);

			for (Method method : new ArrayList<>(cf.getMethods()))
			{
				// constructors can't be renamed, but are obfuscated
				if (!Deob.isObfuscated(method.getName()) && !method.getName().equals("<init>"))
				{
					continue;
				}

				if (extendsApplet && method.getName().equals("<init>"))
				{
					continue;
				}

				if (!methods.contains(method))
				{
					logger.debug("Removing unused method {}", method);

					cf.removeMethod(method);
					++count;
				}
			}
		}

		logger.info("Removed {} methods", count);
	}

	private void run(Method method)
	{
		Code code = method.getCode();

		if (code == null)
		{
			return;
		}

		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (!(i instanceof InvokeInstruction))
			{
				continue;
			}

			InvokeInstruction ii = (InvokeInstruction) i;

			methods.addAll(ii.getMethods());
		}
	}

	private static boolean extendsApplet(ClassFile cf)
	{
		if (cf.getParent() != null)
		{
			return extendsApplet(cf.getParent());
		}
		return cf.getSuperName().equals("java/applet/Applet");
	}
}
