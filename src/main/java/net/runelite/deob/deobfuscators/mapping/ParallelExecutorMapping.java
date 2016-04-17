package net.runelite.deob.deobfuscators.mapping;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;

public class ParallelExecutorMapping
{
	private ClassGroup group, group2;
	private Multimap<Object, Mapping> map = HashMultimap.create();
	public Method m1, m2;
	public boolean crashed;
	public List<PacketHandler> packetHandler1 = new ArrayList<>();
	public List<PacketHandler> packetHandler2 = new ArrayList<>();
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
		return "ParallelExecutorMapping{size = " + map.size() + ", crashed = " + crashed + "}";
	}

	private Mapping getMapping(Object from, Object to)
	{
		for (Mapping m : map.get(from))
			if (m.getObject() == to)
				return m;

		Mapping m = new Mapping(to);
		map.put(from, m);
		return m;
	}

	private Object highest(Object from)
	{
		Mapping highest = null;
		for (Mapping m : map.get(from))
			if (highest == null || m.getCount() > highest.getCount())
				highest = m;
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
	
	public void map(Object one, Object two)
	{
		Mapping m = getMapping(one, two);
		
		belongs(one, group);
		belongs(two, group2);

		m.inc();
	}

	private void mapClass(Object one, Object two)
	{
		ClassFile cf1, cf2;

		if (one instanceof Field || two instanceof Field)
		{
			assert one instanceof Field;
			assert two instanceof Field;

			Field f1 = (Field) one;
			Field f2 = (Field) two;
			
			assert f1.isStatic() == f2.isStatic();
			
			if (f1.isStatic() || f2.isStatic())
				return;

			cf1 = f1.getFields().getClassFile();
			cf2 = f2.getFields().getClassFile();
		}
		else if (one instanceof Method || two instanceof Method)
		{
			assert one instanceof Method;
			assert two instanceof Method;

			Method m1 = (Method) one;
			Method m2 = (Method) two;
			
			assert m1.isStatic() == m1.isStatic();
			
			if (m1.isStatic() || m2.isStatic())
				return;

			cf1 = m1.getMethods().getClassFile();
			cf2 = m2.getMethods().getClassFile();
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
	
	public void buildClasses()
	{
		for (Object o : new HashSet<>(map.keySet()))
			if (o instanceof ClassFile)
				map.removeAll(o);
		
		Map<Object, Object> map = getMap();
		for (Object key : map.keySet())
		{
			Object value = map.get(key);
			
			mapClass(key, value);
		}
	}
	
	public Object get(Object o)
	{
		return highest(o);
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
			assert f.getFields().getClassFile().getGroup() == to;
		}
		else if (o instanceof Method)
		{
			Method m = (Method) o;
			assert m.getMethods().getClassFile().getGroup() == to;
		}
		else if (o instanceof ClassFile)
		{
			ClassFile c = (ClassFile) o;
			assert c.getGroup() == to;
		}
		else
			assert false;
	}

	public PacketHandler findPacketHandler1(int id)
	{
		for (PacketHandler p : this.packetHandler1)
			if (p.getPacketId() == id)
				return p;
		return null;
	}

	public PacketHandler findPacketHandler2(int id)
	{
		for (PacketHandler p : this.packetHandler2)
			if (p.getPacketId() == id)
				return p;
		return null;
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
				++count;
		}

		return count;
	}

	public boolean hasAnyMultiples()
	{
		for (Object o : map.keySet())
			if (map.get(o).size() > 1)
				return true;
		return false;
	}
}
