package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;
import org.apache.commons.collections4.map.MultiValueMap;

public class ModArith implements Deobfuscator
{
	private ClassGroup group;
	private Execution execution;
	private MultiValueMap<Field, Integer> constantGetters = new MultiValueMap<>(),
		constantSetters = new MultiValueMap<>();
	private List<Pair> pairs = new ArrayList<>();
	
	private List<InstructionContext> getInsInExpr(InstructionContext ctx, Set<Instruction> set)
	{
		List<InstructionContext> l = new ArrayList<>();
		
		if (ctx == null || set.contains(ctx.getInstruction()))
			return l;
		
		if (ctx.getInstruction() instanceof InvokeInstruction)
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
		// find a direct big*field with no other fields involved
		
		for (Frame f : e.processedFrames)
		{
			outer:
			for (InstructionContext ctx : f.getInstructions())
			{
				if (ctx.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sfi = (SetFieldInstruction) ctx.getInstruction();
					
					if (sfi.getMyField() == field)
					{
						InstructionContext pushedsfi = ctx.getPops().get(0).getPushed();
						if (pushedsfi.getInstruction() instanceof LDC_W)
						{
							LDC_W ldc = (LDC_W) pushedsfi.getInstruction();
							if (ldc.getConstant().getObject() instanceof Integer)
							{
								int it = ldc.getConstantAsInt();
								if (DMath.isBig(it))
									// field = constant
									return true;
							}
						}
						else if (pushedsfi.getInstruction() instanceof IMul)
						{
							Instruction one = pushedsfi.getPops().get(0).getPushed().getInstruction();
							Instruction two = pushedsfi.getPops().get(1).getPushed().getInstruction();
							
							LDC_W pci = null;
							Instruction other = null;
							if (one instanceof LDC_W)
							{
								pci = (LDC_W) one;
								other = two;
							}
							else if (two instanceof LDC_W)
							{
								pci = (LDC_W) two;
								other = one;
							}
							
							if (pci != null
								&& !(other instanceof GetFieldInstruction))
							{
								if (pci.getConstant().getObject() instanceof Integer)
								{
									int i = pci.getConstantAsInt();
									if (DMath.isBig(i))
										// field = constant * not other field
										return true;
								}
							}
						}
					}
				}
				
				// field * imul
				if (!(ctx.getInstruction() instanceof IMul))
					continue;
				
				Instruction one = ctx.getPops().get(0).getPushed().getInstruction();
				Instruction two = ctx.getPops().get(1).getPushed().getInstruction();
				
				LDC_W pc = null;
				GetFieldInstruction other = null;
				if (one instanceof LDC_W && two instanceof GetFieldInstruction)
				{
					pc = (LDC_W) one;
					other = (GetFieldInstruction) two;
				}
				else if (two instanceof LDC_W && one instanceof GetFieldInstruction)
				{
					pc = (LDC_W) two;
					other = (GetFieldInstruction) one;
				}

				if (pc == null || other == null)
				{
					continue;
				}
				
				if (other.getMyField() != null && other.getMyField() != field)
					continue;
				
				if (!(pc.getConstant().getObject() instanceof Integer))
					continue;
				
				int ivalue = pc.getConstantAsInt();
				if (!DMath.isBig(ivalue))
					continue;
				
				try
				{
					MultiplicationExpression expr = MultiplicationDeobfuscator.parseExpression(e, ctx);
					if (expr.hasFieldOtherThan(field))
						continue;
				}
				catch (IllegalStateException ex)
				{
					continue;
				}
				
				InstructionContext popped = ctx.getPushes().get(0).getPopped().get(0);
				if (popped.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sfi = (SetFieldInstruction) popped.getInstruction();
					
					if (sfi.getMyField() != null && sfi.getMyField() != field)
						continue;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	static class AssociatedConstant
	{
		int value;
		boolean other;
	}
	private MultiValueMap<Field, AssociatedConstant> constants = new MultiValueMap();
	
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
					
					List<InstructionContext> l = this.getInsInExpr(ctx, new HashSet());
					boolean other = false; // check if this contains another field
					for (InstructionContext i : l)
					{
						if (i.getInstruction() instanceof InvokeInstruction)
							continue;
						
						if (i.getInstruction() instanceof FieldInstruction)
						{
							FieldInstruction fi2 = (FieldInstruction) i.getInstruction();
							Field myField = fi2.getMyField();
							
							if (myField != null && myField != fi.getMyField())
								other = true;
						}
					}
					
					for (InstructionContext i : l)
					{
						if (i.getInstruction() instanceof LDC_W)
						{
							LDC_W w = (LDC_W) i.getInstruction();
							if (w.getConstant().getObject() instanceof Integer)
							{
								AssociatedConstant n = new AssociatedConstant();
								n.value = w.getConstantAsInt();
								n.other = other;
								constants.put(fi.getMyField(), n);
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
					
					// field * constant
					constantGetters.put(field, value);
				}
				else if (ctx.getInstruction() instanceof SetFieldInstruction)
				{
					SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();
					
					Field field = sf.getMyField();
					if (field == null)
						continue;
					
					StackContext value = ctx.getPops().get(0); // the first thing popped from both putfield and putstatic is the value
					if (!(value.getPushed().getInstruction() instanceof IMul))
					{
						if (value.getPushed().getInstruction() instanceof LDC_W)
						{
							LDC_W ldc = (LDC_W) value.getPushed().getInstruction();
							
							if (ldc.getConstant().getObject() instanceof Integer)
							{
								int i = ldc.getConstantAsInt();
								
								if (DMath.isBig(i))
									// field = constant
									constantSetters.put(field, i);
							}
						}
						continue;
					}
					
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
					
					// field = something * constant
					constantSetters.put(field, value2);
				}
			}
	}
	
	private Pair guess(Field field, Collection<Integer> constants)
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
				}
			}
		}
		
		boolean g = isGetterOrSetter(field, true, s1),
			g2 = isGetterOrSetter(field, true, s2);
		
		if (g == g2)
		{
			g = isGetterOrSetter(field, false, s1);
			g2 = isGetterOrSetter(field, false, s2);
		}
		
		if (g == g2)
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
	
	// figure out if value is a getter or setter
	private boolean isGetterOrSetter(Field field, boolean getter, int value)
	{
		Collection<Integer> c;
		if (getter)
			c = this.constantGetters.getCollection(field);
		else
			c = this.constantSetters.getCollection(field);
		if (c == null)
			return false;
		
		if (c.contains(value))
			return true;
		
		for (int i : c)
		{
			// i = value * constant
			// find constant = i * modInverse(value)
			
			int constant = i * DMath.modInverse(value);
			
			if (!DMath.isBig(constant))
				return true;
		}
		
		return false;
	}
	
	// remove duplicates from a collection
	private void removeDupes(Collection<Integer> in)
	{
		Set set = new HashSet();
		for (Iterator<Integer> it = in.iterator(); it.hasNext();)
		{
			int i = it.next();

			if (set.contains(i))
			{
				it.remove();
				continue;
			}

			set.add(i);
		}
	}

	private void reduce2()
	{
		for (ClassFile cf : group.getClasses())
			for (Field f : cf.getFields().getFields())
			{
				Collection<AssociatedConstant> col = constants.getCollection(f); // all constants in instructions associated with the field
				if (col == null)
					continue;
				
				// filter out non big ones
				Collection<AssociatedConstant> col2 = col.stream().filter(i -> DMath.isBig(i.value)).collect(Collectors.toList());

				// filer out ones that have another field in the expression
				Collection<Integer> noOther = col2.stream().filter(i -> !i.other).map(i -> i.value).collect(Collectors.toList());
				Collection<Integer> other = col2.stream().filter(i -> i.other).map(i -> i.value).collect(Collectors.toList());
				other.addAll(noOther);

				removeDupes(noOther);
				removeDupes(other);

				if (!isFieldObfuscated(execution, f))
					continue;

				// guess with constants not associated with other fields
				Pair p = this.guess(f, noOther);
				if (p == null)
					p = this.guess(f, other); // fall back to all constants

				if (p != null)
				{
					pairs.add(p);
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
		constants.clear();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findUses();
		findUses2();
		reduce2();
		
		int i = 0;
		for (Pair pair : pairs)
		{
			Field field = pair.field;
			
			System.out.println("Processing " + field.getName() + " getter " + pair.getter + " setter " + pair.setter);
			
			Encryption encr = new Encryption();
			encr.addPair(pair);
			
			insertGetterSetterMuls(encr);
			
			System.out.println("Changed " + ++i);
		}
		
		System.out.println(pairs);
		
		return i;
	}
	
}
