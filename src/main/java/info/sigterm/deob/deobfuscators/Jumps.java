package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Block;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.GotoW;

import java.util.ArrayList;
import java.util.List;

public class Jumps
{
	private int checkBlockGraphOnce(ClassGroup group)
	{
		int count = 0;
		for (ClassFile cf : group.getClasses())
		{
		 methods:
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (m.getCode() == null)
					continue;
				
				Instructions ins = m.getCode().getInstructions();
				ins.buildBlocks();
				ins.buildJumpGraph();
				List<Block> blocks = ins.getBlocks();
				for (int i = 0; i < blocks.size(); ++i)
				{
					Block block = blocks.get(i);
					Block prev = i > 0 ? blocks.get(i - 1) : null;
					
					if (block.begin.from.size() == 1 && prev != null && prev.end.isTerminal())
					{
						// not sure if this is right, just don't mess with blocks in exception ranges or directly handling them
						if (block.exceptions.isEmpty() == false || block.handlers.isEmpty() == false || prev.exceptions.isEmpty() == false || prev.handlers.isEmpty() == false)
							continue;
						
						Instruction from = block.begin.from.get(0); // this instruction jumps to block
						
						if (from.block == block)
							continue;
						
						if (from instanceof Goto || from instanceof GotoW)
						{
							++count;
							
							List<Instruction> ilist = ins.getInstructions();
							
							// clear jump graph
							//ins.clearBlocks();
							ins.clearJumpGraph();
							
							// 'from' goes away and is replaced with block.begin
							for (Instruction in : ilist)
								in.replace(from, block.begin);
							
							// remove instructions
							for (Instruction in : block.instructions)
							{
								boolean b = ilist.remove(in);
								assert b;
							}
							
							// store pos of from
							int index = ilist.indexOf(from);
							ilist.remove(from);
							
							// insert instructions where 'from' was
							for (Instruction in : block.instructions)
								ilist.add(index++, in);
							
							continue methods;
						}
					}
				}
			}
		}
		return count;
	}
	
	public void run(ClassGroup g)
	{
		int count = 0;
		int passes = 0;
		int i;
		do
		{
			i = checkBlockGraphOnce(g);
			count += i;
			++passes;
		}
		while (i > 0);
		
		System.out.println("Inlined " + count + " jumps in " + passes + " passes");
	}
}
