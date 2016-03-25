package net.runelite.deob.deobfuscators;

import java.util.List;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.signature.util.VirtualMethods;
import net.runelite.deob.util.NameMappings;

public class RenameUnique implements Deobfuscator
{
	private Renamer renamer;
	
	private void generateClassNames(NameMappings map, ClassGroup group)
	{
		int i = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			if (cf.getName().length() > 2)
				continue;
			
			map.map(cf.getPoolClass(), "class" + i++);
		}
	}
		
	private void generatFieldNames(NameMappings map, ClassGroup group)
	{
		int i = 0;
		
		for (ClassFile cf : group.getClasses())
			for (Field field : cf.getFields().getFields())
			{
				if (field.getName().length() > 2)
					continue;
				
				map.map(field.getPoolField(), "field" + i++);
			}
	}

	private void generateMethodNames(NameMappings map, ClassGroup group)
	{
		int i = 0;
		
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				if (method.getName().length() > 2)
					continue;
				
				List<Method> virtualMethods = VirtualMethods.getVirutalMethods(method);
				assert !virtualMethods.isEmpty();
				
				String name;
				if (virtualMethods.size() == 1)
					name = "method" + i++;
				else
					name = "vmethod" + i++;
				
				for (Method m : virtualMethods)
					map.map(m.getPoolMethod(), name);
			}
	}

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();
		
		NameMappings mappings = new NameMappings();
		
		this.generateClassNames(mappings, group);
		this.generatFieldNames(mappings, group);
		this.generateMethodNames(mappings, group);
		
		renamer = new Renamer(mappings);
		renamer.run(group);
	}
}
