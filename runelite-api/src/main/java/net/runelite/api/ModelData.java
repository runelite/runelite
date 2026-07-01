/*
 * Copyright (c) 2022 Abex
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

/**
 * An unlit model
 */
public interface ModelData extends Mesh<ModelData>, Renderable
{
	int DEFAULT_AMBIENT = 64;
	int DEFAULT_CONTRAST = 768;
	int DEFAULT_X = -50;
	int DEFAULT_Y = -10;
	int DEFAULT_Z = -50;

	/**
	 * Gets colors as Jagex HSL
	 *
	 * @see JagexColor
	 */
	short[] getFaceColors();

	/**
	 * Lights a model.
	 *
	 * The produced model shares verticies, face transparencies, face indicies, and textures with
	 * the underlying ModelData. If any of these may be mutated the corresponding {@code cloneX}
	 * method should be called before {@code light}ing
	 */
	Model light(int ambient, int contrast, int x, int y, int z);

	/**
	 * Lights a model with default values
	 * 
	 * @see #light(int, int, int, int, int)
	 */
	Model light();

	/**
	 * Applies a recolor using Jagex's HSL format. You should call {@link #cloneColors()} ()} before calling
	 * this method
	 */
	ModelData recolor(short colorToReplace, short colorToReplaceWith);

	/**
	 * Applies a retexture, changing texture ids. You should call {@link #cloneTextures()} before calling
	 * this method
	 */
	ModelData retexture(short find, short replace);

	/**
	 * Shallow-copies a model. Does not copy any arrays, which are still shared with this object.
	 */
	ModelData shallowCopy();

	/**
	 * Clones {@link #getVerticesX()}, {@link #getVerticesY()}, and {@link #getVerticesZ()} so
	 * they can be safely mutated
	 */
	ModelData cloneVertices();

	/**
	 * Clones {@link #getFaceColors()} so they can be safely mutated
	 */
	ModelData cloneColors();

	/**
	 * Clones {@link #getFaceTextures()} so they can be safely mutated
	 */
	ModelData cloneTextures();

	/**
	 * Clones {@link #getFaceTransparencies()} so they can be safely mutated
	 */
	ModelData cloneTransparencies();

	/**
	 * Clones {@link #getFaceTransparencies()} so they can be safely mutated
	 *
	 * @param force Ensure {@link #getFaceTransparencies()} is non null
	 */
	ModelData cloneTransparencies(boolean force);
}
