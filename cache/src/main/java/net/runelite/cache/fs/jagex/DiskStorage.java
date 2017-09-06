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
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.ArchiveData;
import net.runelite.cache.index.FileData;
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

	private void loadIndex(Index index) throws IOException
	{
		logger.trace("Loading index {}", index.getId());

		IndexEntry entry = index255.read(index.getId());
		byte[] indexData = data.read(index255.getIndexFileId(), entry.getId(), entry.getSector(), entry.getLength());
		DataFileReadResult res = DataFile.decompress(indexData, null);
		byte[] data = res.data;

		IndexData id = new IndexData();
		id.load(data);

		index.setProtocol(id.getProtocol());
		index.setRevision(id.getRevision());
		index.setNamed(id.isNamed());
		index.setUsesWhirpool(id.isUsesWhirpool());

		for (ArchiveData ad : id.getArchives())
		{
			Archive archive = index.addArchive(ad.getId());
			archive.setNameHash(ad.getNameHash());
			archive.setWhirlpool(ad.getWhirlpool());
			archive.setCrc(ad.getCrc());
			archive.setRevision(ad.getRevision());

			assert ad.getFiles().length > 0;

			for (FileData fd : ad.getFiles())
			{
				FSFile file = archive.addFile(fd.getId());
				file.setNameHash(fd.getNameHash());
			}
		}

		index.setCrc(res.crc);
		index.setWhirlpool(res.whirlpool);
		index.setCompression(res.compression);
		assert res.revision == -1;

		for (Archive archive : new ArrayList<>(index.getArchives()))
		{
			loadArchive(archive);
		}
	}

	private void loadArchive(Archive archive) throws IOException
	{
		Index index = archive.getIndex();
		IndexFile indexFile = getIndex(index.getId());

		assert indexFile.getIndexFileId() == index.getId();

		IndexEntry entry = indexFile.read(archive.getArchiveId());
		if (entry == null)
		{
			logger.debug("can't read archive " + archive.getArchiveId() + " from index " + index.getId());
			index.getArchives().remove(archive); // is this correct?
			return;
		}

		assert entry.getId() == archive.getArchiveId();

		logger.trace("Loading archive {} for index {} from sector {} length {}",
			archive.getArchiveId(), index.getId(), entry.getSector(), entry.getLength());

		byte[] archiveData = data.read(index.getId(), entry.getId(), entry.getSector(), entry.getLength());
		archive.setData(archiveData);

		if (index.getXteaManager() != null)
		{
			return; // can't decrypt this yet
		}

		archive.decompressAndLoad(null);
	}

	@Override
	public void save(Store store) throws IOException
	{
		logger.debug("Clearing data and indexes in preparation for store save");

		data.clear();

		for (IndexFile indexFile : indexFiles)
		{
			indexFile.clear();
		}

		logger.debug("Saving store");

		for (Index i : store.getIndexes())
		{
			saveIndex(i);
		}
	}

	private void saveIndex(Index index) throws IOException
	{
		// This updates archive CRCs for writeIndexData
		for (Archive archive : index.getArchives())
		{
			saveArchive(archive);
		}

		IndexData indexData = index.toIndexData();
		byte[] data = indexData.writeIndexData();

		byte[] compressedData = DataFile.compress(data, index.getCompression(), -1, null); // index data revision is always -1
		DataFileWriteResult res = this.data.write(index255.getIndexFileId(), index.getId(), compressedData, index.getRevision());

		index255.write(new IndexEntry(index255, index.getId(), res.sector, res.compressedLength));

		index.setCrc(res.crc);
		index.setWhirlpool(res.whirlpool);
	}

	private void saveArchive(Archive a) throws IOException
	{
		Index index = a.getIndex();
		IndexFile indexFile = getIndex(index.getId());
		assert indexFile.getIndexFileId() == index.getId();

		int rev; // used for determining what part of compressedData to crc
		byte[] compressedData;

		if (a.getData() != null)
		{
			compressedData = a.getData(); // data was never decompressed or loaded
			rev = -1; // assume that this data has no revision?
		}
		else
		{
			byte[] fileData = a.saveContents();
			rev = a.getRevision();
			compressedData = DataFile.compress(fileData, a.getCompression(), a.getRevision(), null);
		}

		DataFileWriteResult res = data.write(index.getId(), a.getArchiveId(), compressedData, rev);
		indexFile.write(new IndexEntry(indexFile, a.getArchiveId(), res.sector, res.compressedLength));

		logger.trace("Saved archive {}/{} at sector {}, compressed length {}", index.getId(), a.getArchiveId(), res.sector, res.compressedLength);

		a.setCrc(res.crc);
		a.setWhirlpool(res.whirlpool);
	}
}
