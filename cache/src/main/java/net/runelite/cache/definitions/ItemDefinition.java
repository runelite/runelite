/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.definitions;

public class ItemDefinition
{
	public int id;
	public int resizeY;
	public int xan2d = 0;
	public int cost = 1;
	public int inventoryModel;
	public int resizeZ;
	public short[] colorFind;
	public short[] colorReplace;
	public short[] textureFind;
	public String name = "null";
	public int zoom2d = 200000;
	public int yan2d = 0;
	public int zan2d = 0;
	public int maleOffset;
	public int yOffset2d = 0;
	public int stackable = 0;
	public int[] countCo;
	public boolean members = false;
	public String[] options;
	public String[] interfaceOptions;
	public int maleModel0;
	public int maleModel1;
	public short[] textureReplace;
	public int femaleModel1;
	public int femaleOffset;
	public int maleModel2;
	public int xOffset2d = 0;
	public int maleHeadModel;
	public int maleHeadModel2;
	public int femaleHeadModel;
	public int femaleHeadModel2;
	public int[] countObj;
	public int femaleModel2;
	public int notedID;
	public int femaleModel0;
	public int resizeX;
	public int notedTemplate;
	public int ambient;
	public int contrast;
	public int team;

	public ItemDefinition(int definitionID)
	{
		this.id = definitionID;
		this.options = new String[]
		{
			null, null, "Take", null, null
		};
		this.interfaceOptions = new String[]
		{
			null, null, null, null, "Drop"
		};
		this.maleModel0 = -1;
		this.maleModel1 = -1;
		this.maleOffset = 0;
		this.femaleModel0 = -1;
		this.femaleModel1 = -1;
		this.femaleOffset = 0;
		this.maleModel2 = -1;
		this.femaleModel2 = -1;
		this.maleHeadModel = -1;
		this.maleHeadModel2 = -1;
		this.femaleHeadModel = -1;
		this.femaleHeadModel2 = -1;
		this.notedID = -1;
		this.notedTemplate = -1;
		this.resizeX = 0;
		this.resizeY = 0;
		this.resizeZ = 0;
		this.ambient = 0;
		this.contrast = 0;
		this.team = 0;
	}
}
