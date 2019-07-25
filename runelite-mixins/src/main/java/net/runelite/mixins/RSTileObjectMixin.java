package net.runelite.mixins;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Mixins;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSBoundaryObject;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSGameObject;
import net.runelite.rs.api.RSTileItemPile;
import net.runelite.rs.api.RSWallDecoration;

@Mixins({
	@Mixin(RSWallDecoration.class),
	@Mixin(RSGameObject.class),
	@Mixin(RSFloorDecoration.class),
	@Mixin(RSTileItemPile.class),
	@Mixin(RSBoundaryObject.class)
})
public abstract class RSTileObjectMixin implements TileObject
{
	@Shadow("client")
	private static RSClient client;

	@Override
	@Inject
	public int getId()
	{
		long hash = getHash();
		return (int) (hash >>> 17 & 4294967295L);
	}

	@Override
	@Inject
	public WorldPoint getWorldLocation()
	{
		return WorldPoint.fromLocal(client, getX(), getY(), getPlane());
	}

	@Override
	@Inject
	public LocalPoint getLocalLocation()
	{
		return new LocalPoint(getX(), getY());
	}

	@Override
	@Inject
	public Point getCanvasLocation()
	{
		return getCanvasLocation(0);
	}

	@Override
	@Inject
	public Point getCanvasLocation(int zOffset)
	{
		return Perspective.localToCanvas(client, getLocalLocation(), getPlane(), zOffset);
	}

	@Override
	@Inject
	public Polygon getCanvasTilePoly()
	{
		return Perspective.getCanvasTilePoly(client, getLocalLocation());
	}

	@Override
	@Inject
	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	@Override
	@Inject
	public Point getMinimapLocation()
	{
		return Perspective.localToMinimap(client, getLocalLocation());
	}
}
