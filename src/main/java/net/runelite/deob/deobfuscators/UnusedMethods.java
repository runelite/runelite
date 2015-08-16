package net.runelite.deob.deobfuscators;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.execution.Execution;

import java.util.ArrayList;

public class UnusedMethods implements Deobfuscator
{
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph(); // does this use this?
		
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (!Deob.isObfuscated(m.getName()))
					continue;
				
				if (!execution.methods.contains(m))
				{
					cf.getMethods().removeMethod(m);
					++i;
				}
			}
		}
		
		System.out.println("Removed " + i + " methods");
	}
}
