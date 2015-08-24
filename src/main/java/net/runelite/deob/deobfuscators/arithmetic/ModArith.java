package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	private MultiValueMap<Field, Integer> constants = new MultiValueMap<>();
	//private MultiValueMap<Field, InstructionContext> fieldIns = new MultiValueMap<>();
	

	
//	private void findGetField(InstructionContext ctx)
//	{
//		
//	}
	
	private void findUses()
	{
		//List<InstructionContext> list = new ArrayList<>();
		
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
					int value = (int) pc.getConstant().getObject();
					
					constants.put(field, value);
				}
				else if (ctx.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();
					
					StackContext value = ctx.getPops().get(0); // what setfield pops as value
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
					
					Field field = sf.getMyField();
					int value2 = (int) pc.getConstant().getObject();
					
					constants.put(field, value2);
				}
			}
	}
	
	private void reduce()
	{
		MultiValueMap<Field, Integer> values = constants;
		constants = new MultiValueMap<>();
		
		for (Field field : values.keySet())
		{
			Collection<Integer> col = values.getCollection(field);
			
			Map<Integer, Integer> map = CollectionUtils.getCardinalityMap(col);
			int max = Collections.max(map.values());

			for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (max == entry.getValue()) {
					int constant = entry.getKey();
					
					constants.put(field, constant);
					break;
				}
			}
		}
	}
	
//	public void calculate(Field field)
//	{
//		Collection<InstructionContext> c = fieldIns.getCollection(field);
//		if (c == null)
//			return;
//		
//		List<Integer> constants = new ArrayList<>();
//		for (InstructionContext ctx : c)
//		{
//			if (ctx.getInstruction() instanceof GetFieldInstruction)
//			{
//				List<Field> fields = getFieldsInExpression(ctx, constants);
//				if (fields.size() == 1)
//				{
//				}
//			}
//		}
//		
//		Map<Integer, Integer> map = CollectionUtils.getCardinalityMap(constants);
//		int max = Collections.max(map.values());
//
//		for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			if (max == entry.getValue()) {
//				int constant = entry.getKey();
//
//				System.out.println(constant);
//				assert DMath.isInversable(constant);
//				break;
//			}
//		}
//	}
	
	private List<Field> getFieldsInExpression(InstructionContext ctx, List<Integer> constants)
	{
		return check(ctx, new HashSet<InstructionContext>(), constants);
	}
	
	private List<Field> check(InstructionContext context, Set<InstructionContext> visited, List<Integer> constants)
	{
		List<Field> fields = new ArrayList<>();
		
		if (visited.contains(context))
			return fields;
		
		visited.add(context);
		
		if (context.getInstruction() instanceof InvokeInstruction)
		{
			// field = func(field * constant), the output of the function isn't directly related to the result of field * constant
			return fields;
		}
		
		if (context.getInstruction() instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) context.getInstruction();
			Field myf = fi.getMyField();
			if (myf != null)
				fields.add(myf);
		}
		
		if (context.getInstruction() instanceof PushConstantInstruction)
		{
			PushConstantInstruction pci = (PushConstantInstruction) context.getInstruction();
			int i = (int) pci.getConstant().getObject();
			constants.add(i);
		}
		
		for (StackContext ctx : context.getPops())
		{
			InstructionContext i = ctx.getPushed();
			
			fields.addAll(check(i, visited, constants));
		}
		
		for (StackContext ctx : context.getPushes())
		{
			InstructionContext i = ctx.getPopped();
			
			if (i == null)
				continue;
			
			fields.addAll(check(i, visited, constants));
		}
		
		return fields;
	}

	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		group.buildClassGraph();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findUses();
		reduce();
		
		int i = 0;
		for (Field field : constants.keySet())
		{
			System.out.println("Processing " + field.getName());
			int getter = constants.getCollection(field).iterator().next();
			
			if (i > 5)
				break;
			
			Pair pair = new Pair();
			pair.field = field;
			pair.getter = getter;
			pair.setter = DMath.modInverse(getter);
			
			Encryption encr = new Encryption();
			encr.addPair(pair);
			
			execution = new Execution(group);
			execution.populateInitialMethods();
			execution.setEncryption(encr);
			execution.run();
			
			encr.doChange();
			System.out.println("Changed" + ++i);
		}
		
		Encryption encr = new Encryption();
		System.out.println(constants);
		
//		execution = new Execution(group);
//		execution.populateInitialMethods();
//		
//		Encryption encr = new Encryption(0);
//		execution.setEncryption(encr);
//		
//		execution.run();
//		
//		encr.doChange();
//		
//		
//		execution = new Execution(group);
//		execution.populateInitialMethods();
//		
//		encr = new Encryption(1);
//		execution.setEncryption(encr);
//		
//		execution.run();
//		
//		encr.doChange();
		
//		findUses();
//		
//		Field f = group.findClass("class41").findField("field1170");
//		calculate(f);
	}
	
}
