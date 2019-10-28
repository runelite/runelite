package net.runelite.rs.api;

import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.mapping.Import;

public interface RSScene extends Scene
{
	@Import("tempGameObjects")
	RSGameObject[] getObjects();

	@Import("tiles")
	@Override
	RSTile[][][] getTiles();

	@Import("drawTile")
	void draw(Tile tile, boolean var2);

	@Import("tileHeights")
	int[][][] getTileHeights();

	@Import("drawTileMinimap")
	void drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y);

	@Import("occlude")
	void updateOccluders();

	@Import("xSize")
	int getMaxX();

	@Import("planes")
	int getMaxY();

	@Import("ySize")
	int getMaxZ();

	@Import("minPlane")
	int getMinLevel();

	@Import("newGroundItemPile")
	void newGroundItemPile(int plane, int x, int y, int hash, RSEntity var5, long var6, RSEntity var7, RSEntity var8);
}
