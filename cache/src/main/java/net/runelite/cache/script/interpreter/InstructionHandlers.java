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

import java.util.HashMap;
import java.util.Map;
import net.runelite.cache.script.Opcodes;
import net.runelite.cache.script.interpreter.instructions.If_ICmpEQ;
import net.runelite.cache.script.interpreter.instructions.If_ICmpGE;
import net.runelite.cache.script.interpreter.instructions.If_ICmpGT;
import net.runelite.cache.script.interpreter.instructions.If_ICmpLE;
import net.runelite.cache.script.interpreter.instructions.If_ICmpLT;
import net.runelite.cache.script.interpreter.instructions.If_ICmpNE;
import net.runelite.cache.script.interpreter.instructions.Invoke;
import net.runelite.cache.script.interpreter.instructions.Jump;
import net.runelite.cache.script.interpreter.instructions.LoadInt;
import net.runelite.cache.script.interpreter.instructions.Return;
import net.runelite.cache.script.interpreter.instructions.StringAppend;
import net.runelite.cache.script.interpreter.instructions.Switch;

public class InstructionHandlers
{
	private static final Map<Integer, InstructionHandler> handlers = new HashMap<>();

	static
	{
		init();
	}

	private static void init()
	{
		add(Opcodes.LOAD_INT, new LoadInt());
		add(Opcodes.JUMP, new Jump());
		add(Opcodes.IF_ICMPNE, new If_ICmpNE());
		add(Opcodes.IF_ICMPEQ, new If_ICmpEQ());
		add(Opcodes.IF_ICMPLT, new If_ICmpLT());
		add(Opcodes.IF_ICMPGT, new If_ICmpGT());
		add(Opcodes.IF_ICMPLE, new If_ICmpLE());
		add(Opcodes.IF_ICMPGE, new If_ICmpGE());
		add(Opcodes.INVOKE, new Invoke());
		add(Opcodes.RETURN, new Return());
		add(Opcodes.SWITCH, new Switch());
		add(Opcodes.STRING_APPEND, new StringAppend());
	}

	private static void add(int opcode, InstructionHandler handler)
	{
		assert handlers.containsKey(opcode) == false;
		handlers.put(opcode, handler);
	}

	public static InstructionHandler find(int opcode)
	{
		return handlers.get(opcode);
	}
}
