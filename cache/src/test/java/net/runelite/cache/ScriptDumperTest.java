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
package net.runelite.cache;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(ScriptDumperTest.class);

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		java.io.File outDir = folder.newFolder();
		int count = 0;

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Index index = store.getIndex(IndexType.CLIENTSCRIPT);
			ScriptLoader loader = new ScriptLoader();

			for (Archive archive : index.getArchives())
			{
				assert archive.getFiles().size() == 1;

				File file = archive.getFiles().get(0);
				byte[] contents = file.getContents();

				ScriptDefinition script = loader.load(file.getFileId(), contents);

				java.io.File outFile = new java.io.File(outDir, archive.getArchiveId() + ".rs");
				writeScript(outFile, script);

				++count;
			}
		}

		logger.info("Dumped {} scripts to {}", count, outDir);
	}

	private void writeScript(java.io.File file, ScriptDefinition script) throws IOException
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			int length = script.getInstructions().length;

			assert script.getIntOperands().length == length;
			assert script.getStringOperands().length == length;

			for (int i = 0; i < length; ++i)
			{
				int opcode = script.getInstructions()[i];
				int iop = script.getIntOperands()[i];
				String sop = script.getStringOperands()[i];

				writer.write(String.format("0x%03x", opcode));
				if (iop != 0 || sop != null)
					writer.write(" " + iop);
				if (sop != null)
					writer.write(" " + sop);
				writer.write("\n");
			}
		}
	}
}
