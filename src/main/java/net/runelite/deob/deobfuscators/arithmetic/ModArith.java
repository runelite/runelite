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
		
		set.add(ctx.getInstruction());
		
		l.add(ctx);
		
		for (StackContext s : ctx.getPops())
			l.addAll(getInsInExpr(s.getPushed(), set));
		for (StackContext s : ctx.getPushes())
			for (InstructionContext i : s.getPopped())
				l.addAll(getInsInExpr(i, set));
		
		return l;
	}
	
	private boolean isFieldObfuscated(Execution e, Field field)
	{
		// field isn't obfuscated if there are no usages with big constants and no other fields
		
		for (Frame f : execution.processedFrames)
			outer:
			for (InstructionContext ctx : f.getInstructions())
			{
				if (!(ctx.getInstruction() instanceof FieldInstruction))
					continue;
				
				FieldInstruction fi = (FieldInstruction) ctx.getInstruction();
				
				if (fi.getMyField() != field)
					continue;
				
				List<InstructionContext> ins = getInsInExpr(ctx, new HashSet());
				
				// continue if expr contains another ins
				for (InstructionContext i : ins)
				{
					if (i.getInstruction() instanceof FieldInstruction)
					{
						FieldInstruction ifi = (FieldInstruction) i.getInstruction();
						
						if (ifi.getMyField() != field)
							continue outer; 
					}
				}
				
				// find big constant
				for (InstructionContext i : ins)
				{
					if (i.getInstruction() instanceof LDC_W)
					{
						LDC_W ldc = (LDC_W) i.getInstruction();
						if (ldc.getConstant().getObject() instanceof Integer)
						{
							int value = ldc.getConstantAsInt();

							if (DMath.isBig(value))
								return true;
						}
					}
				}
			}
		
		return false;
	}
	
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

			// if the field is already deobbed, constants here don't include it
			if (fi.getMyField() != field && !deobfuscatedFields.contains(fi.getMyField()))
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
	
	private Pair guess(Field field, Collection<Integer> values, boolean getter)
	{
		Map<Integer, Integer> map = CollectionUtils.getCardinalityMap(values); // value -> how many times it occurs
		int max = Collections.max(map.values()); // largest occurance #
		int size = values.size();
		
		try
		{
			if (max == size)
			{
				// all getters are the same value
				int constant = values.iterator().next();
				if (DMath.isBig(constant))
				{
					Pair pair = new Pair();
					if (getter)
					{
						pair.getter = constant;
					//System.out.println("Guessing " + field.getName() + " getter " + constant + " setter ");
						pair.setter = DMath.modInverse(constant);
					}
					else
					{
						pair.setter = constant;
						pair.getter = DMath.modInverse(constant);
					}
					return pair;
				}
			}
		}
		catch (ArithmeticException ex) { }
		
//		if (size < 50)
//			return null;
		
		if (((float) max / (float) size) < 0.9)
			return null;

		for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (max == entry.getValue()) {
				int constant = entry.getKey();
				int inverse;
				try
				{
					inverse = DMath.modInverse(constant);
				}
				catch (ArithmeticException ex)
				{
					break;
				}

				Pair pair = new Pair();
				if (getter)
				{
					pair.getter = constant;
					pair.setter = inverse;
				}
				else
				{
					pair.getter = inverse;
					pair.setter = constant;
				}
				
				return pair;
			}
		}
		
		return null;
	}
	
	private void reduce()
	{
		for (ClassFile cf : group.getClasses())
			for (Field f : cf.getFields().getFields())
			{
				Collection<Integer> getters = constantGetters.getCollection(f),
					setters = constantSetters.getCollection(f);
				
				if (f.getName().equals("field2976"))
				{
					int k=5;
				}
				
			
				Pair answer = null;
				
				if (getters != null && setters != null)
					answer = reduce(getters, setters);
				
				if (answer == null && getters != null)
					answer = guess(f, getters, true);
				
				if (answer == null && setters != null)
					answer = guess(f, setters, false);
					
				if (answer == null)
					continue;
				
				if (!this.isFieldObfuscated(execution, f))
				{
					System.out.println("Skipping field " + f.getName() + " which isnt obfuscated");
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
		//return runOnce();
//		if (true) return;
//		
//		int passes = 0, total = 0, i;
//		while ((i = runOnce()) > 0)
//		{
//			++passes;
//			total += i;
//		}
//		System.out.println("Finished arith deob on " + total + " fields in " + passes + " passes");
	}
//	
//	private void translateSetFields(Execution e)
//	{
//		//Set<Instruction> visited = new HashSet<>();
//		for (Frame f : e.processedFrames)
//			for (InstructionContext ins : f.getInstructions())
//				if (ins.getInstruction() instanceof SetFieldInstruction)
//				{
//					SetFieldInstruction sfi = (SetFieldInstruction) ins.getInstruction();
//					Pair pair = e.getEncryption().getField(sfi.getMyField());
//					
//					if (pair != null)
//						PutStatic.translate(e.getEncryption(), pair, ins, new HashSet());
//					//
//				}
//	}
	
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
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findUses();
		reduce();
		
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
