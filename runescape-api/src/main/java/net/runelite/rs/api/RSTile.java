package net.runelite.rs.api;

import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.ItemLayer;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.mapping.Import;

public interface RSTile extends Tile
{
	@Import("gameObjects")
	@Override
	GameObject[] getGameObjects();

	@Import("groundItemPile")
	@Override
	ItemLayer getItemLayer();

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
	SceneTilePaint getSceneTilePaint();

	@Import("model")
	@Override
	SceneTileModel getSceneTileModel();

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
