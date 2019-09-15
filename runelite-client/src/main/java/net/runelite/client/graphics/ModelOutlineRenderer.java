/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.graphics;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.Model;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.TileItemPile;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.task.Schedule;

@Singleton
public class ModelOutlineRenderer
{
	/*
	 * This class doesn't really "need" static variables, but they are
	 * static for performance reasons. Arrays are kept outside methods
	 * to avoid frequent big allocations. Arrays should mostly be seen
	 * as ArrayLists. The size of them is increased whenever they need
	 * to become bigger.
	 */

	private final Client client;

	private boolean isReset;
	private boolean usedSinceLastCheck;

	// Dimensions of the underlying image
	private int imageWidth;
	private int imageHeight;

	// Boundaries for the current rasterization
	private int clipX1;
	private int clipY1;
	private int clipX2;
	private int clipY2;

	// Pixel points that would be rendered to
	private int[] visited;
	private int currentVisitedNumber = 0;

	// Transformed vertex positions
	private int[] projectedVerticesX;
	private int[] projectedVerticesY;
	private boolean[] projectedVerticesRenderable;

	// An array of pixel points to raster onto the image. These are checked against
	// clip boundaries and the visited array to prevent drawing on top of the model
	// and outside the scene area. They are grouped per distance to the closest pixel
	// drawn on the model.
	private int[][] outlinePixels;
	private int[] outlinePixelsLengths; // outlinePixelsLength[i] is the used length of outlinePixels[i]
	private int outlineArrayWidth;

	// A list of pixel distances ordered from shortest to longest distance for
	// each outline width. These are calculated once upon first usage and then
	// stored here to prevent reevaluation.
	private List<List<PixelDistanceAlpha>> precomputedDistancePriorities;

	@Inject
	private ModelOutlineRenderer(Client client)
	{
		this.client = client;

		reset();
	}

	@Schedule(period = 5, unit = ChronoUnit.SECONDS)
	public void checkUsage()
	{
		if (!isReset && !usedSinceLastCheck)
		{
			// Reset memory allocated when the rasterizer becomes inactive
			reset();
		}
		usedSinceLastCheck = false;
	}

	/**
	 * Reset memory used by the rasterizer
	 */
	private void reset()
	{
		visited = new int[0];
		projectedVerticesX = new int[0];
		projectedVerticesY = new int[0];
		projectedVerticesRenderable = new boolean[0];
		outlinePixels = new int[0][];
		outlinePixelsLengths = new int[0];
		precomputedDistancePriorities = new ArrayList<>(0);
		isReset = true;
	}

	/**
	 * Calculate the next power of two of a value
	 *
	 * @param value The value to find the next power of two of
	 * @return Returns the next power of two
	 */
	private static int nextPowerOfTwo(int value)
	{
		value--;
		value |= value >> 1;
		value |= value >> 2;
		value |= value >> 4;
		value |= value >> 8;
		value |= value >> 16;
		value++;
		return value;
	}

	/**
	 * Determine if a triangle goes counter clockwise
	 *
	 * @return Returns true if the triangle goes counter clockwise and should be culled, otherwise false
	 */
	private static boolean cullFace(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		return
			(y2 - y1) * (x3 - x2) -
				(x2 - x1) * (y3 - y2) < 0;
	}

	/**
	 * Gets the list of pixel distances ordered by distance from closest pixel for a specific outline width.
	 *
	 * @param outlineWidth The outline width
	 * @return Returns the list of pixel distances
	 */
	private List<PixelDistanceAlpha> getPriorityList(int outlineWidth)
	{
		while (precomputedDistancePriorities.size() <= outlineWidth)
		{
			precomputedDistancePriorities.add(null);
		}

		// Grab the cached outline width if we have one
		if (precomputedDistancePriorities.get(outlineWidth) != null)
		{
			return precomputedDistancePriorities.get(outlineWidth);
		}

		List<PixelDistanceAlpha> ps = new ArrayList<>();
		for (int x = 0; x <= outlineWidth; x++)
		{
			for (int y = 0; y <= outlineWidth; y++)
			{
				if (x == 0 && y == 0)
				{
					continue;
				}

				double dist = Math.sqrt(x * x + y * y);
				if (dist > outlineWidth)
				{
					continue;
				}

				int outerAlpha = outlineWidth == 1 ? 255 // For preventing division by 0
					: (int) (255 * (dist - 1) / (outlineWidth - 1));
				ps.add(new PixelDistanceAlpha(outerAlpha, x + y * outlineArrayWidth));
			}
		}
		ps.sort(Comparator.comparingDouble(PixelDistanceAlpha::getOuterAlpha));
		precomputedDistancePriorities.set(outlineWidth, ps);

		return ps;
	}

