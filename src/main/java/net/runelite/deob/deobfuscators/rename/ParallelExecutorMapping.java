package net.runelite.deob.deobfuscators.rename;

import java.util.HashMap;
import java.util.Map;

public class ParallelExecutorMapping
{
	private Map<Object, Object> map = new HashMap<>();
	
	public void map(Object one, Object two)
	{
		assert !map.containsKey(one) || map.get(one) == two;
		map.put(one, two);
	}
	
	public Map<Object, Object> getMap()
	{
		return map;
	}
}
