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
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MoveBackMethods implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(MoveBackMethods.class);

	private Execution execution;

	private final Set<Method> unusedMethods = new HashSet<>();
	private final Set<Method> usedMethods = new HashSet<>();

	private final Map<Method, List<Method>> realMethodDummies = new HashMap<>();

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();

		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();

		findUnusedMethods(group);
		findUsedMethods(group);

		for (Method m : usedMethods)
		{
			removeUnusedInstructions(m);
		}

		for (Method m : usedMethods)
		{
			findDummies(m);
		}

		AtomicInteger movedCount = new AtomicInteger();
		AtomicInteger foundRealClassCount = new AtomicInteger();

		realMethodDummies.forEach((m, ml) ->
		{
			boolean singleTarget = ml
					.stream()
					.map(m2 -> m2.getClassFile().getName())
					.distinct()
					.count() == 1;

			ClassFile newOwner;

			if (singleTarget)
			{
				foundRealClassCount.incrementAndGet();

				ClassFile cf = ml.get(0).getClassFile();

				if (cf.getName().equals(m.getClassFile().getName()))
				{
					return;
				}

				newOwner = cf;
			}
			else
			{
				ParallelExecutorMapping highest = null;

				for (Method m2 : ml)
				{
					ParallelExecutorMapping mapping = MappingExecutorUtil.map(m, m2);

					if (highest == null || mapping.same > highest.same)
					{
						highest = mapping;
					}
				}

				if (highest == null)
				{
					return;
				}

				newOwner = highest.m2.getClassFile();
			}

			ClassFile oldOwner = m.getClassFile();

			m.getClassFile().removeMethod(m);
			newOwner.addMethod(m);
			m.setClassFile(newOwner);

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
					oldOwner.getName(), m.getName(), m.getDescriptor(), newOwner.getName());

			movedCount.incrementAndGet();
		});

		logger.info("Found the original class for {}/{} static methods", foundRealClassCount, usedMethods.size());
		logger.info("Moved {}/{} static methods back to their original classes", movedCount, usedMethods.size());

		this.regeneratePool(group);
	}

	private void findUnusedMethods(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				if (!m.isStatic())
				{
					continue;
				}

				if (m.getName().equals("<clinit>"))
				{
					continue;
				}

				List<Instruction> instructions = m.getCode().getInstructions().getInstructions();

				if (instructions.size() > 0)
				{
					if (!execution.executed.contains(instructions.get(0)))
					{
						unusedMethods.add(m);
					}
				}
			}
		}
	}

	private void findUsedMethods(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				if (!m.isStatic())
				{
					continue;
				}

				if (m.getName().equals("<clinit>"))
				{
					continue;
				}

				if (unusedMethods.contains(m))
				{
					continue;
				}

				usedMethods.add(m);
			}
		}
	}

	private void removeUnusedInstructions(Method m)
	{
		Instructions ins = m.getCode().getInstructions();

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
			}
		}
	}

	private void findDummies(Method m) {
		List<Integer> lineNumbers = getLineNumbers(m);

		for (Method m2 : unusedMethods)
		{
			if (!equalsDescriptors(m.getDescriptor(), m2.getDescriptor()))
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

	private List<Integer> getLineNumbers(Method method)
	{
		return new ArrayList<>(method.getLineNumbers().getLineNumbers().values());
	}

	private boolean equalsDescriptors(Signature s, Signature s2)
	{
		if (!s.getReturnValue().equals(s2.getReturnValue()))
		{
			return false;
		}

		int commonDescSize = Math.min(s.size(), s2.size());

		for (int i = 0; i < commonDescSize; i++)
		{
			if (!s.getArguments().get(i).equals(s2.getArguments().get(i)))
			{
				return false;
			}
		}

		// Used methods can have an extra parameter (the opaque predicate)
		// Dummy methods cannot
		if (s.size() != s2.size()
				&& s.size() != s2.size() + 1)
		{
			return false;
		}

		if (s.size() == s2.size() + 1)
		{
			Type lastArgType = s.getTypeOfArg(s.size() - 1);

			if (!lastArgType.equals(Type.INT)
					&& !lastArgType.equals(Type.BYTE)
					&& !lastArgType.equals(Type.SHORT))
			{
				return false;
			}
		}

		return true;
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
