/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;

public class Player extends Actor
{
	private final Client client;
	private final net.runelite.rs.api.Player player;

	public Player(Client client, net.runelite.rs.api.Player player)
	{
		super(client, player);

		this.player = player;
		this.client = client;
	}

	@Override
	public String getName()
	{
		return player.getName().replace('\u00A0', ' ');
	}

	@Override
	public int getCombatLevel()
	{
		return player.getCombatLevel();
	}

	public PlayerComposition getPlayerComposition()
	{
		return new PlayerComposition(player.getComposition());
	}

	public Polygon[] getPolygons()
	{
		Model model = getModel();

		if (model == null)
		{
			return null;
		}

		int localX = player.getX();
		int localY = player.getY();

		// models are orientated north (1024) and there are 2048 angles total
		int orientation = (player.getOrientation() + 1024) % 2048;

		List<Triangle> triangles = model.getTriangles();

		if (orientation != 0)
		{
			triangles = rotate(triangles, orientation);
		}

		List<Polygon> polys = new ArrayList<>();
		for (Triangle triangle : triangles)
		{
			Vertex vx = triangle.getA();
			Vertex vy = triangle.getB();
			Vertex vz = triangle.getC();

			Point x = Perspective.worldToCanvas(client,
				localX - vx.getX(),
				localY - vx.getZ(),
				-vx.getY());

			Point y = Perspective.worldToCanvas(client,
				localX - vy.getX(),
				localY - vy.getZ(),
				-vy.getY());

			Point z = Perspective.worldToCanvas(client,
				localX - vz.getX(),
				localY - vz.getZ(),
				-vz.getY());

			int xx[] =
			{
				x.getX(), y.getX(), z.getX()
			};
			int yy[] =
			{
				x.getY(), y.getY(), z.getY()
			};
			polys.add(new Polygon(xx, yy, 3));
		}

		return polys.toArray(new Polygon[polys.size()]);
	}

	private List<Triangle> rotate(List<Triangle> triangles, int orientation)
	{
		List<Triangle> rotatedTriangles = new ArrayList<>();
		for (Triangle triangle : triangles)
		{
			Vertex a = triangle.getA();
			Vertex b = triangle.getB();
			Vertex c = triangle.getC();

			Triangle rotatedTriangle = new Triangle(
				a.rotate(orientation),
				b.rotate(orientation),
				c.rotate(orientation)
			);
			rotatedTriangles.add(rotatedTriangle);
		}
		return rotatedTriangles;
	}
}
