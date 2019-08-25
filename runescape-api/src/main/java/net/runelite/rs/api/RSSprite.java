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
	void setMaxWidth(int maxWidth);

	@Import("height")
	void setMaxHeight(int maxHeight);

	@Import("xOffset")
	void setOffsetX(int offsetX);

	@Import("yOffset")
	void setOffsetY(int offsetY);
}
