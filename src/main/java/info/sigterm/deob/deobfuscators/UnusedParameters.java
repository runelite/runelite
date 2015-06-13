package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;

import java.util.List;

public class UnusedParameters
{
	private int[] checkParametersOnce(Execution execution, ClassGroup group)
	{
		// removing parameters shifts the others around which is annoying.
		// if more than one is unused, we'll just remove the one
		// and do the others on another pass
		
		int count = 0;
		int collide = 0;
		int overrides = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				int offset = m.isStatic() ? 0 : 1;
				NameAndType nat = m.getNameAndType();
				Signature signature = nat.getDescriptor();
				
				for (int variableIndex = 0, lvtIndex = offset;
						variableIndex < signature.size();
						lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots())
				{
					List<? extends Instruction> lv = m.findLVTInstructionsForVariable(lvtIndex);
					
					if (lv == null)
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
					}
					
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
