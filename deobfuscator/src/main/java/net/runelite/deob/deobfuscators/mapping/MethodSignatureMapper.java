package net.runelite.deob.deobfuscators.mapping;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;

public class MethodSignatureMapper
{
	private Multimap<Method, Method> map = ArrayListMultimap.create();

	private List<Method> getMethods(ClassGroup group)
	{
		List<Method> methods = new ArrayList<>();
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
				if (!m.isStatic() && !m.getName().equals("<init>") && m.getCode() != null)
					methods.add(m);
		return methods;
	}

	private List<Method> getMethodsOfSignature(ClassGroup group, ClassFile cf, Signature sig)
	{
		return getMethods(group).stream()
			.filter(m -> MappingExecutorUtil.isMaybeEqual(cf, m.getMethods().getClassFile()))
			.filter(m -> MappingExecutorUtil.isMaybeEqual(m.getDescriptor(), sig))
			.collect(Collectors.toList());
	}

	public void map(ClassGroup group1, ClassGroup group2)
	{
		for (Method m : getMethods(group1))
		{
			map.putAll(m, getMethodsOfSignature(group2, m.getMethods().getClassFile(), m.getDescriptor()));
		}
	}

	public Multimap<Method, Method> getMap()
	{
		return map;
	}
}
