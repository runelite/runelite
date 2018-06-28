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

public class MethodSignatureMapper
{
	private Multimap<Method, Method> map = LinkedHashMultimap.create();

	private List<Method> getMethods(ClassGroup group)
	{
		List<Method> methods = new ArrayList<>();
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods())
				if (!m.isStatic() && !m.getName().equals("<init>") && m.getCode() != null)
					methods.add(m);
		return methods;
	}

	private List<Method> getMethodsOfSignature(ClassGroup group, ClassFile cf, Signature sig)
	{
		return getMethods(group).stream()
			.filter(m -> MappingExecutorUtil.isMaybeEqual(cf, m.getClassFile()))
			.filter(m -> MappingExecutorUtil.isMaybeEqual(m.getDescriptor(), sig))
			.collect(Collectors.toList());
	}

	public void map(ClassGroup group1, ClassGroup group2)
	{
		for (Method m : getMethods(group1))
		{
			map.putAll(m, getMethodsOfSignature(group2, m.getClassFile(), m.getDescriptor()));
		}
	}

	public Multimap<Method, Method> getMap()
	{
		return map;
	}
}
