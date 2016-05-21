/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.fs;

import com.google.common.io.Files;
import java.io.FileOutputStream;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class StoreLoadTest
{
	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void testLoad() throws IOException
	{
		Store store = new Store(StoreLocation.LOCATION);
		store.load();
		System.out.println(store);
	}

	@Test
	public void testSave() throws IOException
	{
		Store store = new Store(StoreLocation.LOCATION);
		store.load();

		java.io.File testStoreFile = new java.io.File("d:/temp/");//folder.newFolder();
		for (java.io.File f : StoreLocation.LOCATION.listFiles())
			Files.copy(f, new java.io.File(testStoreFile, f.getName()));

		Store testStore = new Store(testStoreFile);
		testStore.load();

		Assert.assertTrue(store.equals(testStore));

		testStore.save();
		testStore.load();

		Assert.assertTrue(store.equals(testStore));
	}

	//@Test
	public void unpackStore() throws IOException
	{
		java.io.File base = StoreLocation.LOCATION;
		try (Store store = new Store(base))
		{
			store.load();

			for (Index i : store.getIndexes())
			{
				java.io.File ifile = new java.io.File(folder.newFolder(), "" + i.getId());
				ifile.mkdir();

				for (Archive a : i.getArchives())
				{
					java.io.File afile = new java.io.File(ifile, "" + a.getArchiveId());
					afile.mkdir();

					for (File f : a.getFiles())
					{
						java.io.File ffile = new java.io.File(afile, "" + f.getFileId());
						try (FileOutputStream fout = new FileOutputStream(ffile))
						{
							if (f.getContents() != null)
							{
								fout.write(f.getContents());
							}
						}
					}
				}
			}
		}
	}
}
