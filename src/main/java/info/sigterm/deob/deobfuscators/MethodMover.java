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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.map.MultiValueMap;

// find static methods that are only called from non-static methods of one class
public class MethodMover implements Deobfuscator
{
	private ClassGroup group;
	private MultiValueMap<Method, Method> calls = new MultiValueMap<>();
	
	private void buildCalls()
	{
		calls.clear();
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				if (m.isStatic())
					continue; // only want member methods
				
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
	
	private int moveMethods()
	{
		int moved = 0;
		
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
			
			if (m.getMethods().getClassFile() == caller)
				continue;
			
			++moved;
			move(m, caller);
		}
		
		return moved;
	}
	
	private void move(Method method, ClassFile to)
	{
		assert method.getMethods().getClassFile() != to;
		
		info.sigterm.deob.pool.Method newMethod = new info.sigterm.deob.pool.Method(
			new info.sigterm.deob.pool.Class(to.getName()),
			method.getNameAndType()
		);
		
		// move on instructions
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				code.getInstructions().renameMethod(method, newMethod);
			}
		}
		
		// move the method
		method.getMethods().removeMethod(method);
		to.getMethods().getMethods().add(method);
		method.setMethods(to.getMethods());
	}
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		
		group.buildClassGraph();
		buildCalls();
		int count = moveMethods();
		
		System.out.println("Moved " + count + " methods");
	}
}
