package net.runelite.mixins;

import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Renderable;
import java.awt.geom.Area;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFloorDecoration;

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
	private Model getModel()
	{
		Renderable renderable = getRenderable();
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
	public Area getClickbox()
	{
		return Perspective.getClickbox(client, getModel(), 0, getLocalLocation());
	}
}
