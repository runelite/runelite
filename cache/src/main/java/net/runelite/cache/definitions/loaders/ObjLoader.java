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

package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.ObjDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class ObjLoader
{
	private static final Logger logger = LoggerFactory.getLogger(ObjLoader.class);

	public ObjDefinition load(int id, byte[] b)
	{
		ObjDefinition def = new ObjDefinition(id);
		InputStream is = new InputStream(b);

		while (true)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			this.decodeValues(opcode, def, is);
		}

		post(def);

		return def;
	}

	private void decodeValues(int opcode, ObjDefinition def, InputStream stream)
	{
		if (opcode == 1)
		{
			def.model = stream.readUnsignedShort();
		}
		else if (opcode == 2)
		{
			def.name = stream.readString();
		}
		else if (opcode == 3)
		{
			def.desc = stream.readString();
		}
		else if (opcode == 4)
		{
			def.zoom2d = stream.readUnsignedShort();
		}
		else if (opcode == 5)
		{
			def.xan2d = stream.readUnsignedShort();
		}
		else if (opcode == 6)
		{
			def.yan2d = stream.readUnsignedShort();
		}
		else if (opcode == 7)
		{
			def.xof2d = stream.readUnsignedShort();
			if (def.xof2d > 32767)
			{
				def.xof2d -= 65536;
			}
		}
		else if (opcode == 8)
		{
			def.yof2d = stream.readUnsignedShort();
			if (def.yof2d > 32767)
			{
				def.yof2d -= 65536;
			}
		}
		else if (opcode == 9)
		{
			def.unknown1 = stream.readString();
		}
		else if (opcode == 11)
		{
			def.stackable = 1;
		}
		else if (opcode == 12)
		{
			def.cost = stream.readInt();
		}
		else if (opcode == 13)
		{
			def.wearpos = stream.readByte();
		}
		else if (opcode == 14)
		{
			def.wearpos2 = stream.readByte();
		}
		else if (opcode == 16)
		{
			def.members = true;
		}
		else if (opcode == 23)
		{
			def.manwear = stream.readUnsignedShort();
			def.manwearOffsetY = stream.readUnsignedByte();
		}
		else if (opcode == 24)
		{
			def.manwear2 = stream.readUnsignedShort();
		}
		else if (opcode == 25)
		{
			def.womanwear = stream.readUnsignedShort();
			def.womanwearOffsetY = stream.readUnsignedByte();
		}
		else if (opcode == 26)
		{
			def.womanwear2 = stream.readUnsignedShort();
		}
		else if (opcode == 27)
		{
			def.wearpos3 = stream.readByte();
		}
		else if (opcode >= 30 && opcode < 35)
		{
			def.op[opcode - 30] = stream.readString();
			if (def.op[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				def.op[opcode - 30] = null;
			}
		}
		else if (opcode >= 35 && opcode < 40)
		{
			def.iop[opcode - 35] = stream.readString();
		}
		else if (opcode == 40)
		{
			int var5 = stream.readUnsignedByte();
			def.recol_s = new short[var5];
			def.recol_d = new short[var5];

			for (int var4 = 0; var4 < var5; ++var4)
			{
				def.recol_s[var4] = (short) stream.readUnsignedShort();
				def.recol_d[var4] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 41)
		{
			int var5 = stream.readUnsignedByte();
			def.retex_s = new short[var5];
			def.retex_d = new short[var5];

			for (int var4 = 0; var4 < var5; ++var4)
			{
				def.retex_s[var4] = (short) stream.readUnsignedShort();
				def.retex_d[var4] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 42)
		{
			// unknown jagex name
			def.shiftClickDropIndex = stream.readByte();
		}
		else if (opcode == 65)
		{
			def.stockmarket = true;
		}
		else if (opcode == 75)
		{
			def.weight = stream.readShort();
		}
		else if (opcode == 78)
		{
			def.manwear3 = stream.readUnsignedShort();
		}
		else if (opcode == 79)
		{
			def.womanwear3 = stream.readUnsignedShort();
		}
		else if (opcode == 90)
		{
			def.manhead = stream.readUnsignedShort();
		}
		else if (opcode == 91)
		{
			def.womanhead = stream.readUnsignedShort();
		}
		else if (opcode == 92)
		{
			def.manhead2 = stream.readUnsignedShort();
		}
		else if (opcode == 93)
		{
			def.womanhead2 = stream.readUnsignedShort();
		}
		else if (opcode == 94)
		{
			def.category = stream.readUnsignedShort();
		}
		else if (opcode == 95)
		{
			def.zan2d = stream.readUnsignedShort();
		}
		else if (opcode == 97)
		{
			def.certlink = stream.readUnsignedShort();
		}
		else if (opcode == 98)
		{
			def.certtemplate = stream.readUnsignedShort();
		}
		else if (opcode >= 100 && opcode < 110)
		{
			if (def.countObj == null)
			{
				def.countObj = new int[10];
				def.countCo = new int[10];
			}

			def.countObj[opcode - 100] = stream.readUnsignedShort();
			def.countCo[opcode - 100] = stream.readUnsignedShort();
		}
		else if (opcode == 110)
		{
			def.resizex = stream.readUnsignedShort();
		}
		else if (opcode == 111)
		{
			def.resizey = stream.readUnsignedShort();
		}
		else if (opcode == 112)
		{
			def.resizez = stream.readUnsignedShort();
		}
		else if (opcode == 113)
		{
			def.ambient = stream.readByte();
		}
		else if (opcode == 114)
		{
			def.contrast = stream.readByte();
		}
		else if (opcode == 115)
		{
			def.team = stream.readUnsignedByte();
		}
		else if (opcode == 139)
		{
			def.boughtlink = stream.readUnsignedShort();
		}
		else if (opcode == 140)
		{
			def.boughttemplate = stream.readUnsignedShort();
		}
		else if (opcode == 148)
		{
			def.placeholderlink = stream.readUnsignedShort();
		}
		else if (opcode == 149)
		{
			def.placeholdertemplate = stream.readUnsignedShort();
		}
		else if (opcode == 249)
		{
			int length = stream.readUnsignedByte();

			def.params = new HashMap<>(length);

			for (int i = 0; i < length; i++)
			{
				boolean isString = stream.readUnsignedByte() == 1;
				int key = stream.read24BitInt();
				Object value;

				if (isString)
				{
					value = stream.readString();
				}

				else
				{
					value = stream.readInt();
				}

				def.params.put(key, value);
			}
		}
		else
		{
			logger.warn("Unrecognized opcode {}", opcode);
		}
	}

	private void post(ObjDefinition def)
	{
		if (def.stackable == 1)
		{
			def.weight = 0;
		}
	}
}
