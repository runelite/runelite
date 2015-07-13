package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.block.Block;

import java.util.ArrayList;

public class UnusedBlocks implements Deobfuscator
{
	public int pass(ClassGroup group)
	{
		int removed = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (m.getCode() == null)
					continue;
				
				Instructions ins = m.getCode().getInstructions();
				ins.buildBlocks();
				
				for (int i = 0; i < ins.getBlocks().size(); ++i)
				{
					Block block = ins.getBlocks().get(i);
							
					// first block is the entrypoint, so its always used
					if (i == 0)
						continue;
					
					Block prev = ins.getBlocks().get(i - 1);
					
					if (prev.end.isTerminal() && block.begin.from.isEmpty() && block.handlers.isEmpty())
					{
						ins.remove(block);
						++removed;
						break;
					}
				}
			}
		}
		
		System.out.println("Removed " + removed + " unused blocks");
		return removed;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		while (pass(group) > 0);
	}
}
