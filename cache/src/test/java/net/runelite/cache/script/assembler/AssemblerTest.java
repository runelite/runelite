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
package net.runelite.cache.script.assembler;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.disassembler.Disassembler;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class AssemblerTest
{
	private static final Logger logger = LoggerFactory.getLogger(AssemblerTest.class);

	@Parameter
	public String script;

	@Parameters
	public static String[] scripts()
	{
		return new String[]
		{
			"91.rs2asm",
			"681.rs2asm",
			"Unicode.rs2asm",
			"symbol.rs2asm"
		};
	}

	@Test
	public void testAssemble() throws Exception
	{
		InputStream in = AssemblerTest.class.getResourceAsStream(script);
		Assert.assertNotNull(in);

		Instructions instructions = new Instructions();
		instructions.init();

		Map<String, Object> symbols = Map.of("symtest", 42);
		Assembler assembler = new Assembler(instructions, symbols);
		ScriptDefinition script = assembler.assemble(in);

		// compare with disassembler
		Disassembler disassembler = new Disassembler(symbols);
		String out = disassembler.disassemble(script);

		in = AssemblerTest.class.getResourceAsStream(this.script);
		Assert.assertNotNull(in);

		String original = new String(IOUtils.toByteArray(in), StandardCharsets.UTF_8).replaceAll("\r\n", "\n");

		logger.info(original);
		logger.info("-----------------------");
		logger.info(out);

		Assert.assertEquals(original, out);
	}

}
