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
package net.runelite.cache.fs.flat;

import java.io.File;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Container;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.fs.jagex.DiskStorage;
import net.runelite.cache.index.FileData;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class FlatStorageTest
{
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testSaveArchive() throws Exception
	{
		File file = folder.newFolder();
		DiskStorage storage = new DiskStorage(file);
		Archive archive;
		Archive archive2;
		try (Store store = new Store(storage))
		{
			Index index = store.addIndex(0);
			archive = index.addArchive(0);
			archive2 = index.addArchive(1);

			FileData[] fileData = new FileData[1];
			archive.setFileData(fileData);
			fileData[0] = new FileData();

			FileData[] fileData2 = new FileData[1];
			archive2.setFileData(fileData2);
			fileData2[0] = new FileData();

			byte[] data = "test".getBytes();
			Container container = new Container(archive.getCompression(), -1);
			container.compress(data, null);
			byte[] compressedData = container.data;
			storage.saveArchive(archive, compressedData);

			container = new Container(archive.getCompression(), 42);
			container.compress(data, null);
			compressedData = container.data;
			archive2.setRevision(42);
			storage.saveArchive(archive2, compressedData);

			store.save();
		}

		storage = new DiskStorage(file);
		try (Store store = new Store(storage))
		{
			store.load();
			Index index = store.findIndex(0);
			Archive archive2_1 = index.getArchive(0);
			Archive archive2_2 = index.getArchive(1);

			byte[] comprsesedData = storage.loadArchive(archive2_1);
			byte[] data = archive2_1.decompress(comprsesedData);
			assertArrayEquals("test".getBytes(), data);
			assertEquals(archive.getCrc(), archive2_1.getCrc());
			assertEquals(archive.getRevision(), archive2_1.getRevision());

			comprsesedData = storage.loadArchive(archive2_2);
			data = archive2_2.decompress(comprsesedData);
			assertArrayEquals("test".getBytes(), data);
			assertEquals(archive2.getCrc(), archive2_2.getCrc());
			assertEquals(archive2.getRevision(), archive2_2.getRevision());
		}
	}
}
