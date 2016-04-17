package net.runelite.deob.deobfuscators.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import org.apache.commons.collections4.CollectionUtils;

public class ClassMapper
{
	private final ClassFile one, two;

	public ClassMapper(ClassFile one, ClassFile two)
	{
		this.one = one;
		this.two = two;
	}
	
	private List<Integer> fieldCardinalities(ClassFile cf)
	{
		List<Type> t = cf.getFields().getFields().stream()
			.filter(f -> !f.isStatic())
			.map(f -> f.getType())
			.collect(Collectors.toList());
		
		Map<Type, Integer> m = CollectionUtils.getCardinalityMap(t);
		
		List<Integer> occurances = new ArrayList<>(m.values());
		Collections.sort(occurances);
		return occurances;
	}
	
	private List<Integer> methodCardinalities(ClassFile cf)
	{
		List<Signature> t = cf.getMethods().getMethods().stream()
			.filter(m -> !m.isStatic())
			.filter(m -> !m.getName().startsWith("<"))
			.map(m -> m.getDescriptor())
			.collect(Collectors.toList());
		
		Map<Signature, Integer> m = CollectionUtils.getCardinalityMap(t);
		
		List<Integer> occurances = new ArrayList<>(m.values());
		Collections.sort(occurances);
		return occurances;
	}
	
	public boolean same()
	{
		List<Integer> c1 = fieldCardinalities(one), c2 = fieldCardinalities(two);
		
		if (!c1.equals(c2))
			return false;
		
		c1 = methodCardinalities(one);
		c2 = methodCardinalities(two);
		
		if (!c1.equals(c2))
			return false;
		
		return true;
	}
}
