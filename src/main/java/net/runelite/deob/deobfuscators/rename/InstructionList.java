package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeVirtual;
import net.runelite.deob.deobfuscators.arithmetic.DMath;
import net.runelite.deob.pool.PoolEntry;
import net.runelite.deob.signature.Signature;
import net.runelite.deob.signature.Type;

public class InstructionList
{
	private final List<Instruction> instructions;
	
	public InstructionList(List<Instruction> instructions)
	{
		this.instructions = instructions;
	}
	
	public boolean couldBeEqual(InstructionList other)
	{
		Multiset<Signature> sig1 = HashMultiset.create(),
			sig2 = HashMultiset.create();
		
		// check signatures and field types
		instructions.stream().filter(i -> i instanceof InvokeVirtual).forEach(i -> {
			InvokeVirtual iv = (InvokeVirtual) i;
			for (Method m : iv.getMethods())
				sig1.add(m.getDescriptor());
		});
		
		other.instructions.stream().filter(i -> i instanceof InvokeVirtual).forEach(i -> {
			InvokeVirtual iv = (InvokeVirtual) i;
			for (Method m : iv.getMethods())
				sig2.add(m.getDescriptor());
		});
		
		if (!sig1.equals(sig2))
			return false;
		
		Set<FieldWrapper> type1 = new HashSet<>(),
			type2 = new HashSet<>();
		
		instructions.stream().filter(i -> i instanceof GetFieldInstruction).forEach(i -> {
			GetFieldInstruction gfi = (GetFieldInstruction) i;
			Field f = gfi.getMyField();
			if (f != null)
				type1.add(new FieldWrapper(gfi, f));
		});
		
		other.instructions.stream().filter(i -> i instanceof GetFieldInstruction).forEach(i -> {
			GetFieldInstruction gfi = (GetFieldInstruction) i;
			Field f = gfi.getMyField();
			if (f != null)
				type2.add(new FieldWrapper(gfi, f));
		});
		
		if (!type1.equals(type2))
		{
			for (FieldWrapper fw : type1)
			{
				if (!type2.contains(fw))
				{
					// 2726 -> 2738
					System.out.println(fw + " not in type2");
					for (FieldWrapper fw2 : type2)
					{
						if (fw2.field.getName().equals("field2738"))
						{
							int i= 5;
						}
					}
				}
			}
			return false;
		}
		
		Multiset<FieldWrapper> ms1 = HashMultiset.create(),
			ms2 = HashMultiset.create();
		
		instructions.stream().filter(i -> i instanceof SetFieldInstruction).forEach(i -> {
			SetFieldInstruction sfi = (SetFieldInstruction) i;
			Field f = sfi.getMyField();
			if (f != null)
				ms1.add(new FieldWrapper(sfi, f));
		});
		
		other.instructions.stream().filter(i -> i instanceof SetFieldInstruction).forEach(i -> {
			SetFieldInstruction sfi = (SetFieldInstruction) i;
			Field f = sfi.getMyField();
			if (f != null)
				ms2.add(new FieldWrapper(sfi, f));
		});
		
		if (!ms1.equals(ms2))
			return false;
		
		Set<Object> constants1 = new HashSet<>(),
			constants2 = new HashSet<>();
		
		instructions.stream().filter(i -> i instanceof PushConstantInstruction).forEach(i -> {
			PushConstantInstruction pci = (PushConstantInstruction) i;
			PoolEntry e = pci.getConstant();
			Object o = e.getObject();
			
			if (o instanceof Integer || o instanceof Long)
				if (DMath.isBig((Number) o))
					return;
			
			constants1.add(o);
		});
		
		other.instructions.stream().filter(i -> i instanceof PushConstantInstruction).forEach(i -> {
			PushConstantInstruction pci = (PushConstantInstruction) i;
			PoolEntry e = pci.getConstant();
			Object o = e.getObject();
			
			if (o instanceof Integer || o instanceof Long)
				if (DMath.isBig((Number) o))
					return;
			
			constants2.add(o);
		});
		
		if (!constants1.equals(constants2))
			return false;
		
		return true;
	}
}
