package net.runelite.deob.deobfuscators;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.deob.attributes.code.instructions.AStore;
import net.runelite.deob.attributes.code.instructions.DStore;
import net.runelite.deob.attributes.code.instructions.FStore;
import net.runelite.deob.attributes.code.instructions.Goto;
import net.runelite.deob.attributes.code.instructions.IStore;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.attributes.code.instructions.LStore;
import net.runelite.deob.attributes.code.instructions.NOP;
import net.runelite.deob.signature.Signature;
import net.runelite.deob.signature.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.deob.attributes.code.Exceptions;

public class MethodInliner implements Deobfuscator
{
	private Map<Method, Integer> calls = new HashMap<>();
	//private Set<Method> removeMethods = new HashSet<>();
	
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
			assert i.getInstructions() == ins;
			// can only inline static method calls
			if (!(i instanceof InvokeStatic))
				continue;
			
			List<Method> invokedMethods = ((InvokeInstruction) i).getMethods();
			if (invokedMethods.isEmpty())
				continue; // not our method
			
			Method invokedMethod = invokedMethods.get(0);
			Integer count = calls.get(invokedMethod);

			if (count == null || invokedMethod.getCode().getInstructions().getInstructions().size() > 30)
				continue;
//			if (count == null || count != 1)
//				continue; // only inline methods called once
			
			if (m == invokedMethod)
				continue; // recursive method
			
			int invokeIdx = ins.getInstructions().indexOf(i);
			assert invokeIdx != -1;
			assert ins.getInstructions().get(invokeIdx).getInstructions() == ins.getInstructions();
			
			int lvtIndex = code.getMaxLocals(),
				//startLvtIndex = lvtIndex,
				theirLocals = invokedMethod.getCode().getMaxLocals();
			
			if (lvtIndex + theirLocals > 127)
				continue;
			
			if (invokedMethod.isSynchronized())
				continue;
			
			// assign variables on stack to lvt
			Signature descriptor = invokedMethod.getDescriptor();
			
			Map<Integer, Integer> lvtIndexes = new HashMap<>();
			for (int j = 0, idx = 0; j < descriptor.size(); ++j)
			{
				lvtIndexes.put(j, idx);
				idx += descriptor.getTypeOfArg(j).getSlots();
			}
			
			Instruction firstParamStore = null;
			
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
							break;
						case "J":
							storeIns = new LStore(ins, lvtIndex + paramLvtIndex);
							break;
						case "F":
							storeIns = new FStore(ins, lvtIndex + paramLvtIndex);
							break;
						case "D":
							storeIns = new DStore(ins, lvtIndex + paramLvtIndex);
							break;
					}
				}
					
				if (type.getArrayDims() != 0 || type.getType().startsWith("L"))
				{
					assert storeIns == null;
					storeIns = new AStore(ins, lvtIndex + paramLvtIndex);
				}
				assert storeIns != null;
				
				// insert storeIns before invoke instruction
				ins.getInstructions().add(invokeIdx++, storeIns);
				
				if (firstParamStore == null)
					firstParamStore = storeIns;
			}
			
			int maxStack = code.getMaxStack() + invokedMethod.getCode().getMaxStack(); // not really right but ok
			code.setMaxStack(maxStack);
			
			inline(m, i, invokedMethod, lvtIndex, firstParamStore);
			moveExceptions(m, invokedMethod);
			++inlineCount;
			break;
		}
		
		return inlineCount;
	}
	
	private void inline(Method method, Instruction invokeIns, Method invokeMethod, int lvtBase, Instruction firstParamStore)
	{
		Code methodCode = method.getCode(),
			invokeMethodCode = invokeMethod.getCode();
		Instructions methodInstructions = methodCode.getInstructions(),
			invokeMethodInstructions = invokeMethodCode.getInstructions();
		
		int idx = methodInstructions.getInstructions().indexOf(invokeIns); // index of invoke ins, before removal
		assert invokeIns.getInstructions() == methodInstructions;
		assert idx != -1;
		
		Instruction nextInstruction = methodInstructions.getInstructions().get(idx + 1);
		
		// move stuff which jumps to invokeIns to firstParamStore. If there are no arguments that are stored,
		// firstParamStore is null, and so create a nop instruction.
		
		if (firstParamStore == null)
		{
			Instruction nop = new NOP(methodInstructions);
			methodInstructions.getInstructions().add(idx + 1, nop);
			++idx;
			
			firstParamStore = nop;
		}
		
		methodInstructions.buildJumpGraph();
		invokeMethodInstructions.buildJumpGraph();
		
		for (Instruction fromI : invokeIns.from)
		{
			assert fromI.jump.contains(invokeIns);

			fromI.jump.remove(invokeIns);
			fromI.replace(invokeIns, firstParamStore);

			fromI.jump.add(firstParamStore);
			firstParamStore.from.add(fromI);
		}
		invokeIns.from.clear();
		
		for (net.runelite.deob.attributes.code.Exception e : invokeMethodCode.getExceptions().getExceptions())
			e.replace(invokeIns, firstParamStore);
		
		methodInstructions.remove(invokeIns);
		
		for (Instruction i : invokeMethodInstructions.getInstructions())
		{
			// move instructions over.
			
			if (i instanceof ReturnInstruction)
			{	
				// XXX I am assuming that this function leaves the stack in a clean state?
				
				// instead of return, jump to next instruction after the invoke
				Instruction oldI = i;
				i = new Goto(methodInstructions, nextInstruction);
				assert methodInstructions.getInstructions().contains(nextInstruction);
				
				assert oldI != nextInstruction;
				i.jump.add(nextInstruction);
				nextInstruction.from.add(i);
				
				assert oldI.jump.isEmpty();
				//i.jump.addAll(oldI.jump);
				i.from.addAll(oldI.from);
				
				for (Instruction i2 : oldI.from)
					i2.replace(oldI, i);
				
				oldI.from.clear();
				
				for (net.runelite.deob.attributes.code.Exception e : invokeMethodCode.getExceptions().getExceptions())
					e.replace(oldI, i);
			}
			
			if (i instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) i;
				// offset lvt index
				int newIndex = lvtBase + lvt.getVariableIndex();
				
				Instruction oldI = i;
				i = lvt.setVariableIndex(newIndex);
				
				if (oldI != i)
				{
					assert oldI.jump.isEmpty();
					//i.jump.addAll(oldI.jump);
					i.from.addAll(oldI.from);

					for (Instruction i2 : oldI.from)
						i2.replace(oldI, i);

					oldI.from.clear();
					
					for (net.runelite.deob.attributes.code.Exception e : invokeMethodCode.getExceptions().getExceptions())
						e.replace(oldI, i);
				}
			}
			
			methodInstructions.getInstructions().add(idx++, i);
			i.setInstructions(methodInstructions);
		}
		
		// old method goes away
		//invokeMethodInstructions.getInstructions().clear();
		//removeMethods.add(invokeMethod);
	}
	
	private void moveExceptions(Method to, Method from)
	{
		Exceptions exceptions = from.getCode().getExceptions();
		Exceptions toExceptions = to.getCode().getExceptions();
		
		for (net.runelite.deob.attributes.code.Exception e : exceptions.getExceptions())
		{
			e.setExceptions(toExceptions);
			toExceptions.add(e);
		}
		exceptions.getExceptions().clear();
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
		//removeMethods.clear();
		
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
//		
//		for (Method m : removeMethods)
//			m.getMethods().removeMethod(m);
		
		System.out.println("Inlined " + count + " methods");
		return count;
	}
	
}
