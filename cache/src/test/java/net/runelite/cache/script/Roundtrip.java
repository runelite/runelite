/*
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.cache.script;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import net.runelite.cache.IndexType;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.script.assembler.Assembler;
import net.runelite.cache.script.disassembler.Disassembler;
import net.runelite.cache.util.Djb2;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class Roundtrip
{
	@Test
	@Ignore
	public void fullRoundtrip() throws IOException
	{
		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.CLIENTSCRIPT);
			ScriptLoader loader = new ScriptLoader();

			Disassembler disassembler = new Disassembler();

			Instructions instructions = new Instructions();
			instructions.init();

			Assembler assembler = new Assembler(instructions);

			for (Archive archive : index.getArchives())
			{
				if (archive.getNameHash() == Djb2.hash("version.dat"))
				{
					continue;
				}

				byte[] contents = archive.decompress(storage.loadArchive(archive));
				if (contents == null)
				{
					continue;
				}

				ScriptDefinition oldScript = loader.load(archive.getArchiveId(), contents);
				String scriptStr = disassembler.disassemble(oldScript);

				ScriptDefinition newScript = assembler.assemble(new ByteArrayInputStream(scriptStr.getBytes(StandardCharsets.UTF_8)));

				String message = "script " + archive.getArchiveId();
				assertEquals(message, oldScript.getId(), newScript.getId());
				assertEquals(message, oldScript.getLocalIntCount(), newScript.getLocalIntCount());
				assertEquals(message, oldScript.getLocalObjCount(), newScript.getLocalObjCount());
				assertEquals(message, oldScript.getIntArgCount(), newScript.getIntArgCount());
				assertEquals(message, oldScript.getObjArgCount(), newScript.getObjArgCount());
				assertArrayEquals(message, oldScript.getInstructions(), newScript.getInstructions());
				assertArrayEquals(message, oldScript.getIntOperands(), newScript.getIntOperands());
				assertArrayEquals(message, oldScript.getStringOperands(), newScript.getStringOperands());
				assertArrayEquals(message, oldScript.getSwitches(), newScript.getSwitches());
			}
		}
	}
}
