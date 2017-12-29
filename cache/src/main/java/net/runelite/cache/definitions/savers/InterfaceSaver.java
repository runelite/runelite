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

import net.runelite.cache.definitions.InterfaceDefinition;
import net.runelite.cache.io.OutputStream;

public class InterfaceSaver
{
	public byte[] save(InterfaceDefinition def)
	{
		if (def.hasScript)
		{
			return saveScript(def);
		}
		else
		{
			return saveNoScript(def);
		}
	}

	private byte[] saveScript(InterfaceDefinition def)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private byte[] saveNoScript(InterfaceDefinition def)
	{
		OutputStream out = new OutputStream();
		out.writeByte(def.type);
		out.writeByte(def.field2222);
		out.writeShort(def.contentType);
		out.writeShort(def.originalX);
		out.writeShort(def.originalY);
		out.writeShort(def.originalWidth);
		out.writeShort(def.field2231);
		out.writeByte(def.opacity);
		out.writeShort(def.parentId);
		out.writeShort(def.field2334);
		if (def.tableActions != null)
		{
			out.writeByte(def.tableActions.length);
			for (int i = 0; i < def.tableActions.length; ++i)
			{
				out.writeByte(def.tableActions[i]);
				out.writeShort(def.field2333[i]);
			}
		}
		else
		{
			out.writeByte(0);
		}
		if (def.dynamicValues != null)
		{
			out.writeByte(def.dynamicValues.length);
			for (int i = 0; i < def.dynamicValues.length; ++i)
			{
				out.writeShort(def.dynamicValues[i].length);
				for (int j = 0; j < def.dynamicValues[i].length; ++j)
				{
					out.writeShort(def.dynamicValues[i][j]);
				}
			}
		}
		else
		{
			out.writeByte(0);
		}
		if (def.type == 0)
		{
			out.writeShort(def.scrollHeight);
			out.writeByte(def.isHidden ? 1 : 0);
		}
		if (def.type == 1)
		{
			out.writeShort(0);
			out.writeByte(0);
		}
		if (def.type == 2)
		{
			out.writeByte((def.config & 268435456) != 0 ? 1 : 0);
			out.writeByte((def.config & 1073741824) != 0 ? 1 : 0);
			out.writeByte((def.config & Integer.MIN_VALUE) != 0 ? 1 : 0);
			out.writeByte((def.config & 536870912) != 0 ? 1 : 0);
			out.writeByte(def.paddingX);
			out.writeByte(def.paddingY);
			for (int i = 0; i < 20; ++i)
			{
				if (def.field2289[i] != -1)
				{
					out.writeByte(1);
					out.writeShort(def.xSprites[i]);
					out.writeShort(def.field2288[i]);
					out.writeShort(def.field2289[i]);
				}
				else
				{
					out.writeByte(0);
				}
			}
			for (int i = 0; i < 5; ++i)
			{
				if (def.configActions[i] != null)
				{
					out.writeString(def.configActions[i]);
				}
				else
				{
					out.writeString("");
				}
			}
		}
		if (def.type == 3)
		{
			out.writeByte(def.field2267 ? 1 : 0);
		}
		if (def.type == 4 || def.type == 1)
		{
			out.writeByte(def.field2219);
			out.writeByte(def.field2283);
			out.writeByte(def.field2212);
			out.writeShort(def.fontId);
			out.writeByte(def.textShadowed ? 1 : 0);
		}
		if (def.type == 4)
		{
			out.writeString(def.text);
			out.writeString(def.field2241);
		}
		if (def.type == 1 || def.type == 3 || def.type == 4)
		{
			out.writeInt(def.textColor);
		}
		if (def.type == 3 || def.type == 4)
		{
			out.writeInt(def.field2245);
			out.writeInt(def.field2280);
			out.writeInt(def.field2247);
		}
		if (def.type == 5)
		{
			out.writeInt(def.spriteId);
			out.writeInt(def.field2332);
		}
		if (def.type == 6)
		{
			out.writeShort(def.modelId);
			out.writeShort(def.field2265);
			out.writeShort(def.field2266);
			out.writeShort(def.field2276);
			out.writeShort(def.modelZoom);
			out.writeShort(def.rotationX);
			out.writeShort(def.rotationZ);
		}
		if (def.type == 7)
		{
			out.writeByte(def.field2219);
			out.writeShort(def.fontId);
			out.writeByte(def.textShadowed ? 1 : 0);
			out.writeInt(def.textColor);
			out.writeShort(def.paddingX);
			out.writeShort(def.paddingY);
			out.writeByte((def.config & 1073741824) != 0 ? 1 : 0);
			for (int i = 0; i < 5; ++i)
			{
				out.writeString(def.configActions[i]);
			}
		}
		if (def.type == 8)
		{
			out.writeString(def.text);
		}
		if (def.field2222 == 2 || def.type == 2)
		{
			out.writeString(def.selectedAction);
			out.writeString(def.field2335);
			out.writeShort((def.config >>> 11) & 63);
		}
		if (def.field2222 == 1 || def.field2222 == 4 || def.field2222 == 5 || def.field2222 == 6)
		{
			out.writeString(def.tooltip);
		}
		return out.flip();
	}
}
