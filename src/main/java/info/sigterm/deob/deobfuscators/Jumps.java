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
					
					// only one thing jumps here
					if (block.begin.from.size() == 1 && prev != null && prev.end.isTerminal())
					{
						Instruction from = block.begin.from.get(0); // this instruction jumps to block
						
						if (from.block == block)
							continue;
						
						if (from instanceof Goto || from instanceof GotoW)
						{
							++count;
							
							List<Instruction> ilist = ins.getInstructions();
							
							// remove instructions
							for (Instruction in : block.instructions)
								ilist.remove(in);
							
							int index = ilist.indexOf(from);
							
							assert from.block != block;
							from.block = null;
							
							// move instructions which jump here to jump to block.begin
							for (Instruction in : from.from)
							{
								assert in.jump.contains(from);
								assert !in.jump.contains(block.begin);
								
								in.jump.remove(from);
								
								in.jump.add(block.begin);
								block.begin.from.add(in);
							}
							from.from.clear();
							
							// .replace ins
							for (Instruction in : ilist)
								in.replace(from, block.begin);
							
							for (info.sigterm.deob.attributes.code.Exception e : m.getCode().getExceptions().getExceptions())
								e.replace(from, block.begin);
							
							ins.remove(from); // remove jump
							
							// insert instructions from block where jump was
							for (Instruction in : block.instructions)
								ilist.add(index++, in);
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
