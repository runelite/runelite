package net.runelite.deob.deobfuscators;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.pool.NameAndType;
import net.runelite.deob.pool.PoolEntry;
import net.runelite.deob.signature.Signature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

public class UnusedParameters implements Deobfuscator
{
	private static List<Method> findDependentMethods(NameAndType nat, Set<ClassFile> visited, ClassGroup group, ClassFile cf)
	{
		List<Method> list = new ArrayList<>();
		
		if (cf == null || visited.contains(cf))
			return list;
		
		visited.add(cf);
		
		Method method = cf.findMethod(nat);
		if (method != null && !method.isStatic())
			list.add(method);
		
		// search parent
		list.addAll(findDependentMethods(nat, visited, group, cf.getParent()));
		
		// search interfaces
		for (ClassFile inter : cf.getInterfaces().getMyInterfaces())
			list.addAll(findDependentMethods(nat, visited, group, inter));
		
		// search children
		for (ClassFile child : cf.getChildren())
			list.addAll(findDependentMethods(nat, visited, group, child));
		
		return list;
	}
	
	private static List<Method> findDependentMethods(Method m)
	{
		ClassFile cf = m.getMethods().getClassFile();
		return findDependentMethods(m.getNameAndType(), new HashSet<ClassFile>(), cf.getGroup(), cf);
	}
	
	private List<Integer> findUnusedParameters(Method method)
	{
		int offset = method.isStatic() ? 0 : 1;
		Signature signature = method.getNameAndType().getDescriptor();
		List<Integer> unusedParams = new ArrayList<>();
		
		for (int variableIndex = 0, lvtIndex = offset;
				variableIndex < signature.size();
				lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots())
		{		
			List<? extends Instruction> lv = method.findLVTInstructionsForVariable(lvtIndex);
			if (lv == null || lv.isEmpty())
				unusedParams.add(variableIndex);
		}
		
		return unusedParams;
	}
	
	private int[] getLvtIndexes(Signature signature, int offset)
	{
		int[] i = new int[signature.size()];
		for (int variableIndex = 0, lvtIndex = offset;
				variableIndex < signature.size();
				lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots())
		{
			i[variableIndex] = lvtIndex;
		}
		return i;
	}
	
	private Collection<Integer> findUnusedParameters(Collection<Method> methods)
	{
		Collection<Integer> list = null;
		
		for (Method m : methods)
		{
			List<Integer> p = findUnusedParameters(m);
			
			if (list == null)
				list = p;
			else
				list = CollectionUtils.intersection(list, p);
		}
		
		return list;
	}
	
