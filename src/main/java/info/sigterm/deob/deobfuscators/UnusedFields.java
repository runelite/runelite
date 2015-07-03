package info.sigterm.deob.deobfuscators;

import java.util.ArrayList;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.FieldInstruction;
import info.sigterm.deob.attributes.code.instruction.types.GetFieldInstruction;
import info.sigterm.deob.attributes.code.instruction.types.SetFieldInstruction;

public class UnusedFields
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
						info.sigterm.deob.pool.Field ff = fi.getField();
						
						// pool to Field
						ClassFile clazz = group.findClass(ff.getClassEntry().getName());
						if (clazz == null)
							continue;
						
						Field f = clazz.findField(ff.getNameAndType());
						
						if (field == f)
						{
							if (ins instanceof GetFieldInstruction)
								++get;
							if (ins instanceof SetFieldInstruction)
								++set;
						}
					}
				}
			}
		
		if (get == 0 && set == 0)
			return true;
		
		if (get == 0)
		{
			System.out.println("Field " + field.getFields().getClassFile().getName() + "." + field.getName() + " is set but not get");
			return false;
		}
		
		return false;
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
