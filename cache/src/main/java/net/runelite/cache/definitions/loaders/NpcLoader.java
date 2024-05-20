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

import java.util.HashMap;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.io.InputStream;

@Accessors(chain = true)
@Data
@Slf4j
public class NpcLoader
{
	public static final int REV_210_NPC_ARCHIVE_REV = 1493;

	private int defaultHeadIconArchive = -1;
	private boolean rev210HeadIcons = true;

	public NpcLoader configureForRevision(int rev)
	{
		this.rev210HeadIcons = rev >= NpcLoader.REV_210_NPC_ARCHIVE_REV;
		return this;
	}

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
			def.size = stream.readUnsignedByte();
		}
		else if (opcode == 13)
		{
			def.readyanim = stream.readUnsignedShort();
		}
		else if (opcode == 14)
		{
			def.walkanim = stream.readUnsignedShort();
		}
		else if (opcode == 15)
		{
			// unknown jagex name
			def.idleRotateLeftAnimation = stream.readUnsignedShort();
		}
		else if (opcode == 16)
		{
			// unknown jagex name
			def.idleRotateRightAnimation = stream.readUnsignedShort();
		}
		else if (opcode == 17)
		{
			def.walkanim = stream.readUnsignedShort();
			def.walkanim_b = stream.readUnsignedShort();
			def.walkanim_r = stream.readUnsignedShort();
			def.walkanim_l = stream.readUnsignedShort();
		}
		else if (opcode == 18)
		{
			def.category = stream.readUnsignedShort();
		}
		else if (opcode >= 30 && opcode < 35)
		{
			def.op[opcode - 30] = stream.readString();
			if (def.op[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				def.op[opcode - 30] = null;
			}
		}
		else if (opcode == 40)
		{
			length = stream.readUnsignedByte();
			def.recol_s = new short[length];
			def.recol_d = new short[length];

			for (index = 0; index < length; ++index)
			{
				def.recol_s[index] = (short) stream.readUnsignedShort();
				def.recol_d[index] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 41)
		{
			length = stream.readUnsignedByte();
			def.retex_s = new short[length];
			def.retex_d = new short[length];

			for (index = 0; index < length; ++index)
			{
				def.retex_s[index] = (short) stream.readUnsignedShort();
				def.retex_d[index] = (short) stream.readUnsignedShort();
			}

		}
		else if (opcode == 60)
		{
			length = stream.readUnsignedByte();
			def.heads = new int[length];

			for (index = 0; index < length; ++index)
			{
				def.heads[index] = stream.readUnsignedShort();
			}

		}
		else if (opcode == 93)
		{
			def.minimap = false;
		}
		else if (opcode == 95)
		{
			def.vislevel = stream.readUnsignedShort();
		}
		else if (opcode == 97)
		{
			def.resizeh = stream.readUnsignedShort();
		}
		else if (opcode == 98)
		{
			def.resizev = stream.readUnsignedShort();
		}
		else if (opcode == 99)
		{
			def.drawabove = true;
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
			if (!rev210HeadIcons)
			{
				def.headIconArchiveIds = new int[]{defaultHeadIconArchive};
				def.headIconSpriteIndex = new short[]{(short) stream.readUnsignedShort()};
			}
			else
			{
				int bitfield = stream.readUnsignedByte();
				int len = 0;
				for (int var5 = bitfield; var5 != 0; var5 >>= 1)
				{
					++len;
				}

				def.headIconArchiveIds = new int[len];
				def.headIconSpriteIndex = new short[len];

				for (int i = 0; i < len; i++)
				{
					if ((bitfield & 1 << i) == 0)
					{
						def.headIconArchiveIds[i] = -1;
						def.headIconSpriteIndex[i] = -1;
					}
					else
					{
						def.headIconArchiveIds[i] = stream.readBigSmart2();
						def.headIconSpriteIndex[i] = (short) stream.readUnsignedShortSmartMinusOne();
					}
				}
			}
		}
		else if (opcode == 103)
		{
			def.turnspeed = stream.readUnsignedShort();
		}
		else if (opcode == 106)
		{
			def.multivarbit = stream.readUnsignedShort();
			if (def.multivarbit == 65535)
			{
				def.multivarbit = -1;
			}

			def.multivarp = stream.readUnsignedShort();
			if (def.multivarp == 65535)
			{
				def.multivarp = -1;
			}

			length = stream.readUnsignedByte();
			def.multinpc = new int[length + 2];

			for (index = 0; index <= length; ++index)
			{
				def.multinpc[index] = stream.readUnsignedShort();
				if (def.multinpc[index] == '\uffff')
				{
					def.multinpc[index] = -1;
				}
			}

			def.multinpc[length + 1] = -1;

		}
		else if (opcode == 107)
		{
			def.active = false;
		}
		else if (opcode == 109)
		{
			def.walksmoothing = false;
		}
		else if (opcode == 111)
		{
			// removed in 220
			def.follower = true;
			def.lowPriorityFollowerOps = true;
		}
		else if (opcode == 114)
		{
			def.runanim = stream.readUnsignedShort();
		}
		else if (opcode == 115)
		{
			def.runanim = stream.readUnsignedShort();
			def.runanim_b = stream.readUnsignedShort();
			def.runanim_r = stream.readUnsignedShort();
			def.runanim_l = stream.readUnsignedShort();
		}
		else if (opcode == 116)
		{
			def.crawlanim = stream.readUnsignedShort();
		}
		else if (opcode == 117)
		{
			def.crawlanim = stream.readUnsignedShort();
			def.crawlanim_b = stream.readUnsignedShort();
			def.crawlanim_r = stream.readUnsignedShort();
			def.crawlanim_l = stream.readUnsignedShort();
		}
		else if (opcode == 118)
		{
			def.multivarbit = stream.readUnsignedShort();
			if (def.multivarbit == 65535)
			{
				def.multivarbit = -1;
			}

			def.multivarp = stream.readUnsignedShort();
			if (def.multivarp == 65535)
			{
				def.multivarp = -1;
			}

			int var = stream.readUnsignedShort();
			if (var == 0xFFFF)
			{
				var = -1;
			}

			length = stream.readUnsignedByte();
			def.multinpc = new int[length + 2];

			for (index = 0; index <= length; ++index)
			{
				def.multinpc[index] = stream.readUnsignedShort();
				if (def.multinpc[index] == '\uffff')
				{
					def.multinpc[index] = -1;
				}
			}

			def.multinpc[length + 1] = var;
		}
		else if (opcode == 122)
		{
			def.follower = true;
		}
		else if (opcode == 123)
		{
			def.lowPriorityFollowerOps = true;
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
			log.warn("Unrecognized opcode {}", opcode);
		}
	}
}
