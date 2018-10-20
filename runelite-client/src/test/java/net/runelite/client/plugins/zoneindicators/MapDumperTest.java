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
package net.runelite.client.plugins.zoneindicators;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Ignore;
import org.junit.Test;

public class MapDumperTest
{
	// To use the files generated in these tests, download the official
	// Oldschool Runescape world map and overlay the generated images
	// onto that map.

	private static final int START_X = 1152;
	private static final int START_Y = 2496;
	private static final int WIDTH = 8256;
	private static final int HEIGHT = 4800;
	private static final int PADDING = 25;
	private static final int TILE_SIZE = 3;
	private static final Rectangle VIEW = new Rectangle(
		START_X, START_Y,
		START_X + WIDTH / TILE_SIZE,
		START_Y + HEIGHT / TILE_SIZE);

	private static final File outputDirectory = new File(System.getProperty("tmpdir"));

	private void dump(Area area, Color color, String name) throws IOException
	{
		BufferedImage image = new BufferedImage(
			WIDTH + PADDING * 2,
			HEIGHT + PADDING * 2,
			BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();

		AffineTransform trans1 = new AffineTransform();
		trans1.translate(-START_X, -START_Y);

		AffineTransform trans2 = new AffineTransform();
		trans2.scale(TILE_SIZE, TILE_SIZE);

		AffineTransform trans3 = new AffineTransform();
		trans3.scale(1, -1);

		AffineTransform trans4 = new AffineTransform();
		trans4.translate(0, HEIGHT);

		AffineTransform trans5 = new AffineTransform();
		trans5.translate(PADDING, PADDING);

		area.intersect(new Area(VIEW));
		area.transform(trans1);
		area.transform(trans2);
		area.transform(trans3);
		area.transform(trans4);
		area.transform(trans5);

		g.setColor(color);
		g.fill(area);

		File file = new File(outputDirectory, name);
		file.mkdirs();
		ImageIO.write(image, "PNG", file);
	}

	@Test
	@Ignore
	public void dumpPvpSafezones() throws IOException
	{
		dump(MapLocations.getPvpSafeZones(0), new Color(0, 255, 0, 100),
			"pvp-area.png");
	}

	@Test
	@Ignore
	public void dumpDeadmanSafezones() throws IOException
	{
		dump(MapLocations.getDeadmanSafeZones(0), new Color(0, 255, 0, 100),
			"deadman-area.png");
	}

	@Test
	@Ignore
	public void dumpMulticombat() throws IOException
	{
		dump(MapLocations.getMulticombat(0), new Color(255, 0, 0, 100),
			"multicombat-area.png");
	}
}
