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
package net.runelite.cache;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.definitions.FrameDefinition;
import net.runelite.cache.definitions.FramemapDefinition;
import net.runelite.cache.definitions.loaders.FrameLoader;
import net.runelite.cache.definitions.loaders.FramemapLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameDumper
{
	private static final Logger logger = LoggerFactory.getLogger(FrameDumper.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Test
	@Ignore
	public void extract() throws IOException
	{
		File base = StoreLocation.LOCATION,
			outDir = folder.newFolder();

		int count = 0;

		try (Store store = new Store(base))
		{
			store.load();

			Storage storage = store.getStorage();
			Index frameIndex = store.getIndex(IndexType.FRAMES);
			Index framemapIndex = store.getIndex(IndexType.FRAMEMAPS);

			for (Archive archive : frameIndex.getArchives())
			{
				List<FrameDefinition> frames = new ArrayList<>();

				byte[] archiveData = storage.loadArchive(archive);

				ArchiveFiles archiveFiles = archive.getFiles(archiveData);
				for (FSFile archiveFile : archiveFiles.getFiles())
				{
					byte[] contents = archiveFile.getContents();

					int framemapArchiveId = (contents[0] & 0xff) << 8 | contents[1] & 0xff;

					Archive framemapArchive = framemapIndex.getArchives().get(framemapArchiveId);
					archiveData = storage.loadArchive(framemapArchive);
					byte[] framemapContents = framemapArchive.decompress(archiveData);

					FramemapLoader fmloader = new FramemapLoader();
					FramemapDefinition framemap = fmloader.load(framemapArchive.getArchiveId(), framemapContents);

					FrameLoader frameLoader = new FrameLoader();
					FrameDefinition frame = frameLoader.load(framemap, archiveFile.getFileId(), contents);

					frames.add(frame);
				}

				Files.write(gson.toJson(frames), new File(outDir, archive.getArchiveId() + ".json"), Charset.defaultCharset());
				++count;
			}
		}

		logger.info("Dumped {} frames to {}", count, outDir);
	}
}
