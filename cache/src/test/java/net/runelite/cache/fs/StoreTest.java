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
package net.runelite.cache.fs;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.index.FileData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class StoreTest
{
	private static final int NUMBER_OF_FILES = 1024;

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void testOneFile() throws IOException
	{
		try (Store store = new Store(folder.getRoot()))
		{
			Index index = store.addIndex(0);
			Archive archive = index.addArchive(0);
			archive.setFileData(new FileData[1]);
			FileData fileData = archive.getFileData()[0] = new FileData();
			fileData.setId(42);
			fileData.setNameHash(7);

			store.save();

			try (Store store2 = new Store(folder.getRoot()))
			{
				store2.load();

				Assert.assertEquals(store, store2);
			}
		}
	}

	@Test
	public void testManyFiles() throws IOException
	{
		Random random = new Random(42L);
		File root = folder.newFolder();

		try (Store store = new Store(root))
		{
			Index index = store.addIndex(0);
			Archive archive = index.addArchive(0);
			archive.setNameHash(random.nextInt());
			archive.setFileData(new FileData[NUMBER_OF_FILES]);

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FileData[] fileData = archive.getFileData();
				FileData file = fileData[i] = new FileData();
				file.setId(i);
				file.setNameHash(random.nextInt());
			}

			store.save();

			try (Store store2 = new Store(root))
			{
				store2.load();

				Assert.assertEquals(store, store2);
			}
		}
	}

	@Test
	public void testMultipleArchives() throws IOException
	{
		Random random = new Random(43L);
		File root = folder.newFolder();

		try (Store store = new Store(root))
		{
			Index index = store.addIndex(0);
			Index index2 = store.addIndex(1);

			Archive archive = index.addArchive(0);
			archive.setNameHash(random.nextInt(Integer.MAX_VALUE));
			archive.setFileData(new FileData[NUMBER_OF_FILES]);

			Archive archive2 = index.addArchive(1);
			archive2.setFileData(new FileData[NUMBER_OF_FILES]);

			Archive archive3 = index2.addArchive(0);
			archive3.setFileData(new FileData[NUMBER_OF_FILES]);

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FileData[] fileData = archive.getFileData();
				FileData file = fileData[i] = new FileData();
				file.setId(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
			}

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FileData[] fileData = archive2.getFileData();
				FileData file = fileData[i] = new FileData();
				file.setId(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
			}

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FileData[] fileData = archive3.getFileData();
				FileData file = fileData[i] = new FileData();
				file.setId(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
			}

			store.save();

			try (Store store2 = new Store(root))
			{
				store2.load();

				Assert.assertEquals(store, store2);
			}
		}
	}
}
