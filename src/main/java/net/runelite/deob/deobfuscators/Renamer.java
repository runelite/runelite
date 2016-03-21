package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.pool.UTF8;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.deob.util.NameMappings;

public class Renamer implements Deobfuscator
{
	private static final Type OBFUSCATED_NAME_TYPE = new Type("Lnet/runelite/mapping/ObfuscatedName;");

	private final NameMappings mappings;

	public Renamer(NameMappings mappings)
	{
		this.mappings = mappings;
	}
	
	private void renameClass(ClassFile on, ClassFile old, String name)
	{
		if (on.getParentClass().getName().equals(old.getName()))
			on.setParentClass(new net.runelite.asm.pool.Class(name));
		
		Interfaces interfaces = on.getInterfaces();
		List<net.runelite.asm.pool.Class> interfaceList = interfaces.getInterfaces();
		for (net.runelite.asm.pool.Class inter : interfaceList)
			if (inter.getName().equals(old.getName()))
			{
				int idx = interfaceList.indexOf(inter);
				interfaceList.remove(idx);
				interfaceList.add(idx, new net.runelite.asm.pool.Class(name));
				break;
			}
	}
	
	private void renameClass(ClassGroup group, ClassFile cf, String name)
	{	
		for (ClassFile c : group.getClasses())
		{
			// rename on child interfaces and classes
			renameClass(c, cf, name);
			
			for (Method method : c.getMethods().getMethods())
			{
				// rename on instructions. this includes method calls and field accesses.
				if (method.getCode() != null)
				{
					// rename on exception handlers
					Exceptions exceptions = method.getCode().getExceptions();
					exceptions.renameClass(cf, name);
				}
				
				// rename on parameters
				Signature signature = method.getDescriptor();
				for (int i = 0; i < signature.size(); ++i)
				{
					Type type = signature.getTypeOfArg(i);
					
					if (type.getType().equals("L" + cf.getName() + ";"))
						signature.setTypeOfArg(i, new Type("L" + name + ";", type.getArrayDims())); 
				}
				
				// rename return type
				if (signature.getReturnValue().getType().equals("L" + cf.getName() + ";"))
					signature.setTypeOfReturnValue(new Type("L" + name + ";", signature.getReturnValue().getArrayDims()));
				
				// rename on exceptions thrown
				if (method.getExceptions() != null)
					method.getExceptions().renameClass(cf, name);
			}
			
			// rename on fields
			for (Field field : c.getFields().getFields())
				if (field.getType().getType().equals("L" + cf.getName() + ";"))
					field.setType(new Type("L" + name + ";", field.getType().getArrayDims()));
		}
		
		cf.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(cf.getName()));
		cf.setName(name);
	}
	
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
	
	private void regeneratePool(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				c.getInstructions().regeneratePool();
			}
	}

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();
		
		int classes = 0, fields = 0, methods = 0;
		
		// rename fields
		for (ClassFile cf : group.getClasses())
			for (Field field : cf.getFields().getFields())
			{
				String newName = mappings.get(field.getPoolField());
				if (newName == null)
					continue;
				
				field.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(field.getName()));
				field.setName(newName);
				++fields;
			}
		
		// rename methods
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				String newName = mappings.get(method.getPoolMethod());
				if (newName == null)
					continue;
				
				List<Method> virtualMethods = getVirutalMethods(method);
				assert !virtualMethods.isEmpty();
				
				for (Method m : virtualMethods)
				{
					m.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(m.getName()));
					m.setName(newName);
				}
				methods += virtualMethods.size();
			}
		
		for (ClassFile cf : group.getClasses())
		{
			String newName = mappings.get(cf.getPoolClass());
			if (newName == null)
				continue;
			
			renameClass(group, cf, newName);
			++classes;
		}
		
		this.regeneratePool(group);
		
		System.out.println("Renamed " + classes + " classes, " + fields + " fields, and " + methods + " methods");
	}
}
