package info.sigterm.deob.deobfuscators;

import java.util.ArrayList;
import java.util.List;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Field;
import info.sigterm.deob.Interfaces;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Exceptions;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.signature.Type;
import java.util.HashSet;
import java.util.Set;

public class RenameUnique implements Deobfuscator
{
	private void renameClass(ClassFile on, ClassFile old, String name)
	{
		if (on.getParentClass().getName().equals(old.getName()))
			on.setParentClass(new Class(name));
		
		Interfaces interfaces = on.getInterfaces();
		List<Class> interfaceList = interfaces.getInterfaces();
		for (Class inter : interfaceList)
			if (inter.getName().equals(old.getName()))
			{
				int idx = interfaceList.indexOf(inter);
				interfaceList.remove(idx);
				interfaceList.add(idx, new Class(name));
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
					Instructions instructions = method.getCode().getInstructions();
					instructions.renameClass(cf, name);
					
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
		
		cf.setName(name);
	}
	
	private void renameField(ClassGroup group, Field field, String name)
	{
		for (ClassFile c : group.getClasses())
		{
			for (Method method : c.getMethods().getMethods())
			{
				// rename on instructions
				if (method.getCode() != null)
				{
					Instructions instructions = method.getCode().getInstructions();
					instructions.renameField(field, name);
				}
			}
		}
		
		field.setName(name);
	}
	
	// find the base methods for a method. search goes up from there to see if two
	// different methods can be invoked with the same instruction.
	private List<Method> findBaseMethods(List<Method> methods, ClassFile cf, NameAndType method)
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
	
	private List<Method> findBaseMethods(Method method)
	{
		return findBaseMethods(new ArrayList<Method>(), method.getMethods().getClassFile(), method.getNameAndType());
	}
	
	private void findMethodUp(List<Method> methods, Set<ClassFile> visited, ClassFile cf, NameAndType method)
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
	
	private List<Method> getVirutalMethods(Method method)
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
			findMethodUp(list, new HashSet<ClassFile>(), m.getMethods().getClassFile(), m.getNameAndType());

		return list;
	}
	
	private void renameMethod(ClassGroup group, List<Method> methods, String name)
	{
		for (ClassFile c : group.getClasses())
		{
			for (Method method : c.getMethods().getMethods())
			{
				// rename on instructions
				if (method.getCode() != null)
				{
					Instructions instructions = method.getCode().getInstructions();
					for (Method m : methods)
						instructions.renameMethod(m, name);
				}
			}
		}
		
		for (Method m : methods)
			m.setName(name);
	}

	@Override
	public void run(ClassGroup group)
	{
		int i = 0;
		int classes = 0, fields = 0, methods = 0;
		
		group.buildClassGraph();
		
		for (ClassFile cf : group.getClasses())
		{
			if (cf.getName().length() > 2)
				continue;
			
			renameClass(group, cf, "class" + i++);
			++classes;
		}
		
		// rename fields
		for (ClassFile cf : group.getClasses())
			for (Field field : cf.getFields().getFields())
			{
				if (field.getName().length() > 2)
					continue;
				
				renameField(group, field, "field" + i++);
				++fields;
			}
		
		// rename methods
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				if (method.getName().length() > 2)
					continue;
				
				List<Method> virtualMethods = getVirutalMethods(method);
				assert !virtualMethods.isEmpty();
				
				String name;
				if (virtualMethods.size() == 1)
					name = "method" + i++;
				else
					name = "vmethod" + i++;
				
				renameMethod(group, virtualMethods, name);
				methods += virtualMethods.size();
			}
		
		System.out.println("Uniquely renamed " + classes + " classes, " + fields + " fields, and " + methods + " methods");
	}
}
