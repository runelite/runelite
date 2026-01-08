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

import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.WorldMapCompositeDefinition;
import net.runelite.cache.definitions.WorldMapElementDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.definitions.loaders.WorldMapCompositeLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.fs.Index;
import net.runelite.cache.region.Position;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMapManager
{
	private final Store store;
	private final List<WorldMapCompositeDefinition> worldMapCompositeDefinitions = new ArrayList<>();
	private final List<WorldMapElementDefinition> elements = new ArrayList<>();
	private final Map<Position, Position> intermapLinks = new HashMap<>();

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

		for (WorldMapCompositeDefinition compositeDefinition : worldMapCompositeDefinitions)
		{
			elements.addAll(compositeDefinition.getWorldMapElementDefinitions());
		}

		// Intermap links. These are stored in a client script, so we have to parse it from there.
		final int intermapLinkScriptId = 1705;
		Index scriptIndex = store.getIndex(IndexType.CLIENTSCRIPT);
		Archive intermapLinkScript = scriptIndex.getArchive(intermapLinkScriptId);
		byte[] data = storage.loadArchive(intermapLinkScript);
		FSFile file = intermapLinkScript.getFiles(data).findFile(0);

		ScriptLoader scriptLoader = new ScriptLoader();
		ScriptDefinition scriptDefinition = scriptLoader.load(intermapLinkScriptId, file.getContents());

		List<Position> linkEnds = new ArrayList<>();
		for (int i = 1; i < scriptDefinition.getIntOperands().length; ++i)
		{
			// 1706 is the script that gets called to jump to a location and the position is the int just before it
			if (scriptDefinition.getIntOperands()[i] == 1706)
			{
				linkEnds.add(Position.fromPacked(scriptDefinition.getIntOperands()[i - 1]));
			}
		}

		// The starting positions are in switch cases. We need to sort the cases by their jump positions
		// so that they correspond to the end position in the int operands.
		Map<Integer, Integer> linkSwitch = scriptDefinition.getSwitches()[0];
		int[] linkStarts = Arrays.stream(linkSwitch.keySet().toArray())
				.sorted(Comparator.comparingInt(linkSwitch::get))
				.mapToInt(i -> (int)i)
				.toArray();
		assert (linkStarts.length - 1) == linkEnds.size(); // The last case in the switch statement is the default case

		for (int i = 0; i < linkStarts.length; ++i)
		{
			Position linkStartPosition = Position.fromPacked(linkStarts[i]);
			Position linkEndPosition = linkEnds.get(i);
			intermapLinks.put(linkStartPosition, linkEndPosition);
		}
	}

	public List<WorldMapElementDefinition> getElements()
	{
		return elements;
	}

	public Map<Position, Position> getIntermapLinks()
	{
		return intermapLinks;
	}
}
