package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Annotations;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.execution.ParallellMappingExecutor;
import net.runelite.deob.signature.Type;

public class Mapper
{
	private static final int MAX_CLASSES = 250;
	
	private final ClassGroup source, target;
	private ParallelExecutorMapping mapping;
	
	public Mapper(ClassGroup source, ClassGroup target)
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

		finalm.merge(mapStaticMethods(source, target));
		finalm.merge(mapMethods(source, target));
		finalm.merge(mapPackets(finalm, source, target));

		mapping = finalm;
	}

	private ParallelExecutorMapping mapMethods(ClassGroup one, ClassGroup two)
	{
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		for (int i = -1; i < MAX_CLASSES; ++i)
		{
			ClassFile c1, c2;

			if (i == -1)
			{
				c1 = one.findClass("client");
				c2 = two.findClass("client");
			}
			else
			{
				c1 = one.findClass("class" + i);
				c2 = two.findClass("class" + i);
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
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(one, two);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;
	}
	
	private ParallelExecutorMapping mapStaticMethods(ClassGroup one, ClassGroup two)
	{
		StaticMethodSignatureMapper smsm = new StaticMethodSignatureMapper();
		smsm.map(one, two);
		
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
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(one, two);
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
			else
			{
				all.put(e.getKey(), e.getValue());
			}
		}
	}

	private ParallelExecutorMapping mapPackets(ParallelExecutorMapping pem, ClassGroup group1, ClassGroup group2)
	{
		Method packetMethod = this.findPacketMethod();
		Field packetField = this.findPacketField();

		assert packetMethod != null;
		assert packetField != null;

		Method otherPacketMethod = (Method) pem.get(packetMethod);
		Field otherPacketField = (Field) pem.get(packetField);

		assert otherPacketMethod != null;
		assert otherPacketField != null;

		packetField.packetHandler = true;
		otherPacketField.packetHandler = true;

		ParallelExecutorMapping mappings = MappingExecutorUtil.map(packetMethod, otherPacketMethod);

		System.out.println(mappings.packetHandler1.size() + " vs " + mappings.packetHandler2.size() + " handlers");

		assert mappings.packetHandler1.size() == mappings.packetHandler2.size();

		ParallellMappingExecutor.enable = true;
		ParallelExecutorMapping all = new ParallelExecutorMapping(group1, group2);

		for (int i = 0; i < mappings.packetHandler1.size(); ++i)
		{
			PacketHandler if1 = mappings.packetHandler1.get(i);

			PacketHandler highestHandler = null;
			ParallelExecutorMapping highest = null;
			int maxContradictions = 0;

			for (int j = 0; j < mappings.packetHandler2.size(); ++j)
			{
				PacketHandler if2 = mappings.packetHandler2.get(j);

				Instruction i1 = if1.getFirstInsOfHandler(),
					i2 = if2.getFirstInsOfHandler();

				ParallelExecutorMapping mapping = MappingExecutorUtil.mapFrame(group1, group2, i1, i2);

				if (mapping.getMap().isEmpty())
					continue;

				if (mapping.hasAnyMultiples())
					continue;

				int p = pem.contradicts(mapping);

				if (if1.getPacketId() == 9 && (if2.getPacketId() == 25 || if2.getPacketId() == 187))
				{
					int i444 =6;
					pem.contradicts(mapping);
				}

				//if (highest == null || p < maxContradictions)
				if (highest == null || mapping.getMap().size() > highest.getMap().size())
				{
					if (p == 0 && mapping.crashed == false)
					//if (p == 0)
					//if (!pem.contradicts(mapping))
					{
						highest = mapping;
						highestHandler = if2;
						maxContradictions = p;
					}
				}
			}

			if (highest == null)
			{
				continue;
				//int i44 = 5;
			}
			System.out.println(if1 + " <-> " + highestHandler + " <-> " + highest.getMap().size() + " " + highest.crashed);
			all.merge(highest);
		}

		ParallellMappingExecutor.enable = false;
		return all;
	}


	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/Export;");

	private Field findPacketField()
	{
		for (ClassFile cf : source.getClasses())
		{
			for (Field f : cf.getFields().getFields())
			{
				Annotations an = f.getAttributes().getAnnotations();

				if (an == null || an.find(OBFUSCATED_NAME) == null)
					continue;

				if (an.find(OBFUSCATED_NAME).getElement().getString().equals("packetOpcode"))
					return f;
			}
		}
		return null;
	}

	private Method findPacketMethod()
	{
		for (Method m : source.findClass("client").getMethods().getMethods())
		{
			Annotations an = m.getAttributes().getAnnotations();

			if (an == null || an.find(OBFUSCATED_NAME) == null)
				continue;

			if (an.find(OBFUSCATED_NAME).getElement().getString().equals("packetHandler"))
				return m;
		}

		return null;
	}
}
