package net.runelite.mixins;

import api.Model;
import api.Perspective;
import api.Renderable;
import java.awt.geom.Area;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSBoundaryObject;
import rs.api.RSClient;

@Mixin(RSBoundaryObject.class)
public abstract class RSBoundaryObjectMixin implements RSBoundaryObject
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int wallPlane;

	@Inject
	@Override
	public int getPlane()
	{
		return wallPlane;
	}

	@Inject
	@Override
	public void setPlane(int plane)
	{
		this.wallPlane = plane;
	}

	@Inject
	private Model getModelA()
	{
		Renderable renderable = getRenderable1();
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
	private Model getModelB()
	{
		Renderable renderable = getRenderable2();
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
		Area clickbox = new Area();

		Area clickboxA = Perspective.getClickbox(client, getModelA(), 0, getLocalLocation());
		Area clickboxB = Perspective.getClickbox(client, getModelB(), 0, getLocalLocation());

		if (clickboxA == null && clickboxB == null)
		{
			return null;
		}

		if (clickboxA != null)
		{
			clickbox.add(clickboxA);
		}

		if (clickboxB != null)
		{
			clickbox.add(clickboxB);
		}

		return clickbox;
	}
}
