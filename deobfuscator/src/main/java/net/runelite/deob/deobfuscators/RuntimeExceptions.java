package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;

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
				
				for (net.runelite.asm.attributes.code.Exception e : new ArrayList<>(c.getExceptions().getExceptions()))
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
