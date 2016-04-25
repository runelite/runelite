package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;

public class UnusedFields implements Deobfuscator
{
	private final Set<Field> used = new HashSet<>();

	private void checkForFieldUsage(ClassGroup group)
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

						used.add(fi.getMyField());
					}
				}
			}
	}
	
	@Override
	public void run(ClassGroup group)
	{
		checkForFieldUsage(group);
		
		int count = 0;
		for (ClassFile cf : group.getClasses())
			for (Field f : new ArrayList<>(cf.getFields().getFields()))
				if (!used.contains(f))
				{
					cf.getFields().getFields().remove(f);
					++count;
				}

		System.out.println("Removed " + count + " unused fields");
	}
}
