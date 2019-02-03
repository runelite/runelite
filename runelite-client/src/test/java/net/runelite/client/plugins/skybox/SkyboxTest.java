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

import com.google.common.base.Strings;
import com.google.common.io.CharSource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class SkyboxTest
{
	@Test
	public void testLoadSimple() throws IOException
	{
		Skybox skybox = new Skybox(CharSource.wrap("bounds 0 0 100 100 #00F // R 0 0 100 100\r\nr 99 99").openStream(), "simple");
		Assert.assertEquals(0, skybox.getColorForPoint(0, 0, 0, 0, 0, 1, null));
		int x = (99 * 64) + 32;
		int y = (99 * 64) + 32;
		Assert.assertEquals(0x0000FF, skybox.getColorForPoint(x, y, x, y, 0, 1, null));
	}

	@Test
	public void testLoadActual() throws IOException
	{
		long start = System.nanoTime();
		Skybox skybox = new Skybox(SkyboxPlugin.class.getResourceAsStream("skybox.txt"), "skybox.txt");
		log.info("Parse took {}ms", (System.nanoTime() - start) / 1_000_000);

		String skyboxFile = System.getProperty("skyboxExport");
		if (!Strings.isNullOrEmpty(skyboxFile))
		{
			start = System.nanoTime();
			BufferedImage img = skybox.render(1f, 0, 0, null);
			long time = System.nanoTime() - start;
			log.info("Map render took {}ms", time / 1_000_000);
			log.info("Single render takes ~{}ns/frame", time / (img.getWidth() * img.getHeight()));
			ImageIO.write(img, "png", new File(skyboxFile));
		}

		Assert.assertNotEquals(skybox.getColorForPoint(3232, 3232, 3232, 3232, 0, .9, null), 0); // Lumbridge will never be black
	}
}
