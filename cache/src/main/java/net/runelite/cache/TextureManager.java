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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.loaders.TextureLoader;
import net.runelite.cache.definitions.providers.TextureProvider;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;

public class TextureManager implements TextureProvider
{
	private final Store store;
	private final List<TextureDefinition> textures = new ArrayList<>();

	public TextureManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.TEXTURES);
		Archive archive = index.getArchive(0);

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		TextureLoader loader = new TextureLoader();

		for (FSFile file : files.getFiles())
		{
			TextureDefinition texture = loader.load(file.getFileId(), file.getContents());
			textures.add(texture);
		}
	}

	public List<TextureDefinition> getTextures()
	{
		return textures;
	}

	public TextureDefinition findTexture(int id)
	{
		for (TextureDefinition td : textures)
		{
			if (td.getId() == id)
			{
				return td;
			}
		}
		return null;
	}

	@Override
	public TextureDefinition[] provide()
	{
		return textures.toArray(new TextureDefinition[textures.size()]);
	}
}
