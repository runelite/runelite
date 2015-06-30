package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnusedParameters
{
	private static List<Method> findDependentMethods(NameAndType nat, Set<ClassFile> visited, ClassGroup group, ClassFile cf)
	{
		List<Method> list = new ArrayList<>();
		
		if (cf == null || visited.contains(cf))
			return list;
		
		visited.add(cf);
		
		Method method = cf.findMethod(nat);
		if (method != null)
			list.add(method);
		
		// search parent
		list.addAll(findDependentMethods(nat, visited, group, cf.getParent()));
		
		// search interfaces
		for (ClassFile inter : cf.getInterfaces().getInterfaces())
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
	
	private int[] checkParametersOnce(Execution execution, ClassGroup group)
	{
		// removing parameters shifts the others around which is annoying.
		// if more than one is unused, we'll just remove the one
		// and do the others on another pass
		
		int count = 0;
		int collide = 0;
		int overrides = 0;
		
		//group.buildCallGraph(); // method.removeParameter uses the callgraph
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				int offset = m.isStatic() ? 0 : 1;
				Signature signature = m.getNameAndType().getDescriptor();
				
				// for a parameter to be unused it must be unused on all methods that override it
				
				List<Method> methods = findDependentMethods(m); // these are all of the methods the param must be unused in
				assert methods.contains(m);
				
				if (methods.size() > 1)
					continue; // don't mess with this now
				
				if (m.getCode() == null)
					continue;
				
			 outer:
				for (int variableIndex = 0, lvtIndex = offset;
						variableIndex < signature.size();
						lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots())
				{
					for (Method method : methods)
					{
						// XXX instead of checking if the lvt index is never accessed,
						// check execution frames and see if it is never read prior to being
						// written to, and if so, then remove the parameter, but don't re index
						// the lvt table.
						List<? extends Instruction> lv = method.findLVTInstructionsForVariable(lvtIndex);
						if (lv != null && !lv.isEmpty())
							continue outer; // used, try next parameter
					}
					
					/*if (lv == null)
						continue;
	
					// XXX instead of checking if the lvt index is never accessed,
					// check execution frames and see if it is never read prior to being
					// written to, and if so, then remove the parameter, but don't re index
					// the lvt table.
					if (!lv.isEmpty())
						continue;
					
					if (!m.getOverriddenMethods().isEmpty())
					{
						++overrides;
						continue;
					}*/
					
					Signature newSig = new Signature(m.getDescriptor());
					newSig.remove(variableIndex);
						
					Method otherMethod = cf.getMethods().findMethod(new NameAndType(m.getName(), newSig));
					if (otherMethod != null)
					{
						// sometimes removing an unused parameter will cause a signature collision with another function,
						// just ignore it atm (there seems to be very few)
						++collide;
						continue;
					}
						
					m.removeParameter(execution, variableIndex, lvtIndex);
					++count;
					break;
				}
			}
		}
		return new int[] { count, collide, overrides };
	}
	
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		int count = 0;
		int collide = 0;
		int override = 0;
		int[] i;
		do
		{
			i = checkParametersOnce(execution, group);
		
			count += i[0];
			collide = i[1]; // the next pass may be able to reduce the collisions
			override = i[2];
		}
		while (i[0] > 0);
		
		System.out.println("Removed " + count + " unused parameters, unable to remove " + collide + " because of signature collisions and " + override + " due to overriding");
	}
}
