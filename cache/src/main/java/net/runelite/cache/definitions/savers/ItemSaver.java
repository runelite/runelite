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

import java.util.Map.Entry;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.io.OutputStream;

public class ItemSaver
{
	public byte[] save(ItemDefinition item)
	{
		OutputStream out = new OutputStream();
		if (item.inventoryModel != 0)
		{
			out.writeByte(1);
			out.writeShort(item.inventoryModel);
		}
		if (item.name != null)
		{
			out.writeByte(2);
			out.writeString(item.name);
		}
		out.writeByte(4);
		out.writeShort(item.zoom2d);
		out.writeByte(5);
		out.writeShort(item.xan2d);
		out.writeByte(6);
		out.writeShort(item.yan2d);
		out.writeByte(7);
		out.writeShort(item.xOffset2d);
		out.writeByte(8);
		out.writeShort(item.yOffset2d);
		if (item.stackable != 0)
		{
			out.writeByte(11);
		}
		out.writeByte(12);
		out.writeInt(item.cost);
		if (item.members)
		{
			out.writeByte(16);
		}
		if (item.maleModel0 != -1 || item.maleOffset != 0)
		{
			out.writeByte(23);
			out.writeShort(item.maleModel0);
			out.writeByte(item.maleOffset);
		}
		if (item.maleModel1 != -1)
		{
			out.writeByte(24);
			out.writeShort(item.maleModel1);
		}
		if (item.femaleModel0 != -1 || item.femaleOffset != 0)
		{
			out.writeByte(25);
			out.writeShort(item.femaleModel0);
			out.writeByte(item.femaleOffset);
		}
		if (item.femaleModel1 != -1)
		{
			out.writeByte(26);
			out.writeShort(item.femaleModel1);
		}
		for (int i = 0; i < 5; ++i)
		{
			if (item.options[i] != null)
			{
				out.writeByte(30 + i);
				out.writeString(item.options[i]);
			}
		}
		for (int i = 0; i < 5; ++i)
		{
			if (item.interfaceOptions[i] != null)
			{
				out.writeByte(35 + i);
				out.writeString(item.interfaceOptions[i]);
			}
		}
		if (item.colorFind != null && item.colorReplace != null)
		{
			out.writeByte(40);
			out.writeByte(item.colorFind.length);
			for (int i = 0; i < item.colorFind.length; ++i)
			{
				out.writeShort(item.colorFind[i]);
				out.writeShort(item.colorReplace[i]);
			}
		}
		if (item.textureFind != null && item.textureReplace != null)
		{
			out.writeByte(41);
			out.writeByte(item.textureFind.length);
			for (int i = 0; i < item.textureFind.length; ++i)
			{
				out.writeShort(item.textureFind[i]);
				out.writeShort(item.textureReplace[i]);
			}
		}
		out.writeByte(42);
		out.writeByte(item.shiftClickDropIndex);
		if (item.isTradeable)
		{
			out.writeByte(65);
		}
		if (item.maleModel2 != -1)
		{
			out.writeByte(78);
			out.writeShort(item.maleModel2);
		}
		if (item.femaleModel2 != -1)
		{
			out.writeByte(79);
			out.writeShort(item.femaleModel2);
		}
		if (item.maleHeadModel != -1)
		{
			out.writeByte(90);
			out.writeShort(item.maleHeadModel);
		}
		if (item.femaleHeadModel != -1)
		{
			out.writeByte(91);
			out.writeShort(item.femaleHeadModel);
		}
		if (item.maleHeadModel2 != -1)
		{
			out.writeByte(92);
			out.writeShort(item.maleHeadModel2);
		}
		if (item.femaleHeadModel2 != -1)
		{
			out.writeByte(93);
			out.writeShort(item.femaleHeadModel2);
		}
		out.writeByte(95);
		out.writeShort(item.zan2d);
		if (item.notedID != -1)
		{
			out.writeByte(97);
			out.writeShort(item.notedID);
		}
		if (item.notedTemplate != -1)
		{
			out.writeByte(98);
			out.writeShort(item.notedTemplate);
		}
		if (item.countObj != null)
		{
			for (int i = 0; i < 10; ++i)
			{
				out.writeByte(100 + i);
				out.writeShort(item.countObj[i]);
				out.writeShort(item.countCo[i]);
			}
		}
		out.writeByte(110);
		out.writeShort(item.resizeX);
		out.writeByte(111);
		out.writeShort(item.resizeY);
		out.writeByte(112);
		out.writeShort(item.resizeZ);
		out.writeByte(113);
		out.writeByte(item.ambient);
		out.writeByte(114);
		out.writeByte(item.contrast);
		out.writeByte(115);
		out.writeByte(item.team);
		if (item.boughtId != -1)
		{
			out.writeByte(139);
			out.writeShort(item.boughtId);
		}
		if (item.boughtTemplateId != -1)
		{
			out.writeByte(140);
			out.writeShort(item.boughtTemplateId);
		}
		if (item.placeholderId != -1)
		{
			out.writeByte(148);
			out.writeShort(item.placeholderId);
		}
		if (item.placeholderTemplateId != -1)
		{
			out.writeByte(149);
			out.writeShort(item.placeholderTemplateId);
		}
		if (item.params != null)
		{
			out.writeByte(249);
			out.writeByte(item.params.size());
			for (Entry<Integer, Object> entry : item.params.entrySet())
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
