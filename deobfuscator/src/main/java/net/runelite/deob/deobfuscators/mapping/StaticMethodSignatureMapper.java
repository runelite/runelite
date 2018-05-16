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

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;

public class StaticMethodSignatureMapper
{
	private Multimap<Method, Method> map = LinkedHashMultimap.create();

	private List<Method> getStaticMethods(ClassGroup group)
	{
		List<Method> methods = new ArrayList<>();
		for (ClassFile cf : group.getClasses())
		{
			if (cf.getName().startsWith("net/runelite"))
			{
				// XXX net/runelite/rs/Reflection uses invokedynamic
				continue;
			}

			for (Method m : cf.getMethods())
			{
				// this used to check the method wasnt <clinit>,
				// but fernflower was modified to not remove code
				// in clinit and place into ConstantValue attriutes
				// on fields, so the execution order of clinit no longer
				// depends on field order
				if (m.isStatic())
				{
					methods.add(m);
				}
			}
		}
		return methods;
	}

	private List<Method> getStaticMethodsOfSignature(ClassGroup group, Signature sig)
	{
		return getStaticMethods(group).stream().filter(
			m -> MappingExecutorUtil.isMaybeEqual(m.getDescriptor(), sig)
		).collect(Collectors.toList());
	}

	public void map(ClassGroup group1, ClassGroup group2)
	{
		for (Method m : getStaticMethods(group1))
		{
			map.putAll(m, getStaticMethodsOfSignature(group2, m.getDescriptor()));
		}
	}

	public Multimap<Method, Method> getMap()
	{
		return map;
	}
}
