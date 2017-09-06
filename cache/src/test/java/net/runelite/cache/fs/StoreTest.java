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
import net.runelite.cache.fs.tree.TreeStorage;
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
			FSFile file = archive.addFile(0);
			file.setNameHash(7);
			file.setContents("test".getBytes());

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

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FSFile file = archive.addFile(i);
				file.setNameHash(random.nextInt());
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
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

			Archive archive2 = index.addArchive(1);

			Archive archive3 = index2.addArchive(0);

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FSFile file = archive.addFile(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FSFile file = archive2.addFile(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}

			for (int i = 0; i < NUMBER_OF_FILES; ++i)
			{
				FSFile file = archive3.addFile(i);
				file.setNameHash(random.nextInt(Integer.MAX_VALUE));
				byte[] data = new byte[random.nextInt(1024)];
				random.nextBytes(data);
				file.setContents(data);
			}

			store.save();

			try (Store store2 = new Store(root))
			{
				store2.load();

				Assert.assertEquals(store, store2);
			}

			// Test tree save/load
			File tree = folder.newFolder();
			Storage treeStorage = new TreeStorage(tree);

			treeStorage.save(store);

			try (Store store2 = new Store(treeStorage))
			{
				store2.load();
			}
		}
	}
}
