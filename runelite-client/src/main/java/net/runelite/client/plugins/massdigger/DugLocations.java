package net.runelite.client.plugins.massdigger;

import java.util.Set;
import lombok.Data;
import net.runelite.api.coords.WorldPoint;

@Data
public class DugLocations
{
	private DigGroup group;
	private Set<WorldPoint> locations;
}
