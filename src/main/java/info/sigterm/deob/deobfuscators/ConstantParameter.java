package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
import info.sigterm.deob.attributes.code.instructions.If;
import info.sigterm.deob.attributes.code.instructions.If0;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.StackContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.MultiValueMap;

class ConstantMethodParameter
{
	public List<Method> methods;
	public int paramIndex;
	public int lvtIndex;
	public Object value;
	//public InstructionContext invoke; // invoking instruction

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 47 * hash + Objects.hashCode(this.methods);
		hash = 47 * hash + this.paramIndex;
		hash = 47 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ConstantMethodParameter other = (ConstantMethodParameter) obj;
		if (!Objects.equals(this.methods, other.methods)) {
			return false;
		}
		if (this.paramIndex != other.paramIndex) {
			return false;
		}
		if (!Objects.equals(this.value, other.value)) {
			return false;
		}
		return true;
	}
	
	
}

class MethodGroup
{
	public List<Method> methods; // methods that can be invoked
	public Collection<Integer> constantParameters; // parameters which are always constant for all invocations
	public List<ConstantMethodParameter> cmps = new ArrayList<>(); // cmps for all methods in the group, which hold the values.
	
//	public List<ConstantMethodParameter> getConstantParametersFor(Method m, int parameter)
//	{
//		List<ConstantMethodParameter> out = new ArrayList<>();
//		for (ConstantMethodParameter c : cmps)
//			if (c.method == m && c.paramNum == parameter)
//				out.add(c);
//		return out;
//	}
}

public class ConstantParameter implements Deobfuscator
{
	private List<ConstantMethodParameter> parameters = new ArrayList<>();
	//private MultiValueMap<Method, ConstantMethodParameter> parameters = new MultiValueMap<>();
	// methods can be in more than one group because of multiple inheritance with interfaces
	//private MultiValueMap<Method, MethodGroup> methodGroups = new MultiValueMap<>();
	private List<MethodGroup> methodGroups = new ArrayList<>();
	
	private void checkMethodsAreConsistent(List<Method> methods)
	{
		Method prev = null;
		for (Method m : methods)
		{
			if (prev != null)
			{
				assert prev.getDescriptor().equals(m.getDescriptor());
				assert prev.isStatic() == m.isStatic();
			}
			prev = m;
		}
	}
	
	private void findConstantParameter(Execution execution, List<Method> methods, InstructionContext invokeCtx)
	{
		checkMethodsAreConsistent(methods);
		
		Method method = methods.get(0); // all methods must have the same signature etc
		int offset = method.isStatic() ? 0 : 1;
		
		List<StackContext> pops = invokeCtx.getPops();
		
	 outer:
		// object is popped first, then param 1, 2, 3, etc. double and long take two slots.
		for (int lvtOffset = offset, parameterIndex = 0;
			parameterIndex < method.getDescriptor().size();
			lvtOffset += method.getDescriptor().getTypeOfArg(parameterIndex++).getSlots())
		{	
			// get(0) == first thing popped which is the last parameter,
			// get(descriptor.size() - 1) == first parameter
			StackContext ctx = pops.get(method.getDescriptor().size() - 1 - parameterIndex);
			
			if (ctx.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pc = (PushConstantInstruction) ctx.getPushed().getInstruction();
				
				if (!(pc.getConstant().getObject() instanceof Integer))
					continue;
				
				ConstantMethodParameter cmp = new ConstantMethodParameter();
				cmp.methods = methods;
				cmp.paramIndex = parameterIndex;
				cmp.lvtIndex = lvtOffset;
				cmp.value = pc.getConstant().getObject();
				//cmp.invoke = invokeCtx;
				
				// already exists?
				for (ConstantMethodParameter c : parameters)
					if (c.equals(cmp))
						continue outer;
				
				parameters.add(cmp);
			}
		}
	}
	
//	private Collection<Integer> getParametersFor(Method method)
//	{
//		Collection<ConstantMethodParameter> params = parameters.getCollection(method);
//		Collection<Integer> out = new ArrayList<>();
//		
//		if (params != null)
//			for (ConstantMethodParameter p : params)
//				if (!out.contains(p.paramNum))
//					out.add(p.paramNum);
//		
//		return out;
//	}
//	
	private void findParameters(Execution execution)
	{
		for (Frame frame : execution.processedFrames)
			for (InstructionContext ins : frame.getInstructions())
			{
				if (!(ins.getInstruction() instanceof InvokeInstruction))
					continue;
				
				List<Method> methods = ((InvokeInstruction) ins.getInstruction()).getMethods();
				if (methods.isEmpty())
					continue;
				
				findConstantParameter(execution, methods, ins);
				
				/*
				// get common constant indexes from all methods that can possibly be called
				Collection<Integer> parameterIndexes = null;
				for (Method m : methods)
				{
					Collection<Integer> idxs = getParametersFor(m);
					
					if (parameterIndexes == null)
						parameterIndexes = idxs;
					else
						parameterIndexes = CollectionUtils.intersection(parameterIndexes, idxs);
				}
				
				MethodGroup group = new MethodGroup();
				group.methods = methods;
				group.constantParameters = parameterIndexes;
				
				// build constant method parameters
				for (Method m : methods)
				{
					Collection<ConstantMethodParameter> params = parameters.getCollection(m);
					if (params != null)
						for (ConstantMethodParameter c : params)
							if (parameterIndexes.contains(c.paramNum))
								group.cmps.add(c);
				}
				
				// insert
				methodGroups.add(group);
				//for (Method m : methods)
				//	methodGroups.put(m, group);
					*/
			}
	}
	
