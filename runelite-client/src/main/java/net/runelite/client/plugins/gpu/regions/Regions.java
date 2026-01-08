/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu.regions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.Getter;

public class Regions
{
	private static final Pattern PATTERN = Pattern.compile("^[ \\t]*(?<expr>" +
		"//.*$|" + // //comment
		"n|" +
		"m[ \\t]*(?<mrx>[0-9]+)[ \\t]+(?<mry>[0-9]+)|" + // m <rx> <ry>
		"r[ \\t]*(?<rx>[0-9]+)[ \\t]+(?<ry>[0-9]+)|" + // r <rx> <ry>
		"R[ \\t]*(?<rx1>[0-9]+)[ \\t]+(?<ry1>[0-9]+)[ \\t]+(?<rx2>[0-9]+)[ \\t]+(?<ry2>[0-9]+)|" + // R <rx1> <ry1> <rx2> <ry2>
		"c[ \\t]*(?<cx>[0-9-]+)[ \\t]+(?<cy>[0-9-]+)|" + // c <cx> <cy>
		"C[ \\t]*(?<cx1>[0-9-]+)[ \\t]+(?<cy1>[0-9-]+)[ \\t]+(?<cx2>[0-9-]+)[ \\t]+(?<cy2>[0-9-]+)|" + // C <cx1> <cy1> <cx2> <cy2>
		")[ \\t]*");

	@Getter(AccessLevel.PACKAGE)
	private final List<Region> regions = new ArrayList<>();

	private static final int REGION_MAP_SIZE = 70 * 200 / 8;
	private final byte[] regionMap = new byte[REGION_MAP_SIZE];

	private Region last;

	public Regions(InputStream is, String filename) throws IOException
	{
		this(new InputStreamReader(is, StandardCharsets.UTF_8), filename);
	}

	public Regions(Reader reader, String filename) throws IOException
	{
		BufferedReader br = new BufferedReader(reader);
		int lineNo = 1;
		int rx1 = 0, ry1 = 0, rx2 = 0, ry2 = 0;
		int rid = 0;
		Matcher m = PATTERN.matcher("");
		for (String line; (line = br.readLine()) != null; lineNo++)
		{
			m.reset(line);
			int end = 0;
			while (end < line.length())
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

				char cha = expr.charAt(0);
				switch (cha)
				{
					case 'n':
						rid++;
						break;
					case 'm':
						rx2 = rx1 = Integer.parseInt(m.group("mrx"));
						ry2 = ry1 = Integer.parseInt(m.group("mry"));
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

						if (cx1 > cx2 || cy1 > cy2)
						{
							throw new IllegalArgumentException("First coord must be before second (" + filename + ":" + lineNo + ")");
						}

						Region r = new Region();
						r.id = rid;
						r.cx1 = cx1;
						r.cy1 = cy1;
						r.cx2 = cx2;
						r.cy2 = cy2;
						regions.add(r);

						// mark the affected regions as in uses
						for (int rx = rx1; rx <= rx2; ++rx)
						{
							for (int ry = ry1; ry <= ry2; ++ry)
							{
								markRegion(rx, ry);
							}
						}
				}
			}
		}
	}

	public int getRegionId(int cx, int cy)
	{
		int rx = cx / 8;
		int ry = cy / 8;
		if (!isMarked(rx, ry))
		{
			return 0;
		}

		if (last != null && intersects(cx, cy, last))
		{
			return last.id;
		}

		for (Region r : regions)
		{
			if (intersects(cx, cy, r))
			{
				last = r;
				return r.id;
			}
		}
		return 0;
	}

	private static boolean intersects(int cx, int cy, Region r)
	{
		return cx >= r.cx1 && cy >= r.cy1 && cx <= r.cx2 && cy <= r.cy2;
	}

	private void markRegion(int rx, int ry)
	{
		int id = (rx << 8) | ry;
		int idx = id / 8;
		if (idx < regionMap.length)
		{
			regionMap[idx] |= 1 << (idx % 8);
		}
	}

	private boolean isMarked(int rx, int ry)
	{
		int id = (rx << 8) | ry;
		int idx = id / 8;
		if (idx < regionMap.length)
		{
			return (regionMap[idx] & (1 << (idx % 8))) != 0;
		}
		return true;
	}
}
