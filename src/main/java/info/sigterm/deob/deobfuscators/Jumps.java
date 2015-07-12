package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Block;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.GotoW;

import java.util.ArrayList;
import java.util.List;

public class Jumps implements Deobfuscator
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
					
					if (block.begin.from.size() == 1 && block.end.isTerminal() && prev != null && prev.end.isTerminal())
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
							
							// remove instructions
							for (Instruction in : block.instructions)
							{
								boolean b = ilist.remove(in);
								assert b;
							}
							
							int idx = ilist.indexOf(from);
							boolean b = ilist.remove(from);
							assert b;
							
							b = ilist.addAll(idx, block.instructions);
							assert b;
							
							// replace from with block.begin
							for (Instruction ins2 : ilist)
								ins2.replace(from, block.begin);
							
							for (info.sigterm.deob.attributes.code.Exception e : m.getCode().getExceptions().getExceptions())
								e.replace(from, block.begin);
							
							continue methods;
						}
					}
				}
			}
		}
		return count;
	}
	
	@Override
	public void run(ClassGroup g)
	{
		int count = 0;
		int passes = 0;
		int i;
		do
		{
			i = checkBlockGraphOnce(g);
			System.out.println("pass " + i);
			count += i;
			++passes;
		}
		while (i > 0);
		
		System.out.println("Inlined " + count + " jumps in " + passes + " passes");
	}
}
