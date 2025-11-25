/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache;

import com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreLocation
{
	private static final Logger logger = LoggerFactory.getLogger(StoreLocation.class);

	private static final int NUM_INDEXES = 16;

	public static File LOCATION;
	private static File TMP;

	static
	{
		String cacheTmpDir = System.getProperty("cache.tmpdir");
		if (!Strings.isNullOrEmpty(cacheTmpDir))
		{
			System.setProperty("java.io.tmpdir", cacheTmpDir);
			TMP = new File(cacheTmpDir);
		}

		try
		{
			LOCATION = setupCacheDir();
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}

	private static File setupCacheDir() throws IOException
	{
		File file = new File(System.getProperty("java.io.tmpdir"), "cache-" + CacheProperties.getCacheVersion());

		if (file.exists())
		{
			logger.info("Using preexisting cache working directory {}", file);
			return file;
		}

		try
		{
			file.mkdir();

			// Copy over files
			InputStream in = StoreLocation.class.getResourceAsStream("/main_file_cache.dat2");
			Files.copy(in, new File(file, "main_file_cache.dat2").toPath());

			in = StoreLocation.class.getResourceAsStream("/main_file_cache.idx255");
			Files.copy(in, new File(file, "main_file_cache.idx255").toPath());

			for (int i = 0; i <= NUM_INDEXES; ++i)
			{
				in = StoreLocation.class.getResourceAsStream("/main_file_cache.idx" + i);
				Files.copy(in, new File(file, "main_file_cache.idx" + i).toPath());
			}

			logger.info("Set up cache working directory to {}", file);
		}
		catch (Exception ex)
		{
			file.delete();
			throw ex;
		}

		return file;
	}

	public static TemporaryFolder getTemporaryFolder()
	{
		return new TemporaryFolder()
		{
			@Override
			public void after()
			{
				// don't cleanup if using cache tmpdir
				if (TMP == null)
				{
					super.after();
				}
			}
		};
	}
}