	public void removeParameter(List<Method> methods, Signature signature, Execution execution, int paramIndex, int lvtIndex)
	{
		Set<Instruction> done = new HashSet<>();
		
		assert signature.getTypeOfArg(paramIndex).getSlots() == 1;
		
		for (Frame f : execution.processedFrames)
			for (InstructionContext ins : f.getInstructions())
				if (!ins.getInvokes().isEmpty() && methods.containsAll(ins.getInvokes()))
				{
					int pops = signature.size() - paramIndex - 1; // index from top of stack of parameter. 0 is the last parameter
					ins.removeStack(pops); // remove parameter from stack
					
					if (done.contains(ins.getInstruction()))
						continue;
					
					InvokeInstruction iins = (InvokeInstruction) ins.getInstruction();
					iins.removeParameter(paramIndex); // remove parameter from instruction
					
					done.add(ins.getInstruction());
				}
		
		for (Method method : methods)
			// this double checks that all calls to this have been located
			for (ClassFile cf : method.getMethods().getClassFile().getGroup().getClasses())
				for (Method m : cf.getMethods().getMethods())
				{
					Code c = m.getCode();
					if (c == null)
						continue;
					
					for (Instruction i : c.getInstructions().getInstructions())
					{
						if (i instanceof InvokeInstruction)
						{
							InvokeInstruction ii = (InvokeInstruction) i;
							PoolEntry pool = ii.getMethod();
							
							if (pool instanceof net.runelite.deob.pool.Method)
							{
								net.runelite.deob.pool.Method pm = (net.runelite.deob.pool.Method) pool;
								
								if (pm.getClassEntry().getName().equals(method.getMethods().getClassFile().getName()) && pm.getNameAndType().equals(method.getNameAndType()) && !done.contains(i))
								{
									// for some reason this wasn't removed above?
									System.err.println("Method " + m.getName() + " in " + cf.getName() + " calls " + pm.getNameAndType().getName() + " in " + pm.getClassEntry().getName() + " at " + i.getPc() + ", but this instruction was not found during execution");
									//assert false;
								}
							}
							else if (pool instanceof net.runelite.deob.pool.InterfaceMethod)
							{
								net.runelite.deob.pool.InterfaceMethod pm = (net.runelite.deob.pool.InterfaceMethod) pool;
								
								if (pm.getClassEntry().getName().equals(method.getMethods().getClassFile().getName()) && pm.getNameAndType().equals(method.getNameAndType()) && !done.contains(i))
								{
									// for some reason this wasn't removed above?
									System.err.println("Method " + m.getName() + " in " + cf.getName() + " calls " + pm.getNameAndType().getName() + " in " + pm.getClassEntry().getName() + " at " + i.getPc() + ", but this instruction was not found during execution");
									//assert false;
								}
							}
						}
					}
				}
		
		int numArgs = signature.size();
		if (methods.size() > 1 || !methods.get(0).isStatic())
			++numArgs;
		
		for (Method method : methods)
			if (method.getCode() != null)
				// adjust lvt indexes to get rid of idx in the method
				for (Instruction ins : new ArrayList<>(method.getCode().getInstructions().getInstructions()))
				{
					if (ins instanceof LVTInstruction)
					{
						LVTInstruction lins = (LVTInstruction) ins;
						
						int i = lins.getVariableIndex();
						assert i != lvtIndex; // current unused variable detection just looks for no accesses
						
						//if (i >= numArgs)
						//	continue;
						
						// reassign
						if (i > lvtIndex)
						{
							Instruction newIns = lins.setVariableIndex(--i);
							if (newIns != ins)
								ins.replace(newIns);
						}
					}
				}
		
		for (Method method : methods)
			method.arguments.remove(paramIndex);
	}
	
	private int[] checkParametersOnce(Execution execution, ClassGroup group)
	{
		// removing parameters shifts the others around which is annoying.
		// if more than one is unused, we'll just remove the one
		// and do the others on another pass
		
		Set<Method> done = new HashSet<>();
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (done.contains(m) || !Deob.isObfuscated(m.getName()))
					continue;

				int offset = m.isStatic() ? 0 : 1;
				Signature signature = m.getNameAndType().getDescriptor();
				
				// for a parameter to be unused it must be unused on all methods that override it
				
				List<Method> methods;
				if (!m.isStatic())
				{
					methods = findDependentMethods(m); // these are all of the methods the param must be unused in
				}
				else
				{
					methods = new ArrayList<>();
					methods.add(m);
				}
				
				Collection<Integer> unusedParameters = findUnusedParameters(methods);
				
				if (unusedParameters.isEmpty())
					continue;
				
				int unusedParameter = (int) unusedParameters.toArray()[0];
				int[] lvtIndexes = getLvtIndexes(signature, offset);
				
				for (Method m2 : methods)
				{
					assert !done.contains(m2);
					done.add(m2);
				}
				
				/* removing the parameter can't cause collisions on other (overloaded) methods because prior to this we rename
				 * all classes/fields/methods to have unique names.
				 */
				System.out.println("Removing parameter " + unusedParameter + " from " + methods.get(0).getName());
				removeParameter(methods, signature, execution, unusedParameter, lvtIndexes[unusedParameter]);
				
				++count;
				
				break;
			}
		}
		return new int[] { count };
	}
	
	@Override
	public void run(ClassGroup group)
	{		
		int count = 0;
		int[] i;
		do
		{
			group.buildClassGraph();
			
			Execution execution = new Execution(group);
			execution.populateInitialMethods();
			execution.run();
			
			i = checkParametersOnce(execution, group);
		
			count += i[0];
			break;
		}
		while (i[0] > 0);
		
		System.out.println("Removed " + count + " unused parameters");
	}
}