	/**
	 * Checks that the size of outlinePixels is big enough to hold a specific
	 * amount of elements. This is used to reduce the amount of if checks needed
	 * when adding elements to outlinePixels.
	 *
	 * @param distArrayPos          The position in the array
	 * @param additionalMinimumSize The additional minimum size required
	 */
	private void ensureMinimumOutlineQueueSize(int distArrayPos, int additionalMinimumSize)
	{
		int minimumSize = outlinePixelsLengths[distArrayPos] + additionalMinimumSize;
		while (outlinePixels[distArrayPos].length < minimumSize)
		{
			int[] newArr = new int[nextPowerOfTwo(minimumSize)];
			System.arraycopy(outlinePixels[distArrayPos], 0, newArr, 0,
				outlinePixels[distArrayPos].length);
			outlinePixels[distArrayPos] = newArr;
		}
	}

	/**
	 * Resets the visited flag for a specific amount of pixels
	 *
	 * @param pixelAmount The amount of pixels to reset
	 */
	private void resetVisited(int pixelAmount)
	{
		// The visited array is essentially a boolean array, but by
		// making it an int array and checking if visited[i] == currentVisitedNumber
		// and changing currentVisitedNumber for every new outline, we can essentially
		// reset the whole array without having to iterate over every element

		if (visited.length < pixelAmount)
		{
			visited = new int[nextPowerOfTwo(pixelAmount)];
			currentVisitedNumber = 0;
		}

		currentVisitedNumber++;
	}

	/**
	 * Resets the pixels that are queued for outlining
	 *
	 * @param outlineWidth The width of the outline to reset pixels for
	 */
	private void resetOutline(int outlineWidth)
	{
		outlineArrayWidth = outlineWidth + 2;

		int arraySizes = outlineArrayWidth * outlineArrayWidth;
		if (outlinePixels.length < arraySizes)
		{
			outlinePixels = new int[arraySizes][];
			outlinePixelsLengths = new int[arraySizes];
			for (int i = 0; i < arraySizes; i++)
			{
				outlinePixels[i] = new int[4];
			}
		}
		else
		{
			for (int i = 0; i < arraySizes; i++)
			{
				outlinePixelsLengths[i] = 0;
			}
		}
	}

	/**
	 * Simulates a horizontal line rasterization and adds the pixels to the left
	 * and to the right to the outline queue if they are within the clip area.
	 *
	 * @param pixelPos The pixel position in the line where x == 0
	 * @param x1       The starting x position
	 * @param x2       The ending x position
	 */
	private void simulateHorizontalLineRasterizationForOutline(int pixelPos, int x1, int x2)
	{
		if (x2 > clipX2)
		{
			x2 = clipX2;
		}
		if (x1 < clipX1)
		{
			x1 = clipX1;
		}
		if (x1 >= x2)
		{
			return;
		}

		// Queue the pixel positions to the left and to the right of the line
		ensureMinimumOutlineQueueSize(1, 2);
		if (x2 < clipX2)
		{
			outlinePixels[1][outlinePixelsLengths[1]++] = pixelPos + x2;
		}
		if (x1 > clipX1)
		{
			outlinePixels[1][outlinePixelsLengths[1]++] = pixelPos + x1 - 1;
		}

		// Divide by 4 to account for loop unrolling
		int xDist = x2 - x1 >> 2;
		pixelPos += x1;

		// This loop could run over 100m times per second without loop unrolling in some cases,
		// so unrolling it can give a noticeable performance boost.
		while (xDist-- > 0)
		{
			visited[pixelPos++] = currentVisitedNumber;
			visited[pixelPos++] = currentVisitedNumber;
			visited[pixelPos++] = currentVisitedNumber;
			visited[pixelPos++] = currentVisitedNumber;
		}

		// Draw up to 3 more pixels if there were any left
		xDist = (x2 - x1) & 3;
		while (xDist-- > 0)
		{
			visited[pixelPos++] = currentVisitedNumber;
		}
	}

