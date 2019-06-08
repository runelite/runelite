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
package net.runelite.cache.script.disassembler;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import net.runelite.cache.IndexType;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisassemblerTest
{
	private static final Logger logger = LoggerFactory.getLogger(DisassemblerTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		File outDir = folder.newFolder();
		int count = 0;

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.CLIENTSCRIPT);
			ScriptLoader loader = new ScriptLoader();

			for (Archive archive : index.getArchives())
			{
				byte[] contents = archive.decompress(storage.loadArchive(archive));

				if (contents == null)
				{
					continue;
				}

				ScriptDefinition script = loader.load(archive.getArchiveId(), contents);

				File outFile = new File(outDir, archive.getArchiveId() + ".rs2asm");

				Disassembler disassembler = new Disassembler();
				String out = disassembler.disassemble(script);

				Files.write(out.getBytes(), outFile);

				++count;
			}
		}

		logger.info("Dumped {} scripts to {}", count, outDir);
	}
}
