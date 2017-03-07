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

import java.util.ArrayList;
import java.util.List;

public class InstructionContext
{
	private final ScriptInstruction scriptInstruction;

	private final List<StackContext> ipops = new ArrayList<>();
	private final List<StackContext> spops = new ArrayList<>();
	private final List<StackContext> ipushes = new ArrayList<>();
	private final List<StackContext> spushes = new ArrayList<>();

	public InstructionContext(ScriptInstruction scriptInstruction)
	{
		this.scriptInstruction = scriptInstruction;
	}

	public ScriptInstruction getScriptInstruction()
	{
		return scriptInstruction;
	}

	public void popsInt(StackContext... ctx)
	{
		for (StackContext s : ctx)
		{
			ipops.add(s);
		}
	}

	public void popsString(StackContext... ctx)
	{
		for (StackContext s : ctx)
		{
			spops.add(s);
		}
	}

	public void pushesInt(StackContext... ctx)
	{
		for (StackContext s : ctx)
		{
			ipushes.add(s);
		}
	}

	public void pushesString(StackContext... ctx)
	{
		for (StackContext s : ctx)
		{
			spushes.add(s);
		}

	}

	public List<StackContext> getIpops()
	{
		return ipops;
	}

	public List<StackContext> getSpops()
	{
		return spops;
	}

	public List<StackContext> getIpushes()
	{
		return ipushes;
	}

	public List<StackContext> getSpushes()
	{
		return spushes;
	}
}
