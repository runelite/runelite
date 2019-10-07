package net.runelite.rs.api;

import net.runelite.api.Sprite;
import net.runelite.mapping.Import;

public interface RSSprite extends Sprite
{
	@Import("drawTransBgAt")
	@Override
	void drawAt(int x, int y);

	@Import("subHeight")
	@Override
	int getHeight();

	@Import("subWidth")
	@Override
	int getWidth();

	@Import("pixels")
	@Override
	int[] getPixels();

	@Import("setRaster")
	void setRaster();

	@Import("width")
	@Override
	int getMaxWidth();

	@Import("width")
	@Override
	void setMaxWidth(int maxWidth);

	@Import("height")
	@Override
	int getMaxHeight();

	@Import("height")
	@Override
	void setMaxHeight(int maxHeight);

	@Import("xOffset")
	@Override
	int getOffsetX(); ;

	@Import("xOffset")
	@Override
	void setOffsetX(int offsetX);

	@Import("yOffset")
	@Override
	int getOffsetY(); ;

	@Import("yOffset")
	@Override
	void setOffsetY(int offsetY);
}
