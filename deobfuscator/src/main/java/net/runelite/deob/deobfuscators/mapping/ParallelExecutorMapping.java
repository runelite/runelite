/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.deob.deobfuscators.mapping;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParallelExecutorMapping
{
	private static final Logger logger = LoggerFactory.getLogger(ParallelExecutorMapping.class);

	private ClassGroup group, group2;
	private Multimap<Object, Mapping> map = HashMultimap.create();
	public Method m1, m2;
	public boolean crashed;
	public int same;

	public ParallelExecutorMapping(ClassGroup group, ClassGroup group2)
	{
		this.group = group;
		this.group2 = group2;
		assert group != group2;
	}

	@Override
	public String toString()
	{
		return "ParallelExecutorMapping{size = " + map.keySet().size() + ", crashed = " + crashed + ", same = " + same + ", m1 = " + m1 + ", m2 = " + m2 + "}";
	}

	private Mapping getMapping(Object from, Object to)
	{
		for (Mapping m : map.get(from))
		{
			if (m.getObject() == to)
			{
				return m;
			}
		}

		Mapping m = new Mapping(from, to);
		map.put(from, m);
		return m;
	}

	private Object highest(Object from)
	{
		Mapping highest = null;
		for (Mapping m : map.get(from))
		{
			if (highest == null || m.getCount() > highest.getCount())
			{
				highest = m;
			}
			else if (m.getCount() == highest.getCount() && getName(from).compareTo(getName(highest.getObject())) > 0)
			{
				highest = m;
			}
		}
		return highest != null ? highest.getObject() : null;
	}

	public void merge(ParallelExecutorMapping other)
	{
		assert this != other;

		for (Entry<Object, Mapping> e : other.map.entries())
		{
			Object o = e.getKey();
			Mapping v = e.getValue();

			Mapping m = this.getMapping(o, v.getObject());
			m.merge(v);
		}
	}

	public Mapping map(Instruction mapper, Object one, Object two)
	{
		Mapping m = getMapping(one, two);

		if (mapper != null)
		{
			m.addInstruction(mapper);
		}

		belongs(one, group);
		belongs(two, group2);

		sanityCheck(one, two);

		m.inc();

		return m;
	}

	private void sanityCheck(Object one, Object two)
	{
		if (one instanceof Field && two instanceof Field)
		{
			Field f1 = (Field) one;
			Field f2 = (Field) two;

			assert f1.isStatic() == f2.isStatic() : "field map with static mismatch!";
		}
	}

	private void mapClass(StaticInitializerIndexer staticIndexer1, StaticInitializerIndexer staticIndexer2, Object one, Object two)
	{
		ClassFile cf1, cf2;

		if (one instanceof Field || two instanceof Field)
		{
			assert one instanceof Field;
			assert two instanceof Field;

			Field f1 = (Field) one;
			Field f2 = (Field) two;

			assert f1.isStatic() == f2.isStatic();

			if (staticIndexer1.isStatic(f1) && staticIndexer2.isStatic(f2))
			{
				logger.debug("Mapping class of {} -> {} due to static initializer", f1, f2);
			}
			else if (f1.isStatic() || f2.isStatic())
			{
				return;
			}

			cf1 = f1.getClassFile();
			cf2 = f2.getClassFile();
		}
		else if (one instanceof Method || two instanceof Method)
		{
			assert one instanceof Method;
			assert two instanceof Method;

			Method m1 = (Method) one;
			Method m2 = (Method) two;

			assert m1.isStatic() == m1.isStatic();

			if (m1.isStatic() || m2.isStatic())
			{
				return;
			}

			cf1 = m1.getClassFile();
			cf2 = m2.getClassFile();
		}
		else
		{
			assert false;
			return;
		}

		belongs(cf1, group);
		belongs(cf2, group2);

		Mapping m = getMapping(cf1, cf2);

		m.inc();
	}

	/**
	 * makes the map one to one based on the weight of each mapping. If a
	 * mapping is mapped from the same object multiple places, the highest
	 * is used, and the other mappings are not considered when deducing the
	 * mappings of the other objects.
	 */
	public void reduce()
	{
		List<Mapping> sorted = new ArrayList<>(map.values());

		// Sort indepdent of the map's order, which is undefined
		Collections.sort(sorted, (m1, m2) ->
		{

			// Number of times mapped
			int i = Integer.compare(m1.getCount(), m2.getCount());
			if (i != 0)
			{
				return i;
			}

			if (m1.weight != m2.weight)
			{
				// If equal, number of ins equal in the mapping
				return Integer.compare(m1.weight, m2.weight);
			}

			logger.debug("Count and weight for {} <-> {} are the same! Sorting from name", m1, m2);

			return getName(m1.getFrom()).compareTo(getName(m2.getFrom()));
		});

		// reverse so highest is first
		Collections.reverse(sorted);

		Multimap<Object, Mapping> reducedMap = HashMultimap.create();
		Map<Object, Object> reverse = new HashMap<>();

		for (Mapping m : sorted)
		{
			if (reducedMap.containsKey(m.getFrom()))
			{
				logger.debug("Reduced out mapping {} because of {}", m, reducedMap.get(m.getFrom()).iterator().next());
				continue;
			}

			if (reverse.containsKey(m.getObject()))
			{
				logger.debug("Redudced out mapping {} because of {}", m, reducedMap.get(reverse.get(m.getObject())).iterator().next());
				continue;
			}

			reducedMap.put(m.getFrom(), m);
			reverse.put(m.getObject(), m.getFrom());
		}

		map = reducedMap;
		// map is now one to one
	}

	public void buildClasses()
	{
		for (Object o : new HashSet<>(map.keySet()))
		{
			if (o instanceof ClassFile)
			{
				map.removeAll(o);
			}
		}

		StaticInitializerIndexer staticIndexer1 = new StaticInitializerIndexer(group);
		staticIndexer1.index();

		StaticInitializerIndexer staticIndexer2 = new StaticInitializerIndexer(group2);
		staticIndexer2.index();

		Map<Object, Object> map = getMap();
		for (Object key : map.keySet())
		{
			Object value = map.get(key);

			mapClass(staticIndexer1, staticIndexer2, key, value);
		}

		map = getMap(); // rebuild map now we've inserted classes...
		reduce();

		/* get leftover classes, they usually contain exclusively static
		 * fields and methods so they're hard to pinpoint
		 */
		ClassGroupMapper m = new ClassGroupMapper(group, group2);
		m.map();

		for (ClassFile cf : group.getClasses())
		{
			if (!map.containsKey(cf))
			{
				ClassFile other = m.get(cf);
				if (other == null)
				{
					logger.info("Unable to map class {}", cf);
				}
				else
				{
					// these are both probably very small
					long nonStaticFields = cf.getFields().stream().filter(f -> !f.isStatic()).count(),
						nonStaticMethods = cf.getMethods().stream().filter(m2 -> !m2.isStatic()).count();

					logger.info("Build classes fallback {} -> {}, non static fields: {}, non static methods: {}",
						cf, other, nonStaticFields, nonStaticMethods);

					Mapping ma = getMapping(cf, other);
					ma.inc();
				}
			}
		}
	}

	public Object get(Object o)
	{
		return highest(o);
	}

	public Collection<Mapping> getMappings(Object o)
	{
		return map.get(o);
	}

	public Map<Object, Object> getMap()
	{
		Map<Object, Object> m = new HashMap<>();

		for (Object o : map.keySet())
		{
			m.put(o, highest(o));
		}

		return m;
	}

	private void belongs(Object o, ClassGroup to)
	{
		if (o instanceof Field)
		{
			Field f = (Field) o;
			assert f.getClassFile().getGroup() == to;
		}
		else if (o instanceof Method)
		{
			Method m = (Method) o;
			assert m.getClassFile().getGroup() == to;
		}
		else if (o instanceof ClassFile)
		{
			ClassFile c = (ClassFile) o;
			assert c.getGroup() == to;
		}
		else
		{
			assert false;
		}
	}

	public int contradicts(ParallelExecutorMapping other)
	{
		int count = 0;

		for (Entry<Object, Mapping> e : other.map.entries())
		{
			Object key = e.getKey();
			Mapping value = e.getValue();

			Object highest = highest(key);

			if (highest != null && highest != value.getObject())
			{
				++count;
			}
		}

		return count;
	}

	public boolean hasAnyMultiples()
	{
		for (Object o : map.keySet())
		{
			if (map.get(o).size() > 1)
			{
				return true;
			}
		}
		return false;
	}

	private String getName(Object o)
	{
		if (o instanceof Field)
		{
			Field f = (Field) o;
			return f.getClassFile().getClassName() + "." + f.getName();
		}
		else if (o instanceof Method)
		{
			Method m = (Method) o;
			return m.getClassFile().getClassName() + "." + m.getName();
		}
		else if (o instanceof ClassFile)
		{
			ClassFile c = (ClassFile) o;
			return c.getName();
		}
		else
		{
			assert false;
			return null;
		}
	}
}
