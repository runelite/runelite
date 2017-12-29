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

public class ObjectDefinition
{
	private int id;
	private short[] retextureToFind;
	private int anInt2069 = 16;
	private boolean isSolid = false;
	private String name = "null";
	private int[] objectModels;
	private int[] objectTypes;
	private short[] recolorToFind;
	private int mapAreaId = -1;
	private short[] textureToReplace;
	private int sizeX = 1;
	private int sizeY = 1;
	private int anInt2083 = 0;
	private int[] anIntArray2084;
	private int offsetX = 0;
	private boolean nonFlatShading = false;
	private int anInt2088 = -1;
	private int animationID = -1;
	private int varpID = -1;
	private int ambient = 0;
	private int contrast = 0;
	private String[] actions = new String[5];
	private int interactType = 2;
	private int mapSceneID = -1;
	private short[] recolorToReplace;
	private boolean aBool2097 = true;
	private int modelSizeX = 128;
	private int modelSizeHeight = 128;
	private int modelSizeY = 128;
	private int objectID;
	private int offsetHeight = 0;
	private int offsetY = 0;
	private boolean aBool2104 = false;
	private int anInt2105 = -1;
	private int anInt2106 = -1;
	private int[] configChangeDest;
	private boolean isRotated = false;
	private int configId = -1;
	private int anInt2110 = -1;
	private boolean aBool2111 = false;
	private int anInt2112 = 0;
	private int anInt2113 = 0;
	private boolean blocksProjectile = true;
	private Map<Integer, Object> params = null;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public short[] getRetextureToFind()
	{
		return retextureToFind;
	}

	public void setRetextureToFind(short[] retextureToFind)
	{
		this.retextureToFind = retextureToFind;
	}

	public int getAnInt2069()
	{
		return anInt2069;
	}

	public void setAnInt2069(int anInt2069)
	{
		this.anInt2069 = anInt2069;
	}

	public boolean isIsSolid()
	{
		return isSolid;
	}

	public void setIsSolid(boolean isSolid)
	{
		this.isSolid = isSolid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int[] getObjectModels()
	{
		return objectModels;
	}

	public void setObjectModels(int[] objectModels)
	{
		this.objectModels = objectModels;
	}

	public int[] getObjectTypes()
	{
		return objectTypes;
	}

	public void setObjectTypes(int[] objectTypes)
	{
		this.objectTypes = objectTypes;
	}

	public short[] getRecolorToFind()
	{
		return recolorToFind;
	}

	public void setRecolorToFind(short[] recolorToFind)
	{
		this.recolorToFind = recolorToFind;
	}

	public int getMapAreaId()
	{
		return mapAreaId;
	}

	public void setMapAreaId(int mapAreaId)
	{
		this.mapAreaId = mapAreaId;
	}

	public short[] getTextureToReplace()
	{
		return textureToReplace;
	}

	public void setTextureToReplace(short[] textureToReplace)
	{
		this.textureToReplace = textureToReplace;
	}

	public int getSizeX()
	{
		return sizeX;
	}

	public void setSizeX(int sizeX)
	{
		this.sizeX = sizeX;
	}

	public int getSizeY()
	{
		return sizeY;
	}

	public void setSizeY(int sizeY)
	{
		this.sizeY = sizeY;
	}

	public int getAnInt2083()
	{
		return anInt2083;
	}

	public void setAnInt2083(int anInt2083)
	{
		this.anInt2083 = anInt2083;
	}

	public int[] getAnIntArray2084()
	{
		return anIntArray2084;
	}

	public void setAnIntArray2084(int[] anIntArray2084)
	{
		this.anIntArray2084 = anIntArray2084;
	}

	public int getOffsetX()
	{
		return offsetX;
	}

	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public boolean isNonFlatShading()
	{
		return nonFlatShading;
	}

	public void setNonFlatShading(boolean nonFlatShading)
	{
		this.nonFlatShading = nonFlatShading;
	}

	public int getAnInt2088()
	{
		return anInt2088;
	}

	public void setAnInt2088(int anInt2088)
	{
		this.anInt2088 = anInt2088;
	}

	public int getAnimationID()
	{
		return animationID;
	}

	public void setAnimationID(int animationID)
	{
		this.animationID = animationID;
	}

	public int getVarpID()
	{
		return varpID;
	}

	public void setVarpID(int varpID)
	{
		this.varpID = varpID;
	}

	public int getAmbient()
	{
		return ambient;
	}

	public void setAmbient(int ambient)
	{
		this.ambient = ambient;
	}

	public int getContrast()
	{
		return contrast;
	}

	public void setContrast(int contrast)
	{
		this.contrast = contrast;
	}

	public String[] getActions()
	{
		return actions;
	}

	public void setActions(String[] actions)
	{
		this.actions = actions;
	}

	public int getAnInt2094()
	{
		return anInt2094;
	}

	public void setAnInt2094(int anInt2094)
	{
		this.anInt2094 = anInt2094;
	}

	public int getMapSceneID()
	{
		return mapSceneID;
	}

	public void setMapSceneID(int mapSceneID)
	{
		this.mapSceneID = mapSceneID;
	}

	public short[] getRecolorToReplace()
	{
		return recolorToReplace;
	}

	public void setRecolorToReplace(short[] recolorToReplace)
	{
		this.recolorToReplace = recolorToReplace;
	}

	public boolean isaBool2097()
	{
		return aBool2097;
	}

	public void setaBool2097(boolean aBool2097)
	{
		this.aBool2097 = aBool2097;
	}

	public int getModelSizeX()
	{
		return modelSizeX;
	}

	public void setModelSizeX(int modelSizeX)
	{
		this.modelSizeX = modelSizeX;
	}

	public int getModelSizeHeight()
	{
		return modelSizeHeight;
	}

	public void setModelSizeHeight(int modelSizeHeight)
	{
		this.modelSizeHeight = modelSizeHeight;
	}

	public int getModelSizeY()
	{
		return modelSizeY;
	}

	public void setModelSizeY(int modelSizeY)
	{
		this.modelSizeY = modelSizeY;
	}

	public int getObjectID()
	{
		return objectID;
	}

	public void setObjectID(int objectID)
	{
		this.objectID = objectID;
	}

	public int getOffsetHeight()
	{
		return offsetHeight;
	}

	public void setOffsetHeight(int offsetHeight)
	{
		this.offsetHeight = offsetHeight;
	}

	public int getOffsetY()
	{
		return offsetY;
	}

	public void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}

