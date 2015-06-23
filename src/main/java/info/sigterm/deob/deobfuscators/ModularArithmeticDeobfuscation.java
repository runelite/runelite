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
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
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
				Instruction one = ctx.getPops().get(0).getIns().getInstruction();
				Instruction two = ctx.getPops().get(1).getIns().getInstruction();
				
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
				
				try
				{
					int constant = Integer.parseInt(pc.getConstant().toString());
					modInverse(constant);
				}
				catch (ArithmeticException ex)
				{
					continue;
				}
				
				Integer old = constants.get(gf.getField());
				int newi = Integer.parseInt(pc.getConstant().toString());
				
				if (old != null && (int) old != newi)
					System.out.println("For " + gf.getField().getNameAndType().getName() + " in " + gf.getField().getClassEntry().getName() + " constant " + pc.getConstant().toString() + " mismatch on " + old);
				
				constants.put(gf.getField(), newi);
				
				// see what the result is used for? 
			}
		}
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
		execution.run();
		
		run(execution, group);
	}
}
