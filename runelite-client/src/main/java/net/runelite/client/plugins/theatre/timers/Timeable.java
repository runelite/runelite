package net.runelite.client.plugins.theatre.timers;

import java.util.HashMap;

public interface Timeable
{
	public abstract HashMap<String, Long> getTimes();
}