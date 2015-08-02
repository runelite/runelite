package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.If;
import info.sigterm.deob.attributes.code.instructions.If0;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.StackContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	private MultiValueMap<Method, Integer> nonconst = new MultiValueMap<>(); // methods with non const parameters
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
				
				if (method.getMethods().getClassFile().getName().equals("client") && method.getName().equals("i"))
				{
					int i = 5;
				}				
				
				if (!(pc.getConstant().getObject() instanceof Integer) && (!(pc.getConstant().getObject() instanceof Byte)))
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
			else
			{
				nonconst.put(method, parameterIndex);
				
				// remove from parameters as is not always const
				for (Iterator<ConstantMethodParameter> it = parameters.iterator(); it.hasNext();)
				{
					ConstantMethodParameter c = it.next();
					
					if (c.methods.equals(methods) && c.lvtIndex == lvtOffset)
					{
						it.remove();
					}
				}
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
		assert otherValue == null || otherValue instanceof Integer || otherValue instanceof Byte;

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
	
	private static class LogicallyDeadOp
	{
		InstructionContext compCtx; // logically dead comparison
		boolean branch; // branch which is always taken

		@Override
		public boolean equals(Object obj)
		{
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final LogicallyDeadOp other = (LogicallyDeadOp) obj;
			if (!Objects.equals(this.compCtx.getInstruction(), other.compCtx.getInstruction())) {
				return false;
			}
			if (this.branch != other.branch) {
				return false;
			}
			return true;
		}
		

	}
	
	private List<LogicallyDeadOp> isLogicallyDead(Execution execution, Method method, int lvtIndex, Object value)
	{
		Boolean branch = null;
		List<LogicallyDeadOp> ops = new ArrayList<>();
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
				// XXX this should look for field accesses and see hwats done with it.
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
				StackContext other = null;
				
				if (one.getPushed().getInstruction() instanceof LVTInstruction)
				{
					lvt = (LVTInstruction) one.getPushed().getInstruction();
					other = two;
				}
				else if (two != null && two.getPushed().getInstruction() instanceof LVTInstruction)
				{
					lvt = (LVTInstruction) two.getPushed().getInstruction();
					other = one;
				}
				
				assert lvt == null || !lvt.store();
				
				if (lvt == null || lvt.getVariableIndex() != lvtIndex)
					continue;
				
				Object otherValue = null;
				
				if (two != null) // two is null for if0
				{
					if (!(other.getPushed().getInstruction() instanceof PushConstantInstruction))
						continue;
					
					PushConstantInstruction pc = (PushConstantInstruction) other.getPushed().getInstruction();
					otherValue = pc.getConstant().getObject();
				}
				
				// the result of the comparison doesn't matter, only that it always goes the same direction for every invocation
				boolean result = doLogicalComparison(value, comp, otherValue);
				/*if (branch == null)
					branch = result;
				else if (branch != result)
					return null;*/
				
				LogicallyDeadOp deadOp = new LogicallyDeadOp();
				deadOp.compCtx = ins;
				deadOp.branch = result;
				ops.add(deadOp);
				//if (!logicallyDead)
				//	return false; // if one frame finds it not logically dead, then stop
			}
		}
		
		return ops;
		//return branch != null ? true /* always logically taking the same branch */ : false /* totally unused XXX */;
		//return true;
	}
	
	private void removeLogicallyDead(Execution execution, Method method, int lvtIndex)
	{
		
	}
	
	private Map<Method, List<LogicallyDeadOp> > deadops = new HashMap<>();
	private Set<Method> invalidDeadops = new HashSet<>();
	
	private void findLogicallyDeadOperations(Execution execution)
	{
	 outer:
		for (ConstantMethodParameter cmp : parameters)
		{
//			Method method2 = cmp.methods.get(0);
//				if (method2.getMethods().getClassFile().getName().equals("gy") && method2.getName().equals("y"))
//				{
//					int i = 5;
//				}
			for (Method method : cmp.methods)
			{
				if (invalidDeadops.contains(method))
					continue;
				
				// the dead comparisons must be the same and branch the same way for every call to this method.
				List<LogicallyDeadOp> deadOps = isLogicallyDead(execution, method, cmp.lvtIndex, cmp.value);
				
				List<LogicallyDeadOp> existing = deadops.get(method);
				if (existing != null)
					if (!existing.equals(deadOps))
					{
						deadops.remove(method);
						invalidDeadops.add(method);
						continue;
					}
					else
					{
						continue;
					}
				
				deadops.put(method, deadOps);
				//if (deadOps == null)
					//continue;
				//if (isDead == null || !isDead)
				//	continue outer;
			}
			
			// param is logically dead for all possible methods
			//Method method = cmp.methods.get(0);
			//System.out.println(method.getMethods().getClassFile().getName() + "." + method.getName() + " has dead param " + cmp.paramIndex);
			
			for (Method method : cmp.methods)
			{
				// remove dead parameter.
				
				// I already have an unused parameter deob which detects them and removes them, so don't have to clean up those.
				// Additionally there is an unused block deob which can remove unused blocks of code, so
				
				// remove conditional jump, insert goto?
				//removeLogicallyDead(execution, method, cmp.lvtIndex);
			}
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
	
	private void removeDeadOperations()
	{
		for (Method method : deadops.keySet())
		{
			List<LogicallyDeadOp> ops = deadops.get(method);
			
			for (LogicallyDeadOp op : ops)
			{
				InstructionContext ctx = op.compCtx; // comparison
				Instruction ins = ctx.getInstruction();
				boolean branch = op.branch;
				assert branch;
				
				Instructions instructions = ins.getInstructions();
				
				// remove the if
				if (ctx.getInstruction() instanceof If)
					ctx.removeStack(1);
				ctx.removeStack(0);
				
				int idx = instructions.getInstructions().indexOf(ins);
				if (idx == -1)
					continue; // already removed?

				JumpingInstruction jumpIns = (JumpingInstruction) ins;
				assert jumpIns.getJumps().size() == 1;
				Instruction to = jumpIns.getJumps().get(0);
				
				// move things that jump here to instead jump to 'to'
				for (Instruction fromI : ins.from)
				{
					
				}
				
				instructions.remove(ctx.getInstruction());
				
				//assert branch;
				
				//if (branch)
				{
					// insert goto
					instructions.getInstructions().add(idx, new Goto(instructions, to));
				}
			}
		}
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
		removeDeadOperations();
		
		//System.out.println(deadops.size() + " deadops");
		
//		System.out.println(parameters.size() +  " params");
//		for (ConstantMethodParameter p : parameters)
//		{
//			//System.out.println
//		}
	}
	
}
