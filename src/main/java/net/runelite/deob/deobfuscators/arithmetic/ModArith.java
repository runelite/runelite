package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
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

public class ModArith implements Deobfuscator
{
	private ClassGroup group;
	private Execution execution;
	private MultiValueMap<Field, Integer> constantGetters = new MultiValueMap<>(),
		constantSetters = new MultiValueMap<>();
	private List<Pair> pairs = new ArrayList<>();
	private Set<Field> deobfuscatedFields = new HashSet<>();
	
	private List<InstructionContext> getInsInExpr(InstructionContext ctx, Set<Instruction> set)
	{
		List<InstructionContext> l = new ArrayList<>();
		
		if (ctx == null || set.contains(ctx.getInstruction()))
			return l;
		
//		if (ctx.getInstruction() instanceof FieldInstruction)
//			return l; // well do this one later?
		
		set.add(ctx.getInstruction());
		
		l.add(ctx);
		
		for (StackContext s : ctx.getPops())
			l.addAll(getInsInExpr(s.getPushed(), set));
		for (StackContext s : ctx.getPushes())
			for (InstructionContext i : s.getPopped())
				l.addAll(getInsInExpr(i, set));
		
		return l;
	}
	
//	private boolean isFieldObfuscated(Execution e, Field field)
//	{
//		// field isn't obfuscated if there are no usages with big constants and no other fields
//		
//		for (Frame f : execution.processedFrames)
//			outer:
//			for (InstructionContext ctx : f.getInstructions())
//			{
//				if (!(ctx.getInstruction() instanceof FieldInstruction))
//					continue;
//				
//				FieldInstruction fi = (FieldInstruction) ctx.getInstruction();
//				
//				//if (fi.getMyField() != field)
//				//	continue;
//				
//				List<InstructionContext> ins = getInsInExpr(ctx, new HashSet());
//				
//				// continue if expr contains another ins
//				for (InstructionContext i : ins)
//				{
//					if (i.getInstruction() instanceof FieldInstruction)
//					{
//						FieldInstruction ifi = (FieldInstruction) i.getInstruction();
//						
//						//if (ifi.getMyField() != field)
//						//	continue outer; 
//					}
//				}
//				
//				// find big constant
//				boolean big = false;
//				for (InstructionContext i : ins)
//				{
//					if (i.getInstruction() instanceof LDC_W)
//					{
//						LDC_W ldc = (LDC_W) i.getInstruction();
//						if (ldc.getConstant().getObject() instanceof Integer)
//						{
//							int value = ldc.getConstantAsInt();
//
//							if (DMath.isBig(value))
//								big = true;
//						}
//					}
//				}
//				
////				for (InstructionContext i : ins)
////				{
////					if (i.getInstruction() instanceof InvokeInstruction)
////					{
////						if (!big)
////						{
////							// if no ob is detected and its passed to an invoke, it must be deobbed
////							return false;
////						}
////					}
////				}
//				
//				if (big)
//					return true;
//			}
//		
//		return false;
//	}
	
	static class numgs {
		int value;
		boolean getter;
	}
	private MultiValueMap<Field, numgs> values2 = new MultiValueMap();
	
	private void findUses2()
	{
		for (Frame f : execution.processedFrames)
			for (InstructionContext ctx : f.getInstructions())
			{
				if (ctx.getInstruction() instanceof FieldInstruction)
				{
					FieldInstruction fi = (FieldInstruction) ctx.getInstruction();
					
					if (fi.getMyField() == null)
						continue;
					
					if (!fi.getField().getNameAndType().getDescriptorType().getType().equals("I")
						|| fi.getField().getNameAndType().getDescriptorType().getArrayDims() != 0)
						continue;
					
					//if (!fi.getMyField().getName().equals("field2865")) continue;
					
					List<InstructionContext> l = this.getInsInExpr(ctx, new HashSet());
					for (InstructionContext i : l)
					{
						if (i.getInstruction() instanceof LDC_W)
						{
							LDC_W w = (LDC_W) i.getInstruction();
							if (w.getConstant().getObject() instanceof Integer)
							{
								//boolean getter = fi instanceof GetFieldInstruction;
								numgs n = new numgs();
								n.value = w.getConstantAsInt();
								//n.getter = getter;
								values2.put(fi.getMyField(), n);
							}
						}
					}
				}
			}
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
					
//					List<Integer> constants = null;
//					try
//					{
//						constants = findAssocConstants(field, ctx);
//						for (int i : constants)
//							if (i != 1 && i != 0)
//								constantSetters.put(field, i);
//					}
//					catch (OtherFieldException ex) { }
					
					StackContext value = ctx.getPops().get(0); // the first thing popped from both putfield and putstatic is the value
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
					
					if (field.getName().equals("field2201"))
					{
						int k=7;
					}
					
					constantSetters.put(field, value2);
				}
			}
	}
	
