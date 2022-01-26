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
package net.runelite.cache.definitions.savers;

import java.util.Map;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.io.OutputStream;

public class ObjectSaver
{
	public byte[] save(ObjectDefinition obj)
	{
		OutputStream out = new OutputStream();
		if (obj.getObjectTypes() != null && obj.getObjectModels() != null)
		{
			out.writeByte(1);
			out.writeByte(obj.getObjectTypes().length);
			for (int i = 0; i < obj.getObjectTypes().length; ++i)
			{
				out.writeShort(obj.getObjectModels()[i]);
				out.writeByte(obj.getObjectTypes()[i]);
			}
		}
		if (obj.getName() != null)
		{
			out.writeByte(2);
			out.writeString(obj.getName());
		}
		if (obj.getObjectTypes() == null && obj.getObjectModels() != null)
		{
			out.writeByte(5);
			out.writeByte(obj.getObjectModels().length);
			for (int i = 0; i < obj.getObjectModels().length; ++i)
			{
				out.writeShort(obj.getObjectModels()[i]);
			}
		}
		out.writeByte(14);
		out.writeByte(obj.getSizeX());
		out.writeByte(15);
		out.writeByte(obj.getSizeY());
		if (obj.getInteractType() == 0 && !obj.isBlocksProjectile())
		{
			out.writeByte(17);
		}
		else if (!obj.isBlocksProjectile())
		{
			out.writeByte(18);
		}
		if (obj.getWallOrDoor() != -1)
		{
			out.writeByte(19);
			out.writeByte(obj.getWallOrDoor());
		}
		if (obj.getContouredGround() == 0)
		{
			out.writeByte(21);
		}
		if (!obj.isMergeNormals())
		{
			out.writeByte(22);
		}
		if (obj.isABool2111())
		{
			out.writeByte(23);
		}
		if (obj.getAnimationID() != -1)
		{
			out.writeByte(24);
			out.writeShort(obj.getAnimationID());
		}
		if (obj.getInteractType() == 1)
		{
			out.writeByte(27);
		}
		out.writeByte(28);
		out.writeByte(obj.getDecorDisplacement());
		out.writeByte(29);
		out.writeByte(obj.getAmbient());
		out.writeByte(39);
		out.writeByte(obj.getContrast() / 25);
		for (int i = 0; i < 5; ++i)
		{
			out.writeByte(30 + i);
			String action = obj.getActions()[i];
			out.writeString(action != null ? action : "Hidden");
		}
		if (obj.getRecolorToFind() != null && obj.getRecolorToReplace() != null)
		{
			out.writeByte(40);
			out.writeByte(obj.getRecolorToFind().length);
			for (int i = 0; i < obj.getRecolorToFind().length; ++i)
			{
				out.writeShort(obj.getRecolorToFind()[i]);
				out.writeShort(obj.getRecolorToReplace()[i]);
			}
		}
		if (obj.getRetextureToFind() != null && obj.getTextureToReplace() != null)
		{
			out.writeByte(41);
			out.writeByte(obj.getRetextureToFind().length);
			for (int i = 0; i < obj.getRetextureToFind().length; ++i)
			{
				out.writeShort(obj.getRetextureToFind()[i]);
				out.writeShort(obj.getTextureToReplace()[i]);
			}
		}
		if (obj.isRotated())
		{
			out.writeByte(62);
		}
		if (!obj.isShadow())
		{
			out.writeByte(64);
		}
		out.writeByte(65);
		out.writeShort(obj.getModelSizeX());
		out.writeByte(66);
		out.writeShort(obj.getModelSizeHeight());
		out.writeByte(67);
		out.writeShort(obj.getModelSizeY());
		if (obj.getMapSceneID() != -1)
		{
			out.writeByte(68);
			out.writeShort(obj.getMapSceneID());
		}
		if (obj.getBlockingMask() != 0)
		{
			out.writeByte(69);
			out.writeByte(obj.getBlockingMask());
		}
		out.writeByte(70);
		out.writeShort(obj.getOffsetX());
		out.writeByte(71);
		out.writeShort(obj.getOffsetHeight());
		out.writeByte(72);
		out.writeShort(obj.getOffsetY());
		if (obj.isObstructsGround())
		{
			out.writeByte(73);
		}
		if (obj.isHollow())
		{
			out.writeByte(74);
		}
		if (obj.getSupportsItems() != -1)
		{
			out.writeByte(75);
			out.writeByte(obj.getSupportsItems());
		}
		if (obj.getAmbientSoundId() != -1)
		{
			out.writeByte(78);
			out.writeShort(obj.getAmbientSoundId());
			out.writeByte(obj.getAnInt2083());
		}
		if (obj.getAmbientSoundIds() != null)
		{
			out.writeByte(79);
			out.writeShort(obj.getAnInt2112());
			out.writeShort(obj.getAnInt2113());
			out.writeByte(obj.getAnInt2083());
			out.writeByte(obj.getAmbientSoundIds().length);
			for (int i : obj.getAmbientSoundIds())
			{
				out.writeShort(i);
			}
		}
		if (obj.getContouredGround() != -1)
		{
			out.writeByte(81);
			out.writeByte(obj.getContouredGround() / 256);
		}
		if (obj.getMapAreaId() != -1)
		{
			out.writeByte(82);
			out.writeShort(obj.getMapAreaId());
		}
		if (obj.getConfigChangeDest() != null)
		{
			out.writeByte(92);
			out.writeShort(obj.getVarbitID());
			out.writeShort(obj.getVarpID());

			int[] c = obj.getConfigChangeDest();
			out.writeShort(c[c.length - 1]);
			out.writeByte(c.length - 2);
			for (int i = 0; i <= c.length - 2; ++i)
			{
				out.writeShort(c[i]);
			}
		}
		if (obj.getParams() != null)
		{
			out.writeByte(249);
			out.writeByte(obj.getParams().size());
			for (Map.Entry<Integer, Object> entry : obj.getParams().entrySet())
			{
				out.writeByte(entry.getValue() instanceof String ? 1 : 0);
				out.write24BitInt(entry.getKey());
				if (entry.getValue() instanceof String)
				{
					out.writeString((String) entry.getValue());
				}
				else
				{
					out.writeInt((Integer) entry.getValue());
				}
			}
		}
		out.writeByte(0);
		return out.flip();
	}
}
