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

import java.io.IOException;
import java.io.InputStream;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instructions;
import net.runelite.cache.script.assembler.rs2asmParser.ProgContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Assembler
{
	private final Instructions instructions;

	public Assembler(Instructions instructions)
	{
		this.instructions = instructions;
	}

	public ScriptDefinition assemble(InputStream in) throws IOException
	{
		// Get our lexer
		rs2asmLexer lexer = new rs2asmLexer(CharStreams.fromStream(in));

		LexerErrorListener errorListener = new LexerErrorListener();
		lexer.addErrorListener(errorListener);

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		rs2asmParser parser = new rs2asmParser(tokens);

		// Specify our entry point
		ProgContext progContext = parser.prog();

		if (errorListener.getErrors() > 0)
		{
			throw new RuntimeException("syntax error");
		}

		// Walk it and attach our listener
		ParseTreeWalker walker = new ParseTreeWalker();

		// walk through first and resolve labels
		LabelVisitor labelVisitor = new LabelVisitor();
		walker.walk(labelVisitor, progContext);

		ScriptWriter listener = new ScriptWriter(instructions, labelVisitor);
		walker.walk(listener, progContext);

		return listener.buildScript();
	}
}
