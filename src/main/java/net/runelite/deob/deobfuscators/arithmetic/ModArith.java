package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.MultiValueMap;

/*
store an encryption context on stack context that shows the value the ctx is encrypted with
*/

public class ModArith implements Deobfuscator
{
	private ClassGroup group;
	private Execution execution;
	private MultiValueMap<Field, Integer> constantGetters = new MultiValueMap<>(),
		constantSetters = new MultiValueMap<>();
	private List<Pair> pairs = new ArrayList<>();
	
	private List<Integer> findAssocConstants(Field field, InstructionContext ctx) throws OtherFieldException
	{
		// starts with ctx = setfield
		
		List<Integer> list = new ArrayList<>();
		
		if (ctx.getInstruction() instanceof LDC_W)
		{
			LDC_W pci = (LDC_W) ctx.getInstruction();
			if (pci.getConstant().getObject() instanceof Integer)
				list.add((int) pci.getConstant().getObject());
		}
		
		if (ctx.getInstruction() instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) ctx.getInstruction();
			
			if (fi.getMyField() != field)
				throw new OtherFieldException();
		}
		
		for (StackContext sctx : ctx.getPops())
		{
			list.addAll(findAssocConstants(field, sctx.getPushed()));
		}
		
		return list;
	}

	private void findUses()
	{		
		for (Frame f : execution.processedFrames)
			for (InstructionContext ctx : f.getInstructions())
			{
				if (ctx.getInstruction() instanceof IMul)
				{
					Instruction one = ctx.getPops().get(0).getPushed().getInstruction();
					Instruction two = ctx.getPops().get(1).getPushed().getInstruction();
					
					PushConstantInstruction pc = null;
					GetFieldInstruction gf = null;
					if (one instanceof PushConstantInstruction && two instanceof GetFieldInstruction)
					{
						pc = (PushConstantInstruction) one;
						gf = (GetFieldInstruction) two;
					}
					else if (two instanceof PushConstantInstruction && one instanceof GetFieldInstruction)
					{
						pc = (PushConstantInstruction) two;
						gf = (GetFieldInstruction) one;
					}
					
					if (pc == null)
						continue;
					
					Field field = gf.getMyField();
					if (field == null)
						continue;
					
					int value = (int) pc.getConstant().getObject();
					
					if (value == 1 || value == 0)
						continue;
					
					constantGetters.put(field, value);
				}
				else if (ctx.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();
					
					Field field = sf.getMyField();
					if (field == null)
						continue;
					
					List<Integer> constants = null;
					try
					{
						constants = findAssocConstants(field, ctx);
						for (int i : constants)
							if (i != 1 && i != 0)
								constantSetters.put(field, i);
					}
					catch (OtherFieldException ex) { }
					
					StackContext value = ctx.getPops().get(0); // the first thing poppe from both putfield and putstatic is the value
					if (!(value.getPushed().getInstruction() instanceof IMul))
						continue;
					
					Instruction one = value.getPushed().getPops().get(0).getPushed().getInstruction();
					Instruction two = value.getPushed().getPops().get(1).getPushed().getInstruction();
					
					PushConstantInstruction pc = null;
					Instruction other = null;
					if (one instanceof PushConstantInstruction)
					{
						pc = (PushConstantInstruction) one;
						other  = two;
					}
					else if (two instanceof PushConstantInstruction)
					{
						pc = (PushConstantInstruction) two;
						other = one;
					}
					
					if (pc == null)
						continue;
					
					int value2 = (int) pc.getConstant().getObject();
					
					if (value2 == 1 || value2 == 0)
						continue;
					
					constantSetters.put(field, value2);
				}
			}
	}
	
	private Pair reduce(Collection<Integer> getters, Collection<Integer> setters)
	{
		Pair p = null;
		
		for (Integer i : getters)
		{
			Integer inverse;
			try
			{
				inverse = DMath.modInverse(i);
			}
			catch (ArithmeticException ex)
			{
				continue;
			}
			
			if (setters.contains(inverse))
			{
				if (p != null && p.getter != i)
					return null;
				
				if (p == null)
				{
					p = new Pair();
					p.getter = i;
					p.setter = inverse;
				}
			}
		}
		
		for (Integer i : setters)
		{
			Integer inverse;
			try
			{
				inverse = DMath.modInverse(i);
			}
			catch (ArithmeticException ex)
			{
				continue;
			}
			
			if (getters.contains(inverse))
			{
				if (p != null && p.setter != i)
					return null;
				
				if (p == null)
				{
					p = new Pair();
					p.setter = i;
					p.getter = inverse;
				}
			}
		}
		
		return p;
	}
	
	private Pair guess(Collection<Integer> getters)
	{
		Map<Integer, Integer> map = CollectionUtils.getCardinalityMap(getters);
		int max = Collections.max(map.values());
		int size = getters.size();
		
		if (size < 50)
			return null;
		
		if (((float) max / (float) size) < 0.9)
			return null;

		for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (max == entry.getValue()) {
				int constant = entry.getKey();

				Pair pair = new Pair();
				pair.getter = constant;
				pair.setter = DMath.modInverse(constant);
				return pair;
			}
		}
		
		assert false;
		return null;
	}
	
	private void reduce()
	{
		for (ClassFile cf : group.getClasses())
			for (Field f : cf.getFields().getFields())
			{
				Collection<Integer> getters = constantGetters.getCollection(f),
					setters = constantSetters.getCollection(f);
				
				if (getters == null || setters == null)
					continue;
				
				Pair answer = reduce(getters, setters);
				if (answer == null)
				{
					answer = guess(getters);
					if (answer == null)
						continue;
				}
				
				answer.field = f;
				pairs.add(answer);
			}
	}

	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		while (runOnce() > 0);
	}
	
	private int runOnce()
	{
		group.buildClassGraph();
		
		pairs.clear();
		constantGetters.clear();;
		constantSetters.clear();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findUses();
		reduce();
		
		int i = 0;
		int start = 0, end = pairs.size();
		for (int j = start; j < end; ++j)
		//for (Pair pair : pairs)
		{
			Pair pair = pairs.get(j);
			Field field = pair.field;

			if (!field.getName().equals("field1980") && !field.getName().equals("field1961"))
			{
//				continue;
			}
			
			System.out.println("Processing " + field.getName() + " getter " + pair.getter + " setter " + pair.setter);
			
			Encryption encr = new Encryption();
			encr.addPair(pair);
			
			execution = new Execution(group);
			execution.populateInitialMethods();
			execution.setEncryption(encr);
			execution.run();
			
			encr.doChange();
			System.out.println("Changed " + ++i);
		}
		
		Encryption encr = new Encryption();
		System.out.println(pairs);
		
		return i;
	}
	
}