	public boolean isaBool2104()
	{
		return aBool2104;
	}

	public void setaBool2104(boolean aBool2104)
	{
		this.aBool2104 = aBool2104;
	}

	public int getAnInt2105()
	{
		return anInt2105;
	}

	public void setAnInt2105(int anInt2105)
	{
		this.anInt2105 = anInt2105;
	}

	public int getAnInt2106()
	{
		return anInt2106;
	}

	public void setAnInt2106(int anInt2106)
	{
		this.anInt2106 = anInt2106;
	}

	public int[] getConfigChangeDest()
	{
		return configChangeDest;
	}

	public void setConfigChangeDest(int[] configChangeDest)
	{
		this.configChangeDest = configChangeDest;
	}

	public boolean isRotated()
	{
		return isRotated;
	}

	public void setIsRotated(boolean isRotated)
	{
		this.isRotated = isRotated;
	}

	public int getConfigId()
	{
		return configId;
	}

	public void setConfigId(int configId)
	{
		this.configId = configId;
	}

	public int getAnInt2110()
	{
		return anInt2110;
	}

	public void setAnInt2110(int anInt2110)
	{
		this.anInt2110 = anInt2110;
	}

	public boolean isaBool2111()
	{
		return aBool2111;
	}

	public void setaBool2111(boolean aBool2111)
	{
		this.aBool2111 = aBool2111;
	}

	public int getAnInt2112()
	{
		return anInt2112;
	}

	public void setAnInt2112(int anInt2112)
	{
		this.anInt2112 = anInt2112;
	}

	public int getAnInt2113()
	{
		return anInt2113;
	}

	public void setAnInt2113(int anInt2113)
	{
		this.anInt2113 = anInt2113;
	}

	public boolean isaBool2114()
	{
		return aBool2114;
	}

	public void setaBool2114(boolean aBool2114)
	{
		this.aBool2114 = aBool2114;
	}

	public Map<Integer, Object> getParams()
	{
		return params;
	}

	public void setParams(final Map<Integer, Object> params)
	{
		this.params = params;
	}
}
