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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Properties;
import javax.imageio.ImageIO;
import net.runelite.cache.MapImageDumper;
import net.runelite.cache.fs.Store;
import net.runelite.cache.region.Region;
import net.runelite.cache.region.RegionLoader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "assemble", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class AssembleMojo extends AbstractMojo
{
	private static final int MIN_PLANE = 0;
	private static final int MAX_PLANE = 3;
	private static final int NUM_INDEXES = 16;

	@Parameter(required = true)
	private File outputDirectory;

	@Override
	public void execute() throws MojoExecutionException
	{
		outputDirectory.mkdirs();
		final File location;

		try
		{
			location = setupCacheDir();
		}
		catch (IOException e)
		{
			throw new MojoExecutionException(e.getMessage());
		}

		try (final Store store = new Store(location))
		{
			getLog().info("Loading store");
			store.load();

			getLog().info("Loading regions");
			final RegionLoader regionLoader = new RegionLoader(store);
			regionLoader.loadRegions();

			getLog().info("Loading map image dumper");
			final MapImageDumper dumper = new MapImageDumper(store);
			dumper.load();

			final Collection<Region> regions = regionLoader.getRegions();

			for (Region region : regions)
			{
				getLog().info("Assembling " + region.getRegionID() + " region");

				for (int z = MIN_PLANE; z <= MAX_PLANE; z++)
				{
					final String regionId = z + "-" + region.getRegionID();
					final BufferedImage image = dumper.drawRegion(region, z);

					if (!isFullyBlack(image))
					{
						final File imageFile = new File(outputDirectory, "map-" + regionId + ".png");
						ImageIO.write(image, "png", imageFile);
					}
				}
			}

			getLog().info("Assembled " + regions.size() + " map regions");
		}
		catch (IOException | NullPointerException e)
		{
			throw new MojoExecutionException(e.getMessage());
		}
	}

	/**
	 * Extract cache contents to temporary directory and return path to the directory. If directory already exists
	 * reuse it.
	 * @return path to cache directory
	 * @throws IOException exception when file is not found
	 */
	private File setupCacheDir() throws IOException
	{
		File file = new File(System.getProperty("java.io.tmpdir"), "cache-" + getCacheVersion());

		if (file.exists())
		{
			getLog().info("Using preexisting cache working directory " + file.getPath());
			return file;
		}

		file.mkdir();

		// Copy over files
		InputStream in = getClass().getResourceAsStream("/main_file_cache.dat2");
		Files.copy(in, new File(file, "main_file_cache.dat2").toPath());

		in = getClass().getResourceAsStream("/main_file_cache.idx255");
		Files.copy(in, new File(file, "main_file_cache.idx255").toPath());

		for (int i = 0; i <= NUM_INDEXES; ++i)
		{
			in = getClass().getResourceAsStream("/main_file_cache.idx" + i);
			Files.copy(in, new File(file, "main_file_cache.idx" + i).toPath());
		}

		getLog().info("Set up cache working directory to " + file.getPath());
		return file;
	}

	/**
	 * Check if image contains only black pixels
	 * @param image image to check
	 * @return true if image is fully black
	 */
	private static boolean isFullyBlack(final BufferedImage image)
	{
		final int xmin = image.getMinX();
		final int ymin = image.getMinY();
		final int ymax = ymin + image.getHeight();
		final int xmax = xmin + image.getWidth();

		for (int i = xmin; i < xmax;i++)
		{
			for (int j = ymin; j < ymax; j++)
			{
				int pixel = image.getRGB(i, j);

				if (((pixel & 0x00FFFFFF) != 0))
				{
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Get RuneScape cache version from properties
	 * @return cache version
	 * @throws IOException exception when file is not found
	 */
	private static int getCacheVersion() throws IOException
	{
		final Properties properties = new Properties();
		InputStream resourceAsStream = AssembleMojo.class.getResourceAsStream("/cache.properties");
		properties.load(resourceAsStream);
		return Integer.parseInt(properties.getProperty("cache.version"));
	}
}
