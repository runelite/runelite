package net.runelite.deob.deobfuscators;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.util.VirtualMethods;
import org.apache.commons.collections4.CollectionUtils;

public class UnusedParameters implements Deobfuscator
{
	private Map<List<Method>, Collection<Integer>> unused = new HashMap<>();
	private Multimap<Instruction, InstructionContext> invokes = HashMultimap.create();
	
	private void visit(InstructionContext ictx)
	{
		Instruction i = ictx.getInstruction();
		
		if (!(i instanceof InvokeInstruction))
			return;
		
		InvokeInstruction ii = (InvokeInstruction) i;
		List<Method> methods = ii.getMethods();
		
		//if (!unused.containsKey(methods))
		//	return;
		
		invokes.put(i, ictx);
	}
	
	private void buildUnused(ClassGroup group)
	{
		unused.clear();
		
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()))
					continue;
				
				List<Method> ms = VirtualMethods.getVirutalMethods(m);
				Collection<Integer> u = this.findUnusedParameters(ms);
				if (!u.isEmpty())
					unused.put(ms, u);
			}
	}
	
	private int processUnused(Execution execution, ClassGroup group)
	{
		int count = 0;
		
		for (List<Method> m : unused.keySet())
		{
			Collection<Integer> u = unused.get(m);

			int offset = m.size() == 1 && m.get(0).isStatic() ? 0 : 1;

			for (int unusedParameter : u)
			{
				Signature signature = m.get(0).getDescriptor();
				int lvtIndex = this.getLvtIndex(signature, offset, unusedParameter);
				/* removing the parameter can't cause collisions on other (overloaded) methods because prior to this we rename
				 * all classes/fields/methods to have unique names.
				 */
				System.out.println("Removing parameter " + unusedParameter + " at index " + lvtIndex + " from " + m);
				removeParameter(group, m, signature, execution, unusedParameter, lvtIndex);
				break;
			}

			++count;
		}
		
		return count;
	}
	
	public List<Integer> findUnusedParameters(Method method)
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
	
	@SuppressWarnings("empty-statement")
	private int getLvtIndex(Signature signature, int offset, int parameter)
	{
		// get lvt index for parameter
		int lvtIndex = offset;
		for (int variableIndex = 0;
				variableIndex < parameter;
				lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots());
		return lvtIndex;
	}
	
	public Collection<Integer> findUnusedParameters(Collection<Method> methods)
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
		
		List<Integer> l = new ArrayList<>(list);
		Collections.sort(l);
		Collections.reverse(l);
		return l;
	}
	
	public void removeParameter(ClassGroup group, List<Method> methods, Signature signature, Execution execution, int paramIndex, int lvtIndex)
	{
		int slots = signature.getTypeOfArg(paramIndex).getSlots();
		
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				
				if (c == null)
					continue;
				
				for (Instruction i : new ArrayList<>(c.getInstructions().getInstructions()))
				{
					if (!(i instanceof InvokeInstruction))
						continue;
					
					InvokeInstruction ii = (InvokeInstruction) i;
					
					if (!ii.getMethods().containsAll(methods))
						continue;
					
					ii.removeParameter(paramIndex); // remove parameter from instruction
					
					Collection<InstructionContext> ics = invokes.get(i);//execution.getInstructonContexts(i);
					assert ics != null;
					if (ics != null)
					{
						InstructionContext ins = ics.toArray(new InstructionContext[0])[0];

						int pops = signature.size() - paramIndex - 1; // index from top of stack of parameter. 0 is the last parameter

						StackContext sctx = ins.getPops().get(pops);
						if (sctx.getPushed().getInstruction().getInstructions() == null)
							continue;

						ins.removeStack(pops); // remove parameter from stack
					}
				}
			}
		
		for (Method method : methods)
			if (method.getCode() != null)
				// adjust lvt indexes to get rid of idx in the method
				for (Instruction ins : method.getCode().getInstructions().getInstructions())
				{
					if (ins instanceof LVTInstruction)
					{
						LVTInstruction lins = (LVTInstruction) ins;
						
						int i = lins.getVariableIndex();
						assert i != lvtIndex; // current unused variable detection just looks for no accesses
						
						// reassign
						if (i > lvtIndex)
						{
							assert i > 0;
							assert i >= lvtIndex + slots;
							
							Instruction newIns = lins.setVariableIndex(i - slots);
							assert ins == newIns;
						}
					}
				}
		
		for (Method method : methods)
			method.arguments.remove(paramIndex);
	}

	private int count;
	
	@Override
	public void run(ClassGroup group)
	{		
		int i;
		int pnum = 1;
		do
		{
			group.buildClassGraph();

			invokes.clear();
			this.buildUnused(group);

			Execution execution = new Execution(group);
			execution.addExecutionVisitor(ictx -> visit(ictx));
			execution.populateInitialMethods();
			execution.run();
			
			i = this.processUnused(execution, group);
			System.out.println("PASS " + pnum++ + " " + i);

			count += i;
			break;
		}
		while (i > 0);
		
		System.out.println("Removed " + count + " unused parameters");
	}

	public int getCount()
	{
		return count;
	}
}
