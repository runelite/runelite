package net.runelite.mixins;

import java.awt.Polygon;
import java.awt.Shape;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEntity;
import net.runelite.rs.api.RSFloorDecoration;
import net.runelite.rs.api.RSModel;

@Mixin(RSFloorDecoration.class)
public abstract class RSFloorDecorationMixin implements RSFloorDecoration
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int groundObjectPlane;

	@Inject
	@Override
	public int getPlane()
	{
		return groundObjectPlane;
	}

	@Inject
	@Override
	public void setPlane(int plane)
	{
		this.groundObjectPlane = plane;
	}

	@Inject
	@Override
	public RSModel getModel()
	{
		RSEntity entity = getEntity();
		if (entity == null)
		{
			return null;
		}

		if (entity instanceof Model)
		{
			return (RSModel) entity;
		}
		else
		{
			return entity.getModel();
		}
	}



	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();

		if (model == null)
		{
			return null;
		}

		int tileHeight = Perspective.getTileHeight(client, new LocalPoint(getX(), getY()), client.getPlane());
		return model.getConvexHull(getX(), getY(), 0, tileHeight);
	}

	@Inject
	@Override
	public Shape getClickbox()
	{
		return Perspective.getClickbox(client, getModel(), 0, getLocalLocation());
	}
}
