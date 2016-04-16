package net.runelite.deob.deobfuscators.mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public class ExecutionMapper
{
	// method1 maps to one of methods2, find out based on mappings
	
	private Method method1;
	private Collection<Method> methods2;
	private Map<Method, ParallelExecutorMapping> mappings = new HashMap<>();

	public ExecutionMapper(Method method1, Collection<Method> methods2)
	{
		this.method1 = method1;
		this.methods2 = methods2;
	}

	public ParallelExecutorMapping run()
	{
		ParallelExecutorMapping highest = null;

		for (Method m : methods2)
		{
			ParallelExecutorMapping mapping = MappingExecutorUtil.map(method1, m);
			mappings.put(m, mapping);

			if (highest == null || mapping.same > highest.same)
				highest = mapping;
		}

		return highest;
	}
}
