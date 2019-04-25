package net.runelite.client.plugins.wildernesslocations;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WildernessLocation;

@PluginDescriptor(
		name = "Wild Locations",
		description = "Indicates the players current location in the wild",
		tags = {"Wildy", "Wilderness Location", "location", "loc", "pvp", "pklite"},
		type = PluginType.PVP
)
public class WildernessLocationsPlugin extends Plugin
{
	
	@Inject
	private Client client;
	
	@Inject
	OverlayManager overlayManager;
	
	@Inject
	private WildernessLocationsOverlay overlay = new WildernessLocationsOverlay(this.client, this);
	
	private final HashMap<WorldArea, String> wildLocs = getLocationMap();
	@Getter
	private boolean renderLocation;
	@Getter
	private String locationString = "";
	private WorldPoint worldPoint = null;
	
	
	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}
	
	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}
	
	@Subscribe
	public void onGameTick(GameTick event)
	{
		renderLocation = client.getVar(Varbits.IN_WILDERNESS) == 1;
		if (renderLocation)
		{
			if (client.getLocalPlayer().getWorldLocation() != worldPoint)
			{
				locationString = location();
				worldPoint = client.getLocalPlayer().getWorldLocation();
			}
		}
		else
		{
			worldPoint = null;
			locationString = "";
		}
	}
	
	
	private String location()
	{
		int dist = 10000;
		String s = "";
		WorldArea closestArea = null;
		for (Map.Entry<WorldArea, String> entry : wildLocs.entrySet())
		{
			WorldArea worldArea = entry.getKey();
			
			if (worldArea.toWorldPointList().contains(client.getLocalPlayer().getWorldLocation()))
			{
				s = entry.getValue();
				return s;
			}
			int distTo = worldArea.distanceTo(client.getLocalPlayer().getWorldLocation());
			if (distTo < dist)
			{
				dist = distTo;
				closestArea = worldArea;
			}
		}
		if (client.getLocalPlayer().getWorldLocation().getY() >
				(Objects.requireNonNull(closestArea).toWorldPoint().getY() + closestArea.getHeight()))
		{
			s = s + "N";
		}
		if (client.getLocalPlayer().getWorldLocation().getY() < closestArea.toWorldPoint().getY())
		{
			s = s + "S";
		}
		if (client.getLocalPlayer().getWorldLocation().getX() < closestArea.toWorldPoint().getX())
		{
			s = s + "W";
		}
		if (client.getLocalPlayer().getWorldLocation().getX() >
				(closestArea.toWorldPoint().getX() + closestArea.getWidth()))
		{
			s = s + "E";
		}
		s = s + " of ";
		s = s + wildLocs.get(closestArea);
		if (s.startsWith(" of "))
		{
			s = s.substring(3);
		}
		return s;
	}
	
	private static HashMap<WorldArea, String> getLocationMap()
	{
		HashMap<WorldArea, String> hashMap = new HashMap<>();
		Arrays.stream(WildernessLocation.values()).forEach(wildernessLocation ->
				hashMap.put(wildernessLocation.getWorldArea(), wildernessLocation.getName()));
		return hashMap;
	}
}
