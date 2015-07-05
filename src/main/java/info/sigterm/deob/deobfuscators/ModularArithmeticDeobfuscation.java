package info.sigterm.deob.deobfuscators;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
import info.sigterm.deob.attributes.code.instruction.types.FieldInstruction;
import info.sigterm.deob.attributes.code.instruction.types.GetFieldInstruction;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
import info.sigterm.deob.attributes.code.instruction.types.SetFieldInstruction;
import info.sigterm.deob.attributes.code.instructions.IMul;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.StackContext;
 
public class ModularArithmeticDeobfuscation
{
	/*
	private static String getMethodDesc(Method m)
	{
		return m.getMethods().getClassFile().getName() + "." + m.getName() + m.getNameAndType().getDescriptor().toString();
	}
	
	private static void printWhatCalls(Execution execution, Method method, int level)
	{
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
			{
				if (ctx.getInvokes().contains(method))
				{
					for (int i = 0; i < level; ++i)
						System.out.print(" ");
					System.out.println(getMethodDesc(method) + " called by " + getMethodDesc(frame.getMethod()) + ", " + ctx.getInvokes().size() + " methods total");
					printWhatCalls(execution, frame.getMethod(), level + 1);
				}
			}
		}
	}*/
	
	private Set<Field> obfuscatedFields;
	
	static class Magic
	{
		Field field;
		int getter, setter;
		boolean unknownGetter, unknownSetter;
	}
	
	static class Magics
	{
		Map<Field, Magic> magic = new HashMap<>();
		
		Magic getMagic(Field field)
		{
			Magic m = magic.get(field);
			if (m != null)
				return m;
			
			m = new Magic();
			m.field = field;
			magic.put(field, m);
			return m;
		}
		
		void pass1()
		{
			/* remove fields we aren't 100% sure are correct */
			int bad = 0, good = 0;
			for (Magic m : new ArrayList<>(magic.values()))
			{
				if (m.getter == 0 || m.setter == 0 || m.getter != modInverse(m.setter) || m.setter != modInverse(m.getter))
				{
					magic.remove(m.field);
					++bad;
				}
				else
				{
					++good;
				}
			}
			System.out.println("Pass 1: Bad: " + bad + ", good: " + good); 
		}
		
		void pass2()
		{
			int found = 0;
			for (Magic m : new ArrayList<>(magic.values()))
			{
				if (!m.unknownGetter && !m.unknownSetter && (m.setter != 0 ||  m.getter != 0))
				{
					++found;
				}
			}
			System.out.println("Pass 2: Calculated " + found);
		}
	}
	
	private Field convertFieldFromPool(ClassGroup group, info.sigterm.deob.pool.Field field)
	{
		ClassFile cf = group.findClass(field.getClassEntry().getName());
		if (cf == null)
			return null;
		return cf.findField(field.getNameAndType());		
	}
	
	private List<info.sigterm.deob.pool.Field> checkDown(InstructionContext context)
	{
		List<info.sigterm.deob.pool.Field> fields = new ArrayList<>();
		
		if (context.getInstruction() instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) context.getInstruction();
			fields.add(fi.getField());
		}
		
		for (StackContext ctx : context.getPops())
		{
			InstructionContext i = ctx.getPushed();
			
			fields.addAll(checkDown(i));
		}
		
