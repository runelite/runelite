package net.runelite.cache.definitions;

public class NpcDefinition
{

	public int id;
	public short[] recolorToFind;
	public int anInt2156 = 32;
	public String name = "null";
	public short[] recolorToReplace;
	public int[] models;
	public int[] models_2;
	public int stanceAnimation = -1;
	public int anInt2165 = -1;
	public int tileSpacesOccupied = 1;
	public int walkAnimation = -1;
	public short[] retextureToReplace;
	public int rotate90RightAnimation = -1;
	public boolean aBool2170 = true;
	public int resizeX = 128;
	public int contrast = 0;
	public int rotate180Animation = -1;
	public int anInt2174 = -1;
	public String[] options = new String[5];
	public boolean renderOnMinimap = true;
	public int combatLevel = -1;
	public int rotate90LeftAnimation = -1;
	public int resizeY = 128;
	public boolean hasRenderPriority = false;
	public int ambient = 0;
	public int headIcon = -1;
	public int anInt2184 = 30;
	public int[] anIntArray2185;
	public short[] retextureToFind;
	public int anInt2187 = -1;
	public boolean isClickable = true;
	public int anInt2189 = -1;
	public boolean aBool2190 = false;

	public NpcDefinition(int definitionID)
	{
		this.id = definitionID;
	}
}
