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
public class ObjDefinition
{
	public final int id;

	public String name = "null";
	public String desc;
	public String unknown1;

	public int resizex = 128;
	public int resizey = 128;
	public int resizez = 128;

	public int xan2d = 0;
	public int yan2d = 0;
	public int zan2d = 0;

	public int cost = 1;
	public boolean stockmarket;
	public int stackable = 0;
	public int model;

	public int wearpos;
	public int wearpos2;
	public int wearpos3;

	public boolean members = false;

	public short[] recol_s;
	public short[] recol_d;
	public short[] retex_s;
	public short[] retex_d;

	public int zoom2d = 2000;
	public int xof2d = 0;
	public int yof2d = 0;

	public int ambient;
	public int contrast;

	public int[] countCo;
	public int[] countObj;

	public String[] op = new String[]{null, null, "Take", null, null};

	public String[] iop = new String[]{null, null, null, null, "Drop"};

	public int manwear = -1;
	public int manwear2 = -1;
	public int manwear3 = -1;
	public int manwearOffsetY;
	public int manhead = -1;
	public int manhead2 = -1;

	public int womanwear = -1;
	public int womanwear2 = -1;
	public int womanwear3 = -1;
	public int womanwearOffsetY;
	public int womanhead = -1;
	public int womanhead2 = -1;

	public int category;

	public int certlink = -1;
	public int certtemplate = -1;

	public int team;
	public int weight;

	public int shiftClickDropIndex = -2;

	public int boughtlink = -1;
	public int boughttemplate = -1;

	public int placeholderlink = -1;
	public int placeholdertemplate = -1;

	public Map<Integer, Object> params = null;

	public void linkNote(ObjDefinition notedItem, ObjDefinition unnotedItem)
	{
		this.model = notedItem.model;
		this.zoom2d = notedItem.zoom2d;
		this.xan2d = notedItem.xan2d;
		this.yan2d = notedItem.yan2d;
		this.zan2d = notedItem.zan2d;
		this.xof2d = notedItem.xof2d;
		this.yof2d = notedItem.yof2d;
		this.recol_s = notedItem.recol_s;
		this.recol_d = notedItem.recol_d;
		this.retex_s = notedItem.retex_s;
		this.retex_d = notedItem.retex_d;
		this.name = unnotedItem.name;
		this.members = unnotedItem.members;
		this.cost = unnotedItem.cost;
		this.stackable = 1;
	}

	public void linkBought(ObjDefinition var1, ObjDefinition var2)
	{
		this.model = var1.model;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xof2d = var1.xof2d;
		this.yof2d = var1.yof2d;
		this.recol_s = var2.recol_s;
		this.recol_d = var2.recol_d;
		this.retex_s = var2.retex_s;
		this.retex_d = var2.retex_d;
		this.name = var2.name;
		this.members = var2.members;
		this.stackable = var2.stackable;
		this.manwear = var2.manwear;
		this.manwear2 = var2.manwear2;
		this.manwear3 = var2.manwear3;
		this.womanwear = var2.womanwear;
		this.womanwear2 = var2.womanwear2;
		this.womanwear3 = var2.womanwear3;
		this.manhead = var2.manhead;
		this.manhead2 = var2.manhead2;
		this.womanhead = var2.womanhead;
		this.womanhead2 = var2.womanhead2;
		this.team = var2.team;
		this.op = var2.op;
		this.iop = new String[5];
		if (var2.iop != null)
		{
			for (int var3 = 0; var3 < 4; ++var3)
			{
				this.iop[var3] = var2.iop[var3];
			}
		}

		this.iop[4] = "Discard";
		this.cost = 0;
	}

	public void linkPlaceholder(ObjDefinition var1, ObjDefinition var2)
	{
		this.model = var1.model;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xof2d = var1.xof2d;
		this.yof2d = var1.yof2d;
		this.recol_s = var1.recol_s;
		this.recol_d = var1.recol_d;
		this.retex_s = var1.retex_s;
		this.retex_d = var1.retex_d;
		this.stackable = var1.stackable;
		this.name = var2.name;
		this.cost = 0;
		this.members = false;
		this.stockmarket = false;
	}
}
