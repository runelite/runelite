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
 * A {@link Model} or {@link ModelData}
 */
public interface Mesh<T extends Mesh<T>>
{
	int getVerticesCount();
	float[] getVerticesX();
	float[] getVerticesY();
	float[] getVerticesZ();

	int getFaceCount();
	int[] getFaceIndices1();
	int[] getFaceIndices2();
	int[] getFaceIndices3();
	byte[] getFaceTransparencies();
	short[] getFaceTextures();

	/**
	 * Rotates this model 90 degrees around the vertical axis.
	 * {@link ModelData#cloneVertices()} should be called before calling this method
	 */
	T rotateY90Ccw();

	/**
	 * Rotates this model 180 degrees around the vertical axis.
	 * {@link ModelData#cloneVertices()} should be called before calling this method
	 */
	T rotateY180Ccw();

	/**
	 * Rotates this model 270 degrees around the vertical axis.
	 * {@link ModelData#cloneVertices()} should be called before calling this method
	 */
	T rotateY270Ccw();

	/**
	 * Offsets this model by the passed amount (1/128ths of a tile).
	 * {@link ModelData#cloneVertices()} should be called before calling this method
	 */
	T translate(int x, int y, int z);

	/**
	 * Resizes this model by the passed amount (1/128ths).
	 * {@link ModelData#cloneVertices()} should be called before calling this method
	 */
	T scale(int x, int y, int z);
}
