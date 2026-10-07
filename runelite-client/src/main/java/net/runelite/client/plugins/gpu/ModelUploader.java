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

class ModelUploader
{
	final int[] distances;
	final char[] zsortHead, zsortTail, zsortNext;

	private final float[] modelProjectedX;
	private final float[] modelProjectedY;

	private final float[] modelLocalX;
	private final float[] modelLocalY;
	private final float[] modelLocalZ;

	private final int[] numOfPriority;
	private final int[] eq10;
	private final int[] eq11;
	private final int[] lt10;
	private final int[][] orderedFaces;

	private final int[] vertexBuffer;

	private final float[] u, v;

	static final int MAX_VERTEX_COUNT = 6500;
	static final int MAX_FACE_COUNT = 8192; // was 6500
	static final int MAX_DIAMETER = 6000;
	private static final int MAX_FACES_PER_PRIORITY = 4000; // was 2500
	private static final int FACE_SIZE = (VAO.VERT_SIZE >> 2) * 3;

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

		u = new float[3];
		v = new float[3];
	}

	int uploadSortedModel(GpuPlugin.RenderThread rt, Projection proj, Model model, int orientation, int x, int y, int z,
		int cameraX, int cameraY, int cameraZ, IntBuffer opaqueBuffer, IntBuffer alphaBuffer, boolean prioritySort)
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
		final byte modelTransparency = model.getTransparency();
		final byte[] bias = model.getFaceBias();

		float orientSine = 0;
		float orientCosine = 0;
		int modelCameraX = cameraX - x;
		int modelCameraY = cameraY - y;
		int modelCameraZ = cameraZ - z;
		if (orientation != 0)
		{
			orientSine = Perspective.SINEF[orientation];
			orientCosine = Perspective.COSINEF[orientation];

			int inverseOrientation = (2048 - orientation) & 2047;
			int inverseSine = Perspective.SINE[inverseOrientation];
			int inverseCosine = Perspective.COSINE[inverseOrientation];
			int cameraX0 = modelCameraX;
			modelCameraX = modelCameraZ * inverseSine + cameraX0 * inverseCosine >> 16;
			modelCameraZ = modelCameraZ * inverseCosine - cameraX0 * inverseSine >> 16;
		}

		float[] p = proj.project(x, y, z, rt.tmp);
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

			p = proj.project(vertexX, vertexY, vertexZ, rt.tmp);
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
					computeFaceUvs(model, faceIdx, modelCameraX, modelCameraY, modelCameraZ, true, u, v);

					int su0 = (int) (u[0] * 256f);
					int sv0 = (int) (v[0] * 256f);

					int su1 = (int) (u[1] * 256f);
					int sv1 = (int) (v[1] * 256f);

					int su2 = (int) (u[2] * 256f);
					int sv2 = (int) (v[2] * 256f);

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
							color1 = interpolateHSL(color1, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
							color2 = interpolateHSL(color2, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
							color3 = interpolateHSL(color3, model.getOverrideHue(), model.getOverrideSaturation(), model.getOverrideLuminance(), model.getOverrideAmount());
						}
					}

					int alphaBias = 0;
					alphaBias |= faceTransparency(modelTransparency, transparencies != null ? transparencies[faceIdx] & 0xff : 0) << 24;
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
		if (faceRenderPriorities == null || !prioritySort)
		{
			for (int i = maxFz; i >= minFz; --i)
			{
				for (char face = zsortHead[i]; face != (char) -1; face = zsortNext[face])
				{
					int offset = face * FACE_SIZE;
					var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, offset, FACE_SIZE);
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
					int offset = face * FACE_SIZE;
					var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, offset, FACE_SIZE);

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
					int offset = face * FACE_SIZE;
					var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, offset, FACE_SIZE);

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
					int offset = face * FACE_SIZE;
					var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, offset, FACE_SIZE);

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
					int offset = face * FACE_SIZE;
					var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
					b.put(vertexBuffer, offset, FACE_SIZE);
				}
			}

			while (currFaceDistance != -1000)
			{
				final int face = dynFaces[drawnFaces++];
				int offset = face * FACE_SIZE;
				var b = (vertexBuffer[offset + 3] & 0xff000000) != 0 ? alphaBuffer : opaqueBuffer;
				b.put(vertexBuffer, offset, FACE_SIZE);

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

	private static int faceTransparency(byte modelTransparency, int faceTransparency)
	{
		if (modelTransparency == -1)
		{
			return 255;
		}
		int t = modelTransparency & 255;
		if (t > 0 && faceTransparency < 253)
		{
			int a = (253 - faceTransparency) * t >> 8;
			assert (faceTransparency & 255) == faceTransparency;
			return faceTransparency + a;
		}
		return faceTransparency;
	}

	// temp draw
	int uploadTempModel(Model model, int orientation, int x, int y, int z,
		int cameraX, int cameraY, int cameraZ, IntBuffer buffer)
	{
		final int triangleCount = model.getFaceCount();
		final int vertexCount = model.getVerticesCount();

		final float[] verticesX = model.getVerticesX();
		final float[] verticesY = model.getVerticesY();
		final float[] verticesZ = model.getVerticesZ();

		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final int[] color1s = model.getFaceColors1();
		final int[] color2s = model.getFaceColors2();
		final int[] color3s = model.getFaceColors3();

		final byte[] transparencies = model.getFaceTransparencies();

		final short[] faceTextures = model.getFaceTextures();

		final byte[] bias = model.getFaceBias();

		final byte overrideAmount = model.getOverrideAmount();
		final byte overrideHue = model.getOverrideHue();
		final byte overrideSat = model.getOverrideSaturation();
		final byte overrideLum = model.getOverrideLuminance();

		float orientSine = 0;
		float orientCosine = 0;
		int modelCameraX = cameraX - x;
		int modelCameraY = cameraY - y;
		int modelCameraZ = cameraZ - z;
		if (orientation != 0)
		{
			orientSine = Perspective.SINEF[orientation];
			orientCosine = Perspective.COSINEF[orientation];

			int inverseOrientation = (2048 - orientation) & 2047;
			int inverseSine = Perspective.SINE[inverseOrientation];
			int inverseCosine = Perspective.COSINE[inverseOrientation];
			int cameraX0 = modelCameraX;
			modelCameraX = modelCameraZ * inverseSine + cameraX0 * inverseCosine >> 16;
			modelCameraZ = modelCameraZ * inverseCosine - cameraX0 * inverseSine >> 16;
		}

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

			vertexX += x;
			vertexY += y;
			vertexZ += z;

			modelLocalX[v] = vertexX;
			modelLocalY[v] = vertexY;
			modelLocalZ[v] = vertexZ;
		}

		int len = 0;
		for (int face = 0; face < triangleCount; ++face)
		{
			int color1 = color1s[face];
			int color2 = color2s[face];
			int color3 = color3s[face];

			if (color3 == -1)
			{
				color2 = color3 = color1;
			}
			else if (color3 == -2)
			{
				continue;
			}

			// HSL override is not applied to textured faces
			if (faceTextures == null || faceTextures[face] == -1)
			{
				if (overrideAmount > 0)
				{
					color1 = interpolateHSL(color1, overrideHue, overrideSat, overrideLum, overrideAmount);
					color2 = interpolateHSL(color2, overrideHue, overrideSat, overrideLum, overrideAmount);
					color3 = interpolateHSL(color3, overrideHue, overrideSat, overrideLum, overrideAmount);
				}
			}

			int triangleA = indices1[face];
			int triangleB = indices2[face];
			int triangleC = indices3[face];

			float vx1 = modelLocalX[triangleA];
			float vy1 = modelLocalY[triangleA];
			float vz1 = modelLocalZ[triangleA];

			float vx2 = modelLocalX[triangleB];
			float vy2 = modelLocalY[triangleB];
			float vz2 = modelLocalZ[triangleB];

			float vx3 = modelLocalX[triangleC];
			float vy3 = modelLocalY[triangleC];
			float vz3 = modelLocalZ[triangleC];

			computeFaceUvs(model, face, modelCameraX, modelCameraY, modelCameraZ, true, u, v);

			int su0 = (int) (u[0] * 256f);
			int sv0 = (int) (v[0] * 256f);

			int su1 = (int) (u[1] * 256f);
			int sv1 = (int) (v[1] * 256f);

			int su2 = (int) (u[2] * 256f);
			int sv2 = (int) (v[2] * 256f);

			int alphaBias = 0;
			alphaBias |= transparencies != null ? (transparencies[face] & 0xff) << 24 : 0;
			alphaBias |= bias != null ? (bias[face] & 0xff) << 16 : 0;
			int texture = faceTextures != null ? faceTextures[face] + 1 : 0;

			putfff4(buffer, vx1, vy1, vz1, alphaBias | color1);
			put2222(buffer, texture, su0, sv0, 0);

			putfff4(buffer, vx2, vy2, vz2, alphaBias | color2);
			put2222(buffer, texture, su1, sv1, 0);

			putfff4(buffer, vx3, vy3, vz3, alphaBias | color3);
			put2222(buffer, texture, su2, sv2, 0);

			len += 3;
		}

		return len;
	}

	static void put2222(IntBuffer vb, int x, int y, int z, int w)
	{
		vb.put(((y & 0xffff) << 16) | (x & 0xffff));
		vb.put(((w & 0xffff) << 16) | (z & 0xffff));
	}

	static void putfff4(IntBuffer vb, float x, float y, float z, int w)
	{
		vb.put(Float.floatToIntBits(x));
		vb.put(Float.floatToIntBits(y));
		vb.put(Float.floatToIntBits(z));
		vb.put(w);
	}

	private static int interpolateHSL(int hsl, byte hue2, byte sat2, byte lum2, byte lerp)
	{
		int hue = hsl >> 10 & 63;
		int sat = hsl >> 7 & 7;
		int lum = hsl & 127;
		int var9 = lerp & 255;
		if (hue2 != -1)
		{
			hue += var9 * (hue2 - hue) >> 7;
		}

		if (sat2 != -1)
		{
			sat += var9 * (sat2 - sat) >> 7;
		}

		if (lum2 != -1)
		{
			lum += var9 * (lum2 - lum) >> 7;
		}

		return (hue << 10 | sat << 7 | lum) & 65535;
	}

	static void computeFaceUvs(Model model, int face,
		float cameraX, float cameraY, float cameraZ, boolean project, float[] u, float[] v)
	{
		final float[] vertexX = model.getVerticesX();
		final float[] vertexY = model.getVerticesY();
		final float[] vertexZ = model.getVerticesZ();

		final int[] indices1 = model.getFaceIndices1();
		final int[] indices2 = model.getFaceIndices2();
		final int[] indices3 = model.getFaceIndices3();

		final byte[] textureFaces = model.getTextureFaces();
		final int[] texIndices1 = model.getTexIndices1();
		final int[] texIndices2 = model.getTexIndices2();
		final int[] texIndices3 = model.getTexIndices3();

		if (textureFaces != null && textureFaces[face] != -1)
		{
			final int triangleA = indices1[face];
			final int triangleB = indices2[face];
			final int triangleC = indices3[face];

			int tfaceIdx = textureFaces[face] & 0xff;
			int texA = texIndices1[tfaceIdx];
			int texB = texIndices2[tfaceIdx];
			int texC = texIndices3[tfaceIdx];

			// t1 = vertex[texA]
			float t1x = vertexX[texA];
			float t1y = vertexY[texA];
			float t1z = vertexZ[texA];
			// tangent = vertex[texB] - t1
			float tangentX = vertexX[texB] - t1x;
			float tangentY = vertexY[texB] - t1y;
			float tangentZ = vertexZ[texB] - t1z;
			// bitangent = vertex[texC] - t1
			float bitangentX = vertexX[texC] - t1x;
			float bitangentY = vertexY[texC] - t1y;
			float bitangentZ = vertexZ[texC] - t1z;

			// normal = tangent x bitangent
			float normalX = tangentY * bitangentZ - tangentZ * bitangentY;
			float normalY = tangentZ * bitangentX - tangentX * bitangentZ;
			float normalZ = tangentX * bitangentY - tangentY * bitangentX;

			float faceAx = vertexX[triangleA];
			float faceAy = vertexY[triangleA];
			float faceAz = vertexZ[triangleA];
			float faceBx = vertexX[triangleB];
			float faceBy = vertexY[triangleB];
			float faceBz = vertexZ[triangleB];
			float faceCx = vertexX[triangleC];
			float faceCy = vertexY[triangleC];
			float faceCz = vertexZ[triangleC];

			if (project)
			{
				// ray = camera - faceA
				float rayX = cameraX - faceAx;
				float rayY = cameraY - faceAy;
				float rayZ = cameraZ - faceAz;
				// faceA += ray * ((t1 - faceA) ⋅ normal) / (ray ⋅ normal)
				float scale = ((t1x - faceAx) * normalX + (t1y - faceAy) * normalY + (t1z - faceAz) * normalZ) /
					(rayX * normalX + rayY * normalY + rayZ * normalZ);
				faceAx += rayX * scale;
				faceAy += rayY * scale;
				faceAz += rayZ * scale;

				// ray = camera - faceB
				rayX = cameraX - faceBx;
				rayY = cameraY - faceBy;
				rayZ = cameraZ - faceBz;
				// faceB += ray * ((t2 - faceB) ⋅ normal) / (ray ⋅ normal)
				scale = ((vertexX[texB] - faceBx) * normalX + (vertexY[texB] - faceBy) * normalY +
					(vertexZ[texB] - faceBz) * normalZ) /
					(rayX * normalX + rayY * normalY + rayZ * normalZ);
				faceBx += rayX * scale;
				faceBy += rayY * scale;
				faceBz += rayZ * scale;

				// ray = camera - faceC
				rayX = cameraX - faceCx;
				rayY = cameraY - faceCy;
				rayZ = cameraZ - faceCz;
				// faceC += ray * ((t3 - faceC) ⋅ normal) / (ray ⋅ normal)
				scale = ((vertexX[texC] - faceCx) * normalX + (vertexY[texC] - faceCy) * normalY +
					(vertexZ[texC] - faceCz) * normalZ) /
					(rayX * normalX + rayY * normalY + rayZ * normalZ);
				faceCx += rayX * scale;
				faceCy += rayY * scale;
				faceCz += rayZ * scale;
			}

			float relativeAx = faceAx - t1x;
			float relativeAy = faceAy - t1y;
			float relativeAz = faceAz - t1z;
			float relativeBx = faceBx - t1x;
			float relativeBy = faceBy - t1y;
			float relativeBz = faceBz - t1z;
			float relativeCx = faceCx - t1x;
			float relativeCy = faceCy - t1y;
			float relativeCz = faceCz - t1z;

			// uAxis = bitangent x normal
			float uAxisX = bitangentY * normalZ - bitangentZ * normalY;
			float uAxisY = bitangentZ * normalX - bitangentX * normalZ;
			float uAxisZ = bitangentX * normalY - bitangentY * normalX;

			float inverseUDenominator = 1.0F / (uAxisX * tangentX + uAxisY * tangentY + uAxisZ * tangentZ);

			u[0] = (uAxisX * relativeAx + uAxisY * relativeAy + uAxisZ * relativeAz) * inverseUDenominator;
			u[1] = (uAxisX * relativeBx + uAxisY * relativeBy + uAxisZ * relativeBz) * inverseUDenominator;
			u[2] = (uAxisX * relativeCx + uAxisY * relativeCy + uAxisZ * relativeCz) * inverseUDenominator;

			// vAxis = tangent x normal
			float vAxisX = tangentY * normalZ - tangentZ * normalY;
			float vAxisY = tangentZ * normalX - tangentX * normalZ;
			float vAxisZ = tangentX * normalY - tangentY * normalX;

			float inverseVDenominator = 1.0F / (vAxisX * bitangentX + vAxisY * bitangentY + vAxisZ * bitangentZ);

			v[0] = (vAxisX * relativeAx + vAxisY * relativeAy + vAxisZ * relativeAz) * inverseVDenominator;
			v[1] = (vAxisX * relativeBx + vAxisY * relativeBy + vAxisZ * relativeBz) * inverseVDenominator;
			v[2] = (vAxisX * relativeCx + vAxisY * relativeCy + vAxisZ * relativeCz) * inverseVDenominator;
		}
		else
		{
			// Without a texture face, the client assigns tex = triangle, but the resulting
			// calculations can be reduced:
			//
			// t1 = vertex[texA]
			// tangent = vertex[texB] - t1
			// bitangent = vertex[texC] - t1
			//
			// relativeA = 0
			// relativeB = tangent
			// relativeC = bitangent
			//
			// normal = tangent x bitangent
			//
			// uAxis = bitangent x normal
			// u0 = (uAxis . relativeA) / (uAxis . tangent) // 0 because relativeA is 0
			// u1 = (uAxis . relativeB) / (uAxis . tangent) // 1 because relativeB=tangent
			// u2 = (uAxis . relativeC) / (uAxis . tangent) // 0 because uAxis is perpendicular to bitangent/relativeC
			//
			// vAxis = tangent x normal
			// v0 = (vAxis . relativeA) / (vAxis ⋅ bitangent) // 0 because relativeA is 0
			// v1 = (vAxis . relativeB) / (vAxis ⋅ bitangent) // 0 because vAxis is perpendicular to tangent/relativeB
			// v2 = (vAxis . relativeC) / (vAxis ⋅ bitangent) // 1 because relativeC=bitangent

			u[0] = 0f;
			v[0] = 0f;

			u[1] = 1f;
			v[1] = 0f;

			u[2] = 0f;
			v[2] = 1f;
		}
	}
}
