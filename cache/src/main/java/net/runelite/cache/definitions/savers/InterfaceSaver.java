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

import net.runelite.cache.definitions.ClientScript1Instruction;
import net.runelite.cache.definitions.InterfaceDefinition;
import net.runelite.cache.io.OutputStream;

public class InterfaceSaver
{
	public byte[] save(InterfaceDefinition def)
	{
		if (def.isIf3)
		{
			return saveIf3(def);
		}
		else
		{
			return saveIf1(def);
		}
	}

	private byte[] saveIf3(InterfaceDefinition def)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private byte[] saveIf1(InterfaceDefinition def)
	{
		OutputStream out = new OutputStream();
		out.writeByte(def.type);
		out.writeByte(def.menuType);
		out.writeShort(def.contentType);
		out.writeShort(def.originalX);
		out.writeShort(def.originalY);
		out.writeShort(def.originalWidth);
		out.writeShort(def.originalHeight);
		out.writeByte(def.opacity);
		out.writeShort(def.parentId);
		out.writeShort(def.hoveredSiblingId);
		if (def.alternateOperators != null)
		{
			out.writeByte(def.alternateOperators.length);
			for (int i = 0; i < def.alternateOperators.length; ++i)
			{
				out.writeByte(def.alternateOperators[i]);
				out.writeShort(def.alternateRhs[i]);
			}
		}
		else
		{
			out.writeByte(0);
		}
		if (def.clientScripts != null)
		{
			out.writeByte(def.clientScripts.length);
			for (int i = 0; i < def.clientScripts.length; ++i)
			{
				int len = 0;
				for (int j = 0; j < def.clientScripts[i].length; ++j)
				{
					ClientScript1Instruction ins = def.clientScripts[i][j];
					len++;
					if (ins.operands != null)
					{
						len += ins.operands.length;
					}
				}
				out.writeShort(len);
				for (int j = 0; j < def.clientScripts[i].length; ++j)
				{
					ClientScript1Instruction ins = def.clientScripts[i][j];
					out.writeShort(ins.opcode.ordinal());
					if (ins.operands != null)
					{
						for (int op : ins.operands)
						{
							out.writeShort(op);
						}
					}
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
			out.writeByte((def.clickMask & 268435456) != 0 ? 1 : 0);
			out.writeByte((def.clickMask & 1073741824) != 0 ? 1 : 0);
			out.writeByte((def.clickMask & Integer.MIN_VALUE) != 0 ? 1 : 0);
			out.writeByte((def.clickMask & 536870912) != 0 ? 1 : 0);
			out.writeByte(def.xPitch);
			out.writeByte(def.yPitch);
			for (int i = 0; i < 20; ++i)
			{
				if (def.sprites[i] != -1)
				{
					out.writeByte(1);
					out.writeShort(def.xOffsets[i]);
					out.writeShort(def.yOffsets[i]);
					out.writeShort(def.sprites[i]);
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
			out.writeByte(def.filled ? 1 : 0);
		}
		if (def.type == 4 || def.type == 1)
		{
			out.writeByte(def.xTextAlignment);
			out.writeByte(def.yTextAlignment);
			out.writeByte(def.lineHeight);
			out.writeShort(def.fontId);
			out.writeByte(def.textShadowed ? 1 : 0);
		}
		if (def.type == 4)
		{
			out.writeString(def.text);
			out.writeString(def.alternateText);
		}
		if (def.type == 1 || def.type == 3 || def.type == 4)
		{
			out.writeInt(def.textColor);
		}
		if (def.type == 3 || def.type == 4)
		{
			out.writeInt(def.alternateTextColor);
			out.writeInt(def.hoveredTextColor);
			out.writeInt(def.alternateHoveredTextColor);
		}
		if (def.type == 5)
		{
			out.writeInt(def.spriteId);
			out.writeInt(def.alternateSpriteId);
		}
		if (def.type == 6)
		{
			out.writeShort(def.modelId);
			out.writeShort(def.alternateModelId);
			out.writeShort(def.animation);
			out.writeShort(def.alternateAnimation);
			out.writeShort(def.modelZoom);
			out.writeShort(def.rotationX);
			out.writeShort(def.rotationZ);
		}
		if (def.type == 7)
		{
			out.writeByte(def.xTextAlignment);
			out.writeShort(def.fontId);
			out.writeByte(def.textShadowed ? 1 : 0);
			out.writeInt(def.textColor);
			out.writeShort(def.xPitch);
			out.writeShort(def.yPitch);
			out.writeByte((def.clickMask & 1073741824) != 0 ? 1 : 0);
			for (int i = 0; i < 5; ++i)
			{
				out.writeString(def.configActions[i]);
			}
		}
		if (def.type == 8)
		{
			out.writeString(def.text);
		}
		if (def.menuType == 2 || def.type == 2)
		{
			out.writeString(def.targetVerb);
			out.writeString(def.spellName);
			out.writeShort((def.clickMask >>> 11) & 63);
		}
		if (def.menuType == 1 || def.menuType == 4 || def.menuType == 5 || def.menuType == 6)
		{
			out.writeString(def.tooltip);
		}
		return out.flip();
	}
}
