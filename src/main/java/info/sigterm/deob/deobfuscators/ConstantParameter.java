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
import org.apache.commons.collections4.map.MultiValueMap;

class ConstantMethodParameter
{
	public List<Method> methods;
	public int paramIndex;
	public int lvtIndex;
	public Object value;

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
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ConstantMethodParameter other = (ConstantMethodParameter) obj;
		if (!Objects.equals(this.methods, other.methods))
		{
			return false;
		}
		if (this.paramIndex != other.paramIndex)
		{
			return false;
		}
		if (!Objects.equals(this.value, other.value))
		{
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
}

public class ConstantParameter implements Deobfuscator
{
	private List<ConstantMethodParameter> parameters = new ArrayList<>();
	private MultiValueMap<Method, Integer> nonconst = new MultiValueMap<>(); // methods with non const parameters
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
			
			Collection<Integer> nonIdx = nonconst.getCollection(method);
			boolean non = nonIdx != null && nonIdx.contains(parameterIndex);
			
			if (non)
				continue;
			
			if (ctx.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pc = (PushConstantInstruction) ctx.getPushed().getInstruction();				
				
				if (!(pc.getConstant().getObject() instanceof Integer) && (!(pc.getConstant().getObject() instanceof Byte)))
					continue;
				
				ConstantMethodParameter cmp = new ConstantMethodParameter();
				cmp.methods = methods;
				cmp.paramIndex = parameterIndex;
				cmp.lvtIndex = lvtOffset;
				cmp.value = pc.getConstant().getObject();
				
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
			if (obj == null)
			{
				return false;
			}
			if (getClass() != obj.getClass())
			{
				return false;
			}
			final LogicallyDeadOp other = (LogicallyDeadOp) obj;
			if (!Objects.equals(this.compCtx.getInstruction(), other.compCtx.getInstruction()))
			{
				return false;
			}
			if (this.branch != other.branch)
			{
				return false;
			}
			return true;
		}
	}
	
	// find all comparisons of lvtIndex in method and record branch taken
	private List<LogicallyDeadOp> isLogicallyDead(Execution execution, Method method, int lvtIndex, Object value)
	{
		List<LogicallyDeadOp> ops = new ArrayList<>();
		
		for (Frame frame : execution.processedFrames)
		{
			if (frame.getMethod() != method)
				continue;
			
			for (InstructionContext ins : frame.getInstructions())
			{
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
				
				LogicallyDeadOp deadOp = new LogicallyDeadOp();
				deadOp.compCtx = ins;
				deadOp.branch = result;
				ops.add(deadOp);
			}
		}
		
		return ops;
	}
	
	private static class MethodLvtPair
	{
		Method method;
		int lvtIndex;

		public MethodLvtPair(Method method, int lvtIndex)
		{
			this.method = method;
			this.lvtIndex = lvtIndex;
		}

		@Override
		public int hashCode()
		{
			int hash = 7;
			hash = 41 * hash + Objects.hashCode(this.method);
			hash = 41 * hash + this.lvtIndex;
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
			final MethodLvtPair other = (MethodLvtPair) obj;
			if (!Objects.equals(this.method, other.method)) {
				return false;
			}
			if (this.lvtIndex != other.lvtIndex) {
				return false;
			}
			return true;
		}
		
		
	}
	
	private Map<MethodLvtPair, List<LogicallyDeadOp> > deadops = new HashMap<>();
	private Set<MethodLvtPair> invalidDeadops = new HashSet<>();
	
	// check every method parameter that we've identified as being passed constants to see if it's logically dead
	private void findLogicallyDeadOperations(Execution execution)
	{
	 outer:
		for (ConstantMethodParameter cmp : parameters)
		{
			for (Method method : cmp.methods)
			{
				MethodLvtPair pair = new MethodLvtPair(method, cmp.lvtIndex);
				
				if (invalidDeadops.contains(pair))
					continue;
				
				// the dead comparisons must be the same and branch the same way for every call to this method.
				List<LogicallyDeadOp> deadOps = isLogicallyDead(execution, method, cmp.lvtIndex, cmp.value);
				
				// this must be per method,lvtindex
				List<LogicallyDeadOp> existing = deadops.get(pair);
				if (existing != null)
					if (!existing.equals(deadOps))
					{
						// one of the branches taken differs because of the value, skip it
						deadops.remove(pair);
						invalidDeadops.add(pair);
						continue;
					}
					else
					{
						continue;
					}
				
				deadops.put(pair, deadOps);
			}
		}
	}
	
	// remove logically dead comparisons
	private int removeDeadOperations()
	{
		int count = 0;
		for (MethodLvtPair mvp : deadops.keySet())
		{
			Method method = mvp.method;
			List<LogicallyDeadOp> ops = deadops.get(mvp);
			
			for (LogicallyDeadOp op : ops)
			{
				InstructionContext ctx = op.compCtx; // comparison
				Instruction ins = ctx.getInstruction();
				boolean branch = op.branch; // branch that is always taken
				
				Instructions instructions = ins.getInstructions();
				
				// remove the if
				if (ctx.getInstruction() instanceof If)
					ctx.removeStack(1);
				ctx.removeStack(0);
				
				int idx = instructions.getInstructions().indexOf(ins);
				if (idx == -1)
					continue; // already removed?
				
				++count;
				
				Instruction to;
				if (branch)
				{
					JumpingInstruction jumpIns = (JumpingInstruction) ins;
					assert jumpIns.getJumps().size() == 1;
					to = jumpIns.getJumps().get(0);
				}
				else
				{
					// just go to next instruction
					to = instructions.getInstructions().get(idx + 1);
				}
				assert to.getInstructions() == instructions;
				assert ins != to;
				
				// move things that jump here to instead jump to 'to'
				for (Instruction fromI : ins.from)
				{
					assert fromI.jump.contains(ins);

					fromI.jump.remove(ins);
					fromI.replace(ins, to);
				}
				ins.from.clear();
				
				instructions.remove(ins);
				
				if (branch)
				{				
					// insert goto
					instructions.getInstructions().add(idx, new Goto(instructions, to));
				}
			}
		}
		return count;
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
		int count = removeDeadOperations();
		
		System.out.println("Removed " + count + " logically dead conditional jumps");
	}
	
}
