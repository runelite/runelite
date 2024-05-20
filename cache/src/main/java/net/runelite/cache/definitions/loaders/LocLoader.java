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
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.LocDefinition;
import net.runelite.cache.io.InputStream;

@Accessors(chain = true)
@Data
@Slf4j
public class LocLoader
{
	public static final int REV_220_LOC_ARCHIVE_REV = 1673;

	private boolean rev220SoundData = true;

	public LocLoader configureForRevision(int rev)
	{
		this.rev220SoundData = rev >= REV_220_LOC_ARCHIVE_REV;
		return this;
	}

	public LocDefinition load(int id, byte[] b)
	{
		LocDefinition def = new LocDefinition();
		InputStream is = new InputStream(b);

		def.setId(id);

		for (;;)
		{
			int opcode = is.readUnsignedByte();
			if (opcode == 0)
			{
				break;
			}

			processOp(opcode, def, is);
		}

		post(def);

		return def;
	}

	private void processOp(int opcode, LocDefinition def, InputStream is)
	{
		if (opcode == 1)
		{
			int length = is.readUnsignedByte();
			if (length > 0)
			{
				int[] shapes = new int[length];
				int[] models = new int[length];

				for (int index = 0; index < length; ++index)
				{
					models[index] = is.readUnsignedShort();
					shapes[index] = is.readUnsignedByte();
				}

				def.setShapes(shapes);
				def.setModels(models);
			}
		}
		else if (opcode == 2)
		{
			def.setName(is.readString());
		}
		else if (opcode == 5)
		{
			int length = is.readUnsignedByte();
			if (length > 0)
			{
				def.setShapes(null);
				int[] models = new int[length];

				for (int index = 0; index < length; ++index)
				{
					models[index] = is.readUnsignedShort();
				}

				def.setModels(models);
			}
		}
		else if (opcode == 14)
		{
			def.setWidth(is.readUnsignedByte());
		}
		else if (opcode == 15)
		{
			def.setLength(is.readUnsignedByte());
		}
		else if (opcode == 17)
		{
			def.setBlockwalk(0);
			def.setBlockrange(false);
		}
		else if (opcode == 18)
		{
			def.setBlockrange(false);
		}
		else if (opcode == 19)
		{
			def.setActive(is.readUnsignedByte());
		}
		else if (opcode == 21)
		{
			def.setHillchange(0);
		}
		else if (opcode == 22)
		{
			def.setSharelight(true);
		}
		else if (opcode == 23)
		{
			def.setOcclude(true);
		}
		else if (opcode == 24)
		{
			def.setAnim(is.readUnsignedShort());
			if (def.getAnim() == 0xFFFF)
			{
				def.setAnim(-1);
			}
		}
		else if (opcode == 27)
		{
			def.setBlockwalk(1);
		}
		else if (opcode == 28)
		{
			def.setWallwidth(is.readUnsignedByte());
		}
		else if (opcode == 29)
		{
			def.setAmbient(is.readByte());
		}
		else if (opcode == 39)
		{
			def.setContrast(is.readByte() * 25);
		}
		else if (opcode >= 30 && opcode < 35)
		{
			String[] op = def.getOp();
			op[opcode - 30] = is.readString();
			if (op[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				op[opcode - 30] = null;
			}
		}
		else if (opcode == 40)
		{
			int length = is.readUnsignedByte();
			short[] recol_s = new short[length];
			short[] recol_d = new short[length];

			for (int index = 0; index < length; ++index)
			{
				recol_s[index] = is.readShort();
				recol_d[index] = is.readShort();
			}

			def.setRecol_s(recol_s);
			def.setRecol_d(recol_d);
		}
		else if (opcode == 41)
		{
			int length = is.readUnsignedByte();
			short[] retex_s = new short[length];
			short[] retex_d = new short[length];

			for (int index = 0; index < length; ++index)
			{
				retex_s[index] = is.readShort();
				retex_d[index] = is.readShort();
			}

			def.setRetex_s(retex_s);
			def.setRetex_d(retex_d);
		}
		else if (opcode == 61)
		{
			def.setCategory(is.readUnsignedShort());
		}
		else if (opcode == 62)
		{
			def.setMirror(true);
		}
		else if (opcode == 64)
		{
			def.setShadow(false);
		}
		else if (opcode == 65)
		{
			def.setResizex(is.readUnsignedShort());
		}
		else if (opcode == 66)
		{
			def.setResizey(is.readUnsignedShort());
		}
		else if (opcode == 67)
		{
			def.setResizez(is.readUnsignedShort());
		}
		else if (opcode == 68)
		{
			def.setMapscene(is.readUnsignedShort());
		}
		else if (opcode == 69)
		{
			def.setForceapproach(is.readByte());
		}
		else if (opcode == 70)
		{
			def.setXoff(is.readUnsignedShort());
		}
		else if (opcode == 71)
		{
			def.setYoff(is.readUnsignedShort());
		}
		else if (opcode == 72)
		{
			def.setZoff(is.readUnsignedShort());
		}
		else if (opcode == 73)
		{
			def.setForcedecor(true);
		}
		else if (opcode == 74)
		{
			def.setBreakroutefinding(true);
		}
		else if (opcode == 75)
		{
			def.setRaiseobject(is.readUnsignedByte());
		}
		else if (opcode == 77)
		{
			int varpID = is.readUnsignedShort();
			if (varpID == 0xFFFF)
			{
				varpID = -1;
			}
			def.setMultivarbit(varpID);

			int configId = is.readUnsignedShort();
			if (configId == 0xFFFF)
			{
				configId = -1;
			}
			def.setMultivarp(configId);

			int length = is.readUnsignedByte();
			int[] configChangeDest = new int[length + 2];

			for (int index = 0; index <= length; ++index)
			{
				configChangeDest[index] = is.readUnsignedShort();
				if (0xFFFF == configChangeDest[index])
				{
					configChangeDest[index] = -1;
				}
			}

			configChangeDest[length + 1] = -1;

			def.setMultiloc(configChangeDest);
		}
		else if (opcode == 78)
		{
			def.setBgsound_sound(is.readUnsignedShort());
			def.setBgsound_range(is.readUnsignedByte());
			if (rev220SoundData)
			{
				def.setAmbientSoundRetain(is.readUnsignedByte());
			}
		}
		else if (opcode == 79)
		{
			def.setBgsound_mindelay(is.readUnsignedShort());
			def.setBgsound_maxdelay(is.readUnsignedShort());
			def.setBgsound_range(is.readUnsignedByte());
			if (rev220SoundData)
			{
				def.setAmbientSoundRetain(is.readUnsignedByte());
			}
			int length = is.readUnsignedByte();
			int[] ambientSoundIds = new int[length];

			for (int index = 0; index < length; ++index)
			{
				ambientSoundIds[index] = is.readUnsignedShort();
			}

			def.setBgsound_random(ambientSoundIds);
		}
		else if (opcode == 81)
		{
			def.setHillchange(is.readUnsignedByte() * 256);
		}
		else if (opcode == 82)
		{
			def.setMapAreaId(is.readUnsignedShort());
		}
		else if (opcode == 89)
		{
			def.setRandomanimframe(true);
		}
		else if (opcode == 92)
		{
			int varpID = is.readUnsignedShort();
			if (varpID == 0xFFFF)
			{
				varpID = -1;
			}
			def.setMultivarbit(varpID);

			int configId = is.readUnsignedShort();
			if (configId == 0xFFFF)
			{
				configId = -1;
			}
			def.setMultivarp(configId);


			int var = is.readUnsignedShort();
			if (var == 0xFFFF)
			{
				var = -1;
			}

			int length = is.readUnsignedByte();
			int[] configChangeDest = new int[length + 2];

			for (int index = 0; index <= length; ++index)
			{
				configChangeDest[index] = is.readUnsignedShort();
				if (0xFFFF == configChangeDest[index])
				{
					configChangeDest[index] = -1;
				}
			}

			configChangeDest[length + 1] = var;

			def.setMultiloc(configChangeDest);
		}
		else if (opcode == 249)
		{
			int length = is.readUnsignedByte();

			Map<Integer, Object> params = new HashMap<>(length);
			for (int i = 0; i < length; i++)
			{
				boolean isString = is.readUnsignedByte() == 1;
				int key = is.read24BitInt();
				Object value;

				if (isString)
				{
					value = is.readString();
				}

				else
				{
					value = is.readInt();
				}

				params.put(key, value);
			}

			def.setParams(params);
		}
		else
		{
			log.warn("Unrecognized opcode {}", opcode);
		}
	}


	private void post(LocDefinition def)
	{
		if (def.getActive() == -1)
		{
			def.setActive(0);
			if (def.getModels() != null && (def.getShapes() == null || def.getShapes()[0] == 10))
			{
				def.setActive(1);
			}

			for (int var1 = 0; var1 < 5; ++var1)
			{
				if (def.getOp()[var1] != null)
				{
					def.setActive(1);
				}
			}
		}

		if (def.getRaiseobject() == -1)
		{
			def.setRaiseobject(def.getBlockwalk() != 0 ? 1 : 0);
		}
	}
}
