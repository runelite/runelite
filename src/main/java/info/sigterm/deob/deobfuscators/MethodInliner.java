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
import info.sigterm.deob.attributes.code.instructions.AStore;
import info.sigterm.deob.attributes.code.instructions.DStore;
import info.sigterm.deob.attributes.code.instructions.FStore;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.IStore;
import info.sigterm.deob.attributes.code.instructions.InvokeStatic;
import info.sigterm.deob.attributes.code.instructions.LStore;
import info.sigterm.deob.attributes.code.instructions.NOP;
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.signature.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MethodInliner implements Deobfuscator
{
	private Map<Method, Integer> calls = new HashMap<>();
	private Set<Method> removeMethods = new HashSet<>();
	
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
			
			assert m != invokedMethod;
			
			int invokeIdx = ins.getInstructions().indexOf(i);
			assert invokeIdx != -1;
			
			int lvtIndex = code.getMaxLocals(),
				//startLvtIndex = lvtIndex,
				theirLocals = invokedMethod.getCode().getMaxLocals();
			
			if (lvtIndex + theirLocals > 127)
				continue;
			
			if (invokedMethod.isSynchronized())
				continue;
			
			if (!invokedMethod.getCode().getExceptions().getExceptions().isEmpty())
				continue;
			
			// assign variables on stack to lvt
			Signature descriptor = invokedMethod.getDescriptor();
			
			Map<Integer, Integer> lvtIndexes = new HashMap<>();
			for (int j = 0, idx = 0; j < descriptor.size(); ++j)
			{
				lvtIndexes.put(j, idx);
				idx += descriptor.getTypeOfArg(j).getSlots();
			}
				
			for (int j = descriptor.size() - 1; j >= 0; --j)
			{
				Type type = descriptor.getTypeOfArg(j);
				int paramLvtIndex = lvtIndexes.get(j);
				
				// insert instruction to store top of stack in lvt
				
				Instruction storeIns = null;
				if (type.getArrayDims() == 0)
				{
					switch (type.getType())
					{
						case "B":
						case "Z":
						case "C":
						case "S":
						case "I":
							storeIns = new IStore(ins, lvtIndex + paramLvtIndex);
							//lvtIndex += type.getSlots();
							break;
						case "J":
							storeIns = new LStore(ins, lvtIndex + paramLvtIndex);
							//lvtIndex += type.getSlots();
							break;
						case "F":
							storeIns = new FStore(ins, lvtIndex + paramLvtIndex);
							//lvtIndex += type.getSlots();
							break;
						case "D":
							storeIns = new DStore(ins, lvtIndex + paramLvtIndex);
							//lvtIndex += type.getSlots();
							break;
					}
				}
					
				if (type.getArrayDims() != 0 || type.getType().startsWith("L"))
				{
					assert storeIns == null;
					storeIns = new AStore(ins, lvtIndex + paramLvtIndex);
					//lvtIndex += type.getSlots();
				}
				assert storeIns != null;
				
				// insert storeIns before invoke instruction
				ins.getInstructions().add(invokeIdx++, storeIns);
			}
			
			inline(m, i, invokedMethod, /*start*/lvtIndex);
			++inlineCount;
			break;
		}
		
		return inlineCount;
	}
	
	private void inline(Method method, Instruction invokeIns, Method invokeMethod, int lvtBase)
	{
		Code methodCode = method.getCode(),
			invokeMethodCode = invokeMethod.getCode();
		Instructions methodInstructions = methodCode.getInstructions(),
			invokeMethodInstructions = invokeMethodCode.getInstructions();
		
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
			
			fromI.jump.add(nop);
			nop.from.add(fromI);
		}
		invokeIns.from.clear();
		
		methodInstructions.remove(invokeIns);
		
		methodInstructions.buildJumpGraph();
		invokeMethodInstructions.buildJumpGraph();
		
		for (Instruction i : invokeMethodInstructions.getInstructions())
		{
			// move instructions over.
			
			if (i instanceof ReturnInstruction)
			{	
				// XXX I am assuming that this function leaves the stack in a clean state?
				
				// instead of return, jump to next instruction after the invoke
				Instruction oldI = i;
				i = new Goto(methodInstructions, nextInstruction);
				
				i.jump.addAll(oldI.jump);
				i.from.addAll(oldI.from);
				
				for (Instruction i2 : oldI.from)
					i2.replace(oldI, i);
				
				oldI.from.clear();
			}
			
			if (i instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) i;
				// offset lvt index
				int newIndex = lvtBase + lvt.getVariableIndex();
				
				Instruction oldI = i;
				i = lvt.setVariableIndex(newIndex);
				
				i.jump.addAll(oldI.jump);
				i.from.addAll(oldI.from);
				
				for (Instruction i2 : oldI.from)
					i2.replace(oldI, i);
				
				oldI.from.clear();
			}
			
			methodInstructions.getInstructions().add(idx++, i);
			i.setInstructions(methodInstructions);
		}
		
		// old method goes away
		invokeMethodInstructions.getInstructions().clear();
		removeMethods.add(invokeMethod);
	}
	
	@Override
	public void run(ClassGroup group)
	{
		int total = 0;
		int i;
		do
		{
			i = pass(group);
			total += i;
		}
		while (i > 0);
		
		System.out.println("[TOTAL] Inlined " + total + " methods");
	}
	
	private int pass(ClassGroup group)
	{
		group.buildClassGraph();
		int count = 0;
		
		calls.clear();
		removeMethods.clear();
		
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
		
		for (Method m : removeMethods)
			m.getMethods().removeMethod(m);
		
		System.out.println("Inlined " + count + " methods");
		return count;
	}
	
}
