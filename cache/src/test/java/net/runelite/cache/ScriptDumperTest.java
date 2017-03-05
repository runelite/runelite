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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.script.Instruction;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.Opcodes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(ScriptDumperTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		java.io.File outDir = folder.newFolder();
		int count = 0;

		Instructions.init();

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

				java.io.File outFile = new java.io.File(outDir, archive.getArchiveId() + ".rs2asm");
				writeScript(outFile, script);

				++count;
			}
		}

		logger.info("Dumped {} scripts to {}", count, outDir);
	}

	private boolean isJump(int opcode)
	{
		switch (opcode)
		{
			case Opcodes.JUMP:
			case Opcodes.IF_ICMPEQ:
			case Opcodes.IF_ICMPGE:
			case Opcodes.IF_ICMPGT:
			case Opcodes.IF_ICMPLE:
			case Opcodes.IF_ICMPLT:
			case Opcodes.IF_ICMPNE:
				return true;
			default:
				return false;
		}
	}

	private boolean[] needLabel(ScriptDefinition script)
	{
		int[] instructions = script.getInstructions();
		int[] iop = script.getIntOperands();
		boolean[] jumped = new boolean[instructions.length];

		for (int i = 0; i < instructions.length; ++i)
		{
			int opcode = instructions[i];

			if (!isJump(opcode))
			{
				continue;
			}

			// + 1 because the jumps go to the instructions prior to the
			// one you really want, because the pc is incremented on the
			// next loop
			int to = i + iop[i] + 1;
			assert to >= 0 && to < instructions.length;

			jumped[to] = true;
		}

		return jumped;
	}

	private void writeScript(java.io.File file, ScriptDefinition script) throws IOException
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			int[] instructions = script.getInstructions();
			int[] iops = script.getIntOperands();
			String[] sops = script.getStringOperands();

			assert iops.length == instructions.length;
			assert sops.length == instructions.length;

			boolean[] jumps = needLabel(script);

			for (int i = 0; i < instructions.length; ++i)
			{
				int opcode = instructions[i];
				int iop = iops[i];
				String sop = sops[i];

				Instruction ins = Instructions.find(opcode);
				if (ins == null)
				{
					logger.warn("Unknown instruction {} in script {}", opcode, script.getId());
				}

				String name;
				if (ins != null && ins.getName() != null)
				{
					name = ins.getName();
				}
				else
				{
					name = String.format("%03d", opcode);
				}

				if (jumps[i])
				{
					// something jumps here
					writer.write("LABEL" + i + ":\n");
				}

				writer.write(String.format("   %-22s", name));

				if (iop != 0 || opcode == Opcodes.LOAD_INT)
				{
					if (isJump(opcode))
					{
						writer.write(" LABEL" + (i + iop + 1));
					}
					else
					{
						writer.write(" " + iop);
					}
				}

				if (sop != null)
				{
					writer.write(" \"" + sop + "\"");
				}
				writer.write("\n");
			}
		}
	}
}
