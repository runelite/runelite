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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import org.apache.commons.collections4.CollectionUtils;

public class ClassMapper
{
	private final ClassFile one, two;

	public ClassMapper(ClassFile one, ClassFile two)
	{
		this.one = one;
		this.two = two;
	}
	
	private List<Integer> fieldCardinalities(ClassFile cf)
	{
		List<Type> t = cf.getFields().stream()
			.filter(f -> !f.isStatic())
			.map(f -> f.getType())
			.collect(Collectors.toList());
		
		Map<Type, Integer> m = CollectionUtils.getCardinalityMap(t);
		
		List<Integer> occurances = new ArrayList<>(m.values());
		Collections.sort(occurances);
		return occurances;
	}
	
	private List<Integer> methodCardinalities(ClassFile cf)
	{
		List<Signature> t = cf.getMethods().getMethods().stream()
			.filter(m -> !m.isStatic())
			.filter(m -> !m.getName().startsWith("<"))
			.map(m -> m.getDescriptor())
			.collect(Collectors.toList());
		
		Map<Signature, Integer> m = CollectionUtils.getCardinalityMap(t);
		
		List<Integer> occurances = new ArrayList<>(m.values());
		Collections.sort(occurances);
		return occurances;
	}
	
	public boolean same()
	{
		List<Integer> c1 = fieldCardinalities(one), c2 = fieldCardinalities(two);
		
		if (!c1.equals(c2))
			return false;
		
		c1 = methodCardinalities(one);
		c2 = methodCardinalities(two);
		
		if (!c1.equals(c2))
			return false;
		
		return true;
	}
}
