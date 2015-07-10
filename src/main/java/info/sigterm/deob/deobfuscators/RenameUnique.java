package info.sigterm.deob.deobfuscators;

import java.util.List;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Interfaces;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Exceptions;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.signature.Type;

public class RenameUnique
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
	
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			if (cf.getName().length() > 2)
				continue;
			
			renameClass(group, cf, "class" + i++);
			
			// rename method
			
			// rename fields
		}
	}
}
