package net.runelite.mixins;

import java.awt.geom.Area;
import net.runelite.api.Entity;
import net.runelite.api.Model;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSTileItemPile;

@Mixin(RSTileItemPile.class)
public abstract class RSTileItemPileMixin implements RSTileItemPile
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

	@Inject
	@Override
	public Model getModelBottom()
	{
		Entity entity = getBottom();
		if (entity == null)
		{
			return null;
		}

		if (entity instanceof Model)
		{
			return (Model) entity;
		}
		else
		{
			return entity.getModel();
		}
	}

	@Inject
	@Override
	public Model getModelMiddle()
	{
		Entity entity = getMiddle();
		if (entity == null)
		{
			return null;
		}

		if (entity instanceof Model)
		{
			return (Model) entity;
		}
		else
		{
			return entity.getModel();
		}
	}

	@Inject
	@Override
	public Model getModelTop()
	{
		Entity entity = getTop();
		if (entity == null)
		{
			return null;
		}

		if (entity instanceof Model)
		{
			return (Model) entity;
		}
		else
		{
			return entity.getModel();
		}
	}
}