	/**
	 * Queues the pixel positions above and below two horizontal lines, excluding those
	 * where the x positions of the lines intersect.
	 *
	 * @param pixelPos The pixel position at x == 0 of the second line
	 * @param x1       The starting x position of the first line
	 * @param x2       The ending x position of the first line
	 * @param x3       The starting x position of the second line
	 * @param x4       The ending x position of the second line
	 */
	private void outlineAroundHorizontalLine(int pixelPos, int x1, int x2, int x3, int x4)
	{
		if (x1 < clipX1)
		{
			x1 = clipX1;
		}
		if (x2 < clipX1)
		{
			x2 = clipX1;
		}
		if (x3 < clipX1)
		{
			x3 = clipX1;
		}
		if (x4 < clipX1)
		{
			x4 = clipX1;
		}

		if (x1 > clipX2)
		{
			x1 = clipX2;
		}
		if (x2 > clipX2)
		{
			x2 = clipX2;
		}
		if (x3 > clipX2)
		{
			x3 = clipX2;
		}
		if (x4 > clipX2)
		{
			x4 = clipX2;
		}

		if (x1 < x3)
		{
			ensureMinimumOutlineQueueSize(outlineArrayWidth, x3 - x1);
			for (int x = x1; x < x3; x++)
			{
				outlinePixels[outlineArrayWidth][outlinePixelsLengths[outlineArrayWidth]++] = pixelPos - imageWidth + x;
			}
		}
		else
		{
			ensureMinimumOutlineQueueSize(outlineArrayWidth, x1 - x3);
			for (int x = x3; x < x1; x++)
			{
				outlinePixels[outlineArrayWidth][outlinePixelsLengths[outlineArrayWidth]++] = pixelPos + x;
			}
		}

		if (x2 < x4)
		{
			ensureMinimumOutlineQueueSize(outlineArrayWidth, x4 - x2);
			for (int x = x2; x < x4; x++)
			{
				outlinePixels[outlineArrayWidth][outlinePixelsLengths[outlineArrayWidth]++] = pixelPos + x;
			}
		}
		else
		{
			ensureMinimumOutlineQueueSize(outlineArrayWidth, x2 - x4);
			for (int x = x4; x < x2; x++)
			{
				outlinePixels[outlineArrayWidth][outlinePixelsLengths[outlineArrayWidth]++] = pixelPos - imageWidth + x;
			}
		}
	}

