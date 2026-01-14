/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu;

import java.nio.IntBuffer;
import java.util.Arrays;
import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.Projection;

class FacePrioritySorter
{
	static final int[] distances;
	static final char[] zsortHead, zsortTail, zsortNext;

	private static final float[] modelProjectedX;
	private static final float[] modelProjectedY;

	static final float[] modelLocalX;
	static final float[] modelLocalY;
	static final float[] modelLocalZ;

	static final int[] numOfPriority;
	private static final int[] eq10;
	private static final int[] eq11;
	private static final int[] lt10;
	static final int[][] orderedFaces;

	private static final int[] vertexBuffer;

	static final int MAX_VERTEX_COUNT = 6500;
	static final int MAX_FACE_COUNT = 8192; // was 6500
	static final int MAX_DIAMETER = 6000;
	private static final int MAX_FACES_PER_PRIORITY = 4000; // was 2500
	private static final int FACE_SIZE = (VAO.VERT_SIZE >> 2) * 3;

	static
	{
		distances = new int[MAX_VERTEX_COUNT];
		zsortHead = new char[MAX_DIAMETER];
		zsortTail = new char[MAX_DIAMETER];
		zsortNext = new char[MAX_FACE_COUNT];

		modelProjectedX = new float[MAX_VERTEX_COUNT];
		modelProjectedY = new float[MAX_VERTEX_COUNT];

		modelLocalX = new float[MAX_VERTEX_COUNT];
		modelLocalY = new float[MAX_VERTEX_COUNT];
		modelLocalZ = new float[MAX_VERTEX_COUNT];

		numOfPriority = new int[12];
		eq10 = new int[MAX_FACES_PER_PRIORITY];
		eq11 = new int[MAX_FACES_PER_PRIORITY];
		lt10 = new int[12];
		orderedFaces = new int[12][MAX_FACES_PER_PRIORITY];

		vertexBuffer = new int[MAX_FACE_COUNT * FACE_SIZE];
	}

	private final SceneUploader sceneUploader;

	FacePrioritySorter(SceneUploader sceneUploader)
	{
		this.sceneUploader = sceneUploader;
	}

	int uploadSortedModel(Projection proj, Model model, int orientation, int x, int y, int z, IntBuffer opaqueBuffer, IntBuffer alphaBuffer)
	{
		final int vertexCount = model.getVerticesCount();
		final float[] verticesX = model.getVerticesX();
		final float[] verticesY = model.getVerticesY();
		final float[] verticesZ = model.getVerticesZ();

		final int faceCount = Math.min(model.getFaceCount(), MAX_FACE_COUNT);
		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] faceColors1 = model.getFaceColors1();
		final int[] faceColors2 = model.getFaceColors2();
		final int[] faceColors3 = model.getFaceColors3();
		final byte[] faceRenderPriorities = model.getFaceRenderPriorities();

		final short[] faceTextures = model.getFaceTextures();

		final byte[] transparencies = model.getFaceTransparencies();
		final byte[] bias = model.getFaceBias();

		float orientSine = 0;
		float orientCosine = 0;
		if (orientation != 0)
		{
			orientSine = Perspective.SINE[orientation] / 65536f;
			orientCosine = Perspective.COSINE[orientation] / 65536f;
		}

		float[] p = proj.project(x, y, z);
		int zero = (int) p[2];

		for (int v = 0; v < vertexCount; ++v)
		{
			float vertexX = verticesX[v];
			float vertexY = verticesY[v];
			float vertexZ = verticesZ[v];

			if (orientation != 0)
			{
				float x0 = vertexX;
				vertexX = vertexZ * orientSine + x0 * orientCosine;
				vertexZ = vertexZ * orientCosine - x0 * orientSine;
			}

			// move to local position
			vertexX += x;
			vertexY += y;
			vertexZ += z;

			modelLocalX[v] = vertexX;
			modelLocalY[v] = vertexY;
			modelLocalZ[v] = vertexZ;

			p = proj.project(vertexX, vertexY, vertexZ);
			if (p[2] < 50)
			{
				return 0;
			}

			modelProjectedX[v] = p[0] / p[2];
			modelProjectedY[v] = p[1] / p[2];
			distances[v] = (int) p[2] - zero;
		}

