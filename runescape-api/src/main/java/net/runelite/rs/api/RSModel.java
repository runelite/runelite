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

import net.runelite.api.Model;
import java.awt.Polygon;
import net.runelite.mapping.Import;

public interface RSModel extends RSEntity, Model
{
	@Import("verticesCount")
	@Override
	int getVerticesCount();

	@Import("verticesX")
	@Override
	int[] getVerticesX();

	@Import("verticesY")
	@Override
	int[] getVerticesY();

	@Import("verticesZ")
	@Override
	int[] getVerticesZ();

	@Import("indicesCount")
	@Override
	int getTrianglesCount();

	@Import("indices1")
	@Override
	int[] getTrianglesX();

	@Import("indices2")
	@Override
	int[] getTrianglesY();

	@Import("indices3")
	@Override
	int[] getTrianglesZ();

	@Import("faceColors1")
	@Override
	int[] getFaceColors1();

	@Import("faceColors2")
	@Override
	int[] getFaceColors2();

	@Import("faceColors3")
	@Override
	int[] getFaceColors3();

	@Import("faceAlphas")
	@Override
	byte[] getTriangleTransparencies();

	@Import("faceRenderPriorities")
	@Override
	byte[] getFaceRenderPriorities();

	@Import("vertexLabels")
	int[][] getVertexGroups();

	@Import("height")
	@Override
	int getModelHeight();

	@Import("transform")
	void animate(int type, int[] list, int x, int y, int z);

	@Import("calculateBoundsCylinder")
	@Override
	void calculateBoundsCylinder();

	@Import("calculateBoundingBox")
	@Override
	void calculateExtreme(int orientation);

	@Import("resetBounds")
	void resetBounds();

	@Import("toSharedSequenceModel")
	RSModel toSharedModel(boolean b);

	@Import("toSharedSpotAnimationModel")
	RSModel toSharedSpotAnimModel(boolean b);

	@Import("rotateY90Ccw")
	void rotateY90Ccw();

	@Import("rotateY180")
	void rotateY180Ccw();

	@Import("rotateY270Ccw")
	void rotateY270Ccw();

	@Import("radius")
	@Override
	int getRadius();

	@Import("xMid")
	@Override
	int getCenterX();

	@Import("yMid")
	@Override
	int getCenterY();

	@Import("zMid")
	@Override
	int getCenterZ();

	@Import("xMidOffset")
	@Override
	int getExtremeX();

	@Import("yMidOffset")
	@Override
	int getExtremeY();

	@Import("zMidOffset")
	@Override
	int getExtremeZ();

	@Import("faceTextures")
	@Override
	short[] getFaceTextures();

	@Import("xzRadius")
	@Override
	int getXYZMag();

	@Import("isSingleTile")
	@Override
	boolean isClickable();

	void interpolateFrames(RSFrames frames, int frameId, RSFrames nextFrames, int nextFrameId, int interval, int intervalCount);

	/**
	 * Compute the convex hull of this model
	 */
	Polygon getConvexHull(int localX, int localY, int orientation, int tileHeight);

	float[][] getFaceTextureUCoordinates();
	void setFaceTextureUCoordinates(float[][] rl$faceTextureUCoordinates);

	float[][] getFaceTextureVCoordinates();
	void setFaceTextureVCoordinates(float[][] rl$faceTextureVCoordinates);
}
