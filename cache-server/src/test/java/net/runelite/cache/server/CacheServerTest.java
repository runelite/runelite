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
package net.runelite.cache.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.client.CacheClient;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Container;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.FileData;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CacheServerTest
{
	private static final String HOST = "localhost";
	private static final int REVISION = 154;

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	@Ignore
	public void testDownload() throws Exception
	{
		try (Store store = new Store(StoreLocation.LOCATION);
			CacheServer server = new CacheServer(store, REVISION))
		{
			store.load();

			server.start();

			try (CacheClient client = new CacheClient(new Store(folder.newFolder()), HOST, REVISION))
			{
				client.connect();
				client.handshake().get();
				client.download();
			}
		}
	}

	@Test
	public void testServer() throws Exception
	{
		try (Store store = new Store(folder.newFolder());
			CacheServer server = new CacheServer(store, REVISION))
		{
			addInitialFilesToStore(store);

			store.save();

			server.start();

			try (Store store2 = new Store(folder.newFolder());
				CacheClient client = new CacheClient(store2, HOST, REVISION))
			{
				client.connect();
				client.handshake().get();
				client.download();

				Index index = store2.findIndex(0);
				Archive archive = index.getArchive(0);

				FileData[] files = archive.getFileData();
				FileData file = files[0];
				assertEquals(7, file.getNameHash());

				Storage storage = store2.getStorage();
				byte[] data = storage.loadArchive(archive);
				data = archive.decompress(data);
				assertArrayEquals("test".getBytes(), data);
				assertEquals(store.getIndexes().get(0).getArchive(0).getCrc(), archive.getCrc());
			}
		}
	}

	private void addInitialFilesToStore(Store store) throws FileNotFoundException, IOException
	{
		Storage storage = store.getStorage();
		Index index = store.addIndex(0);

		Archive archive = index.addArchive(0);
		FileData[] files = new FileData[1];
		archive.setFileData(files);
		FileData file = files[0] = new FileData();
		file.setNameHash(7);
		byte[] data = "test".getBytes();

		Container container = new Container(archive.getCompression(), -1);
		container.compress(data, null);
		byte[] compressedData = container.data;
		storage.saveArchive(archive, compressedData);
	}

}
