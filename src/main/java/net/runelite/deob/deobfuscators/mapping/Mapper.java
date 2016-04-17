package net.runelite.deob.deobfuscators.mapping;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.ParallellMappingExecutor;
import net.runelite.asm.signature.Type;
import net.runelite.deob.deobfuscators.mapping.ExecutionMapper;

public class Mapper
{
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
		
		finalm.buildClasses();

		mapping = finalm;
	}

	private ParallelExecutorMapping mapMethods(ClassGroup one, ClassGroup two)
	{
		MethodSignatureMapper msm = new MethodSignatureMapper();
		msm.map(one, two);

		List<ParallelExecutorMapping> pmes = new ArrayList<>();

		for (Method m : msm.getMap().keySet())
		{
			Collection<Method> methods = msm.getMap().get(m);

			ExecutionMapper em = new ExecutionMapper(m, methods);

			ParallelExecutorMapping mapping = em.run();
			mapping.map(mapping.m1, mapping.m2);

			pmes.add(mapping);
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

			ExecutionMapper em = new ExecutionMapper(m, methods);

			ParallelExecutorMapping mapping = em.run();
			mapping.map(mapping.m1, mapping.m2);

			pmes.add(mapping);
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(one, two);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;
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
