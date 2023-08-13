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
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectLoader
{
	private static final Logger logger = LoggerFactory.getLogger(ObjectLoader.class);

	public ObjectDefinition load(int id, byte[] b)
	{
		ObjectDefinition def = new ObjectDefinition();
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

	private void processOp(int opcode, ObjectDefinition def, InputStream is)
	{
		if (opcode == 1)
		{
			int length = is.readUnsignedByte();
			if (length > 0)
			{
				int[] objectTypes = new int[length];
				int[] objectModels = new int[length];

				for (int index = 0; index < length; ++index)
				{
					objectModels[index] = is.readUnsignedShort();
					objectTypes[index] = is.readUnsignedByte();
				}

				def.setObjectTypes(objectTypes);
				def.setObjectModels(objectModels);
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
				def.setObjectTypes(null);
				int[] objectModels = new int[length];

				for (int index = 0; index < length; ++index)
				{
					objectModels[index] = is.readUnsignedShort();
				}

				def.setObjectModels(objectModels);
			}
		}
		else if (opcode == 14)
		{
			def.setSizeX(is.readUnsignedByte());
		}
		else if (opcode == 15)
		{
			def.setSizeY(is.readUnsignedByte());
		}
		else if (opcode == 17)
		{
			def.setInteractType(0);
			def.setBlocksProjectile(false);
		}
		else if (opcode == 18)
		{
			def.setBlocksProjectile(false);
		}
		else if (opcode == 19)
		{
			def.setWallOrDoor(is.readUnsignedByte());
		}
		else if (opcode == 21)
		{
			def.setContouredGround(0);
		}
		else if (opcode == 22)
		{
			def.setMergeNormals(true);
		}
		else if (opcode == 23)
		{
			def.setABool2111(true);
		}
		else if (opcode == 24)
		{
			def.setAnimationID(is.readUnsignedShort());
			if (def.getAnimationID() == 0xFFFF)
			{
				def.setAnimationID(-1);
			}
		}
		else if (opcode == 27)
		{
			def.setInteractType(1);
		}
		else if (opcode == 28)
		{
			def.setDecorDisplacement(is.readUnsignedByte());
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
			String[] actions = def.getActions();
			actions[opcode - 30] = is.readString();
			if (actions[opcode - 30].equalsIgnoreCase("Hidden"))
			{
				actions[opcode - 30] = null;
			}
		}
		else if (opcode == 40)
		{
			int length = is.readUnsignedByte();
			short[] recolorToFind = new short[length];
			short[] recolorToReplace = new short[length];

			for (int index = 0; index < length; ++index)
			{
				recolorToFind[index] = is.readShort();
				recolorToReplace[index] = is.readShort();
			}

			def.setRecolorToFind(recolorToFind);
			def.setRecolorToReplace(recolorToReplace);
		}
		else if (opcode == 41)
		{
			int length = is.readUnsignedByte();
			short[] retextureToFind = new short[length];
			short[] textureToReplace = new short[length];

			for (int index = 0; index < length; ++index)
			{
				retextureToFind[index] = is.readShort();
				textureToReplace[index] = is.readShort();
			}

			def.setRetextureToFind(retextureToFind);
			def.setTextureToReplace(textureToReplace);
		}
		else if (opcode == 61)
		{
			def.setCategory(is.readUnsignedShort());
		}
		else if (opcode == 62)
		{
			def.setRotated(true);
		}
		else if (opcode == 64)
		{
			def.setShadow(false);
		}
		else if (opcode == 65)
		{
			def.setModelSizeX(is.readUnsignedShort());
		}
		else if (opcode == 66)
		{
			def.setModelSizeHeight(is.readUnsignedShort());
		}
		else if (opcode == 67)
		{
			def.setModelSizeY(is.readUnsignedShort());
		}
		else if (opcode == 68)
		{
			def.setMapSceneID(is.readUnsignedShort());
		}
		else if (opcode == 69)
		{
			def.setBlockingMask(is.readByte());
		}
		else if (opcode == 70)
		{
			def.setOffsetX(is.readUnsignedShort());
		}
		else if (opcode == 71)
		{
			def.setOffsetHeight(is.readUnsignedShort());
		}
		else if (opcode == 72)
		{
			def.setOffsetY(is.readUnsignedShort());
		}
		else if (opcode == 73)
		{
			def.setObstructsGround(true);
		}
		else if (opcode == 74)
		{
			def.setHollow(true);
		}
		else if (opcode == 75)
		{
			def.setSupportsItems(is.readUnsignedByte());
		}
		else if (opcode == 77)
		{
			int varpID = is.readUnsignedShort();
			if (varpID == 0xFFFF)
			{
				varpID = -1;
			}
			def.setVarbitID(varpID);

			int configId = is.readUnsignedShort();
			if (configId == 0xFFFF)
			{
				configId = -1;
			}
			def.setVarpID(configId);

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

			def.setConfigChangeDest(configChangeDest);
		}
		else if (opcode == 78)
		{
			def.setAmbientSoundId(is.readUnsignedShort());
			def.setAmbientSoundDistance(is.readUnsignedByte());
		}
		else if (opcode == 79)
		{
			def.setAmbientSoundChangeTicksMin(is.readUnsignedShort());
			def.setAmbientSoundChangeTicksMax(is.readUnsignedShort());
			def.setAmbientSoundDistance(is.readUnsignedByte());
			int length = is.readUnsignedByte();
			int[] ambientSoundIds = new int[length];

			for (int index = 0; index < length; ++index)
			{
				ambientSoundIds[index] = is.readUnsignedShort();
			}

			def.setAmbientSoundIds(ambientSoundIds);
		}
		else if (opcode == 81)
		{
			def.setContouredGround(is.readUnsignedByte() * 256);
		}
		else if (opcode == 82)
		{
			def.setMapAreaId(is.readUnsignedShort());
		}
		else if (opcode == 89)
		{
			def.setRandomizeAnimStart(true);
		}
		else if (opcode == 92)
		{
			int varpID = is.readUnsignedShort();
			if (varpID == 0xFFFF)
			{
				varpID = -1;
			}
			def.setVarbitID(varpID);

			int configId = is.readUnsignedShort();
			if (configId == 0xFFFF)
			{
				configId = -1;
			}
			def.setVarpID(configId);


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

			def.setConfigChangeDest(configChangeDest);
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
			logger.warn("Unrecognized opcode {}", opcode);
		}
	}


	private void post(ObjectDefinition def)
	{
		if (def.getWallOrDoor() == -1)
		{
			def.setWallOrDoor(0);
			if (def.getObjectModels() != null && (def.getObjectTypes() == null || def.getObjectTypes()[0] == 10))
			{
				def.setWallOrDoor(1);
			}

			for (int var1 = 0; var1 < 5; ++var1)
			{
				if (def.getActions()[var1] != null)
				{
					def.setWallOrDoor(1);
				}
			}
		}

		if (def.getSupportsItems() == -1)
		{
			def.setSupportsItems(def.getInteractType() != 0 ? 1 : 0);
		}
	}
}
