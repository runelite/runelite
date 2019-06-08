package net.runelite.mixins;

import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSWorldMapManager;

@Mixin(RSWorldMapManager.class)
public abstract class RSWorldMapManagerMixin implements RSWorldMapManager
{
	@Shadow("client")
	static RSClient client;

	/*
	 The worldMapZoom is essentially pixels per tile. In most instances
	 getPixelsPerTile returns the same as worldMapZoom.

	 At some map widths when 100% zoomed in the Jagex version of this function
	 returns 7.89 instead of 8.0 (the worldMapZoom at this level).
	 This would cause both the x and y positions of the map to shift
	 slightly when the map was certain widths.

	 This mixin function replaces Jagex calculation with getWorldMapZoom.
	 This small change makes the world map tile sizing predictable.
	 */
	@Replace("getPixelsPerTile")
	@Override
	public float getPixelsPerTile(int graphicsDiff, int worldDiff)
	{
		return client.getRenderOverview().getWorldMapZoom();
	}

}
