package net.runelite.deob.deobfuscators;

import java.util.ArrayList;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;

public class UnusedFields implements Deobfuscator
{
	private static boolean isUnused(ClassGroup group, Field field)
	{
		int get = 0, set = 0;
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				if (code == null)
					continue;
				
				for (Instruction ins : code.getInstructions().getInstructions())
				{
					if (ins instanceof FieldInstruction)
					{
						FieldInstruction fi = (FieldInstruction) ins;
						
						if (fi.getMyField() != field)
							continue;

						if (ins instanceof GetFieldInstruction)
							++get;
						if (ins instanceof SetFieldInstruction)
							++set;
					}
				}
			}

		// for only checking 'get' wed need a way to remove field initialization in constructors/class initializers
		return get + set == 0;
//		if (get == 0)
//			return true;
//
//		return false;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		int count = 0;
		for (ClassFile cf : group.getClasses())
			for (Field f : new ArrayList<>(cf.getFields().getFields()))
			{
				if (isUnused(group, f))
				{
					cf.getFields().getFields().remove(f);
					++count;
				}
			}
		System.out.println("Removed " + count + " unused fields");
	}
}
