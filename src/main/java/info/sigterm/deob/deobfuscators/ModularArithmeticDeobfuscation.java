package info.sigterm.deob.deobfuscators;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.GetFieldInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
import info.sigterm.deob.attributes.code.instruction.types.SetFieldInstruction;
import info.sigterm.deob.attributes.code.instructions.IMul;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.pool.Field;
 
public class ModularArithmeticDeobfuscation
{
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
				
				// XXX look only for setting to lvt.
				if (!(popCtx.getInstruction() instanceof LVTInstruction))
					continue;
				
				LVTInstruction lvti = (LVTInstruction) popCtx.getInstruction();
				if (!lvti.store())
					continue;
				
				try
				{
					modInverse(constant);
				}
				catch (ArithmeticException ex)
				{
					System.err.println("Constant " + constant + " passed getter logic tests but is not inversable");
					continue; // if the constant isn't inversable then it can't be the right one
				}
				
				Integer old = constants.get(gf.getField());
				int newi = Integer.parseInt(pc.getConstant().toString());
				
				if (old != null && (int) old != newi)
					System.out.println("For " + gf.getField().getNameAndType().getName() + " in " + gf.getField().getClassEntry().getName() + " constant " + pc.getConstant().toString() + " mismatch on " + old);
				
				constants.put(gf.getField(), newi);
			}
		}
		System.out.println("Found " + constants.size() + " constants");
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
