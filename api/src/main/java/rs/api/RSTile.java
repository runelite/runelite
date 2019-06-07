package rs.api;

import api.DecorativeObject;
import api.GameObject;
import api.GroundObject;
import api.ItemLayer;
import api.SceneTileModel;
import api.SceneTilePaint;
import api.Tile;
import api.WallObject;
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

	//@Import("flags")
	//int getFlags(); ---- unused, think it's gameobjectedgemask

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
