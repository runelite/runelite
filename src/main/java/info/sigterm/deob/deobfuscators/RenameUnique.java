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
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.signature.Type;

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
	
	private void findMethodDown(List<Method> list, ClassFile cf, Method method)
	{
		if (cf == null)
			return;
		
		Method m = cf.findMethod(method.getNameAndType());
		if (m != null && !m.isStatic())
			list.add(m);
		
		findMethodDown(list, cf.getParent(), method);
		
		for (ClassFile inter : cf.getInterfaces().getMyInterfaces())
			findMethodDown(list, inter, method);
	}
	
	private void findMethodUp(List<Method> list, ClassFile cf, Method method)
	{
		Method m = cf.findMethod(method.getNameAndType());
		if (m != null && !m.isStatic())
			list.add(m);
		
		for (ClassFile child : cf.getChildren())
			findMethodUp(list, child, method);
	}
	
	private List<Method> getVirutalMethods(Method method)
	{
		List<Method> list = new ArrayList<>();
		
		list.add(method);
		
		if (method.isStatic())
			return list;
		
		ClassFile classOfMethod = method.getMethods().getClassFile();
		findMethodDown(list, classOfMethod.getParent(), method);
		
		for (ClassFile inter : classOfMethod.getInterfaces().getMyInterfaces())
			findMethodDown(list, inter, method);
		
		for (ClassFile child : classOfMethod.getChildren())
			findMethodUp(list, child, method);
		
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
		
		group.buildClassGraph();
		
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
