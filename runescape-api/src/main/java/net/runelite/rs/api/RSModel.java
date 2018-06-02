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
package net.runelite.rs.api;

import java.awt.Polygon;
import net.runelite.api.Model;
import net.runelite.mapping.Import;

public interface RSModel extends RSRenderable, Model
{
	@Import("verticesCount")
	int getVerticesCount();

	@Import("verticesX")
	int[] getVerticesX();

	@Import("verticesY")
	int[] getVerticesY();

	@Import("verticesZ")
	int[] getVerticesZ();

	@Import("indicesCount")
	int getTrianglesCount();

	@Import("indices1")
	int[] getTrianglesX();

	@Import("indices2")
	int[] getTrianglesY();

	@Import("indices3")
	int[] getTrianglesZ();

	@Import("vertexGroups")
	int[][] getVertexGroups();

	@Import("animate")
	void animate(int type, int[] list, int x, int y, int z);

	@Import("resetBounds")
	void resetBounds();

	@Import("toSharedModel")
	RSModel toSharedModel(boolean b);

	@Import("toSharedSpotAnimModel")
	RSModel toSharedSpotAnimModel(boolean b);

	@Import("rotateY90Ccw")
	void rotateY90Ccw();

	@Import("rotateY180Ccw")
	void rotateY180Ccw();

	@Import("rotateY270Ccw")
	void rotateY270Ccw();

	void interpolateFrames(RSFrames frames, int frameId, RSFrames nextFrames, int nextFrameId, int interval,
								int intervalCount);

	/**
	 * Compute the convex hull of this model
	 * @param localX
	 * @param localY
	 * @param orientation
	 * @return
	 */
	Polygon getConvexHull(int localX, int localY, int orientation);
}
