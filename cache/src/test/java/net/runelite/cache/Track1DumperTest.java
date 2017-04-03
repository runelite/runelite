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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import net.runelite.cache.definitions.Track1Definition;
import net.runelite.cache.definitions.loaders.Track1Loader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Djb2Manager;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Track1DumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(Track1DumperTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		File dumpDir = folder.newFolder();
		int count = 0;

		Djb2Manager djb2 = new Djb2Manager();
		djb2.load();

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Index index = store.getIndex(IndexType.TRACK1);

			for (Archive archive : index.getArchives())
			{
				assert archive.getFiles().size() == 1;

				net.runelite.cache.fs.File file = archive.getFiles().get(0);

				Track1Loader loader = new Track1Loader();
				Track1Definition def = loader.load(file.getContents());

				String name = djb2.getName(archive.getNameHash());
				if (name == null)
				{
					name = "" + archive.getNameHash();
				}

				Files.write(def.midi, new File(dumpDir, name + ".midi"));

				++count;
			}
		}

		logger.info("Dumped {} sound tracks to {}", count, dumpDir);
	}

	@Test
	@Ignore
	public void play() throws Exception
	{
		// Obtains the default Sequencer connected to a default device.
		Sequencer sequencer = MidiSystem.getSequencer();

		// Opens the device, indicating that it should now acquire any
		// system resources it requires and become operational.
		sequencer.open();

		try
		{
			// create a stream from a file
			java.io.InputStream is = new FileInputStream(new File("C:\\rs\\cache\\track1\\scape main.midi"));

			// Sets the current sequence on which the sequencer operates.
			// The stream must point to MIDI file data.
			sequencer.setSequence(is);

			// Starts playback of the MIDI data in the currently loaded sequence.
			sequencer.start();

			while (sequencer.isRunning())
			{
				Thread.sleep(1000L);
			}
		}
		finally
		{
			sequencer.close();
		}
	}
}
