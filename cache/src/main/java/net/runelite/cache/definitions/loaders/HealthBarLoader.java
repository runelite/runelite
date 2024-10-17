/*
 * Copyright (c) 2020, Trevor <https://github.com/Trevor159>
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
package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.HealthBarDefinition;
import net.runelite.cache.io.InputStream;

public class HealthBarLoader
{
	public HealthBarDefinition load(int id, byte[] b)
	{
		HealthBarDefinition def = new HealthBarDefinition();
		InputStream is = new InputStream(b);
		def.id = id;

		while (true)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			this.decodeValues(opcode, def, is);
		}

		return def;
	}

	private void decodeValues(int opcode, HealthBarDefinition def, InputStream stream)
	{
		if (opcode == 1)
		{
			stream.readUnsignedShort();
		}
		else if (opcode == 2)
		{
			def.field3277 = stream.readUnsignedByte();
		}
		else if (opcode == 3)
		{
			def.field3278 = stream.readUnsignedByte();
		}
		else if (opcode == 4)
		{
			def.field3283 = 0;
		}
		else if (opcode == 5)
		{
			def.field3275 = stream.readUnsignedShort();
		}
		else if (opcode == 6)
		{
			stream.readUnsignedByte();
		}
		else if (opcode == 7)
		{
			def.healthBarFrontSpriteId = stream.readBigSmart2();
		}
		else if (opcode == 8)
		{
			def.healthBarBackSpriteId = stream.readBigSmart2();
		}
		else if (opcode == 11)
		{
			def.field3283 = stream.readUnsignedShort();
		}
		else if (opcode == 14)
		{
			def.healthScale = stream.readUnsignedByte();
		}
		else if (opcode == 15)
		{
			def.healthBarPadding = stream.readUnsignedByte();
		}
	}
}
