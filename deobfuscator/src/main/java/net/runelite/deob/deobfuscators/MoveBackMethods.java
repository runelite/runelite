/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2017, UniquePassive <https://github.com/uniquepassive>
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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MoveBackMethods implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MoveBackMethods.class);

	private final Set<Method> methods = new HashSet<>();

	private final Set<Method> unusedMethods = new HashSet<>();
	private final Set<Method> usedMethods = new HashSet<>();

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();

		for (ClassFile cf : group.getClasses())
		{
			for (Method method : cf.getMethods())
			{
				findMethods(method);
			}
		}

		for (ClassFile cf : group.getClasses())
		{
			findUnusedMethods(cf);
		}

		findUsedMethods();

		Map<Method, List<Method>> realMethodDummies = new HashMap<>();

		for (Method m : usedMethods)
		{
			List<Integer> lineNumbers = getLineNumbers(m);

			for (Method m2 : unusedMethods)
			{
				if (!m.getDescriptor().getReturnValue().equals(m2.getDescriptor().getReturnValue()))
				{
					continue;
				}

				// Used methods can have an extra parameter (the opaque predicate)
				// Dummy methods cannot
				if (m.getDescriptor().size() + 1 < m2.getDescriptor().size()
						|| m.getDescriptor().size() - 1 > m2.getDescriptor().size())
				{
					continue;
				}

				List<Integer> lineNumbers2 = getLineNumbers(m2);

				if (lineNumbers.size() != lineNumbers2.size()
						|| !lineNumbers.containsAll(lineNumbers2))
				{
					continue;
				}

				realMethodDummies
						.computeIfAbsent(m, k -> new ArrayList<>())
						.add(m2);
			}
		}

		AtomicInteger count = new AtomicInteger();

		realMethodDummies.forEach((m, ml) ->
		{
			ClassFile cf = ml.get(0).getClassFile();

			if (cf.getName().equals(m.getClassFile().getName()))
			{
				return;
			}

			boolean singleTarget = ml
					.stream()
					.map(m2 -> m2.getClassFile().getName())
					.distinct()
					.count() == 1;

			if (!singleTarget)
			{
				return;
			}

			ClassFile oldOwner = m.getClassFile();

			m.getClassFile().removeMethod(m);
			cf.addMethod(m);
			m.setClassFile(cf);

			if (m.getAnnotations().find(DeobAnnotations.OBFUSCATED_OWNER) == null)
			{
				String oldOwnerName = DeobAnnotations.getObfuscatedName(oldOwner.getAnnotations());

				if (oldOwnerName == null)
				{
					oldOwnerName = oldOwner.getName();
				}

				// Put the annotation first in the list to get owner, name, signature order
				m.getAnnotations().addAnnotation(0, DeobAnnotations.OBFUSCATED_OWNER, "value", oldOwnerName);
			}

			logger.info("Moved {}.{}{} to {}",
					oldOwner.getName(), m.getName(), m.getDescriptor(), cf.getName());

			count.incrementAndGet();
		});

		logger.info("Moved {}/{} static methods back to their original classes", count, usedMethods.size());

		this.regeneratePool(group);
	}

	private void findMethods(Method method)
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

	private void findUnusedMethods(ClassFile cf)
	{
		boolean extendsApplet = extendsApplet(cf);

		for (Method method : new ArrayList<>(cf.getMethods()))
		{
			if (!method.isStatic())
			{
				continue;
			}

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
				unusedMethods.add(method);
			}
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

	private void findUsedMethods()
	{
		Set<Method> usedMethods = methods
				.stream()
				.filter(Method::isStatic)
				.filter(m -> !unusedMethods.contains(m))
				.collect(Collectors.toSet());

		this.usedMethods.addAll(usedMethods);
	}

	private List<Integer> getLineNumbers(Method method)
	{
		return new ArrayList<>(method.getLineNumbers().getLineNumbers().values());
	}

	private void regeneratePool(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code c = m.getCode();
				if (c == null)
				{
					continue;
				}

				c.getInstructions().regeneratePool();
			}
		}
	}
}
