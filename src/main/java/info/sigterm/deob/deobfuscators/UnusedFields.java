package info.sigterm.deob.deobfuscators;

import java.util.ArrayList;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.FieldInstruction;

public class UnusedFields
{
	private static boolean isUnused(ClassGroup group, Field field)
	{
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
						
						info.sigterm.deob.pool.Field ff = fi.getField();
						
						if (ff.getClassEntry().getName().equals(field.getFields().getClassFile().getName()))
						{
							if (ff.getNameAndType().getName().equals(field.getName()))
							{
								return false;
							}
						}
					}
				}
			}
		return true;
	}
	
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