		final int diameter = model.getDiameter();
		final int radius = model.getRadius();
		if (diameter >= MAX_DIAMETER)
		{
			return 0;
		}

		Arrays.fill(zsortHead, 0, diameter, (char) -1);
		Arrays.fill(zsortTail, 0, diameter, (char) -1);

		int minFz = diameter, maxFz = 0;
		for (char faceIdx = 0; faceIdx < faceCount; ++faceIdx)
		{
			if (faceColors3[faceIdx] != -2)
			{
				final int v1 = indices1[faceIdx];
				final int v2 = indices2[faceIdx];
				final int v3 = indices3[faceIdx];

				final float
					aX = modelProjectedX[v1],
					aY = modelProjectedY[v1],
					bX = modelProjectedX[v2],
					bY = modelProjectedY[v2],
					cX = modelProjectedX[v3],
					cY = modelProjectedY[v3];

				if ((aX - bX) * (cY - bY) - (cX - bX) * (aY - bY) > 0)
				{
					int distance = radius + (distances[v1] + distances[v2] + distances[v3]) / 3;
					assert distance >= 0 && distance < diameter;

					if (zsortTail[distance] == (char) -1)
					{
						zsortHead[distance] = zsortTail[distance] = faceIdx;
						zsortNext[faceIdx] = (char) -1;
					}
					else
					{
						char lastFace = zsortTail[distance];
						zsortNext[lastFace] = faceIdx;
						zsortNext[faceIdx] = (char) -1;
						zsortTail[distance] = faceIdx;
					}

					minFz = Math.min(minFz, distance);
					maxFz = Math.max(maxFz, distance);

					sceneUploader.computeFaceUvs(model, faceIdx);

					int su0 = (int) (sceneUploader.u0 * 256f);
					int sv0 = (int) (sceneUploader.v0 * 256f);

					int su1 = (int) (sceneUploader.u1 * 256f);
					int sv1 = (int) (sceneUploader.v1 * 256f);

					int su2 = (int) (sceneUploader.u2 * 256f);
					int sv2 = (int) (sceneUploader.v2 * 256f);

					int color1 = faceColors1[faceIdx];
					int color2 = faceColors2[faceIdx];
					int color3 = faceColors3[faceIdx];

					if (color3 == -1)
					{
						color2 = color3 = color1;
					}

					// HSL override is not applied to textured faces
					if (faceTextures == null || faceTextures[faceIdx] == -1)
					{
						if (model.getOverrideAmount() > 0)
						{
							color1 = SceneUploader.interpolateHSL(color1, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
							color2 = SceneUploader.interpolateHSL(color2, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
							color3 = SceneUploader.interpolateHSL(color3, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
						}
					}

					int alphaBias = 0;
					alphaBias |= transparencies != null ? (transparencies[faceIdx] & 0xff) << 24 : 0;
					alphaBias |= bias != null ? (bias[faceIdx] & 0xff) << 16 : 0;
					int texture = faceTextures != null ? faceTextures[faceIdx] + 1 : 0;

					int vbOff = faceIdx * FACE_SIZE;
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalX[v1]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalY[v1]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalZ[v1]);
					vertexBuffer[vbOff++] = alphaBias | color1;
					vertexBuffer[vbOff++] = ((su0 & 0xffff) << 16 | (texture & 0xffff));
					vertexBuffer[vbOff++] = sv0 & 0xffff;

					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalX[v2]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalY[v2]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalZ[v2]);
					vertexBuffer[vbOff++] = alphaBias | color2;
					vertexBuffer[vbOff++] = ((su1 & 0xffff) << 16 | (texture & 0xffff));
					vertexBuffer[vbOff++] = sv1 & 0xffff;

					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalX[v3]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalY[v3]);
					vertexBuffer[vbOff++] = Float.floatToIntBits(modelLocalZ[v3]);
					vertexBuffer[vbOff++] = alphaBias | color3;
					vertexBuffer[vbOff++] = ((su2 & 0xffff) << 16 | (texture & 0xffff));
					vertexBuffer[vbOff++] = sv2 & 0xffff;
				}
			}
		}

