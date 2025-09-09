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
package net.runelite.cache.fs.jagex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Container;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.ArchiveData;
import net.runelite.cache.index.IndexData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskStorage implements Storage
{
	private static final Logger logger = LoggerFactory.getLogger(DiskStorage.class);

	private static final String MAIN_FILE_CACHE_DAT = "main_file_cache.dat2";
	private static final String MAIN_FILE_CACHE_IDX = "main_file_cache.idx";

	private final File folder;

	private final DataFile data;
	private final IndexFile index255;
	private final List<IndexFile> indexFiles = new ArrayList<>();

	public DiskStorage(File folder) throws IOException
	{
		this.folder = folder;

		this.data = new DataFile(new File(folder, MAIN_FILE_CACHE_DAT));
		this.index255 = new IndexFile(255, new File(folder, MAIN_FILE_CACHE_IDX + "255"));
	}

	@Override
	public void init(Store store) throws IOException
	{
		for (int i = 0; i < index255.getIndexCount(); ++i)
		{
			store.addIndex(i);
			getIndex(i);
		}

		assert store.getIndexes().size() == indexFiles.size();
	}

	@Override
	public void close() throws IOException
	{
		data.close();
		index255.close();
		for (IndexFile indexFile : indexFiles)
		{
			indexFile.close();
		}
	}

	private IndexFile getIndex(int i) throws FileNotFoundException
	{
		if (i == 255)
		{
			return index255;
		}

		for (IndexFile indexFile : indexFiles)
		{
			if (indexFile.getIndexFileId() == i)
			{
				return indexFile;
			}
		}

		IndexFile indexFile = new IndexFile(i, new File(folder, MAIN_FILE_CACHE_IDX + i));
		indexFiles.add(indexFile);
		return indexFile;
	}

	@Override
	public void load(Store store) throws IOException
	{
		for (Index index : store.getIndexes())
		{
			loadIndex(index);
		}
	}

	public byte[] readIndex(int indexId) throws IOException
	{
		IndexEntry entry = index255.read(indexId);
		if (entry == null)
		{
			return null;
		}

		byte[] indexData = data.read(index255.getIndexFileId(), entry.getId(), entry.getSector(), entry.getLength());
		return indexData;
	}

	private void loadIndex(Index index) throws IOException
	{
		logger.trace("Loading index {}", index.getId());

		byte[] indexData = readIndex(index.getId());
		if (indexData == null)
		{
			return;
		}

		Container res = Container.decompress(indexData, null);
		byte[] data = res.data;

		IndexData id = new IndexData();
		id.load(data);

		index.setProtocol(id.getProtocol());
		index.setRevision(id.getRevision());
		index.setNamed(id.isNamed());
		index.setSized(id.isSized());

		for (ArchiveData ad : id.getArchives())
		{
			Archive archive = index.addArchive(ad.getId());
			archive.setNameHash(ad.getNameHash());
			archive.setCrc(ad.getCrc());
			archive.setCompressedSize(ad.getCompressedSize());
			archive.setDecompressedSize(ad.getDecompressedSize());
			archive.setRevision(ad.getRevision());
			archive.setFileData(ad.getFiles());

			assert ad.getFiles().length > 0;
		}

		index.setCrc(res.crc);
		index.setCompression(res.compression);
		assert res.revision == -1;
	}

	@Override
	public void save(Store store) throws IOException
	{
		logger.debug("Saving store");

		for (Index i : store.getIndexes())
		{
			saveIndex(i);
		}
	}

	private void saveIndex(Index index) throws IOException
	{
		IndexData indexData = index.toIndexData();
		byte[] data = indexData.writeIndexData();

		Container container = new Container(index.getCompression(), -1); // index data revision is always -1
		container.compress(data, null);
		byte[] compressedData = container.data;

		store(255, index.getId(), compressedData);

		index.setCrc(container.crc);
	}

	@Override
	public byte[] load(int index, int archive) throws IOException
	{
		IndexFile indexFile = getIndex(index);

		assert indexFile.getIndexFileId() == index;

		IndexEntry entry = indexFile.read(archive);
		if (entry == null)
		{
			logger.debug("can't read archive {} from index {}", archive, index);
			return null;
		}

		assert entry.getId() == archive;

		logger.trace("Loading archive {} for index {} from sector {} length {}",
			archive, index, entry.getSector(), entry.getLength());

		byte[] archiveData = data.read(index, entry.getId(), entry.getSector(), entry.getLength());
		return archiveData;
	}

	@Override
	public void store(int index, int archive, byte[] archiveData) throws IOException
	{
		IndexFile indexFile = getIndex(index);
		assert indexFile.getIndexFileId() == index;

		DataFileWriteResult res = data.write(index, archive, archiveData);
		indexFile.write(new IndexEntry(indexFile, archive, res.sector, res.compressedLength));

		logger.trace("Saved archive {}/{} at sector {}, compressed length {}",
			index, archive, res.sector, res.compressedLength);
	}
}
