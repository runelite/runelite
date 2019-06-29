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

import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class NpcLoader
{
	private static final Logger logger = LoggerFactory.getLogger(NpcLoader.class);

	public NpcDefinition load(int id, byte[] b)
	{
		NpcDefinition def = new NpcDefinition(id);
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

		return def;
	}

	private void decodeValues(int opcode, NpcDefinition def, InputStream stream)
	{
		int length;
		int index;
		if (opcode == 1)
		{
			length = stream.readUnsignedByte();
			def.models = new int[length];

			for (index = 0; index < length; ++index)
			{
				def.models[index] = stream.readUnsignedShort();
			}

		}
		else if (opcode == 2)
		{
			def.name = stream.readString();
		}
		else if (opcode == 12)
		{
			def.tileSpacesOccupied = stream.readUnsignedByte();
		}
		else if (opcode == 13)
		{
			def.stanceAnimation = stream.readUnsignedShort();
		}
		else if (opcode == 14)
		{
			def.walkAnimation = stream.readUnsignedShort();
		}
		else if (opcode == 15)
		{
			def.anInt2165 = stream.readUnsignedShort();
		}
		else if (opcode == 16)
		{
			def.anInt2189 = stream.readUnsignedShort();
		}
		else if (opcode == 17)
		{
			def.walkAnimation = stream.readUnsignedShort();
			def.rotate180Animation = stream.readUnsignedShort();
			def.rotate90RightAnimation = stream.readUnsignedShort();
			def.rotate90LeftAnimation = stream.readUnsignedShort();
		}
		else if (opcode >= 30 && opcode < 35)
		{
			def.options[opcode - 30] = stream.readString();
			if (def.options[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				def.options[opcode - 30] = null;
			}
		}
		else if (opcode == 40)
		{
			length = stream.readUnsignedByte();
			def.recolorToFind = new short[length];
			def.recolorToReplace = new short[length];

			for (index = 0; index < length; ++index)
			{
				def.recolorToFind[index] = (short) stream.readUnsignedShort();
				def.recolorToReplace[index] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 41)
		{
			length = stream.readUnsignedByte();
			def.retextureToFind = new short[length];
			def.retextureToReplace = new short[length];

			for (index = 0; index < length; ++index)
			{
				def.retextureToFind[index] = (short) stream.readUnsignedShort();
				def.retextureToReplace[index] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 60)
		{
			length = stream.readUnsignedByte();
			def.models_2 = new int[length];

			for (index = 0; index < length; ++index)
			{
				def.models_2[index] = stream.readUnsignedShort();
			}

		}
		else if (opcode == 93)
		{
			def.renderOnMinimap = false;
		}
		else if (opcode == 95)
		{
			def.combatLevel = stream.readUnsignedShort();
		}
		else if (opcode == 97)
		{
			def.resizeX = stream.readUnsignedShort();
		}
		else if (opcode == 98)
		{
			def.resizeY = stream.readUnsignedShort();
		}
		else if (opcode == 99)
		{
			def.hasRenderPriority = true;
		}
		else if (opcode == 100)
		{
			def.ambient = stream.readByte();
		}
		else if (opcode == 101)
		{
			def.contrast = stream.readByte();
		}
		else if (opcode == 102)
		{
			def.headIcon = stream.readUnsignedShort();
		}
		else if (opcode == 103)
		{
			def.rotation = stream.readUnsignedShort();
		}
		else if (opcode == 106)
		{
			def.varbitIndex = stream.readUnsignedShort();
			if ('\uffff' == def.varbitIndex)
			{
				def.varbitIndex = -1;
			}

			def.varpIndex = stream.readUnsignedShort();
			if ('\uffff' == def.varpIndex)
			{
				def.varpIndex = -1;
			}

			length = stream.readUnsignedByte();
			def.configs = new int[length + 2];

			for (index = 0; index <= length; ++index)
			{
				def.configs[index] = stream.readUnsignedShort();
				if (def.configs[index] == '\uffff')
				{
					def.configs[index] = -1;
				}
			}

			def.configs[length + 1] = -1;

		}
		else if (opcode == 107)
		{
			def.isClickable = false;
		}
		else if (opcode == 109)
		{
			def.aBool2170 = false;
		}
		else if (opcode == 111)
		{
			def.aBool2190 = true;
		}
		else if (opcode == 118)
		{
			def.varbitIndex = stream.readUnsignedShort();
			if ('\uffff' == def.varbitIndex)
			{
				def.varbitIndex = -1;
			}

			def.varpIndex = stream.readUnsignedShort();
			if ('\uffff' == def.varpIndex)
			{
				def.varpIndex = -1;
			}

			int var = stream.readUnsignedShort();
			if (var == 0xFFFF)
			{
				var = -1;
			}

			length = stream.readUnsignedByte();
			def.configs = new int[length + 2];

			for (index = 0; index <= length; ++index)
			{
				def.configs[index] = stream.readUnsignedShort();
				if (def.configs[index] == '\uffff')
				{
					def.configs[index] = -1;
				}
			}

			def.configs[length + 1] = var;
		}
		else if (opcode == 249)
		{
			length = stream.readUnsignedByte();

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
}
