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
import net.runelite.rs.api.Model;

public class Player extends Actor
{
	private Client client;
	private net.runelite.rs.api.Player player;

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

	public Model getModel()
	{
		return player.getModel();
	}

	public Polygon[] getPolygons()
	{
		List<Polygon> polys = new ArrayList<>();
		Model model = getModel();
		int localX = player.getX();
		int localY = player.getY();

		// models are orientated north (1024) and there are 2048 angles total
		int orientation = (player.getOrientation() + 1024) % 2048;

		if (model == null)
		{
			return null;
		}

		int[] verticesX = model.getVerticesX().clone();
		int[] verticesY = model.getVerticesY();
		int[] verticesZ = model.getVerticesZ().clone();

		int[] trianglesX = model.getTrianglesX();
		int[] trianglesY = model.getTrianglesY();
		int[] trianglesZ = model.getTrianglesZ();

		if (orientation != 0)
		{
			setOrientation(model, orientation, verticesX, verticesZ);
		}

		for (int i = 0; i < trianglesX.length; i++)
		{
			Point x = Perspective.worldToCanvas(client, localX - verticesX[trianglesX[i]], localY - verticesZ[trianglesX[i]], -verticesY[trianglesX[i]]);
			Point y = Perspective.worldToCanvas(client, localX - verticesX[trianglesY[i]], localY - verticesZ[trianglesY[i]], -verticesY[trianglesY[i]]);
			Point z = Perspective.worldToCanvas(client, localX - verticesX[trianglesZ[i]], localY - verticesZ[trianglesZ[i]], -verticesY[trianglesZ[i]]);

			int xx[] = {
					x.getX(), y.getX(), z.getX()
			};
			int yy[] = {
					x.getY(), y.getY(), z.getY()
			};
			polys.add(new Polygon(xx, yy, 3));
		}

		return polys.toArray(new Polygon[polys.size()]);
	}

	private void setOrientation(Model model, int orientation, int[] verticesX, int[] verticesZ)
	{
		int sin = Perspective.SINE[orientation];
		int cos = Perspective.COSINE[orientation];

		int[] originalX = model.getVerticesX();
		int[] originalZ = model.getVerticesZ();

		for (int i = 0; i < originalX.length; ++i)
		{
			verticesX[i] = originalX[i] * cos + originalZ[i] * sin >> 16;
			verticesZ[i] = originalZ[i] * cos - originalX[i] * sin >> 16;
		}
	}
}
