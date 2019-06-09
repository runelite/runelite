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

package net.runelite.asm.signature.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;

public class VirtualMethods
{
	// find the base methods for a method. search goes up from there to see if two
	// different methods can be invoked with the same instruction.
	private static List<Method> findBaseMethods(List<Method> methods, ClassFile cf, String name, Signature type)
	{
		if (cf == null)
			return methods;
		
		Method m = cf.findMethod(name, type);
		if (m != null && !m.isStatic())
			methods.add(m);
		
		List<Method> parentMethods = findBaseMethods(new ArrayList<>(), cf.getParent(), name, type);
		
		for (ClassFile inter : cf.getInterfaces().getMyInterfaces())
			parentMethods.addAll(findBaseMethods(new ArrayList<>(), inter, name, type));
		
		// parentMethods take precedence over our methods
		return parentMethods.isEmpty() ? methods : parentMethods;
	}
	
	private static List<Method> findBaseMethods(Method method)
	{
		return findBaseMethods(new ArrayList<>(), method.getClassFile(), method.getName(), method.getDescriptor());
	}
	
	private static void findMethodUp(List<Method> methods, Set<ClassFile> visited, ClassFile cf, String name, Signature type)
	{
		if (cf == null || visited.contains(cf))
			return;
		
		visited.add(cf); // can do diamond inheritance with interfaces
		
		Method m = cf.findMethod(name, type);
		if (m != null && !m.isStatic())
			methods.add(m);
		
		for (ClassFile child : cf.getChildren())
			findMethodUp(methods, visited, child, name, type);
	}
	
	public static List<Method> getVirtualMethods(Method method)
	{
		List<Method> list = new ArrayList<>();
		
		if (method.isStatic())
		{
			list.add(method);
			return list;
		}
		
		List<Method> bases = findBaseMethods(method); // base methods method overrides
		assert !bases.isEmpty(); // must contain at least a method
		
		// now search up from bases, appending to list.
		for (Method m : bases)
			findMethodUp(list, new HashSet<>(), m.getClassFile(), m.getName(), m.getDescriptor());

		return list;
	}
}
