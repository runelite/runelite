package net.runelite.deob.deobfuscators.mapping;

import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;

public class ClassGroupMapper
{
	private final ClassGroup one, two;
	private final Map<ClassFile, ClassFile> map = new HashMap<>();

	public ClassGroupMapper(ClassGroup one, ClassGroup two)
	{
		this.one = one;
		this.two = two;
	}
	
	public void map()
	{
		for (ClassFile cf1 : one.getClasses())
			for (ClassFile cf2 : two.getClasses())
			{
				if (!MappingExecutorUtil.isMaybeEqual(cf1, cf2))
					continue;
				
				ClassMapper m = new ClassMapper(cf1, cf2);
				if (!m.same())
					continue;
				
				map.put(cf1, cf2);
			}
	}

	public Map<ClassFile, ClassFile> getMap()
	{
		return map;
	}
	
	public ClassFile get(ClassFile c)
	{
		return map.get(c);
	}
}
