package net.runelite.mixins;

import java.awt.geom.Area;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSGroundItemPile;

@Mixin(RSGroundItemPile.class)
public abstract class RSGroundItemPileMixin implements RSGroundItemPile
{
	@Inject
	private int itemLayerPlane;

	@Inject
	@Override
	public int getPlane()
	{
		return itemLayerPlane;
	}

	@Inject
	@Override
	public void setPlane(int plane)
	{
		this.itemLayerPlane = plane;
	}

	@Inject
	@Override
	public Area getClickbox()
	{
		throw new UnsupportedOperationException();
	}
}