	private boolean doLogicalComparison(Object value, ComparisonInstruction comparison, Object otherValue)
	{
		Instruction ins = (Instruction) comparison;
		
		assert (comparison instanceof If0) == (otherValue == null);
		assert otherValue == null || otherValue instanceof Integer;

		switch (ins.getType())
		{
			case IFEQ:
				return value.equals(0);
			case IFNE:
				return !value.equals(0);
			case IFLT:
				return (int) value < 0;
			case IFGE:
				return (int) value >= 0;
			case IFGT:
				return (int) value > 0;
			case IFLE:
				return (int) value < 0;
			case IF_ICMPEQ:
				return value.equals(otherValue);
			case IF_ICMPNE:
				return !value.equals(otherValue);
			case IF_ICMPLT:
				return (int) value < (int) otherValue;
			case IF_ICMPGE:
				return (int) value >= (int) otherValue;
			case IF_ICMPGT:
				return (int) value > (int) otherValue;
			case IF_ICMPLE:
				return (int) value <= (int) otherValue;
			default:
				throw new RuntimeException("Unknown constant comparison instructuction");
		}
	}
	
	private boolean isLogicallyDead(Execution execution, Method method, int paramIndex, int lvtIndex, Object value)
	{
		Boolean branch = null;
		// find if instruction
		// one side must be constant, other must be parameterIndex
		
		//int offset = method.isStatic() ? 0 : 1;
		//int variableIndex = paramIndex + offset;		
		
		for (Frame frame : execution.processedFrames)
		{
			if (frame.getMethod() != method)
				continue;
			
			for (InstructionContext ins : frame.getInstructions())
			{
//				if (ins.getInstruction() instanceof LVTInstruction)
//				{
//					LVTInstruction lvtins = (LVTInstruction) ins.getInstruction();
//					
//					if (lvtins.getVariableIndex() != variableIndex)
//						continue;
//				}
				
				if (!(ins.getInstruction() instanceof ComparisonInstruction))
					continue;
				
				// assume that this will always be variable index #paramIndex comp with a constant.
				
				ComparisonInstruction comp = (ComparisonInstruction) ins.getInstruction();
				
				StackContext one, two = null;
				
				if (comp instanceof If0)
				{
					one = ins.getPops().get(0);
				}
				else if (comp instanceof If)
				{
					one = ins.getPops().get(0);
					two = ins.getPops().get(1);
				}
				else
				{
					throw new RuntimeException("Unknown comp ins");
				}
					
				// find if one is a lvt ins
				LVTInstruction lvt = null;
				
				if (one.getPushed().getInstruction() instanceof LVTInstruction)
				{
					lvt = (LVTInstruction) one.getPushed().getInstruction();
				}
				else if (two != null && two.getPushed().getInstruction() instanceof LVTInstruction)
				{
					lvt = (LVTInstruction) two.getPushed().getInstruction();
				}
				
				assert lvt == null || !lvt.store();
				
				if (lvt == null || lvt.getVariableIndex() != lvtIndex)
					continue;
				
				Object otherValue = null;
				
				if (two != null) // two is null for if0
				{
					if (!(two.getPushed().getInstruction() instanceof PushConstantInstruction))
						continue;
					
					PushConstantInstruction pc = (PushConstantInstruction) two.getPushed().getInstruction();
					otherValue = pc.getConstant().getObject();
				}
				
				// results must all be the same
				boolean logicallyDead = doLogicalComparison(value, comp, otherValue);
				if (branch == null)
					branch = logicallyDead;
				else if (branch != logicallyDead)
					return false;
				//if (!logicallyDead)
				//	return false; // if one frame finds it not logically dead, then stop
			}
		}
		
		return branch != null ? true /* always logically taking the same branch */ : false /* totally unused XXX */;
		//return true;
	}
	
