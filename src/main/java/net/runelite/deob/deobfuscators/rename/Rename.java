package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.Multimap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.util.JarUtil;

public class Rename
{
	private static final int MAX_CLASSES = 250;
	
	private ClassGroup source, target;
	private ParallelExecutorMapping mapping;
	
	public Rename(ClassGroup source, ClassGroup target)
	{
		this.source = source;
		this.target = target;
	}

	public ParallelExecutorMapping getMapping()
	{
		return mapping;
	}
	
	public void run()
	{		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(source, target);
		
		finalm.merge(staticMethodSignatureMapper());
		finalm.merge(methodSignatureMapper());

		for (int i = -1; i < MAX_CLASSES; ++i)
		{
			ClassFile c1;
			
			if (i == -1)
			{
				c1 = source.findClass("client");
			}
			else
			{
				c1 = source.findClass("class" + i);
			}
			
			if (c1 == null)
				continue;
			
			for (Method m : c1.getMethods().getMethods())
			{
				if (!finalm.getMap().containsKey(m))
					System.out.println("missing " + m);
			}
			for (Field m : c1.getFields().getFields())
			{
				if (!finalm.getMap().containsKey(m))
					System.out.println("missing " + m);
			}
		}
		
		mapping = finalm;
	}

	private ParallelExecutorMapping methodSignatureMapper()
	{
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		
		for (int i = -1; i < MAX_CLASSES; ++i)
		{
			ClassFile c1, c2;
			
			if (i == -1)
			{
				c1 = source.findClass("client");
				c2 = target.findClass("client");
			}
			else
			{
				c1 = source.findClass("class" + i);
				c2 = target.findClass("class" + i);
			}
			
			if (c1 == null || c2 == null)
				continue;
			
			MethodSignatureMapper msm = new MethodSignatureMapper();
			msm.map(c1, c2);
			
			Multimap<Method, Method> map = msm.getMap();
			for (Method m : map.keySet())
			{
				Collection<Method> methods = map.get(m);
				
				for (Method other : methods)
				{
					HashMap<Object, Object> all = new HashMap();
					map(all, pmes, m, other);
				}
			}
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(source, target);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;
	}
	
	private ParallelExecutorMapping staticMethodSignatureMapper()
	{
		StaticMethodSignatureMapper smsm = new StaticMethodSignatureMapper();
		smsm.map(source, target);
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		
		for (Method m : smsm.getMap().keySet())
		{
			Collection<Method> methods = smsm.getMap().get(m);
			
			for (Method other : methods)
			{
				HashMap<Object, Object> all = new HashMap();
				map(all, pmes, m, other);
			}
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(source, target);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;		
	}
	
	private void map(Map<Object, Object> all, List<ParallelExecutorMapping> result, Method m1, Method m2)
	{
		if (all.containsKey(m1))
			return;
		all.put(m1, m2);
		
		assert (m1.getCode() == null) == (m2.getCode() == null);
		
		if (m1.getCode() == null)
			return;
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		if (mappings.getMap().isEmpty() && mappings.crashed)
			return;
		
		mappings.map(m1, m2);
		result.add(mappings);
		
		for (Map.Entry<Object, Object> e : mappings.getMap().entrySet())
		{
			if (e.getKey() instanceof Method)
			{
				Method n1 = (Method) e.getKey(),
					n2 = (Method) e.getValue();
				
				map(all, result, n1, n2);
			}
		}
	}
}
