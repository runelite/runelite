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
package net.runelite.cache.definitions;

import java.util.Map;
import lombok.Data;

@Data
public class ItemDefinition
{
	public final int id;

	public String name = "null";
	public String unknown1;

	public int resizeX = 128;
	public int resizeY = 128;
	public int resizeZ = 128;

	public int xan2d = 0;
	public int yan2d = 0;
	public int zan2d = 0;

	public int cost = 1;
	public boolean isTradeable;
	public int stackable = 0;
	public int inventoryModel;

	public int wearPos1;
	public int wearPos2;
	public int wearPos3;

	public boolean members = false;

	public short[] colorFind;
	public short[] colorReplace;
	public short[] textureFind;
	public short[] textureReplace;

	public int zoom2d = 2000;
	public int xOffset2d = 0;
	public int yOffset2d = 0;

	public int ambient;
	public int contrast;

	public int[] countCo;
	public int[] countObj;

	public String[] options = new String[]{null, null, "Take", null, null};

	public String[] interfaceOptions = new String[]{null, null, null, null, "Drop"};

	public int maleModel0 = -1;
	public int maleModel1 = -1;
	public int maleModel2 = -1;
	public int maleOffset;
	public int maleHeadModel = -1;
	public int maleHeadModel2 = -1;

	public int femaleModel0 = -1;
	public int femaleModel1 = -1;
	public int femaleModel2 = -1;
	public int femaleOffset;
	public int femaleHeadModel = -1;
	public int femaleHeadModel2 = -1;

	public int category;

	public int notedID = -1;
	public int notedTemplate = -1;

	public int team;
	public int weight;

	public int shiftClickDropIndex = -2;

	public int boughtId = -1;
	public int boughtTemplateId = -1;

	public int placeholderId = -1;
	public int placeholderTemplateId = -1;

	public Map<Integer, Object> params = null;

	public void linkNote(ItemDefinition notedItem, ItemDefinition unnotedItem)
	{
		this.inventoryModel = notedItem.inventoryModel;
		this.zoom2d = notedItem.zoom2d;
		this.xan2d = notedItem.xan2d;
		this.yan2d = notedItem.yan2d;
		this.zan2d = notedItem.zan2d;
		this.xOffset2d = notedItem.xOffset2d;
		this.yOffset2d = notedItem.yOffset2d;
		this.colorFind = notedItem.colorFind;
		this.colorReplace = notedItem.colorReplace;
		this.textureFind = notedItem.textureFind;
		this.textureReplace = notedItem.textureReplace;
		this.name = unnotedItem.name;
		this.members = unnotedItem.members;
		this.cost = unnotedItem.cost;
		this.stackable = 1;
	}

	public void linkBought(ItemDefinition var1, ItemDefinition var2)
	{
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xOffset2d = var1.xOffset2d;
		this.yOffset2d = var1.yOffset2d;
		this.colorFind = var2.colorFind;
		this.colorReplace = var2.colorReplace;
		this.textureFind = var2.textureFind;
		this.textureReplace = var2.textureReplace;
		this.name = var2.name;
		this.members = var2.members;
		this.stackable = var2.stackable;
		this.maleModel0 = var2.maleModel0;
		this.maleModel1 = var2.maleModel1;
		this.maleModel2 = var2.maleModel2;
		this.femaleModel0 = var2.femaleModel0;
		this.femaleModel1 = var2.femaleModel1;
		this.femaleModel2 = var2.femaleModel2;
		this.maleHeadModel = var2.maleHeadModel;
		this.maleHeadModel2 = var2.maleHeadModel2;
		this.femaleHeadModel = var2.femaleHeadModel;
		this.femaleHeadModel2 = var2.femaleHeadModel2;
		this.team = var2.team;
		this.options = var2.options;
		this.interfaceOptions = new String[5];
		if (var2.interfaceOptions != null)
		{
			for (int var3 = 0; var3 < 4; ++var3)
			{
				this.interfaceOptions[var3] = var2.interfaceOptions[var3];
			}
		}

		this.interfaceOptions[4] = "Discard";
		this.cost = 0;
	}

	public void linkPlaceholder(ItemDefinition var1, ItemDefinition var2)
	{
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xOffset2d = var1.xOffset2d;
		this.yOffset2d = var1.yOffset2d;
		this.colorFind = var1.colorFind;
		this.colorReplace = var1.colorReplace;
		this.textureFind = var1.textureFind;
		this.textureReplace = var1.textureReplace;
		this.stackable = var1.stackable;
		this.name = var2.name;
		this.cost = 0;
		this.members = false;
		this.isTradeable = false;
	}
}
