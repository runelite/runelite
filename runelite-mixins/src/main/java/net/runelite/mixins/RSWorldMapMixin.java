package net.runelite.mixins;

import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSWorldMap;
import net.runelite.rs.api.RSWorldMapManager;

@Mixin(RSWorldMap.class)
public abstract class RSWorldMapMixin implements RSWorldMap
{
	@Override
	@Inject
	public Point getWorldMapPosition()
	{
		RSWorldMapManager worldMapManager = getWorldMapManager();
		int worldX = getWorldMapX() + worldMapManager.getSurfaceOffsetX();
		int worldY = getWorldMapY() + worldMapManager.getSurfaceOffsetY();
		return new Point(worldX, worldY);
	}

	@Inject
	public void setWorldMapPositionTarget(WorldPoint worldPoint)
	{
		setWorldMapPositionTarget(worldPoint.getX(), worldPoint.getY());
	}

}
