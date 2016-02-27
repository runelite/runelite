package net.runelite.deob.deobfuscators.rename;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.instructions.If;

public class ParallelExecutorMapping
{
	private ClassGroup group, group2;
	private Map<Object, Object> map = new HashMap<>();
	//private List<Object> order = new ArrayList<>();
	public Method m1, m2;
	public boolean crashed;
	public List<PacketHandler> packetHandler1 = new ArrayList<>();
	public List<PacketHandler> packetHandler2 = new ArrayList<>();
	
	public ParallelExecutorMapping(ClassGroup group, ClassGroup group2)
	{
		this.group = group;
		this.group2 = group2;
		assert group != group2;
	}
	
	public void merge(ParallelExecutorMapping other)
	{
		assert this != other;
		map.putAll(other.map); // is this right?
	}
	
	public void map(Object one, Object two)
	{
		//assert !map.containsKey(one) || map.get(one) == two;
		
		if (map.containsKey(one))
			return;
		
		belongs(one, group);
		belongs(two, group2);
		
		map.put(one, two);
		//order.add(one);
	}
	
	public Object get(Object o)
	{
		return map.get(o);
	}
	
	public Map<Object, Object> getMap()
	{
		return map;
	}
	
	//public List<Object> getOrder() { return order; }
	
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
}
