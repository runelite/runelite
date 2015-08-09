package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.block.Block;

import java.util.ArrayList;
import java.util.List;

public class UnusedBlocks implements Deobfuscator
{
	private List<Method> methods = new ArrayList<>();
	
	public int pass(ClassGroup group)
	{
		int removed = 0;
	 methods:
		for (Method m : new ArrayList<>(methods))
		{
			if (m.getCode() == null)
			{
				methods.remove(m);
				continue;
			}

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
					continue methods;
				}
			}
			
			methods.remove(m);
		}
		
		System.out.println("Removed " + removed + " unused blocks");
		return removed;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				methods.add(m);
			}	
		}
		
		while (pass(group) > 0);
	}
}
