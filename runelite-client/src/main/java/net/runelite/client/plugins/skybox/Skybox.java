/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.plugins.skybox;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.runelite.api.Client;

class Skybox
{
	@FunctionalInterface
	public interface ChunkMapper
	{
		/**
		 * Gets the instance template chunk data for the specified point
		 *
		 * @see Client#getInstanceTemplateChunks
		 */
		int getTemplateChunk(int cx, int cy, int plane);
	}

	private static final double SQRT2 = Math.sqrt(2);

	// How many stddev per direction we need to stay visibly continuous
	// 511/512 accuracy
	private static final double BLEND_DISTRIBUTION = 3.075;

	// This has a worst case complexity of O((BLEND_RADUS*2)^2)
	// BLEND_RADIUS is in chunks (8 tiles)
	private static final int BLEND_RADIUS = 5;

	// The maximum number of tiles that can be blended before becoming visibly discontinuous
	private static final int MAX_BLEND = (int) ((BLEND_RADIUS * 8) / BLEND_DISTRIBUTION);

	private static final int PLANE_ALL = 0b1111;

	private static final Pattern PATTERN = Pattern.compile("^[ \\t]*(?<expr>" +
		"//.*$|" + // //comment
		"m[ \\t]*(?<mrx>[0-9]+)[ \\t]+(?<mry>[0-9]+)|" + // m <rx> <ry>
		"r[ \\t]*(?<rx>[0-9]+)[ \\t]+(?<ry>[0-9]+)|" + // r <rx> <ry>
		"R[ \\t]*(?<rx1>[0-9]+)[ \\t]+(?<ry1>[0-9]+)[ \\t]+(?<rx2>[0-9]+)[ \\t]+(?<ry2>[0-9]+)|" + // R <rx1> <ry1> <rx2> <ry2>
		"c[ \\t]*(?<cx>[0-9-]+)[ \\t]+(?<cy>[0-9-]+)|" + // c <cx> <cy>
		"C[ \\t]*(?<cx1>[0-9-]+)[ \\t]+(?<cy1>[0-9-]+)[ \\t]+(?<cx2>[0-9-]+)[ \\t]+(?<cy2>[0-9-]+)|" + // C <cx1> <cy1> <cx2> <cy2>
		"#[ \\t]*(?<color>[0-9a-fA-F]{6}|[0-9a-fA-F]{3})|" + // #<RRGGBB> or #<RGB>
		"p[ \\t]*(?<plane>all|0?[ \\t]*1?[ \\t]*2?[ \\t]*3?)|" + // p all or p<1><2><3><4>
		"b[ \\t]*(?<blend>[0-9]+)|" + // b <blend>
		"bounds[ \\t]+(?<bx1>[0-9]+)[ \\t]+(?<by1>[0-9]+)[ \\t]+(?<bx2>[0-9]+)[ \\t]+(?<by2>[0-9]+)" + // bounds <x0> <y0> <x1> <y1>
		")[ \\t]*");

	private final int[] chunks;
	private final int[] planeOverrides;

	private final int x1;
	private final int y1;
	private final int x2;
	private final int y2;
	private final int stride;

	public Skybox(InputStream is, String filename) throws IOException
	{
		this(new InputStreamReader(is), filename);
	}

