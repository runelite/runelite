package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Block;
import info.sigterm.deob.attributes.code.Instructions;

import java.util.ArrayList;

public class UnusedBlocks
{
	public void run(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (m.getCode() == null)
					continue;
				
				Instructions ins = m.getCode().getInstructions();
				ins.buildBlocks();
				
				int count = 0;
				for (Block b : new ArrayList<>(ins.getBlocks()))
				{
					// first block is the entrypoint, so its always used
					if (count++ == 0)
						continue;
					
					if (b.begin.from.isEmpty() && b.begin.exce.isEmpty())
					{
						ins.remove(b);
						++i;
					}
				}
			}
		}
		System.out.println("Removed " + i + " unused blocks");
	}
}
