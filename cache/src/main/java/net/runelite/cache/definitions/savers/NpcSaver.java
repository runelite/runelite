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
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.io.OutputStream;

public class NpcSaver
{
	public byte[] save(NpcDefinition npc)
	{
		OutputStream out = new OutputStream();
		if (npc.models != null)
		{
			out.writeByte(1);
			out.writeByte(npc.models.length);
			for (int modelId : npc.models)
			{
				out.writeShort(modelId);
			}
		}
		if (npc.name != null)
		{
			out.writeByte(2);
			out.writeString(npc.name);
		}
		if (npc.tileSpacesOccupied != 1)
		{
			out.writeByte(12);
			out.writeByte(npc.tileSpacesOccupied);
		}
		if (npc.stanceAnimation != -1)
		{
			out.writeByte(13);
			out.writeShort(npc.stanceAnimation);
		}
		if (npc.walkAnimation != -1)
		{
			out.writeByte(14);
			out.writeShort(npc.walkAnimation);
		}
		if (npc.anInt2165 != -1)
		{
			out.writeByte(15);
			out.writeShort(npc.anInt2165);
		}
		if (npc.anInt2189 != -1)
		{
			out.writeByte(16);
			out.writeShort(npc.anInt2189);
		}
		if (npc.rotate180Animation != -1 || npc.rotate90LeftAnimation != -1 || npc.rotate90RightAnimation != -1)
		{
			out.writeByte(17);
			out.writeShort(npc.walkAnimation);
			out.writeShort(npc.rotate180Animation);
			out.writeShort(npc.rotate90RightAnimation);
			out.writeShort(npc.rotate90LeftAnimation);
		}
		for (int i = 0; i < 5; ++i)
		{
			if (npc.options[i] != null)
			{
				out.writeByte(30 + i);
				out.writeString(npc.options[i]);
			}
		}
		if (npc.recolorToFind != null && npc.recolorToReplace != null)
		{
			out.writeByte(40);
			out.writeByte(npc.recolorToFind.length);
			for (int i = 0; i < npc.recolorToFind.length; ++i)
			{
				out.writeShort(npc.recolorToFind[i]);
				out.writeShort(npc.recolorToReplace[i]);
			}
		}
		if (npc.retextureToFind != null && npc.retextureToReplace != null)
		{
			out.writeByte(41);
			out.writeByte(npc.retextureToFind.length);
			for (int i = 0; i < npc.retextureToFind.length; ++i)
			{
				out.writeShort(npc.retextureToFind[i]);
				out.writeShort(npc.retextureToReplace[i]);
			}
		}
		if (npc.models_2 != null)
		{
			out.writeByte(60);
			out.writeByte(npc.models_2.length);
			for (int modelId : npc.models_2)
			{
				out.writeShort(modelId);
			}
		}
		if (!npc.renderOnMinimap)
		{
			out.writeByte(93);
		}
		if (npc.combatLevel != -1)
		{
			out.writeByte(95);
			out.writeShort(npc.combatLevel);
		}
		out.writeByte(97);
		out.writeShort(npc.resizeX);
		out.writeByte(98);
		out.writeShort(npc.resizeY);
		if (npc.hasRenderPriority)
		{
			out.writeByte(99);
		}
		out.writeByte(100);
		out.writeByte(npc.ambient);
		out.writeByte(101);
		out.writeByte(npc.contrast);
		if (npc.headIcon != -1)
		{
			out.writeByte(102);
			out.writeShort(npc.headIcon);
		}
		out.writeByte(103);
		out.writeShort(npc.rotation);
		if (!npc.isClickable)
		{
			out.writeByte(107);
		}
		if (!npc.aBool2170)
		{
			out.writeByte(109);
		}
		if (npc.aBool2190)
		{
			out.writeByte(111);
		}
		if (npc.configs != null)
		{
			out.writeByte(118);
			out.writeShort(npc.varbitIndex);
			out.writeShort(npc.varpIndex);

			int[] c = npc.configs;
			out.writeShort(c[c.length - 1]);
			out.writeByte(c.length - 2);
			for (int i = 0; i <= c.length - 2; ++i)
			{
				out.writeShort(c[i]);
			}
		}
		if (npc.params != null)
		{
			out.writeByte(249);
			out.writeByte(npc.params.size());
			for (Map.Entry<Integer, Object> entry : npc.params.entrySet())
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
