package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.AttributeType;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.ConstantValue;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.NOP;
import java.util.ArrayList;
import java.util.List;

public class FieldInliner implements Deobfuscator
{
	private ClassGroup group;
	private List<Field> fields = new ArrayList<>();
	
	private List<FieldInstruction> findFieldIns(Field field, boolean set)
	{
		List<FieldInstruction> ins = new ArrayList<>();
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				for (Instruction i : code.getInstructions().getInstructions())
				{
					if (!(i instanceof FieldInstruction))
						continue;
					
					FieldInstruction sf = (FieldInstruction) i;
					
					if (sf.getMyField() != field)
						continue;
					
					if (sf instanceof SetFieldInstruction != set)
						continue;
					
					ins.add(sf);
				}
			}
		}
		
		return ins;
	}
	
	private void makeConstantValues()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Field f : cf.getFields().getFields())
			{
				if (!f.isStatic() || !f.getType().getFullType().equals("Ljava/lang/String;"))
					continue;
				
				Attributes attributes = f.getAttributes();
				ConstantValue constantValue = (ConstantValue) attributes.findType(AttributeType.CONSTANT_VALUE);
				if (constantValue != null)
					continue;
				
				List<FieldInstruction> sfis = findFieldIns(f, true);
				if (sfis.size() != 1)
					continue;
				
				SetFieldInstruction sfi = (SetFieldInstruction) sfis.get(0);
				Instruction ins = (Instruction) sfi;
				
				Method mOfSet = ins.getInstructions().getCode().getAttributes().getMethod();
				if (!mOfSet.getName().equals("<clinit>"))
					continue;
				
				// get prev instruction and change to a constant value
				Instructions instructions = mOfSet.getCode().getInstructions();
				int idx = instructions.getInstructions().indexOf(ins);
				assert idx != -1;
				
				Instruction prev = instructions.getInstructions().get(idx - 1);
				if (!(prev instanceof PushConstantInstruction))
					continue;
				
				PushConstantInstruction pci = (PushConstantInstruction) prev;
				
				constantValue = new ConstantValue(attributes, pci.getConstant());
				attributes.addAttribute(constantValue);
				
				fields.add(f);
				
				// nop
				NOP nop1 = new NOP(instructions), nop2 = new NOP(instructions);

				for (Instruction i : instructions.getInstructions())
					i.replace(prev, nop1);

				for (Instruction i : instructions.getInstructions())
					i.replace(ins, nop1);
				
				boolean b = instructions.getInstructions().remove(prev);
				assert b;
				b = instructions.getInstructions().remove(ins);
				assert b;
				
				instructions.getInstructions().add(idx - 1, nop1);
				instructions.getInstructions().add(idx, nop2);
			}
		}
	}
	
	public int inlineUse()
	{
		int count = 0;
		
		for (Field f : fields)
		{
			// replace getfield with constant push
			List<FieldInstruction> fins = findFieldIns(f, false);
			ConstantValue value = (ConstantValue) f.getAttributes().findType(AttributeType.CONSTANT_VALUE);
			
			for (FieldInstruction fin : fins)
			{
				// remove fin, add push constant
				Instruction i = (Instruction) fin;
				
				Instruction pushIns = new LDC_W(i.getInstructions(), value.getValue());
				
				List<Instruction> instructions = i.getInstructions().getInstructions();
				
				int idx = instructions.indexOf(i);
				assert idx != -1;
				
				// move jumps to i to pushIns
				for (Instruction i2 : instructions)
					i2.replace(i, pushIns);
				
				i.getInstructions().remove(i);
				instructions.add(idx, pushIns);
				
				++count;
			}
			
			f.getFields().getFields().remove(f);
		}
		
		return count;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		makeConstantValues();
		int count = inlineUse();
		
		System.out.println("Inlined " + count + " fields");
	}
	
}
