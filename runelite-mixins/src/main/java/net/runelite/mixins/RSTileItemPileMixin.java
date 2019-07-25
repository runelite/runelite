package net.runelite.mixins;

import java.awt.geom.Area;
import net.runelite.api.Model;
import net.runelite.api.Renderable;
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
		Renderable renderable = getBottom();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof Model)
		{
			return (Model) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}

	@Inject
	@Override
	public Model getModelMiddle()
	{
		Renderable renderable = getMiddle();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof Model)
		{
			return (Model) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}

	@Inject
	@Override
	public Model getModelTop()
	{
		Renderable renderable = getTop();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof Model)
		{
			return (Model) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}
}
