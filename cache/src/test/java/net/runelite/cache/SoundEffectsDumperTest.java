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

import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import net.runelite.cache.definitions.loaders.sound.SoundEffectTrackLoader;
import net.runelite.cache.definitions.sound.SoundEffectTrackDefinition;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class SoundEffectsDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(SoundEffectsDumperTest.class);

	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		File dumpDir = folder.newFolder();
		int count = 0;

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.SOUNDEFFECTS);

			for (Archive archive : index.getArchives())
			{
				byte[] contents = archive.decompress(storage.loadArchive(archive));

				SoundEffectTrackLoader setLoader = new SoundEffectTrackLoader();
				SoundEffectTrackDefinition soundEffect = setLoader.load(contents);

				Files.asCharSink(new File(dumpDir, archive.getArchiveId() + ".json"), Charset.defaultCharset()).write(gson.toJson(soundEffect));
				++count;
			}
		}

		logger.info("Dumped {} sound effects to {}", count, dumpDir);
	}

	@Test
	public void extractWavTest() throws IOException
	{
		File dumpDir = folder.newFolder();
		int count = 0;

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.SOUNDEFFECTS);

			for (Archive archive : index.getArchives())
			{
				byte[] contents = archive.decompress(storage.loadArchive(archive));

				SoundEffectTrackLoader setLoader = new SoundEffectTrackLoader();
				SoundEffectTrackDefinition soundEffect = setLoader.load(contents);
				try
				{
					Object audioStream;
					byte[] data = soundEffect.mix();

					AudioFormat audioFormat = new AudioFormat(22050.0f, 8, 1, true, false);
					audioStream = new AudioInputStream(new ByteArrayInputStream(data), audioFormat, data.length);

					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					AudioSystem.write((AudioInputStream) audioStream, AudioFileFormat.Type.WAVE, bos);
					data = bos.toByteArray();

					FileOutputStream fos = new FileOutputStream(new File(dumpDir, archive.getArchiveId() + ".wav"));

					try
					{
						fos.write(data);
					}
					finally
					{
						fos.close();
					}

					++count;
				}
				catch (Exception e)
				{
					continue;
				}
			}
		}

		logger.info("Dumped {} sound effects to {}", count, dumpDir);
	}
}