package info.sigterm.deob.deobfuscators;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
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
	
	// lvt = field * constant
	private static boolean checkLVTGet(InstructionContext popCtx)
	{
		if (!(popCtx.getInstruction() instanceof LVTInstruction))
			return false;
		
		LVTInstruction lvti = (LVTInstruction) popCtx.getInstruction();
		if (!lvti.store())
			return false;
		
		return true;
	}
	
	// func(field * constant)
	private static boolean checkInvoke(InstructionContext popCtx)
	{
		if (!(popCtx.getInstruction() instanceof InvokeInstruction))
			return false;
		
		return true;
	}
	
	// lvt comparison field * constant
	private static boolean checkCompare(InstructionContext popCtx)
	{
		if (!(popCtx.getInstruction() instanceof ComparisonInstruction))
			return false;
		
		// make sure comparison is against lvt
		List<StackContext> pops = popCtx.getPops(); // things popCtx popped
		for (StackContext ctx : pops) // one of these is the imul
		{
			InstructionContext pushCtx = ctx.getPushed(); // instruction which pushed this here
			if (pushCtx.getInstruction() instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) pushCtx.getInstruction();
				return !lvt.store(); // check its a get
			}
		}
		
		return false;
	}
	
	private static boolean checkRules(InstructionContext popCtx)
	{
		return checkLVTGet(popCtx)
				|| checkInvoke(popCtx)
				|| checkCompare(popCtx);
	}
	
	/* try to identify:
	 * 
	   lvt = field * constant
	   getfield              dy/e I
	   ldc                   1512989863
	   imul
	   istore_1
	      
	   or
	   
	   field * constant compare+conditional jump
	   getstatic             client/c I
	   ldc                   -2061786953
	   imul
	   bipush                30
	   if_icmpeq             LABEL0x86
	   
	   or
	   
	   (constant * field) - lvt
	   ldc                   1512989863
	   getstatic             client/cq Ldy;
	   getfield              dy/e I
	   imul
	   iload_1
	   isub
	   
	   field * constant where result is:
	   stored in lvt
	   compared with something
	   any other operation with lvt
    */
	private void run(Execution execution, ClassGroup group)
	{
		Map<Field, Integer> constants = new HashMap<>();
		for (Frame frame : execution.processedFrames)
		{
			for (InstructionContext ctx : frame.getInstructions())
			{
				// I think it is easier to detect the getters instead of the setters,
				// and then calculate the setters.
				if (!(ctx.getInstruction() instanceof IMul))
					continue;
				
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
					continue;
				
				int constant = Integer.parseInt(pc.getConstant().toString());
				
				StackContext push = ctx.getPushes().get(0); // result of imul operation
				InstructionContext popCtx = push.getPopped(); // instruction which popped the result
				
				if (popCtx == null)
				{
					continue;
					//System.err.println("Stack ctx never popped! Pushed by " + push.getPushed().getInstruction());
					//int i = frame.getInstructions().indexOf(push.getPushed().getInstruction());
					//System.err.println("next ins is " + frame.getInstructions().get(i + 1).getInstruction());
				}
				
				if (!checkRules(popCtx))
					continue;

				try
				{
					modInverse(constant);
				}
				catch (ArithmeticException ex)
				{
					System.err.println("Constant " + constant + " passed getter logic tests but is not inversable");
					//printWhatCalls(execution, frame.getMethod(), 0);
					continue; // if the constant isn't inversable then it can't be the right one
				}
				
				// get Field from pool Field
				info.sigterm.deob.pool.Field field = gf.getField();
				Field f = group.findClass(field.getClassEntry().getName()).findField(field.getNameAndType());				
				
				Integer old = constants.get(f);
				int newi = Integer.parseInt(pc.getConstant().toString());
				
				if (old != null && (int) old != newi)
					System.out.println("For " + gf.getField().getNameAndType().getName() + " in " + gf.getField().getClassEntry().getName() + " constant " + pc.getConstant().toString() + " mismatch on " + old);
				
				constants.put(f, newi);
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
		for (ClassFile cf : group.getClasses())
			for (Field f : cf.getFields().getFields())
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
