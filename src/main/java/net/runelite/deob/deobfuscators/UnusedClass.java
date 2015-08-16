package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;

public class UnusedClass implements Deobfuscator
{
	@Override
	public void run(ClassGroup group)
	{
		int count = 0;
		for (ClassFile cf : new ArrayList<>(group.getClasses()))
		{
			if (!cf.getFields().getFields().isEmpty())
				continue;
			
			if (!cf.getMethods().getMethods().isEmpty())
				continue;
			
			group.removeClass(cf);
			++count;
		}
		System.out.println("Removed " + count + " classes");
	}
	
}
