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
import net.runelite.cache.definitions.TrackDefinition;
import net.runelite.cache.definitions.loaders.TrackLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Djb2Manager;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(TrackDumperTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	private final Djb2Manager djb2 = new Djb2Manager();

	@Test
	public void test() throws IOException
	{
		File dumpDir1 = folder.newFolder(),
			dumpDir2 = folder.newFolder();
		int idx1 = 0, idx2 = 0;

		djb2.load();

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.TRACK1);
			Index index2 = store.getIndex(IndexType.TRACK2);

			for (Archive archive : index.getArchives())
			{
				dumpTrackArchive(dumpDir1, storage, archive);
				++idx1;
			}

			for (Archive archive : index2.getArchives())
			{
				dumpTrackArchive(dumpDir2, storage, archive);
				++idx2;
			}
		}

		logger.info("Dumped {} sound tracks ({} idx1, {} idx2) to {} and {}", idx1 + idx2, idx1, idx2, dumpDir1, dumpDir2);
	}

	private void dumpTrackArchive(File dumpDir, Storage storage, Archive archive) throws IOException
	{
		byte[] contents = archive.decompress(storage.loadArchive(archive));

		if (contents == null)
		{
			return;
		}

		TrackLoader loader = new TrackLoader();
		TrackDefinition def = loader.load(contents);

		String name;
		if (archive.getNameHash() != 0)
		{
			name = djb2.getName(archive.getNameHash());
			if (name == null)
			{
				name = "name-" + archive.getNameHash();
			}
		}
		else
		{
			name = "archive-" + archive.getArchiveId();
		}

		File dest = new File(dumpDir, name + ".midi");
		assert !dest.exists();

		Files.write(def.midi, dest);
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
			java.io.InputStream is = new FileInputStream(new File("D:\\rs\\07\\cache\\track1\\name-687938017.midi"));

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
