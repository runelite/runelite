package net.runelite.deob.deobfuscators.rename;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelExecutorMapping
{
	private Map<Object, Object> map = new HashMap<>();
	private List<Object> order = new ArrayList<>();
	
	public void map(Object one, Object two)
	{
		assert !map.containsKey(one) || map.get(one) == two;
		
		if (map.containsKey(one))
			return;
		
		map.put(one, two);
		order.add(one);
	}
	
	public Object get(Object o)
	{
		return map.get(o);
	}
	
	public Map<Object, Object> getMap()
	{
		return map;
	}
	
	public List<Object> getOrder() { return order; }
}
