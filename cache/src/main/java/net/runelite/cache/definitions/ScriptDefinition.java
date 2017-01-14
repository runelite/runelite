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

package net.runelite.cache.definitions;

public class ScriptDefinition
{
	private int id;
        private int anInt2269;
        private int[] instructions;
        private int[] intOperands;
        private String[] stringOperands;
        private int localStringCount;
        private int anInt2276;
        private int localIntCount;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAnInt2269()
	{
		return anInt2269;
	}

	public void setAnInt2269(int anInt2269)
	{
		this.anInt2269 = anInt2269;
	}

	public int[] getInstructions()
	{
		return instructions;
	}

	public void setInstructions(int[] instructions)
	{
		this.instructions = instructions;
	}

	public int[] getIntOperands()
	{
		return intOperands;
	}

	public void setIntOperands(int[] intOperands)
	{
		this.intOperands = intOperands;
	}

	public String[] getStringOperands()
	{
		return stringOperands;
	}

	public void setStringOperands(String[] stringOperands)
	{
		this.stringOperands = stringOperands;
	}

	public int getLocalStringCount()
	{
		return localStringCount;
	}

	public void setLocalStringCount(int localStringCount)
	{
		this.localStringCount = localStringCount;
	}

	public int getAnInt2276()
	{
		return anInt2276;
	}

	public void setAnInt2276(int anInt2276)
	{
		this.anInt2276 = anInt2276;
	}

	public int getLocalIntCount()
	{
		return localIntCount;
	}

	public void setLocalIntCount(int localIntCount)
	{
		this.localIntCount = localIntCount;
	}
}
