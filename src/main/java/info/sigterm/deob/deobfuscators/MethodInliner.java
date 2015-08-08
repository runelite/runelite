package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.ReturnInstruction;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.InvokeStatic;
import info.sigterm.deob.attributes.code.instructions.NOP;
import info.sigterm.deob.attributes.code.instructions.VReturn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInliner implements Deobfuscator
{
	private Map<Method, Integer> calls = new HashMap<>();
	
	private void countCalls(Method m)
	{
		Code code = m.getCode();
		if (code == null)
			return;
		
		Instructions ins = code.getInstructions();
		
		for (Instruction i : ins.getInstructions())
		{
			// can only inline static method calls
			if (!(i instanceof InvokeStatic))
				continue;
			
			List<Method> invokedMethods = ((InvokeInstruction) i).getMethods();
			if (invokedMethods.isEmpty())
				continue; // not our method
			
			assert invokedMethods.size() == 1;
			Method invokedMethod = invokedMethods.get(0);
			
			Integer count = calls.get(invokedMethod);
			if (count == null)
				calls.put(invokedMethod, 1);
			else
				calls.put(invokedMethod, count + 1);
		}
	}
	
	private int processMethod(Method m)
	{
		int inlineCount = 0;
		Code code = m.getCode();
		if (code == null)
			return inlineCount;
		
		Instructions ins = code.getInstructions();
		
		for (Instruction i : ins.getInstructions())
		{
			// can only inline static method calls
			if (!(i instanceof InvokeStatic))
				continue;
			
			List<Method> invokedMethods = ((InvokeInstruction) i).getMethods();
			if (invokedMethods.isEmpty())
				continue; // not our method
			
			Method invokedMethod = invokedMethods.get(0);
			Integer count = calls.get(invokedMethod);
			
			if (count == null || count != 1)
				continue; // only inline methods called once
			
			// XXX do this later
			System.out.println(invokedMethod.getDescriptor().getReturnValue().getType() + " " + invokedMethod.getDescriptor().size());
			if (!invokedMethod.getDescriptor().getReturnValue().getType().equals("V")
				|| invokedMethod.getDescriptor().size() != 0)
				continue;
			
			inline(m, i, invokedMethod);
			++inlineCount;
			break;
		}
		
		return inlineCount;
	}
	
	private void inline(Method method, Instruction invokeIns, Method invokeMethod)
	{
		Code methodCode = method.getCode(),
			invokeMethodCode = invokeMethod.getCode();
		Instructions methodInstructions = methodCode.getInstructions(),
			invokeMethodInstructions = invokeMethodCode.getInstructions();
		
		int maxLocals = methodCode.getMaxLocals(); // max locals currently
		
		int idx = methodInstructions.getInstructions().indexOf(invokeIns); // index of invoke ins, before removal
		assert idx != -1;
		
		Instruction nextInstruction = methodInstructions.getInstructions().get(idx + 1);
		
		// move stuff which jumps to invokeIns to nop
		
		Instruction nop = new NOP(methodInstructions);
		methodInstructions.getInstructions().add(idx + 1, nop);
		++idx;
		
		for (Instruction fromI : invokeIns.from)
		{
			assert fromI.jump.contains(invokeIns);

			fromI.jump.remove(invokeIns);
			fromI.replace(invokeIns, nop);
		}
		invokeIns.from.clear();
		
		methodInstructions.remove(invokeIns);
		
		for (Instruction i : invokeMethodInstructions.getInstructions())
		{
			// move instructions over.
			
			if (i instanceof ReturnInstruction)
			{
				assert i instanceof VReturn; // only support void atm
				
				// XXX I am assuming that this function leaves the stack in a clean state?
				
				// instead of return, jump to next instruction after the invoke
				i = new Goto(methodInstructions, nextInstruction);
			}
			
			if (i instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) i;
				// offset lvt index
				int newIndex = maxLocals + lvt.getVariableIndex();
				i = lvt.setVariableIndex(newIndex);
			}
			
			methodInstructions.getInstructions().add(idx++, i);
		}
		
		// old instructions go away
		invokeMethodInstructions.getInstructions().clear();
	}
	
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				countCalls(m);
			}
		}
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				count += processMethod(m);
			}
		}
		
		System.out.println("Inlined " + count + " methods");
	}
	
}
