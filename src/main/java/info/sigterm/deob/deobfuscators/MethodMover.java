package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.InvokeStatic;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.map.MultiValueMap;

// find static methods that are only called from methods of one class
public class MethodMover implements Deobfuscator
{
	private MultiValueMap<Method, Method> calls = new MultiValueMap<>();
	
	private void buildCalls(ClassGroup group)
	{
		calls.clear();
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				Instructions ins = code.getInstructions();
				for (Instruction i : ins.getInstructions())
				{
					if (!(i instanceof InvokeStatic))
						continue;
					
					InvokeStatic is = (InvokeStatic) i;
					List<Method> methods = is.getMethods();
					
					if (methods.isEmpty())
						continue;
					
					Method method = methods.get(0);
					
					calls.put(method, m);
				}
			}
		}	
	}
	
	private void look()
	{
		for (Method m : calls.keySet())
		{
			Collection<Method> values = calls.getCollection(m);
			
			boolean set = false;
			ClassFile caller = null;
			
			for (Method m2 : values)
			{
				if (!set)
				{
					set = true;
					caller = m2.getMethods().getClassFile();
				}
				
				if (caller != m2.getMethods().getClassFile())
				{
					caller = null;
				}
			}
			
			if (caller == null)
				continue;
			
			System.out.println(caller.getName() + " always calls " + m.getName() + " sz " + values.size());
		}
	}
	
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		buildCalls(group);
		look();
	}
}
