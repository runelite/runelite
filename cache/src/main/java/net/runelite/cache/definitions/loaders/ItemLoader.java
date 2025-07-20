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

import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class ItemLoader
{
	private static final Logger logger = LoggerFactory.getLogger(ItemLoader.class);

	public ItemDefinition load(int id, byte[] b)
	{
		ItemDefinition def = new ItemDefinition(id);
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

	private void decodeValues(int opcode, ItemDefinition def, InputStream stream)
	{
		if (opcode == 1)
		{
			def.inventoryModel = stream.readUnsignedShort();
		}
		else if (opcode == 2)
		{
			def.name = stream.readString();
		}
		else if (opcode == 3)
		{
			def.examine = stream.readString();
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
			def.xOffset2d = stream.readUnsignedShort();
			if (def.xOffset2d > 32767)
			{
				def.xOffset2d -= 65536;
			}
		}
		else if (opcode == 8)
		{
			def.yOffset2d = stream.readUnsignedShort();
			if (def.yOffset2d > 32767)
			{
				def.yOffset2d -= 65536;
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
			def.wearPos1 = stream.readByte();
		}
		else if (opcode == 14)
		{
			def.wearPos2 = stream.readByte();
		}
		else if (opcode == 16)
		{
			def.members = true;
		}
		else if (opcode == 23)
		{
			def.maleModel0 = stream.readUnsignedShort();
			def.maleOffset = stream.readUnsignedByte();
		}
		else if (opcode == 24)
		{
			def.maleModel1 = stream.readUnsignedShort();
		}
		else if (opcode == 25)
		{
			def.femaleModel0 = stream.readUnsignedShort();
			def.femaleOffset = stream.readUnsignedByte();
		}
		else if (opcode == 26)
		{
			def.femaleModel1 = stream.readUnsignedShort();
		}
		else if (opcode == 27)
		{
			def.wearPos3 = stream.readByte();
		}
		else if (opcode >= 30 && opcode < 35)
		{
			def.options[opcode - 30] = stream.readString();
			if (def.options[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				def.options[opcode - 30] = null;
			}
		}
		else if (opcode >= 35 && opcode < 40)
		{
			def.interfaceOptions[opcode - 35] = stream.readString();
		}
		else if (opcode == 40)
		{
			int var5 = stream.readUnsignedByte();
			def.colorFind = new short[var5];
			def.colorReplace = new short[var5];

			for (int var4 = 0; var4 < var5; ++var4)
			{
				def.colorFind[var4] = (short) stream.readUnsignedShort();
				def.colorReplace[var4] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 41)
		{
			int var5 = stream.readUnsignedByte();
			def.textureFind = new short[var5];
			def.textureReplace = new short[var5];

			for (int var4 = 0; var4 < var5; ++var4)
			{
				def.textureFind[var4] = (short) stream.readUnsignedShort();
				def.textureReplace[var4] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 42)
		{
			def.shiftClickDropIndex = stream.readByte();
		}
		else if (opcode == 43)
		{
			int opId = stream.readUnsignedByte();
			if (def.subops == null)
			{
				def.subops = new String[5][];
			}

			boolean valid = opId >= 0 && opId < 5;
			if (valid && def.subops[opId] == null)
			{
				def.subops[opId] = new String[20];
			}

			while (true)
			{
				int subopId = stream.readUnsignedByte() - 1;
				if (subopId == -1)
				{
					break;
				}

				String op = stream.readString();
				if (valid && subopId >= 0 && subopId < 20)
				{
					def.subops[opId][subopId] = op;
				}
			}
		}
		else if (opcode == 65)
		{
			def.isTradeable = true;
		}
		else if (opcode == 75)
		{
			def.weight = stream.readShort();
		}
		else if (opcode == 78)
		{
			def.maleModel2 = stream.readUnsignedShort();
		}
		else if (opcode == 79)
		{
			def.femaleModel2 = stream.readUnsignedShort();
		}
		else if (opcode == 90)
		{
			def.maleHeadModel = stream.readUnsignedShort();
		}
		else if (opcode == 91)
		{
			def.femaleHeadModel = stream.readUnsignedShort();
		}
		else if (opcode == 92)
		{
			def.maleHeadModel2 = stream.readUnsignedShort();
		}
		else if (opcode == 93)
		{
			def.femaleHeadModel2 = stream.readUnsignedShort();
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
			def.notedID = stream.readUnsignedShort();
		}
		else if (opcode == 98)
		{
			def.notedTemplate = stream.readUnsignedShort();
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
			def.resizeX = stream.readUnsignedShort();
		}
		else if (opcode == 111)
		{
			def.resizeY = stream.readUnsignedShort();
		}
		else if (opcode == 112)
		{
			def.resizeZ = stream.readUnsignedShort();
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
			def.boughtId = stream.readUnsignedShort();
		}
		else if (opcode == 140)
		{
			def.boughtTemplateId = stream.readUnsignedShort();
		}
		else if (opcode == 148)
		{
			def.placeholderId = stream.readUnsignedShort();
		}
		else if (opcode == 149)
		{
			def.placeholderTemplateId = stream.readUnsignedShort();
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

	private void post(ItemDefinition def)
	{
		if (def.stackable == 1)
		{
			def.weight = 0;
		}
	}
}
