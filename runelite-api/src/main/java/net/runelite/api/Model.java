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

import javax.annotation.Nonnull;

/**
 * Represents the model of an object.
 */
public interface Model extends Mesh<Model>, Renderable
{
	int[] getFaceColors1();

	int[] getFaceColors2();

	int[] getFaceColors3();

	int getSceneId();
	void setSceneId(int sceneId);

	int getBufferOffset();
	void setBufferOffset(int bufferOffset);

	int getUvBufferOffset();
	void setUvBufferOffset(int bufferOffset);

	int getBottomY();

	void calculateBoundsCylinder();

	byte[] getFaceRenderPriorities();

	int getRadius();
	int getDiameter();

	/**
	 * @see #getAABB(int)
	 */
	@Deprecated
	void calculateExtreme(int orientation);

	@Nonnull
	AABB getAABB(int orientation);

	int getXYZMag();
	boolean useBoundingBox();

	int[] getVertexNormalsX();
	int[] getVertexNormalsY();
	int[] getVertexNormalsZ();

	byte getOverrideAmount();
	byte getOverrideHue();
	byte getOverrideSaturation();
	byte getOverrideLuminance();

	byte[] getTextureFaces();

	int[] getTexIndices1();
	int[] getTexIndices2();
	int[] getTexIndices3();

	Model getUnskewedModel();

	void drawFrustum(int zero, int xRotate, int yRotate, int zRotate, int xCamera, int yCamera, int zCamera);
	void drawOrtho(int zero, int xRotate, int yRotate, int zRotate, int xCamera, int yCamera, int zCamera, int zoom);
}
