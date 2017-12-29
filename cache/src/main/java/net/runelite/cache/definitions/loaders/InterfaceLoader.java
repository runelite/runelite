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
package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.InterfaceDefinition;
import net.runelite.cache.io.InputStream;

public class InterfaceLoader
{
	public InterfaceDefinition load(int id, byte[] b)
	{
		InterfaceDefinition iface = new InterfaceDefinition();
		iface.id = id;
		if (b[0] == -1)
		{
			method3252(iface, new InputStream(b));
		}
		else
		{
			method3251(iface, new InputStream(b));
		}

		return iface;
	}

	private void method3251(InterfaceDefinition iface, InputStream var1)
	{
		iface.hasScript = false;
		iface.type = var1.readUnsignedByte();
		iface.field2222 = var1.readUnsignedByte();
		iface.contentType = var1.readUnsignedShort();
		iface.originalX = var1.readShort();
		iface.originalY = var1.readShort();
		iface.originalWidth = var1.readUnsignedShort();
		iface.field2231 = var1.readUnsignedShort();
		iface.opacity = var1.readUnsignedByte();
		iface.parentId = var1.readUnsignedShort();
		if (iface.parentId == '\uffff')
		{
			iface.parentId = -1;
		}
		else
		{
			iface.parentId += iface.id & -65536;
		}

		iface.field2334 = var1.readUnsignedShort();
		if (iface.field2334 == '\uffff')
		{
			iface.field2334 = -1;
		}

		int var2 = var1.readUnsignedByte();
		int var3;
		if (var2 > 0)
		{
			iface.tableActions = new int[var2];
			iface.field2333 = new int[var2];

			for (var3 = 0; var3 < var2; ++var3)
			{
				iface.tableActions[var3] = var1.readUnsignedByte();
				iface.field2333[var3] = var1.readUnsignedShort();
			}
		}

		var3 = var1.readUnsignedByte();
		int var4;
		int var5;
		int var6;
		if (var3 > 0)
		{
			iface.dynamicValues = new int[var3][];

			for (var4 = 0; var4 < var3; ++var4)
			{
				var5 = var1.readUnsignedShort();
				iface.dynamicValues[var4] = new int[var5];

				for (var6 = 0; var6 < var5; ++var6)
				{
					iface.dynamicValues[var4][var6] = var1.readUnsignedShort();
					if (iface.dynamicValues[var4][var6] == '\uffff')
					{
						iface.dynamicValues[var4][var6] = -1;
					}
				}
			}
		}

		if (iface.type == 0)
		{
			iface.scrollHeight = var1.readUnsignedShort();
			iface.isHidden = var1.readUnsignedByte() == 1;
		}

		if (iface.type == 1)
		{
			var1.readUnsignedShort();
			var1.readUnsignedByte();
		}

		if (iface.type == 2)
		{
			iface.itemIds = new int[iface.originalWidth * iface.field2231];
			iface.itemQuantities = new int[iface.field2231 * iface.originalWidth];
			var4 = var1.readUnsignedByte();
			if (var4 == 1)
			{
				iface.config |= 268435456;
			}

			var5 = var1.readUnsignedByte();
			if (var5 == 1)
			{
				iface.config |= 1073741824;
			}

			var6 = var1.readUnsignedByte();
			if (var6 == 1)
			{
				iface.config |= Integer.MIN_VALUE;
			}

			int var7 = var1.readUnsignedByte();
			if (var7 == 1)
			{
				iface.config |= 536870912;
			}

			iface.paddingX = var1.readUnsignedByte();
			iface.paddingY = var1.readUnsignedByte();
			iface.xSprites = new int[20];
			iface.field2288 = new int[20];
			iface.field2289 = new int[20];

			int var8;
			for (var8 = 0; var8 < 20; ++var8)
			{
				int var9 = var1.readUnsignedByte();
				if (var9 == 1)
				{
					iface.xSprites[var8] = var1.readShort();
					iface.field2288[var8] = var1.readShort();
					iface.field2289[var8] = var1.readInt();
				}
				else
				{
					iface.field2289[var8] = -1;
				}
			}

			iface.configActions = new String[5];

			for (var8 = 0; var8 < 5; ++var8)
			{
				String var11 = var1.readString();
				if (var11.length() > 0)
				{
					iface.configActions[var8] = var11;
					iface.config |= 1 << var8 + 23;
				}
			}
		}

		if (iface.type == 3)
		{
			iface.field2267 = var1.readUnsignedByte() == 1;
		}

		if (iface.type == 4 || iface.type == 1)
		{
			iface.field2219 = var1.readUnsignedByte();
			iface.field2283 = var1.readUnsignedByte();
			iface.field2212 = var1.readUnsignedByte();
			iface.fontId = var1.readUnsignedShort();
			if (iface.fontId == '\uffff')
			{
				iface.fontId = -1;
			}

			iface.textShadowed = var1.readUnsignedByte() == 1;
		}

		if (iface.type == 4)
		{
			iface.text = var1.readString();
			iface.field2241 = var1.readString();
		}

		if (iface.type == 1 || iface.type == 3 || iface.type == 4)
		{
			iface.textColor = var1.readInt();
		}

		if (iface.type == 3 || iface.type == 4)
		{
			iface.field2245 = var1.readInt();
			iface.field2280 = var1.readInt();
			iface.field2247 = var1.readInt();
		}

		if (iface.type == 5)
		{
			iface.spriteId = var1.readInt();
			iface.field2332 = var1.readInt();
		}

		if (iface.type == 6)
		{
			iface.modelType = 1;
			iface.modelId = var1.readUnsignedShort();
			if (iface.modelId == '\uffff')
			{
				iface.modelId = -1;
			}

			iface.field2264 = 1;
			iface.field2265 = var1.readUnsignedShort();
			if (iface.field2265 == '\uffff')
			{
				iface.field2265 = -1;
			}

			iface.field2266 = var1.readUnsignedShort();
			if (iface.field2266 == '\uffff')
			{
				iface.field2266 = -1;
			}

			iface.field2276 = var1.readUnsignedShort();
			if (iface.field2276 == '\uffff')
			{
				iface.field2276 = -1;
			}

			iface.modelZoom = var1.readUnsignedShort();
			iface.rotationX = var1.readUnsignedShort();
			iface.rotationZ = var1.readUnsignedShort();
		}

		if (iface.type == 7)
		{
			iface.itemIds = new int[iface.originalWidth * iface.field2231];
			iface.itemQuantities = new int[iface.originalWidth * iface.field2231];
			iface.field2219 = var1.readUnsignedByte();
			iface.fontId = var1.readUnsignedShort();
			if (iface.fontId == '\uffff')
			{
				iface.fontId = -1;
			}

			iface.textShadowed = var1.readUnsignedByte() == 1;
			iface.textColor = var1.readInt();
			iface.paddingX = var1.readShort();
			iface.paddingY = var1.readShort();
			var4 = var1.readUnsignedByte();
			if (var4 == 1)
			{
				iface.config |= 1073741824;
			}

			iface.configActions = new String[5];

			for (var5 = 0; var5 < 5; ++var5)
			{
				String var10 = var1.readString();
				if (var10.length() > 0)
				{
					iface.configActions[var5] = var10;
					iface.config |= 1 << var5 + 23;
				}
			}
		}

		if (iface.type == 8)
		{
			iface.text = var1.readString();
		}

		if (iface.field2222 == 2 || iface.type == 2)
		{
			iface.selectedAction = var1.readString();
			iface.field2335 = var1.readString();
			var4 = var1.readUnsignedShort() & 63;
			iface.config |= var4 << 11;
		}

		if (iface.field2222 == 1 || iface.field2222 == 4 || iface.field2222 == 5 || iface.field2222 == 6)
		{
			iface.tooltip = var1.readString();
			if (iface.tooltip.length() == 0)
			{
				if (iface.field2222 == 1)
				{
					iface.tooltip = "Ok";
				}

				if (iface.field2222 == 4)
				{
					iface.tooltip = "Select";
				}

				if (iface.field2222 == 5)
				{
					iface.tooltip = "Select";
				}

				if (iface.field2222 == 6)
				{
					iface.tooltip = "Continue";
				}
			}
		}

		if (iface.field2222 == 1 || iface.field2222 == 4 || iface.field2222 == 5)
		{
			iface.config |= 4194304;
		}

		if (iface.field2222 == 6)
		{
			iface.config |= 1;
		}

	}