	/**
	 * Simulates rasterization of a triangle and adds every pixel outside the triangle
	 * to the outline queue.
	 *
	 * @param x1 The x position of the first vertex in the triangle
	 * @param y1 The y position of the first vertex in the triangle
	 * @param x2 The x position of the second vertex in the triangle
	 * @param y2 The y position of the second vertex in the triangle
	 * @param x3 The x position of the third vertex in the triangle
	 * @param y3 The y position of the third vertex in the triangle
	 */
	private void simulateTriangleRasterizationForOutline(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		// Swap vertices so y1 <= y2 <= y3 using bubble sort
		if (y1 > y2)
		{
			int yp = y1;
			int xp = x1;
			y1 = y2;
			y2 = yp;
			x1 = x2;
			x2 = xp;
		}
		if (y2 > y3)
		{
			int yp = y2;
			int xp = x2;
			y2 = y3;
			y3 = yp;
			x2 = x3;
			x3 = xp;
		}
		if (y1 > y2)
		{
			int yp = y1;
			int xp = x1;
			y1 = y2;
			y2 = yp;
			x1 = x2;
			x2 = xp;
		}

		if (y1 > clipY2)
		{
			// All points are outside clip boundaries
			return;
		}

		int slope1 = 0;
		if (y1 != y2)
		{
			slope1 = (x2 - x1 << 14) / (y2 - y1);
		}

		int slope2 = 0;
		if (y3 != y2)
		{
			slope2 = (x3 - x2 << 14) / (y3 - y2);
		}

		int slope3 = 0;
		if (y1 != y3)
		{
			slope3 = (x1 - x3 << 14) / (y1 - y3);
		}

		if (y2 > clipY2)
		{
			y2 = clipY2;
		}
		if (y3 > clipY2)
		{
			y3 = clipY2;
		}
		if (y1 == y3 || y3 < 0)
		{
			return;
		}

		x1 <<= 14;
		x2 <<= 14;
		x3 = x1;

		if (y1 < 0)
		{
			x3 -= y1 * slope3;
			x1 -= y1 * slope1;
			y1 = 0;
		}
		if (y2 < 0)
		{
			x2 -= slope2 * y2;
			y2 = 0;
		}

		int pixelPos = y1 * imageWidth;
		int currX1;
		int currX2;
		if (y1 != y2 && slope3 < slope1 || y1 == y2 && slope3 > slope2)
		{
			int height1 = y2 - y1;
			int height2 = y3 - y2;

			int prevX1;
			int prevX2;
			if (height1 <= 0)
			{
				prevX1 = x3 >> 14;
				prevX2 = x2 >> 14;
			}
			else
			{
				prevX1 = x3 >> 14;
				prevX2 = x1 >> 14;
			}

			outlineAroundHorizontalLine(pixelPos, prevX1, prevX2, prevX2, prevX2);

			while (height1-- > 0)
			{
				currX1 = x3 >> 14;
				currX2 = x1 >> 14;
				outlineAroundHorizontalLine(pixelPos, currX1, currX2, prevX1, prevX2);
				simulateHorizontalLineRasterizationForOutline(pixelPos, currX1, currX2);
				x3 += slope3;
				x1 += slope1;
				pixelPos += imageWidth;
				prevX1 = currX1;
				prevX2 = currX2;
			}

			while (height2-- > 0)
			{
				currX1 = x3 >> 14;
				currX2 = x2 >> 14;
				outlineAroundHorizontalLine(pixelPos, currX1, currX2, prevX1, prevX2);
				simulateHorizontalLineRasterizationForOutline(pixelPos, currX1, currX2);
				x3 += slope3;
				x2 += slope2;
				pixelPos += imageWidth;
				prevX1 = currX1;
				prevX2 = currX2;
			}

			outlineAroundHorizontalLine(pixelPos, prevX1, prevX1, prevX1, prevX2);
		}
		else
		{
			int height1 = y2 - y1;
			int height2 = y3 - y2;

			int prevX1;
			int prevX2;
			if (height1 <= 0)
			{
				prevX1 = x2 >> 14;
				prevX2 = x3 >> 14;
			}
			else
			{
				prevX1 = x1 >> 14;
				prevX2 = x3 >> 14;
			}

			outlineAroundHorizontalLine(pixelPos, prevX1, prevX2, prevX2, prevX2);

			while (height1-- > 0)
			{
				currX1 = x1 >> 14;
				currX2 = x3 >> 14;
				outlineAroundHorizontalLine(pixelPos, currX1, currX2, prevX1, prevX2);
				simulateHorizontalLineRasterizationForOutline(pixelPos, currX1, currX2);
				x1 += slope1;
				x3 += slope3;
				pixelPos += imageWidth;
				prevX1 = currX1;
				prevX2 = currX2;
			}

			while (height2-- > 0)
			{
				currX1 = x2 >> 14;
				currX2 = x3 >> 14;
				outlineAroundHorizontalLine(pixelPos, currX1, currX2, prevX1, prevX2);
				simulateHorizontalLineRasterizationForOutline(pixelPos, currX1, currX2);
				x3 += slope3;
				x2 += slope2;
				pixelPos += imageWidth;
				prevX1 = currX1;
				prevX2 = currX2;
			}

			outlineAroundHorizontalLine(pixelPos, prevX1, prevX1, prevX1, prevX2);
		}
	}

