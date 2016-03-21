package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.AStore;
import net.runelite.asm.attributes.code.instructions.DStore;
import net.runelite.asm.attributes.code.instructions.FStore;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LStore;
import net.runelite.asm.attributes.code.instructions.NOP;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instructions.If;

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

			// this can't inline functions with exception handlers because throwing exceptions clears the stack
			if (count == null
				|| !invokedMethod.getCode().getExceptions().getExceptions().isEmpty()
				|| invokedMethod.getCode().getInstructions().getInstructions().size() > 30) // XXX magic
				continue;
//			if (count == null || count != 1)
//				continue; // only inline methods called once
			
			if (m == invokedMethod)
				continue; // recursive method
			
			int invokeIdx = ins.getInstructions().indexOf(i);
			assert invokeIdx != -1;
			assert ins.getInstructions().get(invokeIdx).getInstructions() == ins;
			
			int lvtIndex = code.getMaxLocals(),
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
		
		for (net.runelite.asm.attributes.code.Exception e : invokeMethodCode.getExceptions().getExceptions())
			e.replace(invokeIns, firstParamStore);
		
		methodInstructions.remove(invokeIns);
		
		Map<Instruction, Instruction> insMap = new HashMap<>();
		for (Instruction i : invokeMethodInstructions.getInstructions())
		{
			Instruction i2 = i.clone();
			i2.setInstructions(null);
			insMap.put(i, i2);
		}
		
		for (Instruction i : insMap.values())
		{
			for (Entry<Instruction, Instruction> e : insMap.entrySet())
			{
				i.replace(e.getKey(), e.getValue());
			}
		}
		
		for (Instruction i : insMap.values())
		{
			if (i instanceof JumpingInstruction)
			{
				JumpingInstruction j = (JumpingInstruction) i;
				for (Instruction i2 : j.getJumps())
				{
					assert insMap.values().contains(i2);
					assert i2.getInstructions() == null;
				}
			}
		}
		
		Exceptions fromExceptions = invokeMethod.getCode().getExceptions();
		Exceptions toExceptions = method.getCode().getExceptions();
		
		for (net.runelite.asm.attributes.code.Exception e : fromExceptions.getExceptions())
		{
			e = e.clone();
			e.setExceptions(toExceptions);
			
			for (Entry<Instruction, Instruction> en : insMap.entrySet())
			{
				e.replace(en.getKey(), en.getValue());
			}
			
			toExceptions.add(e);
		}
		
		for (Instruction i : invokeMethodInstructions.getInstructions())
		{
			Instruction orig = i;
			i = insMap.get(i);
			// copy instructions over.
			
			if (i instanceof ReturnInstruction)
			{	
				// XXX I am assuming that this function leaves the stack in a clean state?
				
				// instead of return, jump to next instruction after the invoke
				Instruction oldI = i;
				assert oldI.getInstructions() == null;
				
				i = new Goto(methodInstructions, nextInstruction);
				
				assert nextInstruction.getInstructions() == methodInstructions;
				assert methodInstructions.getInstructions().contains(nextInstruction);
				
				for (Instruction i2 : insMap.values())
					i2.replace(oldI, i);
				
				for (net.runelite.asm.attributes.code.Exception e : toExceptions.getExceptions())
					e.replace(oldI, i);
				
				insMap.put(orig, i);
			}
			
			if (i instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) i;
				// offset lvt index
				int newIndex = lvtBase + lvt.getVariableIndex();
				
				Instruction oldI = i;
				i = lvt.setVariableIndex(newIndex);
				
				assert oldI == i;
//				if (oldI != i)
//				{
//					for (Instruction i2 : insMap.values())
//						i2.replace(oldI, i);
//					
//					for (net.runelite.deob.attributes.code.Exception e : toExceptions.getExceptions())
//						e.replace(oldI, i);
//					
//					insMap.put(orig, i);
//				}
			}
			
			
			i.setInstructions(methodInstructions);
			assert !methodInstructions.getInstructions().contains(i);
			methodInstructions.getInstructions().add(idx++, i);
		}
		
		this.checkJumpGraph(methodInstructions);
	}
	
	private void checkJumpGraph(Instructions ins)
	{
		ins.buildJumpGraph();
		
		assert new HashSet<>(ins.getInstructions()).size() == ins.getInstructions().size();
		
		for (Instruction i : ins.getInstructions())
		{
			for (Instruction i2 : i.jump)
			{
				assert i2.getInstructions() == ins;
				assert ins.getInstructions().contains(i2);
				
				assert i2.from.contains(i);
			}
			
			for (Instruction i2 : i.from)
			{
				assert i2.getInstructions() == ins;
				assert ins.getInstructions().contains(i2);
				
				assert i2.jump.contains(i);
			}
			
			if (i instanceof JumpingInstruction)
			{
				JumpingInstruction j = (JumpingInstruction) i;
				assert j.getJumps().size() == i.jump.size();
			}
		}
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
		return count;
	}
	
}
