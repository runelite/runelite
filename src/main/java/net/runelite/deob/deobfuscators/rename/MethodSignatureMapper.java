package net.runelite.deob.deobfuscators.rename;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Method;
import net.runelite.deob.Methods;
import net.runelite.deob.signature.Signature;

public class MethodSignatureMapper
{
	private Map<Method, Method> map = new HashMap<>();
	
	private long count(Methods methods, Signature sig)
	{
		return methods.getMethods().stream().filter(m -> m.getDescriptor().equals(sig)).count();
	}
	
	private Method get(Methods methods, Signature sig)
	{
		Optional<Method> o = methods.getMethods().stream().filter(m -> m.getDescriptor().equals(sig)).findFirst();
		return o.isPresent() ? o.get() : null;
	}
	
	public void map(ClassFile c1, ClassFile c2)
	{
		for (Method m : c1.getMethods().getMethods())
		{
			if (m.isStatic() || m.getName().equals("<init>") || count(c1.getMethods(), m.getDescriptor()) > 1)
				continue;
			
			Method other = get(c2.getMethods(), m.getDescriptor());
			if (other == null)
				continue;
			
			map.put(m, other);
		}
	}
	
	public Map<Method, Method> getMap()
	{
		return map;
	}
}
