/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MapLoader
{
	private static final int REGION_IMAGE_SIZE = 256;
	private static final BufferedImage EMPTY_REGION;

	static
	{
		EMPTY_REGION = new BufferedImage(REGION_IMAGE_SIZE, REGION_IMAGE_SIZE, BufferedImage.TYPE_INT_RGB);
		final Graphics graphics = EMPTY_REGION.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, REGION_IMAGE_SIZE, REGION_IMAGE_SIZE);
		graphics.dispose();
	}

	/**
	 * Reads map region image
	 * @param plane plane on map
	 * @param regionId region id
	 * @return map region image
	 * @throws IOException exception when image is not found
	 */
	public static BufferedImage readMapRegionImage(final int plane, final int regionId) throws IOException
	{
		final URL resource = MapLoader.class.getResource(String.format("map-%d-%d.png", plane, regionId));
		return resource != null ? ImageIO.read(resource) : EMPTY_REGION;
	}
}
