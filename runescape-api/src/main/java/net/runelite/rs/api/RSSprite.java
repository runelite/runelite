package net.runelite.rs.api;

import net.runelite.api.Sprite;
import net.runelite.mapping.Import;

public interface RSSprite extends Sprite
{
	@Import("drawAt2")
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

	@Import("yOffset")
	void setOffsetX(int offsetX); // <-- I don't even know

	@Import("xOffset")
	void setOffsetY(int offsetY); // <-- I don't even know
}
