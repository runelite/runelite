package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;

public class StaticMethodSignatureMapper
{
	private Multimap<Method, Method> map = ArrayListMultimap.create();
	
	private List<Method> getStaticMethods(ClassGroup group)
	{
		List<Method> methods = new ArrayList<>();
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
				if (m.isStatic() && !m.getName().equals("<clinit>"))
					methods.add(m);
		return methods;
	}
	
	private List<Method> getStaticMethodsOfSignature(ClassGroup group, Signature sig)
	{
		return getStaticMethods(group).stream().filter(
			m -> MappingExecutorUtil.isMaybeEqual(m.getDescriptor(), sig)
		).collect(Collectors.toList());
	}
	
	public void map(ClassGroup group1, ClassGroup group2)
	{
		for (Method m : getStaticMethods(group1))
		{
			map.putAll(m, getStaticMethodsOfSignature(group2, m.getDescriptor()));
		}
	}
	
	public Multimap<Method, Method> getMap()
	{
		return map;
	}
}
