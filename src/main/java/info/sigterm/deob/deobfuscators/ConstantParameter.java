package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.PushConstantInstruction;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.StackContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.MultiValueMap;

class ConstantMethodParameter
{
	public Method method;
	public int paramNum;
	public Object value;
	public InstructionContext invoke; // invoking instruction
}

class MethodGroup
{
	public List<Method> methods; // methods that can be invoked
	public Collection<Integer> constantParameters; // parameters which are always constant for all invocations
	public List<ConstantMethodParameter> cmps = new ArrayList<>(); // cmps for all methods in the group, which hold the values.
	
	public List<ConstantMethodParameter> getConstantParametersFor(Method m, int parameter)
	{
		List<ConstantMethodParameter> out = new ArrayList<>();
		for (ConstantMethodParameter c : cmps)
			if (c.method == m && c.paramNum == parameter)
				out.add(c);
		return out;
	}
}

public class ConstantParameter implements Deobfuscator
{
	private MultiValueMap<Method, ConstantMethodParameter> parameters = new MultiValueMap<>();
	// methods can be in more than one group because of multiple inheritance with interfaces
	//private MultiValueMap<Method, MethodGroup> methodGroups = new MultiValueMap<>();
	private List<MethodGroup> methodGroups = new ArrayList<>();
	
	private void findConstantParameter(Execution execution, Method method, InstructionContext invokeCtx)
	{
		List<StackContext> pops = invokeCtx.getPops();
		for (int i = 0; i < method.getDescriptor().size(); ++i)
		{
			// object is poped first
			
			int offset = method.isStatic() ? 0 : 1;
			
			StackContext ctx = pops.get(offset + i);
			if (ctx.getPushed().getInstruction() instanceof PushConstantInstruction)
			{
				PushConstantInstruction pc = (PushConstantInstruction) ctx.getPushed().getInstruction();
				
				if (!(pc.getConstant().getObject() instanceof Integer))
					continue;
				
				ConstantMethodParameter cmp = new ConstantMethodParameter();
				cmp.method = method;
				cmp.paramNum = i;
				cmp.value = pc.getConstant().getObject();
				cmp.invoke = invokeCtx;
				
				parameters.put(method, cmp);
			}
		}
	}
	
	private Collection<Integer> getParametersFor(Method method)
	{
		Collection<ConstantMethodParameter> params = parameters.getCollection(method);
		Collection<Integer> out = new ArrayList<>();
		
		if (params != null)
			for (ConstantMethodParameter p : params)
				if (!out.contains(p.paramNum))
					out.add(p.paramNum);
		
		return out;
	}
	
	private void findParameters(Execution execution)
	{
		for (Frame frame : execution.processedFrames)
			for (InstructionContext ins : frame.getInstructions())
			{
				if (!(ins.getInstruction() instanceof InvokeInstruction))
					continue;
				
				List<Method> methods = ((InvokeInstruction) ins.getInstruction()).getMethods();
				for (Method m : methods)
					findConstantParameter(execution, m, ins);
				
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
			}
	}
	
	private void findLogicallyDeadOperations()
	{
		for (MethodGroup group : methodGroups)
		//for (Object ogroup : methodGroups.values())
		{
	//		MethodGroup group = (MethodGroup) ogroup;
			for (Method m : group.methods)
				for (int parameterIndex : group.constantParameters)
				{
					// constants used in this parameter index when calling this method
					List<ConstantMethodParameter> cmps = group.getConstantParametersFor(m, parameterIndex);
					
					// iterate instructions of method and find comparisons to parameter
					// remove if all are logically dead. rely on unused parameter deob to remove
					// the parameter.
					System.out.println(cmps.size() + " calls to " + m.getMethods().getClassFile().getName() + "." + m.getName() + " with index " + parameterIndex);
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
		findLogicallyDeadOperations();
	}
	
}
