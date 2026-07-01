/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018-2019, Hunter WB <hunterwb.com>
 * Copyright (c) 2019, Abex
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

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;

public class Instructions implements Opcodes
{
	private final Map<Integer, String> opToName = new HashMap<>();
	private final Map<String, Integer> nameToOp = new HashMap<>();

	@SneakyThrows
	public void init()
	{
		for (Field f : Opcodes.class.getDeclaredFields())
		{
			String name = f.getName();
			int value = f.getInt(null);
			add(value, name.toLowerCase());
		}
	}

	protected void add(int opcode, String name)
	{
		assert !opToName.containsKey(opcode);
		assert !nameToOp.containsKey(name);
		opToName.put(opcode, name);
		nameToOp.put(name, opcode);
	}

	public String findNameFromOpcode(int opcode)
	{
		return opToName.get(opcode);
	}

	public Integer findOpcodeFromName(String name)
	{
		return nameToOp.get(name);
	}
}