		int len = 0;
		if (faceRenderPriorities == null)
		{
			for (int i = maxFz; i >= minFz; --i)
			{
				for (char face = zsortHead[i]; face != (char) -1; face = zsortNext[face])
				{
					var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);
				}
			}
		}
		else
		{
			Arrays.fill(numOfPriority, 0);
			Arrays.fill(lt10, 0);

			for (int i = maxFz; i >= minFz; --i)
			{
				for (char face = zsortHead[i]; face != (char) -1; face = zsortNext[face])
				{
					final byte pri = faceRenderPriorities[face];
					final int distIdx = numOfPriority[pri]++;

					orderedFaces[pri][distIdx] = face;
					if (pri < 10)
					{
						lt10[pri] += i;
					}
					else if (pri == 10)
					{
						eq10[distIdx] = i;
					}
					else
					{
						eq11[distIdx] = i;
					}
				}
			}

			int avg12 = 0;
			if (numOfPriority[1] > 0 || numOfPriority[2] > 0)
			{
				avg12 = (lt10[1] + lt10[2]) / (numOfPriority[1] + numOfPriority[2]);
			}

			int avg34 = 0;
			if (numOfPriority[3] > 0 || numOfPriority[4] > 0)
			{
				avg34 = (lt10[3] + lt10[4]) / (numOfPriority[3] + numOfPriority[4]);
			}

			int avg68 = 0;
			if (numOfPriority[6] > 0 || numOfPriority[8] > 0)
			{
				avg68 = (lt10[8] + lt10[6]) / (numOfPriority[8] + numOfPriority[6]);
			}

			int drawnFaces = 0;
			int numDynFaces = numOfPriority[10];
			int[] dynFaces = orderedFaces[10];
			int[] dynFaceDistances = eq10;
			if (drawnFaces == numDynFaces)
			{
				drawnFaces = 0;
				numDynFaces = numOfPriority[11];
				dynFaces = orderedFaces[11];
				dynFaceDistances = eq11;
			}

			int currFaceDistance;
			if (drawnFaces < numDynFaces)
			{
				currFaceDistance = dynFaceDistances[drawnFaces];
			}
			else
			{
				currFaceDistance = -1000;
			}

			for (int pri = 0; pri < 10; ++pri)
			{
				while (pri == 0 && currFaceDistance > avg12)
				{
					final int face = dynFaces[drawnFaces++];
					var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				while (pri == 3 && currFaceDistance > avg34)
				{
					final int face = dynFaces[drawnFaces++];
					var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				while (pri == 5 && currFaceDistance > avg68)
				{
					final int face = dynFaces[drawnFaces++];
					var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);

					if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
					{
						drawnFaces = 0;
						numDynFaces = numOfPriority[11];
						dynFaces = orderedFaces[11];
						dynFaceDistances = eq11;
					}

					if (drawnFaces < numDynFaces)
					{
						currFaceDistance = dynFaceDistances[drawnFaces];
					}
					else
					{
						currFaceDistance = -1000;
					}
				}

				final int priNum = numOfPriority[pri];
				final int[] priFaces = orderedFaces[pri];

				for (int faceIdx = 0; faceIdx < priNum; ++faceIdx)
				{
					final int face = priFaces[faceIdx];
					var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);
				}
			}

			while (currFaceDistance != -1000)
			{
				final int face = dynFaces[drawnFaces++];
				var b = transparencies != null && transparencies[face] != 0 ? alphaBuffer : opaqueBuffer;
				b.put(vertexBuffer, face * FACE_SIZE, FACE_SIZE);

				if (drawnFaces == numDynFaces && dynFaces != orderedFaces[11])
				{
					drawnFaces = 0;
					dynFaces = orderedFaces[11];
					numDynFaces = numOfPriority[11];
					dynFaceDistances = eq11;
				}

				if (drawnFaces < numDynFaces)
				{
					currFaceDistance = dynFaceDistances[drawnFaces];
				}
				else
				{
					currFaceDistance = -1000;
				}
			}
		}

		return len;
	}
}
