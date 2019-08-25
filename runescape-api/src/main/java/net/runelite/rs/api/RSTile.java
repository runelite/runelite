package net.runelite.rs.api;

import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.TileItemPile;
import net.runelite.api.TileModel;
import net.runelite.api.TilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.mapping.Import;

public interface RSTile extends Tile
{
	@Import("gameObjects")
	@Override
	GameObject[] getGameObjects();

	@Import("tileItemPile")
	@Override
	TileItemPile getItemLayer();

	@Import("wallDecoration")
	@Override
	DecorativeObject getDecorativeObject();

	@Import("floorDecoration")
	@Override
	GroundObject getGroundObject();

	@Import("boundaryObject")
	@Override
	WallObject getWallObject();

	@Import("paint")
	@Override
	TilePaint getTilePaint();

	@Import("model")
	@Override
	TileModel getTileModel();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("plane")
	@Override
	int getPlane();

	@Import("originalPlane")
	@Override
	int getRenderLevel();

	@Import("minPlane")
	int getPhysicalLevel();

	@Import("gameObjectsEdgeMask")
	int getFlags();

	@Import("linkedBelowTile")
	@Override
	RSTile getBridge();

	@Import("drawPrimary")
	boolean isDraw();

	@Import("drawPrimary")
	void setDraw(boolean draw);

	@Import("drawSecondary")
	boolean isVisible();

	@Import("drawSecondary")
	void setVisible(boolean visible);

	@Import("drawGameObjects")
	void setDrawEntities(boolean drawEntities);

	@Import("drawGameObjectEdges")
	void setWallCullDirection(int wallCullDirection);
}
