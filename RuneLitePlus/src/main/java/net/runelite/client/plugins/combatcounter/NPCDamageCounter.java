package net.runelite.client.plugins.combatcounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NPCDamageCounter 
{

	public Map<Integer, List<String>> attackers;

	public List<Integer> damage;

	public NPCDamageCounter()
	{
		this.attackers = new TreeMap<Integer, List<String>>();
		this.damage = new ArrayList<Integer>();
	}
}