	/**
	 * Translates the vertices 3D points to the screen canvas 2D points
	 *
	 * @param localX            The local x position of the vertices
	 * @param localY            The local y position of the vertices
	 * @param localZ            The local z position of the vertices
	 * @param vertexOrientation The orientation of the vertices
	 * @return Returns true if any of them are inside the clip area, otherwise false
	 */
	private boolean projectVertices(Model model, final int localX, final int localY, final int localZ, final int vertexOrientation)
	{
		final int cameraX = client.getCameraX();
		final int cameraY = client.getCameraY();
		final int cameraZ = client.getCameraZ();
		final int cameraYaw = client.getCameraYaw();
		final int cameraPitch = client.getCameraPitch();
		final int scale = client.getScale();
		final int orientationSin = Perspective.SINE[vertexOrientation];
		final int orientationCos = Perspective.COSINE[vertexOrientation];
		final int pitchSin = Perspective.SINE[cameraPitch];
		final int pitchCos = Perspective.COSINE[cameraPitch];
		final int yawSin = Perspective.SINE[cameraYaw];
		final int yawCos = Perspective.COSINE[cameraYaw];
		final int vertexCount = model.getVerticesCount();
		final int[] verticesX = model.getVerticesX();
		final int[] verticesY = model.getVerticesY();
		final int[] verticesZ = model.getVerticesZ();

		boolean anyVisible = false;

		// Make sure the arrays are big enough
		while (projectedVerticesX.length < vertexCount)
		{
			int newSize = nextPowerOfTwo(vertexCount);
			projectedVerticesX = new int[newSize];
			projectedVerticesY = new int[newSize];
			projectedVerticesRenderable = new boolean[newSize];
		}

		for (int i = 0; i < vertexCount; i++)
		{
			int vx = verticesX[i];
			int vy = verticesZ[i];
			int vz = verticesY[i];
			int vh; // Value holder

			// Rotate based on orientation
			vh = vx * orientationCos + vy * orientationSin >> 16;
			vy = vy * orientationCos - vx * orientationSin >> 16;
			vx = vh;

			// Translate to local coords
			vx += localX;
			vy += localY;
			vz += localZ;

			// Translate to camera
			vx -= cameraX;
			vy -= cameraY;
			vz -= cameraZ;

			// Transform to canvas
			vh = vx * yawCos + vy * yawSin >> 16;
			vy = vy * yawCos - vx * yawSin >> 16;
			vx = vh;
			vh = vz * pitchCos - vy * pitchSin >> 16;
			vz = vz * pitchSin + vy * pitchCos >> 16;
			vy = vh;

			if (vz >= 50)
			{
				projectedVerticesX[i] = (clipX1 + clipX2) / 2 + vx * scale / vz;
				projectedVerticesY[i] = (clipY1 + clipY2) / 2 + vy * scale / vz;

				projectedVerticesRenderable[i] = true;
				anyVisible |=
					projectedVerticesX[i] >= clipX1 && projectedVerticesX[i] < clipX2 &&
						projectedVerticesY[i] >= clipY1 && projectedVerticesY[i] < clipY2;
			}
			else
			{
				projectedVerticesRenderable[i] = false;
			}
		}

		return anyVisible;
	}

	/**
	 * Simulate rendering of the model and puts every pixel of the wireframe of
	 * the non-culled and non-transparent faces into the outline pixel queue.
	 */
	private void simulateModelRasterizationForOutline(Model model)
	{
		final int triangleCount = model.getTrianglesCount();
		final int[] indices1 = model.getTrianglesX();
		final int[] indices2 = model.getTrianglesY();
		final int[] indices3 = model.getTrianglesZ();
		final byte[] triangleTransparencies = model.getTriangleTransparencies();

		for (int i = 0; i < triangleCount; i++)
		{
			if (projectedVerticesRenderable[indices1[i]] &&
				projectedVerticesRenderable[indices2[i]] &&
				projectedVerticesRenderable[indices3[i]] &&
				// 254 and 255 counts as fully transparent
				(triangleTransparencies == null || (triangleTransparencies[i] & 255) < 254))
			{
				final int index1 = indices1[i];
				final int index2 = indices2[i];
				final int index3 = indices3[i];
				final int v1x = projectedVerticesX[index1];
				final int v1y = projectedVerticesY[index1];
				final int v2x = projectedVerticesX[index2];
				final int v2y = projectedVerticesY[index2];
				final int v3x = projectedVerticesX[index3];
				final int v3y = projectedVerticesY[index3];

				if (!cullFace(v1x, v1y, v2x, v2y, v3x, v3y))
				{
					simulateTriangleRasterizationForOutline(
						v1x, v1y, v2x, v2y, v3x, v3y);
				}
			}
		}
	}

