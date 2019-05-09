package net.runelite.client.plugins.freezetimers;

import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;

@Slf4j
@Singleton
public class PrayerTracker
{

	@Inject
	private Client client;

	private HashMap<Actor, HashMap<String, Integer>> lastTick = new HashMap<>();
	private HashMap<Actor, HashMap<String, Integer>> newTick = new HashMap<>();

	public void gameTick()
	{
		lastTick.clear();
		lastTick.putAll(newTick);
		newTick.clear();
		for (Player p : client.getPlayers())
		{
			processActor(p);
		}
		for (NPC npc : client.getNpcs())
		{
			processActor(npc);
		}
	}

	private void processActor(Actor actor)
	{
		if (!newTick.containsKey(actor))
		{
			newTick.put(actor, new HashMap<>());
		}
		if (actor instanceof Player)
		{
			if (actor instanceof Player)
			{
				newTick.get(actor).put("PrayerIcon", ((Player) actor).getOverheadIcon() == null ? -1 : ((Player) actor).getOverheadIcon().ordinal());
			}
		}
		newTick.get(actor).put("SpotAnim", actor.getGraphic());
	}

	public int getPrayerIconLastTick(Actor p)
	{
		return lastTick.getOrDefault(p, new HashMap<>()).getOrDefault("PrayerIcon", -1337);
	}

	public int getSpotanimLastTick(Actor p)
	{
		return lastTick.getOrDefault(p, new HashMap<>()).getOrDefault("SpotAnim", -1337);
	}

}
