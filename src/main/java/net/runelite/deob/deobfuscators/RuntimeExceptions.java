package net.runelite.deob.deobfuscators;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;

import java.util.ArrayList;

public class RuntimeExceptions implements Deobfuscator
{
	@Override
	public void run(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				for (net.runelite.deob.attributes.code.Exception e : new ArrayList<>(c.getExceptions().getExceptions()))
				{
					if (e.getCatchType() != null && e.getCatchType().getName().equals("java/lang/RuntimeException"))
					{
						c.getExceptions().remove(e);
						++i;
					}
				}
			}
		}
		System.out.println("Removed " + i + " exception handlers");
	}
}
