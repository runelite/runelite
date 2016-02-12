package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Method;

public class MethodSignatureMapper
{
	private Multimap<Method, Method> map = ArrayListMultimap.create();
	
	public void map(ClassFile c1, ClassFile c2)
	{
		for (Method m : c1.getMethods().getMethods())
		{
			if (m.isStatic() || m.getCode() == null)
				continue;
			
			boolean isConstructor = m.getName().equals("<init>");
			
			for (Method m2 : c2.getMethods().getMethods())
			{
				if (m2.getCode() == null)
					continue;
				
				if (!m.getDescriptor().equals(m2.getDescriptor()))
					continue;
				
				boolean isConstructor2 = m2.getName().equals("<init>");
				
				if (isConstructor != isConstructor2)
					continue;

				map.put(m, m2);
			}
		}
	}
	
	public Multimap<Method, Method> getMap()
	{
		return map;
	}
}
