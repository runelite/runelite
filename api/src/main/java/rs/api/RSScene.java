package rs.api;

import api.Scene;
import api.Tile;
import net.runelite.mapping.Import;

public interface RSScene extends Scene
{
	//@Import("Scene_gameObjects") --- unused and causing trouble
	//RSGameObject[] getObjects();

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

	@Import("Scene_minPlane")
	int getMinLevel();
}