	/**
	 * Draws an outline of the pixels in the outline queue to an image
	 *
	 * @param image        The image to draw the outline to
	 * @param outlineWidth The width of the outline
	 * @param innerColor   The color of the pixels of the outline closest to the model
	 * @param outerColor   The color of the pixels of the outline furthest away from the model
	 */
	private void renderOutline(BufferedImage image, int outlineWidth, Color innerColor, Color outerColor)
	{
		int[] imageData = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		List<PixelDistanceAlpha> ps = getPriorityList(outlineWidth);

		for (PixelDistanceAlpha p : ps)
		{
			int color;
			int alpha;
			if (outlineWidth == 1)
			{
				color =
					((innerColor.getRed() + outerColor.getRed()) << 15) |
						((innerColor.getGreen() + outerColor.getGreen() << 7)) |
						((innerColor.getBlue() + outerColor.getBlue() >> 1));
				alpha = (innerColor.getAlpha() + outerColor.getAlpha()) >> 1;
			}
			else
			{
				int outerAlpha = p.getOuterAlpha();
				int innerAlpha = 255 - outerAlpha;
				int innerAlphaFraction = (innerAlpha * innerColor.getAlpha()) / 255;
				int outerAlphaFraction = (outerAlpha * outerColor.getAlpha()) / 255;
				alpha = innerAlphaFraction + outerAlphaFraction;
				if (alpha != 0)
				{
					color =
						((innerColor.getRed() * innerAlphaFraction +
							outerColor.getRed() * outerAlphaFraction) / alpha << 16) |
							((innerColor.getGreen() * innerAlphaFraction +
								outerColor.getGreen() * outerAlphaFraction) / alpha << 8) |
							((innerColor.getBlue() * innerAlphaFraction +
								outerColor.getBlue() * outerAlphaFraction) / alpha);
				}
				else
				{
					color = 0;
				}
			}

			final int distArrayPos = p.getDistArrayPos();
			final int nextDistArrayPosY = distArrayPos + outlineArrayWidth;
			final int nextDistArrayPosX = distArrayPos + 1;
			ensureMinimumOutlineQueueSize(nextDistArrayPosX, outlinePixelsLengths[distArrayPos] * 2);
			ensureMinimumOutlineQueueSize(nextDistArrayPosY, outlinePixelsLengths[distArrayPos] * 2);

			// The following 3 branches do the same thing, but when the requirements are simple,
			// there are less checks needed which can give a performance boost.
			if (alpha == 255)
			{
				if (outlineWidth == 1)
				{
					for (int i2 = 0; i2 < outlinePixelsLengths[distArrayPos]; i2++)
					{
						int pixelPos = outlinePixels[distArrayPos][i2];
						int x = pixelPos % imageWidth;
						int y = pixelPos / imageWidth;
						if (x < clipX1 || x >= clipX2 ||
							y < clipY1 || y >= clipY2 ||
							visited[pixelPos] == currentVisitedNumber)
						{
							continue;
						}

						imageData[pixelPos] = color;
					}
				}
				else
				{
					for (int i2 = 0; i2 < outlinePixelsLengths[distArrayPos]; i2++)
					{
						int pixelPos = outlinePixels[distArrayPos][i2];
						int x = pixelPos % imageWidth;
						int y = pixelPos / imageWidth;
						if (x < clipX1 || x >= clipX2 ||
							y < clipY1 || y >= clipY2 ||
							visited[pixelPos] == currentVisitedNumber)
						{
							continue;
						}
						visited[pixelPos] = currentVisitedNumber;

						imageData[pixelPos] = color;

						if (pixelPos % imageWidth != 0)
						{
							outlinePixels[nextDistArrayPosX][outlinePixelsLengths[nextDistArrayPosX]++] = pixelPos - 1;
						}
						if ((pixelPos + 1) % imageWidth != 0)
						{
							outlinePixels[nextDistArrayPosX][outlinePixelsLengths[nextDistArrayPosX]++] = pixelPos + 1;
						}
						outlinePixels[nextDistArrayPosY][outlinePixelsLengths[nextDistArrayPosY]++] = pixelPos - imageWidth;
						outlinePixels[nextDistArrayPosY][outlinePixelsLengths[nextDistArrayPosY]++] = pixelPos + imageWidth;
					}
				}
			}
			else
			{
				for (int i2 = 0; i2 < outlinePixelsLengths[distArrayPos]; i2++)
				{
					int pixelPos = outlinePixels[distArrayPos][i2];
					int x = pixelPos % imageWidth;
					int y = pixelPos / imageWidth;
					if (x < clipX1 || x >= clipX2 ||
						y < clipY1 || y >= clipY2 ||
						visited[pixelPos] == currentVisitedNumber)
					{
						continue;
					}
					visited[pixelPos] = currentVisitedNumber;

					imageData[pixelPos] =
						((((color & 0xFF0000) * alpha + (imageData[pixelPos] & 0xFF0000) * (255 - alpha)) / 255) & 0xFF0000) +
							((((color & 0xFF00) * alpha + (imageData[pixelPos] & 0xFF00) * (255 - alpha)) / 255) & 0xFF00) +
							((((color & 0xFF) * alpha + (imageData[pixelPos] & 0xFF) * (255 - alpha)) / 255) & 0xFF);

					if (pixelPos % imageWidth != 0)
					{
						outlinePixels[nextDistArrayPosX][outlinePixelsLengths[nextDistArrayPosX]++] = pixelPos - 1;
					}
					if ((pixelPos + 1) % imageWidth != 0)
					{
						outlinePixels[nextDistArrayPosX][outlinePixelsLengths[nextDistArrayPosX]++] = pixelPos + 1;
					}
					outlinePixels[nextDistArrayPosY][outlinePixelsLengths[nextDistArrayPosY]++] = pixelPos - imageWidth;
					outlinePixels[nextDistArrayPosY][outlinePixelsLengths[nextDistArrayPosY]++] = pixelPos + imageWidth;
				}
			}
		}
	}

