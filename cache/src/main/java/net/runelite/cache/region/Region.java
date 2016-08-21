/**
 * Copyright (c) 2015 Kyle Friz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.runelite.cache.region;

import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.io.InputStream;

/**
 *
 * @author Kyle Friz
 * @since Jun 30, 2015
 */
public class Region
{

	public static final int X = 64;
	public static final int Y = 64;
	public static final int Z = 4;

	private final int regionID;
	private final int baseX;
	private final int baseY;

	private final int[][][] tileHeights = new int[Z][X][Y];
	private final byte[][][] renderRules = new byte[Z][X][Y];
	private final byte[][][] overlayIds = new byte[Z][X][Y];
	private final byte[][][] overlayPaths = new byte[Z][X][Y];
	private final byte[][][] overlayRotations = new byte[Z][X][Y];
	private final byte[][][] underlayIds = new byte[Z][X][Y];

	private final List<Location> locations = new ArrayList<>();

	public Region(int id)
	{
		this.regionID = id;
		this.baseX = ((id >> 8) & 0xFF) << 6;
		this.baseY = (id & 0xFF) << 6;
	}

	public void loadTerrain(byte[] buf)
	{
		InputStream in = new InputStream(buf);

		for (int z = 0; z < Z; z++)
		{
			for (int x = 0; x < X; x++)
			{
				for (int y = 0; y < Y; y++)
				{
					while (true)
					{
						int attribute = in.readUnsignedByte();
						if (attribute == 0)
						{
							if (z == 0)
							{
								tileHeights[0][x][y] = -HeightCalc.calculate(baseX, baseY, x, y) * 8;
							}
							else
							{
								tileHeights[z][x][y] = tileHeights[z - 1][x][y] - 240;
							}

							break;
						}
						else if (attribute == 1)
						{
							int height = in.readUnsignedByte();
							if (height == 1)
							{
								height = 0;
							}

							if (z == 0)
							{
								tileHeights[0][x][y] = -height * 8;
							}
							else
							{
								tileHeights[z][x][y] = tileHeights[z - 1][x][y] - height * 8;
							}

							break;
						}
						else if (attribute <= 49)
						{
							overlayIds[z][x][y] = in.readByte();
							overlayPaths[z][x][y] = (byte) ((attribute - 2) / 4);
							overlayRotations[z][x][y] = (byte) (attribute - 2 & 3);
						}
						else if (attribute <= 81)
						{
							renderRules[z][x][y] = (byte) (attribute - 49);
						}
						else
						{
							underlayIds[z][x][y] = (byte) (attribute - 81);
						}
					}
				}
			}
		}
	}

	public void loadLocations(byte[] b)
	{
		InputStream buf = new InputStream(b);

		int id = -1;
		int idOffset;

		while ((idOffset = buf.readUnsignedShortSmart()) != 0)
		{
			id += idOffset;

			int position = 0;
			int positionOffset;

			while ((positionOffset = buf.readUnsignedShortSmart()) != 0)
			{
				position += positionOffset - 1;

				int localY = position & 0x3F;
				int localX = position >> 6 & 0x3F;
				int height = position >> 12 & 0x3;

				int attributes = buf.readUnsignedByte();
				int type = attributes >> 2;
				int orientation = attributes & 0x3;

				locations.add(new Location(id, type, orientation, new Position(getBaseX() + localX, getBaseY() + localY, height)));
			}
		}
	}

	public int getRegionID()
	{
		return regionID;
	}

	public int getBaseX()
	{
		return baseX;
	}

	public int getBaseY()
	{
		return baseY;
	}

	public int getTileHeight(int z, int x, int y)
	{
		return tileHeights[z][x][y];
	}

	public byte getRenderRule(int z, int x, int y)
	{
		return renderRules[z][x][y];
	}

	public int getOverlayId(int z, int x, int y)
	{
		return overlayIds[z][x][y] & 0xFF;
	}

	public byte getOverlayPath(int z, int x, int y)
	{
		return overlayPaths[z][x][y];
	}

	public byte getOverlayRotation(int z, int x, int y)
	{
		return overlayRotations[z][x][y];
	}

	public int getUnderlayId(int z, int x, int y)
	{
		return underlayIds[z][x][y] & 0xFF;
	}

	public List<Location> getLocations()
	{
		return locations;
	}
}