	private void method3252(InterfaceDefinition iface, InputStream var1)
	{
		var1.readUnsignedByte();
		iface.hasScript = true;
		iface.type = var1.readUnsignedByte();
		iface.contentType = var1.readUnsignedShort();
		iface.originalX = var1.readShort();
		iface.originalY = var1.readShort();
		iface.originalWidth = var1.readUnsignedShort();
		if (iface.type == 9)
		{
			iface.field2231 = var1.readShort();
		}
		else
		{
			iface.field2231 = var1.readUnsignedShort();
		}

		iface.field2226 = var1.readByte();
		iface.field2227 = var1.readByte();
		iface.field2351 = var1.readByte();
		iface.field2217 = var1.readByte();
		iface.parentId = var1.readUnsignedShort();
		if (iface.parentId == '\uffff')
		{
			iface.parentId = -1;
		}
		else
		{
			iface.parentId += iface.id & -65536;
		}

		iface.isHidden = var1.readUnsignedByte() == 1;
		if (iface.type == 0)
		{
			iface.scrollWidth = var1.readUnsignedShort();
			iface.scrollHeight = var1.readUnsignedShort();
			iface.field2210 = var1.readUnsignedByte() == 1;
		}

		if (iface.type == 5)
		{
			iface.spriteId = var1.readInt();
			iface.field2294 = var1.readUnsignedShort();
			iface.field2257 = var1.readUnsignedByte() == 1;
			iface.opacity = var1.readUnsignedByte();
			iface.borderThickness = var1.readUnsignedByte();
			iface.sprite2 = var1.readInt();
			iface.flippedVertically = var1.readUnsignedByte() == 1;
			iface.flippedHorizontally = var1.readUnsignedByte() == 1;
		}

		if (iface.type == 6)
		{
			iface.modelType = 1;
			iface.modelId = var1.readUnsignedShort();
			if (iface.modelId == '\uffff')
			{
				iface.modelId = -1;
			}

			iface.field2268 = var1.readShort();
			iface.field2269 = var1.readShort();
			iface.rotationX = var1.readUnsignedShort();
			iface.rotationZ = var1.readUnsignedShort();
			iface.rotationY = var1.readUnsignedShort();
			iface.modelZoom = var1.readUnsignedShort();
			iface.field2266 = var1.readUnsignedShort();
			if (iface.field2266 == '\uffff')
			{
				iface.field2266 = -1;
			}

			iface.field2296 = var1.readUnsignedByte() == 1;
			var1.readUnsignedShort();
			if (iface.field2226 != 0)
			{
				iface.field2274 = var1.readUnsignedShort();
			}

			if (iface.field2227 != 0)
			{
				var1.readUnsignedShort();
			}
		}

		if (iface.type == 4)
		{
			iface.fontId = var1.readUnsignedShort();
			if (iface.fontId == '\uffff')
			{
				iface.fontId = -1;
			}

			iface.text = var1.readString();
			iface.field2212 = var1.readUnsignedByte();
			iface.field2219 = var1.readUnsignedByte();
			iface.field2283 = var1.readUnsignedByte();
			iface.textShadowed = var1.readUnsignedByte() == 1;
			iface.textColor = var1.readInt();
		}

		if (iface.type == 3)
		{
			iface.textColor = var1.readInt();
			iface.field2267 = var1.readUnsignedByte() == 1;
			iface.opacity = var1.readUnsignedByte();
		}

		if (iface.type == 9)
		{
			iface.field2218 = var1.readUnsignedByte();
			iface.textColor = var1.readInt();
			iface.field2253 = var1.readUnsignedByte() == 1;
		}

		iface.config = var1.read24BitInt();
		iface.name = var1.readString();
		int var2 = var1.readUnsignedByte();
		if (var2 > 0)
		{
			iface.actions = new String[var2];

			for (int var3 = 0; var3 < var2; ++var3)
			{
				iface.actions[var3] = var1.readString();
			}
		}

		iface.field2295 = var1.readUnsignedByte();
		iface.field2223 = var1.readUnsignedByte();
		iface.field2297 = var1.readUnsignedByte() == 1;
		iface.selectedAction = var1.readString();
		iface.field2225 = this.method3282(iface, var1);
		iface.field2300 = this.method3282(iface, var1);
		iface.field2248 = this.method3282(iface, var1);
		iface.field2311 = this.method3282(iface, var1);
		iface.field2350 = this.method3282(iface, var1);
		iface.field2312 = this.method3282(iface, var1);
		iface.field2314 = this.method3282(iface, var1);
		iface.field2316 = this.method3282(iface, var1);
		iface.field2318 = this.method3282(iface, var1);
		iface.field2319 = this.method3282(iface, var1);
		iface.field2306 = this.method3282(iface, var1);
		iface.field2337 = this.method3282(iface, var1);
		iface.field2287 = this.method3282(iface, var1);
		iface.field2303 = this.method3282(iface, var1);
		iface.field2304 = this.method3282(iface, var1);
		iface.field2308 = this.method3282(iface, var1);
		iface.field2310 = this.method3282(iface, var1);
		iface.field2262 = this.method3282(iface, var1);
		iface.field2313 = this.method3274(var1);
		iface.field2315 = this.method3274(var1);
		iface.field2282 = this.method3274(var1);
	}

	private Object[] method3282(InterfaceDefinition iface, InputStream var1)
	{
		int var2 = var1.readUnsignedByte();
		if (var2 == 0)
		{
			return null;
		}
		else
		{
			Object[] var3 = new Object[var2];

			for (int var4 = 0; var4 < var2; ++var4)
			{
				int var5 = var1.readUnsignedByte();
				if (var5 == 0)
				{
					var3[var4] = new Integer(var1.readInt());
				}
				else if (var5 == 1)
				{
					var3[var4] = var1.readString();
				}
			}

			iface.field2299 = true;
			return var3;
		}
	}

	private int[] method3274(InputStream var1)
	{
		int var2 = var1.readUnsignedByte();
		if (var2 == 0)
		{
			return null;
		}
		else
		{
			int[] var3 = new int[var2];

			for (int var4 = 0; var4 < var2; ++var4)
			{
				var3[var4] = var1.readInt();
			}

			return var3;
		}
	}
}
