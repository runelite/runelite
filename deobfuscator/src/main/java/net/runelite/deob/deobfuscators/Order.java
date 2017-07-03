/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.util.Collections;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Fields;
import net.runelite.asm.Method;
import net.runelite.asm.Methods;
import net.runelite.asm.execution.Execution;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sort fields and methods based on the order encountered by the executor
 *
 * @author Adam
 */
public class Order implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(Order.class);

	private Execution execution;

	public Execution getExecution()
	{
		return execution;
	}

	@Override
	public void run(ClassGroup group)
	{
		execution = new Execution(group);
		execution.staticStep = true;
		execution.populateInitialMethods();
		execution.run();

		int sortedMethods = 0, sortedFields = 0;

		for (ClassFile cf : group.getClasses())
		{
			Methods methods = cf.getMethods();
			List<Method> m = methods.getMethods();
			Collections.sort(m, this::compareMethod);

			sortedMethods += m.size();

			// field order of enums is mostly handled in EnumDeobfuscator
			if (!cf.isEnum())
			{
				Fields fields = cf.getFields();
				List<Field> f = fields.getFields();
				Collections.sort(f, this::compareFields);

				sortedFields += f.size();
			}
		}

		logger.info("Sorted {} methods and {} fields", sortedMethods, sortedFields);
	}

	// static fields, member fields, clinit, init, methods, static methods
	private int compareMethod(Method m1, Method m2)
	{
		int i1 = getType(m1), i2 = getType(m2);

		if (i1 != i2)
		{
			return Integer.compare(i1, i2);
		}

		return compareOrder(m1, m2);
	}

	private int compareFields(Field f1, Field f2)
	{
		int i1 = getType(f1), i2 = getType(f2);

		if (i1 != i2)
		{
			return Integer.compare(i1, i2);
		}

		return compareOrder(f1, f2);
	}

	private int getType(Method m)
	{
		if (m.getName().equals("<clinit>"))
		{
			return 1;
		}
		if (m.getName().equals("<init>"))
		{
			return 2;
		}
		if (!m.isStatic())
		{
			return 3;
		}
		return 4;
	}

	private int getType(Field f)
	{
		if (f.isStatic())
		{
			return 1;
		}
		return 2;
	}

	private int compareOrder(Object o1, Object o2)
	{
		Integer i1, i2;

		i1 = execution.getOrder(o1);
		i2 = execution.getOrder(o2);

		if (i1 == null)
		{
			i1 = Integer.MAX_VALUE;
		}
		if (i2 == null)
		{
			i2 = Integer.MAX_VALUE;
		}

		if (!i1.equals(i2))
		{
			return Integer.compare(i1, i2);
		}

		// Fall back to number of accesses
		i1 = execution.getAccesses(o1);
		i2 = execution.getAccesses(o2);

		if (i1 == null)
		{
			i1 = Integer.MAX_VALUE;
		}
		if (i2 == null)
		{
			i2 = Integer.MAX_VALUE;
		}

		return Integer.compare(i1, i2);
	}

}