	private void findLogicallyDeadOperations(Execution execution)
	{
	 outer:
		for (ConstantMethodParameter cmp : parameters)
		{
			for (Method method : cmp.methods)
			{
				boolean isDead = isLogicallyDead(execution, method, cmp.paramIndex, cmp.lvtIndex, cmp.value);
				if (!isDead)
					continue outer;
			}
			
			// param is logically dead for all possible methods
			Method method = cmp.methods.get(0);
			System.out.println(method.getMethods().getClassFile().getName() + "." + method.getName() + " has dead param " + cmp.paramIndex);
		}
//		for (MethodGroup group : methodGroups)
//		//for (Object ogroup : methodGroups.values())
//		{
//			System.out.println("Iterating group " + group);
//	//		MethodGroup group = (MethodGroup) ogroup;
//			for (Method m : group.methods)
//			{
//				System.out.println("Iterating method " + m);
//				for (int parameterIndex : group.constantParameters)
//				{
//					// constants used in this parameter index when calling this method
//					List<ConstantMethodParameter> cmps = group.getConstantParametersFor(m, parameterIndex);
//					
//					// iterate instructions of method and find comparisons to parameter
//					// remove if all are logically dead. rely on unused parameter deob to remove
//					// the parameter.
//					System.out.println(cmps.size() + " calls to " + m.getMethods().getClassFile().getName() + "." + m.getName() + " with index " + parameterIndex);
//				}
//			}
//		}
//		for (MethodGroup group : methodGroups)
//		//for (Object ogroup : methodGroups.values())
//		{
//			System.out.println("Iterating group " + group);
//	//		MethodGroup group = (MethodGroup) ogroup;
//			for (Method m : group.methods)
//			{
//				System.out.println("Iterating method " + m);
//				for (int parameterIndex : group.constantParameters)
//				{
//					// constants used in this parameter index when calling this method
//					List<ConstantMethodParameter> cmps = group.getConstantParametersFor(m, parameterIndex);
//					
//					// iterate instructions of method and find comparisons to parameter
//					// remove if all are logically dead. rely on unused parameter deob to remove
//					// the parameter.
//					System.out.println(cmps.size() + " calls to " + m.getMethods().getClassFile().getName() + "." + m.getName() + " with index " + parameterIndex);
//				}
//			}
//		}
	}
	
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph(); // required for getMethods in the invoke stuff by execution...
		
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		findParameters(execution);
		findLogicallyDeadOperations(execution);
		
//		System.out.println(parameters.size() +  " params");
//		for (ConstantMethodParameter p : parameters)
//		{
//			//System.out.println
//		}
	}
	
}
