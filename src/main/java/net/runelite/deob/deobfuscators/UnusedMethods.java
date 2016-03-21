package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.execution.Execution;

import java.util.ArrayList;

public class UnusedMethods implements Deobfuscator
{
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
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