		return fields;
	}
	
	private List<info.sigterm.deob.pool.Field> checkUp(InstructionContext context)
	{
		List<info.sigterm.deob.pool.Field> fields = new ArrayList<>();
		
		if (context.getInstruction() instanceof InvokeInstruction)
		{
			// field = func(field * constant), the output of the function isn't directly related to the result of field * constant
			return fields;
		}
		
		if (context.getInstruction() instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) context.getInstruction();
			fields.add(fi.getField());
		}
		
		for (StackContext ctx : context.getPushes())
		{
			InstructionContext i = ctx.getPopped();
			
			if (i == null)
				continue;
			
			fields.addAll(checkUp(i));
		}
		
		return fields;
	}
	
	/* check there are no other fields */
	private boolean checkFields(Magics goodMagics, ClassGroup group, Set<Field> obFields, info.sigterm.deob.pool.Field imulField, InstructionContext context)
	{
		List<info.sigterm.deob.pool.Field> fields = new ArrayList<>();
		fields.addAll(checkUp(context));
		fields.addAll(checkDown(context));
		
		assert !fields.isEmpty();
		
		for (info.sigterm.deob.pool.Field f : fields)
		{
			if (f.equals(imulField))
				continue;
			
			Field field = convertFieldFromPool(group, f);
			assert field != null;
			
			if (!obFields.contains(field))
				continue;
			
			return false;
		}
		
		return true;
	}
	
	private List<InstructionContext> getDown(InstructionContext context)
	{
		List<InstructionContext> instructions = new ArrayList<>();
		
		instructions.add(context);
		
		for (StackContext ctx : context.getPops())
		{
			InstructionContext i = ctx.getPushed();
			
			instructions.addAll(getDown(i));
		}
		
		return instructions;
	}
	
	private List<InstructionContext> getInstructions(InstructionContext context)
	{
		List<InstructionContext> instructions = new ArrayList<>();
		
		instructions.add(context);
		
		instructions.addAll(getDown(context));
		
		return instructions;
	}
	
	private Set<Field> getObfuscatedFields(Execution execution, ClassGroup group)
	{
		Set<Field> fields = new HashSet<>();
		
		// XXX this detects field = field * constant as ob when field isn't
		
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
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
					
					// get Field from pool Field
					info.sigterm.deob.pool.Field field = gf.getField();
					Field f = group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());		
					
					assert f != null;
					
					fields.add(f);
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
					
					// get Field from pool Field
					info.sigterm.deob.pool.Field field = sf.getField();
					Field f = group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());		
					
					assert f != null;
					
					fields.add(f);
				}
			}
		}
		
		return fields;
	}
	
	private void detectSetters(Magics goodMagics, Magics workMagics, Execution execution, ClassGroup group, InstructionContext ctx)
	{
		if (!(ctx.getInstruction() instanceof SetFieldInstruction))
			return;
		
		SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();
		
		StackContext value = ctx.getPops().get(0); // what setfield pops as value
		if (!(value.getPushed().getInstruction() instanceof IMul))
			return;
		
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
			return;
		
		if (!checkFields(goodMagics, group, obfuscatedFields, sf.getField(), value.getPushed()))
			return;
		
		//System.out.println("Setter " + sf.getField().getClassEntry().getName() + "." + sf.getField().getNameAndType().getName() + " -> " + pc.getConstant().toString());
		
		int constant = Integer.parseInt(pc.getConstant().toString());
		try
		{
			modInverse(constant);
		}
		catch (ArithmeticException ex)
		{
			//System.err.println("Constant " + constant + " passed setter logic tests but is not inversable");
			//printWhatCalls(execution, frame.getMethod(), 0);
			return; // if the constant isn't inversable then it can't be the right one
		}
		
		Field field = convertFieldFromPool(group, sf.getField());
		Magic magic = workMagics.getMagic(field);
		
		if (!magic.unknownSetter)
		{
			if (magic.setter == 0)
				magic.setter = constant;
			else if (magic.setter != constant)
			{
				magic.setter = 0;
				magic.unknownSetter = true;
			}
		}
	}
	
	private void detectGetters(Magics goodMagics, Magics workMagics, Execution execution, ClassGroup group, InstructionContext ctx)
	{
		if (!(ctx.getInstruction() instanceof IMul))
			return;
		
		// check for push constant and for get field instruction
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
			return;
		
		int constant = Integer.parseInt(pc.getConstant().toString());

		StackContext push = ctx.getPushes().get(0); // result of imul operation
		InstructionContext popCtx = push.getPopped(); // instruction which popped the result of mul
		
		if (popCtx == null)
		{
			return;
			//System.err.println("Stack ctx never popped! Pushed by " + push.getPushed().getInstruction());
			//int i = frame.getInstructions().indexOf(push.getPushed().getInstruction());
			//System.err.println("next ins is " + frame.getInstructions().get(i + 1).getInstruction());
		}
		
		if (!checkFields(goodMagics, group, obfuscatedFields, gf.getField(), ctx))
			return;

		try
		{
			modInverse(constant);
		}
		catch (ArithmeticException ex)
		{
			//System.err.println("Constant " + constant + " passed getter logic tests but is not inversable");
			//printWhatCalls(execution, frame.getMethod(), 0);
			return; // if the constant isn't inversable then it can't be the right one
		}
		
		// get Field from pool Field
		info.sigterm.deob.pool.Field field = gf.getField();
		Field f = group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());
		
		Magic magic = workMagics.getMagic(f);
		
		if (!magic.unknownGetter)
		{
			if (magic.getter == 0)
				magic.getter = constant;
			else if (magic.getter != constant)
			{
				magic.getter = 0;
				magic.unknownGetter = true;
			}
		}
	}
	
	private void detectCombined(Magics goodMagics, Magics workMagics, Execution execution, ClassGroup group, InstructionContext ctx)
	{
		// look for put involving one other field, assume constant is combined field getter/setter
		
		if (!(ctx.getInstruction() instanceof SetFieldInstruction))
			return;
		
		SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();
		Field thisField = convertFieldFromPool(group, sf.getField());
		
		boolean ey = thisField.getFields().getClassFile().getName().equals("client") && thisField.getName().equals("ej");
		
		List<InstructionContext> ins = getInstructions(ctx);
		
		Field other = null;
		int constant = 0;
		for (InstructionContext i : ins)
			if (i.getInstruction() instanceof FieldInstruction)
			{
				FieldInstruction fin = (FieldInstruction) i.getInstruction();
				if (fin.getField().equals(sf.getField()))
						continue;
				
				if (other != null)
					return;
				
				other = convertFieldFromPool(group, fin.getField());
			}
			else if (i.getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) i.getInstruction();
				try
				{
					constant = Integer.parseInt(pci.getConstant().toString());
					
					if (constant == -1354014691 && ey)
					{
						int i3 = 5;
					}
				}
				catch (NumberFormatException ex)
				{
					return;
				}
			}
		
		if (other == null || constant == 0)
			return;
		
		if (goodMagics.magic.containsKey(thisField) && goodMagics.magic.containsKey(other))
			return;
		
		if (!thisField.getType().toString().equals("I") || !other.getType().toString().equals("I"))
			return;
		
		// thisField = operations with field/constant
		
		if (obfuscatedFields.contains(thisField) && obfuscatedFields.contains(other))
		{
			// constant is thisField setter * otherField getter
			
			Magic thisMagic = goodMagics.magic.get(thisField);
			Magic otherMagic = goodMagics.magic.get(other);
			
			if (thisMagic == null && otherMagic == null)
			{
				System.err.println("Combined fields with no known good magic");
				return;
			}
			
			//if (thisMagic != null && otherMagic != null)
			//{
			//	return; // check?
			//}
			
			if (thisMagic == null)
			{
				//System.out.println("Combined 1");
				
				// this = other * constant
				// constant = other getter * this setter
				// solve for this setter
				// this setter = constant * modInverse(other.getter)
				
				int thisSetter = constant * modInverse(otherMagic.getter);
				
				System.out.println("Calculated setter for " + thisField.getFields().getClassFile().getName() + "." + thisField.getName() + " to be " + thisSetter);
				
				Magic m = workMagics.getMagic(thisField);
				
				if (!m.unknownSetter)
					if (m.setter != 0 && m.setter != thisSetter)
					{
						System.err.println("Calculated setter mismatch");
						m.unknownSetter = true;
						m.setter = 0;
					}
				
				m.setter = thisSetter;
			}
			else if (otherMagic == null)
			{
				//System.out.println("Combined 2");
				
				// this = other * constant
				// constant = other getter * this setter
				// solve for other getter
				// other getter = constant * modInverse(this setter)
				
				int otherGetter = constant * modInverse(thisMagic.setter);
				
				System.out.println("Calculated getter for " + other.getFields().getClassFile().getName() + "." + other.getName() + " to be " + otherGetter);
				
				Magic m = workMagics.getMagic(other);
				
				if (!m.unknownGetter)
					if (m.getter != 0 && m.getter != otherGetter)
					{
						System.err.println("Calculated getter mismatch");
						m.unknownGetter = true;
						m.getter = 0;
					}
				
				m.getter = otherGetter;
			}
		}
		else if (obfuscatedFields.contains(thisField))
		{
			// constant is this fields setter
			System.out.println("Only one field is obd 1 " + thisField.getFields().getClassFile().getName() + "." + thisField.getName()
					+ ", " + other.getFields().getClassFile().getName() + "." + other.getName());
		}
		else if (obfuscatedFields.contains(other))
		{
			// constant is other fields getter
			System.out.println("Only one field is obd 2");
		}
		else
		{
			System.err.println("detected combined field with both fields non obfuscated. " + thisField.getFields().getClassFile().getName() + "." + thisField.getName()
					+ ", " + other.getFields().getClassFile().getName() + "." + other.getName());
			//return;
		}
	}
	
	private void check(Magics magics)
	{
		for (Field f : obfuscatedFields)
		{
			Magic magic = magics.magic.get(f);
			
			if (magic == null)
			{
				System.err.println(f.getFields().getClassFile().getName() + "." + f.getName() + " is obfuscated, but no magic found");
				continue;
			}
			
			if (magic.getter != 0 && magic.setter != 0)
			{
				if (magic.getter != modInverse(magic.setter) || magic.setter != modInverse(magic.getter))
				{
					System.err.println(f.getFields().getClassFile().getName() + "." + f.getName() + " has mismatch, get " + magic.getter + ", set " + magic.setter + ", modInverse(get) " + modInverse(magic.getter) + ", modInverse(set) " + modInverse(magic.setter));
				}
				else
				{
					System.out.println(f.getFields().getClassFile().getName() + "." + f.getName() + " has get " + magic.getter + ", set " + magic.setter);
				}
			}
			else
				// ez.k
				System.out.println(f.getFields().getClassFile().getName() + "." + f.getName() + " 2 has get " + magic.getter + ", set " + magic.setter);
		}
	}
	
	private void run(Magics magics /* known good */, Magics work, Execution execution, ClassGroup group)
	{
		obfuscatedFields = getObfuscatedFields(execution, group);
		
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
			{
				if (magics == null)
				{
					detectGetters(magics, work, execution, group, ctx);
					detectSetters(magics, work, execution, group, ctx);
				}
				else
				if (magics != null)
					detectCombined(magics, work, execution, group, ctx);
			}
		}
		
		if (magics == null)
			check(work);
	}
	
	private static BigInteger modInverse(BigInteger val, int bits)
	{
		BigInteger shift = BigInteger.ONE.shiftLeft(bits);
		return val.modInverse(shift);
	}
	
	private static int modInverse(int val)
	{
		return modInverse(BigInteger.valueOf(val), 32).intValue();
	}
	
	private static long modInverse(long val)
	{
		return modInverse(BigInteger.valueOf(val), 64).longValue();
	}
	
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		Magics work = new Magics();
		run(null, work, execution, group);
		work.pass1();
		
		Magics magics = work;
		work = new Magics();
		run(magics, work, execution, group);
		work.pass2();
	}
}