//	private Pair reduce(Collection<Integer> getters, Collection<Integer> setters)
//	{
//		Pair p = null;
//		
//		for (Integer i : getters)
//		{
//			Integer inverse;
//			try
//			{
//				inverse = DMath.modInverse(i);
//			}
//			catch (ArithmeticException ex)
//			{
//				continue;
//			}
//			
//			if (setters.contains(inverse))
//			{
//				if (p != null && p.getter != i)
//					return null;
//				
//				if (p == null)
//				{
//					p = new Pair();
//					p.getter = i;
//					p.setter = inverse;
//				}
//			}
//		}
//		
//		for (Integer i : setters)
//		{
//			Integer inverse;
//			try
//			{
//				inverse = DMath.modInverse(i);
//			}
//			catch (ArithmeticException ex)
//			{
//				continue;
//			}
//			
//			if (getters.contains(inverse))
//			{
//				if (p != null && p.setter != i)
//					return null;
//				
//				if (p == null)
//				{
//					p = new Pair();
//					p.setter = i;
//					p.getter = inverse;
//				}
//			}
//		}
//		
//		return p;
//	}
	
	private Pair guess2(Field field, Collection col, Collection<Integer> constants)
	{
		// multiply each by each,
		// lowest number wins
		int s1 = 0, s2 = 0;
		int smallest = 0;
		for (Integer i : constants)
		{
			for (Integer i2 : constants)
			{
				if (i == 0 || i2 == 0)
					//|| i == -1 || i2 == -1
					//|| i == 1 || i2 == 1)
					continue;
				
				int result = i * i2;
				
				if (result == 0)
					continue;
				
				if (smallest == 0 || result == 1 || Math.abs(result) < Math.abs(smallest))
				{
					s1 = i;
					s2 = i2;
					smallest = result;
				}
			}
		}
		
		if (smallest != 1)
		{
			if (DMath.isInversable(smallest))
			{
				// x*y=z*1
				// divide x or y by z

				if (DMath.isInversable(s1))
				{
					s2 = s2 * DMath.modInverse(smallest);
					smallest = 1;
					assert s1 * s2 == 1;
				}
				else if (DMath.isInversable(s2))
				{
					s1 = s1 * DMath.modInverse(smallest);
					smallest = 1;
					assert s1 * s2 == 1;
				}
				else
				{
					System.out.println("cant guess " + field.getName());
					return null;
					// I dont know what one to pick, maybe it doesnt matter
					//assert false;
				}
			}
			else
			{
				if (DMath.isInversable(s1))
				{
					int newTwo = DMath.modInverse(s1);
					if (newTwo * smallest == s2)
					{
						s2 = newTwo;
						smallest = 1;
						assert s1 * s2 == 1;
					}
				}
				else if (DMath.isInversable(s2))
				{
					int newTwo = DMath.modInverse(s2);
					if (newTwo * smallest == s1)
					{
						s1 = newTwo;
						smallest = 1;
						assert s1 * s2 == 1;
					}
				}
				else
				{
					System.out.println("cant guess " + field.getName());
					return null;
					//assert false;
				}
			}
		}
		
		Boolean g = isGetter(field, col, s1),
			g2 = isGetter(field, col, s2);
		
		if (g == null || g2 == null || g == g2)
			System.out.println("BAD  " + field.getName() + " " + s1 + " * " + s2 + " = " + smallest + " " + g + " " + g2);
		else
		{
			System.out.println("GOOD " + field.getName() + " " + s1 + " * " + s2 + " = " + smallest + " " + g + " " + g2);
			Pair p = new Pair();
			p.field = field;
			if (g)
			{
				p.getter = s1;
				p.setter = s2;
			}
			else
			{
				p.getter = s2;
				p.setter = s1;
			}
			return p;
		}
		return null;
	}
	
	private Boolean isGetter(Field field, Collection<numgs> col, int value)
	{
		Collection<Integer> c = this.constantGetters.getCollection(field);
		return c != null && c.contains(value);
//		Boolean b = null;
//		for (numgs n : col)
//		{
//			if (n.value == value)
//			{
//				if (b == null)
//					b = n.getter;
//				else if (b != n.getter)
//					return null;
//			}
//		}
//		return b;
	}

	private void reduce2()
	{
		for (ClassFile cf : group.getClasses())
			for (Field f : cf.getFields().getFields())
			{
				Collection<numgs> col = values2.getCollection(f);
				if (col == null)
					continue;
				
				//if (f.getName().equals("field2865"))
				{
					//Collection<Integer> col3 = col.stream().map(i -> i.value).collect(Collectors.toSet());
					
					Collection<numgs> col2 = col.stream().filter(i -> DMath.isBig(i.value)).collect(Collectors.toList());
				
					Set set = col2.stream().map(i -> i.value).collect(Collectors.toSet());
				//
				
					Pair p = this.guess2(f, col2, set);
					if (p != null)
					{
				
						if (this.deobfuscatedFields.contains(f))
							continue;
						
						pairs.add(p);
						
						this.deobfuscatedFields.add(f);
					}
				}
			}
	}

	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
	}
	
	private void insertGetterSetterMuls(Encryption encr)
	{
		// after getfield insert imul * setter
		// before setfield insert inul * getter
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				if (code == null)
					continue;
				
				Instructions ins = code.getInstructions();
				List<Instruction> ilist = ins.getInstructions();
				
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction in = ilist.get(i);
					
					if (in instanceof SetFieldInstruction)
					{
						SetFieldInstruction sfi = (SetFieldInstruction) in;
						Field f = sfi.getMyField();

						if (f == null)
							continue;

						Pair p = encr.getField(f);
						if (p == null)
							continue;

						// insert push getter
						// insert imul

						ilist.add(i++, new LDC_W(ins, new net.runelite.deob.pool.Integer(p.getter)));
						ilist.add(i++, new IMul(ins));
					}
					else if (in instanceof GetFieldInstruction)
					{
						GetFieldInstruction sfi = (GetFieldInstruction) in;
						Field f = sfi.getMyField();

						if (f == null)
							continue;

						Pair p = encr.getField(f);
						if (p == null)
							continue;

						// add after: push setter
						// imul
						ilist.add(++i, new LDC_W(ins, new net.runelite.deob.pool.Integer(p.setter)));
						ilist.add(++i, new IMul(ins));
					}
				}
			}
	}
	
	public int runOnce()
	{
		group.buildClassGraph();
		
		pairs.clear();
		constantGetters.clear();;
		constantSetters.clear();
		values2.clear();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findUses();
		findUses2();
		reduce2();
		
//		Encryption encr = new Encryption();
//		for (Pair pair : pairs)
//			encr.addPair(pair);
//		
//		insertGetterSetterMuls(encr);
		
		int i = 0;
		for (Pair pair : pairs)
		{
			Field field = pair.field;

			//field933 = -193434591 * field743;
			// var143.field3014 = (var143.field2960 = 1 * var92.field2960) * 1496783801;
			//if (!field.getName().equals("field3014") && !field.getName().equals("field2960"))
			if (!field.getName().equals("field2201"))
			{
				int j =5;
			//	continue;
			}
			
			System.out.println("Processing " + field.getName() + " getter " + pair.getter + " setter " + pair.setter);
			
			Encryption encr = new Encryption();
			encr.addPair(pair);
			
			insertGetterSetterMuls(encr);
			
			System.out.println("Changed " + ++i);
			//assert !deobfuscatedFields.contains(field);
			deobfuscatedFields.add(field);
		}
		
		System.out.println(pairs);
		
		return i;
	}
	
}
