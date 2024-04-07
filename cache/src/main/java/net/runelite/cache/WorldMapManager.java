/*
 * Copyright (c) 2024, Christopher Brown <christoabrown@gmail.com>
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

import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.WorldMapCompositeDefinition;
import net.runelite.cache.definitions.WorldMapElementDefinition;
import net.runelite.cache.definitions.loaders.WorldMapCompositeLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.fs.Index;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WorldMapManager
{
	private final Store store;
	private final List<WorldMapCompositeDefinition> worldMapCompositeDefinitions = new ArrayList<>();

	public WorldMapManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.WORLDMAP);
		Archive compositeMapArchive = index.findArchiveByName("compositemap");
		WorldMapCompositeLoader worldMapCompositeLoader = new WorldMapCompositeLoader();

		ArchiveFiles compositeMapFiles = compositeMapArchive.getFiles(storage.loadArchive(compositeMapArchive));
		for (FSFile compositeFile : compositeMapFiles.getFiles())
		{
			WorldMapCompositeDefinition composite = worldMapCompositeLoader.load(compositeFile.getContents());
			worldMapCompositeDefinitions.add(composite);
		}
	}

	public List<WorldMapElementDefinition> getElements()
	{
		List<WorldMapElementDefinition> elements = new ArrayList<>();
		for (WorldMapCompositeDefinition compositeDefinition : worldMapCompositeDefinitions)
		{
			elements.addAll(compositeDefinition.getWorldMapElementDefinitions());
		}

		return elements;
	}
}
