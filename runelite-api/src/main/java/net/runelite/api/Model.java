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

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;

public class Model
{
	private final net.runelite.rs.api.Model model;

	public Model(net.runelite.rs.api.Model model)
	{
		this.model = model;
	}

	public List<Vertex> getVertices()
	{
		int[] verticesX = model.getVerticesX();
		int[] verticesY = model.getVerticesY();
		int[] verticesZ = model.getVerticesZ();

		assert verticesX.length == verticesY.length;
		assert verticesY.length == verticesZ.length;

		List<Vertex> vertices = new ArrayList<>();

		for (int i = 0; i < verticesX.length; ++i)
		{
			Vertex v = new Vertex(
				verticesX[i],
				verticesY[i],
				verticesZ[i]
			);
			vertices.add(v);
		}

		return vertices;
	}

	public List<Triangle> getTriangles()
	{
		int[] trianglesX = model.getTrianglesX();
		int[] trianglesY = model.getTrianglesY();
		int[] trianglesZ = model.getTrianglesZ();

		assert trianglesX.length == trianglesY.length;
		assert trianglesY.length == trianglesZ.length;

		List<Vertex> vertices = getVertices();
		List<Triangle> triangles = new ArrayList<>(trianglesX.length);

		for (int i = 0; i < trianglesX.length; ++i)
		{
			int triangleX = trianglesX[i];
			int triangleY = trianglesY[i];
			int triangleZ = trianglesZ[i];

			Triangle triangle = new Triangle(
				vertices.get(triangleX),
				vertices.get(triangleY),
				vertices.get(triangleZ)
			);
			triangles.add(triangle);
		}

		return triangles;
	}
}