	public Skybox(Reader reader, String filename) throws IOException
	{
		int[] chunks = null;
		int[] planeOverrides = new int[64];
		int planeOverrideEnd = 0;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, stride = 0;
		BufferedReader br = new BufferedReader(reader);
		int lineNo = 1;
		int color = 0;
		int plane = PLANE_ALL;
		int rx1 = 0, ry1 = 0, rx2 = 0, ry2 = 0;
		try
		{
			Matcher m = PATTERN.matcher("");
			for (String line; (line = br.readLine()) != null; lineNo++)
			{
				m.reset(line);
				int end = 0;
				for (; end < line.length(); )
				{
					m.region(end, line.length());
					if (!m.find())
					{
						throw new IllegalArgumentException("Unexpected: \"" + line.substring(end) + "\" (" + filename + ":" + lineNo + ")");
					}
					end = m.end();

					String expr = m.group("expr");
					if (expr == null || expr.length() <= 0 || expr.startsWith("//"))
					{
						continue;
					}

					if (chunks == null)
					{
						if (!expr.startsWith("bounds"))
						{
							throw new IllegalArgumentException("Expected bounds (" + filename + ":" + lineNo + ")");
						}
						x1 = Integer.parseInt(m.group("bx1")) * 8;
						y1 = Integer.parseInt(m.group("by1")) * 8;
						x2 = (Integer.parseInt(m.group("bx2")) + 1) * 8;
						y2 = (Integer.parseInt(m.group("by2")) + 1) * 8;
						stride = (x2 - x1);
						chunks = new int[stride * (y2 - y1)];
						Arrays.fill(chunks, -1);
						continue;
					}

					char cha = expr.charAt(0);
					switch (cha)
					{
						case '#':
							String sColor = m.group("color");
							int scolor = Integer.parseInt(sColor, 16);
							int cr, cg, cb;
							if (sColor.length() == 3)
							{
								// Expand #RGB to #RRGGBB
								cr = scolor >> 8 & 0xF;
								cr |= cr << 4;
								cg = scolor >> 4 & 0xF;
								cg |= cg << 4;
								cb = scolor & 0xF;
								cb |= cb << 4;
							}
							else
							{
								cr = scolor >> 16 & 0xFF;
								cg = scolor >> 8 & 0xFF;
								cb = scolor & 0xFF;
							}

							// Convert to YCoCg24 because it produces less blending artifacts due
							// to mismatched skew rates
							// See: https://stackoverflow.com/questions/10566668/lossless-rgb-to-ycbcr-transformation
							byte cco = (byte) (cb - cr);
							byte tmp = (byte) (cr + (cco >> 1));
							byte ccg = (byte) (tmp - cg);
							byte cy = (byte) (cg + (ccg >> 1));

							color = color & 0xFF000000 | (cy & 0xFF) << 16 | (cco & 0xFF) << 8 | (ccg & 0xFF);
							break;
						case 'b':
							int iblend = Integer.parseInt(m.group("blend"));
							if (iblend < 0)
							{
								throw new IllegalArgumentException("Blend must be >=0 (" + filename + ":" + lineNo + ")");
							}
							if (iblend > MAX_BLEND)
							{
								throw new IllegalArgumentException("Blend must be <= " + MAX_BLEND + " (" + filename + ":" + lineNo + ")");
							}
							color = color & 0x00FFFFFF | iblend << 24;
							break;
						case 'm':
							rx2 = rx1 = Integer.parseInt(m.group("mrx"));
							ry2 = ry1 = Integer.parseInt(m.group("mry"));
							break;
						case 'p':
							String planes = m.group("plane");
							if ("all".equals(planes))
							{
								plane = PLANE_ALL;
							}
							else
							{
								plane = 0;
								for (int i = 0; i < planes.length(); i++)
								{
									plane |= 1 << (planes.charAt(i) - '0');
								}
							}
							break;
						case 'r':
						case 'R':
							if (cha == 'r')
							{
								rx2 = rx1 = Integer.parseInt(m.group("rx"));
								ry2 = ry1 = Integer.parseInt(m.group("ry"));
							}
							else
							{
								rx1 = Integer.parseInt(m.group("rx1"));
								ry1 = Integer.parseInt(m.group("ry1"));
								rx2 = Integer.parseInt(m.group("rx2"));
								ry2 = Integer.parseInt(m.group("ry2"));
							}
							// fallthrough
						case 'c':
						case 'C':
							int cx1 = rx1 * 8;
							int cy1 = ry1 * 8;
							int cx2 = rx2 * 8 + 7;
							int cy2 = ry2 * 8 + 7;
							if (cha == 'c')
							{
								cx2 = cx1 = cx1 + Integer.parseInt(m.group("cx"));
								cy2 = cy1 = cy1 + Integer.parseInt(m.group("cy"));
							}
							else if (cha == 'C')
							{
								cx2 = cx1 + Integer.parseInt(m.group("cx2"));
								cy2 = cy1 + Integer.parseInt(m.group("cy2"));
								cx1 = cx1 + Integer.parseInt(m.group("cx1"));
								cy1 = cy1 + Integer.parseInt(m.group("cy1"));
							}

							if (cx1 < x1 || cy1 < y1 || cx2 >= x2 || cy2 >= y2)
							{
								throw new IllegalArgumentException("Coordinate out of bounds (" + filename + ":" + lineNo + ")");
							}
							if (cx1 > cx2 || cy1 > cy2)
							{
								throw new IllegalArgumentException("First coord must be before second (" + filename + ":" + lineNo + ")");
							}

							for (int y = cy1; y <= cy2; y++)
							{
								int yoffset = stride * (y - y1);
								for (int x = cx1; x <= cx2; x++)
								{
									int offset = (x - x1) + yoffset;

									if (plane == PLANE_ALL)
									{
										chunks[offset] = color;
									}
									else
									{
										// We are not setting all planes in this chunk, so allocate a plane override section
										// and add a pointer to it in the normal chunk's space. We do this because most chunks
										// do not have plane-specific data
										int ocv = chunks[offset];
										int poptr;
										if ((ocv & 0x8000_0000) != 0 && ocv != -1)
										{
											// Existing plane override
											poptr = ocv & 0x7FFF_FFFF;
										}
										else
										{
											poptr = planeOverrideEnd;
											planeOverrideEnd += 4;
											if (planeOverrideEnd > planeOverrides.length)
											{
												planeOverrides = Arrays.copyOf(planeOverrides, planeOverrideEnd + 64);
											}
											chunks[offset] = poptr | 0x8000_0000;
											for (int i = 0; i < 4; i++)
											{
												planeOverrides[poptr + i] = ocv;
											}
										}

										for (int i = 0; i < 4; i++)
										{
											if ((plane & (1 << i)) != 0)
											{
												planeOverrides[poptr + i] = color;
											}
										}
									}
								}
							}
							break;
					}
				}
			}
		}
		catch (NumberFormatException ex)
		{
			throw new IllegalArgumentException("Expected number (" + filename + ":" + lineNo + ")", ex);
		}
		if (chunks == null)
		{
			throw new IllegalArgumentException(filename + ": no data");
		}

		this.chunks = chunks;
		this.planeOverrides = planeOverrides;
		this.stride = stride;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	private int chunkData(int cx, int cy, int plane, ChunkMapper chunkMapper)
	{
		if (chunkMapper != null)
		{
			int itp = chunkMapper.getTemplateChunk(cx, cy, plane);
			if (itp == -1)
			{
				return -1;
			}

			cy = itp >> 3 & 0x7FF;
			cx = itp >> 14 & 0x3FF;
			plane = itp >> 24 & 0x3;
		}

		if (cx < x1)
		{
			cx = x1;
		}
		if (cx >= x2)
		{
			cx = x2 - 1;
		}
		if (cy < y1)
		{
			cy = y1;
		}
		if (cy >= y2)
		{
			cy = y2 - 1;
		}

		int cv = chunks[(stride * (cy - y1)) + (cx - x1)];
		if (cv == -1)
		{
			return -1;
		}
		if ((cv & 0x8000_0000) != 0)
		{
			cv = planeOverrides[(cv & 0x7FFF_FFFF) | plane];
		}
		return cv;
	}

	/**
	 * Calculates the RGB color for a specific world coordinate. Arguments are floats for sub-tile accuracy.
	 *
	 * @param x           Sample X coordinate in tiles
	 * @param y           Samlpe Y coordinate in tiles
	 * @param x           Player X coordinate in tiles
	 * @param y           Player Y coordinate in tiles
	 * @param chunkMapper maps chunks to their instance templates, or null if not in an instance
	 */
	public int getColorForPoint(double x, double y, int px, int py, int plane, double brightness, ChunkMapper chunkMapper)
	{
		x /= 8.d;
		y /= 8.d;

		int cx = (int) x;
		int cy = (int) y;

		int centerChunkData = chunkData(px / 8, py / 8, plane, chunkMapper);
		if (centerChunkData == -1)
		{
			// No data in the center chunk?
			return 0;
		}

		double t = 0;
		double ty = 0;
		double tco = 0;
		double tcg = 0;

		int xmin = (int) (x - BLEND_RADIUS);
		int xmax = (int) Math.ceil(x + BLEND_RADIUS);
		int ymin = (int) (y - BLEND_RADIUS);
		int ymax = (int) Math.ceil(y + BLEND_RADIUS);

		for (int ucx = xmin; ucx < xmax; ucx++)
		{
			for (int ucy = ymin; ucy <= ymax; ucy++)
			{
				int val = chunkData(ucx, ucy, plane, chunkMapper);
				if (val == -1)
				{
					continue;
				}

				// Get the blend value, add 1/8 tile to make sure we don't div/0, convert to chunks
				double sigma = ((val >>> 24) + .125) / 8.d;

				// Calculate how far we have to be away before we can discard this value without
				// becoming visibly discontinuous
				double minDist = 1 + (sigma * BLEND_DISTRIBUTION);

				// Try to fast-fail
				double dxl = ucx - x;
				double dxh = dxl + 1.d;
				if (dxl < -minDist || dxl > minDist)
				{
					continue;
				}

				double dyl = ucy - y;
				double dyh = dyl + 1.d;
				if (dyl < -minDist || dyh > minDist)
				{
					continue;
				}

				// Calculate integrate a gaussian distribution in each dimension for
				// this chunk relative to the requested point
				double erfdivc = sigma * SQRT2;
				double m = (erf(dxl / erfdivc) - erf(dxh / erfdivc)) * (erf(dyl / erfdivc) - erf(dyh / erfdivc));

				// Load our YCoCg24 values into floats
				double vy = (val >>> 16 & 0xFF) / 255.d;
				double vco = (byte) (val >>> 8) / 128.d;
				double vcg = (byte) val / 128.d;

				// And multiply by the weight
				ty += vy * m;
				tco += vco * m;
				tcg += vcg * m;
				t += m;
			}
		}

		// Convert back to int range values, and bounds check while we are at it
		byte ay = (byte) Math.min(Math.max(Math.round(ty / t * 255.d), 0), 255);
		byte aco = (byte) Math.min(Math.max(Math.round(tco * 128.d / t), -128), 127);
		byte acg = (byte) Math.min(Math.max(Math.round(tcg * 128.d / t), -128), 127);

		// convert back to rgb from YCoCg24
		int g = (ay - (acg >> 1)) & 0xFF;
		int tmp = (g + acg) & 0xFF;
		int r = (tmp - (aco >> 1)) & 0xFF;
		int b = (r + aco) & 0xFF;

		// increase brightness with HSB
		float[] hsb = Color.RGBtoHSB(r, g, b, null);
		hsb[2] = (float) Math.pow(hsb[2], brightness);

		return 0xFFFFFF & Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
	}

	/**
	 * Approximation of erf 'Gauss error function' which is used to calculate
	 * the cumulative distribution of a gaussian distribution.
	 * This is used to simulate a large kernel gaussian blur without having
	 * to sample the same chunk multiple times.
	 */
	private double erf(double x)
	{
		double ax = Math.abs(x);
		double t = 1.d / (1.d + (ax * .3275911d));
		double y = 1.d - ((((((1.061405429d * t) - 1.453152027d) * t) + 1.421413741d) * t - 0.284496736d) * t + 0.254829592d) * t * Math.exp(-ax * ax);
		return Math.copySign(y, x);
	}

	/**
	 * Draws the skybox map to an image
	 *
	 * @param resolution The number of pixels per tile
	 * @param line       How many tiles to put a line
	 * @param plane      the plane (0-4) to render
	 */
	BufferedImage render(double resolution, int line, int plane, ChunkMapper chunkMapper)
	{
		int w = (int) (((x2 - x1) * 8) * resolution);
		int h = (int) (((y2 - y1) * 8) * resolution);
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		int lineEvery = line <= 0 ? Integer.MAX_VALUE : (int) (line * resolution);

		for (int y = 0; y < h; y++)
		{
			for (int x = 0; x < w; x++)
			{
				int color;
				if (x % lineEvery == 0 || y % lineEvery == 0)
				{
					color = 0x00FFFFFF;
				}
				else
				{
					double fx = (x1 * 8) + (x / resolution);
					double fy = (y1 * 8) + (y / resolution);
					color = getColorForPoint(fx, fy, (int) fx, (int) fy, plane, .8, chunkMapper);
				}
				img.setRGB(x, h - 1 - y, color | 0xFF000000);
			}
		}

		return img;
	}
}