	/**
	 * Draws an outline around a model to an image
	 *
	 * @param localX       The local x position of the model
	 * @param localY       The local y position of the model
	 * @param localZ       The local z position of the model
	 * @param orientation  The orientation of the model
	 * @param outlineWidth The width of the outline
	 * @param innerColor   The color of the pixels of the outline closest to the model
	 * @param outerColor   The color of the pixels of the outline furthest away from the model
	 */
	private void drawModelOutline(Model model, int localX, int localY, int localZ, int orientation, int outlineWidth, Color innerColor, Color outerColor)
	{
		if (outlineWidth <= 0)
		{
			return;
		}

		isReset = false;
		usedSinceLastCheck = true;

		MainBufferProvider bufferProvider = (MainBufferProvider) client.getBufferProvider();
		BufferedImage image = (BufferedImage) bufferProvider.getImage();

		clipX1 = client.getViewportXOffset();
		clipY1 = client.getViewportYOffset();
		clipX2 = client.getViewportWidth() + clipX1;
		clipY2 = client.getViewportHeight() + clipY1;
		imageWidth = image.getWidth();
		imageHeight = image.getHeight();
		final int pixelAmount = imageWidth * imageHeight;

		resetVisited(pixelAmount);
		resetOutline(outlineWidth);

		if (!projectVertices(model,
			localX, localY, localZ, orientation))
		{
			// No vertex of the model is visible on the screen, so we can
			// assume there are no parts of the model to outline.
			return;
		}

		simulateModelRasterizationForOutline(model);

		renderOutline(image, outlineWidth, innerColor, outerColor);
	}

	public void drawOutline(NPC npc, int outlineWidth, Color color)
	{
		drawOutline(npc, outlineWidth, color, color);
	}

	public void drawOutline(NPC npc, int outlineWidth, Color innerColor, Color outerColor)
	{
		int size = 1;
		NPCDefinition composition = npc.getTransformedDefinition();
		if (composition != null)
		{
			size = composition.getSize();
		}

		LocalPoint lp = npc.getLocalLocation();
		if (lp != null)
		{
			// NPCs z position are calculated based on the tile height of the northeastern tile
			final int northEastX = lp.getX() + Perspective.LOCAL_TILE_SIZE * (size - 1) / 2;
			final int northEastY = lp.getY() + Perspective.LOCAL_TILE_SIZE * (size - 1) / 2;
			final LocalPoint northEastLp = new LocalPoint(northEastX, northEastY);

			drawModelOutline(npc.getModel(), lp.getX(), lp.getY(),
				Perspective.getTileHeight(client, northEastLp, client.getPlane()),
				npc.getCurrentOrientation(), outlineWidth, innerColor, outerColor);
		}
	}

	public void drawOutline(Player player, int outlineWidth, Color color)
	{
		drawOutline(player, outlineWidth, color, color);
	}

