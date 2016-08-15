/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.io.InputStream;

public class ScriptLoader
{
	public ScriptDefinition load(int id, byte[] b)
	{
		ScriptDefinition def = new ScriptDefinition();
		InputStream in = new InputStream(b);

		in.setOffset(in.getLength() - 12);
		int paramCount = in.readInt();
		int localIntCount = in.readUnsignedShort();
		int localStringCount = in.readUnsignedShort();
		int anInt2269 = in.readUnsignedShort();
		int anInt2276 = in.readUnsignedShort();

		def.setLocalIntCount(localIntCount);
		def.setLocalStringCount(localStringCount);
		def.setAnInt2269(anInt2269);
		def.setAnInt2276(anInt2276);

		in.setOffset(0);
		in.readStringOrNull();

		int[] instructions = new int[paramCount];
		int[] intOperands = new int[paramCount];
		String[] stringOperands = new String[paramCount];

		def.setInstructions(instructions);
		def.setIntOperands(intOperands);
		def.setStringOperands(stringOperands);

		int var3;
		for (int var6 = 0; in.getOffset() < in.getLength() - 12; instructions[var6++] = var3)
		{
			var3 = in.readUnsignedShort();
			if (var3 == 3)
			{
				stringOperands[var6] = in.readString();
			}
			else if (var3 < 100 && 21 != var3 && 38 != var3 && 39 != var3)
			{
				intOperands[var6] = in.readInt();
			}
			else
			{
				intOperands[var6] = in.readUnsignedByte();
			}
		}

		return def;
	}
}
