/*
 * Copyright (c) 2018 Abex
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.index.FileData;

/**
 * A Storage that stores the cache as a series of flat files, designed
 * to be git revisioned.
 */
public class FlatStorage implements Storage
{
	protected static final String EXTENSION = ".flatcache";

	private final File directory;
	private final Map<Long, byte[]> data = new HashMap<>();

	public FlatStorage(File directory) throws IOException
	{
		this.directory = directory;
	}

	protected FlatStorage()
	{
		this.directory = null;
	}

	protected InputStream openReader(String filename) throws IOException
	{
		return new FileInputStream(new File(directory, filename));
	}

	protected OutputStream openWriter(String filename) throws IOException
	{
		return new FileOutputStream(new File(directory, filename));
	}

	protected String[] listFlatcacheFiles() throws IOException
	{
		return directory.list((dir, name) -> name.endsWith(EXTENSION));
	}

	@Override
	public void init(Store store) throws IOException
	{
		String[] idxs = listFlatcacheFiles();
		for (String idx : idxs)
		{
			int id = Integer.parseInt(idx.substring(0, idx.length() - EXTENSION.length()));
			store.addIndex(id);
		}
	}

	@Override
	public void close() throws IOException
	{
	}

	@Override
	public void load(Store store) throws IOException
	{
		for (Index idx : store.getIndexes())
		{
			String file = idx.getId() + EXTENSION;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(openReader(file))))
			{
				int lineNo = 0;
				Archive archive = null;
				List<FileData> fileData = null;
				for (String line = br.readLine(); line != null; line = br.readLine())
				{
					lineNo++;

					try
					{
						int lidx = line.indexOf('=');
						String key = line.substring(0, lidx);
						String value = line.substring(lidx + 1);

						if ("file".equals(key))
						{
							if (fileData == null)
							{
								fileData = new ArrayList<>();
							}

							int vidx = value.indexOf('=');
							FileData fd = new FileData();
							fd.setId(Integer.parseInt(value.substring(0, vidx)));
							fd.setNameHash(Integer.parseInt(value.substring(vidx + 1)));
							fileData.add(fd);
							continue;
						}
						else if (fileData != null)
						{
							archive.setFileData(fileData.toArray(new FileData[0]));
							fileData = null;
						}

						if ("id".equals(key))
						{
							archive = idx.addArchive(Integer.parseInt(value));
							continue;
						}

						if (archive == null)
						{
							switch (key)
							{
								case "protocol":
									idx.setProtocol(Integer.parseInt(value));
									continue;
								case "revision":
									idx.setRevision(Integer.parseInt(value));
									continue;
								case "compression":
									idx.setCompression(Integer.parseInt(value));
									continue;
								case "crc":
									idx.setCrc(Integer.parseInt(value));
									continue;
								case "named":
									idx.setNamed(Boolean.parseBoolean(value));
									continue;
							}
						}
						else
						{
							switch (key)
							{
								case "namehash":
									archive.setNameHash(Integer.parseInt(value));
									continue;
								case "revision":
									archive.setRevision(Integer.parseInt(value));
									continue;
								case "crc":
									archive.setCrc(Integer.parseInt(value));
									continue;
								case "hash":
									archive.setHash(Base64.getDecoder().decode(value));
									continue;
								case "compression":
									archive.setCompression(Integer.parseInt(value));
									continue;
								case "contents":
									data.put((long) idx.getId() << 32 | archive.getArchiveId(), Base64.getDecoder().decode(value));
									continue;
							}
						}
						throw new IOException("unknown key: \"" + key + "\"");
					}
					catch (Exception e)
					{
						throw new IOException("error reading flatcache at " + file + ":" + lineNo, e);
					}
				}

				if (fileData != null)
				{
					archive.setFileData(fileData.toArray(new FileData[0]));
					fileData = null;
				}
			}
		}
	}

	@Override
	public void save(Store store) throws IOException
	{
		store.getIndexes().sort(Comparator.comparing(Index::getId));
		for (Index idx : store.getIndexes())
		{
			String file = idx.getId() + EXTENSION;
			try (PrintStream br = new PrintStream(openWriter(file)))
			{
				br.printf("protocol=%d\n", idx.getProtocol());
				br.printf("revision=%d\n", idx.getRevision());
				br.printf("compression=%d\n", idx.getCompression());
				br.printf("crc=%d\n", idx.getCrc());
				br.printf("named=%b\n", idx.getCompression());

				idx.getArchives().sort(Comparator.comparing(Archive::getArchiveId));
				for (Archive archive : idx.getArchives())
				{
					br.printf("id=%d\n", archive.getArchiveId());
					br.printf("namehash=%d\n", archive.getNameHash());
					br.printf("revision=%d\n", archive.getRevision());
					br.printf("crc=%d\n", archive.getCrc());

					if (archive.getHash() != null)
					{
						br.append("hash=");
						br.write(Base64.getEncoder().encode(archive.getHash()));
						br.append("\n");
					}

					byte[] contents = store.getStorage().loadArchive(archive);
					if (contents != null)
					{
						br.append("contents=");
						br.write(Base64.getEncoder().encode(contents));
						br.append("\n");
					}

					br.printf("compression=%d\n", archive.getCompression());
					for (FileData fd : archive.getFileData())
					{
						br.printf("file=%d=%d\n", fd.getId(), fd.getNameHash());
					}
				}
			}
		}
	}

	@Override
	public byte[] loadArchive(Archive archive) throws IOException
	{
		return data.get((long) archive.getIndex().getId() << 32 | archive.getArchiveId());
	}

	@Override
	public void saveArchive(Archive archive, byte[] bytes) throws IOException
	{
		data.put((long) archive.getIndex().getId() << 32 | archive.getArchiveId(), bytes);
	}
}
