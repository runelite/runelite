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
package net.runelite.cache.script.interpreter;

import java.util.ArrayDeque;
import java.util.Queue;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.script.Instruction;
import net.runelite.cache.script.Instructions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interpreter
{
	private static final Logger logger = LoggerFactory.getLogger(Interpreter.class);

	private final Queue<Frame> frames = new ArrayDeque<>();
	private final GenericInstructionHandler genericInstructionHandler = new GenericInstructionHandler();

	public void run(ScriptDefinition script)
	{
		Instructions.init();

		Frame frame = new Frame(this, script);
		frames.add(frame);

		int count = 0;

		while (!frames.isEmpty())
		{
			frame = frames.remove();
			run(frame);
			++count;
		}

		logger.info("Processed {} frames", count);
	}

	private void run(Frame frame)
	{
		ScriptDefinition script = frame.getScript();

		int[] instructions = script.getInstructions();
		int[] iops = script.getIntOperands();
		String[] sops = script.getStringOperands();

		while (frame.isRunning())
		{
			if (frame.pc >= instructions.length)
			{
				throw new RuntimeException("PC went past end of instructions - maybe missing return");
			}

			int opcode = instructions[frame.pc];
			int iop = iops[frame.pc];
			String sop = sops[frame.pc];

			Instruction i = Instructions.find(opcode);
			if (i == null)
			{
				throw new RuntimeException("Unknown instruction " + opcode + " in script at pc " + frame.pc);
			}

			ScriptInstruction scriptInstruction = new ScriptInstruction(frame.pc, i, iop, sop);
			InstructionContext ctx = new InstructionContext(scriptInstruction);

			InstructionHandler handler = InstructionHandlers.find(opcode);
			if (handler == null)
			{
				handler = genericInstructionHandler;
			}

			int old = frame.pc;

			handler.execute(frame, ctx);

			if (old == frame.pc)
			{
				// not a jump
				++frame.pc;
			}
		}
	}

	public void addFrame(Frame frame)
	{
		frames.add(frame);
	}
}
