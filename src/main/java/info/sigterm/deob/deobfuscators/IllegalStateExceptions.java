package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.AThrow;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.If;
import info.sigterm.deob.attributes.code.instructions.If0;
import info.sigterm.deob.attributes.code.instructions.New;

import java.util.ArrayList;
import java.util.List;

public class IllegalStateExceptions
{
	/* find if, new, ..., athrow, replace with goto */
	public void run(ClassGroup group)
	{
		int count = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				Instructions instructions = c.getInstructions();
				instructions.clearBlockGraph();
				
				List<Instruction> ilist = instructions.getInstructions();
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction ins = ilist.get(i);
					
					if (!(ins instanceof If) && !(ins instanceof If0))
						continue;
					
					Instruction ins2 = ilist.get(i + 1);
					if (!(ins2 instanceof New))
						continue;
					
					New new2 = (New) ins2;
					info.sigterm.deob.pool.Class clazz = new2.getNewClass();
					if (!clazz.getName().equals("java/lang/IllegalStateException"))
						continue;
					
					Instruction to = null;
					if (ins instanceof If)
						to = ((If) ins).getTo();
					else if (ins instanceof If0)
						to = ((If0) ins).getTo();
					
					// remove up to athrow
					do
					{
						instructions.remove(ins);
						ins = ilist.get(i); // don't need to ++i because 
					}
					while (!(ins instanceof AThrow));
					
					// remove athrow
					instructions.remove(ins);
					
					// insert goto
					ilist.add(i, new Goto(instructions, to));
					
					++count;
				}
			}
		}
		System.out.println("Removed " + count + " illegal state exceptions");
	}
}