	public void drawOutline(Player player, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = player.getLocalLocation();
		if (lp != null)
		{
			drawModelOutline(player.getModel(), lp.getX(), lp.getY(),
				Perspective.getTileHeight(client, lp, client.getPlane()),
				player.getCurrentOrientation(), outlineWidth, innerColor, outerColor);
		}
	}

	public void drawOutline(GameObject gameObject, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = gameObject.getLocalLocation();
		if (lp != null)
		{
			drawModelOutline(gameObject.getModel(), lp.getX(), lp.getY(),
				Perspective.getTileHeight(client, lp, gameObject.getPlane()),
				gameObject.getRsOrientation(), outlineWidth, innerColor, outerColor);
		}
	}

	public void drawOutline(GroundObject groundObject, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = groundObject.getLocalLocation();
		if (lp != null)
		{
			drawModelOutline(groundObject.getModel(), lp.getX(), lp.getY(),
				Perspective.getTileHeight(client, lp, client.getPlane()),
				0, outlineWidth, innerColor, outerColor);
		}
	}

	private void drawOutline(TileItemPile tileItemPile, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = tileItemPile.getLocalLocation();
		if (lp != null)
		{
			Model model = tileItemPile.getModelBottom();
			if (model != null)
			{
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, tileItemPile.getPlane()),
					0, outlineWidth, innerColor, outerColor);
			}

			model = tileItemPile.getModelMiddle();
			if (model != null)
			{
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, tileItemPile.getPlane()),
					0, outlineWidth, innerColor, outerColor);
			}

			model = tileItemPile.getModelTop();
			if (model != null)
			{
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, tileItemPile.getPlane()),
					0, outlineWidth, innerColor, outerColor);
			}
		}
	}

	private void drawOutline(DecorativeObject decorativeObject, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = decorativeObject.getLocalLocation();
		if (lp != null)
		{
			Model model = decorativeObject.getModel1();
			if (model != null)
			{
				drawModelOutline(model,
					lp.getX() + decorativeObject.getXOffset(),
					lp.getY() + decorativeObject.getYOffset(),
					Perspective.getTileHeight(client, lp, decorativeObject.getPlane()),
					decorativeObject.getOrientation(), outlineWidth, innerColor, outerColor);
			}

			model = decorativeObject.getModel2();
			if (model != null)
			{
				// Offset is not used for the second model
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, decorativeObject.getPlane()),
					decorativeObject.getOrientation(), outlineWidth, innerColor, outerColor);
			}
		}
	}

	private void drawOutline(WallObject wallObject, int outlineWidth, Color innerColor, Color outerColor)
	{
		LocalPoint lp = wallObject.getLocalLocation();
		if (lp != null)
		{
			Model model = wallObject.getModelA();
			if (model != null)
			{
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, wallObject.getPlane()),
					wallObject.getOrientationA(), outlineWidth, innerColor, outerColor);
			}

			model = wallObject.getModelB();
			if (model != null)
			{
				drawModelOutline(model, lp.getX(), lp.getY(),
					Perspective.getTileHeight(client, lp, wallObject.getPlane()),
					wallObject.getOrientationB(), outlineWidth, innerColor, outerColor);
			}
		}
	}

	public void drawOutline(TileObject tileObject, int outlineWidth, Color color)
	{
		drawOutline(tileObject, outlineWidth, color, color);
	}

	public void drawOutline(TileObject tileObject,
							int outlineWidth, Color innerColor, Color outerColor)
	{
		if (tileObject instanceof GameObject)
		{
			drawOutline((GameObject) tileObject, outlineWidth, innerColor, outerColor);
		}
		else if (tileObject instanceof GroundObject)
		{
			drawOutline((GroundObject) tileObject, outlineWidth, innerColor, outerColor);
		}
		else if (tileObject instanceof TileItemPile)
		{
			drawOutline((TileItemPile) tileObject, outlineWidth, innerColor, outerColor);
		}
		else if (tileObject instanceof DecorativeObject)
		{
			drawOutline((DecorativeObject) tileObject, outlineWidth, innerColor, outerColor);
		}
		else if (tileObject instanceof WallObject)
		{
			drawOutline((WallObject) tileObject, outlineWidth, innerColor, outerColor);
		}
	}
}