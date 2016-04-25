package net.runelite.asm.signature.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.pool.NameAndType;

public class VirtualMethods
{
	// find the base methods for a method. search goes up from there to see if two
	// different methods can be invoked with the same instruction.
	private static List<Method> findBaseMethods(List<Method> methods, ClassFile cf, NameAndType method)
	{
		if (cf == null)
			return methods;
		
		Method m = cf.findMethod(method);
		if (m != null && !m.isStatic())
			methods.add(m);
		
		List<Method> parentMethods = findBaseMethods(new ArrayList<Method>(), cf.getParent(), method);
		
		for (ClassFile inter : cf.getInterfaces().getMyInterfaces())
			findBaseMethods(parentMethods, inter, method);
		
		// parentMethods take precedence over our methods
		return parentMethods.isEmpty() ? methods : parentMethods;
	}
	
	private static List<Method> findBaseMethods(Method method)
	{
		return findBaseMethods(new ArrayList<>(), method.getMethods().getClassFile(), method.getNameAndType());
	}
	
	private static void findMethodUp(List<Method> methods, Set<ClassFile> visited, ClassFile cf, NameAndType method)
	{
		if (cf == null || visited.contains(cf))
			return;
		
		visited.add(cf); // can do diamond inheritance with interfaces
		
		Method m = cf.findMethod(method);
		if (m != null && !m.isStatic())
			methods.add(m);
		
		for (ClassFile child : cf.getChildren())
			findMethodUp(methods, visited, child, method);
	}
	
	public static List<Method> getVirutalMethods(Method method)
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
			findMethodUp(list, new HashSet<>(), m.getMethods().getClassFile(), m.getNameAndType());

		return list;
	}
}
