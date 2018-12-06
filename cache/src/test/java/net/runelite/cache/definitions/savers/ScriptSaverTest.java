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
package net.runelite.cache.definitions.savers;

import java.io.IOException;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.assembler.Assembler;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Adam
 */
public class ScriptSaverTest
{
	private static final String SCRIPT_RESOURCE = "/net/runelite/cache/script/assembler/91.rs2asm";
	private static final String SCRIPT_RESOURCE_UNICODE = "/net/runelite/cache/script/assembler/Unicode.rs2asm";

	@Test
	public void testSave() throws IOException
	{
		Instructions instructions = new Instructions();
		instructions.init();
		ScriptDefinition script = new Assembler(instructions).assemble(getClass().getResourceAsStream(SCRIPT_RESOURCE));
		byte[] saved = new ScriptSaver().save(script);
		ScriptDefinition loadedScripot = new ScriptLoader().load(91, saved);
		assertEquals(script, loadedScripot);
	}

	@Test
	public void testSaveUnicode() throws IOException
	{
		Instructions instructions = new Instructions();
		instructions.init();
		ScriptDefinition script = new Assembler(instructions).assemble(getClass().getResourceAsStream(SCRIPT_RESOURCE_UNICODE));
		byte[] saved = new ScriptSaver().save(script);
		ScriptDefinition loadedScripot = new ScriptLoader().load(1001, saved);
		assertEquals(script, loadedScripot);
	}

}
