/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Vertex;

/**
 *
 * @author Adam
 */
public class GameObject extends TileObject
{
	private final net.runelite.rs.api.GameObject gameObject;

	public GameObject(Client client, net.runelite.rs.api.GameObject gameObject)
	{
		super(client);
		this.gameObject = gameObject;
	}

	@Override
	protected int getHash()
	{
		return gameObject.getHash();
	}

	@Override
	protected int getLocalX()
	{
		return gameObject.getX();
	}

	@Override
	protected int getLocalY()
	{
		return gameObject.getY();
	}

	public Renderable getRenderable()
	{
		return Renderable.of(gameObject.getRenderable());
	}

	public Polygon getConvexHull()
	{
		Renderable renderable = getRenderable();
		if (renderable == null)
		{
			return null;
		}

		Model model;

		if (renderable instanceof Model)
		{
			model = (Model) renderable;
		}
		else
		{
			model = renderable.getModel();
		}

		if (model == null)
		{
			return null;
		}

		int localX = gameObject.getX();
		int localY = gameObject.getY();

		// models are orientated north (1024) and there are 2048 angles total
		int orientation = (gameObject.getOrientation() + 1024) % 2048;

		List<Vertex> verticies = model.getVertices();

		if (orientation != 0)
		{
			// rotate verticies
			for (int i = 0; i < verticies.size(); ++i)
			{
				Vertex v = verticies.get(i);
				verticies.set(i, v.rotate(orientation));
			}
		}

		List<Point> points = new ArrayList<>();

		for (Vertex v : verticies)
		{
			// Compute canvas location of vertex
			Point p = Perspective.worldToCanvas(client,
				localX - v.getX(),
				localY - v.getZ(),
				-v.getY());
			if (p != null)
			{
				points.add(p);
			}
		}

		// Run Jarvis march algorithm
		points = Jarvis.convexHull(points);
		if (points == null)
		{
			return null;
		}

		// Convert to a polygon
		Polygon p = new Polygon();
		for (Point point : points)
		{
			p.addPoint(point.getX(), point.getY());
		}
		return p;
	}
}
