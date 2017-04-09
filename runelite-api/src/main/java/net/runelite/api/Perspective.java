/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

public class Perspective
{
	public static final int[] SINE = new int[2048];
	public static final int[] COSINE = new int[2048];

	static
	{
		for (int i = 0; i < 2048; ++i)
		{
			SINE[i] = (int) (65536.0D * Math.sin((double) i * 0.0030679615D));
			COSINE[i] = (int) (65536.0D * Math.cos((double) i * 0.0030679615D));
		}
	}

	/**
	 * Translates two-dimensional ground coordinates within the 3D world to
	 * their corresponding coordinates on the game screen.
	 *
	 * @param client
	 * @param x ground coordinate on the x axis
	 * @param y ground coordinate on the y axis
	 * @param var2
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	public static Point worldToCanvas(Client client, int x, int y, int var2)
	{
		if (x >= 128 && y >= 128 && x <= 13056 && y <= 13056)
		{
			int z = getTileHeight(client, x, y, client.getPlane()) - var2;
			x -= client.getCameraX();
			z -= client.getCameraZ();
			y -= client.getCameraY();

			int cameraPitch = client.getCameraPitch();
			int cameraYaw = client.getCameraYaw();

			int pitchSin = SINE[cameraPitch];
			int pitchCos = COSINE[cameraPitch];
			int yawSin = SINE[cameraYaw];
			int yawCos = COSINE[cameraYaw];

			int var8 = yawCos * x + y * yawSin >> 16;
			y = yawCos * y - yawSin * x >> 16;
			x = var8;
			var8 = pitchCos * z - y * pitchSin >> 16;
			y = z * pitchSin + y * pitchCos >> 16;

			if (y >= 50)
			{
				int pointX = client.getCamera2() / 2 + x * client.getScale() / y;
				int pointY = var8 * client.getScale() / y + client.getCamera3() / 2;
				return new Point(pointX, pointY);
			}
		}

		return null;

	}

	/**
	 * Calculates the above ground height of a tile point.
	 *
	 * @param client
	 * @param x the ground coordinate on the x axis
	 * @param y the ground coordinate on the y axis
	 * @param plane the client plane/ground level
	 * @return the offset from the ground of the tile
	 */
	public static int getTileHeight(Client client, int x, int y, int plane)
	{
		int var3 = x >> 7;
		int var4 = y >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103)
		{
			byte[][][] tileSettings = client.getTileSettings();
			int[][][] tileHeights = client.getTileHeights();

			int var5 = plane;
			if (plane < 3 && (tileSettings[1][var3][var4] & 2) == 2)
			{
				var5 = plane + 1;
			}

			int var6 = x & 127;
			int var7 = y & 127;
			int var8 = var6 * tileHeights[var5][var3 + 1][var4] + (128 - var6) * tileHeights[var5][var3][var4] >> 7;
			int var9 = tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * tileHeights[var5][var3 + 1][var4 + 1] >> 7;
			return (128 - var7) * var8 + var7 * var9 >> 7;
		}

		return 0;
	}

}
