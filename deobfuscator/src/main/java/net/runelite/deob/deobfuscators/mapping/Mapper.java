/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.deobfuscators.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.execution.ParallellMappingExecutor;
import net.runelite.asm.signature.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapper
{
	private static final Logger logger = LoggerFactory.getLogger(Mapper.class);
	
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

		finalm.merge(mapStaticMethods());
		finalm.merge(mapMethods());
		finalm.merge(mapPackets(finalm));
		
		finalm.reduce();

		// map unexecuted methods
		mapUnexecutedMethods(finalm);
		
		finalm.buildClasses();
		
		mapMemberMethods(finalm);

		new ConstructorMapper(source, target, finalm).mapConstructors();

		mapping = finalm;
	}

	private ParallelExecutorMapping mapMethods()
	{
		MethodSignatureMapper msm = new MethodSignatureMapper();
		msm.map(source, target);

		List<ParallelExecutorMapping> pmes = new ArrayList<>();

		for (Method m : msm.getMap().keySet())
		{
			Collection<Method> methods = msm.getMap().get(m);

			ExecutionMapper em = new ExecutionMapper(m, methods);

			ParallelExecutorMapping mapping = em.run();
			if (mapping == null)
				continue;

			mapping.map(null, mapping.m1, mapping.m2).wasExecuted = true;

			logger.debug("map methods mapped {} -> {}", mapping.m1, mapping.m2);

			pmes.add(mapping);
		}

		ParallelExecutorMapping finalm = new ParallelExecutorMapping(source, target);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;
	}
	
	private ParallelExecutorMapping mapStaticMethods()
	{
		StaticMethodSignatureMapper smsm = new StaticMethodSignatureMapper();
		smsm.map(source, target);
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		
		for (Method m : smsm.getMap().keySet())
		{
			Collection<Method> methods = smsm.getMap().get(m);

			ExecutionMapper em = new ExecutionMapper(m, methods);

			ParallelExecutorMapping mapping = em.run();
			if (mapping == null)
				continue;
			
			mapping.map(null, mapping.m1, mapping.m2).wasExecuted = true;

			logger.debug("map static methods mapped {} -> {}", mapping.m1, mapping.m2);

			pmes.add(mapping);
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(source, target);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;
	}

	private ParallelExecutorMapping mapPackets(ParallelExecutorMapping pem)
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
		ParallelExecutorMapping all = new ParallelExecutorMapping(source, target);

		for (int i = 0; i < mappings.packetHandler1.size(); ++i)
		{
			PacketHandler if1 = mappings.packetHandler1.get(i);

			PacketHandler highestHandler = null;
			ParallelExecutorMapping highest = null;

			for (int j = 0; j < mappings.packetHandler2.size(); ++j)
			{
				PacketHandler if2 = mappings.packetHandler2.get(j);

				Instruction i1 = if1.getFirstInsOfHandler(),
					i2 = if2.getFirstInsOfHandler();

				ParallelExecutorMapping mapping = MappingExecutorUtil.mapFrame(source, target, i1, i2);

				if (mapping.getMap().isEmpty())
					continue;

				if (mapping.hasAnyMultiples())
					continue;

				int p = pem.contradicts(mapping);

				if (highest == null || mapping.getMap().size() > highest.getMap().size())
				{
					if (p == 0 && mapping.crashed == false)
					{
						highest = mapping;
						highestHandler = if2;
					}
				}
			}

			if (highest == null)
			{
				continue;
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
				Annotations an = f.getAnnotations();

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
			Annotations an = m.getAnnotations();

			if (an == null || an.find(OBFUSCATED_NAME) == null)
				continue;

			if (an.find(OBFUSCATED_NAME).getElement().getString().equals("packetHandler"))
				return m;
		}

		return null;
	}
	
	private void mapMemberMethods(ParallelExecutorMapping mapping)
	{
		// pass #2 at method mapping, can use class file mappings learned
		
		for (ClassFile cf : source.getClasses())
		{
			ClassFile other = (ClassFile) mapping.get(cf);
			if (other == null)
				continue;
			
			List<Method> methods1 = cf.getMethods().getMethods().stream()
				.filter(m -> !m.isStatic())
				.filter(m -> !m.getName().equals("<init>"))
				.filter(m -> m.getCode() != null)
				.collect(Collectors.toList());
			
			List<Method> methods2 = other.getMethods().getMethods().stream()
				.filter(m -> !m.isStatic())
				.filter(m -> !m.getName().equals("<init>"))
				.filter(m -> m.getCode() != null)
				.collect(Collectors.toList());
			
			for (Method method : methods1)
			{
				if (mapping.get(method) != null) // already mapped
					continue;
				
				List<Method> possible = methods2.stream()
					.filter(m -> MappingExecutorUtil.isMaybeEqual(m.getDescriptor(), method.getDescriptor()))
					.collect(Collectors.toList());
				
				// Run over execution mapper
				ExecutionMapper em = new ExecutionMapper(method, possible);
				ParallelExecutorMapping map = em.run();
				if (map == null)
					continue;
				
				map.map(null, map.m1, map.m2);
				
				logger.debug("Mapped {} -> {} based on exiting class mapping and method signatures", map.m1, map.m2);
				
				mapping.merge(map);
			}
		}
	}

	private void mapUnexecutedMethods(ParallelExecutorMapping mapping)
	{
		// map has already been reduced
		
		for (Object o : mapping.getMap().keySet())
		{
			Mapping m = mapping.getMappings(o).iterator().next();

			if (m.wasExecuted || !(m.getFrom() instanceof Method))
				continue;

			Method m1 = (Method) m.getFrom(), m2 = (Method) m.getObject();

			if (m1.getCode() == null || m2.getCode() == null)
				continue;

			// m was picked up as an invoke instruction when mapping
			// something else, but wasn't executed itself
			logger.debug("Wasn't executed {}", m);

			ParallelExecutorMapping ma = MappingExecutorUtil.map(m1, m2);
			mapping.merge(ma);
		}
	}
}
