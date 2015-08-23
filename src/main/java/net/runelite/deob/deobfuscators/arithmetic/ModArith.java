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
	private MultiValueMap<Field, InstructionContext> fieldIns = new MultiValueMap<>();
	
	private void findGetField(InstructionContext ctx)
	{
		
	}
	
	private void findUses()
	{
		//List<InstructionContext> list = new ArrayList<>();
		
		for (Frame f : execution.processedFrames)
			for (InstructionContext ctx : f.getInstructions())
			{
				Instruction i = ctx.getInstruction();
				
				if (!(i instanceof FieldInstruction))
					continue;
				
				FieldInstruction fi = (FieldInstruction) i;
				
				Field fifield = fi.getMyField();
	
				if (fifield == null)
					continue;
				
				fieldIns.put(fifield, ctx);
//				if (i instanceof GetFieldInstruction)
//				{
//					findGetField(ctx);
//				}
			}
		
		//return list;
//		for (ClassFile cf : group.getClasses())
//			for (Field f : cf.getFields().getFields())
//			{
//				
//			}
	}
	
	public void calculate(Field field)
	{
		Collection<InstructionContext> c = fieldIns.getCollection(field);
		if (c == null)
			return;
		
		List<Integer> constants = new ArrayList<>();
		for (InstructionContext ctx : c)
		{
			if (ctx.getInstruction() instanceof GetFieldInstruction)
			{
				List<Field> fields = getFieldsInExpression(ctx, constants);
				if (fields.size() == 1)
				{
				}
			}
		}
		
		Map<Integer, Integer> map = CollectionUtils.getCardinalityMap(constants);
		int max = Collections.max(map.values());

		for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (max == entry.getValue()) {
				int constant = entry.getKey();

				System.out.println(constant);
				assert DMath.isInversable(constant);
				break;
			}
		}
	}
	
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
	
//	private void replace(Pair pair)
//	{
//		// do replacements with pair
//		
//		for (Frame frame : execution.processedFrames)
//		{
//			for (InstructionContext ctx : frame.getInstructions())
//			{
//			}
//		}
//	}

	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		group.buildClassGraph();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		
		Encryption encr = new Encryption();
		execution.setEncryption(encr);
		
		execution.run();
		
		encr.doChange();
		
//		findUses();
//		
//		Field f = group.findClass("class41").findField("field1170");
//		calculate(f);
	}
	
}
