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
	}
	
	private static Field convertFieldFromPool(ClassGroup group, info.sigterm.deob.pool.Field field)
	{
		return group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());		
	}
	
	private static List<info.sigterm.deob.pool.Field> checkDown(InstructionContext context)
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
	
	private static List<info.sigterm.deob.pool.Field> checkUp(InstructionContext context)
	{
		List<info.sigterm.deob.pool.Field> fields = new ArrayList<>();
		
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
	private static boolean checkFields(ClassGroup group, Set<Field> obFields, info.sigterm.deob.pool.Field imulField, InstructionContext context)
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
	
	private static Set<Field> getObfuscatedFields(Execution execution, ClassGroup group)
	{
		Set<Field> fields = new HashSet<>();
		
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
			{
				if (!(ctx.getInstruction() instanceof IMul))
					continue;
				
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
		}
		
		return fields;
	}
	
	private static Set<Field> obfuscatedFields;
	private static Map<Field, Integer> constants = new HashMap<>(); // getters
	
	private static void detectSetters(Execution execution, ClassGroup group, InstructionContext ctx)
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
		
		if (!checkFields(group, obfuscatedFields, sf.getField(), value.getPushed()))
			return;
		
		System.out.println("Setter " + sf.getField().getClassEntry().getName() + "." + sf.getField().getNameAndType().getName() + " -> " + pc.getConstant().toString());
	}
	
	private static void detectGetters(Execution execution, ClassGroup group, InstructionContext ctx)
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
		
		if (!checkFields(group, obfuscatedFields, gf.getField(), ctx))
			return;

		try
		{
			modInverse(constant);
		}
		catch (ArithmeticException ex)
		{
			System.err.println("Constant " + constant + " passed getter logic tests but is not inversable");
			//printWhatCalls(execution, frame.getMethod(), 0);
			return; // if the constant isn't inversable then it can't be the right one
		}
		
		// get Field from pool Field
		info.sigterm.deob.pool.Field field = gf.getField();
		Field f = group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());				
		
		Integer old = constants.get(f);
		int newi = Integer.parseInt(pc.getConstant().toString());
		
		if (old != null && (int) old != newi)
			System.err.println("For " + gf.getField().getNameAndType().getName() + " in " + gf.getField().getClassEntry().getName() + " constant " + pc.getConstant().toString() + " mismatch on " + old);
		
		constants.put(f, newi);
	}
	
	private void run(Execution execution, ClassGroup group)
	{
		obfuscatedFields = getObfuscatedFields(execution, group);
		
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
			{
				detectGetters(execution, group, ctx);
				detectSetters(execution, group, ctx);
			}
		}
		System.out.println("Found " + constants.size() + " constants");
		for (Entry<Field, Integer> entry : constants.entrySet())
		{
			Field f = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(f.getFields().getClassFile().getName() + "." + f.getName() + " -> " + v);
		}
		System.out.println("Did not find for:");
		int count = 0;
		for (Field f : obfuscatedFields)
		//for (ClassFile cf : group.getClasses())
			//for (Field f : cf.getFields().getFields())
			{
				if (f.getType().toString().equals("I"))
				{
					if (!constants.containsKey(f))
					{
						System.out.println(f.getFields().getClassFile().getName() + "." + f.getName());
						++count;
					}
				}
			}
		System.out.println("Did not find for " + count);
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
		return modInverse(BigInteger.valueOf(val), 64).intValue();
	}
	
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		run(execution, group);
	}
}
