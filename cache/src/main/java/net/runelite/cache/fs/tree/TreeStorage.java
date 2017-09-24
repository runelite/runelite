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
package net.runelite.cache.fs.tree;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;

public class TreeStorage implements Storage
{
	private final File folder;

	public TreeStorage(File folder)
	{
		this.folder = folder;
	}

	@Override
	public void init(Store store) throws IOException
	{
	}

	@Override
	public void close() throws IOException
	{
	}

	@Override
	public void load(Store store) throws IOException
	{
		for (File idx : folder.listFiles())
		{
			if (!idx.isDirectory())
			{
				continue;
			}

			int id = Integer.parseInt(idx.getName());
			Index index = store.addIndex(id);
			loadIndex(index, folder, idx);
		}

		Collections.sort(store.getIndexes(), (idx1, idx2) -> Integer.compare(idx1.getId(), idx2.getId()));
	}

	private void loadIndex(Index index, File parent, File to) throws IOException
	{
		for (File f : to.listFiles())
		{
			if (f.isDirectory())
			{
				int id = Integer.parseInt(f.getName());

				Archive archive = index.addArchive(id);
				loadTree(archive, to, f);
			}
			else if (f.getName().endsWith(".dat"))
			{
				// one file. archiveId-fileId-name
				String[] parts = Files.getNameWithoutExtension(f.getName()).split("-");

				int id = Integer.parseInt(parts[0]);

				Archive archive = index.addArchive(id);
				loadTreeSingleFile(archive, to, f);
			}
			else if (f.getName().endsWith(".datc"))
			{
				// packed data
				String[] parts = Files.getNameWithoutExtension(f.getName()).split("-");

				int id = Integer.parseInt(parts[0]);

				Archive archive = index.addArchive(id);
				loadTreeData(archive, to, f);
			}
		}

		String str = Files.readFirstLine(new File(parent, index.getId() + ".rev"), Charset.defaultCharset());
		int revision = Integer.parseInt(str);
		index.setRevision(revision);

		Collections.sort(index.getArchives(), (ar1, ar2) -> Integer.compare(ar1.getArchiveId(), ar2.getArchiveId()));
	}

	public void loadTreeData(Archive archive, File parent, File from) throws IOException
	{
		//archiveId-fileId-fileName
		String[] parts = Files.getNameWithoutExtension(from.getName()).split("-");
		assert parts.length == 3;

		int archiveId = Integer.parseInt(parts[0]);
		int fileId = Integer.parseInt(parts[1]);
		int nameHash = (int) Long.parseLong(parts[2], 16);

		assert archiveId == archive.getArchiveId();

		byte[] data = Files.toByteArray(from);

		FSFile file = new FSFile(fileId);
		file.setNameHash(nameHash);
		file.setContents(data);
		archive.addFile(file);

		File archiveFile = new File(parent, archive.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setRevision(rev);

		archiveFile = new File(parent, archive.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setNameHash(name);
	}

	public void loadTreeSingleFile(Archive archive, File parent, File from) throws IOException
	{
		//archiveId-fileId-fileName
		String[] parts = Files.getNameWithoutExtension(from.getName()).split("-");
		assert parts.length == 3;

		int archiveId = Integer.parseInt(parts[0]);
		int fileId = Integer.parseInt(parts[1]);
		int nameHash = (int) Long.parseLong(parts[2], 16);

		assert archiveId == archive.getArchiveId();

		FSFile file = new FSFile(fileId);
		file.setNameHash(nameHash);
		archive.addFile(file);

		byte[] contents = Files.toByteArray(from);
		file.setContents(contents);

		File archiveFile = new File(parent, archive.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setRevision(rev);

		archiveFile = new File(parent, archive.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setNameHash(name);
	}

	public void loadTree(Archive archive, File parent, File from) throws IOException
	{
		List<FSFile> files = new ArrayList<>();

		for (File file : from.listFiles())
		{
			//fileId-fileName.dat
			String[] split = Files.getNameWithoutExtension(file.getName()).split("-");
			assert split.length == 2;

			int fileId = Integer.parseInt(split[0]);
			int fileName = (int) Long.parseLong(split[1], 16);

			FSFile f = new FSFile(fileId);
			f.setNameHash(fileName);
			files.add(f);

			byte[] contents = Files.toByteArray(file);
			f.setContents(contents);
		}

		// the filesystem may order these differently (eg, 1, 10, 2)
		Collections.sort(files, (f1, f2) -> Integer.compare(f1.getFileId(), f2.getFileId()));
		files.forEach(archive::addFile);

		File archiveFile = new File(parent, archive.getArchiveId() + ".rev");
		int rev = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setRevision(rev);

		archiveFile = new File(parent, archive.getArchiveId() + ".name");
		int name = Integer.parseInt(Files.readFirstLine(archiveFile, Charset.defaultCharset()));
		archive.setNameHash(name);
	}

	@Override
	public void save(Store store) throws IOException
	{
		for (Index i : store.getIndexes())
		{
			saveIndex(i);
		}
	}

	private void saveIndex(Index i) throws IOException
	{
		File idx = new File(folder, "" + i.getId());
		idx.mkdirs();

		for (Archive a : i.getArchives())
		{
			saveArchive(a, idx);
		}

		File rev = new File(folder, i.getId() + ".rev");
		Files.write(Integer.toString(i.getRevision()), rev, Charset.defaultCharset());
	}

	private void saveArchive(Archive a, File to) throws IOException
	{
		byte[] data = a.getData();
		List<FSFile> files = a.getFiles();

		if (data != null)
		{
			assert files.size() == 1; // this is the maps

			FSFile file = files.get(0);

			File archiveFile = new File(to, a.getArchiveId() + "-"
				+ file.getFileId() + "-" + Integer.toHexString(file.getNameHash()) + ".datc");
			Files.write(data, archiveFile);

			archiveFile = new File(to, a.getArchiveId() + ".rev");
			Files.write(Integer.toString(a.getRevision()), archiveFile, Charset.defaultCharset());

			archiveFile = new File(to, a.getArchiveId() + ".name");
			Files.write(Integer.toString(a.getNameHash()), archiveFile, Charset.defaultCharset());
			return;
		}

		if (files.size() == 1)
		{
			FSFile file = files.get(0);

			File archiveFile = new File(to, a.getArchiveId() + "-"
				+ file.getFileId() + "-" + Integer.toHexString(file.getNameHash()) + ".dat");
			byte[] contents = file.getContents();

			Files.write(contents, archiveFile);

			archiveFile = new File(to, a.getArchiveId() + ".rev");
			Files.write(Integer.toString(a.getRevision()), archiveFile, Charset.defaultCharset());

			archiveFile = new File(to, a.getArchiveId() + ".name");
			Files.write(Integer.toString(a.getNameHash()), archiveFile, Charset.defaultCharset());
			return;
		}

		File archiveFile = new File(to, a.getArchiveId() + ".rev");
		Files.write(Integer.toString(a.getRevision()), archiveFile, Charset.defaultCharset());

		archiveFile = new File(to, a.getArchiveId() + ".name");
		Files.write(Integer.toString(a.getNameHash()), archiveFile, Charset.defaultCharset());

		File archiveFolder = new File(to, Integer.toString(a.getArchiveId()));
		archiveFolder.mkdirs();

		for (FSFile file : files)
		{
			archiveFile = new File(archiveFolder, file.getFileId() + "-"
				+ Integer.toHexString(file.getNameHash()) + ".dat");
			byte[] contents = file.getContents();
			Files.write(contents, archiveFile);
		}
	}

}
